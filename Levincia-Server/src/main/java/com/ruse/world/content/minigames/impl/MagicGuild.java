package com.ruse.world.content.minigames.impl;

import com.ruse.world.entity.impl.player.Player;

public class MagicGuild {
    private final Player player;

    public MagicGuild(Player player) {this.player = player;}

    public void openMain() {
        player.getPacketSender().sendInterface(77130);
        player.getPacketSender().sendString(77140,  player.getPointsHandler().getBorkKC() >= 50000
                ? "@gre@- 50,000 Bork KC"
                : "@red@- 50,000 Bork KC");

    }

    public void openT1() {
        player.getPacketSender().sendInterface(77330);
        player.getPacketSender().sendString(77337,  player.getPointsHandler().getFacelessMagicianKC() >= 100_000
                ? "@gre@- 25,000 Faceless Magician KC"
                : "@red@- 25,000 Faceless Magician KC");

    }

    public void openT2() {
        player.getPacketSender().sendInterface(77430);
        player.getPacketSender().sendString(77437,  player.getPointsHandler().getLotusMagicianKC() >= 50000
                ? "@gre@- 50,000 Lotus Magician KC"
                : "@red@- 50,000 Lotus Magician KC");

    }

    public void openT3() {
        player.getPacketSender().sendInterface(77530);
        player.getPacketSender().sendString(77537,  player.getPointsHandler().getShadowMagicianKC() >= 150000
                ? "@gre@- 75,000 Shadow Magician KC"
                : "@red@- 75,000 Shadow Magician KC");

    }
}
