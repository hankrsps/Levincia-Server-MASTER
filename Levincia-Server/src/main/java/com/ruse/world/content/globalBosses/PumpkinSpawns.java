package com.ruse.world.content.globalBosses;

import com.ruse.GameSettings;
import com.ruse.model.*;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.CustomObjects;
import com.ruse.world.entity.impl.player.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PumpkinSpawns {

    public static final TurkeySpawnLocation[] LOCATIONS = {
            new TurkeySpawnLocation("Middle",
                    new int[]{2900, 4700},
                    new int[]{2920, 4713}),
            new TurkeySpawnLocation("Middle",
                    new int[]{2900, 4700},
                    new int[]{2920, 4713}),

    };

    private static long massMessageTimer = System.currentTimeMillis();

    public static long INTERVAL = TimeUnit.MINUTES.toMillis(5);

    public static String getTimeLeft() {
        long ms = ((INTERVAL) - (System.currentTimeMillis() - massMessageTimer));
        return String.format("%dmin %ds",
                TimeUnit.MILLISECONDS.toMinutes(ms) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(ms)),
                TimeUnit.MILLISECONDS.toSeconds(ms) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ms)));
    }

    public static void initialize() {
        if ((System.currentTimeMillis() - massMessageTimer >= (INTERVAL))) {
            massMessageTimer = System.currentTimeMillis();
            //spawn();
            INTERVAL = TimeUnit.MINUTES.toMillis(15 + Misc.getRandom(15));
        }
    }


    public static void loadEggs(Player player) {
        for (GameObject object : objects){
            if (object != null)
                player.getPacketSender().sendObject(object);
        }
    }


    public static ArrayList<GameObject> objects = new ArrayList<>();
    public static ArrayList<Position> positions = new ArrayList<>();

    public static void spawn() {
        if (objects.size() > 0){
            for (GameObject object : objects){
                if (object != null)
                    CustomObjects.deleteGlobalObject(object);
            }
        }
        objects.clear();
        positions.clear();

        while (objects.size() < 50) {
            int random = 1;
            TurkeySpawnLocation location = LOCATIONS[random];

            int x = Misc.getRandom(location.getCoords()[1][0] - location.getCoords()[0][0]);
            int y = Misc.getRandom(location.getCoords()[1][1] - location.getCoords()[0][1]);

            Position pos = new Position(location.getCoords()[0][0] + x, location.getCoords()[0][1] + y);
            if (!positions.contains(pos)) {
                positions.add(pos);
                GameObject gameObject = new GameObject(400, pos, 10, 0);
                gameObject.performGraphic(new Graphic(1028));
                gameObject.performAnimation(new Animation(2109));
                objects.add(gameObject);
                CustomObjects.spawnGlobalObject(gameObject);
            }
        }
        String message = "Pumpkins have spawned around ::hween - Find them for rewards!";
        World.sendMessage("<img=1760>@blu@[Halloween]<img=1760> <col=674ea7>" + "Pumpkins have spawned around @blu@::hween"
                + "<col=674ea7> - Find them for rewards!");
        World.sendBroadcastMessage("Pumpkins have spawned around ::hween - Find them for rewards!");
        GameSettings.broadcastMessage = "Pumpkins have spawned around ::hween - Find them for rewards!";
        GameSettings.broadcastTime = 100;
        for (Player players : World.getPlayers()) {
            if (players == null) {
                continue;
            }
            players.getPacketSender().sendBroadCastMessage(message, 100);
        }
        GameSettings.broadcastMessage = "Pumpkins have spawned around ::hween - Find them for rewards!";
        GameSettings.broadcastTime = 100;


        for (Player p : World.getPlayers()) {
            if (p == null)
                continue;
            p.setSoulInPouch(0);
            if (p.getLocation() == Locations.Location.EVENT) {
                p.sendMessage("You have been moved to the middle to collect pumpkins!");
                p.moveTo(new Position(2910, 4704, 0));
                loadEggs(p);
            }
        }
    }


    public static void claimEgg(Player player, GameObject gameObject) {
        if (!player.getEasterDelay().elapsed(2500)){
            player.sendMessage("You must wait three seconds before collecting more pumpkins.");
            return;
        }
        if (player.getSoulInPouch() >= 5){
            player.sendMessage("You have already gathered five pumpkins this batch.");
            return;
        }

        player.getEasterDelay().reset();

        boolean contains = false;
        for (GameObject object : objects) {
            if (object != null && object.getPosition().equals(gameObject.getPosition())) {
                player.sendMessage("@blu@You found an pumpkin!");

                player.getInventory().add(1959, 1);

                CustomObjects.deleteGlobalObject(object);
                player.setSoulInPouch(player.getSoulInPouch()  + 1);
                objects.remove(object);
                contains = true;
                break;
            }
        }

        if (!contains) {
            CustomObjects.deleteGlobalObject(gameObject);
        }

        if (objects.size() <= 0){
            World.sendMessage("<img=1760>@blu@[Halloween]<img=1760> <col=674ea7>All of the pumpkins have been found!");
        }
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

    }

}