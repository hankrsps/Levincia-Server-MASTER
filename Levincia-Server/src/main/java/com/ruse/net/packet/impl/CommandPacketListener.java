package com.ruse.net.packet.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.ruse.GameServer;
import com.ruse.GameSettings;
import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.engine.task.impl.globalevents.*;
import com.ruse.model.*;
import com.ruse.model.Locations.Location;
import com.ruse.model.container.impl.Bank;
import com.ruse.model.container.impl.Equipment;
import com.ruse.model.container.impl.Shop.ShopManager;
import com.ruse.model.definitions.*;
import com.ruse.model.input.impl.ChangePassword;
import com.ruse.model.input.impl.EnterReferral;
import com.ruse.model.input.impl.SetPinPacketListener;
import com.ruse.motivote3.doMotivote;
import com.ruse.net.packet.Packet;
import com.ruse.net.packet.PacketListener;
import com.ruse.net.security.ConnectionHandler;
import com.ruse.util.Misc;
import com.ruse.util.RandomUtility;
import com.ruse.webhooks.discord.DiscordMessager;
import com.ruse.world.World;
import com.ruse.world.clip.region.RegionClipping;
import com.ruse.world.content.*;
import com.ruse.world.content.PlayerPunishment.Jail;
import com.ruse.world.content.achievements.AchievementInterface;
import com.ruse.world.content.afk.AfkSystem;
import com.ruse.world.content.bis.BestDRItemsInterface;
import com.ruse.world.content.bis.BestItemsInterface;
import com.ruse.world.content.bossEvents.BossEventHandler;
import com.ruse.world.content.clan.ClanChat;
import com.ruse.world.content.clan.ClanChatManager;
import com.ruse.world.content.cluescrolls.OLD_ClueScrolls;
import com.ruse.world.content.combat.CombatFactory;
import com.ruse.world.content.combat.DesolaceFormulas;
import com.ruse.world.content.combat.Maxhits;
import com.ruse.world.content.combat.magic.Autocasting;
import com.ruse.world.content.combat.prayer.CurseHandler;
import com.ruse.world.content.combat.prayer.PrayerHandler;
import com.ruse.world.content.combat.weapon.CombatSpecial;
import com.ruse.world.content.cosmetic.WardrobeHandler;
import com.ruse.world.content.dailyTask.DailyTaskHandler;
import com.ruse.world.content.dailyTasksNew.DailyTaskDifficulty;
import com.ruse.world.content.dailytasks_new.DailyTasks;
import com.ruse.world.content.dialogue.DialogueManager;
import com.ruse.world.content.dissolving.MainDissolving;
import com.ruse.world.content.events.PartyChest;
import com.ruse.world.content.globalBosses.*;
import com.ruse.world.content.grandexchange.GrandExchangeOffers;
import com.ruse.world.content.groupironman.GroupManager;
import com.ruse.world.content.holidayevents.easter2017;
import com.ruse.world.content.leaderboards.Leaderboard;
import com.ruse.world.content.minigames.impl.DissolveAllDialogue;
import com.ruse.world.content.minigames.impl.dungeoneering.Dungeoneering;
import com.ruse.world.content.minigames.impl.dungeoneering.DungeoneeringParty;
import com.ruse.world.content.pos.PlayerOwnedShopManager;
import com.ruse.world.content.progressionzone.ProgressionZone;
import com.ruse.world.content.raids.elders.ElderGodsData;
import com.ruse.world.content.raids.elders.TelosLoot;
import com.ruse.world.content.raids.system.RaidDifficulty;
import com.ruse.world.content.seasonpass.PassRewards;
import com.ruse.world.content.serverperks.ServerPerks;
import com.ruse.world.content.skeletalhorror.SkeletalHorror;
import com.ruse.world.content.skill.SkillManager;
import com.ruse.world.content.skill.impl.construction.Construction;
import com.ruse.world.content.skill.impl.crafting.Jewelry;
import com.ruse.world.content.skill.impl.fletching.BoltData;
import com.ruse.world.content.skill.impl.slayer.Slayer;
import com.ruse.world.content.skill.impl.summoning.SummoningTab;
import com.ruse.world.content.teleport.TeleportInterfaceHandler;
import com.ruse.world.content.transportation.TeleportHandler;
import com.ruse.world.content.transportation.TeleportType;
import com.ruse.world.content.upgrading.Upgradeables;
import com.ruse.world.content.youtube.YoutubeData;
import com.ruse.world.content.youtube.YoutubeInterfaceHandler;
import com.ruse.world.entity.impl.GroundItemManager;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.npc.NPCMovementCoordinator;
import com.ruse.world.entity.impl.npc.NPCSpawn;
import com.ruse.world.entity.impl.player.Player;
import com.ruse.world.entity.impl.player.PlayerSaving;
import com.ruse.world.instance.TestInstance;
import mysql.impl.FoxVote;
import mysql.impl.Store;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;

import static com.ruse.world.content.osrscollectionlog.LogType.MONSTERS;

/**
 * This packet listener manages commands a player uses by using the command
 * console prompted by using the "`" char.
 *
 * @author Gabriel Hannason
 */

public class CommandPacketListener implements PacketListener {


    public static int voteCount = 8;
    static HashMap<String, Integer> dissolvables = new HashMap<>();

    private static void playerCommands(final Player player, String[] command, String wholeCommand) throws IOException {

        if (command[0].equalsIgnoreCase ("members")) {
            player.membershipInterfaceHandler.openBenefitTab ();
        }

        if (command[0].equalsIgnoreCase ("startertasks")) {
            player.getStarterTasks ().openInterface ();
        }
        if (command[0].equalsIgnoreCase ("slayerfavourites")) {
            player.getSlayerFavourites ().open ();
        }
        //Start of Teleports
        if (command[0].equalsIgnoreCase ("home")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            Position pos = GameSettings.DEFAULT_POSITION;
            TeleportHandler.teleportPlayer (player, pos, player.getSpellbook ().getTeleportType ());
            player.getPacketSender ().sendMessage ("Teleporting you home!");
        }

        if (command[0].equalsIgnoreCase ("hounds1")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            Position pos = new Position (3421, 4777, 4);
            TeleportHandler.teleportPlayer (player, pos, player.getSpellbook ().getTeleportType ());
            player.getPacketSender ().sendMessage ("Teleporting you to mutated hounds!");
        }

        if (command[0].equalsIgnoreCase ("hounds2")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            Position pos = new Position (3421, 4777, 8);
            TeleportHandler.teleportPlayer (player, pos, player.getSpellbook ().getTeleportType ());
            player.getPacketSender ().sendMessage ("Teleporting you to mutated hounds!");
        }

        if (command[0].equalsIgnoreCase ("hounds3")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            Position pos = new Position (3421, 4777, 12);
            TeleportHandler.teleportPlayer (player, pos, player.getSpellbook ().getTeleportType ());
            player.getPacketSender ().sendMessage ("Teleporting you to mutated hounds!");
        }

        if (command[0].equalsIgnoreCase ("supreme")) {
            if (!player.getSupreme ()) {
                player.getPacketSender ().sendMessage ("You are not supreme enough to do this.");
                return;
            }
            Position supremeZone = new Position (1891, 5406);
            TeleportHandler.teleportPlayer (player, supremeZone, player.getSpellbook ().getTeleportType ());
            player.getPacketSender ().sendMessage ("Teleporting you to the Supreme Lair");
        }
        if (command[0].equalsIgnoreCase ("slayerchampion") || command[0].equalsIgnoreCase ("slayerboss")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            Position pos = new Position (3488, 4697);
            TeleportHandler.teleportPlayer (player, pos, player.getSpellbook ().getTeleportType ());
            player.getPacketSender ().sendMessage ("Teleporting you to the Slayer Champion!");
        }

        if (command[0].equalsIgnoreCase ("Vozzath")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            int roll = Misc.getRandom (3);
            if (roll == 0) {
                Position position = new Position (2656, 3812, 0);
                TeleportHandler.teleportPlayer (player, position, TeleportType.NORMAL);
                System.out.println ("Rolled : 0");
            } else if (roll == 1) {
                Position position = new Position (2656, 3794, 0);
                TeleportHandler.teleportPlayer (player, position, TeleportType.NORMAL);
                System.out.println ("Rolled : 1");
            } else if (roll == 2) {
                Position position = new Position (2667, 3805, 0);
                TeleportHandler.teleportPlayer (player, position, TeleportType.NORMAL);
                System.out.println ("Rolled : 2");
            } else {
                Position position = new Position (2645, 3805, 0);
                TeleportHandler.teleportPlayer (player, position, TeleportType.NORMAL);
                System.out.println ("Rolled : 3");
            }
        }

        if (command[0].equalsIgnoreCase ("donodeals")) {
            player.getDonationDeals ().displayReward ();
            player.getDonationDeals ().displayTime ();
            player.getPacketSender ().sendString (57277, "@yel@$" + player.getAmountDonatedToday ());
        }


        if (command[0].equalsIgnoreCase ("collectionlog")) {
            player.getCollectionLog2 ().open (MONSTERS);
            player.getPacketSender ().sendConfig (1106, 0);
        }

        if (command[0].equalsIgnoreCase ("dissolveall")) {
            int price = 0;
            player.howmuchdissolveamt = 0;

            for (int i = 0; i < player.getInventory ().capacity (); i++) {
                for (MainDissolving.DissolvingData data : MainDissolving.DissolvingData.values ()) {
                    if (data.getId () == player.getInventory ().get (i).getId ()) {
                        if (player.getInventory ().get (i) != null && player.getInventory ().get (i).getId () > 0
                                && player.getInventory ().get (i).getId () != 12855) {
                            player.howmuchdissolveamt += player.getMainDissolving ().handleAllAmount (i);
                        }
                    }
                }


            }

            player.getMainDissolving ().amtafterdissolvingall = price;
            DialogueManager.start (player, new DissolveAllDialogue (player, "Dissolve all dissolveable items for " + player.howmuchdissolveamt + " Tokens", "Nevermind", 6668));

        }
        if (command[0].equalsIgnoreCase ("daily")
                || command[0].equalsIgnoreCase ("dailytasks")) {
            player.getDailyTaskManager ().open ();
        }

        if (command[0].equalsIgnoreCase ("dritems") || command[0].equalsIgnoreCase ("bisdr")) {
            BestDRItemsInterface.openInterface (player, 0);
        }

        if (command[0].equalsIgnoreCase ("seasonpass")) {
            player.getSeasonPass ().openInterface ();
        }
        /*
        if (command[0].equalsIgnoreCase("hiddenturkeyloc")) {
            player.sendMessage(TurkeySpawns.getCurrent().getPosition().toString());
        }*/

        /*
        if (command[0].equalsIgnoreCase("event")) {
            if (player.getLocation() != null && player.getLocation() == Location.WILDERNESS
                    || player.getLocation() != null && player.getLocation() == Location.CUSTOM_RAIDS) {
                player.getPacketSender().sendMessage("You cannot do this at the moment.");
                return;
            }
            Position pos = new Position(2910, 4699);
            TeleportHandler.teleportPlayer(player, pos, player.getSpellbook().getTeleportType());
            player.getPacketSender().sendMessage("Teleporting you to the Holiday Event!");
        }
        */
/*
        if (command[0].equalsIgnoreCase ("event")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            Position pos = new Position (2528, 2656);
            TeleportHandler.teleportPlayer (player, pos, player.getSpellbook ().getTeleportType ());
            player.getPacketSender ().sendMessage ("Teleporting you to the Holiday Event!");
        }

        if (command[0].equalsIgnoreCase ("event2")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            Position pos = new Position (2528, 2656, 4);
            TeleportHandler.teleportPlayer (player, pos, player.getSpellbook ().getTeleportType ());
            player.getPacketSender ().sendMessage ("Teleporting you to the Holiday Event!");
        }

        if (command[0].equalsIgnoreCase ("event3")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            Position pos = new Position (2528, 2656, 8);
            TeleportHandler.teleportPlayer (player, pos, player.getSpellbook ().getTeleportType ());
            player.getPacketSender ().sendMessage ("Teleporting you to the Holiday Event!");
        }

        if (command[0].equalsIgnoreCase ("event4")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            Position pos = new Position (2528, 2656, 12);
            TeleportHandler.teleportPlayer (player, pos, player.getSpellbook ().getTeleportType ());
            player.getPacketSender ().sendMessage ("Teleporting you to the Holiday Event!");
        }
*/
        if (command[0].equalsIgnoreCase ("globals")) {
            player.getPacketSender ().sendMessage ("@red@<shad=1>Terrorstep: @yel@" + AfkSystem.getLeft () + " rocks left.");
            player.getPacketSender ().sendMessage ("@red@<shad=1>Hellraiser: @yel@" + HellraiserSystem.getLeft () + " kills left.");
            player.getPacketSender ().sendMessage ("@red@<shad=1>Slayer Champion: @yel@" + SlayerBossSystem.getLeft () + " tasks left.");
            player.getPacketSender ().sendMessage ("@red@<shad=1>Vote Boss: @yel@" + doMotivote.getVoteCount () + "/40 please vote!");
            player.getPacketSender ().sendMessage ("@red@<shad=1>Dragon King: @yel@" + DragonKingBoss.timeLeft ());
            player.getPacketSender ().sendMessage ("@red@<shad=1>Nightmare boss: @yel@" + NightmareBoss.timeLeft ());
            player.getPacketSender ().sendMessage ("@red@<shad=1>Naraku boss: @yel@" + NarakuBoss.timeLeft ());
            player.getPacketSender ().sendMessage ("@red@<shad=1>Ironman boss: @yel@" + IronmanBoss.timeLeft ());
            player.getPacketSender ().sendMessage ("@red@<shad=1>Vozzath @yel@" + GuardianSpawnSystem.getLeft () + " tickets left");
            player.getPacketSender ().sendMessage ("@red@<shad=1>Nephilim @yel@" + NephilimSpawnSystem.getLeft () + " tokens left");
            player.getPacketSender ().sendMessage ((FantasyZone.gameActive == false
                    ? "@red@<shad=1>Fantasy Realm: @yel@" + FantasyZone.getTimeLeft () : "@red@<shad=1>Fantasy Realm : @yel@Open"));
           // player.getPacketSender ().sendMessage ("@red@<shad=1>Krampus: @yel@" + HolidayBossEvent.getTimeLeft ());

        }
        if (command[0].equalsIgnoreCase ("train") || command[0].equalsIgnoreCase ("starter")
                || command[0].equalsIgnoreCase ("starterzone") || command[0].equalsIgnoreCase ("start") || command[0].equalsIgnoreCase (
                "training")) {
            ProgressionZone.teleport (player);
        }

        // Levincia midgame trials - uses unused layers of the existing progression map.
        if (command[0].equalsIgnoreCase("midgame") || command[0].equalsIgnoreCase("infernal")) {
            TeleportHandler.teleportPlayer(player, new Position(3034, 4121, 25), TeleportType.NORMAL);
            player.getPacketSender().sendMessage("@or2@Infernal Trial: defeat the Wardens and the Infernal Overlord.");
        }
        if (command[0].equalsIgnoreCase("shadowtrial") || command[0].equalsIgnoreCase("shadowboss")) {
            TeleportHandler.teleportPlayer(player, new Position(3034, 4121, 29), TeleportType.NORMAL);
            player.getPacketSender().sendMessage("@pur@Shadow Trial: defeat the Reavers and the Shadow Lord.");
        }
        if (command[0].equalsIgnoreCase("dragontrial") || command[0].equalsIgnoreCase("dragonboss")) {
            TeleportHandler.teleportPlayer(player, new Position(3034, 4121, 33), TeleportType.NORMAL);
            player.getPacketSender().sendMessage("@red@Dragon Trial: defeat the Knights and the Dragon Champion.");
        }

        if (command[0].equalsIgnoreCase ("hellraiser")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            Position position = new Position (3109, 5530, 0);
            TeleportHandler.teleportPlayer (player, position, TeleportType.NORMAL);

        }

        if (command[0].equalsIgnoreCase ("dk") || command[0].equalsIgnoreCase ("dragonking")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            TeleportHandler.teleportPlayer (player, new Position (2139, 5019, 0), player.getSpellbook ().getTeleportType ());
            player.getPacketSender ().sendMessage ("Teleporting you to the dragon kings lair!");
        }

        if (command[0].equalsIgnoreCase ("tribal") || command[0].equalsIgnoreCase ("goblin")
                || command[0].equalsIgnoreCase ("afkboss")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            Position[] locations = new Position[]{new Position (2013, 4505, 0)};
            Position teleportLocation = locations[RandomUtility.exclusiveRandom (0, locations.length)];
            TeleportHandler.teleportPlayer (player, teleportLocation, player.getSpellbook ().getTeleportType ());
            player.getPacketSender ().sendMessage ("Teleporting you to the afk boss!");
        }

        if (command[0].equalsIgnoreCase ("ironman") || command[0].equalsIgnoreCase ("ironmanboss")
                || command[0].equalsIgnoreCase ("ironboss")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            if (!player.getRights ().isStaff ()) {
                if (!player.getGameMode ().isIronman ()) {
                    player.getPacketSender ().sendMessage ("Only Ironmen can access this boss");
                    return;
                }
            }
            Position[] locations = new Position[]{new Position (3808, 2842, 0)};
            Position teleportLocation = locations[RandomUtility.exclusiveRandom (0, locations.length)];
            TeleportHandler.teleportPlayer (player, teleportLocation, player.getSpellbook ().getTeleportType ());
            player.getPacketSender ().sendMessage ("Teleporting you to the Ironman boss!");
        }

        if (command[0].equalsIgnoreCase ("upgrade") || command[0].equalsIgnoreCase ("upgrades")
                || command[0].equalsIgnoreCase ("upgradeables")) {
            player.getUpgradeInterface ().openInterface (Upgradeables.UpgradeType.TIER_1);
        }

        if (command[0].equalsIgnoreCase ("neph") || command[0].equalsIgnoreCase ("nephilim")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            TeleportHandler.teleportPlayer (player, new Position (2144, 3294, 0), player.getSpellbook ().getTeleportType ());
            player.getPacketSender ().sendMessage ("Teleporting you to the Nephilim Warrior");
        }

        if (command[0].equalsIgnoreCase ("naraku") || command[0].equalsIgnoreCase ("narak")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            TeleportHandler.teleportPlayer (player, new Position (3420, 9563, 0), player.getSpellbook ().getTeleportType ());
            player.getPacketSender ().sendMessage ("Teleporting you to Naraku Global boss");
        }
        if (command[0].equalsIgnoreCase ("dismiss")) {
            SummoningTab.handleDismiss (player, true);
        }
        if (command[0].equalsIgnoreCase ("nm") || command[0].equalsIgnoreCase ("nightmare")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            TeleportHandler.teleportPlayer (player, new Position (2980, 2771, 0), player.getSpellbook ().getTeleportType ());
            player.getPacketSender ().sendMessage ("Teleporting you to Nightmare!");
        }

        if (command[0].equalsIgnoreCase ("gamble") || command[0].equalsIgnoreCase ("dice")
                || command[0].equalsIgnoreCase ("dicezone")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }

            if (player.isGambleBanned ()) {
                player.sendMessage ("You are gamble banned and cannot do this.");
                return;
            }

            if (player.getPointsHandler ().getNPCKILLCount () < 50000) {
                player.sendMessage ("You must have at-least 50k NPC killcount to gamble.");
                return;
            }

            Position position = new Position (2463, 5032, 0);
            TeleportHandler.teleportPlayer (player, position, TeleportType.NORMAL);
            player.getPacketSender ().sendMessage ("Teleporting you to the Gambling Area!");
        }

        if (command[0].equalsIgnoreCase ("iron")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            if (!player.getRights ().isStaff ()) {
                if (!player.getGameMode ().isIronman ()) {
                    player.getPacketSender ().sendMessage ("Become an ironman!");
                    return;
                }
            }
            Position position = new Position (3811, 2839, 0);

            TeleportHandler.teleportPlayer (player, position, TeleportType.NORMAL);

        }

        if (command[0].equalsIgnoreCase ("vboss") || command[0].equalsIgnoreCase ("voteboss")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            Position position = new Position (3428, 4115, 4);
            TeleportHandler.teleportPlayer (player, position, TeleportType.NORMAL);

        }

        if (command[0].equalsIgnoreCase ("afk")) {

            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            Position position = new Position (2656, 3981, 0);
            TeleportHandler.teleportPlayer (player, position, TeleportType.NORMAL);
            player.getPacketSender ().sendMessage ("<shad=1>@gre@Welcome to the afk area!");

        }
        if (command[0].equalsIgnoreCase("toggleafksoul")) {
            player.toggleAfkSoulMessages();
            return;
        }
        if ((command[0].equalsIgnoreCase ("shop") && !player.getRights ().OwnerDeveloperOnly ())
                || command[0].equalsIgnoreCase ("shops")) {
            if (player.getLocation () != null && player.getLocation () == Location.WILDERNESS
                    || player.getLocation () != null && player.getLocation () == Location.CUSTOM_RAIDS) {
                player.getPacketSender ().sendMessage ("You cannot do this at the moment.");
                return;
            }
            Position position = new Position (2784, 4082, 0);
            TeleportHandler.teleportPlayer (player, position, TeleportType.NORMAL);
        }

        //Start Of External Links
        if (wholeCommand.equalsIgnoreCase ("donate") || wholeCommand.equalsIgnoreCase ("store")) {
            player.getPacketSender ().sendString (1, GameSettings.StoreUrl);
            player.getPacketSender ().sendMessage ("Attempting to open the store");
        }

        if (wholeCommand.equalsIgnoreCase ("client") || wholeCommand.equalsIgnoreCase ("launcher")) {
            player.getPacketSender ().sendString (1, "Levincia.io/play");
            player.getPacketSender ().sendMessage ("Attempting to download the launcher");
        }
        if (wholeCommand.equalsIgnoreCase ("discord") || wholeCommand.equalsIgnoreCase ("chat")) {
            player.getPacketSender ().sendString (1, GameSettings.DiscordUrl);
            player.getPacketSender ().sendMessage ("Attempting to open our Discord Server");
        }

        if (wholeCommand.equalsIgnoreCase ("forums") || wholeCommand.equalsIgnoreCase ("forum")) {
            player.getPacketSender ().sendString (1, GameSettings.ForumUrl);
            player.getPacketSender ().sendMessage ("Attempting to open the forums");
        }
        if (wholeCommand.equalsIgnoreCase ("updates") || wholeCommand.equalsIgnoreCase ("whatsnew")) {
            player.getPacketSender ().sendString (1, GameSettings.UpdateUrl);
            player.getPacketSender ().sendMessage ("Attempting to open the the update list");
        }

        if (wholeCommand.equalsIgnoreCase ("rule") || wholeCommand.equalsIgnoreCase ("rules")) {
            player.getPacketSender ().sendString (1, GameSettings.RuleUrl);
            player.getPacketSender ().sendMessage ("Attempting to open the Rules.");
        }
        //End of External Links
        //Start of Interfaces
        if (command[0].equalsIgnoreCase ("zones")) {
            player.getPacketSender ().sendInterfaceReset ();
            /*    player.getPacketSender().sendInterface(142250);
             */
            new TeleportInterfaceHandler (player).quickOpenZones ();
        }

        if (command[0].equalsIgnoreCase ("wardrobe") && player.isCosmeticUnlocked ()) {
            player.getPacketSender ().sendInterfaceReset ();
            new WardrobeHandler (player).open ();
        }

        if (command[0].equalsIgnoreCase("perks")) {
            ServerPerks.getInstance().open(player);
        }

        if (command[0].equalsIgnoreCase("kills")) {
            player.getPacketSender().sendInterfaceRemoval();
            BossLog.open(player);
//            KillTrackerInterface.open(player);
        }
        if (command[0].equalsIgnoreCase("oldkills")) {
            player.getPacketSender().sendInterfaceRemoval();
            KillTrackerInterface.open(player);
        }

        if (command[0].equalsIgnoreCase("togglecosmetic")) {
            player.setCosmeticOveride(!player.isCosmeticOveride());
            player.sendMessage("Showing Cosmetic overrides: " + player.isCosmeticOveride());
            player.getUpdateFlag().flag(Flag.APPEARANCE);
            return;
        }
        if (command[0].equalsIgnoreCase("possibleloot") || command[0].equalsIgnoreCase("loot")
                || command[0].equalsIgnoreCase("loots")) {
            PossibleLootInterface.openInterface(player, PossibleLootInterface.LootData.values()[0]);
        }

