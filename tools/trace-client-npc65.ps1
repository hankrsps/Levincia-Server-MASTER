$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$file = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\Client.java'
$backup = "$file.npc65-client-trace-backup"

if (-not (Test-Path $file)) { throw "Client.java not found: $file" }
$text = [IO.File]::ReadAllText($file)

if ($text.Contains('[LEVINCIA NPC65 RX]')) {
    Write-Host 'Client NPC65 diagnostics are already installed.'
    exit 0
}

if (-not (Test-Path $backup)) {
    Copy-Item $file $backup
    Write-Host "Backup created: $backup"
}

$newline = if ($text.Contains("`r`n")) { "`r`n" } else { "`n" }
$needle = 'case 65:'
$idx = $text.IndexOf($needle)
if ($idx -lt 0) { throw 'Could not find case 65: in Client.java. No file was written.' }

$insertAt = $idx + $needle.Length
$trace = $newline + '                    System.out.println("[LEVINCIA NPC65 RX] packetSize=" + pktSize + " npcCountBefore=" + npcCount);'
$text = $text.Substring(0, $insertAt) + $trace + $text.Substring($insertAt)

[IO.File]::WriteAllText($file, $text, [Text.UTF8Encoding]::new($false))
Write-Host 'Levincia client NPC packet 65 trace installed successfully.'
Write-Host 'Rebuild/restart the client, log in once, then copy any [LEVINCIA NPC65 RX] lines.'