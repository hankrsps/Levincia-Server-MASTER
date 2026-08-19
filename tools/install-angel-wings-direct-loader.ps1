$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$itemDefPath = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\cache\definition\ItemDefinition.java'
$fetcherPath = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\cache\ondemand\OnDemandFetcher.java'
$modelDir = Join-Path $repoRoot 'custom-assets\converted\wings\angel-wing-test\317'
$source100500 = Join-Path $modelDir '100500.gz'
$source99000 = Join-Path $modelDir '99000.gz'
$customDir = Join-Path $env:USERPROFILE '.Levincia\custom-models'
$customTarget = Join-Path $customDir '100500.gz'
$index1 = Join-Path $env:USERPROFILE '.Levincia\index1'
$stamp = Get-Date -Format 'yyyyMMdd-HHmmss'

Write-Host ''
Write-Host '=== Levincia Angel Wings Direct Loose Model Loader ==='
Write-Host ''

foreach ($required in @($itemDefPath, $fetcherPath)) {
    if (!(Test-Path -LiteralPath $required)) { throw "Missing required file: $required" }
}

if (!(Test-Path -LiteralPath $source100500)) {
    if (Test-Path -LiteralPath $source99000) {
        Copy-Item -LiteralPath $source99000 -Destination $source100500 -Force
        Write-Host '[FIX] Restored 100500.gz from the identical 99000.gz staging model.'
    } else {
        throw 'No encoded Angel Wings gzip was found. Run encode-angel-wing-317.ps1 first.'
    }
}

New-Item -ItemType Directory -Force -Path $customDir | Out-Null
Copy-Item -LiteralPath $source100500 -Destination $customTarget -Force
Write-Host "[OK] Direct custom model staged -> $customTarget"

foreach ($id in 100500,99000) {
    $p = Join-Path $index1 "$id.gz"
    if (Test-Path -LiteralPath $p) {
        $disabled = "$p.disabled-$stamp"
        Move-Item -LiteralPath $p -Destination $disabled -Force
        Write-Host "[FIX] Disabled index1 repack source $id -> $disabled"
    }
}

$itemText = [System.IO.File]::ReadAllText($itemDefPath)
$itemOriginal = $itemText
$itemText = $itemText.Replace('itemDef.modelID = 99000;', 'itemDef.modelID = 100500;')
$itemText = $itemText.Replace('itemDef.maleEquip1 = 99000;', 'itemDef.maleEquip1 = 100500;')
$itemText = $itemText.Replace('itemDef.femaleEquip1 = 99000;', 'itemDef.femaleEquip1 = 100500;')
if ($itemText -ne $itemOriginal) {
    Copy-Item -LiteralPath $itemDefPath -Destination "$itemDefPath.direct-loader-backup-$stamp" -Force
    [System.IO.File]::WriteAllText($itemDefPath, $itemText, (New-Object System.Text.UTF8Encoding($false)))
    Write-Host '[OK] Item 22640 restored to dedicated model ID 100500.'
} else {
    Write-Host '[OK] Item 22640 already points at model 100500.'
}

$fetchText = [System.IO.File]::ReadAllText($fetcherPath)
if ($fetchText -match 'LEVINCIA CUSTOM MODEL 100500') {
    Write-Host '[OK] OnDemandFetcher direct loader already installed.'
} else {
    $needle = "public void get(int i) {`r`n`t`ttry {"
    $idx = $fetchText.IndexOf($needle, [System.StringComparison]::Ordinal)
    if ($idx -lt 0) {
        $needle = "public void get(int i) {`n`t`ttry {"
        $idx = $fetchText.IndexOf($needle, [System.StringComparison]::Ordinal)
    }
    if ($idx -lt 0) { throw 'Could not locate OnDemandFetcher.get(int i) insertion point.' }

    $insertAt = $idx + $needle.IndexOf('try {')
    $direct = @'
// LEVINCIA CUSTOM MODEL 100500 - direct loose loader, bypasses cache version arrays
		if (i == 100500) {
			try {
				File custom = new File(Signlink.getCacheDirectory(), "custom-models" + File.separator + "100500.gz");
				if (custom.exists()) {
					try (GZIPInputStream gzip = new GZIPInputStream(new FileInputStream(custom));
						 ByteArrayOutputStream out = new ByteArrayOutputStream()) {
						byte[] buffer = new byte[8192];
						int read;
						while ((read = gzip.read(buffer)) != -1) {
							out.write(buffer, 0, read);
						}
						byte[] model = out.toByteArray();
						System.out.println("[ANGEL-100500] direct loose load bytes=" + model.length + " file=" + custom.getAbsolutePath());
						Model.load(model, 100500);
						return;
					}
				}
				System.out.println("[ANGEL-100500] direct loose file missing: " + custom.getAbsolutePath());
			} catch (Exception e) {
				System.out.println("[ANGEL-100500] direct loose load failed: " + e.getMessage());
				e.printStackTrace();
			}
		}
		
'@

    Copy-Item -LiteralPath $fetcherPath -Destination "$fetcherPath.angel-direct-backup-$stamp" -Force
    $fetchText = $fetchText.Insert($insertAt, $direct)
    [System.IO.File]::WriteAllText($fetcherPath, $fetchText, (New-Object System.Text.UTF8Encoding($false)))
    Write-Host '[OK] Installed direct loose loader for model 100500.'
}

Write-Host ''
Write-Host 'NEXT:'
Write-Host '1. Rebuild the client.'
Write-Host '2. Startup should NOT repack 99000 or 100500 from index1.'
Write-Host '3. Spawn/equip item 22640.'
Write-Host '4. Paste any console line beginning with [ANGEL-100500].'
Write-Host ''
Write-Host 'This avoids both the 99538 on-demand array limit and collisions with existing cache model IDs.'
