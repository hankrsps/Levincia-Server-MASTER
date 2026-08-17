package com.ruse.world.entity.impl;

import com.ruse.model.GroundItem;
import com.ruse.model.Item;
import com.ruse.model.Position;
import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;

public class GlobalItemSpawner {

    public static Position ROCKCAKE_POSITION = new Position(3667, 2994, 0);
    private static long timer = System.currentTimeMillis();

    public static void startup() {
        if (System.currentTimeMillis() - timer > 1000 * 60) {
            World.sendGlobalGroundItems();
        }
    }

    public static void spawnGlobalGroundItems(Player player) {
        long a = System.currentTimeMillis();
        nullCheckAndSpawn(player, new Item(952, 1), new Position(3571, 3312, 0));
        long b = System.currentTimeMillis();
        nullCheckAndSpawn(player, new Item(1351, 1), new Position(2693, 9560, 0));
        nullCheckAndSpawn(player, new Item(1949, 1), new Position(3142, 3453, 0));
        nullCheckAndSpawn(player, new Item(1005, 1), new Position(3143, 3453, 0));
        nullCheckAndSpawn(player, new Item(946, 1), new Position(2891, 4120, 0));
        nullCheckAndSpawn(player, new Item(1923, 1), new Position(2882, 4120, 0));
        nullCheckAndSpawn(player, new Item(7546, 1), new Position(2888, 4122, 0));
        nullCheckAndSpawn(player, new Item(3727, 1), new Position(2888, 4123, 0));
        nullCheckAndSpawn(player, new Item(4682, 1), new Position(2940, 4127, 0));
        nullCheckAndSpawn(player, new Item(4682, 1), new Position(2763, 4064, 0));//holy symbol
        nullCheckAndSpawn(player, new Item(7546, 1), new Position(2788, 4050, 0));//rancid flour
        nullCheckAndSpawn(player, new Item(3727, 1), new Position(2787, 4050, 0));//empty bucket
        nullCheckAndSpawn(player, new Item(558, 1), new Position(3206, 3208, 0));
        nullCheckAndSpawn(player, new Item(7509, 1), ROCKCAKE_POSITION);
        timer = System.currentTimeMillis();
    }

    private static void nullCheckAndSpawn(Player player, Item item, Position pos) {
        if (GroundItemManager.getGroundItem(player, item, pos) == null) {
            GroundItemManager.spawnGroundItem(player,
                    new GroundItem(item, pos, player.getUsername(), false, 60 * 60, false, 0)); // each player will have
            // an instance of the
            // shovel, will last
            // 60*60 seconds (1 hr)
        }
    }

    public static void spawnEGG(Player player) {
        nullCheckAndSpawn(player, new Item(10537, 1), player.getPosition());
        timer = System.currentTimeMillis();
    }
}
