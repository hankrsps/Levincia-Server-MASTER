$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$clientRoot = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client'
$serverRoot = Join-Path $repoRoot 'Levincia-Server'
$outDir = Join-Path $repoRoot 'custom-assets\branding\xslayer'
$report = Join-Path $env:USERPROFILE '.Levincia\xslayer-branding-report.txt'
$stamp = Get-Date -Format 'yyyyMMdd-HHmmss'

if (!(Test-Path -LiteralPath $clientRoot)) { throw "Client root not found: $clientRoot" }
if (!(Test-Path -LiteralPath $serverRoot)) { throw "Server root not found: $serverRoot" }
New-Item -ItemType Directory -Force -Path $outDir | Out-Null
New-Item -ItemType Directory -Force -Path (Split-Path -Parent $report) | Out-Null

Add-Type -AssemblyName System.Drawing

function New-LevinciaScreen {
    param(
        [Parameter(Mandatory=$true)][string]$Path,
        [Parameter(Mandatory=$true)][ValidateSet('Login','Loading')][string]$Mode
    )

    $w = 765; $h = 503
    $bmp = New-Object System.Drawing.Bitmap($w, $h)
    $g = [System.Drawing.Graphics]::FromImage($bmp)
    try {
        $g.SmoothingMode = [System.Drawing.Drawing2D.SmoothingMode]::AntiAlias
        $g.TextRenderingHint = [System.Drawing.Text.TextRenderingHint]::AntiAliasGridFit

        $rect = New-Object System.Drawing.Rectangle(0,0,$w,$h)
        $c1 = [System.Drawing.Color]::FromArgb(10,13,22)
        $c2 = [System.Drawing.Color]::FromArgb(28,11,42)
        $brush = New-Object System.Drawing.Drawing2D.LinearGradientBrush($rect,$c1,$c2,20)
        $g.FillRectangle($brush,$rect)
        $brush.Dispose()

        # Layered dark-fantasy glow.
        foreach ($r in @(340,270,210,150)) {
            $alpha = [Math]::Max(8, [int](34 - ($r/15)))
            $b = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb($alpha,115,55,210))
            $g.FillEllipse($b, [int](382-$r), [int](220-$r*.55), $r*2, [int]($r*1.1))
            $b.Dispose()
        }

        # Decorative rune-like diagonals and border.
        $pen1 = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(70,160,95,235),2)
        $pen2 = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(48,236,191,90),1)
        for ($x=-120; $x -lt 900; $x+=85) {
            $g.DrawLine($pen1,$x,0,$x+210,503)
            $g.DrawLine($pen2,$x+20,0,$x+230,503)
        }
        $pen1.Dispose(); $pen2.Dispose()

        $border = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(160,213,170,255),2)
        $g.DrawRectangle($border,7,7,750,488)
        $border.Dispose()

        # Center panel.
        $panel = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(185,8,10,18))
        $g.FillRectangle($panel,160,105,445,275)
        $panel.Dispose()
        $panelPen = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(150,155,100,235),2)
        $g.DrawRectangle($panelPen,160,105,445,275)
        $panelPen.Dispose()

        $titleFont = New-Object System.Drawing.Font('Georgia',38,[System.Drawing.FontStyle]::Bold)
        $subFont = New-Object System.Drawing.Font('Segoe UI',13,[System.Drawing.FontStyle]::Bold)
        $smallFont = New-Object System.Drawing.Font('Segoe UI',10,[System.Drawing.FontStyle]::Regular)
        $gold = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(242,204,116))
        $white = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(235,240,255))
        $muted = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(165,174,201))

        $fmt = New-Object System.Drawing.StringFormat
        $fmt.Alignment = [System.Drawing.StringAlignment]::Center
        $g.DrawString('LEVINCIA',$titleFont,$white,(New-Object System.Drawing.RectangleF(160,135,445,64)),$fmt)
        $g.DrawString('XSLAYER EDITION',$subFont,$gold,(New-Object System.Drawing.RectangleF(160,198,445,30)),$fmt)

        if ($Mode -eq 'Login') {
            $g.DrawString('ENTER THE REALM',$subFont,$white,(New-Object System.Drawing.RectangleF(160,250,445,30)),$fmt)
            $g.DrawString('Custom progression • bosses • wings • raids',$smallFont,$muted,(New-Object System.Drawing.RectangleF(160,292,445,24)),$fmt)
            $g.DrawString('levincia-ps.com',$smallFont,$gold,(New-Object System.Drawing.RectangleF(160,335,445,24)),$fmt)
        } else {
            $g.DrawString('PREPARING YOUR ADVENTURE',$subFont,$white,(New-Object System.Drawing.RectangleF(160,245,445,30)),$fmt)
            $g.DrawString('Loading custom models, maps and progression...',$smallFont,$muted,(New-Object System.Drawing.RectangleF(160,287,445,24)),$fmt)
            # Fake visual progress bar background for the artwork; client can draw live progress over it.
            $barBack = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(110,30,34,49))
            $g.FillRectangle($barBack,225,333,315,14); $barBack.Dispose()
            $bar = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(210,158,100,236))
            $g.FillRectangle($bar,227,335,190,10); $bar.Dispose()
        }

        $g.DrawString('Created for Xslayer',$smallFont,$muted,(New-Object System.Drawing.RectangleF(0,466,765,20)),$fmt)

        $fmt.Dispose(); $titleFont.Dispose(); $subFont.Dispose(); $smallFont.Dispose()
        $gold.Dispose(); $white.Dispose(); $muted.Dispose()
        $bmp.Save($Path,[System.Drawing.Imaging.ImageFormat]::Png)
    } finally {
        $g.Dispose(); $bmp.Dispose()
    }
}

