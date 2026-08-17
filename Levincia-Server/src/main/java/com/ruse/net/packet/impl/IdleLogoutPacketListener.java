package com.ruse.net.packet.impl;

import com.ruse.net.packet.Packet;
import com.ruse.net.packet.PacketListener;
import com.ruse.world.entity.impl.player.Player;

//CALLED EVERY 3 MINUTES OF INACTIVITY

public class IdleLogoutPacketListener implements PacketListener {

	@Override
	public void handleMessage(Player player, Packet packet) {

		if (player.getPosition().getRegionId() != 11082 ) {//vod
			Afking.afk(player);
		} else return;

		/*
		 * if(player.logout() &&
		 * (player.getSkillManager().getSkillAttributes().getCurrentTask() == null ||
		 * !player.getSkillManager().getSkillAttributes().getCurrentTask().isRunning()))
		 * { World.removePlayer(player); }
		 */

		player.setInactive(true);
	}
}
