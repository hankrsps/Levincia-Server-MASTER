param(
    [Parameter(Mandatory=$true)]
    [string]$Path
)

$ErrorActionPreference = 'Stop'

if (!(Test-Path -LiteralPath $Path)) {
    throw "Model not found: $Path"
}

$bytes = [System.IO.File]::ReadAllBytes((Resolve-Path -LiteralPath $Path))
if ($bytes.Length -lt 18) {
    throw 'Model is too small to contain a classic 317 footer.'
}

function U16([byte[]]$b, [int]$o) {
    # Cast each byte to Int32 before shifting. PowerShell can otherwise preserve
    # byte-width semantics and discard the high byte (e.g. 0x06D4 becomes 0x00D4).
    $hi = [int]$b[$o]
    $lo = [int]$b[$o + 1]
    return (($hi -shl 8) -bor $lo)
}

$footer = $bytes.Length - 18
$vertices = U16 $bytes $footer
$faces = U16 $bytes ($footer + 2)
$textures = $bytes[$footer + 4]
$renderType = $bytes[$footer + 5]
$priority = $bytes[$footer + 6]
$alpha = $bytes[$footer + 7]
$faceSkin = $bytes[$footer + 8]
$vertexSkin = $bytes[$footer + 9]
$xLen = U16 $bytes ($footer + 10)
$yLen = U16 $bytes ($footer + 12)
$zLen = U16 $bytes ($footer + 14)
$indexLen = U16 $bytes ($footer + 16)

$offset = 0
$vertexFlagsOffset = $offset; $offset += $vertices
$faceTypesOffset = $offset; $offset += $faces
$priorityOffset = -1
if ($priority -eq 255) { $priorityOffset = $offset; $offset += $faces }
$faceSkinOffset = -1
if ($faceSkin -eq 1) { $faceSkinOffset = $offset; $offset += $faces }
$renderTypeOffset = -1
if ($renderType -eq 1) { $renderTypeOffset = $offset; $offset += $faces }
$vertexSkinOffset = -1
if ($vertexSkin -eq 1) { $vertexSkinOffset = $offset; $offset += $vertices }
$alphaOffset = -1
if ($alpha -eq 1) { $alphaOffset = $offset; $offset += $faces }
$indexOffset = $offset; $offset += $indexLen
$colorOffset = $offset; $offset += ($faces * 2)
$textureOffset = $offset; $offset += ($textures * 6)
$xOffset = $offset; $offset += $xLen
$yOffset = $offset; $offset += $yLen
$zOffset = $offset; $offset += $zLen

$ok = ($offset -eq $footer)

Write-Host ''
Write-Host '=== Levincia Classic 317 Model Validator ==='
Write-Host "File:        $Path"
Write-Host "Bytes:       $($bytes.Length)"
Write-Host "Vertices:    $vertices"
Write-Host "Faces:       $faces"
Write-Host "Textures:    $textures"
Write-Host "RenderType:  $renderType"
Write-Host "Priority:    $priority"
Write-Host "Alpha:       $alpha"
Write-Host "FaceSkin:    $faceSkin"
Write-Host "VertexSkin:  $vertexSkin"
Write-Host "X stream:    $xLen"
Write-Host "Y stream:    $yLen"
Write-Host "Z stream:    $zLen"
Write-Host "Index stream:$indexLen"
Write-Host "Computed footer offset: $offset"
Write-Host "Actual footer offset:   $footer"
Write-Host ''

if (!$ok) {
    throw 'INVALID: stream lengths do not land exactly on the 18-byte footer.'
}

if ($vertices -le 0 -or $faces -le 0) {
    throw 'INVALID: model has zero vertices or faces.'
}

if ($textureOffset + ($textures * 6) -gt $footer) {
    throw 'INVALID: texture stream exceeds footer boundary.'
}

Write-Host '[OK] Footer and stream layout match Levincia readOldModel().'
Write-Host 'This is still staging-only; no cache files were modified.'
