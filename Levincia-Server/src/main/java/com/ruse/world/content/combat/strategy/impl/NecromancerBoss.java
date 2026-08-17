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


public class NecromancerBoss implements CombatStrategy {


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

        int random = Misc.random(5);
        if (random == 1) {
            randomFire(npc, player);
        } else if (random == 2) {
            dripPlayer(npc, player);
        } else {
            BaseAttacks.magicAttack(npc, player);
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
        return CombatType.MAGIC;
    }

    public Position startPosition() {
        return new Position(1821, 4255, getParty().getHeight());
    }

    public NecromancerRaidParty getParty() {
        return getParty();
    }

    public static Position getRandom(){
        int x = 1816 + Misc.getRandom(14);
        int y = 4250 + Misc.getRandom(10);
        if (RegionClipping.getClipping(x, y,0) != 0){
            return getRandom();
        }
        return new Position(x, y);
    }

    private static void dripPlayer(NPC npc, Player player) {
        ArrayList<Position> orbs = new ArrayList<> ();
        Player target = player;

        final Position[] lastPosition = {player.getPosition ()};

        new Projectile (npc, target, 197, 44, 3, 41, 43, 0).sendProjectile ();

        int random = Misc.getRandom (3);
        if (random == 1) {
            npc.forceChat ("What doesn't kill you, disappoints me!");
        } else if (random == 2) {
            npc.forceChat ("The dead make good soldiers!");
        }else if (random == 3)
            npc.forceChat("Revenge is beneath me!");
        else {
            npc.forceChat ("This will only cost my soul, i wasn't using it anyways!");
        }

        TaskManager.submit(new Task(1, npc, false) {
            int tick = 0;

            @Override
            public void execute() {
                if (npc == null || npc.isDying() || npc.getConstitution() <= 0) {
                    stop();
                    return;
                }

                if (tick >= 3 && tick % 2 == 1) {
                    for (final Player t : BaseAttacks.getPlayers(player)) {
                        if (t == null || t.isTeleporting() || npc.getPosition().distanceToPoint(t.getPosition().getX(), t.getPosition().getY()) > 25)
                            continue;
                        for (Position pos : orbs) {
                            player.getPacketSender().sendGlobalGraphic(new Graphic(197, GraphicHeight.LOW), pos);
                            if (t.getPosition().sameAs(pos)) {
                                t.dealDamage(new Hit(30 + Misc.getRandom(30), Hitmask.RED, CombatIcon.BLOCK));
                            }
                        }
                    }
                } else {
                    for (final Player t : BaseAttacks.getPlayers(player)) {
                        if (t == null || t.isTeleporting() || npc.getPosition().distanceToPoint(t.getPosition().getX(), t.getPosition().getY()) > 25)
                            continue;
                        for (Position pos : orbs) {
                            player.getPacketSender().sendGlobalGraphic(new Graphic(197, GraphicHeight.LOW), pos);
                            if (t.getPosition().sameAs(pos)) {
                                t.dealDamage(new Hit(30 + Misc.getRandom(30), Hitmask.RED, CombatIcon.BLOCK));
                            }
                        }
                    }
                }

                if (tick == 2) {
                    lastPosition[0] = player.getPosition();
                    player.sendMessage("@blu@The " + npc.getDefinition().getName() + " has thrown a following flame towards you.");
                }

                if (tick >= 3) {
                    player.getPacketSender().sendGlobalGraphic(new Graphic(197, GraphicHeight.LOW), lastPosition[0]);
                    orbs.add(lastPosition[0]);
                    lastPosition[0] = player.getPosition();
                }

                tick++;
                if (tick == 15) {
                    stop();
                }
            }
        });
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
                            .sendGraphic(new Graphic(281), position));
                }
                if (tick == 1) {
                    for (Player partyMember : player.getShadowRaidsParty().getPlayers()) {
                        if (positionList.contains(partyMember.getPosition())) {
                            partyMember.dealDamage(new Hit(Misc.random(250, 600), Hitmask.DARK_PURPLE, CombatIcon.NONE));
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

