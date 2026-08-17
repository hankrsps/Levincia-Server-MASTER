package com.ruse.world.content;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.*;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.webhooks.discord.DiscordMessager;
import com.ruse.world.World;
import com.ruse.world.content.dialogue.DialogueManager;
import com.ruse.world.content.transportation.TeleportHandler;
import com.ruse.world.content.transportation.TeleportType;
import com.ruse.world.entity.impl.player.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.TimeUnit;

public class FantasyZone {

    public static boolean gameActive = true;
    public static long massMessageTimer = System.currentTimeMillis();
    public static long INTERVAL = TimeUnit.MINUTES.toMillis(180);//180
    public static int gameTicks = 6000;

    public static String getTimeLeft() {
        long ms = ((INTERVAL) - (System.currentTimeMillis() - massMessageTimer));
        return String.format("%dhrs %dmin %ds",
                TimeUnit.MILLISECONDS.toHours(ms) - TimeUnit.HOURS.toHours(TimeUnit.MILLISECONDS.toDays(ms)),
                TimeUnit.MILLISECONDS.toMinutes(ms) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(ms)),
                TimeUnit.MILLISECONDS.toSeconds(ms) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ms)));
    }

    public static void initialize() {
        if ((System.currentTimeMillis() - massMessageTimer >= (INTERVAL))) {
            spawn();
            INTERVAL = TimeUnit.MINUTES.toMillis(180);//180
        }
        if (gameActive)
            processGame();
    }

    public static void processGame() {
        if (gameTicks == 0) {
            World.sendMessage("<img=856>@blu@[Fantasy]<img=856> <col=29a7cc>The Fantasy Portal has closed!");
            gameActive = false;
        }else{
            gameTicks --;
            if (gameTicks == 1000 || gameTicks == 500 || gameTicks == 1500 || gameTicks == 3000 || gameTicks == 4500){
                sendMessage("<col=29a7cc>The Fantasy Zone will close in "+(gameTicks / 100)+" minutes.");
            }
            if (gameTicks == 100){
                sendMessage("<col=29a7cc>The Fantasy Zone will close in one minute.");
            }
            if (gameTicks == 50){
                sendMessage("<col=29a7cc>The Fantasy Zone will close in 30 seconds.");
            }
        }
    }

    public static void sendMessage(String message) {
        for (Player p : World.getPlayers()) {
            if (p == null)
                continue;
            p.setSoulInPouch(0);
            if (p.getLocation().equals(Locations.Location.FANTASY_ZONE)) {
                p.sendMessage(message);
            }
        }
    }


    public static void spawn() {
        gameActive = true;
                DiscordMessager.sendCelestialLog("");

        World.sendMessage("<img=832> The Fantasy Realm has opened for 1 hour (Fantasy Realm members only)");
        massMessageTimer = System.currentTimeMillis();
        gameTicks = 6000;
        for (Player p : World.getPlayers()) {
            if (p == null)
                continue;
            if (p.getLocation() == Locations.Location.FANTASY_ZONE)
                p.getPA().sendEffectTimerSeconds(60000, EffectTimer.FANTASY_ZONE);
        }
    }


    public static void FantasyPortal(Player player) {
        if (player.getCelestial()) {
            if (gameActive) {
                player.sendMessage("@mag@You have entered the Fantasy Realm!");
                TeleportHandler.teleportPlayer(player, new Position(4257, 5598, 0), TeleportType.NORMAL);
            } else {
                DialogueManager.sendStatement(player, "The Fantasy Realm Portal will open in " + FantasyZone.getTimeLeft());
            }
        } else {
            DialogueManager.sendStatement(player, "You must be a member of the Fantasy Realm to do this.");
        }
    }

    public static void movePlayer(Player player) {
        player.moveTo(new Position(2932, 4126, 0));
        feedFire(player);
    }

    public static void pickMushroom(Player player, GameObject gameObject) {
        if (!gameActive) {
            player.getPacketSender().sendMessage("The Fantasy Realm is not open.");
            return;
        }
            if (!player.getClickDelay().elapsed(1200))
            return;
        if (player.getInventory().isFull()) {
            player.getPacketSender().sendMessage("You don't have enough free inventory space.");
            return;
        }
        player.performAnimation(new Animation(881));
        player.getInventory().add(17821, 1);
        player.getPacketSender().sendMessage("You pick some Fantasy mushroom.");

        CustomObjects.globalObjectRespawnTask(new GameObject(12005, gameObject.getPosition(), gameObject.getType(), gameObject.getFace()),
                gameObject, 5);

        player.getClickDelay().reset();
    }


    public static void smeltBar(Player player) {
        System.out.println ("Hott ASS");
        if (!gameActive) {
            player.getPacketSender().sendMessage("The Fantasy Realm is not open.");
            return;
        }
        if (!player.getInventory().contains(23295)) {
            player.sendMessage("You need Fantasy Ores to do this.");
            return;
        }
        int amount = player.getInventory().getAmount(23295);

        player.getSkillManager().stopSkilling();
        player.getPacketSender().sendInterfaceRemoval();
        player.performAnimation(new Animation(896));
        player.setCurrentTask(new Task(2, player, true) {
            int amountMade = 0;

            @Override
            public void execute() {
                if (!player.getInventory().contains(23295)) {
                    stop();
                    return;
                }
                player.performAnimation(new Animation(896));

                player.getInventory().delete(23295, 1);
                player.getInventory().add(2893, 1);

                amountMade++;
                if (amountMade >= amount)
                    stop();
            }
        });
        TaskManager.submit(player.getCurrentTask());
    }

    public static void useItem(Player player, int item) {
        if (item == 23351 || item == 23352 || item == 23353 || item == 7995 || item == 22111) {
            if (player.getCelestial()) {
                player.sendMessage("@red@You are already a member of the Fantasy Realm!");
            } else {
                    if (player.getInventory().contains(item)) {
                        player.getInventory().delete(item, 1);
                        if (player.isSacrificedFantasyItem()) {
                            player.sendMessage("<col=29a7cc>You sacrificed 2/2 Owner items to the Fantasy being.");
                            World.sendMessage("@blu@<img=856>[Fantasy]<img=856><col=29a7cc>" + player.getUsername() + " is now a member of the Fantasy Realm!");

                            player.setCelestial(true);
                            player.getUpdateFlag().flag(Flag.APPEARANCE);
                        } else {
                            player.setSacrificedFantasyItem(true);
                            player.sendMessage("<col=29a7cc>You sacrificed 1/2 Owner items to the Fantasy being.");
                    }
                } else {
                    player.sendMessage("");
                }
            }
        }
    }

    public static void feedFire(Player player) {
        if (!gameActive) {
            player.getPacketSender().sendMessage("The Fantasy Zone is not open.");
            return;
        }
        for (FantasyItems FantasyItems : FantasyItems.values()) {
            if (player.getInventory().contains(FantasyItems.getItemId())) {
                double amount = player.getInventory().getAmount(FantasyItems.getItemId()) * FantasyItems.getEnergy()  ;
                amount *= 1.1;

                double boost = 1D;
                if (player.getEquipment().contains(23456)) {
                    boost += 1.2D;
                }else {
                    for (int i = 14050; i <= 14055; i++) {
                        if (player.getEquipment().contains(i) || player.getEquipment().contains(18333)) {
                            boost += 0.2D;
                        }
                    }
                }
                amount *= boost * 2;

                if (amount <= 2)
                    amount = 2;

                System.out.println("amount: " + amount);

                player.sendMessage("<col=29a7cc>You feed the fire x" + player.getInventory().getAmount(FantasyItems.getItemId()) + " "
                        + ItemDefinition.forId(FantasyItems.getItemId()).getName() + " and receive " + amount + " Dark matter.");

                player.getInventory().delete(FantasyItems.getItemId(), player.getInventory().getAmount(FantasyItems.getItemId()));
                player.getInventory().add(23273, (int) amount);

                player.getDailyTaskManager().submitProgressToIdentifier(46, (int) amount);
            }
        }
    }

    @AllArgsConstructor
    @Getter
    public enum FantasyItems {
        SCALES(23294, 1.5),
        MUSHROOMS(17821, 1.2),
        BARS(2893, 2.2),
        ORES(23295, 1.0),

        ;
        private int itemId;
        private double energy;
    }

}