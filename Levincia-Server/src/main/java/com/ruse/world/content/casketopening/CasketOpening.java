package com.ruse.world.content.casketopening;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Item;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.boxes.*;
import com.ruse.world.content.casketopening.impl.*;
import com.ruse.world.content.osrscollectionlog.CollectionLog;
import com.ruse.world.content.raids.shadows.ShadowRewards;
import com.ruse.world.entity.impl.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.ruse.world.content.osrscollectionlog.LogType.*;
import static com.ruse.world.content.raids.shadows.ShadowRewards.getRareRate;

public class CasketOpening {

    private final Player player;
    private final int INTERFACE_ID = 110000;
    private boolean canCasketOpening = true;
    private Box SlotPrize;
    private Caskets currentCasket;
    public CasketOpening(Player player) {
        this.player = player;
    }


    public static Box getLoot(Box[] loot) {
        HashMap<Double, ArrayList<Box>> dropRates = new HashMap<>();
        ArrayList<Box> potentialDrops = new ArrayList<>();

        for (Box drop : loot) {
            if (drop == null)
                continue;
            double divisor = drop.getRate();
            if (!dropRates.containsKey(divisor)) {
                ArrayList<Box> items = new ArrayList<>();
                items.add(drop);
                dropRates.put(divisor, items);
            } else {
                dropRates.get(divisor).add(drop);
            }
        }
        for (double dropRate : dropRates.keySet()) {
            double rate = dropRate * 1000;
            if (Misc.getRandom(100000) <= rate) {
                potentialDrops.add(dropRates.get(dropRate).get(Misc.getRandom(dropRates.get(dropRate).size() - 1)));
            }
        }

        if (potentialDrops.size() > 0) {
            return potentialDrops.get(Misc.getRandom((potentialDrops.size() - 1)));
        } else {
            return loot[Misc.getRandom(1)];
        }
    }

    public static Box getLoot1(Box[] loot) {
        HashMap<Double, ArrayList<Box>> dropRates = new HashMap<>();
        ArrayList<Box> potentialDrops = new ArrayList<>();

        for (Box drop : loot) {
            if (drop == null)
                continue;
            double divisor = drop.getRate();
            if (!dropRates.containsKey(divisor)) {
                ArrayList<Box> items = new ArrayList<>();
                items.add(drop);
                dropRates.put(divisor, items);
            } else {
                dropRates.get(divisor).add(drop);
            }
        }
        for (double dropRate : dropRates.keySet()) {
            double rate = dropRate * 1000;
            if (Misc.getRandom(100000) <= rate) {
                potentialDrops.add(dropRates.get(dropRate).get(Misc.getRandom(dropRates.get(dropRate).size() - 1)));
            }
        }

        if (potentialDrops.size() > 0) {
            return potentialDrops.get(Misc.getRandom((potentialDrops.size() - 1)));
        } else {
            return loot[Misc.getRandom(loot.length - 1)];
        }
    }

    public boolean hasItems() {
        if (!player.getInventory().contains(getCurrentCasket().getItemID())) {
            player.sendMessage("You need a " + ItemDefinition.forId(getCurrentCasket().getItemID()).getName() + " to do this.");
            return false;
        }
        return true;
    }

    public boolean removeItems() {
        if (getCurrentCasket() == Caskets.ETHEREAL_CASE || getCurrentCasket() == Caskets.SERAPHIC_CASE|| getCurrentCasket() == Caskets.MONEY_CASE) {
            player.getInventory().delete(4186, 1);
        }
        if (player.getInventory().getAmount(getCurrentCasket().getItemID()) >= 1) {
            player.getInventory().delete(getCurrentCasket().getItemID(), 1);
            if (player.getInventory().contains(23401) && Misc.getRandom(1,10) == 3) {
                player.getInventory().delete(23401, 1);
                player.getInventory().add(getCurrentCasket().getItemID(), 1);
                player.getPacketSender().sendMessage("<img=832>@red@You kept your " + ItemDefinition.forId(getCurrentCasket().getItemID()).getName() +" and a Scroll of Insurance is consumed.");
            }
        }
        return false;
    }

