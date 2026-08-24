$ErrorActionPreference = 'Stop'
$repoRoot = Split-Path -Parent $PSScriptRoot
$serverRoot = Join-Path $repoRoot 'Levincia-Server'
$setup = Join-Path $PSScriptRoot 'setup-local-maven.ps1'
$localMaven = Join-Path $repoRoot '.tools\apache-maven-3.9.9\bin'
$gamePort = 43594

if (!(Test-Path -LiteralPath (Join-Path $serverRoot 'data'))) {
    throw "Levincia server data directory is missing: $serverRoot\data"
}
if (!(Test-Path -LiteralPath (Join-Path $serverRoot 'pom.xml'))) {
    throw "Levincia server pom.xml is missing: $serverRoot\pom.xml"
}

# Fail early with a clear message if another server/process already owns the game port.
$listener = Get-NetTCPConnection -LocalPort $gamePort -State Listen -ErrorAction SilentlyContinue | Select-Object -First 1
if ($listener) {
    $pidUsingPort = $listener.OwningProcess
    $processName = 'unknown process'
    try {
        $processName = (Get-Process -Id $pidUsingPort -ErrorAction Stop).ProcessName
    } catch { }

    Write-Host ''
    Write-Host "[ERROR] Port $gamePort is already in use by PID $pidUsingPort ($processName)." -ForegroundColor Red
    Write-Host 'Levincia is probably already running in another window.' -ForegroundColor Yellow
    Write-Host "To inspect it: tasklist /FI \"PID eq $pidUsingPort\""
    Write-Host "If it is an old Levincia java.exe, stop it with: taskkill /PID $pidUsingPort /F"
    Write-Host 'Then run .\run-server.bat again.'
    exit 2
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