$loginPng = Join-Path $outDir 'levincia-xslayer-login.png'
$loadingPng = Join-Path $outDir 'levincia-xslayer-loading.png'
New-LevinciaScreen -Path $loginPng -Mode Login
New-LevinciaScreen -Path $loadingPng -Mode Loading

$lines = New-Object System.Collections.Generic.List[string]
$lines.Add('=== Levincia Xslayer Branding Installer ===')
$lines.Add("Generated login:   $loginPng")
$lines.Add("Generated loading: $loadingPng")
$lines.Add('')

# Find likely existing login/loading assets. Only image files are considered.
$imageCandidates = Get-ChildItem -LiteralPath $clientRoot -Recurse -File -ErrorAction SilentlyContinue |
    Where-Object {
        $_.Extension -match '^\.(png|jpg|jpeg|gif)$' -and
        $_.FullName -notmatch '\\(build|bin|out|\.gradle)\\' -and
        $_.Name -match '(?i)(login|loading|loadscreen|splash|title|background)'
    }

$lines.Add('--- SCREEN ASSET CANDIDATES ---')
if ($imageCandidates) {
    foreach ($f in $imageCandidates) {
        $kind = if ($f.Name -match '(?i)(loading|loadscreen|splash)') { 'Loading' } elseif ($f.Name -match '(?i)(login|title)') { 'Login' } else { 'Background' }
        $lines.Add("[$kind] $($f.FullName)")
    }
} else {
    $lines.Add('No filename-based login/loading image candidates were found.')
}
$lines.Add('')

# Safely replace high-confidence filename matches, preserving original extension and backup.
$installed = 0
foreach ($f in $imageCandidates) {
    $isLogin = $f.Name -match '(?i)(login|loginscreen|titlebox|title\.png)'
    $isLoading = $f.Name -match '(?i)(loading|loadscreen|splash)'
    if (-not ($isLogin -or $isLoading)) { continue }
    if ($f.Extension -notmatch '(?i)^\.png$') {
        $lines.Add("[SKIP IMAGE] Non-PNG candidate requires manual conversion: $($f.FullName)")
        continue
    }
    $backup = "$($f.FullName).xslayer-backup-$stamp"
    Copy-Item -LiteralPath $f.FullName -Destination $backup -Force
    Copy-Item -LiteralPath ($(if($isLoading){$loadingPng}else{$loginPng})) -Destination $f.FullName -Force
    $installed++
    $lines.Add("[INSTALLED] $($f.FullName)")
    $lines.Add("[BACKUP]    $backup")
}
$lines.Add("High-confidence screen assets replaced: $installed")
$lines.Add('')

