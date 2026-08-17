package com.ruse.world.content.raids.shadows;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Locations;
import com.ruse.model.PlayerRights;
import com.ruse.model.Position;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.Cases;
import com.ruse.world.content.KillsTracker;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.combat.prayer.CurseHandler;
import com.ruse.world.content.combat.prayer.PrayerHandler;
import com.ruse.world.content.raids.system.RaidDifficulty;
import com.ruse.world.content.serverperks.ServerPerks;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import java.util.ArrayList;

public class NecromancerRaid {



    public static boolean canEnter(Player player, NecromancerRaidParty party) {

        if (!hasRequirements(party))
            return false;

        if (party.hasTradeOpen())
            return false;

        if (player.getLocation() != Locations.Location.DARKNESS_LOBBY) {
            player.sendMessage("You are not in the Necromancer lobby.");
            return false;
        }

        return true;
    }

    public static boolean hasRequirements(NecromancerRaidParty party) {
        for (Player player : party.getPlayers()) {

            if (((party.getDifficulty().equals(RaidDifficulty.INTERMEDIATE)
                    && player.getEasyIsleGodKC() < party.getDifficulty().getGodsRequirement().getPreviousDifficultyAmount())

                    || (party.getDifficulty().equals(RaidDifficulty.ADVANCED)
                    && player.getMedIsleGodKC() < 200))

                    && !player.getRights().isDeveloperOnly() && player.getRights() != PlayerRights.YOUTUBER) {
                party.sendMessage(player.getUsername() + " does not have the correct kill requirements to do this.");
                party.sendMessage("Every party member must have at least " + party.getDifficulty().getGodsRequirement().getPreviousDifficultyAmount() + " completions of the previous difficulty.");
                return false;
            }

            int total = KillsTracker.getTotalKillsForNpc(9813, player);

            if (total < 10000 && !player.getRights().isDeveloperOnly() && player.getRights() != PlayerRights.YOUTUBER) {
                party.sendMessage(player.getUsername() + " does not have the Blood Demon kill requirement to do this.");
                player.sendMessage("@red@You need 10,000 Blood Demon kills to fight the Necromancer!");
                return false;
            }

            if (player.getInventory().getAmount(12855) < party.getDifficulty().getGodsRequirement().getCost()) {
                party.sendMessage(player.getUsername() + " does not have " + Misc.insertCommasToNumber(party.getDifficulty().getGodsRequirement().getCost()) + " Levincia tokens.");
                player.sendMessage("@red@You need " + Misc.insertCommasToNumber(party.getDifficulty().getGodsRequirement().getCost()) + " Levincia tokens to fight the Necromancer!");
                return false;
            }

        }
        return true;
    }

    public static void removeTokens(NecromancerRaidParty party) {
        for (Player player : party.getPlayers()) {
            player.getInventory().delete(12855, party.getDifficulty().getGodsRequirement().getCost());
        }
    }
    public static void start(NecromancerRaidParty party) {

        Player p = party.getOwner();
        p.getPacketSender().sendInterfaceRemoval();

        if (!canEnter(p, party))
            return;

        if (party.hasEnteredRaids()) {
            p.getPacketSender().sendMessage("your party is already in fighting Necromancer!");
            return;
        }
        if (party.getPlayers().size() <= 0) {
            return;
        }
        if (party.getOwner() != p) {
            p.getPacketSender().sendMessage("Only the party leader can start the raid.");
            return;
        }

        removeTokens(party);
        for (Player member : party.getPlayers()) {
            if (member != null) {
                member.getPacketSender().sendInterfaceRemoval();
                if (member.getSummoning().getFamiliar() != null) {
                    member.getPacketSender()
                            .sendMessage("You must dismiss your familiar before being allowed to fight Necromancer.");
                    p.getPacketSender().sendMessage(
                            "" + p.getUsername() + " has to dismiss their familiar before you can fight Necromancer.");
                    return;
                }
            }
        }

        party.enteredDungeon(true);
        final int height = p.getIndex() * 4;
        World.getNpcs().forEach(n -> n.removeInstancedNpcs(Locations.Location.SHADOWS_OF_DARKNESS, height, null));

        for (Player member : party.getPlayers()) {
            member.setLastDifficulty(party.getDifficulty());
            member.getPacketSender().sendInterfaceRemoval();
            member.setRegionInstance(null);
            member.getMovementQueue().reset();
            member.getClickDelay().reset();
            member.moveTo(new Position(1820, 4247, height));
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
            member.setEnteredShadowRaids(false);
            member.setShadowRaidsParty(party);
        }
        party.setDeathCount(0);
        party.setKills(0);
        party.sendMessage("You arrive on a cold island of darkness.");
        party.setCurrentPhase(1);
        party.setHeight(height);
        party.startShadowRaid();

    }
    public static void firstWave(NecromancerRaidParty party) {
        ArrayList<NPC> npcs = new ArrayList<NPC>();

            NPC npc = new NPC(9894, new Position(1821, 4255, party.getHeight()));
            npc.setDefaultConstitution((int) ((double) (npc.getConstitution()  * (party.getDifficulty().ordinal() + 1))));
            npc.setConstitution((int) ((double) (npc.getConstitution()  * (party.getDifficulty().ordinal() + 1))));
            npcs.add(npc);
        TaskManager.submit(new Task(5, false) {

            @Override
            public void execute() {
                startTask(party, npcs, 1);
                stop();
            }
        });
    }

