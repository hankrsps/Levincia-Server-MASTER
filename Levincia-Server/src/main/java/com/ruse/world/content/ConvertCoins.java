package com.ruse.world.content;

import com.ruse.model.Item;
import com.ruse.world.entity.impl.player.Player;

public class ConvertCoins {

	public static void convertMillCoins(Player player) {
		if (player.getInventory().getAmount(995) > 2_146_483_646) {
			player.sendMessage("You must bank some coins before converting any more tickets!");
			return;
		}
		player.getInventory().delete(5021,1);
		player.getInventory().add(new Item(995, 1_000_000));
		player.sendMessage("You have successfully converted your 1m ticket into 1,000,000 coins!");

	}
}