    public boolean removeAllItems() {
        int amount = player.getInventory().getAmount(getCurrentCasket().getItemID());
        if (player.getInventory().getAmount(getCurrentCasket().getItemID()) >= 1) {
            player.getInventory().delete(getCurrentCasket().getItemID(), amount);
            if (player.getInventory().contains(23401) && Misc.getRandom(1,10) == 3) {
                player.getInventory().delete(23401, 1);
                player.getInventory().add(getCurrentCasket().getItemID(), 1);
                player.getPacketSender().sendMessage("<img=832>@red@You kept your " + ItemDefinition.forId(getCurrentCasket().getItemID()).getName() +" and a Scroll of Insurance is consumed.");
            }
        }
        return false;
    }

    public void spin() {
        if (getCurrentCasket() == null) {
            return;
        }
        if (getCurrentCasket() == Caskets.SERAPHIC_CASE && !player.getInventory().contains(4186)) {
            player.getPacketSender().sendMessage("@blu@You need x1 Case key to open this.");
            return;
        }
        if (getCurrentCasket() == Caskets.ETHEREAL_CASE && !player.getInventory().contains(4186)) {
            player.getPacketSender().sendMessage("@blu@You need x1 Case key to open this.");
            return;
        }

        if (getCurrentCasket() == Caskets.MONEY_CASE && !player.getInventory().contains(4186)) {
            player.getPacketSender().sendMessage("@blu@You need x1 Case key to open this.");
            return;
        }
        if (!canCasketOpening) {
            player.sendMessage("Please finish your current spin.");
            return;
        }
        if (hasItems()) {
            if (player.getInventory().getFreeSlots() == 0) {
                player.getPacketSender().sendMessage("You don't have enough free inventory space.");
                return;
            }
            removeItems();
            player.setSpinning(true);
            player.getMovementQueue().setLockMovement(true);
            player.sendMessage(":resetCasket");
            player.sendMessage(":spinCasket");
            process();
        }
    }

    public void quickSpin() {
        if (getCurrentCasket() == null) {
            return;
        }
        if (getCurrentCasket() == Caskets.SERAPHIC_CASE && !player.getInventory().contains(4186)) {
            player.getPacketSender().sendMessage("@blu@You need x1 Case key to open this.");
            return;
        }
        if (getCurrentCasket() == Caskets.ETHEREAL_CASE && !player.getInventory().contains(4186)) {
            player.getPacketSender().sendMessage("@blu@You need x1 Case key to open this.");
            return;
        }

        if (getCurrentCasket() == Caskets.MONEY_CASE && !player.getInventory().contains(4186)) {
            player.getPacketSender().sendMessage("@blu@You need x1 Case key to open this.");
            return;
        }
        if (!canCasketOpening) {
            player.sendMessage("Please finish your current spin.");
            return;
        }
        if (hasItems()) {
            if (player.getInventory().getFreeSlots() == 0) {
                player.getPacketSender().sendMessage("You don't have enough free inventory space.");
                return;
            }
            removeItems();
            player.sendMessage(":resetCasket");
            processQuick();
        }
    }

