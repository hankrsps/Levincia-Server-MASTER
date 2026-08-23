$ErrorActionPreference = 'Continue'

$repoRoot = Split-Path -Parent $PSScriptRoot
$serverDir = Join-Path $repoRoot 'Levincia-Server'
$clientDir = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client'
$report = Join-Path $env:USERPROFILE '.Levincia\beginner-phase-validation.txt'
$lines = New-Object System.Collections.Generic.List[string]
$failures = 0

function Add-Result([string]$Status,[string]$Text) {
    $script:lines.Add("[$Status] $Text")
    Write-Host "[$Status] $Text"
    if ($Status -eq 'FAIL') { $script:failures++ }
}

Write-Host ''
Write-Host '=== Levincia Beginner Phase Validator ==='
$lines.Add('=== Levincia Beginner Phase Validator ===')
$lines.Add("Generated: $(Get-Date)")
$lines.Add('')

# Tooling
$java = Get-Command java -ErrorAction SilentlyContinue
$mvn = Get-Command mvn -ErrorAction SilentlyContinue
if ($java) {
    $javaVersion = (& java -version 2>&1 | Select-Object -First 1)
    Add-Result 'OK' "Java found: $javaVersion"
} else { Add-Result 'FAIL' 'Java not found in PATH (Java 11 is expected by both Maven projects).' }
if ($mvn) { Add-Result 'OK' "Maven found: $($mvn.Source)" } else { Add-Result 'FAIL' 'Maven (mvn) not found in PATH.' }

# Required files and source checks
$checks = @(
    @{Path='Levincia-Server\pom.xml'; Desc='Server Maven project'},
    @{Path='Levincia-Client-Master\Levincia-Client\pom.xml'; Desc='Client Maven project'},
    @{Path='Levincia-Server\src\main\java\com\ruse\GameSettings.java'; Desc='Server settings'},
    @{Path='Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\Configuration.java'; Desc='Client settings'},
    @{Path='Levincia-Server\src\main\java\com\ruse\world\content\dialogue\impl\Tutorial.java'; Desc='Tutorial'},
    @{Path='Levincia-Server\src\main\java\com\ruse\world\content\startertasks\StarterTasks.java'; Desc='Starter tasks'},
    @{Path='Levincia-Server\src\main\java\com\ruse\world\content\startertasks\StarterTaskHandler.java'; Desc='Starter task handler'},
    @{Path='Levincia-Server\src\main\java\com\ruse\net\packet\impl\CommandPacketListener.java'; Desc='Commands'},
    @{Path='Levincia-Server\src\main\java\com\ruse\net\packet\impl\NPCOptionPacketListener.java'; Desc='NPC interactions'}
)
foreach ($c in $checks) {
    $p = Join-Path $repoRoot $c.Path
    if (Test-Path -LiteralPath $p) { Add-Result 'OK' $c.Desc } else { Add-Result 'FAIL' "$($c.Desc) missing: $($c.Path)" }
}

$serverSettings = Join-Path $serverDir 'src\main\java\com\ruse\GameSettings.java'
$clientSettings = Join-Path $clientDir 'src\main\java\org\necrotic\Configuration.java'
$tutorial = Join-Path $serverDir 'src\main\java\com\ruse\world\content\dialogue\impl\Tutorial.java'
$spriteMap = Join-Path $clientDir 'src\main\java\org\necrotic\client\graphics\SpritesMap.java'

if (Test-Path $serverSettings) {
    $s = [IO.File]::ReadAllText($serverSettings)
    if ($s -match 'RSPS_NAME\s*=\s*"Levincia"') { Add-Result 'OK' 'Server name is Levincia.' } else { Add-Result 'FAIL' 'Server RSPS_NAME is not Levincia.' }
    if ($s -match 'GAME_PORT\s*=\s*43594') { Add-Result 'OK' 'Server port is 43594.' } else { Add-Result 'FAIL' 'Server port is not 43594.' }
    if ($s -match 'discord\.gg/UmnFXzYrB7') { Add-Result 'OK' 'Active Levincia Discord invite is present.' } else { Add-Result 'WARN' 'Active Discord invite was not found in GameSettings.java.' }
}

if (Test-Path $clientSettings) {
    $c = [IO.File]::ReadAllText($clientSettings)
    if ($c -match 'CLIENT_NAME\s*=\s*"Levincia"') { Add-Result 'OK' 'Client name is Levincia.' } else { Add-Result 'FAIL' 'Client name is not Levincia.' }
    if ($c -match 'SERVER_PORT\s*=\s*43594') { Add-Result 'OK' 'Client port matches server port.' } else { Add-Result 'FAIL' 'Client port does not match 43594.' }
    if ($c -match 'clientversion\s*=\s*30') { Add-Result 'OK' 'Client login UID/version is 30.' } else { Add-Result 'WARN' 'Client login UID/version is not 30; compare with LoginDecoder.currentversion.' }
}

