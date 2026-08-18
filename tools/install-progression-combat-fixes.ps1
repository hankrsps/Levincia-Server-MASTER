$ErrorActionPreference = 'Stop'

$weaponInterfaces = '.\Levincia-Server\src\main\java\com\ruse\model\definitions\WeaponInterfaces.java'
$weaponAnimations = '.\Levincia-Server\src\main\java\com\ruse\model\definitions\WeaponAnimations.java'
$magicStaff = '.\Levincia-Server\src\main\java\com\ruse\world\content\combat\magic\PlayerMagicStaff.java'

foreach ($path in @($weaponInterfaces, $weaponAnimations, $magicStaff)) {
    if (!(Test-Path -LiteralPath $path)) { throw "Missing expected file: $path" }
}

$stamp = Get-Date -Format 'yyyyMMdd-HHmmss'
Copy-Item $weaponInterfaces "$weaponInterfaces.progression-combat-backup-$stamp" -Force
Copy-Item $weaponAnimations "$weaponAnimations.progression-combat-backup-$stamp" -Force
Copy-Item $magicStaff "$magicStaff.progression-combat-backup-$stamp" -Force

Write-Host ''
Write-Host '=== Levincia Progression Combat Fix ==='
Write-Host ''

# 1) Explicit progression weapon-interface mappings.
$wi = Get-Content -LiteralPath $weaponInterfaces -Raw
if ($wi -notmatch 'LEVINCIA PROGRESSION WEAPON INTERFACES') {
    $insert = @'

            // LEVINCIA PROGRESSION WEAPON INTERFACES
            // Explicit IDs keep custom weapons from falling back to UNARMED/KICK.
            switch (id) {
            case 22577: // Frostborn Frostblade
            case 22585: // Bloodforged Bloodblade
            case 22601: // Stormblade
            case 22630: // Dragon Cleaver
                weaponInterface = WeaponInterface.SWORD;
                break;
            case 22593: // Toxic Spear
                weaponInterface = WeaponInterface.SPEAR;
                break;
            case 22614: // Infernal Greatsword
                weaponInterface = WeaponInterface.TWO_HANDED_SWORD;
                break;
            case 22622: // Shadow Scythe
                weaponInterface = WeaponInterface.SCYTHE;
                break;
            case 22579: // Frostborn Frost Staff
            case 22587: // Bloodforged Blood Staff
            case 22595: // Toxic Staff
            case 22603: // Storm Staff
            case 22616: // Infernal Staff
            case 22624: // Shadow Staff
            case 22632: // Dragon Staff
                weaponInterface = WeaponInterface.STAFF;
                break;
            default:
                break;
            }
'@

    $pattern = '(?s)(lowerName\s*=\s*lowerName\.toLowerCase\(\);\s*WeaponInterface\s+weaponInterface\s*=\s*null\s*;)'
    if ($wi -notmatch $pattern) { throw 'Could not find WeaponInterfaces init insertion point. Nothing changed.' }
    $wi = [regex]::Replace($wi, $pattern, '$1' + $insert, 1)

    # Turn the existing name classifier into a fallback only.
    $firstIfPattern = '(?m)^(\s*)if\s*\(lowerName\.contains\("staff"\)\s*\|\|\s*lowerName\.contains\("sceptre"\)\)\s*\{'
    $m = [regex]::Match($wi, $firstIfPattern)
    if (!$m.Success) { throw 'Could not find WeaponInterfaces name classifier. Nothing changed.' }
    $indent = $m.Groups[1].Value
    $replacement = $indent + 'if (weaponInterface == null) {' + "`r`n" + $indent + '    if (lowerName.contains("staff") || lowerName.contains("sceptre")) {'
    $wi = [regex]::Replace($wi, $firstIfPattern, [System.Text.RegularExpressions.MatchEvaluator]{ param($x) $replacement }, 1)

    $tailPattern = '(?s)(else\s+if\s*\(lowerName\.contains\("scythe"\)\)\s*\{\s*weaponInterface\s*=\s*WeaponInterface\.SCYTHE;\s*\})(\s*if\s*\(weaponInterface\s*==\s*null\)\s*\{\s*continue;\s*\})'
    if ($wi -notmatch $tailPattern) { throw 'Could not close WeaponInterfaces fallback classifier safely. Nothing changed.' }
    $wi = [regex]::Replace($wi, $tailPattern, '$1' + "`r`n" + $indent + '}' + '$2', 1)

    Set-Content -LiteralPath $weaponInterfaces -Value $wi -Encoding UTF8
    Write-Host '[OK] Progression weapon interfaces mapped.'
} else {
    Write-Host '[SKIP] Progression weapon interface mappings already present.'
}

# 2) Rune-free progression staves.
$ms = Get-Content -LiteralPath $magicStaff -Raw
if ($ms -notmatch '22579,\s*22587,\s*22595,\s*22603,\s*22616,\s*22624,\s*22632') {
    $omniPattern = 'OMNI\(new int\[\]\s*\{\s*13642\s*,\s*15835\s*,\s*17293\s*\},'
    if ($ms -notmatch $omniPattern) { throw 'Could not find PlayerMagicStaff OMNI definition. Nothing changed.' }
    $ms = [regex]::Replace($ms, $omniPattern, 'OMNI(new int[] { 13642, 15835, 17293, 22579, 22587, 22595, 22603, 22616, 22624, 22632 },', 1)
    Set-Content -LiteralPath $magicStaff -Value $ms -Encoding UTF8
    Write-Host '[OK] Progression staves added to OMNI rune suppression.'
} else {
    Write-Host '[SKIP] Progression staves already configured as rune-free.'
}

# 3) Infernal Greatsword attack animation override.
$wa = Get-Content -LiteralPath $weaponAnimations -Raw
if ($wa -notmatch 'LEVINCIA PROGRESSION ATTACK ANIMATIONS') {
    $animPattern = '(String\s+prop\s*=\s*c\.getFightType\(\)\.toString\(\)\.toLowerCase\(\);)'
    if ($wa -notmatch $animPattern) { throw 'Could not find WeaponAnimations attack insertion point. Nothing changed.' }
    $animInsert = @'
$1

        // LEVINCIA PROGRESSION ATTACK ANIMATIONS
        if (weaponId == 22614)
            return 11979;
'@
    $wa = [regex]::Replace($wa, $animPattern, $animInsert, 1)
    Set-Content -LiteralPath $weaponAnimations -Value $wa -Encoding UTF8
    Write-Host '[OK] Infernal Greatsword attack animation corrected.'
} else {
    Write-Host '[SKIP] Progression attack animation hook already present.'
}

Write-Host ''
Write-Host 'Done. Rebuild/restart the server and test 22577 melee + 22579 magic first.'
Write-Host 'Backups were created beside each changed Java file.'
