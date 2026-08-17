package com.ruse.world.content.achievements;

import com.ruse.model.Skill;
import com.ruse.world.entity.impl.player.Player;

/*
 * Project Levincia
 * Author @Levincia (AlwaysDreaming.ai@gmail.com)
 * Created on - 6/14/2022
 */

public class ExpReward implements NonItemReward {

    private final Skill skill;
    private final int experience;

    public ExpReward(Skill skill, int experience) {
        this.skill = skill;
        this.experience = experience;
    }

    @Override
    public void giveReward(Player player) {
        player.getSkillManager().addExperience(skill, experience);
    }

    @Override
    public String rewardDescription() {
        return "-" + experience + " " + skill.getFormatName() + " XP.";
    }
}
