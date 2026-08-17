package com.ruse.world.content.achievements;

import com.ruse.world.entity.impl.player.Player;

/*
 * Project Levincia
 * Author @Levincia (AlwaysDreaming.ai@gmail.com)
 * Created on - 6/14/2022
 */

public class VotingPointReward implements NonItemReward {

    private final int amount;

    public VotingPointReward(int amount) {
        this.amount = amount;
    }

    @Override
    public void giveReward(Player player) {
        player.getPointsHandler().incrementVotingPoints( + amount);
    }

    @Override
    public String rewardDescription() {
        return " Voting: " + amount ;
    }
}
