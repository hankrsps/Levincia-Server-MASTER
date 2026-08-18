$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$playerHandler = Join-Path $repoRoot 'Levincia-Server\src\main\java\com\ruse\world\entity\impl\player\PlayerHandler.java'
$backup = "$playerHandler.first-update-order-backup"

if (-not (Test-Path $playerHandler)) {
    throw "PlayerHandler.java not found at: $playerHandler"
}

$text = [System.IO.File]::ReadAllText($playerHandler)
$newline = if ($text.Contains("`r`n")) { "`r`n" } else { "`n" }

if ($text.Contains('[LEVINCIA FIRST PLAYER UPDATE]')) {
    Write-Host 'Early player-update ordering fix is already installed.'
    exit 0
}

if (-not (Test-Path $backup)) {
    Copy-Item $playerHandler $backup
    Write-Host "Backup created: $backup"
}

# Add the import without disturbing existing local edits.
if (-not $text.Contains('import com.ruse.world.entity.updating.PlayerUpdating;')) {
    $importAnchor = 'import com.ruse.world.entity.impl.player.Player;'
    if ($text.Contains($importAnchor)) {
        $text = $text.Replace($importAnchor, $importAnchor + $newline + 'import com.ruse.world.entity.updating.PlayerUpdating;')
    } else {
        # PlayerHandler is itself in the player package, so use a nearby world import as fallback.
        $importAnchor = 'import com.ruse.world.World;'
        if (-not $text.Contains($importAnchor)) {
            throw 'Could not find a safe import anchor in PlayerHandler.java. No file was written.'
        }
        $text = $text.Replace($importAnchor, $importAnchor + $newline + 'import com.ruse.world.entity.updating.PlayerUpdating;')
    }
}

# Send the first player update immediately after the client receives its region/base packet,
# before the large interface/inventory/config initialization burst.
$anchor = '        player.loadMap (true);'
if (-not $text.Contains($anchor)) {
    $anchor = '        player.loadMap(true);'
}
if (-not $text.Contains($anchor)) {
    throw 'Could not find player.loadMap(true) in PlayerHandler.java. No file was written.'
}

$insert = $anchor + $newline + $newline +
    '        // Levincia: send the first player-update packet immediately after the map region packet.' + $newline +
    '        // This prevents packet 81 from sitting behind the large login UI/inventory initialization burst.' + $newline +
    '        System.out.println("[LEVINCIA FIRST PLAYER UPDATE] sending packet 81 immediately after loadMap for " + player.getUsername());' + $newline +
    '        PlayerUpdating.update(player);'

$text = $text.Replace($anchor, $insert)

[System.IO.File]::WriteAllText($playerHandler, $text, [System.Text.UTF8Encoding]::new($false))

Write-Host 'Levincia early player-update ordering fix installed successfully.'
Write-Host 'Rebuild/restart the SERVER, then log in once.'
Write-Host 'Look for: [LEVINCIA FIRST PLAYER UPDATE] and then packet 81 near the start of the TX sequence.'