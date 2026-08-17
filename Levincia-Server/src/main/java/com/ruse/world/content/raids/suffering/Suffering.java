package com.ruse.world.content.raids.suffering;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Locations;
import com.ruse.model.Position;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.Cases;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.combat.prayer.CurseHandler;
import com.ruse.world.content.combat.prayer.PrayerHandler;
import com.ruse.world.content.raids.system.RaidsParty;
import com.ruse.world.content.serverperks.ServerPerks;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import java.util.ArrayList;

public class Suffering {

    public static void start(RaidsParty party) {

        Player p = party.getOwner();
        p.getPacketSender().sendInterfaceRemoval();

        if (party.hasEnteredRaids()) {
            p.getPacketSender().sendMessage("your party is already in a raids!");
            return;
        }

        if (party.getOwner() != p) {
            p.getPacketSender().sendMessage("Only the party leader can start the fight.");
            return;
        }

        for (Player member : party.getPlayers()) {
            if (member != null) {
                member.getPacketSender().sendInterfaceRemoval();
                if (member.getSummoning().getFamiliar() != null) {
                    member.getPacketSender()
                            .sendMessage("You must dismiss your familiar before being allowed to enter a dungeon.");
                    p.getPacketSender().sendMessage(
                            "" + p.getUsername() + " has to dismiss their familiar before you can enter the dungeon.");
                    return;
                }
            }
        }

        party.enteredDungeon(true);
        final int height = p.getIndex() * 4;
        World.getNpcs().forEach(n -> n.removeInstancedNpcs(Locations.Location.SOD, height, null));

        for (Player member : party.getPlayers()) {
            member.getPacketSender().sendInterfaceRemoval();
            member.setRegionInstance(null);
            member.getMovementQueue().reset();
            member.getClickDelay().reset();
            member.moveTo(new Position(3445, 3978 , height));
            PrayerHandler.deactivateAll(member);
            CurseHandler.deactivateAll(member);
            TaskManager.submit(new Task(2, false) {

                @Override
                public void execute() {
                    PrayerHandler.deactivateAll(member);
                    CurseHandler.deactivateAll(member);
                    stop();
                }
            });
            member.getSkillManager().stopSkilling();
            member.getPacketSender().sendClientRightClickRemoval();
            member.getPacketSender().sendCameraNeutrality();
            member.setInsideRaids(false);
            member.setEnteredSODRaids(false);
            member.setRaidsParty(party);
        }
        party.setDeathCount(0);
        party.setKills(0);
        party.sendMessage("The Unholy Spirits welcome you to the Souls of Suffering.");
        party.setCurrentPhase(1);
        party.setHeight(height);
        party.startSODRaid();

    }

    public static NPC addNpc(RaidsParty party, int npcId, double mult) {
        NPC npc = (new NPC(npcId, new Position(2244 + Misc.getRandom(16), 4104 + Misc.getRandom(19), party.getHeight())));
        npc.setDefaultConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
        npc.setConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
        return npc;
    }

    public static void firstWave(RaidsParty party) {
        ArrayList<NPC> npcs = new ArrayList<NPC>();
        double mult = 2500;

            NPC npc = new NPC(SufferingData.firstWaveNpc, new Position(3422, 3978, party.getHeight()));
            npc.setDefaultConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npc.setConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npcs.add(npc);
        TaskManager.submit(new Task(10, false) {

            @Override
            public void execute() {
                startTask(party, npcs, 1);
                stop();
            }
        });
    }

    public static void secondWave(RaidsParty party) {

        ArrayList<NPC> npcs = new ArrayList<NPC>();
        double mult = 5000;
            NPC npc = new NPC(SufferingData.secondWaveNpc, new Position(3402, 3986, party.getHeight()));
            npc.setDefaultConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npc.setConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npcs.add(npc);
        TaskManager.submit(new Task(10, false) {

            @Override
            public void execute() {
                startTask(party, npcs, 2);
                stop();
            }
        });
    }

    public static void thirdWave(RaidsParty party) {

        ArrayList<NPC> npcs = new ArrayList<NPC>();
        double mult = 10000;
            NPC npc = new NPC(SufferingData.thirdWaveNpc, new Position(3403, 4017, party.getHeight()));
            npc.setDefaultConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npc.setConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npcs.add(npc);

        TaskManager.submit(new Task(10, false) {

            @Override
            public void execute() {
                startTask(party, npcs, 3);
                stop();
            }
        });
    }

    public static void fourthWave(RaidsParty party) {

        ArrayList<NPC> npcs = new ArrayList<NPC>();
        double mult = 20000;

            NPC npc = new NPC(SufferingData.fourthWaveNpc, new Position(3435, 4017, party.getHeight()));
            npc.setDefaultConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npc.setConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
            npcs.add(npc);
        TaskManager.submit(new Task(10, false) {

            @Override
            public void execute() {
                startTask(party, npcs, 4);
                stop();
            }
        });
    }

    public static void fifthWave(RaidsParty party) {

        ArrayList<NPC> npcs = new ArrayList<NPC>();

        double mult = 100000;

        NPC npc = new NPC(SufferingData.fifthWaveNpc, new Position(3420, 3998, party.getHeight()));
        npc.setDefaultConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
        npc.setConstitution((int) (npc.getConstitution() + (party.getPlayers().size() * mult)));
        npcs.add(npc);

        TaskManager.submit(new Task(10, false) {

            @Override
            public void execute() {
                startTask(party, npcs, 5);
                stop();
            }
        });
    }

