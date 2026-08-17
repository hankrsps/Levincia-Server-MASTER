package com.ruse.world.content.achievements;

import com.ruse.world.entity.impl.player.Player;

/*
 * Project Levincia
 * Author @Levincia (AlwaysDreaming.ai@gmail.com)
 * Created on - 6/14/2022
 */

public interface NonItemReward {
    void giveReward(Player player);

    String rewardDescription();
}