if (Test-Path $tutorial) {
    $t = [IO.File]::ReadAllText($tutorial)
    if ($t -match 'return get\(p, stage \+ 1\);' -and $t -notmatch 'return get\(p, 13\);') { Add-Result 'OK' 'Full tutorial progression is enabled.' } else { Add-Result 'FAIL' 'Tutorial still appears to skip stages.' }
    if ($t -match 'Pohenix') { Add-Result 'WARN' 'Tutorial still contains the Pohenix typo.' } else { Add-Result 'OK' 'Tutorial typo cleanup present.' }
}

if (Test-Path $spriteMap) {
    $sm = [IO.File]::ReadAllText($spriteMap)
    if ($sm -match 'id == 449' -and $sm -match 'levincia_login\.png') { Add-Result 'OK' 'Loose login sprite 449 override is installed.' } else { Add-Result 'WARN' 'Loose sprite 449 override is not installed.' }
}

# Cache-side files used by the client.
$cacheRoot = Join-Path $env:USERPROFILE '.Levincia'
$login = Join-Path $cacheRoot 'levincia_login.png'
$spritesDat = Join-Path $cacheRoot 'data\main_file_sprites.dat'
$spritesIdx = Join-Path $cacheRoot 'data\main_file_sprites.idx'
foreach ($entry in @(@($login,'Login PNG'),@($spritesDat,'Sprite DAT'),@($spritesIdx,'Sprite IDX'))) {
    if (Test-Path -LiteralPath $entry[0]) {
        $len = (Get-Item -LiteralPath $entry[0]).Length
        if ($len -gt 0) { Add-Result 'OK' "$($entry[1]) exists ($len bytes)." } else { Add-Result 'FAIL' "$($entry[1]) is zero bytes." }
    } else { Add-Result 'FAIL' "$($entry[1]) is missing: $($entry[0])" }
}

# Scan source/config only; deliberately ignore historical saves/logs and URLs that must remain unchanged.
$scanRoots = @((Join-Path $serverDir 'src'), (Join-Path $clientDir 'src'))
$legacyHits = @()
foreach ($root in $scanRoots) {
    if (Test-Path $root) {
        $legacyHits += Get-ChildItem $root -Recurse -File -Include *.java,*.kt,*.json,*.txt -ErrorAction SilentlyContinue |
            Select-String -Pattern '\bAvalon\b|Hank_rsps|Owner/Developer:\s*Hank' -ErrorAction SilentlyContinue
    }
}
if ($legacyHits.Count -eq 0) { Add-Result 'OK' 'No obvious player-facing Avalon/Hank branding remains in source.' }
else {
    Add-Result 'WARN' "Found $($legacyHits.Count) possible legacy branding references in source. Review report details."
    foreach ($hit in $legacyHits | Select-Object -First 30) { $lines.Add("    $($hit.Path):$($hit.LineNumber): $($hit.Line.Trim())") }
}

# Compile both Maven projects. Do not start either program automatically.
if ($mvn) {
    Write-Host ''
    Write-Host '--- Compiling server ---'
    Push-Location $serverDir
    & mvn -q -DskipTests package
    $serverExit = $LASTEXITCODE
    Pop-Location
    if ($serverExit -eq 0) { Add-Result 'OK' 'Server Maven build passed.' } else { Add-Result 'FAIL' "Server Maven build failed with exit code $serverExit." }

    Write-Host ''
    Write-Host '--- Compiling client ---'
    Push-Location $clientDir
    & mvn -q -DskipTests package
    $clientExit = $LASTEXITCODE
    Pop-Location
    if ($clientExit -eq 0) { Add-Result 'OK' 'Client Maven build passed.' } else { Add-Result 'FAIL' "Client Maven build failed with exit code $clientExit." }
}

$lines.Add('')
$lines.Add("Failures: $failures")
if ($failures -eq 0) { $lines.Add('RESULT: STATIC/BUILD VALIDATION PASSED. Runtime gameplay smoke tests are still required.') }
else { $lines.Add('RESULT: VALIDATION FAILED. Fix the FAIL entries before calling the beginner phase stable.') }

New-Item -ItemType Directory -Force -Path (Split-Path $report -Parent) | Out-Null
[IO.File]::WriteAllLines($report,$lines,(New-Object Text.UTF8Encoding($false)))
Write-Host ''
Write-Host "Report: $report"
Write-Host "Failures: $failures"
if ($failures -gt 0) { exit 1 }
