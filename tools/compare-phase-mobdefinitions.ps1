$ErrorActionPreference = 'Stop'

$paths = @(
    'C:\Users\Becca\Downloads\Levincia-Server-MASTER-COMPLETE-ENUM-FIX\Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\cache\definition\MobDefinition.java',
    'C:\Users\Becca\Downloads\Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\cache\definition\MobDefinition.java',
    'C:\Users\Becca\Downloads\levincia-client-main\levincia-client-main\Azura-Client\src\main\java\org\necrotic\client\cache\definition\MobDefinition.java',
    'C:\Users\Becca\IdeaProjects\Levincia.2\elvarg-rsps\ElvargClient\Levincia\levincia-client-main\levincia-client-main\Azura-Client\src\main\java\org\necrotic\client\cache\definition\MobDefinition.java',
    'C:\Users\Becca\IdeaProjects\Levincia.2\elvarg-rsps\ElvargClient\untitled\levincia-client-main(3)\levincia-client-main\Azura-Client\src\main\java\org\necrotic\client\cache\definition\MobDefinition.java'
)

$out = 'C:\Users\Becca\.Levincia\phase-mobdefinition-comparison.txt'
$report = New-Object System.Collections.Generic.List[string]

function Add-Line([string]$s='') {
    $script:report.Add($s)
}

function Get-CaseBlock {
    param([string[]]$Lines,[int]$NpcId)

    $start = -1
    for ($i=0; $i -lt $Lines.Length; $i++) {
        if ($Lines[$i] -match "^\s*case\s+$NpcId\s*:") {
            $start = $i
            break
        }
    }
    if ($start -lt 0) { return $null }

    $end = [Math]::Min($Lines.Length - 1, $start + 80)
    for ($i=$start+1; $i -le $end; $i++) {
        if ($Lines[$i] -match '^\s*case\s+\d+\s*:') {
            $end = $i - 1
            break
        }
    }

    return ,$Lines[$start..$end]
}

function Get-ModelIds {
    param([string[]]$Block)
    if ($null -eq $Block) { return @() }
    $ids = New-Object System.Collections.Generic.List[int]
    foreach ($line in $Block) {
        if ($line -match 'npcModels\s*=\s*new\s+int\s*\[\]\s*\{([^}]*)\}') {
            foreach ($m in [regex]::Matches($Matches[1], '\d+')) {
                $ids.Add([int]$m.Value)
            }
        }
    }
    return $ids.ToArray()
}

Add-Line '=== Phase MobDefinition Comparison ==='
Add-Line ''

$summary = @()

foreach ($path in $paths) {
    if (!(Test-Path $path)) { continue }

    $lines = Get-Content $path
    Add-Line ('=' * 100)
    Add-Line $path
    Add-Line ''

    $entry = [ordered]@{ File = $path }

    foreach ($npc in 9001..9006) {
        $phase = $npc - 9000
        $block = Get-CaseBlock -Lines $lines -NpcId $npc
        if ($null -eq $block) {
            Add-Line "Phase $phase / NPC ${npc}: NOT FOUND"
            $entry["P$phase"] = 'missing'
            continue
        }

        $modelIds = Get-ModelIds -Block $block
        $modelsText = if ($modelIds.Count -gt 0) { $modelIds -join ',' } else { 'NO npcModels assignment' }
        $entry["P$phase"] = $modelsText

        Add-Line "----- Phase $phase / NPC $npc / models: $modelsText -----"
        foreach ($line in $block) { Add-Line $line }
        Add-Line ''
    }

    $summary += [PSCustomObject]$entry
}

Add-Line ''
Add-Line '================ MODEL-ID SUMMARY ================'
Add-Line (($summary | Format-Table -AutoSize | Out-String -Width 300).TrimEnd())

[System.IO.File]::WriteAllLines($out, $report, [System.Text.UTF8Encoding]::new($false))

Write-Host ''
Write-Host '=== Phase model ID comparison ==='
$summary | Format-Table -AutoSize
Write-Host ''
Write-Host "Full case blocks saved to: $out"
Write-Host ''
Write-Host 'Paste the model-ID table back to ChatGPT. If any source differs, also paste that source''s Phase case block(s).'
