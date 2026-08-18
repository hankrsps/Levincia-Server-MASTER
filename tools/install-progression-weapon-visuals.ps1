$ErrorActionPreference = 'Stop'

$path = '.\Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\cache\definition\ItemDefinition.java'

if (!(Test-Path -LiteralPath $path)) {
    throw "Could not find ItemDefinition.java at: $path"
}

$backup = "$path.progression-weapon-backup-$(Get-Date -Format 'yyyyMMdd-HHmmss')"
Copy-Item -LiteralPath $path -Destination $backup -Force

$text = Get-Content -LiteralPath $path -Raw

# Progression item id -> existing custom source item id whose full visual setup
# (inventory model, equip models, zoom, rotations, offsets, etc.) will be copied.
# Names/descriptions/actions in the progression cases remain unchanged because they are
# assigned immediately after copyItem(...).
$map = [ordered]@{
    22577 = 22075   # Frostborn Frostblade <- Starlight sword
    22578 = 20173   # Frostborn Frost Bow <- Sorrow Bow
    22579 = 14004   # Frostborn Frost Staff <- Staff of light

    22585 = 22072   # Bloodforged Bloodblade <- Death's sword
    22586 = 12283   # Bloodforged Blood Bow <- Twisted Bow
    22587 = 22092   # Bloodforged Blood Staff <- Art's Staff

    22593 = 1249    # Toxic Spear remains a spear-shaped base
    22594 = 22083   # Toxic Venom Bow <- BlastBomb bow
    22595 = 12904   # Toxic Staff <- Toxic staff of the dead

    22601 = 22073   # Stormblade <- Forgiveness blade
    22602 = 12283   # Storm Bow <- Twisted Bow
    22603 = 22087   # Storm Staff <- Burning Staff

    22614 = 20542   # Infernal Greatsword <- Satanic hellblade
    22615 = 22083   # Infernal Bow <- BlastBomb bow
    22616 = 22087   # Infernal Staff <- Burning Staff

    22622 = 20549   # Shadow Scythe <- Demonic scythe
    22623 = 12283   # Shadow Bow <- Twisted Bow
    22624 = 22092   # Shadow Staff <- Art's Staff

    22630 = 14023   # Dragon Cleaver <- Drygore Long-sword
    22631 = 20173   # Dragon Bow <- Sorrow Bow
    22632 = 13641   # Dragon Staff <- Starter staff
}

$changes = @()

foreach ($entry in $map.GetEnumerator()) {
    $itemId = [int]$entry.Key
    $sourceId = [int]$entry.Value

    $casePattern = "(?ms)(case\s+$itemId\s*:\s*.*?itemDef\.copyItem\()\d+(\);.*?break;)"
    $match = [regex]::Match($text, $casePattern)

    if (!$match.Success) {
        throw "Could not locate progression item case $itemId with copyItem(...). No changes were written. Backup: $backup"
    }

    $oldBlock = $match.Value
    $oldSourceMatch = [regex]::Match($oldBlock, 'copyItem\((\d+)\)')
    $oldSource = if ($oldSourceMatch.Success) { [int]$oldSourceMatch.Groups[1].Value } else { -1 }

    $newBlock = [regex]::Replace($oldBlock, 'copyItem\(\d+\)', "copyItem($sourceId)", 1)
    $text = $text.Remove($match.Index, $match.Length).Insert($match.Index, $newBlock)

    $changes += [PSCustomObject]@{
        ItemId = $itemId
        OldSource = $oldSource
        NewSource = $sourceId
    }
}

[System.IO.File]::WriteAllText((Resolve-Path -LiteralPath $path), $text, [System.Text.UTF8Encoding]::new($false))

Write-Host ''
Write-Host '=== Levincia Progression Weapon Visual Patch ==='
Write-Host "Updated: $path"
Write-Host "Backup:  $backup"
Write-Host ''
$changes | Format-Table -AutoSize
Write-Host ''
Write-Host 'Done. Rebuild/run the client and inspect the progression melee, bow, and staff items.'
Write-Host 'This patch only changes the copyItem visual source for those weapons; their custom names/descriptions/actions remain intact.'
