package com.ruse.world.content.skill.impl.prayer;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Animation;
import com.ruse.model.Item;
import com.ruse.model.Skill;
import com.ruse.world.content.Sounds;
import com.ruse.world.content.Sounds.Sound;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.entity.impl.player.Player;

/**
 * The prayer skill is based upon burying the corpses of enemies. Obtaining a
 * higher level means more prayer abilities being unlocked, which help out in
 * combat.
 * 
 * @author Gabriel Hannason
 */

public class Prayer {

	public static boolean isBone(int bone) {
		return BonesData.forId(bone) != null;
	}

	public static void buryBone(final Player player, final int itemId) {
		if (!player.getClickDelay().elapsed(2000))
			return;
		final BonesData currentBone = BonesData.forId(itemId);
		if (currentBone == null)
			return;
		player.getSkillManager().stopSkilling();
		player.getPacketSender().sendInterfaceRemoval();
		player.performAnimation(new Animation(827));
		player.getPacketSender().sendMessage("You dig a hole in the ground..");
		final Item bone = new Item(itemId);
		player.getInventory().delete(bone);


		TaskManager.submit(new Task(3, player, false) {
			@Override
			public void execute() {
				player.getPacketSender().sendMessage("..and bury the " + bone.getDefinition().getName() + ".");
				player.getSkillManager().addExperience(Skill.PRAYER, currentBone.getBuryingXP());
				Sounds.sendSound(player, Sound.BURY_BONE);

				player.getAchievementTracker().progress(AchievementData.PRAYER, 1);
				player.getAchievementTracker().progress(AchievementData.PRAYER_RITUAL, 1);
				player.getAchievementTracker().progress(AchievementData.PRAYER_DEVOTION, 1);
				player.getAchievementTracker().progress(AchievementData.BURY_ALOT, 1);


				stop();
			}
		});
		player.getClickDelay().reset();
	}
}
