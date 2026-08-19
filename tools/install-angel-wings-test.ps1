$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$itemDefPath = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\cache\definition\ItemDefinition.java'
$modelSource = Join-Path $repoRoot 'custom-assets\converted\wings\angel-wing-test\317\100500.gz'
$validator = Join-Path $PSScriptRoot 'validate-317-model.ps1'
$rawModel = Join-Path $repoRoot 'custom-assets\converted\wings\angel-wing-test\317\angel_wings_317.dat'
$looseIndex = Join-Path $env:USERPROFILE '.Levincia\index1'
$modelTarget = Join-Path $looseIndex '100500.gz'
$stamp = Get-Date -Format 'yyyyMMdd-HHmmss'

Write-Host ''
Write-Host '=== Levincia Angel Wings In-Game Test Installer ==='
Write-Host ''

foreach ($required in @($itemDefPath, $modelSource, $validator, $rawModel)) {
    if (!(Test-Path -LiteralPath $required)) {
        throw "Missing required file: $required"
    }
}

& powershell -ExecutionPolicy Bypass -File $validator -Path $rawModel
if ($LASTEXITCODE -ne 0) {
    throw 'Angel Wings model validation failed. Nothing was installed.'
}

New-Item -ItemType Directory -Force -Path $looseIndex | Out-Null
if (Test-Path -LiteralPath $modelTarget) {
    $backupModel = "$modelTarget.backup-$stamp"
    Copy-Item -LiteralPath $modelTarget -Destination $backupModel -Force
    Write-Host "[BACKUP] Existing model 100500 -> $backupModel"
}
Copy-Item -LiteralPath $modelSource -Destination $modelTarget -Force
Write-Host "[OK] Staged model 100500 -> $modelTarget"

$text = [System.IO.File]::ReadAllText($itemDefPath)
$hadBom = $text.Length -gt 0 -and [int][char]$text[0] -eq 0xFEFF
if ($hadBom) {
    $text = $text.TrimStart([char]0xFEFF)
    Write-Host '[FIX] Removed UTF-8 BOM from ItemDefinition.java.'
}

$changed = $false
if ($text -match 'customId\s*==\s*22640') {
    Write-Host '[OK] ItemDefinition 22640 already exists.'
} else {
    $needle = 'if (customId == 22070) { // sword'
    $idx = $text.IndexOf($needle, [System.StringComparison]::Ordinal)
    if ($idx -lt 0) {
        throw 'Could not locate the custom-item insertion point in ItemDefinition.java. Model 100500 was staged, but Java was not changed.'
    }

    $backupJava = "$itemDefPath.angel-wings-backup-$stamp"
    Copy-Item -LiteralPath $itemDefPath -Destination $backupJava -Force

    $block = @'
		if (customId == 22640) { // Levincia Angel Wings external-model test
			itemDef.name = "Angel Wings";
			itemDef.description = "A pair of celestial wings.".getBytes();
			ItemDefinition itemDef2 = ItemDefinition.get(20079); // existing wearable cape as inventory-view reference
			itemDef.modelID = 100500;
			itemDef.maleEquip1 = 100500;
			itemDef.femaleEquip1 = 100500;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.stackable = false;
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[4] = "Drop";
		}

'@

    $text = $text.Insert($idx, $block)
    $changed = $true
    Write-Host '[OK] Added ItemDefinition 22640 -> model 100500.'
    Write-Host "[BACKUP] $backupJava"
}

# Always rewrite without BOM if one was present, even when item 22640 already exists.
if ($changed -or $hadBom) {
    [System.IO.File]::WriteAllText($itemDefPath, $text, (New-Object System.Text.UTF8Encoding($false)))
    Write-Host '[OK] ItemDefinition.java saved as UTF-8 without BOM.'
}

Write-Host ''
Write-Host 'Installed test:'
Write-Host '  Item ID:  22640'
Write-Host '  Name:     Angel Wings'
Write-Host '  Model ID: 100500'
Write-Host '  Slot goal: cape/back'
Write-Host ''
Write-Host 'NEXT:'
Write-Host '1. Rebuild/run the Levincia client so index 1 repacks model 100500.'
Write-Host '2. Restart the server if your setup requires it for item spawning.'
Write-Host '3. Spawn item 22640 using your normal item command.'
Write-Host '4. First test: inventory appearance, then Wear, then player appearance.'
Write-Host ''
Write-Host 'NOTE: This first model is intentionally flat-colored/untextured. We are proving geometry + wearable loading first.'
