$ErrorActionPreference = "Stop"

$modelId = 22383
$outDir = "C:\Users\Becca\.Levincia\22383-candidates"
New-Item -ItemType Directory -Force -Path $outDir | Out-Null

$candidates = @(
    @{ Name = "Elvarg-595"; Idx = "C:\Users\Becca\IdeaProjects\Levincia.2\elvarg-rsps\ElvargClient\Cache\main_file_cache.idx1"; Dat = "C:\Users\Becca\IdeaProjects\Levincia.2\elvarg-rsps\ElvargClient\Cache\main_file_cache.dat" },
    @{ Name = "Runex-601"; Idx = "C:\Users\Becca\.runex\main_file_cache.idx1"; Dat = "C:\Users\Becca\.runex\main_file_cache.dat" },
    @{ Name = "Simplicity-730"; Idx = "C:\Users\Becca\.SimplicityCache\main_file_cache.idx1"; Dat = "C:\Users\Becca\.SimplicityCache\main_file_cache.dat" },
    @{ Name = "Bethlehem-931"; Idx = "C:\Users\Becca\BethlehemCache\main_file_cache.idx1"; Dat = "C:\Users\Becca\BethlehemCache\main_file_cache.dat" }
)

function Read-Medium {
    param([byte[]]$Bytes, [int]$Offset)
    return ((($Bytes[$Offset] -band 255) -shl 16) -bor (($Bytes[$Offset+1] -band 255) -shl 8) -bor ($Bytes[$Offset+2] -band 255))
}

function Extract-CacheEntry {
    param([string]$IdxPath, [string]$DatPath, [int]$FileId, [string]$OutputPath)

    $idx = [System.IO.File]::Open($IdxPath,[System.IO.FileMode]::Open,[System.IO.FileAccess]::Read,[System.IO.FileShare]::ReadWrite)
    $dat = [System.IO.File]::Open($DatPath,[System.IO.FileMode]::Open,[System.IO.FileAccess]::Read,[System.IO.FileShare]::ReadWrite)
    try {
        $idxOffset = $FileId * 6
        if ($idxOffset + 6 -gt $idx.Length) { throw "IDX entry is outside the file." }
        $idx.Seek($idxOffset,[System.IO.SeekOrigin]::Begin) | Out-Null
        $entry = New-Object byte[] 6
        if ($idx.Read($entry,0,6) -ne 6) { throw "Unable to read IDX entry." }
        $length = Read-Medium $entry 0
        $sector = Read-Medium $entry 3
        if ($length -le 0 -or $sector -le 0) { throw "Empty cache entry." }
        Write-Host "  Length: $length"
        Write-Host "  First sector: $sector"

        $result = New-Object System.IO.MemoryStream
        $remaining = $length
        $chunk = 0
        while ($remaining -gt 0) {
            $sectorOffset = [int64]$sector * 520
            if ($sectorOffset + 8 -gt $dat.Length) { throw "Sector $sector is outside DAT file." }
            $dat.Seek($sectorOffset,[System.IO.SeekOrigin]::Begin) | Out-Null
            $header = New-Object byte[] 8
            if ($dat.Read($header,0,8) -ne 8) { throw "Unable to read sector header." }
            $headerFile = (($header[0] -band 255) -shl 8) -bor ($header[1] -band 255)
            $headerChunk = (($header[2] -band 255) -shl 8) -bor ($header[3] -band 255)
            $nextSector = Read-Medium $header 4
            $indexId = $header[7] -band 255
            if ($headerFile -ne $FileId) { throw "Unexpected file id $headerFile in sector $sector." }
            if ($headerChunk -ne $chunk) { throw "Unexpected chunk $headerChunk; expected $chunk." }
            if ($indexId -ne 2) { throw "Unexpected cache index id $indexId." }
            $amount = [Math]::Min(512,$remaining)
            $buffer = New-Object byte[] $amount
            if ($dat.Read($buffer,0,$amount) -ne $amount) { throw "Short read from sector $sector." }
            $result.Write($buffer,0,$amount)
            $remaining -= $amount
            $sector = $nextSector
            $chunk++
            if ($remaining -gt 0 -and $sector -eq 0) { throw "Sector chain ended early." }
        }
        [System.IO.File]::WriteAllBytes($OutputPath,$result.ToArray())
        $result.Dispose()
        return $length
    } finally {
        $idx.Dispose()
        $dat.Dispose()
    }
}

Write-Host ""
Write-Host "=== Levincia model 22383 candidate extractor ==="
Write-Host ""
$results = @()
foreach ($candidate in $candidates) {
    Write-Host "----------------------------------------"
    Write-Host "Testing $($candidate.Name)"
    if (!(Test-Path $candidate.Idx)) { Write-Host "  SKIP: IDX missing."; continue }
    if (!(Test-Path $candidate.Dat)) { Write-Host "  SKIP: DAT missing."; continue }
    $output = Join-Path $outDir "$($candidate.Name)-22383.gz"
    try {
        $compressedLength = Extract-CacheEntry -IdxPath $candidate.Idx -DatPath $candidate.Dat -FileId $modelId -OutputPath $output
        $gzipOK = $false; $decompressedSize = 0; $footer = "N/A"
        $fs = [System.IO.File]::OpenRead($output)
        try {
            $gz = New-Object System.IO.Compression.GZipStream($fs,[System.IO.Compression.CompressionMode]::Decompress)
            $mem = New-Object System.IO.MemoryStream
            try {
                $gz.CopyTo($mem)
                $decoded = $mem.ToArray()
                $gzipOK = $true
                $decompressedSize = $decoded.Length
                if ($decoded.Length -ge 2) {
                    $footer = "{0:X2} {1:X2}" -f $decoded[$decoded.Length-2],$decoded[$decoded.Length-1]
                }
            } finally { $mem.Dispose(); $gz.Dispose() }
        } catch { $gzipOK = $false } finally { $fs.Dispose() }
        $results += [PSCustomObject]@{ Candidate=$candidate.Name; Compressed=$compressedLength; Gzip=$gzipOK; Decompressed=$decompressedSize; Footer=$footer; File=$output }
        Write-Host "  EXTRACTED: $output"
        Write-Host "  GZIP: $gzipOK"
        Write-Host "  Decompressed: $decompressedSize"
        Write-Host "  Footer: $footer"
    } catch { Write-Host "  FAILED: $($_.Exception.Message)" }
    Write-Host ""
}
Write-Host "=============== RESULTS ==============="
$results | Format-Table -AutoSize
Write-Host ""
Write-Host "Candidates saved in: $outDir"
Write-Host "Do NOT copy one into index1 yet."
