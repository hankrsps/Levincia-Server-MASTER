package com.ruse.net.packet.impl;

import com.ruse.GameSettings;
import com.ruse.engine.task.TaskManager;
import com.ruse.engine.task.impl.DoubleDDRTask;
import com.ruse.engine.task.impl.DoubleDMGTask;
import com.ruse.engine.task.impl.WalkToTask;
import com.ruse.engine.task.impl.WalkToTask.FinalizedMovementTask;
import com.ruse.model.*;
import com.ruse.model.Locations.Location;
import com.ruse.model.container.impl.Shop.ShopManager;
import com.ruse.model.definitions.NPCDrops;
import com.ruse.model.definitions.NpcDefinition;
import com.ruse.net.packet.Packet;
import com.ruse.net.packet.PacketListener;
import com.ruse.world.World;
import com.ruse.world.content.*;
import com.ruse.world.content.celestial.CelestialDialogues;
import com.ruse.world.content.combat.CombatFactory;
import com.ruse.world.content.combat.magic.CombatSpell;
import com.ruse.world.content.combat.magic.CombatSpells;
import com.ruse.world.content.combat.weapon.CombatSpecial;
import com.ruse.world.content.dailytasks_new.DailyTasks;
import com.ruse.world.content.dialogue.DialogueManager;
//import com.ruse.world.content.discordbot.DiscordIntegration;
import com.ruse.world.content.grandexchange.GrandExchange;
import com.ruse.world.content.groupironman.GroupConfig;
import com.ruse.world.content.groupironman.GroupManager;
import com.ruse.world.content.holidayevents.christmas2016;
import com.ruse.world.content.minigames.impl.VaultOfWar;
import com.ruse.world.content.minigames.impl.WarriorsGuild;
import com.ruse.world.content.minigames.impl.trioMinigame;
import com.ruse.world.content.pos.PlayerOwnedShopManager;
import com.ruse.world.content.quests.BloodRunsDeepDialogues;
import com.ruse.world.content.quests.TheOmegaDialogues;
import com.ruse.world.content.randomevents.Genie;
import com.ruse.world.content.serverperks.ServerPerks;
import com.ruse.world.content.skill.impl.construction.ConstructionActions;
import com.ruse.world.content.skill.impl.crafting.Tanning;
import com.ruse.world.content.skill.impl.fishing.Fishing;
import com.ruse.world.content.skill.impl.herblore.Decanting;
import com.ruse.world.content.skill.impl.hunter.PuroPuro;
import com.ruse.world.content.skill.impl.old_dungeoneering.Dungeoneering;
import com.ruse.world.content.skill.impl.old_dungeoneering.UltimateIronmanHandler;
import com.ruse.world.content.skill.impl.runecrafting.DesoSpan;
import com.ruse.world.content.skill.impl.slayer.BossSlayerDialogues;
import com.ruse.world.content.skill.impl.slayer.SlayerDialogues;
import com.ruse.world.content.skill.impl.slayer.SlayerTasks;
import com.ruse.world.content.skill.impl.slayer.TaskType;
import com.ruse.world.content.skill.impl.summoning.BossPets;
import com.ruse.world.content.skill.impl.summoning.Summoning;
import com.ruse.world.content.skill.impl.summoning.SummoningData;
import com.ruse.world.content.skill.impl.thieving.Pickpocket;
import com.ruse.world.content.skill.impl.thieving.PickpocketData;
import com.ruse.world.content.transportation.TeleportHandler;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import static com.ruse.world.content.combat.CombatType.RANGED;

public class NPCOptionPacketListener implements PacketListener {

