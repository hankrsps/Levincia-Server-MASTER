$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$itemDefPath = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\cache\definition\ItemDefinition.java'
$modelDir = Join-Path $repoRoot 'custom-assets\converted\wings\angel-wing-test\317'
$modelSource = Join-Path $modelDir '99000.gz'
$legacySource = Join-Path $modelDir '100500.gz'
$validator = Join-Path $PSScriptRoot 'validate-317-model.ps1'
$rawModel = Join-Path $modelDir 'angel_wings_317.dat'
$looseIndex = Join-Path $env:USERPROFILE '.Levincia\index1'
$modelTarget = Join-Path $looseIndex '99000.gz'
$oldTarget = Join-Path $looseIndex '100500.gz'
$stamp = Get-Date -Format 'yyyyMMdd-HHmmss'

Write-Host ''
Write-Host '=== Levincia Angel Wings In-Game Test Installer (Model 99000) ==='
Write-Host ''

foreach ($required in @($itemDefPath, $validator, $rawModel)) {
    if (!(Test-Path -LiteralPath $required)) { throw "Missing required file: $required" }
}
if (!(Test-Path -LiteralPath $modelSource)) {
    if (Test-Path -LiteralPath $legacySource) {
        Copy-Item -LiteralPath $legacySource -Destination $modelSource -Force
        Write-Host '[FIX] Created 99000.gz from the validated legacy 100500.gz model.'
    } else {
        throw 'Missing 99000.gz. Run .\tools\encode-angel-wing-317.ps1 first.'
    }
}

& powershell -ExecutionPolicy Bypass -File $validator -Path $rawModel
if ($LASTEXITCODE -ne 0) { throw 'Angel Wings model validation failed. Nothing was installed.' }

New-Item -ItemType Directory -Force -Path $looseIndex | Out-Null
if (Test-Path -LiteralPath $modelTarget) {
    $backupModel = "$modelTarget.backup-$stamp"
    Copy-Item -LiteralPath $modelTarget -Destination $backupModel -Force
    Write-Host "[BACKUP] Existing model 99000 -> $backupModel"
}
Copy-Item -LiteralPath $modelSource -Destination $modelTarget -Force
Write-Host "[OK] Staged model 99000 -> $modelTarget"
if (Test-Path -LiteralPath $oldTarget) {
    $oldBackup = "$oldTarget.disabled-$stamp"
    Move-Item -LiteralPath $oldTarget -Destination $oldBackup -Force
    Write-Host "[FIX] Disabled out-of-range loose model 100500 -> $oldBackup"
}

$text = [System.IO.File]::ReadAllText($itemDefPath)
$hadBom = $text.Length -gt 0 -and [int][char]$text[0] -eq 0xFEFF
if ($hadBom) { $text = $text.TrimStart([char]0xFEFF) }
$original = $text

# Migrate any already-installed Angel Wings definition from the out-of-range ID.
$text = $text.Replace('itemDef.modelID = 100500;', 'itemDef.modelID = 99000;')
$text = $text.Replace('itemDef.maleEquip1 = 100500;', 'itemDef.maleEquip1 = 99000;')
$text = $text.Replace('itemDef.femaleEquip1 = 100500;', 'itemDef.femaleEquip1 = 99000;')

if ($text -notmatch 'customId\s*==\s*22640') {
    $needle = 'if (customId == 22070) { // sword'
    $idx = $text.IndexOf($needle, [System.StringComparison]::Ordinal)
    if ($idx -lt 0) { throw 'Could not locate custom-item insertion point in ItemDefinition.java.' }
    $block = @'
		if (customId == 22640) { // Levincia Angel Wings external-model test
			itemDef.name = "Angel Wings";
			itemDef.description = "A pair of celestial wings.".getBytes();
			ItemDefinition itemDef2 = ItemDefinition.get(20079);
			itemDef.modelID = 99000;
			itemDef.maleEquip1 = 99000;
			itemDef.femaleEquip1 = 99000;
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
}

if ($text -ne $original -or $hadBom) {
    $backupJava = "$itemDefPath.angel-wings-99000-backup-$stamp"
    Copy-Item -LiteralPath $itemDefPath -Destination $backupJava -Force
    [System.IO.File]::WriteAllText($itemDefPath, $text, (New-Object System.Text.UTF8Encoding($false)))
    Write-Host '[OK] ItemDefinition 22640 now uses model 99000.'
    Write-Host "[BACKUP] $backupJava"
} else {
    Write-Host '[OK] ItemDefinition 22640 already uses model 99000.'
}

Write-Host ''
Write-Host 'Installed test:'
Write-Host '  Item ID:  22640'
Write-Host '  Name:     Angel Wings'
Write-Host '  Model ID: 99000'
Write-Host '  Slot:     cape/back'
Write-Host ''
Write-Host 'NEXT:'
Write-Host '1. Completely close the client.'
Write-Host '2. Rebuild/run the client so index 1 repacks model 99000.'
Write-Host '3. Spawn item 22640 and test inventory + Wear.'
Write-Host '4. Confirm the console says: Repacked Archive: 1 File: 99000.'