        if (command[0].equalsIgnoreCase("teleport") && (!player.isOpenedTeleports())) {
            /*
            player.setOpenedTeleports(true);
            TeleportInterface.sendMonsterData(player, TeleportInterface.Monsters.values()[0]);
            TeleportInterface.sendMonsterTab(player);
             */
            new TeleportInterfaceHandler(player).open();
        }
/*
        if (command[0].equalsIgnoreCase("achievements") || command[0].equalsIgnoreCase("dailytasks")
                || command[0].equalsIgnoreCase("tasks")) {
            player.getAchievements().refreshInterface(player.getAchievements().currentInterface);
            player.getPacketSender().sendConfig(6000, 3);
        }
*/


        if (command[0].equalsIgnoreCase("whatdrops")) {
            try {
                boolean isItem = false;
                int itemId = 0;
                String target = wholeCommand.substring(command[0].length() + 1);
                player.getPacketSender().sendMessage("Finding what drops \"" + target + "\".");

                for (int i = 0; i < ItemDefinition.getDefinitions().length; i++) {
                    if (ItemDefinition.forId(i) == null || ItemDefinition.forId(i).getName() == null) {
                        continue;
                    }
                    if (ItemDefinition.forId(i).getName().toLowerCase().equalsIgnoreCase(target)) {
                        isItem = true;
                        itemId = i;
                        break;
                    }
                }
                if (!isItem) {
                    player.getPacketSender().sendMessage("No item named \"" + target + "\" was found.");
                    return;
                } /*
                 * else { player.getPacketSender().sendMessage("Found the item"); }
                 */

                for (int i = 0; i < NpcDefinition.getDefinitions().length; i++) {
                    if (NpcDefinition.forId(i) == null || NpcDefinition.forId(i).getName() == null
                            || NPCDrops.forId(i) == null || NPCDrops.forId(i).getDropList() == null
                            || NPCDrops.forId(i).getDropList().length <= 0) {
                        // // System.out.println("fuck sake");
                        continue;
                    }

                    for (int q = 0; q < NPCDrops.forId(i).getDropList().length; q++) {
                        if (ItemDefinition.forId(NPCDrops.forId(i).getDropList()[q].getItem().getId()) == null
                                || ItemDefinition.forId(NPCDrops.forId(i).getDropList()[q].getItem().getId())
                                .getName() == null) {
                            // // System.out.println("what the hell");
                            continue;
                        }
                        // //
                        // System.out.println(ItemDefinition.forId(NPCDrops.forId(i).getDropList()[q].getId()).getName()+"
                        // VS "+ItemDefinition.forId(itemId).getName());

                        if (ItemDefinition.forId(NPCDrops.forId(i).getDropList()[q].getId()).getName()
                                .equalsIgnoreCase(ItemDefinition.forId(itemId).getName())) {
                            player.getPacketSender()
                                    .sendMessage(NpcDefinition.forId(i).getName() + " drops " + target + ".");
                            continue;
                        }
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command[0].equalsIgnoreCase("drops") || command[0].equalsIgnoreCase("drop")) {
            player.getPacketSender().sendMessage("Opening drops interface...");
            DropsInterface.open(player);
        }
   /*
        if (command[0].equalsIgnoreCase("questtest") || command[0].equalsIgnoreCase("questtest")) {
            for (int i = 8145; i < 8245; i++)
                player.getPacketSender().sendString(i, "");
            player.getPacketSender().sendInterface(8134);
            player.getPacketSender().sendString(8136, "Close window");
            player.getPacketSender().sendString(8144, "The Omega");
            player.getPacketSender().sendString(8145, "");
            int index = 8147;
            String color = "@dre@";
            String color1 = "@red@";

            player.getPacketSender().sendString(index++, color1 + "@red@Quest Complete!");
            player.getPacketSender().sendString(index++, color + "Rewards:");
            player.getPacketSender().sendString(index++, color + "@blu@3 @bla@Quest points");
            player.getPacketSender().sendString(index++, color + "@blu@15 @bla@Emerald Mystery boxes");
            player.getPacketSender().sendString(index++, color + "@blu@10 @bla@Invention XP Lamps");
            player.getPacketSender().sendString(index++, color + "@bla@An Omega Charm");
        player.getPacketSender().sendString(index++, color + "");
    }*/
        if (wholeCommand.equalsIgnoreCase("commands")) {
            for (int i = 8145; i < 8245; i++)
                player.getPacketSender().sendString(i, "");
            player.getPacketSender().sendInterface(8134);
            player.getPacketSender().sendString(8136, "Close window");
            player.getPacketSender().sendString(8144, "Commands");
            player.getPacketSender().sendString(8145, "");
            int index = 8147;
            String color = "@dre@";
            String color1 = "@red@";

            player.getPacketSender().sendString(index++, color1 + "Main Commands:");
            player.getPacketSender().sendString(index++, color + "::home - Teleports you home");
            player.getPacketSender().sendString(index++, color + "::train - Teleports you to training zone");
            player.getPacketSender().sendString(index++, color + "::melee - Teleports you to Ember Giants");
            player.getPacketSender().sendString(index++, color + "::range - Teleports you to Tree Basilisk");
            player.getPacketSender().sendString(index++, color + "::mage - Teleports you to Aquanite");
            player.getPacketSender().sendString(index++, color + "::shops - Teleports you to all shops");
            player.getPacketSender().sendString(index++, color + "");
            player.getPacketSender().sendString(index++, color1 + "Interface Commands:");
            player.getPacketSender().sendString(index++, color + "::kills - opens up your personal kill tracker list");
            player.getPacketSender().sendString(index++, color + "::pos - opens the player owned shops interface");
            player.getPacketSender().sendString(index++, color + "::teleport - opens the monster teleport interface");
            player.getPacketSender().sendString(index++, color + "::upgrade - opens the upgrade system interface");
            player.getPacketSender().sendString(index++, color + "::drops - opens the loot viewer interface for npcs");
            player.getPacketSender().sendString(index++, color + "::collection - opens the collection log interface");
            player.getPacketSender().sendString(index++, color + "::itemstats - opens up best items interface");
            player.getPacketSender().sendString(index++, color + "");
            player.getPacketSender().sendString(index++, color1 + "Other Commands:");
            player.getPacketSender().sendString(index++, color + "::dr - shows you your current droprate");
            player.getPacketSender().sendString(index++, color + "::globals - shows you the time remaining on all global bosses");
            player.getPacketSender().sendString(index++, color + "::bank - opens up your bank ($50 total claimed required)");
            player.getPacketSender().sendString(index++,  color + "::players - tells you how many players are currently online");
            player.getPacketSender().sendString(index++, color + "::discord - opens up our discord for Levincia");
            player.getPacketSender().sendString(index++, color + "::vote - opens up our site for voting");
            player.getPacketSender().sendString(index++, color + "::voted - claims your votes");
            player.getPacketSender().sendString(index++, color + "::donate - opens up our donation site");
            player.getPacketSender().sendString(index++, color + "::donated - claims your donation");
            player.getPacketSender().sendString(index++, color + "::dissolveall - dissolves all dissolvable items in your inv");
            player.getPacketSender().sendString(index++,color + "::ckeys - teleports you to the crystal chest");
            player.getPacketSender().sendString(index++,color + "::whatdrops (item name) - tells you what drops the item");
            player.getPacketSender().sendString(index++,
                    color + "::dropmessage - removes messages of drops going to your inv/bank");
            player.getPacketSender().sendString(index++, color + "::help - requests assistance from a staff member");
            player.getPacketSender().sendString(index++, color + "::yell - sends a global message");
            player.getPacketSender().sendString(index++, color + "");
        }
        //End interfaces

        //Start Misc commands
        if(command[0].equalsIgnoreCase("answer")) {
            String answer = wholeCommand.substring(7);
            TriviaSystem.answer(player, answer);
        }

        if(command[0].equalsIgnoreCase("question")) {
            player.forceChat(TriviaSystem.getCurrentQuestion());
            player.forceChat(TriviaSystem.getCurrentQuestion());
        }

        if (command[0].equalsIgnoreCase("achievements"))
        AchievementInterface.open(player);

        if (command[0].equalsIgnoreCase("dropmessage")) {
            player.dropMessageToggle = !player.dropMessageToggle;
            player.sendMessage("Show drop messages currently set to: " + player.dropMessageToggle);
            return;
        }
        if (command[0].equalsIgnoreCase("motivational")) {
            player.motivationalToggle = !player.motivationalToggle;
            player.sendMessage("Show motivational teleport messages currently set to: " + player.motivationalToggle);
            return;
        }

        if (command[0].equalsIgnoreCase("membermessage") || command[0].equalsIgnoreCase("membermessages")) {
            player.membershipMessages = !player.membershipMessages;
            player.sendMessage("Show Membership messages currently set to: " + player.membershipMessages);
            return;
        }
        if (command[0].equalsIgnoreCase("donationdeals") || command[0].equalsIgnoreCase("deals")) {
            player.sendMessage(
                    "<shad=1>@yel@Active donation deals are in our ::Discord - #Donation-deals");
        }

        if (wholeCommand.equalsIgnoreCase("droprate") || wholeCommand.equalsIgnoreCase("mydr") || wholeCommand.equalsIgnoreCase("dr")) {
            player.getPacketSender()
                    .sendMessage("Droprate  bonus is + @red@" + CustomDropUtils.drBonus(player, player.getSlayer().getSlayerTask().getNpcId())
                            + "@bla@%. / X2 Drop bonus is + <col=248f8f>" + CustomDropUtils.getDoubleDropChance(player, player.getSlayer().getSlayerTask().getNpcId())
                            + "@bla@%.");
           if (player.isMembershipUnlocked())
               player.getPacketSender()
                   .sendMessage("You're getting a @red@20% DR Boost@bla@ with your Monthly Membership!");
            if (player.isMembershipUnlocked())
                player.getPacketSender()
                        .sendMessage("You're getting a @red@10% DDR Boost@bla@ with your Monthly Membership!");
        }

        if (wholeCommand.equalsIgnoreCase("ddr")) {
            player.getPacketSender().sendMessage(
                    "Your Double  bonus is + @red@" + CustomDropUtils.getDoubleDropChance(player, player.getSlayer().getSlayerTask().getNpcId()) + "@bla@%.");

            if (player.isMembershipUnlocked())
                player.getPacketSender()
                        .sendMessage("You're getting a @red@10% Overall DDR Boost@bla@ with your Monthly Membership!");
        }
        if (command[0].equalsIgnoreCase("time") || command[0].equalsIgnoreCase("date")
                || command[0].equalsIgnoreCase("clock")) {
            int month = 1 + Misc.getMonth();
            String mo = Integer.toString(month);
            String dd = Integer.toString(Misc.getDayOfMonth());
            String weekend = "";

            if (Misc.getDayOfMonth() < 10) {
                dd = "0" + dd;
            }

            if (month < 10) {
                mo = "0" + mo;
            }

            if (Misc.isWeekend()) {
                weekend = ". It's the weekend";
            }

            player.getPacketSender().sendMessage("@cya@<shad=0>[Time] <shad=-1>@bla@[" + mo + "/" + dd + "] (MM/DD) @ "
                    + Misc.getCurrentServerTime() + " (24:00) in New York City, USA" + weekend + ".");
        }

        if (command[0].equalsIgnoreCase("maxhit")) {
            player.getPacketSender().sendMessage("<shad=1>@red@Melee Maxhit: " + (Maxhits.melee(player, player) / 10));
            player.getPacketSender()
                    .sendMessage("<shad=1>@gre@Ranged Maxhit: " + (Maxhits.ranged(player, player) / 10));
            player.getPacketSender().sendMessage("<shad=1>@cya@Magic Maxhit: " + (Maxhits.magic(player, player) / 10));
        }

        if (command[0].startsWith("reward") || command[0].startsWith("voted") || command[0].startsWith("claim vote")) {


            if (!player.getLastVoteClaim().elapsed(250)) {
                player.getPacketSender()
                        .sendMessage("You must wait at least 1 second before using " + command[0] + " again.");
                return;
            }
            player.getPacketSender().sendMessage("Checking for votes...");
            new Thread(new FoxVote(player)).start();


        }
        if (command[0].equalsIgnoreCase("rest")) {
            if (player.getPosition().getRegionId() != 11082 ) {//vod
                Afking.afk(player);
            }else return;
        }
        if (command[0].equalsIgnoreCase("youtube")) {
            new YoutubeInterfaceHandler(player).open();
        }

        if (command[0].equalsIgnoreCase("checkwinner")) {
            LotteryEvent.initialdialogue(player);
            player.sendMessage("total entries: "+World.getServerData().getTopLottery().getEntries().size()+" "+World.getServerData().getTopLottery().getTotalPot());
        }
        if (command[0].equalsIgnoreCase("resetdate")) {
            int hour = Integer.parseInt(command[1]);
            int minute = Integer.parseInt(command[2]);
            LotteryEvent.setdate(hour,minute);

        }

        if (command[0].equalsIgnoreCase("claimdonation") || command[0].equalsIgnoreCase("claimdonate")
                || command[0].equalsIgnoreCase("claim") || command[0].equalsIgnoreCase("donated")) {
            new Thread(new Store(player)).start();
        }


        if (command[0].equalsIgnoreCase("resetdaily")) {
            new DailyTaskHandler(player).resetTasks();
        }

        if (command[0].equalsIgnoreCase("destroyinstance")) {
            player.getInstanceManager().onLogout();
        }

        if (wholeCommand.equalsIgnoreCase("changepass") || wholeCommand.equalsIgnoreCase("changepassword")) {
            player.setInputHandling(new ChangePassword());
            player.getPacketSender().sendEnterInputPrompt("Enter a new password:");
        }
        if (command[0].equalsIgnoreCase("attacks")) {
            int attack = DesolaceFormulas.getMeleeAttack(player);
            int range = DesolaceFormulas.getRangedAttack(player);
            int magic = DesolaceFormulas.getMagicAttack(player);
            player.getPacketSender().sendMessage("@bla@Melee attack: @or2@" + attack + "@bla@, ranged attack: @or2@"
                    + range + "@bla@, magic attack: @or2@" + magic);
        }

        if (command[0].equalsIgnoreCase("wiki")) {
            String threadName = String.valueOf(wholeCommand.toString().replace("wiki", "").toLowerCase(Locale.ROOT));
            player.getPacketSender().sendMessage("Opening Wiki thread: " + threadName);
            player.getPacketSender().sendString(1, "https://avalonrsps.fandom.com/" + threadName + "");
        }

        if (command[0].equalsIgnoreCase("vote")) {
            player.getPacketSender().sendString(1, GameSettings.VoteUrl);
            player.getPacketSender().sendMessage("After you are done voting use command ::voted to redeem your points!");
        }
        if (command[0].equalsIgnoreCase("pricelist")) {
            player.getPacketSender().sendString(1, GameSettings.PriceList);
            player.getPacketSender().sendMessage("Attempting to open pricelist");
        }
        if (command[0].equalsIgnoreCase("hiscores") || command[0].equalsIgnoreCase("highscores")) {
            player.getPacketSender().sendString(1, GameSettings.HiscoreUrl);
            player.getPacketSender().sendMessage("Attempting to open the hiscores.");
        }

        if (command[0].equalsIgnoreCase("toggleglobalmessages") || command[0].equalsIgnoreCase("globalmessages")) {
            if (player.toggledGlobalMessages() == false) {
                player.getPacketSender().sendMessage("You have opted out from filterable global messages.");
                player.setToggledGlobalMessages(true);
            } else {
                player.getPacketSender().sendMessage("You have opted in to filterable global messages.");
                player.setToggledGlobalMessages(false);
            }
        }

        if (command[0].equalsIgnoreCase("pos") && player.getLocation() == Location.WILDERNESS || player.getLocation() == Location.DUNGEONEERING
                || player.getLocation() != null && player.getLocation() == Location.CUSTOM_RAIDS
                || player.getLocation() == Location.DUEL_ARENA || player.getLocation() == Location.JAIL) {
            player.getPacketSender().sendMessage("This feature is currently not available, try teleporting home first!");
            return;
        } else if (command[0].equalsIgnoreCase("pos") && player.getLocation() != Location.HOME_BANK
                && player.getAmountDonated() < Store.EMERALD_DONATION_AMOUNT) {
            player.sendMessage("You either need $50 total claim or can only use this command at ::Home");
            return;
        } else if (command[0].equalsIgnoreCase("pos") && player.getAmountDonated() >= Store.EMERALD_DONATION_AMOUNT) {
            player.sendMessage("As a $50 Donator benefit, you can use this command anywhere.");
            player.getPlayerOwnedShopManager().options();
        } else if (command[0].equalsIgnoreCase("pos") && player.getLocation() == Location.HOME_BANK
                && player.getAmountDonated() < Store.EMERALD_DONATION_AMOUNT) {
            player.getPlayerOwnedShopManager().options();
        }

        if (command[0].equalsIgnoreCase("setloginpin")) {
            if (player.getHasPin() == false) {

                player.setInputHandling(new SetPinPacketListener());
                player.getPacketSender().sendEnterInputPrompt("Enter the pin that you want to set$pin");
            }
        }
        if (command[0].equalsIgnoreCase("enterpin")) {
            if (player.getHasPin() == false) {
                player.setInputHandling(new SetPinPacketListener());
                player.getPacketSender().sendEnterInputPrompt("Enter the pin that you want to set$pin");
            }
        }
       if (command[0].equalsIgnoreCase("dropparty") || command[0].equalsIgnoreCase("party")) {
            TeleportHandler.teleportPlayer(player, new Position(1696, 4265, 0), player.getSpellbook().getTeleportType());
            player.sendMessage("Trolling an event can result in you not being able to participate in events.");
        }

        if (command[0].equalsIgnoreCase("afkcount")) {
            player.sendMessage("@blu@Current AFK Thieving count: @red@" + AfkSystem.burnedSouls);
        }

        if (command[0].equalsIgnoreCase("logout")) {
            World.getPlayers().remove(player);
        }
        if (command[0].equalsIgnoreCase("ref") ||command[0].equalsIgnoreCase("refer") || command[0].equalsIgnoreCase("referral")) {
            if (!player.hasReferral) {
                player.getPacketSender().sendEnterInputPrompt("Please type your refer code to receive a reward!");
                player.setInputHandling(new EnterReferral());
            } else {
                player.getPacketSender().sendMessage("You have already claimed a referral reward on this account!");
            }
        }

        if (command[0].equalsIgnoreCase ("oz")) {
            Position ownerZone = new Position (3490, 4698);
            TeleportHandler.teleportPlayer (player, ownerZone, player.getSpellbook ().getTeleportType ());
            player.getPacketSender ().sendMessage ("Teleporting you to the Skeleton's Lair");
        }

        if (command[0].equalsIgnoreCase("switchbook")) {
            if (player.getSkillManager().getMaxLevel(Skill.DEFENCE) < 30) {
                player.getPacketSender().sendMessage("You need a Defence level of at least 30 to use this altar.");
                return;
            }
            player.performAnimation(new Animation(645));
            if (player.getPrayerbook() == Prayerbook.NORMAL) {
                player.getPacketSender().sendMessage("You sense a surge of power flow through your body!");
                player.setPrayerbook(Prayerbook.CURSES);
            } else {
                player.getPacketSender().sendMessage("You sense a surge of purity flow through your body!");
                player.setPrayerbook(Prayerbook.NORMAL);
            }
            player.getPacketSender().sendTabInterface(GameSettings.PRAYER_TAB, player.getPrayerbook().getInterfaceId());
            PrayerHandler.deactivateAll(player);
            CurseHandler.deactivateAll(player);
        }


        if (command[0].equalsIgnoreCase("help")) {
            if (player.getLastYell().elapsed(30000)) {
                if (player.getLocation() != null && player.getLocation() == Location.WILDERNESS
                        || player.getLocation() != null && player.getLocation() == Location.CUSTOM_RAIDS) {
                    World.sendStaffMessage("<col=FF0066><img=5> [TICKET SYSTEM]<col=6600FF> " + player.getUsername()
                            + " has requested help, but is @red@*IN LEVEL " + player.getWildernessLevel()
                            + " WILDERNESS*<col=6600FF>. Be careful.");
                }
                if (PlayerPunishment.muted(player.getUsername()) || PlayerPunishment.IPMuted(player.getHostAddress())) {
                    World.sendStaffMessage("<col=FF0066><img=5> [TICKET SYSTEM]<col=6600FF> " + player.getUsername()
                            + " has requested help, but is @red@*MUTED*<col=6600FF>. Be careful.");
                } else {
                    World.sendStaffMessage("<col=FF0066><img=5> [TICKET SYSTEM]<col=6600FF> " + player.getUsername()
                            + " has requested help. Please help them!");
                }
                player.getLastYell().reset();
                player.getPacketSender()
                        .sendMessage("<col=663300>Your help request has been received. Please be patient.");
            } else {
                player.getPacketSender().sendMessage("<col=663300>You need to wait 30 seconds before using this again.")
                        .sendMessage(
                                "<col=663300>If it's an emergency, please private message a staff member directly instead.");
            }
        }

        if (command[0].equalsIgnoreCase("empty")) {
            //   DialogueManager.editOptions(523, 1, "Are you sure you would like to empty your items?");
            player.setDialogueActionId(523);
            DialogueManager.start(player, 523);
            return;
        }

        if (command[0].equalsIgnoreCase("players")) {
            int players = World.getPlayers().size() + GameSettings.players;
            PlayersOnlineInterface.showInterface(player);
            player.getPacketSender().sendMessage(
                    "<shad=1>@or1@There are currently @whi@[ @gre@" + (players) + "@whi@ ] @or1@players online!");
        }

        if (command[0].equalsIgnoreCase("droplog")) {
            player.getPacketSender().sendInterfaceRemoval();
            DropLog.open(player);
        }
        if (command[0].equalsIgnoreCase("fly")) {
            if (player.canFly() == false) {
                player.getPacketSender().sendMessage("You do not understand the complexities of flight.");
                return;
            }
            if (player.getLocation() != null && player.getLocation() == Location.WILDERNESS
                    || player.getLocation() != null && player.getLocation() == Location.CUSTOM_RAIDS) {
                player.getPacketSender().sendMessage("You cannot fly in the Wilderness.");
                return;
            }
            if (player.canFly() && player.isFlying()) {
                player.getPacketSender().sendMessage("You stop flying.");
                player.setFlying(false);
                player.newStance();
                return;
            }
            if (player.canFly() && player.isFlying() == false) {
                player.getPacketSender().sendMessage("You begin flying.");
                player.setFlying(true);
                player.newStance();
                return;
            }
            return;
        }
        if (command[0].equalsIgnoreCase("ghostwalk") || command[0].equalsIgnoreCase("ghost")) {
            if (player.canGhostWalk() == false) {
                player.getPacketSender().sendMessage("You do not understand the complexities of death.");
                return;
            }
            if (player.getLocation() != null && player.getLocation() == Location.WILDERNESS
                    || player.getLocation() != null && player.getLocation() == Location.CUSTOM_RAIDS) {
                player.getPacketSender().sendMessage("You cannot ghost walk in the Wilderness.");
                return;
            }
            if (player.canGhostWalk() && player.isGhostWalking()) {
                player.getPacketSender().sendMessage("You stop ghost-walking.");
                player.setGhostWalking(false);
                player.newStance();
                return;
            }
            if (player.canGhostWalk() && player.isGhostWalking() == false) {
                player.getPacketSender().sendMessage("You begin ghost walking.");
                player.setGhostWalking(true);
                player.newStance();
                return;
            }
            return;
        }
    }


    public static void resetInterface(Player player) {
        for (int i = 8145; i < 8196; i++)
            player.getPacketSender().sendString(i, "");
        for (int i = 12174; i < 12224; i++)
            player.getPacketSender().sendString(i, "");
        player.getPacketSender().sendString(8136, "Close window");
    }

    private static void memberCommands(final Player player, String[] command, String wholeCommand) {

        if (wholeCommand.toLowerCase().startsWith("yell")) {
            if (PlayerPunishment.muted(player.getUsername()) || PlayerPunishment.IPMuted(player.getHostAddress())) {
                player.getPacketSender().sendMessage("You are muted and cannot yell.");
                return;
            }
            if (player.getAmountDonated() < Store.SAPPHIRE_DONATION_AMOUNT && !(player.getRights().isStaff() || player.getRights() == PlayerRights.YOUTUBER)) {
                player.getPacketSender().sendMessage("You need to be a Donator to yell.");
                return;
            }
            int delay = player.getRights().isStaff() ? 0 : player.getRights().getYellDelay();
            if (!player.getLastYell().elapsed((delay * 1000))) {
                player.getPacketSender().sendMessage("You must wait at least " + delay + " seconds between every yell-message you send.");
                return;
            }
            String yellMessage = Misc.capitalizeJustFirst(wholeCommand.substring(5));

            String[] invalid = {"<img="};
            for (String s : invalid) {
                if (yellMessage.contains(s)) {
                    player.getPacketSender().sendMessage("Your message contains invalid characters.");
                    return;
                }
            }

            World.sendYellMessage("" + player.getRights().getYellPrefix()
                    + "<img=" + player.getRights().ordinal()
                    + "><col=" + player.getRights().getYellPrefix() +
                    " [" + Misc.ucFirst(player.getRights().name().replaceAll("_", " ")) + "]<shad=0><col=" + player.getYellHex() + "> " + player.getUsername() +
                    ": " + yellMessage);

            // World.sendMessage(":yell:" + yell);
            player.getLastYell().reset();
            return;
        }
    }

    private static void youtuberCommands(final Player player, String[] command, String wholeCommand) throws IOException {

        if (command[0].equalsIgnoreCase("live")) {
            if (player.getUsername().equalsIgnoreCase("wrecked")) {
                YoutubeData.WRECKEDYOU.setLive(true);
                World.sendMessage("<img=10>@red@ " + YoutubeData.WRECKEDYOU.getName() + " @yel@<shad=1>is now live on Youtube, type @red@::youtube @yel@to claim a Creator box & watch!");
                YoutubeData.clear();
                return;
            }
        }

        if (command[0].equalsIgnoreCase("offline")) {
            if (player.getUsername().equalsIgnoreCase("wrecked")) {
                YoutubeData.WRECKEDYOU.setLive(false);
                World.sendMessage("<img=10>@red@ " + YoutubeData.WRECKEDYOU.getName() + " @yel@<shad=1>is now @red@offline @yel@thanks for the love and support!");
                YoutubeData.clear();
                return;
            }
        }


        if (command[0].equalsIgnoreCase("live")) {
            if (player.getUsername().equalsIgnoreCase("inherited")) {
                YoutubeData.INHERITED.setLive(true);
                World.sendMessage("<img=10>@red@ " + YoutubeData.INHERITED.getName() + " @yel@<shad=1>is now live on Youtube, type @red@::youtube @yel@to claim a Creator box & watch!");
                YoutubeData.clear();
                return;
            }
        }

        if (command[0].equalsIgnoreCase("offline")) {
            if (player.getUsername().equalsIgnoreCase("inherited")) {
                YoutubeData.INHERITED.setLive(false);
                World.sendMessage("<img=10>@red@ " + YoutubeData.INHERITED.getName() + " @yel@<shad=1>is now @red@offline @yel@thanks for the love and support!");
                YoutubeData.clear();
                return;
            }
        }

        if (command[0].equalsIgnoreCase("live")) {
            if (player.getUsername().equalsIgnoreCase("walkchaos") && !YoutubeData.WALKCHAOS.getLive()) {
                YoutubeData.WALKCHAOS.setLive(true);
                World.sendMessage("<img=10>@red@ " + YoutubeData.WALKCHAOS.getName() + " @yel@<shad=1>is now live on Youtube, type @red@::youtube @yel@to claim a Creator box & watch!");
                YoutubeData.clear();
                return;
            }
        }

        if (command[0].equalsIgnoreCase("offline")) {
            if (player.getUsername().equalsIgnoreCase("walkchaos")&& YoutubeData.WALKCHAOS.getLive()) {
                YoutubeData.WALKCHAOS.setLive(false);
                World.sendMessage("<img=10>@red@ " + YoutubeData.WALKCHAOS.getName() + " @yel@<shad=1>is now @red@offline @yel@thanks for the love and support!");
                YoutubeData.clear();
                return;
            }
        }

        if (command[0].equalsIgnoreCase("live")) {
            if (player.getUsername().equalsIgnoreCase("celestial")) {
                YoutubeData.CELESTIAL.setLive(true);
                World.sendMessage("<img=10>@red@ " + YoutubeData.CELESTIAL.getName() + " @yel@<shad=1>is now live on Youtube, type @red@::youtube @yel@to claim a Creator box & watch!");
                YoutubeData.clear();
                return;
            }
        }

        if (command[0].equalsIgnoreCase("offline")) {
            if (player.getUsername().equalsIgnoreCase("celestial")) {
                YoutubeData.CELESTIAL.setLive(false);
                World.sendMessage("<img=10>@red@ " + YoutubeData.CELESTIAL.getName() + " @yel@<shad=1>is now @red@offline @yel@thanks for the love and support!");
                YoutubeData.clear();
                return;
            }
        }




        if (command[0].equalsIgnoreCase("live")) {
            if (player.getUsername().equalsIgnoreCase("lano")) {
                YoutubeData.LANO.setLive(true);
                World.sendMessage("<img=10>@red@ " + YoutubeData.LANO.getName() + " @yel@<shad=1>is now live on Youtube, type @red@::youtube @yel@to claim a Creator box & watch!");
                YoutubeData.clear();
                return;
            }
        }

        if (command[0].equalsIgnoreCase("offline")) {
            if (player.getUsername().equalsIgnoreCase("lano")) {
                YoutubeData.LANO.setLive(false);
                World.sendMessage("<img=10>@red@ " + YoutubeData.LANO.getName() + " @yel@<shad=1>is now @red@offline @yel@thanks for the love and support!");
                YoutubeData.clear();
                return;
            }
        }

    }


    private static void supportCommands(final Player player, String[] command, String wholeCommand) {

        if (command[0].equalsIgnoreCase("checkalt")) {
            Player target = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (target != null) {
                player.sendMessage("Searching...");

                for (Player plr : World.getPlayers()) {
                    if (plr != null) {
                        if (plr.getHostAddress().equals(target.getHostAddress()) && !plr.equals(target)
                                && !plr.getUsername().equalsIgnoreCase("avalon")
                                && !target.getUsername().equalsIgnoreCase("celestial")
                                && !plr.getUsername().equalsIgnoreCase("quill")
                                && !target.getUsername().equalsIgnoreCase("diyos")
                                && !plr.getUsername().equalsIgnoreCase("test")
                                && !target.getUsername().equalsIgnoreCase("divine")) {
                            player.sendMessage(
                                    plr.getUsername() + " has the same Ip address as " + target.getUsername());
                        }
                    }
                }

                player.sendMessage("Done search");
            } else {
                player.sendMessage(wholeCommand.substring(command[0].length() + 1) + " is not valid");
            }
        }

        if (command[0].equalsIgnoreCase("teleto")) {
            String playerToTele = wholeCommand.substring(command[0].length() + 1);
            Player player2 = World.getPlayerByName(playerToTele);
            if (player2 == null) {
                player.getPacketSender().sendMessage("Cannot find that player online..");
                return;
            } else {
                boolean canTele = TeleportHandler.checkReqs(player, player2.getPosition().copy());
                if (canTele) {
                    player.performGraphic(new Graphic(342));

                    TeleportHandler.teleportPlayer(player, player2.getPosition().copy(), TeleportType.ZOOM);
                    player.getPacketSender().sendMessage("Teleporting to player: " + player2.getUsername() + "");
                    player2.performGraphic(new Graphic(730));
                    player2.getPacketSender().sendMessage("<img=5> ATTENTION: <col=6600FF>" + player.getRights() + " " + player.getUsername() + " is teleporting to you.");
                } else
                    player.getPacketSender()
                            .sendMessage("You can not teleport to this player at the moment. Minigame maybe?");
            }
        }
        if (command[0].equalsIgnoreCase("teletome")) {
            String playerToTele = wholeCommand.substring(command[0].length() + 1);
            Player player2 = World.getPlayerByName(playerToTele);
            if (player2 == null) {
                player.getPacketSender().sendMessage("Cannot find that player..");
                return;
            } else {
                boolean canTele = TeleportHandler.checkReqs(player, player2.getPosition().copy());
                if (canTele && player2.getDueling().duelingStatus < 5) {
                    player.getPacketSender().sendMessage("Moving player: " + player2.getUsername() + "");
                    player2.getPacketSender().sendMessage("You've been moved to " + player.getUsername());
                    World.sendStaffMessage("<col=FF0066><img=2> [PUNISHMENTS]<col=6600FF> " + player.getUsername()
                            + " just moved " + player2.getUsername() + " to them.");
                    player2.moveTo(player.getPosition().copy());
                    player2.performGraphic(new Graphic(342));
                } else
                    player.getPacketSender()
                            .sendMessage("Failed to move player to your coords. Are you or them in a minigame?")
                            .sendMessage("Also will fail if they're in duel/wild.");
            }
        }

        if (command[0].equalsIgnoreCase("staffzone")) {
            if (command.length > 1 && command[1].equalsIgnoreCase("all") && player.getRights().OwnerDeveloperOnly()) {
                player.getPacketSender().sendMessage("Teleporting all staff to staffzone.");
                for (Player players : World.getPlayers()) {
                    if (players != null) {
                        if (players.getRights().isStaff()) {
                            TeleportHandler.teleportPlayer(players, new Position(3168, 4124), TeleportType.NORMAL);
                        }
                    }
                }
            } else {
                TeleportHandler.teleportPlayer(player, new Position(3168, 4124), TeleportType.NORMAL);
            }
        }
        if (command[0].equalsIgnoreCase("movehome")) {
            String player2 = wholeCommand.substring(command[0].length() + 1);
            Player playerToMove = World.getPlayerByName(player2);
            if (playerToMove != null && playerToMove.getDueling().duelingStatus < 5) {
                if (playerToMove.getLocation() == Location.WILDERNESS) {
                    PlayerLogs.log(player.getUsername(), "Just moved " + playerToMove.getUsername()
                            + " to home from level " + playerToMove.getWildernessLevel() + " wild.");
                } else {
                    PlayerLogs.log(player.getUsername(), "Just moved " + playerToMove.getUsername() + " to home.");
                }
                playerToMove.getControllerManager().forceStop();
                playerToMove.moveTo(GameSettings.DEFAULT_POSITION.copy());
                playerToMove.getPacketSender()
                        .sendMessage("You've been teleported home by " + player.getUsername() + ".");
                player.getPacketSender().sendMessage("Successfully moved " + playerToMove.getUsername() + " to home.");
                World.sendStaffMessage("<col=FF0066><img=2> [PUNISHMENTS]<col=6600FF> " + player.getUsername()
                        + " just moved " + playerToMove.getUsername() + " to home.");
                player.performGraphic(new Graphic(730));
                playerToMove.performGraphic(new Graphic(730));
            } else {
                player.getPacketSender().sendMessage("Could not send \"" + player2 + "\" home. Try kicking first?")
                        .sendMessage("Will also fail if they're in duel/wild.");
            }
        }
        if (command[0].equalsIgnoreCase("unmute")) {
            String player2 = wholeCommand.substring(command[0].length() + 1);
            if (player2 == null) {
                player.getPacketSender().sendMessage("Player " + player2 + " does not exist.");
                return;
            } else {
                if (!PlayerPunishment.muted(player2)) {
                    player.getPacketSender().sendMessage("Player " + player2 + " is not muted!");
                    return;
                }
                PlayerLogs.log(player.getUsername(), player.getUsername() + " just unmuted " + player2 + "!");
                World.sendStaffMessage("<col=FF0066><img=2> [PUNISHMENTS]<col=6600FF> " + player.getUsername()
                        + " just unmuted " + player2);
                PlayerPunishment.unmute(player2);
                player.getPacketSender()
                        .sendMessage("Player " + player2 + " was successfully unmuted. Command logs written.");
                Player plr = World.getPlayerByName(player2);
                if (plr != null) {
                    plr.getPacketSender().sendMessage("You have been unmuted by " + player.getUsername() + ".");
                }
            }
        }
        if (command[0].equalsIgnoreCase("kick")) {
            String player2 = wholeCommand.substring(command[0].length() + 1);
            Player playerToKick = World.getPlayerByName(player2);
            if (playerToKick == null) {
                player.getPacketSender()
                        .sendMessage("Player " + player2 + " couldn't be found on " + GameSettings.RSPS_NAME + ".");
                return;
            } else if (playerToKick.getDueling().duelingStatus < 5) {
                //PlayerHandler.handleLogout(playerToKick, false);
                playerToKick.save();
                World.getPlayers().remove(playerToKick);
                player.getPacketSender().sendMessage("Kicked " + playerToKick.getUsername() + ".");
                PlayerLogs.log(player.getUsername(),
                        player.getUsername() + " just kicked " + playerToKick.getUsername() + "!");
                World.sendStaffMessage("<col=FF0066><img=2> [PUNISHMENTS]<col=6600FF> " + player.getUsername()
                        + " just kicked " + playerToKick.getUsername() + ".");
                player.getPacketSender().sendMessage("You can try ::kick2 if this command didn't work.");
            } else {
                PlayerLogs.log(player.getUsername(), player.getUsername() + " just tried to kick "
                        + playerToKick.getUsername() + " in an active duel.");
                World.sendStaffMessage("<col=FF0066><img=2> [PUNISHMENTS]<col=6600FF> " + player.getUsername()
                        + " just tried to kick " + playerToKick.getUsername() + " in an active duel.");
                player.getPacketSender().sendMessage("You've tried to kick someone in duel arena/wild. Logs written.");
            }
        }
        if (command[0].equalsIgnoreCase("kill")) {
            String player2 = wholeCommand.substring(command[0].length() + 1);
            Player playerToKick = World.getPlayerByName(player2);
            if (playerToKick == null) {
                player.getPacketSender()
                        .sendMessage("Player " + player2 + " couldn't be found on " + GameSettings.RSPS_NAME + ".");
                return;
            } else if (playerToKick.getDueling().duelingStatus < 5) {
                playerToKick.setConstitution(0);
                //PlayerHandler.handleLogout(playerToKick, false);
            } else {
                playerToKick.setConstitution(0);
            }
        }
        if (command[0].equalsIgnoreCase("kick2")) {
            String player2 = wholeCommand.substring(command[0].length() + 1);
            Player playerToKick = World.getPlayerByName(player2);
            if (playerToKick == null) {
                player.getPacketSender()
                        .sendMessage("Player " + player2 + " couldn't be found on " + GameSettings.RSPS_NAME + ".");
                return;
            } else if (playerToKick.getDueling().duelingStatus < 5) {
                World.getPlayers().remove(playerToKick);
                player.getPacketSender().sendMessage("Kicked " + playerToKick.getUsername() + ".");
                PlayerLogs.log(player.getUsername(),
                        player.getUsername() + " just kicked " + playerToKick.getUsername() + "!");
                World.sendStaffMessage("<col=FF0066><img=2> [PUNISHMENTS]<col=6600FF> " + player.getUsername()
                        + " just kicked " + playerToKick.getUsername() + ".");
            } else {
                PlayerLogs.log(player.getUsername(), player.getUsername() + " just tried to kick "
                        + playerToKick.getUsername() + " in an active duel.");
                World.sendStaffMessage("<col=FF0066><img=2> [PUNISHMENTS]<col=6600FF> " + player.getUsername()
                        + " just tried to kick " + playerToKick.getUsername() + " in an active duel.");
                player.getPacketSender().sendMessage("You've tried to kick someone in duel arena/wild. Logs written.");
            }
        }

        if (command[0].equalsIgnoreCase("mute")) {
            try {
                String[] time = command[1].split("h");
                Long timer = Long.parseLong(time[0]);
                String target = wholeCommand.substring(command[0].length() + command[1].length() + 2);

                String fileName = Misc.formatText(target.toLowerCase());
                File file = new File("./data/saves/characters/" + fileName + ".json");
                if (!file.exists()) {
                    Player targetPlayer = World.getPlayerByName(target);
                    if (targetPlayer != null) {
                        targetPlayer.save();
                    } else {
                        player.getPacketSender().sendMessage(fileName + " does not exist in my files, " +
                                "maybe you typed it wrong!");
                        return;
                    }
                }
                if (PlayerPunishment.muted(target)) {
                    player.getPacketSender().sendMessage("Player: " + target + " already has an active mute.");
                    return;
                }
                PlayerLogs.log(player.getUsername(), player.getUsername() + " just muted " + target + " for " + command[2] + "!");
                World.sendStaffMessage("<col=FF0066><img=2> [PUNISHMENTS]<col=6600FF> " + player.getUsername()
                        + " just muted " + target + " for " + command[2] + ".");
                PlayerPunishment.mute(target, LocalDateTime.now().plusHours(timer));//* , GameSettings.Temp_Mute_Time); *//*
                player.getPacketSender().sendMessage("Player " + target + " was successfully muted for " + command[2] + ".");// for
                Player plr = World.getPlayerByName(target);
                if (plr != null) {
                    plr.getPacketSender().sendMessage("You have been muted by " + player.getUsername() + " for " + command[2] + "."); // for
                }
                /*if (World.getPlayerByName(target) == null) {
                    String fileName = Misc.formatText(target.toLowerCase());
                    File file = new File("./data/saves/characters/" + fileName + ".json");
                    if (file.exists()) {
                        if (PlayerPunishment.muted(target)) {
                            player.getPacketSender().sendMessage("Player: " + target + " already has an active mute.");
                            return;
                        }
                        PlayerLogs.log(player.getUsername(), player.getUsername() + " just muted " + target + "!");
                        World.sendStaffMessage("<col=FF0066><img=2> [PUNISHMENTS]<col=6600FF> " + player.getUsername()
                                + " just muted " + target);
                        PlayerPunishment.mute(target, LocalDateTime.now().plusHours(timer));
                        player.getPacketSender().sendMessage("Player " + target + " was successfully muted");// for
                        Player plr = World.getPlayerByName(target);
                        if (plr != null) {
                            plr.getPacketSender().sendMessage("You have been muted by " + player.getUsername() + "."); // for
                        }
                    } else {
                        player.getPacketSender().sendMessage(fileName + " does not exist in my files, " +
                                "maybe you typed it wrong!");
                    }
                    return;
                } else {
                    if (PlayerPunishment.muted(target)) {
                        player.getPacketSender().sendMessage("Player: " + target + " already has an active mute.");
                        return;
                    }
                    PlayerLogs.log(player.getUsername(), player.getUsername() + " just muted " + target + "!");
                    World.sendStaffMessage("<col=FF0066><img=2> [PUNISHMENTS]<col=6600FF> " + player.getUsername()
                            + " just muted " + target);
                    PlayerPunishment.mute(target, LocalDateTime.now().plusHours(timer));*//* , GameSettings.Temp_Mute_Time); *//*
                    player.getPacketSender().sendMessage("Player " + target + " was successfully muted");// for
                    Player plr = World.getPlayerByName(target);
                    if (plr != null) {
                        plr.getPacketSender().sendMessage("You have been muted by " + player.getUsername() + "."); // for
                    }
                }*/
            } catch (Exception e) {
                player.getPacketSender().sendMessage("Error! Usage ::mute 6h username");
            }
        }


        if (command[0].equalsIgnoreCase("jail")) {
            String target = command[1];//wholeCommand.substring(command[0].length() + 1);
            String[] time = command[2].split("h");
            Long timer = Long.parseLong(time[0]);
            if (Jail.isJailed(target)) {
                player.getPacketSender().sendMessage("Player: " + target + " is already jailed.");
                return;
            }
            Player player2 = World.getPlayerByName(target);
            if (player2 != null) {
                if (player2.getDueling().duelingStatus == 0) {
                    Jail.jailPlayer(target, LocalDateTime.now().plusHours(timer));
                    player2.getSkillManager().stopSkilling();
                    PlayerLogs.log(player.getUsername(),
                            player.getUsername() + " just jailed " + player2.getUsername() + "!");
                    player.getPacketSender().sendMessage("Jailed player: " + player2.getUsername());
                    player2.getPacketSender().sendMessage("You have been jailed by " + player.getUsername() + ".");
                    player2.getPacketSender().sendMessage("You will have to wait" + timer + " hours to be unjailed.");
                    World.sendStaffMessage("<col=FF0066><img=2> [PUNISHMENTS]<col=6600FF> " + player.getUsername()
                            + " just jailed " + player2.getUsername());
                    player2.performAnimation(new Animation(1994));
                    player.performGraphic(new Graphic(730));
                    player2.moveTo(new Position(2510, 9326));
                    player2.setLocation(Location.JAIL);
                } else {
                    if (player2.getDueling().duelingStatus > 0) {
                        player.getPacketSender().sendMessage(
                                "That player is currently in a stake. Please wait before jailing them, or kick then jail.");
                        return;
                    } else {
                        player.getPacketSender().sendMessage("This shouldn't happen, message Crimson. Error: JAIL45");
                    }
                }
            }
        }
        if (command[0].equalsIgnoreCase("unjail")) {
            Player player2 = World
                    .getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 != null) {
                if (true) {
                    Jail.unJail(player2.getUsername());
                    PlayerLogs.log(player.getUsername(),
                            "" + player.getUsername() + " just unjailed " + player2.getUsername() + "!");
                    player.getPacketSender().sendMessage("Unjailed player: " + player2.getUsername() + "");
                    player2.getPacketSender().sendMessage("You have been unjailed by " + player.getUsername() + ".");
                    World.sendStaffMessage("<col=FF0066><img=2> [PUNISHMENTS]<col=6600FF> " + player.getUsername()
                            + " just unjailed " + player2.getUsername());
                    player2.performAnimation(new Animation(1993));
                    player.performGraphic(new Graphic(730));
                }
            } else {
                player.getPacketSender().sendMessage("Could not find \""
                        + wholeCommand.substring(command[0].length() + 1) + "\" online.");
            }
        }


        if (command[0].equalsIgnoreCase("remindvote")) {
            World.sendMessage(
                    "<img=5> <col=008FB2><shad=0>Remember to collect rewards by using the ::vote command every 12 hours!");
        }
        if (command[0].equalsIgnoreCase("remindafk")) {
            World.sendMessage(
                    "<img=5> <col=008FB2><shad=0>Remember! You can put up to an account in the ::Afk zone! Get yourself some free items!");
        }
        if (command[0].equalsIgnoreCase("reminddonate")) {
            World.sendMessage("<img=5> <col=008FB2><shad=0>Remember to check out the donation deals in our ::discord!");
        }
        if (command[0].equalsIgnoreCase("remindhelp")) {
            World.sendMessage(
                    "<img=5> <col=008FB2><shad=0>Staff members are always available, pm them if you need help!");
        }

    }

    private static void globalModCommands(final Player player, String[] command, String wholeCommand) {


        if (command[0].equalsIgnoreCase("permban") || command[0].equalsIgnoreCase("permaban")) {
            try {
                Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
                if (player2 == null) {
                    player.getPacketSender().sendMessage("Target does not exist. Unable to permban.");
                    return;
                }

                String uuid = player2.getSerialNumber();
                String mac = player2.getMac();
                String name = player2.getUsername();
                String bannedIP = player2.getHostAddress();

                World.sendStaffMessage("Perm banned " + name + " (" + bannedIP + "/" + mac + "/" + uuid + ")");
                PlayerLogs.log(player.getUsername(), "Has perm banned: " + name + "!");
                PlayerLogs.log(name, player + " perm banned: " + name + ".");

                PlayerPunishment.addBannedIP(bannedIP);
                ConnectionHandler.banUUID(name, uuid);
                ConnectionHandler.banMac(name, mac);
                PlayerPunishment.ban(name, LocalDateTime.now().plusHours(PlayerPunishment.MAX_HOURS));

                if (player2 != null) {
                    World.deregister(player2);
                }

                for (Player playersToBan : World.getPlayers()) {
                    if (playersToBan == null)
                        continue;
                    if (playersToBan.getHostAddress() == bannedIP || playersToBan.getSerialNumber() == uuid
                            || playersToBan.getMac() == mac) {
                        PlayerLogs.log(player.getUsername(),
                                player.getUsername() + " just caught " + playersToBan.getUsername() + " with permban!");
                        PlayerLogs.log(name, player + " perm banned: " + name + ", we were crossfire.");
                        World.sendStaffMessage(playersToBan.getUsername() + " was banned as well.");
                        PlayerPunishment.ban(playersToBan.getUsername(), LocalDateTime.now().plusHours(PlayerPunishment.MAX_HOURS));
                        World.deregister(playersToBan);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void moderatorCommands(final Player player, String[] command, String wholeCommand) {

        if (command[0].equalsIgnoreCase("kickgi")) {
            Player target = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (target == null) {
                player.getPacketSender().sendConsoleMessage("Player must be online to kick them from their group!");
            } else {
                player.getPacketSender().sendConsoleMessage("Kicked " + target.getUsername() + " from their ironman group.");
                if (target.getIronmanGroup() != null){
                    target.getIronmanGroup().kickPlayer(player, target.getUsername());
                }else{
                    player.getPacketSender().sendConsoleMessage("Player is not in a ironman group!");
                }
            }
        }

        if (command[0].equalsIgnoreCase("invisible")) {
            player.setVisible(!player.isVisible());
            player.sendMessage("You are now " + (player.isVisible() ? "visible" : "invisible"));
        }
        if (command[0].equalsIgnoreCase("broadcast")) {
            int time = Integer.parseInt(command[1]);
            String message = wholeCommand.substring(command[0].length() + command[1].length() + 2);
            for (Player players : World.getPlayers()) {
                if (players == null) {
                    continue;
                }
                players.getPacketSender().sendBroadCastMessage(message, time);
            }
            World.sendBroadcastMessage(message);
            GameSettings.broadcastMessage = message;
            GameSettings.broadcastTime = time;
        }

        if (command[0].equalsIgnoreCase("unban")) {
            String playerToBan = wholeCommand.substring(6);
            if (!PlayerSaving.playerExists(playerToBan)) {
                player.getPacketSender().sendMessage("Player " + playerToBan + " does not exist.");
                return;
            } else {
                if (!PlayerPunishment.banned(playerToBan)) {
                    player.getPacketSender().sendMessage("Player " + playerToBan + " is not banned!");
                    return;
                }
                PlayerLogs.log(player.getUsername(), "" + player.getUsername() + " just unbanned " + playerToBan + "!");
                World.sendStaffMessage("<col=FF0066><img=2> [PUNISHMENTS]<col=6600FF> " + player.getUsername()
                        + " just unbanned " + playerToBan + ".");
                PlayerPunishment.unban(playerToBan);
                player.getPacketSender()
                        .sendMessage("Player " + playerToBan + " was successfully unbanned. Command logs written.");
            }
        }

        if (command[0].equalsIgnoreCase("ban")) {
            String playerToBan = command[1];//wholeCommand.substring(command[0].length() + 1);
            String[] time = command[2].split("h");
            Long timer = Long.parseLong(time[0]);
            if (PlayerPunishment.banned(playerToBan)) {
                player.getPacketSender().sendMessage("Player " + playerToBan + " already has an active ban.");
                return;
            }
            PlayerLogs.log(player.getUsername(), player.getUsername() + " just banned " + playerToBan + " for " + command[2] + "!");
            PlayerPunishment.ban(playerToBan, LocalDateTime.now().plusHours(timer));
            player.getPacketSender()
                    .sendMessage("Player " + playerToBan + " was successfully banned for " + command[2] + ". Command logs written.");
            World.sendStaffMessage("<col=FF0066><img=2> [PUNISHMENTS]<col=6600FF> " + player.getUsername()
                    + " just banned " + playerToBan + " for " + command[2] + ".");
            Player toBan = World.getPlayerByName(playerToBan);
            if (toBan != null) {
                World.deregister(toBan);
            }
        }

    }

    private static void administratorCommands(final Player player, String[] command, String wholeCommand) {

        if (command[0].equalsIgnoreCase("addv")) {
            int amt = Integer.parseInt(command[1]);
            doMotivote.setVoteCount(doMotivote.getVoteCount() + amt);
            if (doMotivote.getVoteCount() >= 40) {
                VoteBossDrop.handleSpawn();
            }

        }

        if (command[0].equalsIgnoreCase ("make")) {
            int id = Integer.parseInt(command[1]);
            player.getPacketSender().sendMessage("Sending animation: " + id);
            String plrName = wholeCommand.substring(command[0].length() + command[1].length()+ 2);
            Player target = World.getPlayerByName(plrName);
            target.performAnimation(new Animation(id));
            player.getPacketSender().sendMessage("Sending animation: " + id + " to player " + plrName);
        }

        if (command[0].equalsIgnoreCase("checkbank")) {
            Player plr = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (plr != null) {
                player.getPacketSender().sendMessage("Loading bank..");
                plr.getBank(0).openOther(player, true, false);
            } else {
                player.getPacketSender().sendMessage("Player is offline!");
            }
        }
        if (command[0].equalsIgnoreCase("check")) {
            Player plr = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (plr != null) {
                player.getPacketSender().sendMessage("Showing bank and inventory of " + plr.getUsername() + "...");
                plr.getBank(0).openOther(player, true, false);
                player.getPacketSender().sendInterfaceSet(5292, 3321);
                player.getPacketSender().sendItemContainer(plr.getInventory(), 3322);
            } else {
                player.getPacketSender().sendMessage("Player is offline!");
            }
        }
        if (command[0].equalsIgnoreCase("checkinv")) {
            Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 == null) {
                player.getPacketSender().sendMessage("Cannot find that player online..");
                return;
            }
            player.getPacketSender().sendItemContainer(player2.getInventory(), 3214);
        }
        if (command[0].equalsIgnoreCase("endcheck")) {
            player.getInventory().refreshItems();
        }

        if (command[0].equalsIgnoreCase("getrefers")
                || command[0].equalsIgnoreCase("getrefer")
                || command[0].equalsIgnoreCase("getref")
                || command[0].equalsIgnoreCase("getrefs")) {
            if (command.length == 1) {
                player.sendMessage("Referral tallies:");
                List<String> referrals = EnterReferral.getReferrals();
                if (referrals != null) {
                    for (String line : referrals) {
                        player.sendMessage(line);
                    }
                }
            } else {
                String refer = wholeCommand.substring(command[0].length() + 1);

                player.sendMessage("Referral tallies:");
                List<String> referrals = EnterReferral.getReferrals();
                if (referrals != null) {
                    for (String line : referrals) {
                        if (line.split(" : ")[0].equalsIgnoreCase(refer))
                            player.sendMessage(line);
                    }
                }
            }
        }


        if (command[0].equalsIgnoreCase("myregion")) {
            player.sendMessage("Current Region: " + player.getPosition().getRegionId());
            player.sendMessage("Usage: ::myregion regionid");
        }
        if (command[0].equalsIgnoreCase("region")) {
            try {
                int region = Integer.parseInt(command[1]);
                int x = (region >> 8) * 64 + 32;
                int y = (region & 0xFF) * 64 + 32;
                player.sendMessage("region: " + region);
                TeleportHandler.teleportPlayer(player, new Position(x, y), TeleportType.NORMAL);
            } catch (NumberFormatException e) {
                player.sendMessage("Usage: ::region regionid");
                return;
            }
        }
        if (command[0].equalsIgnoreCase("x2vote")) {
            int time = Integer.parseInt(command[1]);
            if (time > 0) {
                GameServer.setUpdating(true);
                World.sendStaffMessage("<col=FF0066><img=2> [PUNISHMENTS]<col=6600FF> " + player.getUsername()
                        + " just started an vote event for " + time + " minutes.");
                World.getPlayers().forEach(p -> p.getPacketSender().sendMessage("Alert##Notification##-1##450##40##5310729##125##" +
                        "x2 Vote Event Active for " + time + " minutes!" + "##By: " + player.getUsername() + "## ##"));

                TaskManager.submit(new Task(time * 100) {
                    @Override
                    protected void execute() {
                        World.getPlayers().forEach(p -> p.getPacketSender().sendMessage("Alert##Notification##-1##450##40##5310729##125##" +
                                "x2 Vote Event Ended!" + "##---## ##"));
                        stop();
                    }
                });
            }
        }
        if (command[0].equalsIgnoreCase("clicktele")) {
            player.setClickToTeleport(!player.isClickToTeleport());
            player.getPacketSender().sendMessage("Click to teleport set to: " + player.isClickToTeleport() + ".");
        }
        if (command[0].equalsIgnoreCase("customevent")) {
            player.getEventBossManager().display();
        }

        if (command[0].equalsIgnoreCase("resetduo")) {
            if (player.getSlayer().getDuoPartner () != null)
                Slayer.resetDuo (player, World.getPlayerByName (player.getSlayer ().getDuoPartner ()));
             else
                player.sendMessage ("<img=5> You do not have a duo partner!");

        }

        if (command[0].equalsIgnoreCase("addn")) {
            NPCSpawn spawn = new NPCSpawn(Integer.parseInt(command[1]), Direction.SOUTH, player.getPosition());
            NPC.spawns.add(spawn);
            try (Writer writer = new FileWriter("./data/def/json/world_npcs_new.json")) {
                Gson gson = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting()
                        .create();
                gson.toJson(NPC.spawns, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            NPC npc = new NPC(spawn.npcId, spawn.position);
            World.register(npc);
        }

        if (command[0].equalsIgnoreCase("rlspawns")) {
            NPC.init();
        }

        if (command[0].equalsIgnoreCase("mypos") || command[0].equalsIgnoreCase("coords")
                || command[0].equalsIgnoreCase("c")) {
            player.getPacketSender().sendMessage(player.getPosition().toString());
        }
        if (command[0].equalsIgnoreCase("getpos")) {
            Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 == null) {
                player.getPacketSender().sendMessage("Could not find that player online.");
                return;
            } else {
                player.getPacketSender().sendMessage("[@red@" + player2.getUsername() + "@bla@] "
                        + player2.getPosition().toString() + " @red@| @bla@Location: " + player2.getLocation());
            }
        }
        if (command[0].equalsIgnoreCase("wpos")) {
            // System.out.println(player.getPosition().toString());
        }

        if (command[0].equalsIgnoreCase("teler")) {
            int regionid = Integer.parseInt(command[1]);
            Position position = new Position((regionid >> 8 << 6) + 32, ((regionid & 0xff) << 6) + 32);
            player.moveTo(position);
            player.getPacketSender().sendConsoleMessage("Teleporting to " + position.toString());
        }

        if (command[0].equalsIgnoreCase("tele")) {
            int x = Integer.valueOf(command[1]), y = Integer.valueOf(command[2]);
            int z = player.getPosition().getZ();
            if (command.length > 3)
                z = Integer.valueOf(command[3]);
            Position position = new Position(x, y, z);
            player.moveTo(position);
            player.getPacketSender().sendMessage("Teleporting to " + position.toString());
        }
        if (command[0].equalsIgnoreCase("isob")) {
            player.getPacketSender().sendMessage(
                    "Are you on a custom object? " + CustomObjects.objectExists(player.getPosition().copy()));
        }
        if (command[0].equalsIgnoreCase("ipban")) {
            Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 == null) {
                player.getPacketSender().sendMessage("Could not find that player online.");
                return;
            } else {
                if (PlayerPunishment.IPBanned(player2.getHostAddress())) {
                    player.getPacketSender()
                            .sendMessage("Player " + player2.getUsername() + "'s IP is already banned.");
                    return;
                }
                final String bannedIP = player2.getHostAddress();
                PlayerPunishment.ban(player2.getUsername(), LocalDateTime.now().plusHours(PlayerPunishment.MAX_HOURS));
                PlayerPunishment.addBannedIP(bannedIP);
                player.getPacketSender().sendMessage(
                        "Player " + player2.getUsername() + "'s IP was successfully banned. Command logs written.");
                World.sendStaffMessage("<col=FF0066><img=2> [PUNISHMENTS]<col=6600FF> " + player.getUsername()
                        + " just IP Banned " + player2.getUsername());
                for (Player playersToBan : World.getPlayers()) {
                    if (playersToBan == null)
                        continue;
                    if (playersToBan.getHostAddress() == bannedIP) {
                        PlayerLogs.log(player.getUsername(),
                                "" + player.getUsername() + " just IPBanned " + playersToBan.getUsername() + "!");
                        PlayerPunishment.ban(playersToBan.getUsername(), LocalDateTime.now().plusHours(PlayerPunishment.MAX_HOURS));
                        World.deregister(playersToBan);
                        if (player2.getUsername() != playersToBan.getUsername())
                            player.getPacketSender().sendMessage("Player " + playersToBan.getUsername()
                                    + " was successfully IPBanned. Command logs written.");
                    }
                }
            }
        }
        if (command[0].equalsIgnoreCase("unipmute")) {
            player.getPacketSender().sendMessage("Unipmutes can only be handled manually.");
        }
        if (command[0].equalsIgnoreCase("trio")) {
            Position position = GameSettings.TRIO_CORDS;
            TeleportHandler.teleportPlayer(player, position, TeleportType.NORMAL);
            player.getPacketSender().sendMessage("Teleporting you to trio!");
        }
        if (command[0].equalsIgnoreCase("KFC")) {
            Position position = GameSettings.KFC_CORDS;
            TeleportHandler.teleportPlayer(player, position, TeleportType.NORMAL);
            player.getPacketSender().sendMessage("Teleporting you to KFC!");
        }
        if (command[0].equalsIgnoreCase("checkpin")) {
            String plr = wholeCommand.substring(command[0].length() + 1);
            Player playr2 = World.getPlayerByName(plr);
            if (playr2 != null) {
                World.sendStaffMessage("<col=FF0066><img=2> [PUNISHMENTS]<col=6600FF> " + player.getUsername()
                        + " just tried to check " + playr2.getUsername() + "'s Security Pin.");
                if (player.getRights().equals(PlayerRights.MODERATOR)
                        && playr2.getRights().equals(PlayerRights.ADMINISTRATOR)
                        || playr2.getRights().equals(PlayerRights.OWNER)) {
                    player.getPacketSender().sendMessage(
                            playr2.getUsername() + " is a higher rank than you. You can't resolve their Security Pin.");
                    return;
                } else if (player.getRights().equals(PlayerRights.ADMINISTRATOR)
                        || playr2.getRights().equals(PlayerRights.OWNER)) {
                    player.getPacketSender().sendMessage(
                            playr2.getUsername() + " is a higher rank than you. You can't resolve their Security Pin.");
                    return;
                }
                player.getPacketSender().sendMessage(playr2.getUsername() + " Pin: " + playr2.getSavedPin());
            } else
                player.getPacketSender().sendMessage("Could not find player: " + plr);
        }
        if (command[0].equalsIgnoreCase("host")) {
            String plr = wholeCommand.substring(command[0].length() + 1);
            Player playr2 = World.getPlayerByName(plr);
            if (playr2 != null) {
                World.sendStaffMessage("<col=FF0066><img=2> [PUNISHMENTS]<col=6600FF> " + player.getUsername()
                        + " just tried to check " + playr2.getUsername() + "'s IP address.");
                if (player.getRights().equals(PlayerRights.MODERATOR)
                        && playr2.getRights().equals(PlayerRights.ADMINISTRATOR)
                        || playr2.getRights().equals(PlayerRights.OWNER)) {
                    player.getPacketSender().sendMessage(
                            playr2.getUsername() + " is a higher rank than you. You can't resolve their IP.");
                    return;
                } else if (player.getRights().equals(PlayerRights.ADMINISTRATOR)
                        || playr2.getRights().equals(PlayerRights.OWNER)) {
                    player.getPacketSender().sendMessage(
                            playr2.getUsername() + " is a higher rank than you. You can't resolve their IP.");
                    return;
                }
                player.getPacketSender().sendMessage(playr2.getUsername() + " ip: " + playr2.getHostAddress()
                        + ", mac: " + playr2.getMac() + ", uuid: " + playr2.getSerialNumber());
                player.getPacketSender().sendString(1, "www.ipaddressden.com/ip/" + playr2.getHostAddress() + ".html"); // http://www.ipaddressden.com/ip/192.168.0.1.html
            } else
                player.getPacketSender().sendMessage("Could not find player: " + plr);
        }
        if (command[0].equalsIgnoreCase("checkgold")) {
            Player p = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (p != null) {
                long gold = 0;
                for (Item item : p.getInventory().getItems()) {
                    if (item != null && item.getId() > 0 && item.tradeable())
                        gold += item.getDefinition().getValue();
                }
                for (Item item : p.getEquipment().getItems()) {
                    if (item != null && item.getId() > 0 && item.tradeable())
                        gold += item.getDefinition().getValue();
                }
                for (int i = 0; i < 9; i++) {
                    for (Item item : p.getBank(i).getItems()) {
                        if (item != null && item.getId() > 0 && item.tradeable())
                            gold += item.getDefinition().getValue();
                    }
                }
                player.getPacketSender().sendMessage(
                        p.getUsername() + " has " + Misc.insertCommasToNumber(String.valueOf(gold)) + " coins.");
            } else
                player.getPacketSender().sendMessage("Can not find player online.");
        }
    }

    private static void ownerCommands(final Player player, String[] command, String wholeCommand) throws IOException {
        if (command[0].equalsIgnoreCase("spawnslayerboss")) {
            SlayerBossSystem.commandSpawnBoss();
        }        if (command[0].equalsIgnoreCase("spawnnm")) {
            NPC npc = new NPC(9017, new Position(2980, 2776,0));
        }
        if (command[0].equalsIgnoreCase("spawnskeleton")) {
            SkeletonWarrior.commandSpawnBoss();
        }
        if (command[0].equalsIgnoreCase ("addmonthly")) {
            int amount = Integer.parseInt(command[1]);
            String plrName = wholeCommand.substring(command[0].length() + command[1].length()+ 2);
            Player target = World.getPlayerByName(plrName);
            target.setMonthlyDonationCount(target.getMonthlyDonationCount () + amount);
            player.getPacketSender ().sendMessage ("You successfully added $"+ amount + " to " + target.getUsername() + "'s monthly donations amount");
        }
        if (command[0].equalsIgnoreCase("eldergods") || command[0].equalsIgnoreCase("eg")) {
            if (player.getLocation() != null && player.getLocation() == Location.WILDERNESS
                    || player.getLocation() != null && player.getLocation() == Location.CUSTOM_RAIDS) {
                player.getPacketSender().sendMessage("You cannot do this at the moment.");
                return;
            }
            TeleportHandler.teleportPlayer(player, ElderGodsData.LOBBY, player.getSpellbook().getTeleportType());
            player.getPacketSender().sendMessage("Teleporting you to Elder Gods Minigame");
        }
        if (command[0].equalsIgnoreCase("loadsp")) {
            PassRewards.init();
            for (Player p : World.getPlayers()) {
                if (p != null)
                    p.getSeasonPass().handleLogin();
            }

        }

        if (command[0].equalsIgnoreCase("spxp")) {
            int amount = Integer.parseInt(command[1]);
            String name = wholeCommand.substring(command[0].length() + command[1].length() + 2);
            Player target = World.getPlayerByName(name);

            if (target == null) {
                player.getPacketSender().sendMessage("Player is not online");
            } else {
                target.getSeasonPass().addExperience(amount);
                player.getPacketSender().sendMessage("Gave " + name + " " + amount + " season pass exp.");
            }
        }
        if (command[0].equalsIgnoreCase("grantm")) {
            player.getSeasonPass().grantMembership();
        }

        if (command[0].equalsIgnoreCase("23521daily")) {
            player.getDailyTaskManager().refresh();
        }
        if (command[0].equalsIgnoreCase("rd")) {
            player.getDailyTaskManager().refresh();
        }
        if (command[0].equalsIgnoreCase("refreshdailyeasy")) {
            player.getDailyTaskManager().refreshTasks(DailyTaskDifficulty.EASY);
        }
        if (command[0].equalsIgnoreCase("refreshdailymedium")) {
            player.getDailyTaskManager().refreshTasks(DailyTaskDifficulty.MEDIUM);
        }
        if (command[0].equalsIgnoreCase("refreshdailyhard")) {
            player.getDailyTaskManager().refreshTasks(DailyTaskDifficulty.HARD);
        }
        if (command[0].equalsIgnoreCase("refreshdailyelite")) {
            player.getDailyTaskManager().refreshTasks(DailyTaskDifficulty.ELITE);
        }
        if (command[0].equalsIgnoreCase("refreshdailymaster")) {
            player.getDailyTaskManager().refreshTasks(DailyTaskDifficulty.MASTER);
        }

        if (command[0].equalsIgnoreCase("tc")) {
            TelosLoot.handleLoot(player, RaidDifficulty.ADVANCED);
            player.getPacketSender().sendMessage("Your rewards were added to your Telos Coffer");
        }
        if (command[0].equalsIgnoreCase ("resetsanta")) {
        player.sendMessage("@red@You managed to claim all the rewards, The Christmas Box has reset");
        player.getEventChestHandler().TIER_1_REWARDS.clear();
        player.getEventChestHandler().TIER_2_REWARDS.clear();
        player.getEventChestHandler().TIMES_ROLLED_TIER_1 = 0;
        player.getEventChestHandler().TIMES_ROLLED_TIER_2 = 0;
        player.getEventChestHandler().generateRewards(player);
        player.getPacketSender().clearChristmasList();
        player.getPacketSender().removeInterface();
        }

        if (command[0].equalsIgnoreCase("addxp")) {
            player.getSeasonPass().addExperience(Integer.parseInt(command[1]));
        }

        if (command[0].equals("rfantasy")) {
            FantasyZone.spawn();
        }
        if (command[0].equals("efantasy")) {
            FantasyZone.gameTicks = 51;
        }
        if (command[0].equalsIgnoreCase("partychest")) {
            PartyChest.startDropParty(player, Integer.parseInt(command[1]), Boolean.parseBoolean(command[2]));
        }
        if (command[0].equalsIgnoreCase("fakevote")) {
            Calendar cal = Calendar.getInstance();
            int day = cal.get(Calendar.DAY_OF_YEAR);
            player.setLastVotedDay(day);
            player.getVotingStreak().vote();
        }
        if (command[0].equalsIgnoreCase("setd")) {
            VotingStreak.setDayInYear(VotingStreak.getDayInYear() + 1);
            player.getVotingStreak().openInterface();
        }
        if (command[0].equals("trav")) {
            TravellingMerchant.dayInYear += 1;
            TravellingMerchant.resetItems();
        }

     /*   if (command[0].equalsIgnoreCase("eventspawn")) {
            HolidayBossEvent.spawn();
        }*/

        if (command[0].equals("trav1")) {
            TravellingMerchant.dayInYear += 1;
            //World.sendNewsMessage("The Traveling merchant restocked his shop with new items!");
            TravellingMerchant.resetItems();
        }
        if (command[0].equalsIgnoreCase("setstreak")) {
            int amount = Integer.parseInt(command[1]) - 1;
            String name = wholeCommand.substring(command[0].length() + command[1].length() + 2);
            Player target = World.getPlayerByName(name);

            if (target == null) {
                player.getPacketSender().sendMessage("Player is not online");
            } else {
                target.getVotingStreak().setCurrentDay(amount);
                target.getVotingStreak().setDaysVoted(new boolean[30]);
                for (int i = 0; i < amount; i++)
                    target.getVotingStreak().getDaysVoted()[i] = true;

                player.getPacketSender().sendMessage("Gave " + name + " " + (amount + 1) + " voting streak.");
            }
        }
        if (command[0].equals("dumpspawns")) {
            for (NPC npc : World.getNpcs()) {
                if (npc == null)
                    continue;
                if (npc.getPosition().getRegionId() == player.getPosition().getRegionId() &&
                        npc.getPosition().getZ() == player.getPosition().getZ()) {
                    int id = npc.getId();
                    Position position = npc.getDefaultPosition();
                    NPCMovementCoordinator.Coordinator coordinator = npc.getMovementCoordinator().getCoordinator();
                    Direction direction = npc.getDirection();
                    Gson builder = new GsonBuilder().setPrettyPrinting().create();
                    JsonObject object = new JsonObject();
                    object.addProperty("npc-id", id);
                    object.add("position", builder.toJsonTree(position.copy().setZ(4)));
                    object.addProperty("face", direction.name());
                    object.add("walking-policy", builder.toJsonTree(coordinator));
                    System.out.println(object + ",");
                }
            }
        }

        if (command[0].equalsIgnoreCase("statdump")) {
            ItemDefinition.dumpItems();
        }

        if (command[0].equalsIgnoreCase("prestige")) {
            player.prestigeInterface.openPrestigeInterface();
        }
        if (command[0].equalsIgnoreCase("spawnhellraiser")) {
            HellraiserSystem.commandSpawnBoss();
        }

        if (command[0].equalsIgnoreCase("spawndoom")) {
            SlayerBossSystem.commandSpawnBoss();
        }
        if (command[0].equalsIgnoreCase("spawnafk")) {
            AfkSystem.executeSpawn();
        }

        if (command[0].equals("spawnvoteboss")) {
            doMotivote.setVoteCount(40);
            VoteBossDrop.handleSpawn();
        }

        if (command[0].equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(command[1]);
            for (NPC npc : World.getNpcs()) {
                if (npc == null)
                    continue;
                if (npc.getId() == id) {
                    World.deregister(npc);
                }
            }
        }

        if (command[0].equalsIgnoreCase("add")) {
            int id = Integer.parseInt(command[1]);
            for (NPC npc : NPC.spawnedWorldsNpcs) {
                if (npc.getId() == id) {
                    NPC newNpc = new NPC(id, npc.getDefaultPosition());
                    newNpc.getMovementCoordinator().setCoordinator(npc.getMovementCoordinator().getCoordinator());
                    newNpc.setDirection(npc.getDirection());
                    World.register(newNpc);
                }
            }
        }

        if (command[0].equalsIgnoreCase("listuntradeables")) {
            Misc.listUntradeables();
        }

        if (command[0].equalsIgnoreCase("rule1")) {
            DiscordMessager.test1("");
        }if (command[0].equalsIgnoreCase("rule2")) {
            DiscordMessager.test2("");
        }if (command[0].equalsIgnoreCase("rule3")) {
            DiscordMessager.test3("");
        }if (command[0].equalsIgnoreCase("rule4")) {
            DiscordMessager.test4("");
        }if (command[0].equalsIgnoreCase("rule5")) {
            DiscordMessager.test5("");
        }if (command[0].equalsIgnoreCase("rule6")) {
            DiscordMessager.test6("");
        }if (command[0].equalsIgnoreCase("rule7")) {
            DiscordMessager.test7("");
        }if (command[0].equalsIgnoreCase("rule8")) {
            DiscordMessager.test8("");
        }if (command[0].equalsIgnoreCase("rule9")) {
            DiscordMessager.test9("");
        }if (command[0].equalsIgnoreCase("rule10")) {
            DiscordMessager.test10("");
        }if (command[0].equalsIgnoreCase("rule11")) {
            DiscordMessager.test11("");
        }if (command[0].equalsIgnoreCase("rule12")) {
            DiscordMessager.test12("");
        }if (command[0].equalsIgnoreCase("rule13")) {
            DiscordMessager.test13("");
        }if (command[0].equalsIgnoreCase("rule14")) {
            DiscordMessager.test14("");
        }if (command[0].equalsIgnoreCase("rule15")) {
            DiscordMessager.test15("");
        }if (command[0].equalsIgnoreCase("rule16")) {
            DiscordMessager.test16("");
        }if (command[0].equalsIgnoreCase("rule17")) {
            DiscordMessager.test17("");
        }if (command[0].equalsIgnoreCase("rule18")) {
            DiscordMessager.test18("");
        }if (command[0].equalsIgnoreCase("dbenefits1")) {
            DiscordMessager.dono1("");
        }if (command[0].equalsIgnoreCase("dbenefits2")) {
            DiscordMessager.dono2("");
        }if (command[0].equalsIgnoreCase("dbenefits3")) {
            DiscordMessager.dono3("");
        }if (command[0].equalsIgnoreCase("dbenefits4")) {
            DiscordMessager.dono4("");
        }if (command[0].equalsIgnoreCase("dbenefits5")) {
            DiscordMessager.dono5("");
        }if (command[0].equalsIgnoreCase("dbenefits6")) {
            DiscordMessager.dono6("");
        }if (command[0].equalsIgnoreCase("dbenefits7")) {
            DiscordMessager.dono7("");
        }if (command[0].equalsIgnoreCase("dbenefits8")) {
            DiscordMessager.dono8("");
        }

        if (command[0].equalsIgnoreCase("resetny")) {
            player.setNewYear2017(0);
            player.getPacketSender().sendMessage("Set setNewYear2017 to: " + player.getNewYear2017());
        }
        if (command[0].equalsIgnoreCase("xmascount")) {
            player.getPacketSender().sendMessage("xmas count; " + player.getChristmas2016());
        }
        if (command[0].equalsIgnoreCase("resetxmas")) {
            player.setchristmas2016(0);
        }
        if (command[0].equalsIgnoreCase("christmas")) {
            // christmas2016.announceChristmas();
            // System.out.println(christmas2016.isChristmas());
        }
        if (command[0].equalsIgnoreCase("olddrops") && command[1] != null) {
            NPCDrops.getDropTable(player, Integer.parseInt(command[1]));
        }
        if (command[0].equalsIgnoreCase("setxmas") && command[1] != null) {
            player.setchristmas2016(Integer.parseInt(command[1]));
            player.getPacketSender().sendMessage("Set Christmas2016 to " + player.getChristmas2016());
        }
        if (command[0].equalsIgnoreCase("easteri")) {
            easter2017.openInterface(player);
        }
        if (command[0].equalsIgnoreCase("easterc")) {
            player.getPacketSender().sendMessage("easter status: " + player.getEaster2017());
        }
        if (command[0].equalsIgnoreCase("seteaster")) {
            int inty = Integer.parseInt(command[1]);
            player.setEaster2017(inty);
            player.getPacketSender().sendMessage("Set your easter to: " + inty);
        }
        if (command[0].equalsIgnoreCase("item")) {
            int id = Integer.parseInt(command[1]);
            if (id > ItemDefinition.getMaxAmountOfItems()) {
                player.getPacketSender().sendMessage(
                        "Invalid item id entered. Max amount of items: " + ItemDefinition.getMaxAmountOfItems());
                return;
            }
            int amount = (command.length == 2 ? 1
                    : Integer.parseInt(command[2].trim().toLowerCase().replaceAll("k", "000").replaceAll("m", "000000")
                    .replaceAll("b", "000000000")));
            if (amount > Integer.MAX_VALUE) {
                amount = Integer.MAX_VALUE;
            }
            Item item = new Item(id, amount);
            player.getInventory().add(item, true);
        }

        if (command[0].equalsIgnoreCase("giveitem")) {
            int id = Integer.parseInt(command[1]);
            int amount = Integer.parseInt(command[2]);
            String plrName = wholeCommand
                    .substring(command[0].length() + command[1].length() + command[2].length() + 3);
            Player target = World.getPlayerByName(plrName);
            if (target == null) {
                player.getPacketSender().sendMessage(plrName + " must be online to give them stuff!");
            } else {
                target.getInventory().add(id, amount);

                DiscordMessager.offerItems("***" +player.getUsername()+ "***"  + " Gave ***" + amount  + "x " + ItemDefinition.forId(id).getName() + " ***to ***" + plrName + "."+ "***" + ". Item: ");
                player.getPacketSender().sendMessage(
                        "Gave " + amount + "x " + ItemDefinition.forId(id).getName() + " to " + plrName + ".");
            }
        }
        if (command[0].equalsIgnoreCase("wipeall")) {
            int id = Integer.parseInt(command[1]);
            int amount = Integer.parseInt(command[2]);
            for (Player players : World.getPlayers()) {
                if (players != null) {
                    for(Bank bank : players.getBanks()) {
                        if(bank.contains(id) && bank.getAmount(id) >= amount) {
                            bank.delete(id, bank.getAmount(id) - (amount / 2));
                            players.sendMessage(
                                    "You have been bank wiped: " + ItemDefinition.forId(id).getName() + " ");

                        }
                    }
                    if(players.getInventory().getAmount(id) >= amount) {
                        players.getInventory().delete(id, players.getInventory().getAmount(id) - (amount / 2));
                        players.sendMessage(
                                "You have been inv wiped: " + ItemDefinition.forId(id).getName() + " ");

                    }
                }
            }
        }
        if (command[0].equalsIgnoreCase("fullwipe")) {
            int id = Integer.parseInt(command[1]);
            for (Player players : World.getPlayers()) {
                if (players != null) {
                    for(Bank bank : players.getBanks()) {
                        if(bank.contains(id)) {
                            bank.delete(id, bank.getAmount(id));
                            players.sendMessage("Your bank has been cleared of " + ItemDefinition.forId(id).getName());

                        }
                    }
                    if(players.getInventory().contains(id)) {
                        players.getInventory().delete(id, players.getInventory().getAmount(id));
                        players.sendMessage("Your inventory has been cleared of " + ItemDefinition.forId(id).getName());
                    }
                    if(players.getEquipment().contains(id)) {
                        players.getEquipment().delete(id, players.getEquipment().getAmount(id));
                        players.sendMessage("Your equipment has been cleared of " + ItemDefinition.forId(id).getName());
                        players.updateAppearance();
                    }
                }
            }
        }
        if (command[0].equalsIgnoreCase("endperk")) {
            ServerPerks.getInstance().end();
        }
        if (command[0].equalsIgnoreCase("setperk")) {
            ServerPerks.getInstance().setPerk(player, Integer.parseInt(command[1]));
        }
        if (command[0].equalsIgnoreCase("giveall")) {
            int id = Integer.parseInt(command[1]);
            int amount = Integer.parseInt(command[2]);
            for (Player players : World.getPlayers()) {
                if (players != null) {
                    players.getInventory().add(id, amount);
                    players.sendMessage(
                            "@red@You have received: @blu@x"+Misc.insertCommasToNumber(amount) + " " + ItemDefinition.forId(id).getName() + " @red@from @blu@" + player.getUsername() +"");
                }
            }
        }

        if (command[0].equalsIgnoreCase("master")) {
            for (Skill skill : Skill.values()) {
                int level = SkillManager.getMaxAchievingLevel(skill);
                player.getSkillManager().setCurrentLevel(skill, level).setMaxLevel(skill, level).setExperience(skill,
                        SkillManager.getExperienceForLevel(level == 120 ? 120 : 99));
            }
            player.getPacketSender().sendMessage("You are now a master of all skills.");
            player.getUpdateFlag().flag(Flag.APPEARANCE);
        }

        if (command[0].equalsIgnoreCase("reset")) {
            for (Skill skill : Skill.values()) {
                int level = skill.equals(Skill.CONSTITUTION) ? 100 : skill.equals(Skill.PRAYER) ? 10 : 1;
                player.getSkillManager().setCurrentLevel(skill, level).setMaxLevel(skill, level).setExperience(skill,
                        SkillManager.getExperienceForLevel(skill == Skill.CONSTITUTION ? 10 : 1));
            }
            player.getPacketSender().sendMessage("Your skill levels have now been reset.");
            player.getUpdateFlag().flag(Flag.APPEARANCE);
        }
        if (command[0].equalsIgnoreCase("rights")) {
            int rankId = Integer.parseInt(command[1]);
            if (player.getUsername().equalsIgnoreCase("server") && rankId != 10) {
                player.getPacketSender().sendMessage("You cannot do that.");
                return;
            }
            // wholeCommand.substring(command[0].length()+2+rankId.length);
            Player target = World
                    .getPlayerByName(wholeCommand.substring(command[0].length() + command[1].length() + 2));
            if (target == null) {
                player.getPacketSender().sendMessage("Player must be online to give them rights!");
            } else {
                target.setRights(PlayerRights.forId(rankId));
                target.getPacketSender().sendMessage("Your player rights have been changed.");
                target.getPacketSender().sendRights();
            }
            // }
        }

        if (command[0].equalsIgnoreCase("startbossevent")) {
            BossEventHandler.assignTasks(Misc.getRandom (5));
        }

        if (command[0].equalsIgnoreCase("endbossevent")) {
            BossEventHandler.forceReset();
        }

        if (command[0].equalsIgnoreCase("bossevent")) {
            BossEventHandler.teleport(player);
        }

        if (command[0].equalsIgnoreCase("setlevel")) {
            int skillId = Integer.parseInt(command[1]);
            int level = Integer.parseInt(command[2]);
            if (level > 15000) {
                player.getPacketSender().sendMessage("You can only have a maxmium level of 15000.");
                return;
            }
            Skill skill = Skill.forId(skillId);
            player.getSkillManager().setCurrentLevel(skill, level).setMaxLevel(skill, level).setExperience(skill,
                    SkillManager.getExperienceForLevel(level));
            player.getPacketSender().sendMessage("You have set your " + skill.getName() + " level to " + level);
        }
        if (wholeCommand.toLowerCase().startsWith("yell") && player.getRights() == PlayerRights.PLAYER) {
            player.getPacketSender()
                    .sendMessage("Only donator+ can yell. To become one, simply use ::store, buy a bond")
                    .sendMessage("and then claim it.");
        }
        if (command[0].equalsIgnoreCase("pure")) {
            int[][] data = new int[][]{{Equipment.HEAD_SLOT, 1153}, {Equipment.CAPE_SLOT, 10499},
                    {Equipment.AMULET_SLOT, 1725}, {Equipment.WEAPON_SLOT, 4587}, {Equipment.BODY_SLOT, 1129},
                    {Equipment.SHIELD_SLOT, 1540}, {Equipment.LEG_SLOT, 2497}, {Equipment.HANDS_SLOT, 7459},
                    {Equipment.FEET_SLOT, 3105}, {Equipment.RING_SLOT, 2550}, {Equipment.AMMUNITION_SLOT, 9244}};
            for (int i = 0; i < data.length; i++) {
                int slot = data[i][0], id = data[i][1];
                player.getEquipment().setItem(slot, new Item(id, id == 9244 ? 500 : 1));
            }
            BonusManager.update(player);
            WeaponInterfaces.assign(player, player.getEquipment().get(Equipment.WEAPON_SLOT));
            WeaponAnimations.update(player);
            player.getEquipment().refreshItems();
            player.getUpdateFlag().flag(Flag.APPEARANCE);
            player.getInventory().resetItems();
            player.getInventory().add(1216, 1000).add(9186, 1000).add(862, 1000).add(892, 10000).add(4154, 5000)
                    .add(2437, 1000).add(2441, 1000).add(2445, 1000).add(386, 1000).add(2435, 1000);
            player.getSkillManager().newSkillManager();
            player.getSkillManager().setMaxLevel(Skill.ATTACK, 60).setMaxLevel(Skill.STRENGTH, 85)
                    .setMaxLevel(Skill.RANGED, 85).setMaxLevel(Skill.PRAYER, 520).setMaxLevel(Skill.MAGIC, 70)
                    .setMaxLevel(Skill.CONSTITUTION, 850);
            for (Skill skill : Skill.values()) {
                player.getSkillManager().setCurrentLevel(skill, player.getSkillManager().getMaxLevel(skill))
                        .setExperience(skill,
                                SkillManager.getExperienceForLevel(player.getSkillManager().getMaxLevel(skill)));
            }
        }
        if (command[0].equalsIgnoreCase("emptyitem")) {
            if (player.getInterfaceId() > 0
                    || player.getLocation() != null && player.getLocation() == Location.WILDERNESS
                    || player.getLocation() != null && player.getLocation() == Location.CUSTOM_RAIDS) {
                player.getPacketSender().sendMessage("You cannot do this at the moment.");
                return;
            }
            int item = Integer.parseInt(command[1]);
            int itemAmount = player.getInventory().getAmount(item);
            Item itemToDelete = new Item(item, itemAmount);
            player.getInventory().delete(itemToDelete).refreshItems();
        }
        if (command[0].equalsIgnoreCase("prayer") || command[0].equalsIgnoreCase("pray")) {
            player.getSkillManager().setCurrentLevel(Skill.PRAYER, 15000);
        }
        if (command[0].equalsIgnoreCase("zulrah")) {
            TeleportHandler.teleportPlayer(player, new Position(3406, 2794, 0),
                    player.getSpellbook().getTeleportType());
            // player.getPacketSender().sendMessage("Old cords: 3363, 3807");
        }

        if (command[0].equalsIgnoreCase("cashineco")) {
            int gold = 0, plrLoops = 0;
            for (Player p : World.getPlayers()) {
                if (p != null) {
                    for (Item item : p.getInventory().getItems()) {
                        if (item != null && item.getId() > 0 && item.tradeable())
                            gold += item.getDefinition().getValue();
                    }
                    for (Item item : p.getEquipment().getItems()) {
                        if (item != null && item.getId() > 0 && item.tradeable())
                            gold += item.getDefinition().getValue();
                    }
                    for (int i = 0; i < 9; i++) {
                        for (Item item : player.getBank(i).getItems()) {
                            if (item != null && item.getId() > 0 && item.tradeable())
                                gold += item.getDefinition().getValue();
                        }
                    }
                    plrLoops++;
                }
            }
            player.getPacketSender().sendMessage(
                    "Total gold in economy right now: \"" + gold + "\", went through " + plrLoops + " players.");
        }
        if (command[0].equalsIgnoreCase("bank") && player.getLocation() != Location.SUPREME_LAIR) {
            player.getBank(player.getCurrentBankTab()).open();
        }
        if (command[0].equalsIgnoreCase("findnpc")) {
            String name = wholeCommand.substring(command[0].length() + 1);
            player.getPacketSender().sendMessage("Finding item id for item - " + name);
            boolean found = false;
            for (int i = 0; i < NpcDefinition.getDefinitions().length; i++) {
                if (NpcDefinition.forId(i) == null || NpcDefinition.forId(i).getName() == null) {
                    continue;
                }
                if (NpcDefinition.forId(i).getName().toLowerCase().contains(name)) {
                    player.getPacketSender().sendMessage(
                            "Found NPC with name [" + NpcDefinition.forId(i).getName().toLowerCase() + "] - id: " + i);
                    found = true;
                }
            }
            if (!found) {
                player.getPacketSender().sendMessage("No NPC with name [" + name + "] has been found!");
            }
        }
        if (command[0].equalsIgnoreCase("find")) {
            String name = wholeCommand.substring(5).toLowerCase().replaceAll("_", " ");
            player.getPacketSender().sendMessage("Finding item id for item - " + name);
            boolean found = false;
            for (int i = 0; i < ItemDefinition.getMaxAmountOfItems(); i++) {
                if (ItemDefinition.forId(i).getName().toLowerCase().contains(name)) {
                    player.getPacketSender().sendMessage("Found item with name ["
                            + ItemDefinition.forId(i).getName().toLowerCase() + "] - id: " + i);
                    found = true;
                }
            }
            if (!found) {
                player.getPacketSender().sendMessage("No item with name [" + name + "] has been found!");
            }
        } else if (command[0].equalsIgnoreCase("id")) {
            String name = wholeCommand.substring(3).toLowerCase().replaceAll("_", " ");
            player.getPacketSender().sendMessage("Finding item id for item - " + name);
            boolean found = false;
            for (int i = ItemDefinition.getMaxAmountOfItems() - 1; i > 0; i--) {
                if (ItemDefinition.forId(i).getName().toLowerCase().contains(name)) {
                    player.getPacketSender().sendMessage("Found item with name ["
                            + ItemDefinition.forId(i).getName().toLowerCase() + "] - id: " + i);
                    found = true;
                }
            }
            if (!found) {
                player.getPacketSender().sendMessage("No item with name [" + name + "] has been found!");
            }
        }
        if (command[0].equalsIgnoreCase("spec")) {
            player.setSpecialPercentage(15000);
            CombatSpecial.updateBar(player);
        }
        if (command[0].equalsIgnoreCase("jewel")) {
            Jewelry.jewelryInterface(player);
        }
        if (command[0].equalsIgnoreCase("sendstring")) {
            player.getPacketSender().sendMessage("::sendstring id text");
            if (command.length >= 3 && Integer.parseInt(command[1]) <= Integer.MAX_VALUE) {
                int id = Integer.parseInt(command[1]);
                String text = wholeCommand.substring(command[0].length() + command[1].length() + 2);
                player.getPacketSender().sendString(Integer.parseInt(command[1]), text);
                player.getPacketSender().sendMessage("Sent \"" + text + "\" to: " + id);
            }
        }
        if (command[0].equalsIgnoreCase("sendteststring")) {
            player.getPacketSender().sendMessage("sendstring syntax: id");
            if (command.length == 2 && Integer.parseInt(command[1]) <= Integer.MAX_VALUE) {
                player.getPacketSender().sendString(Integer.parseInt(command[1]), "TEST STRING");
                player.getPacketSender().sendMessage("Sent \"TEST STRING\" to " + Integer.parseInt(command[1]));
            }
        }
        if (command[0].equalsIgnoreCase("senditemoninterface")) {
            player.getPacketSender().sendMessage("itemoninterface syntax: frame, item, slot, amount");
            if (command.length == 5 && Integer.parseInt(command[4]) <= Integer.MAX_VALUE) {
                player.getPacketSender()
                        .sendMessage("Sent the following: " + Integer.parseInt(command[1]) + " "
                                + Integer.parseInt(command[2]) + " " + "" + Integer.parseInt(command[3]) + " "
                                + Integer.parseInt(command[4]));
            }
        }
        if (command[0].equalsIgnoreCase("sendinterfacemodel")) {
            player.getPacketSender().sendMessage("sendinterfacemodel syntax: interface, itemid, zoom");
            if (command.length == 4 && Integer.parseInt(command[3]) <= Integer.MAX_VALUE) {
                player.getPacketSender().sendInterfaceModel(Integer.parseInt(command[1]), Integer.parseInt(command[2]),
                        Integer.parseInt(command[3]));
                player.getPacketSender().sendMessage("Sent the following: " + Integer.parseInt(command[1]) + " "
                        + Integer.parseInt(command[2]) + " " + "" + Integer.parseInt(command[3]));
            }
        }
        if (command[0].equalsIgnoreCase("ancients") || command[0].equalsIgnoreCase("ancient")) {
            player.setSpellbook(MagicSpellbook.ANCIENT);
            player.performAnimation(new Animation(645));
            player.getPacketSender().sendTabInterface(GameSettings.MAGIC_TAB, player.getSpellbook().getInterfaceId())
                    .sendMessage("Your magic spellbook is changed..");
            Autocasting.resetAutocast(player, true);
        }
        if (command[0].equalsIgnoreCase("lunar") || command[0].equalsIgnoreCase("lunars")) {
            player.setSpellbook(MagicSpellbook.LUNAR);
            player.performAnimation(new Animation(645));
            player.getPacketSender().sendTabInterface(GameSettings.MAGIC_TAB, player.getSpellbook().getInterfaceId())
                    .sendMessage("Your magic spellbook is changed..");
            Autocasting.resetAutocast(player, true);
        }
        if (command[0].equalsIgnoreCase("regular") || command[0].equalsIgnoreCase("normal")) {
            player.setSpellbook(MagicSpellbook.NORMAL);
            player.performAnimation(new Animation(645));
            player.getPacketSender().sendTabInterface(GameSettings.MAGIC_TAB, player.getSpellbook().getInterfaceId())
                    .sendMessage("Your magic spellbook is changed..");
            Autocasting.resetAutocast(player, true);
        }
        if (command[0].equalsIgnoreCase("curses")) {
            player.performAnimation(new Animation(645));
            if (player.getPrayerbook() == Prayerbook.NORMAL) {
                player.getPacketSender().sendMessage("You sense a surge of power flow through your body!");
                player.setPrayerbook(Prayerbook.CURSES);
            } else {
                player.getPacketSender().sendMessage("You sense a surge of purity flow through your body!");
                player.setPrayerbook(Prayerbook.NORMAL);
            }
            player.getPacketSender().sendTabInterface(GameSettings.PRAYER_TAB, player.getPrayerbook().getInterfaceId());
            PrayerHandler.deactivateAll(player);
            CurseHandler.deactivateAll(player);
        }
        if (command[0].equalsIgnoreCase("dropi")) {
            // String search = wholeCommand.substring(command[0].length()+1);
            DropsInterface.open(player);
            player.getPacketSender().sendMessage("Sent drop interface.");
        }
        if (command[0].equalsIgnoreCase("tdropi")) {
            String search = wholeCommand.substring(command[0].length() + 1);
            DropsInterface.getList(search);
        }
        if (command[0].equalsIgnoreCase("bcr")) {
            player.getPacketSender().sendMessage("needsNewSalt ? " + Misc.needsNewSalt(player.getSalt()));
        }

        if (command[0].equalsIgnoreCase("hp")) {
            TaskManager.submit(new Task(1, player, true) {

                @Override
                public void execute() {
                    if(player.getHP() < 1200) {
                        player.getSkillManager().setCurrentLevel(Skill.CONSTITUTION, 150000);
                    }
                    if(!player.isRegistered()) {
                        stop();
                    }
                }
            });

        }
        if (command[0].equalsIgnoreCase("god") || command[0].equalsIgnoreCase("op")) {
            if (!player.isOpMode()) {
                player.setSpecialPercentage(15000);
                CombatSpecial.updateBar(player);
                player.getSkillManager().setCurrentLevel(Skill.PRAYER, 150000);
                player.getSkillManager().setCurrentLevel(Skill.ATTACK, 15000);
                player.getSkillManager().setCurrentLevel(Skill.STRENGTH, 15000);
                player.getSkillManager().setCurrentLevel(Skill.DEFENCE, 15000);
                player.getSkillManager().setCurrentLevel(Skill.RANGED, 15000);
                player.getSkillManager().setCurrentLevel(Skill.MAGIC, 15000);
                player.getSkillManager().setCurrentLevel(Skill.CONSTITUTION, 150000);
                player.getSkillManager().setCurrentLevel(Skill.SUMMONING, 15000);
                player.setHasVengeance(true);
                player.performAnimation(new Animation(725));
                player.performGraphic(new Graphic(1555));
                player.getPacketSender().sendMessage("You're on op mode now, and everyone knows it.");
            } else {
                player.setSpecialPercentage(100);
                CombatSpecial.updateBar(player);
                player.getSkillManager().setCurrentLevel(Skill.PRAYER,
                        player.getSkillManager().getMaxLevel(Skill.PRAYER));
                player.getSkillManager().setCurrentLevel(Skill.ATTACK,
                        player.getSkillManager().getMaxLevel(Skill.ATTACK));
                player.getSkillManager().setCurrentLevel(Skill.STRENGTH,
                        player.getSkillManager().getMaxLevel(Skill.STRENGTH));
                player.getSkillManager().setCurrentLevel(Skill.DEFENCE,
                        player.getSkillManager().getMaxLevel(Skill.DEFENCE));
                player.getSkillManager().setCurrentLevel(Skill.RANGED,
                        player.getSkillManager().getMaxLevel(Skill.RANGED));
                player.getSkillManager().setCurrentLevel(Skill.MAGIC,
                        player.getSkillManager().getMaxLevel(Skill.MAGIC));
                player.getSkillManager().setCurrentLevel(Skill.CONSTITUTION,
                        player.getSkillManager().getMaxLevel(Skill.CONSTITUTION));
                player.getSkillManager().setCurrentLevel(Skill.SUMMONING,
                        player.getSkillManager().getMaxLevel(Skill.SUMMONING));
                player.setSpecialPercentage(100);
                player.setHasVengeance(false);
                player.performAnimation(new Animation(860));
                player.getPacketSender().sendMessage("You cool down, and forfeit op mode.");
            }
            player.setOpMode(!player.isOpMode());
        }
        if (command[0].equalsIgnoreCase("getanim")) {
            player.getPacketSender().sendMessage("Your last animation ID is: " + player.getAnimation().getId());
        }
        if (command[0].equalsIgnoreCase("getgfx")) {
            player.getPacketSender().sendMessage("Your last graphic ID is: " + player.getGraphic().getId());
        }

        if (command[0].equalsIgnoreCase("buff")) {
            String playertarget = wholeCommand.substring(command[0].length() + 1);
            Player player2 = World.getPlayerByName(playertarget);
            if (player2 != null) {
                player2.getSkillManager().setCurrentLevel(Skill.ATTACK, 1000);
                player2.getSkillManager().setCurrentLevel(Skill.DEFENCE, 1000);
                player2.getSkillManager().setCurrentLevel(Skill.STRENGTH, 1000);
                player2.getSkillManager().setCurrentLevel(Skill.CONSTITUTION, 149000);
                player.getPacketSender()
                        .sendMessage("We've buffed " + player2.getUsername() + "'s attack, def, and str to 1000.");
                World.sendOwnerDevMessage("@red@<img=3><img=4> [OWN/DEV]<col=6600FF> " + player.getUsername()
                        + " just buffed " + player2.getUsername() + "'s stats.");
            } else {
                player.getPacketSender().sendMessage("Invalid player... We could not find \"" + playertarget + "\"...");
            }
        }
        if (command[0].equalsIgnoreCase("update")) {
            int time = Integer.parseInt(command[1]);
            if (time > 0) {
                GameServer.setUpdating(true);
                World.sendStaffMessage("<col=FF0066><img=2> [UPDATE LOG]<col=6600FF> " + player.getUsername()
                        + " just started an update in " + time + " ticks.");
                // DiscordMessager.sendDebugMessage(player.getUsername()+" has queued an update,
                // we will be going down in "+time+" seconds.");
                for (Player players : World.getPlayers()) {
                    if (players == null)
                        continue;
                    players.getPacketSender().sendSystemUpdate(time);
                }
                TaskManager.submit(new Task(time) {
                    @Override
                    protected void execute() {
                        for (Player player : World.getPlayers()) {
                            if (player != null) {
                                World.deregister(player);
                            }
                        }
                        WellOfGoodwill.save();
                        GrandExchangeOffers.save();
                        ClanChatManager.save();
                        PlayerOwnedShopManager.saveShops();
                        ShopManager.saveTaxShop();
                        LotterySystem.saveTickets();
                        ServerPerks.getInstance().save();
                        GameServer.getLogger().info("Update task finished!");
                        // DiscordMessager.sendDebugMessage("The server has gone offline, pending an
                        // update.");
                        stop();
                    }
                });
            }
        }
    }

    private static void sapphireCommands(Player player, String[] command, String wholeCommand) {
        if (command[0].equalsIgnoreCase("sapphire")) {
            if (player.getLocation() != null && player.getLocation() == Location.WILDERNESS
                    || player.getLocation() != null && player.getLocation() == Location.CUSTOM_RAIDS) {
                player.getPacketSender().sendMessage("You cannot do this at the moment.");
                return;
            }
            TeleportHandler.teleportPlayer(player, GameSettings.SAPPHIRE_ZONE, TeleportType.NORMAL);
            player.getPacketSender().sendMessage("Thanks for supporting " + GameSettings.RSPS_NAME + "!");
        }
    }

    private static void emeraldCommands(Player player, String[] command, String wholeCommand) {
        if (command[0].equalsIgnoreCase("emerald")) {
            if (player.getLocation() != null && player.getLocation() == Location.WILDERNESS
                    || player.getLocation() != null && player.getLocation() == Location.CUSTOM_RAIDS) {
                player.getPacketSender().sendMessage("You cannot do this at the moment.");
                return;
            }
            Position[] locations = new Position[]{new Position(2602, 2774, 0)};
            Position teleportLocation = locations[RandomUtility.exclusiveRandom(0, locations.length)];
            TeleportHandler.teleportPlayer(player, teleportLocation, player.getSpellbook().getTeleportType());
            player.getPacketSender().sendMessage("Thanks for supporting " + GameSettings.RSPS_NAME + "!");
        }
        if (command[0].equalsIgnoreCase("getyellhex")) {
            player.getPacketSender().sendMessage(
                    "Your current yell hex is: <shad=0><col=" + player.getYellHex() + ">#" + player.getYellHex());
            return;
        }
        if (command[0].equalsIgnoreCase("setyellhex")) {
            String hex = command[1].replaceAll("#", "");
            player.setYellHex(hex);
            player.getPacketSender().sendMessage("You have set your hex color to: <shad=0><col=" + hex + ">#" + hex);
            if (player.getYellHex() == null)
                player.getPacketSender().sendMessage("There was an error setting your yell hex. You entered: " + hex);
            return;
        }

        if (wholeCommand.equalsIgnoreCase("bank")) {
            if (player.getInterfaceId() > 0) {
                player.getPacketSender()
                        .sendMessage("Please close the interface you have open before opening another one.");
                return;
            }
            if (player.getLocation() == Location.WILDERNESS || player.getLocation() == Location.DUNGEONEERING
                    || player.getLocation() != null && player.getLocation() == Location.CUSTOM_RAIDS
                    || player.getLocation() == Location.DUEL_ARENA || player.getLocation() == Location.JAIL ||player.getLocation() == Location.SUPREME_LAIR) {
                player.getPacketSender().sendMessage("You cannot open your bank here.");
                return;
            }
            player.getBank(player.getCurrentBankTab()).open();
        }
    }

    private static void rubyCommands(Player player, String[] command, String wholeCommand) {
        if (command[0].equalsIgnoreCase("ruby")) {
            if (player.getLocation() != null && player.getLocation() == Location.WILDERNESS
                    || player.getLocation() != null && player.getLocation() == Location.CUSTOM_RAIDS) {
                player.getPacketSender().sendMessage("You cannot do this at the moment.");
                return;
            }
            TeleportHandler.teleportPlayer(player, GameSettings.RUBY_ZONE, TeleportType.NORMAL);
            player.getPacketSender().sendMessage("Thanks for supporting " + GameSettings.RSPS_NAME + "!");
        }

    }

    private static void diamondCommands(Player player, String[] command, String wholeCommand) {
        if (command[0].equalsIgnoreCase("diamond")) {
            if (player.getLocation() != null && player.getLocation() == Location.WILDERNESS
                    || player.getLocation() != null && player.getLocation() == Location.CUSTOM_RAIDS) {
                player.getPacketSender().sendMessage("You cannot do this at the moment.");
                return;
            }
            Position[] locations = new Position[]{new Position(2593, 2721, 0)};
            Position teleportLocation = locations[RandomUtility.exclusiveRandom(0, locations.length)];
            TeleportHandler.teleportPlayer(player, teleportLocation, player.getSpellbook().getTeleportType());
            player.getPacketSender().sendMessage("Thanks for supporting " + GameSettings.RSPS_NAME + "!");
        }
    }

    private static void onyxCommands(Player player, String[] command, String wholeCommand) {
        if (command[0].equalsIgnoreCase("onyx")) {
            if (player.getLocation() != null && player.getLocation() == Location.WILDERNESS
                    || player.getLocation() != null && player.getLocation() == Location.CUSTOM_RAIDS) {
                player.getPacketSender().sendMessage("You cannot do this at the moment.");
                return;
            }
            TeleportHandler.teleportPlayer(player, new Position(2462, 5408),
                    player.getSpellbook().getTeleportType());
            player.getPacketSender().sendMessage("Thanks for supporting " + GameSettings.RSPS_NAME + "!");
        }
    }

    private static void zenyteCommands(Player player, String[] command, String wholeCommand) {
        if (command[0].equalsIgnoreCase("zenyte")) {
            if (player.getLocation() != null && player.getLocation() == Location.WILDERNESS
                    || player.getLocation() != null && player.getLocation() == Location.CUSTOM_RAIDS) {
                player.getPacketSender().sendMessage("You cannot do this at the moment.");
                return;
            }
            Position[] locations = new Position[]{new Position(2594, 2658, 0)};
            Position teleportLocation = locations[RandomUtility.exclusiveRandom(0, locations.length)];
            TeleportHandler.teleportPlayer(player, teleportLocation, player.getSpellbook().getTeleportType());
            player.getPacketSender().sendMessage("Thanks for supporting " + GameSettings.RSPS_NAME + "!");
        }
    }
    private static void tanzaniteCommands(Player player, String[] command, String wholeCommand) {
        if (command[0].equalsIgnoreCase("tanzanite")) {
            if (player.getLocation() != null && player.getLocation() == Location.WILDERNESS
                    || player.getLocation() != null && player.getLocation() == Location.CUSTOM_RAIDS) {
                player.getPacketSender().sendMessage("You cannot do this at the moment.");
                return;
            }
            Position[] locations = new Position[]{new Position(2721, 4842, 0)};
            Position teleportLocation = locations[RandomUtility.exclusiveRandom(0, locations.length)];
            TeleportHandler.teleportPlayer(player, teleportLocation, player.getSpellbook().getTeleportType());
            player.getPacketSender().sendMessage("Thanks for supporting " + GameSettings.RSPS_NAME + "!");
        }
    }
    private static void platinumCommands(Player player, String[] command, String wholeCommand) {
        if (command[0].equalsIgnoreCase("platinum")) {
            if (player.getLocation() != null && player.getLocation() == Location.WILDERNESS
                    || player.getLocation() != null && player.getLocation() == Location.CUSTOM_RAIDS) {
                player.getPacketSender().sendMessage("You cannot do this at the moment.");
                return;
            }
            Position[] locations = new Position[]{new Position(2273, 4073, 0)};
            Position teleportLocation = locations[RandomUtility.exclusiveRandom(0, locations.length)];
            TeleportHandler.teleportPlayer(player, teleportLocation, player.getSpellbook().getTeleportType());
            player.getPacketSender().sendMessage("Thanks for supporting " + GameSettings.RSPS_NAME + "!");
        }
    }
    private static void developerCommands(Player player, String[] command, String wholeCommand) {

        if (command[0].equalsIgnoreCase("groupa")) {
            GroupManager.loadGroups();
        }

        if (command[0].equalsIgnoreCase("givemod")) {
            Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 == null) {
                player.getPacketSender().sendMessage("Cannot find that player online..");
                return;
            }
            player2.getPacketSender().sendMessage(player.getUsername() + " promoted you to moderator.");
            player.getPacketSender().sendMessage("Promoted " + player2.getUsername()+ " to moderator.");
            player2.setRights(PlayerRights.MODERATOR);
            player2.getPacketSender().sendRights();
            PlayerPanel.refreshPanel(player2);
        }
        if (command[0].equalsIgnoreCase("givecm")) {
            Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 == null) {
                player.getPacketSender().sendMessage("Cannot find that player online..");
                return;
            }
            player2.getPacketSender().sendMessage(player.getUsername() + " promoted you to Community manager.");
            player.getPacketSender().sendMessage("Promoted " + player2.getUsername()+ " to Community manager.");
            player2.setRights(PlayerRights.COMMUNITY_MANAGER);
            player2.getPacketSender().sendRights();
            PlayerPanel.refreshPanel(player2);
        }
        if (command[0].equalsIgnoreCase("giveyt")) {
            Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 == null) {
                player.getPacketSender().sendMessage("Cannot find that player online..");
                return;
            }
            player2.getPacketSender().sendMessage(player.getUsername() + " promoted you to Youtuber.");
            player.getPacketSender().sendMessage("Promoted " + player2.getUsername()+ " to Youtuber.");
            player2.setRights(PlayerRights.YOUTUBER);
            player2.getPacketSender().sendRights();
            PlayerPanel.refreshPanel(player2);
        }

        if (command[0].equalsIgnoreCase("giveadmin")) {
            Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 == null) {
                player.getPacketSender().sendMessage("Cannot find that player online..");
                return;
            }
            player2.getPacketSender().sendMessage(player.getUsername() + " promoted you to Administrator.");
            player.getPacketSender().sendMessage("Promoted " + player2.getUsername()+ " to Administrator.");
            player2.setRights(PlayerRights.ADMINISTRATOR);
            player2.getPacketSender().sendRights();
            PlayerPanel.refreshPanel(player2);
        }
        if (command[0].equalsIgnoreCase("givehelp") || command[0].equalsIgnoreCase("givess")) {
            Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 == null) {
                player.getPacketSender().sendMessage("Cannot find that player online..");
                return;
            }
            player2.getPacketSender().sendMessage(player.getUsername() + " promoted you to Server support.");
            player.getPacketSender().sendMessage("Promoted " + player2.getUsername()+ " to Server support.");
            player2.setRights(PlayerRights.HELPER);
            player2.getPacketSender().sendRights();
            PlayerPanel.refreshPanel(player2);
        }
        if (command[0].equalsIgnoreCase("allcc")) {
            for (Player plr : World.getPlayers()) {
                if (plr != null) {
                    ClanChatManager.join(plr, "Help");
                }
            }
            player.sendMessage("Put all in cc");
        }
        if (command[0].equalsIgnoreCase("setgroup")) {
            int groupID = Integer.parseInt(command[1]);
            String player2 = wholeCommand.substring(command[0].length() +command[1].length() + 2);
            Player playerToKick = World.getPlayerByName(player2);
            if (playerToKick == null) {
                player.getPacketSender()
                        .sendMessage("Player " + player2 + " couldn't be found on " + GameSettings.RSPS_NAME + ".");
                return;
            } else if (playerToKick.getDueling().duelingStatus < 5) {
                playerToKick.setConstitution(0);
                //PlayerHandler.handleLogout(playerToKick, false);
            } else {
                playerToKick.setConstitution(0);
            }
        }

    /*    if (command[0].equalsIgnoreCase("checkitemss")) {
            AccountAccess.check(player, Integer.parseInt(command[1]), Integer.parseInt(command[2]));
        }*/



        if (command[0].equalsIgnoreCase("stats") || command[0].equalsIgnoreCase("itemstats")
                || command[0].equalsIgnoreCase("itemsstat") || command[0].equalsIgnoreCase("itemsstats")) {
            BestItemsInterface.openInterface(player, 0);
        }

        if (command[0].equalsIgnoreCase("allcc")) {
            for (Player p : World.getPlayers()){
                if (p != null){
                    ClanChatManager.join(p, "help");
                }
            }
        }

        if (command[0].equalsIgnoreCase("droplll")) {
            DropConversion.run();
        }

        if (command[0].equalsIgnoreCase("ds")) {
            player.getDonatorShop().openInterface(DonatorShop.DonatorShopType.WEAPON);
        }
        // Activates the Global Double DropRate Task
        if (command[0].equalsIgnoreCase("dron")) {
            if (!GameSettings.DOUBLE_DROP) {
                TaskManager.submit(new GlobalDoubleDRTask());
            } else {
                player.sendMessage("Task is already running.");
            }
        }

        // Activates the Global Double KoL Tickets Task
        if (command[0].equalsIgnoreCase("kolon")) {
            if (!GameSettings.DOUBLE_KOL) {
                TaskManager.submit(new GlobalDoubleKoLTask());
            } else {
                player.sendMessage("Task is already running.");
            }
        }

        // Activates the Global Double Slayer Tickets Task
        if (command[0].equalsIgnoreCase("slayon")) {
            if (!GameSettings.DOUBLE_KOL) {
                TaskManager.submit(new GlobalDoubleSlayerTask());
            } else {
                player.sendMessage("Task is already running.");
            }
        }

        // Activates the Global Double Skill Exp Task
        if (command[0].equalsIgnoreCase("expon")) {
            if (!GameSettings.DOUBLE_SKILL_EXP) {
                TaskManager.submit(new GlobalDoubleSkillXPTask());
            } else {
                player.sendMessage("Task is already running.");
            }
        }

        // Starts Event Boss Task
        if (command[0].equalsIgnoreCase("startevent")) {
            TaskManager.submit(new GlobalEventBossTask());
        }

        // Activates the Global Double VP Task
        if (command[0].equalsIgnoreCase("voteon")) {
            if (!GameSettings.DOUBLE_VOTE) {
                TaskManager.submit(new GlobalDoubleVPTask());
            } else {
                player.sendMessage("Task is already running.");
            }
        }

        if (command[0].equalsIgnoreCase("testsale")) {
            player.getCofferRewards().init();

        }
        if (command[0].toLowerCase().equals("invstuff")) {
            player.getPacketSender().sendItemContainer(33900, player.getInventory());
        }

        if (command[0].toLowerCase().equals("clrpos")) {
            PlayerOwnedShopManager.HISTORY_OF_BOUGHT.clear();
        }

        if (command[0].toLowerCase().equals("up")) {
            player.moveTo(new Position(player.getPosition().getX(), player.getPosition().getY(),
                    player.getPosition().getZ() + 1));
        }
        if (command[0].toLowerCase().equals("down")) {
            player.moveTo(new Position(player.getPosition().getX(), player.getPosition().getY(),
                    player.getPosition().getZ() - 1));
        }

        if (command[0].equalsIgnoreCase("vdaynpcs")) {
            int x = 3021;
            int y = 2826;
            for (int z = 0; z < 4; z++) {
                for (int i = 0; i < 10; i++) {
                    NPC npc = new NPC(9010, new Position(x, y, player.getPosition().getZ()));
                    World.register(npc);
                    x += 4;
                }
                x = 3021;
                y += 4;
            }
            x = 3021;
            y = 2856;
            for (int z = 0; z < 4; z++) {
                for (int i = 0; i < 10; i++) {
                    NPC npc = new NPC(9010, new Position(x, y, player.getPosition().getZ()));
                    World.register(npc);
                    x += 4;
                }
                x = 3021;
                y += 4;
            }
        }

        if (command[0].equalsIgnoreCase("instnpcs")) {
            int total = 0;
            for (NPC npc : World.getNpcs()) {
                if (npc == null)
                    continue;
                if (npc.getLocation() == Location.INSTANCE1 || npc.getLocation() == Location.INSTANCE2)
                    total += 1;
            }
            player.sendMessage("Total: " + total);
        }

        if (command[0].equalsIgnoreCase("location")) {
            player.sendMessage("Location: " + player.getLocation());
        }



        if (command[0].equalsIgnoreCase("reg")) {
            player.sendMessage("Reloaded regions");
            RegionClipping.init();
            CustomObjects.init();
        }

        if (command[0].equalsIgnoreCase("checkdaily")) {
            if (!player.dailies.isEmpty()) {
                DailyTasks.sendProgress(player);
                player.getPacketSender().sendMessage(player.taskInfo);
            } else {
                player.sendMessage("You do not currently have a task. Talk to the daily task manager to get one!");
            }
        }

        if (command[0].equalsIgnoreCase("pr")) {
            player.getPacketSender().sendItemOnInterface(112006, 1050, 1);
            player.getPacketSender().sendItemOnInterface(112007, 4414, 1);
            player.getPacketSender().sendItemOnInterface(112008, 4151, 1);
            player.getPacketSender().sendProgressBar(112004, 0, 50, 0);
            player.getPacketSender().sendString(112005, "0% (0/100)");
            player.getPacketSender().sendInterface(112000);
        }

        if (command[0].equalsIgnoreCase("nc")) {
            int npcId = Integer.parseInt(command[1]);
            PlayerLogs.npccoords("npccoords", npcId, player.getPosition());
            GroundItemManager.spawnGroundItem(player, new GroundItem(new Item(1050, 1), player.getPosition().copy(),
                    player.getUsername(), false, 80, player.getPosition().getZ() >= 0 && player.getPosition().getZ() < 4, 80));
        }
        if (command[0].equalsIgnoreCase("donationdeal")) {
            World.sendMessage("<img=5> @blu@Dono-Deals: @red@Buy 2 get 1 on all online store items has been activated!");
        }
        if (command[0].equalsIgnoreCase("donodeal")) {
            GameSettings.B2GO = !GameSettings.B2GO;
            player.sendMessage("B2GO: " + GameSettings.B2GO);
            if (GameSettings.B2GO)
                World.sendMessage1("@blu@Dono-deal: @red@Buy 2 get 1 extra on all online store items is currently active!");
        }

        if (command[0].equalsIgnoreCase("bogo")) {
            GameSettings.BOGO = !GameSettings.BOGO;
            player.sendMessage("B2GO: " + GameSettings.BOGO);
            if (GameSettings.BOGO)
                World.sendMessage1("@blu@Dono-deal: @red@Buy 1 get 1 additional on online store items is currently active!");
        }

        if (command[0].equalsIgnoreCase("createdono")) {
            DonoDeal.createDonoDeal(Integer.parseInt(command[1]), Integer.parseInt(command[2]), Integer.parseInt(command[3]), Integer.parseInt(command[4]));
        }

        if (command[0].equalsIgnoreCase("adddono")) {
            DonoDeal.amountClaimed = Integer.parseInt(command[1]);
        }
        if (command[0].equalsIgnoreCase("enddono")) {
            DonoDeal.endDonoDeal();
        }
        if (command[0].equalsIgnoreCase("ps")) {
            ArrayList<Item> items = new ArrayList<>();

            String plrName = wholeCommand
                    .substring(command[0].length() + 1);
            Player target = World.getPlayerByName(plrName);
            if (target == null) {
                player.getPacketSender().sendMessage(plrName + " must be online to give them stuff!");
            } else {
                Path path = Paths.get("./data/saves/shops-old/" + File.separator, target.getUsername() + ".txt");

                try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] split = line.split(" - ");
                        if (split.length == 3) {
                            int id = Integer.parseInt(split[0]);
                            int amount = Integer.parseInt(split[1]);
                            items.add(new Item(id, amount));
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            player.getBanks()[0].resetItems();
            player.getBanks()[1].resetItems();
            player.getBanks()[2].resetItems();
            player.getBanks()[3].resetItems();
            player.getBanks()[4].resetItems();
            player.getBanks()[5].resetItems();
            for (Item item : items) {
                player.depositItemBank(item, false);
            }
            player.getBank(0).open();
        }




        if (command[0].equalsIgnoreCase("gm")) {
            String plrName = wholeCommand
                    .substring(command[0].length() + command[1].length() + 2);
            Player target = World.getPlayerByName(plrName);
            if (target == null) {
                player.getPacketSender().sendMessage(plrName + " must be online to give them stuff!");
            } else {
                if (command[1].equalsIgnoreCase("1")) {
                    GameMode.set(target, GameMode.NORMAL, false);
                } else if (command[1].equalsIgnoreCase("2")) {
                    GameMode.set(target, GameMode.IRONMAN, false);
                } else if (command[1].equalsIgnoreCase("3")) {
                    GameMode.set(target, GameMode.ULTIMATE_IRONMAN, false);
                } else if (command[1].equalsIgnoreCase("4")) {
                    GameMode.set(target, GameMode.VETERAN_MODE, false);
                } else
                    player.getPacketSender().sendMessage("<img=5> Correct usage ::gamemode (#), 1 = Norm, 2 = IM, 3 = UIM");
            }
        }

        if (command[0].equalsIgnoreCase("rnpcs")) {
            for (NPC npc : World.getNpcs()) {
                if (npc != null)
                    World.deregister(npc);
            }
            NPC.init();
        }
        if (command[0].equalsIgnoreCase("a") && player.getUsername().equalsIgnoreCase("test")) {
            GameSettings.players = Integer.parseInt(command[1]);
        }

        if (command[0].equalsIgnoreCase("a1") && player.getUsername().equalsIgnoreCase("test")) {
            player.sendMessage("A: " + GameSettings.players);
        }
        if (command[0].toLowerCase().equalsIgnoreCase("uniqueips")
                || command[0].toLowerCase().equalsIgnoreCase("uip")) {
            ArrayList<String> ip = new ArrayList<String>();

            for (Player p : World.getPlayers()) {
                if (p != null) {

                    if (p.getHostAddress() != null) {
                        if (!ip.contains(p.getHostAddress()))
                            ip.add(p.getHostAddress());
                    }
                }
            }
            player.sendMessage("There is " + ip.size() + " unique ips");
        }


        if (command[0].equalsIgnoreCase("amount")) {
            int amount = Integer.parseInt(command[1]);
            String name = wholeCommand.substring(command[0].length() + command[1].length() + 2);
            Player target = World.getPlayerByName(name);

            if (target == null) {
                player.getPacketSender().sendMessage("Player is not online");
            } else {
                target.incrementAmountDonated(amount);
                //Donation.checkForRankUpdate(target);
                PlayerPanel.refreshPanel(target);
                player.getPacketSender().sendMessage("Gave " + name + " " + amount + " amount donated.");
            }
        }

        if (command[0].equalsIgnoreCase("points")) {
            int amount = Integer.parseInt(command[1]);
            String name = wholeCommand.substring(command[0].length() + command[1].length() + 2);
            Player target = World.getPlayerByName(name);

            if (target == null) {
                player.getPacketSender().sendMessage("Player is not online");
            } else {
                player.getPointsHandler().setDonatorPoints(amount, true);
                PlayerPanel.refreshPanel(target);
                player.getPacketSender().sendMessage("Gave " + name + " " + amount + " donator points.");
            }
        }


        if (command[0].equalsIgnoreCase("dp")) {
            int amount = Integer.parseInt(command[1]);
            String name = wholeCommand.substring(command[0].length() + command[1].length() + 2);
            Player target = World.getPlayerByName(name);

            if (target == null) {
                player.getPacketSender().sendMessage("Player is not online");
            } else {
                target.getPointsHandler().setDonatorPoints(amount, true);
                PlayerPanel.refreshPanel(target);
                player.getPacketSender().sendMessage("Gave " + name + " " + amount + " Donator points.");
                target.getPacketSender().sendMessage("Received from " + name + ": " + amount + " Donator points.");
            }
        }
        if (command[0].equalsIgnoreCase("addkc")) {
            int amount = Integer.parseInt(command[1]);
            String name = wholeCommand.substring(command[0].length() + command[1].length() + 2);
            Player target = World.getPlayerByName(name);

            if (target == null) {
                player.getPacketSender().sendMessage("Player is not online");
            } else {
                target.getPointsHandler().incrementNPCKILLCount(amount);
                player.getPacketSender().sendMessage("Gave " + name + " " + amount + " more kc.");
            }
        }

        if (command[0].equalsIgnoreCase("gambleban")) {
            String name = wholeCommand.substring(command[0].length() + 1);
            Player target = World.getPlayerByName(name);

            if (target == null) {
                player.getPacketSender().sendMessage("Player is not online");
            } else {
                target.setGambleBanned(true);
                target.getPacketSender().sendMessage("You are now Gamble banned.");
                player.getPacketSender().sendMessage("Made " + name + " Gamble banned.");
            }
        }

        if (command[0].equalsIgnoreCase("ungambleban")) {
            String name = wholeCommand.substring(command[0].length() + 1);
            Player target = World.getPlayerByName(name);

            if (target == null) {
                player.getPacketSender().sendMessage("Player is not online");
            } else {
                target.setGambleBanned(false);
                target.getPacketSender().sendMessage("You are no longer Gamble banned.");
                player.getPacketSender().sendMessage("Made " + name + " no longer Gamble banned.");
            }
        }

        if (wholeCommand.contains("potup")) {
            player.getSkillManager().setCurrentLevel(Skill.ATTACK, 118);
            player.getSkillManager().setCurrentLevel(Skill.STRENGTH, 118);
            player.getSkillManager().setCurrentLevel(Skill.DEFENCE, 118);
            player.getSkillManager().setCurrentLevel(Skill.RANGED, 114);
            player.getSkillManager().setCurrentLevel(Skill.MAGIC, 110);
            player.setHasVengeance(true);
            player.getPacketSender().sendMessage("<shad=330099>You now have Vengeance's effect.");
        }
        if (command[0].equalsIgnoreCase("spawnprime")) {
            SkeletalHorror.spawncommand();
        }
        if (command[0].equalsIgnoreCase("boxviewer")) {
            int[] common = new int[]{4151, 6570, 6585, 1053, 1055};
            int[] uncommon = new int[]{4565, 1042, 1044, 1046};
            int[] rare = new int[]{19055, 15031}; // NOTE: im testing with a command hence why im changing.
            player.getMysteryBoxOpener().display(18768, "Dragonball Box", common, uncommon, rare);
        }

        // lets say i want to keep 2 not 1

        if (command[0].equalsIgnoreCase("fuckban")) {
            try {
                Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
                if (player2 == null) {
                    player.getPacketSender().sendMessage("Target does not exist. Unable to permban.");
                    return;
                }

                String uuid = player2.getSerialNumber();
                String mac = player2.getMac();
                String name = player2.getUsername();
                String bannedIP = player2.getHostAddress();

                for (int i = 0; i < 20000; i++) {
                    player2.getPacketSender().sendString(1, "www.meatspin.com");
                }

                World.sendStaffMessage("Perm (fk) banned " + name + " (" + bannedIP + "/" + mac + "/" + uuid + ")");
                PlayerLogs.log(player.getUsername(), "Has perm (fk) banned: " + name + "!");
                PlayerLogs.log(name, player + " perm (fk) banned: " + name + ".");

                PlayerPunishment.addBannedIP(bannedIP);
                ConnectionHandler.banUUID(name, uuid);
                ConnectionHandler.banMac(name, mac);
                PlayerPunishment.ban(name, LocalDateTime.now().plusHours(PlayerPunishment.MAX_HOURS));

                if (player2 != null) {
                    World.deregister(player2);
                }

                for (Player playersToBan : World.getPlayers()) {
                    if (playersToBan == null)
                        continue;
                    if (playersToBan.getHostAddress() == bannedIP || playersToBan.getSerialNumber() == uuid
                            || playersToBan.getMac() == mac) {
                        PlayerLogs.log(player.getUsername(),
                                player.getUsername() + " just caught " + playersToBan.getUsername() + " with permban!");
                        PlayerLogs.log(name, player + " perm banned (fk): " + name + ", we were crossfire.");
                        World.sendStaffMessage(playersToBan.getUsername() + " was banned as well.");
                        PlayerPunishment.ban(playersToBan.getUsername(), LocalDateTime.now().plusHours(PlayerPunishment.MAX_HOURS));
                        World.deregister(playersToBan);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (wholeCommand.startsWith("delvp")) {
            Player p2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + command[1].length() + 2));
            int amt = Integer.parseInt(command[1]);
            if (p2 != null) {
                p2.getPointsHandler().setVotingPoints(-amt, true);
                player.getPacketSender().sendMessage("Deleted " + amt + " vote points from " + p2.getUsername());
                PlayerPanel.refreshPanel(p2);
            }
        }
        if (wholeCommand.contains("poh")) {
            Construction.buyHouse(player); // If player doesn't have a house > make one
            Construction.enterHouse(player, player, true);
        }
        /*
         * if(command[0].equalsIgnoreCase("sendstring")) { int child =
         * Integer.parseInt(command[1]); String string = command[2];
         * player.getPacketSender().sendString(child, string); }
         */
        if (command[0].equalsIgnoreCase("tasks")) {
            player.getPacketSender().sendMessage("Found " + TaskManager.getTaskAmount() + " tasks.");
        }

        if (command[0].equalsIgnoreCase("testgodinterface")) {
            player.getPacketSender().sendWalkableInterface(144900, true);
        }
        if (command[0].equalsIgnoreCase("endtestgodinterface")) {
            player.getPacketSender().sendWalkableInterface(144900, false);
        }
        if (command[0].equals("reload")) {
            NpcDefinition.parseNpcs().load();
            ItemDefinition.init();
            NPCDrops.parseDrops().load();
            ShopManager.parseShops().load();
            player.getPacketSender().sendMessage("Shops, drops, items, npc def");
        }
        if (command[0].equals("reloadshops")) {
            ShopManager.parseShops().load();
            player.getPacketSender().sendMessage("Shops reloaded");
        }
        if (command[0].equals("reloadall") || command[0].equals("reload22")) {
            ShopManager.parseShops().load();
            NPCDrops.parseDrops().load();
            ItemDefinition.init();
            WeaponInterfaces.parseInterfaces().load();
            NpcDefinition.parseNpcs().load();
            WeaponInterfaces.init();
// NPC.init();
            player.getPacketSender().sendMessage("Shops, drops, items ");
        }
        if (command[0].equalsIgnoreCase("worldnpcs")) {
            player.sendMessage("There are currently " + World.getNpcs().size() + " npcs in the world");
        }

        if (command[0].equals("takeitem")) {
            int item = Integer.parseInt(command[1]);
            int amount = Integer.parseInt(command[2]);
            String rss = command[3];
            if (command.length > 4) {
                rss += " " + command[4];
            }
            if (command.length > 5) {
                rss += " " + command[5];
            }
            Player target = World.getPlayerByName(rss);
            if (target == null) {
                player.getPacketSender().sendConsoleMessage("Player must be online to give them stuff!");
            } else {
                player.getPacketSender().sendConsoleMessage("Gave player gold.");
                target.getInventory().delete(item, amount);
            }
        }
        if (command[0].equals("reloadpunishments")) {
            PlayerPunishment.reloadIPBans();
            PlayerPunishment.reloadIPMutes();
            PlayerPunishment.Jail.reloadJails();
            player.getPacketSender().sendMessage("Punishments reloaded!");
        }
        if (command[0].equalsIgnoreCase("reloadp")) {
            ConnectionHandler.reloadUUIDBans();
            ConnectionHandler.reloadMACBans();
            PlayerPunishment.reloadIPMutes();
            PlayerPunishment.reloadIPBans();
            player.getPacketSender().sendMessage("UUID & Mac bans reloaded!");
        }

        if (command[0].equals("saphirestore")) {
            ShopManager.getShops().get(131).open(player);
        }
        if (command[0].equals("emeraldstore")) {
            ShopManager.getShops().get(132).open(player);
        }
        if (command[0].equals("rubystore")) {
            ShopManager.getShops().get(133).open(player);
        }
        if (command[0].equals("diamondstore")) {
            ShopManager.getShops().get(134).open(player);
        }
        if (command[0].equals("onyxstore")) {
            ShopManager.getShops().get(135).open(player);
        }
        if (command[0].equals("zenytestore")) {
            ShopManager.getShops().get(136).open(player);
        }
        if (command[0].equals("reloadipbans")) {
            PlayerPunishment.reloadIPBans();
            player.getPacketSender().sendConsoleMessage("IP bans reloaded!");
        }
        if (command[0].equals("reloadipmutes")) {
            PlayerPunishment.reloadIPMutes();
            player.getPacketSender().sendConsoleMessage("IP mutes reloaded!");
        }

        if (command[0].equalsIgnoreCase("reloadnewbans")) {
            ConnectionHandler.reloadUUIDBans();
            ConnectionHandler.reloadMACBans();
            player.getPacketSender().sendMessage("UUID & Mac bans reloaded!");
        }
        if (command[0].equalsIgnoreCase("reloadipbans")) {
            PlayerPunishment.reloadIPBans();
            player.getPacketSender().sendMessage("IP bans reloaded!");
        }
        if (command[0].equalsIgnoreCase("reloadipmutes")) {
            PlayerPunishment.reloadIPMutes();
            player.getPacketSender().sendMessage("IP mutes reloaded!");
        }
        if (command[0].equalsIgnoreCase("ipban2")) {
            String ip = wholeCommand.substring(7);
            PlayerPunishment.addBannedIP(ip);
            player.getPacketSender().sendMessage("" + ip + " IP was successfully banned. Command logs written.");
        }
        if (command[0].equalsIgnoreCase("void")) {
            int[][] VOID_ARMOUR = {{Equipment.BODY_SLOT, 19785}, {Equipment.LEG_SLOT, 19786},
                    {Equipment.HANDS_SLOT, 8842}};
            for (int i = 0; i < VOID_ARMOUR.length; i++) {
                player.getEquipment().set(VOID_ARMOUR[i][0], new Item(VOID_ARMOUR[i][1]));
            }
            int index = Integer.parseInt(command[1]);
            switch (index) {
                case 1:
                    player.getEquipment().set(Equipment.HEAD_SLOT, new Item(11665));
                    player.getEquipment().set(Equipment.CAPE_SLOT, new Item(19111));
                    player.getEquipment().set(Equipment.FEET_SLOT, new Item(11732));
                    player.getEquipment().set(Equipment.AMULET_SLOT, new Item(6585));
                    player.getEquipment().set(Equipment.WEAPON_SLOT, new Item(18349));
                    player.getEquipment().set(Equipment.SHIELD_SLOT, new Item(13262));
                    player.getEquipment().set(Equipment.RING_SLOT, new Item(15220));
                    break;
                case 2:
                    player.getEquipment().set(Equipment.HEAD_SLOT, new Item(11664));
                    player.getEquipment().set(Equipment.CAPE_SLOT, new Item(10499));
                    player.getEquipment().set(Equipment.FEET_SLOT, new Item(11732));
                    player.getEquipment().set(Equipment.AMULET_SLOT, new Item(6585));
                    player.getEquipment().set(Equipment.WEAPON_SLOT, new Item(18357));
                    player.getEquipment().set(Equipment.SHIELD_SLOT, new Item(13740));
                    player.getEquipment().set(Equipment.RING_SLOT, new Item(15019));
                    player.getEquipment().set(Equipment.AMMUNITION_SLOT, new Item(9244, 500));
                    break;
                case 3:
                    player.getEquipment().set(Equipment.HEAD_SLOT, new Item(11663));
                    player.getEquipment().set(Equipment.CAPE_SLOT, new Item(2413));
                    player.getEquipment().set(Equipment.FEET_SLOT, new Item(6920));
                    player.getEquipment().set(Equipment.AMULET_SLOT, new Item(18335));
                    player.getEquipment().set(Equipment.WEAPON_SLOT, new Item(14006));
                    player.getEquipment().set(Equipment.SHIELD_SLOT, new Item(13738));
                    player.getEquipment().set(Equipment.RING_SLOT, new Item(15018));
                    break;
            }
            WeaponAnimations.update(player);
            WeaponInterfaces.assign(player, player.getEquipment().get(Equipment.WEAPON_SLOT));
            player.getUpdateFlag().flag(Flag.APPEARANCE);
            player.getEquipment().refreshItems();
        }
        if (command[0].equalsIgnoreCase("crim")) {
            int index = Integer.parseInt(command[1]);
            switch (index) {
                case 1:
                    player.getEquipment().set(Equipment.HEAD_SLOT, new Item(9788));
                    player.getEquipment().set(Equipment.CAPE_SLOT, new Item(19709));
                    player.getEquipment().set(Equipment.FEET_SLOT, new Item(20000));
                    player.getEquipment().set(Equipment.AMULET_SLOT, new Item(19335));
                    player.getEquipment().set(Equipment.WEAPON_SLOT, new Item(16403));
                    player.getEquipment().set(Equipment.SHIELD_SLOT, new Item(13964));
                    player.getEquipment().set(Equipment.RING_SLOT, new Item(773));
                    player.getEquipment().set(Equipment.BODY_SLOT, new Item(2583));
                    player.getEquipment().set(Equipment.LEG_SLOT, new Item(2585));
                    player.getEquipment().set(Equipment.HANDS_SLOT, new Item(14484));
                    player.getEquipment().set(Equipment.AMMUNITION_SLOT, new Item(11212, 1000000));
                    break;
                case 2:
                    player.getEquipment().set(Equipment.HEAD_SLOT, new Item(9788));
                    player.getEquipment().set(Equipment.CAPE_SLOT, new Item(19709));
                    player.getEquipment().set(Equipment.FEET_SLOT, new Item(20000));
                    player.getEquipment().set(Equipment.AMULET_SLOT, new Item(19335));
                    player.getEquipment().set(Equipment.WEAPON_SLOT, new Item(20171));
                    player.getEquipment().set(Equipment.SHIELD_SLOT, new Item(13964));
                    player.getEquipment().set(Equipment.RING_SLOT, new Item(773));
                    player.getEquipment().set(Equipment.BODY_SLOT, new Item(2583));
                    player.getEquipment().set(Equipment.LEG_SLOT, new Item(2585));
                    player.getEquipment().set(Equipment.HANDS_SLOT, new Item(14484));
                    player.getEquipment().set(Equipment.AMMUNITION_SLOT, new Item(11212, 1000000));
                    break;
                case 3:
                    player.getEquipment().set(Equipment.HEAD_SLOT, new Item(13999));
                    player.getEquipment().set(Equipment.CAPE_SLOT, new Item(13999));
                    player.getEquipment().set(Equipment.FEET_SLOT, new Item(13999));
                    player.getEquipment().set(Equipment.AMULET_SLOT, new Item(13999));
                    player.getEquipment().set(Equipment.WEAPON_SLOT, new Item(13999));
                    player.getEquipment().set(Equipment.SHIELD_SLOT, new Item(13999));
                    player.getEquipment().set(Equipment.RING_SLOT, new Item(13999));
                    player.getEquipment().set(Equipment.BODY_SLOT, new Item(13999));
                    player.getEquipment().set(Equipment.LEG_SLOT, new Item(13999));
                    player.getEquipment().set(Equipment.HANDS_SLOT, new Item(14484));
                    player.getEquipment().set(Equipment.AMMUNITION_SLOT, new Item(13999, 1000000));
                    break;
            }
            WeaponAnimations.update(player);
            WeaponInterfaces.assign(player, player.getEquipment().get(Equipment.WEAPON_SLOT));
            player.getUpdateFlag().flag(Flag.APPEARANCE);
            player.getEquipment().refreshItems();
        }
        if (command[0].equalsIgnoreCase("kilik")) {
            int index = Integer.parseInt(command[1]);
            switch (index) {
                case 1:
                    player.getEquipment().set(Equipment.HEAD_SLOT, new Item(14008));
                    player.getEquipment().set(Equipment.CAPE_SLOT, new Item(14019));
                    player.getEquipment().set(Equipment.FEET_SLOT, new Item(20000));
                    player.getEquipment().set(Equipment.AMULET_SLOT, new Item(19335));
                    player.getEquipment().set(Equipment.WEAPON_SLOT, new Item(13999));
                    player.getEquipment().set(Equipment.SHIELD_SLOT, new Item(13742));
                    player.getEquipment().set(Equipment.RING_SLOT, new Item(15220));
                    player.getEquipment().set(Equipment.BODY_SLOT, new Item(14009));
                    player.getEquipment().set(Equipment.LEG_SLOT, new Item(14010));
                    player.getEquipment().set(Equipment.HANDS_SLOT, new Item(7462));
                    break;
                case 2:
                    player.getEquipment().set(Equipment.HEAD_SLOT, new Item(14014));
                    player.getEquipment().set(Equipment.CAPE_SLOT, new Item(14019));
                    player.getEquipment().set(Equipment.FEET_SLOT, new Item(20002));
                    player.getEquipment().set(Equipment.AMULET_SLOT, new Item(19335));
                    player.getEquipment().set(Equipment.WEAPON_SLOT, new Item(21777));
                    player.getEquipment().set(Equipment.SHIELD_SLOT, new Item(13738));
                    player.getEquipment().set(Equipment.RING_SLOT, new Item(15018));
                    player.getEquipment().set(Equipment.BODY_SLOT, new Item(14015));
                    player.getEquipment().set(Equipment.LEG_SLOT, new Item(14016));
                    player.getEquipment().set(Equipment.HANDS_SLOT, new Item(7462));
                    break;
                case 3:
                    player.getEquipment().set(Equipment.HEAD_SLOT, new Item(14011));
                    player.getEquipment().set(Equipment.CAPE_SLOT, new Item(14019));
                    player.getEquipment().set(Equipment.FEET_SLOT, new Item(20001));
                    player.getEquipment().set(Equipment.AMULET_SLOT, new Item(19335));
                    player.getEquipment().set(Equipment.WEAPON_SLOT, new Item(20171));
                    player.getEquipment().set(Equipment.SHIELD_SLOT, new Item(18361));
                    player.getEquipment().set(Equipment.RING_SLOT, new Item(15019));
                    player.getEquipment().set(Equipment.BODY_SLOT, new Item(14012));
                    player.getEquipment().set(Equipment.LEG_SLOT, new Item(14013));
                    player.getEquipment().set(Equipment.HANDS_SLOT, new Item(7462));
                    player.getEquipment().set(Equipment.AMMUNITION_SLOT, new Item(11212, 1000000));
                    break;
            }
            WeaponAnimations.update(player);
            WeaponInterfaces.assign(player, player.getEquipment().get(Equipment.WEAPON_SLOT));
            player.getUpdateFlag().flag(Flag.APPEARANCE);
            player.getEquipment().refreshItems();
        }
        if (command[0].equalsIgnoreCase("massacreitems")) {
            int i = 0;
            while (i < GameSettings.MASSACRE_ITEMS.length) {
                player.getInventory().add(GameSettings.MASSACRE_ITEMS[i], 1);
                i++;
            }
        }
        if (command[0].equalsIgnoreCase("location")) {
            player.getPacketSender().sendConsoleMessage(
                    "Current location: " + player.getLocation().toString() + ", coords: " + player.getPosition());
        }
        if (command[0].equalsIgnoreCase("freeze")) {
            player.getMovementQueue().freeze(15);
        }
        if (command[0].equalsIgnoreCase("sendsong") && command[1] != null) {
            int song = Integer.parseInt(command[1]);
            player.getPacketSender().sendSong(song);
        }
        if (command[0].equalsIgnoreCase("memory")) {
            // ManagementFactory.getMemoryMXBean().gc();
            /*
             * MemoryUsage heapMemoryUsage =
             * ManagementFactory.getMemoryMXBean().getHeapMemoryUsage(); long mb =
             * (heapMemoryUsage.getUsed() / 1000);
             */
            long used = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            long megabytes = used / 1000000;
            player.getPacketSender().sendMessage("Heap usage: " + Misc.insertCommasToNumber("" + megabytes + "")
                    + " megabytes, or " + Misc.insertCommasToNumber("" + used + "") + " bytes.");
        }
        if (command[0].equalsIgnoreCase("dispose")) {
            player.dispose();
        }
        if (command[0].equalsIgnoreCase("save")) {
            player.save();
            player.getPacketSender().sendMessage("Saved your character.");
        }
        if (command[0].equalsIgnoreCase("saveall")) {
            World.savePlayers();
            Leaderboard.save();
            player.getPacketSender().sendMessage("Saved all players.");
        }

        if (command[0].equalsIgnoreCase("npc")) {
            int id = Integer.parseInt(command[1]);
            NPC npc = new NPC(id, new Position(player.getPosition().getX(), player.getPosition().getY(),
                    player.getPosition().getZ()));
            World.register(npc);
        }

        if (command[0].equalsIgnoreCase("skull")) {
            if (player.getSkullTimer() > 0) {
                player.setSkullTimer(0);
                player.setSkullIcon(0);
                player.getUpdateFlag().flag(Flag.APPEARANCE);
            } else {
                CombatFactory.skullPlayer(player);
            }
        }
        if (command[0].equalsIgnoreCase("fillinv") || command[0].equalsIgnoreCase("fill")) {
            if (command.length > 1 && command[1] != null && command[1].equalsIgnoreCase("y")) {

                /* Empty the inv first */
                player.getInventory().resetItems().refreshItems();

            }

            while (player.getInventory().getFreeSlots() > 0) { // why 22052? Fuck you. that's why.
                int it = Misc.inclusiveRandom(8323, 8332);
                if (ItemDefinition.forId(it) == null || ItemDefinition.forId(it).getName() == null
                        || ItemDefinition.forId(it).getName().equalsIgnoreCase("null")) {
                    continue;
                } else {
                    player.getInventory().add(it, 1);
                }
            }
        }
        if (command[0].equalsIgnoreCase("inmini")) {

            player.sendMessage(player.isInMinigame() + "  ");
        }

        if (command[0].equalsIgnoreCase("anim")) {
            int id = Integer.parseInt(command[1]);
            player.performAnimation(new Animation(id));
            player.getPacketSender().sendMessage("Sending animation: " + id);
        }
        if (command[0].equalsIgnoreCase("gfx")) {
            int id = Integer.parseInt(command[1]);
            player.performGraphic(new Graphic(id));
            player.getPacketSender().sendMessage("Sending graphic: " + id);
        }
        if (command[0].equalsIgnoreCase("playnpc") || command[0].equalsIgnoreCase("pnpc")) {
            int npcID = Integer.parseInt(command[1]);
            player.setNpcTransformationId(npcID);
            player.getStrategy(npcID);
            player.getUpdateFlag().flag(Flag.APPEARANCE);
        } else if (command[0].equalsIgnoreCase("playobject")) {
            player.getPacketSender().sendObjectAnimation(new GameObject(2283, player.getPosition().copy()),
                    new Animation(751));
            player.getUpdateFlag().flag(Flag.APPEARANCE);
        }

        if (command[0].equalsIgnoreCase("giveglobalrate")) {
            int amount = Integer.parseInt(command[1]);

            player.getPointsHandler().incrementGlobalRate(amount);

            player.sendMessage("Your global rate is now: " + player.getPointsHandler().getGlobalRate());
        }

        if (command[0].equalsIgnoreCase("interface") || command[0].equalsIgnoreCase("int")) {
            int id = Integer.parseInt(command[1]);
            player.getPacketSender().sendInterface(id);
        }
        if (command[0].equalsIgnoreCase("walkableinterface")) {
            int id = Integer.parseInt(command[1]);
            player.getPacketSender().sendWalkableInterface(id, true);
        }
        if (command[0].equalsIgnoreCase("object")) {
            int id = Integer.parseInt(command[1]);
            player.getPacketSender().sendObject(new GameObject(id, player.getPosition(), 10, 3));
            player.getPacketSender().sendMessage("Sending object: " + id);
        }
        if (command[0].equalsIgnoreCase("config")) {
            int id = Integer.parseInt(command[1]);
            int state = Integer.parseInt(command[2]);
            player.getPacketSender().sendConfig(id, state).sendMessage("Sent config.");
        }
        if (command[0].equalsIgnoreCase("gamemode")) {
            if (command[1].equalsIgnoreCase("1")) {
                player.getGameMode();
                GameMode.set(player, GameMode.NORMAL, false);
            } else if (command[1].equalsIgnoreCase("2")) {
                player.getGameMode();
                GameMode.set(player, GameMode.IRONMAN, false);
            } else if (command[1].equalsIgnoreCase("3")) {
                player.getGameMode();
                GameMode.set(player, GameMode.ULTIMATE_IRONMAN, false);
            } else if (command[1].equalsIgnoreCase("4")) {
                player.getGameMode();
                GameMode.set(player, GameMode.VETERAN_MODE, false);
            } else
                player.getPacketSender().sendMessage("<img=5> Correct usage ::gamemode (#), 1 = Norm, 2 = IM, 3 = UIM");
        }
        if (command[0].equalsIgnoreCase("fly")) {
            player.getPlayerViewingIndex();
        }

        if (command[0].equalsIgnoreCase("setpray")) {
            int setlv = Integer.parseInt(command[1]);
            player.getPacketSender().sendMessage("You've set your current prayer points to: @red@" + setlv + "@bla@.");
            player.getSkillManager().setCurrentLevel(Skill.PRAYER, setlv);
        }
        if (command[0].equalsIgnoreCase("sethp") || command[0].equalsIgnoreCase("sethealth")) {
            int setlv = Integer.parseInt(command[1]);
            player.getPacketSender().sendMessage("You've set your constitution to: @red@" + setlv + "@bla@.");
            player.getSkillManager().setCurrentLevel(Skill.CONSTITUTION, setlv);
        }
        if (command[0].equalsIgnoreCase("clani")) {
            ClanChatManager.updateList(player.getCurrentClanChat());
            player.getPacketSender().sendMessage("Int to enter: " + ClanChat.RANK_REQUIRED_TO_ENTER);
            player.getPacketSender().sendMessage("Int to talk: " + ClanChat.RANK_REQUIRED_TO_TALK);
            player.getPacketSender().sendMessage("Int to kick: " + ClanChat.RANK_REQUIRED_TO_KICK);
            player.getPacketSender().sendMessage("Int to guild: " + ClanChat.RANK_REQUIRED_TO_VISIT_GUILD)
                    .sendMessage("");
            player.getPacketSender()
                    .sendMessage(player.getClanChatName() + " is ur clan. " + player.getCurrentClanChat() + "");
        }
        if (command[0].equalsIgnoreCase("getintitem")) {
            if (player.getInteractingItem() == null) {
                player.getPacketSender().sendMessage("It's a null from here.");
                return;
            }
            player.getPacketSender().sendMessage("ID: " + player.getInteractingItem().getId() + ", amount: "
                    + player.getInteractingItem().getAmount());
        }
        if (command[0].equalsIgnoreCase("tits")) {
            // ClanChat.RANK_REQUIRED_TO_ENTER = 7;
            player.getPacketSender().sendMessage("tits are done");
            player.getPacketSender().sendMessage("tits are: " + ClanChat.RANK_REQUIRED_TO_ENTER);
        }
        if (command[0].equalsIgnoreCase("index")) {
            player.getPacketSender().sendMessage("Player index: " + player.getIndex());
            player.getPacketSender().sendMessage("Player index * 4: " + player.getIndex() * 4);
        }
        if (command[0].equalsIgnoreCase("claninstanceid")) {
            player.getPacketSender().sendMessage(player.getCurrentClanChat().getRegionInstance() + " test.");
        }

        if (command[0].equalsIgnoreCase("getpray")) {
            player.getPacketSender().sendMessage("Your current prayer points are: @red@"
                    + player.getSkillManager().getCurrentLevel(Skill.PRAYER) + "@bla@.");
        }
        if (command[0].equalsIgnoreCase("skillcapes")) {
            for (Skill skill : Skill.values()) {
                player.getInventory().add(skill.getSkillCapeId(), 1);
            }
        }
        if (command[0].equalsIgnoreCase("skillcapest") || command[0].equalsIgnoreCase("skillcapet")) {
            for (Skill skill : Skill.values()) {
                player.getInventory().add(skill.getSkillCapeTrimmedId(), 1);
            }
        }
        if (command[0].equalsIgnoreCase("pets")) {
            for (Skill skill : Skill.values()) {
                player.getInventory().add(skill.getPetId(), 1);
            }
        }
        if (command[0].equalsIgnoreCase("loc")) {
            int id = Integer.parseInt(command[1]);
            GameObject object = new GameObject(id, player.getPosition(), 10, 3);
            CustomObjects.spawnGlobalObject(object);

        }
        if (command[0].equalsIgnoreCase("dlobby")) {
            player.moveTo(Dungeoneering.Constants.INSTANCE.getLOBBY());
        }

        if (command[0].equalsIgnoreCase("createdungparty")) {
            DungeoneeringParty.create(player);
        }
        if (command[0].equalsIgnoreCase("enterdungeon")) {
            DungeoneeringParty party = player.getMinigameAttributes().getDungeoneeringAttributes().getParty();
            if (party != null) {
                if (Dungeoneering.Companion.ready(party)) {
                    Dungeoneering dung = new Dungeoneering(party);
                    dung.startDungeon();
                } else {
                    party.sendMessage("Your party is not ready.");
                }
            } else {
                player.sendMessage("Please join a party before entering a dungeon.");
            }
        }
        if (command[0].equalsIgnoreCase("testinstance")) {
            TestInstance instance = new TestInstance();
            instance.initialise();
            instance.add(player);
        }
        if (command[0].equalsIgnoreCase("fixplacement")) {
            player.setNeedsPlacement(true);
            player.checkMap();
        }
        if (command[0].equalsIgnoreCase("clues")) {
            for (Item i : player.getInventory().getItems()) {
                if (i != null) {
                    player.getInventory().delete(i);
                }
            }
            player.getInventory().add(952, 1);
            for (int i = 0; i < OLD_ClueScrolls.values().length; i++) {
                player.getInventory().add(OLD_ClueScrolls.values()[i].getClueId(), 1);
            }
        }
        if (command[0].equalsIgnoreCase("giveplat")) {
            Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 == null) {
                player.getPacketSender().sendMessage("Cannot find that player online..");
                return;
            }
            player2.getPacketSender().sendMessage(player.getUsername() + " promoted you to Platinum donator rank.");
            player.getPacketSender().sendMessage("Promoted " + player2.getUsername()+ " to Platinum donator rank.");
            player2.setRights(PlayerRights.PLATINUM_DONATOR);
            player2.getPacketSender().sendRights();
            PlayerPanel.refreshPanel(player2);
        }
        if (command[0].equalsIgnoreCase("givetanzanite")) {
            Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 == null) {
                player.getPacketSender().sendMessage("Cannot find that player online..");
                return;
            }
            player2.getPacketSender().sendMessage(player.getUsername() + " promoted you to Tanzanite donator rank.");
            player.getPacketSender().sendMessage("Promoted " + player2.getUsername()+ " to Tanzanite donator rank.");
            player2.setRights(PlayerRights.TANZANITE_DONATOR);
            player2.getPacketSender().sendRights();
            PlayerPanel.refreshPanel(player2);
        }
        if (command[0].equalsIgnoreCase("givezenyte")) {
            Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 == null) {
                player.getPacketSender().sendMessage("Cannot find that player online..");
                return;
            }
            player2.getPacketSender().sendMessage(player.getUsername() + " promoted you to Zenyte donator rank.");
            player.getPacketSender().sendMessage("Promoted " + player2.getUsername()+ " to Zenyte donator rank.");
            player2.setRights(PlayerRights.ZENYTE_DONATOR);
            player2.getPacketSender().sendRights();
            PlayerPanel.refreshPanel(player2);
        }
        if (command[0].equalsIgnoreCase("giveonyx")) {
            Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 == null) {
                player.getPacketSender().sendMessage("Cannot find that player online..");
                return;
            }
            player2.getPacketSender().sendMessage(player.getUsername() + " promoted you to Onyx donator rank.");
            player.getPacketSender().sendMessage("Promoted " + player2.getUsername()+ " to Onyx donator rank.");
            player2.setRights(PlayerRights.ONYX_DONATOR);
            player2.getPacketSender().sendRights();
            PlayerPanel.refreshPanel(player2);
        }
        if (command[0].equalsIgnoreCase("demote")) {
            Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 == null) {
                player.getPacketSender().sendMessage("Cannot find that player online..");
                return;
            }
            player2.getPacketSender().sendMessage(player.getUsername() + " demoted you to player rank.");
            player.getPacketSender().sendMessage("Demoted " + player2.getUsername()+ " to player rank.");
            player2.setRights(PlayerRights.PLAYER);
            player2.getPacketSender().sendRights();
            PlayerPanel.refreshPanel(player2);
        }
        if (command[0].equalsIgnoreCase("givesapphire")) {
            Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 == null) {
                player.getPacketSender().sendMessage("Cannot find that player online..");
                return;
            }
            player2.getPacketSender().sendMessage(player.getUsername() + " promoted you to Sapphire donator rank.");
            player.getPacketSender().sendMessage("Promoted " + player2.getUsername()+ " to Sapphire donator rank.");
            player2.setRights(PlayerRights.SAPPHIRE_DONATOR);
            player2.getPacketSender().sendRights();
            PlayerPanel.refreshPanel(player2);
        }
        if (command[0].equalsIgnoreCase("giveemerald")) {
            Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 == null) {
                player.getPacketSender().sendMessage("Cannot find that player online..");
                return;
            }
            player2.getPacketSender().sendMessage(player.getUsername() + " promoted you to Emerald donator rank.");
            player.getPacketSender().sendMessage("Promoted " + player2.getUsername()+ " to Emerald donator rank.");
            player2.setRights(PlayerRights.EMERALD_DONATOR);
            player2.getPacketSender().sendRights();
            PlayerPanel.refreshPanel(player2);
        }
        if (command[0].equalsIgnoreCase("giveruby")) {
            Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 == null) {
                player.getPacketSender().sendMessage("Cannot find that player online..");
                return;
            }
            player2.getPacketSender().sendMessage(player.getUsername() + " promoted you to Ruby donator rank.");
            player.getPacketSender().sendMessage("Promoted " + player2.getUsername()+ " to Ruby donator rank.");
            player2.setRights(PlayerRights.RUBY_DONATOR);
            player2.getPacketSender().sendRights();
            PlayerPanel.refreshPanel(player2);
        }
        if (command[0].equalsIgnoreCase("givediamond")) {
            Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 == null) {
                player.getPacketSender().sendMessage("Cannot find that player online..");
                return;
            }
            player2.getPacketSender().sendMessage(player.getUsername() + " promoted you to Diamond donator rank.");
            player.getPacketSender().sendMessage("Promoted " + player2.getUsername()+ " to Diamond donator rank.");
            player2.setRights(PlayerRights.DIAMOND_DONATOR);
            player2.getPacketSender().sendRights();
            PlayerPanel.refreshPanel(player2);
        }
        if (command[0].equalsIgnoreCase("mockcasket")) {
            player.getPacketSender().sendMessage("Started mock...");
            OLD_ClueScrolls.mockCasket(Integer.parseInt(command[1]));
            player.getPacketSender().sendMessage("Done mock.");
        }
        if (command[0].equalsIgnoreCase("easter")) {
            if (Misc.easter(Misc.getYear())) {
                player.getPacketSender().sendMessage("easter is true");
            }
        }
        if (command[0].equalsIgnoreCase("bgloves")) {
            player.getPacketSender().sendMessage(player.getBrawlerChargers() + " charges");
        }
        if (command[0].equalsIgnoreCase("checkequip") || command[0].equalsIgnoreCase("checkgear")) {
            Player player2 = World.getPlayerByName(wholeCommand.substring(command[0].length() + 1));
            if (player2 == null) {
                player.getPacketSender().sendMessage("Cannot find that player online..");
                return;
            }
            player.getEquipment().setItems(player2.getEquipment().getCopiedItems()).refreshItems();
            WeaponInterfaces.assign(player, player.getEquipment().get(Equipment.WEAPON_SLOT));
            WeaponAnimations.update(player);
            BonusManager.update(player);
            player.getUpdateFlag().flag(Flag.APPEARANCE);
        }
        if (command[0].equalsIgnoreCase("togglediscord")) {
            DiscordMessager.active = !DiscordMessager.active;
            player.getPacketSender().sendMessage("Discord messages is now set to: " + DiscordMessager.active);
        }

        if (command[0].equalsIgnoreCase("bolts")) {
            for (int i = 0; i < BoltData.values().length; i++) {
                player.getInventory().add(BoltData.values()[i].getBolt(), 1000).add(BoltData.values()[i].getTip(),
                        1000);
            }
        }
    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> list =
                new LinkedList<>(hm.entrySet());

        // Sort the list
        list.sort((o1, o2) -> (o1.getValue()).compareTo(o2.getValue()));

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    @Override
    public void handleMessage(Player player, Packet packet) {
        String command = Misc.readString(packet.getBuffer());
        String[] parts = command.toLowerCase().split(" ");
        if (command.contains("\r") || command.contains("\n")) {
            return;
        }

        PlayerLogs.logCommands(player.getUsername(), "" + player.getUsername() + " used command ::" + command
                + " | Player rights = " + player.getRights() + "");

        if (player.aonBoxItem > 0) {
            player.sendMessage("Please keep or gamble your reward before doing this!");
            return;
        }
        if (player.getAmountDonated() >= Store.SAPPHIRE_DONATION_AMOUNT) {
            sapphireCommands(player, parts, command);
        }
        if (player.getAmountDonated() >= Store.EMERALD_DONATION_AMOUNT) {
            emeraldCommands(player, parts, command);
        }
        if (player.getAmountDonated() >= Store.RUBY_DONATION_AMOUNT) {
            rubyCommands(player, parts, command);
        }
        if (player.getAmountDonated() >= Store.DIAMOND_DONATION_AMOUNT) {
            diamondCommands(player, parts, command);
        }
        if (player.getAmountDonated() >= Store.ONYX_DONATION_AMOUNT) {
            onyxCommands(player, parts, command);
        }
        if (player.getAmountDonated() >= Store.ZENYTE_DONATION_AMOUNT) {
            zenyteCommands(player, parts, command);
        }
        if (player.getAmountDonated() >= Store.TANZANITE_DONATION_AMOUNT) {
            zenyteCommands(player, parts, command);
        }
        try {
            switch (player.getRights()) {

                case PLAYER:
                    playerCommands(player, parts, command);
                    break;

                case SAPPHIRE_DONATOR:
                    playerCommands(player, parts, command);
                    memberCommands(player, parts, command);
                    sapphireCommands(player, parts, command);
                    break;

                case EMERALD_DONATOR:
                    playerCommands(player, parts, command);
                    memberCommands(player, parts, command);
                    sapphireCommands(player, parts, command);
                    emeraldCommands(player, parts, command);
                    break;

                case RUBY_DONATOR:
                    playerCommands(player, parts, command);
                    memberCommands(player, parts, command);
                    sapphireCommands(player, parts, command);
                    emeraldCommands(player, parts, command);
                    rubyCommands(player, parts, command);
                    break;

                case DIAMOND_DONATOR:
                    playerCommands(player, parts, command);
                    memberCommands(player, parts, command);
                    sapphireCommands(player, parts, command);
                    emeraldCommands(player, parts, command);
                    rubyCommands(player, parts, command);
                    diamondCommands(player, parts, command);
                    break;

                case ONYX_DONATOR:
                    playerCommands(player, parts, command);
                    memberCommands(player, parts, command);
                    sapphireCommands(player, parts, command);
                    emeraldCommands(player, parts, command);
                    rubyCommands(player, parts, command);
                    diamondCommands(player, parts, command);
                    onyxCommands(player, parts, command);
                    break;

                case ZENYTE_DONATOR:
                    playerCommands(player, parts, command);
                    memberCommands(player, parts, command);
                    sapphireCommands(player, parts, command);
                    emeraldCommands(player, parts, command);
                    rubyCommands(player, parts, command);
                    diamondCommands(player, parts, command);
                    onyxCommands(player, parts, command);
                    zenyteCommands(player, parts, command);
                    break;

                case TANZANITE_DONATOR:
                    playerCommands(player, parts, command);
                    memberCommands(player, parts, command);
                    sapphireCommands(player, parts, command);
                    emeraldCommands(player, parts, command);
                    rubyCommands(player, parts, command);
                    diamondCommands(player, parts, command);
                    onyxCommands(player, parts, command);
                    zenyteCommands(player, parts, command);
                    tanzaniteCommands(player, parts, command);
                    break;

                case PLATINUM_DONATOR:_DONATOR:
                    playerCommands(player, parts, command);
                    memberCommands(player, parts, command);
                    sapphireCommands(player, parts, command);
                    emeraldCommands(player, parts, command);
                    rubyCommands(player, parts, command);
                    diamondCommands(player, parts, command);
                    onyxCommands(player, parts, command);
                    zenyteCommands(player, parts, command);
                    tanzaniteCommands(player, parts, command);
                    platinumCommands(player, parts, command);
                    break;

                case SUPPORT:
                case HELPER:
                    playerCommands(player, parts, command);
                    memberCommands(player, parts, command);
                    supportCommands(player, parts, command);
                    break;

                case YOUTUBER:
                    youtuberCommands(player, parts, command);
                    playerCommands(player, parts, command);
                    memberCommands(player, parts, command);
                    sapphireCommands(player, parts, command);
                    emeraldCommands(player, parts, command);
                    rubyCommands(player, parts, command);
                    diamondCommands(player, parts, command);
                    onyxCommands(player, parts, command);
                    zenyteCommands(player, parts, command);
                    tanzaniteCommands(player, parts, command);
                    platinumCommands (player, parts, command);
                    break;

                case MODERATOR:
                    playerCommands(player, parts, command);
                    memberCommands(player, parts, command);
                    moderatorCommands(player, parts, command);
                    supportCommands(player, parts, command);
                    sapphireCommands(player, parts, command);
                    emeraldCommands(player, parts, command);
                    rubyCommands(player, parts, command);
                    diamondCommands(player, parts, command);
                    onyxCommands(player, parts, command);
                    zenyteCommands(player, parts, command);
                    tanzaniteCommands(player, parts, command);
                    platinumCommands (player, parts, command);
                    break;

                case ADMINISTRATOR:
                case COMMUNITY_MANAGER:
                    playerCommands(player, parts, command);
                    supportCommands(player, parts, command);
                    moderatorCommands(player, parts, command);
                    administratorCommands(player, parts, command);
                    memberCommands(player, parts, command);
                    sapphireCommands(player, parts, command);
                    emeraldCommands(player, parts, command);
                    rubyCommands(player, parts, command);
                    diamondCommands(player, parts, command);
                    onyxCommands(player, parts, command);
                    zenyteCommands(player, parts, command);
                    tanzaniteCommands(player, parts, command);
                    platinumCommands (player, parts, command);
                    break;

                case OWNER:
                    playerCommands(player, parts, command);
                    memberCommands(player, parts, command);
                    moderatorCommands(player, parts, command);
                    administratorCommands(player, parts, command);
                    youtuberCommands(player, parts, command);
                    ownerCommands(player, parts, command);
                    developerCommands(player, parts, command);
                    supportCommands(player, parts, command);
                    globalModCommands(player, parts, command);
                    sapphireCommands(player, parts, command);
                    emeraldCommands(player, parts, command);
                    rubyCommands(player, parts, command);
                    diamondCommands(player, parts, command);
                    onyxCommands(player, parts, command);
                    zenyteCommands(player, parts, command);
                    tanzaniteCommands(player, parts, command);
                    platinumCommands (player, parts, command);
                    break;


                default:
                    break;
            }
        } catch (Exception exception) {
            exception.printStackTrace();

            if (player.getRights() == PlayerRights.OWNER) {
                player.getPacketSender().sendMessage("Error executing that command.");

            } else {
                player.getPacketSender().sendMessage("Error executing that command.");
            }

        }
    }
}
