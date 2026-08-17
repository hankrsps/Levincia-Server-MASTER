package com.ruse.world.content.skill.impl.slayer;

import com.ruse.model.Position;
import com.ruse.world.content.KillsTracker;
import com.ruse.world.content.NpcRequirements;
import com.ruse.world.entity.impl.player.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabriel Hannason
 */

@Getter
@AllArgsConstructor
public enum SlayerTasks {

    NO_TASK(null, -1, null, -1, -1, null),
    SYMBIOTE(TaskType.EASY, 1727, "Easy Slayer Dungeon", 60,120, new Position(1883, 5222)),
    ELEMENTAL_MOSS(TaskType.EASY, 1740,"Easy Slayer Dungeon", 60,120, new Position(1868, 5231)),
    LEOPARD(TaskType.EASY, 1733,  "Easy Slayer Dungeon", 60,120, new Position(1902, 5239)),
    DINO(TaskType.EASY, 6870, "Easy Slayer Dungeon", 60,120, new Position(1895, 5198)),
    SPIRIT_CRITTER(TaskType.EASY, 6871, "Easy Slayer Dungeon", 60,120, new Position(1879, 5201)),

    // Med slayer tasks 50k- xp =  half the npcs health
    ELEMENTAL_FIRE(TaskType.MEDIUM, 1741, "Medium Slayer Dungeon", 100,200, new Position(2334, 5223)),
    WILD_GRAAHK(TaskType.MEDIUM, 1734, "Medium Slayer Dungeon", 100,200, new Position(2343, 5201)),
    RUSTED_GARGOYLE(TaskType.MEDIUM, 1712, "Medium Slayer Dungeon", 100,200, new Position(2324, 5200)),
    TRAPPER(TaskType.MEDIUM, 1710, "Medium Slayer Dungeon", 100,200, new Position(2320, 5230)),
    ZAMORAK_BAT(TaskType.MEDIUM, 1725, "Medium Slayer Dungeon", 100,200, new Position(2345, 5242)),

    // Hard slayer tasks xp =  half the npcs health
    GIANT_SPIDERS(TaskType.HARD, 117, "Monster teleports", 100,200, new Position(2721, 4446)),
    DEMON_GODDESS(TaskType.HARD, 501, "Monster teleports", 100,200, new Position(2784, 4445)),
    ENERGY_SKELETON(TaskType.HARD, 503, "Monster teleports", 100,200, new Position(2088, 3995)),
    TUROTHS(TaskType.HARD, 1627, "Monster teleports", 100,200, new Position(3154, 5556)),
    CAVE_DRONE(TaskType.HARD, 6799, "Dungeon teleports", 100,200, new Position(2080, 5533)),
    CAVE_SNAIL(TaskType.HARD, 6792, "Dungeon teleports", 100,200, new Position(2080, 5533)),
    CAVE_MUTANT(TaskType.HARD, 6798, "Dungeon teleports", 100,200, new Position(2080, 5533)),

    FALLEN_WARRIOR(TaskType.HARD, 9011, "Fallen Warrior's can be found by using the Teleport interface.", 200,300,
            new Position(3421, 4777, 0)),

    // Easy bosses xp =  half the npcs health
    HANTO(TaskType.BOSS_SLAYER, 250, "Hanto warrior can be found by using the Teleport interface.", 200,300,
            new Position(2849, 4576, 0)),
    RADITZ(TaskType.BOSS_SLAYER, 449, "Raditz can be found by using the Teleport interface.", 200,300,
            new Position(2911, 3991, 0)),
    GOKU(TaskType.BOSS_SLAYER, 452, "Goku can be found by using the Teleport interface.", 200,300,
            new Position(3358, 9307, 0)),
    //Med bosses xp =  half the npcs health
    BOTANIC_GUARDIAN(TaskType.BOSS_SLAYER, 2342, "Botanic Guardian can be found by using the Teleport interface.", 200,300,
            new Position(2586, 9449, 0)),
    ENRAGED_GUARDIAN(TaskType.BOSS_SLAYER, 2949, "Enraged Guardian can be found by using the Teleport interface.", 200,300,
            new Position(3039, 3995, 0)),
    ELEMENTAL_GUARDIAN(TaskType.BOSS_SLAYER, 505, "Elemental Guardian can be found by using the Teleport interface.", 200,300,
            new Position(2781, 4576, 0)),

