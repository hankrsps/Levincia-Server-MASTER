param(
    [string]$Root = ".\custom-assets\incoming"
)

$ErrorActionPreference = "Stop"
Write-Host "`n=== Levincia Custom Asset Compatibility Analyzer ===`n"

$dirs = @("armor", "wings", "bosses", "auras", "maps", "props")
foreach ($d in $dirs) {
    $p = Join-Path $Root $d
    if (!(Test-Path $p)) { New-Item -ItemType Directory -Force -Path $p | Out-Null }
}

$reportDir = Join-Path $env:USERPROFILE ".Levincia"
New-Item -ItemType Directory -Force -Path $reportDir | Out-Null
$report = Join-Path $reportDir "custom-asset-compatibility.csv"

$rows = @()
Get-ChildItem $Root -Recurse -File -ErrorAction SilentlyContinue | ForEach-Object {
    $ext = $_.Extension.ToLowerInvariant()
    $kind = ($_.DirectoryName.Substring((Resolve-Path $Root).Path.Length).TrimStart('\').Split('\')[0])
    $supported = $ext -in @('.obj','.fbx','.gltf','.glb','.blend','.png','.jpg','.jpeg')
    $notes = switch ($ext) {
        '.obj'  { 'Static geometry candidate; easiest 3D inspection path.' }
        '.fbx'  { 'May contain rig/animations; requires conversion before Necrotic cache use.' }
        '.gltf' { 'Modern scene format; requires conversion.' }
        '.glb'  { 'Modern binary scene format; requires conversion.' }
        '.blend' { 'Source asset; export to an interchange format before conversion.' }
        '.png'  { 'Texture/VFX candidate; aura frames can be staged here.' }
        '.jpg'  { 'Texture candidate.' }
        '.jpeg' { 'Texture candidate.' }
        default { 'Unknown format; manual review required.' }
    }
    $rows += [pscustomobject]@{
        Category=$kind; File=$_.FullName; Extension=$ext; Bytes=$_.Length;
        Recognized=$supported; Status='STAGED_ONLY'; Notes=$notes
    }
}

$rows | Export-Csv -NoTypeInformation -Encoding UTF8 $report
$rows | Format-Table Category,Extension,Bytes,Recognized,Status,File -AutoSize
Write-Host "`nReport: $report"
Write-Host "No cache files were modified. Assets remain staging-only."
