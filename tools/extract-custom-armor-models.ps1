$ErrorActionPreference = 'Stop'

$path = '.\Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\cache\definition\ItemDefinition.java'
$out = 'C:\Users\Becca\.Levincia\custom-armor-models.txt'

if (!(Test-Path -LiteralPath $path)) { throw "ItemDefinition.java not found: $path" }

$lines = Get-Content -LiteralPath $path

$armorWords = 'helm|helmet|hood|mask|platebody|body|robe top|top|chest|platelegs|legs|robe bottom|bottom|boots|gloves|gauntlets|cape|shield|defender'
$rows = New-Object System.Collections.Generic.List[object]

for ($i=0; $i -lt $lines.Length; $i++) {
    if ($lines[$i] -notmatch '^\s*case\s+(\d+)\s*:') { continue }
    $itemId = [int]$Matches[1]
    $end = [Math]::Min($lines.Length - 1, $i + 80)
    for ($j=$i+1; $j -le $end; $j++) {
        if ($lines[$j] -match '^\s*case\s+\d+\s*:') { $end = $j - 1; break }
    }
    $block = $lines[$i..$end]
    $text = $block -join "`n"
    if ($text -notmatch 'itemDef\.name\s*=\s*"([^"]+)"') { continue }
    $name = $Matches[1]
    if ($name -notmatch $armorWords) { continue }

    function Match-Num([string]$pattern) {
        foreach ($ln in $block) {
            if ($ln -match $pattern) { return [int]$Matches[1] }
        }
        return $null
    }

    $copyItem = Match-Num 'copyItem\((\d+)\)'
    $modelID = Match-Num 'itemDef\.modelID\s*=\s*(\d+)'
    $male1 = Match-Num 'itemDef\.maleEquip1\s*=\s*(\d+)'
    $female1 = Match-Num 'itemDef\.femaleEquip1\s*=\s*(\d+)'
    $male2 = Match-Num 'itemDef\.anInt188\s*=\s*(\d+)'
    $female2 = Match-Num 'itemDef\.anInt164\s*=\s*(\d+)'
    $zoom = Match-Num 'itemDef\.modelZoom\s*=\s*(-?\d+)'
    $rotX = Match-Num 'itemDef\.rotationX\s*=\s*(-?\d+)'
    $rotY = Match-Num 'itemDef\.rotationY\s*=\s*(-?\d+)'
    $rotZ = Match-Num 'itemDef\.rotationZ\s*=\s*(-?\d+)'
    $offX = Match-Num 'itemDef\.modelOffsetX\s*=\s*(-?\d+)'
    $offY = Match-Num 'itemDef\.modelOffsetY\s*=\s*(-?\d+)'

    if ($null -eq $modelID -and $null -eq $male1 -and $null -eq $female1 -and $null -eq $copyItem) { continue }

    $rows.Add([PSCustomObject]@{
        ItemId=$itemId; Name=$name; CopyItem=$copyItem; ModelID=$modelID; MaleEquip1=$male1; FemaleEquip1=$female1; MaleEquip2=$male2; FemaleEquip2=$female2; Zoom=$zoom; RotX=$rotX; RotY=$rotY; RotZ=$rotZ; OffX=$offX; OffY=$offY
    })
}

$rows = $rows | Sort-Object ItemId

$progressionIds = 22573..22633
$interesting = $rows | Where-Object {
    $_.ItemId -in $progressionIds -or
    ($null -ne $_.ModelID -and $null -ne $_.MaleEquip1) -or
    $_.Name -match 'Diyos|Volcanic|Master void|Owl|Sagittarian|Torva|Virtus|Pernix|Primal|Celestial|Sirenic|Tectonic|Demon|Angel|Dragon|Shadow|Infernal|Blood|Frost|Toxic|Storm'
}

$header = @()
$header += '=== Levincia Custom Armor Model Extractor ==='
$header += ''
$header += 'This report lists armor-like ItemDefinition entries and their explicit inventory/equipment model IDs.'
$header += 'Progression items 22573-22633 are included even when they only copy vanilla templates.'
$header += ''

$table = $interesting | Format-Table ItemId,Name,CopyItem,ModelID,MaleEquip1,FemaleEquip1,MaleEquip2,FemaleEquip2,Zoom,RotX,RotY,RotZ,OffX,OffY -AutoSize | Out-String -Width 260
[System.IO.File]::WriteAllText($out, (($header -join "`r`n") + "`r`n" + $table), [System.Text.UTF8Encoding]::new($false))

Write-Host ''
Write-Host '=== Levincia Custom Armor Model Extractor ==='
Write-Host ''
$interesting | Format-Table ItemId,Name,CopyItem,ModelID,MaleEquip1,FemaleEquip1,MaleEquip2,FemaleEquip2,Zoom,RotX,RotY,RotZ,OffX,OffY -AutoSize
Write-Host ''
Write-Host "Full report saved to: $out"
Write-Host 'Paste the ARMOR MODEL TABLE back to ChatGPT.'
