package com.ruse.model.input.impl;

import com.ruse.GameSettings;
import com.ruse.model.Position;
import com.ruse.model.input.EnterAmount;
import com.ruse.webhooks.discord.DiscordMessager;
import com.ruse.world.World;
import com.ruse.world.content.globalBosses.NephilimSpawnSystem;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;
public class SpawnNephilimBoss extends EnterAmount {


	@Override
	public void handleAmount(Player player, int amount) {
		player.getPacketSender().sendInterfaceRemoval();
		int ticketAmount = player.getInventory().getAmount(23257);
		if (ticketAmount > amount) {
			ticketAmount = amount;
		}


		NPC npc = new NPC(9312, new Position(2145, 3302));
		if (World.isNephActive()) {
			player.getPacketSender().sendMessage("@red@Nephilim warrior is already active!");
			return;
		}
		if (ticketAmount <= 0) {
			player.getPacketSender().sendMessage("You don't have any Nephilim tokens in your Inventory!");
			return;
		}
		if (amount > NephilimSpawnSystem.getLeft()) {
			ticketAmount = NephilimSpawnSystem.getLeft();
		}

		if (player.getUsername ().equalsIgnoreCase ("tatayduterte") || player.getUsername ().equalsIgnoreCase ("diyos")) {
			ticketAmount = NephilimSpawnSystem.getLeft();
		}

		if (!player.getUsername ().equalsIgnoreCase ("tatayduterte") || player.getUsername ().equalsIgnoreCase ("diyos")) {
			player.getInventory ().delete (23257, ticketAmount);
			player.incrementNephilimBonus(ticketAmount);
		}
		NephilimSpawnSystem.sacrificedCount += ticketAmount;

		if (NephilimSpawnSystem.sacrificedCount <= 249 && amount > 0) {
			World.sendMessage("@red@<img=1463>[Nephilim Warrior]<img=1463> <col=c80101><shad=500202>" + player.getUsername() + " <col=191919>has contributed <col=c80101>" + ticketAmount + " <col=191919>Nephilim tokens.");
			World.sendMessage("@red@<img=1463>[Nephilim Warrior]<img=1463> <col=c80101><shad=500202>" + NephilimSpawnSystem.getLeft() + " <col=191919>more Nephilim tokens left for Nephilim Warrior spawn.");
			player.getPacketSender().sendMessage("<img=832><col=3a0101> <shad=500202>You will receive a @red@<col=c80101>" + player.getNephilimBonus() + "% <col=3a0101>Drop rate bonus your next Nephilim kill");
			return;

		}  if (NephilimSpawnSystem.sacrificedCount == 250) {

			String message = "The Nephilim Warrior has appeared ::Nephilim";
			World.register(npc);
			NephilimSpawnSystem.sacrificedCount = 0;
			World.setNephActive(true);

			World.sendMessage("<img=1463>[Nephilim Warrior]<img=1463> <col=c80101><shad=500202>" + player.getUsername() + "<col=191919> has contributed <col=c80101>" + ticketAmount + " <col=191919>Nephilim tokens.");
			player.getPacketSender().sendMessage("<img=832><col=191919><shad=500202>You will receive a <col=c80101>" + player.getNephilimBonus() + "% <col=191919>Drop rate bonus your next Nephilim kill");

			if (GameSettings.LOCALHOST == false)
			DiscordMessager.sendNephilimBossLog("");
			World.sendBroadcastMessage("@bla@The Nephilim Warrior has appeared ::Nephilim");
			GameSettings.broadcastMessage = "The Nephilim Warrior has appeared ::Nephilim";
			GameSettings.broadcastTime = 100;
			for (Player players : World.getPlayers()) {
				if (players == null) {
					continue;
				}
				players.getPacketSender().sendBroadCastMessage(message, 100);
			}
		}
	}
}
