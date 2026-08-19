$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$clientRoot = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client'
$out = Join-Path $env:USERPROFILE '.Levincia\login-loading-renderer-report.txt'

if (!(Test-Path -LiteralPath $clientRoot)) { throw "Client root not found: $clientRoot" }

$patterns = @(
    'drawLogin', 'loginScreen', 'loginMessage', 'myUsername', 'myPassword',
    'drawLoading', 'loadingPercentage', 'setLoadingPercentage', 'loadingText',
    'titlebox', 'titlebutton', 'logo', 'background', 'welcomeScreen', 'login'
)

$lines = New-Object System.Collections.Generic.List[string]
$lines.Add('=== Levincia Login / Loading Renderer Finder ===')
$lines.Add("Client root: $clientRoot")
$lines.Add('')
$lines.Add('--- SOURCE HITS ---')

$sourceFiles = Get-ChildItem $clientRoot -Recurse -File -Include *.java,*.kt -ErrorAction SilentlyContinue |
    Where-Object { $_.FullName -notmatch '\\target\\|\\build\\' }

foreach ($f in $sourceFiles) {
    $hits = Select-String -LiteralPath $f.FullName -Pattern $patterns -SimpleMatch -ErrorAction SilentlyContinue
    if ($hits) {
        $lines.Add('')
        $lines.Add("FILE: $($f.FullName)")
        foreach ($h in ($hits | Select-Object -First 25)) {
            $txt = $h.Line.Trim()
            $lines.Add(("  {0}: {1}" -f $h.LineNumber, $txt))
        }
    }
}

$lines.Add('')
$lines.Add('--- IMAGE / SPRITE CANDIDATES ---')
$imageExt = @('.png','.jpg','.jpeg','.gif','.bmp')
$images = Get-ChildItem $clientRoot -Recurse -File -ErrorAction SilentlyContinue |
    Where-Object { $imageExt -contains $_.Extension.ToLowerInvariant() }
foreach ($img in $images) {
    $n = $img.Name.ToLowerInvariant()
    if ($n -match 'login|load|title|background|welcome|logo|splash') {
        $lines.Add(("{0}  {1} bytes" -f $img.FullName, $img.Length))
    }
}

$lines.Add('')
$lines.Add('--- CACHE-AREA CANDIDATES ---')
$cacheRoot = Join-Path $env:USERPROFILE '.Levincia'
if (Test-Path -LiteralPath $cacheRoot) {
    $cacheImages = Get-ChildItem $cacheRoot -Recurse -File -ErrorAction SilentlyContinue |
        Where-Object { $imageExt -contains $_.Extension.ToLowerInvariant() }
    foreach ($img in $cacheImages) {
        $n = $img.Name.ToLowerInvariant()
        if ($n -match 'login|load|title|background|welcome|logo|splash') {
            $lines.Add(("{0}  {1} bytes" -f $img.FullName, $img.Length))
        }
    }
}

[System.IO.File]::WriteAllLines($out, $lines, (New-Object System.Text.UTF8Encoding($false)))
Write-Host ''
Write-Host '=== Levincia Login / Loading Renderer Finder ==='
Write-Host "Report: $out"
Write-Host ''
Write-Host 'Paste these sections back to ChatGPT:'
Write-Host '  --- SOURCE HITS ---'
Write-Host '  --- IMAGE / SPRITE CANDIDATES ---'
Write-Host '  --- CACHE-AREA CANDIDATES ---'
Write-Host ''
Write-Host 'No cache or source files were modified.'
