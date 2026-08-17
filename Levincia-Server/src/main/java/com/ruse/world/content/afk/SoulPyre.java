package com.ruse.world.content.afk;

import com.ruse.util.Misc;
import com.ruse.world.entity.impl.player.Player;

public class SoulPyre {

    private static final int BOSS_TOTAL = 500_000;
    private static final int URN_TOTAL = 350_000;

    // You need to store these globally somewhere in your game engine



    public static void openInterface(Player player) {
        // Calculate %s

        int soulsForUrn = player.getSealedUrnAmount();
        int bossPercent = (int) Math.ceil((AfkSystem.burnedSouls / (double) BOSS_TOTAL) * 100);
        bossPercent = Math.min(bossPercent, 100); // Clamp to 100%
               int keyPercent = (int) ((soulsForUrn / (double) URN_TOTAL) * 100);

        player.getPacketSender().sendProgressBar(143504, 0, bossPercent, 0);
        player.getPacketSender().sendProgressBar(143507, 0, keyPercent, 0);

        // Update text labels

        int soulsForBoss = AfkSystem.burnedSouls;
        player.getPacketSender().sendString(143505, bossPercent + "% (" +
                Misc.formatNumber(soulsForBoss) + "/" + Misc.formatNumber(BOSS_TOTAL) + ")");
        player.getPacketSender().sendString(143508, keyPercent + "% (" +
                Misc.formatNumber(soulsForUrn) + "/" + Misc.formatNumber(URN_TOTAL) + ")");

        // Finally open the interface
        player.getPacketSender().sendInterface(143500);
    }
}

