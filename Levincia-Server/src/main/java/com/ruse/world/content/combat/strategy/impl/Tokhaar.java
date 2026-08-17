package com.ruse.world.content.combat.strategy.impl;


import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.*;
import com.ruse.util.Misc;
import com.ruse.world.content.combat.CombatContainer;
import com.ruse.world.content.combat.CombatType;
import com.ruse.world.content.combat.prayer.CurseHandler;
import com.ruse.world.content.combat.prayer.PrayerHandler;
import com.ruse.world.content.combat.strategy.CombatStrategy;
import com.ruse.world.entity.impl.Character;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Tokhaar implements CombatStrategy {

    @Override
    public boolean canAttack(Character entity, Character victim) {
        return true;
    }

    @Override
    public CombatContainer attack(Character entity, Character victim) {
        return null;
    }

    private final Random random = new Random();
    private List<Position> chosenTiles = new ArrayList<>();

    @Override
    public boolean customContainerAttack(Character entity, Character victim) {
        Player player = (Player) victim;
        NPC npc = (NPC) entity;
        if (player.isDying() || player.getConstitution() <= 0 || !player.getPosition()
            .isWithinDistance(npc.getPosition(), 15)) {
            npc.getCombatBuilder().reset(true);
            return false;
        }
        if (npc.getCombatBuilder().getStrategy() == null) {
            return false;
        }
        npc.setChargingAttack(true);
        npc.getCombatBuilder().attack(player);
        npc.performAnimation(new Animation (npc.getDefinition().getAttackAnimation()));
        handlePrayerRemoval(player, npc);
        handleTileAttack(player, npc);
        return true;
    }

    private void handleTileAttack(Player player, NPC npc) {
        if (shouldTileAttack()) {
            setupTileAttack(player);
            TaskManager.submit(new Task (1) {
                @Override
                protected void execute() {
                    executeTileAttack(player, npc);
                    stop();
                }
            });
        }
    }

    private void executeTileAttack(Player player, NPC npc) {
        chosenTiles.forEach(chosenTile -> {
            if (!player.getLocalPlayers().contains(player)) {
                tileAttack(player, npc, chosenTile);
            }
            player.getLocalPlayers().forEach(local -> {
                tileAttack(local, npc, chosenTile);
            });
        });
        chosenTiles.clear();
    }

    private void tileAttack(Player player, NPC npc, Position chosenTile) {
       int random = Misc.getRandom (3);
        if (random == 1)
        npc.forceChat("You better watch out!");
        else if (random == 2)
            npc.forceChat ("You will be crushed");
        else if (random == 3)
            npc.forceChat ("My strength is to strong for a little human like you");
        else
            npc.forceChat ("The Elder Gods will not be defeated");
        player.getPacketSender().sendGlobalGraphic(new Graphic(626), chosenTile);
        TaskManager.submit(new Task(3, false) {
            @Override
            protected void execute() {
                if (player.getPosition().equals(chosenTile)) {
                    player.performGraphic(new Graphic (1629));
                    player.dealDamage(new Hit (Misc.getRandom (600,800), Hitmask.RED, CombatIcon.MELEE));
                    System.out.println("Tile was " + player.getPosition() + " | " + chosenTile);
                }
                stop();
            }
        });
    }

    private boolean shouldTileAttack() {
        return chosenTiles.isEmpty() && random.nextInt(100) > 35; // 5% chance
    }

    private void setupTileAttack(Player player) {
        List<Player> players = pickNRandom(player.getLocalPlayers(), 4);
        if (!player.getLocalPlayers().contains(player)) {
            players.add(player);
        }
        chosenTiles = players.stream().map(Player::getPosition).collect(Collectors.toList());
    }

    private void handlePrayerRemoval(Player player, NPC npc) {
        int n = random.nextInt(100);
        if (n > 85) {
            PrayerHandler.deactivateAll(player);
            CurseHandler.deactivateAll(player);
            player.getLocalPlayers().forEach(local -> {
                PrayerHandler.deactivateAll(local);
                CurseHandler.deactivateAll(local);
            });
        }
    }

    private List<Player> pickNRandom(List<Player> lst, int n) {
        List<Player> copy = new ArrayList<>(lst);
        Collections.shuffle(copy);
        return n > copy.size() ? copy.subList(0, copy.size()) : copy.subList(0, n);
    }

    @Override
    public int attackDelay(Character entity) {
        return entity.getAttackSpeed();
    }

    @Override
    public int attackDistance(Character entity) {
        return 15;
    }

    @Override
    public CombatType getCombatType() {
        return CombatType.MELEE;
    }
}
