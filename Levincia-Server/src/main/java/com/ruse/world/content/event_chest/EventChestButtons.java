package com.ruse.world.content.event_chest;


import com.ruse.GameSettings;
import com.ruse.util.Misc;
import com.ruse.world.entity.impl.player.Player;

public class EventChestButtons {
	
	public static boolean handleButton(Player player, int buttonId) {
		switch (buttonId) {
		
		case -9953:
			player.getPacketSender().removeInterface();
			return true;
			
		case -9935: // Store button
			player.getPacketSender().sendString(1, GameSettings.StoreUrl);
			player.getPacketSender().sendMessage("Attempting to open the store");
			return true;
			
		case -9942: // Roll
			player.getEventChestHandler().rollReward(player);
			return true;
			
		case -9950: // Select Tier 1
			if(player.getEventChestHandler().getServerTierSelected() != TierType.TIER_1) {
				player.getPacketSender().sendMessage ("Tier "+ Misc.capitalizeString ("i") + " is currently locked, complete your current Tier.");
				return true;
			}
			
			player.getPacketSender().setInterfaceClicked(55580, 55586, true);
			player.getEventChestHandler().setTierType(TierType.TIER_1);
			EventChestInterface.resetRewards(player);
			EventChestInterface.sendRewardsToInterface(player);
			EventChestInterface.sendTierPrize(player);
			return true;
			
		case -9946: // Select Tier 2
			if(player.getEventChestHandler().getServerTierSelected() != TierType.TIER_2) {
				player.getPacketSender().sendMessage ("Tier "+ Misc.capitalizeString ("ii") + " is currently locked, complete your current Tier.");
				return true;
			}
			
			player.getPacketSender().setInterfaceClicked(55580, 55590, true);
			player.getEventChestHandler().setTierType(TierType.TIER_2);
			EventChestInterface.resetRewards(player);
			EventChestInterface.sendRewardsToInterface(player);
			EventChestInterface.sendTierPrize(player);
			return true;
		}
		return false;

	}
}
