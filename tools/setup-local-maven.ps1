$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$toolsDir = Join-Path $repoRoot '.tools'
$version = '3.9.9'
$archive = Join-Path $toolsDir "apache-maven-$version-bin.zip"
$installDir = Join-Path $toolsDir "apache-maven-$version"
$mvnCmd = Join-Path $installDir 'bin\mvn.cmd'
$url = "https://archive.apache.org/dist/maven/maven-3/$version/binaries/apache-maven-$version-bin.zip"

Write-Host ''
Write-Host '=== Levincia Local Maven Setup ==='

if (Get-Command mvn -ErrorAction SilentlyContinue) {
    Write-Host '[OK] Maven is already available in PATH.'
    & mvn -version
    exit 0
}

if (Test-Path -LiteralPath $mvnCmd) {
    Write-Host "[OK] Local Maven already installed: $mvnCmd"
    & $mvnCmd -version
    exit 0
}

New-Item -ItemType Directory -Force -Path $toolsDir | Out-Null

Write-Host "[INFO] Downloading Apache Maven $version from the Apache archive..."
Invoke-WebRequest -Uri $url -OutFile $archive -UseBasicParsing

Write-Host '[INFO] Extracting Maven...'
Expand-Archive -LiteralPath $archive -DestinationPath $toolsDir -Force
Remove-Item -LiteralPath $archive -Force -ErrorAction SilentlyContinue

if (!(Test-Path -LiteralPath $mvnCmd)) {
    throw "Maven installation completed but mvn.cmd was not found: $mvnCmd"
}

Write-Host "[OK] Local Maven installed: $mvnCmd"
& $mvnCmd -version
Write-Host ''
Write-Host 'No system-wide PATH changes were made.'
Write-Host 'The Levincia validator will automatically use this local Maven copy.'
