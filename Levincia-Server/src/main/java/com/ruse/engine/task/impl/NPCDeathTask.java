package com.ruse.engine.task.impl;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.engine.task.impl.globalevents.GlobalEventBossTask;
import com.ruse.model.Animation;
import com.ruse.model.DamageDealer;
import com.ruse.model.Graphic;
import com.ruse.model.Locations.Location;
import com.ruse.model.Position;
import com.ruse.model.definitions.NPCDrops;
import com.ruse.motivote3.doMotivote;
import com.ruse.util.Misc;
import com.ruse.util.RandomUtility;
import com.ruse.world.World;
import com.ruse.world.content.*;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.content.afk.AFKBossDrops;
import com.ruse.world.content.afk.AfkSystem;
import com.ruse.world.content.bossEvents.BossEventHandler;
import com.ruse.world.content.combat.strategy.impl.Dragonkin;
import com.ruse.world.content.combat.strategy.impl.Exoden;
import com.ruse.world.content.combat.strategy.impl.KalphiteQueen;
import com.ruse.world.content.combat.strategy.impl.Nex;
import com.ruse.world.content.dailyTask.DailyTaskHandler;
import com.ruse.world.content.dailytasks_new.DailyTask;
import com.ruse.world.content.eventboss.EventBossDropHandler;
import com.ruse.world.content.globalBosses.*;
import com.ruse.world.content.progressionzone.ProgressionZone;
import com.ruse.world.content.skeletalhorror.SkeletalHorror;
import com.ruse.world.content.skill.impl.old_dungeoneering.Dungeoneering;
import com.ruse.world.entity.impl.mini.MiniPlayer;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.ruse.motivote3.doMotivote.setVoteCount;

//import com.ruse.tools.discord.DiscordConstant;
//import com.ruse.tools.discord.DiscordManager;
//import com.ruse.world.content.dbz.Frieza;

/**
 * Represents an npc's death task, which handles everything an npc does before
 * and after their death animation (including it), such as dropping their drop
 * table items.
 *
 * @author relex lawl
 */

public class NPCDeathTask extends Task {
    public static NPC FRIEZA;

    /**
     * The npc setting off the death task.
     */
    private final NPC npc;
    /*
     * The array which handles what bosses will give a player points after death
     */
    private Set<Integer> BOSSES = new HashSet<>(Arrays.asList(1999, 440, 2882, 2881, 2883, 7134, 5666, 7286, 4540, 6222, 252,
            449, 452, 6260, 6247, 6203, 8349, 50, 2001, 1158, 8133, 3200, 13447, 8549, 1382, 2000, 2009, 2006, 8000,
            8002, 6430, 185, 3831, 2342, 2949, 1120, 8015,9837,250,505,9813,9839,9767,200)); // use
    /**
     * The amount of ticks on the task.
     */
    private int ticks = 2;

    /**
     * The player who killed the NPC
     */
    private Player killer = null;

    /**
     * The NPCDeathTask constructor.
     *
     * @param npc The npc being killed.
     */
    public NPCDeathTask(NPC npc) {
        super(2);
        this.npc = npc;
        this.ticks = 2;
    }

