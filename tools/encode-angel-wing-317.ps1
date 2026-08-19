$ErrorActionPreference = 'Stop'

$inputObj = '.\custom-assets\converted\wings\angel-wing-test\angel_wing_low_poly.obj'
$outDir = '.\custom-assets\converted\wings\angel-wing-test\317'
$outRaw = Join-Path $outDir 'angel_wings_317.dat'
$outGz = Join-Path $outDir '99000.gz'
$py = Join-Path $env:TEMP 'levincia_encode_angel_wing_317.py'

if (!(Test-Path -LiteralPath $inputObj)) { throw "Missing converted OBJ: $inputObj" }
New-Item -ItemType Directory -Force -Path $outDir | Out-Null

$candidates = @()
$cmd = Get-Command blender.exe -ErrorAction SilentlyContinue
if ($cmd) { $candidates += @($cmd.Source) }
$candidates += @(Get-ChildItem 'C:\Program Files\Blender Foundation' -Recurse -Filter blender.exe -ErrorAction SilentlyContinue | Select-Object -ExpandProperty FullName)
$candidates = @($candidates | Where-Object { $_ -and (Test-Path -LiteralPath $_) } | Select-Object -Unique)
if ($candidates.Count -eq 0) { throw 'Blender was not found.' }
$blender = $candidates[0]
$srcFull = (Resolve-Path -LiteralPath $inputObj).Path
$rawFull = [System.IO.Path]::GetFullPath($outRaw)
$gzFull = [System.IO.Path]::GetFullPath($outGz)

$python = @"
import gzip, os, struct
SRC=r'''$srcFull'''; RAW=r'''$rawFull'''; GZ=r'''$gzFull'''
SCALE=220.0; FACE_COLOR=127
def smart(v):
    if -64 <= v < 64: return bytes((v+64,))
    if -16384 <= v < 16384: return struct.pack('>H',v+49152)
    raise ValueError('signed-smart delta out of range: %s'%v)
def parse(path):
    vs=[]; fs=[]
    for line in open(path,'r',encoding='utf-8',errors='ignore'):
        if line.startswith('v '):
            p=line.split(); vs.append(tuple(map(float,p[1:4])))
        elif line.startswith('f '):
            ids=[]
            for t in line.split()[1:]:
                n=int(t.split('/')[0]); ids.append(len(vs)+n if n<0 else n-1)
            for j in range(1,len(ids)-1): fs.append((ids[0],ids[j],ids[j+1]))
    return vs,fs
def pair(vs,fs):
    xs=[v[0] for v in vs]; ys=[v[1] for v in vs]; zs=[v[2] for v in vs]
    cx=(min(xs)+max(xs))/2; cy=(min(ys)+max(ys))/2; cz=(min(zs)+max(zs))/2
    shift=(max(xs)-min(xs))*.53
    r=[(x-cx+shift,y-cy,z-cz) for x,y,z in vs]; l=[(-x,y,z) for x,y,z in r]; o=len(r)
    return r+l, fs+[(a+o,c+o,b+o) for a,b,c in fs]
def encode(vs,fs):
    vf=bytearray(); xs=bytearray(); ys=bytearray(); zs=bytearray(); px=py=pz=0
    for x,y,z in vs:
        dx,dy,dz=x-px,y-py,z-pz; f=(1 if dx else 0)|(2 if dy else 0)|(4 if dz else 0); vf.append(f)
        if dx: xs.extend(smart(dx))
        if dy: ys.extend(smart(dy))
        if dz: zs.extend(smart(dz))
        px,py,pz=x,y,z
    ft=bytearray(); ind=bytearray(); last=0
    for a,b,c in fs:
        ft.append(1)
        for n in (a,b,c): ind.extend(smart(n-last)); last=n
    colors=b''.join(struct.pack('>H',FACE_COLOR) for _ in fs)
    body=bytes(vf)+bytes(ft)+bytes(ind)+colors+bytes(xs)+bytes(ys)+bytes(zs)
    footer=struct.pack('>HHBBBBBBHHHH',len(vs),len(fs),0,0,0,0,0,0,len(xs),len(ys),len(zs),len(ind))
    return body+footer
vs,fs=parse(SRC)
if not vs or not fs: raise RuntimeError('OBJ contained no usable vertices/faces')
vs,fs=pair(vs,fs); q=[(round(x*SCALE),round(-y*SCALE),round(z*SCALE)) for x,y,z in vs]
raw=encode(q,fs); os.makedirs(os.path.dirname(RAW),exist_ok=True); open(RAW,'wb').write(raw)
with open(GZ,'wb') as out:
    with gzip.GzipFile(filename='',mode='wb',fileobj=out,compresslevel=9,mtime=0) as g: g.write(raw)
print('LEVINCIA_317_ENCODE_OK=1'); print('MODEL_ID=99000'); print('VERTICES=%d FACES=%d RAW_BYTES=%d GZIP_BYTES=%d'%(len(q),len(fs),len(raw),os.path.getsize(GZ)))
print('RAW='+RAW); print('GZ='+GZ)
"@
[System.IO.File]::WriteAllText($py, $python, (New-Object System.Text.UTF8Encoding($false)))
Write-Host ''
Write-Host '=== Levincia Angel Wings Classic 317 Encoder ==='
Write-Host "Blender: $blender"
Write-Host "Input:   $inputObj"
Write-Host 'Model ID reserved for test: 99000'
Write-Host 'Item ID reserved for test:  22640'
Write-Host ''
& $blender --background --python $py
if ($LASTEXITCODE -ne 0) { throw "317 encoding failed with exit code $LASTEXITCODE" }
if (!(Test-Path -LiteralPath $outRaw) -or !(Test-Path -LiteralPath $outGz)) { throw 'Encoder completed but expected output files were not produced.' }
Write-Host ''
Write-Host '[OK] Angel Wings encoded as model 99000.'
Write-Host "Raw:  $outRaw"
Write-Host "Gzip: $outGz"
Write-Host 'NEXT:'
Write-Host '  powershell -ExecutionPolicy Bypass -File .\tools\install-angel-wings-test.ps1'
