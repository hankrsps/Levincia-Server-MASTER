package com.ruse.world.content.combat.strategy.impl;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.*;
import com.ruse.util.Misc;
import com.ruse.world.clip.region.RegionClipping;
import com.ruse.world.content.combat.CombatContainer;
import com.ruse.world.content.combat.CombatType;
import com.ruse.world.content.combat.strategy.CombatStrategy;
import com.ruse.world.content.raids.shadows.NecromancerRaidParty;
import com.ruse.world.entity.impl.Character;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import java.util.ArrayList;
import java.util.List;


public class RaidsFirstBoss implements CombatStrategy {


    @Override
    public boolean canAttack(Character entity, Character victim) {
        return true;
    }

    @Override
    public CombatContainer attack(Character entity, Character victim) {
        return null;
    }

    @Override
    public boolean customContainerAttack(Character entity, Character victim) {
        NPC npc = (NPC) entity;
        Player player = (Player) victim;
        /*
        if (player.getShadowRaidsParty() == null)
            return false;
*/

        int random = Misc.random(3);
        if (random == 1) {
            randomFire(npc, player);
        } else {
            BaseAttacks.meleeAttack(npc, player);
        }
        return true;
    }

    @Override
    public int attackDelay(Character entity) {
        return 2;
    }

    @Override
    public int attackDistance(Character entity) {
        return 40;
    }

    @Override
    public CombatType getCombatType() {
        return CombatType.MELEE;
    }

    public Position startPosition() {
        return new Position(3217, 2891, getParty().getHeight());
    }

    public NecromancerRaidParty getParty() {
        return getParty();
    }

    public static Position getRandom(){
        int x = 3212 + Misc.getRandom(14);
        int y = 2887 + Misc.getRandom(10);
        if (RegionClipping.getClipping(x, y,0) != 0){
            return getRandom();
        }
        return new Position(x, y);
    }

    public static void randomFire(NPC npc, Player player) {
        npc.setChargingAttack(true);
        npc.performAnimation(new Animation(npc.getDefinition().getAttackAnimation()));
        List<Position> positionList = new ArrayList<>();

        for (int i = 0 ; i < 20; i ++){
            positionList.add(getRandom().setZ(npc.getPosition().getZ()));
        }
        TaskManager.submit(new Task(1, true) {
            int tick = 0;

            @Override
            protected void execute() {
                if (tick == 0) {
                    positionList.forEach(position -> player.getPacketSender()
                            .sendGraphic(new Graphic(197), position));
                }
                if (tick == 1) {
                    for (Player partyMember : player.getShadowRaidsParty().getPlayers()) {
                        if (positionList.contains(partyMember.getPosition())) {
                            partyMember.dealDamage(new Hit(Misc.random(200, 600), Hitmask.DARK_PURPLE, CombatIcon.NONE));
                        }
                    }
                    npc.setChargingAttack(false);
                    stop();
                }
                tick++;
            }
        });
    }
};

