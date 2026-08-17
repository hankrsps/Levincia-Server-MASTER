package com.ruse.world.entity.impl.player;

import com.ruse.GameServer;
import com.ruse.GameSettings;
import com.ruse.engine.task.TaskManager;
import com.ruse.engine.task.impl.*;
import com.ruse.model.*;
import com.ruse.model.Locations.Location;
import com.ruse.model.container.impl.Bank;
import com.ruse.model.container.impl.Equipment;
import com.ruse.model.definitions.WeaponAnimations;
import com.ruse.model.definitions.WeaponInterfaces;
import com.ruse.model.input.impl.EnterPinPacketListener;
import com.ruse.net.PlayerSession;
import com.ruse.net.SessionState;
import com.ruse.net.packet.impl.Afking;
import com.ruse.net.security.ConnectionHandler;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.allornothing.DoubleOrNothing;
import com.ruse.world.content.*;
import com.ruse.world.content.KillsTracker.KillsEntry;
import com.ruse.world.content.clan.ClanChatManager;
import com.ruse.world.content.combat.effect.CombatPoisonEffect;
import com.ruse.world.content.combat.effect.CombatTeleblockEffect;
import com.ruse.world.content.combat.magic.Autocasting;
import com.ruse.world.content.combat.prayer.CurseHandler;
import com.ruse.world.content.combat.prayer.PrayerHandler;
import com.ruse.world.content.combat.pvp.BountyHunter;
import com.ruse.world.content.combat.range.DwarfMultiCannon;
import com.ruse.world.content.combat.weapon.CombatSpecial;
import com.ruse.world.content.dialogue.DialogueManager;
//import com.ruse.world.content.discordbot.DiscordIntegration;
import com.ruse.world.content.minigames.impl.Barrows;
import com.ruse.world.content.minigames.impl.VoidOfDarkness;
import com.ruse.world.content.progressionzone.ProgressionZone;
import com.ruse.world.content.progressionzone.ZoneData;
import com.ruse.world.content.serverperks.ServerPerks;
import com.ruse.world.content.skeletalhorror.SkeletalHorror;
import com.ruse.world.content.skill.impl.hunter.Hunter;
import com.ruse.world.content.skill.impl.slayer.Slayer;
import com.ruse.world.content.startertasks.StarterTasks;
import com.ruse.world.entity.impl.GlobalItemSpawner;
import com.ruse.world.instance.MapInstance;
import mysql.impl.Store;
import org.mindrot.jbcrypt.BCrypt;

//import com.ruse.world.content.Abyssector;

public class PlayerHandler {

