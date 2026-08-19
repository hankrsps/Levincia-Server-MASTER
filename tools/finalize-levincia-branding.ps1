$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$clientRoot = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client'
$serverRoot = Join-Path $repoRoot 'Levincia-Server'
$loginSource = Join-Path $repoRoot 'custom-assets\branding\xslayer\levincia-xslayer-login.png'
$cacheRoot = Join-Path $env:USERPROFILE '.Levincia'
$loginTarget = Join-Path $cacheRoot 'levincia_login.png'
$loginBackup = Join-Path $cacheRoot 'levincia_login.original-backup.png'
$report = Join-Path $cacheRoot 'levincia-branding-finalize-report.txt'
$stamp = Get-Date -Format 'yyyyMMdd-HHmmss'

Write-Host ''
Write-Host '=== Levincia Branding Finalizer ==='
Write-Host ''

# Install the proven login background.
if (!(Test-Path -LiteralPath $loginSource)) {
    throw "Missing generated login image: $loginSource`nRun .\tools\install-xslayer-branding.ps1 first."
}
New-Item -ItemType Directory -Force -Path $cacheRoot | Out-Null
if ((Test-Path -LiteralPath $loginTarget) -and !(Test-Path -LiteralPath $loginBackup)) {
    Copy-Item -LiteralPath $loginTarget -Destination $loginBackup -Force
}
Copy-Item -LiteralPath $loginSource -Destination $loginTarget -Force
Write-Host "[OK] Login screen installed: $loginTarget"

$extensions = @('.java','.kt','.kts','.gradle','.properties','.json','.txt','.md','.xml','.yml','.yaml','.ini','.cfg')
$roots = @($clientRoot,$serverRoot)
$changed = New-Object System.Collections.Generic.List[string]
$preserved = New-Object System.Collections.Generic.List[string]
$utf8NoBom = New-Object System.Text.UTF8Encoding($false)

foreach ($root in $roots) {
    if (!(Test-Path -LiteralPath $root)) { continue }
    $files = Get-ChildItem -LiteralPath $root -Recurse -File -ErrorAction SilentlyContinue | Where-Object {
        $extensions -contains $_.Extension.ToLowerInvariant() -and
        $_.FullName -notmatch '[\\/]data[\\/]saves[\\/]' -and
        $_.FullName -notmatch '[\\/](target|bin|build|out|\.gradle)[\\/]'
    }
    foreach ($file in $files) {
        $text = [System.IO.File]::ReadAllText($file.FullName)
        if ($text -notmatch '(?i)avalon') { continue }
        $lines = $text -split "`r?`n", -1
        $didChange = $false
        for ($i=0; $i -lt $lines.Length; $i++) {
            $line = $lines[$i]
            if ($line -notmatch '(?i)avalon') { continue }

            # Preserve real external URLs so cache/download endpoints are not silently broken.
            if ($line -match '(?i)https?://') {
                $preserved.Add("URL: $($file.FullName):$($i+1): $line")
                continue
            }

            # Preserve historical author attribution instead of falsely re-crediting old code.
            if ($line -match '(?i)@author\s+Avalon') {
                $preserved.Add("AUTHOR CREDIT: $($file.FullName):$($i+1): $line")
                continue
            }

            $newLine = [regex]::Replace($line, 'Avalon', 'Levincia', [System.Text.RegularExpressions.RegexOptions]::IgnoreCase)
            if ($newLine -ne $line) {
                $lines[$i] = $newLine
                $didChange = $true
            }
        }
        if ($didChange) {
            $backup = "$($file.FullName).levincia-branding-backup-$stamp"
            Copy-Item -LiteralPath $file.FullName -Destination $backup -Force
            $newText = [string]::Join("`r`n", $lines)
            [System.IO.File]::WriteAllText($file.FullName, $newText, $utf8NoBom)
            $changed.Add($file.FullName)
            Write-Host "[OK] Avalon -> Levincia: $($file.FullName)"
        }
    }
}

$remaining = New-Object System.Collections.Generic.List[string]
foreach ($root in $roots) {
    if (!(Test-Path -LiteralPath $root)) { continue }
    Get-ChildItem -LiteralPath $root -Recurse -File -ErrorAction SilentlyContinue | Where-Object {
        $extensions -contains $_.Extension.ToLowerInvariant() -and
        $_.FullName -notmatch '[\\/]data[\\/]saves[\\/]' -and
        $_.FullName -notmatch '[\\/](target|bin|build|out|\.gradle)[\\/]'
    } | ForEach-Object {
        $matches = Select-String -LiteralPath $_.FullName -Pattern 'Avalon' -SimpleMatch -ErrorAction SilentlyContinue
        foreach ($m in $matches) { $remaining.Add("$($_.FullName):$($m.LineNumber): $($m.Line.Trim())") }
    }
}

$out = New-Object System.Collections.Generic.List[string]
$out.Add('=== Levincia Branding Finalizer Report ===')
$out.Add("Login installed: $loginTarget")
$out.Add("Changed files: $($changed.Count)")
foreach ($f in $changed) { $out.Add("CHANGED: $f") }
$out.Add('')
$out.Add('--- INTENTIONALLY PRESERVED ---')
$out.Add('External URLs were not renamed because changing a remote filename/domain locally can break downloads.')
$out.Add('Historical @author Avalon credits were preserved rather than falsely changing authorship.')
foreach ($p in $preserved) { $out.Add($p) }
$out.Add('')
$out.Add('--- REMAINING NON-SAVE AVALON REFERENCES ---')
if ($remaining.Count -eq 0) { $out.Add('None.') } else { foreach ($r in $remaining) { $out.Add($r) } }
[System.IO.File]::WriteAllLines($report, $out, $utf8NoBom)

Write-Host ''
Write-Host "[DONE] Changed $($changed.Count) source/config/document files."
Write-Host "Report: $report"
Write-Host 'Historical data/saves content was left untouched.'
Write-Host 'Remote URL strings and original author credits are preserved for safety/accuracy.'
Write-Host ''
Write-Host 'NEXT: rebuild/restart the client and server.'
