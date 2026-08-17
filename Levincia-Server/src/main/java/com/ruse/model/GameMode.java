package com.ruse.model;

import com.ruse.world.content.skill.impl.old_dungeoneering.UltimateIronmanHandler;
import com.ruse.world.entity.impl.player.Player;

public enum GameMode {

	NORMAL, ULTIMATE_IRONMAN, IRONMAN, VETERAN_MODE, GROUP_IRONMAN;

	public boolean isIronman() {
		return this.equals(IRONMAN) || this.equals(ULTIMATE_IRONMAN) || this.equals(GROUP_IRONMAN);
	}

	public boolean isUltIronman() {
		return this.equals(ULTIMATE_IRONMAN);
	}
	public static void set(Player player, GameMode newMode, boolean death) {
		if (UltimateIronmanHandler.hasItemsStored(player)) {
			player.getPacketSender().sendMessage("You must claim your stored items at Dungeoneering first.");
			player.setPlayerLocked(false);
			player.getPacketSender().sendInterfaceRemoval();
			return;
		}
		if (!death && !player.getClickDelay().elapsed(1000))
			return;
		player.getClickDelay().reset();
		player.getPacketSender().sendInterfaceRemoval();
		if (player.getGameMode() == IRONMAN && newMode != NORMAL && (!(player.getRights().OwnerDeveloperOnly()))) {
			player.getPacketSender().sendMessage("As an Iron Man, you can only set your game mode to Normal mode.");
			player.setPlayerLocked(false);
			player.getPacketSender().sendInterfaceRemoval();
			return;
		}
		if (player.getGameMode() == ULTIMATE_IRONMAN && newMode == ULTIMATE_IRONMAN
				&& (!(player.getRights().OwnerDeveloperOnly()))) {
			player.getPacketSender().sendMessage("You already are a Ultimate Ironman, that would be pointless!");
			player.setPlayerLocked(false);
			player.getPacketSender().sendInterfaceRemoval();
			return;
		}
		if (player.getGameMode() == ULTIMATE_IRONMAN && newMode == IRONMAN
				&& (!(player.getRights().OwnerDeveloperOnly()))) {
			player.getBank(0).add(16691, 1).add(9704, 1).add(17239, 1).add(16669, 1).add(16339, 1).add(6068, 1)
					.add(9703, 1);
			player.getPacketSender().sendMessage("Your new Iron Man armour has been sent to your bank!");
			player.setPlayerLocked(false);
			player.getPacketSender().sendInterfaceRemoval();
		}
		if (newMode != player.getGameMode() || death) {
		}

		player.setGameMode(newMode);
		player.getPacketSender().sendIronmanMode(newMode.ordinal());
		if (!death) {
			player.getPacketSender()
					.sendMessage(
							"You've set your Gamemode to " + newMode.name().toLowerCase().replaceAll("_", " ") + ".")
					.sendMessage("If you wish to change it, please talk to the town crier at home.");
		} else {
			player.getPacketSender().sendMessage("Your account progress has been reset.");
		}
		if (player.newPlayer()) {
			player.setPlayerLocked(true);
			
		} else {
			player.setPlayerLocked(false);
		}
	}
}