    private static void firstClick(Player player, Packet packet) {
        int index = packet.readLEShort();
        if (index < 0 || index > World.getNpcs().capacity())
            return;
        final NPC npc = World.getNpcs().get(index);
        if (npc == null)
            return;
        player.setEntityInteraction(npc);
        if (player.getRights() == PlayerRights.OWNER)
            player.getPacketSender().sendMessage("First click npc id: " + npc.getId());
        if (BossPets.pickup(player, npc)) {
            player.getMovementQueue().reset();
            return;
        }
        player.setWalkToTask(new WalkToTask(player, npc.getPosition(), npc.getSize(), new FinalizedMovementTask() {
            @Override
            public void execute() {
                if (!player.getControllerManager().processNPCClick1(npc)) {
                    return;
                }

                if (SummoningData.beastOfBurden(npc.getId())) {
                    Summoning summoning = player.getSummoning();
                    if (summoning.getBeastOfBurden() != null && summoning.getFamiliar() != null
                            && summoning.getFamiliar().getSummonNpc() != null
                            && summoning.getFamiliar().getSummonNpc().getIndex() == npc.getIndex()) {
                        summoning.store();
                        player.getMovementQueue().reset();
                    } else {
                        player.getPacketSender().sendMessage("That familiar is not yours!");
                    }
                    return;
                }
                if (ConstructionActions.handleFirstClickNpc(player, npc)) {
                    return;
                }

                switch (npc.getId()) {
                    case Genie.genieID:
                        Genie.handleInteraction(npc, player, 1);
                        break;
                    case 3373:
                        DialogueManager.start(player, 8005);
                        player.setDialogueActionId(8005);
                        break;
                    case 568:
                        DialogueManager.start(player, 1311);
                        player.setDialogueActionId(568);
                        break;
                    case 9000:
                        if (!player.getSlayer().getTaskType().equals(TaskType.BOSS_SLAYER)
                                && player.getSlayer().getSlayerTask().equals(SlayerTasks.NO_TASK)) {
                            TaskType.changeSlayerMaster(player, TaskType.BOSS_SLAYER);
                        }
                        if (!player.getSlayer().getTaskType().equals(TaskType.BOSS_SLAYER))
                            DialogueManager.sendStatement(player, "You do not have a boss slayer task.");
                        else
                            DialogueManager.start(player, BossSlayerDialogues.dialogue(player));

                        break;
                    case 925:
                       /* if (player.getSlayer().getTaskType().equals(TaskType.BOSS_SLAYER)
                                && !player.getSlayer().getSlayerTask().equals(SlayerTasks.NO_TASK)) {
                            DialogueManager.sendStatement(player, "You currently have an assignment with another master.");
                        }else{*/
                        DialogueManager.start(player, SlayerDialogues.dialogue(player));
                        // }

                        break;
/*
                    case 432:
                        player.getPacketSender().sendInterfaceReset();
                        player.questInterface.openQuestOne();
                        break;
*/
                    case 1007:
                        player.setSupremeTbed(false);
                        player.performGraphic(new Graphic(189));
                        npc.performAnimation(new Animation(811));
                        npc.performGraphic(new Graphic(433));
                        npc.forceChat("By the Sons of Supreme!");
                        player.moveTo(GameSettings.DEFAULT_POSITION);
                        player.getPacketSender().sendMessage("The wizard has broke the teleblock and sends you home!");
                        break;
                    case 927:
                        player.setEntityInteraction(npc);
                        Fishing.setupFishing(player, Fishing.forSpot(npc.getId(), true));
                        break;
                    case 1208://GLOVES_NPC
                        break;

                    case 10006:
                        player.getPA().sendInterface(19130);
//                        DiscordIntegration.updateDiscordInterface(player);
                        break;
                    case 9222:
                        TravellingMerchant.openShop(player);
                        break;
                    case 649: //ARCHER GUILD
                        if (player.getArcherMaster() == true) {
                            DialogueManager.sendStatement(player, "You Already have mastered this minigame!");
                            return;
                        }
                        if (player.getArcherGuildTier3() == true && player.getArcherGuildTier2() == true && player.getArcherGuildTier1() == true) {
                            player.getPacketSender().sendInterfaceReset();
                            player.archerGuildT3.openT3();
                            return;
                        }
                        if (player.getArcherGuildTier2() == true && player.getArcherGuildTier1()) {
                            player.getPacketSender().sendInterfaceReset();
                            player.archerGuildT2.openT2();
                            return;
                        }
                        if (player.getArcherGuildTier1()) {
                            player.getPacketSender().sendInterfaceReset();
                            player.archerGuildT1.openT1();
                            return;
                        }
                        break;
                    case 460: //MAGIC GUILD
                        npc.forceChat("Vis porta. Claudo te. Vis sera portus.sigillum");
                        if (player.getMagicianMaster() == true) {
                            DialogueManager.sendStatement(player, "You Already have mastered this minigame!");
                            return;
                        }
                        if (player.getMagicGuildTier3() == true && player.getMagicGuildTier2() == true && player.getMagicGuildTier1() == true) {
                            player.getPacketSender().sendInterfaceReset();
                            player.magicGuildT3.openT3();
                            return;
                        }
                        if (player.getMagicGuildTier2() == true && player.getMagicGuildTier1()) {
                            player.getPacketSender().sendInterfaceReset();
                            player.magicGuildT2.openT2();
                            return;
                        }
                        if (player.getMagicGuildTier1()) {
                            player.getPacketSender().sendInterfaceReset();
                            player.magicGuildT1.openT1();
                            return;
                        }
                        break;
                    case 198: //WARRIOR GUILD
                        if (player.getWarriorMaster() == true) {
                            DialogueManager.sendStatement(player, "You already have mastered this minigame!");
                            return;
                        }
                        if (player.getWarriorGuildTier3() == true && player.getWarriorGuildTier2() == true && player.getWarriorGuildTier1() == true) {
                            player.getPacketSender().sendInterfaceReset();
                            player.warriorGuildT3.openT3();
                            return;
                        }
                        if (player.getWarriorGuildTier2() == true && player.getWarriorGuildTier1()) {
                            player.getPacketSender().sendInterfaceReset();
                            player.warriorGuildT2.openT2();
                            return;
                        }
                        if (player.getWarriorGuildTier1()) {
                            player.getPacketSender().sendInterfaceReset();
                            player.warriorGuildT1.openT1();
                            return;
                        }
                        break;
                    case 289: //DAILY TASK
                        if (player.dailies.isEmpty()) {
                            DialogueManager.start(player, 9901);
                            player.setDialogueActionId(9905);
                        } else {
                            DailyTasks.sendProgress(player);
                            player.getPacketSender().sendMessage(player.taskInfo);
                        }
                        break;
                    case 9022:
                        ServerPerks.getInstance().open(player);
                        break;
                    case 241:
                        ShopManager.getShops().get(123).open(player);
                        player.getPacketSender().sendString(3903,
                                "Spend your Global tickets on items");
                        break;

                    case 8504:
                    case 8505:
                    case 8506:
                    case 8508:
                    case 8510:
                        //TurkeySpawns.findTurkey(npc, player);
                        break;
                    case 3643:
                       /* ShopManager.getShops().get(550).open(player);
                        player.getPacketSender().sendString(3903,
                                "Happy Thanksgiving!");*/
                        break;
                    case GroupConfig.NPC_ID:
                        if (player.getGameMode() == GameMode.GROUP_IRONMAN) {
                            if (GroupManager.isInGroup(player)) {
                                GroupManager.openInterface(player);
                            } else {
                                DialogueManager.start(player, 8001);
                                player.setDialogueActionId(8001);
                            }
                        } else {
                            player.sendMessage("You must be a group ironman to do this.");
                        }
                        break;
                    case PlayerOwnedShopManager.NPC_ID:
                        player.getPlayerOwnedShopManager().options();
                        break;
                    case 4652:
                        ShopManager.getShops().get(106).open(player);
                        break;
                    case 4601:
                        player.setDialogueActionId(8);
                        DialogueManager.start(player, 13);
                        break;
                    case 5382:
                        if (player.getGameMode().equals(GameMode.ULTIMATE_IRONMAN)) {
                            DialogueManager.start(player, 192);
                        } else {
                            DialogueManager.start(player, 195);
                        }
                        break;

                    case 4650:
                        LotteryEvent.initialdialogue(player);
                        break;

                    case 2938:
                        player.getDailyRewards().processTime();
                        player.getDailyRewards().displayRewards();
                        npc.forceChat("Talk to me to get your Daily Rewards!");
                        break;
                    case 613:
                        if (player.getDoubleDDRTimer() > 0) {
                            npc.forceChat("Already looking to cheat me out my own game aye? not so fast!");
                            return;
                        }
                        if (player.getInventory().contains(4277)) {
                            player.getInventory().delete(4277, 1);
                            player.setDoubleDMGTimer(24000);
                            player.setDoubleDDRTimer(24000);
                            TaskManager.submit(new DoubleDDRTask(player));
                            TaskManager.submit(new DoubleDMGTask(player));
                            player.sendMessage("You trade the map for X2 Dmg and X2 Drops for 4 Hours.");
                            DialogueManager.sendStatement(player, "Magnificent work, traveller!");

                        } else {
                            npc.forceChat("You're Awake! Grab a spade and dig for the treasure!");
                        }
                        break;



                    case 4285:
                        /*
                        if (!player.getGameMode().isIronman()) {
                            player.getPacketSender().sendMessage("Only ironman can sell items to this shop.");
                            return;
                        }*/
                        ShopManager.getShops().get(119).open(player);
                        player.getPacketSender().sendString(3903,
                                "Items can be sold to this store");
                        break;

                    case 1050:
                        player.moveTo(new Position(2793, 3276));
                        npc.forceChat("Deep sea fishing!");
                        break;

                    case 3089:
                        ShopManager.getShops().get(104).open(player);
                        player.getPacketSender().sendString(3903,
                                "");
                        npc.forceChat("PvM ticket shop!");
                        break;
                    case 5838:
                        ShopManager.getShops().get(137).open(player);
                        player.getPacketSender().sendString(3903,
                                "Sell items for 50% of their original value");
                        break;
                    case 659:
                        if (GameSettings.newYear2017) {
                            if (player.getNewYear2017() == 0) {
                                DialogueManager.start(player, 189);
                                player.setDialogueActionId(189);
                            } else {
                                DialogueManager.start(player, 190);
                            }
                        } else {
                            npc.forceChat("I love a good party!");
                            ShopManager.getShops().get(81).open(player);
                        }
                        break;
                    case 13651:
                        ShopManager.getShops().get(150).open(player);
                        break;
                    case 1835:
                        ShopManager.getShops().get(151).open(player);
                        break;
                    case 304:
                        if (player.getLocation() == Location.SAPPHIRE_ZONE) {
                            ShopManager.getShops().get(131).open(player);
                        } else if (player.getLocation() == Location.EMERALD_ZONE) {
                            ShopManager.getShops().get(132).open(player);
                        } else if (player.getLocation() == Location.RUBY_ZONE) {
                            ShopManager.getShops().get(133).open(player);
                        } else if (player.getLocation() == Location.DIAMOND_ZONE) {
                            ShopManager.getShops().get(134).open(player);
                        } else if (player.getLocation() == Location.ONYX_ZONE) {
                            ShopManager.getShops().get(135).open(player);
                        } else if (player.getLocation() == Location.ZENYTE_ZONE) {
                            ShopManager.getShops().get(136).open(player);
                        } else
                        npc.forceChat("Silly noob, you are not at a donator zone");
                        break;
                    case 4653:
                        player.getPacketSender().sendString(3903,
                                "AFK Tickets in Inventory: " + player.getInventory().getAmount(5020) + "");
                        ShopManager.getShops().get(103).open(player);
                        npc.forceChat("Get back to the grind!");
                        break;
                    case 1872:
                        if (player.getLocation() == Location.ZULRAH_WAITING) {
                            DialogueManager.start(player, 200);
                        }
                        break;
                    case 1552:
                        if (christmas2016.isChristmas()) {
                            if (player.getChristmas2016() == 0) {
                                DialogueManager.start(player, 169);
                                player.setDialogueActionId(171);
                            } else if (player.getChristmas2016() == 1) {
                                player.getPacketSender().sendMessage("Santa wants me to talk to Explorer Jack at home.");
                            } else if (player.getChristmas2016() == 2) {
                                DialogueManager.start(player, 181);
                            } else if (player.getChristmas2016() > 2 && player.getChristmas2016() < 5) {
                                DialogueManager.start(player, 182);
                                player.getPacketSender().sendMessage("The Reindeer need Law, Cosmic, and Nature runes.");
                            } else if (player.getChristmas2016() == 5) {
                                DialogueManager.start(player, 183);
                                player.getPacketSender().sendMessage("I should \"use\" the Mind Bomb on Santa.");
                            } else if (player.getChristmas2016() == 6) {
                                DialogueManager.start(player, 184);
                                player.setDialogueActionId(187);
                            } else if (player.getChristmas2016() == 7) {
                                DialogueManager.start(player, 188);
                            } else {
                                npc.forceChat("Ho ho ho!");
                            }
                        } else {
                            npc.forceChat("Ho ho ho!");
                        }
                        break;
                    case 1084:
                        ShopManager.getShops().get(111).open(player);
                        break;
                    case 1085:
                        ShopManager.getShops().get(112).open(player);
                        break;
                    case 1086:
                        ShopManager.getShops().get(113).open(player);
                        break;
                    case 1821:
                        DialogueManager.start(player, CelestialDialogues.main(player));
                        break;

                    case 648:
                        if (player.getQuestOneStep5() == false && !player.getInventory().contains(17801, 5)) {
                            DialogueManager.start(player, BloodRunsDeepDialogues.questBloodRunsDeepKingRoald(player));
                            return;
                        } else if (player.getInventory().contains(17801, 5) && player.getQuestOneStep5() == false) {
                            DialogueManager.start(player, BloodRunsDeepDialogues.questBloodRunsDeepKingRoaldComplete(player));
                            return;
                        } else if (player.getQuestOneStep5() == true) {
                            DialogueManager.start(player, BloodRunsDeepDialogues.questBloodRunsDeepKingRoaldExit(player));
                            return;
                        }
                        break;
                    case 9127:

                        if (player.getQuestTwoStep7() == true ) {
                            DialogueManager.start(player, TheOmegaDialogues.GoodDay(player));
                            return;
                        } else
                        if (player.getQuestTwoStep6() == true) {
                            DialogueManager.start(player, TheOmegaDialogues.QuestComplete(player));
                            return;
                        }

                        if (player.getQuestTwoStep4() == true && player.getQuestTwoStep5() == false ) {
                            DialogueManager.start(player, TheOmegaDialogues.DukeHoracio(player));
                            return;
                        }
                        if (player.getQuestTwoStep5() == true ) {
                            DialogueManager.start(player, TheOmegaDialogues.DukeHoracioFinal(player));
                            return;
                        }

                        break;
                    case 1921:
                        if (player.getQuestTwoStarted() == true) {
                            DialogueManager.start(player, TheOmegaDialogues.PubIntro(player));
                            return;
                        } else
                            player.getPA ().sendMessage ("You need to start the Omega quest first");
                        break;
                    case 6040:

                        if (player.getQuestOneStep7() == true) {
                            DialogueManager.start(player, BloodRunsDeepDialogues.questBloodRunsDeepAfterCompletion(player));
                            return;
                        }
                        if (player.getQuestOneStep7() == false && player.getInventory().contains(17510) && player.getQuestOneStep6() == true) {
                            DialogueManager.start(player, BloodRunsDeepDialogues.questBloodRunsDeepFinalReturn(player));
                            return;
                        }
                        if (player.getQuestOneStep6() == true) {
                            DialogueManager.start(player, BloodRunsDeepDialogues.questBloodRunsDeepVisitDagonnoth(player));
                            return;
                        }
                        if (player.getQuestOneStep5() == true && player.getInventory().contains(15406) && player.getInventory().contains(8534)) {
                            DialogueManager.start(player, BloodRunsDeepDialogues.questBloodRunsDeepReturnItems(player));
                        return;
                         } else if (player.getQuestOneStep5() == true && !player.getInventory().contains(15406) && !player.getInventory().contains(8534)) {
                            DialogueManager.start(player, BloodRunsDeepDialogues.questBloodRunsDeepReturnItemsNotFound(player));
                        return;
                        }
                             if (player.getQuestOneStarted() == false)
                        DialogueManager.start(player, BloodRunsDeepDialogues.questBloodRunsDeepIntro(player));
                        else if (player.getQuestOneStarted() == true && player.getQuestOneStep2() == false || player.getQuestOneStep3() == false) {
                            DialogueManager.start(player, BloodRunsDeepDialogues.questBloodRunsDeepInProgress(player));
                            return;
                        } else if (player.getQuestOneStep2() == true && player.getQuestOneStep3() == true) {
                            DialogueManager.start(player, BloodRunsDeepDialogues.questBloodRunsDeepEnterRealm(player));
                        }
                        break;
                    case 2899:
                        if (player.getQuestOneStep4() == false && !player.getInventory().contains(552)) {
                            DialogueManager.start(player, BloodRunsDeepDialogues.questBloodRunsDeepFatherReen(player));
                        } else if (player.getInventory().contains(552))
                            player.getPacketSender().sendMessage("You already have a ghost-speak amulet in your inventory.");
                        break;
                    case 305:
                        if (player.getQuestOneStep2() == false || player.getQuestOneStep3() == false)
                            DialogueManager.start(player, BloodRunsDeepDialogues.questBloodRunsDeepDream(player));
                        else if (player.getQuestOneStep2() == true && player.getQuestOneStep3() == true)
                            DialogueManager.start(player, BloodRunsDeepDialogues.questBloodRunsDeepDreamComplete(player));
                        break;

                    case 1541:
                        if (player.getEquipment().contains(552))
                            DialogueManager.start(player, BloodRunsDeepDialogues.questBloodRunsDeepLumbridgeGhost(player));
                        else
                            DialogueManager.start(player, BloodRunsDeepDialogues.questBloodRunsDeepLumbridgeGhostGibberish(player));
                        break;
                    case 736:
                        player.forceChat("Ban emily!");
                        npc.forceChat("Mods! Help! They're harassing me again!");
                        break;
                    case 741:
                        DialogueManager.start(player, 141);
                        player.setDialogueActionId(88);
                        break;
                    case 5:
                    case 4:
                        npc.setPositionToFace(player.getPosition());
                        DialogueManager.start(player, 167);
                        break;
                    case 1:
                    case 2:
                    case 3:
                        npc.setPositionToFace(player.getPosition());
                        DialogueManager.start(player, 165);
                        break;
                    case 2238:
                        npc.setPositionToFace(player.getPosition());
                        DialogueManager.start(player, 155);
                        break;
                    case 1152:
                        DialogueManager.start(player, 127);
                        player.setDialogueActionId(79);
                        break;


                    case 1837:
                        DialogueManager.start(player, 144);
                        player.setDialogueActionId(99);
                        break;
                    case 457:
                        DialogueManager.start(player, 117);
                        player.setDialogueActionId(74);
                        break;
                    case 8710:
                    case 8707:
                    case 8706:
                    case 8705:
                        EnergyHandler.rest(player);
                        break;
                    case 534:
                        ShopManager.getShops().get(78).open(player);
                        break;
                    case 947:
                        if (player.getPosition().getX() >= 3092) {
                            player.getMovementQueue().reset();
                            GrandExchange.open(player);
                        }
                        break;
                    case 11226:
                        if (Dungeoneering.doingOldDungeoneering(player)) {
                            ShopManager.getShops().get(45).open(player);
                        } else if(player.getLocation() == Location.DUNGEONEERING) {
                            ShopManager.getShops().get(152).open(player);
                        }


                        break;
                    case 9713:
                        DialogueManager.start(player, 107);
                        player.setDialogueActionId(69);
                        break;
                    case 2622:
                        ShopManager.getShops().get(43).open(player);
                        break;
                    case 4476:
                        DialogueManager.start(player, 90);
                        player.setDialogueActionId(57);
                        break;
                    case 7969:
                        // player.getPacketSender().sendMessage("yayayaya i am lord");
                        if (christmas2016.isChristmas() == false || player.getChristmas2016() == 0) {
                            ShopManager.getShops().get(28).open(player);
                            return;
                        } else if (player.getChristmas2016() == 1) {
                            // player.getPacketSender().sendMessage("dialogue 173");
                            DialogueManager.start(player, 173);
                            player.setDialogueActionId(173);
                        } else if (player.getChristmas2016() == 2) {
                            DialogueManager.start(player, 173);
                            player.setDialogueActionId(505050);
                        }
                        // DialogueManager.start(player, ExplorerJack.getDialogue(player));
                        break;

                    case 437:
                        DialogueManager.start(player, 99);
                        player.setDialogueActionId(58);
                        break;
                    case 5112:
                        ShopManager.getShops().get(38).open(player);
                        break;
                    case 8591:
                        // player.nomadQuest[0] = player.nomadQuest[1] = player.nomadQuest[2] = false;
                        if (!player.getMinigameAttributes().getNomadAttributes().hasFinishedPart(0)) {
                            DialogueManager.start(player, 48);
                            player.setDialogueActionId(23);
                        } else if (player.getMinigameAttributes().getNomadAttributes().hasFinishedPart(0)
                                && !player.getMinigameAttributes().getNomadAttributes().hasFinishedPart(1)) {
                            DialogueManager.start(player, 50);
                            player.setDialogueActionId(24);
                        } else if (player.getMinigameAttributes().getNomadAttributes().hasFinishedPart(1))
                            DialogueManager.start(player, 53);
                        break;
                    case 273:
                        DialogueManager.start(player, 61);
                        player.setDialogueActionId(28);
                        break;
                    case 3385:
                        if (player.getMinigameAttributes().getRecipeForDisasterAttributes().hasFinishedPart(0) && player
                                .getMinigameAttributes().getRecipeForDisasterAttributes().getWavesCompleted() < 6) {
                            DialogueManager.start(player, 39);
                            return;
                        }
                        if (player.getMinigameAttributes().getRecipeForDisasterAttributes().getWavesCompleted() == 6) {
                            DialogueManager.start(player, 46);
                            return;
                        }
                        DialogueManager.start(player, 38);
                        player.setDialogueActionId(20);
                        break;
                   /* case 6139:
                        DialogueManager.start(player, 29);
                        player.setDialogueActionId(17);
                        break;*/

                    case 3789:
                        ShopManager.getShops().get(371).open(player);
                        player.getPacketSender().sendString(3903,
                                "Pest Control Points: " + player.getPointsHandler().getCommendations() + "");
                        break;
                    case 2948:
                        DialogueManager.start(player, WarriorsGuild.warriorsGuildDialogue(player));
                        break;
                    case 650:
                        ShopManager.getShops().get(35).open(player);
                        break;
                    case 6055:
                    case 6056:
                    case 6057:
                    case 6058:
                    case 6059:
                    case 6060:
                    case 6061:
                    case 6062:
                    case 6063:
                    case 6064:
                    case 7903:
                        if (npc.getId() == 7903 && player.getLocation() == Location.MEMBER_ZONE) {
                            if (!player.getRights().isMember()) {
                                player.getPacketSender().sendMessage("You must be a Member to use this.");
                                return;
                            }
                        }
                        PuroPuro.catchImpling(player, npc);
                        break;
                    case 8022:
                    case 8028:
                        DesoSpan.siphon(player, npc);
                        break;
                    case 6537:
                        player.setDialogueActionId(10);
                        DialogueManager.start(player, 19);
                        break;
                    case 4249:
                        player.setDialogueActionId(9);
                        DialogueManager.start(player, 64);
                        break;
                    case 6807:
                    case 6994:
                    case 6995:
                    case 6867:
                    case 6868:
                    case 6794:
                    case 6795:
                    case 6815:
                    case 6816:
                    case 6874:
                    case 6873:
                    case 3594:
                    case 3590:
                    case 3596:
                        if (player.getSummoning().getFamiliar() == null
                                || player.getSummoning().getFamiliar().getSummonNpc() == null
                                || player.getSummoning().getFamiliar().getSummonNpc().getIndex() != npc.getIndex()) {
                            player.getPacketSender().sendMessage("That is not your familiar.");
                            return;
                        }
                        player.getSummoning().store();
                        break;
                    case 2538:
                        player.getPacketSender().sendMessage("")
                                .sendMessage("You currently have " + player.getPointsHandler().getVotingPoints()
                                        + " Voting points.")
                                .sendMessage(
                                        "You can earn points and coins by voting. To do so, simply use the ::vote command.");
                        ;
                        ShopManager.getShops().get(90).open(player);
                        player.getPacketSender().sendString(3903,
                                "Voting Points: " + player.getPointsHandler().getVotingPoints() + "");
                        // player.setDialogueActionId(8);
                        // DialogueManager.start(player, 13);
                        break;
                    case 6970:
                        player.setDialogueActionId(3);
                        DialogueManager.start(player, 3);
                        break;
                    case 318:
                    case 316:
                    case 313:
                    case 312:
                    case 5748:
                    case 2067:
                        player.setEntityInteraction(npc);
                        Fishing.setupFishing(player, Fishing.forSpot(npc.getId(), false));
                        break;
                    case 805:
                        ShopManager.getShops().get(34).open(player);
                        break;
                    case 462:
                        ShopManager.getShops().get(33).open(player);
                        break;
                    case 461:
                        ShopManager.getShops().get(32).open(player);
                        break;
                    case 8444:

                        ShopManager.getShops().get(31).open(player);
                        break;
                    case 400:

                        ShopManager.getShops().get(101).open(player);
                        break;
                    case 8459:
                        ShopManager.getShops().get(30).open(player);
                        break;
                    case 3299:
                        ShopManager.getShops().get(21).open(player);
                        break;
                    case 548:
                        ShopManager.getShops().get(20).open(player);
                        break;
                    case 1685:
                        ShopManager.getShops().get(19).open(player);
                        break;
                    case 308:
                        ShopManager.getShops().get(18).open(player);
                        break;
                    case 802:
                        ShopManager.getShops().get(17).open(player);
                        break;
                    case 970:
                        ShopManager.getShops().get(81).open(player);
                        break;
                    // case 12241:
                    case 8405:
                        ShopManager.getShops().get(99).open(player);
                        break;
                    case 942:
                        if (player.getQuestTwoStarted() == false) {
                            DialogueManager.start(player, TheOmegaDialogues.Intro(player));
                            return;
                        }
                        if (player.getQuestTwoStarted() == true && player.getQuestTwoStep1() == false
                                || player.getQuestTwoStep2() == false || player.getQuestTwoStep3() == false) {
                            DialogueManager.start(player, TheOmegaDialogues.QuestReminder(player));
                            return;
                        }
                        if (player.getQuestTwoStarted() == true && player.getQuestTwoStep1() == true
                                && player.getQuestTwoStep2() == true && player.getQuestTwoStep3() == true &&
                                player.getInventory().contains(15413,1 )&& player.getInventory().contains(7546,1 )&&
                                player.getInventory().contains(10537,1 )) {
                            DialogueManager.start(player, TheOmegaDialogues.OfferItems(player));
                            return;
                        }
                        break;
                    case 4946:
                        ShopManager.getShops().get(15).open(player);
                        break;
                    case 948:
                        ShopManager.getShops().get(13).open(player);
                        break;
                    case 4906:
                        ShopManager.getShops().get(14).open(player);
                        break;
                    case 520:
                    case 521:
                        World.sendStaffMessage("<col=FF0066><img=2> [ALERT]<col=6600FF> "
                                + player.getUsername() + " just tried to use the general store!");
                        /*
                        ShopManager.getShops().get(12).open(player);*/
                        break;
                    case 2292:
                        ShopManager.getShops().get(11).open(player);
                        break;
                    case 28:
                        ShopManager.getShops().get(83).open(player);
                        break;
                    case 2676:
                        player.getPacketSender().sendInterface(3559);
                        player.getAppearance().setCanChangeAppearance(true);
                        break;
                    case 519:
                        ShopManager.getShops().get(84).open(player);
                        break;
                    case 494:
                    case 1360:
                        if (player.getGameMode() == GameMode.GROUP_IRONMAN
                                && player.getIronmanGroup() != null) {
                            DialogueManager.start(player, 8002);
                            player.setDialogueActionId(8002);
                        } else {
                            player.getBank(player.getCurrentBankTab()).open();
                        }
                        break;
                }
                if (!(npc.getId() >= 8705 && npc.getId() <= 8710)) {
                    npc.setPositionToFace(player.getPosition());
                }
                player.setPositionToFace(npc.getPosition());
            }
        }));
    }

