package com.ruse.world.content.minigames.impl;

import com.ruse.world.entity.impl.player.Player;

public class ArcherGuild {
    private final Player player;

    public ArcherGuild(Player player) {this.player = player;}

    public void openMain() {
        player.getPacketSender().sendInterface(88130);
        player.getPacketSender().sendString(88140,  player.getPointsHandler().getBorkKC() >= 50000
                ? "@gre@- 50,000 Bork KC"
                : "@red@- 50,000 Bork KC");

    }

    public void openT1() {
        player.getPacketSender().sendInterface(88330);
        player.getPacketSender().sendString(88337,  player.getPointsHandler().getForestArcherKC() >= 25000
                ? "@gre@- 25,000 Forest Archer KC"
                : "@red@- 25,000 Forest Archer KC");

    }

    public void openT2() {
        player.getPacketSender().sendInterface(88430);
        player.getPacketSender().sendString(88437,  player.getPointsHandler().getChaoticArcherKC() >= 50000
                ? "@gre@- 50,000 Chaotic Archer KC"
                : "@red@- 50,000 Chaotic Archer KC");

    }

    public void openT3() {
        player.getPacketSender().sendInterface(88530);
        player.getPacketSender().sendString(88537,  player.getPointsHandler().getDivineArcherKC() >= 75000
                ? "@gre@- 75,000 Divine Archer KC"
                : "@red@- 75,000 Divine Archer KC");

    }
}
