$ErrorActionPreference = 'Stop'

$source = '.\custom-assets\branding\xslayer\levincia-xslayer-login.png'
$cache = Join-Path $env:USERPROFILE '.Levincia'
$target = Join-Path $cache 'levincia_login.png'
$backup = Join-Path $cache 'levincia_login.original-backup.png'

Write-Host ''
Write-Host '=== Levincia Xslayer Login Screen Installer ==='

if (!(Test-Path -LiteralPath $source)) {
    throw "Generated Xslayer login image not found: $source`nRun tools\install-xslayer-branding.ps1 first."
}

New-Item -ItemType Directory -Force -Path $cache | Out-Null

if ((Test-Path -LiteralPath $target) -and !(Test-Path -LiteralPath $backup)) {
    Copy-Item -LiteralPath $target -Destination $backup -Force
    Write-Host "[BACKUP] $backup"
}

Copy-Item -LiteralPath $source -Destination $target -Force
Write-Host "[OK] Installed Xslayer login screen: $target"
Write-Host ''
Write-Host 'The client already reads this cache-side levincia_login.png file.'
Write-Host 'Completely restart the client to verify the screen.'
Write-Host ''
Write-Host 'Original backup is preserved at:'
Write-Host "  $backup"
