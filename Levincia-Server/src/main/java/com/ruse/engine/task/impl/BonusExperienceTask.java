package com.ruse.engine.task.impl;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.util.Misc;
import com.ruse.world.entity.impl.player.Player;

public class BonusExperienceTask extends Task {

	public BonusExperienceTask(final Player player) {
		super(100, player, false);
		this.player = player;
	}

	final Player player;
	int msg;

	@Override
	public void execute() {
		if (player == null || !player.isRegistered()) {
			stop();
			return;
		}
		player.setMinutesBonusExp(-1, true);
		int newMinutes = player.getMinutesBonusExp();
		if (newMinutes == 0) {
			player.getPacketSender().sendMessage("<img=5><col=330099>Your bonus experience has run out.");
			player.setMinutesBonusExp(-1, false);
			stop();
		} else if(String.valueOf(player.getMinutesBonusExp()).endsWith("(0)") && player.getMinutesBonusExp() != 0) {
			player.getPacketSender().sendMessage("<img=5><col=330099>You have " + player.getMinutesBonusExp()
					+ " minutes of bonus experience left.");
			msg = 0;
		}
		msg++;
	}

	public static void addBonusXp(final Player p, int minutes) {
		boolean startEvent = p.getMinutesBonusExp() == -1;
		p.setMinutesBonusExp(startEvent ? (minutes + 1) : minutes, true);
		if(p.getMinutesBonusExp() > 1) {
			p.getPacketSender().sendMessage("<img=5> <col=330099>You have " + Misc.format(p.getMinutesBonusExp())
					+ " minutes of bonus experience left.");
		}
		p.getPacketSender().sendString(48402, "" + p.getMinutesBonusExp() + " minutes");
		if (startEvent) {
			TaskManager.submit(new BonusExperienceTask(p));
		}
	}
}