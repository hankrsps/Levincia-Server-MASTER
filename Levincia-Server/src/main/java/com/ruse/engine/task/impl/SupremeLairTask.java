package com.ruse.engine.task.impl;

import com.ruse.engine.task.Task;
import com.ruse.model.*;
import com.ruse.model.Locations.Location;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

/**
 * Supreme lair
 * 
 * @author Levincia
 */
public class SupremeLairTask extends Task {

	static NPC npc = new NPC(3242, new Position(1887, 5406, 0));
	static NPC npc1 = new NPC(3242, new Position(1895, 5406, 0));

	public SupremeLairTask(Player player) {
		super(2, player, true);
		this.player = player;
	}

	private Player player;

	@Override
	public void execute() {

		if (player.getLocation() != Location.SUPREME_LAIR) {
			player.getPacketSender().sendCameraNeutrality();
			World.deregister(npc);
			World.deregister(npc1);
			stop();
			player.setSupremeTbed(false);
			return;
		}
		player.performGraphic(new Graphic(60));
		player.getPacketSender().sendMessage("Some rocks fall from the ceiling and hit you.");
		player.forceChat("Ouch!");
		player.dealDamage(new Hit(130 + Misc.getRandom(250), Hitmask.RED, CombatIcon.BLOCK));

	}

	public static void spawnSupremeWizards() {
		World.register(npc);
		World.register(npc1);
		npc.performGraphic(new Graphic(189));
		npc1.performGraphic(new Graphic(189));
		npc.forceChat("The Supreme Energy shall not leave the lair!");
		npc1.forceChat("You will be eliminated at all costs!");
	}

}
