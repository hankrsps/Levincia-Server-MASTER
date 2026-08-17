package com.ruse.model.input.impl;

import com.ruse.model.input.Input;
import com.ruse.model.Locations;
import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;

public class InviteRaidsPlayer extends Input {

	@Override
	public void handleSyntax(Player player, String plrToInvite) {
		if ( player.getLocation() == Locations.Location.SOD_LOBBY ) {

			player.getPacketSender().sendInterfaceRemoval();
			Player invite = World.getPlayerByName(plrToInvite);
			if (invite == null) {
				player.getPacketSender().sendMessage("That player is currently not online.");
				return;
			}
			if (player.getRaidsParty().getPlayers().contains(invite)) {
				player.getPacketSender().sendMessage("That player is already in your party.");
				return;
			}
			player.sendMessage("Sent invite to " + plrToInvite);

			player.getRaidsParty().invite(invite);

		} else if ( player.getLocation() == Locations.Location.ZOMBIE_LOBBY ) {

			player.getPacketSender().sendInterfaceRemoval();
			Player invite = World.getPlayerByName(plrToInvite);
			if (invite == null) {
				player.getPacketSender().sendMessage("That player is currently not online.");
				return;
			}
			if (player.getZombieRaidsParty().getPlayers().contains(invite)) {
				player.getPacketSender().sendMessage("That player is already in your party.");
				return;
			}
			player.sendMessage("Sent invite to " + plrToInvite);

			player.getZombieRaidsParty().invite(invite);

		} else if ( player.getLocation() == Locations.Location.TELOS_LOBBY ) {

			player.getPacketSender().sendInterfaceRemoval();
			Player invite = World.getPlayerByName(plrToInvite);
			if (invite == null) {
				player.getPacketSender().sendMessage("That player is currently not online.");
				return;
			}
			if (player.getTelosRaidsParty ().getPlayers().contains(invite)) {
				player.getPacketSender().sendMessage("That player is already in your party.");
				return;
			}
			player.sendMessage("Sent invite to " + plrToInvite);

			player.getTelosRaidsParty().invite(invite);

		} else if ( player.getLocation() == Locations.Location.DARKNESS_LOBBY ) {

		player.getPacketSender().sendInterfaceRemoval();
		Player invite = World.getPlayerByName(plrToInvite);
		if (invite == null) {
			player.getPacketSender().sendMessage("That player is currently not online.");
			return;
		}
		if (player.getShadowRaidsParty().getPlayers().contains(invite)) {
			player.getPacketSender().sendMessage("That player is already in your party.");
			return;
		}
		player.sendMessage("Sent invite to " + plrToInvite);

		player.getShadowRaidsParty().invite(invite);

	}
	}
}