    public void process() {
        SlotPrize = null;
        canCasketOpening = false;
        Box[] loot =getCurrentCasket().getLoot() ;
        SlotPrize = getLoot1(loot);
        if (SlotPrize.getRate() < 10D && Misc.getRandom(1) == 0){
            SlotPrize = getLoot1(loot);
        }
        if (SlotPrize.getRate() < 10D && Misc.getRandom(2) == 0){
            SlotPrize = getLoot1(loot);
        }

        boolean announce = SlotPrize.isAnnounce();

        for (int i = 0; i < 28; i++) {
            Box NOT_PRIZE = getLoot1(loot);
            if (NOT_PRIZE.getRate() > 10 && Misc.getRandom(2) == 0) {
                NOT_PRIZE = getLoot1(loot);
            }
            sendItem(i, 23, SlotPrize.getId(), SlotPrize.getMax(), NOT_PRIZE.getId(), NOT_PRIZE.getMax(), 110501);
        }
        final boolean announceLoot = announce;
        TaskManager.submit(new Task(7, player, false) {

            @Override
            public void execute() {
                reward(announceLoot);
                player.setSpinning(false);
                player.getMovementQueue().setLockMovement(false);
                stop();
            }
        });
    }
    public void processAll() {
        SlotPrize = null;
        canCasketOpening = false;
        Box[] loot = getCurrentCasket().getLoot() ;
        SlotPrize = getLoot1(loot);
        if (SlotPrize.getRate() < 10D && Misc.getRandom(1) == 0){
            SlotPrize = getLoot1(loot);
        }
        if (SlotPrize.getRate() < 10D && Misc.getRandom(2) == 0){
            SlotPrize = getLoot1(loot);
        }
        boolean announce = SlotPrize.isAnnounce();
        for (int i = 0; i < 7; i++) {
            Box NOT_PRIZE = getLoot1(loot);
            if (NOT_PRIZE.getRate() > 10 && Misc.getRandom(2) == 0) {
                NOT_PRIZE = getLoot1(loot);
            }

            sendItem(i, 3, SlotPrize.getId(), SlotPrize.getAmount(), NOT_PRIZE.getId(), NOT_PRIZE.getAmount(), 110501);
        }
        // player.getBank(0).add(new Item(SlotPrize.getId(), SlotPrize.getMax()), false);
        //   canCasketOpening = true;
        if(getCurrentCasket().getItemID() == 23370){
            player.getPointsHandler().incrementSufferingKC(1);
        }
        reward(announce);
        player.setSpinning(false);
    }

    public void processQuick() {
        SlotPrize = null;
        canCasketOpening = false;
        Box[] loot =getCurrentCasket().getLoot() ;
        SlotPrize = getLoot1(loot);
        if (SlotPrize.getRate() < 10D && Misc.getRandom(1) == 0){
            SlotPrize = getLoot1(loot);
        }
        if (SlotPrize.getRate() < 10D && Misc.getRandom(2) == 0){
            SlotPrize = getLoot1(loot);
        }
        boolean announce = SlotPrize.isAnnounce();
        for (int i = 0; i < 7; i++) {
            Box NOT_PRIZE = getLoot1(loot);
            if (NOT_PRIZE.getRate() > 10 && Misc.getRandom(2) == 0) {
                NOT_PRIZE = getLoot1(loot);
            }

            sendItem(i, 3, SlotPrize.getId(), SlotPrize.getAmount(), NOT_PRIZE.getId(), NOT_PRIZE.getAmount(), 110501);

        }
         // player.getBank(0).add(new Item(SlotPrize.getId(), SlotPrize.getMax()), false);
       //   canCasketOpening = true;
        if(getCurrentCasket().getItemID() == 23370){
        player.getPointsHandler().incrementSufferingKC(1);
        }

        reward(announce);
        player.setSpinning(false);
    }

    public void sendItem(int i, int prizeSlot, int PRIZE_ID, int prizeamount, int NOT_PRIZE, int amount,
                         int ITEM_FRAME) {
        if (i == prizeSlot) {
            player.sendMessage("casketopening##" + ITEM_FRAME + "##" + PRIZE_ID + "##" + prizeamount + "##" + i + "##");
        } else {
            player.sendMessage("casketopening##" + ITEM_FRAME + "##" + NOT_PRIZE + "##" + amount + "##" + i + "##");
        }
    }


