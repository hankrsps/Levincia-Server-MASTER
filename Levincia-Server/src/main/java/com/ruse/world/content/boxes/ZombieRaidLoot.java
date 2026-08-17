package com.ruse.world.content.boxes;


import com.ruse.model.definitions.ItemDefinition;
import com.ruse.world.content.casketopening.Box;

public class ZombieRaidLoot {

	public static Box[] LOOT = {

			new Box(ItemDefinition.UPGRADE_TOKEN_ID, 1500, 5000,100), // Levincia tokens
			new Box(18404, 1, 1,75), // Raid box
			new Box(18404, 2, 2,50), // Raid box x 2
	};

}
