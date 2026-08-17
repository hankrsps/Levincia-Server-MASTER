package com.ruse.world.content.casketopening;

import com.ruse.model.Item;
import com.ruse.util.Misc;
import com.ruse.world.content.osrscollectionlog.CollectionLog;
import com.ruse.world.entity.impl.player.Player;

import static com.ruse.world.content.osrscollectionlog.LogType.MINIGAMES;

public class BoxLoot {
	public static Box getLoot(Box[] loot) {

		Box[] possibleDrops = new Box[loot.length];
		int possibleDropsCount = 0;
		for (Box drop : loot) {
			double rate = drop.getRate() * 100;
			if (Misc.getRandom(10000) <= rate) {
				possibleDrops[possibleDropsCount++] = drop;
			}
		}

		if (possibleDropsCount > 0) {
			return possibleDrops[Misc.getRandom((possibleDropsCount - 1))];
		} else {
			return loot[Misc.getRandom((possibleDropsCount - 1))];
		}
	}
		public static Box getLoot(Box[] loot, Player player) {

			Box[] possibleDrops = new Box[loot.length];
			int possibleDropsCount = 0;
			for (Box drop : loot) {
				double rate = drop.getRate() * 100;
				if (Misc.getRandom(10000) <= rate) {
					possibleDrops[possibleDropsCount++] = drop;
				}
			}
			if (possibleDropsCount > 0) {
				return possibleDrops[Misc.getRandom((possibleDropsCount - 1))];
			} else {
				return loot[Misc.getRandom((possibleDropsCount - 1))];
			}
		}

}
