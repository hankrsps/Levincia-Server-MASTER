$ErrorActionPreference = 'Stop'

$repoRoot = (Get-Location).Path
$incomingWing = Join-Path $repoRoot 'custom-assets\incoming\wings'
$reportDir = Join-Path $env:USERPROFILE '.Levincia'
$report = Join-Path $reportDir 'angel-wing-test-preflight.txt'

if (!(Test-Path -LiteralPath $incomingWing)) {
    throw "Missing staging folder: $incomingWing"
}

New-Item -ItemType Directory -Force -Path $reportDir | Out-Null

$files = Get-ChildItem -LiteralPath $incomingWing -Recurse -File -ErrorAction SilentlyContinue |
    Where-Object { $_.Extension.ToLowerInvariant() -in '.fbx','.obj','.gltf','.glb','.blend','.png','.jpg','.jpeg','.tga' }

$lines = New-Object System.Collections.Generic.List[string]
$lines.Add('=== Levincia Angel Wings Test Preflight ===')
$lines.Add('')
$lines.Add("Staging folder: $incomingWing")
$lines.Add('')

if (!$files -or $files.Count -eq 0) {
    $lines.Add('STATUS: NO ASSET FILES FOUND')
    $lines.Add('Run tools\stage-custom-assets.ps1 -DownloadWingTest first, then rerun this script.')
    $lines | Set-Content -LiteralPath $report -Encoding UTF8
    Get-Content -LiteralPath $report
    exit 0
}

$lines.Add('Files found:')
foreach ($f in $files) {
    $rel = $f.FullName.Substring($incomingWing.Length).TrimStart('\')
    $lines.Add("  $rel`t$($f.Length) bytes")
}

$modelFiles = $files | Where-Object { $_.Extension.ToLowerInvariant() -in '.fbx','.obj','.gltf','.glb','.blend' }
$textureFiles = $files | Where-Object { $_.Extension.ToLowerInvariant() -in '.png','.jpg','.jpeg','.tga' }

$lines.Add('')
$lines.Add("Model files:   $($modelFiles.Count)")
$lines.Add("Texture files: $($textureFiles.Count)")
$lines.Add('')

# Reserve IDs only; do not touch live cache or ItemDefinition yet.
$lines.Add('Reserved test identifiers:')
$lines.Add('  Item ID: 22640')
$lines.Add('  Name: Angel Wings')
$lines.Add('  Intended slot: cape/back')
$lines.Add('  Status: staging-only; NOT packed into cache')
$lines.Add('')
$lines.Add('NEXT:')
$lines.Add('1. Confirm at least one model file exists above.')
$lines.Add('2. We will inspect/convert that model into a Necrotic-compatible model format.')
$lines.Add('3. Only after conversion succeeds will we add ItemDefinition 22640 and pack the model.')
$lines.Add('4. Nothing in this script modifies main_file_cache.*')

$lines | Set-Content -LiteralPath $report -Encoding UTF8
Get-Content -LiteralPath $report
Write-Host ''
Write-Host "Report: $report"
