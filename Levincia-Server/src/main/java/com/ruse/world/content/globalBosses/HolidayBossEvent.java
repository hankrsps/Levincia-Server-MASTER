package com.ruse.world.content.globalBosses;

import com.ruse.GameSettings;
import com.ruse.model.Position;
import com.ruse.model.definitions.NPCDrops;
import com.ruse.world.World;
import com.ruse.world.content.KillsTracker;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.content.combat.CombatBuilder;
import com.ruse.world.content.combat.CombatFactory;
import com.ruse.world.content.dailytasks_new.DailyTask;
import com.ruse.world.content.startertasks.StarterTasks;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class HolidayBossEvent extends NPC {

    private static long massMessageTimer = 0;

    public static boolean bossAlive = false;
    public static int NPC_ID = 10005;
    public static long INTERVAL = TimeUnit.MINUTES.toMillis(45);

    public HolidayBossEvent(Position position) {
        super(NPC_ID, position);
    }

    public static String getTimeLeft() {
        long ms = ((INTERVAL) - (System.currentTimeMillis() - massMessageTimer));
        return String.format("%dmin %ds",
                TimeUnit.MILLISECONDS.toMinutes(ms) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(ms)),
                TimeUnit.MILLISECONDS.toSeconds(ms) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ms)));
    }

    public static void initialize() {
        if (massMessageTimer == 0 || (System.currentTimeMillis() - massMessageTimer >= (INTERVAL))) {
            massMessageTimer = System.currentTimeMillis();
            spawn();
        }
    }

    public static void spawn() {
        if (bossAlive) {
            World.sendBroadcastMessage("[Christmas] Krampus has appeared at ::event");
            GameSettings.broadcastMessage = "[Christmas] Krampus has appeared at ::event";
            GameSettings.broadcastTime = 100;
            return;
        }
        HolidayBossEvent instance = new HolidayBossEvent (new Position(2532, 2659, 0));
        World.register(instance);
        bossAlive = true;

        String message = "[Christmas] Krampus has appeared at ::event";

        World.sendMessage("<img=862><col=146b3a>[Christmas]<img=862> <col=bb2528>Krampus has appeared at<col=1c3c0d> ::event");

        World.sendBroadcastMessage("[Christmas] Krampus has appeared at ::event");
        GameSettings.broadcastMessage = "[Christmas] Krampus has appeared at ::event";
        GameSettings.broadcastTime = 100;
        for (Player players : World.getPlayers()) {
            if (players == null) {
                continue;
            }
            players.getPacketSender().sendBroadCastMessage(message, 100);
        }

    }


    public static void handleDrop(NPC npc) {
        bossAlive = false;
        //PumpkinSpawns.spawn();
        if (npc.getCombatBuilder().getDamageMap().size() == 0) {
            return;
        }
        Map<Player, Integer> killers = new HashMap<>();

        for (Map.Entry<Player, CombatBuilder.CombatDamageCache> entry : npc.getCombatBuilder().getDamageMap().entrySet()) {
            if (entry == null) {
                continue;
            }

            long timeout = entry.getValue().getStopwatch().elapsed();
            if (timeout > CombatFactory.DAMAGE_CACHE_TIMEOUT) {
                continue;
            }

            Player player = entry.getKey();
            if (player.getConstitution() <= 0 || !player.isRegistered()) {
                continue;
            }

            killers.put(player, entry.getValue().getDamage());
        }

        npc.getCombatBuilder().getDamageMap().clear();

        List<Map.Entry<Player, Integer>> result = sortEntries(killers);
        for (Iterator<Map.Entry<Player, Integer>> iterator = result.iterator(); iterator.hasNext(); ) {
            Map.Entry<Player, Integer> entry = iterator.next();
            Player killer = entry.getKey();

            StarterTasks.doProgress(killer, StarterTasks.StarterTask.KILL_GLOBALS);
            DailyTask.GLOBAL_BOSSES.tryProgress(killer);
            killer.getAchievementTracker().progress(AchievementData.KILL_5K_GLOBALS, 1);
            KillsTracker.submitById(killer, npc.getId(), true, npc.getDefinition().boss);
            KillsTracker.submitById(killer, npc.getId(), false, npc.getDefinition().boss);
            NPCDrops.handleDrops(killer, npc);
            iterator.remove();
        }
    }

    /**
     *
     * @param npc
     * @param player
     * @param damage
     */

    /**
     *
     * @param map
     * @return
     */
    static <K, V extends Comparable<? super V>> List<Map.Entry<K, V>> sortEntries(Map<K, V> map) {

        List<Map.Entry<K, V>> sortedEntries = new ArrayList<Map.Entry<K, V>>(map.entrySet());

        Collections.sort(sortedEntries, new Comparator<Map.Entry<K, V>>() {

            @Override
            public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }

        });

        return sortedEntries;

    }


}