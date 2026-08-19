$ErrorActionPreference = 'Stop'

$inputObj = '.\custom-assets\converted\wings\angel-wing-test\angel_wing_low_poly.obj'
$outDir = '.\custom-assets\converted\wings\angel-wing-test\317'
$outRaw = Join-Path $outDir 'angel_wings_317.dat'
$outGz = Join-Path $outDir '100500.gz'
$py = Join-Path $env:TEMP 'levincia_encode_angel_wing_317.py'

if (!(Test-Path -LiteralPath $inputObj)) {
    throw "Missing converted OBJ: $inputObj"
}

New-Item -ItemType Directory -Force -Path $outDir | Out-Null

# Reuse Blender's bundled Python so this tool has no separate Python dependency.
$candidates = @()
$cmd = Get-Command blender.exe -ErrorAction SilentlyContinue
if ($cmd) { $candidates += @($cmd.Source) }
$candidates += @(Get-ChildItem 'C:\Program Files\Blender Foundation' -Recurse -Filter blender.exe -ErrorAction SilentlyContinue | Select-Object -ExpandProperty FullName)
$candidates = @($candidates | Where-Object { $_ -and (Test-Path -LiteralPath $_) } | Select-Object -Unique)
if ($candidates.Count -eq 0) {
    throw 'Blender was not found. The encoder uses Blender only to provide a Python runtime.'
}
$blender = $candidates[0]

$srcFull = (Resolve-Path -LiteralPath $inputObj).Path
$rawFull = [System.IO.Path]::GetFullPath($outRaw)
$gzFull = [System.IO.Path]::GetFullPath($outGz)

$python = @"
import gzip, math, os, struct

SRC = r'''$srcFull'''
RAW = r'''$rawFull'''
GZ = r'''$gzFull'''
SCALE = 220.0
FACE_COLOR = 127


def signed_smart(v):
    if -64 <= v < 64:
        return bytes((v + 64,))
    if -16384 <= v < 16384:
        return struct.pack('>H', v + 49152)
    raise ValueError(f'signed-smart delta out of range: {v}')


def parse_obj(path):
    verts = []
    faces = []
    with open(path, 'r', encoding='utf-8', errors='ignore') as f:
        for line in f:
            if line.startswith('v '):
                p = line.split()
                if len(p) >= 4:
                    verts.append((float(p[1]), float(p[2]), float(p[3])))
            elif line.startswith('f '):
                raw = line.split()[1:]
                idx = []
                for token in raw:
                    a = token.split('/')[0]
                    if not a:
                        continue
                    n = int(a)
                    if n < 0:
                        n = len(verts) + n
                    else:
                        n -= 1
                    idx.append(n)
                if len(idx) >= 3:
                    for j in range(1, len(idx)-1):
                        faces.append((idx[0], idx[j], idx[j+1]))
    return verts, faces


def build_pair(verts, faces):
    xs = [v[0] for v in verts]
    ys = [v[1] for v in verts]
    zs = [v[2] for v in verts]
    minx, maxx = min(xs), max(xs)
    miny, maxy = min(ys), max(ys)
    minz, maxz = min(zs), max(zs)
    width = maxx - minx
    cy = (miny + maxy) * 0.5
    cz = (minz + maxz) * 0.5
    cx = (minx + maxx) * 0.5
    gap = width * 0.03
    shift = width * 0.5 + gap
    right = [(x - cx + shift, y - cy, z - cz) for x,y,z in verts]
    left = [(-x, y, z) for x,y,z in right]
    outv = right + left
    off = len(right)
    outf = list(faces)
    outf += [(a+off, c+off, b+off) for a,b,c in faces]
    return outv, outf


def quantize(verts):
    out = []
    for x,y,z in verts:
        qx = int(round(x * SCALE))
        qy = int(round(-y * SCALE))
        qz = int(round(z * SCALE))
        out.append((qx,qy,qz))
    return out


