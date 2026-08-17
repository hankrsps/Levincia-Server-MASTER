package com.ruse.world.content.randomevents;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Animation;
import com.ruse.model.GameObject;
import com.ruse.model.Position;
import com.ruse.util.Misc;
import com.ruse.util.Stopwatch;
import com.ruse.world.World;
import com.ruse.world.content.CustomObjects;
import com.ruse.world.content.PlayerPanel;
import com.ruse.world.content.Sounds;
import com.ruse.world.content.Sounds.Sound;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.casketopening.BoxLoot;
import com.ruse.world.entity.impl.player.Player;

import java.util.HashMap;
import java.util.Map;

//import com.ruse.tools.discord.DiscordConstant;
//import com.ruse.tools.discord.DiscordManager;

public final class LootChest {

	/**
	 * @author Crimson 6/10/2017
	 */

	private static int TIME = 1_000_000;// 1_000_000;
	private static int tickDelay = 30, maxLoot = 5;
	private static Stopwatch timer = new Stopwatch().reset();
	public static SpawnedChest LOOT_CHEST = null;
	private static LocationData PREVIOUS_LOC = null;
	public static int rewards[] = {21211};
	private static boolean firstTime = true;

	public static int getRandomItem(int[] array) {
		return array[Misc.getRandom(array.length - 1)];
	}

	public static void handleAction(Player player, GameObject object) {

		int reward = getRandomItem(rewards);
			player.setEntityInteraction(object);
				int delay = Misc.getRandom(5);
				player.setCurrentTask(new Task(1, player, false) {
					int cycle = 0, reqCycle = delay >= 2 ? delay : Misc.getRandom(1) + 1;


					@Override
					public void execute() {
						if (player.isChestLooted()) {
							player.sendMessage("You can only search the loot chest once each respawn!");
						this.stop();
						return;
					}

						if (player.getInventory().getFreeSlots() == 0) {
							player.performAnimation(new Animation(65535));
							player.getPacketSender().sendMessage("You don't have enough free inventory space.");
							this.stop();
							return;
						}

						if (cycle != reqCycle || (!player.isChestLooted())) {
							cycle++;
							player.setChestLooted(true);
							player.performAnimation(new Animation(827));
							LOOT_CHEST.getChestObject().incrementPickAmount();
							if (LOOT_CHEST.getChestObject().getPickAmount() < 5)
								World.sendMessage("@blu@[Loot Chest]: @red@A player has found the loot chest. @blu@" + (5 - LOOT_CHEST.getChestObject().getPickAmount()) + "/5@red@ keys left!");
							LootChest.handleReward(player);
							this.stop();
								} else
									if (cycle >= reqCycle) {
							cycle = 0;
							this.stop();
						}

						Sounds.sendSound(player, Sound.PICKUP_ITEM);
					}
				});
				TaskManager.submit(player.getCurrentTask());
		}


	public static class SpawnedChest {

		public SpawnedChest(GameObject chestObject, LocationData chestLocation) {
			this.chestObject = chestObject;
			this.chestLocation = chestLocation;
		}

		private GameObject chestObject;
		private LocationData chestLocation;

		public GameObject getChestObject() {
			return chestObject;
		}

		public LocationData getChestLocation() {
			return chestLocation;
		}
	}

	public static Box[] loot = { //
			new Box(15288, 1, 2, 3),
			new Box(15290, 2, 5, 25),
			new Box(15289, 1, 2, 20),
			new Box(19116, 5, 10, 50),
			new Box(19115, 3, 7, 50),
			new Box(19114, 2, 5, 33),
			new Box(20488, 1, 3, 20),
			new Box(10946, 1, 1, 1, true),
			new Box(15003, 1, 1, 1, true),
			new Box(15002, 1, 1, 0.75, true),
			new Box(6769, 1, 1, 0.75, true),
			new Box(14999, 1, 1, 0.25, true),
			new Box(10942, 1, 1, 0.25, true),
			new Box(3578, 1, 1, 0.1, true),
	};

	public static void handleReward(Player player) {
			Box box = BoxLoot.getLoot(loot);
			player.getInventory().add(box.getId(), box.getAmount());
	}

	public static enum LootChestDef {

		LOOT_CHEST("Loot chest", 13291, 20488,maxLoot);

		private String chestName;
		private int id;
		private int reward;
		private int maximumLootingAmount;

		private LootChestDef(String chestName, int id, int reward, int maxLootAmount) {
			this.chestName = chestName;
			this.id = id;
			this.reward = reward;
			this.maximumLootingAmount = maxLootAmount;
		}

