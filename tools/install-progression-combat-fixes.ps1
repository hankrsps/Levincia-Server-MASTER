$ErrorActionPreference = 'Stop'

$weaponInterfaces = '.\Levincia-Server\src\main\java\com\ruse\model\definitions\WeaponInterfaces.java'
$weaponAnimations = '.\Levincia-Server\src\main\java\com\ruse\model\definitions\WeaponAnimations.java'
$magicStaff = '.\Levincia-Server\src\main\java\com\ruse\world\content\combat\magic\PlayerMagicStaff.java'

foreach ($path in @($weaponInterfaces, $weaponAnimations, $magicStaff)) {
    if (!(Test-Path -LiteralPath $path)) {
        throw "Missing expected file: $path"
    }
}

$stamp = Get-Date -Format 'yyyyMMdd-HHmmss'
Copy-Item $weaponInterfaces "$weaponInterfaces.progression-combat-backup-$stamp" -Force
Copy-Item $weaponAnimations "$weaponAnimations.progression-combat-backup-$stamp" -Force
Copy-Item $magicStaff "$magicStaff.progression-combat-backup-$stamp" -Force

Write-Host ''
Write-Host '=== Levincia Progression Combat Fix ==='
Write-Host ''

# -----------------------------------------------------------------------------
# 1) Weapon interfaces: explicit progression mappings so custom names never
#    fall back to UNARMED/KICK.
# -----------------------------------------------------------------------------
$wi = Get-Content -LiteralPath $weaponInterfaces -Raw

if ($wi -notmatch 'LEVINCIA PROGRESSION WEAPON INTERFACES') {
    $needle = @'
			lowerName = lowerName.toLowerCase();
			WeaponInterface weaponInterface = null;
'@

    $replacement = @'
			lowerName = lowerName.toLowerCase();
			WeaponInterface weaponInterface = null;

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

    if (!$wi.Contains($needle)) {
        throw 'Could not find WeaponInterfaces init insertion point. Nothing changed.'
    }
    $wi = $wi.Replace($needle, $replacement)

    # Make the existing name-based classifier a fallback only.
    $firstIf = "`t`t`tif (lowerName.contains(\"staff\")  || lowerName.contains(\"sceptre\")) {"
    $fallbackIf = "`t`t`tif (weaponInterface == null) {`r`n`t`t`t`tif (lowerName.contains(\"staff\")  || lowerName.contains(\"sceptre\")) {"
    if ($wi.Contains($firstIf)) {
        $wi = $wi.Replace($firstIf, $fallbackIf)
        $marker = "`t`t`t} else if (lowerName.contains(\"scythe\")) {`r`n`t`t`t`tweaponInterface = WeaponInterface.SCYTHE;`r`n`t`t`t}"
        $markerReplacement = $marker + "`r`n`t`t`t}"
        if (!$wi.Contains($marker)) {
            throw 'Could not close WeaponInterfaces fallback classifier safely. Nothing changed.'
        }
        $wi = $wi.Replace($marker, $markerReplacement)
    } else {
        throw 'Could not find WeaponInterfaces name classifier. Nothing changed.'
    }

    Set-Content -LiteralPath $weaponInterfaces -Value $wi -Encoding UTF8
    Write-Host '[OK] Progression weapon interfaces mapped.'
} else {
    Write-Host '[SKIP] Progression weapon interface mappings already present.'
}

# -----------------------------------------------------------------------------
# 2) Rune-free progression staves through the server's existing OMNI staff
#    suppression system.
# -----------------------------------------------------------------------------
$ms = Get-Content -LiteralPath $magicStaff -Raw

if ($ms -notmatch '22579, 22587, 22595, 22603, 22616, 22624, 22632') {
    $oldOmni = 'OMNI(new int[] { 13642, 15835, 17293 },'
    $newOmni = 'OMNI(new int[] { 13642, 15835, 17293, 22579, 22587, 22595, 22603, 22616, 22624, 22632 },'
    if (!$ms.Contains($oldOmni)) {
        throw 'Could not find PlayerMagicStaff OMNI definition. Nothing changed.'
    }
    $ms = $ms.Replace($oldOmni, $newOmni)

    $oldAll = '13642, 15835, 17293, 13634, 13632, 13641 };'
    $newAll = '13642, 15835, 17293, 22579, 22587, 22595, 22603, 22616, 22624, 22632, 13634, 13632, 13641 };'
    if ($ms.Contains($oldAll)) {
        $ms = $ms.Replace($oldAll, $newAll)
    }

    Set-Content -LiteralPath $magicStaff -Value $ms -Encoding UTF8
    Write-Host '[OK] Progression staves added to OMNI rune suppression.'
} else {
    Write-Host '[SKIP] Progression staves already configured as rune-free.'
}

# -----------------------------------------------------------------------------
# 3) Attack animation correction for the one name that would otherwise be
#    caught by the generic "sword" rule despite using the 2H interface.
#    Other progression melee weapons can use their newly-correct FightType
#    animations naturally.
# -----------------------------------------------------------------------------
$wa = Get-Content -LiteralPath $weaponAnimations -Raw

if ($wa -notmatch 'LEVINCIA PROGRESSION ATTACK ANIMATIONS') {
    $needleAnim = @'
		String prop = c.getFightType().toString().toLowerCase();
'@
    $replacementAnim = @'
		String prop = c.getFightType().toString().toLowerCase();

		// LEVINCIA PROGRESSION ATTACK ANIMATIONS
		// Infernal Greatsword is a two-handed weapon; avoid the later generic sword rule.
		if (weaponId == 22614)
			return 11979;
'@
    if (!$wa.Contains($needleAnim)) {
        throw 'Could not find WeaponAnimations attack insertion point. Nothing changed.'
    }
    $wa = $wa.Replace($needleAnim, $replacementAnim)
    Set-Content -LiteralPath $weaponAnimations -Value $wa -Encoding UTF8
    Write-Host '[OK] Infernal Greatsword attack animation corrected.'
} else {
    Write-Host '[SKIP] Progression attack animation hook already present.'
}

Write-Host ''
Write-Host 'Progression melee mapping:'
Write-Host '  22577 Frostblade      -> SWORD'
Write-Host '  22585 Bloodblade      -> SWORD'
Write-Host '  22593 Toxic Spear     -> SPEAR'
Write-Host '  22601 Stormblade      -> SWORD'
Write-Host '  22614 Infernal GS     -> TWO_HANDED_SWORD'
Write-Host '  22622 Shadow Scythe   -> SCYTHE'
Write-Host '  22630 Dragon Cleaver  -> SWORD'
Write-Host ''
Write-Host 'Rune-free progression staves:'
Write-Host '  22579, 22587, 22595, 22603, 22616, 22624, 22632'
Write-Host ''
Write-Host 'Backups were created beside each changed Java file.'
Write-Host 'NEXT: rebuild/restart the server, equip 22577 and 22579, then test melee and magic combat.'
