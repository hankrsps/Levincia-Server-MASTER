$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$modelFile = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\world\Model.java'

if (!(Test-Path $modelFile)) {
    throw "Model.java not found: $modelFile"
}

$text = [System.IO.File]::ReadAllText($modelFile)

if ($text.Contains('levinciaDecoder = "622-phase-test"')) {
    Write-Host 'Phase 622 decoder test is already installed.'
    exit 0
}

$old = @'
			if (data[data.length - 1] == -1 && data[data.length - 2] == -1) {
				levinciaDecoder = "622";
				read622Model(data, modelId);
			} else {
				levinciaDecoder = "old";
				readOldModel(data);
			}
'@

$new = @'
			if (data[data.length - 1] == -1 && data[data.length - 2] == -1) {
				levinciaDecoder = "622";
				read622Model(data, modelId);
			} else if (levinciaPhaseModel) {
				levinciaDecoder = "622-phase-test";
				read622Model(data, modelId);
			} else {
				levinciaDecoder = "old";
				readOldModel(data);
			}
'@

if (!$text.Contains($old)) {
    throw 'Could not find the installed Phase diagnostic decoder block. Run trace-phase-model-decode.ps1 first, then retry.'
}

$backup = "$modelFile.before-phase-622-test"
if (!(Test-Path $backup)) {
    Copy-Item $modelFile $backup
    Write-Host "Backup created: $backup"
}

$text = $text.Replace($old, $new)
[System.IO.File]::WriteAllText($modelFile, $text, [System.Text.UTF8Encoding]::new($false))

Write-Host 'Levincia Phase 622 decoder test installed successfully.'
Write-Host 'Models 22383, 22382, and 22379 will now be routed through read622Model().' 
Write-Host 'All other model routing is unchanged.'
Write-Host 'Rebuild/run the client and send lines containing LEVINCIA PHASE MODEL.'
