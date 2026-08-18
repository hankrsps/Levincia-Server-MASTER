$ErrorActionPreference = 'Stop'

$repoRoot = Split-Path -Parent $PSScriptRoot
$mobFile = Join-Path $repoRoot 'Levincia-Client-Master\Levincia-Client\src\main\java\org\necrotic\client\cache\definition\MobDefinition.java'

if (!(Test-Path $mobFile)) {
    throw "MobDefinition.java not found: $mobFile"
}

$text = [System.IO.File]::ReadAllText($mobFile)
$backup = "$mobFile.before-original-phase-restore"
if (!(Test-Path $backup)) {
    Copy-Item $mobFile $backup
    Write-Host "Backup created: $backup"
}

$replacement = @'
                        case 9001:
                                definition.name = "Phase [1]";
                                definition.actions = new String[]{null, "Attack", null, null, null};
                                definition.npcModels = MobDefinition.get(1).npcModels;
                                definition.npcSizeInSquares = 1;
                                definition.combatLevel = 10;
                                definition.standAnimation = MobDefinition.get(1).standAnimation;
                                definition.walkAnimation = MobDefinition.get(1).walkAnimation;
                                definition.scaleXZ = 130;
                                definition.scaleY = 130;
                                definition.drawYellowDotOnMap = true;
                                definition.originalModelColours = new int[1];
                                definition.changedModelColours = new int[1];
                                definition.changedModelColours[0] = 57;
                                definition.originalModelColours[0] = 104;
                                break;

                        case 9002: {
                                MobDefinition base = MobDefinition.get(9024);
                                definition.name = "Phase [2]";
                                definition.actions = new String[]{null, "Attack", null, null, null};
                                definition.npcModels = base.npcModels;
                                definition.npcSizeInSquares = base.npcSizeInSquares;
                                definition.combatLevel = 50;
                                definition.standAnimation = base.standAnimation;
                                definition.walkAnimation = base.walkAnimation;
                                definition.scaleXZ = 80;
                                definition.scaleY = 80;
                                definition.drawYellowDotOnMap = true;
                                break;
                        }

                        case 9003: {
                                MobDefinition base = MobDefinition.get(9025);
                                definition.name = "Phase [3]";
                                definition.actions = new String[]{null, "Attack", null, null, null};
                                definition.npcModels = base.npcModels;
                                definition.npcSizeInSquares = base.npcSizeInSquares;
                                definition.combatLevel = 100;
                                definition.standAnimation = base.standAnimation;
                                definition.walkAnimation = base.walkAnimation;
                                definition.scaleXZ = 100;
                                definition.scaleY = 100;
                                definition.drawYellowDotOnMap = true;
                                break;
                        }

                        case 9004: {
                                MobDefinition base = MobDefinition.get(9026);
                                definition.name = "Phase [4]";
                                definition.actions = new String[]{null, "Attack", null, null, null};
                                definition.npcModels = base.npcModels;
                                definition.npcSizeInSquares = base.npcSizeInSquares;
                                definition.combatLevel = 150;
                                definition.standAnimation = base.standAnimation;
                                definition.walkAnimation = base.walkAnimation;
                                definition.scaleXZ = 260;
                                definition.scaleY = 260;
                                definition.drawYellowDotOnMap = true;
                                break;
                        }

                        case 9005: {
                                MobDefinition base = MobDefinition.get(9027);
                                definition.name = "Phase [5]";
                                definition.actions = new String[]{null, "Attack", null, null, null};
                                definition.npcModels = base.npcModels;
                                definition.npcSizeInSquares = base.npcSizeInSquares;
                                definition.combatLevel = 225;
                                definition.standAnimation = base.standAnimation;
                                definition.walkAnimation = base.walkAnimation;
                                definition.scaleXZ = 105;
                                definition.scaleY = 105;
                                definition.drawYellowDotOnMap = true;
                                break;
                        }

                        case 9006: {
                                MobDefinition base = MobDefinition.get(9815);
                                definition.name = "Phase [6]";
                                definition.actions = new String[]{null, "Attack", null, null, null};
                                definition.npcModels = base.npcModels;
                                definition.npcSizeInSquares = base.npcSizeInSquares;
                                definition.combatLevel = 300;
                                definition.standAnimation = base.standAnimation;
                                definition.walkAnimation = base.walkAnimation;
                                definition.scaleXZ = 100;
                                definition.scaleY = 100;
                                definition.drawYellowDotOnMap = true;
                                break;
                        }
'@

$pattern = '(?ms)^\s*case\s+9001\s*:.*?(?=^\s*case\s+10050\s*:|^\s*case\s+9106\s*:|\z)'
$match = [regex]::Match($text, $pattern)
if (!$match.Success) {
    throw 'Could not locate the Phase 9001-9006 block in MobDefinition.java. Nothing was changed.'
}

$text = [regex]::Replace($text, $pattern, $replacement + "`r`n", 1)
[System.IO.File]::WriteAllText($mobFile, $text, [System.Text.UTF8Encoding]::new($false))

Write-Host ''
Write-Host 'Original Azura Phase definitions restored successfully.'
Write-Host '9001 -> NPC 1 geometry'
Write-Host '9002 -> NPC 9024 geometry'
Write-Host '9003 -> NPC 9025 geometry'
Write-Host '9004 -> NPC 9026 geometry'
Write-Host '9005 -> NPC 9027 geometry'
Write-Host '9006 -> NPC 9815 geometry'
Write-Host ''
Write-Host 'Next: rebuild/run the client and test Phase 1 through Phase 6.'
