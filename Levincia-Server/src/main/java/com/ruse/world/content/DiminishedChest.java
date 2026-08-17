package com.ruse.world.content;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Animation;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;

import java.util.HashMap;
import java.util.Map;

public class DiminishedChest {

	// We roll > 99 on random 1-100
	private static final int[] RARE_LOOTS = { 10793,10795,10823,10824,10825,10826,10827,10828,10829 };

	// if We roll < 99 on random 1-100
	private static final int[] COMMON_LOOTS = { 16465 };

	// A map that associates each item in RARE_LOOTS and COMMON_LOOTS with its corresponding amount
	private static final Map<Integer, Integer> LOOT_AMOUNTS = new HashMap<> ();
	static {
		LOOT_AMOUNTS.put (16465, 5 +Misc.getRandom (10));
		LOOT_AMOUNTS.put (10793, 1);
		LOOT_AMOUNTS.put (10795, 1);
		LOOT_AMOUNTS.put (10823, 1);
		LOOT_AMOUNTS.put (10824, 1);
		LOOT_AMOUNTS.put (10825, 1);
		LOOT_AMOUNTS.put (10826, 1);
		LOOT_AMOUNTS.put (10827, 1);
		LOOT_AMOUNTS.put (10828, 1);
		LOOT_AMOUNTS.put (10829, 1);

	}

	private static int getRandomItem(int[] array) {
		return array[Misc.getRandom(array.length - 1)];
	}

	public static void openChest(Player player) {
		if (player.getInventory().contains(10830)) {
			player.getInventory().delete(10830, 1);
			TaskManager.submit(new Task(2, player, false) {
				@Override
				public void execute() {
					player.getPacketSender().sendMessage("Opening Diminished Chest...");
					player.performAnimation(new Animation(827));
					giveReward(player);
					this.stop();

				}
			});
		} else {

			player.getPacketSender().sendMessage("@red@You require a Diminished Key to open this chest!");
			return;
		}
	}

	// Main method for determining roll
	public static void giveReward(Player player) {
		int commonDrop = getRandomItem(COMMON_LOOTS);
		int rareDrop = getRandomItem(RARE_LOOTS);
		int random = Misc.inclusiveRandom(1, 1000);
		int randomAmount = 1 + Misc.inclusiveRandom(1, 29);
		if (random < 999) {
			player.getInventory().add(commonDrop, randomAmount);
		} else {
			String message = "@blu@News: @red@" + player.getUsername() + " @blu@has received @red@"
					+ ItemDefinition.forId(rareDrop).getName() + "@blu@ from the Diminished chest!@red@";
			World.sendMessage1(message);
			int amount = LOOT_AMOUNTS.getOrDefault(rareDrop, 1);
			player.getInventory().add(rareDrop, amount);
		}
	}
}