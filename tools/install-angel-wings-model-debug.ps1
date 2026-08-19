$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$modelPath = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\world\Model.java'
$stamp = Get-Date -Format 'yyyyMMdd-HHmmss'

if (!(Test-Path -LiteralPath $modelPath)) {
    throw "Model.java not found: $modelPath"
}

$text = [System.IO.File]::ReadAllText($modelPath)
if ($text -match '\[ANGEL-100500\]') {
    Write-Host '[OK] Angel Wings model-load diagnostic is already installed.'
    exit 0
}

$needle = 'private Model(byte[] data, int modelId) {'
$idx = $text.IndexOf($needle, [System.StringComparison]::Ordinal)
if ($idx -lt 0) {
    throw 'Could not locate Model(byte[] data, int modelId) constructor. Nothing changed.'
}

$insertAt = $idx + $needle.Length
$debug = @'

                if (modelId == 100500) {
                        int b1 = data != null && data.length >= 1 ? data[data.length - 1] : 999;
                        int b2 = data != null && data.length >= 2 ? data[data.length - 2] : 999;
                        System.out.println("[ANGEL-100500] constructor reached; bytes=" + (data == null ? -1 : data.length) + " footer=" + b2 + "," + b1);
                        if (data == null || data.length < 18) {
                                System.out.println("[ANGEL-100500] ERROR: model data is null/too short before decoder routing");
                        } else if (data[data.length - 1] == -1 && data[data.length - 2] == -1) {
                                System.out.println("[ANGEL-100500] decoder route=622");
                        } else if (data[data.length - 1] == -2 && data[data.length - 2] == -1) {
                                System.out.println("[ANGEL-100500] decoder route=525");
                        } else {
                                System.out.println("[ANGEL-100500] decoder route=OLD317");
                        }
                }
'@

$backup = "$modelPath.angel-debug-backup-$stamp"
Copy-Item -LiteralPath $modelPath -Destination $backup -Force
$text = $text.Insert($insertAt, $debug)
[System.IO.File]::WriteAllText($modelPath, $text, (New-Object System.Text.UTF8Encoding($false)))

Write-Host ''
Write-Host '=== Levincia Angel Wings Model Load Diagnostic ==='
Write-Host "[OK] Patched: $modelPath"
Write-Host "[BACKUP] $backup"
Write-Host ''
Write-Host 'NEXT:'
Write-Host '1. Rebuild/run the client.'
Write-Host '2. Spawn item 22640 and look at it in inventory.'
Write-Host '3. Equip it once.'
Write-Host '4. Paste every console line beginning with [ANGEL-100500].'
Write-Host ''
Write-Host 'If NO [ANGEL-100500] line appears, model 100500 is not being loaded from cache at all.'