    public void reward(boolean announce) {
        if (SlotPrize == null) {
            return;
        }
        MINIGAMES.log(player, CollectionLog.SUFFERING_KEY, new Item(SlotPrize.getId()));
        if (getCurrentCasket() == Caskets.NECROMANCER) {
        }
        BOXES.log(player, getCurrentCasket().getItemID(), new Item(SlotPrize.getId()));

        if (currentCasket == Caskets.SERAPHIC_CASE
                || currentCasket == Caskets.MONEY_CASE
                || currentCasket == Caskets.ETHEREAL_CASE)
            player.getDailyTaskManager().submitProgressToIdentifier(39, 1);

        if (currentCasket == Caskets.SUMMER || currentCasket == Caskets.AUTUMN)
            player.getDailyTaskManager().submitProgressToIdentifier(43, 1);

        if (currentCasket.ordinal() <= 4)
            player.getDailyTaskManager().submitProgressToIdentifier(28, 1);

        player.getDailyTaskManager().submitProgressToIdentifier(5, 1);
        player.getInventory().add(SlotPrize.getId(), SlotPrize.getAmount());
        int amount = SlotPrize.getAmount();
        if (announce) {

            String message = "@red@" + player.getUsername() + " <col=ff812f>has just received @red@"
                    + (amount > 1 ? "x" + amount : "") + " "
                    + ItemDefinition.forId(SlotPrize.getId()).getName() + "<col=ff812f> from a @red@" +
                    ItemDefinition.forId(getCurrentCasket().getItemID()).getName() + "!";
            World.sendNewsMessage(message);
            if (SlotPrize.isAnnounce() && player.getEquipment().contains(23403) && Misc.getRandom(5) == 1 && getCurrentCasket() == Caskets.SOSREWARDS) {
                player.getPacketSender().sendMessage("Your Suffering charm has doubled your rare reward!");
                player.getInventory().add(SlotPrize.getId(), amount);
            }
        }

        canCasketOpening = true;
    }


    public static List<Item> shadowRareRewards = Arrays.asList( // 1/1000
            new Item(23303, 1, 1, 0.02, true), // Mystic helmet
            new Item(23304, 1, 1, 0.02, true), // Mystic body
            new Item(23305, 1, 1, 0.02, true), // Mystic legs
            new Item(23306, 1, 1, 0.02, true), // Mystic legs
            new Item(23307, 1, 1, 0.02, true), // Mystic legs
            new Item(23308, 1, 1, 0.02, true), // Mystic legs
            new Item(23309, 1, 1, 0.02, true), // Mystic legs
            new Item(23310, 1, 1, 0.02, true), // Mystic legs
            new Item(23311, 1, 1, 0.02, true), // Mystic legs
            new Item(14999, 1, 1, 0.02, true), // Onyx casket
            new Item(23276, 1, 1, 0.02, true), // Starter Card pack
            new Item(23403, 1, 1, 0.02, true), // Suffering charm
            new Item(15288, 10, 250, 0.02, true) // Upgrade token packs

    );

    public static List<Item> shadowCommonRewards = Arrays.asList(
            new Item(15288, 1,4,50,false), // x2 100k token pack
            new Item(5022, 10_000, 250_000,50,false), // Pvm tickets
            new Item(7956, 100,7500,50,false), // PvM Box t1
            new Item(19114, 5,75,50,false), // Ruby mystery box
            new Item(20488, 1,10,50,false), // Ruby mystery box
            new Item(11137, 25,75,50,false), // xp lamps
            new Item(20489, 1,1,50,false), // Launch casket
            new Item(15358, 1,1,50,false), // 30min effect scroll
            new Item(15359, 1,1,50,false), // 30min effect scroll
            new Item(15288, 3,10,33,false), // x5 100k token packs
            new Item(10946, 1,1,20,false), // $1 scroll
            new Item(4446, 1,1,20,false), // $1 scroll
            new Item(19886, 1,1,20,false), // $1 scroll
            new Item(8087, 1,1,5,false), // $1 scroll
            new Item(8088, 1,1,5,false), // $1 scroll
            new Item(8089, 1,1,5,false), // $1 scroll
            new Item(22006, 5,50,5,false), // Deathtouch darts
            new Item(15003, 1,1,5,false), // Silver chest
            new Item(6769, 1,1,1,true) // $5 bond
    );

