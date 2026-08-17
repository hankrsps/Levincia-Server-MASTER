package com.ruse.world.content;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.world.entity.impl.player.Player;

public class BonusXp {

	private Player player;
	public BonusXp(Player player) {
		this.player = player;
	}
	
	public void init() {
		player.getPacketSender().sendWalkableInterface(48400, true);
		run();
	}
	
	private void run() {
		
		TaskManager.submit(new Task(100, true) {
			@Override
			protected void execute() {
				player.getPacketSender().sendString(48402, "" + player.getMinutesBonusExp() + " minutes");
				if(player.getMinutesBonusExp() < 1) {
					player.getPacketSender().sendWalkableInterface(48400, false);
					stop();
				}
			}
		});
	}
	
}
