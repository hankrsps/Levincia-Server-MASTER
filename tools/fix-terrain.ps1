$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$clientPath = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\Client.java'

if (-not (Test-Path $clientPath)) {
    throw "Client.java not found at: $clientPath"
}

$text = [System.IO.File]::ReadAllText($clientPath)
$backup = "$clientPath.terrain-backup"

if (-not (Test-Path $backup)) {
    [System.IO.File]::Copy($clientPath, $backup)
    Write-Host "Backup created: $backup"
}

$helperAnchor = "    private int getMapLoadingState() {"
$helper = @'
    private byte[] loadLevinciaMapDirect(int fileId) {
        try {
            if (fileId < 0 || decompressors == null || decompressors.length <= 4 || decompressors[4] == null) {
                return null;
            }
            byte[] packed = decompressors[4].decompress(fileId);
            if (packed == null) {
                System.out.println("[LEVINCIA MAP DIRECT] idx4 file not found: " + fileId);
                return null;
            }
            try (java.util.zip.GZIPInputStream gzip = new java.util.zip.GZIPInputStream(new ByteArrayInputStream(packed));
                 ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                byte[] buffer = new byte[8192];
                int read;
                while ((read = gzip.read(buffer)) != -1) {
                    out.write(buffer, 0, read);
                }
                byte[] decoded = out.toByteArray();
                System.out.println("[LEVINCIA MAP DIRECT] loaded idx4 file=" + fileId + " bytes=" + decoded.length);
                return decoded;
            }
        } catch (Exception e) {
            System.out.println("[LEVINCIA MAP DIRECT] failed file=" + fileId + " - " + e.getClass().getSimpleName() + ": " + e.getMessage());
            return null;
        }
    }

'@

if ($text -notmatch 'private byte\[\] loadLevinciaMapDirect\(int fileId\)') {
    if (-not $text.Contains($helperAnchor)) {
        throw 'Could not find getMapLoadingState(). No changes were made.'
    }
    $text = $text.Replace($helperAnchor, $helper + $helperAnchor)
}

$oldTerrain = @'
            if (terrainData[i] == null && floorMap[i] != -1) {
                levinciaLoadDebug("WAITING FOR TERRAIN: slot=" + i
                        + " file=" + floorMap[i]
                        + " mapCoord=" + mapCoordinates[i]);
                return -1;
            }
'@

$newTerrain = @'
            if (terrainData[i] == null && floorMap[i] != -1) {
                terrainData[i] = loadLevinciaMapDirect(floorMap[i]);
                if (terrainData[i] == null) {
                    levinciaLoadDebug("WAITING FOR TERRAIN: slot=" + i
                            + " file=" + floorMap[i]
                            + " mapCoord=" + mapCoordinates[i]);
                    return -1;
                }
            }
'@

if (-not $text.Contains('terrainData[i] = loadLevinciaMapDirect(floorMap[i]);')) {
    if (-not $text.Contains($oldTerrain)) {
        throw 'Could not find the terrain wait block. No file was written.'
    }
    $text = $text.Replace($oldTerrain, $newTerrain)
}

$oldObject = @'
            if (objectData[i] == null && objectMap[i] != -1) {
                levinciaLoadDebug("WAITING FOR OBJECT MAP: slot=" + i
                        + " file=" + objectMap[i]
                        + " mapCoord=" + mapCoordinates[i]);
                return -2;
            }
'@

$newObject = @'
            if (objectData[i] == null && objectMap[i] != -1) {
                objectData[i] = loadLevinciaMapDirect(objectMap[i]);
                if (objectData[i] == null) {
                    levinciaLoadDebug("WAITING FOR OBJECT MAP: slot=" + i
                            + " file=" + objectMap[i]
                            + " mapCoord=" + mapCoordinates[i]);
                    return -2;
                }
            }
'@

if (-not $text.Contains('objectData[i] = loadLevinciaMapDirect(objectMap[i]);')) {
    if (-not $text.Contains($oldObject)) {
        throw 'Could not find the object-map wait block. No file was written.'
    }
    $text = $text.Replace($oldObject, $newObject)
}

$utf8NoBom = New-Object System.Text.UTF8Encoding($false)
[System.IO.File]::WriteAllText($clientPath, $text, $utf8NoBom)

Write-Host ''
Write-Host 'Levincia terrain repair applied successfully.'
Write-Host 'Client.java now loads terrain/object maps directly from main_file_cache.idx4.'
Write-Host 'Next: Maven clean -> compile -> run the client.'