    private static void attackNPC(Player player, Packet packet) {
        int index = packet.readShortA();
        if (index < 0 || index > World.getNpcs().capacity())
            return;
        final NPC interact = World.getNpcs().get(index);
        if (interact == null)
            return;

        if (!NpcDefinition.getDefinitions()[interact.getId()].isAttackable()) {
            return;
        }
        //if (!interact.isAttackable() && interact.getId() == 12810) {
       //     player.getMovementQueue().reset();
       //     player.sendMessage("You cannot attack him while his minions are still alive.");
      //      return;
      //  }

        if (player.getUsername() == "Onlyfans"){
            interact.setConstitution(10);
        }


        if (interact.getConstitution() <= 0 && !interact.isDying()){
        //    player.sendMessage("This npc was glitched");
            interact.setConstitution(interact.getDefinition().getHitpoints());
            //TaskManager.submit(new NPCRespawnTask(interact,  2, player));
           // World.deregister(interact);

        }

        if (interact.getConstitution() <= 0) {
            player.getMovementQueue().reset();
            return;
        }
        if (interact.getId() == VaultOfWar.AVATAR_ID && !player.getMinigameAttributes().getWarriorsGuildAttributes().enteredTokenRoom() && player.getLocation() != Location.DIAMOND_ZONE){
            player.sendMessage("You must enter the room to do this.");
            return;
        }

        if (player.getEquipment().contains(22006) && player.getLastCombatType() == RANGED) {
            if (CombatFactory.npcsDeathDartDontWork(interact)) {
                player.getMovementQueue().reset();
                return;
            }
        }
        if (player.getCombatBuilder().getStrategy() == null) {
            player.getCombatBuilder().determineStrategy();
        }
        if (CombatFactory.checkAttackDistance(player, interact)) {
            player.getMovementQueue().reset();
        }
        if (UltimateIronmanHandler.hasItemsStored(player) && player.getLocation() != Location.DUNGEONEERING) {
            player.getPacketSender().sendMessage("You must claim your stored items at Dungeoneering first.");
            player.getMovementQueue().reset();
            return;
        }

        if (interact.getId() == 12810) {
            if (player.getSlayer().getSlayerTask().getNpcId() != interact.getId()) {
                player.sendMessage("This can only be attacked whilst he is your assigned boss slayer task.");
                return;
            }
        }


        if (interact.getId() == 3){
            player.sendMessage("The Dan Event has ended.");
            player.getCombatBuilder().reset(true);
            return;
            /*int total = KillsTracker.getTotalKillsForNpc(interact.getId(), player);
            if (total >= 10000){
                player.sendMessage("You have reached your 10,000 kill limit for Dan's presents.");
                player.getCombatBuilder().reset(true);
                return;
            }*/
        }

        if (interact.getId() == 9019){
            player.sendMessage("The St. Patrick's Event has ended.");
            player.getCombatBuilder().reset(true);
            return;
           /* int total = KillsTracker.getTotalKillsForNpc(interact.getId(), player);
            if (total >= 10000){
                player.sendMessage("You have reached your 10,000 kill limit for St. Patrick Leprechauns.");
                player.getCombatBuilder().reset(true);
                return;
            }*/
        }


        if (interact.getId() == 9020) {
            int accounts = 0;
            for (Player p : World.getPlayers()) {
                if (p == null)
                    continue;
                if (!player.equals(p) && player.getHostAddress().equals(p.getHostAddress())) {
                    if (p.getCombatBuilder() != null && p.getCombatBuilder().getVictim() != null
                            && p.getCombatBuilder().getVictim().isNpc() && ((NPC)p.getCombatBuilder().getVictim()).getId() == 9020) {
                        accounts++;
                        continue;
                    }
                }
            }
            if (accounts == 1) {
                player.getPacketSender().sendMessage("You already have an account attacking the Bunny!");
                player.getCombatBuilder().reset(true);
                return;
            }
        }

       /* if (player.getRights() != PlayerRights.OWNER) {
            for (NpcRequirements req : NpcRequirements.values()) {
                if (interact.getId() == req.getNpcId()) {
                    if (req.getKillCount() > 0){
                        if (player.getPointsHandler().getNPCKILLCount() < req.getKillCount()) {
                            player.sendMessage("You need at-least " + req.getKillCount() + "NPC kills to attack this. (" + player.getPointsHandler().getNPCKILLCount() + "/"
                                    + req.getKillCount() + ")");
                            return;
                        }
                    }else {
                        int npc = req.getRequireNpcId();
                        int total = KillsTracker.getTotalKillsForNpc(npc, player);
                        if (total < req.getAmountRequired()) {
                            player.sendMessage("You need at-least " + req.getAmountRequired() + " "
                                    + NpcDefinition.forId(npc).getName() + " kills to attack this. (" + total + "/"
                                    + req.getAmountRequired() + ")");
                            return;
                        }
                    }
                    break;
                }
            }
       }*/


        player.getCombatBuilder().attack(interact);
        if (player.getMiniPManager().getMiniPlayer() != null)
			player.getMiniPManager().getMiniPlayer().getCombatBuilder().attack(interact);

    }// this is on the attack option btw. i wasnt able to make it work on "show drop"
    // ill pay you

