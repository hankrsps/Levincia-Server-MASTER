$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$file = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\renderable\NPC.java'
$backup = "$file.model-trace-backup"

if (-not (Test-Path $file)) { throw "NPC.java not found: $file" }
$text = [IO.File]::ReadAllText($file)
if ($text.Contains('[LEVINCIA NPC MODEL]')) {
    Write-Host 'NPC model diagnostics are already installed.'
    exit 0
}
if (-not (Test-Path $backup)) {
    Copy-Item $file $backup
    Write-Host "Backup created: $backup"
}

$newline = if ($text.Contains("`r`n")) { "`r`n" } else { "`n" }

# Add a small global counter so the render trace does not flood the console forever.
$classNeedle = 'public final class NPC extends Entity {'
$classReplacement = $classNeedle + $newline + $newline + "`tprivate static int levinciaModelTraceCount = 0;"
if (-not $text.Contains($classNeedle)) { throw 'Could not find NPC class declaration.' }
$text = $text.Replace($classNeedle, $classReplacement)

$nullDefNeedle = @'
		if (definitionOverride == null) {
			return null;
		}
'@
$nullDefNeedle = $nullDefNeedle -replace "`r?`n", $newline
$nullDefReplacement = @'
		if (definitionOverride == null) {
			if (levinciaModelTraceCount < 100) {
				System.out.println("[LEVINCIA NPC MODEL] definition=null x=" + x + " y=" + y);
				levinciaModelTraceCount++;
			}
			return null;
		}
'@
$nullDefReplacement = $nullDefReplacement -replace "`r?`n", $newline
if (-not $text.Contains($nullDefNeedle)) { throw 'Could not find definitionOverride null block.' }
$text = $text.Replace($nullDefNeedle, $nullDefReplacement)

$modelNeedle = @'
		Model model = method450();

		if (model == null) {
			return null;
		}
'@
$modelNeedle = $modelNeedle -replace "`r?`n", $newline
$modelReplacement = @'
		Model model = method450();

		if (model == null) {
			if (levinciaModelTraceCount < 100) {
				System.out.println("[LEVINCIA NPC MODEL] model=null id=" + definitionOverride.id
						+ " name=" + definitionOverride.name + " x=" + x + " y=" + y);
				levinciaModelTraceCount++;
			}
			return null;
		}

		if (levinciaModelTraceCount < 100) {
			System.out.println("[LEVINCIA NPC MODEL] model=OK id=" + definitionOverride.id
					+ " name=" + definitionOverride.name + " x=" + x + " y=" + y
					+ " height=" + model.modelHeight);
			levinciaModelTraceCount++;
		}
'@
$modelReplacement = $modelReplacement -replace "`r?`n", $newline
if (-not $text.Contains($modelNeedle)) { throw 'Could not find NPC model creation block.' }
$text = $text.Replace($modelNeedle, $modelReplacement)

[IO.File]::WriteAllText($file, $text, [Text.UTF8Encoding]::new($false))
Write-Host 'Levincia client NPC model/render diagnostics installed successfully.'
Write-Host 'Rebuild/restart the client, log in once, then copy the [LEVINCIA NPC MODEL] lines.'