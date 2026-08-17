package com.ruse.world.content;

import com.ruse.model.GameMode;
import com.ruse.model.Item;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.util.RandomUtility;
import com.ruse.world.World;
import com.ruse.world.content.startertasks.StarterTasks;
import com.ruse.world.entity.impl.player.Player;

import java.util.HashMap;
import java.util.Map;

import static com.ruse.world.content.osrscollectionlog.LogType.BOXES;

public class MysteryBoxOpener {

	private Player player;

	public MysteryBoxOpener(Player player) {
		this.player = player;
	}

	private int openBox = -1;

	public int getOpenBox() {
		return openBox;
	}

	private int[] common, uncommon, rare;

	public void display(int boxId, String name, int[] common, int[] uncommon, int[] rare) {
		player.getPacketSender().sendInterface(48030);
		openBox = boxId;
		this.common = common;
		this.uncommon = uncommon;
		this.rare = rare;
		updateInterface(boxId, name, common, uncommon, rare);
	}
	public void backgroundDisplay(int boxId, String name, int[] common, int[] uncommon, int[] rare) {
		openBox = boxId;
		this.common = common;
		this.uncommon = uncommon;
		this.rare = rare;
	}
	private void updateInterface(int boxId, String name, int[] common, int[] uncommon, int[] rare) {

		for(int i = 0; i < 3; i++) {
			player.getPacketSender().resetItemsOnInterface(48051 + i * 10,150);
		}
		player.getPacketSender().sendString(48035, name);
		player.getPacketSender().sendItemOnInterface(48045, boxId, 0, 1);

		for (int i = 0; i < common.length; i++) {
			player.getPacketSender().sendItemOnInterface(48051, common[i], i, 1);
		}

		for (int i = 0; i < uncommon.length; i++) {
			player.getPacketSender().sendItemOnInterface(48061, uncommon[i], i, 1);
		}

		for (int i = 0; i < rare.length; i++) {
			player.getPacketSender().sendItemOnInterface(48071, rare[i], i, 1);
		}

	}

	public void open(int boxId) {
		int reward = -1;
		int chance = RandomUtility.inclusiveRandom(0, 100);
		String name = ItemDefinition.forId(boxId).getName();

		StarterTasks.doProgress(player, StarterTasks.StarterTask.OPEN_BOXES);
		if (chance > 95) {
			reward = rare[RandomUtility.exclusiveRandom(0, rare.length)];
			if ( reward == 10942 || reward == 6769 || reward == 10935 || reward == 10934 || reward == 10943) { // OH LOL oh lol
				reward = rare[RandomUtility.exclusiveRandom(0, rare.length)];
				World.sendMessage("@blu@<img=832>News: @red@"+ player.getUsername() + " @blu@has received @red@" + ItemDefinition.forId(reward).getName() + " @blu@from a @red@ " + ItemDefinition.forId(boxId).getName()+ "" );
			}
		} else if (chance > 65) {
			reward = uncommon[RandomUtility.exclusiveRandom(0, uncommon.length)];
		}
		else if (chance >= 0) {
			reward = common[RandomUtility.exclusiveRandom(0, common.length)];
		}
		int rngRoll = Misc.getRandom(1, 100);
		if (player.isMembershipUnlocked() && rngRoll > 90) {
			player.getInventory().add(boxId, 1);
			if (player.membershipMessages)
			player.getPacketSender().sendMessage("You kept your " + ItemDefinition.forId(boxId).getName() +" with your Membership status.");
		}
		if (player.getInventory().contains(23401) && Misc.getRandom(1,10) == 3) {
			player.getInventory().delete(23401, 1);
			player.getInventory().add(boxId, 1);
			player.getPacketSender().sendMessage("<img=832>@red@You kept your " + ItemDefinition.forId(boxId).getName() +" and a Scroll of Insurance is consumed.");
		}
		player.getInventory().delete(boxId, 1);
		player.getInventory().add(reward, 1);
		BOXES.log(player, boxId, new Item(reward));
		player.getDailyTaskManager().submitProgressToIdentifier(5, 1);
	}