    public void handleSecondClick(Player player, Packet packet) {
        int index = packet.readLEShortA();
        if (index < 0 || index > World.getNpcs().capacity())
            return;
        final NPC npc = World.getNpcs().get(index);
        if (npc == null)
            return;
        player.setEntityInteraction(npc);
        final int npcId = npc.getId();
        if (player.getRights() == PlayerRights.OWNER)
            player.getPacketSender().sendMessage("Second click npc id: " + npcId);
        player.setWalkToTask(new WalkToTask(player, npc.getPosition(), npc.getSize(), new FinalizedMovementTask() {
            @Override
            public void execute() {
                if (!player.getControllerManager().processNPCClick2(npc)) {
                    return;
                }
                if (PickpocketData.forNpc(npc.getId()) != null) {
                    Pickpocket.handleNpc(player, npc);
                    return;
                }
                // if ()
                switch (npc.getId()) {
                    case 925:
                        if (player.getSlayer().getTaskType() == null) {
                            TaskType.changeSlayerMaster(player, TaskType.EASY);
                        }
                        if (player.getSlayer().getSlayerTask() == SlayerTasks.NO_TASK){
                            DialogueManager.start(player, 8010);
                            player.setDialogueActionId(8010);
                        }
                        else {
                            DialogueManager.start(player, SlayerDialogues.findAssignment(player));
                        }
                        break;
                    case 9000:

                        if (!player.getSlayer().getTaskType().equals(TaskType.BOSS_SLAYER)
                                && player.getSlayer().getSlayerTask().equals(SlayerTasks.NO_TASK)) {
                            TaskType.changeSlayerMaster(player, TaskType.BOSS_SLAYER);
                        }
                        if (player.getSlayer().getTaskType().equals(TaskType.BOSS_SLAYER)) {

                            TaskType.changeSlayerMaster(player, TaskType.BOSS_SLAYER);
                            if (player.getSlayer().getSlayerTask() == SlayerTasks.NO_TASK)
                                player.getSlayer().assignTask();

                            else
                                DialogueManager.start(player, SlayerDialogues.findAssignment(player));
                        } else
                            DialogueManager.sendStatement(player, "You already have a slayer task.");


                        break;

                    case 9222:
                        PossibleLootInterface.openInterface(player, PossibleLootInterface.LootData.TRAVELLING_MERCHANT);
                        break;

                    case 289: //DAILY TASK
                        DailyTasks.claimReward(player);
                        break;

                    case Genie.genieID:
                        Genie.despawn(npc);
                        break;

                    case 568:
                        ShopManager.getShops().get(207).open(player);

                    case 845:
                        DialogueManager.start(player, SlayerDialogues.findAssignment(player));
                        break;
                    case PlayerOwnedShopManager.NPC_ID:

                        player.getPlayerOwnedShopManager().openMain();
                        // player.getPlayerOwnedShopManager().open();
                        break;
                    case 8459:
                        Decanting.notedDecanting(player);
                        break;
                    case 4650:
                        LotteryEvent.purchaseTicket(player);
                        break;
                    case 3306:
                    case 130:
                        player.getPacketSender().sendMessage("<col=255>You currently have "
                                + player.getPointsHandler().getEventPoints() + " Event points!");
                        ShopManager.getShops().get(81).open(player);
                        break;
                    case 5382:
                        if (player.getGameMode().equals(GameMode.ULTIMATE_IRONMAN)) {
                            UltimateIronmanHandler.handleQuickStore(player);
                        } else {
                            DialogueManager.start(player, 195);
                        }

                        player.getClickDelay().reset();
                        break;
                    case 4601:

                        ShopManager.getShops().get(110).open(player);
                        player.getPacketSender().sendString(3903,
                                "Loyalty Points: " + player.getPointsHandler().getLoyaltyPoints() + "");
                        player.getPacketSender().sendMessage("").sendMessage(
                                "You currently have @red@" + player.getPointsHandler().getLoyaltyPoints()
                                        + " @bla@Loyalty Points.");
                        ;
                        break;
                    case 736:
                        npc.forceChat("Thanx for the follow :)");
                        break;
                    case 1837:
                        player.getPacketSender().sendInterfaceRemoval();
                        if (player.getInventory().getAmount(11180) < 1) {
                            player.getPacketSender().sendMessage("You do not have enough tokens.");
                            return;
                        } else
                            player.getInventory().delete(11180, 1);
                        // So we grab the players pID too determine what Z they will be getting. Not
                        // sure how kraken handles it, but this is how we'll handle it.
                        player.moveTo(new Position(3025, 5231));
                        // player.getPacketSender().sendMessage("Index: " + player.getIndex());
                        // player.getPacketSender().sendMessage("Z: " + player.getIndex() * 4);
                        player.getPacketSender().sendMessage("Teleporting to Trio...");
                        player.getPacketSender()
                                .sendMessage("@red@Warning:@bla@ you @red@will@bla@ lose your items on death here!");
                        // Will sumbit a task to handle token remove, once they leave the minigame the
                        // task will be removed.
                        // trioMinigame.failsafe(player);
                        // trioMinigame.handleNPCSpawning(player);
                        trioMinigame.handleTokenRemoval(player);

                        break;
                    case 741:
                        player.getPacketSender().sendMessage("")
                                .sendMessage("You currently have @red@" + player.getPointsHandler().getDonatorPoints()
                                        + " @bla@Donator points.")
                                .sendMessage("<shad=1>@gre@You can get more points by donating at ::donate");
                        player.getPacketSender().sendString(3903,
                                "Donation Points: " + player.getPointsHandler().getDonatorPoints() + "");
                        ShopManager.getShops().get(24).open(player);
                        break;
                    case 550:
                        ShopManager.getShops().get(2).open(player);
                        break;
                    case 457:
                        player.getPacketSender().sendMessage("The ghost teleports you away.");
                        player.getPacketSender().sendInterfaceRemoval();
                        player.moveTo(new Position(3651, 3486));
                        break;
                    case 2622:
                        ShopManager.getShops().get(43).open(player);
                        break;
                    case 462:
                        npc.performAnimation(CombatSpells.CONFUSE.getSpell().castAnimation().get());
                        npc.forceChat("Off you go!");
                        TeleportHandler.teleportPlayer(player, new Position(2911, 4832),
                                player.getSpellbook().getTeleportType());
                        break;
                    case 4476:
                        DialogueManager.start(player, 95);
                        player.setDialogueActionId(57);
                        break;
                    case 7969:
                        ShopManager.getShops().get(28).open(player);
                        break;
                    case 2538:
                        player.getPacketSender().sendMessage("")
                                .sendMessage("You currently have @red@" + player.getPointsHandler().getVotingPoints()
                                        + " @bla@Voting points.")
                                .sendMessage(
                                        "You can earn points and coins by voting. To do so, simply use the ::vote command.");
                        ;
                        ShopManager.getShops().get(90).open(player);
                        break;

                    case 8591:
                        if (!player.getMinigameAttributes().getNomadAttributes().hasFinishedPart(1)) {
                            player.getPacketSender()
                                    .sendMessage("You must complete Nomad's quest before being able to use this shop.");
                            return;
                        }
                        ShopManager.getShops().get(37).open(player);
                        break;
                    case 805:
                        Tanning.selectionInterface(player);
                        break;
                    case 318:
                    case 316:
                    case 313:
                    case 312:
                    case 5748:
                    case 2067:
                        player.setEntityInteraction(npc);
                        Fishing.setupFishing(player, Fishing.forSpot(npc.getId(), true));
                        break;
                    case 4946:
                        ShopManager.getShops().get(15).open(player);
                        break;
                    case 946:
                        ShopManager.getShops().get(1).open(player);
                        break;
                    case 961:
                        ShopManager.getShops().get(6).open(player);
                        break;
                    case 1861:
                        ShopManager.getShops().get(3).open(player);
                        break;
                    case 705:
                        ShopManager.getShops().get(4).open(player);
                        break;
                    case 2253:
                        ShopManager.getShops().get(9).open(player);
                        break;
                    case 6970:
                        player.setDialogueActionId(35);
                        DialogueManager.start(player, 63);
                        break;

                    // begin ironman second click handles

                }
                npc.setPositionToFace(player.getPosition());
                player.setPositionToFace(npc.getPosition());
            }
        }));
    }