def encode(vertices, faces):
    if len(vertices) > 65535 or len(faces) > 65535:
        raise ValueError('classic 317 model count exceeds unsigned-short capacity')
    vertex_flags = bytearray()
    xstream = bytearray(); ystream = bytearray(); zstream = bytearray()
    px = py = pz = 0
    for x,y,z in vertices:
        dx,dy,dz = x-px, y-py, z-pz
        flag = 0
        if dx: flag |= 1
        if dy: flag |= 2
        if dz: flag |= 4
        vertex_flags.append(flag)
        if dx: xstream += signed_smart(dx)
        if dy: ystream += signed_smart(dy)
        if dz: zstream += signed_smart(dz)
        px,py,pz = x,y,z
    face_types = bytearray()
    indexstream = bytearray()
    last = 0
    for a,b,c in faces:
        if not (0 <= a < len(vertices) and 0 <= b < len(vertices) and 0 <= c < len(vertices)):
            raise ValueError(f'face index out of range: {(a,b,c)}')
        face_types.append(1)
        indexstream += signed_smart(a - last); last = a
        indexstream += signed_smart(b - last); last = b
        indexstream += signed_smart(c - last); last = c
    colors = bytearray()
    for _ in faces:
        colors += struct.pack('>H', FACE_COLOR)
    body = bytes(vertex_flags) + bytes(face_types) + bytes(indexstream) + bytes(colors) + bytes(xstream) + bytes(ystream) + bytes(zstream)
    footer = struct.pack('>HHBBBBBBHHHH', len(vertices), len(faces), 0, 0, 0, 0, 0, 0, len(xstream), len(ystream), len(zstream), len(indexstream))
    assert len(footer) == 18
    return body + footer, {'vertex_flags': len(vertex_flags), 'face_types': len(face_types), 'index_stream': len(indexstream), 'colors': len(colors), 'x_stream': len(xstream), 'y_stream': len(ystream), 'z_stream': len(zstream)}

verts, faces = parse_obj(SRC)
if not verts or not faces:
    raise RuntimeError('OBJ contained no usable vertices/faces')
paired_v, paired_f = build_pair(verts, faces)
qv = quantize(paired_v)
raw, sizes = encode(qv, paired_f)
os.makedirs(os.path.dirname(RAW), exist_ok=True)
with open(RAW, 'wb') as f:
    f.write(raw)
# gzip.open() does not accept mtime on every Python version. GzipFile does.
with open(GZ, 'wb') as gz_out:
    with gzip.GzipFile(filename='', mode='wb', fileobj=gz_out, compresslevel=9, mtime=0) as g:
        g.write(raw)
mins = tuple(min(v[i] for v in qv) for i in range(3))
maxs = tuple(max(v[i] for v in qv) for i in range(3))
print('LEVINCIA_317_ENCODE_OK=1')
print(f'SOURCE_VERTICES={len(verts)} SOURCE_FACES={len(faces)}')
print(f'PAIRED_VERTICES={len(qv)} PAIRED_FACES={len(paired_f)}')
print(f'RAW_BYTES={len(raw)} GZIP_BYTES={os.path.getsize(GZ)}')
print(f'BOUNDS_MIN={mins} BOUNDS_MAX={maxs}')
for k,v in sizes.items():
    print(f'{k.upper()}={v}')
print('RAW=' + RAW)
print('GZ=' + GZ)
"@

Set-Content -LiteralPath $py -Value $python -Encoding UTF8

Write-Host ''
Write-Host '=== Levincia Angel Wings Classic 317 Encoder ==='
Write-Host "Blender: $blender"
Write-Host "Input:   $inputObj"
Write-Host 'Model ID reserved for test: 100500'
Write-Host 'Item ID reserved for test:  22640'
Write-Host ''

& $blender --background --python $py
if ($LASTEXITCODE -ne 0) {
    throw "317 encoding failed with exit code $LASTEXITCODE"
}
if (!(Test-Path -LiteralPath $outRaw) -or !(Test-Path -LiteralPath $outGz)) {
    throw 'Encoder completed but expected output files were not produced.'
}
Write-Host ''
Write-Host '[OK] Angel Wings encoded as a staging-only classic 317 model.'
Write-Host "Raw:  $outRaw"
Write-Host "Gzip: $outGz"
Write-Host 'No live cache files were modified.'
Write-Host ''
Write-Host 'NEXT:'
Write-Host '  powershell -ExecutionPolicy Bypass -File .\tools\validate-317-model.ps1 -Path ".\custom-assets\converted\wings\angel-wing-test\317\angel_wings_317.dat"'
