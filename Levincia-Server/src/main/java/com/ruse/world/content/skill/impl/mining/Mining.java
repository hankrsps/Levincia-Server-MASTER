package com.ruse.world.content.skill.impl.mining;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.*;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.CustomObjects;
import com.ruse.world.content.FantasyZone;
import com.ruse.world.content.Sounds;
import com.ruse.world.content.Sounds.Sound;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.content.afk.AfkSystem;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.casketopening.CasketOpening;
import com.ruse.world.content.skill.impl.mining.MiningData.Ores;
import com.ruse.world.content.skill.impl.mining.MiningData.Pickaxe;
import com.ruse.world.content.skill.impl.smithing.Smelting;
import com.ruse.world.content.skill.impl.smithing.SmithingData;
import com.ruse.world.entity.impl.player.Player;

public class Mining {


    public static Box[] sapphire = new Box[]{
            new Box(5022, 2, 4, 100),  //Pvm tickets
            new Box(5022, 4, 8, 75),  //Pvm tickets
            new Box(5020, 2, 4, 100),  //Afk tickets
            new Box(5020, 4, 8, 70),  //Afk tickets
            new Box(ItemDefinition.UPGRADE_TOKEN_ID, 2, 6, 100),  //Orbs
            new Box(ItemDefinition.UPGRADE_TOKEN_ID, 6, 12, 60),  //Orbs
            new Box(6199, 1, 3, 0.4D),  //mystery box
            new Box(7956, 1,3, 0.3D),  //PvM Box
            new Box(19116, 0.05D), //Super mbox
            new Box(10946, 0.01D,true), //$1 Scroll
            new Box(15002, 0.001D,true), //Elite casket
            new Box(23204, 1, 3D),  //sapphire fragment
    };
    public static Box[] emerald = new Box[]{
            new Box(5022, 2, 8, 100),  //Pvm tickets
            new Box(5022, 8, 16, 75),  //Pvm tickets
            new Box(5020, 2, 8, 100),  //Afk tickets
            new Box(5020, 8, 16, 70),  //Afk tickets
            new Box(ItemDefinition.UPGRADE_TOKEN_ID, 2, 12, 100),  //Orbs
            new Box(ItemDefinition.UPGRADE_TOKEN_ID, 12, 24, 60),  //Orbs
            new Box(6199, 1, 7, 0.4D),  //mystery box
            new Box(7956, 1,7, 0.3D),  //PvM Box
            new Box(19114, 0.05D), //Super mbox
            new Box(10946, 0.01D,true), //$1 Scroll
            new Box(6769, 0.005D,true), //$5 BBond
            new Box(15004, 0.001D,true), //Exclusive casket
            new Box(23205, 1, 3D),  //emerald fragment
    };
    public static Box[] ruby = new Box[]{
            new Box(5022, 8, 16, 100),  //Pvm tickets
            new Box(5022, 16, 32, 75),  //Pvm tickets
            new Box(5020, 8, 16, 100),  //Afk tickets
            new Box(5020, 16, 32, 70),  //Afk tickets
            new Box(ItemDefinition.UPGRADE_TOKEN_ID, 2, 16, 100),  //Orbs
            new Box(ItemDefinition.UPGRADE_TOKEN_ID, 14, 32, 60),  //Orbs
            new Box(6199, 1, 7, 0.4D),  //mystery box
            new Box(7956, 1,7, 0.3D),  //PvM Box
            new Box(19114, 0.05D), //Super mbox
            new Box(10946, 0.01D,true), //$1 Scroll
            new Box(6769, 0.005D,true), //$5 BBond
            new Box(15004, 0.001D,true), //Exclusive casket
            new Box(23206, 1, 3D),  //ruby fragment
    };
    public static Box[] diamond = new Box[]{
            new Box(5022, 8, 20, 100),  //Pvm tickets
            new Box(5022, 24, 40, 75),  //Pvm tickets
            new Box(5020, 8, 20, 100),  //Afk tickets
            new Box(5020, 24, 40, 70),  //Afk tickets
            new Box(ItemDefinition.UPGRADE_TOKEN_ID, 8, 20, 100),  //Orbs
            new Box(ItemDefinition.UPGRADE_TOKEN_ID, 20, 40, 60),  //Orbs
            new Box(6199, 1, 9, 0.4D),  //mystery box
            new Box(7956, 1,9, 0.3D),  //PvM Box
            new Box(20488, 0.05D), //Super mbox
            new Box(6769, 0.005D,true), //$5 BBond
            new Box(10942, 0.005D,true), //$5 BBond
            new Box(14999, 0.001D,true), //Exclusive casket
            new Box(23207, 1, 3D),  //diamond fragment
    };
    public static Box[] onyx = new Box[]{
            new Box(5022, 8, 24, 100),  //Pvm tickets
            new Box(5022, 24, 44, 75),  //Pvm tickets
            new Box(5020, 8, 24, 100),  //Afk tickets
            new Box(5020, 24, 44, 70),  //Afk tickets
            new Box(ItemDefinition.UPGRADE_TOKEN_ID, 8, 24, 100),  //Orbs
            new Box(ItemDefinition.UPGRADE_TOKEN_ID, 20, 44, 60),  //Orbs
            new Box(6199, 1, 10, 0.4D),  //mystery box
            new Box(7956, 1,10, 0.3D),  //PvM Box
            new Box(20488, 0.05D), //Super mbox
            new Box(6769, 0.005D,true), //$5 BBond
            new Box(10942, 0.005D,true), //$5 BBond
            new Box(14999, 0.001D,true), //Exclusive casket
            new Box(23208, 1, 3D),  //onyx fragment
    };
    public static Box[] zenyte = new Box[]{
            new Box(5022, 8, 28, 100),  //Pvm tickets
            new Box(5022, 24, 48, 75),  //Pvm tickets
            new Box(5020, 8, 28, 100),  //Afk tickets
            new Box(5020, 24, 48, 70),  //Afk tickets
            new Box(ItemDefinition.UPGRADE_TOKEN_ID, 8, 28, 100),  //Orbs
            new Box(ItemDefinition.UPGRADE_TOKEN_ID, 20, 48, 60),  //Orbs
            new Box(6199, 1, 10, 0.4D),  //mystery box
            new Box(7956, 1,10, 0.3D),  //PvM Box
            new Box(20488, 0.05D), //Super mbox
            new Box(6769, 0.005D,true), //$5 BBond
            new Box(10942, 0.005D,true), //$5 BBond
            new Box(23253, 0.001D,true), //Exclusive casket
            new Box(23209, 1, 3D),  //onyx fragment
    };

