# Levincia Custom Asset Library

This folder is the staging area for external, license-safe custom assets before they are converted for the Levincia client/cache.

## Folders

- `armor/` - wearable armor/outfit source models
- `wings/` - wearable wing/back-slot source models
- `auras/` - aura/VFX sprite sheets and effect sources
- `capes/` - cape/back-slot source models
- `pets/` - pet/companion source models
- `objects/` - scenery and world-object source models
- `effects/` - general spell/cosmetic VFX sources
- `converted/` - assets that have passed conversion and in-client testing

## Import rule

Do not pack an external asset directly into the live cache. Keep the original source in a staging folder, record its license/source, convert a copy, test it on a disposable custom ID, and only then promote the tested result into `converted/`.

## Initial compatibility targets

1. One CC0 armor/outfit piece
2. One CC0 wing/back-slot model
3. One CC0 animated aura

The goal of v1 is compatibility testing, not bulk importing. Once one asset of each type works, the pipeline can be expanded safely.

## Asset manifest

For every imported asset, add an entry to `ASSET-MANIFEST.csv` with its local name, category, source page, license, source format, target type, and conversion status.