		public String getChestName() {
			return chestName;
		}

		public int getId() {
			return id;
		}

		/**
		 * @return the log
		 */
		public int getReward() {
			return reward;
		}

		public int getMaxLootingAmount() {
			return maximumLootingAmount;
		}

		private static final Map<Integer, LootChestDef> chest = new HashMap<Integer, LootChestDef>();

		public static LootChestDef forId(int id) {
			return chest.get(id);
		}

		static {
			for (LootChestDef w : LootChestDef.values())

				chest.put(w.id, w);

		}

	}

	public static enum LocationData {
		AL_KHARID_NORTH(new Position(2527, 2521), "Al Kharid (North)", "@whi@Al Kharid (North)"),
		AL_KHARID_EAST(new Position(3316, 3175), "Al Kharid (East)", "@whi@Al Kharid (East)"),
		AL_KHARID_WEST(new Position(3270, 3167), "Al Kharid (West)", "@whi@Al Kharid (West)"),

		ARDOUGNE_NORTH(new Position(2659, 3322), "Ardougne (North)", "@whi@Ardougne (North)"),
		ARDOUGNE_EAST(new Position(2673, 3305), "Ardougne (East)", "@whi@Ardougne (East)"),
		ARDOUGNE_WEST(new Position(2646, 3307), "Ardougne (West)", "@whi@Ardougne (West)"),

		CAMELOT_NORTH(new Position(2758, 3486), "Camelot (North)", "@whi@Camelot (North)"),
		CAMELOT_EAST(new Position(2774, 3475), "Camelot (East)", "@whi@Camelot (East)"),
		CAMELOT_WEST(new Position(2739, 3479), "Camelot (West)", "@whi@Camelot (West)"),
		;
		private LocationData(Position spawnPos, String clue, String playerPanelFrame) {
			this.spawnPos = spawnPos;
			this.clue = clue;
			this.playerPanelFrame = playerPanelFrame;
		}

		private Position spawnPos;
		private String clue;
		public String playerPanelFrame;
	}

	public static LocationData getRandom() {
		LocationData chest = LocationData.values()[Misc.getRandom(LocationData.values().length - 1)];
		return chest;
	}

	public static LootChestDef getRandomChest() {
		LootChestDef chest = LootChestDef.values()[Misc.getRandom(LootChestDef.values().length - 1)];
		return chest;
	}

	public static void sequence() {
		if (LOOT_CHEST == null) {
			if (timer.elapsed(TIME) || firstTime) {
				if (firstTime == true) {
					firstTime = false;
				}
				LocationData locationData = getRandom();
				LootChestDef chest = getRandomChest();
				if (PREVIOUS_LOC != null) {
					if (locationData == PREVIOUS_LOC) {
						locationData = getRandom();
					}
				}
				PREVIOUS_LOC = locationData;
				LOOT_CHEST = new SpawnedChest(new GameObject(chest.getId(), locationData.spawnPos), locationData);
				CustomObjects.spawnGlobalObject(LOOT_CHEST.chestObject);
				World.sendMessage("@blu@[Event]: @red@A Loot chest has spawned at " + locationData.clue + ".");
				World.getPlayers().forEach(p -> PlayerPanel.refreshPanel(p));

				timer.reset();
			}
		} else {
			if (LOOT_CHEST.chestObject.getPickAmount() >= maxLoot) {
				despawn(true);
				timer.reset();
			}
		}
	}
	public static LocationData getLocation() {
		return PREVIOUS_LOC;
	}
	public static void despawn(boolean respawn) {
		if (respawn) {
			timer.reset(0);
		} else {
			timer.reset();
		}
		if (LOOT_CHEST != null) {
			for (Player p : World.getPlayers()) {
				if (p == null) {
					continue;
				}

				if (p.getInteractingObject() != null
						&& p.getInteractingObject().getId() == LOOT_CHEST.chestObject.getId()) {
					PREVIOUS_LOC = null;
					p.performAnimation(new Animation(65535));
					p.getPacketSender().sendClientRightClickRemoval();
					p.getSkillManager().stopSkilling();
					p.setChestLooted(false);
				}
			}
			CustomObjects.deleteGlobalObject(LOOT_CHEST.chestObject);
			World.sendMessage("@blu@[Loot Chest]: @red@The Loot chest has been fully looted and will respawn in 1 hour.");
			LOOT_CHEST = null;
			for (Player p : World.getPlayers()) {
				if (p == null) {
					continue;
				}
				PlayerPanel.refreshPanel(p);
			}
		}
	}
}