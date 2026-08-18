$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$modelFile = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\world\Model.java'
$sourceCache = 'C:\Users\Becca\IdeaProjects\Levincia.2\Levincia.2.0\game-client\Cache'
$sourceIdx = Join-Path $sourceCache 'main_file_cache.idx1'
$sourceDat = Join-Path $sourceCache 'main_file_cache.dat'
$targetDir = 'C:\Users\Becca\.Levincia\index1'
$models = @(22383,22382,22379)

function Read-Medium {
    param([byte[]]$Bytes,[int]$Offset)
    return ((($Bytes[$Offset] -band 255) -shl 16) -bor (($Bytes[$Offset+1] -band 255) -shl 8) -bor ($Bytes[$Offset+2] -band 255))
}

function Extract-CacheEntry {
    param([int]$FileId,[string]$OutputPath)

    $idx = [System.IO.File]::Open($sourceIdx,[System.IO.FileMode]::Open,[System.IO.FileAccess]::Read,[System.IO.FileShare]::ReadWrite)
    $dat = [System.IO.File]::Open($sourceDat,[System.IO.FileMode]::Open,[System.IO.FileAccess]::Read,[System.IO.FileShare]::ReadWrite)
    try {
        $idxOffset = $FileId * 6
        if ($idxOffset + 6 -gt $idx.Length) { throw "IDX entry for $FileId is outside the file." }
        $idx.Seek($idxOffset,[System.IO.SeekOrigin]::Begin) | Out-Null
        $entry = New-Object byte[] 6
        if ($idx.Read($entry,0,6) -ne 6) { throw "Unable to read IDX entry for $FileId." }

        $length = Read-Medium $entry 0
        $sector = Read-Medium $entry 3
        if ($length -le 0 -or $sector -le 0) { throw "Model $FileId has an empty cache entry." }

        $result = New-Object System.IO.MemoryStream
        $remaining = $length
        $chunk = 0
        try {
            while ($remaining -gt 0) {
                $sectorOffset = [int64]$sector * 520
                if ($sectorOffset + 8 -gt $dat.Length) { throw "Sector $sector for model $FileId is outside DAT." }
                $dat.Seek($sectorOffset,[System.IO.SeekOrigin]::Begin) | Out-Null

                $header = New-Object byte[] 8
                if ($dat.Read($header,0,8) -ne 8) { throw "Unable to read sector header for model $FileId." }

                $headerFile = (($header[0] -band 255) -shl 8) -bor ($header[1] -band 255)
                $headerChunk = (($header[2] -band 255) -shl 8) -bor ($header[3] -band 255)
                $nextSector = Read-Medium $header 4
                $indexId = $header[7] -band 255

                if ($headerFile -ne $FileId) { throw "Unexpected file id $headerFile in sector $sector; expected $FileId." }
                if ($headerChunk -ne $chunk) { throw "Unexpected chunk $headerChunk for $FileId; expected $chunk." }
                if ($indexId -ne 2) { throw "Unexpected cache index id $indexId for $FileId; expected 2." }

                $amount = [Math]::Min(512,$remaining)
                $buffer = New-Object byte[] $amount
                if ($dat.Read($buffer,0,$amount) -ne $amount) { throw "Short read for model $FileId at sector $sector." }
                $result.Write($buffer,0,$amount)

                $remaining -= $amount
                $sector = $nextSector
                $chunk++
                if ($remaining -gt 0 -and $sector -eq 0) { throw "Sector chain ended early for model $FileId." }
            }

            [System.IO.File]::WriteAllBytes($OutputPath,$result.ToArray())
            return $length
        }
        finally {
            $result.Dispose()
        }
    }
    finally {
        $idx.Dispose()
        $dat.Dispose()
    }
}

Write-Host ''
Write-Host '=== Levincia Phase Model Restore ==='
Write-Host ''

if (!(Test-Path $modelFile)) { throw "Model.java not found: $modelFile" }
if (!(Test-Path $sourceIdx)) { throw "Source idx1 not found: $sourceIdx" }
if (!(Test-Path $sourceDat)) { throw "Source dat not found: $sourceDat" }
New-Item -ItemType Directory -Force -Path $targetDir | Out-Null

