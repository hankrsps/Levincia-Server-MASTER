package com.ruse.world.content.event_chest;

import com.ruse.model.Item;

public class Configuration {

	public static String INTERFACE_TITLE = "Christmas Box";

	/**
	 * REWARDS CAN NEVER BE THE SAME ID In the same array
	 */

	public static Item CURRENCY_TO_SPEND = new Item(23362, 1);

	public static Item ALWAYS_ROLL_REWARD = new Item(12855, 50_000);

	public static Item[] TIER_PRIZES = new Item[] { new Item(12855, 10_000_000), new Item(12855, 50_000_000) };
}
