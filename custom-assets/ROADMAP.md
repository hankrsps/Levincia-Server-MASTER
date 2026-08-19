# Levincia Custom Content Roadmap

This workspace tracks external CC0/custom assets before anything is introduced into the live client/cache.

## Phase A - Compatibility first

1. Armor: validate one wearable armor set.
2. Wings/capes: validate one back-slot cosmetic.
3. NPC/boss: validate one static NPC model, then animation compatibility.
4. Auras/VFX: validate one sprite/effect sequence separately from model imports.
5. Environment: validate one floor/wall/door/prop set before attempting a complete custom region.

## Asset families

- `armor/` wearable armor and clothing
- `wings/` wings and back-slot cosmetics
- `auras/` sprite/VFX sources
- `npcs/` creatures and boss candidates
- `maps/` environment pieces and map-kit sources
- `props/` reusable scenery and decorations
- `converted/` conversion outputs that have passed format checks
- `rejected/` assets found incompatible or unsuitable

## Recommended CC0 source families

- Quaternius Modular Dungeons Pack - modular dungeon environment pieces
- Quaternius Medieval Village MegaKit - large modular village/environment library
- Quaternius Ultimate Modular Ruins Pack - ruins/dungeon pieces
- Quaternius animated monster packs - NPC/boss candidates
- Quaternius fantasy character/outfit packs - armor/cosmetic candidates

Record every downloaded asset in `ASSET-MANIFEST.csv` with its exact source URL and license before conversion.

## Rules

- Never overwrite the live cache during compatibility analysis.
- Keep original downloads separate from converted files.
- Preserve license/source metadata.
- Test one representative asset per category before bulk conversion.
- Back up cache/client files before packing anything.
- Treat terrain/region conversion separately from scenery-object conversion.

## Levincia world targets

1. Custom home/town
2. Progression dungeon
3. Boss arena
4. Ruined castle
5. Underground cavern
6. Endgame island

The initial environment test should use a small modular dungeon room: floor + wall + doorway + one decoration. Once those objects render at the expected scale/orientation, expand to a complete room and then region-building experiments.
