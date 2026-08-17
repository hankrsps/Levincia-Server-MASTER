package com.ruse.world.content.boxes;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Animation;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;

import java.util.HashMap;
import java.util.Map;

public class PlatinumChest {

	// We roll > 99 on random 1-100
	private static final int[] RARE_LOOTS = { 6769, 10942, 15003, 22209, 10503, 10585, 10587, 10598, 11425, 10483, 10484, 10485, 10486 };

	// if We roll < 99 on random 1-100
	private static final int[] COMMON_LOOTS = { 15288, 20488, 19114, 10946, 19115, 23215, 22219, 23264 };

	// A map that associates each item in RARE_LOOTS and COMMON_LOOTS with its corresponding amount
	private static final Map<Integer, Integer> LOOT_AMOUNTS = new HashMap<> ();
	static {
		LOOT_AMOUNTS.put (6769, 1 +Misc.getRandom (2));
		LOOT_AMOUNTS.put (10942, 1);
		LOOT_AMOUNTS.put (15003, 1);
		LOOT_AMOUNTS.put (22209, 2 +Misc.getRandom (2));
		LOOT_AMOUNTS.put (10503, 1);
		LOOT_AMOUNTS.put (10585, 1);
		LOOT_AMOUNTS.put (10587, 1);
		LOOT_AMOUNTS.put (10598, 1);
		LOOT_AMOUNTS.put (11425, 1);
		LOOT_AMOUNTS.put (10483, 1);
		LOOT_AMOUNTS.put (10484, 1);
		LOOT_AMOUNTS.put (10485, 1);
		LOOT_AMOUNTS.put (10486, 1);
		LOOT_AMOUNTS.put (15288, 2 +Misc.getRandom (5));
		LOOT_AMOUNTS.put (20488, 2 +Misc.getRandom (2));
		LOOT_AMOUNTS.put (19114, 3 +Misc.getRandom (22));
		LOOT_AMOUNTS.put (10946, 1 +Misc.getRandom (3));
		LOOT_AMOUNTS.put (19115, 5 +Misc.getRandom (45));
		LOOT_AMOUNTS.put (23215, 2 +Misc.getRandom (3));
		LOOT_AMOUNTS.put (22219, 1 +Misc.getRandom (2));
		LOOT_AMOUNTS.put (23264, 5 +Misc.getRandom (5));

	}

	private static int getRandomItem(int[] array) {
		return array[Misc.getRandom(array.length - 1)];
	}

	public static void openChest(Player player) {
		if (player.getInventory().contains(23447)) {
			player.getInventory().delete(23447, 1);
			TaskManager.submit(new Task(2, player, false) {
				@Override
				public void execute() {
					player.getPacketSender().sendMessage("Opening Platinum Chest...");
					player.performAnimation(new Animation(827));
					giveReward(player);
					this.stop();

				}
			});
		} else {

			player.getPacketSender().sendMessage("@red@You require a Platinum Key to open this chest!");
			return;
		}
	}

	// Main method for determining roll
	public static void giveReward(Player player) {
		int commonDrop = getRandomItem(COMMON_LOOTS);
		int rareDrop = getRandomItem(RARE_LOOTS);
		int random = Misc.inclusiveRandom(1, 100);
		if (random < 99) {
			int commonamount = LOOT_AMOUNTS.getOrDefault(rareDrop, 1);
			player.getInventory().add(commonDrop, commonamount);
		} else {
			String message = "@blu@News: @red@" + player.getUsername() + " @blu@has received @red@"
					+ ItemDefinition.forId(rareDrop).getName() + "@blu@ from the Platinum chest!@red@";
			World.sendMessage1(message);
			int amount = LOOT_AMOUNTS.getOrDefault(rareDrop, 1);
			player.getInventory().add(rareDrop, amount);
		}
	}
}