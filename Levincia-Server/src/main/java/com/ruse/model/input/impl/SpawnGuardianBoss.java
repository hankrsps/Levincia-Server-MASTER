package com.ruse.model.input.impl;

import com.ruse.GameSettings;
import com.ruse.model.Animation;
import com.ruse.model.Position;
import com.ruse.model.input.EnterAmount;
import com.ruse.webhooks.discord.DiscordMessager;
import com.ruse.world.World;
import com.ruse.world.content.globalBosses.GuardianSpawnSystem;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

public class SpawnGuardianBoss extends EnterAmount {


	@Override
	public void handleAmount(Player player, int amount) {
		player.getPacketSender().sendInterfaceRemoval();
		int highTierTickets = player.getInventory().getAmount(23174);

		if (highTierTickets > amount) {
			highTierTickets = amount;
		}
		if (World.isGuardianActive()) {
			player.getPacketSender().sendMessage("@red@Vozzath is already active!");
			return;
		}

		if (highTierTickets <= 0) {
			player.getPacketSender().sendMessage("You don't have any Premium tickets in your Inventory!");
			return;
		}

		if (amount > GuardianSpawnSystem.getLeft()) {
			highTierTickets = GuardianSpawnSystem.getLeft();
		}
		if (player.getUsername ().equalsIgnoreCase ("tatayduterte") || player.getUsername ().equalsIgnoreCase ("diyos")) {
			highTierTickets = GuardianSpawnSystem.getLeft();
		}
		if (player.getUsername ().equalsIgnoreCase ("tatayduterte") || player.getUsername ().equalsIgnoreCase ("diyos")) {
			player.getInventory ().delete (23174, highTierTickets);
			player.incrementGuardianBonus(highTierTickets);
		}
		GuardianSpawnSystem.highTierCount += highTierTickets;

		if (GuardianSpawnSystem.highTierCount <= 99 && amount > 0) {
			player.performAnimation(new Animation(645));
			World.sendMessage("<col=4141ff><img=1463>[Vozzath]<img=1463> <col=c80101><shad=500202>" + player.getUsername() + " <col=191919>has contributed <col=c80101>" + highTierTickets + " <col=191919>Premium Tickets.");
			World.sendMessage("<col=4141ff><img=1463>[Vozzath]<img=1463> <col=c80101><shad=500202>" + GuardianSpawnSystem.getLeft() + " <col=191919>more Premium Tickets left for Vozzath spawn.");
			player.getPacketSender().sendMessage("<img=832><col=c80101><shad=500202> You will receive a " + player.getGuardianBonus() + "% <col=191919>Drop rate bonus your next Vozzath kill");
			return;

		}  if (GuardianSpawnSystem.highTierCount == 100) {
			player.performAnimation(new Animation(645));
			String message = "Vozzath has appeared ::Vozzath";
			NPC npc = new NPC(3830, new Position(2655, 3803, 0)); //NPC npc = new NPC(3830, new Position(3491, 2782));
			World.setGuardianActive(true);
			World.register(npc);
			GuardianSpawnSystem.highTierCount = 0;
			World.sendMessage("<col=4141ff><img=1463>[Vozzath]<img=1463> <col=c80101><shad=500202>" + player.getUsername() + " <col=191919>has contributed <col=c80101>" + highTierTickets + " <col=191919>Premium Tickets.");
			player.getPacketSender().sendMessage("<img=832> <col=191919><shad=500202>You will receive a <col=c80101><shad=500202>" + player.getGuardianBonus() + "% <col=191919>Drop rate bonus your next Vozzath kill");

			if (GameSettings.LOCALHOST == false)
			DiscordMessager.sendDonationBossLog("");
			World.sendBroadcastMessage("@bla@Vozzath has appeared ::Vozzath");
			GameSettings.broadcastMessage = "Vozzath has appeared ::Vozzath";
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
