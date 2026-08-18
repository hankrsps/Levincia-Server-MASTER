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
}

$oldGet = @'
	public static Model get(int model) {
		final byte[] data = getData(model);
		if (data != null) {
			return new Model(data, model);
		}
		aOnDemandFetcherParent_1662.get(model);
		return null;
	}
'@

$newGet = @'
	public static Model get(int model) {
		byte[] data = getData(model);
		if (data != null) {
			return new Model(data, model);
		}

		// The Levincia on-demand fetcher can satisfy packed-cache model requests
		// synchronously. Re-check immediately instead of forcing a later game tick.
		aOnDemandFetcherParent_1662.get(model);
		data = getData(model);
		return data == null ? null : new Model(data, model);
	}
'@

$oldReady = @'
	public static boolean method463(int model) {
		final byte[] data = getData(model);
		if (data != null) {
			return true;
		}
		aOnDemandFetcherParent_1662.get(model);
		return false;
	}
'@

$newReady = @'
	public static boolean method463(int model) {
		if (getData(model) != null) {
			return true;
		}

		// Packed models are loaded synchronously by OnDemandFetcher.get().
		// Re-check now so valid cached models do not falsely hold the region at -3.
		aOnDemandFetcherParent_1662.get(model);
		return getData(model) != null;
	}
'@

if (-not $text.Contains('return data == null ? null : new Model(data, model);')) {
    if (-not $text.Contains($oldGet)) {
        throw 'Could not find the expected Model.get(int) block. No file was written.'
    }
    $text = $text.Replace($oldGet, $newGet)
}

if (-not $text.Contains('return getData(model) != null;')) {
    if (-not $text.Contains($oldReady)) {
        throw 'Could not find the expected Model.method463(int) block. No file was written.'
    }
    $text = $text.Replace($oldReady, $newReady)
}

$utf8NoBom = New-Object System.Text.UTF8Encoding($false)
[System.IO.File]::WriteAllText($modelPath, $text, $utf8NoBom)

Write-Host ''
Write-Host 'Levincia model readiness repair applied successfully.'
Write-Host 'Model.get() and method463() now re-check models after synchronous packed-cache loading.'
Write-Host 'Next: Maven clean -> compile -> run the client.'
