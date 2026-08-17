package com.ruse.world.content.minigames.impl;

import java.util.HashMap;
import java.util.Map;

import com.ruse.model.definitions.NpcDefinition;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

public class UnknownZone {
	private final Player player;
	private final UnknownZoneInterface unknownzone;


	public UnknownZone(Player player) {
		this.player = player;
		unknownzone = new UnknownZoneInterface(player);
	}

	public void openInterface() {
		unknownzone.open();
	}

	public void refreshInterface() {
		unknownzone.refresh();
	}
	public void closeInterface() {
		unknownzone.close();
	}
}

