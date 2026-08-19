$ErrorActionPreference = 'Stop'

$inputFbx = '.\custom-assets\incoming\wings\angel-wing-test\angel_wing_low_poly.fbx'
$outDir = '.\custom-assets\converted\wings\angel-wing-test'
$outObj = Join-Path $outDir 'angel_wing_low_poly.obj'
$py = Join-Path $env:TEMP 'levincia_convert_angel_wing.py'

if (!(Test-Path -LiteralPath $inputFbx)) {
    throw "Missing staged FBX: $inputFbx"
}

New-Item -ItemType Directory -Force -Path $outDir | Out-Null

# Find Blender without assuming a specific version.
$candidates = @()
$cmd = Get-Command blender.exe -ErrorAction SilentlyContinue
if ($cmd) { $candidates += $cmd.Source }
$candidates += @(Get-ChildItem 'C:\Program Files\Blender Foundation' -Recurse -Filter blender.exe -ErrorAction SilentlyContinue | Select-Object -ExpandProperty FullName)
$candidates = @($candidates | Where-Object { $_ -and (Test-Path -LiteralPath $_) } | Select-Object -Unique)

if ($candidates.Count -eq 0) {
    Write-Host ''
    Write-Host 'Blender was not found.'
    Write-Host 'This conversion uses Blender only as a command-line format converter; no 3D modeling work is required.'
    Write-Host 'Install Blender, then rerun this script.'
    Write-Host ''
    Write-Host 'Staged source remains untouched:'
    Write-Host "  $inputFbx"
    exit 2
}

$blender = $candidates | Select-Object -First 1

$python = @"
import bpy, os

src = r'''$((Resolve-Path -LiteralPath $inputFbx).Path)'''
dst = r'''$([System.IO.Path]::GetFullPath($outObj))'''

bpy.ops.object.select_all(action='SELECT')
bpy.ops.object.delete(use_global=False)

bpy.ops.import_scene.fbx(filepath=src)

for obj in list(bpy.context.scene.objects):
    if obj.type != 'MESH':
        bpy.data.objects.remove(obj, do_unlink=True)

for obj in bpy.context.scene.objects:
    obj.select_set(True)
    bpy.context.view_layer.objects.active = obj
    try:
        bpy.ops.object.transform_apply(location=False, rotation=True, scale=True)
    except Exception:
        pass

os.makedirs(os.path.dirname(dst), exist_ok=True)

if hasattr(bpy.ops.wm, 'obj_export'):
    bpy.ops.wm.obj_export(filepath=dst, export_materials=True)
else:
    bpy.ops.export_scene.obj(filepath=dst, use_materials=True)

print('LEVINCIA_EXPORT_OK=' + dst)
"@

Set-Content -LiteralPath $py -Value $python -Encoding UTF8

Write-Host ''
Write-Host '=== Levincia Angel Wing FBX Converter ==='
Write-Host "Blender: $blender"
Write-Host "Input:   $inputFbx"
Write-Host "Output:  $outObj"
Write-Host ''

& $blender --background --python $py
if ($LASTEXITCODE -ne 0) {
    throw "Blender conversion failed with exit code $LASTEXITCODE"
}

if (!(Test-Path -LiteralPath $outObj)) {
    throw 'Blender completed but no OBJ was produced.'
}

$textureSrc = '.\custom-assets\incoming\wings\angel-wing-test\textures'
$textureDst = Join-Path $outDir 'textures'
if (Test-Path -LiteralPath $textureSrc) {
    New-Item -ItemType Directory -Force -Path $textureDst | Out-Null
    Copy-Item (Join-Path $textureSrc '*') $textureDst -Force
}

Write-Host ''
Write-Host '[OK] FBX converted to OBJ.'
Write-Host "Converted model: $outObj"
Write-Host 'No cache files were modified.'
Write-Host ''
Write-Host 'NEXT:'
Write-Host '  powershell -ExecutionPolicy Bypass -File .\tools\analyze-converted-obj.ps1 -Path ".\custom-assets\converted\wings\angel-wing-test\angel_wing_low_poly.obj"'
