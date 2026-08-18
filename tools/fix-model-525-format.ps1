$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$modelFile = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\world\Model.java'
$backup = "$modelFile.525-format-backup"

if (-not (Test-Path $modelFile)) {
    throw "Model.java not found: $modelFile"
}

$text = [System.IO.File]::ReadAllText($modelFile)

if ($text.Contains('read525Model(data, modelId);')) {
    Write-Host 'Model 525-format routing fix is already installed.'
    exit 0
}

$old = @'
		if (data[data.length - 1] == -1 && data[data.length - 2] == -1) {
			read622Model(data, modelId);
		} else {
			readOldModel(data);
		}
'@

$new = @'
		if (data[data.length - 1] == -1 && data[data.length - 2] == -1) {
			read622Model(data, modelId);
		} else if (data[data.length - 1] == -2 && data[data.length - 2] == -1) {
			read525Model(data, modelId);
		} else {
			readOldModel(data);
		}
'@

if (-not $text.Contains($old)) {
    throw 'Could not find the expected Model(byte[], int) decoder-routing block. No file was written.'
}

if (-not (Test-Path $backup)) {
    Copy-Item $modelFile $backup
    Write-Host "Backup created: $backup"
}

$text = $text.Replace($old, $new)
[System.IO.File]::WriteAllText($modelFile, $text, [System.Text.UTF8Encoding]::new($false))

Write-Host 'Levincia Model 525-format routing fix installed successfully.'
Write-Host 'FF FF models -> read622Model'
Write-Host 'FF FE models -> read525Model'
Write-Host 'Other models -> readOldModel'
