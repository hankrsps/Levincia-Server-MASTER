package com.ruse.world.content.globalBosses;

public class NephilimSpawnSystem {

	public static final int totalCount = 250;
	public static int sacrificedCount = 0;
	public static int getLeft() {
		return totalCount - sacrificedCount;
		}

}