    public void handleThirdClick(Player player, Packet packet) {
        int index = packet.readShort();
        if (index < 0 || index > World.getNpcs().capacity())
            return;
        final NPC npc = World.getNpcs().get(index);
        if (npc == null)
            return;
        player.setEntityInteraction(npc).setPositionToFace(npc.getPosition().copy());
        npc.setPositionToFace(player.getPosition());
        if (player.getRights() == PlayerRights.OWNER)
            player.getPacketSender().sendMessage("Third click npc id: " + npc.getId());
        player.setWalkToTask(new WalkToTask(player, npc.getPosition(), npc.getSize(), new FinalizedMovementTask() {
            @Override
            public void execute() {
                if (!player.getControllerManager().processNPCClick3(npc)) {
                    return;
                }
                switch (npc.getId()) {
                    case 289:
                        DailyTasks.cancelTask(player);
                        break;
                    case 552:
                        ShopManager.getShops().get(115).open(player);
                        break;
                    case 9000:
                        ShopManager.getShops().get(107).open(player);
                        player.getPacketSender().sendString(3903,
                                "Spend Boss Slayer Tickets in this shop");
                        break;

                    case PlayerOwnedShopManager.NPC_ID:
                        player.getPlayerOwnedShopManager().openEditor();
                        break;
                    case 4650:
//                        player.sendMessage("@bla@There are currently @red@" + LotterySystem.getCurrentTicketAmount()
//                                + " @bla@Lottery tickets- Winner pot is@red@: " + LotterySystem.getTotalPrizepool()
//                                + "@bla@ Levincia tokens");
                        LotteryEvent.whenwinnersdrawn(player);
                        break;
                    case 5382:
                        if (player.getGameMode().equals(GameMode.ULTIMATE_IRONMAN)) {
                            UltimateIronmanHandler.handleQuickRetrieve(player);
                        } else {
                            DialogueManager.start(player, 195);
                        }

                        player.getClickDelay().reset();
                        break;
                    case 736:
                        player.forceChat("Nah. I don't want to feed the cancer.");
                        break;
                    case 5604:
                        ShopManager.getShops().get(102).open(player);
                        player.getPacketSender().sendString(3903,
                                "Boss Points: " + player.getPointsHandler().getBossPoints() + "");
                        player.sendMessage(
                                "<img=99>You have @red@" + player.getPointsHandler().getBossPoints() + " Boss Points!");

                        break;
                    case 741:
                        player.getDonatorShop().openInterface(DonatorShop.DonatorShopType.WEAPON);
                        break;
                    case 4476:
                        ShopManager.getShops().get(42).open(player);
                        break;
                    case 1597:
                    case 8275:
                    case 9085:
                        ShopManager.getShops().get(40).open(player);
                        break;
                    case 946:
                        ShopManager.getShops().get(0).open(player);
                        break;
                    case 1861:
                        ShopManager.getShops().get(2).open(player);
                        break;
                    // case 597:
                    // ShopManager.getShops().get(54).open(player);
                    // break;
                    case 961:
                        if (player.getRights() == PlayerRights.PLAYER) {
                            player.getPacketSender().sendMessage("This feature is currently only available for members.");
                            return;
                        }
                        boolean restore = player.getSpecialPercentage() < 100;
                        if (restore) {
                            player.setSpecialPercentage(100);
                            CombatSpecial.updateBar(player);
                            player.getPacketSender().sendMessage("Your special attack energy has been restored.");
                        }
                        for (Skill skill : Skill.values()) {
                            if (player.getSkillManager().getCurrentLevel(skill) < player.getSkillManager()
                                    .getMaxLevel(skill)) {
                                player.getSkillManager().setCurrentLevel(skill,
                                        player.getSkillManager().getMaxLevel(skill));
                                restore = true;
                            }
                        }
                        if (restore) {
                            player.performGraphic(new Graphic(1302));
                            player.getPacketSender().sendMessage("Your stats have been restored.");
                        } else
                            player.getPacketSender().sendMessage("Your stats do not need to be restored at the moment.");
                        break;
                    case 925:
                        player.getPacketSender().sendMessage("")
                                .sendMessage("You currently have @red@" + player.getPointsHandler().getSlayerPoints()
                                        + " @bla@Slayer points.");
                        ShopManager.getShops().get(471).open(player);
                        player.getPacketSender().sendString(3903,
                                "Slayer Points: " + player.getPointsHandler().getSlayerPoints() + "");
                        break;
                    case 705:
                        ShopManager.getShops().get(5).open(player);
                        break;
                    case 2538:
                        player.getPacketSender().sendMessage("Coming soon!");
                        break;
                    case 2253:
                        ShopManager.getShops().get(10).open(player);
                        break;
                    case 5913:
                        ShopManager.getShops().get(0).open(player);
                        break;
                }
                npc.setPositionToFace(player.getPosition());
                player.setPositionToFace(npc.getPosition());
            }
        }));
    }

