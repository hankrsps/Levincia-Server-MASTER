package com.ruse.world.content.skill.impl.thieving;

import com.ruse.model.Animation;
import com.ruse.model.GameObject;
import com.ruse.model.Item;
import com.ruse.model.Skill;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.entity.impl.player.Player;

public class Stalls {

    public static void stealFromStall(Player player, GameObject  gameObject, int lvlreq, int xp, Item reward, String message) {
        if (player.getInventory().getFreeSlots() < 1) {
            player.getPacketSender().sendMessage("You need some more inventory space to do this.");
            return;
        }
        if (player.getCombatBuilder().isBeingAttacked()) {
            player.getPacketSender()
                    .sendMessage("You must wait a few seconds after being out of combat before doing this.");
            return;
        }
        if (!player.getClickDelay().elapsed(2000))
            return;
        if (player.getSkillManager().getMaxLevel(Skill.THIEVING) < lvlreq) {
            player.getPacketSender()
                    .sendMessage("You need a Thieving level of at least " + lvlreq + " to steal from this stall.");
            return;
        }

        player.performAnimation(new Animation(881));
        player.getPacketSender().sendInterfaceRemoval();
        player.getAchievementTracker().progress(AchievementData.THIEVING, 1);
        player.getSkillManager().addExperience(Skill.THIEVING, xp);
        player.getClickDelay().reset();
        {
            player.getPacketSender().sendMessage(message);
            player.getInventory().add(reward);
        }
        player.getSkillManager().stopSkilling();
    }
}
