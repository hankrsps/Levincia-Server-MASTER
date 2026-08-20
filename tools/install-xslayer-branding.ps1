$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$outDir = Join-Path $repoRoot 'custom-assets\branding\xslayer'
$cacheDir = Join-Path $env:USERPROFILE '.Levincia'
$loginPng = Join-Path $outDir 'levincia-xslayer-login.png'
$loadingPng = Join-Path $outDir 'levincia-xslayer-loading.png'
$liveLogin = Join-Path $cacheDir 'levincia_login.png'
$backup = Join-Path $cacheDir 'levincia_login.pre-xslayer-red-backup.png'

New-Item -ItemType Directory -Force -Path $outDir | Out-Null
New-Item -ItemType Directory -Force -Path $cacheDir | Out-Null
Add-Type -AssemblyName System.Drawing

function New-LevinciaRedScreen {
    param([string]$Path,[bool]$Loading=$false)
    $w=765; $h=503
    $bmp=New-Object System.Drawing.Bitmap($w,$h)
    $g=[System.Drawing.Graphics]::FromImage($bmp)
    try {
        $g.SmoothingMode=[System.Drawing.Drawing2D.SmoothingMode]::AntiAlias
        $g.TextRenderingHint=[System.Drawing.Text.TextRenderingHint]::AntiAliasGridFit
        $rect=New-Object System.Drawing.Rectangle(0,0,$w,$h)
        $bg=New-Object System.Drawing.Drawing2D.LinearGradientBrush($rect,[System.Drawing.Color]::FromArgb(7,7,10),[System.Drawing.Color]::FromArgb(92,4,12),25)
        $g.FillRectangle($bg,$rect); $bg.Dispose()

        # Red moon / glow.
        foreach($r in @(250,205,160,115)) {
            $a=[Math]::Max(10,55-[int]($r/6))
            $b=New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb($a,255,22,36))
            $g.FillEllipse($b,520-[int]($r/2),35-[int]($r/5),$r,$r); $b.Dispose()
        }
        # Gothic horizon silhouettes.
        $sil=New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(220,5,5,8))
        $g.FillRectangle($sil,0,390,765,113)
        foreach($x in @(25,85,145,590,645,705)) {
            $height=70+(($x*7)%90)
            $g.FillRectangle($sil,$x,390-$height,34,$height)
            $pts=@((New-Object System.Drawing.Point($x-6,390-$height)),(New-Object System.Drawing.Point($x+17,355-$height)),(New-Object System.Drawing.Point($x+40,390-$height)))
            $g.FillPolygon($sil,$pts)
        }
        $sil.Dispose()

        # Crimson frame and center panel.
        $frame=New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(210,215,25,35),3)
        $g.DrawRectangle($frame,7,7,750,488); $frame.Dispose()
        $panel=New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(215,8,8,11))
        $g.FillRectangle($panel,175,120,415,265); $panel.Dispose()
        $panelPen=New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(220,190,25,35),2)
        $g.DrawRectangle($panelPen,175,120,415,265); $panelPen.Dispose()

        $fmt=New-Object System.Drawing.StringFormat; $fmt.Alignment=[System.Drawing.StringAlignment]::Center
        $title=New-Object System.Drawing.Font('Georgia',42,[System.Drawing.FontStyle]::Bold)
        $sub=New-Object System.Drawing.Font('Segoe UI',14,[System.Drawing.FontStyle]::Bold)
        $small=New-Object System.Drawing.Font('Segoe UI',10,[System.Drawing.FontStyle]::Regular)
        $white=New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(245,238,238))
        $red=New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(245,55,62))
        $muted=New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(185,175,180))
        $g.DrawString('LEVINCIA',$title,$white,(New-Object System.Drawing.RectangleF(175,145,415,62)),$fmt)
        $g.DrawString('XSLAYER EDITION',$sub,$red,(New-Object System.Drawing.RectangleF(175,207,415,28)),$fmt)
        if($Loading) {
            $g.DrawString('PREPARING YOUR ADVENTURE',$sub,$white,(New-Object System.Drawing.RectangleF(175,260,415,28)),$fmt)
            $g.DrawString('Loading custom content...',$small,$muted,(New-Object System.Drawing.RectangleF(175,300,415,22)),$fmt)
            $barBack=New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255,35,20,22)); $g.FillRectangle($barBack,230,340,305,12); $barBack.Dispose()
            $bar=New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255,205,25,35)); $g.FillRectangle($bar,232,342,185,8); $bar.Dispose()
        } else {
            $g.DrawString('ENTER THE REALM',$sub,$white,(New-Object System.Drawing.RectangleF(175,258,415,28)),$fmt)
            $g.DrawString('Custom progression  •  bosses  •  wings  •  raids',$small,$muted,(New-Object System.Drawing.RectangleF(175,300,415,22)),$fmt)
            $g.DrawString('levincia-ps.com',$small,$red,(New-Object System.Drawing.RectangleF(175,342,415,22)),$fmt)
        }
        $g.DrawString('Created for Xslayer',$small,$muted,(New-Object System.Drawing.RectangleF(0,468,765,20)),$fmt)
        $fmt.Dispose();$title.Dispose();$sub.Dispose();$small.Dispose();$white.Dispose();$red.Dispose();$muted.Dispose()
        $bmp.Save($Path,[System.Drawing.Imaging.ImageFormat]::Png)
    } finally {$g.Dispose();$bmp.Dispose()}
}

Write-Host ''
Write-Host '=== Levincia Xslayer RED Login Installer ==='
New-LevinciaRedScreen -Path $loginPng
New-LevinciaRedScreen -Path $loadingPng -Loading $true

if((Test-Path -LiteralPath $liveLogin) -and !(Test-Path -LiteralPath $backup)) {
    Copy-Item -LiteralPath $liveLogin -Destination $backup -Force
    Write-Host "[BACKUP] $backup"
}
Copy-Item -LiteralPath $loginPng -Destination $liveLogin -Force

Write-Host "[OK] Generated: $loginPng"
Write-Host "[OK] Installed directly to: $liveLogin"
Write-Host "[OK] Size: 765x503"
Write-Host ''
Write-Host 'Completely close and restart the client now.'
