$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$modelFile = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\world\Model.java'

if (!(Test-Path $modelFile)) {
    throw "Model.java not found: $modelFile"
}

$text = [System.IO.File]::ReadAllText($modelFile)

if ($text.Contains('private void readType2PhaseModel(byte[] data, int modelId)')) {
    Write-Host 'Type2 Phase decoder is already installed.'
    exit 0
}

$backup = "$modelFile.before-type2-phase-decoder"
if (!(Test-Path $backup)) {
    Copy-Item $modelFile $backup
    Write-Host "Backup created: $backup"
}

# Replace the temporary forced-622 route from test-phase-model-622.ps1.
$oldRoute = @'
			} else if (levinciaPhaseModel) {
				levinciaDecoder = "622-phase-test";
				read622Model(data, modelId);
			} else {
'@

$newRoute = @'
			} else if (levinciaPhaseModel && data.length >= 2
					&& data[data.length - 2] == -1 && data[data.length - 1] == -2) {
				levinciaDecoder = "type2-fffe";
				readType2PhaseModel(data, modelId);
			} else {
'@

if ($text.Contains($oldRoute)) {
    $text = $text.Replace($oldRoute, $newRoute)
} else {
    # Also support the diagnostic state before the forced-622 experiment.
    $oldRoute2 = @'
			} else {
				levinciaDecoder = "old";
				readOldModel(data);
			}
'@
    $newRoute2 = @'
			} else if (levinciaPhaseModel && data.length >= 2
					&& data[data.length - 2] == -1 && data[data.length - 1] == -2) {
				levinciaDecoder = "type2-fffe";
				readType2PhaseModel(data, modelId);
			} else {
				levinciaDecoder = "old";
				readOldModel(data);
			}
'@
    if ($text.Contains($oldRoute2)) {
        $text = $text.Replace($oldRoute2, $newRoute2)
    } else {
        throw 'Could not find the Phase decoder routing block in Model.java. No changes were written.'
    }
}

$anchor = "`tprivate void read525Model(byte abyte0[], int modelID) {"
if (!$text.Contains($anchor)) {
    throw 'Could not find read525Model() insertion point. No changes were written.'
}

