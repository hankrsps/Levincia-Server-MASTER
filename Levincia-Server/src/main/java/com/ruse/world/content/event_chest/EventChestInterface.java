package com.ruse.world.content.event_chest;

import com.ruse.model.Item;
import com.ruse.world.entity.impl.player.Player;

public class EventChestInterface {

	public static void openInterface(Player player) {
		player.getPacketSender().sendString(55582, Configuration.INTERFACE_TITLE);
		
		if(player.getEventChestHandler().getTierType() == null) {
			player.getEventChestHandler().setTierType(TierType.TIER_1);
		}

		sendCorrectTabSelected(player);
		resetContainers(player);
		resetRewards(player);
		sendRewardsToInterface(player);
		sendTierPrize(player);
		updateBar(player);

		player.getPacketSender().clearChristmasList();

		if (player.getEventChestHandler().TIER_1_REWARDS.get(0).getFirstGoldReward().getAmount() <= 0) {
			player.getPacketSender()
					.addChristmasList(player.getEventChestHandler().TIER_1_REWARDS.get(0).getFirstGoldReward().getId());
		}
		
		if (player.getEventChestHandler().TIER_1_REWARDS.get(0).getSecondGoldReward().getAmount() <= 0) {
			player.getPacketSender()
					.addChristmasList(player.getEventChestHandler().TIER_1_REWARDS.get(0).getSecondGoldReward().getId());
		}
		
		if (player.getEventChestHandler().TIER_1_REWARDS.get(0).getThirdGoldReward().getAmount() <= 0) {
			player.getPacketSender()
					.addChristmasList(player.getEventChestHandler().TIER_1_REWARDS.get(0).getThirdGoldReward().getId());
		}

		for (Item rara : player.getEventChestHandler().TIER_1_REWARDS.get(0).getRegularRewards()) {
			if (rara.getAmount() <= 0) {
				player.getPacketSender().addChristmasList(rara.getId());
			}
		}
		
		player.getPacketSender().sendItemOnInterface(55610, Configuration.ALWAYS_ROLL_REWARD.getId(),
				Configuration.ALWAYS_ROLL_REWARD.getAmount());

		player.getPacketSender().sendItemOnInterface(55609, Configuration.CURRENCY_TO_SPEND.getId(),
				player.getEventChestHandler().getServerTierSelected() == TierType.TIER_1
						? Configuration.CURRENCY_TO_SPEND.getAmount()
						: Configuration.CURRENCY_TO_SPEND.getAmount() * 2);

		player.getPacketSender().sendInterface(55580);
	}

	public static void updateBar(Player player) {
		player.getPacketSender().sendString(55605,
				"@yel@" + (player.getEventChestHandler().getTierType() == TierType.TIER_1
						? player.getEventChestHandler().TIMES_ROLLED_TIER_1
						: player.getEventChestHandler().TIMES_ROLLED_TIER_2) + " / "
						+ (player.getEventChestHandler().getTierType() == TierType.TIER_1
								? player.getEventChestHandler().MAX_ROLLS_TIER_1
								: player.getEventChestHandler().MAX_ROLLS_TIER_2)
						+ " opened @or1@("
						+ (player.getEventChestHandler().getTierType() == TierType.TIER_1
								? player.getEventChestHandler().TIMES_ROLLED_TIER_1
								: player.getEventChestHandler().TIMES_ROLLED_TIER_2)
								* (player.getEventChestHandler().getTierType() == TierType.TIER_1
										? Configuration.CURRENCY_TO_SPEND.getAmount()
										: Configuration.CURRENCY_TO_SPEND.getAmount() * 2)
						+ " / "
						+ (player.getEventChestHandler().getTierType() == TierType.TIER_1
								? player.getEventChestHandler().MAX_ROLLS_TIER_1
								: player.getEventChestHandler().MAX_ROLLS_TIER_2)
								* (player.getEventChestHandler().getTierType() == TierType.TIER_1
										? Configuration.CURRENCY_TO_SPEND.getAmount()
										: Configuration.CURRENCY_TO_SPEND.getAmount() * 2)
						+ " presents)");

		player.getPacketSender().setSpriteLoadingPercentage(55606,
				player.getEventChestHandler().getTierType() == TierType.TIER_1
						? calculatePercentage(player.getEventChestHandler().TIMES_ROLLED_TIER_1,
								player.getEventChestHandler().MAX_ROLLS_TIER_1)
						: calculatePercentage(player.getEventChestHandler().TIMES_ROLLED_TIER_2,
								player.getEventChestHandler().MAX_ROLLS_TIER_2));

		player.getPacketSender()
				.sendString(55607, ""
						+ (player.getEventChestHandler().getTierType() == TierType.TIER_1
								? calculatePercentage(player.getEventChestHandler().TIMES_ROLLED_TIER_1,
										player.getEventChestHandler().MAX_ROLLS_TIER_1)
								: calculatePercentage(
										player.getEventChestHandler().TIMES_ROLLED_TIER_2,
										player.getEventChestHandler().MAX_ROLLS_TIER_2))
						+ "% ("
						+ (player.getEventChestHandler().getTierType() == TierType.TIER_1
								? (player.getEventChestHandler().MAX_ROLLS_TIER_1 - player
										.getEventChestHandler().TIMES_ROLLED_TIER_1)
										* (player.getEventChestHandler().getServerTierSelected() == TierType.TIER_1
												? Configuration.CURRENCY_TO_SPEND.getAmount()
												: Configuration.CURRENCY_TO_SPEND.getAmount() * 2)

								: (player.getEventChestHandler().MAX_ROLLS_TIER_2
										- player.getEventChestHandler().TIMES_ROLLED_TIER_2)
										* (player.getEventChestHandler().getServerTierSelected() == TierType.TIER_1
												? Configuration.CURRENCY_TO_SPEND.getAmount()
												: Configuration.CURRENCY_TO_SPEND.getAmount() * 2))
						+ " presents left)");
	}

