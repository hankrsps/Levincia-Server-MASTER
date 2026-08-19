param(
    [Parameter(Mandatory=$true)]
    [string]$Path
)

$ErrorActionPreference = 'Stop'

if (!(Test-Path -LiteralPath $Path)) {
    throw "OBJ not found: $Path"
}

$vertexCount = 0
$texCoordCount = 0
$normalCount = 0
$faceCount = 0
$objectNames = New-Object System.Collections.Generic.List[string]
$materialNames = New-Object System.Collections.Generic.HashSet[string]

$minX = [double]::PositiveInfinity
$minY = [double]::PositiveInfinity
$minZ = [double]::PositiveInfinity
$maxX = [double]::NegativeInfinity
$maxY = [double]::NegativeInfinity
$maxZ = [double]::NegativeInfinity

Get-Content -LiteralPath $Path | ForEach-Object {
    $line = $_.Trim()
    if ($line.StartsWith('v ')) {
        $vertexCount++
        $parts = $line -split '\s+'
        if ($parts.Count -ge 4) {
            $x = [double]$parts[1]
            $y = [double]$parts[2]
            $z = [double]$parts[3]
            if ($x -lt $minX) { $minX = $x }
            if ($y -lt $minY) { $minY = $y }
            if ($z -lt $minZ) { $minZ = $z }
            if ($x -gt $maxX) { $maxX = $x }
            if ($y -gt $maxY) { $maxY = $y }
            if ($z -gt $maxZ) { $maxZ = $z }
        }
    } elseif ($line.StartsWith('vt ')) {
        $texCoordCount++
    } elseif ($line.StartsWith('vn ')) {
        $normalCount++
    } elseif ($line.StartsWith('f ')) {
        $faceCount++
    } elseif ($line.StartsWith('o ')) {
        $name = $line.Substring(2).Trim()
        if ($name) { $objectNames.Add($name) }
    } elseif ($line.StartsWith('usemtl ')) {
        $name = $line.Substring(7).Trim()
        if ($name) { [void]$materialNames.Add($name) }
    }
}

$sizeX = if ([double]::IsInfinity($minX)) { 0 } else { $maxX - $minX }
$sizeY = if ([double]::IsInfinity($minY)) { 0 } else { $maxY - $minY }
$sizeZ = if ([double]::IsInfinity($minZ)) { 0 } else { $maxZ - $minZ }

Write-Host ''
Write-Host '=== Levincia Converted OBJ Analyzer ==='
Write-Host "File:      $Path"
Write-Host "Vertices:  $vertexCount"
Write-Host "Faces:     $faceCount"
Write-Host "UVs:       $texCoordCount"
Write-Host "Normals:   $normalCount"
Write-Host "Objects:   $($objectNames.Count)"
Write-Host "Materials: $($materialNames.Count)"
Write-Host ('Bounds:    X={0:N3}  Y={1:N3}  Z={2:N3}' -f $sizeX, $sizeY, $sizeZ)

if ($objectNames.Count -gt 0) {
    Write-Host 'Object names:'
    $objectNames | Select-Object -Unique | ForEach-Object { Write-Host "  $_" }
}

if ($materialNames.Count -gt 0) {
    Write-Host 'Materials:'
    $materialNames | Sort-Object | ForEach-Object { Write-Host "  $_" }
}

Write-Host ''
if ($vertexCount -eq 0 -or $faceCount -eq 0) {
    Write-Host '[FAIL] The converted OBJ has no usable mesh geometry.'
    exit 3
}

if ($vertexCount -gt 10000 -or $faceCount -gt 15000) {
    Write-Host '[WARN] Geometry is relatively heavy for an old 317/Necrotic client; reduction may be needed.'
} else {
    Write-Host '[OK] Geometry size is reasonable enough for the next compatibility step.'
}

Write-Host 'No cache files were modified.'
