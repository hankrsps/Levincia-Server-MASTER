$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$tutorial = Join-Path $repoRoot 'Levincia-Server\src\main\java\com\ruse\world\content\dialogue\impl\Tutorial.java'
$settings = Join-Path $repoRoot 'Levincia-Server\src\main\java\com\ruse\GameSettings.java'
$client = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\Client.java'
$report = Join-Path $env:USERPROFILE '.Levincia\beginner-phase-report.txt'
$stamp = Get-Date -Format 'yyyyMMdd-HHmmss'
$utf8 = New-Object System.Text.UTF8Encoding($false)

Write-Host ''
Write-Host '=== Levincia Beginner Phase Installer ==='

foreach ($f in @($tutorial,$settings,$client)) {
    if (!(Test-Path -LiteralPath $f)) { throw "Missing required file: $f" }
}

$changed = New-Object System.Collections.Generic.List[string]

function Save-PatchedFile([string]$Path,[string]$Text,[string]$Original,[string]$Label) {
    if ($Text -ne $Original) {
        Copy-Item -LiteralPath $Path -Destination "$Path.beginner-backup-$stamp" -Force
        [System.IO.File]::WriteAllText($Path,$Text,$utf8)
        $script:changed.Add($Label)
        Write-Host "[OK] $Label"
    } else {
        Write-Host "[OK] $Label already applied / no matching old text found."
    }
}

# 1) Re-enable the full first-time player walkthrough.
$t = [System.IO.File]::ReadAllText($tutorial)
$origT = $t
$t = $t.Replace('return get(p, 13);// stage + 1);','return get(p, stage + 1);')
$t = $t.Replace('simply press the on the respective skill in the skill tab.','simply press the respective skill in the skill tab.')
$t = $t.Replace('mighty Pohenix!','mighty Phoenix!')
$t = $t.Replace('You may also wish to check the ::forums and ::wikia','You may also wish to check the Levincia website and Discord')
Save-PatchedFile $tutorial $t $origT 'Tutorial walkthrough and text cleaned up'

# 2) Make every support/info Discord URL point to the active Levincia invite.
$s = [System.IO.File]::ReadAllText($settings)
$origS = $s
$s = $s.Replace('https://discord.com/invite/EWbMsxdm78','https://discord.gg/UmnFXzYrB7')
Save-PatchedFile $settings $s $origS 'Discord/support links updated'

# 3) Clean the login announcement so it does not advertise an old beta sale and uses Xslayer branding.
$c = [System.IO.File]::ReadAllText($client)
$origC = $c
$c = [regex]::Replace($c,
    'private final String bannerMessage = ".*?";',
    'private final String bannerMessage = "Welcome to Levincia! Build your account, complete starter tasks, fight bosses, and join the community.       Owner/Developer: Xslayer       Use ::discord for updates and support.";',
    [System.Text.RegularExpressions.RegexOptions]::Singleline)
Save-PatchedFile $client $c $origC 'Login banner finalized for beginner phase'

# 4) Apply the already-tested loose login sprite override when available.
$loginOverride = Join-Path $repoRoot 'tools\install-login-sprite-449-override.ps1'
if (Test-Path -LiteralPath $loginOverride) {
    Write-Host '[INFO] Applying login sprite 449 override...'
    & powershell -ExecutionPolicy Bypass -File $loginOverride
    if ($LASTEXITCODE -ne 0) { throw 'Login sprite 449 override failed.' }
}

# 5) Audit important beginner systems without rewriting them blindly.
$required = @(
    @{ Name='Starter tasks'; Path='Levincia-Server\src\main\java\com\ruse\world\content\startertasks\StarterTasks.java' },
    @{ Name='Starter task handler'; Path='Levincia-Server\src\main\java\com\ruse\world\content\startertasks\StarterTaskHandler.java' },
    @{ Name='Starter reward box'; Path='Levincia-Server\src\main\java\com\ruse\world\content\boxes\Starter.java' },
    @{ Name='Tutorial'; Path='Levincia-Server\src\main\java\com\ruse\world\content\dialogue\impl\Tutorial.java' },
    @{ Name='Commands'; Path='Levincia-Server\src\main\java\com\ruse\net\packet\impl\CommandPacketListener.java' },
    @{ Name='NPC interactions'; Path='Levincia-Server\src\main\java\com\ruse\net\packet\impl\NPCOptionPacketListener.java' }
)

$lines = New-Object System.Collections.Generic.List[string]
$lines.Add('=== Levincia Beginner Phase Report ===')
$lines.Add("Generated: $(Get-Date)")
$lines.Add('')
$lines.Add('Applied changes:')
if ($changed.Count -eq 0) { $lines.Add('  - No new text/source patches were needed on this run.') }
foreach ($x in $changed) { $lines.Add("  - $x") }
$lines.Add('')
$lines.Add('Required system presence:')
foreach ($r in $required) {
    $full = Join-Path $repoRoot $r.Path
    $status = if (Test-Path -LiteralPath $full) { 'OK' } else { 'MISSING' }
    $lines.Add("  [$status] $($r.Name) - $($r.Path)")
}
$lines.Add('')
$lines.Add('Beginner-phase smoke test:')
$lines.Add('  1. Create a fresh test account/IP-eligible starter.')
$lines.Add('  2. Confirm difficulty selection and the full tutorial stages play in order.')
$lines.Add('  3. Confirm the starter kit is awarded exactly once.')
$lines.Add('  4. Confirm starter tasks open and can be completed.')
$lines.Add('  5. Test home, shops, skill teleports, boss teleports, vote/store/discord commands.')
$lines.Add('  6. Test the three progression combat styles and Angel Wings.')
$lines.Add('  7. Confirm login screen says Levincia/Xslayer and no player-visible Avalon/Hank branding remains.')

New-Item -ItemType Directory -Force -Path (Split-Path $report -Parent) | Out-Null
[System.IO.File]::WriteAllLines($report,$lines,$utf8)

Write-Host ''
Write-Host "[OK] Beginner phase report: $report"
Write-Host ''
Write-Host 'NEXT:'
Write-Host '1. Rebuild/restart client and server.'
Write-Host '2. Test with a fresh account.'
Write-Host '3. Paste the report plus any startup errors.'
