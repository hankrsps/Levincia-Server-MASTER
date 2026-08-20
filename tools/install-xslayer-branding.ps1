$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$outDir = Join-Path $repoRoot 'custom-assets\branding\xslayer'
$cacheDir = Join-Path $env:USERPROFILE '.Levincia'
$loginPng = Join-Path $outDir 'levincia-xslayer-login.png'
$liveLogin = Join-Path $cacheDir 'levincia_login.png'
$backup = Join-Path $cacheDir 'levincia_login.pre-xslayer-final-backup.png'

New-Item -ItemType Directory -Force -Path $outDir | Out-Null
New-Item -ItemType Directory -Force -Path $cacheDir | Out-Null
Add-Type -AssemblyName System.Drawing

$w = 765
$h = 503
$bmp = New-Object System.Drawing.Bitmap($w, $h)
$g = [System.Drawing.Graphics]::FromImage($bmp)

try {
    $g.SmoothingMode = [System.Drawing.Drawing2D.SmoothingMode]::AntiAlias
    $g.TextRenderingHint = [System.Drawing.Text.TextRenderingHint]::AntiAliasGridFit

    # Very dark red/black background so this is unmistakably different from the old screen.
    $rect = New-Object System.Drawing.Rectangle(0,0,$w,$h)
    $bg = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
        $rect,
        [System.Drawing.Color]::FromArgb(5,5,8),
        [System.Drawing.Color]::FromArgb(95,0,8),
        90
    )
    $g.FillRectangle($bg,$rect)
    $bg.Dispose()

    # Large red moon/glow.
    $moonGlow = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(70,255,0,20))
    $g.FillEllipse($moonGlow,485,18,250,250)
    $moonGlow.Dispose()
    $moon = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(190,165,15,24))
    $g.FillEllipse($moon,515,48,190,190)
    $moon.Dispose()

    # Ground / castle silhouette.
    $dark = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(235,3,3,6))
    $g.FillRectangle($dark,0,365,765,138)
    foreach($tower in @(
        @{X=25;Y=235;W=65;H=130},
        @{X=115;Y=285;W=48;H=80},
        @{X=600;Y=260;W=55;H=105},
        @{X=680;Y=215;W=60;H=150}
    )) {
        $g.FillRectangle($dark,[int]$tower.X,[int]$tower.Y,[int]$tower.W,[int]$tower.H)
    }
    $dark.Dispose()

    # Bright frame.
    $frame = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(255,215,20,35),4)
    $g.DrawRectangle($frame,8,8,748,486)
    $frame.Dispose()

    # Main title.
    $fmt = New-Object System.Drawing.StringFormat
    $fmt.Alignment = [System.Drawing.StringAlignment]::Center
    $titleFont = New-Object System.Drawing.Font('Georgia',52,[System.Drawing.FontStyle]::Bold)
    $subFont = New-Object System.Drawing.Font('Segoe UI',18,[System.Drawing.FontStyle]::Bold)
    $smallFont = New-Object System.Drawing.Font('Segoe UI',11,[System.Drawing.FontStyle]::Regular)
    $white = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(250,245,245))
    $red = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255,65,70))
    $muted = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(205,185,190))

    $g.DrawString('LEVINCIA',$titleFont,$white,(New-Object System.Drawing.RectangleF(70,75,625,75)),$fmt)
    $g.DrawString('XSLAYER EDITION',$subFont,$red,(New-Object System.Drawing.RectangleF(70,150,625,38)),$fmt)

    # Login card area (background only; client fields/buttons will render over it).
    $panel = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(225,8,8,12))
    $g.FillRectangle($panel,205,215,355,175)
    $panel.Dispose()
    $panelPen = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(255,185,20,35),2)
    $g.DrawRectangle($panelPen,205,215,355,175)
    $panelPen.Dispose()

    $g.DrawString('WELCOME TO LEVINCIA',$subFont,$white,(New-Object System.Drawing.RectangleF(205,235,355,35)),$fmt)
    $g.DrawString('Custom progression • bosses • raids • wings',$smallFont,$muted,(New-Object System.Drawing.RectangleF(205,280,355,26)),$fmt)
    $g.DrawString('levincia-ps.com',$smallFont,$red,(New-Object System.Drawing.RectangleF(205,335,355,26)),$fmt)
    $g.DrawString('Created for Xslayer',$smallFont,$muted,(New-Object System.Drawing.RectangleF(0,468,765,20)),$fmt)

    $fmt.Dispose(); $titleFont.Dispose(); $subFont.Dispose(); $smallFont.Dispose()
    $white.Dispose(); $red.Dispose(); $muted.Dispose()

    $bmp.Save($loginPng,[System.Drawing.Imaging.ImageFormat]::Png)
}
finally {
    $g.Dispose()
    $bmp.Dispose()
}

if ((Test-Path -LiteralPath $liveLogin) -and !(Test-Path -LiteralPath $backup)) {
    Copy-Item -LiteralPath $liveLogin -Destination $backup -Force
    Write-Host "[BACKUP] $backup"
}

Copy-Item -LiteralPath $loginPng -Destination $liveLogin -Force

$hash = (Get-FileHash -LiteralPath $liveLogin -Algorithm SHA256).Hash
Write-Host ''
Write-Host '=== Levincia Xslayer FINAL Login Installer ==='
Write-Host "[OK] Generated new login art: $loginPng"
Write-Host "[OK] Installed to: $liveLogin"
Write-Host '[OK] Size: 765x503'
Write-Host "[OK] SHA256: $hash"
Write-Host ''
Write-Host 'This version has a large LEVINCIA / XSLAYER EDITION title and a red moon.'
Write-Host 'Completely close every client window, then start the client again.'
