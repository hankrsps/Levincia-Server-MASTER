$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$target = Join-Path $repoRoot 'Levincia-Server\src\main\java\com\ruse\world\entity\impl\player\PlayerHandler.java'
$backup = "$target.npc-sync-backup"

if (-not (Test-Path $target)) {
    throw "PlayerHandler.java not found at: $target"
}

$text = [System.IO.File]::ReadAllText($target)

if ($text.Contains('[LEVINCIA FIRST NPC UPDATE]')) {
    Write-Host 'Early NPC sync is already installed.'
    exit 0
}

if (-not (Test-Path $backup)) {
    Copy-Item $target $backup
    Write-Host "Backup created: $backup"
}

$newline = if ($text.Contains("`r`n")) { "`r`n" } else { "`n" }

# Ensure NPCUpdating import exists next to the PlayerUpdating import.
if (-not $text.Contains('import com.ruse.world.entity.updating.NPCUpdating;')) {
    if ($text.Contains('import com.ruse.world.entity.updating.PlayerUpdating;')) {
        $text = $text.Replace(
            'import com.ruse.world.entity.updating.PlayerUpdating;',
            'import com.ruse.world.entity.updating.PlayerUpdating;' + $newline + 'import com.ruse.world.entity.updating.NPCUpdating;'
        )
    } else {
        # Fall back to inserting after the GlobalItemSpawner import, which exists in this source.
        $anchorImport = 'import com.ruse.world.entity.impl.GlobalItemSpawner;'
        if (-not $text.Contains($anchorImport)) {
            throw 'Could not find a safe import anchor in PlayerHandler.java. No file was written.'
        }
        $text = $text.Replace(
            $anchorImport,
            $anchorImport + $newline + 'import com.ruse.world.entity.updating.NPCUpdating;'
        )
    }
}

# The previous packet-81 fix adds this marker immediately after loadMap(true).
$marker = 'System.out.println("[LEVINCIA FIRST PLAYER UPDATE] sending packet 81 immediately after loadMap for " + player.getUsername());'
if (-not $text.Contains($marker)) {
    throw 'Could not find the early player-update marker. Run fix-first-player-update-order.ps1 first. No file was written.'
}

$playerCall = 'PlayerUpdating.update(player);'
$markerIndex = $text.IndexOf($marker)
$callIndex = $text.IndexOf($playerCall, $markerIndex)
if ($callIndex -lt 0) {
    throw 'Could not find PlayerUpdating.update(player) after the early-update marker. No file was written.'
}

$lineEnd = $text.IndexOf($newline, $callIndex)
if ($lineEnd -lt 0) { $lineEnd = $text.Length }

$indentStart = $text.LastIndexOf($newline, $callIndex)
if ($indentStart -lt 0) { $indentStart = 0 } else { $indentStart += $newline.Length }
$indent = $text.Substring($indentStart, $callIndex - $indentStart)

$insert = $newline + $indent + 'System.out.println("[LEVINCIA FIRST NPC UPDATE] synchronizing NPCs immediately after first player update for " + player.getUsername());' +
          $newline + $indent + 'NPCUpdating.update(player);'

$text = $text.Insert($lineEnd, $insert)

[System.IO.File]::WriteAllText($target, $text, [System.Text.UTF8Encoding]::new($false))

Write-Host 'Levincia early NPC synchronization fix installed successfully.'
Write-Host 'Rebuild/restart the server, restart the client, and log in once.'
Write-Host 'Look for: [LEVINCIA FIRST NPC UPDATE] and check whether NPCs are visible.'