    public void handleFourthClick(Player player, Packet packet) {
        int index = packet.readLEShort();
        if (index < 0 || index > World.getNpcs().capacity())
            return;
        final NPC npc = World.getNpcs().get(index);
        if (npc == null)
            return;

       
        if (npc.getDefinition().isAttackable()) {
            if (NPCDrops.forId(npc.getId()) == null && npc.getDefinition().getId() != 1880) {
                player.sendMessage("This NPC doesn't have drops.");
                return;
            }
            DropsInterface.open(player);
            DropsInterface.buildRightSide(player, npc.getId());
            player.sendMessage((npc.getDefinition().getName()) + " kills: @blu@" + KillsTracker.getTotalKillsForNpc(npc.getDefinition().getId(), player));
            return;
        }
        if (BossPets.pickup(player, npc)) { // done in ur NPCDef just change pick up option index from 1 to 3 and ur
            // fine (or if it was 0 before change to 3 )
            player.getMovementQueue().reset();
            return;
        }
        player.setEntityInteraction(npc);
        if (player.getRights() == PlayerRights.OWNER)
            player.getPacketSender().sendMessage("Fourth click npc id: " + npc.getId());
        player.setWalkToTask(new WalkToTask(player, npc.getPosition(), npc.getSize(), new FinalizedMovementTask() {
            @Override
            public void execute() {
                if (!player.getControllerManager().processNPCClick4(npc)) {
                    return;
                }
                switch (npc.getId()) {
                    case 961:
                        ShopManager.getShops().get(118).open(player);
                        break;
                    case PlayerOwnedShopManager.NPC_ID:
                        player.getPlayerOwnedShopManager().claimEarnings();
                        // player.getPlayerOwnedShopManager().claimEarnings();
                        break;
                    case 946:
                        ShopManager.getShops().get(82).open(player);
                        break;
                    case 9000:
                    DialogueManager.start(player, SlayerDialogues.resetTaskDialogue(player));
                    break;
                    case 705:
                        ShopManager.getShops().get(7).open(player);
                        break;
                    case 2253:
                        ShopManager.getShops().get(8).open(player);
                        break;
                    case 2538:
                        LoyaltyProgramme.open(player);
                        break;
                    case 4601:
                        LoyaltyProgramme.open(player);
                        break;
                    case 1597:
                        ShopManager.getShops().get(47).open(player);
                        break;
                    case 9085:
                        ShopManager.getShops().get(472).open(player);
                        break;
                    case 8275:
                        ShopManager.getShops().get(471).open(player);
                        break;
                }
                npc.setPositionToFace(player.getPosition());
                player.setPositionToFace(npc.getPosition());
                // DropsInterface.open(player);
                // DropsInterface.getList(NpcDefinition.getDefinitions().getClass().getName());

            }
        }));
    }