    public void openShadowRewardInterface() {
        player.sendMessage(":resetCasket");
        player.getPA().sendInterface(48130);
        player.getPacketSender().sendString(48144, "Necromancer Chest");
        player.getPacketSender().sendString(48135, "Necromancer Key");
        player.getPacketSender().sendString(48133, "Increase Chances");
        player.getPacketSender().sendItemOnInterface(48145, 23447, 0, 1);
        player.getPacketSender().sendString(48134, "Rare: (1/" + getRareRate(player) + ")");

        for (int i = 0; i < common.size(); i++) {
            player.getPacketSender().sendItemOnInterface(48151, shadowCommonRewards.get(i).getId(),i, shadowCommonRewards.get(i).getMax());
        }

        for (int i = 0; i < rare.size(); i++) {
            player.getPacketSender().sendItemOnInterface(48110, shadowRareRewards.get(i).getId(),i, shadowRareRewards.get(i).getMax());
        }

    }


    public static List<Item> rare = Arrays.asList( // 1/1000
            new Item(23303, 1, 1, 0.02, true), // Mystic helmet
            new Item(23304, 1, 1, 0.02, true), // Mystic body
            new Item(23305, 1, 1, 0.02, true), // Mystic legs
            new Item(23306, 1, 1, 0.02, true), // Mystic legs
            new Item(23307, 1, 1, 0.02, true), // Mystic legs
            new Item(23308, 1, 1, 0.02, true), // Mystic legs
            new Item(23309, 1, 1, 0.02, true), // Mystic legs
            new Item(23310, 1, 1, 0.02, true), // Mystic legs
            new Item(23311, 1, 1, 0.02, true), // Mystic legs
            new Item(14999, 1, 1, 0.02, true), // Onyx casket
            new Item(23276, 1, 1, 0.02, true), // Starter Card pack
            new Item(23403, 1, 1, 0.02, true), // Suffering charm
            new Item(15288, 10, 250, 0.02, true) // Upgrade token packs

    );

    public static List<Item> common = Arrays.asList(
            new Item(15288, 1,2,50,false), // x2 100k token pack
            new Item(5022, 10_000, 100_000,50,false), // Pvm tickets
            new Item(7956, 100,5000,50,false), // PvM Box t1
            new Item(19114, 5,50,50,false), // Ruby mystery box
            new Item(20488, 1,5,50,false), // Ruby mystery box
            new Item(11137, 25,75,50,false), // xp lamps
            new Item(20489, 1,1,50,false), // Launch casket
            new Item(15358, 1,1,50,false), // 30min effect scroll
            new Item(15359, 1,1,50,false), // 30min effect scroll
            new Item(15288, 3,5,33,false), // x5 100k token packs
            new Item(23321, 10,20,20,false), // Soulless crystal
            new Item(10946, 1,1,20,false), // $1 scroll
            new Item(4446, 1,1,20,false), // $1 scroll
            new Item(19886, 1,1,20,false), // $1 scroll
            new Item(8087, 1,1,5,false), // $1 scroll
            new Item(8088, 1,1,5,false), // $1 scroll
            new Item(8089, 1,1,5,false), // $1 scroll
            new Item(22006, 5,25,5,false), // Deathtouch darts
            new Item(15003, 1,1,5,false) // Silver chest
    );

    public void openSOSInterface() {
        player.sendMessage(":resetCasket");
        player.getPA().sendInterface(48130);
        player.getPacketSender().sendString(48144, "Souls of Suffering");
        player.getPacketSender().sendString(48135, "Suffering key");
        player.getPacketSender().sendString(48133, "Earn X2 Rewards");
        player.getPacketSender().sendItemOnInterface(48145, 23370, 0, 1);
            player.getPacketSender().sendString(48134, "Rare (1/500)");

        for (int i = 0; i < common.size(); i++) {
                player.getPacketSender().sendItemOnInterface(48151, common.get(i).getId(),i, common.get(i).getMax());
        }

        for (int i = 0; i < rare.size(); i++) {
                player.getPacketSender().sendItemOnInterface(48110, rare.get(i).getId(),i, rare.get(i).getMax());
        }

    }

