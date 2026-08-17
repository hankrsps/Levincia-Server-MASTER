package com.ruse.world.content.afk;

import com.ruse.model.Locations;
import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;

import java.util.HashMap;
import java.util.Map;

public class AfkSystem {

	public static void rewardAfkSoulsToZonePlayers() {
		Map<String, Integer> ipCounts = new HashMap<>();

		// First Pass: Count IPs
		for (Player player : World.getPlayers()) {
			if (player == null || !player.isRegistered() || player.getLocation() != Locations.Location.AFK)
				continue;

			String ip = player.getHostAddress();
			ipCounts.put(ip, ipCounts.getOrDefault(ip, 0) + 1);
		}

		// Second Pass: Reward players with <= 2 per IP
		for (Player player : World.getPlayers()) {
			if (player == null || !player.isRegistered() || player.getLocation() != Locations.Location.AFK)
				continue;

			String ip = player.getHostAddress();
			if (ipCounts.getOrDefault(ip, 0) > 2) {
				continue; // more than 2 accounts from this IP in AFK zone
			}

			player.getInventory().add(14639, 1); // AFK Soul
			if (player.isAfkSoulMessagesEnabled()) {
				player.getPacketSender().sendMessage("<col=AA66FF>You feel a soul whisper into your hands...");
			}
		}
	}



	private static final int TOTAL_COUNT = 500000;
	public static int burnedSouls = 0;

	public static int getLeft() {
		return TOTAL_COUNT - burnedSouls;
	}

	public static void executeSpawn() {
		burnedSouls += TOTAL_COUNT;
		World.sendMessage(String.format("@blu@<img=832>Terrorstep@red@ has awoken! teleport to ::afkboss to fight him"));
		burnedSouls = 0;
	}
}
