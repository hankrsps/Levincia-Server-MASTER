$ErrorActionPreference = 'Stop'

$path = '.\Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\cache\definition\ItemDefinition.java'
$out = 'C:\Users\Becca\.Levincia\custom-weapon-models.txt'

if (!(Test-Path -LiteralPath $path)) {
    throw "Could not find ItemDefinition.java at: $path"
}

$lines = Get-Content -LiteralPath $path

$weaponPattern = '(?i)(sword|blade|scythe|bow|staff|spear|axe|whip|hammer|crossbow|mace|halberd|dagger|maul|cleaver|trident)'

function Get-CaseIdBeforeLine {
    param([int]$Index)
    for ($i = $Index; $i -ge [Math]::Max(0, $Index - 80); $i--) {
        if ($lines[$i] -match '^\s*case\s+(\d+)\s*:') {
            return [int]$Matches[1]
        }
        if ($lines[$i] -match '^\s*if\s*\(\s*customId\s*==\s*(\d+)\s*\)') {
            return [int]$Matches[1]
        }
    }
    return $null
}

function Get-Block {
    param([int]$Start)
    $end = [Math]::Min($lines.Length - 1, $Start + 45)
    for ($i = $Start + 1; $i -le $end; $i++) {
        if ($lines[$i] -match '^\s*case\s+\d+\s*:' -or $lines[$i] -match '^\s*if\s*\(\s*customId\s*==\s*\d+\s*\)') {
            $end = $i - 1
            break
        }
    }
    return ,$lines[$Start..$end]
}

function First-IntValue {
    param([string[]]$Block,[string]$Field)
    foreach ($line in $Block) {
        if ($line -match ("\b" + [regex]::Escape($Field) + '\s*=\s*(-?\d+)')) {
            return [int]$Matches[1]
        }
    }
    return $null
}

function First-StringValue {
    param([string[]]$Block,[string]$Field)
    foreach ($line in $Block) {
        if ($line -match ("\b" + [regex]::Escape($Field) + '\s*=\s*"([^"]+)"')) {
            return $Matches[1]
        }
    }
    return $null
}

$seen = @{}
$rows = New-Object System.Collections.Generic.List[object]
$blocks = New-Object System.Collections.Generic.List[string]

for ($i = 0; $i -lt $lines.Length; $i++) {
    if ($lines[$i] -notmatch 'itemDef\.name\s*=\s*"([^"]+)"') { continue }
    $name = $Matches[1]
    if ($name -notmatch $weaponPattern) { continue }

    $id = Get-CaseIdBeforeLine -Index $i
    if ($null -eq $id) { continue }
    if ($seen.ContainsKey($id)) { continue }

    $start = $i
    for ($j = $i; $j -ge [Math]::Max(0, $i - 40); $j--) {
        if ($lines[$j] -match '^\s*case\s+\d+\s*:' -or $lines[$j] -match '^\s*if\s*\(\s*customId\s*==\s*\d+\s*\)') {
            $start = $j
            break
        }
    }

    $block = Get-Block -Start $start
    $model = First-IntValue -Block $block -Field 'itemDef.modelID'
    $male = First-IntValue -Block $block -Field 'itemDef.maleEquip1'
    $female = First-IntValue -Block $block -Field 'itemDef.femaleEquip1'
    $zoom = First-IntValue -Block $block -Field 'itemDef.modelZoom'
    $rotX = First-IntValue -Block $block -Field 'itemDef.rotationX'
    $rotY = First-IntValue -Block $block -Field 'itemDef.rotationY'
    $rotZ = First-IntValue -Block $block -Field 'itemDef.rotationZ'
    $offX = First-IntValue -Block $block -Field 'itemDef.modelOffsetX'
    $offY = First-IntValue -Block $block -Field 'itemDef.modelOffsetY'

    $copy = $null
    foreach ($line in $block) {
        if ($line -match 'itemDef\.copyItem\((\d+)\)') { $copy = [int]$Matches[1]; break }
    }

    # Keep entries that have explicit weapon models, plus named progression placeholders for comparison.
    if ($null -eq $model -and $id -lt 22573) { continue }

    $rows.Add([PSCustomObject]@{
        ItemId = $id
        Name = $name
        CopyItem = $copy
        ModelID = $model
        MaleEquip = $male
        FemaleEquip = $female
        Zoom = $zoom
        RotX = $rotX
        RotY = $rotY
        RotZ = $rotZ
        OffX = $offX
        OffY = $offY
    })

    $blocks.Add(('=' * 100))
    $blocks.Add("ITEM $id - $name")
    foreach ($line in $block) { $blocks.Add($line) }
    $seen[$id] = $true
}

$rows = $rows | Sort-Object ItemId

$header = @(
    '=== Levincia Custom Weapon Model Extractor ===',
    '',
    'This report lists weapon-like item definitions that have explicit model IDs,',
    'plus the Levincia progression placeholders so they can be compared safely.',
    '',
    '================ MODEL TABLE ================',
    (($rows | Format-Table -AutoSize | Out-String -Width 300).TrimEnd()),
    '',
    '================ FULL BLOCKS ================',
    ''
)

[System.IO.File]::WriteAllLines($out, ($header + $blocks), [System.Text.UTF8Encoding]::new($false))

Write-Host ''
Write-Host '=== Levincia Custom Weapon Model Extractor ==='
Write-Host ''
$rows | Format-Table ItemId,Name,CopyItem,ModelID,MaleEquip,FemaleEquip,Zoom,RotX,RotY,RotZ,OffX,OffY -AutoSize
Write-Host ''
Write-Host "Full report saved to: $out"
Write-Host ''
Write-Host 'NEXT: paste the MODEL TABLE back to ChatGPT. Do not edit the progression item definitions yet.'