    public static Box[] tanzanite = new Box[]{
            new Box(5022, 8, 30, 100),  //Pvm tickets
            new Box(5022, 24, 50, 75),  //Pvm tickets
            new Box(5020, 8, 30, 100),  //Afk tickets
            new Box(5020, 24, 50, 70),  //Afk tickets
            new Box(ItemDefinition.UPGRADE_TOKEN_ID, 8, 30, 100),  //Orbs
            new Box(ItemDefinition.UPGRADE_TOKEN_ID, 20, 50, 60),  //Orbs
            new Box(6199, 1, 10, 0.4D),  //mystery box
            new Box(7956, 1,10, 0.3D),  //PvM Box
            new Box(20488, 0.05D), //Super mbox
            new Box(6769, 0.005D,true), //$5 BBond
            new Box(10942, 0.005D,true), //$5 BBond
            new Box(23253, 0.001D,true), //Exclusive casket
            new Box(10482, 1, 3D),  //onyx fragment
    };

    public static Box[] platinum = new Box[]{
            new Box(5022, 8, 30, 100),  //Pvm tickets
            new Box(5022, 24, 50, 75),  //Pvm tickets
            new Box(5020, 8, 30, 100),  //Afk tickets
            new Box(5020, 24, 50, 70),  //Afk tickets
            new Box(ItemDefinition.UPGRADE_TOKEN_ID, 8, 30, 100),  //Orbs
            new Box(ItemDefinition.UPGRADE_TOKEN_ID, 20, 50, 60),  //Orbs
            new Box(6199, 1, 10, 0.4D),  //mystery box
            new Box(7956, 1,10, 0.3D),  //PvM Box
            new Box(20488, 0.05D), //Super mbox
            new Box(6769, 0.005D,true), //$5 BBond
            new Box(10942, 0.005D,true), //$5 BBond
            new Box(23253, 0.001D,true), //Exclusive casket
            new Box(10481, 1, 3D),  //onyx fragment
    };

