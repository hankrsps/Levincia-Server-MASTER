$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$modelPath = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\world\Model.java'

if (-not (Test-Path $modelPath)) {
    throw "Model.java not found at: $modelPath"
}

$text = [System.IO.File]::ReadAllText($modelPath)
$backup = "$modelPath.readiness-backup"

if (-not (Test-Path $backup)) {
    [System.IO.File]::Copy($modelPath, $backup)
    Write-Host "Backup created: $backup"
} else {
    Write-Host "Backup already exists: $backup"
}

# Match Java methods regardless of CRLF/LF line endings or indentation differences.
$getPattern = '(?s)public\s+static\s+Model\s+get\s*\(\s*int\s+model\s*\)\s*\{.*?aOnDemandFetcherParent_1662\.get\s*\(\s*model\s*\)\s*;\s*return\s+null\s*;\s*\}'
$getReplacement = @'
public static Model get(int model) {
		byte[] data = getData(model);
		if (data != null) {
			return new Model(data, model);
		}

		// Levincia's packed-cache loader can satisfy the request synchronously.
		aOnDemandFetcherParent_1662.get(model);
		data = getData(model);
		return data == null ? null : new Model(data, model);
	}
'@

$readyPattern = '(?s)public\s+static\s+boolean\s+method463\s*\(\s*int\s+model\s*\)\s*\{.*?aOnDemandFetcherParent_1662\.get\s*\(\s*model\s*\)\s*;\s*return\s+false\s*;\s*\}'
$readyReplacement = @'
public static boolean method463(int model) {
		if (getData(model) != null) {
			return true;
		}

		// Packed models are loaded synchronously by OnDemandFetcher.get().
		aOnDemandFetcherParent_1662.get(model);
		return getData(model) != null;
	}
'@

$changed = $false

if ($text -notmatch 'return\s+data\s*==\s*null\s*\?\s*null\s*:\s*new\s+Model\s*\(\s*data\s*,\s*model\s*\)\s*;') {
    $matches = [regex]::Matches($text, $getPattern)
    if ($matches.Count -ne 1) {
        throw "Expected exactly one Model.get(int) block, found $($matches.Count). No file was written."
    }
    $text = [regex]::Replace($text, $getPattern, $getReplacement, 1)
    $changed = $true
}

if ($text -notmatch 'return\s+getData\s*\(\s*model\s*\)\s*!=\s*null\s*;') {
    $matches = [regex]::Matches($text, $readyPattern)
    if ($matches.Count -ne 1) {
        throw "Expected exactly one Model.method463(int) block, found $($matches.Count). No file was written."
    }
    $text = [regex]::Replace($text, $readyPattern, $readyReplacement, 1)
    $changed = $true
}

if (-not $changed) {
    Write-Host ''
    Write-Host 'Levincia model readiness repair is already applied.'
    exit 0
}

# Preserve Windows-friendly CRLF line endings in the local Java source.
$text = $text -replace "`r?`n", "`r`n"
$utf8NoBom = New-Object System.Text.UTF8Encoding($false)
[System.IO.File]::WriteAllText($modelPath, $text, $utf8NoBom)

Write-Host ''
Write-Host 'Levincia model readiness repair applied successfully.'
Write-Host 'Model.get() and method463() now re-check models after synchronous packed-cache loading.'
Write-Host 'Next: Maven clean -> compile -> run the client.'
