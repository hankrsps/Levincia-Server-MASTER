package com.ruse.world.content.globalBosses;

import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;

import java.util.concurrent.TimeUnit;

public class PlatinumGifting {
    private static long massMessageTimer = 0;
    public static int rng = 0,
            INTERVAL = 1 * 60 * 120_000;

    public static String getTimeLeft() {
        long ms = (INTERVAL - (System.currentTimeMillis() - massMessageTimer));
        if (amountSpawned == 0)
            ms = (INTERVAL - (System.currentTimeMillis() - massMessageTimer) - (45 * 120_000));

        return String.format("%dhr %dmin %ds", TimeUnit.MILLISECONDS.toHours(ms),
                TimeUnit.MILLISECONDS.toMinutes(ms) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(ms)),
                TimeUnit.MILLISECONDS.toSeconds(ms) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ms)));
    }

    public static int amountSpawned = 0;

    public static void initialize() {
        // massMessageTimer = System.currentTimeMillis();
        if (massMessageTimer == 0) {
            massMessageTimer = System.currentTimeMillis();
        }
        if (amountSpawned == 0 && (System.currentTimeMillis() - massMessageTimer >= (45 * 60_000))) {
            giveKey();
            amountSpawned++;
        }
        if ((System.currentTimeMillis() - massMessageTimer >= INTERVAL)) {
            giveKey();
        }
    }

    public static void giveKey() {
        Player player = null;

        int i = 0;

        while (player == null && i < 500) {
            player = World.getPlayers().get(Misc.getRandom(1 + World.getPlayers().size() - 1));
            if ( player != null && player.getInteractingObject() != null && (player.getInteractingObject().getId() == 22099
                    || player.getInteractingObject().getId() == 22098 || player.getInteractingObject().getId() == 22097
                    || player.getInteractingObject().getId() == 8455 || player.getInteractingObject().getId() == 8456
                    || player.getInteractingObject().getId() == 22768 || player.getInteractingObject().getId() == 22769
                    || player.getInteractingObject().getId() == 1333 || player.getInteractingObject().getId() == 26280 || player.getAmountDonated () < 20000) ) {


                player = null;
                continue;
            }
            i++;
        }


        if (player != null && player.getAmountDonated () > 20000) {
            player.getInventory().add(23447, 1);
            World.sendMessage("<shad=1><img=857><col=989794>[Platinum]<img=857> @red@"
                    + player.getUsername() + " <col=989794>was rewarded with @red@X1 Platinum key");}
        massMessageTimer = System.currentTimeMillis();
    }

}