    @SuppressWarnings("incomplete-switch")
    @Override
    public void execute() {
        try {
            npc.setEntityInteraction(null);
            switch (ticks) {
                case 2:
                    npc.getMovementQueue().setLockMovement(true).reset();

                    DamageDealer damageDealer = npc.getCombatBuilder().getTopDamageDealer(false, null);
                    boolean additanyway = false;
                    if(npc.getId() == 8013){
                        additanyway = true;
                    }
                    killer = damageDealer == null ? null : damageDealer.getPlayer();

                    if (npc.getId() == GlobalEventBossTask.eventBossID) {
                       // World.sendMessage("Event Boss has died.");
                        World.deregister(npc);
                        return;
                    }

                    String bosspoints = String.valueOf(killer.getPointsHandler().getBossPoints());

                    if (BOSSES.contains(npc.getId())) {
                        killer.getPointsHandler().incrementBossPoints(1);
                        if (bosspoints.endsWith(String.valueOf(9))) {
                            killer.sendMessage("<img=99>You now have @red@" + killer.getPointsHandler().getBossPoints()
                                    + " Boss Points!");
                        }
                    }

                    if ((killer instanceof MiniPlayer) && killer.getMiniPlayerOwner() != null) {
                        killer = killer.getMiniPlayerOwner();
                    }
                    if (killer instanceof Player) {
                        killer.getControllerManager().processNPCDeath(npc);
                    }

                    if (!(npc.getId() >= 6142 && npc.getId() <= 6145) && !(npc.getId() > 5070 && npc.getId() < 5081))
                        npc.performAnimation(new Animation(npc.getDefinition().getDeathAnimation()));

                    /** CUSTOM NPC DEATHS **/
                    if (npc.getId() == 13447) {
                        Nex.handleDeath();
                    }

                    if (npc.getId() == 9897) {
                        Dragonkin.handleDeath();
                    }
                    break;
                case 0:
//                    if(npc.getId() == 8013){
//                        List<DamageDealer> damageDealer2 = npc.getCombatBuilder().getTopKillers(npc,10);
//                        for(DamageDealer killerslist : damageDealer2){
//
//                        }
//                        killer = damageDealer == null ? null : damageDealer.getPlayer();
//                    }
                    if (killer != null) {
                        killer.getCollectionLog2().registerkill(npc.getId());
                        boolean boss = (npc.getDefaultConstitution() > 2000);
                        if (!Nex.nexMinion(npc.getId()) && npc.getId() != 1158
                                && !(npc.getId() >= 3493 && npc.getId() <= 3497)) {
                            KillsTracker.submitById(killer, npc.getId(), true, npc.getDefinition().boss);
                            KillsTracker.submitById(killer, npc.getId(), false, npc.getDefinition().boss);
                            if (boss) {
                            }
                        }

                        if (npc.getId() == 3) {
                            int total = KillsTracker.getTotalKillsForNpc(npc.getId(), killer);
                            if (total == 10000) {
                                killer.sendMessage("@blu@You have reached 10,000 kills and received a Dan's present.");
                                killer.getInventory().add(6542, 1);
                                //return;
                            }
                        }
                        if (npc.getId() == 9019) {
                            int total = KillsTracker.getTotalKillsForNpc(npc.getId(), killer);
                            if (total == 10000) {
                                killer.sendMessage("@blu@You have reached 10,000 kills and received a St. Patrick's Box.");
                                killer.getInventory().add(13802, 1);
                                //return;
                            }
                        }


                        if (npc.getId() == 6799 ||npc.getId() == 6792 ||npc.getId() == 6798
                                && killer.getLocation() == Location.PLATINUM_ZONE) {
                            if (Misc.getRandom (100) < 20)
                                killer.getInventory().add(10481, 1);
                                //return;
                            }

                        if (killer.getLocation() == Location.CUSTOM_RAIDS) {
                            Dungeoneering.handleNpcDeath(killer, npc);
                        } // fixed, enjoy.

                        if (boss) {
                            DailyTask.BOSSES.tryProgress(killer);
                        }

                        if (npc.getId () == 10034 ||npc.getId () == 10035 ||
                                npc.getId () == 10036 ||npc.getId () == 10037) {
                            PlatinumBosses.handleDrop(npc);
                            PlatinumBosses.bossAlive = false;
                        }

                        if (npc.getId() == Wildywyrm.NPC_ID) {
                            Wildywyrm.wyrmAlive = false;
                            World.getPlayers().forEach(p -> PlayerPanel.refreshPanel(p));
                        }
                        if (npc.getId () == 959) {
                            SkeletonWarrior.handleDrop(npc);
                            SkeletonWarrior.bossAlive = false;
                        }

                        if (npc.getId() == 3779) {
                            AFKBossDrops.handleDrop(npc);
                            AfkSystem.burnedSouls = 0;
                        }
                        if (npc.getId() == 9129 || npc.getId () == 200) {
                            GlobalBossDrops.handleDrop(npc);
                        }
                        if (npc.getId() == 9312) {
                            NephilimBossDrop.handleDrop(npc);
                            NephilimSpawnSystem.sacrificedCount = 0;
                            World.setNephActive(false);
                        }
                        if (npc.getId() == 8013) {
                            VoteBossDrop.handleDrop(npc);
                            setVoteCount(0);
                            VoteBossDrop.spawned = 0;
                        }
                        if (npc.getId() == SkeletalHorror.NPC_ID) {
                            SkeletalHorror.wyrmAlive = false;
                        }
                        if (npc.getId() == 1614 ||
                                npc.getId() ==  603 ||
                                npc.getId() ==  12843||
                                npc.getId() ==  53 ||
                                npc.getId() ==  8018 ||
                                npc.getId() ==  13635 ||
                                npc.getId() ==  8008 ||
                                npc.getId() ==  3308 ||
                                npc.getId() ==  3117 ||
                                npc.getId() ==  201 ||
                                npc.getId() ==  202 ||
                                npc.getId() ==  203 ||
                                npc.getId() ==  8010 ||
                                npc.getId() ==  9807 ||
                                npc.getId() ==  7134){
                            killer.getDailyTaskManager().submitProgressToIdentifier(0, 1);
                        }
                        if (npc.getId() == 449 || npc.getId() == 452) {
                            killer.getDailyTaskManager().submitProgressToIdentifier(19, 1);
                        }
                        if (npc.getId() == 9012 || npc.getId() == 9011) {
                            killer.getDailyTaskManager().submitProgressToIdentifier(26, 1);
                        }

                        if (npc.getId() == 9767) {
                            killer.getDailyTaskManager().submitProgressToIdentifier(37, 1);
                        }

                        if (npc.getId() == 1244) {
                            killer.getDailyTaskManager().submitProgressToIdentifier(38, 1);
                        }

                        if (npc.getId() == 205) {
                            killer.getDailyTaskManager().submitProgressToIdentifier(17, 1);
                        }

                        if (npc.getId() == 440) {
                            killer.getDailyTaskManager().submitProgressToIdentifier(3, 1);
                        }
                        if (npc.getId() == 4540) {
                            killer.getDailyTaskManager().submitProgressToIdentifier(29, 1);
                        }
                        /** PARSE DROPS **/
                        if (npc.getId() == 823) { //unknown Boss room
                            UnknownBossDrop.handleDrop(npc);
                            killer.unknownZone.refreshInterface();
                            killer.getPointsHandler().incrementUnknownCompleted(1);
                            killer.getAchievementTracker().progress(AchievementData.CRYPT_CAMPER, 1);
                            killer.getPacketSender().sendMessage("@red@ You have completed the Unknown Crypt @blu@" + killer.getPointsHandler().getUnknownCompleted() + " @red@time(s)");
                        }
                        if (npc.getId() == 827) {// Unknown Room 1
                            UnknownGuardDrop.handleDrop(npc);
                            killer.unknownZone.refreshInterface();

                        }
                        if (npc.getId() == 9837) {
                            if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null
                                    && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
                                killer.getPointsHandler ().incrementMIDNIGHTKILLCount (2);
                            } else
                            killer.getAchievementTracker().progress(AchievementData.MIDNIGHT_ACHIEVER, 1);
                            killer.getPointsHandler().incrementMIDNIGHTKILLCount(1);
                        }

                        if (npc.getId() == HolidayBossEvent.NPC_ID) {
                            HolidayBossEvent.bossAlive = false;
                            HolidayBossEvent.handleDrop(npc);
                        }

                        if (npc.getId() == 9813) {
                            killer.getAchievementTracker().progress(AchievementData.BLOOD_MASTER, 1);
                        }
                        if (npc.getId() == 1719) {
                            killer.getAchievementTracker().progress(AchievementData.TRAIN_NPCS, 1);
                        }
                        if (npc.getId() == 9838) {
                            killer.getAchievementTracker().progress(AchievementData.MELEE_NPCS, 1);
                        }
                        if (npc.getId() == 1718) {
                            killer.getAchievementTracker().progress(AchievementData.RANGE_NPCS, 1);
                        }
                        if (npc.getId() == 9172) {
                            killer.getAchievementTracker().progress(AchievementData.MAGIC_NPCS, 1);
                        }
                        if (npc.getId() == 117) {
                            killer.getAchievementTracker().progress(AchievementData.GIANT_SPIDERS, 1);
                        }
                        if (npc.getId() == 501) {
                            killer.getAchievementTracker().progress(AchievementData.DEMON_GODDESS, 1);
                        }
                        if (npc.getId() == 503) {
                            killer.getAchievementTracker().progress(AchievementData.ENERGY_SKELETON, 1);
                        }
                        if (npc.getId() == 1627) {
                            killer.getAchievementTracker().progress(AchievementData.TUROTHS, 1);
                        }
                        if (npc.getId() == 4540) {
                            killer.getAchievementTracker().progress(AchievementData.COLOSSAL_KILLER, 1);
                        }
                        if (npc.getId() == 205) {
                            killer.getAchievementTracker().progress(AchievementData.ELITE_KILLER, 1);
                        }
                        if (npc.getId() == 828) {// Unknown Room 2
                            UnknownCreatureDrop.handleDrop(npc);
                            killer.unknownZone.refreshInterface();
                        }

                        if (npc.getId() == 825) {// Unknown Room 3
                            UnknownGhostDrop.handleDrop(npc);
                            killer.unknownZone.refreshInterface();
                        }

                        if (killer.getLocation() == Location.SAPPHIRE_ZONE) {
                            killer.getInventory().add(23204, 1);
                        }
                        if (killer.getLocation() == Location.EMERALD_ZONE) {
                            killer.getInventory().add(23205, 1);
                        }
                        if (killer.getLocation() == Location.RUBY_ZONE) {
                            killer.getInventory().add(23206, 1);
                        }
                        if (killer.getLocation() == Location.DIAMOND_ZONE) {
                            killer.getInventory().add(23207, 1);
                        }
                        if (killer.getLocation() == Location.ONYX_ZONE) {
                            killer.getInventory().add(23208, 1);
                        }
                        if (killer.getLocation() == Location.ZENYTE_ZONE) {
                            killer.getInventory().add(23209, 1);
                        }

                        if (npc.getId() == 8013) {
                            setVoteCount (doMotivote.getVoteCount());
                            VoteBossDrop.handleDrop (npc);
                        }

                        if (npc.getId() == 8013 && killer.isVoteBossTransform() && NPCDrops.Misc1 == true) {
                            killer.sendMessage ("You received Double rewards from your transformation effect!");
                        }
                        if (npc.getId() == 4972 && killer.isDragonKingTransform() && NPCDrops.Misc1 == true) {
                            killer.sendMessage ("You received Double rewards from your transformation effect!");
                        }
                        if (npc.getId() == 9319 && killer.isGolemTransform() && NPCDrops.Misc1 == true) {
                            killer.sendMessage ("You received Double rewards from your transformation effect!");
                        }
                        if (npc.getId() == 3830 && killer.isVozzathTransform() && NPCDrops.Misc1 == true) {
                            killer.sendMessage ("You received Double rewards from your transformation effect!");
                        }
                        if (npc.getId() == 9017 && killer.isNightmareTransform() && NPCDrops.Misc1 == true) {
                            killer.sendMessage ("You received Double rewards from your transformation effect!");
                        }

                        if (npc.getId() == 3830) {
                            GuardianBossDrop.handleDropReward(npc);
                            GuardianSpawnSystem.highTierCount = 0;
                            World.setGuardianActive(false);
                        }

                        if (npc.getId() == 9017) {
                            NightmareBoss.handleDrop(npc);
                        }
                        if (npc.getId() == 4972) {
                            DragonKingBoss.handleDrop (npc);

                        }
                        if (npc.getId() == 9319) {
                            ZenyteGolemBoss.handleDrop(npc);
                        }

                        if (npc.getId() == 9128 && killer.getQuestTwoStep6() == false) {
                            killer.setQuestTwoStep6(true);
                            killer.getPacketSender().sendMessage("<img=832>You completed a quest objective: @blu@Defeat the Evil cook");
                            killer.getPacketSender().sendMessage("Return to Duke of Horacio to claim your reward!");
                        }
                        if (npc.getId() == 587) {
                            IronmanBoss.handleDrop(npc);
                        }
                        if (npc.getId() == 9318) {
                            OnyxPantherBoss.handleDrop(npc);
                        }
                        if (npc.getId() == 3305) {
                            NarakuBoss.handleDrop(npc);
                        }
                        if (npc.getId() == 187) {
                            HellraiserBossDrop.handleDrop(npc);
                        }
                        if (npc.getId() == 250) {
                            killer.getAchievementTracker().progress(AchievementData.HANTO, 1);
                        }
                        if (npc.getId() == 449) {
                            killer.getAchievementTracker().progress(AchievementData.RADITZ, 1);
                        }
                        if (npc.getId() == 452) {
                            killer.getAchievementTracker().progress(AchievementData.GOKU, 1);
                        }
                        if (npc.getId() == 185) {
                            killer.getAchievementTracker().progress(AchievementData.INUYASHA, 1);
                        }
                        if (npc.getId() == Exoden.MINION_NPCID) {
                            Exoden.minions_dead = true;
                            Exoden.minions_spawned = false;
                        }

                        ProgressionZone.handleKill(killer, npc.getId());

                        /** LOCATION KILLS **/
                        if (npc.getLocation().handleKilledNPC(killer, npc)) {
                            stop();
                            return;
                        }
                        if (npc.getPosition().getRegionId() == 7758) {
                            killer.vod.killBarrowsNpc(killer, npc, true);
                            stop();
                            return;
                        }

                        if (npc.getPosition().getRegionId() == 8782) {
                            killer.hov.killBarrowsNpc(npc, true);
                            stop();
                            return;
                        }

                        if (NPCDrops.multiKillNpcs.contains(npc.getId())) {
                            NPCDrops.dropItemsMultiKill(npc);
                        } else {
                            HellraiserSystem.npckills++;
                            HellraiserSystem.spawnBoss();
                            HellraiserSystem.callBoss();
                            killer.getAchievementTracker().progress(AchievementData.REACH_10K_KILLS, 1);
                            killer.getAchievementTracker().progress(AchievementData.REACH_100K_KILLS, 1);
                            killer.getAchievementTracker().progress(AchievementData.REACH_500K_KILLS, 1);
                            killer.getAchievementTracker().progress(AchievementData.ONE_MILLION, 1);
                            killer.getAchievementTracker().progress(AchievementData.TWO_MILLION, 1);
                            killer.getPointsHandler().incrementNPCKILLCount(1);
                            AfkSystem.rewardAfkSoulsToZonePlayers();

                            if (!npc.isEventBoss()) {
                                NPCDrops.handleDrops(killer, npc, 1);

                               // NPCDrops.dropItems(killer, npc);
                            }
                        }
                        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null
                                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
                            killer.getPointsHandler().incrementNPCKILLCount(1);
                            killer.getAchievementTracker().progress(AchievementData.REACH_10K_KILLS, 1);
                            killer.getAchievementTracker().progress(AchievementData.REACH_100K_KILLS, 1);
                            killer.getAchievementTracker().progress(AchievementData.REACH_500K_KILLS, 1);
                            killer.getAchievementTracker().progress(AchievementData.ONE_MILLION, 1);
                            HellraiserSystem.npckills++;
                        }
                        int rngRoll = Misc.getRandom(1, 100);
                        if (killer.isMembershipUnlocked() && rngRoll > 90) {
                            killer.getPointsHandler().incrementNPCKILLCount(1);
                            killer.getAchievementTracker().progress(AchievementData.REACH_10K_KILLS, 1);
                            killer.getAchievementTracker().progress(AchievementData.REACH_100K_KILLS, 1);
                            killer.getAchievementTracker().progress(AchievementData.REACH_500K_KILLS, 1);
                            killer.getAchievementTracker().progress(AchievementData.ONE_MILLION, 1);
                            HellraiserSystem.npckills++;
                            if (killer.membershipMessages)
                            killer.getPacketSender().sendMessage("You received x2 KC from your Membership status.");
                        }
                        if (npc instanceof GlobalBoss) {
                            GlobalBossHandler.onDeath((GlobalBoss) npc);
                        }
                        if (npc.getId() == 6804)
                        killer.getPointsHandler().incrementQuestOneDreamKC(1);

                        if (npc.getId() == 6804 &&
                            killer.getPointsHandler().getQuestOneDreamKC() == 50) {
                            killer.setQuestOneStep3(true);
                            killer.getPacketSender().sendMessage("<img=832>You completed a quest objective: @blu@Fight off the Daganoth Army");
                        }


                        /** BOSS EVENT **/
                        BossEventHandler handler = new BossEventHandler();
                        handler.death(killer, npc, npc.getDefinition().getName());
                        killer.getInstanceManager().death(killer, npc, npc.getDefinition().getName());
                        new DailyTaskHandler(killer).death(npc.getDefinition().getName());

                        /** SLAYER **/
                        killer.getSlayer().killedNpc(npc);
                        if (npc.getId() == killer.getSlayer().getSlayerTask().getNpcId() && Misc.getRandom(1,1000) == 575) {
                            NPC npc = new NPC(13479, new Position(killer.getPosition().getX() + 1, killer.getPosition().getY() + 1, killer.getPosition().getZ()));
                           killer.setCanKillSlayerBoss(true);
                            killer.getPacketSender().sendMessage("@red@ A Supreme Dark beast has spawned near you, kill it for rewards!");
                           System.out.println("npc:" + npc);
                            World.register(npc);
                            npc.performGraphic(new Graphic(189));
                        }

                        if (npc.getId() == 13749) {
                            NPC npc = new NPC(13479, new Position(killer.getLocation().getX().length + 1, killer.getLocation().getX().length + 1, killer.getLocation().getX().length));
                            killer.setCanKillSlayerBoss(false);
                            World.deregister(npc);
                        }



                        npc.getCombatBuilder().getDamageMap().clear();

                        if (String.valueOf(KillsTracker.getTotalKillsForNpc(npc.getDefinition().getId(), killer)).endsWith("500") ||
                                String.valueOf(KillsTracker.getTotalKillsForNpc(npc.getDefinition().getId(), killer)).endsWith("000")) {
                            killer.sendMessage(" You now have: @red@" + KillsTracker.getTotalKillsForNpc(npc.getDefinition().getId(), killer) + " " + (npc.getDefinition().getName()) + " kills.");
                        }

                        if (KillsTracker.getTotalKills(killer) % 500 == 0){
                            Cases.grantCasket(killer, 3);
                        }
                        if (KillsTracker.getTotalKills(killer) >= 500 && !killer.getSeasonPass().isReceived500KCXP()) {
                            killer.getSeasonPass().addExperience(1);
                            killer.getSeasonPass().setReceived500KCXP(true);
                        }
                    }
                    stop();
                    break;
            }
            ticks--;
        } catch (Exception e) {
            e.printStackTrace();
            stop();
        }
    }

    @Override
    public void stop() {

        setEventRunning(false);

        npc.setDying(false);
        PlayerPanel.refreshPanel(killer);
        // respawn
        /*
        if (npc.getDefinition().getRespawnTime() > 0
                && npc.getLocation() != Location.PYRAMID
                && npc.getLocation() != Location.DUNGEONEERING
                && npc.getLocation() != Location.CUSTOM_RAIDS && !npc.isEventBoss()
                && npc.getLocation() != Location.KEEPERS_OF_LIGHT_GAME) {
            if (npc.respawn)
                TaskManager.submit(new NPCRespawnTask(npc, npc.getDefinition().getRespawnTime(), killer));
        }
*/
        if (npc.isEventBoss()) {
            EventBossDropHandler.death(killer, npc);
        }

        if (npc.getDefinition().getRespawnTime() > 0 && npc.getLocation() != Location.PYRAMID
                && npc.getLocation() != Location.DUNGEONEERING && !npc.isEventBoss()) {

            boolean instanceNPC = npc.getLocation()  == Location.INSTANCE1
                    || npc.getLocation()  == Location.INSTANCE2;

            TaskManager.submit(new NPCRespawnTask(npc, instanceNPC ? 6 : npc.getDefinition().getRespawnTime(), killer, instanceNPC));
        }

        World.deregister(npc);

        if (npc.getId() == 1158 || npc.getId() == 1160) {
            KalphiteQueen.death(npc.getId(), npc.getPosition());
        }
        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 1614
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getAchievementTracker().progress(AchievementData.DUSTCLAW, 2);
            killer.getPointsHandler().incrementSPAWNKILLCount(2);
        } else if (npc.getId() == 1614) {// spawn
            killer.getPointsHandler().incrementSPAWNKILLCount(1);
            killer.getAchievementTracker().progress(AchievementData.DUSTCLAW, 1);

        }
        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 603
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().incrementLORDKILLCount(2);
            killer.getAchievementTracker().progress(AchievementData.LORD, 2);
        } else if (npc.getId() == 603) {
            killer.getPointsHandler().incrementLORDKILLCount(1);
            killer.getAchievementTracker().progress(AchievementData.LORD, 1);
        }

        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 12843
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().incrementDEMONKILLCount(2);
            killer.getAchievementTracker().progress(AchievementData.SHADOW, 2);
        } else if (npc.getId() == 12843) {// demon
            killer.getPointsHandler().incrementDEMONKILLCount(1);
            killer.getAchievementTracker().progress(AchievementData.SHADOW, 1);
        }

        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 53
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().incrementDRAGONKILLCount(2);
            killer.getAchievementTracker().progress(AchievementData.GOLEM, 2);
        } else if (npc.getId() == 53) {// dragon
            killer.getPointsHandler().incrementDRAGONKILLCount(1);
            killer.getAchievementTracker().progress(AchievementData.GOLEM, 1);

        }

        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 8018
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().incrementBEASTKILLCount(2);
            killer.getAchievementTracker().progress(AchievementData.SHETANI, 2);
        } else if (npc.getId() == 8018) {// beast
            killer.getPointsHandler().incrementBEASTKILLCount(1);
            killer.getAchievementTracker().progress(AchievementData.SHETANI, 1);
        }

        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 13635
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().incrementKINGKILLCount(2);
            killer.getAchievementTracker().progress(AchievementData.RIPPER, 2);
        } else if (npc.getId() == 13635) {// king
            killer.getPointsHandler().incrementKINGKILLCount(1);
            killer.getAchievementTracker().progress(AchievementData.RIPPER, 1);

        }

        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 8008
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().incrementAVATARKILLCount(2);
            killer.getAchievementTracker().progress(AchievementData.AVATAR, 1);
        } else if (npc.getId() == 8008) {// avatar
            killer.getPointsHandler().incrementAVATARKILLCount(1);
            killer.getAchievementTracker().progress(AchievementData.AVATAR, 1);

        }
        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 3308
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().incrementANGELKILLCount(2);
            killer.getAchievementTracker().progress(AchievementData.WYVERNS, 1);
        } else if (npc.getId() == 3308) {// angel
            killer.getPointsHandler().incrementANGELKILLCount(1);
            killer.getAchievementTracker().progress(AchievementData.WYVERNS, 1);

        }
        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 3117
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().incrementLUCIENKILLCount(2);
        } else if (npc.getId() == 3117) {// lucien
            killer.getPointsHandler().incrementLUCIENKILLCount(1);

        }

        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 201
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().incrementHERCULESKILLCount(2);
        } else if (npc.getId() == 201) {// hercules
            killer.getPointsHandler().incrementHERCULESKILLCount(1);

        }
        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 202
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().incrementSATANKILLCount(2);
        } else if (npc.getId() == 202) {// satan
            killer.getPointsHandler().incrementSATANKILLCount(1);

        }

        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 203
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().incrementZEUSKILLCount(2);
        } else if (npc.getId() == 203) {// zeus
            killer.getPointsHandler().incrementZEUSKILLCount(1);
        }
        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 277
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().addLesarkusWarriorKC(2);
        } else if (npc.getId() == 277) {// Lesarkus warrior
            killer.getPointsHandler().addLesarkusWarriorKC(1);
        }
        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 2359
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().addAncientWarriorKC(2);
        } else if (npc.getId() == 2359) {// Immortal Warrior
            killer.getPointsHandler().addAncientWarriorKC(1);
        }
        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 1914
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().addVampireWarriorKC(2);
        } else if (npc.getId() == 1914) {// Fatal Warrior
            killer.getPointsHandler().addVampireWarriorKC(1);
        }
        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 9116
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().addFacelessMagicianKC(2);
        } else if (npc.getId() == 9116) {// Faceless magician
            killer.getPointsHandler().addFacelessMagicianKC(1);
        }
        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 9117
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().addLotusMagicianKC(2);
        } else if (npc.getId() == 9117) {//  Lotus magician
            killer.getPointsHandler().addLotusMagicianKC(1);
        }
        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 9118
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().addShadowMagicianKC(2);
        } else if (npc.getId() == 9118) {//  Shadow magician
            killer.getPointsHandler().addShadowMagicianKC(1);
        }

        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 1508
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().addForestArcherKC(2);
        } else if (npc.getId() == 1508) {// Forest archer
            killer.getPointsHandler().addForestArcherKC(1);
        }
        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 1458
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().addChaoticArcherKC(2);
        } else if (npc.getId() == 1458) {//  Lotus magician
            killer.getPointsHandler().addChaoticArcherKC(1);
        }
        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 1457
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().addDivineArcherKC(2);
        } else if (npc.getId() == 1457) {//  Shadow magician
            killer.getPointsHandler().addDivineArcherKC(1);
        }
        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 8010
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().incrementGROUDONKILLCount(2);
        } else if (npc.getId() == 8010) {// zeus
            killer.getPointsHandler().incrementGROUDONKILLCount(1);
        }
        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 9807
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().incrementFENRIRKILLCount(2);
        } else if (npc.getId() == 9807) {// zeus
            killer.getPointsHandler().incrementFENRIRKILLCount(1);
        }
        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 7134
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().addBorkKC(2);
        } else if (npc.getId() == 7134) {// zeus
            killer.getPointsHandler().addBorkKC(1);
        }
        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 9011
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().incrementMiniLuciferKillCount(2);
        } else if (npc.getId() == 9011) {
            killer.getPointsHandler().incrementMiniLuciferKillCount(1);
        }

        if (killer.getSummoning() != null && killer.getSummoning().getFamiliar() != null && npc.getId() == 9012
                && killer.getSummoning().getFamiliar().getSummonNpc().getId() == 302) {
            killer.getPointsHandler().incrementLuciferKillCount(2);
            killer.getAchievementTracker().progress(AchievementData.ANGEL_KILLER, 2);
        } else if (npc.getId() == 9012) {// zeus
            killer.getPointsHandler().incrementLuciferKillCount(1);
            killer.getAchievementTracker().progress(AchievementData.ANGEL_KILLER, 1);
        }

        int ID_HERE = 1;
        int ITEM_ID = 91;

        if (npc.getId() == ID_HERE)
            killer.getInventory().add(ITEM_ID, 1);

        if (npc.getId() == 186) {
            int random = RandomUtility.inclusiveRandom(0, 100);
            if (random < killer.getPointsHandler().getGlobalRate()) {
                killer.getInventory().add(8212, 5);
                killer.getInventory().add(8213, 1);
                killer.getPointsHandler().incrementEventPoints(2);
                killer.sendMessage("Because of your 'Event rate' multiplier you got extra dust");
                killer.sendMessage("you also got a free Christmas token.");
            } else {
                killer.getInventory().add(8212, 2);
                killer.getPointsHandler().incrementEventPoints(2);
            }
        }

        if (npc.getId() == 5188) {// penguins
            killer.getInventory().add(12657, 50 + killer.getPointsHandler().getSHILLINGRate());

        }

        if (Nex.nexMob(npc.getId())) {
            Nex.death(npc.getId());
        }
        if (killer.getRegionInstance() != null) {
            if (npc.getLocation() == killer.getLocation()) {
                killer.getRegionInstance().getNpcsList().remove(npc);
            }
        }
    }
}
