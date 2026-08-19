param(
    [switch]$OpenSources,
    [switch]$DownloadWingTest,
    [string]$ImportFile,
    [string]$AssetKey
)

$ErrorActionPreference = 'Stop'

$root = Join-Path (Get-Location) 'custom-assets'
$incoming = Join-Path $root 'incoming'
$catalogPath = Join-Path $root 'SOURCE-CATALOG.csv'
$manifestPath = Join-Path $root 'ASSET-MANIFEST.csv'

if (!(Test-Path -LiteralPath $catalogPath)) {
    throw "Missing source catalog: $catalogPath"
}

$categories = @('armor','wings','bosses','auras','maps','props')
foreach ($category in $categories) {
    New-Item -ItemType Directory -Path (Join-Path $incoming $category) -Force | Out-Null
}

$catalog = Import-Csv -LiteralPath $catalogPath

Write-Host ''
Write-Host '=== Levincia CC0 Asset Staging Helper ==='
Write-Host ''
Write-Host 'Approved source catalog:'
$catalog | Select-Object key,name,category,license,formats | Format-Table -AutoSize

if ($OpenSources) {
    foreach ($entry in $catalog) {
        Write-Host "Opening $($entry.name)..."
        Start-Process $entry.source_page
    }
}

if ($DownloadWingTest) {
    $wing = $catalog | Where-Object key -eq 'wing_angel' | Select-Object -First 1
    if (!$wing) {
        throw 'wing_angel is missing from SOURCE-CATALOG.csv'
    }

    $targetDir = Join-Path $incoming 'wings'
    $targetZip = Join-Path $targetDir 'angel_wing_low_poly.zip'
    $downloadUrl = 'https://opengameart.org/sites/default/files/angel_wing_low_poly.zip'

    Write-Host ''
    Write-Host 'Downloading small CC0 Angel Wing compatibility test...'
    Invoke-WebRequest -Uri $downloadUrl -OutFile $targetZip -UseBasicParsing
    Write-Host "Saved: $targetZip"

    $extractDir = Join-Path $targetDir 'angel-wing-test'
    if (Test-Path -LiteralPath $extractDir) {
        Remove-Item -LiteralPath $extractDir -Recurse -Force
    }
    Expand-Archive -LiteralPath $targetZip -DestinationPath $extractDir -Force
    Write-Host "Extracted: $extractDir"
}

if ($ImportFile) {
    if (!$AssetKey) {
        throw '-AssetKey is required when using -ImportFile.'
    }
    if (!(Test-Path -LiteralPath $ImportFile)) {
        throw "Import file not found: $ImportFile"
    }

    $entry = $catalog | Where-Object key -eq $AssetKey | Select-Object -First 1
    if (!$entry) {
        throw "Unknown AssetKey '$AssetKey'. Check custom-assets\SOURCE-CATALOG.csv"
    }

    $destDir = Join-Path $incoming $entry.category
    New-Item -ItemType Directory -Path $destDir -Force | Out-Null
    $dest = Join-Path $destDir ([IO.Path]::GetFileName($ImportFile))
    Copy-Item -LiteralPath $ImportFile -Destination $dest -Force

    Write-Host ''
    Write-Host "Imported $($entry.name) -> $dest"

    if ([IO.Path]::GetExtension($dest) -ieq '.zip') {
        $extractName = [IO.Path]::GetFileNameWithoutExtension($dest)
        $extractDir = Join-Path $destDir $extractName
        if (Test-Path -LiteralPath $extractDir) {
            Remove-Item -LiteralPath $extractDir -Recurse -Force
        }
        Expand-Archive -LiteralPath $dest -DestinationPath $extractDir -Force
        Write-Host "Extracted ZIP -> $extractDir"
    } elseif ([IO.Path]::GetExtension($dest) -ieq '.7z') {
        Write-Host '7z archive staged. Extract it with 7-Zip before running the analyzer.'
    }
}

Write-Host ''
Write-Host 'Staging folders:'
foreach ($category in $categories) {
    Write-Host "  custom-assets\incoming\$category"
}

Write-Host ''
Write-Host 'NEXT:'
Write-Host '  1. Use -DownloadWingTest for the first small automatic test, OR'
Write-Host '  2. Use -OpenSources, download one approved CC0 pack in your browser, then stage it with:'
Write-Host '     powershell -ExecutionPolicy Bypass -File .\tools\stage-custom-assets.ps1 -ImportFile "C:\path\asset.zip" -AssetKey <key>'
Write-Host '  3. Run: powershell -ExecutionPolicy Bypass -File .\tools\analyze-custom-assets.ps1'
Write-Host ''
Write-Host 'No live cache files are modified by this helper.'