# Replace Hank branding in source/config/docs, but deliberately preserve historical player saves/logs
# and external GitHub owner URLs (hankrsps) so accounts/history and repository links are not damaged.
$extensions = @('.java','.kt','.kts','.gradle','.properties','.json','.xml','.txt','.md','.cfg','.ini','.yml','.yaml','.html','.css','.js','.ts','.tsx')
$roots = @($clientRoot,$serverRoot)
$changedFiles = New-Object System.Collections.Generic.List[string]
$remainingRefs = New-Object System.Collections.Generic.List[string]

foreach ($root in $roots) {
    Get-ChildItem -LiteralPath $root -Recurse -File -ErrorAction SilentlyContinue |
        Where-Object {
            $extensions -contains $_.Extension.ToLowerInvariant() -and
            $_.FullName -notmatch '\\data\\saves\\' -and
            $_.FullName -notmatch '\\(build|bin|out|\.gradle|\.idea)\\'
        } | ForEach-Object {
            $path = $_.FullName
            try { $text = [System.IO.File]::ReadAllText($path) } catch { return }
            if ($text -notmatch '(?i)\bhank\b') { return }
            $original = $text
            # Protect hankrsps URLs/usernames from replacement.
            $token = '__LEVINCIA_GITHUB_OWNER__'
            $text = $text -replace '(?i)hankrsps',$token
            $text = $text -creplace '\bHANK\b','XSLAYER'
            $text = $text -creplace '\bHank\b','Xslayer'
            $text = $text -creplace '\bhank\b','xslayer'
            $text = $text.Replace($token,'hankrsps')
            if ($text -ne $original) {
                $backup = "$path.xslayer-name-backup-$stamp"
                Copy-Item -LiteralPath $path -Destination $backup -Force
                [System.IO.File]::WriteAllText($path,$text,(New-Object System.Text.UTF8Encoding($false)))
                $changedFiles.Add($path)
            }
        }
}

$lines.Add('--- HANK -> XSLAYER SOURCE BRANDING ---')
$lines.Add("Changed source/config/doc files: $($changedFiles.Count)")
foreach ($p in $changedFiles) { $lines.Add("[CHANGED] $p") }
$lines.Add('')
$lines.Add('Historical files under Levincia-Server\data\saves were intentionally NOT renamed or rewritten.')
$lines.Add('The GitHub owner string "hankrsps" was intentionally preserved so repository URLs remain valid.')
$lines.Add('')

# Search what is still left outside saves/logs so we can target any unusual binary/cache references next.
foreach ($root in $roots) {
    Get-ChildItem -LiteralPath $root -Recurse -File -ErrorAction SilentlyContinue |
        Where-Object {
            $extensions -contains $_.Extension.ToLowerInvariant() -and
            $_.FullName -notmatch '\\data\\saves\\' -and
            $_.FullName -notmatch '\\(build|bin|out|\.gradle|\.idea)\\'
        } | ForEach-Object {
            try {
                $hits = Select-String -LiteralPath $_.FullName -Pattern '\bHank\b|\bhank\b|\bHANK\b' -AllMatches -ErrorAction Stop
                foreach ($h in $hits) {
                    if ($h.Line -notmatch '(?i)hankrsps') { $remainingRefs.Add("$($_.FullName):$($h.LineNumber): $($h.Line.Trim())") }
                }
            } catch {}
        }
}

$lines.Add('--- REMAINING NON-SAVE HANK REFERENCES ---')
if ($remainingRefs.Count -eq 0) { $lines.Add('None found.') } else { foreach ($r in $remainingRefs) { $lines.Add($r) } }

[System.IO.File]::WriteAllLines($report,$lines,(New-Object System.Text.UTF8Encoding($false)))

Write-Host ''
Write-Host '=== Levincia Xslayer Branding Installer ==='
Write-Host "[OK] New login artwork:   $loginPng"
Write-Host "[OK] New loading artwork: $loadingPng"
Write-Host "[OK] High-confidence client screen assets replaced: $installed"
Write-Host "[OK] Hank branding changed in source/config/docs: $($changedFiles.Count) files"
Write-Host "[REPORT] $report"
Write-Host ''
Write-Host 'NEXT:'
Write-Host '1. Rebuild/run the client.'
Write-Host '2. Check the loading and login screens.'
Write-Host '3. If either old screen remains, paste the SCREEN ASSET CANDIDATES section from the report.'
Write-Host '4. If the report shows remaining Hank references, paste that section too.'