    // Hard bosses xp =  half the npcs health
    INUYASHA(TaskType.BOSS_SLAYER, 185, "Inuyashas can be found by using the Teleport interface.", 200,300,
            new Position(2328, 5409, 0)),
    TOLROKOTH(TaskType.BOSS_SLAYER, 6430, "Tolrokoths can be found by using the Teleport interface.", 200,300,
            new Position(1887, 5468, 0)),
    DEMONS_OF_DEITY(TaskType.BOSS_SLAYER, 440, "Demons of Deity can be found by using the Teleport interface.", 200,300,
            new Position(2842, 9387, 0)),
    MUTATED_HOUND(TaskType.BOSS_SLAYER, 9839, "Mutated hounds can be found by using the Teleport interface.", 200,300,
            new Position(3421, 4777, 0)),
    FALLEN_ANGEL(TaskType.BOSS_SLAYER, 9012, "Fallen Angel's can be found by using the Teleport interface.", 200,300,
            new Position(3421, 4777, 0)),
    MIDNIGHT_GOBLIN(TaskType.BOSS_SLAYER, 9837, "Midnight goblin's can be found by using the Teleport interface.", 200,300,
            new Position(3421, 4777, 0)),
    PLUTONIC_DEMON(TaskType.BOSS_SLAYER, 12810, "Plutonic demons can be found by using the Teleport interface.", 200,300,
            new Position(2728, 4505, 0)),
    RAMMERNAUT(TaskType.BOSS_SLAYER, 9767, "Rammernaut can be found by using the Teleport interface.", 200,300,
            new Position(2326, 9831, 4)),



    ;

    private TaskType taskType;
    private int npcId;
    private String npcLocation;
    private int min;
    private int max;
    private Position taskPosition;

    public static SlayerTasks forId(int id) {
        for (SlayerTasks tasks : SlayerTasks.values()) {
            if (tasks.ordinal() == id) {
                return tasks;
            }
        }
        return null;
    }

    public static ArrayList<SlayerTasks> forId(Player player, TaskType taskType) {
        ArrayList<SlayerTasks> list = new ArrayList<>();
        for (SlayerTasks tasks : SlayerTasks.values()) {
            if (tasks.getTaskType() == taskType) {
                list.add(tasks);
                if (tasks == RAMMERNAUT) {
                    if (!player.isUnlockedRammernaut ()) {
                        if (list.contains (tasks))
                            list.remove (tasks);
                    }
                }
/*
                if (tasks == FALLEN_ANGEL) {
                    if (!player.isUnlockedLucifers() ||
                            player.getPointsHandler().getMiniLuciferkillcount() < 5_000) {
                        if (list.contains(tasks))
                            list.remove(tasks);
                    }
                } else if (tasks == MIDNIGHT_GOBLIN) {
                    if (!player.isUnlockedDarkSupreme() && !player.getRights().isDeveloperOnly()) {
                        if (list.contains(tasks))
                            list.remove(tasks);
                    }
                } else if (tasks == BLOOD_DEMON) {
                    if (KillsTracker.getTotalKillsForNpc(438, player) < 10000 && !player.getRights().isDeveloperOnly()) {
                        if (list.contains(tasks))
                            list.remove(tasks);
                    }
                }
 */
                for (NpcRequirements req : NpcRequirements.values()) {
                    if (tasks.getNpcId() == req.getNpcId()) {
                        if (req.getKillCount() > 0) {
                            if (KillsTracker.getTotalKills(player) < req.getKillCount()) {
                                if (list.contains(tasks))
                                    list.remove(tasks);
                            }
                        } else {
                            int npc = req.getRequireNpcId();
                            if (req.getNpcId() == 3308)
                                npc = 8008;
                            else if (req.getNpcId() == 3117)
                                npc = 3308;
                            else if (req.getNpcId() == 201)
                                npc = 3117;
                            else if (req.getNpcId() == 202)
                                npc = 201;
                            else if (req.getNpcId() == 203)
                                npc = 202;
                            int total = KillsTracker.getTotalKillsForNpc(npc, player);

                            if (npc == 603)
                                total = player.getPointsHandler().getLORDKILLCount();
                            if (npc == 12843)
                                total = player.getPointsHandler().getDEMONKILLCount();
                            if (npc == 53)
                                total = player.getPointsHandler().getDRAGONKILLCount();
                            if (npc == 8018)
                                total = player.getPointsHandler().getBEASTKILLCount();
                            if (npc == 13635)
                                total = player.getPointsHandler().getKINGKILLCount();
                            if (npc == 8008)
                                total = player.getPointsHandler().getAVATARKILLCount();
                            if (npc == 3308)
                                total = player.getPointsHandler().getANGELKILLCount();
                            if (npc == 3117)
                                total = player.getPointsHandler().getLUCIENKILLCount();
                            if (npc == 201)
                                total = player.getPointsHandler().getHERCULESKILLCount();
                            if (npc == 202)
                                total = player.getPointsHandler().getSATANKILLCount();
                            if (npc == 203)
                                total = player.getPointsHandler().getZEUSKILLCount();

                            if (total < req.getAmountRequired()) {
                                if (list.contains(tasks))
                                    list.remove(tasks);
                            }
                        }
                    }
                }


                if (player.getSlayerFavourites().isBlocked(tasks.getNpcId())) {
                    if (list.contains(tasks))
                        list.remove(tasks);
                }
                if (player.getSlayerFavourites().isFavourite(tasks.getNpcId())) {
                    if (list.contains(tasks))
                        list.add(tasks);
                }

            }
        }

        return list;
    }
    public static List<SlayerTasks> tasksForType(TaskType type) {
        List<SlayerTasks> toReturn = new ArrayList<>();
        for (SlayerTasks task : values())
            if (task.taskType == type)
                toReturn.add(task);
        return toReturn;
    }

