$ErrorActionPreference = 'Stop'

$serverRoot = '.\Levincia-Server\src\main\java'
$clientRoot = '.\Levincia-Client-Master\Levincia-Client\src\main\java'
$out = 'C:\Users\Becca\.Levincia\progression-combat-hooks.txt'

$weaponIds = '22577|22578|22579|22585|22586|22587|22593|22594|22595|22601|22602|22603|22614|22615|22616|22622|22623|22624|22630|22631|22632'

$sections = New-Object System.Collections.Generic.List[string]
function Add([string]$s='') { $script:sections.Add($s) }

Add '=== LEVINCIA PROGRESSION COMBAT HOOK FINDER ==='
Add ''
Add '--- WEAPON ID REFERENCES ---'
Get-ChildItem $serverRoot -Recurse -Filter '*.java' -ErrorAction SilentlyContinue |
    Select-String -Pattern $weaponIds |
    ForEach-Object { Add ("{0}:{1}: {2}" -f $_.Path,$_.LineNumber,$_.Line.Trim()) }

Add ''
Add '--- MELEE / ATTACK ANIMATION CANDIDATES ---'
$animPatterns = @(
    'getAttackAnimation','attackAnimation','attackAnim','weaponAnimation','WeaponAnimation','kick','KICK','combatAnimation','getFightType','FightType','animationId','performAnimation'
)
Get-ChildItem $serverRoot -Recurse -Filter '*.java' -ErrorAction SilentlyContinue |
    Select-String -Pattern $animPatterns |
    Where-Object { $_.Path -match 'combat|weapon|player|equipment|animation' -or $_.Line -match 'kick|attackAnimation|weaponAnimation|getAttackAnimation' } |
    Select-Object -First 300 |
    ForEach-Object { Add ("{0}:{1}: {2}" -f $_.Path,$_.LineNumber,$_.Line.Trim()) }

Add ''
Add '--- MAGIC / RUNE CHECK CANDIDATES ---'
$magicPatterns = @(
    'rune','Runes','hasRunes','removeRunes','delete.*rune','MagicSpell','CombatSpell','spellbook','castSpell','magicSpell','Staff','staff','weapon.*staff','Equipment.*WEAPON'
)
Get-ChildItem $serverRoot -Recurse -Filter '*.java' -ErrorAction SilentlyContinue |
    Select-String -Pattern $magicPatterns |
    Where-Object { $_.Path -match 'magic|combat|spell|player|equipment' -or $_.Line -match 'rune|staff|spell' } |
    Select-Object -First 500 |
    ForEach-Object { Add ("{0}:{1}: {2}" -f $_.Path,$_.LineNumber,$_.Line.Trim()) }

Add ''
Add '--- CLIENT WEAPON/STAFF NAME REFERENCES ---'
Get-ChildItem $clientRoot -Recurse -Filter '*.java' -ErrorAction SilentlyContinue |
    Select-String -Pattern 'Frostborn Frostblade|Bloodforged Bloodblade|Toxic Spear|Stormblade|Infernal Greatsword|Shadow Scythe|Dragon Cleaver|Frostborn Frost Staff|Bloodforged Blood Staff|Toxic Staff|Storm Staff|Infernal Staff|Shadow Staff|Dragon Staff' |
    ForEach-Object { Add ("{0}:{1}: {2}" -f $_.Path,$_.LineNumber,$_.Line.Trim()) }

[System.IO.Directory]::CreateDirectory((Split-Path $out)) | Out-Null
[System.IO.File]::WriteAllLines($out,$sections,[System.Text.UTF8Encoding]::new($false))

Write-Host ''
Write-Host '=== Levincia Progression Combat Hook Finder ==='
Write-Host "Report: $out"
Write-Host ''
Write-Host 'Paste the sections titled:'
Write-Host '  --- WEAPON ID REFERENCES ---'
Write-Host '  --- MELEE / ATTACK ANIMATION CANDIDATES ---'
Write-Host '  --- MAGIC / RUNE CHECK CANDIDATES ---'
