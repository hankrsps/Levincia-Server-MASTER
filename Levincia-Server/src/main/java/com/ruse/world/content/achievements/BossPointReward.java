package com.ruse.world.content.achievements;

import com.ruse.world.entity.impl.player.Player;

/*
 * Project Levincia
 * Author @Levincia (AlwaysDreaming.ai@gmail.com)
 * Created on - 6/14/2022
 */

public class BossPointReward implements NonItemReward {

    private final int amount;

    public BossPointReward(int amount) {
        this.amount = amount;
    }

    @Override
    public void giveReward(Player player) {
        player.getPointsHandler().incrementBossPoints(amount);
    }

    @Override
    public String rewardDescription() {
        return "-" + amount + " MOB Points.";
    }
}