    public static final Box[] whisperLoot = {
            new Box(19840, 1, 15000), // Coins
            new Box(7700, 1, 1), // Tea of Insight
            new Box(8977, 1, 2), // Rare bark shavings
    };

    public static final Box[] deeperWhispers = {
            new Box(19840, 5, 15000), // Coins
            new Box(7700, 2, 2), // Tea of Insight
            new Box(8977, 2, 3), // Rare bark shavings
    };

    public static final Box[] hauntedWhispers = {
            new Box(19840, 10, 15000), // Coins
            new Box(7700, 3, 4), // Tea of Insight
            new Box(8977, 3, 5), // Rare bark shavings
    };


    public static void listenAfkTree(Player player, int objectId, int tier) {
        player.getSkillManager().stopSkilling();
        player.getPacketSender().sendInterfaceRemoval();

        if (!player.getClickDelay().elapsed(2000)) return;
        if (player.getInventory().getFreeSlots() <= 0) {
            player.getPacketSender().sendMessage("You need more inventory space to listen to the whispers.");
            return;
        }
        if (player.busy() || player.getCombatBuilder().isBeingAttacked() || player.getCombatBuilder().isAttacking()) {
            player.getPacketSender().sendMessage("You can't do this right now.");
            return;
        }

        int accounts = 1;
        for (Player p : World.getPlayers()) {
            if (p == null) continue;
            if (!player.equals(p) && player.getHostAddress().equals(p.getHostAddress())) {
                if (p.getInteractingObject() != null && (p.getInteractingObject().getId() == 11394)) { // tree ID here
                    accounts++;
                }
            }
        }
        if (accounts > 2) {
            player.getPacketSender().sendMessage("You already have two accounts listening to the tree.");
            return;
        }

        player.setCurrentTask(new Task(4, player, true) {
            @Override
            public void execute() {
                if (player.getInventory().getFreeSlots() <= 0) {
                    player.getPacketSender().sendMessage("You have no free inventory space left.");
                    this.stop();
                    return;
                }

                player.performAnimation(new Animation(800)); // Sitting, meditating animation
                player.performGraphic(new Graphic(188));
                Box[] whispers = whisperLoot;

                switch (tier) {
                    case 2: whispers = deeperWhispers; break;
                    case 3: whispers = hauntedWhispers; break;
                }

                player.setAfkWhispers(player.getAfkWhispers() + 1);
                Box reward = CasketOpening.getLoot(whispers);
                player.getInventory().add(reward.getId(), reward.getMin() + Misc.getRandom(reward.getMax() - reward.getMin()));
                player.getPacketSender().sendMessage("You hear a faint whisper in the wind...");
                player.getInventory().refreshItems();
                player.getClickDelay().reset();
            }

            @Override
            public void stop() {
                setEventRunning(false);
            }
        });
        TaskManager.submit(player.getCurrentTask());
    }


