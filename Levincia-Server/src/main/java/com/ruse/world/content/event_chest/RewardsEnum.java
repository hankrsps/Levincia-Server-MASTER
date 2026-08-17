package com.ruse.world.content.event_chest;

import com.ruse.model.Item;

public enum RewardsEnum {

	TIER_1(TierType.TIER_1,

			new Item[] { new Item(23359, 1)}, //Rare reward #1
			new Item[] { new Item(23357, 1)}, //Rare reward #2
			new Item[] { new Item(14999, 1)}, //Rare reward #3
			
			new Item[] {
					new Item(15288, 5), //Common rewards 8
					new Item(15289, 5), //Common rewards 13
					new Item(15290, 3), //Common rewards 16
					new Item(22219, 5), //18
					new Item(19001, 5), //23
					new Item(15358, 3),//26
					new Item(20489, 2),//28
					new Item(15359, 3),//31
					new Item(6769, 2),//33
					new Item(10946, 5),//38
					new Item(10947, 1),//39
					new Item(18404, 5),//44
					new Item(15003, 1),//45
					new Item(23401, 2),//47
					new Item(23528, 1),//49
					new Item(23529, 1),//50
					new Item(23530, 1),//48
					new Item(23531, 1),//51
					new Item(23532, 1),//52
					new Item(10507, 1),//53
					new Item(3578, 1) }),//54
	
	TIER_2(TierType.TIER_2,
			new Item[] { new Item(23358, 1)}, //Rare reward #1
			new Item[] { new Item(23360, 1)}, //Rare reward #2
			new Item[] { new Item(23361, 1)}, //Rare reward #3

			new Item[] {
					new Item(4186, 10), //Common rewards 39
					new Item(22209, 3),//34
					new Item(22211, 3),//29
					new Item(10942, 2),//24
					new Item(10935, 1),//11
					new Item(10934, 1),//22
					new Item(15355, 3),//21
					new Item(15356, 3),//18
					new Item(15357, 3),//15
					new Item(15004, 1),//12
					new Item(23239, 2),//8
					new Item(22112, 2),//6
					new Item(10949, 2),//4
					new Item(23253, 1),//2
					new Item(23240, 1), //1

			}
	);

	private TierType tierType;

	private Item[] firstGoldReward;

	private Item[] secondGoldReward;

	private Item[] thirdGoldReward;

	private Item[] regularRewards;

	RewardsEnum(TierType tierType, Item[] firstGoldReward, Item[] secondGoldReward, Item[] thirdGoldReward,
			Item[] regularRewards) {
		this.tierType = tierType;
		this.firstGoldReward = firstGoldReward;
		this.secondGoldReward = secondGoldReward;
		this.thirdGoldReward = thirdGoldReward;
		this.regularRewards = regularRewards;
	}

	public TierType getTierType() {
		return tierType;
	}

	public Item[] getFirstGoldReward() {
		return firstGoldReward;
	}

	public Item[] getSecondGoldReward() {
		return secondGoldReward;
	}

	public Item[] getThirdGoldReward() {
		return thirdGoldReward;
	}

	public Item[] getRegularRewards() {
		return regularRewards;
	}
}