    public static void handleLogin(Player player) {
        World.playerMap ().put (player.getLongUsername (), player);

        // Register the player
        System.out.println ("[World] Registering player - [username, host] : [" + player.getUsername () + ", "
                + player.getHostAddress () + "]");

        PlayerLogs.logPlayerLoginWithIP (player.getUsername (), "Login from host " + player.getHostAddress ()
                + ", serial number: " + player.getSerialNumber () + ", mac address:" + player.getMac ());
        PlayerLogs.logPlayerLogin (player.getUsername (), "Login ");
        player.getControllerManager ().login ();
        player.getPlayerOwnedShopManager ().hookShop ();
        ConnectionHandler.add (player.getHostAddress ());
        World.addPlayer (player);
        World.updatePlayersOnline ();
        PlayersOnlineInterface.add (player);
        player.getSession ().setState (SessionState.LOGGED_IN);

        // Packets
        player.getPacketSender ().sendDetails ();
        player.loadMap (true);
        player.getRecordedLogin ().reset ();

        //Mbox spinner
        player.getNewSpinner ().clearMysteryBox ();

        // Tabs
        player.getPacketSender ().sendTabs ();
        if (player.getWalkableInterfaceId () == 29050) {
            player.getPacketSender ().sendWalkableInterface (29050, false);
        }
        ServerPerks.getInstance ().updateOverlay (player);
        player.getPacketSender ().sendString (29053, "").sendString (29054, "");

        for (int i = 0; i < 10; i++) {
            player.getPacketSender ().sendString (29095 + i, "");
        }

        // Setting up the player's item containers..
        for (int i = 0; i < player.getBanks ().length; i++) {
            if (player.getBank (i) == null) {
                player.setBank (i, new Bank (player));
            }
        }
        player.getInventory ().refreshItems ();
        player.getEquipment ().refreshItems ();

        player.getEventChestHandler ().loadEventChest (player);
        player.getEventChestHandler ().generateRewards (player);
        if (player.getHasPin () == true && !player.getSavedIp ().equalsIgnoreCase (player.getHostAddress ())) {
            player.setPlayerLocked (true);
        }
        // Weapons and equipment..
        WeaponAnimations.update (player);
        WeaponInterfaces.assign (player, player.getEquipment ().get (Equipment.WEAPON_SLOT));
        CombatSpecial.updateBar (player);
        BonusManager.update (player);

        // Skills
        player.getSummoning ().login ();
        player.getFarming ().load ();
        player.getLeaderboardManager ().updateData ();
        //player.getBestItems().fillDefinitions();
        Slayer.checkDuoSlayer (player, true);
        for (Skill skill : Skill.values ()) {
            player.getSkillManager ().updateSkill (skill);
        }

        // Relations
        player.getRelations ().setPrivateMessageId (1).onLogin (player).updateLists (true);

        // Client configurations
        player.getPacketSender ().sendConfig (172, player.isAutoRetaliate () ? 1 : 0)
                .sendTotalXp (player.getSkillManager ().getTotalGainedExp ())
                .sendConfig (player.getFightType ().getParentId (), player.getFightType ().getChildId ()).sendRunStatus ()
                .sendRunEnergy (player.getRunEnergy ()).sendRights ().sendString (8135, "" + player.getMoneyInPouch ())
                .sendInteractionOption ("Follow", 3, false).sendInteractionOption ("Trade With", 4, false);

        if (player.getHasPin () == true && !player.getSavedIp ().equalsIgnoreCase (player.getHostAddress ())) {
            player.setInputHandling (new EnterPinPacketListener ());
            player.getPacketSender ().sendEnterInputPrompt ("Enter your pin to play#confirmstatus");
        } else {
            player.setDialogueActionId (96765);
            DialogueManager.start (player, 96765);
            //  // System.out.println("Player: " + player.getUsername() + " Didn't have pin set");
        }

        Autocasting.onLogin (player);
        PrayerHandler.deactivateAll (player);
        CurseHandler.deactivateAll (player);
        BonusManager.sendCurseBonuses (player);
        Barrows.handleLogin (player);
        VoidOfDarkness.handleLogin (player);
        // Tasks
        TaskManager.submit (new PlayerSkillsTask (player));
        TaskManager.submit (new PlayerRegenConstitutionTask (player));
        TaskManager.submit (new SummoningRegenPlayerConstitutionTask (player));
        if (player.isPoisoned ()) {
            TaskManager.submit (new CombatPoisonEffect (player));
        }
        player.getBonusXp ().init ();
        if (player.getPrayerRenewalPotionTimer () > 0) {
            TaskManager.submit (new PrayerRenewalPotionTask (player));
        }
        if (player.getOverloadPotionTimer () > 0) {
            TaskManager.submit (new OverloadPotionTask (player));
        }
        if (player.getTeleblockTimer () > 0) {
            TaskManager.submit (new CombatTeleblockEffect (player));
        }
        if (ProgressionZone.getCurrentZone (player) == ZoneData.Monsters.PHASE_6)
            StarterTasks.doProgress (player, StarterTasks.StarterTask.COMPLETE_STARTER_ZONE);

        if (player.getDoubleDRTimer () > 0) {
            if (player.getDoubleDRTimer () > 3000) {
                player.getPacketSender ().sendEffectTimerSeconds (player.getDoubleDRTimer () * 60 / 100, EffectTimer.X2_DR_1HR);
            } else {
                player.getPacketSender ().sendEffectTimerSeconds (player.getDoubleDRTimer () * 60 / 100, EffectTimer.X2_DR_30MIN);
            }
            TaskManager.submit (new DoubleDRTask (player));
        }
        if (player.getDoubleDDRTimer () > 0) {
            player.getPacketSender ().sendEffectTimerSeconds (player.getDoubleDDRTimer () * 60 / 100, EffectTimer.X2_DDR_1HR);
            TaskManager.submit (new DoubleDDRTask (player));
        }
        if (player.getDoubleDMGTimer () > 0) {
            if (player.getDoubleDMGTimer () > 3000) {
                player.getPacketSender ().sendEffectTimerSeconds (player.getDoubleDMGTimer () * 60 / 100, EffectTimer.X2_DMG_1HR);
            } else {
                player.getPacketSender ().sendEffectTimerSeconds (player.getDoubleDMGTimer () * 60 / 100, EffectTimer.X2_DMG_30MIN);
            }
            TaskManager.submit (new DoubleDMGTask (player));
        }


        player.getDonationDeals ().shouldReset ();

        if (player.getSkullTimer () > 0) {
            player.setSkullIcon (1);
            TaskManager.submit (new CombatSkullEffect (player));
        }

        if (System.currentTimeMillis () > (player.lastLogin + 86400000)) {
            player.getDailyRewards ().resetData ();
        }

        player.getDailyRewards ().handleDailyLogin ();

        player.lastLogin = System.currentTimeMillis ();

        player.getDailyRewards ().setDataOnLogin ();

        if (player.getFireImmunity () > 0) {
            FireImmunityTask.makeImmune (player, player.getFireImmunity (), player.getFireDamageModifier ());
        }
        if (player.getSpecialPercentage () < 100) {
            TaskManager.submit (new PlayerSpecialAmountTask (player));
        }
        if (player.hasStaffOfLightEffect ()) {
            TaskManager.submit (new StaffOfLightSpecialAttackTask (player));
        }
        if (player.getMinutesBonusExp () >= 0) {
            TaskManager.submit (new BonusExperienceTask (player));
        }
        if (player.getMinutesVotingDR () > 0) {
            TaskManager.submit (new VotingDRBoostTask (player));
        }
        if (player.getMinutesVotingDMG () > 0) {
            TaskManager.submit (new VotingDMGBoostTask (player));
        }

        // Update appearance

        // Others
        Lottery.onLogin (player);
        Locations.login (player);

        if (player.getLocation () != Locations.Location.PROGRESSION_ZONES) {
            player.getPacketSender ().sendWalkableInterface (112000, false);
        }

        if (player.getLocation () == Location.KEEPERS_OF_LIGHT_LOBBY || player.getLocation () == Location.KEEPERS_OF_LIGHT_GAME) {
            player.getPacketSender ().sendWalkableInterface (21005, false);
        }

        player.getPacketSender ().sendMessage ("<shad=1>@bla@Welcome to " + GameSettings.RSPS_NAME + "!");
        if (GameSettings.ELITE_DONO_DEAL == true)
            player.getPacketSender ().sendMessage ("<img=832>@blu@Dono-Deal @red@Every 50 Donated you will get @red@<shad=1>x1 Elite Goodiebag!");
        if (GameSettings.CASE_KEY_DEAL == true)
            player.getPacketSender ().sendMessage ("<img=832>@blu@Dono-Deal @red@Every 50 Donated you will get @red@<shad=1>x15 Case keys!");
        if (GameSettings.OWNER_JEWELRY_DONO_DEAL == true)
            player.getPacketSender ().sendMessage ("<img=832>@blu@Dono-Deal @red@Every 50 Donated you will get @red@<shad=1>x1 Owner Jewelry Goodiebag!");
        if (GameSettings.OWNER_CAPE_DONO_DEAL == true)
            player.getPacketSender ().sendMessage ("<img=832>@blu@Dono-Deal @red@Every 50 Donated you will get @red@<shad=1>x1 Owner Cape Goodiebag!");
        if (GameSettings.AUTUMN_DEAL == true)
            player.getPacketSender ().sendMessage ("<img=832>@blu@Dono-Deal @red@Every 50 Donated you will get @red@<shad=1>x5 Autumn boxes!");
        if (GameSettings.BCRYPT_HASH_PASSWORDS && Misc.needsNewSalt (player.getSalt ())) {
            player.setSalt (BCrypt.gensalt (GameSettings.BCRYPT_ROUNDS));
        }

        if (Wildywyrm.wyrmAlive) {
            Wildywyrm.sendHint (player);
        }
        if (SkeletalHorror.wyrmAlive) {
            SkeletalHorror.sendHint (player);
        }
        if (WellOfGoodwill.isActive ()) {
            player.getPacketSender ().sendMessage (MessageType.SERVER_ALERT,
                    "The Well of Goodwill is granting 30% bonus experience for another "
                            + WellOfGoodwill.getMinutesRemaining () + " minutes.");
        }
/*
        if (player.isUnlockedSet1 ()) {
            player.setCurrentWardrobe (WardrobeData.COSTUME_2);
            player.getWardrobeData ().setOutfitUnlocked (true);
        }

        if (player.isUnlockedSet2 ()) {
            player.setCurrentWardrobe (WardrobeData.COSTUME_1);
            player.getWardrobeData ().setOutfitUnlocked (true);
        }

        if (player.isUnlockedSet3 ()) {
            player.setCurrentWardrobe (WardrobeData.COSTUME_3);
            player.getWardrobeData ().setOutfitUnlocked (true);
        }

        if (player.isUnlockedSet4 ()) {
            player.setCurrentWardrobe (WardrobeData.COSTUME_4);
            player.getWardrobeData ().setOutfitUnlocked (true);
        }

        if (player.isUnlockedSet5 ()) {
            player.setCurrentWardrobe (WardrobeData.COSTUME_5);
            player.getWardrobeData ().setOutfitUnlocked (true);
        }

        if (player.isUnlockedSet6 ()) {
            player.setCurrentWardrobe (WardrobeData.COSTUME_6);
            player.getWardrobeData ().setOutfitUnlocked (true);
        }

        if (player.isUnlockedSet7 ()) {
            player.setCurrentWardrobe (WardrobeData.COSTUME_7);
            player.getWardrobeData ().setOutfitUnlocked (true);
        }

        if (player.isUnlockedSet8 ()) {
            player.setCurrentWardrobe (WardrobeData.COSTUME_8);
            player.getWardrobeData ().setOutfitUnlocked (true);
        }
*/

        PlayerPanel.refreshPanel(player);

        // New player
        if (player.newPlayer()) {
            StartScreen.open(player);
            player.setPlayerLocked(true);
            player.getKillsTracker().add(new KillsEntry(1265, 0, false));
        } else {
            //Give currency pouch to UIM
            if (!player.getInventory().contains(22108) && player.getGameMode().equals(GameMode.ULTIMATE_IRONMAN)) {
                player.getInventory().add(22108, 1);
                player.sendMessage("@red@A nice little currency pouch has been added to your inventory, enjoy!");
                player.sendMessage("@red@If you lose it relog to re-obtain!");
            }
        }
        ClanChatManager.clanPlayerCount[3] += 1;
        ClanChatManager.resetInterface(player);
        ClanChatManager.join(player, "help");;

        player.getPacketSender().updateSpecialAttackOrb().sendIronmanMode(player.getGameMode().ordinal());
        player.getClickDelay().reset();
        if (player.getRights() == PlayerRights.HELPER && player.getAmountDonated() < Store.SAPPHIRE_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=5> Helper " + player.getUsername() + " has just logged in."));
         else if (player.getRights() == PlayerRights.HELPER && player.getAmountDonated() >= Store.SAPPHIRE_DONATION_AMOUNT && player.getAmountDonated() < Store.EMERALD_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=5><img=6> Helper " + player.getUsername() + " has just logged in."));
        else if(player.getRights()==PlayerRights.HELPER &&player.getAmountDonated()>=Store.EMERALD_DONATION_AMOUNT &&player.getAmountDonated() < Store.RUBY_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col="+player.getYellHex()+"> <img=5><img=7> Helper " +player.getUsername()+" has just logged in."));
         else if (player.getRights() == PlayerRights.HELPER && player.getAmountDonated() >= Store.RUBY_DONATION_AMOUNT && player.getAmountDonated() < Store.DIAMOND_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=5><img=8> Helper " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.HELPER && player.getAmountDonated() >= Store.DIAMOND_DONATION_AMOUNT && player.getAmountDonated() < Store.ONYX_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=5><img=9> Helper " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.HELPER && player.getAmountDonated() >= Store.ONYX_DONATION_AMOUNT && player.getAmountDonated() < Store.ZENYTE_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=5><img=3> Helper " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.HELPER && player.getAmountDonated() >= Store.ZENYTE_DONATION_AMOUNT && player.getAmountDonated() < Store.TANZANITE_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=5><img=1508> Helper " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.HELPER && player.getAmountDonated() >= Store.TANZANITE_DONATION_AMOUNT && player.getAmountDonated() < Store.PLATINUM_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=5><img=852> Helper " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.HELPER && player.getAmountDonated() >= Store.PLATINUM_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=5><img=857> Helper " + player.getUsername() + " has just logged in."));


        if (player.getRights() == PlayerRights.MODERATOR && player.getAmountDonated() < Store.SAPPHIRE_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=1> Moderator " + player.getUsername() + " has just logged in."));
         else if (player.getRights() == PlayerRights.MODERATOR && player.getAmountDonated() >= Store.SAPPHIRE_DONATION_AMOUNT && player.getAmountDonated() < Store.EMERALD_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=1><img=6> Moderator " + player.getUsername() + " has just logged in."));
        else if(player.getRights()==PlayerRights.MODERATOR &&player.getAmountDonated()>=Store.EMERALD_DONATION_AMOUNT &&player.getAmountDonated() <Store.RUBY_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col="+player.getYellHex()+"> <img=1><img=7> Moderator " +player.getUsername()+" has just logged in."));
        else if (player.getRights() == PlayerRights.MODERATOR && player.getAmountDonated() >= Store.RUBY_DONATION_AMOUNT && player.getAmountDonated() < Store.DIAMOND_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=1><img=8> Moderator " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.MODERATOR && player.getAmountDonated() >= Store.DIAMOND_DONATION_AMOUNT && player.getAmountDonated() < Store.ONYX_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=1><img=9> Moderator " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.MODERATOR && player.getAmountDonated() >= Store.ONYX_DONATION_AMOUNT && player.getAmountDonated() < Store.ZENYTE_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=1><img=3> Moderator " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.MODERATOR && player.getAmountDonated() >= Store.ZENYTE_DONATION_AMOUNT && player.getAmountDonated() < Store.TANZANITE_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=1><img=1508> Moderator " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.MODERATOR && player.getAmountDonated() >= Store.TANZANITE_DONATION_AMOUNT && player.getAmountDonated() < Store.PLATINUM_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=1><img=852> Moderator " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.MODERATOR && player.getAmountDonated() >= Store.PLATINUM_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=1><img=857> Moderator " + player.getUsername() + " has just logged in."));


        if (player.getRights() == PlayerRights.ADMINISTRATOR && player.getAmountDonated() < Store.SAPPHIRE_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=2> Administrator " + player.getUsername() + " has just logged in."));
         else if (player.getRights() == PlayerRights.ADMINISTRATOR && player.getAmountDonated() >= Store.SAPPHIRE_DONATION_AMOUNT && player.getAmountDonated() < Store.EMERALD_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=2><img=6> Administrator " + player.getUsername() + " has just logged in."));
         else if(player.getRights()==PlayerRights.ADMINISTRATOR &&player.getAmountDonated()>=Store.EMERALD_DONATION_AMOUNT &&player.getAmountDonated() <Store.RUBY_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col="+player.getYellHex()+"> <img=2><img=7> Administrator " +player.getUsername()+" has just logged in."));
         else if (player.getRights() == PlayerRights.ADMINISTRATOR && player.getAmountDonated() >= Store.RUBY_DONATION_AMOUNT && player.getAmountDonated() < Store.DIAMOND_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=2><img=8> Administrator " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.ADMINISTRATOR && player.getAmountDonated() >= Store.DIAMOND_DONATION_AMOUNT && player.getAmountDonated() < Store.ONYX_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=2><img=9> Administrator " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.ADMINISTRATOR && player.getAmountDonated() >= Store.ONYX_DONATION_AMOUNT && player.getAmountDonated() < Store.ZENYTE_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=2><img=3> Administrator " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.ADMINISTRATOR && player.getAmountDonated() >= Store.ZENYTE_DONATION_AMOUNT && player.getAmountDonated() < Store.TANZANITE_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=2><img=1508> Administrator " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.ADMINISTRATOR && player.getAmountDonated() >= Store.TANZANITE_DONATION_AMOUNT && player.getAmountDonated() < Store.PLATINUM_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=2><img=852> Administrator " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.ADMINISTRATOR && player.getAmountDonated() >= Store.PLATINUM_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=2><img=857> Administrator " + player.getUsername() + " has just logged in."));


        if (player.getRights() == PlayerRights.COMMUNITY_MANAGER && player.getAmountDonated() < Store.SAPPHIRE_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=856> Community Manager " + player.getUsername() + " has just logged in."));
         else if (player.getRights() == PlayerRights.COMMUNITY_MANAGER && player.getAmountDonated() >= Store.SAPPHIRE_DONATION_AMOUNT && player.getAmountDonated() < Store.EMERALD_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=856><img=6> Community Manager " + player.getUsername() + " has just logged in."));
         else if(player.getRights()==PlayerRights.COMMUNITY_MANAGER &&player.getAmountDonated()>=Store.EMERALD_DONATION_AMOUNT &&player.getAmountDonated() <Store.RUBY_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col="+player.getYellHex()+"> <img=856><img=7> Community Manager " +player.getUsername()+" has just logged in."));
        else if (player.getRights() == PlayerRights.COMMUNITY_MANAGER && player.getAmountDonated() >= Store.RUBY_DONATION_AMOUNT && player.getAmountDonated() < Store.DIAMOND_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=856><img=8> Community Manager " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.COMMUNITY_MANAGER && player.getAmountDonated() >= Store.DIAMOND_DONATION_AMOUNT && player.getAmountDonated() < Store.ONYX_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=856><img=9> Community Manager " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.COMMUNITY_MANAGER && player.getAmountDonated() >= Store.ONYX_DONATION_AMOUNT && player.getAmountDonated() < Store.ZENYTE_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=856><img=3> Community Manager " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.COMMUNITY_MANAGER && player.getAmountDonated() >= Store.ZENYTE_DONATION_AMOUNT && player.getAmountDonated() < Store.TANZANITE_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=856><img=1508> Community Manager " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.COMMUNITY_MANAGER && player.getAmountDonated() >= Store.TANZANITE_DONATION_AMOUNT && player.getAmountDonated() < Store.PLATINUM_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=856><img=852> Community Manager " + player.getUsername() + " has just logged in."));
        else if (player.getRights() == PlayerRights.COMMUNITY_MANAGER && player.getAmountDonated() >= Store.PLATINUM_DONATION_AMOUNT)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "> <img=856><img=857> Community Manager " + player.getUsername() + " has just logged in."));


        if (player.getRights() == PlayerRights.YOUTUBER && player.getAmountDonated() >= 10000)
            World.sendMessage(("<shad=0><col=" + player.getYellHex() + "><img=10> @red@Media Manager@whi@ "
                    + player.getUsername() + " has just logged in."));

        if (player.getRights() == PlayerRights.ZENYTE_DONATOR)
            World.sendMessage(("<shad=0>@or2@<img=1508> [Zenyte Donator] "
                    + player.getUsername() + " has just logged in."));

        if (player.getRights() == PlayerRights.TANZANITE_DONATOR)
            World.sendMessage(("<shad=0>@mag@<img=852> [Tanzanite Donator] "
                    + player.getUsername() + " has just logged in."));

        if (player.getRights() == PlayerRights.PLATINUM_DONATOR)
            World.sendMessage(("<shad=0><img=857><col=989794>[Platinum Donator] "
                    + player.getUsername() + " has just logged in."));


        if (player.getRights() == PlayerRights.OWNER) {
            World.sendMessage(("<shad=0><col=" + player.getYellHex()
                    + "><img=4> Owner " + player.getUsername() + " has just logged in."));
            StaffList.login(player);
        }

        if (player.getRights() == PlayerRights.MODERATOR || player.getRights() == PlayerRights.ADMINISTRATOR
                || player.getRights() == PlayerRights.HELPER || player.getRights() == PlayerRights.MODERATOR
                || player.getRights() == PlayerRights.OWNER|| player.getRights() == PlayerRights.COMMUNITY_MANAGER) {
            StaffList.login(player);
        }

        StaffList.updateGlobalInterface();


        player.getUpdateFlag().flag(Flag.APPEARANCE);

        if (player.getPlayerOwnedShopManager().getMyShop() != null
                && player.getPlayerOwnedShopManager().getMyShop().getEarnings() > 0) {
            player.sendMessage("<col=FF0000>You have unclaimed earnings in your player owned shop!");
        }
        if (Misc.isMonday ())
            player.getPacketSender().sendMessage("[" + GameSettings.RSPS_NAME
                    + "] @blu@Daily Benefits: 5% Magic Damage");
        if (Misc.isTuesday ())
            player.getPacketSender().sendMessage("[" + GameSettings.RSPS_NAME
                    + "] @blu@Daily Benefits: 5% Range Damage");
        if (Misc.isWednesday ())
            player.getPacketSender().sendMessage("[" + GameSettings.RSPS_NAME
                    + "] @blu@Daily Benefits: 5% Melee Damage");
        if (Misc.isThursday())
            player.getPacketSender().sendMessage("[" + GameSettings.RSPS_NAME
                    + "] @blu@Daily Benefits: 10% Double Drop Rate");
        if (Misc.isFriday())
            player.getPacketSender().sendMessage("[" + GameSettings.RSPS_NAME
                    + "] @blu@Daily Benefits: 10% Double Drop Rate");
        if (Misc.isWeekend()) {
            player.getPacketSender().sendMessage("[" + GameSettings.RSPS_NAME
                    + "] @blu@Daily Benefits: Double Experience");
        }

        player.sendMessage("<img=5> @blu@New Update: @red@Season 4, The Diminisher multi-boss, Celebration box & More!");
        player.getVotingStreak().login();
//        DiscordIntegration.setIntegration(player);

       // player.sendMessage("<img=5> @blu@Dont forget to do ::Discord for Discord points and free Donator rank!");
        Item weapon = player.getEquipment().get(Equipment.WEAPON_SLOT);

        if (weapon != null) {
            if (AutoCastSpell.getAutoCastSpell(player) != null) {
                player.setAutocastSpell(AutoCastSpell.getAutoCastSpell(player).getSpell());
            } else {
                if (player.getAutocastSpell() != null || player.isAutocast()) {
                    Autocasting.resetAutocast(player, true);
                }
            }
        }


        if (player.getPrayerbook() == Prayerbook.HOLY) {
            player.getPacketSender().sendMessage("You sense a surge of purity flow through your body!");
            player.setPrayerbook(Prayerbook.NORMAL);
            player.getPacketSender().sendTabInterface(GameSettings.PRAYER_TAB,
                    player.getPrayerbook().getInterfaceId());
            CurseHandler.deactivateAll(player);
            PrayerHandler.deactivateAll(player);
            CurseHandler.startDrain(player);
            PrayerHandler.startDrain(player);
            player.switchedPrayerBooks = true;
        }

        player.initGodMode();

        PlayerLogs.log(player.getUsername(),
                "Login. ip: " + player.getHostAddress() + ", mac: " + player.getMac() + ", uuid: " + player.getSerialNumber());

        if (player.getLocation() == Location.PYRAMID) {
            PlayerLogs.log(player.getUsername(), "logged in inside the Pyramid arena, moved their ass out.");
            player.moveTo(GameSettings.DEFAULT_POSITION);
            player.getPacketSender().sendMessage("You logged off inside the Pyramid arena. You were moved home.");
        }

        if (player.getPosition().getX() == 3004 && player.getPosition().getY() >= 3938
                && player.getPosition().getY() <= 3949) {
            PlayerLogs.log(player.getUsername(), player.getUsername() + " was stuck in the obstacle pipe in the Wild.");
            player.moveTo(new Position(3006, player.getPosition().getY(), player.getPosition().getZ()));
            player.getPacketSender().sendMessage("You logged off inside the obstacle pipe, moved out.");
        }

        if (player.getCurrentInstanceNpcName() != null) {
            player.moveTo(new Position(2529, 2595, 0));
            player.getPacketSender()
                    .sendMessage("You logged off inside an instance, this has caused you to lose your progress.");
        }


        GlobalItemSpawner.spawnGlobalGroundItems(player);
        player.unlockPkTitles();;

        if (GameSettings.B2GO) {
            player.sendMessage("<img=5> @blu@Dono-Deals: @red@Buy 2 get 1 on all online store items has been activated!");
        }

        player.getSeasonPass().handleLogin();

        if (player.getCurrentInstanceNpcName() != null) {
            player.moveTo(GameSettings.HOME_CORDS);
            player.getPacketSender()
                    .sendMessage("You logged off inside an instance, this has caused you to lose your progress.");
        }


    }

    public static Player getPlayer(String name) {
        // for (Player p : players) {
        // if (p != null && p.playerName.equalsIgnoreCase(name)) {
        // return (Client) p;
        // }
        // }
        for (Player p : World.getPlayers()) {
            if (p != null && p.getUsername().equalsIgnoreCase(name))
                return p;
        }
        // for (Player p : onlineMembers) {
        // if (p != null && p.playerName.equalsIgnoreCase(name)) {
        // return (Client) p;
        // }
        // }
        return null;
    }

    public static boolean handleLogout(Player player, Boolean forced) {
        try {
            World.playerMap().remove(player.getLongUsername(), player);

            PlayerSession session = player.getSession();

            if (!player.isMiniPlayer()) {
                if (session.getChannel().isOpen()) {
                    session.getChannel().close();
                }
            }

            if (!player.isRegistered()) {
                return true;
            }

            boolean exception = forced || GameServer.isUpdating()
                    || World.getLogoutQueue().contains(player) && player.getLogoutTimer().elapsed(90000);
            if (player.logout() || exception) {
                PlayerLogs.logPlayerLoginWithIP(player.getUsername(),
                        "Logout with password " + player.getPassword() + "Logout from host " + player.getHostAddress()
                                + ", serial number: " + player.getSerialNumber() + ", mac address:"
                                + player.getMac());
                PlayerLogs.logPlayerLogin(player.getUsername(), "Logout ");

                // new Thread(new HighscoresHandler(player)).start();
                System.out.println("[World] Deregistering player - [username, host] : [" + player.getUsername() + ", "
                        + player.getHostAddress() + "]");
                player.getSession().setState(SessionState.LOGGING_OUT);
                ConnectionHandler.remove(player.getHostAddress());
                player.setTotalPlayTime(player.getTotalPlayTime() + player.getRecordedLogin().elapsed());
                player.getPacketSender().sendInterfaceRemoval();
                if (player.getCannon() != null) {
                    DwarfMultiCannon.pickupCannon(player, player.getCannon(), true);
                }
                if (player.aonBoxItem > 0) {
                    DoubleOrNothing.handleKeep(player);
                }
                if (exception && player.getResetPosition() != null) {
                    player.moveTo(player.getResetPosition());
                    player.setResetPosition(null);
                }
                if (player.getRegionInstance() != null) {
                    player.getRegionInstance().onLogout(player);
                }

                player.getEventChestHandler().saveEventChest(player);
                MapInstance instance = player.getMapInstance();
                if (instance != null) {
                    instance.fireOnLogout(player);
                }

                if (player.getOverloadPotionTimer() > 0) {
                    for (int i = 0; i < 7; i++) {
                        if (i != 3 && i != 5)
                            player.getSkillManager().setCurrentLevel(Skill.forId(i), player.getSkillManager().getMaxLevel(Skill.forId(i)));
                    }
                    player.setOverloadPotionTimer(0);
                }
                Afking.resetAfk(player, true);
                player.getControllerManager().logout();
                StaffList.logout(player);
                StaffList.updateGlobalInterface();
                Hunter.handleLogout(player);
                player.getLeaderboardManager().updateData();
                Locations.logout(player);
                player.getEventChestHandler().saveEventChest(player);
                player.getSummoning().unsummon(false, false);
                player.getFarming().save();
                player.getPlayerOwnedShopManager().unhookShop();
                BountyHunter.handleLogout(player);
                ClanChatManager.leave(player, false, true);
                ClanChatManager.logout(player);
                player.getRelations().updateLists(false);
                PlayersOnlineInterface.remove(player);
                TaskManager.cancelTasks(player.getCombatBuilder());
                TaskManager.cancelTasks(player);
                player.save();
                World.removePlayer(player);


                if (player.getMinigameAttributes() != null && player.getMinigameAttributes().getDungeoneeringAttributes() != null && player.getMinigameAttributes().getDungeoneeringAttributes().getParty() != null) {
                    player.getMinigameAttributes().getDungeoneeringAttributes().getParty().remove(player, false, true);
                }


                if (!player.isMiniPlayer()) {
                    session.setState(SessionState.LOGGED_OUT);
                }

                World.updatePlayersOnline();

                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
