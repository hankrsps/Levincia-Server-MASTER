$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$spritesMap = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\graphics\SpritesMap.java'
$clientJava = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\Client.java'
$loginPng = Join-Path $env:USERPROFILE '.Levincia\levincia_login.png'
$stamp = Get-Date -Format 'yyyyMMdd-HHmmss'

Write-Host ''
Write-Host '=== Levincia Login Sprite 449 Override Installer ==='

foreach ($f in @($spritesMap,$clientJava,$loginPng)) {
    if (!(Test-Path -LiteralPath $f)) { throw "Missing required file: $f" }
}

# Patch SpritesMap.get() so sprite 449 comes from the loose Levincia login PNG.
$text = [System.IO.File]::ReadAllText($spritesMap)
$original = $text
$needle = @'
	public Sprite get(int id) {
		if (id < 0) {
'@
$replacement = @'
	public Sprite get(int id) {
		if (id == 449) {
			try {
				File customLogin = new File(System.getProperty("user.home") + File.separator + ".Levincia" + File.separator + "levincia_login.png");
				if (customLogin.exists()) {
					BufferedImage image = ImageIO.read(customLogin);
					if (image != null) {
						if (image.getType() != BufferedImage.TYPE_INT_ARGB) {
							image = convert(image, BufferedImage.TYPE_INT_ARGB);
						}
						int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
						Sprite sprite = new Sprite(image.getWidth(), image.getHeight(), 0, 0, pixels);
						map.put(id, sprite);
						System.out.println("[LEVINCIA-LOGIN] Loaded loose sprite 449: " + customLogin.getAbsolutePath());
						return sprite;
					}
				}
			} catch (IOException e) {
				System.err.println("[LEVINCIA-LOGIN] Failed loading loose sprite 449: " + e.getMessage());
			}
		}
		if (id < 0) {
'@

if ($text.Contains('[LEVINCIA-LOGIN] Loaded loose sprite 449')) {
    Write-Host '[OK] SpritesMap.java already has the sprite 449 override.'
} elseif ($text.Contains($needle)) {
    Copy-Item -LiteralPath $spritesMap -Destination "$spritesMap.login449-backup-$stamp" -Force
    $text = $text.Replace($needle,$replacement)
    [System.IO.File]::WriteAllText($spritesMap,$text,(New-Object System.Text.UTF8Encoding($false)))
    Write-Host '[OK] Patched SpritesMap.java: sprite 449 now loads .Levincia\levincia_login.png first.'
} else {
    throw 'Could not find SpritesMap.get() insertion point. Nothing changed.'
}

# Replace player-visible Hank branding in the scrolling login banner only.
$c = [System.IO.File]::ReadAllText($clientJava)
$cOriginal = $c
$c = $c.Replace('Owner/Developer: Hank_rsps','Owner/Developer: Xslayer')
$c = $c.Replace('Owner/Developer: Hank','Owner/Developer: Xslayer')
if ($c -ne $cOriginal) {
    Copy-Item -LiteralPath $clientJava -Destination "$clientJava.login-branding-backup-$stamp" -Force
    [System.IO.File]::WriteAllText($clientJava,$c,(New-Object System.Text.UTF8Encoding($false)))
    Write-Host '[OK] Changed login banner owner branding to Xslayer.'
} else {
    Write-Host '[OK] Login banner already uses Xslayer or no Hank banner text was present.'
}

Write-Host ''
Write-Host '[OK] No packed sprite DAT/IDX files were modified.'
Write-Host '[OK] Existing login controls remain unchanged.'
Write-Host ''
Write-Host 'NEXT:'
Write-Host '1. Completely close the client.'
Write-Host '2. Rebuild the client from source.'
Write-Host '3. Start it and look for:'
Write-Host '   [LEVINCIA-LOGIN] Loaded loose sprite 449:'
Write-Host '4. The old Avalon background/logo should be replaced by levincia_login.png.'
