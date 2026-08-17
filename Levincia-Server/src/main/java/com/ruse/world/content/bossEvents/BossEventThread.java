package com.ruse.world.content.bossEvents;

import com.ruse.util.Misc;
import com.ruse.world.World;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Levincia#9598 (AlwaysDreaming.AI@gmail.com)
 * Offering Development services with tutorials pm me
 *
 */

public class BossEventThread {
	private static final int TASK_INTERVAL = 35; // in seconds
	private static final int REMINDER_INTERVAL = 600; // in seconds

	private int tick = 0;
	private int reminder = 0;
	private BossEventHandler handler = new BossEventHandler();

	public void executeEvent() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (tick == TASK_INTERVAL) {
					stop();
					cancel();
					handler.assignTasks(Misc.exclusiveRandom(0, 1));
					return;
				}
				tick++;
				reminder++;
				if (reminder > REMINDER_INTERVAL) {
					remind();
				}
			}
		};
		Timer timer = new Timer();
		timer.schedule(task, 1000, 1000);
	}

	public void stop() {
		tick = 0;
	}

	public void remind() {
		World.sendMessage("<shad=916323>[BossEvent] " + tick / 60 + " Minutes passed.");
		reminder = 0;
	}
}
