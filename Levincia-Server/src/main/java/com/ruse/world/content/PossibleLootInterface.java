package com.ruse.world.content;

import com.ruse.model.Item;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.content.boxes.WheelOfFortune;
import com.ruse.world.content.boxes.*;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.casketopening.impl.*;
import com.ruse.world.content.minigames.impl.HallsOfAmmo;
import com.ruse.world.content.minigames.impl.TreasureHunter;
import com.ruse.world.content.skill.impl.mining.Mining;
import com.ruse.world.content.skill.impl.woodcutting.Woodcutting;
import com.ruse.world.entity.impl.player.Player;

import java.util.ArrayList;

public class PossibleLootInterface {

    public static void openInterface(Player player, LootData data) {
        player.getPacketSender().sendInterface(101000);

        int stringStart = 101271;
        for (LootData loot : LootData.values()) {
            player.getPacketSender().sendItemOnInterface(stringStart++, loot.getItemId(), 1);
            String name = loot.name != null ? loot.name : "          " + ItemDefinition.forId(loot.getItemId()).getName();
            player.getPacketSender().sendString(stringStart++, (loot == data ? "@whi@" : "") + name);
        }
        player.getPacketSender().setScrollBar(101250, LootData.values().length * 40);

        int index = 101051;
        int i = 0;
        for (Item item : data.getLoot()) {
            player.getPacketSender().sendItemOnInterface(index++, item.getId(), item.getAmount());
            i++;
        }
        int rows = (i / 7) + 1;
        if (rows <= 6)
            rows = 6;
        player.getPacketSender().setScrollBar(101050, 2 + (rows * 35));

        for (int z = i; z < (rows * 7 >= 42 ? rows * 7 : 42); z++) {
            player.getPacketSender().sendItemOnInterface(index++, -1, 1);
        }
    }

    public static boolean handleButton(Player player, int buttonID) {
        if (buttonID >= 101272 && buttonID <= 101348) {
            int index = (buttonID - 101272) / 2;

            if (index <= LootData.values().length)
                openInterface(player, LootData.values()[index]);

            return true;
        }
        return false;
    }

    public enum LootData {
        SUPER(19116, Super.common, Super.uncommon,Super.rare),
        EXTREME(19115, Extreme.common,Extreme.uncommon,Extreme.rare),
        GRAND(19114, Grand.common,Grand.uncommon,Grand.rare),
        OPchest(20488, OP.common,OP.uncommon,OP.rare),
        LAUNCH(20489, Launch.common,Launch.uncommon,Launch.rare),
        AZURE(15003, Azure.rewards),
        ELITE(15002, Elite.rewards),
        EXCLUSIVE(15004, Exclusive.rewards),
        LEGENDARY(14999, Legendary.rewards),
        SUPREME(23253, Supreme.rewards),
        FORTUNE(23002, WheelOfFortune.rewards),
        OCAPE(3578, Ocape.rare),
        OJEWELRY(23240, Ojewelry.rare),
        TREASURE_HUNTER("Treasure Hunter",  -1,TreasureHunter.loot),
        ISLES_OF_AVALON("Isles of Levincia",  -1, HallsOfAmmo.loot),
        RAIDS(18404, Raids1.rewards),
        BRONZE_CARD_PACK(23276, CardPackRewards.bronze),
        SILVER_CARD_PACK(23277, CardPackRewards.silver),
        GOLD_CARD_PACK(23278, CardPackRewards.gold),
        DIAMOND_CARD_PACK(23279, CardPackRewards.diamond),
        DRAGONBALLBOX(18768,  DragonballBox.common1,  DragonballBox.uncommon1,  DragonballBox.rare1),
        SLAYERBOX( 7120, SlayerBox.commonpro2,  SlayerBox.uncommonpro2,  SlayerBox.rarepro2),
        SLAYERBOX_U( 22123, UpgradedSlayerBox.commonpro2,  UpgradedSlayerBox.uncommonpro2,  UpgradedSlayerBox.rarepro2),
        PROGRESSIVEBOX(10025,  ProgressiveBox.commonpro,  ProgressiveBox.uncommonpro,  ProgressiveBox.rarepro),
        PVMMBOX(PVMBox.ITEM_ID, PVMBox.commonpvm, PVMBox.uncommonpvm, PVMBox.rarepvm),
        PVMMBOX_T2(22214, PVMBoxT2.commonpvm, PVMBoxT2.uncommonpvm, PVMBoxT2.rarepvm),
        MBOX(6199,MBox.common, MBox.uncommon,MBox.rare),
        PRESTIGE_MBOX(23236,PrestigeBox.rewards),
        AFK_TREE("Metal AFK Tree",-1, Woodcutting.afktree),
        AFK_SAPPHIRE("Sapphire AFK Rock",-1, Mining.sapphire),
        AFK_EMERALD("Emerald AFK Rock",-1, Mining.emerald),
        AFK_RUBY("Ruby AFK Rock",-1, Mining.ruby),
        AFK_DIAMOND("Diamond AFK Rock",-1, Mining.diamond),
        AFK_ONYX("Onyx AFK Rock",-1, Mining.onyx),
        AFK_ZENYTE("Zenyte AFK Rock",-1, Mining.zenyte),
        AFK_TANZANITE("Tanzanite AFK Rock",-1, Mining.tanzanite),
        AFK_PLATINUM("Platinum AFK Rock",-1, Mining.platinum),
        TRAVELLING_MERCHANT(-1, TravellingMerchant.FIRST_ITEMS, "Travelling Merchant"),
        PLATINUM_CHEST("Platinum Chest",-1, PlatinumRewards.rewards),
        ;