    public static int[] getNewTaskData(TaskType master) {
        int slayerTaskId = 1, slayerTaskAmount = 20;
        int easyTasks = 0, mediumTasks = 0, hardTasks = 0, eliteTasks = 0, customTasks = 0, bossTasks = 0;

        /*	*//*
         * Calculating amount of tasks
         *//*
		for (SlayerTasks task : SlayerTasks.values()) {
			if (task.getTaskMaster() == TaskType.VANNAKA)
				easyTasks++;
			else if (task.getTaskMaster() == TaskType.DURADEL)
				mediumTasks++;
			else if (task.getTaskMaster() == TaskType.KURADEL)
				hardTasks++;
			else if (task.getTaskMaster() == TaskType.SUMONA)
				eliteTasks++;
			else if (task.getTaskMaster() == TaskType.EASY)
				customTasks++;
			else if (task.getTaskMaster() == TaskType.BOSS_SLAYER)
				bossTasks++;

			// // System.out.println("TAsk master: " + task.getTaskMaster().toString());
			// back, did u figure it out or na.no, k ill rewrite it then.
		}

		*//*
         * Getting a task
         *//*
		if (master == TaskType.VANNAKA) {
			slayerTaskId = 1 + Misc.getRandom(easyTasks);
			if (slayerTaskId > easyTasks)
				slayerTaskId = easyTasks;
			slayerTaskAmount = 15 + Misc.getRandom(15);
		} else if (master == TaskType.DURADEL) {
			slayerTaskId = easyTasks - 1 + Misc.getRandom(mediumTasks);
			slayerTaskAmount = 12 + Misc.getRandom(13);
		} else if (master == TaskType.KURADEL) {
			slayerTaskId = 1 + easyTasks + mediumTasks + Misc.getRandom(hardTasks - 1);
			slayerTaskAmount = 10 + Misc.getRandom(15);
		} else if (master == TaskType.SUMONA) {
			slayerTaskId = 1 + easyTasks + mediumTasks + hardTasks + Misc.getRandom(eliteTasks - 1);
			slayerTaskAmount = 2 + Misc.getRandom(7);
		} else if (master == TaskType.EASY) {
			slayerTaskId = 1 + easyTasks + mediumTasks + hardTasks + eliteTasks + Misc.getRandom(customTasks - 1);
			slayerTaskAmount = 50 + Misc.getRandom(30);
		} else if (master == TaskType.BOSS_SLAYER) {
			slayerTaskId = 1 + easyTasks + mediumTasks + hardTasks + eliteTasks + customTasks + Misc.getRandom(bossTasks - 1);
			slayerTaskAmount = 40 + Misc.getRandom(40);
		}*/
        return new int[]{slayerTaskId, slayerTaskAmount};
    }
}
