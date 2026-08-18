$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$file = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\renderable\NPC.java'
$backup = "$file.model-id-trace-backup"

if (-not (Test-Path $file)) { throw "NPC.java not found: $file" }
$text = [IO.File]::ReadAllText($file)
if ($text.Contains('[LEVINCIA NPC MODEL IDS]')) {
    Write-Host 'NPC model ID trace is already installed.'
    exit 0
}
if (-not (Test-Path $backup)) {
    Copy-Item $file $backup
    Write-Host "Backup created: $backup"
}

$newline = if ($text.Contains("`r`n")) { "`r`n" } else { "`n" }
$needle = "`t`tModel model = method450();"
$idx = $text.IndexOf($needle)
if ($idx -lt 0) { throw 'Could not find Model model = method450(); in NPC.java.' }

$diag = @'

		if (model == null) {
			StringBuilder levinciaModels = new StringBuilder();
			if (definitionOverride.npcModels == null) {
				levinciaModels.append("null");
			} else {
				for (int i = 0; i < definitionOverride.npcModels.length; i++) {
					if (i > 0) levinciaModels.append(',');
					levinciaModels.append(definitionOverride.npcModels[i]);
				}
			}
			System.out.println("[LEVINCIA NPC MODEL IDS] id=" + definitionOverride.id
					+ " name=" + definitionOverride.name
					+ " models=" + levinciaModels);
		}
'@
$diag = $diag -replace "`r?`n", $newline
$insertAt = $idx + $needle.Length
$text = $text.Substring(0, $insertAt) + $diag + $text.Substring($insertAt)

[IO.File]::WriteAllText($file, $text, [Text.UTF8Encoding]::new($false))
Write-Host 'Levincia client NPC model ID trace installed successfully.'
Write-Host 'Rebuild/restart the client, log in once, then copy [LEVINCIA NPC MODEL IDS] lines.'