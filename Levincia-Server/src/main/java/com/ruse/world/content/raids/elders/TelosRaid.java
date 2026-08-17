package com.ruse.world.content.raids.elders;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Locations;
import com.ruse.model.PlayerRights;
import com.ruse.model.Position;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.Cases;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.combat.prayer.CurseHandler;
import com.ruse.world.content.combat.prayer.PrayerHandler;
import com.ruse.world.content.combat.strategy.impl.Dragonkin;
import com.ruse.world.content.raids.system.RaidDifficulty;
import com.ruse.world.content.serverperks.ServerPerks;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import java.util.ArrayList;

public class TelosRaid {



    public static boolean canEnter(Player player, TelosRaidParty party) {
        if (!hasRequirements(party))
            return false;
        if (party.hasTradeOpen())
            return false;
        if (player.getLocation() != Locations.Location.TELOS_LOBBY) {
            player.sendMessage("You are not in the Elder Gods lobby.");
            return false;
        }
        return true;
    }

    public static boolean hasRequirements(TelosRaidParty party) {
        for (Player player : party.getPlayers()) {
            if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER)
                return true;

            if ((party.getDifficulty().equals(RaidDifficulty.INTERMEDIATE)
                    && player.getEasyElderGodKC() < party.getDifficulty().getGodsRequirement().getPreviousDifficultyAmount())
                    || (party.getDifficulty().equals(RaidDifficulty.ADVANCED)
                    && player.getMedElderGodKC() < 200)) {
                party.sendMessage(player.getUsername() + " does not have the correct kill requirements to partake in the Elder Gods Raids!");
                party.sendMessage("Every party member must have at least " + party.getDifficulty().getGodsRequirement().getPreviousDifficultyAmount() + " completions of the previous difficulty.");
                return false;
            }

            if (player.getPointsHandler ().getNecromancerKC () < 500) {
                party.sendMessage(player.getUsername() + " does not have 500 Necromancer Kills!");
                player.sendMessage("@red@You need to have at least 500 Necromancer Kills!");
                return false;
            }

            if ((!player.getMagicianMaster() || !player.getWarriorMaster () || !player.getArcherMaster ())) {
                party.sendMessage(player.getUsername() + " does not have all of the guilds completed to partake in the Elder Gods Raids!");
                player.sendMessage("@red@You need to have completed all of the guilds to partake in the Elder Gods Raids!");
                return false;
            }

        }
        return true;
    }

    public static void start(TelosRaidParty party) {

        Player p = party.getOwner();
        p.getPacketSender().sendInterfaceRemoval();
        if (!canEnter(p, party))
            return;

        if (party.hasEnteredRaids()) {
            p.getPacketSender().sendMessage("your party is already in fighting the Elder Gods!");
            return;
        }

        if (party.getPlayers().size() <= 0) {
            return;
        }

        if (party.getOwner() != p) {
            p.getPacketSender().sendMessage("Only the party leader can start the raid.");
            return;
        }

        for (Player member : party.getPlayers()) {
            if (member != null) {
                member.getPacketSender().sendInterfaceRemoval();
                if (member.getSummoning().getFamiliar() != null) {
                    member.getPacketSender()
                            .sendMessage("You must dismiss your familiar before being allowed to fight the Elder Gods.");
                    p.getPacketSender().sendMessage(
                            "" + p.getUsername() + " has to dismiss their familiar before you can fight the Elder Gods.");
                    return;
                }
            }
        }

        party.enteredDungeon(true);
        final int height = p.getIndex() * 4;
        World.getNpcs().forEach(n -> n.removeInstancedNpcs(Locations.Location.TELOS, height, null));

        for (Player member : party.getPlayers()) {
            member.setLastDifficulty(party.getDifficulty());
            member.getPacketSender().sendInterfaceRemoval();
            member.setRegionInstance(null);
            member.getMovementQueue().reset();
            member.getClickDelay().reset();
            member.moveTo(new Position(2922, 2944, height));
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
            member.setEnteredTelosRaids(false);
            member.setTelosRaidParty(party);
        }
        party.setDeathCount(0);
        party.setKills(0);
        party.sendMessage("@mag@Welcome to the Elder Gods Raids, The first wave will begin shortly");
        party.setCurrentPhase(1);
        party.setHeight(height);
        party.startElderGods();

    }
    public static void firstWave(TelosRaidParty party) {
        ArrayList<NPC> npcs = new ArrayList<NPC>();

        NPC npc = new NPC(9899, new Position(2922, 2927, party.getHeight()));

        double hp = (npc.getConstitution() + ((party.getPlayers().size() - 1) * npc.getConstitution()));
        if (party.getDifficulty() == RaidDifficulty.ADVANCED)
            hp *= 2.5D;
        /*
        boss.setConstitution((long) hp);
        boss.setDefaultConstitution((long) hp);
        */
            npc.setDefaultConstitution((int) hp);
            npc.setConstitution((int) hp);
            npcs.add(npc);
        TaskManager.submit(new Task(5, false) {

            @Override
            public void execute() {
                startTask(party, npcs, 1);
                stop();
            }
        });
    }

    public static void secondWave(TelosRaidParty party) {
        Dragonkin.minions_spawned = false;
        ArrayList<NPC> npcs = new ArrayList<NPC>();
        NPC npc = new NPC(9993, new Position(2961, 2927, party.getHeight()));
        npc.setDefaultConstitution((int) ((double) (npc.getConstitution()  * (party.getDifficulty().ordinal() + 1))));
        npc.setConstitution((int) ((double) (npc.getConstitution()  * (party.getDifficulty().ordinal() + 1))));
        npcs.add(npc);
        TaskManager.submit(new Task(3, false) {

            @Override
            public void execute() {
                startTask(party, npcs, 2);
                stop();
            }
        });
    }

    public static void thirdWave(TelosRaidParty party) {
        ArrayList<NPC> npcs = new ArrayList<NPC>();

        NPC npc = new NPC(9884, new Position(2943, 2968, party.getHeight()));
        npc.setDefaultConstitution((int) ((double) (npc.getConstitution()  * (party.getDifficulty().ordinal() + 1))));
        npc.setConstitution((int) ((double) (npc.getConstitution()  * (party.getDifficulty().ordinal() + 1))));
        npcs.add(npc);
        TaskManager.submit(new Task(3, false) {

            @Override
            public void execute() {
                startTask(party, npcs, 3);
                stop();
            }
        });
    }

    public static void startTask(TelosRaidParty party, ArrayList<NPC> npcs, int wave) {
        TaskManager.submit(new Task(1, false) {

            @Override
            public void execute() {

                TaskManager.submit(new Task(1, false) {
                    int tick = 0;

                    @Override
                    protected void execute() {
                        if ((party.getOwner().getLocation() != Locations.Location.TELOS)
                                || party.getPlayers().size() <= 0) {
                            party.sendMessage("@red@Your party has failed to kill the Elder Gods!");
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
                                finishRaid(party);
                            stop();
                        }

                        if (tick == 3) {
                            if (wave == 1)
                                party.sendMessage("@red@The Elder Gods Raids has started!");
                            else if (wave == 2) {
                                Dragonkin.minions_spawned = false;
                                party.sendMessage ("@red@The second wave has started!");
                            } else if (wave == 3)
                                party.sendMessage("@red@The third wave has started!");
                            else if (wave == 4)
                                party.sendMessage("@red@Final boss Telos has appeared!");
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

    public static void spawnNpc(TelosRaidParty party, NPC npc) {
        World.register(npc);
        Player player = randomPlayer(party);
        npc.getMovementQueue().setFollowCharacter(player);
        npc.getCombatBuilder().attack(player);
    }

    public static void handleDeath(TelosRaidParty party, Player player) {
        player.getPacketSender().sendWalkableInterface(144900, false);
        party.getPlayers().remove(player);
        player.moveTo(ElderGodsData.LOBBY);
        party.remove(player, true);

        player.sendMessage("@red@Your Elder Gods Drop rate has been halved because you died.");
        player.setElderDropRate( player.getElderDropRate() / 2);

        if (party.hasEnteredRaids() && party.getPlayers ().size () <= 0) {
            destroyInstance(party);
        }
    }

    public static Player randomPlayer(TelosRaidParty party) {
        return party.getPlayers().get(Misc.getRandom(party.getPlayers().size() - 1));
    }

    public static void finishRaid(TelosRaidParty party) {

        party.enteredDungeon(false);

        for (Player member : party.getPlayers()) {
        member.getPacketSender().sendInterfaceRemoval();
    }

        TaskManager.submit(new Task(3, false) {

        @Override
        public void execute() {
            long timerElapsed = party.getTimer().elapsed();
            String timeString = Misc.formatTime(timerElapsed);
            String prefix = "Easy";
            if (party.getDifficulty() == RaidDifficulty.INTERMEDIATE) {
                prefix = "Medium";
            } else if (party.getDifficulty() == RaidDifficulty.ADVANCED) {
                prefix = "Hard";
            }
            //party.sendMessage("Elder Gods ("+prefix+") completion time: @red@" + timeString);
            for (Player player : party.getPlayers()) {
                for (Player member : party.getPlayers()) {
                        if (member.getElderDropRate() + 0.25D >= 100D)
                            member.setElderDropRate( 100D);
                        else
                    if (party.getDifficulty() == RaidDifficulty.EASY1) {
                        if (member.getElderDropRate() + 0.25D >= 100D)
                            member.setElderDropRate( 100D);
                        else
                            member.setElderDropRate(member.getElderDropRate() + 0.25D);

                        if (member.getElderEasyTimer() <= 0
                                || timerElapsed < member.getElderEasyTimer()) {
                            member.setElderEasyTimer(timerElapsed);
                        }
                       // member.sendMessage("Personal Best ("+prefix+"): " + Misc.formatTime(member.getElderEasyTimer()));
                    } else if (party.getDifficulty() == RaidDifficulty.INTERMEDIATE1) {
                        if (member.getElderDropRate() + 0.5D >= 100D)
                            member.setElderDropRate( 100D);
                        else
                            member.setElderDropRate(member.getElderDropRate() + 0.5D);

                        if (member.getElderMedTimer() <= 0
                                || timerElapsed < member.getElderMedTimer()) {
                            member.setElderMedTimer(timerElapsed);
                        }
                      //  member.sendMessage("Personal Best ("+prefix+"): " + Misc.formatTime(member.getElderMedTimer()));
                    } else if (party.getDifficulty() == RaidDifficulty.ADVANCED1) {

                        if (member.getElderDropRate() + 1D >= 100D)
                            member.setElderDropRate( 100D);
                        else
                            member.setElderDropRate(member.getElderDropRate() + 1D);

                        if (member.getElderHardTimer() <= 0
                                || timerElapsed < member.getElderHardTimer()) {
                            member.setElderHardTimer(timerElapsed);
                        }
                       // member.sendMessage("Personal Best ("+prefix+"): " + Misc.formatTime(member.getElderHardTimer()));
                    }
                    if (party.getDifficulty() == RaidDifficulty.EASY1) {
                        member.setEasyElderGodKC(member.getEasyElderGodKC() + 1);
                        member.sendMessage("@blu@Elder Gods (Easy) KC: " + member.getEasyElderGodKC());
                    } else if (party.getDifficulty() == RaidDifficulty.INTERMEDIATE1) {
                        member.setMedElderGodKC(member.getMedElderGodKC() + 1);
                        member.sendMessage("@blu@Elder Gods (Medium) KC: " + member.getMedElderGodKC());
                    } else if (party.getDifficulty() == RaidDifficulty.ADVANCED1) {
                        member.setHardElderGodKC(member.getHardElderGodKC() + 1);
                        member.sendMessage("@blu@Elder Gods (Hard) KC: " + member.getHardElderGodKC());
                    }
                    member.getAchievementTracker().progress(AchievementData.NECROTIC, 1);
                    TelosLoot.handleLoot(member, party.getDifficulty());
                    member.getSeasonPass().addExperience(2);
                    Cases.grantCasket(player, 10);
                    if (ServerPerks.getInstance().getActivePerk() == ServerPerks.Perk.RAIDS_LOOT) {
                        TelosLoot.handleLoot(member, party.getDifficulty());
                    }
                    int random = Misc.inclusiveRandom(1,100);
                    if (player.getAmountDonated () > 20000 && random < 5) {
                        TelosLoot.handleLoot(member, party.getDifficulty());
                        member.sendMessage("You received a second drop as a chance from your donator rank.");
                    } else if ( member.getAmountDonated() >= 10000 && random <= 3
                            || member.getAmountDonated() >= 5000 && random <= 2
                            || member.getAmountDonated() >= 1000 && random <= 1) {
                        member.sendMessage("You received a second drop as a chance from your donator rank.");
                       TelosLoot.handleLoot(member, party.getDifficulty());
                    }

                    member.getDailyTaskManager().submitProgressToIdentifier(35, 1);
                    member.getAchievementTracker().progress(AchievementData.RAIDER, 1);
                    member.getPointsHandler().incrementTelosKC(1);
                }
                party.moveTo(ElderGodsData.LOBBY);
                player.getZombieRaidsParty ().enteredDungeon(false);
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

    public static void destroyInstance(TelosRaidParty party) {

        for (Player member : party.getPlayers()) {
            member.setEnteredTelosRaids(false);
        }
        party.moveTo(ElderGodsData.LOBBY);
        party.enteredDungeon(false);
        party.getPlayers().clear();

        for (NPC npc : party.getNpcs()) {
            if (npc != null && npc.getPosition().getZ() == party.getHeight())
                World.deregister(npc);
        }
    }

}
