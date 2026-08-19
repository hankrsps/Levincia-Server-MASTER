$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$itemsPath = Join-Path $repoRoot 'Levincia-Server\data\def\txt\items.txt'
$stamp = Get-Date -Format 'yyyyMMdd-HHmmss'

if (!(Test-Path -LiteralPath $itemsPath)) {
    throw "Server item definitions not found: $itemsPath"
}

$text = [System.IO.File]::ReadAllText($itemsPath)
$backup = "$itemsPath.angel-wings-slot-backup-$stamp"
Copy-Item -LiteralPath $itemsPath -Destination $backup -Force

# Remove any existing 22640 block so the definition is deterministic.
$pattern = '(?ms)^Item id:\s*22640\s*\r?\n.*?^finish\s*\r?\n?'
$text = [regex]::Replace($text, $pattern, '')

$block = @"
Item id: 22640
Name: Angel Wings
Examine: A pair of celestial wings.
Value: 0
Stackable: false
Noted: false
Double-handed: false
Equipment type: CAPE
Is weapon: false
finish
"@

if (-not $text.EndsWith("`n")) { $text += "`r`n" }
$text += $block

[System.IO.File]::WriteAllText($itemsPath, $text, (New-Object System.Text.UTF8Encoding($false)))

Write-Host ''
Write-Host '=== Levincia Angel Wings Slot Fix ==='
Write-Host '[OK] Item 22640 is now Equipment type: CAPE'
Write-Host '[OK] Item 22640 is now Is weapon: false'
Write-Host "[BACKUP] $backup"
Write-Host ''
Write-Host 'Restart/rebuild the SERVER, then respawn/equip item 22640.'
Write-Host 'If the slot is fixed but the model is still invisible, report whether the inventory icon is visible and whether client startup mentions repacking model 100500.'
