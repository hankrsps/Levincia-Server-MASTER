package com.ruse.world.content.osrscollectionlog;


import com.ruse.model.Item;
import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public enum LogType {

    MONSTERS, ZONES, BOSSES, MINIGAMES, BOXES;

    public void log(Player killer, int keyId, Item reward) {
        killer.getCollectionLog2().registerkill(keyId);
        if (reward == null) {
            System.out.println("Reward was null.");
            return;
        }
        reward = reward.copy(); // make sure not to handle the same instance as other game code uses

        Item finalReward = reward;
        Arrays.stream(Collection.values()).filter(e -> e.getLogType() == this && Arrays.stream(e.getObtainables()).anyMatch(colItem -> colItem.getId() == finalReward.getId()) && Arrays.stream(e.getKey()).anyMatch(n -> n == keyId)).findFirst().ifPresent(c -> {
            int before = killer.getCollectionLog2().totalObtained(c);

            killer.getCollectionLog2().collectionLog.compute(c, (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                    System.out.println("Hitting unique item : " + finalReward);
                    killer.sendMessage("@red@A unique item has been added to your collection log!");
                    v.add(finalReward);
                } else {
                    Optional<Item> first = v.stream().filter(loot -> loot.getId() == finalReward.getId()).findFirst();
                    if (first.isPresent()) {
                        first.get().setAmount(first.get().getAmount() + finalReward.getAmount());
                    } else {
                        v.add(finalReward);
                        System.out.println("Hitting unique item 2: " + finalReward);
                        killer.sendMessage("@red@A unique item has been added to your collection log!");
                    }
                }


                final int totalCollectables = c.totalCollectables();
                int after = killer.getCollectionLog2().totalObtained(c);
                if(after != before && after == totalCollectables) {
                    World.sendMessage( "@red@<img=832> " + killer.getUsername() +  "<col=297A29> completed the @red@"+c.getName()+" <col=297A29>collection log.");
                    killer.sendMessage("<col=297A29>Congratulations! You have completed the "+c.getName()+" collection log.");
                }
                return v;
            });
        });
    }
}

