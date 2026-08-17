package com.ruse.world.content.randomevents;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Animation;
import com.ruse.model.Graphic;
import com.ruse.model.Item;
import com.ruse.model.container.impl.Inventory;
import com.ruse.world.World;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;
import lombok.Getter;
import lombok.Setter;

public class Genie {

    @Getter
    @Setter
    private Player spawnedFor;
    @Getter
    @Setter
    private boolean claimed;

    public Genie(Player spawnedFor, boolean claimed) {
        this.spawnedFor = spawnedFor;
        this.claimed = claimed;
    }

    public static final int genieID = 409;

    private static final int lampID = 18782;

    private static final Item reward = new Item(lampID, 1);

    private static final Animation wave = new Animation(863);

    private static final Graphic smoke = new Graphic(188);

    public static void spawn(Player player) {
        String userName = player.getUsername();
        Genie genie = player.getGenie();
        genie.setClaimed(false);
        NPC genieNpc = new NPC(409, player.getPosition());
        genieNpc.setSpawnedFor(player);
        World.register(genieNpc);
        genieNpc.setResetMovementQueue(true);
        genieNpc.performGraphic(smoke);
        genieNpc.getMovementQueue().setFollowCharacter(player);
        genieNpc.performAnimation(wave);
        genieNpc.forceChat(userName + " I have a reward for you!");

        TaskManager.submit(new Task(60, false) {
            @Override
            protected void execute() {
                despawn(genieNpc);
            }
        });
    }

    public static void handleInteraction(NPC genieNpc, Player player, int click) {
        String userName = player.getUsername();
        Inventory invent = player.getInventory();
        boolean freeSlot = invent.getFreeSlots() >= 1;
        Genie playerGenie = player.getGenie();

        if (genieNpc.getSpawnedFor() == player
                && !player.getGenie().isClaimed()
                && playerGenie.getSpawnedFor() == player) {

            if (!freeSlot) {
                genieNpc.forceChat("You need to have at least one inventory slot free!");
                return;
            }

            switch (click) {
                case 1:
                    invent.add(reward);
                    playerGenie.setClaimed(true);
                    genieNpc.forceChat("Enjoy your reward " + userName + "!");
                    break;
                case 2:
                    player.getPacketSender().sendMessage("You dismiss the Genie!");
                    genieNpc.forceChat("Okay, bye for now " + userName + "!");
                    break;
            }
            despawn(genieNpc);
        } else if (playerGenie.isClaimed()){
            player.getPacketSender().sendMessage("You've already claimed your reward!");
        } else {
            player.getPacketSender().sendMessage("This Genie isn't here for you!");
        }
    }

    public static void despawn(NPC genieNpc) {
        if (genieNpc != null) {
            genieNpc.performAnimation(wave);
            genieNpc.performGraphic(smoke);

            TaskManager.submit(new Task(2, false) {
                @Override
                protected void execute() {
                    World.deregister(genieNpc);
                }
            });
        }
    }
}