$text = [System.IO.File]::ReadAllText($modelFile)
$original = @'
		if (data[data.length - 1] == -1 && data[data.length - 2] == -1) {
			read622Model(data, modelId);
		} else {
			readOldModel(data);
		}
'@
$experimental = @'
		if (data[data.length - 1] == -1 && data[data.length - 2] == -1) {
			read622Model(data, modelId);
		} else if (data[data.length - 1] == -2 && data[data.length - 2] == -1) {
			read525Model(data, modelId);
		} else {
			readOldModel(data);
		}
'@
$diagnostic = @'
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

$rollbackBackup = "$modelFile.before-phase-restore"
if (!(Test-Path $rollbackBackup)) { Copy-Item $modelFile $rollbackBackup }

if ($text.Contains($diagnostic)) {
    $text = $text.Replace($diagnostic,$original)
    [System.IO.File]::WriteAllText($modelFile,$text,[System.Text.UTF8Encoding]::new($false))
    Write-Host '[OK] Removed model 22383 diagnostic and restored original decoder routing.'
} elseif ($text.Contains($experimental)) {
    $text = $text.Replace($experimental,$original)
    [System.IO.File]::WriteAllText($modelFile,$text,[System.Text.UTF8Encoding]::new($false))
    Write-Host '[OK] Restored original model decoder routing.'
} elseif ($text.Contains($original)) {
    Write-Host '[OK] Original model decoder routing is already active.'
} else {
    Write-Host '[WARN] Exact block did not match. Trying tolerant regex rollback...'
    $pattern = '(?s)\s*String\s+levinciaDecoder;\s*try\s*\{.*?throw\s+t;\s*\}'
    if ([regex]::IsMatch($text,$pattern)) {
        $replacement = "`r`n" + ($original -replace "`n","`r`n")
        $text = [regex]::Replace($text,$pattern,[System.Text.RegularExpressions.MatchEvaluator]{ param($m) $replacement },1)
        [System.IO.File]::WriteAllText($modelFile,$text,[System.Text.UTF8Encoding]::new($false))
        Write-Host '[OK] Tolerant rollback succeeded; original decoder routing restored.'
    } else {
        throw 'Could not locate the decoder-routing or diagnostic block in Model.java. No model files were changed.'
    }
}

$stamp = Get-Date -Format 'yyyyMMdd-HHmmss'
$backupDir = Join-Path $targetDir "phase-backup-$stamp"
New-Item -ItemType Directory -Force -Path $backupDir | Out-Null

foreach ($model in $models) {
    $target = Join-Path $targetDir "$model.gz"
    if (Test-Path $target) {
        Copy-Item $target (Join-Path $backupDir "$model.gz") -Force
    }

    $length = Extract-CacheEntry -FileId $model -OutputPath $target

    $fs = [System.IO.File]::OpenRead($target)
    try {
        $gz = New-Object System.IO.Compression.GZipStream($fs,[System.IO.Compression.CompressionMode]::Decompress)
        $mem = New-Object System.IO.MemoryStream
        try {
            $gz.CopyTo($mem)
            $decoded = $mem.ToArray()
            $footer = if ($decoded.Length -ge 2) { '{0:X2} {1:X2}' -f $decoded[$decoded.Length-2],$decoded[$decoded.Length-1] } else { 'N/A' }
            Write-Host "[OK] Model $model -> compressed=$length decompressed=$($decoded.Length) footer=$footer"
        }
        finally { $mem.Dispose(); $gz.Dispose() }
    }
    finally { $fs.Dispose() }
}

Write-Host ''
Write-Host "Backups of previous phase files: $backupDir"
Write-Host "Source cache: $sourceCache"
Write-Host ''
Write-Host 'NEXT:'
Write-Host '1. Rebuild/run the Levincia client once.'
Write-Host '2. Confirm startup says index 1 repacked models 22379, 22382, and 22383.'
Write-Host '3. Test Phase [1], Phase [2], and Phase [3] in-game.'
Write-Host ''