# This decoder implements the FF FE / Type2 layout used by models 22383, 22382, and 22379.
# These three models have zero texture triangles, so this intentionally rejects textured Type2 models
# rather than guessing at rendering semantics used elsewhere in this older client.
$method = @'
	private void readType2PhaseModel(byte[] data, int modelId) {
		if (data == null || data.length < 23) {
			throw new IllegalArgumentException("Type2 model too short: " + modelId);
		}

		ByteBuffer footer = new ByteBuffer(data);
		footer.position = data.length - 23;

		int vertexCount = footer.getUnsignedShort();
		int faceCount = footer.getUnsignedShort();
		int textureCount = footer.getUnsignedByte();
		int hasFaceInfo = footer.getUnsignedByte();
		int priorityFlag = footer.getUnsignedByte();
		int alphaFlag = footer.getUnsignedByte();
		int faceSkinFlag = footer.getUnsignedByte();
		int vertexSkinFlag = footer.getUnsignedByte();
		int animayaFlag = footer.getUnsignedByte();
		int xDataLength = footer.getUnsignedShort();
		int yDataLength = footer.getUnsignedShort();
		int zDataLength = footer.getUnsignedShort();
		int faceIndexDataLength = footer.getUnsignedShort();
		int vertexSkinDataLength = footer.getUnsignedShort();

		if (textureCount != 0) {
			throw new IllegalArgumentException("Levincia Type2 Phase decoder expected 0 texture triangles for model "
					+ modelId + " but found " + textureCount);
		}
		if (hasFaceInfo != 0) {
			throw new IllegalArgumentException("Levincia Type2 Phase decoder expected no face-info stream for model "
					+ modelId + " but flag was " + hasFaceInfo);
		}
		if (animayaFlag != 0) {
			throw new IllegalArgumentException("Levincia Type2 Phase decoder does not support animaya groups for model "
					+ modelId + " (flag=" + animayaFlag + ")");
		}

		int offset = 0;
		int vertexFlagsOffset = offset;
		offset += vertexCount;

		int faceIndexTypesOffset = offset;
		offset += faceCount;

		int prioritiesOffset = offset;
		if (priorityFlag == 255) {
			offset += faceCount;
		}

		int faceSkinsOffset = offset;
		if (faceSkinFlag == 1) {
			offset += faceCount;
		}

		int faceInfoOffset = offset;
		if (hasFaceInfo == 1) {
			offset += faceCount;
		}

		int vertexSkinsOffset = offset;
		offset += vertexSkinDataLength;

		int alphaOffset = offset;
		if (alphaFlag == 1) {
			offset += faceCount;
		}

		int faceIndexDataOffset = offset;
		offset += faceIndexDataLength;

		int faceColorsOffset = offset;
		offset += faceCount * 2;

		int textureTrianglesOffset = offset;
		offset += textureCount * 6;

		int xDataOffset = offset;
		offset += xDataLength;
		int yDataOffset = offset;
		offset += yDataLength;
		int zDataOffset = offset;
		offset += zDataLength;

		int footerOffset = data.length - 23;
		if (offset != footerOffset) {
			throw new IllegalArgumentException("Type2 layout mismatch for model " + modelId
					+ ": decoded data ends at " + offset + " but footer starts at " + footerOffset);
		}

		ByteBuffer vertexFlags = new ByteBuffer(data);
		ByteBuffer xData = new ByteBuffer(data);
		ByteBuffer yData = new ByteBuffer(data);
		ByteBuffer zData = new ByteBuffer(data);
		ByteBuffer vertexSkins = new ByteBuffer(data);
		vertexFlags.position = vertexFlagsOffset;
		xData.position = xDataOffset;
		yData.position = yDataOffset;
		zData.position = zDataOffset;
		vertexSkins.position = vertexSkinsOffset;

		verticesParticle = new int[vertexCount];
		verticesXCoordinate = new int[vertexCount];
		verticesYCoordinate = new int[vertexCount];
		verticesZCoordinate = new int[vertexCount];
		faces_a = new int[faceCount];
		faces_b = new int[faceCount];
		faces_c = new int[faceCount];
		face_color = new int[faceCount];
		face_render_type = null;
		texture_face_x = null;
		texture_face_y = null;
		texture_face_z = null;

		anIntArray1655 = vertexSkinFlag == 1 ? new int[vertexCount] : null;
		anIntArray1656 = faceSkinFlag == 1 ? new int[faceCount] : null;
		faces_alpha = alphaFlag == 1 ? new int[faceCount] : null;
		face_render_priorities = new int[faceCount];

		int lastX = 0;
		int lastY = 0;
		int lastZ = 0;
		for (int v = 0; v < vertexCount; v++) {
			int flags = vertexFlags.getUnsignedByte();
			int dx = (flags & 1) != 0 ? xData.method421() : 0;
			int dy = (flags & 2) != 0 ? yData.method421() : 0;
			int dz = (flags & 4) != 0 ? zData.method421() : 0;

			lastX += dx;
			lastY += dy;
			lastZ += dz;
			verticesXCoordinate[v] = lastX;
			verticesYCoordinate[v] = lastY;
			verticesZCoordinate[v] = lastZ;

			if (anIntArray1655 != null) {
				anIntArray1655[v] = vertexSkins.getUnsignedByte();
			}
		}

		ByteBuffer colors = new ByteBuffer(data);
		ByteBuffer priorities = new ByteBuffer(data);
		ByteBuffer alpha = new ByteBuffer(data);
		ByteBuffer faceSkins = new ByteBuffer(data);
		colors.position = faceColorsOffset;
		priorities.position = prioritiesOffset;
		alpha.position = alphaOffset;
		faceSkins.position = faceSkinsOffset;

		for (int f = 0; f < faceCount; f++) {
			face_color[f] = colors.getUnsignedShort();
			face_render_priorities[f] = priorityFlag == 255 ? priorities.getSignedByte() : priorityFlag;
			if (faces_alpha != null) {
				int a = alpha.getSignedByte();
				faces_alpha[f] = a < 0 ? a + 256 : a;
			}
			if (anIntArray1656 != null) {
				anIntArray1656[f] = faceSkins.getUnsignedByte();
			}
		}

		ByteBuffer faceIndexData = new ByteBuffer(data);
		ByteBuffer faceIndexTypes = new ByteBuffer(data);
		faceIndexData.position = faceIndexDataOffset;
		faceIndexTypes.position = faceIndexTypesOffset;

		int a = 0;
		int b = 0;
		int c = 0;
		int last = 0;
		for (int f = 0; f < faceCount; f++) {
			int type = faceIndexTypes.getUnsignedByte();
			if (type == 1) {
				a = faceIndexData.method421() + last;
				last = a;
				b = faceIndexData.method421() + last;
				last = b;
				c = faceIndexData.method421() + last;
				last = c;
			} else if (type == 2) {
				b = c;
				c = faceIndexData.method421() + last;
				last = c;
			} else if (type == 3) {
				a = c;
				c = faceIndexData.method421() + last;
				last = c;
			} else if (type == 4) {
				int swap = a;
				a = b;
				b = swap;
				c = faceIndexData.method421() + last;
				last = c;
			} else {
				throw new IllegalArgumentException("Unknown Type2 face index type " + type
						+ " in model " + modelId + " face " + f);
			}

			faces_a[f] = a;
			faces_b[f] = b;
			faces_c[f] = c;
		}

		numberOfVerticeCoordinates = vertexCount;
		anInt1630 = faceCount;
		anInt1642 = textureCount;

		System.out.println("[LEVINCIA TYPE2 OK] id=" + modelId
				+ " vertices=" + vertexCount
				+ " faces=" + faceCount
				+ " textures=" + textureCount
				+ " priorityFlag=" + priorityFlag
				+ " faceSkin=" + faceSkinFlag
				+ " vertexSkin=" + vertexSkinFlag);
	}

'@

$text = $text.Replace($anchor, $method + $anchor)
[System.IO.File]::WriteAllText($modelFile, $text, [System.Text.UTF8Encoding]::new($false))

Write-Host 'Levincia FF FE / Type2 Phase decoder installed successfully.'
Write-Host 'Models 22383, 22382, and 22379 will use readType2PhaseModel().' 
Write-Host 'This decoder intentionally handles the untextured Type2 layout used by these three Phase models only.'
Write-Host 'Rebuild/run the client and look for [LEVINCIA TYPE2 OK] or [LEVINCIA PHASE MODEL ERROR].'