    public static void mineAfkRock(Player player, int objectId, int tier) {
        player.getSkillManager().stopSkilling();
        player.getPacketSender().sendInterfaceRemoval();
        if (!player.getClickDelay().elapsed(2000))
            return;
        if (player.getInventory().getFreeSlots() <= 0) {
            player.getPacketSender().sendMessage("You need some more inventory space to do this.");
            return;
        }
        if (player.busy() || player.getCombatBuilder().isBeingAttacked() || player.getCombatBuilder().isAttacking()) {
            player.getPacketSender().sendMessage("You cannot do that right now.");
            return;
        }


        int accounts = 1;
        for (Player p : World.getPlayers()) {
            if (p == null)
                continue;
            if (!player.equals(p) && player.getHostAddress().equals(p.getHostAddress())) {
                if (p.getInteractingObject() != null && (p.getInteractingObject().getId() == 52601
                        || p.getInteractingObject().getId() == 53654 || p.getInteractingObject().getId() == 30035)) {
                    accounts++;
                    continue;
                }
            }
        }
        if (accounts > 2){
            player.getPacketSender().sendMessage("You already have two accounts mining afk.");
            return;
        }

        player.setCurrentTask(new Task(4, player, true) {

            @Override
            public void execute() {
                if (player.getInventory().getFreeSlots() <= 0) {
                    player.getPacketSender().sendMessage("You do not have any free inventory space left.");
                    this.stop();
                    return;
                }

                final int pickaxe = MiningData.getPickaxe(player);
                if (pickaxe > 0) {
                    final Pickaxe p = MiningData.forPick(pickaxe);
                    if (MiningData.isHoldingPickaxe(player)) {
                        player.performAnimation(new Animation(12003));
                        Box[] loot = sapphire;
                        if (tier == 1) {
                            player.setAfkSapphire(player.getAfkSapphire() + 1);
                        } else if (tier == 2) {
                            loot = emerald;
                            player.setAfkEmerald(player.getAfkEmerald() + 1);
                        } else if (tier == 3) {
                            loot = ruby;
                            player.setAfkbRuby(player.getAfkbRuby() + 1);
                        } else if (tier == 4) {
                            loot = diamond;
                            player.setAfkDiamond(player.getAfkDiamond() + 1);
                        } else if (tier == 5) {
                            loot = onyx;
                            player.setAfkOnyx(player.getAfkOnyx() + 1);
                        } else if (tier == 6) {
                            loot = zenyte;
                            player.setAfkZenyte(player.getAfkZenyte() + 1);
                        } else if (tier == 7) {
                            loot = tanzanite;
                            player.setAfkTanzanite(player.getAfkTanzanite() + 1);
                        } else if (tier == 8) {
                            loot = platinum;
                            player.setAfkPlatinum(player.getAfkPlatinum() + 1);
                        }

                        Box reward = CasketOpening.getLoot(loot);
                        player.getInventory().add(reward.getId(), reward.getMin() + Misc.getRandom(reward.getMax() - reward.getMin()));
                        AfkSystem.burnedSouls++;
                        player.getInventory().refreshItems();
                        player.getClickDelay().reset();
                        return;
                    }
                } else
                    this.stop();
                player.getPacketSender().sendMessage("You don't have a pickaxe to mine this rock with.");
            }

            @Override
            public void stop() {
                setEventRunning(false);
                player.performAnimation(new Animation(65535));
            }
        });
        TaskManager.submit(player.getCurrentTask());
    }

    public static void tendAfkBeehive(Player player) {
        player.getSkillManager().stopSkilling();
        player.getPacketSender().sendInterfaceRemoval();

        if (!player.getClickDelay().elapsed(2000))
            return;

        if (player.getInventory().getFreeSlots() <= 0) {
            player.getPacketSender().sendMessage("You need more inventory space to collect enchanted wax.");
            return;
        }

        if (player.busy() || player.getCombatBuilder().isBeingAttacked() || player.getCombatBuilder().isAttacking()) {
            player.getPacketSender().sendMessage("You can't do this right now.");
            return;
        }

        int accounts = 1;
        for (Player p : World.getPlayers()) {
            if (p == null) continue;
            if (!player.equals(p) && player.getHostAddress().equals(p.getHostAddress())) {
                if (p.getInteractingObject() != null && p.getInteractingObject().getId() == 26121) { // beehive ID
                    accounts++;
                }
            }
        }

        if (accounts > 2) {
            player.getPacketSender().sendMessage("You already have two accounts tending this magical beehive.");
            return;
        }

        player.setCurrentTask(new Task(4, player, true) {
            @Override
            public void execute() {
                if (player.getInventory().getFreeSlots() <= 0) {
                    player.getPacketSender().sendMessage("You have no free inventory space left.");
                    this.stop();
                    return;
                }
                player.getInteractingObject().performGraphic(new Graphic(184));
                player.performAnimation(new Animation(7660)); // Sitting or calm beekeeping animation
                player.getInventory().add(30, 1); // enchanted wax ID
                player.getPacketSender().sendMessage("You carefully collect some enchanted wax from the buzzing hive...");
                player.getInventory().refreshItems();
                player.getClickDelay().reset();
            }

            @Override
            public void stop() {
                setEventRunning(false);
                player.performAnimation(new Animation(65535)); // reset animation
            }
        });

        TaskManager.submit(player.getCurrentTask());
    }



