package com.ruse.world.content.minigames.impl;

import com.ruse.world.entity.impl.player.Player;

public class WarriorGuild {
    private final Player player;

    public WarriorGuild(Player player) {this.player = player;}

    public void openMain() {
        player.getPacketSender().sendInterface(71500);
        player.getPacketSender().sendString(71510,  player.getPointsHandler().getBorkKC() >= 50000
                ? "@gre@- 50,000 Bork KC"
                : "@red@- 50,000 Bork KC");

    }

    public void openT1() {
        player.getPacketSender().sendInterface(71520);
        player.getPacketSender().sendString(71527,  player.getPointsHandler().getLesarkusWarriorKC() >= 25000
                ? "@gre@- 25,000 Lesarkus Warrior KC"
                : "@red@- 25,000 Lesarkus Warrior KC");

    }

    public void openT2() {
        player.getPacketSender().sendInterface(71560);
        player.getPacketSender().sendString(71567,  player.getPointsHandler().getVampireWarriorKC() >= 50000
                ? "@gre@- 50,000 Fatal Warrior KC"
                : "@red@- 50,000 Fatal Warrior KC");

    }

    public void openT3() {
        player.getPacketSender().sendInterface(80560);
        player.getPacketSender().sendString(80567,  player.getPointsHandler().getAncientWarriorKC() >= 75000
                ? "@gre@- 75,000 Immortal Warrior KC"
                : "@red@- 75,000 Immortal Warrior KC");

    }
}
