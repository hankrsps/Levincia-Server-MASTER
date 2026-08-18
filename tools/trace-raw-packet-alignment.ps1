$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$clientFile = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\Client.java'
$serverFile = Join-Path $repoRoot 'Levincia-Server\src\main\java\com\ruse\net\packet\codec\PacketEncoder.java'
$clientBackup = "$clientFile.raw-packet-backup"
$serverBackup = "$serverFile.raw-packet-backup"

foreach ($file in @($clientFile, $serverFile)) {
    if (-not (Test-Path $file)) {
        throw "Required file not found: $file"
    }
}

function Get-Newline([string]$text) {
    if ($text.Contains("`r`n")) { return "`r`n" }
    return "`n"
}

# ---------------- CLIENT ----------------
$client = [System.IO.File]::ReadAllText($clientFile)
$cnl = Get-Newline $client

if (-not $client.Contains('[LEVINCIA RAW RX]')) {
    if (-not (Test-Path $clientBackup)) {
        Copy-Item $clientFile $clientBackup
        Write-Host "Client backup created: $clientBackup"
    }

    $clientPattern = '(?ms)(\s*getConnection\(\)\.flushInputStream\(getInputBuffer\(\)\.buffer, 1\);\s*)pktType\s*=\s*getInputBuffer\(\)\.buffer\[0\]\s*&\s*0xff;\s*if\s*\(getConnectionCipher\(\)\s*!=\s*null\)\s*\{\s*pktType\s*=\s*pktType\s*-\s*getConnectionCipher\(\)\.next\(\)\s*&\s*0xff;\s*\}'

    $clientInsert = @'
$1int levinciaRawOpcode = getInputBuffer().buffer[0] & 0xff;
                int levinciaIsaacValue = -1;
                pktType = levinciaRawOpcode;

                if (getConnectionCipher() != null) {
                    levinciaIsaacValue = getConnectionCipher().next();
                    pktType = pktType - levinciaIsaacValue & 0xff;
                }

                if (aBoolean1080) {
                    System.out.println("[LEVINCIA RAW RX] raw=" + levinciaRawOpcode
                            + " isaacLow=" + (levinciaIsaacValue & 0xff)
                            + " decoded=" + pktType
                            + " availableBeforeSize=" + available);
                }
'@
    $clientInsert = $clientInsert -replace "`r?`n", $cnl
    $newClient = [regex]::Replace($client, $clientPattern, $clientInsert, 1)

    if ($newClient -eq $client) {
        throw 'Could not find the client opcode/ISAAC decode block. No files were written.'
    }

    [System.IO.File]::WriteAllText($clientFile, $newClient, [System.Text.UTF8Encoding]::new($false))
    Write-Host 'Installed client raw opcode/ISAAC trace.'
} else {
    Write-Host 'Client raw packet trace already installed.'
}

# ---------------- SERVER ----------------
$server = [System.IO.File]::ReadAllText($serverFile)
$snl = Get-Newline $server

if (-not $server.Contains('[LEVINCIA RAW TX]')) {
    if (-not (Test-Path $serverBackup)) {
        Copy-Item $serverFile $serverBackup
        Write-Host "Server backup created: $serverBackup"
    }

    # Add a small trace counter field so normal gameplay cannot flood the console forever.
    $fieldPattern = '(?m)(private\s+final\s+IsaacRandom\s+encoder\s*;)'
    $fieldReplacement = '$1' + $snl + $snl + "\tprivate static int levinciaRawTraceCount = 0;"
    $newServer = [regex]::Replace($server, $fieldPattern, $fieldReplacement, 1)
    if ($newServer -eq $server) {
        throw 'Could not find PacketEncoder encoder field. Client trace may have been written; restore its backup if needed.'
    }
    $server = $newServer

    $writePattern = '(?m)(\s*)buffer\.writeByte\(\(packet\.getOpcode\(\)\s*\+\s*encoder\.nextInt\(\)\)\s*&\s*0xFF\);'
    $serverInsert = @'
$1int levinciaIsaacValue = encoder.nextInt();
$1int levinciaRawHeader = (packet.getOpcode() + levinciaIsaacValue) & 0xFF;
$1if (levinciaRawTraceCount < 350) {
$1    System.out.println("[LEVINCIA RAW TX] seq=" + levinciaRawTraceCount
$1            + " opcode=" + packet.getOpcode()
$1            + " type=" + packetType
$1            + " payload=" + packetLength
$1            + " isaacLow=" + (levinciaIsaacValue & 0xFF)
$1            + " raw=" + levinciaRawHeader);
$1    levinciaRawTraceCount++;
$1}
$1buffer.writeByte(levinciaRawHeader);
'@
    $serverInsert = $serverInsert -replace "`r?`n", $snl
    $newServer = [regex]::Replace($server, $writePattern, $serverInsert, 1)

    if ($newServer -eq $server) {
        throw 'Could not find PacketEncoder opcode write. Client trace may have been written; restore its backup if needed.'
    }

    [System.IO.File]::WriteAllText($serverFile, $newServer, [System.Text.UTF8Encoding]::new($false))
    Write-Host 'Installed server raw opcode/ISAAC trace.'
} else {
    Write-Host 'Server raw packet trace already installed.'
}

Write-Host ''
Write-Host 'Raw packet alignment tracing installed successfully.'
Write-Host 'Rebuild BOTH server and client, log in once, then copy:'
Write-Host '  [LEVINCIA RAW TX] from the server'
Write-Host '  [LEVINCIA RAW RX] from the client'
Write-Host 'especially the final TX lines immediately before opcode=81 and the matching RX lines.'