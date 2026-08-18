$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$modelFile = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\world\Model.java'

if (!(Test-Path $modelFile)) {
    throw "Model.java not found: $modelFile"
}

$text = [System.IO.File]::ReadAllText($modelFile)

if ($text.Contains('[LEVINCIA PHASE MODEL]')) {
    Write-Host 'Phase model diagnostic is already installed.'
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
		String levinciaDecoder = "unknown";
		boolean levinciaPhaseModel = modelId == 22383 || modelId == 22382 || modelId == 22379;
		try {
			if (data[data.length - 1] == -1 && data[data.length - 2] == -1) {
				levinciaDecoder = "622";
				read622Model(data, modelId);
			} else {
				levinciaDecoder = "old";
				readOldModel(data);
			}

			if (levinciaPhaseModel) {
				int footerA = data.length >= 2 ? data[data.length - 2] & 0xff : -1;
				int footerB = data.length >= 1 ? data[data.length - 1] & 0xff : -1;
				System.out.println("[LEVINCIA PHASE MODEL] id=" + modelId
						+ " decoder=" + levinciaDecoder
						+ " bytes=" + data.length
						+ " footer=" + String.format("%02X %02X", footerA, footerB)
						+ " vertices=" + numberOfVerticeCoordinates
						+ " faces=" + anInt1630
						+ " textures=" + anInt1642
						+ " verticesX=" + (verticesXCoordinate == null ? "null" : verticesXCoordinate.length)
						+ " facesA=" + (faces_a == null ? "null" : faces_a.length)
						+ " faceColor=" + (face_color == null ? "null" : face_color.length));
			}
		} catch (Throwable t) {
			if (levinciaPhaseModel) {
				System.out.println("[LEVINCIA PHASE MODEL ERROR] id=" + modelId
						+ " decoder=" + levinciaDecoder
						+ " bytes=" + data.length
						+ " type=" + t.getClass().getName()
						+ " message=" + t.getMessage());
				t.printStackTrace();
			}
			throw t;
		}
'@

if (!$text.Contains($old)) {
    throw 'Could not find the original model decoder block. No file was changed.'
}

$backup = "$modelFile.before-phase-diagnostic"
if (!(Test-Path $backup)) {
    Copy-Item $modelFile $backup
    Write-Host "Backup created: $backup"
}

$text = $text.Replace($old, $new)
[System.IO.File]::WriteAllText($modelFile, $text, [System.Text.UTF8Encoding]::new($false))

Write-Host 'Levincia Phase model diagnostic installed successfully.'
Write-Host 'Tracing model IDs: 22383, 22382, 22379'
Write-Host 'Rebuild/run the client and send lines containing LEVINCIA PHASE MODEL.'