        private int itemId;
        private String name;
        private Item[] loot;


        LootData(int itemId, Item[] C, String name) {
            this.itemId = itemId;
            this.loot = new Item[C.length];
            this.name = name;
            int i = 0;
            for (Item d : C) {
                this.loot[i++] = new Item(d.getId(), d.getAmount());
            }
        }

        LootData(String name, int itemId, Box[] loot) {
            this.itemId = itemId;
            this.loot = new Item[loot.length];
            this.name = name;
            int i = 0;
            for (Box d : loot) {
                this.loot[i++] = new Item(d.getId(), d.getMax());
            }
        }


        LootData(int itemId, Box[] loot) {
            this.itemId = itemId;
            this.loot = new Item[loot.length];
            int i = 0;
            for (Box d : loot) {
                this.loot[i++] = new Item(d.getId(), d.getMax());
            }
        }


        LootData(int itemId, ArrayList<Item> loot) {
            this.itemId = itemId;
            this.loot = Misc.convertItems(loot);
        }

        LootData(int itemId, int[]... items) {
            this.itemId = itemId;

            ArrayList<Item> loot = new ArrayList<>();
            for (int i = 0; i < items.length; i++) {
                for (int z = 0; z < items[i].length; z++) {
                    loot.add(new Item(items[i][z]));
                }
            }
            this.loot = Misc.convertItems(loot);
        }
        /*LootData(int itemId, int[]... items) {
            this.itemId = itemId;

            ArrayList<Item> loot = new ArrayList<>();
                for (int z = 0; z < items[0].length; z++) {
                    loot.add(new Item(items[0][z]));
            }

            this.loot = Misc.convertItems(loot);
        }*/

        LootData(int itemId, Item[]... items) {
            this.itemId = itemId;

            ArrayList<Item> loot = new ArrayList<>();
            for (int i = 0; i < items.length; i++) {
                for (int z = 0; z < items[i].length; z++) {
                    loot.add(items[i][z]);
                }
            }
            this.loot = Misc.convertItems(loot);
        }

        public int getItemId() {
            return itemId;
        }

        public Item[] getLoot() {
            return loot;
        }

    }

}