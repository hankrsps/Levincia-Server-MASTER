$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$file = Join-Path $repoRoot 'Levincia-Server\src\main\java\com\ruse\world\entity\updating\NPCUpdating.java'
$backup = "$file.npc65-trace-backup"

if (-not (Test-Path $file)) { throw "NPCUpdating.java not found: $file" }
$text = [IO.File]::ReadAllText($file)
if ($text.Contains('[LEVINCIA NPC65 BEGIN]')) {
    Write-Host 'NPC65 diagnostics are already installed.'
    exit 0
}
if (-not (Test-Path $backup)) {
    Copy-Item $file $backup
    Write-Host "Backup created: $backup"
}
$newline = if ($text.Contains("`r`n")) { "`r`n" } else { "`n" }

$methodPattern = 'public static void update\(Player player\) \{'
$methodReplacement = 'public static void update(Player player) {' + $newline +
    "`t`tSystem.out.println(\"[LEVINCIA NPC65 BEGIN] user=\" + player.getUsername()" + $newline +
    "`t`t`t`t+ \" localNpcs=\" + player.getLocalNpcs().size());"
$newText = [regex]::Replace($text, $methodPattern, $methodReplacement, 1)
if ($newText -eq $text) { throw 'Could not locate NPCUpdating.update(Player). No file was written.' }
$text = $newText

$queueLine = 'player.getSession().queueMessage(packet);'
$queueReplacement = "System.out.println(\"[LEVINCIA NPC65 QUEUE] user=\" + player.getUsername()" + $newline +
    "`t`t`t`t+ \" localNpcs=\" + player.getLocalNpcs().size()" + $newline +
    "`t`t`t`t+ \" addedThisUpdate=\" + number" + $newline +
    "`t`t`t`t+ \" packetBytes=\" + packet.buffer().writerIndex());" + $newline +
    "`t`t" + $queueLine
$idx = $text.IndexOf($queueLine)
if ($idx -lt 0) { throw 'Could not locate queueMessage(packet). No file was written.' }
$text = $text.Substring(0,$idx) + $queueReplacement + $text.Substring($idx + $queueLine.Length)

[IO.File]::WriteAllText($file, $text, [Text.UTF8Encoding]::new($false))
Write-Host 'Levincia NPC packet 65 diagnostics installed successfully.'
Write-Host 'Rebuild/restart the server, log in once, then copy the [LEVINCIA NPC65 BEGIN] and [LEVINCIA NPC65 QUEUE] lines.'