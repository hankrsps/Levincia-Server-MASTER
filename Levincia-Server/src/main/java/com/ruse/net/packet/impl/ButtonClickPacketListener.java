package com.ruse.net.packet.impl;

import com.ruse.GameSettings;
import com.ruse.model.*;
import com.ruse.model.Locations.Location;
import com.ruse.model.container.impl.Bank;
import com.ruse.model.container.impl.Bank.BankSearchAttributes;
import com.ruse.model.container.impl.GroupIronmanBank;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.model.definitions.WeaponInterfaces.WeaponInterface;
import com.ruse.model.input.EnterAmountToBurn;
import com.ruse.model.input.EnterAmountToRisk;
import com.ruse.model.input.impl.*;
import com.ruse.net.packet.Packet;
import com.ruse.net.packet.PacketListener;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.allornothing.DoubleOrNothing;
import com.ruse.world.content.*;
import com.ruse.world.content.Sounds.Sound;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.content.achievements.AchievementInterface;
import com.ruse.world.content.afk.AfkSystem;
import com.ruse.world.content.afk.SoulPyre;
import com.ruse.world.content.bis.BestDRItemsInterface;
import com.ruse.world.content.bis.BestItemsInterface;
import com.ruse.world.content.bossEvents.BossEventInterfaceHandler;
import com.ruse.world.content.clan.ClanChat;
import com.ruse.world.content.clan.ClanChatManager;
import com.ruse.world.content.clan.Guild;
import com.ruse.world.content.collectionlog.SearchForCollectionNpc;
import com.ruse.world.content.combat.magic.Autocasting;
import com.ruse.world.content.combat.magic.MagicSpells;
import com.ruse.world.content.combat.prayer.CurseHandler;
import com.ruse.world.content.combat.prayer.PrayerHandler;
import com.ruse.world.content.combat.weapon.CombatSpecial;
import com.ruse.world.content.combat.weapon.FightType;
import com.ruse.world.content.cosmetic.WardrobeHandler;
import com.ruse.world.content.dailyTask.DailyTaskInterface;
import com.ruse.world.content.dialogue.DialogueManager;
import com.ruse.world.content.dialogue.DialogueOptions;
import com.ruse.world.content.event_chest.EventChestButtons;
import com.ruse.world.content.events.EventManager;
import com.ruse.world.content.goldenscratch.ScratchCard;
import com.ruse.world.content.grandexchange.GrandExchange;
import com.ruse.world.content.groupironman.GroupManager;
import com.ruse.world.content.instanceMananger.InstanceInterfaceHandler;
import com.ruse.world.content.loyalty_streak.LoyaltyStreakManager;
import com.ruse.world.content.minigames.impl.Dueling;
import com.ruse.world.content.minigames.impl.PestControl;
import com.ruse.world.content.minigames.impl.dungeoneering.DungeoneeringParty;
import com.ruse.world.content.osrscollectionlog.CollectionLogButtons;
import com.ruse.world.content.polling.PollCreation;
import com.ruse.world.content.polling.PollManager;
import com.ruse.world.content.raids.elders.TelosLoot;
import com.ruse.world.content.raids.elders.TelosRaid;
import com.ruse.world.content.raids.elders.TelosRaidParty;
import com.ruse.world.content.raids.legends.LegendsRaidParty;
import com.ruse.world.content.raids.shadows.NecromancerLoot;
import com.ruse.world.content.raids.shadows.NecromancerRaid;
import com.ruse.world.content.raids.shadows.NecromancerRaidParty;
import com.ruse.world.content.raids.shadows.ShadowRewards;
import com.ruse.world.content.raids.system.RaidDifficulty;
import com.ruse.world.content.raids.system.RaidsParty;
import com.ruse.world.content.rewardsList.RewardsHandler;
import com.ruse.world.content.seasonpass.SeasonPass;
import com.ruse.world.content.serverperks.ServerPerkContributionInput;
import com.ruse.world.content.serverperks.ServerPerks;
import com.ruse.world.content.skill.ChatboxInterfaceSkillAction;
import com.ruse.world.content.skill.impl.construction.Construction;
import com.ruse.world.content.skill.impl.crafting.LeatherMaking;
import com.ruse.world.content.skill.impl.crafting.Tanning;
import com.ruse.world.content.skill.impl.fletching.Fletching;
import com.ruse.world.content.skill.impl.herblore.ingredientsBook;
import com.ruse.world.content.skill.impl.old_dungeoneering.Dungeoneering;
import com.ruse.world.content.skill.impl.old_dungeoneering.ItemBinding;
import com.ruse.world.content.skill.impl.smithing.SmithingData;
import com.ruse.world.content.skill.impl.summoning.PouchMaking;
import com.ruse.world.content.skill.impl.summoning.SummoningTab;
import com.ruse.world.content.teleport.TeleportInterfaceHandler;
import com.ruse.world.content.transportation.TeleportHandler;
import com.ruse.world.content.transportation.TeleportType;
import com.ruse.world.content.valentine.HweenEvent;
import com.ruse.world.content.wellForGlobalBosses.WellForGlobalBossesInterface;
import com.ruse.world.content.youtube.YoutubeData;
import com.ruse.world.content.youtube.YoutubeInterfaceHandler;
import com.ruse.world.entity.impl.player.Player;
import com.ruse.world.entity.impl.player.StartScreen;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static com.ruse.model.Skill.*;
import static com.ruse.world.content.osrscollectionlog.LogType.MONSTERS;
import static com.ruse.world.content.raids.elders.TelosInterfaces.*;
import static com.ruse.world.content.raids.shadows.NecromancerInterfaces.*;

/**
 * This packet listener manages a button that the player has clicked upon.
 *
 * @author Gabriel Hannason
 */

public class ButtonClickPacketListener implements PacketListener {

    public static final int OPCODE = 185;
    private static final List<Integer> NEW_TELEPORT_BUTTONS_TAB = Arrays.asList(28215, 28216, 28217, 28218, 28219, 28220);
    private static final List<Integer> NEW_TELEPORT_BUTTONS = Arrays.asList(
            28231, 28232, 28233, 28234, 28235, 28236, 28237, 28238,
            28239, 28240, 28241, 28242,
            28243, 28244, 28245, 28246, 28247, 28248, 28249, 28250, 28251, 28252, 28253, 28254,
            28307, 28308, 28309, 28310, 28311, 28312, 28313, 28314, 28315, 28316, 28317, 28318, 28319,
            28320, 28321, 28322, 28323, 28324, 28325, 28326, 28327, 28328, 28329, 28330,
            28331, 28332, 28333, 28334, 28335, 28336, 28337, 28338, 28339);

    private static final List<Integer> NEW_WARDROBE_BUTTONS = Arrays.asList(
            133071, 133072, 133073, 133074, 133075, 133076, 133077, 133078,
            133079, 133080, 133081, 133082,133083,133084,133085,133086,133087,
            133088,133089,133090,133091,133092,133093,133094,133095,133096,133097,
            133098,133099,133100);
    private static final List<Integer> YT_SELECT_BUTTONS = Arrays.asList(
            82461, 82462, 82463, 82464, 82465, 82466, 82467, 82468, 82469, 82470, 82361, 83262, 83263, 83264, 83265, 83266, 83267, 83268, 83269, 83270);

