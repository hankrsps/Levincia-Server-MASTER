package com.ruse.world.content.event_chest;

import com.ruse.model.Item;

public class ChestRewards {
	
	private Item firstGoldReward;
	
	private Item secondGoldReward;
	
	private Item thirdGoldReward;
	
	private Item[] regularRewards;
	
	public ChestRewards(Item firstGoldReward, Item secondGoldReward, Item thirdGoldReward, Item[] regularRewards) {
		this.firstGoldReward = firstGoldReward;
		this.secondGoldReward = secondGoldReward;
		this.thirdGoldReward = thirdGoldReward;
		this.regularRewards = regularRewards;
	}
	
	public Item getFirstGoldReward() {
		return firstGoldReward;
	}
	
	public void setFirstGoldReward(Item firstGoldReward) {
		this.firstGoldReward = firstGoldReward;
	}
	
	public Item getSecondGoldReward() {
		return secondGoldReward;
	}

	public void setSecondGoldReward(Item secondGoldReward) {
		this.secondGoldReward = secondGoldReward;
	}
	
	public Item getThirdGoldReward() {
		return thirdGoldReward;
	}
	
	public void setThirdGoldReward(Item thirdGoldReward) {
		this.thirdGoldReward = thirdGoldReward;
	}
	
	public Item[] getRegularRewards() {
		return regularRewards;
	}
	
	public void setRegularRewards(Item[] regularRewards) {
		this.regularRewards = regularRewards;
	}
}
