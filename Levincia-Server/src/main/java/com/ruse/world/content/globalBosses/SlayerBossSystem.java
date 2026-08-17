package com.ruse.world.content.globalBosses;
import com.ruse.model.Position;
import com.ruse.world.World;
import com.ruse.world.entity.impl.npc.NPC;

public class SlayerBossSystem {
	public static int getLeft() {
		return totalCount - slayerTasks;
		}
	public static final int totalCount = 300;
	public static int slayerTasks = 0;
	
	public static void commandSpawnBoss() {
		NPC npc = new NPC(9129, new Position(3488, 4704));
		World.register(npc);
		World.sendMessage("<img=832>@or2@<shad=1>Slayer Champion has Arrived! fight him now at @blu@::slayerboss");
		slayerTasks = 0;
	}
	public static void spawnBoss() {
		if(slayerTasks < 300) {
			return;
		}

		NPC npc = new NPC(9129, new Position(3488, 4704));
		World.register(npc);
		World.sendMessage("<img=832>@or2@<shad=1>Slayer Champion has Arrived! fight him now at @blu@::slayerboss");
		slayerTasks = 0;
	}
	public static void callBoss() {
		if(slayerTasks == 75) {
		World.sendMessage("<shad=1>@or2@We are 25% to spawning the Slayer Champion, keep slaying!");
		if(slayerTasks == 150) {
			World.sendMessage("<img=832> <shad=1>@or2@We are halfway to spawning the Slayer Champion, keep slaying!");
			return;
				}
			}
		}
}
