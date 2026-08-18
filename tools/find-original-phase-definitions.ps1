$ErrorActionPreference = 'Stop'

$roots = @(
    'C:\Users\Becca\Downloads',
    'C:\Users\Becca\IdeaProjects'
)

$patterns = @(
    'Phase [1]', 'Phase [2]', 'Phase [3]', 'Phase [4]', 'Phase [5]', 'Phase [6]',
    '22383', '22382', '22379', '16349', '16351', '16352'
)

$extensions = @('.java','.kt','.json','.cfg','.txt','.xml','.ini','.properties','.yaml','.yml','.cs')
$out = 'C:\Users\Becca\.Levincia\phase-definition-search.txt'

Write-Host ''
Write-Host '=== Searching local source trees for original Phase NPC definitions ==='
Write-Host 'This may take a little while.'
Write-Host ''

$results = New-Object System.Collections.Generic.List[object]

foreach ($root in $roots) {
    if (!(Test-Path $root)) { continue }

    Get-ChildItem $root -Recurse -File -ErrorAction SilentlyContinue |
        Where-Object {
            $extensions -contains $_.Extension.ToLower() -and
            $_.Length -lt 20MB -and
            $_.FullName -notmatch '\\target\\|\\build\\|\\\.git\\|\\node_modules\\|\\\.m2\\'
        } |
        ForEach-Object {
            $file = $_
            foreach ($pattern in $patterns) {
                try {
                    $matches = Select-String -LiteralPath $file.FullName -SimpleMatch -Pattern $pattern -Context 8,18 -ErrorAction SilentlyContinue
                    foreach ($m in $matches) {
                        $context = @()
                        foreach ($pre in $m.Context.PreContext) { $context += $pre }
                        $context += $m.Line
                        foreach ($post in $m.Context.PostContext) { $context += $post }

                        $results.Add([PSCustomObject]@{
                            Pattern = $pattern
                            Path = $file.FullName
                            Line = $m.LineNumber
                            Context = ($context -join "`r`n")
                        })
                    }
                } catch { }
            }
        }
}

# De-duplicate overlapping matches from the same file/area.
$unique = $results |
    Sort-Object Path, Line, Pattern |
    Group-Object { "{0}|{1}" -f $_.Path, ([Math]::Floor($_.Line / 10)) } |
    ForEach-Object { $_.Group | Select-Object -First 1 }

$sb = New-Object System.Text.StringBuilder
[void]$sb.AppendLine('=== LEVINCIA PHASE DEFINITION SEARCH ===')
[void]$sb.AppendLine("Generated: $(Get-Date -Format 'yyyy-MM-dd HH:mm:ss')")
[void]$sb.AppendLine('')

if (!$unique -or $unique.Count -eq 0) {
    [void]$sb.AppendLine('NO MATCHES FOUND')
} else {
    foreach ($r in $unique) {
        [void]$sb.AppendLine('============================================================')
        [void]$sb.AppendLine("MATCH: $($r.Pattern)")
        [void]$sb.AppendLine("FILE : $($r.Path)")
        [void]$sb.AppendLine("LINE : $($r.Line)")
        [void]$sb.AppendLine('------------------------------------------------------------')
        [void]$sb.AppendLine($r.Context)
        [void]$sb.AppendLine('')
    }
}

[System.IO.File]::WriteAllText($out, $sb.ToString(), [System.Text.UTF8Encoding]::new($false))

Write-Host "Matches found: $($unique.Count)"
Write-Host "Saved full report to: $out"
Write-Host ''
Write-Host 'Top matching source files:'
$unique |
    Group-Object Path |
    Sort-Object Count -Descending |
    Select-Object -First 25 Count, Name |
    Format-Table -AutoSize

Write-Host ''
Write-Host 'NEXT: paste the Top matching source files table here.'
Write-Host 'If one looks like an older/full client source, we will inspect that exact file next.'