    public static void startTask(NecromancerRaidParty party, ArrayList<NPC> npcs, int wave) {
        TaskManager.submit(new Task(1, false) {

            @Override
            public void execute() {

                TaskManager.submit(new Task(1, false) {
                    int tick = 0;

                    @Override
                    protected void execute() {
                        if ((party.getOwner().getLocation() != Locations.Location.SHADOWS_OF_DARKNESS)
                                || party.getPlayers().size() <= 0) {
                            party.sendMessage("@red@Your party has failed to kill Necromancer!");
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
                                finishRaid(party);
                            stop();
                        }

                        if (tick == 3) {
                            if (wave == 1)
                                party.sendMessage("@red@Necromancer has appeared!");
                            if (wave == 2)
                                party.sendMessage("@red@You defeated Necromancer!");
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

    public static void spawnNpc(NecromancerRaidParty party, NPC npc) {
        World.register(npc);
        Player player = randomPlayer(party);
        npc.getMovementQueue().setFollowCharacter(player);
        npc.getCombatBuilder().attack(player);
    }

    public static void handleDeath(NecromancerRaidParty party, Player player) {
        player.getPacketSender().sendWalkableInterface(144900, false);
        party.getPlayers().remove(player);
        player.moveTo(ShadowData.lobbyPosition);
        party.remove(player, true);

        player.sendMessage("@red@Your Necromancer Drop rate has been halved because you died.");
        player.setIsleDropRate( player.getIsleDropRate() / 2);

        if (party.hasEnteredRaids() && party.getPlayers ().size () <= 0) {
            destroyInstance(party);
        }
    }

    public static Player randomPlayer(NecromancerRaidParty party) {
        return party.getPlayers().get(Misc.getRandom(party.getPlayers().size() - 1));
    }

    public static void finishRaid(NecromancerRaidParty party) {

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
            //party.sendMessage("Necromancer ("+prefix+") completion time: @red@" + timeString);
            for (Player player : party.getPlayers()) {
                for (Player member : party.getPlayers()) {
                        if (member.getIsleDropRate() + 0.25D >= 100D)
                            member.setIsleDropRate( 100D);
                        else
                    if (party.getDifficulty() == RaidDifficulty.EASY) {
                        if (member.getIsleDropRate() + 0.25D >= 100D)
                            member.setIsleDropRate( 100D);
                        else
                            member.setIsleDropRate(member.getIsleDropRate() + 0.25D);

                        if (member.getIsleEasyTimer() <= 0
                                || timerElapsed < member.getIsleEasyTimer()) {
                            member.setIsleEasyTimer(timerElapsed);
                        }
                       // member.sendMessage("Personal Best ("+prefix+"): " + Misc.formatTime(member.getIsleEasyTimer()));
                    } else if (party.getDifficulty() == RaidDifficulty.INTERMEDIATE) {
                        if (member.getIsleDropRate() + 0.5D >= 100D)
                            member.setIsleDropRate( 100D);
                        else
                            member.setIsleDropRate(member.getIsleDropRate() + 0.5D);

                        if (member.getIsleMedTimer() <= 0
                                || timerElapsed < member.getIsleMedTimer()) {
                            member.setIsleMedTimer(timerElapsed);
                        }
                      //  member.sendMessage("Personal Best ("+prefix+"): " + Misc.formatTime(member.getIsleMedTimer()));
                    } else if (party.getDifficulty() == RaidDifficulty.ADVANCED) {

                        if (member.getIsleDropRate() + 1D >= 100D)
                            member.setIsleDropRate( 100D);
                        else
                            member.setIsleDropRate(member.getIsleDropRate() + 1D);

                        if (member.getIsleHardTimer() <= 0
                                || timerElapsed < member.getIsleHardTimer()) {
                            member.setIsleHardTimer(timerElapsed);
                        }
                       // member.sendMessage("Personal Best ("+prefix+"): " + Misc.formatTime(member.getIsleHardTimer()));
                    }
                    if (party.getDifficulty() == RaidDifficulty.EASY) {
                        member.setEasyIsleGodKC(member.getEasyIsleGodKC() + 1);
                        member.sendMessage("@blu@Necromancer (Easy) KC: " + member.getEasyIsleGodKC());
                    } else if (party.getDifficulty() == RaidDifficulty.INTERMEDIATE) {
                        member.setMedIsleGodKC(member.getMedIsleGodKC() + 1);
                        member.sendMessage("@blu@Necromancer (Medium) KC: " + member.getMedIsleGodKC());
                    } else if (party.getDifficulty() == RaidDifficulty.ADVANCED) {
                        member.setHardIsleGodKC(member.getHardIsleGodKC() + 1);
                        member.sendMessage("@blu@Necromancer (Hard) KC: " + member.getHardIsleGodKC());
                    }
                    member.getAchievementTracker().progress(AchievementData.NECROTIC, 1);
                    NecromancerLoot.handleLoot(member, party.getDifficulty());
                    member.getSeasonPass().addExperience(2);
                    Cases.grantCasket(player, 10);
                    if (ServerPerks.getInstance().getActivePerk() == ServerPerks.Perk.RAIDS_LOOT) {
                        NecromancerLoot.handleLoot(member, party.getDifficulty());
                    }
                    int random = Misc.inclusiveRandom(100);

                    if (player.getAmountDonated () > 20000 && random < 5) {
                        NecromancerLoot.handleLoot(member, party.getDifficulty());
                        member.sendMessage("You received a second drop as a chance from your donator rank.");
                    } else if ( member.getAmountDonated() >= 10000 && random <= 3
                            || member.getAmountDonated() >= 5000 && random <= 2
                            || member.getAmountDonated() >= 1000 && random <= 1) {
                        member.sendMessage("You received a second drop as a chance from your donator rank.");
                        NecromancerLoot.handleLoot(member, party.getDifficulty());
                    }

                    if (member.getEquipment ().contains (23550) && random == 75) {
                        member.sendMessage("You received a second drop as a chance from your Necromancer charm.");
                        NecromancerLoot.handleLoot(member, party.getDifficulty());
                    }



                    member.getDailyTaskManager().submitProgressToIdentifier(35, 1);
                    member.getAchievementTracker().progress(AchievementData.RAIDER, 1);
                    member.getPointsHandler().incrementNecromancerKC(1);
                }
                party.moveTo(ShadowData.lobbyPosition);
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

    public static void destroyInstance(NecromancerRaidParty party) {

        for (Player member : party.getPlayers()) {
            member.setEnteredShadowRaids(false);
        }
        party.moveTo(ShadowData.lobbyPosition);
        party.enteredDungeon(false);
        party.getPlayers().clear();

        for (NPC npc : party.getNpcs()) {
            if (npc != null && npc.getPosition().getZ() == party.getHeight())
                World.deregister(npc);
        }
    }

}