    public static void startMining(final Player player, final GameObject oreObject) {
        player.getSkillManager().stopSkilling();
        player.getPacketSender().sendInterfaceRemoval();
        if (!Locations.goodDistance(player.getPosition().copy(), oreObject.getPosition(), 1)
                && oreObject.getId() != 24444 && oreObject.getId() != 24445 && oreObject.getId() != 38660)
            return;
        if (player.busy() || player.getCombatBuilder().isBeingAttacked() || player.getCombatBuilder().isAttacking()) {
            player.getPacketSender().sendMessage("You cannot do that right now.");
            return;
        }
        if (player.getInventory().getFreeSlots() == 0) {
            player.getPacketSender().sendMessage("You do not have any free inventory space left.");
            return;
        }
        player.setInteractingObject(oreObject);
        player.setPositionToFace(oreObject.getPosition());
        final Ores o = MiningData.forRock(oreObject.getId());
        final boolean giveGem = o != Ores.Rune_essence && o != Ores.Pure_essence;
        final int reqCycle = o == Ores.Runite ? 6 + Misc.getRandom(2) : Misc.getRandom(o.getTicks() - 1);
        if (o != null) {
            if (o == Ores.FANTASY) {
                if (!FantasyZone.gameActive) {
                    player.getPacketSender().sendMessage("The Fantasy Realm is not open.");
                    return;
                }
            }
            final int pickaxe = MiningData.getPickaxe(player);
            final int miningLevel = player.getSkillManager().getCurrentLevel(Skill.MINING);
            if (pickaxe > 0) {
                if (miningLevel >= o.getLevelReq()) {
                    final Pickaxe p = MiningData.forPick(pickaxe);
                    if (miningLevel >= p.getReq()) {
                        if (MiningData.isHoldingPickaxe(player)) {
                            player.performAnimation(new Animation(12003));
                        } else {
                            player.performAnimation(new Animation(12003));
                        }
                        final int delay = o.getTicks() - MiningData.getReducedTimer(player, p);
                        player.setCurrentTask(new Task(delay >= 2 ? delay : 1, player, false) {
                            int cycle = 0;

                            @Override
                            public void execute() {
                                if (player.getInteractingObject() == null
                                        || player.getInteractingObject().getId() != oreObject.getId()) {
                                    player.getSkillManager().stopSkilling();
                                    player.performAnimation(new Animation(65535));
                                    stop();
                                    return;
                                }
                                if (player.getInventory().getFreeSlots() == 0) {
                                    player.performAnimation(new Animation(65535));
                                    stop();
                                    player.getPacketSender()
                                            .sendMessage("You do not have any free inventory space left.");
                                    return;
                                }
                                if (cycle != reqCycle) {
                                    cycle++;
                                    if (MiningData.isHoldingPickaxe(player)) {
                                        player.performAnimation(new Animation(12003));
                                    } else {
                                        player.performAnimation(new Animation(12003));
                                        //player.performAnimation(new Animation(p.getAnim()));
                                    }
                                }
								/*if (giveGem) {
									boolean onyx = (o == Ores.Runite || o == Ores.CRASHED_STAR)
											&& Misc.getRandom(o == Ores.CRASHED_STAR ? 20000 : 5000) == 1;
									if (onyx || Misc.getRandom(o == Ores.CRASHED_STAR ? 35 : 50) == 15) {
										int gemId = onyx ? 6571
												: MiningData.RANDOM_GEMS[(int) (MiningData.RANDOM_GEMS.length
														* Math.random())];
										if (player.getSkillManager().skillCape(Skill.MINING)
												&& player.getGameMode() != GameMode.ULTIMATE_IRONMAN) {
											if (player.getBank(0).isFull()) {
												player.getPacketSender().sendMessage(
														"Your cape failed at trying to bank your gem, because your bank was full.");
												player.getInventory().add(gemId, 1);
											} else {
												player.getPacketSender()
														.sendMessage("Your cape banked a gem while you were mining!");
												player.getBank(0).add(gemId, 1);
											}
										} else {
											if (player.getGameMode() == GameMode.ULTIMATE_IRONMAN) {
												player.getInventory().add(gemId + 1, 1);
												// player.getPacketSender().sendMessage("As a UIM, your cape won't bank
												// gems, but here's a noted one.");
											} else {
												player.getInventory().add(gemId, 1);
												// player.getPacketSender().sendMessage("You've found a gem!");
											}
										}
										if (gemId == 6571) {
											String s = o == Ores.Runite ? "Runite ore" : "Crashed star";
											World.sendMessage("<img=5><col=009966><shad=0> " + player.getUsername()
													+ " has just received an Uncut Onyx from mining a " + s + "!");
										}
									}
								}*/
                                if (cycle == reqCycle) {

                                    if (o == Ores.AFKMINE) {
                                        player.getInventory().add(995, 50 + Misc.getRandom(50));
                                    } else if (o.getItemId() != -1 && o != Ores.AFKMINE) {
                                        if (o == Ores.Coal && player.getSkillManager().skillCape(Skill.MINING)
                                                && Misc.getRandom(3) == 1) {
                                            player.getInventory().add(o.getItemId(), 2);
                                            player.getPacketSender()
                                                    .sendMessage("Your cape allows you to mine an additional coal.");
                                        } else {
                                            player.getInventory().add(o.getItemId(), 1);
                                        }
                                    }


                                    player.getSkillManager().addExperience(Skill.MINING, (int) (o.getXpAmount()));
                                    if (o == Ores.CRASHED_STAR) {
                                        player.getPacketSender().sendMessage("You mine the crashed star..");
                                    } else {
                                        player.getAchievementTracker().progress(AchievementData.MINING, 1);
                                        player.getPacketSender().sendMessage("You mine some ore.");
                                    }

                                    /** ADZE EFFECT **/
                                    if (pickaxe == Pickaxe.Adze.getId()) {
                                        if (Misc.getRandom(100) >= 75) {
                                            switch (o) {
                                                case Adamantite:
                                                    handleAdze(player, oreObject, 2361);
                                                    break;
                                                case Gold:
                                                    handleAdze(player, oreObject, 2357);
                                                    break;
                                                case Iron:
                                                    handleAdze(player, oreObject, 2351);
                                                    break;
                                                case Mithril:
                                                    handleAdze(player, oreObject, 2359);
                                                    break;
                                                case Runite:
                                                    handleAdze(player, oreObject, 2363);
                                                    break;
                                                case Silver:
                                                    handleAdze(player, oreObject, 2355);
                                                    break;
                                                case Tin:
                                                case Copper:
                                                    handleAdze(player, oreObject, 2349);
                                                    break;
                                            }
                                        }
                                    }

                                    Sounds.sendSound(player, Sound.MINE_ITEM);

                                    cycle = 0;
                                    this.stop();
                                    if (o.getRespawn() > 0) {
                                        player.performAnimation(new Animation(65535));
                                        oreRespawn(player, oreObject, o);
                                    }
                                }
                            }
                        });
                        TaskManager.submit(player.getCurrentTask());
                    } else {
                        player.getPacketSender().sendMessage(
                                "You need a Mining level of at least " + p.getReq() + " to use this pickaxe.");
                    }
                } else {
                    player.getPacketSender().sendMessage(
                            "You need a Mining level of at least " + o.getLevelReq() + " to mine this rock.");
                }
            } else {
                player.getPacketSender().sendMessage("You don't have a pickaxe to mine this rock with.");
            }
        }
    }

