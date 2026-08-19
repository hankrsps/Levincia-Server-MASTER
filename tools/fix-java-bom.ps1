$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$roots = @(
    (Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java'),
    (Join-Path $repoRoot 'Levincia-Server\src\main\java')
) | Where-Object { Test-Path -LiteralPath $_ }

Write-Host ''
Write-Host '=== Levincia Java BOM Scanner/Fixer ==='
Write-Host ''

$fixed = @()
$clean = 0

foreach ($root in $roots) {
    Get-ChildItem -LiteralPath $root -Recurse -Filter '*.java' -File | ForEach-Object {
        $path = $_.FullName
        $bytes = [System.IO.File]::ReadAllBytes($path)
        if ($bytes.Length -ge 3 -and $bytes[0] -eq 0xEF -and $bytes[1] -eq 0xBB -and $bytes[2] -eq 0xBF) {
            $backup = "$path.bom-backup"
            if (!(Test-Path -LiteralPath $backup)) {
                Copy-Item -LiteralPath $path -Destination $backup -Force
            }
            $text = [System.Text.Encoding]::UTF8.GetString($bytes, 3, $bytes.Length - 3)
            [System.IO.File]::WriteAllText($path, $text, (New-Object System.Text.UTF8Encoding($false)))
            $fixed += $path
            Write-Host "[FIXED] $path"
        } else {
            $clean++
        }
    }
}

Write-Host ''
if ($fixed.Count -eq 0) {
    Write-Host '[OK] No UTF-8 BOM was found in Java source files.'
} else {
    Write-Host "[OK] Removed UTF-8 BOM from $($fixed.Count) Java file(s)."
}
Write-Host "Clean Java files checked: $clean"
Write-Host ''
Write-Host 'NEXT:'
Write-Host '1. Rebuild the client/server.'
Write-Host '2. If javac still reports illegal character \ufeff, paste the FULL compiler line that includes the Java file path and line number.'