        public void openYoutbeRewards() {
        player.getPA().sendInterface(82350);

        for (int i = 0; i < common.size(); i++) {
            player.getPacketSender().sendItemOnInterface(48080, common.get(i).getId(),i, common.get(i).getMax());
        }
    }


    public void openInterface() {
        player.sendMessage(":resetCasket");

        player.getPacketSender().sendItemOnInterface(110009, 13759, 1);
        player.getPacketSender().sendItemOnInterface(110010, 13758, 1);

        Box[] loot = getCurrentCasket().getLoot();

        int length = loot.length;
        if (length >= 160)
            length = 160;
        if (length <= 16)
            length = 16;

        length += 8 - (length % 8);

        for (int i = 0; i < length; i++) {
            if (loot.length > i)
                player.getPacketSender().sendItemOnInterface(110101 + i, loot[i].getId(), loot[i].getMax());
            else
                player.getPacketSender().sendItemOnInterface(110101 + i, -1, 0);
        }

        for (int i = 0; i < length; i++) {
            if (loot.length > i)
                player.getPacketSender().sendString(110261 + i, "1/" + getRate(loot[i].getRate()));
            else
                player.getPacketSender().sendString(110261 + i, "");
        }
        int scroll = 9 + ((loot.length / 8) + 1) * 55;
        if (scroll <= 165)
            scroll = 165;
        player.getPacketSender().setScrollBar(110100, scroll);


        player.getPA().sendInterface(INTERFACE_ID);
    }

    public int getRate(double rate) {
        int result = (int) (100 / rate);
        return result;
    }


    public Caskets getCurrentCasket() {
        return currentCasket;
    }

    public void setCurrentCasket(Caskets currentCasket) {
        this.currentCasket = currentCasket;
    }

    public enum Caskets {

        RARE_BOX(23171, RareBox.loot),
        DEF_BOX(23172, DefBox.loot),
        OFF_BOX(23173, OffBox.loot),
        WEAPON_BOX(19114, WepBox.loot),
        HOV_BOX(23086, HOVBox.loot),
        ELITE(15002, Elite.rewards),
        LEGENDARY(14999, Legendary.rewards),
        AZURE(15003, Azure.rewards),
        EXCLUSIVE(15004, Exclusive.rewards),
        PRESTIGE(23236, PrestigeBox.rewards),
        RAIDS(18404, Raids1.rewards),
        SUPREME(23253, Supreme.rewards),
        SOSREWARDS(23370, SOSRewards.rewards),
        PLATINUM(23447, PlatinumRewards.rewards),
        NECROMANCER(23447, ShadowRewards.rare),
        SUMMER_BOX(23322, SummerBox.rewards),
        SLAYER_U(22123, SlayerU.rewards),
        ETHEREAL_CASE(23412, Ethereal.rewards),
        SERAPHIC_CASE(23411, Seraphic.rewards),
        WRECKED_YOU(23414, CreatorBox1.rewards),
        INHERITED(23415, CreatorBox2.rewards),
        CELESTIAL(23416, CreatorBox3.rewards),
        WALKCHAOS(23417, CreatorBox4.rewards),
        LANO(23425, CreatorBox5.rewards),
        SPRING(23429, SpringBox.loot),
        SUMMER(23826, SummerBox.rewards),
        AUTUMN(23428, AutumnBox.loot),
        PUMPKIN(1959, Pumpkin.loot),

        MONEY_CASE(23812, MoneyCase.loot),
        ;
        private int itemID;
        private Box[] loot;

        Caskets(int itemID, Box[] loot) {
            this.itemID = itemID;
            this.loot = loot;
        }

        public int getItemID() {
            return itemID;
        }

        public Box[] getLoot() {
            return loot;
        }

    }

}