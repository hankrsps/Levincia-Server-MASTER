$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$clientFile = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\Client.java'
$backupFile = "$clientFile.packet-trace-backup"

if (-not (Test-Path $clientFile)) {
    throw "Client.java not found at: $clientFile"
}

$text = [System.IO.File]::ReadAllText($clientFile)

if ($text.Contains('[LEVINCIA PACKET RX]')) {
    Write-Host 'Client packet receive trace is already installed.'
    exit 0
}

if (-not (Test-Path $backupFile)) {
    Copy-Item $clientFile $backupFile
    Write-Host "Backup created: $backupFile"
}

# Trace the decoded opcode and packet-size mode while the region loader is waiting
# for the first player-update packet. Insert immediately after PACKET_SIZES lookup.
$pattern1 = '(?m)(\s*pktSize\s*=\s*SizeConstants\.PACKET_SIZES\[pktType\];\s*)'
$replacement1 = '$1' + "`r`n                if (aBoolean1080) {`r`n                    System.out.println(\"[LEVINCIA PACKET RX] decodedType=\" + pktType + \" sizeMode=\" + pktSize + \" availableAfterOpcode=\" + available);`r`n                }`r`n"
$newText = [regex]::Replace($text, $pattern1, $replacement1, 1)

if ($newText -eq $text) {
    throw 'Could not find the PACKET_SIZES assignment in Client.parsePacket(). No file was written.'
}

$text = $newText

# Add an unmistakable marker when opcode 81 actually reaches its switch case.
$pattern2 = '(?m)(\s*case\s+81\s*:\s*)'
$replacement2 = '$1' + "`r`n                    System.out.println(\"[LEVINCIA PACKET81 RX] size=\" + pktSize);`r`n"
$newText = [regex]::Replace($text, $pattern2, $replacement2, 1)

if ($newText -eq $text) {
    throw 'Could not find case 81 in Client.parsePacket(). No file was written.'
}

[System.IO.File]::WriteAllText($clientFile, $newText, [System.Text.UTF8Encoding]::new($false))

Write-Host 'Levincia client packet receive trace installed successfully.'
Write-Host 'Rebuild the client, log in once, and copy the [LEVINCIA PACKET RX] / [LEVINCIA PACKET81 RX] lines.'