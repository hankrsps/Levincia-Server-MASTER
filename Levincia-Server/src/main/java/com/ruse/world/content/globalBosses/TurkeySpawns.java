package com.ruse.world.content.globalBosses;

import com.ruse.model.Position;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.npc.NPCMovementCoordinator;
import com.ruse.world.entity.impl.player.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

public class TurkeySpawns extends NPC {
    private static long massMessageTimer = 0;
    public static boolean alive = false;
    public static int rng = 0,
            INTERVAL = 1 * 60 * 60_000, NPC_ID = 8499;

    public static final TurkeySpawnLocation[] LOCATIONS = {
            new TurkeySpawnLocation("Home", new int[]{2932, 4109},
                    new int[]{2937, 4104}, new int[]{2940, 4101},
                    new int[]{2940, 4108},new int[]{2940, 4107},new int[]{2940, 4106},
                    new int[]{2940, 4108},new int[]{2940, 4105},new int[]{2933, 4133},
                    new int[]{2940, 4104},new int[]{2940, 4103},new int[]{2940, 4102},
                    new int[]{2938, 4119},new int[]{2936, 4124},new int[]{2940, 4102},
                    new int[]{2930, 4132},new int[]{2929, 4132},new int[]{2928, 4132},
                    new int[]{2927, 4132},new int[]{2925, 4128},new int[]{2923, 4125},
                    new int[]{2930, 4123},new int[]{2920, 4125},new int[]{2918, 4126},
                    new int[]{2914, 4117},new int[]{2917, 4114},new int[]{2917, 4107},
                    new int[]{2911, 4105},new int[]{2905, 4109},new int[]{2900, 4111},
                    new int[]{2903, 4116},new int[]{2904, 4118},new int[]{2908, 4125},
                    new int[]{2907, 4131},new int[]{2903, 4132},new int[]{2899, 4128},
                    new int[]{2897, 4121}
            )};

    public static int[] NPC_IDS = new int[]{8504, 8505, 8506, 8508, 8510};

    @Getter
    @Setter
    private static TurkeySpawns current;
    @Getter
    private static TurkeySpawnLocation currentLocation;

    public TurkeySpawns(Position position) {
        super(NPC_IDS[Misc.getRandom(NPC_IDS.length - 1)], position);
        getMovementCoordinator().setCoordinator(new NPCMovementCoordinator.Coordinator(true, 10));
    }


    public static String getTimeLeft() {
        long ms = (INTERVAL - (System.currentTimeMillis() - massMessageTimer));
        if (amountSpawned == 0)
            ms = (INTERVAL - (System.currentTimeMillis() - massMessageTimer) - (45 * 60_000));

        return String.format("%dhr %dmin %ds", TimeUnit.MILLISECONDS.toHours(ms),
                TimeUnit.MILLISECONDS.toMinutes(ms) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(ms)),
                TimeUnit.MILLISECONDS.toSeconds(ms) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ms)));
    }

    public static int amountSpawned = 0;

    public static void initialize() {
        if (massMessageTimer == 0) {
            massMessageTimer = System.currentTimeMillis();
        }
        if (amountSpawned == 0 && (System.currentTimeMillis() - massMessageTimer >= (45 * 60_000))) {
            massMessageTimer = System.currentTimeMillis();
            spawn();
            amountSpawned++;
        }
        if ((System.currentTimeMillis() - massMessageTimer >= INTERVAL)) {
            massMessageTimer = System.currentTimeMillis();
            spawn();
        }
    }

    public static void spawn() {
        if (alive == true) {
            World.sendBroadcastMessage("The Hidden Turkey is roaming around <col=ff0000>" + LOCATIONS[rng].getLocation(), 300);
            return;
        }
        rng = Misc.randomMinusOne(LOCATIONS.length);
        TurkeySpawnLocation location = LOCATIONS[rng];
        TurkeySpawns instance = new TurkeySpawns(location.getRandomLocation());
        World.register(instance);
        setCurrent(instance);
        alive = true;

        currentLocation = location;

        World.sendBroadcastMessage("The Hidden Turkey is roaming around <col=ff0000>" + location.getLocation()
                + " - Find it for a reward!" , 300);
        World.sendMessage("<img=862>@blu@[Thanksgiving]<img=862> @or2@" + "The Hidden Turkey is roaming around <col=ff0000>"
                + location.getLocation()
                + "@or2@ - @red@Find it for a reward!");
    }

    public static void findTurkey(NPC npc, Player player) {
        if (!alive) {
            player.sendMessage("The Hidden turkey has already been found.");
            return;
        }
        if (!npc.equals(getCurrent())) {
            player.sendMessage("This is not the correct turkey.");
            return;
        }

        World.deregister(npc);
        alive = false;
        setCurrent(null);
        World.sendMessage("<img=862>@blu@[Thanksgiving]<img=862> @mag@" + player.getUsername() + "@or2@ has found the Hidden Turkey!");
        World.sendMessage("<img=862>@blu@[Thanksgiving]<img=862> @mag@" + player.getUsername()
                + "@or2@ got: @red@$1 Scroll, x10 Turkey Feathers, x2 Vote scrolls");
        World.sendBroadcastMessage("The Hidden Turkey has been found!" , 10);

        player.getInventory().add(10946, 1);
        player.getInventory().add(23510, 10);
        player.getInventory().add(23020, 2);
    }

    public static void handleDrop(NPC npc) {
        alive = false;
        setCurrent(null);
    }


    @Getter
    @Setter
    public static class TurkeySpawnLocation {

        private String location;
        private int[][] coords;

        public TurkeySpawnLocation(String location, int[]... coords) {
            this.location = location;
            this.coords = coords;
        }

        public Position getRandomLocation() {
            int[] coord = coords[Misc.getRandom(coords.length)];
            return new Position(coord[0], coord[1], 0);
        }

    }

}