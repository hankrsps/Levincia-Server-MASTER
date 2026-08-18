$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$file = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\Client.java'
$backup = "$file.npc-state-backup"

if (-not (Test-Path $file)) { throw "Client.java not found: $file" }
$text = [IO.File]::ReadAllText($file)
if ($text.Contains('[LEVINCIA NPC STATE]')) {
    Write-Host 'NPC local-state trace is already installed.'
    exit 0
}
if (-not (Test-Path $backup)) {
    Copy-Item $file $backup
    Write-Host "Backup created: $backup"
}

$newline = if ($text.Contains("`r`n")) { "`r`n" } else { "`n" }

# Find the case 65 block and insert diagnostics after its NPC update call.
$caseStart = $text.IndexOf('case 65:')
if ($caseStart -lt 0) { throw 'Could not find case 65 in Client.java.' }
$nextCase = $text.IndexOf('case ', $caseStart + 8)
if ($nextCase -lt 0) { throw 'Could not find the case following case 65.' }
$block = $text.Substring($caseStart, $nextCase - $caseStart)

$patterns = @(
    'updateNPCs\s*\([^;]+\);',
    'updateNpcs\s*\([^;]+\);',
    'updateNPCs\s*\([^;]+\)\s*;'
)
$match = $null
foreach ($p in $patterns) {
    $m = [regex]::Match($block, $p)
    if ($m.Success) { $match = $m; break }
}
if ($null -eq $match) {
    throw 'Could not find the NPC decoder call inside case 65. No file was written.'
}

$insertAt = $caseStart + $match.Index + $match.Length
$diag = @'

                    System.out.println("[LEVINCIA NPC STATE] npcCount=" + npcCount + " plane=" + plane);
                    for (int levinciaNpcDebug = 0; levinciaNpcDebug < npcCount && levinciaNpcDebug < 20; levinciaNpcDebug++) {
                        int levinciaNpcIndex = npcIndices[levinciaNpcDebug];
                        NPC levinciaNpc = npcArray[levinciaNpcIndex];
                        if (levinciaNpc == null) {
                            System.out.println("[LEVINCIA NPC ENTRY] slot=" + levinciaNpcDebug + " index=" + levinciaNpcIndex + " null=true");
                        } else {
                            System.out.println("[LEVINCIA NPC ENTRY] slot=" + levinciaNpcDebug + " index=" + levinciaNpcIndex
                                    + " x=" + levinciaNpc.x + " y=" + levinciaNpc.y);
                        }
                    }
'@
$diag = $diag -replace "`r?`n", $newline
$text = $text.Substring(0, $insertAt) + $diag + $text.Substring($insertAt)

[IO.File]::WriteAllText($file, $text, [Text.UTF8Encoding]::new($false))
Write-Host 'Levincia client NPC local-state trace installed successfully.'
Write-Host 'Rebuild/restart the client, log in once, then copy [LEVINCIA NPC STATE] and [LEVINCIA NPC ENTRY] lines.'