    public static void handleAdze(final Player player, final GameObject oreObject, final int barId) {
        if (SmithingData.hasOres(player, barId)) {
            Smelting.handleBarCreation(barId, player);
            player.getPacketSender()
                    .sendMessage("The heat from your Inferno adze immediately ignites the ore and smelts it.");
            player.setInteractingObject(oreObject);
            player.setPositionToFace(oreObject.getPosition());
            oreObject.performGraphic(new Graphic(453));
            player.setInteractingObject(oreObject);
            player.setPositionToFace(oreObject.getPosition());
        }
    }

    public static void oreRespawn(final Player player, final GameObject oldOre, Ores o) {
        if (oldOre == null || oldOre.getPickAmount() >= 1)
            return;
        oldOre.setPickAmount(1);
        for (Player players : player.getLocalPlayers()) {
            if (players == null)
                continue;
            if (players.getInteractingObject() != null && players.getInteractingObject().getPosition()
                    .equals(player.getInteractingObject().getPosition().copy())) {
                players.getPacketSender().sendClientRightClickRemoval();
                players.getSkillManager().stopSkilling();
            }
        }
        player.getPacketSender().sendClientRightClickRemoval();
        player.getSkillManager().stopSkilling();
        CustomObjects.globalObjectRespawnTask(new GameObject(452, oldOre.getPosition().copy(), 10, 0), oldOre,
                o.getRespawn());
    }
}