    @Override
    public void handleMessage(Player player, Packet packet) {
        int bankid = 0;
        int id = packet.readInt();
        if (id >= 32768 && id < 65535) {
            id -= 65536;
        }

        ClanChatManager.buttonClick(player, id);

        if (player.getLeaderboardManager().handleButton(id)) {
            return;
        }
        if (player.getRights().isDeveloperOnly()) {
            player.getPacketSender().sendMessage("Clicked button: " + id);
        }
        if (!player.getControllerManager().processButtonClick(id)) {
            return;
        }
        if (id == -23480) {
            player.getPacketSender().sendEnterAmountPrompt("How much would you like to contribute?");
            player.setInputHandling(new ServerPerkContributionInput());
            return;
        }

        if (checkHandlers(player, id))
            return;

        EventManager.buttonClick(player, id);
        player.getGambling().handleChoice(id);


        if (player.getPlayerOwnedShopManager().handleButton(id)) {
            return;
        }

        if (player.getStarterTasks().handleButtonClick(id)) {
            return;
        }
        if (player.getGoodieBag().handleClick(id)) {
            return;
        }
        if (PossibleLootInterface.handleButton(player, id)) {
            return;
        }
        if (CollectionLogButtons.onButtonClick(player, id)) {
            return;
        }
        if (player.getAchievementInterface() != null && player.getAchievementInterface().handleButton(id)) {
            return;
        }
        if(EventChestButtons.handleButton(player, id)) {
            return;
        }
        if (player.getUpgradeInterface().handleButton(id)) {
            return;
        }
        if (NEW_TELEPORT_BUTTONS_TAB.contains(id)) {
            new TeleportInterfaceHandler(player).switchTab(id);
        }
        if (NEW_TELEPORT_BUTTONS.contains(id)) {
            new TeleportInterfaceHandler(player).button(id);
        }

        if (NEW_WARDROBE_BUTTONS.contains(id)) {
            new WardrobeHandler (player).button(id);
        }

        if (YT_SELECT_BUTTONS.contains(id)) {
            new YoutubeInterfaceHandler(player).button(id);
        }

        if (player.getDonatorShop().handleButton(id)) {
            return;
        }
        if (player.getPetShop().handleButton(id)) {
            return;
        }


        if (player.getCardPack().handleButton(id)) {
            return;
        }
        new ScratchCard(player).reveal(id);
        new DailyTaskInterface(player).button(id);
        new DailyTaskInterface(player).tabClicking(id);
        new InstanceInterfaceHandler(player).handleButtons(id);
        new WellForGlobalBossesInterface(player).button(id);
        new HweenEvent(player).handleButton (id);

        switch (id) {
            case 31886:

                if (player.getWardrobeData ().unlocked) {

                    if (player.getWardrobeData().getNpcId () == 2270 && !player.isSet1() ) {
                        player.setSet1 (true);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet8 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet1() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                    } else if (player.getWardrobeData().getNpcId () == 2270  && player.isSet1()){
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet8 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet1() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");


                    } else if (player.getWardrobeData().getNpcId () == 9244 && !player.isSet2()) {
                        player.setSet1 (false);
                        player.setSet2 (true);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet8 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet2() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                    } else if (player.getWardrobeData().getNpcId () == 9244 && player.isSet2()){
                        player.setSet2 (false);
                        player.setSet1 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet8 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet2() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");


                    } else if (player.getWardrobeData().getNpcId () == 607 && !player.isSet3()) {
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (true);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet8 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet3() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                    } else if (player.getWardrobeData().getNpcId () == 607 && player.isSet3()){
                        player.setSet3 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet8 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet3() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");


                    } else if (player.getWardrobeData().getNpcId () == 903 && !player.isSet4()) {
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (true);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet8 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet4() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                    } else if (player.getWardrobeData().getNpcId () == 903 && player.isSet4()){
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet8 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet4() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");


                    } else if (player.getWardrobeData().getNpcId () == 904 && !player.isSet5()) {
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (true);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet8 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet5() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                    } else if (player.getWardrobeData().getNpcId () == 904 && player.isSet5()){
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet8 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet5() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");


                    } else if (player.getWardrobeData().getNpcId () == 905 && !player.isSet6()) {
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (true);
                        player.setSet7 (false);
                        player.setSet8 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet6() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                    } else if (player.getWardrobeData().getNpcId () == 905 && player.isSet6()){
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet8 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet6() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");


                    } else if (player.getWardrobeData().getNpcId () == 906 && !player.isSet7()) {
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (true);
                        player.setSet8 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet7() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                    } else if (player.getWardrobeData().getNpcId () == 906 && player.isSet7()){
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet8 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet7() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");


                    } else if (player.getWardrobeData().getNpcId () == 907 && !player.isSet8()) {
                        player.setSet8 (true);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet8() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                    } else if (player.getWardrobeData().getNpcId () == 907 && player.isSet8()){
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet8() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");

                    } else if (player.getWardrobeData().getNpcId () == 908 && !player.isSet9()) {
                    player.setSet8 (false);
                    player.setSet1 (false);
                    player.setSet2 (false);
                    player.setSet3 (false);
                    player.setSet4 (false);
                    player.setSet5 (false);
                    player.setSet6 (false);
                    player.setSet7 (false);
                    player.setSet9 (true);
                    player.setSet10 (false);
                    player.setSet11 (false);
                    player.setSet12 (false);
                    player.setSet13 (false);
                    player.setSet14 (false);
                    player.setSet15 (false);
                    player.setSet16 (false);
                    player.setSet17 (false);
                    player.setSet18 (false);
                    player.setSet19 (false);
                    player.setSet20 (false);
                    player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                            player.isSet9() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                    player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                } else if (player.getWardrobeData().getNpcId () == 908 && player.isSet9()){
                    player.setSet8 (false);
                    player.setSet1 (false);
                    player.setSet2 (false);
                    player.setSet3 (false);
                    player.setSet4 (false);
                    player.setSet5 (false);
                    player.setSet6 (false);
                    player.setSet7 (false);
                    player.setSet9 (false);
                    player.setSet10 (false);
                    player.setSet11 (false);
                    player.setSet12 (false);
                    player.setSet13 (false);
                    player.setSet14 (false);
                    player.setSet15 (false);
                    player.setSet16 (false);
                    player.setSet17 (false);
                    player.setSet18 (false);
                    player.setSet19 (false);
                    player.setSet20 (false);
                    player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                            player.isSet9() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                    player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");


                    } else if (player.getWardrobeData().getNpcId () == 909 && !player.isSet10()) {
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (true);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet10() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                    } else if (player.getWardrobeData().getNpcId () == 909 && player.isSet10()){
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet10() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");



                    } else if (player.getWardrobeData().getNpcId () == 910 && !player.isSet11()) {
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (true);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet11() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                    } else if (player.getWardrobeData().getNpcId () == 909 && player.isSet11()){
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet11() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");



                    } else if (player.getWardrobeData().getNpcId () == 911 && !player.isSet12()) {
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (true);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet12() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                    } else if (player.getWardrobeData().getNpcId () == 911 && player.isSet12()){
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet12() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");


                    } else if (player.getWardrobeData().getNpcId () == 912 && !player.isSet13()) {
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (true);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet13() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                    } else if (player.getWardrobeData().getNpcId () == 912 && player.isSet13()){
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet13() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");



                    } else if (player.getWardrobeData().getNpcId () == 913 && !player.isSet14()) {
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (true);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet14() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                    } else if (player.getWardrobeData().getNpcId () == 913 && player.isSet14()){
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet14() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");



                    } else if (player.getWardrobeData().getNpcId () == 914 && !player.isSet15()) {
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (true);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet15() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                    } else if (player.getWardrobeData().getNpcId () == 914 && player.isSet15()){
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet15() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");


                    } else if (player.getWardrobeData().getNpcId () == 915 && !player.isSet16()) {
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (true);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet16() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                    } else if (player.getWardrobeData().getNpcId () == 915 && player.isSet16()) {
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet16 () ? "Unequip Outfit" : " Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");

                    } else if (player.getWardrobeData().getNpcId () == 916 && !player.isSet17()) {
                    player.setSet8 (false);
                    player.setSet1 (false);
                    player.setSet2 (false);
                    player.setSet3 (false);
                    player.setSet4 (false);
                    player.setSet5 (false);
                    player.setSet6 (false);
                    player.setSet7 (false);
                    player.setSet9 (false);
                    player.setSet10 (false);
                    player.setSet11 (false);
                    player.setSet12 (false);
                    player.setSet13 (false);
                    player.setSet14 (false);
                    player.setSet15 (false);
                    player.setSet16 (false);
                    player.setSet17 (true);
                    player.setSet18 (false);
                    player.setSet19 (false);
                    player.setSet20 (false);
                    player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                            player.isSet17() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                    player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                } else if (player.getWardrobeData().getNpcId () == 916 && player.isSet17()) {
                    player.setSet8 (false);
                    player.setSet1 (false);
                    player.setSet2 (false);
                    player.setSet3 (false);
                    player.setSet4 (false);
                    player.setSet5 (false);
                    player.setSet6 (false);
                    player.setSet7 (false);
                    player.setSet9 (false);
                    player.setSet10 (false);
                    player.setSet11 (false);
                    player.setSet12 (false);
                    player.setSet13 (false);
                    player.setSet14 (false);
                    player.setSet15 (false);
                    player.setSet16 (false);
                    player.setSet17 (false);
                    player.setSet18 (false);
                    player.setSet19 (false);
                    player.setSet20 (false);
                    player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                            player.isSet16 () ? "Unequip Outfit" : " Equip Outfit" : "" + "Unlock Outfit");
                    player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");

                    } else if (player.getWardrobeData().getNpcId () == 917 && !player.isSet18()) {
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (true);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet18() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                    } else if (player.getWardrobeData().getNpcId () == 917 && player.isSet18()) {
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet18 () ? "Unequip Outfit" : " Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");
                    } else if (player.getWardrobeData().getNpcId () == 918 && !player.isSet19()) {
                    player.setSet8 (false);
                    player.setSet1 (false);
                    player.setSet2 (false);
                    player.setSet3 (false);
                    player.setSet4 (false);
                    player.setSet5 (false);
                    player.setSet6 (false);
                    player.setSet7 (false);
                    player.setSet9 (false);
                    player.setSet10 (false);
                    player.setSet11 (false);
                    player.setSet12 (false);
                    player.setSet13 (false);
                    player.setSet14 (false);
                    player.setSet15 (false);
                    player.setSet16 (false);
                    player.setSet17 (false);
                    player.setSet18 (false);
                    player.setSet19 (true);
                    player.setSet20 (false);
                    player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                            player.isSet19() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                    player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                } else if (player.getWardrobeData().getNpcId () == 918 && player.isSet19()) {
                    player.setSet8 (false);
                    player.setSet1 (false);
                    player.setSet2 (false);
                    player.setSet3 (false);
                    player.setSet4 (false);
                    player.setSet5 (false);
                    player.setSet6 (false);
                    player.setSet7 (false);
                    player.setSet9 (false);
                    player.setSet10 (false);
                    player.setSet11 (false);
                    player.setSet12 (false);
                    player.setSet13 (false);
                    player.setSet14 (false);
                    player.setSet15 (false);
                    player.setSet16 (false);
                    player.setSet17 (false);
                    player.setSet18 (false);
                    player.setSet19 (false);
                    player.setSet20 (false);
                    player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                            player.isSet19 () ? "Unequip Outfit" : " Equip Outfit" : "" + "Unlock Outfit");
                    player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");

                    } else if (player.getWardrobeData().getNpcId () == 918 && !player.isSet19()) {
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (true);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet20() ? "Unequip Outfit" :" Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You equipped your Cosmetic Overrides");
                    } else if (player.getWardrobeData().getNpcId () == 919 && player.isSet20()) {
                        player.setSet8 (false);
                        player.setSet1 (false);
                        player.setSet2 (false);
                        player.setSet3 (false);
                        player.setSet4 (false);
                        player.setSet5 (false);
                        player.setSet6 (false);
                        player.setSet7 (false);
                        player.setSet9 (false);
                        player.setSet10 (false);
                        player.setSet11 (false);
                        player.setSet12 (false);
                        player.setSet13 (false);
                        player.setSet14 (false);
                        player.setSet15 (false);
                        player.setSet16 (false);
                        player.setSet17 (false);
                        player.setSet18 (false);
                        player.setSet19 (false);
                        player.setSet20 (false);
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ?
                                player.isSet20 () ? "Unequip Outfit" : " Equip Outfit" : "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You unequipped your Cosmetic Overrides");

                    }
                        player.updateAppearance();
                }

                if (!player.getWardrobeData ().unlocked) {
                    if (player.getInventory().contains (12855, player.getWardrobeData().getCost ())) {
                        player.getInventory ().delete (12855, player.getWardrobeData ().getCost());

                        if (player.getWardrobeData().getNpcId () == 2270)
                            player.setUnlockedSet1(true);

                        if (player.getWardrobeData().getNpcId () == 9244)
                            player.setUnlockedSet2(true);

                        if (player.getWardrobeData().getNpcId () == 607)
                            player.setUnlockedSet3(true);

                        if (player.getWardrobeData().getNpcId () == 903)
                            player.setUnlockedSet4(true);

                        if (player.getWardrobeData().getNpcId () == 904)
                            player.setUnlockedSet5(true);

                        if (player.getWardrobeData().getNpcId () == 905)
                            player.setUnlockedSet6(true);

                        if (player.getWardrobeData().getNpcId () == 906)
                            player.setUnlockedSet7(true);

                        if (player.getWardrobeData().getNpcId () == 907)
                            player.setUnlockedSet8(true);
                        if (player.getWardrobeData().getNpcId () == 908)
                            player.setUnlockedSet9(true);
                        if (player.getWardrobeData().getNpcId () == 909)
                            player.setUnlockedSet10(true);
                        if (player.getWardrobeData().getNpcId () == 910)
                            player.setUnlockedSet11(true);
                        if (player.getWardrobeData().getNpcId () == 911)
                            player.setUnlockedSet12(true);
                        if (player.getWardrobeData().getNpcId () == 912)
                            player.setUnlockedSet13(true);
                        if (player.getWardrobeData().getNpcId () == 913)
                            player.setUnlockedSet14(true);
                        if (player.getWardrobeData().getNpcId () == 914)
                            player.setUnlockedSet15(true);
                        if (player.getWardrobeData().getNpcId () == 915)
                            player.setUnlockedSet16(true);
                        if (player.getWardrobeData().getNpcId () == 916)
                            player.setUnlockedSet17(true);
                        if (player.getWardrobeData().getNpcId () == 917)
                            player.setUnlockedSet18(true);
                        if (player.getWardrobeData().getNpcId () == 918)
                            player.setUnlockedSet19(true);
                        if (player.getWardrobeData().getNpcId () == 919)
                            player.setUnlockedSet20(true);




                        player.getWardrobeData().setOutfitUnlocked(true);
                        player.getPA ().sendString (player.getWardrobeData ().buttonId, player.getWardrobeData ().getOutfitUnlocked () ? "@gre@"
                                +  player.getWardrobeData().getName () : "" +  player.getWardrobeData().getName ());

                        player.getPA ().sendString (133710, "");
                        if (player.getWardrobeData().getNpcId () == 2270 && player.isSet1())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 9244 && player.isSet2())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 607 && player.isSet3())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 903 && player.isSet4())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 904 && player.isSet5())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 905 && player.isSet6())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 906 && player.isSet7())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 907 && player.isSet8())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 908 && player.isSet9())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 909 && player.isSet10())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 910 && player.isSet11())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 911 && player.isSet12())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 912 && player.isSet13())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 913 && player.isSet14())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 914 && player.isSet15())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 915 && player.isSet16())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 916 && player.isSet17())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 917 && player.isSet18())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 918 && player.isSet19())
                            player.getPA ().sendString (31886, " Unequip Outfit");
                        else if (player.getWardrobeData().getNpcId () == 919 && player.isSet20())
                            player.getPA ().sendString (31886, " Unequip Outfit");

                        else
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ? " Equip Outfit" :
                                "" + "Unlock Outfit");
                        player.getPacketSender ().sendMessage ("You have Unlocked " + player.getWardrobeData ().getName());
                    } else
                        player.getPacketSender ().sendMessage ("You need " + Misc.insertCommasToNumber (player.getWardrobeData().getCost ())
                                + "Cosmetic Gems to unlock this outfit");
                }
                break;

            case 75012://3x3
                player.set4x4(false);
                player.set3x3(true);
                player.sendMessage("You have selected 3x3 instances.");
                player.getPacketSender().sendString(75010, "Cost: @whi@1,500 Levincia tokens");
                break;
            case 75013://4x4
                player.set3x3(false);
                player.set4x4(true);
                player.sendMessage("You have selected 4x4 instances.");
                player.getPacketSender().sendString(75010, "Cost: @whi@3,000 Levincia tokens");
                break;
            case 135012://3x3
                player.set4x4(false);
                player.set3x3(true);
                player.sendMessage("You have selected 3x3 instances.");
                player.getPacketSender().sendString(135010, "Cost: @whi@750 Levincia tokens");
                break;
            case 135013://4x4
                player.set3x3(false);
                player.set4x4(true);
                player.sendMessage("You have selected 4x4 instances.");
                player.getPacketSender().sendString(135010, "Cost: @whi@1,500 Levincia tokens");
                break;
            case 28028:
                if (player.isMembershipUnlocked()) {
                    player.sendMessage("You have already claimed a membership this Month");
                    return;

                }
                if (player.getInventory().contains(23392)) {

                    Calendar cal = Calendar.getInstance();
                    int day = cal.get(Calendar.DAY_OF_YEAR);
                    int daysLeft = SeasonPass.SEASONEND - day;
                    player.getInventory().delete(23392, 1);
                    player.getPacketSender().removeInterface();
                    player.setUnlockedMembership(true);
                    player.membershipInterfaceHandler.openBenefitTab();
                    player.sendMessage("You have claimed your Monthly Membership");
                    World.sendMessage("@red@<img=832>[News] @blu@" + player.getUsername() +" @red@claimed a Monthly Membership!");
                    player.sendMessage("The Monthly pass ends in " + daysLeft + " days.");
                } else {
                    player.sendMessage("You do not have a monthly membership pass.");
                }
                break;
            case 143517: // Risk Souls (55x2)
                if (!player.getInventory().contains(14639)) {
                    player.sendMessage("You don't have any souls to risk.");
                }

                player.setInputHandling(new EnterAmountToRisk());
                player.getPacketSender().sendEnterAmountPrompt("How many souls would you like to risk?");
            break;

            case 143509: // Burn Souls
                if (!player.getInventory().contains(14639)) {
                    player.sendMessage("You don't have any souls to burn.");
                }

                player.setInputHandling(new EnterAmountToBurn());
                player.getPacketSender().sendEnterAmountPrompt("How many souls would you like to burn?");
                break;


            case 13760:
                int amount = player.getSoulRiskAmount();
                int amount2 = player.getSoulGambleAmount();
                if (!player.getInventory().contains(14639, amount)) {
                    player.sendMessage("You no longer have that many souls.");
                    break;
                }
                if (player.getSoulRiskAmount() > 0) {
                    player.performAnimation(new Animation(11900));
                    player.performGraphic(new Graphic(2075));
                    int roll = Misc.getRandom(99) + 1;
                    player.sendMessage("You roll the dice... (" + roll + ")");

                    if (roll > 55) {
                        player.getInventory().add(14639, amount);
                        player.sendMessage("@blu@You win! Souls doubled.");
                        player.setSoulRiskAmount(0);
                    } else {
                        player.getInventory().delete(14639, amount);
                        player.sendMessage("@red@You lost the gamble.");
                        player.setSoulRiskAmount(0);
                    }
                }
                else if (player.getSoulGambleAmount() > 0) {
                    player.getInventory().delete(14639, amount2);
                    AfkSystem.burnedSouls += amount2;
                    player.setSealedUrnAmount(player.getSealedUrnAmount() + amount2);
                    if (AfkSystem.burnedSouls <= 500_000)
                    player.sendMessage("You burn " + amount2 +" Lost Souls, To Awaken the boss we need " + AfkSystem.getLeft() + " more." );
                    if (AfkSystem.burnedSouls >= 500_000)
                        AfkSystem.executeSpawn();
                    if (player.getSealedUrnAmount() >= 350_000) {
                        player.getInventory().add(20413, 1);
                        player.sendMessage("@blu@Sealed Urn of Whispers has been added to your inventory.");
                        player.setSealedUrnAmount(player.getSealedUrnAmount() - 350_000);
                    }
                }
                player.setSoulGambleAmount(0);
                SoulPyre.openInterface(player);
                break;


                case -30520:
                if (player.getInstanceManager().selectedInstance != null) {
                    if (player.getInstanceManager().selectedInstance.getNpcId() == 1265) {
                        player.sendMessage("Levincia lions can only be killed at ::train");
                        return;
                    }

                    if (!player.getLastRunRecovery().elapsed(5000)) {
                        player.sendMessage("Please wait 5 seconds before doing this again.");
                        return;
                    }

                    if (player.getInstanceManager().selectedInstance.getNpcId() == 1265
                            || player.getInstanceManager().selectedInstance.getNpcId() == 1023
                            || player.getInstanceManager().selectedInstance.getNpcId() == 1233
                            || player.getInstanceManager().selectedInstance.getNpcId() == 1234) {
                        if (player.getPointsHandler().getNPCKILLCount() > 5000 && KillsTracker.getTotalKillsForNpc(player.getInstanceManager().selectedInstance.getNpcId(), player) > 500) {
                            player.sendMessage("This place is for new players with less than 5k npc kills.");
                            return;
                        }
                    }
                    player.getInstanceManager().createInstance(player.getInstanceManager().selectedInstance.getNpcId(), RegionInstance.RegionInstanceType.INSTANCE);
                } else {
                    player.getPA().sendMessage("Select the boss you'd like to instance.");
                }
                break;
            case -4908:
                if (player.isCosmeticUnlocked()) {
                    player.sendMessage("You have already claimed a cosmetic membership this month");
                    return;

                }
                if (player.getInventory().contains(23393)) {
                    Calendar cal = Calendar.getInstance();
                    int day = cal.get(Calendar.DAY_OF_YEAR);
                    int daysLeft = SeasonPass.SEASONEND - day;
                    player.getInventory().delete(23393, 1);
                    player.getPacketSender().removeInterface();
                    player.setUnlockedCosmetic(true);
                    player.getInventory().add(13265, 1);
                    player.getInventory().add(13267, 1);
                    player.getInventory().add(13269, 1);
                    player.getInventory().add(13258, 1);
                    player.membershipInterfaceHandler.openCosmeticTab();
                    player.sendMessage("You have claimed your Monthly Cosmetic Membership");
                    World.sendMessage("@red@<img=832>[News] @blu@" + player.getUsername() +" @red@claimed a Cosmetic Membership!");
                    player.sendMessage("The Monthly pass ends in " + daysLeft + " days.");
                } else {
                    player.sendMessage("You do not have a Monthly Cosmetic pass.");
                }
                break;

            case 105011:
                player.getSeasonPass().information();
                break;
            case -4928:
            case 28008:
               // player.membershipInterfaceHandler.openCosmeticTab();
                player.sendMessage("The Cosmetic Interface is being revamped! check back next update.");
                break;
            case 117629:
                player.membershipInterfaceHandler.changeCostumeForward();
                break;
            case 117628:
                player.membershipInterfaceHandler.changeCostumeBackward();
                break;
            case -4929:
                player.membershipInterfaceHandler.openBenefitTab();
                break;
            case 26070:
                player.levelNotifications = !player.levelNotifications;
                player.getPacketSender().sendMessage("Level-up notifications toggled: " + (player.levelNotifications ? "on" : "off") + ".");
                break;
            case 77944:
                player.getPacketSender().sendInterfaceRemoval();
                if (!player.getSkillManager().maxed()) {
                    DialogueManager.sendStatement(player, "You must be maxed in all skills to do this.");
                    return;
                }
                if (player.getEquipment().getFreeSlots() != player.getEquipment().capacity()) {
                    player.getPacketSender().sendMessage("Please unequip all your items first.");
                    return;
                }
                if (player.getPointsHandler().getTotalPrestiges() >= 3) {
                    player.getPacketSender().sendMessage("@red@You already are max prestige. Wait until next season to unlock another.");
                    return;
                }
                if (player.getLocation() == Location.WILDERNESS || player.getCombatBuilder().isBeingAttacked()) {
                    player.getPacketSender().sendMessage("You cannot do this at the moment");
                    return;
                }
                player.getPointsHandler().incrementTotalPrestiges(1);
                player.getSkillManager().resetSkill(ATTACK, false);
                player.getSkillManager().resetSkill(DEFENCE, false);
                player.getSkillManager().resetSkill(STRENGTH, false);
                player.getSkillManager().resetSkill(CONSTITUTION, false);
                player.getSkillManager().resetSkill(RANGED, false);
                player.getSkillManager().resetSkill(PRAYER, false);
                player.getSkillManager().resetSkill(MAGIC, false);
                player.getSkillManager().resetSkill(COOKING, false);
                player.getSkillManager().resetSkill(WOODCUTTING, false);
                player.getSkillManager().resetSkill(FLETCHING, false);
                player.getSkillManager().resetSkill(FISHING, false);
                player.getSkillManager().resetSkill(FIREMAKING, false);
                player.getSkillManager().resetSkill(CRAFTING, false);
                player.getSkillManager().resetSkill(SMITHING, false);
                player.getSkillManager().resetSkill(MINING, false);
                player.getSkillManager().resetSkill(HERBLORE, false);
                player.getSkillManager().resetSkill(AGILITY, false);
                player.getSkillManager().resetSkill(THIEVING, false);
                player.getSkillManager().resetSkill(SLAYER, false);
                player.getSkillManager().resetSkill(FARMING, false);
                player.getSkillManager().resetSkill(RUNECRAFTING, false);
                player.getSkillManager().resetSkill(INVENTION, false);
                player.getSkillManager().resetSkill(HUNTER, false);
                player.getSkillManager().resetSkill(SUMMONING, false);
                player.getPointsHandler().setPrestigePoints(1, true);
                player.getAppearance().setprestigeIcon(player.getPointsHandler().getTotalPrestiges());
                player.getPacketSender().sendMessage("You have just prestiged to level " + player.getPointsHandler().getTotalPrestiges() + "!");
                player.getPacketSender().sendMessage(player.getPointsHandler().getTotalPrestiges() + " Prestige Mboxes have been added to your inventory as a reward.");
                World.sendMessage("@blu@<shad=1>[News] @red@" + player.getUsername() + "@bla@ has just prestiged to level " + player.getPointsHandler().getTotalPrestiges() + "!");
                player.getAchievementTracker().progress(AchievementData.PRESTIGE_VETERAN, 1);
                player.getAchievementTracker().progress(AchievementData.PRESTIGE_MASTER, 1);
                if (player.getPointsHandler().getTotalPrestiges() == 1)
                    player.getInventory().add(20488, 10);
                player.getInventory().add(15003, 1);
                player.getInventory().add(23236, 1);
                if (player.getPointsHandler().getTotalPrestiges() == 2)
                    player.getInventory().add(23236, 2);
                if (player.getPointsHandler().getTotalPrestiges() == 3)
                    player.getInventory().add(23236, 3);
                if (player.getPointsHandler().getTotalPrestiges() == 4)
                    player.getInventory().add(23236, 4);
                if (player.getPointsHandler().getTotalPrestiges() == 5)
                    player.getInventory().add(23236, 5);
                if (player.getPointsHandler().getTotalPrestiges() == 6)
                    player.getInventory().add(23236, 6);
                if (player.getPointsHandler().getTotalPrestiges() == 7)
                    player.getInventory().add(23236, 7);
                if (player.getPointsHandler().getTotalPrestiges() == 8)
                    player.getInventory().add(23236, 8);
                if (player.getPointsHandler().getTotalPrestiges() == 9)
                    player.getInventory().add(23236, 9);
                if (player.getPointsHandler().getTotalPrestiges() == 10)
                    player.getInventory().add(23236, 10);
                player.prestigeInterface.openPrestigeInterface();
                break;
            case -18527:
            case 111214:
                player.getPacketSender().sendString(1, GameSettings.StoreUrl);
                break;

            case 77834:
            case -18522:
            case -17390:
            case 77146:
            case 77346:
            case 77446:
            case 77546:
            case 77251:
            case 71516:
            case 71576:
            case 80576:
            case 77934:
            case 71536:
                player.getPacketSender().removeInterface();
                break;

            case 80242:
                if (player.getInventory().contains(23386)) {
                    player.getInventory().delete(23386, 1);
                    player.getInventory().add(23387, 1);
                    player.getPA().sendMessage("You have chosen the Lesarkus Warrior Pet!");
                }
                player.getPacketSender().removeInterface();
                break;
            case 80245:
                if (player.getInventory().contains(23386)) {
                    player.getInventory().delete(23386, 1);
                    player.getInventory().add(23388, 1);
                    player.getPA().sendMessage("You have chosen the Fatal Warrior Pet!");
                }
                player.getPacketSender().removeInterface();
                break;

            case 80248:
                if (player.getInventory().contains(23386)) {
                    player.getInventory().delete(23386, 1);
                    player.getInventory().add(23389, 1);
                    player.getPA().sendMessage("You have chosen the Immortal Warrior Pet!");
                }
                player.getPacketSender().removeInterface();
                break;


            case 77242:
                if (player.getInventory().contains(23367)) {
                    player.getInventory().delete(23367, 1);
                    player.getInventory().add(23324, 1);
                    player.getPA().sendMessage("You have chosen the Faeless Magician Pet!");
                }
                player.getPacketSender().removeInterface();
                break;
            case 77245:
                if (player.getInventory().contains(23367)) {
                    player.getInventory().delete(23367, 1);
                    player.getInventory().add(23325, 1);
                    player.getPA().sendMessage("You have chosen the Lotus Magician Pet!");
                }
                player.getPacketSender().removeInterface();
                break;

            case 77248:
                if (player.getInventory().contains(23367)) {
                    player.getInventory().delete(23367, 1);
                    player.getInventory().add(23326, 1);
                    player.getPA().sendMessage("You have chosen the Shadow Magician Pet!");
                }
                player.getPacketSender().removeInterface();
                break;


            case 107242:
                if (player.getInventory().contains(23409)) {
                    player.getInventory().delete(23409, 1);
                    player.getInventory().add(13223, 1);
                    player.getPA().sendMessage("You have chosen the Forest Archer Pet!");
                }
                player.getPacketSender().removeInterface();
                break;

            case 107245:
                if (player.getInventory().contains(23409)) {
                    player.getInventory().delete(23409, 1);
                    player.getInventory().add(13224, 1);
                    player.getPA().sendMessage("You have chosen the Chaotic Archer Pet!");
                }
                player.getPacketSender().removeInterface();
                break;

            case 107248:
                if (player.getInventory().contains(23409)) {
                    player.getInventory().delete(23409, 1);
                    player.getInventory().add(13225, 1);
                    player.getPA().sendMessage("You have chosen the Divine Archer Pet!");
                }
                player.getPacketSender().removeInterface();
                break;


            case 77142:
                if (player.getPointsHandler().getBorkKC() < 50000) {
                    player.getPA().sendMessage("You need 50,000 Bork KC before you can sacrifice your Legends Light staff.");
                    return;
                }
                if (player.getPointsHandler().getBorkKC() >= 50000 && player.getInventory().contains(17013)) {
                    player.getPA().sendMessage("You sacrifice your Legends Light staff and become a Tier 1 Magician in the Guild!");
                    World.sendMessage("<img=832> @red@" + player.getUsername() + " has just became a Tier 1 Magician!");
                    player.setMagicGuildTier1(true);
                    player.getInventory().delete(17013, 1);
                    Position magicGuild = new Position(2204, 4511);
                    TeleportHandler.teleportPlayer(player, magicGuild, player.getSpellbook().getTeleportType());
                    return;
                } else
                    player.getPA().sendMessage("You need to sacrifice x1 Legends Light Staff");
                break;
            case 88142:
                if (player.getPointsHandler().getBorkKC() < 50000) {
                    player.getPA().sendMessage("You need 50,000 Bork KC before you can sacrifice your Legends Light bow.");
                    return;
                }
                if (player.getPointsHandler().getBorkKC() >= 50000 && player.getInventory().contains(5011)) {
                    player.getPA().sendMessage("You sacrifice your Legends Light bow and become a Tier 1 Archer in the Guild!");
                    World.sendMessage("<img=832> @red@" + player.getUsername() + " has just became a Tier 1 Archer!");
                    player.setArcherGuildTier1(true);
                    player.getInventory().delete(5011, 1);
                    Position archerGuild = new Position(3356, 4703);
                    TeleportHandler.teleportPlayer(player, archerGuild, player.getSpellbook().getTeleportType());
                    return;
                } else
                    player.getPA().sendMessage("You need to sacrifice x1 Legends Light bow");
                break;
            case 71512:
                if (player.getPointsHandler().getBorkKC() < 50000) {
                    player.getPA().sendMessage("You need 50,000 Bork KC before you can sacrifice your Light Staff of Vitur.");
                    return;
                }
                if (player.getPointsHandler().getBorkKC() >= 50000 && player.getInventory().contains(12537)) {
                    player.getPA().sendMessage("You sacrifice your Light Scythe of Vitur and become a Tier 1 Warrior in the Guild!");
                    World.sendMessage("<img=832> @red@" + player.getUsername() + " has just became a Tier 1 Warrior!");
                    player.setWarriorGuildTier1(true);
                    player.getInventory().delete(12537, 1);
                    Position warriorGuild = new Position(1948, 4191);
                    TeleportHandler.teleportPlayer(player, warriorGuild, player.getSpellbook().getTeleportType());
                    return;
                } else
                    player.getPA().sendMessage("You need to sacrifice x1 Light Scythe of Vitur");
                break;
            case -18532:
                player.getNewSpinner().findReward();
                break;

            case 21353:
                player.getWheelOfFortune().start();
                break;

            case 21372:
                player.getWheelOfFortune().open();
                break;


            case 8666:
                Position prayerAlter = new Position(2768, 4064, 0);
                TeleportHandler.teleportPlayer(player, prayerAlter, TeleportType.NORMAL);
                break;

            case 8662:
                Position fishingPos = new Position(2786, 2598, 0);
                TeleportHandler.teleportPlayer(player, fishingPos, TeleportType.NORMAL);
                break;

            case 8665:

            case 8668:
                Position cookingPos = new Position(2817, 2598, 0);
                TeleportHandler.teleportPlayer(player, cookingPos, TeleportType.NORMAL);
                break;

            case 28178:
                Position huntingPos = new Position(2810, 2651, 0);
                TeleportHandler.teleportPlayer(player, huntingPos, TeleportType.NORMAL);
                break;

            case 8656:
                Position miningPos = new Position(2803, 2611, 0);
                TeleportHandler.teleportPlayer(player, miningPos, TeleportType.NORMAL);
                break;
            case 71532:
                if (player.getPointsHandler().getLesarkusWarriorKC() < 25000) {
                    player.getPA().sendMessage("You need 25,000 Lesarkus Warrior kills before sacrificing x1 Dark Scythe of Vitur");
                    return;
                }

                if (player.getInventory().getFreeSlots() < 1) {
                    player.getPA().sendMessage("You need at-least 1 free inventory space to level up!");
                    return;
                }
                if (player.getInventory().contains(22115, 1)) {
                    player.getInventory().delete(22115, 1);
                } else if (!player.getInventory().contains(22115, 1)) {
                    player.getPA().sendMessage("You need x1 Dark Scythe of Vitur to Level up!");
                    return;
                }
                player.getPA().sendMessage("You sacrifice your Dark Scythe of Vitur and Unlock Tier 2 of the Warrior Guild.");
                World.sendMessage("<img=832>@red@" + player.getUsername() + "@blu@ Has leveled up to @red@Tier 2 @blu@of the @red@Warrior Guild");
                player.getPacketSender().sendInterfaceRemoval();
                player.getPacketSender().sendInterface(71560);
                player.setWarriorGuildTier2(true);
                player.getInventory().add(23383, 1);
                player.getPA().sendMessage("<img=832> x1 Lesarkus Blade has been added to your inventory.");
                break;
            case 71572:
                if (player.getPointsHandler().getVampireWarriorKC() < 50_000) {
                    player.getPA().sendMessage("You need 50,000 Fatal Warrior kills before sacrificing x1 Owner Fragment.");
                    return;
                }

                if (player.getInventory().getFreeSlots() < 1) {
                    player.getPA().sendMessage("You need at-least 1 free inventory space to level up!");
                    return;
                }
                if (player.getInventory().contains(8136, 1)) {
                    player.getInventory().delete(8136, 1);
                } else if (!player.getInventory().contains(8136, 1)) {
                    player.getPA().sendMessage("You need x1 Blood Scythe of Vitur to Level up!");
                    return;
                }
                player.getPA().sendMessage("You sacrifice your Blood Scythe of Vitur and Unlock Tier 3 of the Warrior Guild.");
                World.sendMessage("<img=832>@red@" + player.getUsername() + "@blu@ Has leveled up to @red@Tier 3 @blu@of the @red@Warrior Guild");
                player.getPacketSender().sendInterfaceRemoval();
                player.getPacketSender().sendInterface(80560);
                player.setWarriorGuildTier3(true);
                player.getInventory().add(23384, 1);
                player.getPA().sendMessage("<img=832> x1 Kismet Medallion has been added to your inventory.");
                break;
            case 80572:
                if (player.getPointsHandler().getAncientWarriorKC() < 75_000) {
                    player.getPA().sendMessage("You need 75,000 Immortal Warrior kills before sacrificing 100,000,000 Levincia tokens.");
                    return;
                }

                if (player.getInventory().getFreeSlots() < 1) {
                    player.getPA().sendMessage("You need at-least 1 free inventory space to level up!");
                    return;
                }

                if (player.getInventory().contains(12855, 100_000_000)) {
                    player.getInventory().delete(12855, 100_000_000);
                } else if (!player.getInventory().contains(12855, 100_000_000)) {
                    player.getPA().sendMessage("You need 100,000,000 Levincia tokens to Level up!");
                    return;
                }
                player.getPA().sendMessage("You sacrifice 100,000,000 Levincia tokens and Unlock Tier Warrior Master.");
                World.sendMessage("<img=832>@red@" + player.getUsername() + "@blu@ Has leveled up to @red@Warrior Master @blu@of the @red@Warrior Guild");
                player.getPacketSender().sendInterfaceRemoval();
                player.setWarriorMaster(true);
                player.getInventory().add(23386, 1);
                player.getPA().sendMessage("<img=832>x1 Warrior Pet scroll was added to your inventory");
                player.getPA().sendMessage("<img=832> Your account has received a permanent 0.20% Melee Damage increase!");
                break;
            case 77342:
                if (player.getPointsHandler().getFacelessMagicianKC() < 25000) {
                    player.getPA().sendMessage("You need 25,000 Faceless Magician kills before sacrificing a Legends Dark staff.");
                    return;
                }

                if (player.getInventory().getFreeSlots() < 1) {
                    player.getPA().sendMessage("You need at-least 1 free inventory space to level up!");
                    return;
                }
                if (player.getInventory().contains(22114, 1)) {
                    player.getInventory().delete(22114, 1);
                } else if (!player.getInventory().contains(22114)) {
                    player.getPA().sendMessage("You need to sacrifice a Legends Dark staff to level up!");
                    return;
                }
                player.getPA().sendMessage("You sacrifice 1 Legends Dark staff and unlock Tier 2 of the Magic Guild.");
                World.sendMessage("<img=832>@red@" + player.getUsername() + "@blu@ Has leveled up to @red@Tier 2 @blu@of the @red@Magic Guild");
                player.getPacketSender().sendInterfaceRemoval();
                player.getPacketSender().sendInterface(77430);
                player.setMagicGuildTier2(true);
                player.getInventory().add(3745, 1);
                player.getPA().sendMessage("<img=832> x1 Magician staff has been added to your inventory.");
                break;

            case 77442:
                if (player.getPointsHandler().getLotusMagicianKC() < 50_000) {
                    player.getPA().sendMessage("You need 50,000 Lotus Magician kills before sacrificing a Blood Staff.");
                    return;
                }

                if (player.getInventory().getFreeSlots() < 1) {
                    player.getPA().sendMessage("You need at-least 1 free inventory space to level up!");
                    return;
                }
                if (player.getInventory().contains(23227, 1)) {
                    player.getInventory().delete(23227, 1);
                } else if (!player.getInventory().contains(23227)) {
                    player.getPA().sendMessage("You need to sacrifice a Blood Staff to Level up!");
                    return;
                }
                player.getPA().sendMessage("You sacrifice a Blood Staff and Unlock Tier 2 of the Magic Guild.");
                World.sendMessage("<img=832>@red@" + player.getUsername() + "@blu@ Has leveled up to @red@Tier 3 @blu@of the @red@Magic Guild");
                player.getPacketSender().sendInterfaceRemoval();
                player.getPacketSender().sendInterface(77530);
                player.setMagicGuildTier3(true);
                player.getInventory().add(23229, 1);
                player.getPA().sendMessage("<img=832> x1 Gemstone Kaseki has been added to your inventory.");
                break;

            case 77542:
                if (player.getPointsHandler().getShadowMagicianKC() < 75_000) {
                    player.getPA().sendMessage("You need 75,000 Shadow Magician kills before sacrificing 250,000,000 Levincia tokens");
                    return;
                }

                if (player.getInventory().getFreeSlots() < 1) {
                    player.getPA().sendMessage("You need at-least 1 free inventory space to level up!");
                    return;
                }
                if (player.getInventory().contains(12855, 100_000_000)) {
                    player.getInventory().delete(12855, 100_000_000);
                } else if (!player.getInventory().contains(12855, 100_000_000)) {
                    player.getPA().sendMessage("You need to sacrifice 100,000,000 Levincia tokens to level up!");
                    return;
                }
                player.getPA().sendMessage("You sacrifice 100,000,000 Levincia tokens and Unlock Tier Magician Master of the Magic Guild.");
                World.sendMessage("<img=832>@red@" + player.getUsername() + "@blu@ Has leveled up to @red@Magician Master @blu@of the @red@Magic Guild");
                player.getPacketSender().sendInterfaceRemoval();
                player.setMagicianMaster(true);
                player.getInventory().add(23367, 1);
                player.getPA().sendMessage("<img=832>x1 Magician Pet scroll was added to your inventory");
                player.getPA().sendMessage("<img=832> Your account has received a permanent 0.20% Magic Damage increase!");
                break;


            case 88342:
                if (player.getPointsHandler().getForestArcherKC() < 25000) {
                    player.getPA().sendMessage("You need 25,000 Forest Archer kills before sacrificing a Legends Dark bow.");
                    return;
                }

                if (player.getInventory().getFreeSlots() < 1) {
                    player.getPA().sendMessage("You need at-least 1 free inventory space to level up!");
                    return;
                }
                if (player.getInventory().contains(22113, 1)) {
                    player.getInventory().delete(22113, 1);
                } else if (!player.getInventory().contains(22113)) {
                    player.getPA().sendMessage("You need to sacrifice a Legends Dark bow to level up!");
                    return;
                }
                player.getPA().sendMessage("You sacrifice 1 Legends Dark bow and unlock Tier 2 of the Archer Guild.");
                World.sendMessage("<img=832>@red@" + player.getUsername() + "@blu@ Has leveled up to @red@Tier 2 @blu@of the @red@Archer Guild");
                player.getPacketSender().sendInterfaceRemoval();
                player.getPacketSender().sendInterface(88430);
                player.setArcherGuildTier2(true);
                player.getInventory().add(17718, 1);
                player.getPA().sendMessage("<img=832> x1 Batman bow has been added to your inventory.");
                break;

            case 88442:
                if (player.getPointsHandler().getChaoticArcherKC() < 50000) {
                    player.getPA().sendMessage("You need 50,000 Chaotic Archer kills before sacrificing a Blood gun.");
                    return;
                }

                if (player.getInventory().getFreeSlots() < 1) {
                    player.getPA().sendMessage("You need at-least 1 free inventory space to level up!");
                    return;
                }
                if (player.getInventory().contains(23226, 1)) {
                    player.getInventory().delete(23226, 1);
                } else if (!player.getInventory().contains(23226)) {
                    player.getPA().sendMessage("You need to sacrifice a Blood gun to level up!");
                    return;
                }
                player.getPA().sendMessage("You sacrifice your Blood gun and unlock Tier 3 of the Archer Guild.");
                World.sendMessage("<img=832>@red@" + player.getUsername() + "@blu@ Has leveled up to @red@Tier 3 @blu@of the @red@Archer Guild");
                player.getPacketSender().sendInterfaceRemoval();
                player.getPacketSender().sendInterface(88530);
                player.setArcherGuildTier3(true);
                player.getInventory().add(23385, 1);
                player.getPA().sendMessage("<img=832> x1 Lucky pendant has been added to your inventory.");
                break;

            case 88542:
                if (player.getPointsHandler().getDivineArcherKC() < 75_000) {
                    player.getPA().sendMessage("You need 75,000 Divine archer kills before sacrificing 100,000,000 Levincia tokens");
                    return;
                }

                if (player.getInventory().getFreeSlots() < 1) {
                    player.getPA().sendMessage("You need at-least 1 free inventory space to level up!");
                    return;
                }
                if (player.getInventory().contains(12855, 100_000_000)) {
                    player.getInventory().delete(12855, 100_000_000);
                } else if (!player.getInventory().contains(12855, 100_000_000)) {
                    player.getPA().sendMessage("You need to sacrifice 100,000,000 Levincia tokens to level up!");
                    return;
                }
                player.getPA().sendMessage("You sacrifice 100,000,000 Levincia tokens and Unlock Tier Archer Master of the Magic Guild.");
                World.sendMessage("<img=832>@red@" + player.getUsername() + "@blu@ Has leveled up to @red@Archer Master @blu@of the @red@Archer Guild");
                player.getPacketSender().sendInterfaceRemoval();
                player.setArcherMaster(true);
                player.getInventory().add(23409, 1);
                player.getPA().sendMessage("<img=832>x1 Archer Pet scroll was added to your inventory");
                player.getPA().sendMessage("<img=832> Your account has received a permanent 0.20% Range Damage increase!");
                break;


            case 8659:
                Position smithingPos = new Position(2818, 2609, 0);
                TeleportHandler.teleportPlayer(player, smithingPos, TeleportType.NORMAL);
                break;

            case 8671:
                Position woodcuttingPos = new Position(2802, 2665, 0);
                TeleportHandler.teleportPlayer(player, woodcuttingPos, TeleportType.NORMAL);
                break;

            case 13928:
                Position farmingPos = new Position(2828, 2658, 0);
                TeleportHandler.teleportPlayer(player, farmingPos, TeleportType.NORMAL);
                break;


            case 8672:
                Position rcPos = new Position(2806, 2582, 0);
                TeleportHandler.teleportPlayer(player, rcPos, TeleportType.NORMAL);
                break;

            case 8664:
                Position thievingPos = new Position(2823, 2601, 0);
                TeleportHandler.teleportPlayer(player, thievingPos, TeleportType.NORMAL);
                break;

            case 8658:
                DialogueManager.start(player, 55);
                player.setDialogueActionId(26);
                break;

            case 8861:
            case 8667:
            case 8670:
                Position skillingShopsPos = new Position(2818, 2592, 0);
                TeleportHandler.teleportPlayer(player, skillingShopsPos, TeleportType.NORMAL);
                break;
            case 12464:
                player.motivationalToggle = !player.motivationalToggle;
                player.sendMessage("Show motivational teleport messages currently set to: " + player.motivationalToggle);
                player.getPacketSender().sendConfig(427, player.motivationalToggle ? 0 : 1);
                break;
            case 21360:
            case 133002:
            case -17490:
            case -12286:
            case 28133:
            case 27133:
            case 26133:
            case -16938:
            case -17492:
            case 31502:
            case 142255:
            case -4931:
            case 125008:
            case 88346:
            case 88446:
            case 88546:
            case 88146:

            case 106005:
            case -8305:


            case -13233:

            case -27454:
            case -27534:
            case -16534:
            case 36002:
            case 32606:
            case -31929:
            case -8255:
            case 19705:
            case 28005:
            case 26003:
            case 5384:
            case -13390:
            case 142402:

                player.getPacketSender().sendInterfaceRemoval();
                break;

            // Previous Teleport Button
            case 1717:
                if (!player.getClickDelay().elapsed(4500) || player.getMovementQueue().isLockMovement())
                    return;

                if (player.lastTeleport != null) {
                    player.sendMessage("You have been teleported to your last teleport location.");
                    TeleportHandler.teleportPlayer(player, player.lastTeleport, player.getSpellbook().getTeleportType());
                } else {
                    player.sendMessage("You haven't teleported yet.");
                }

                player.getClickDelay().reset(0);
                break;

            case 21375:
                player.getWheelOfFortune().start();
                player.getPacketSender().updateInterfaceVisibility(21370, false);
                player.getPacketSender().updateInterfaceVisibility(21362, false);
                break;

            case 25408:
                player.getScratchcard().claimPrize();
                break;
            case 28210:
                new TeleportInterfaceHandler(player).teleport();
                break;
            case 1716:
            case 106009:
                if (!player.isBanking() || player.getInterfaceId() != 106000)
                    return;
                GroupIronmanBank.depositItems(player, player.getInventory(), false);
                break;
            case 106012:
                if (!player.isBanking() || player.getInterfaceId() != 106000)
                    return;
                GroupIronmanBank.depositItems(player, player.getEquipment(), false);
                break;

            case -17400:
            case 110008:
                if (player.getLocation() == Location.DARKNESS_LOBBY)
                    ShadowRewards.open(player);
                else
                player.getCasketOpening().quickSpin();
                break;
            case -17397:
                if (player.getLocation() == Location.DARKNESS_LOBBY)
                    ShadowRewards.openAll(player);
                else
                if (player.getInventory().contains(player.getMysteryBoxOpener().getOpenBox())) {
                    player.getMysteryBoxOpener().openAllRaids2Chest(player.getMysteryBoxOpener().getOpenBox());
                }
                break;
            case -17403:
                if (player.getLocation() == Location.DARKNESS_LOBBY)
                    player.getPacketSender().sendMessage("You can sacrifice Souls of Suffering armour to the chest to increase your chances.");
                else
                player.getPacketSender().sendMessage("<img=832> 20% Chance at 2X loot on Rare Rewards with a @blu@Suffering charm @bla@equipped.");
                break;
            case 110007:
                player.getCasketOpening().spin();
                break;

            case 111104:
            case 111602:
                AchievementInterface.open(player);
                break;
            case 111105:
                player.getPacketSender().sendTabInterface(GameSettings.QUESTS_TAB, 111700).sendTab(GameSettings.QUESTS_TAB);
                break;
            case 78395:
                // player.sendMessage("@red@This feature is currently disabled.");

                if (!player.isBanking() || player.getInterfaceId() != 5292)
                    return;
                player.setPlaceholders(!player.isPlaceholders());
                player.getPacketSender().sendConfig(111, player.isPlaceholders() ? 0 : 1);

                break;
            case 111703:

                if (player.getSkillManager().getMaxLevel(Skill.SLAYER) < 98) {
                    player.getPacketSender().sendMessage("<shad=1>@or2@You must be 99+ Slayer to do Legend Raids.");
                    return;
                }
                if (player.getLocation() == Location.TELOS_LOBBY) {
                    if (player.getTelosRaidsParty () != null) {
                        if (player.getTelosRaidsParty ().getOwner () != player) {
                            player.getPacketSender ().sendMessage ("Only the party leader can invite other players.");
                        } else {
                            player.setInputHandling (new InviteRaidsPlayer ());
                            player.getPacketSender ().sendEnterInputPrompt ("Invite Player");
                        }
                    } else {
                        if (player.getLocation () == Location.TELOS_LOBBY)
                            new TelosRaidParty (player).create ();
                    }
                }else if (player.getLocation() == Location.DARKNESS_LOBBY) {
                    if (player.getShadowRaidsParty() != null) {
                        if (player.getShadowRaidsParty().getOwner() != player) {
                            player.getPacketSender().sendMessage("Only the party leader can invite other players.");
                        } else {
                            player.setInputHandling(new InviteRaidsPlayer());
                            player.getPacketSender().sendEnterInputPrompt("Invite Player");
                        }
                    } else {
                        if (player.getLocation() == Location.DARKNESS_LOBBY)
                            new NecromancerRaidParty (player).create();
                    }
                }else if (player.getLocation() == Location.ZOMBIE_LOBBY) {
                    if (player.getZombieRaidsParty() != null) {
                        if (player.getZombieRaidsParty().getOwner() != player) {
                            player.getPacketSender().sendMessage("Only the party leader can invite other players.");
                        } else {
                            player.setInputHandling(new InviteRaidsPlayer());
                            player.getPacketSender().sendEnterInputPrompt("Invite Player");
                        }
                    } else {
                        if (player.getLocation() == Location.ZOMBIE_LOBBY )
                        new LegendsRaidParty(player).create();
                    }
                } else if (player.getLocation() == Location.SOD_LOBBY) {
                    if (player.getRaidsParty() != null) {
                        if (player.getRaidsParty().getOwner() != player) {
                            player.getPacketSender().sendMessage("Only the party leader can invite other players.");
                        } else {
                            player.setInputHandling(new InviteRaidsPlayer());
                            player.getPacketSender().sendEnterInputPrompt("Invite Player");
                        }
                    } else {
                        if (player.getLocation() == Location.SOD_LOBBY )
                            new RaidsParty(player).create();
                    }
                } else {
                    player.sendMessage("You must be in a raid lobby to do this.");
                }
                return;

            case 111706:
                if (player.getLocation() == Location.ZOMBIE || player.getLocation() == Location.SOD ||
                        player.getLocation() == Location.TELOS || player.getLocation() == Location.SHADOWS_OF_DARKNESS ||
                        player.getLocation() == Location.ZOMBIE_LOBBY || player.getLocation() == Location.SOD_LOBBY ||
                        player.getLocation() == Location.DARKNESS_LOBBY || player.getLocation() == Location.TELOS_LOBBY) {
                    if (player.getRaidsParty() != null) {
                        player.getRaidsParty().remove(player, true);
                        player.sendMessage("You left your Raids party.");
                    } else if (player.getZombieRaidsParty() != null) {
                        player.getZombieRaidsParty().remove(player, true);
                        player.sendMessage("You left your Raids party.");
                    } else if (player.getShadowRaidsParty() != null) {
                        player.getShadowRaidsParty().remove(player, true);
                        player.sendMessage("You left your Raids party.");
                    } else if (player.getTelosRaidsParty() != null) {
                        player.getTelosRaidsParty().remove(player, true);
                        player.sendMessage("You left your Raids party.");
                    }
                } else {
                    player.sendMessage("You must be in a raid to do this.");
                }
                return;

            case 111211:
                player.getPacketSender().sendString(1, GameSettings.DomainUrl);
                break;
            case 111212:
            case 111215:
                player.getPacketSender().sendString(1, GameSettings.DiscordUrl);
                break;
            case 111213:
                player.getPacketSender().sendString(1, GameSettings.VoteUrl);
                break;
            case 111716:
            case 111719:
            case 111722:
            case 111725:
            case 111728:
            case 111731:
            case 111734:
            case 111737:
            case 111740:
            case 111743:
            case 111746:
            case 111749:
                if (player.getLocation() == Location.ZOMBIE || player.getLocation() == Location.SOD ||
                        player.getLocation() == Location.TELOS || player.getLocation() == Location.SHADOWS_OF_DARKNESS ||
                        player.getLocation() == Location.ZOMBIE_LOBBY || player.getLocation() == Location.SOD_LOBBY ||
                        player.getLocation() == Location.DARKNESS_LOBBY || player.getLocation() == Location.TELOS_LOBBY) {
                    if (player.getRaidsParty() != null) {
                        if (player.equals(player.getRaidsParty().getOwner())) {
                            if (player.getRaidsParty().getPlayers()
                                    .size() >= ((id - 111716) / 3) + 1) {
                                Player playerToKick = player.getRaidsParty()
                                        .getPlayers().get((id - 111716) / 3);
                                if (playerToKick == player) {
                                    player.sendMessage("You cannot kick yourself!");
                                } else {
                                    player.getRaidsParty().remove(playerToKick,
                                            true);

                                }
                            }
                        } else {
                            player.sendMessage("Only the leader of the party can kick players!");
                        }
                    }
                } else {
                    player.sendMessage("You must be in a raid to do this.");
                }
                return;
            /*case 111603:
                BestItemsInterface.openInterface(player, 0);
                break;*/
            case 111604:
                player.getCollectionLog2().open(MONSTERS);
                player.getPacketSender().sendConfig(1106, 0);
                break;
            case 111605:
                player.getPacketSender().sendInterfaceRemoval();
                BossLog.open(player);
                // KillTrackerInterface.open(player);
                break;
            case 111611:
                player.setInputHandling(new ChangePassword());
                player.getPacketSender().sendEnterInputPrompt("Enter a new password:");
                break;
            case 82488:
                if (player.getCurrentData().getName().equalsIgnoreCase("wreckedyou") && player.getCurrentData().getLive()) {
                    player.getPacketSender().sendString(1, player.getCurrentData().getChannel());
                    player.getPacketSender().sendMessage("Attempting to open <img=10>Wr3ckedyou's Youtube Channel");
                } else if (player.getCurrentData().getName().equalsIgnoreCase("inheritedrs") && player.getCurrentData().getLive()) {
                    player.getPacketSender().sendString(1, player.getCurrentData().getChannel());
                    player.getPacketSender().sendMessage("Attempting to open <img=10>InheritedRS's Youtube Channel");
                } else if (player.getCurrentData().getName().equalsIgnoreCase("chopper rsps") && player.getCurrentData().getLive()) {
                    player.getPacketSender().sendString(1, player.getCurrentData().getChannel());
                    player.getPacketSender().sendMessage("Attempting to open <img=10>chopper rsps's Youtube Channel");
                } else if (player.getCurrentData().getName().equalsIgnoreCase("walkchaos") && player.getCurrentData().getLive()) {
                    player.getPacketSender().sendString(1, player.getCurrentData().getChannel());
                    player.getPacketSender().sendMessage("Attempting to open <img=10>Walkchaos Youtube Channel");
                } else if (player.getCurrentData().getName().equalsIgnoreCase("celestial") && player.getCurrentData().getLive()) {
                    player.getPacketSender().sendString(1, player.getCurrentData().getChannel());
                    player.getPacketSender().sendMessage("Attempting to open <img=10>Celestial's Youtube Channel");
                } else if (player.getCurrentData().getName().equalsIgnoreCase("lano") && player.getCurrentData().getLive()) {
                    player.getPacketSender().sendString(1, player.getCurrentData().getChannel());
                    player.getPacketSender().sendMessage("Attempting to open <img=10>Lano's Youtube Channel");
                } else if (!player.getCurrentData().live) {
                    player.getPacketSender().sendMessage("This youtuber is not currently live!");
                } else
                    player.getPacketSender().sendMessage("Select a Youtuber to view their channel.");

                break;

            case 82485:
                YoutubeData.handleSyntax(player, player.getCurrentData().getName());
                break;
            case 111603:
                player.getPacketSender().sendMessage("Opening drops interface...");
                DropsInterface.open(player);
                break;
            case 111606:
                PossibleLootInterface.openInterface(player, PossibleLootInterface.LootData.values()[0]);
                break;

            case 111610:
                player.getVotingStreak().openInterface();
                break;

            case 111612:
                player.setInputHandling(new SetPinPacketListener());
                player.getPacketSender().sendEnterInputPrompt("Enter the pin that you want to set$pin");
                break;
            case 111608:
                BestDRItemsInterface.openInterface(player, 0);
                break;
            case 111609:
                player.getSeasonPass().openInterface();
                break;
            case 111428:
                player.questInterface.openQuestOne();
                break;
            case 111429:
                player.questInterface.openQuestTwo();
                break;
            case 111607:
                BestItemsInterface.openInterface(player, 0);
                break;

            case 111101:
                player.getPacketSender().sendTabInterface(GameSettings.QUESTS_TAB, 111000);
                player.getPacketSender().sendConfig(6000, 0);
                break;
            case 111102:
                player.getPacketSender().sendTabInterface(GameSettings.QUESTS_TAB, 111300);
                player.getPacketSender().sendConfig(6000, 1);
                break;
            case 111103:
                player.getPacketSender().sendTabInterface(GameSettings.QUESTS_TAB, 111500);
                player.getPacketSender().sendConfig(6000, 2);
                break;

            case 111601:
                for (int i = 8145; i < 8186; i++)
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
                break;
            case 31508:
                player.getEventBossManager().updateNpcIdentification();
                break;

            case 31509:
                player.getEventBossManager().updateNpcHealth();
                break;

            case 31513:
                player.getEventBossManager().initiateSpawn();
                break;

            case -16332:
                player.getGoodieBag().claim();
                break;


            case 23638:
            case 23636:
                player.getScratchCard().scratch();
                break;

            case -8274:
                player.getDailyRewards().claimDay7();
                break;

            /**
             * Combiner
             */

            case -17500:
                if (player.getInventory().contains(player.getMysteryBoxOpener().getOpenBox())) { // example for mbox with random data.
                    player.getMysteryBoxOpener().open(player.getMysteryBoxOpener().getOpenBox());
                }


                break;

            case -17497: // example for mbox with random data. - open all
                if (player.getInventory().contains(player.getMysteryBoxOpener().getOpenBox())) {
                    player.getMysteryBoxOpener().openAll(player.getMysteryBoxOpener().getOpenBox());
                }

                break;

            case -8384:
                player.sendMessage("Auto gambling has been disabled.");
                player.sendMessage("In order to gamble, you have to purchase the dice bag or seeds via ::Store");
                break;

            case -8383:
                if (player.getGambling().inGamble())
                    player.getGambling().declineGamble(true);
                break;
            case 30935:

                if (player.getInventory().contains(ItemDefinition.COIN_ID, 50000000)) {
                    player.setEntriesCurrency(player.getEntriesCurrency() + 5.0);
                    player.getInventory().delete(ItemDefinition.COIN_ID, 50000000);
                    player.getPA().sendMessage("<img=30>You have purchased a lottery ticket, go enter the lottery!");
                } else {
                    player.getPA().sendMessage("Each lottery ticket costs 50 Mill, Please have 50 Mill in your inventory.");
                }
                break;
            case 22095:
                DoubleOrNothing.handleGamble(player);
                break;
            case 22090:
            case 22098:
                DoubleOrNothing.handleKeep(player);
                break;
            case 19633:
                player.setInputHandling(new PollCreationTitle());
                player.getPacketSender().sendEnterInputPrompt("What Title would you like to apply?");
                break;
            case 19637:
                player.setInputHandling(new PollCreationOptionOne());
                player.getPacketSender().sendEnterInputPrompt("What First Option would you like to poll?");
                break;
            case 19641:
                player.setInputHandling(new PollCreationOptionTwo());
                player.getPacketSender().sendEnterInputPrompt("What Second Option would you like to poll?");
                break;
            case 19645:
                player.setInputHandling(new PollCreationTimeForPoll());
                player.getPacketSender().sendEnterInputPrompt("How long would you like the poll to stay active?P");
                break;
            case 19649:
                PollCreation.launchPoll(player);
                break;
            case 19654:
                PollCreation.resetPoll(player);
                break;
            case -8254:
                player.getPacketSender().sendString(1, GameSettings.StoreUrl);
                player.getPacketSender().sendMessage("Attempting to open the store");
                break;
            case -11438:
                player.getPlayerOwnedShopManager().openEditor();
                break;
            case 29133:
                player.getPacketSender().sendMessage("::leave to leave room");
                //player.getPacketSender().sendMessage("@red@Please re-group!");
                player.getPacketSender().sendInterfaceRemoval();

                //TeleportHandler.teleportPlayer(player, new Position(2722, 2737), player.getSpellbook().getTeleportType());

                player.getPacketSender().sendString(29053, "").sendString(29054, "");

                for (int i = 0; i < 10; i++) {
                    player.getPacketSender().sendString(29095 + i, ""); // this should be the final thing., added UI check for every place now.

                }
                break;

            case 15009:
                player.setCosmeticOveride(!player.isCosmeticOveride());
                player.sendMessage("Showing Cosmetic overrides: " + player.isCosmeticOveride());
                player.getUpdateFlag().flag(Flag.APPEARANCE);
                break;

            case 142266:// Dustclaws
                if (player.getPointsHandler().getNPCKILLCount() <= 49){
                    player.getPacketSender().sendMessage("You need 50 npc kill Count. You currently have @red@"
                            + player.getPointsHandler().getNPCKILLCount() + "@bla@ kills.");
                    player.getPacketSender().sendMessage("@blu@To get Fast NPC KILLS go to ::Starter");
                    return;
                }
                Position positionspawns = GameSettings.DUSTCLAW_LOCATION;
                TeleportHandler.teleportPlayer(player, positionspawns, TeleportType.NORMAL);
                break;

            case 142267:// LORD
                if (player.getPointsHandler().getSPAWNKILLCount() <= 99) {
                    player.getPacketSender().sendMessage("You need 100 Dustclaw kills. You currently have @red@"
                            + player.getPointsHandler().getSPAWNKILLCount() + "@bla@ kills.");
                    return;
                }
                Position positionlord = GameSettings.LORDS_LOCATION;
                TeleportHandler.teleportPlayer(player, positionlord, TeleportType.NORMAL);
                break;

            case 142268:// Shadow
                if (player.getPointsHandler().getLORDKILLCount() <= 199) {
                    player.getPacketSender().sendMessage("You need 200 Lord kills. You currently have @red@"
                            + player.getPointsHandler().getLORDKILLCount() + "@bla@ kills.");
                    return;
                }
                Position position2 = GameSettings.SHADOWS_LOCATION;
                TeleportHandler.teleportPlayer(player, position2, TeleportType.NORMAL);
                break;

            case 142269:// Golem
                if (player.getPointsHandler().getDEMONKILLCount() <= 299) {
                    player.getPacketSender().sendMessage("You need 300 Shadow kills. You currently have @red@"
                            + player.getPointsHandler().getDEMONKILLCount() + "@bla@ kills.");
                    return;
                }
                Position position3 = GameSettings.GOLEMS_LOCATION;
                TeleportHandler.teleportPlayer(player, position3, TeleportType.NORMAL);
                break;
            case 77888:
                player.getSeasonPass().information();
                break;

            case 142270:// Shetani
                if (player.getPointsHandler().getDRAGONKILLCount() <= 399) {
                    player.getPacketSender().sendMessage("You need 400 Golem kills. You currently have @red@"
                            + player.getPointsHandler().getDRAGONKILLCount() + "@bla@ kills.");
                    return;
                }
                Position dragon = GameSettings.SHETANI_LOCATION;
                TeleportHandler.teleportPlayer(player, dragon, TeleportType.NORMAL);
                break;

            case 142271:// Ripper
                if (player.getPointsHandler().getBEASTKILLCount() <= 499) {
                    player.getPacketSender().sendMessage("You need 500 Shetani kills. You currently have @red@"
                            + player.getPointsHandler().getBEASTKILLCount() + "@bla@ kills.");
                    return;
                }
                Position king = GameSettings.RIPPER_LOCATION;
                TeleportHandler.teleportPlayer(player, king, TeleportType.NORMAL);
                break;

            case 142272:// AVATAR
                if (player.getPointsHandler().getKINGKILLCount() <= 999) {
                    player.getPacketSender().sendMessage("You need 1,000 Ripper kills. You currently have @red@"
                            + player.getPointsHandler().getKINGKILLCount() + "@bla@ kills.");
                    return;
                }
                Position avatar = new Position(3301, 3289, 0);
                TeleportHandler.teleportPlayer(player, avatar, TeleportType.NORMAL);
                break;

            case 142273:// Wyverns
                if (player.getPointsHandler().getAVATARKILLCount() <= 1199) {
                    player.getPacketSender().sendMessage("You need 1,200 Avatar kills. You currently have @red@"
                            + player.getPointsHandler().getAVATARKILLCount() + "@bla@ kills.");
                    return;
                }
                Position angel = new Position(3322, 3309, 0);
                TeleportHandler.teleportPlayer(player, angel, TeleportType.NORMAL);
                break;

            case 142274:// Oni
                if (player.getPointsHandler().getANGELKILLCount() <= 1499) {
                    player.getPacketSender().sendMessage("You need 1,500 Wyvern kills. You currently have @red@"
                            + player.getPointsHandler().getANGELKILLCount() + "@bla@ kills.");
                    return;
                }
                Position lucien = new Position(2907, 5455, 0);
                TeleportHandler.teleportPlayer(player, lucien, TeleportType.NORMAL);
                break;

            case 142275:// Shenron
                if (player.getPointsHandler().getLUCIENKILLCount() <= 2499) {
                    player.getPacketSender().sendMessage("You need 2,500 Oni kills. You currently have @red@"
                            + player.getPointsHandler().getLUCIENKILLCount() + "@bla@ kills.");
                    return;
                }
                Position herc = new Position(2931, 5469, 0);
                TeleportHandler.teleportPlayer(player, herc, TeleportType.NORMAL);
                break;

            case 142276:// Subzero
                if (player.getPointsHandler().getHERCULESKILLCount() <= 3499) {
                    player.getPacketSender().sendMessage("You need 3,500 Shenron kills. You currently have @red@"
                            + player.getPointsHandler().getHERCULESKILLCount() + "@bla@ kills.");
                    return;
                }
                Position sait = new Position(2910, 5491, 0);
                TeleportHandler.teleportPlayer(player, sait, TeleportType.NORMAL);
                break;

            case 142277:// Zeus
                if (player.getPointsHandler().getSATANKILLCount() <= 4999) {
                    player.getPacketSender().sendMessage("You need 5,000 Subzero kills. You currently have @red@"
                            + player.getPointsHandler().getSATANKILLCount() + "@bla@ kills.");
                    return;
                }
                Position zzeus = new Position(2893, 5469, 0);
                TeleportHandler.teleportPlayer(player, zzeus, TeleportType.NORMAL);
                break;

            case 142278:// Ipotane
                if (player.getPointsHandler().getZEUSKILLCount() <= 14999) {
                    player.getPacketSender().sendMessage("You need 15,000 Zeus kills. You currently have @red@"
                            + player.getPointsHandler().getZEUSKILLCount() + "@bla@ kills.");
                    return;
                }
                Position ipotane = new Position(2993, 3114, 0);
                TeleportHandler.teleportPlayer(player, ipotane, TeleportType.NORMAL);
                break;

            case 142279:// Vindicta
                if (player.getPointsHandler().getGROUDONKILLCount() <= 24999) {
                    player.getPacketSender().sendMessage("You need 25,000 Ipotane kills. You currently have @red@"
                            + player.getPointsHandler().getGROUDONKILLCount() + "@bla@ kills.");
                    return;
                }
                Position fenrir = new Position(2893, 5469, 0);
                TeleportHandler.teleportPlayer(player, fenrir, TeleportType.NORMAL);
                break;
            case -23477:
                player.getPacketSender().sendEnterAmountPrompt("How much would you like to contribute?");
                player.setInputHandling(new ServerPerkContributionInput());
                break;
       /*     case 19137:
                DiscordIntegration.buttonClick(player);
                break;
            case 19125:
                player.getPacketSender().sendString(1, GameSettings.DiscordUrl);
                player.getPacketSender().sendMessage("Attempting to open our Discord Server");
                break;
            case 19122:
                if (player.getDiscordUser() <= 0) {
                    player.setInputHandling(new DiscordIntegrationPrompt());
                    player.getPA().sendEnterInputPrompt("Please enter the unique code you received on discord.");
                } else {
                    player.setDiscordTag(null);
                    player.setDiscordUser(-1);
                    player.sendMessage("You have successfully diconnected your discord account!");
                    DiscordIntegration.updateDiscordInterface(player);
                    if (DiscordIntegration.connectedAccounts.containsKey(player.getUsername()))
                        DiscordIntegration.connectedAccounts.remove(player.getUsername());
                }
                break;

            case 111613:
                player.getPA().sendInterface(19130);
                DiscordIntegration.updateDiscordInterface(player);
                break;*/
            case -32235:
            case -32285:
                player.setIncludeDR(!player.isIncludeDR());
                player.getPacketSender().sendConfig(2451, player.isIncludeDR() ? 1 : 0);
                player.sendMessage("Include Drop rate: " + (player.isIncludeDR() ? "Enabled" : "Disabled"));
                player.getPacketSender().sendString(33300, "Include DR Bonus @or1@(@whi@"+ CustomDropUtils.drBonus(player, player.getSlayer().getSlayerTask().getNpcId())+"%@or1@)");
                player.getPacketSender().sendString(33250, "Include DR Bonus @or1@(@whi@"+ CustomDropUtils.drBonus(player, player.getSlayer().getSlayerTask().getNpcId())+"%@or1@)");
                if (player.getDropInterfaceNPC() > 0)
                    DropsInterface.buildRightSide(player, player.getDropInterfaceNPC());
                break;
            case 142280:// Beast
                if (player.getPointsHandler().getFENRIRKILLCount() <= 49999) {
                    player.getPacketSender().sendMessage("You need 50,000 Vindicta kills. You currently have @red@"
                            + player.getPointsHandler().getFENRIRKILLCount() + "@bla@ kills.");
                    return;
                }
                Position bork = GameSettings.CYAN;
                TeleportHandler.teleportPlayer(player, bork, TeleportType.NORMAL);
                break;

            case -3306:
            case 30905:
                player.getPacketSender().sendInterfaceRemoval();
                break;

            case 12162:
                DialogueManager.start(player, 212);
                player.setDialogueActionId(100000);
                // TeleportHandler.teleportPlayer(player, new Position(3674, 2966),
                // TeleportType.NORMAL);
                // player.getPacketSender().sendMessage("Get a task from a Slayer Master here.
                // (Slayer tower is now in Dungeon teleports)");
                break;
            case 1036:
                EnergyHandler.rest(player);
                break;
            case -26376:
                PlayersOnlineInterface.showInterface(player);
                break;
            case -26386:
                player.getPacketSender().sendTabInterface(GameSettings.STAFF_TAB, 46343);
                StaffList.updateInterface(player);
                break;
            case 30362:
                player.setInputHandling(new SearchForCollectionNpc());
                player.getPacketSender().sendEnterInputPrompt("Type the NPC name that you would like to search for");
                break;
            case 26250://invite player
                if(player.getMinigameAttributes().getDungeoneeringAttributes().getParty() != null) {
                    if (!player.getMinigameAttributes().getDungeoneeringAttributes().getParty().getOwner().equals(player)) {
                        player.getPacketSender().sendMessage("Only the party leader can invite other players.");
                    } else {
                        player.setInputHandling(new InviteDungeoneeringPlayer());
                        player.getPacketSender().sendEnterInputPrompt("Invite Player");
                    }
                }

                break;
            case 27229://form party
                if(player.getMinigameAttributes().getDungeoneeringAttributes().getParty() == null) {
                    DungeoneeringParty.create(player);
                }
                break;
            case 26226://Exit TODO
                if (Dungeoneering.doingOldDungeoneering(player)) {
                    DialogueManager.start(player, 114);
                    player.setDialogueActionId(71);
                }
                break;
            case 26229://leave
                com.ruse.world.content.minigames.impl.dungeoneering.Dungeoneering.Companion.leaveParty(player);
                player.getPacketSender().sendDungeoneeringTabIcon(true).sendTabInterface(GameSettings.QUESTS_TAB, 27224).sendTab(GameSettings.QUESTS_TAB);
                break;
            case 26244:
            case 26247://floors
                /*
                if (player.getMinigameAttributes().getDungeoneeringAttributes().getParty() != null) {
                    if (player.getMinigameAttributes().getDungeoneeringAttributes().getParty().getOwner().getUsername()
                            .equals(player.getUsername())) {
                        DialogueManager.start(player, id == 26247 ? 106 : 105);
                        player.setDialogueActionId(id == 26247 ? 68 : 67);
                    } else {
                        player.getPacketSender().sendMessage("Only the party owner can change this setting.");
                    }
                }*/
                break;
            case 28180:
                TeleportHandler.teleportPlayer(player, new Position(2815, 5511), player.getSpellbook().getTeleportType());
                break;
            case 14176:
                player.setUntradeableDropItem(null);
                player.getPacketSender().sendInterfaceRemoval();
                break;

            /**
             * Player panel tab buttons
             */

            case 23835:
            case 23836:
            case 23837:
            case 23838:
                PlayerPanel.refreshPanel(player);
                break;

            case 14175:
                player.getPacketSender().sendInterfaceRemoval();
                if (player.getUntradeableDropItem() != null
                        && player.getInventory().contains(player.getUntradeableDropItem().getId())) {
                    ItemBinding.unbindItem(player, player.getUntradeableDropItem().getId());
                    player.getInventory().delete(player.getUntradeableDropItem());
                    PlayerLogs.log(player.getUsername(),
                            "Player destroying item: " + player.getUntradeableDropItem().getId() + ", amount: "
                                    + player.getUntradeableDropItem().getAmount());
                    player.getPacketSender().sendMessage("Your item vanishes as it hits the floor.");
                    Sounds.sendSound(player, Sound.DROP_ITEM);
                }
                player.setUntradeableDropItem(null);
                break;
            case 1013:
                player.getSkillManager().setTotalGainedExp(0);
                break;
            case -26373:
                if (WellOfGoodwill.isActive()) {
                    player.getPacketSender().sendMessage(
                            "<img=5> <col=008FB2>The Well of Goodwill is granting 30% bonus experience for another "
                                    + WellOfGoodwill.getMinutesRemaining() + " minutes.");
                } else {
                    player.getPacketSender()
                            .sendMessage("<img=5> <col=008FB2>The Well of Goodwill needs another "
                                    + Misc.insertCommasToNumber("" + WellOfGoodwill.getMissingAmount())
                                    + " coins before becoming full.");
                }
                break;
            case -26349:
                KillsTracker.open(player);
                break;
            case -26348:
                DropLog.open(player);
                break;
            case -10531:
                if (player.isKillsTrackerOpen()) {
                    player.setKillsTrackerOpen(false);
                    player.getPacketSender().sendTabInterface(GameSettings.QUESTS_TAB, 111000);
                    PlayerPanel.refreshPanel(player);
                }
                break;
            case 11213:
                player.getPacketSender().sendString(1, GameSettings.DomainUrl);
                player.getPacketSender().sendMessage("Attempting to open the homepage");
                break;
            case 11217:
                player.getPacketSender().sendString(1, GameSettings.DiscordUrl);
                player.getPacketSender().sendMessage("Attempting to open the Discord");
                break;
            case -26337:
            case 11216:
                player.getPacketSender().sendString(1, GameSettings.StoreUrl);
                player.getPacketSender().sendMessage("Attempting to open the Store");
                break;
            case -26338:
                player.getPacketSender().sendString(1, GameSettings.RuleUrl);
                player.getPacketSender().sendMessage("Attempting to open the rules");
                break;
            case -26339:
            case 11214:
                player.getPacketSender().sendString(1, GameSettings.ForumUrl);
                player.getPacketSender().sendMessage("Attempting to open the forums");
                break;
            case -26336:
            case 11215:
                player.getPacketSender().sendString(1, GameSettings.VoteUrl);
                player.getPacketSender().sendMessage("Attempting to open the Vote page");
                break;
            case -26335:
                player.getPacketSender().sendString(1, GameSettings.HiscoreUrl);
                player.getPacketSender().sendMessage("Attempting to open the Hiscore page");
                break;
            case -26334:
                player.getPacketSender().sendString(1, GameSettings.ReportUrl);
                player.getPacketSender().sendMessage("Attempting to open the report page");
                break;
            case 350:
                player.getPacketSender()
                        .sendMessage("To autocast a spell, please right-click it and choose the autocast option.")
                        .sendTab(GameSettings.MAGIC_TAB).sendConfig(108, player.getAutocastSpell() == null ? 3 : 1);
                break;
            case 29335:
                if (player.getInterfaceId() > 0) {
                    player.getPacketSender()
                            .sendMessage("Please close the interface you have open before opening another one.");
                    return;
                }
                DialogueManager.start(player, 60);
                player.setDialogueActionId(27);
                break;
            case 29455:
                if (player.getInterfaceId() > 0) {
                    player.getPacketSender()
                            .sendMessage("Please close the interface you have open before opening another one.");
                    return;
                }
                ClanChatManager.toggleLootShare(player);
                break;
            /*case 29456:
                if (player.getInterfaceId() > 0) {
                    player.getPacketSender()
                            .sendMessage("Please close the interface you have open before opening another one.");
                    return;
                }
                player.getPacketSender().sendInterfaceRemoval();
                PlayersOnlineInterface.showInterface(player);
                // player.getPacketSender().sendMessage("<shad=1>@or1@There are currently @whi@[ @gre@" + (17 + World.getPlayers().size()) + "@whi@ ] @or1@players online!");
                break;*/
            case 11001:
                TeleportHandler.teleportPlayer(player, GameSettings.DEFAULT_POSITION.copy(),
                        player.getSpellbook().getTeleportType());
                player.getPacketSender().sendInterfaceRemoval();
                //player.setDialogueActionId(217);
                //DialogueManager.start(player, 217);

                break;
            case 28211:
                TeleportHandler.teleportPlayer(player, GameSettings.DEFAULT_POSITION.copy(),
                        player.getSpellbook().getTeleportType());
                break;
            case 1159: // Bones to Bananas
            case 15877:// Bones to peaches
            case 30306:
                MagicSpells.handleMagicSpells(player, id);
                break;
            case 10001:
                if (player.getInterfaceId() == -1) {
                    Consumables.handleHealAction(player);
                } else {
                    player.getPacketSender().sendMessage("You cannot heal yourself right now.");
                }
                break;
            case 18025:
                if (PrayerHandler.isActivated(player, PrayerHandler.AUGURY)) {
                    PrayerHandler.deactivatePrayer(player, PrayerHandler.AUGURY);
                } else {
                    PrayerHandler.activatePrayer(player, PrayerHandler.AUGURY);
                }
                break;

            case 18018:
                if (PrayerHandler.isActivated(player, PrayerHandler.RIGOUR)) {
                    PrayerHandler.deactivatePrayer(player, PrayerHandler.RIGOUR);
                } else {
                    PrayerHandler.activatePrayer(player, PrayerHandler.RIGOUR);
                }
                break;
            case 10000:
            case 950:
                if (player.getInterfaceId() < 0)
                    player.getPacketSender().sendInterface(40030);
                else
                    player.getPacketSender().sendMessage("Please close the interface you have open before doing this.");
                break;
            case 3546:
            case 3420:
                if (System.currentTimeMillis() - player.getTrading().lastAction <= 300)
                    return;
                player.getTrading().lastAction = System.currentTimeMillis();
                if (player.getTrading().inTrade()) {
                    player.getTrading().acceptTrade(id == 3546 ? 2 : 1);
                } else {
                    player.getPacketSender().sendInterfaceRemoval();
                }
                break;
            case 10162:
            case -18269:
                player.getPacketSender().sendInterfaceRemoval();
                break;
            case 841:
                ingredientsBook.readBook(player, player.getCurrentBookPage() + 2, true);
                break;
            case 839:
                ingredientsBook.readBook(player, player.getCurrentBookPage() - 2, true);
                break;
            case 14922:
                player.getPacketSender().sendClientRightClickRemoval().sendInterfaceRemoval();
                break;
            case 14921:
                player.getPacketSender().sendMessage("Please visit the forums and ask for help in the support section.");
                break;
            case 5294:
                player.getPacketSender().sendClientRightClickRemoval().sendInterfaceRemoval();
                player.setDialogueActionId(player.getBankPinAttributes().hasBankPin() ? 8 : 7);
                DialogueManager.start(player,
                        DialogueManager.getDialogues().get(player.getBankPinAttributes().hasBankPin() ? 12 : 9));
                break;
            case 15002:

                if (!player.busy() && !player.getCombatBuilder().isBeingAttacked()
                        && !Dungeoneering.doingOldDungeoneering(player)) {
                    player.getSkillManager().stopSkilling();
                    player.getPriceChecker().open();
                } else {
                    player.getPacketSender().sendMessage("You cannot open this right now.");
                }
                break;
            case 2735:
            case 1511:
                if (player.getSummoning().getBeastOfBurden() != null) {
                    player.getSummoning().toInventory();
                    player.getPacketSender().sendInterfaceRemoval();
                } else {
                    player.getPacketSender().sendMessage("You do not have a familiar who can hold items.");
                }
                break;
            case -11501:

            case -11498:
            case -11507:
            case 1020:
            case 1021:
            case 1019:
            case 1018:
                if (id == 1020)
                    SummoningTab.renewFamiliar(player);
                else if (id == 1019 || id == -11507)
                    SummoningTab.callFollower(player);
                else if (id == 1021 || id == -11504)
                    SummoningTab.handleDismiss(player, true);
                //else if (id == -11507) // TODO swagyolo
               //     player.getSummoning().store();
                else if (id == 1018)
                    player.getSummoning().toInventory();
                break;
            case 1042:
                if (!player.busy() && !player.getCombatBuilder().isBeingAttacked()
                    && !Dungeoneering.doingOldDungeoneering(player)) {
                player.getSkillManager().stopSkilling();
                player.getPacketSender().sendInterface(57350);
            } else {
                player.getPacketSender().sendMessage("You cannot open this right now.");
            }
                break;

             case 1037:
                SummoningTab.callFollower(player);
                break;
            case 1038:
                SummoningTab.renewFamiliar(player);
                break;
            case 1039:
                SummoningTab.handleDismiss(player, false);
                break;
            case 1040:
                player.getSummoning().toInventory();
                break;
            case 1041:
                player.getSummoning().store();
                break;
            case 1095:
                player.setExperienceLocked(!player.experienceLocked());
                if (player.experienceLocked()) {
                    player.getPacketSender().sendMessage("Your EXP is now locked, revert this lock to get EXP again.");
                } else {
                    player.getPacketSender().sendMessage("Your EXP is unlocked, and you will gain EXP as normal.");
                }
                break;
            /*
             * player.setDialogueActionId(0); DialogueManager.start(player, 0);
             */

            /*
             * case 11008: player.setDialogueActionId(0); DialogueManager.start(player, 0);
             * break; case 11017: DialogueManager.start(player, 34);
             * player.setDialogueActionId(15); break; case 11011:
             * DialogueManager.start(player, 22); player.setDialogueActionId(14); break;
             * case 11020: DialogueManager.start(player, 21);
             * player.setDialogueActionId(12); break; case 11014:
             * player.setDialogueActionId(36); DialogueManager.start(player, 136); break;
             */
            case 2799:
            case 2798:
            case 1747:
            case 1748:
            case 8890:
            case 8886:
            case 8875:
            case 8871:
            case 8894:
                ChatboxInterfaceSkillAction.handleChatboxInterfaceButtons(player, id);
                break;
            case 14873:
            case 14874:
            case 14875:
            case 14876:
            case 14877:
            case 14878:
            case 14879:
            case 14880:
            case 14881:
            case 14882:
                BankPin.clickedButton(player, id);
                break;

            case 27005:
            case 22012:
                if (!player.isBanking() || player.getInterfaceId() != 5292)
                    return;
                Bank.depositItems(player, id == 27005 ? player.getEquipment() : player.getInventory(), false);
                break;
            case 27023:
                if (!player.isBanking() || player.getInterfaceId() != 5292)
                    return;
                if (player.getSummoning().getBeastOfBurden() == null) {
                    player.getPacketSender().sendMessage("You do not have a familiar which can hold items.");
                    return;
                }
                Bank.depositItems(player, player.getSummoning().getBeastOfBurden(), false);
                break;
            case 22008:
                if (!player.isBanking() ||( player.getInterfaceId() != 106000 && player.getInterfaceId() != 5292))
                    return;
                player.setNoteWithdrawal(!player.withdrawAsNote());
                break;

            case 21000:
                if (!player.isBanking() || (player.getInterfaceId() != 106000 && player.getInterfaceId() != 5292))
                    return;
                player.setSwapMode(!player.swapMode());
                player.getPacketSender().sendConfig(304, player.swapMode() ? 1 : 0);
                break;
            case 27009:
                player.sendMessage("This option has been disabled");
                break;

            case 144006:
                if (player.getLocation () == Location.DARKNESS_LOBBY) {
                    player.getShadowRaidsParty ().setDifficulty (RaidDifficulty.EASY);
                    openStartScreen(player);
                } else if (player.getLocation () == Location.TELOS_LOBBY) {
                    player.getTelosRaidsParty ().setDifficulty(RaidDifficulty.EASY1);
                    openInterface(player);
                }
                break;
            case 144008:
                if (player.getLocation () == Location.DARKNESS_LOBBY) {
                    player.getShadowRaidsParty().setDifficulty(RaidDifficulty.INTERMEDIATE);
                    openStartScreen(player);
                } else  if (player.getLocation () == Location.TELOS_LOBBY) {
                    player.getTelosRaidsParty ().setDifficulty(RaidDifficulty.INTERMEDIATE1);
                    openInterface(player);
                }
                break;
            case 144010:
                if (player.getLocation () == Location.DARKNESS_LOBBY) {
                    player.getShadowRaidsParty().setDifficulty(RaidDifficulty.ADVANCED);
                    openStartScreen(player);
                } else if (player.getLocation () == Location.TELOS_LOBBY) {
                    player.getTelosRaidsParty ().setDifficulty(RaidDifficulty.ADVANCED1);
                    openInterface(player);
                }
                break;
            case 144019:
                if (player.getLocation() == Location.DARKNESS_LOBBY)
                    NecromancerRaid.start(player.getShadowRaidsParty ());
                    else if (player.getLocation () == Location.TELOS_LOBBY)
                    TelosRaid.start (player.getTelosRaidsParty());
                break;

            case 144506:
                if (player.getLocation () == Location.DARKNESS_LOBBY) {
                    openCoffer (player);
                } else if (player.getLocation () == Location.TELOS_LOBBY) {
                    openCofferRewards(player);
                }
                break;
            case 144108:
            case 144510:
                if (player.getLocation () == Location.DARKNESS_LOBBY) {
                    openRewards (player, NecromancerLoot.EASY);
                    player.getPacketSender ().sendConfig (4512, 0);
                } else if (player.getLocation () == Location.TELOS_LOBBY) {
                    viewRewards (player, TelosLoot.EASY);
                    player.getPacketSender ().sendConfig (4512, 0);
                }
                break;
            case 144512:
                if (player.getLocation () == Location.DARKNESS_LOBBY) {
                    openRewards (player, NecromancerLoot.MEDIUM);
                    player.getPacketSender ().sendConfig (4512, 1);
                } else if (player.getLocation () == Location.TELOS_LOBBY) {
                    viewRewards (player, TelosLoot.MEDIUM);
                    player.getPacketSender ().sendConfig (4512, 1);
                }
                break;
            case 144514:
                if (player.getLocation () == Location.DARKNESS_LOBBY) {
                    openRewards (player, NecromancerLoot.HARD);
                    player.getPacketSender ().sendConfig (4512, 2);
                } else if (player.getLocation () == Location.TELOS_LOBBY) {
                    viewRewards (player, TelosLoot.HARD);
                player.getPacketSender ().sendConfig (4512, 2);
            }
                break;
            case 144110:
                if (player.getLocation () == Location.DARKNESS_LOBBY)
                takeCoffer(player);
                else if (player.getLocation () == Location.TELOS_LOBBY)
                    takeCofferRewards(player);
                break;
            case 144111:
                if (player.getLocation () == Location.DARKNESS_LOBBY)
                bankCoffer(player);
                else if (player.getLocation () == Location.TELOS_LOBBY)
                    bankCofferRewards(player);
                    break;
            case 27014:
            case 27015:
            case 27016:
            case 27017:
            case 27018:
            case 27019:
            case 27020:
            case 27021:
            case 27022:
                if (!player.isBanking())
                    return;
                if (player.getBankSearchingAttribtues().isSearchingBank())
                    BankSearchAttributes.stopSearch(player, true);
                int bankId = id - 27014;
                boolean empty = bankId > 0 && Bank.isEmpty(player.getBank(bankId));
                if (!empty || bankId == 0) {
                    player.setCurrentBankTab(bankId);
                    player.getPacketSender().sendString(5385, "scrollreset");
                    player.getPacketSender().sendString(27002, Integer.toString(player.getCurrentBankTab()));
                    player.getPacketSender().sendString(27000, "1");
                    player.getBank(bankId).open();
                } else
                    player.getPacketSender().sendMessage("To create a new tab, please drag an item here.");
                break;
            case 22004:
                if (!player.isBanking())
                    return;
                if (!player.getBankSearchingAttribtues().isSearchingBank()) {
                    player.getBankSearchingAttribtues().setSearchingBank(true);
                    player.setInputHandling(new EnterSyntaxToBankSearchFor());
                    player.getPacketSender().sendEnterInputPrompt("What would you like to search for?");
                } else {
                    BankSearchAttributes.stopSearch(player, true);
                }
                break;
            case 22845:
            case 24115:
            case 24010:
            case 24041:
            case 150:
                player.setAutoRetaliate(!player.isAutoRetaliate());
                break;
            case 29332:
                ClanChat clan = player.getCurrentClanChat();
                if (clan == null) {
                    player.getPacketSender().sendMessage("You are not in a clanchat channel.");
                    return;
                }
                ClanChatManager.leave(player, false, true);
                player.setClanChatName(null);
                break;
            case 29329:
                if (player.getInterfaceId() > 0) {
                    player.getPacketSender()
                            .sendMessage("Please close the interface you have open before opening another one.");
                    return;
                }
                player.setInputHandling(new EnterClanChatToJoin());
                player.getPacketSender().sendEnterInputPrompt("Enter the name of the clanchat channel you wish to join:");
                break;
            case 19158:
            case 152:
                if (player.getRunEnergy() <= 1) {
                    player.getPacketSender().sendMessage("You do not have enough energy to do this.");
                    player.setRunning(false);
                } else
                    player.setRunning(!player.isRunning());
                player.getPacketSender().sendRunStatus();
                break;
            case 15004:
                player.setCosmeticOveride(!player.isCosmeticOveride());
                player.sendMessage("Showing Cosmetic overrides: " + player.isCosmeticOveride());
                player.getUpdateFlag().flag(Flag.APPEARANCE);
                break;
            case 27651:
            case 15001:
                if (player.getInterfaceId() == -1) {
                    player.getSkillManager().stopSkilling();
                    BonusManager.update(player);
                    player.getPacketSender().sendInterface(21172);
                } else
                    player.getPacketSender().sendMessage("Please close the interface you have open before doing this.");
                break;
            case 15003:
                if (player.getInterfaceId() > 0) {
                    player.getPacketSender()
                            .sendMessage("Please close the interface you have open before opening another one.");
                    return;
                }
                player.getSkillManager().stopSkilling();
                ItemsKeptOnDeath.sendInterface(player);
                break;
            case 2458: // Logout
                if (player.logout()) {
                    World.removePlayer(player);
                }
                break;

            case 30832:
                player.getCustomCombiner().combine();
                break;

            // case 10003:
            case 29138:
            case 29038:
            case 29063:
            case 29113:
            case 29163:
            case 29188:
            case 29213:
            case 29238:
            case 30007:
            case 48023:
            case 33033:
            case 30108:
            case 7473:
            case 7562:
            case 7487:
            case 7788:
            case 8481:
            case 7612:
            case 7587:
            case 7662:
            case 7462:
            case 7548:
            case 7687:
            case 7537:
            case 12322:
            case 7637:
            case 12311:
                CombatSpecial.activate(player);
                break;
            case 1772: // shortbow & longbow & blowpipe & crossbow
                if (player.getWeapon() == WeaponInterface.SHORTBOW) {
                    player.setFightType(FightType.SHORTBOW_ACCURATE);
                } else if (player.getWeapon() == WeaponInterface.LONGBOW) {
                    player.setFightType(FightType.LONGBOW_ACCURATE);
                } else if (player.getWeapon() == WeaponInterface.CROSSBOW) {
                    player.setFightType(FightType.CROSSBOW_ACCURATE);
                } else if (player.getWeapon() == WeaponInterface.BLOWPIPE) {
                    player.setFightType(FightType.BLOWPIPE_ACCURATE);
                } else if (player.getWeapon() == WeaponInterface.BSOAT) {
                    player.setFightType(FightType.BSOAT_ACCURATE);
                } else if (player.getWeapon() == WeaponInterface.SNOW) {
                    player.setFightType(FightType.SNOW_ACCURATE);
                } else if (player.getWeapon() == WeaponInterface.ARMADYLXBOW) {
                    player.setFightType(FightType.ARMADYLXBOW_ACCURATE);
                }
                break;
            case -11504:
                SummoningTab.handleDismiss(player, true);
                break;
            case 1771:
                if (player.getWeapon() == WeaponInterface.SHORTBOW) {
                    player.setFightType(FightType.SHORTBOW_RAPID);
                } else if (player.getWeapon() == WeaponInterface.LONGBOW) {
                    player.setFightType(FightType.LONGBOW_RAPID);
                } else if (player.getWeapon() == WeaponInterface.CROSSBOW) {
                    player.setFightType(FightType.CROSSBOW_RAPID);
                } else if (player.getWeapon() == WeaponInterface.BLOWPIPE) {
                    player.setFightType(FightType.BLOWPIPE_RAPID);
                } else if (player.getWeapon() == WeaponInterface.BSOAT) {
                    player.setFightType(FightType.BSOAT_RAPID);
                } else if (player.getWeapon() == WeaponInterface.SNOW) {
                    player.setFightType(FightType.SNOW_RAPID);
                } else if (player.getWeapon() == WeaponInterface.ARMADYLXBOW) {
                    player.setFightType(FightType.ARMADYLXBOW_RAPID);
                }
                break;
            case 1770:
                if (player.getWeapon() == WeaponInterface.SHORTBOW) {
                    player.setFightType(FightType.SHORTBOW_LONGRANGE);
                } else if (player.getWeapon() == WeaponInterface.LONGBOW) {
                    player.setFightType(FightType.LONGBOW_LONGRANGE);
                } else if (player.getWeapon() == WeaponInterface.CROSSBOW) {
                    player.setFightType(FightType.CROSSBOW_LONGRANGE);
                } else if (player.getWeapon() == WeaponInterface.BLOWPIPE) {
                    player.setFightType(FightType.BLOWPIPE_LONGRANGE);
                } else if (player.getWeapon() == WeaponInterface.BSOAT) {
                    player.setFightType(FightType.BSOAT_LONGRANGE);
                } else if (player.getWeapon() == WeaponInterface.SNOW) {
                    player.setFightType(FightType.SNOW_LONGRANGE);
                } else if (player.getWeapon() == WeaponInterface.ARMADYLXBOW) {
                    player.setFightType(FightType.ARMADYLXBOW_LONGRANGE);
                }
                break;
            case 2282: // dagger & sword
                if (player.getWeapon() == WeaponInterface.DAGGER) {
                    player.setFightType(FightType.DAGGER_STAB);
                } else if (player.getWeapon() == WeaponInterface.SWORD) {
                    player.setFightType(FightType.SWORD_STAB);
                }
                break;
            case 2285:
                if (player.getWeapon() == WeaponInterface.DAGGER) {
                    player.setFightType(FightType.DAGGER_LUNGE);
                } else if (player.getWeapon() == WeaponInterface.SWORD) {
                    player.setFightType(FightType.SWORD_LUNGE);
                }
                break;
            case 2284:
                if (player.getWeapon() == WeaponInterface.DAGGER) {
                    player.setFightType(FightType.DAGGER_SLASH);
                } else if (player.getWeapon() == WeaponInterface.SWORD) {
                    player.setFightType(FightType.SWORD_SLASH);
                }
                break;
            case 2283:
                if (player.getWeapon() == WeaponInterface.DAGGER) {
                    player.setFightType(FightType.DAGGER_BLOCK);
                } else if (player.getWeapon() == WeaponInterface.SWORD) {
                    player.setFightType(FightType.SWORD_BLOCK);
                }
                break;
            case 2429: // scimitar & longsword
                if (player.getWeapon() == WeaponInterface.SCIMITAR) {
                    player.setFightType(FightType.SCIMITAR_CHOP);
                } else if (player.getWeapon() == WeaponInterface.LONGSWORD) {
                    player.setFightType(FightType.LONGSWORD_CHOP);
                }
                break;
            case 2432:
                if (player.getWeapon() == WeaponInterface.SCIMITAR) {
                    player.setFightType(FightType.SCIMITAR_SLASH);
                } else if (player.getWeapon() == WeaponInterface.LONGSWORD) {
                    player.setFightType(FightType.LONGSWORD_SLASH);
                }
                break;
            case 2431:
                if (player.getWeapon() == WeaponInterface.SCIMITAR) {
                    player.setFightType(FightType.SCIMITAR_LUNGE);
                } else if (player.getWeapon() == WeaponInterface.LONGSWORD) {
                    player.setFightType(FightType.LONGSWORD_LUNGE);
                }
                break;
            case 2430:
                if (player.getWeapon() == WeaponInterface.SCIMITAR) {
                    player.setFightType(FightType.SCIMITAR_BLOCK);
                } else if (player.getWeapon() == WeaponInterface.LONGSWORD) {
                    player.setFightType(FightType.LONGSWORD_BLOCK);
                }
                break;
            case 3802: // mace
                player.setFightType(FightType.MACE_POUND);
                break;
            case 3805:
                player.setFightType(FightType.MACE_PUMMEL);
                break;
            case 3804:
                player.setFightType(FightType.MACE_SPIKE);
                break;
            case 3803:
                player.setFightType(FightType.MACE_BLOCK);
                break;
            case 4454: // knife, thrownaxe, dart & javelin
                if (player.getWeapon() == WeaponInterface.KNIFE) {
                    player.setFightType(FightType.KNIFE_ACCURATE);
                } else if (player.getWeapon() == WeaponInterface.THROWNAXE) {
                    player.setFightType(FightType.THROWNAXE_ACCURATE);
                } else if (player.getWeapon() == WeaponInterface.DART) {
                    player.setFightType(FightType.DART_ACCURATE);
                } else if (player.getWeapon() == WeaponInterface.JAVELIN) {
                    player.setFightType(FightType.JAVELIN_ACCURATE);
                }
                break;
            case 4453:
                if (player.getWeapon() == WeaponInterface.KNIFE) {
                    player.setFightType(FightType.KNIFE_RAPID);
                } else if (player.getWeapon() == WeaponInterface.THROWNAXE) {
                    player.setFightType(FightType.THROWNAXE_RAPID);
                } else if (player.getWeapon() == WeaponInterface.DART) {
                    player.setFightType(FightType.DART_RAPID);
                } else if (player.getWeapon() == WeaponInterface.JAVELIN) {
                    player.setFightType(FightType.JAVELIN_RAPID);
                }
                break;
            case 4452:
                if (player.getWeapon() == WeaponInterface.KNIFE) {
                    player.setFightType(FightType.KNIFE_LONGRANGE);
                } else if (player.getWeapon() == WeaponInterface.THROWNAXE) {
                    player.setFightType(FightType.THROWNAXE_LONGRANGE);
                } else if (player.getWeapon() == WeaponInterface.DART) {
                    player.setFightType(FightType.DART_LONGRANGE);
                } else if (player.getWeapon() == WeaponInterface.JAVELIN) {
                    player.setFightType(FightType.JAVELIN_LONGRANGE);
                }
                break;
            case 4685: // spear
                player.setFightType(FightType.SPEAR_LUNGE);
                break;
            case 4688:
                player.setFightType(FightType.SPEAR_SWIPE);
                break;
            case 4687:
                player.setFightType(FightType.SPEAR_POUND);
                break;
            case 4686:
                player.setFightType(FightType.SPEAR_BLOCK);
                break;
            case 4711: // 2h sword
                player.setFightType(FightType.TWOHANDEDSWORD_CHOP);
                break;
            case 4714:
                player.setFightType(FightType.TWOHANDEDSWORD_SLASH);
                break;
            case 4713:
                player.setFightType(FightType.TWOHANDEDSWORD_SMASH);
                break;
            case 4712:
                player.setFightType(FightType.TWOHANDEDSWORD_BLOCK);
                break;
            case 5576: // pickaxe
                player.setFightType(FightType.PICKAXE_SPIKE);
                break;
            case 5579:
                player.setFightType(FightType.PICKAXE_IMPALE);
                break;
            case 5578:
                player.setFightType(FightType.PICKAXE_SMASH);
                break;
            case 5577:
                player.setFightType(FightType.PICKAXE_BLOCK);
                break;
            case 7768: // claws
                player.setFightType(FightType.CLAWS_CHOP);
                break;
            case 7771:
                player.setFightType(FightType.CLAWS_SLASH);
                break;
            case 7770:
                player.setFightType(FightType.CLAWS_LUNGE);
                break;
            case 7769:
                player.setFightType(FightType.CLAWS_BLOCK);
                break;
            case 8466: // halberd
                player.setFightType(FightType.HALBERD_JAB);
                break;
            case 8468:
                player.setFightType(FightType.HALBERD_SWIPE);
                break;
            case 8467:
                player.setFightType(FightType.HALBERD_FEND);
                break;
            case 5862: // unarmed
                player.setFightType(FightType.UNARMED_PUNCH);
                break;
            case 5861:
                player.setFightType(FightType.UNARMED_KICK);
                break;
            case 5860:
                player.setFightType(FightType.UNARMED_BLOCK);
                break;
            case 12298: // whip
                player.setFightType(FightType.WHIP_FLICK);
                break;
            case 12297:
                player.setFightType(FightType.WHIP_LASH);
                break;
            case 12296:
                player.setFightType(FightType.WHIP_DEFLECT);
                break;
            case 336: // staff
                player.setFightType(FightType.STAFF_BASH);
                break;
            case 335:
                player.setFightType(FightType.STAFF_POUND);
                break;
            case 334:
                player.setFightType(FightType.STAFF_FOCUS);
                break;
            case 433: // warhammer
                player.setFightType(FightType.WARHAMMER_POUND);
                break;
            case 432:
                player.setFightType(FightType.WARHAMMER_PUMMEL);
                break;
            case 431:
                player.setFightType(FightType.WARHAMMER_BLOCK);
                break;
            case 782: // scythe
                player.setFightType(FightType.SCYTHE_REAP);
                break;
            case 784:
                player.setFightType(FightType.SCYTHE_CHOP);
                break;
            case 785:
                player.setFightType(FightType.SCYTHE_JAB);
                break;
            case 783:
                player.setFightType(FightType.SCYTHE_BLOCK);
                break;
            case 1704: // battle axe
                player.setFightType(FightType.BATTLEAXE_CHOP);
                break;
            case 1707:
                player.setFightType(FightType.BATTLEAXE_HACK);
                break;
            case 1706:
                player.setFightType(FightType.BATTLEAXE_SMASH);
                break;
            case 1705:
                player.setFightType(FightType.BATTLEAXE_BLOCK);
                break;
        }
    }

    private boolean checkHandlers(Player player, int id) {

        if (ServerPerks.getInstance().handleButton(player, id)) {
            return true;
        }

        if (player.getSlayerFavourites().handleButton(id))
            return true;
        if (player.getDailyTaskManager().handleButton(id))
            return true;

        if (player.getHweenEvent().handleButton(id)) {
            return true;
        }
        if (player.getCollectionLog().handleButton(id))
            return true;
        if (BestItemsInterface.buttonClicked(player, id)) {
            return true;
        }
        if (BestDRItemsInterface.buttonClicked(player, id)) {
            return true;
        }
        if (KillTrackerInterface.handleButton(player, id))
            return true;
        if (Construction.handleButtonClick(id, player)) {
            return true;
        }
        switch (id) {
            case 14650:
                player.getPacketSender().removeInterface();
                return true;
            case 2494:
            case 2495:
            case 2496:
            case 2497:
            case 2498:
            case 2471:
            case 2472:
            case 2473:
            case 2461:
            case 2462:
            case 2482:
            case 2483:
            case 2484:
            case 2485:
                DialogueOptions.handle(player, id);
                return true;

            case -8307:
            case -8308:
            case -8309:
            case -8310:
            case -8311:
            case -8312:
                if (DailyRewards.handleRewards(player, id))
                    ;
                return true;

        }

        if (GroupManager.handleButton(player, id)) {
            return true;
        }
        
        if ((player.isPlayerLocked() || player.isGroupIronmanLocked())  && id != 2458 && !(id >= 116005 && id<= 116010)
                && id != -12780 && id != -12779 && id != -12778 && id != -12763 && id != -12760 && id != -12767) {
            return true;
        }
        if (TeleportInterface.handleButton(player, id)) {
            return true;
        }

        if (new RewardsHandler(player).button(id)) {
            return true;
        }
        if (StartScreen.handleButton(player, id)) {
            return true;
        }

        if (DropsInterface.handleButton(id)) {
            DropsInterface.handleButtonClick(player, id);
            return true;
        }
        if (player.isPlayerLocked() && id != 2458) {
            return true;
        }
        if (Sounds.handleButton(player, id)) {
            return true;
        }
        if (PrayerHandler.isButton(id)) {
            PrayerHandler.togglePrayerWithActionButton(player, id);
            return true;
        }
        if (CurseHandler.isButton(player, id)) {
            return true;
        }
        if (Autocasting.handleAutocast(player, id)) {
            return true;
        }
        if (SmithingData.handleButtons(player, id)) {
            return true;
        }
        if (PouchMaking.pouchInterface(player, id)) {
            return true;
        }
        if (LoyaltyProgramme.handleButton(player, id)) {
            return true;
        }
        if (Fletching.fletchingButton(player, id)) {
            return true;
        }
        if (LeatherMaking.handleButton(player, id) || Tanning.handleButton(player, id)) {
            return true;
        }
        if (Emotes.doEmote(player, id)) {
            return true;
        }
        if (PestControl.handleInterface(player, id)) {
            return true;
        }
        if (player.getLocation() == Location.DUEL_ARENA && Dueling.handleDuelingButtons(player, id)) {
            return true;
        }
        if (ExperienceLamps.handleButton(player, id)) {
            return true;
        }
        if (PlayersOnlineInterface.handleButton(player, id)) {
            return true;
        }
        if (GrandExchange.handleButton(player, id)) {
            return true;
        }
        if (ClanChatManager.handleClanChatSetupButton(player, id)) {
            return true;
        }
        if (Guild.handleClanButtons(player, id)) {
            return true;
        }
        if (new BossEventInterfaceHandler(player).button(id)) {
            return true;
        }

        if (LoyaltyStreakManager.handleButtonClick(player, id)) {
            return true;
        }
        if (PollManager.handlePollClick(player, id)) {
            return true;
        }
        return false;
    }
}
