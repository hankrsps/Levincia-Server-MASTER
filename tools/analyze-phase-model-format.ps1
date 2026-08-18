$ErrorActionPreference = 'Stop'

$sourceCache = 'C:\Users\Becca\IdeaProjects\Levincia.2\Levincia.2.0\game-client\Cache'
$sourceIdx = Join-Path $sourceCache 'main_file_cache.idx1'
$sourceDat = Join-Path $sourceCache 'main_file_cache.dat'
$activeLoose = 'C:\Users\Becca\.Levincia\index1'
$outDir = 'C:\Users\Becca\.Levincia\phase-model-analysis'

$models = @(
    @{ Id = 22383; Name = 'Phase 1' },
    @{ Id = 22382; Name = 'Phase 2' },
    @{ Id = 22379; Name = 'Phase 3' },
    @{ Id = 16349; Name = 'Phase 4' },
    @{ Id = 16351; Name = 'Phase 5' },
    @{ Id = 16352; Name = 'Phase 6' }
)

New-Item -ItemType Directory -Force -Path $outDir | Out-Null

function Read-Medium {
    param([byte[]]$Bytes,[int]$Offset)
    return ((($Bytes[$Offset] -band 255) -shl 16) -bor (($Bytes[$Offset+1] -band 255) -shl 8) -bor ($Bytes[$Offset+2] -band 255))
}

function Read-U16 {
    param([byte[]]$Bytes,[int]$Offset)
    if ($Offset -lt 0 -or $Offset + 1 -ge $Bytes.Length) { return $null }
    return ((($Bytes[$Offset] -band 255) -shl 8) -bor ($Bytes[$Offset+1] -band 255))
}

function Extract-CacheEntry {
    param([int]$FileId,[string]$OutputPath)

    $idx = [System.IO.File]::Open($sourceIdx,[System.IO.FileMode]::Open,[System.IO.FileAccess]::Read,[System.IO.FileShare]::ReadWrite)
    $dat = [System.IO.File]::Open($sourceDat,[System.IO.FileMode]::Open,[System.IO.FileAccess]::Read,[System.IO.FileShare]::ReadWrite)
    try {
        $off = $FileId * 6
        if ($off + 6 -gt $idx.Length) { return $false }
        $idx.Seek($off,[System.IO.SeekOrigin]::Begin) | Out-Null
        $entry = New-Object byte[] 6
        if ($idx.Read($entry,0,6) -ne 6) { return $false }
        $length = Read-Medium $entry 0
        $sector = Read-Medium $entry 3
        if ($length -le 0 -or $sector -le 0) { return $false }

        $mem = New-Object System.IO.MemoryStream
        try {
            $remaining = $length
            $chunk = 0
            while ($remaining -gt 0) {
                $dat.Seek(([int64]$sector * 520),[System.IO.SeekOrigin]::Begin) | Out-Null
                $header = New-Object byte[] 8
                if ($dat.Read($header,0,8) -ne 8) { throw "Short sector header for model $FileId" }
                $headerFile = (($header[0] -band 255) -shl 8) -bor ($header[1] -band 255)
                $headerChunk = (($header[2] -band 255) -shl 8) -bor ($header[3] -band 255)
                $nextSector = Read-Medium $header 4
                $indexId = $header[7] -band 255
                if ($headerFile -ne $FileId) { throw "Model $FileId sector $sector has file id $headerFile" }
                if ($headerChunk -ne $chunk) { throw "Model $FileId sector $sector has chunk $headerChunk expected $chunk" }
                if ($indexId -ne 2) { throw "Model $FileId sector $sector has index id $indexId expected 2" }
                $take = [Math]::Min(512,$remaining)
                $buf = New-Object byte[] $take
                if ($dat.Read($buf,0,$take) -ne $take) { throw "Short sector data for model $FileId" }
                $mem.Write($buf,0,$take)
                $remaining -= $take
                $sector = $nextSector
                $chunk++
            }
            [System.IO.File]::WriteAllBytes($OutputPath,$mem.ToArray())
            return $true
        } finally { $mem.Dispose() }
    } finally {
        $idx.Dispose()
        $dat.Dispose()
    }
}

