$ErrorActionPreference = 'Stop'

$path = Join-Path $PSScriptRoot '..\Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\world\Model.java'
$path = [System.IO.Path]::GetFullPath($path)

if (!(Test-Path $path)) {
    throw "Model.java not found: $path"
}

$text = [System.IO.File]::ReadAllText($path)

if ($text -match '\[LEVINCIA MODEL 22383\]') {
    Write-Host 'Model 22383 diagnostic is already installed.'
    exit 0
}

$old = @'
		if (data[data.length - 1] == -1 && data[data.length - 2] == -1) {
			read622Model(data, modelId);
		} else if (data[data.length - 1] == -2 && data[data.length - 2] == -1) {
			read525Model(data, modelId);
		} else {
			readOldModel(data);
		}
'@

$new = @'
		String levinciaDecoder;
		try {
			if (data[data.length - 1] == -1 && data[data.length - 2] == -1) {
				levinciaDecoder = "622";
				read622Model(data, modelId);
			} else if (data[data.length - 1] == -2 && data[data.length - 2] == -1) {
				levinciaDecoder = "525";
				read525Model(data, modelId);
			} else {
				levinciaDecoder = "old";
				readOldModel(data);
			}

			if (modelId == 22383) {
				System.out.println("[LEVINCIA MODEL 22383] decoder=" + levinciaDecoder
						+ " bytes=" + data.length
						+ " vertices=" + numberOfVerticeCoordinates
						+ " faces=" + anInt1630
						+ " textures=" + anInt1642
						+ " faceColor=" + (face_color == null ? "null" : face_color.length)
						+ " facesA=" + (faces_a == null ? "null" : faces_a.length)
						+ " verticesX=" + (verticesXCoordinate == null ? "null" : verticesXCoordinate.length));
			}
		} catch (Throwable t) {
			if (modelId == 22383) {
				System.out.println("[LEVINCIA MODEL 22383 ERROR] " + t.getClass().getName() + ": " + t.getMessage());
				t.printStackTrace();
			}
			throw t;
		}
'@

if (!$text.Contains($old)) {
    throw 'Could not find the expected FF FF / FF FE model-decoder block. Make sure fix-model-525-format.ps1 was applied first.'
}

$text = $text.Replace($old, $new)
[System.IO.File]::WriteAllText($path, $text)

Write-Host 'Levincia model 22383 decoder diagnostic installed successfully.'
Write-Host 'Rebuild/run the client and send lines containing: LEVINCIA MODEL 22383'
