$ErrorActionPreference = 'Stop'
$repoRoot = Split-Path -Parent $PSScriptRoot
$serverRoot = Join-Path $repoRoot 'Levincia-Server'
$setup = Join-Path $PSScriptRoot 'setup-local-maven.ps1'
$localMaven = Join-Path $repoRoot '.tools\apache-maven-3.9.9\bin'

if (!(Test-Path -LiteralPath (Join-Path $serverRoot 'data'))) {
    throw "Levincia server data directory is missing: $serverRoot\data"
}
if (!(Test-Path -LiteralPath (Join-Path $serverRoot 'pom.xml'))) {
    throw "Levincia server pom.xml is missing: $serverRoot\pom.xml"
}

if (!(Get-Command mvn -ErrorAction SilentlyContinue)) {
    $localMvnCmd = Join-Path $localMaven 'mvn.cmd'
    if (!(Test-Path -LiteralPath $localMvnCmd)) {
        if (!(Test-Path -LiteralPath $setup)) { throw "Maven is missing and setup script was not found: $setup" }
        & powershell -ExecutionPolicy Bypass -File $setup
        if ($LASTEXITCODE -ne 0) { throw 'Local Maven setup failed.' }
    }
    $env:PATH = "$localMaven;$env:PATH"
}

$mvn = Get-Command mvn -ErrorAction SilentlyContinue
if (!$mvn) { throw 'Maven is unavailable.' }

Write-Host "Starting Levincia from: $serverRoot"
Push-Location $serverRoot
try {
    & mvn -q -DskipTests compile exec:java
    exit $LASTEXITCODE
}
finally {
    Pop-Location
}
