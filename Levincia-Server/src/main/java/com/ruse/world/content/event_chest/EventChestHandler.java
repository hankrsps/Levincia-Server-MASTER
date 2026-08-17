package com.ruse.world.content.event_chest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.ruse.model.Item;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class EventChestHandler {

    private static String DIR = "./data/saves/eventChest/";

	public List<ChestRewards> TIER_1_REWARDS = new ArrayList<>();

	public List<ChestRewards> TIER_2_REWARDS = new ArrayList<>();

	private TierType tierType;

	private TierType serverTierSelected;

	public Item TIER_1_PRIZE;

	public Item TIER_2_PRIZE;

	public int TIMES_ROLLED_TIER_1 = 0;

	public int MAX_ROLLS_TIER_1 = 57;

	public int TIMES_ROLLED_TIER_2 = 0;

	public int MAX_ROLLS_TIER_2 = 41;

	public void generateRewards(Player player) {
		if (player.getEventChestHandler().TIER_1_REWARDS.isEmpty()) {
			Item firstGoldReward_Tier1 = RewardsEnum.TIER_1.getFirstGoldReward()[Misc
					.random(RewardsEnum.TIER_1.getFirstGoldReward().length - 1)];

			Item secondGoldReward_Tier1 = RewardsEnum.TIER_1.getSecondGoldReward()[Misc
					.random(RewardsEnum.TIER_1.getSecondGoldReward().length - 1)];
			Item thirdGoldReward_Tier1 = RewardsEnum.TIER_1.getThirdGoldReward()[Misc
					.random(RewardsEnum.TIER_1.getThirdGoldReward().length - 1)];

			TIER_1_PRIZE = Configuration.TIER_PRIZES[Misc.random(Configuration.TIER_PRIZES.length - 1)];

			Item[] coppyz = new Item[] { RewardsEnum.TIER_1.getRegularRewards()[0].copy(),
					RewardsEnum.TIER_1.getRegularRewards()[1].copy(), RewardsEnum.TIER_1.getRegularRewards()[2].copy(),
					RewardsEnum.TIER_1.getRegularRewards()[3].copy(), RewardsEnum.TIER_1.getRegularRewards()[4].copy(),
					RewardsEnum.TIER_1.getRegularRewards()[5].copy(), RewardsEnum.TIER_1.getRegularRewards()[6].copy(),
					RewardsEnum.TIER_1.getRegularRewards()[7].copy(), RewardsEnum.TIER_1.getRegularRewards()[8].copy(),
					RewardsEnum.TIER_1.getRegularRewards()[9].copy(), RewardsEnum.TIER_1.getRegularRewards()[10].copy(),
					RewardsEnum.TIER_1.getRegularRewards()[11].copy(), RewardsEnum.TIER_1.getRegularRewards()[12].copy(),
					RewardsEnum.TIER_1.getRegularRewards()[13].copy(), RewardsEnum.TIER_1.getRegularRewards()[14].copy(),
					RewardsEnum.TIER_1.getRegularRewards()[15].copy(), RewardsEnum.TIER_1.getRegularRewards()[16].copy(),
					 RewardsEnum.TIER_1.getRegularRewards()[17].copy(),RewardsEnum.TIER_1.getRegularRewards()[18].copy(),
					RewardsEnum.TIER_1.getRegularRewards()[19].copy(), RewardsEnum.TIER_1.getRegularRewards()[20].copy()
					 };

			ChestRewards list = new ChestRewards(firstGoldReward_Tier1.copy(), secondGoldReward_Tier1.copy(),
					thirdGoldReward_Tier1.copy(), coppyz);

			player.getEventChestHandler().TIER_1_REWARDS.add(list);

			firstGoldReward_Tier1 = RewardsEnum.TIER_2.getFirstGoldReward()[Misc
					.random(RewardsEnum.TIER_2.getFirstGoldReward().length - 1)];

			secondGoldReward_Tier1 = RewardsEnum.TIER_2.getSecondGoldReward()[Misc
					.random(RewardsEnum.TIER_2.getSecondGoldReward().length - 1)];
			thirdGoldReward_Tier1 = RewardsEnum.TIER_2.getThirdGoldReward()[Misc
					.random(RewardsEnum.TIER_2.getThirdGoldReward().length - 1)];

			TIER_2_PRIZE = Configuration.TIER_PRIZES[Misc.random(Configuration.TIER_PRIZES.length - 1)];

			coppyz = new Item[] { RewardsEnum.TIER_2.getRegularRewards()[0].copy(),
					RewardsEnum.TIER_2.getRegularRewards()[1].copy(), RewardsEnum.TIER_2.getRegularRewards()[2].copy(),
					RewardsEnum.TIER_2.getRegularRewards()[3].copy(), RewardsEnum.TIER_2.getRegularRewards()[4].copy(),
					RewardsEnum.TIER_2.getRegularRewards()[5].copy(), RewardsEnum.TIER_2.getRegularRewards()[6].copy(),
					RewardsEnum.TIER_2.getRegularRewards()[7].copy(), RewardsEnum.TIER_2.getRegularRewards()[8].copy(),
					RewardsEnum.TIER_2.getRegularRewards()[9].copy(),
					RewardsEnum.TIER_2.getRegularRewards()[10].copy(),RewardsEnum.TIER_2.getRegularRewards()[11].copy(),
					RewardsEnum.TIER_2.getRegularRewards()[12].copy(), RewardsEnum.TIER_2.getRegularRewards()[13].copy(),
					 RewardsEnum.TIER_2.getRegularRewards()[14].copy(),
					//RewardsEnum.TIER_2.getRegularRewards()[15].copy(),// RewardsEnum.TIER_2.getRegularRewards()[16].copy(),
					// RewardsEnum.TIER_2.getRegularRewards()[17].copy(),RewardsEnum.TIER_2.getRegularRewards()[18].copy(),
					//RewardsEnum.TIER_2.getRegularRewards()[19].copy(), RewardsEnum.TIER_2.getRegularRewards()[20].copy()
			};

			list = new ChestRewards(firstGoldReward_Tier1.copy(), secondGoldReward_Tier1.copy(),
					thirdGoldReward_Tier1.copy(), coppyz);

			player.getEventChestHandler().TIER_2_REWARDS.add(list);
			

			player.getEventChestHandler().setServerTierSelected(TierType.TIER_1);
		}
	}

	public void rollReward(Player player) {

		boolean updateList = false;
		int updateId = 0;

		if (player.getEventChestHandler().getServerTierSelected() != player.getEventChestHandler().getTierType()) {
			return;
		}

		if (!player.getClickDelay().elapsed(1000)) {
			return;
		}

		if (player.getEventChestHandler().getTierType() == TierType.TIER_1) {
			if (!player.getInventory ().contains (Configuration.CURRENCY_TO_SPEND.getId (),
					Configuration.CURRENCY_TO_SPEND.getAmount ())) {
				player.sendMessage ("You need at least "
						+ ("" + Configuration.CURRENCY_TO_SPEND.getAmount ()) + " "
						+ ItemDefinition.forId (Configuration.CURRENCY_TO_SPEND.getId ()).getName () + " to claim your reward!");
				return;
			}
		} else if (player.getEventChestHandler().getTierType() == TierType.TIER_2) {
			if (!player.getInventory ().contains (Configuration.CURRENCY_TO_SPEND.getId (),
					Configuration.CURRENCY_TO_SPEND.getAmount () * 2)) {
				player.sendMessage ("You need at least "
						+  ("" + Configuration.CURRENCY_TO_SPEND.getAmount ()  * 2) + " "
						+ ItemDefinition.forId (Configuration.CURRENCY_TO_SPEND.getId ()).getName () + " to claim your reward!");
				return;
			}
		}

		boolean cats = false;

		player.getInventory().delete(Configuration.CURRENCY_TO_SPEND.getId(),
				getServerTierSelected() == TierType.TIER_1 ? Configuration.CURRENCY_TO_SPEND.getAmount()
						: Configuration.CURRENCY_TO_SPEND.getAmount() * 2);

		if (player.getEventChestHandler().getTierType() == TierType.TIER_1) {
			ChestRewards rewards = player.getEventChestHandler().TIER_1_REWARDS.get(0);
			while (!cats) {

				int luck = Misc.random(100);
				int randomTop = Misc.random(2);
				int amount = 1;

				List<Item> regularFreeReward = Arrays.stream(rewards.getRegularRewards()).filter(t -> t.getAmount() > 0)
						.collect(Collectors.toList());

				Item nextFreeTop = rewards.getFirstGoldReward().getAmount() > 0 ? rewards.getFirstGoldReward()
						: rewards.getSecondGoldReward().getAmount() > 0 ? rewards.getSecondGoldReward()
								: rewards.getThirdGoldReward();

				Item topReward = randomTop == 0 && rewards.getFirstGoldReward().getAmount() > 0
						? rewards.getFirstGoldReward()
						: randomTop == 1 && rewards.getSecondGoldReward().getAmount() > 0
								? rewards.getSecondGoldReward()
								: randomTop == 2 && rewards.getThirdGoldReward().getAmount() > 0
										? rewards.getThirdGoldReward()
										: !regularFreeReward.isEmpty()
												? regularFreeReward.get(Misc.random(regularFreeReward.size() - 1))
												: nextFreeTop;

				boolean topRewardsEmpty = rewards.getFirstGoldReward().getAmount() <= 0
						&& rewards.getSecondGoldReward().getAmount() <= 0
						&& rewards.getThirdGoldReward().getAmount() <= 0;

				Item reward = luck >= 95 && !topRewardsEmpty ? topReward
						: !regularFreeReward.isEmpty()
								? regularFreeReward.get(Misc.random(regularFreeReward.size() - 1))
								: nextFreeTop;

				if (reward.getAmount() <= 0) {
					continue;
				}

				reward.setAmount(reward.getAmount() - amount);

				if (reward.getAmount() <= 0) {
					updateList = true;
					updateId = reward.getId();
				}

				player.getInventory().add(Configuration.ALWAYS_ROLL_REWARD);
				player.getInventory().add(reward.getId(), amount);

				cats = true;
				TIMES_ROLLED_TIER_1++;

				if (player.getEventChestHandler().TIER_1_REWARDS.stream()
						.allMatch(t -> t.getFirstGoldReward().getAmount() <= 0
								&& t.getSecondGoldReward().getAmount() <= 0 && t.getThirdGoldReward().getAmount() <= 0
								&& Arrays.stream(t.getRegularRewards()).allMatch(z -> z.getAmount() <= 0))) {
					player.sendMessage("@red@Congratulations, You have advanced to Tier 2");
					World.sendMessage("<img=17>" + "@red@[News] @blu@" + player.getUsername()+ "@red@ advanced to @blu@Tier 2 @red@of the Christmas box <img=17>");

					player.getInventory().add(TIER_1_PRIZE);

					player.getEventChestHandler().setServerTierSelected(TierType.TIER_2);

					player.getEventChestHandler().setTierType(TierType.TIER_2);
					EventChestInterface.sendCorrectTabSelected(player);
					player.getPacketSender().sendItemOnInterface(55611, -1, 0);
					player.getPacketSender().sendString(55612, "?");
					EventChestInterface.resetRewards(player);
					player.getPacketSender().clearChristmasList();
					EventChestInterface.sendRewardsToInterface(player);
				}

				player.getPacketSender().sendString(55612, "");
				player.getPacketSender().sendItemOnInterface(55611, reward.getId(), amount);

				if (luck >= 95) {
					World.sendMessage("<img=17>@red@ " + player.getUsername() + " just received @gre@<shad=1>x"
							+ amount + " " + ItemDefinition.forId(reward.getId()).getName()
							+ "</shad>@red@ from a Christmas box! <img=17>");
				}
			}
		} else if (player.getEventChestHandler().getTierType() == TierType.TIER_2) {
			for (ChestRewards rewards : player.getEventChestHandler().TIER_2_REWARDS) {
				while (!cats) {
					int luck = Misc.random(100);
					int randomTop = Misc.random(2);
					int amount = 1;

					List<Item> regularFreeReward = Arrays.stream(rewards.getRegularRewards())
							.filter(t -> t.getAmount() > 0).collect(Collectors.toList());

					Item nextFreeTop = rewards.getFirstGoldReward().getAmount() > 0 ? rewards.getFirstGoldReward()
							: rewards.getSecondGoldReward().getAmount() > 0 ? rewards.getSecondGoldReward()
									: rewards.getThirdGoldReward();

					Item topReward = randomTop == 0 && rewards.getFirstGoldReward().getAmount() > 0
							? rewards.getFirstGoldReward()
							: randomTop == 1 && rewards.getSecondGoldReward().getAmount() > 0
									? rewards.getSecondGoldReward()
									: randomTop == 2 && rewards.getThirdGoldReward().getAmount() > 0
											? rewards.getThirdGoldReward()
											: !regularFreeReward.isEmpty()
													? regularFreeReward.get(Misc.random(regularFreeReward.size() - 1))
													: nextFreeTop;

					boolean topRewardsEmpty = rewards.getFirstGoldReward().getAmount() <= 0
							&& rewards.getSecondGoldReward().getAmount() <= 0
							&& rewards.getThirdGoldReward().getAmount() <= 0;

					Item reward = luck >= 95 && !topRewardsEmpty ? topReward
							: !regularFreeReward.isEmpty()
									? regularFreeReward.get(Misc.random(regularFreeReward.size() - 1))
									: nextFreeTop;

					if (reward.getAmount() <= 0) {
						continue;
					}

					reward.setAmount(reward.getAmount() - amount);

					if (reward.getAmount() <= 0) {
						updateList = true;
						updateId = reward.getId();
					}

					player.getInventory().add(Configuration.ALWAYS_ROLL_REWARD);
					player.getInventory().add(reward.getId(), amount);

					cats = true;
					TIMES_ROLLED_TIER_2++;

					if (player.getEventChestHandler().TIER_2_REWARDS.stream()
							.allMatch(t -> t.getFirstGoldReward().getAmount() <= 0
									&& t.getSecondGoldReward().getAmount() <= 0
									&& t.getThirdGoldReward().getAmount() <= 0
									&& Arrays.stream(t.getRegularRewards()).allMatch(z -> z.getAmount() <= 0))) {
						player.sendMessage("@red@Congratulations, You successfully claimed all the rewards from the Christmas Box!");
						World.sendMessage("<img=17>" + "@red@[News] @blu@" + player.getUsername()+ "@red@ has completed Tier 2 of the Christmas box! <img=17>");
						player.getInventory().add(TIER_2_PRIZE);
						player.getEventChestHandler().TIER_1_REWARDS.clear();
						player.getEventChestHandler().TIER_2_REWARDS.clear();
						TIMES_ROLLED_TIER_1 = 0;
						TIMES_ROLLED_TIER_2 = 0;
						player.getEventChestHandler().generateRewards(player);

						player.getPacketSender().clearChristmasList();
						player.getPacketSender().removeInterface();
						player.setInterfaceId(0);
						player.getPacketSender().setInterfaceClicked(55580, 55586, true);
						player.getEventChestHandler().setTierType(TierType.TIER_1);
						EventChestInterface.resetRewards(player);
						EventChestInterface.sendRewardsToInterface(player);
						EventChestInterface.sendTierPrize(player);
					}

					player.getPacketSender().sendString(55612, "");
					player.getPacketSender().sendItemOnInterface(55611, reward.getId(), amount);

					if (luck >= 95) {
						World.sendMessage("<img=17> @red@" + player.getUsername() + " just received @gre@<shad=1>x"
								+ amount + " " + ItemDefinition.forId(reward.getId()).getName()
								+ "</shad>@red@ from a Christmas Box! <img=17>");
					}
				}
			}
		}

		if (updateList) {
			player.getPacketSender().addChristmasList(updateId);
		}
		EventChestInterface.updateBar(player);
		EventChestInterface.sendRewardsToInterface(player);

	}

	public TierType getTierType() {
		return tierType;
	}

	public void setTierType(TierType tierType) {
		this.tierType = tierType;
	}

	public TierType getServerTierSelected() {
		return serverTierSelected;
	}

	public void setServerTierSelected(TierType serverTierSelected) {
		this.serverTierSelected = serverTierSelected;
	}
	
    public void saveEventChest(Player player) {
    	Path path = Paths.get(DIR + player.getUsername() + ".json");
    	File file = path.toFile();
    	file.getParentFile().setWritable(true);
    	
    	if(!file.getParentFile().exists()) {
    		try {
    			file.getParentFile().mkdirs();
    		} catch (SecurityException e) {
    			System.out.println("Unable to create directory for christmas box system!!");
    		}
    	}
    	
    	try (FileWriter writer = new FileWriter(file)) {
    		Gson builder = new GsonBuilder().setPrettyPrinting().create();
    		JsonObject object = new JsonObject();
    		
    		object.add("tierType", builder.toJsonTree(player.getEventChestHandler().getTierType()));
    		
    		object.add("serverTierSelected", builder.toJsonTree(player.getEventChestHandler().getServerTierSelected()));
    		
    		object.add("tier1prize", builder.toJsonTree(player.getEventChestHandler().TIER_1_PRIZE));
    		
    		object.add("tier2prize", builder.toJsonTree(player.getEventChestHandler().TIER_2_PRIZE));
    		
    		object.add("TIMES_ROLLED_TIER_1", builder.toJsonTree(player.getEventChestHandler().TIMES_ROLLED_TIER_1));
    		
    		object.add("TIMES_ROLLED_TIER_2", builder.toJsonTree(player.getEventChestHandler().TIMES_ROLLED_TIER_2));
    		
    		object.add("TIER_1_REWARDS", builder.toJsonTree(player.getEventChestHandler().TIER_1_REWARDS));
    		
    		object.add("TIER_2_REWARDS", builder.toJsonTree(player.getEventChestHandler().TIER_2_REWARDS));
    		
    		writer.write(builder.toJson(object));
    		writer.close();
    		System.out.println("Saved "+ player.getUsername() + " Christmas box!");
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public void loadEventChest(Player player) {
    	Path path = Paths.get(DIR + player.getUsername() + ".json");
    	File file = path.toFile();
    	
    	if(!file.exists())
    		return;
    	
    	try(FileReader fileReader = new FileReader(file)) {
    		Gson builder = new GsonBuilder().create();
    		JsonParser parser = new JsonParser();
    		JsonObject reader = parser.parse(fileReader).getAsJsonObject();
    		
    		if (reader.has("tierType")) {
				player.getEventChestHandler().setTierType(builder.fromJson(reader.get("tierType"), TierType.class));
			}
    		
    		if (reader.has("serverTierSelected")) {
				player.getEventChestHandler().setServerTierSelected(builder.fromJson(reader.get("serverTierSelected"), TierType.class));
			}
    		
    		if (reader.has("tier1prize")) {
    			player.getEventChestHandler().TIER_1_PRIZE = builder.fromJson(reader.get("tier1prize"), Item.class);
			}
    		
    		if (reader.has("tier2prize")) {
    			player.getEventChestHandler().TIER_2_PRIZE = builder.fromJson(reader.get("tier2prize"), Item.class);
			}
    		
    		if (reader.has("TIMES_ROLLED_TIER_1")) {
    			player.getEventChestHandler().TIMES_ROLLED_TIER_1 = reader.get("TIMES_ROLLED_TIER_1").getAsInt();
			}
    		
    		if (reader.has("TIMES_ROLLED_TIER_2")) {
    			player.getEventChestHandler().TIMES_ROLLED_TIER_2 = reader.get("TIMES_ROLLED_TIER_2").getAsInt();
			}
    		
    		if (reader.has("TIER_1_REWARDS")) {
    			Type collectionType = new TypeToken<Collection<ChestRewards>>() {
                }.getType();
                Collection<ChestRewards> collection = builder.fromJson(reader.get("TIER_1_REWARDS").getAsJsonArray(), collectionType);
                player.getEventChestHandler().TIER_1_REWARDS.addAll(collection);
			}
    		
    		if (reader.has("TIER_2_REWARDS")) {
    			Type collectionType = new TypeToken<Collection<ChestRewards>>() {
                }.getType();
                Collection<ChestRewards> collection = builder.fromJson(reader.get("TIER_2_REWARDS").getAsJsonArray(), collectionType);
                player.getEventChestHandler().TIER_2_REWARDS.addAll(collection);
			}
    		
    		System.out.println("Loaded "+ player.getUsername() + " Christmas box!");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