	public void openAll(int boxId) {

		int amount = player.getInventory().getAmount(boxId);
		StarterTasks.doProgress(player, StarterTasks.StarterTask.OPEN_BOXES, amount);
		Map<Integer, Integer> rewards = new HashMap<>();
		for (int i = 0; i < amount; i++) {
			int reward = -1;
			int chance = RandomUtility.inclusiveRandom(0, 100);
			String name = ItemDefinition.forId(boxId).getName();
			if (chance > 95) {
				reward = rare[RandomUtility.exclusiveRandom(0, rare.length)];

				if ( reward == 10942 || reward == 6769 || reward == 10935 || reward == 10934 || reward == 10943) {
					reward = rare[RandomUtility.exclusiveRandom(0, rare.length)];
					World.sendMessage("@blu@<img=832>News: @red@"+ player.getUsername() +" @blu@has received @red@" + ItemDefinition.forId(reward).getName() + " @blu@from a @red@ " + ItemDefinition.forId(boxId).getName()+ "" );
				}

			} else if (chance > 65) { //65% of 100% = 35% (remainder)
				reward = uncommon[RandomUtility.exclusiveRandom(0, uncommon.length)];
			} else if (chance >= 0) { //0% of 100% = 55% (remainder)
				reward = common[RandomUtility.exclusiveRandom(0, common.length)]; // ye its correct.
			}

			rewards.merge(reward, 1, Integer::sum);

			BOXES.log(player, boxId, new Item(reward));
			if (player.getInventory().contains(23401) && Misc.getRandom(1,10) == 3) {
				player.getInventory().delete(23401, 1);
				player.getInventory().add(boxId, 1);
				player.getPacketSender().sendMessage("<img=832>@red@You kept your " + ItemDefinition.forId(boxId).getName() +" and a Scroll of Insurance is consumed.");
			}
		}

		player.getInventory().delete(boxId, amount);

		player.getDailyTaskManager().submitProgressToIdentifier(5, amount);
		boolean bank = amount <= player.getInventory().getFreeSlots();
		rewards.forEach((key, value) -> {
			if (bank) {
				player.getInventory().add(new Item(key, value), false);
			} else {
				Item item = new Item(key, value);
				if (player.getGameMode() == GameMode.ULTIMATE_IRONMAN)
				player.getUimBank().deposit(key, value);
				player.depositItemBank(item, false);
			}
		});
		player.getInventory().refreshItems();

		if(!bank) {
			player.sendMessage("@blu@Your rewards have been added to your bank.");
		}

	}

	public void openAllRaids2Chest(int boxId) {
		int amount = player.getInventory().getAmount(boxId);
		Map<Integer, Integer> rewards = new HashMap<>();
		for (int i = 0; i < amount; i++) {
			int reward = -1;
			int value = 1;
			int chance = RandomUtility.inclusiveRandom(0, 500);
			String name = ItemDefinition.forId(boxId).getName();
			if (chance > 499) {
				reward = rare[RandomUtility.exclusiveRandom(0, rare.length)];

				if ( reward == 23303 || reward == 23304 || reward == 23305 || reward == 23306 || reward == 23307
						|| reward == 23308|| reward == 23309|| reward == 23310|| reward == 23311|| reward == 14999
						|| reward == 23276|| reward == 23403) {
					reward = rare[RandomUtility.exclusiveRandom(0, rare.length)];
					World.sendMessage("@blu@<img=832>News: @red@"+ player.getUsername() +" @blu@has received @red@" + ItemDefinition.forId(reward).getName() + " @blu@from a @red@ " + ItemDefinition.forId(boxId).getName()+ "" );
				}
			} else if (chance >= 0) { //0% of 100% = 55% (remainder)
				reward = common[RandomUtility.exclusiveRandom(0, common.length)]; // ye its correct.
			}
			if (reward == 12855) {
				value = Misc.getRandom(1,5);
			} else
			if (reward == 5022) {
				value = Misc.getRandom(1,100_000);
			} else
			if (reward == 7956) {
				value = Misc.getRandom(1,5000);
			} else
			if (reward == 19114) {
				value = Misc.getRandom(1,50);
			} else
			if (reward == 20488) {
				value = Misc.getRandom(1,5);
			} else
			if (reward == 11137) {
				value = Misc.getRandom(1,75);
			} else
			if (reward == 23321) {
				value = Misc.getRandom(1,20);
			} else
			if (reward == 22006) {
				value = Misc.getRandom(1,25);
			} else
				value = 1;
			rewards.merge(reward, value, Integer::sum);
			BOXES.log(player, boxId, new Item(reward));
			if (player.getInventory().contains(23401) && Misc.getRandom(1,10) == 3) {
				player.getInventory().delete(23401, 1);
				player.getInventory().add(boxId, 1);
				player.getPacketSender().sendMessage("<img=832>@red@You kept your " + ItemDefinition.forId(boxId).getName() +" and a Scroll of Insurance is consumed.");
			}
		}

		player.getInventory().delete(boxId, amount);
		boolean bank = amount <= player.getInventory().getFreeSlots();
		rewards.forEach((key, value) -> {
			if (bank) {
				player.getInventory().add(new Item(key, value), false);
			} else {
				Item item = new Item(key, value);
				player.depositItemBank(item, false);
			}
		});
		player.getInventory().refreshItems();

		if(!bank) {
			player.sendMessage("@blu@Your rewards have been added to your bank.");
		}

	}

}
