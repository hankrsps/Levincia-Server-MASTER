# Levincia Beginner Phase

This document is the minimum playable baseline before wider beta/content expansion.

## Already in the project

- Levincia server branding through `GameSettings.RSPS_NAME`.
- First-time tutorial framework.
- Starter kits and IP starter protection.
- Starter task system and handler.
- Shops, skilling, teleport, NPC interaction and command systems.
- Existing bosses/minigames and progression content.
- Custom progression weapons/combat fixes from the current Levincia work.
- Angel Wings custom wearable pipeline.
- Loose sprite 449 login override for custom Levincia login art.

## Beginner-phase fixes applied by `tools/install-beginner-phase.ps1`

- Re-enable tutorial stages 1-12 instead of skipping directly from stage 0 to stage 13.
- Clean tutorial wording/typos.
- Replace obsolete tutorial wiki wording with Levincia website/Discord guidance.
- Update old Discord invite references to the active Levincia invite.
- Replace old beta-sale/Hank login banner text with an evergreen Levincia/Xslayer beginner message.
- Apply the sprite 449 login override so the packed legacy login artwork can be bypassed safely.
- Generate a local smoke-test report under `.Levincia`.

## Required smoke test before calling beginner phase complete

1. Fresh account reaches difficulty selection and completes the full tutorial in sequence.
2. Starter kit can be received once, including Ironman/Ultimate variants.
3. Starter tasks open, update, reward, and persist after relog.
4. Home shops and bank work.
5. Skill teleports and combat/boss teleports work.
6. Melee/range/magic progression weapons equip and attack with the intended animation/spell behavior.
7. Angel Wings equip in the cape/back slot and remain visible after relog.
8. Login screen is Levincia/Xslayer branded and the login controls remain clickable.
9. `::discord`, vote/store/support links point to valid Levincia destinations.
10. No startup exceptions, cache repack errors, or player-save corruption during a clean restart/relog cycle.

## Next content phase after beginner baseline

- Multiple wing variants and aura cosmetics.
- New custom armor families with correct equipment models/slots.
- Curated boss roster and drop progression.
- New maps/zones once cache compatibility is proven.
- Economy/drop-rate balancing after real player testing.
- Launcher/updater and website polish after the gameplay loop is stable.
