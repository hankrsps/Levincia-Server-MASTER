$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$playerHandlerPath = Join-Path $repoRoot 'Levincia-Server\src\main\java\com\ruse\world\entity\impl\player\PlayerHandler.java'
$playerUpdatingPath = Join-Path $repoRoot 'Levincia-Server\src\main\java\com\ruse\world\entity\updating\PlayerUpdating.java'

foreach ($path in @($playerHandlerPath, $playerUpdatingPath)) {
    if (-not (Test-Path $path)) { throw "Required file not found: $path" }
    $backup = "$path.packet81-backup"
    if (-not (Test-Path $backup)) {
        Copy-Item $path $backup
        Write-Host "Backup created: $backup"
    }
}

# ---- Force Xslayer OWNER in the login handler that the live server log proves is executing. ----
$ph = [System.IO.File]::ReadAllText($playerHandlerPath)
if (-not $ph.Contains('[LEVINCIA OWNER]')) {
    $pattern = '(public\s+static\s+void\s+handleLogin\s*\(\s*Player\s+player\s*\)\s*\{)'
    $replacement = @'
$1
        // Levincia master account: apply after character loading and before login packets.
        if (player.getUsername() != null && player.getUsername().equalsIgnoreCase("Xslayer")) {
            player.setRights(PlayerRights.OWNER);
            System.out.println("[LEVINCIA OWNER] Xslayer rights=" + player.getRights() + " ordinal=" + player.getRights().ordinal());
        }
'@
    $newPh = [regex]::Replace($ph, $pattern, $replacement, 1)
    if ($newPh -eq $ph) { throw 'Could not locate PlayerHandler.handleLogin(). No PlayerHandler changes were written.' }
    $ph = $newPh
}

# ---- Add a one-time packet 81 send diagnostic for Xslayer. ----
$pu = [System.IO.File]::ReadAllText($playerUpdatingPath)
if (-not $pu.Contains('levinciaPacket81Logged')) {
    $classPattern = '(public\s+class\s+PlayerUpdating\s*\{)'
    $classReplacement = @'
$1

    private static final java.util.Set<String> levinciaPacket81Logged =
            java.util.Collections.newSetFromMap(new java.util.concurrent.ConcurrentHashMap<String, Boolean>());
'@
    $newPu = [regex]::Replace($pu, $classPattern, $classReplacement, 1)
    if ($newPu -eq $pu) { throw 'Could not locate PlayerUpdating class declaration. No PlayerUpdating changes were written.' }
    $pu = $newPu
}

if (-not $pu.Contains('[LEVINCIA PACKET81 SEND]')) {
    $sendPattern = 'player\.getSession\(\)\.queueMessage\(packet\);'
    $sendReplacement = @'
if (player.getUsername() != null
                && player.getUsername().equalsIgnoreCase("Xslayer")
                && levinciaPacket81Logged.add(player.getUsername().toLowerCase())) {
            System.out.println("[LEVINCIA PACKET81 SEND] user=" + player.getUsername()
                    + " index=" + player.getIndex()
                    + " state=" + player.getSession().getState()
                    + " channelOpen=" + player.getSession().getChannel().isOpen()
                    + " channelConnected=" + player.getSession().getChannel().isConnected()
                    + " packetBytes=" + packet.buffer().writerIndex()
                    + " position=" + player.getPosition());
        }
        player.getSession().queueMessage(packet);
'@
    $newPu = [regex]::Replace($pu, $sendPattern, $sendReplacement, 1)
    if ($newPu -eq $pu) { throw 'Could not locate packet 81 queueMessage call. No PlayerUpdating changes were written.' }
    $pu = $newPu
}

$utf8NoBom = New-Object System.Text.UTF8Encoding($false)
[System.IO.File]::WriteAllText($playerHandlerPath, $ph, $utf8NoBom)
[System.IO.File]::WriteAllText($playerUpdatingPath, $pu, $utf8NoBom)

Write-Host ''
Write-Host 'Levincia login/update repair applied successfully.'
Write-Host 'Xslayer will be forced to OWNER inside PlayerHandler.handleLogin().' 
Write-Host 'The first packet 81 send for Xslayer will print [LEVINCIA PACKET81 SEND].'
Write-Host 'Next: rebuild/restart the SERVER, then log in once and paste the server + client debug lines.'
