$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$validator = Join-Path $PSScriptRoot 'validate-beginner-phase.ps1'
$setup = Join-Path $PSScriptRoot 'setup-local-maven.ps1'
$localMaven = Join-Path $repoRoot '.tools\apache-maven-3.9.9\bin'

Write-Host ''
Write-Host '=== Levincia Beginner Validation Runner ==='

if (!(Test-Path -LiteralPath $validator)) {
    throw "Validator missing: $validator"
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
if (!$mvn) { throw 'Maven is still unavailable after local setup.' }
Write-Host "[OK] Maven ready: $($mvn.Source)"

& powershell -ExecutionPolicy Bypass -File $validator
exit $LASTEXITCODE