	public static void sendCorrectTabSelected(Player player) {
		if (player.getEventChestHandler().getServerTierSelected() == TierType.TIER_1) {
			player.getPacketSender().setInterfaceClicked(55580, 55586, true);
		} else if (player.getEventChestHandler().getServerTierSelected() == TierType.TIER_2) {
			player.getPacketSender().setInterfaceClicked(55580, 55590, true);
		}
	}

	public static int calculatePercentage(int obtained, int total) {
		return obtained * 100 / total;
	}

	public static void sendRewardsToInterface(Player player) {

		player.getPacketSender().sendItemOnInterface(55609, Configuration.CURRENCY_TO_SPEND.getId(),
				player.getEventChestHandler().getServerTierSelected() == TierType.TIER_1
						? Configuration.CURRENCY_TO_SPEND.getAmount()
						: Configuration.CURRENCY_TO_SPEND.getAmount() * 2);

		if (player.getEventChestHandler().getTierType() == TierType.TIER_1) {
			for (ChestRewards rewards : player.getEventChestHandler().TIER_1_REWARDS) {
				player.getPacketSender().sendItemOnInterface(55617, rewards.getFirstGoldReward().getId(),
						rewards.getFirstGoldReward().getAmount());
				player.getPacketSender().sendItemOnInterface(55618, rewards.getSecondGoldReward().getId(),
						rewards.getSecondGoldReward().getAmount());
				player.getPacketSender().sendItemOnInterface(55619, rewards.getThirdGoldReward().getId(),
						rewards.getThirdGoldReward().getAmount());

				int start = 55620;
				for (Item reward : rewards.getRegularRewards()) {
					player.getPacketSender().sendItemOnInterface(start, reward.getId(), reward.getAmount());
					start++;
				}
			}
		} else if (player.getEventChestHandler().getTierType() == TierType.TIER_2) {
			for (ChestRewards rewards : player.getEventChestHandler().TIER_2_REWARDS) {
				player.getPacketSender().sendItemOnInterface(55617, rewards.getFirstGoldReward().getId(),
						rewards.getFirstGoldReward().getAmount());
				player.getPacketSender().sendItemOnInterface(55618, rewards.getSecondGoldReward().getId(),
						rewards.getSecondGoldReward().getAmount());
				player.getPacketSender().sendItemOnInterface(55619, rewards.getThirdGoldReward().getId(),
						rewards.getThirdGoldReward().getAmount());

				int start = 55620;
				for (Item reward : rewards.getRegularRewards()) {
					player.getPacketSender().sendItemOnInterface(start, reward.getId(), reward.getAmount());
					start++;
				}
			}
		}
	}

	public static void resetRewards(Player player) {
		if (player.getEventChestHandler().getTierType() == TierType.TIER_1) {
			int start = 55617 + player.getEventChestHandler().TIER_1_REWARDS.size();
			for (int i = start; i < 55651; i++) {
				player.getPacketSender().sendItemOnInterface(i, -1, 0);
			}
		} else if (player.getEventChestHandler().getTierType() == TierType.TIER_2) {
			int start = 55617 + player.getEventChestHandler().TIER_2_REWARDS.size();
			for (int i = start; i < 55651; i++) {
				player.getPacketSender().sendItemOnInterface(i, -1, 0);
			}
		}
	}

	public static void sendTierPrize(Player player) {
		if (player.getEventChestHandler().getTierType() == TierType.TIER_1) {
			player.getPacketSender().sendItemOnInterface(55608, player.getEventChestHandler().TIER_1_PRIZE.getId(),
					player.getEventChestHandler().TIER_1_PRIZE.getAmount());
		} else if (player.getEventChestHandler().getTierType() == TierType.TIER_2) {
			player.getPacketSender().sendItemOnInterface(55608, player.getEventChestHandler().TIER_2_PRIZE.getId(),
					player.getEventChestHandler().TIER_2_PRIZE.getAmount());
		}
	}

	public static void resetContainers(Player player) {
		player.getPacketSender().sendItemOnInterface(55608, -1, 0);
		player.getPacketSender().sendItemOnInterface(55609, -1, 0);
		player.getPacketSender().sendItemOnInterface(55610, -1, 0);
		player.getPacketSender().sendItemOnInterface(55611, -1, 0);
		player.getPacketSender().sendString(55612, "?");
	}
}
