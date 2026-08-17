
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


public class PlatinumBosses extends NPC {

    private static long massMessageTimer = 0;

    public static boolean bossAlive = false;
    public static List<Integer> NPC_IDS = Arrays.asList(10034, 10035, 10036,10037);
    public static long INTERVAL = TimeUnit.MINUTES.toMillis(180);

    public PlatinumBosses(int id, Position position) {
        super(id, position);
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
            World.sendBroadcastMessage("[Platinum] A Platinum boss has been roaming at ::platinum");
            GameSettings.broadcastMessage = "[Platinum] A Platinum boss has been roaming at ::platinum";
            GameSettings.broadcastTime = 100;
            return;
        }
        // Pick a random NPC ID from the list.
        int id = NPC_IDS.get(new Random().nextInt(NPC_IDS.size()));

        PlatinumBosses instance = new PlatinumBosses (id, new Position(2273, 4083, 0));
        World.register(instance);
        bossAlive = true;

        // Generate a message for the current NPC ID.
        String message = String.format("[Platinum] "+ getNpcName(id) + " has appeared at ::platinum");

        World.sendMessage("<img=857><col=989794>[Platinum]<img=857> <col=6a6967>" + getNpcName(id) + " has appeared at<col=2a2a29> ::platinum");

        World.sendBroadcastMessage(message);
        GameSettings.broadcastMessage = message;
        GameSettings.broadcastTime = 100;
        for (Player players : World.getPlayers()) {
            if (players == null) {
                continue;
            }
            players.getPacketSender().sendBroadCastMessage(message, 100);
        }
    }


    // Returns the name of the NPC with the given ID.
    public static String getNpcName(int id) {
        switch (id) {
            case 10034:
                return "Yugi Moto";
            case 10035:
                return "Dark Magician";
            case 10036:
                return "Armed Protector Dragon";
            case 10037:
                return "Exodia";
            // Add more cases as needed.
            default:
                return "Unknown NPC";
        }
    }


    public static void handleDrop(NPC npc) {
        bossAlive = false;
        //PumpkinSpawns.spawn();
        if (npc.getCombatBuilder().getDamageMap().size() == 0) {
            return;
        }
        Map<Player, Integer> killers = new HashMap<> ();

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

        List<Map.Entry<K, V>> sortedEntries = new ArrayList<Map.Entry<K, V>> (map.entrySet());

        Collections.sort(sortedEntries, new Comparator<Map.Entry<K, V>>() {

            @Override
            public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }

        });

        return sortedEntries;

    }


}