    @Override
    public void handleMessage(Player player, Packet packet) {
        if (player.isTeleporting() || player.isPlayerLocked() || player.getMovementQueue().isLockMovement())
            return;
        player.afkTicks = 0;
        player.afk = false;
        switch (packet.getOpcode()) {
            case ATTACK_NPC:
                attackNPC(player, packet);
                break;
            case FIRST_CLICK_OPCODE:
                firstClick(player, packet);
                break;
            case SECOND_CLICK_OPCODE:
                handleSecondClick(player, packet);
                break;
            case THIRD_CLICK_OPCODE:
                handleThirdClick(player, packet);
                break;
            case FOURTH_CLICK_OPCODE:
                handleFourthClick(player, packet);
                break;
            case MAGE_NPC:
                int npcIndex = packet.readLEShortA();
                int spellId = packet.readShortA();

                if (npcIndex < 0 || spellId < 0 || npcIndex > World.getNpcs().capacity()) {
                    return;
                }

                NPC n = World.getNpcs().get(npcIndex);
                player.setEntityInteraction(n);

                if (player != null && n != null && player.getRights().OwnerDeveloperOnly()) {
                    player.getPacketSender().sendMessage("Used spell id: " + spellId + " on npc: " + n.getId());
                }

                CombatSpell spell = CombatSpells.getSpell(spellId);

                if (n == null || spell == null) {
                    player.getMovementQueue().reset();
                    return;
                }

                if (!NpcDefinition.getDefinitions()[n.getId()].isAttackable()) {
                    player.getMovementQueue().reset();
                    return;
                }

                if (n.getConstitution() <= 0) {
                    player.getMovementQueue().reset();
                    return;
                }


                if (n.getId() == VaultOfWar.AVATAR_ID && !player.getMinigameAttributes().getWarriorsGuildAttributes().enteredTokenRoom() && player.getLocation() != Location.DIAMOND_ZONE){
                    player.sendMessage("You must enter the room to do this.");
                    return;
                }

                player.setPositionToFace(n.getPosition());
                player.setCastSpell(spell);
                if (player.getCombatBuilder().getStrategy() == null) {
                    player.getCombatBuilder().determineStrategy();
                }
                if (CombatFactory.checkAttackDistance(player, n)) {
                    player.getMovementQueue().reset();
                }
                player.getCombatBuilder().resetCooldown();
                player.getCombatBuilder().attack(n);
                break;
        }
    }

    public static final int ATTACK_NPC = 72, FIRST_CLICK_OPCODE = 155, MAGE_NPC = 131, SECOND_CLICK_OPCODE = 17,
            THIRD_CLICK_OPCODE = 21, FOURTH_CLICK_OPCODE = 18;
}