function Expand-Gzip {
    param([string]$Path)
    $fs = [System.IO.File]::OpenRead($Path)
    try {
        $gz = New-Object System.IO.Compression.GZipStream($fs,[System.IO.Compression.CompressionMode]::Decompress)
        $mem = New-Object System.IO.MemoryStream
        try {
            $gz.CopyTo($mem)
            return ,$mem.ToArray()
        } finally { $mem.Dispose(); $gz.Dispose() }
    } finally { $fs.Dispose() }
}

function Hex-Range {
    param([byte[]]$Data,[int]$Start,[int]$Count)
    if ($Start -lt 0) { $Start = 0 }
    $end = [Math]::Min($Data.Length - 1,$Start + $Count - 1)
    if ($Data.Length -eq 0 -or $Start -gt $end) { return '' }
    return (($Data[$Start..$end] | ForEach-Object { $_.ToString('X2') }) -join ' ')
}

function Describe-Footer {
    param([byte[]]$Data,[int]$Back,[string]$Label)
    $p = $Data.Length - $Back
    if ($p -lt 0 -or $p + 17 -ge $Data.Length) {
        Write-Host "  $Label: unavailable"
        return
    }
    $v = Read-U16 $Data $p
    $f = Read-U16 $Data ($p+2)
    $t = $Data[$p+4] -band 255
    $flags = @()
    for ($i=5; $i -le 9; $i++) { $flags += ($Data[$p+$i] -band 255) }
    $a = Read-U16 $Data ($p+10)
    $b = Read-U16 $Data ($p+12)
    $c = Read-U16 $Data ($p+14)
    $d = Read-U16 $Data ($p+16)
    Write-Host "  $Label @ $p -> vertices=$v faces=$f tex=$t flags=$($flags -join ',') lens=$a,$b,$c,$d"
}

Write-Host ''
Write-Host '=== Levincia Phase Model Format Analyzer ==='
Write-Host "Source cache: $sourceCache"
Write-Host "Output:       $outDir"
Write-Host ''

$summary = @()

foreach ($m in $models) {
    $id = [int]$m.Id
    $name = [string]$m.Name
    $loose = Join-Path $activeLoose "$id.gz"
    $copy = Join-Path $outDir "$id.gz"

    if (Test-Path $loose) {
        Copy-Item $loose $copy -Force
        $origin = 'active loose index1'
    } else {
        if (!(Extract-CacheEntry -FileId $id -OutputPath $copy)) {
            Write-Host "[$name / $id] MISSING in source cache"
            continue
        }
        $origin = 'old Levincia cache'
    }

    try {
        $data = Expand-Gzip $copy
    } catch {
        Write-Host "[$name / $id] GZIP FAILED: $($_.Exception.Message)"
        continue
    }

    $compressed = (Get-Item $copy).Length
    $footer = if ($data.Length -ge 2) { '{0:X2} {1:X2}' -f $data[$data.Length-2],$data[$data.Length-1] } else { 'N/A' }
    $hash = (Get-FileHash $copy -Algorithm SHA256).Hash.Substring(0,16)

    Write-Host '------------------------------------------------------------'
    Write-Host "$name / model $id"
    Write-Host "  origin=$origin compressed=$compressed decompressed=$($data.Length) footer=$footer sha256=$hash..."
    Write-Host "  first32: $(Hex-Range $data 0 32)"
    Write-Host "  last64 : $(Hex-Range $data ([Math]::Max(0,$data.Length-64)) 64)"
    Describe-Footer -Data $data -Back 18 -Label 'old-style candidate (-18)'
    Describe-Footer -Data $data -Back 23 -Label 'new-style candidate (-23)'
    Describe-Footer -Data $data -Back 24 -Label 'type2 candidate (-24)'
    Describe-Footer -Data $data -Back 25 -Label 'type2 candidate (-25)'

    $summary += [PSCustomObject]@{
        Phase = $name
        Model = $id
        Compressed = $compressed
        Decompressed = $data.Length
        Footer = $footer
        Origin = $origin
        Sha16 = $hash
    }
}

Write-Host ''
Write-Host '================ SUMMARY ================'
$summary | Format-Table -AutoSize
Write-Host ''
Write-Host 'Copy the full output back to ChatGPT. Do not change Model.java or the cache after this test.'