    public static void startTask(RaidsParty party, ArrayList<NPC> npcs, int wave) {
        TaskManager.submit(new Task(1, false) {

            @Override
            public void execute() {

                TaskManager.submit(new Task(1, false) {
                    int tick = 0;

                    @Override
                    protected void execute() {
                        if ((party.getOwner().getLocation() != Locations.Location.SOD)
                                || party.getPlayers().size() <= 0) {
                            party.sendMessage("@red@Your party has failed to complete the Souls of Suffering Raid!");
                            destroyInstance(party);
                            stop();
                            
                            
                        }

                        if (!party.hasEnteredRaids())
                            stop();

                        int count = 0;
                        for (NPC npc : npcs) {
                            if (npc.getConstitution() <= 0)
                                count++;
                        }
                        if (count >= npcs.size()) {
                            if (wave == 1)
                                secondWave(party);
                            else if (wave == 2)
                                thirdWave(party);
                            else if (wave == 3)
                                fourthWave(party);
                            else if (wave == 4)
                                fifthWave(party);
                            else
                                finishRaid(party);
                            stop();
                        }

                        if (tick == 3) {
                            if (wave == 1)
                                party.sendMessage("@red@The first wave has started!");
                            else if (wave == 2)
                                party.sendMessage("@red@The second wave has started!");
                            else if (wave == 3)
                                party.sendMessage("@red@The third wave has started!");
                            else if (wave == 4)
                                party.sendMessage("@red@The fourth wave has started!");
                            else if (wave == 5)
                                party.sendMessage("@red@The final wave of suffering has started!");
                            for (NPC npc : npcs) {
                                spawnNpc(party, npc);
                            }
                        }

                        tick++;
                    }

                });

                stop();
            }
        });

    }

    public static void spawnNpc(RaidsParty party, NPC npc) {
        World.register(npc);
        Player player = randomPlayer(party);
        npc.getMovementQueue().setFollowCharacter(player);
        npc.getCombatBuilder().attack(player);
    }

    public static void handleDeath(RaidsParty party, Player player) {
        player.moveTo(new Position(3445, 3978 , party.getHeight()));
        player.sendMessage("@red@You died and were sent to beginning of the suffering.");
    }

    public static Player randomPlayer(RaidsParty party) {
        return party.getPlayers().get(Misc.getRandom(party.getPlayers().size() - 1));
    }

    public static void finishRaid(RaidsParty party) {

        party.enteredDungeon(false);

        for (Player member : party.getPlayers()) {
        member.getPacketSender().sendInterfaceRemoval();
    }

        TaskManager.submit(new Task(3, false) {

        @Override
        public void execute() {
            party.sendMessage("@red@Your party has defeated the Souls of Suffering!");

            for (Player player : party.getPlayers()) {
                for (Player member : party.getPlayers()) {
                    member.getInventory().add(23370, 1);
                    member.getSeasonPass().addExperience(2);
                    Cases.grantCasket(player, 10);
                    player.getDailyTaskManager().submitProgressToIdentifier(24, 1);
                    if (ServerPerks.getInstance().getActivePerk() == ServerPerks.Perk.RAIDS_LOOT) {
                        member.getInventory().add(23370, 1);
                    }
                    if (player.getInventory().contains(18649)) {
                        player.getInventory().delete(18649, 1);
                        member.getInventory().add(23370, 1);
                    }
                    if (player.getAmountDonated () > 20000 && Misc.getRandom (100) < 5) {
                        member.getInventory().add(23370, 1);
                        member.sendMessage("@red@Your Donator rank increased your keys earned!");
                    }
                    member.getAchievementTracker().progress(AchievementData.RAIDER, 1);
                    member.getPointsHandler().incrementSufferingKC(1);
                }
                party.moveTo(SufferingData.lobbyPosition);
                player.getZombieRaidsParty().enteredDungeon(false);
                party.setDeathCount(0);
                party.setKills(0);
                party.setCurrentPhase(1);

            }
            party.getPlayers().clear();
            stop();
        }
    });

}


    public static Box getLoot(Box[] loot, int size) {

        Box[] possibleDrops = new Box[loot.length];
        int possibleDropsCount = 0;
        for (Box drop : loot) {
            if (Misc.getRandom(100 * size) <= drop.getRate()) {
                possibleDrops[possibleDropsCount++] = drop;
            }
        }

        if (possibleDropsCount > 0) {
            return possibleDrops[Misc.getRandom((possibleDropsCount - 1))];
        } else {
            return loot[Misc.getRandom((possibleDropsCount - 1))];
        }
    }

    public static void destroyInstance(RaidsParty party) {

        for (Player member : party.getPlayers()) {
            member.setEnteredSODRaids(false);
        }
        party.moveTo(SufferingData.lobbyPosition);
        party.enteredDungeon(false);
        party.getPlayers().clear();

        for (NPC npc : party.getNpcs()) {
            if (npc != null && npc.getPosition().getZ() == party.getHeight())
                World.deregister(npc);
        }
    }

}
