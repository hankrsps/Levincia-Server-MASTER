package com.ruse.model.container.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ruse.GameSettings;
import com.ruse.ReducedSellPrice;
import com.ruse.engine.task.TaskManager;
import com.ruse.engine.task.impl.ShopRestockTask;
import com.ruse.model.GameMode;
import com.ruse.model.Item;
import com.ruse.model.Locations.Location;
import com.ruse.model.Position;
import com.ruse.model.Skill;
import com.ruse.model.container.ItemContainer;
import com.ruse.model.container.StackType;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.model.input.impl.EnterAmountToBuyFromShop;
import com.ruse.model.input.impl.EnterAmountToSellToShop;
import com.ruse.util.JsonLoader;
import com.ruse.util.Misc;
import com.ruse.webhooks.discord.DiscordMessager;
import com.ruse.world.World;
import com.ruse.world.content.*;
import com.ruse.world.content.globalBosses.GuardianSpawnSystem;
import com.ruse.world.content.minigames.impl.RecipeForDisaster;
import com.ruse.world.content.osrscollectionlog.CollectionLog;
import com.ruse.world.content.skill.impl.old_dungeoneering.UltimateIronmanHandler;
import com.ruse.world.content.skill.impl.summoning.BossPets;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static com.ruse.world.content.osrscollectionlog.LogType.MINIGAMES;

/**
 * Messy but perfect Shop System
 *
 * @author Gabriel Hannason
 */

public class Shop extends ItemContainer {

    public static final int TRAVELLING_MERCHANT = 3001;
    /**
     * The shop interface id.
     */
    public static final int INTERFACE_ID =
            3824;
    /**
     * The starting interface child id of items.
     */
    public static final int ITEM_CHILD_ID = 3900;
    /**
     * The interface child id of the shop's name.
     */
    public static final int NAME_INTERFACE_CHILD_ID = 3901;
    /**
     * The inventory interface id, used to set the items right click values to
     * 'sell'.
     */
    public static final int INVENTORY_INTERFACE_ID = 3823;
    public static final int GENERAL_STORE = 12;
    public static final int RECIPE_FOR_DISASTER_STORE = 36;
    /*
     * Declared shops
     */
    private static final int EASTER_STORE_1 = 150;
    private static final int HWEEN_STORE = 550;
    private static final int EASTER_STORE_2 = 151;
    private static final int GLOBAL_BOSS = 123;
    private static final int SAPPHIRE_STORE = 131;
    private static final int EMERALD_STORE = 132;
    private static final int RUBY_STORE = 133;
    private static final int DIAMOND_STORE = 134;
    private static final int ONYX_STORE = 135;
    private static final int ZENYTE_STORE = 136;
    private static final int HIGH_TIER_STORE = 137;

    private static final int DUNGEONEERING_STORE_NEW = 152;
    private static final int KOL_STORE = 207;
    private static final int VOTE_STORE = 90;
    private static final int PKING_REWARDS_STORE = 26;
    private static final int EVENT_SHOP = 81;
    private static final int BOSS_SHOP = 102;
    private static final int ENERGY_FRAGMENT_STORE = 33;
    private static final int AGILITY_TICKET_STORE = 39;
    private static final int PYRAMID_OUTBREAK_SHOP = 42;
    private static final int TOKKUL_EXCHANGE_STORE = 43;
    private static final int BOSS_SLAYER_SHOP = 107;
    private static final int SHILLINGS = 99;
    private static final int AFK = 103;
    private static final int PVM = 104;
    private static final int TRAIN_MELEE = 111;
    private static final int TRAIN_RANGED = 112;
    private static final int TRAIN_MAGIC = 113;
    private static final int STARDUST_EXCHANGE_STORE = 78;
    private static final int SKILLCAPE_STORE_1 = 8;
    private static final int SKILLCAPE_STORE_2 = 9;
    private static final int SKILLCAPE_STORE_3 = 10;
    private static final int GAMBLING_STORE = 41;
    private static final int DUNGEONEERING_STORE = 44;
    private static final int PRESTIGE_STORE = 46;
    private static final int SLAYER_SHOP = 471;
    private static final int PEST_CONTROL = 371;
    private static final int LOYALTY_POINT_SHOP = 110;
    private static final int BARROWS_STORE = 79;
    private static final int MEMBERS_STORE_I = 24;
    private static final int MEMBERS_STORE_II = 25;
    private static final int DONATOR_STORE_1 = DonatorShop.DonatorShopType.WEAPON.getShopId();
    private static final int DONATOR_STORE_2 = DonatorShop.DonatorShopType.ARMOUR.getShopId();
    private static final int DONATOR_STORE_3 = DonatorShop.DonatorShopType.ACCESSORY.getShopId();
    private static final int DONATOR_STORE_4 = DonatorShop.DonatorShopType.MISC.getShopId();

    private static final int PET_STORE_1 = PetShop.PetShopType.DAMAGE.getShopId();
    private static final int PET_STORE_2 = PetShop.PetShopType.RAID.getShopId();
    private static final int PET_STORE_3 = PetShop.PetShopType.DROP_RATE.getShopId();
    private static final int PET_STORE_4 = PetShop.PetShopType.MISC.getShopId();

    private static final int SELL_ITEMS = 119;
    private final int id;
    private String name;
    private Item currency;
    private final Item[] originalStock;
    private boolean restockingItems;
    /**
     * Opens a shop for a player
     *
     * @param player The player to open the shop for
     * @return The shop instance
     */


    private int currencyicon = 0;

    /*
     * The shop constructor
     */
    public Shop(Player player, int id, String name, Item currency, Item[] stockItems) {
        super(player);
        this.id = id;
        this.name = name.length() > 0 ? name : "General Store";
        this.currency = currency;
        this.originalStock = new Item[stockItems.length];
        for (int i = 0; i < stockItems.length; i++) {
            Item item = new Item(stockItems[i].getId(), stockItems[i].getAmount());
            add(item, false);
            this.originalStock[i] = item;
        }
    }

    /**
     * Checks if a player has enough inventory space to buy an item
     *
     * @param item The item which the player is buying
     * @return true or false if the player has enough space to buy the item
     */

    public static boolean hasInventorySpace(Player player, Item item, int currency, int pricePerItem) {
        if (player.getInventory().getFreeSlots() >= 1) {
            return true;
        }
        if (item.getDefinition().isStackable()) {
            if (player.getInventory().contains(item.getId())) {
                return true;
            }
        }
        if (currency != -1) {
            return player.getInventory().getFreeSlots() == 0
                    && player.getInventory().getAmount(currency) == pricePerItem;
        }
        return false;
    }

    public static boolean shopBuysItem(int shopId, Item item) {
        if (shopId == GENERAL_STORE || shopId == SELL_ITEMS || shopId == TRAVELLING_MERCHANT)
            return true;
        if (shopId == DUNGEONEERING_STORE || shopId == DUNGEONEERING_STORE_NEW || shopId == KOL_STORE || shopId == PKING_REWARDS_STORE || shopId == BOSS_SHOP
                || shopId == EVENT_SHOP
                || shopId == TRAIN_MELEE
                || shopId == TRAIN_RANGED
                || shopId == TRAIN_MAGIC
                || shopId == STARDUST_EXCHANGE_STORE || shopId == SHILLINGS
                || shopId == VOTE_STORE || shopId == RECIPE_FOR_DISASTER_STORE || shopId == EVENT_SHOP || shopId == GLOBAL_BOSS
                || shopId == BOSS_SHOP || shopId == ENERGY_FRAGMENT_STORE || shopId == AGILITY_TICKET_STORE
                || shopId == PYRAMID_OUTBREAK_SHOP || shopId == TOKKUL_EXCHANGE_STORE || shopId == BOSS_SLAYER_SHOP || shopId == PVM || shopId == AFK
                || shopId == PRESTIGE_STORE || shopId == SLAYER_SHOP|| shopId == PEST_CONTROL || shopId == LOYALTY_POINT_SHOP || shopId == BARROWS_STORE
                || shopId == MEMBERS_STORE_I || shopId == MEMBERS_STORE_II || shopId == DONATOR_STORE_1
                || shopId == DONATOR_STORE_2 || shopId == DONATOR_STORE_3 || shopId == DONATOR_STORE_4|| shopId == PET_STORE_1
                || shopId == PET_STORE_2 || shopId == PET_STORE_3 || shopId == PET_STORE_4 || shopId == 118)
            return false;
        Shop shop = ShopManager.getShops().get(shopId);
        if (shop != null && shop.getOriginalStock() != null) {
            for (Item it : shop.getOriginalStock()) {
                if (it != null && it.getId() == item.getId())
                    return true;
            }
        }
        return false;
    }

    public Item[] getOriginalStock() {
        return this.originalStock;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public Shop setName(String name) {
        this.name = name;
        return this;
    }

    public Item getCurrency() {
        return currency;
    }

    public Shop setCurrency(Item currency) {
        this.currency = currency;
        return this;
    }

    public boolean isRestockingItems() {
        return restockingItems;
    }

    public void setRestockingItems(boolean restockingItems) {
        this.restockingItems = restockingItems;
    }

    public Shop open(Player player) {
        if (player.getGameMode() == GameMode.IRONMAN || player.getGameMode() == GameMode.ULTIMATE_IRONMAN || player.getGameMode() == GameMode.GROUP_IRONMAN) {
            if (id != RECIPE_FOR_DISASTER_STORE && id != VOTE_STORE && id != PKING_REWARDS_STORE && id != 81
                    && id != BOSS_SHOP && id != AFK && id != PVM && id != SHILLINGS && id != 9 && id != 10 && id != 8
                    && id != 6 && id != 1 && id != 43 && id != 79 && id != 85 // trader shop
                    && id != 31 && id != 119 // member druid
                    && id != TRAVELLING_MERCHANT
                    && id != TRAIN_MELEE // member druid
                    && id != TRAIN_RANGED // member druid
                    && id != TRAIN_MAGIC // member druid
                    && id != 82 // teleports shop
                    && id != GENERAL_STORE && id != 40 && id != 47 // slayer shop
                    && id != STARDUST_EXCHANGE_STORE && id != GAMBLING_STORE && id != 83 && id != PRESTIGE_STORE
                    && id != 45 // 45 = dung guy
                    && id != MEMBERS_STORE_I && id != MEMBERS_STORE_II && id != DONATOR_STORE_1
                    && id != DONATOR_STORE_2 && id != DONATOR_STORE_3 && id != DONATOR_STORE_4
                    && id != PET_STORE_1
                    && id != PET_STORE_2 && id != PET_STORE_3 && id != PET_STORE_4
                    && id != 110
                    && id != 106
                    && id != BOSS_SLAYER_SHOP
                    && id != SLAYER_SHOP

                    && id != PEST_CONTROL
                    && id != KOL_STORE
                    && id != 17 && id != 2 // 17
                    && id != 33 && id != 39 && id != 11 && id != 34 && id != 14 && id != 13 && id != 18 && id != 15
                    && id != 21 && id != 44
                    && id != 22 && id != 42 && id != 35 && id != 32 && id != 23 && id != 38 && id != 91 && id != 92 && id != 0
                    && id != 93 && id != 94 && id != 95 && id != 96 && id != 97 && id != 98 && id != 30 && id != 117 && id != EASTER_STORE_1 && id != HWEEN_STORE && id != SAPPHIRE_STORE  && id != GLOBAL_BOSS  && id != EMERALD_STORE  && id != RUBY_STORE  && id != ONYX_STORE  && id != DIAMOND_STORE   && id != ZENYTE_STORE  && id != HIGH_TIER_STORE && id != EASTER_STORE_2 && id != DUNGEONEERING_STORE_NEW) { // 22 + 23 ==
                // pikkupstix's
                // materials,
                // 38 =
                // hunting
                // store, 30
                // =
                // herblore
                // store
                player.getPacketSender().sendMessage("You're unable to access this shop as a "
                        + player.getGameMode().toString().toLowerCase().replace("_", " ") + " player.");
                return this;
            }
        }
        setPlayer(player);
        getPlayer().getPacketSender().sendInterfaceRemoval().sendClientRightClickRemoval();

            getPlayer().setShop(ShopManager.getShops().get(id)).setInterfaceId(getInterfaceId()).setShopping(true);
        if (id == TRAVELLING_MERCHANT) {
            getPlayer().setShop(this);
        } else {
            getPlayer().setShop(ShopManager.getShops().get(id));
        }
        refreshItems();

        if (Misc.getMinutesPlayed(getPlayer()) <= 190)
            getPlayer().getPacketSender()
                    .sendMessage("Note: When selling an item to a store, it loses 50% of its original value.");


        Shop shop = ShopManager.getShops().get(id);

        for (int i = 0; i < shop.getItems().length; i++) {
            Item item = getItems()[i];
            int finalValue = 0;
            if (getCurrency().getId() != -1) {
                finalValue = ItemDefinition.forId(item.getId()).getValue();
                Object[] obj = ShopManager.getCustomShopData(id, item.getId());
                if (obj != null) {
                    finalValue = (int) obj[0];
                }
            } else {
                Object[] obj = ShopManager.getCustomShopData(id, item.getId());
                if (obj != null) {
                    finalValue = (int) obj[0];
                }
            }
            if (shop.getId() == 371) {
                currencyicon = 1;
                player.getPacketSender().sendString(35613 + i, (finalValue) + "," + currencyicon);
            }
            else if (shop.getId() == 104) {
                currencyicon = 1;
                player.getPacketSender().sendString(35613 + i, (finalValue) + "," + currencyicon);
            }
            else if (shop.getId() == 119 || shop.getId() == TRAVELLING_MERCHANT) {
                currencyicon = 0;
                player.getPacketSender().sendString(35613 + i, finalValue + "," + currencyicon);
            } else if (shop.getId() == 24) {
                currencyicon = 2;
                player.getPacketSender().sendString(35613 + i, finalValue + "," + currencyicon);
            } else if (shop.getId() == 137 || shop.getId() == HWEEN_STORE) {
                    currencyicon = 1;
                    player.getPacketSender().sendString(35613 + i, finalValue + "," + currencyicon);
            } else if (shop.getId() == 123) {
                currencyicon = 1;
                player.getPacketSender().sendString(35613 + i, finalValue + "," + currencyicon);
            } else if (shop.getId() == 110) {
                currencyicon = 1;
                player.getPacketSender().sendString(35613 + i, finalValue + "," + currencyicon);
            } else if (shop.getId() == 102) {
                currencyicon = 1;
                player.getPacketSender().sendString(35613 + i, finalValue + "," + currencyicon);
            } else if (shop.getId() == 471) {
                currencyicon = 5;
                player.getPacketSender().sendString(35613 + i, finalValue + "," + currencyicon);
            } else if (shop.getId() == 107) {
                currencyicon = 5;
                player.getPacketSender().sendString(35613 + i, finalValue + "," + currencyicon);
            } else if (shop.getId() == 90) {
                currencyicon = 3;
                player.getPacketSender().sendString(35613 + i, finalValue + "," + currencyicon);
            } else {
                player.getPacketSender().sendString(35613 + i, "," + -1);
            }
        }

        return this;
    }

    /**
     * Refreshes a shop for every player who's viewing it
     */
    public void publicRefresh() {
        Shop publicShop = this;
        if (publicShop == null)
            return;

        if (id == TRAVELLING_MERCHANT) {
        } else {
            publicShop.setItems(getItems());
            for (Player player : World.getPlayers()) {
                if (player == null)
                    continue;
                if (player.getShop() != null && player.getShop().id == id && player.isShopping())
                    player.getShop().setItems(publicShop.getItems());
            }
        }
    }

    /**
     * Checks a value of an item in a shop
     *
     * @param player      The player who's checking the item's value
     * @param slot        The shop item's slot (in the shop!)
     * @param sellingItem Is the player selling the item?
     */
    public void checkValue(Player player, int slot, boolean sellingItem) {
        this.setPlayer(player);
        if (UltimateIronmanHandler.hasItemsStored(player) && player.getLocation() != Location.DUNGEONEERING) {
            player.getPacketSender().sendMessage(
                    "<shad=0>@red@You cannot use the shop until you claim your stored Dungeoneering items.");
            return;
        }
        Item shopItem = new Item(getItems()[slot].getId());
        if (!player.isShopping()) {
            player.getPacketSender().sendInterfaceRemoval();
            return;
        }
        Item item = sellingItem ? player.getInventory().getItems()[slot] : getItems()[slot];
        if (item.getId() == 995 || item.getId() == ItemDefinition.COIN_ID)
            return;
        if (sellingItem) {
            if (!shopBuysItem(id, item)) {
                player.getPacketSender().sendMessage("You cannot sell this item to this store.");
                return;
            }

        } else {

            if (id == EASTER_STORE_2) {
                player.getPacketSender().sendMessage("You cannot sell items to this store.");
                return;
            }

            if (id == TRAVELLING_MERCHANT) {
                return;
            }



            if (id == TRAVELLING_MERCHANT && item.getAmount() == 0) {
                player.sendMessage("There are none of this item left in the stock.");
                return;
            }
        }
        Object[] exchangeItem = ShopManager.getCustomShopData(id, item.getId());

        int excahngeItemValue = 0;
            if (exchangeItem == null)
                return;
            excahngeItemValue = (int) exchangeItem[0];


        int finalValue = 0;
        String finalString = sellingItem ? "" + ItemDefinition.forId(item.getId()).getName() + ": shop will buy for "
                : "" + ItemDefinition.forId(shopItem.getId()).getName() + " currently costs @red@";
        String s = currency.getDefinition().getName().toLowerCase().endsWith("s")
                ? currency.getDefinition().getName().toLowerCase()
                : currency.getDefinition().getName().toLowerCase() + "s";
        if (getCurrency().getId() != -1) {
            finalValue = ItemDefinition.forId(item.getId()).getValue();



            if (id == PET_STORE_2){
                getPlayer().sendMessage("Coming soon...");
                return;
            }
            /** CUSTOM CURRENCY, CUSTOM SHOP VALUES **/
            if (id == TOKKUL_EXCHANGE_STORE || id == BOSS_SLAYER_SHOP || id == SLAYER_SHOP || id == PEST_CONTROL || id == PVM || id == AFK || id == STARDUST_EXCHANGE_STORE
                    || id == SHILLINGS
                    || id == TRAIN_MELEE
                    || id == TRAIN_RANGED
                    || id == TRAIN_MAGIC || id == KOL_STORE
                    || id == TRAVELLING_MERCHANT
                    || id == SAPPHIRE_STORE || id == GLOBAL_BOSS || id == EMERALD_STORE || id == RUBY_STORE || id == DIAMOND_STORE || id == ONYX_STORE || id == ZENYTE_STORE || id == HIGH_TIER_STORE
                    || id == EASTER_STORE_1 ||  id == HWEEN_STORE ||id == EASTER_STORE_2 || id == DUNGEONEERING_STORE_NEW
                    || id == ENERGY_FRAGMENT_STORE || id == AGILITY_TICKET_STORE
                    || id == PYRAMID_OUTBREAK_SHOP || id == BARROWS_STORE || id == MEMBERS_STORE_I || id == MEMBERS_STORE_II
                    || id == DONATOR_STORE_1 || id == DONATOR_STORE_2 || id == DONATOR_STORE_3 || id == DONATOR_STORE_4
                    || id == PET_STORE_1 || id == PET_STORE_2 || id == PET_STORE_3 || id == PET_STORE_4 || id == SELL_ITEMS || id == KOL_STORE) {
                Object[] obj = ShopManager.getCustomShopData(id, item.getId());
                if (obj == null)
                    return;
                finalValue = (int) obj[0];
                s = (String) obj[1];
            }
            if (sellingItem) {
                if (finalValue != 1) {
                    finalValue = (int) (finalValue * 0.5D);
                }
            } else {
                if (player.getLocation() == Location.SKILLING_ISLAND) {
                    if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                            && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FENRIR_PET.npcId) {
                        finalValue -= finalValue / 4;
                    }
                }
            }


            finalString += "" + finalValue + " " + s + "" + shopPriceEx(finalValue) + ".";
        } else {
            Object[] obj = ShopManager.getCustomShopData(id, item.getId());
            if (obj == null)
                return;
            finalValue = (int) obj[0];
            if (sellingItem && id == 119) {
                if (finalValue != 1) {
                    finalValue = (int) (finalValue * 1D);
                }
            }
            if (sellingItem && id == 137) {
                if (finalValue != 1) {
                    finalValue = (int) (finalValue * 1D);
                }
            }
            if (sellingItem) {
                if (finalValue != 1) {
                    finalValue = (int) (finalValue * 0.5D);
                }
            }

            finalString += "" + finalValue + " " + obj[1] + ".";
        }

        if (id == SELL_ITEMS && (item != null && exchangeItem != null)) {
            player.getPacketSender().sendMessage(ItemDefinition.forId(item.getId()).getName()
                    + ": @red@shop will buy for @red@" + (Misc.insertCommasToNumber(excahngeItemValue))
                    + " Levincia tokens"
            );
            return;
        }

        if (sellingItem && id != 119) {
            for (ReducedSellPrice r : ReducedSellPrice.values()) {
                if (r.getUnNotedId() == item.getId() || r.getNotedId() == item.getId()) {
                    finalString = ItemDefinition.forId(item.getId()).getName() + ": shop will buy for "
                            + r.getSellValue() + " " + s + "" + shopPriceEx(r.getSellValue()) + ".";
                    // finalString = item.getDefinition().getName() + ": shop will buy for 1000
                    // coins (1K).";
                }
            }

        }

        if (player != null && finalValue > 0) {
            player.getPacketSender().sendMessage(finalString);


            if (id ==  PET_STORE_1 || id ==  PET_STORE_2 || id ==  PET_STORE_3 || id == PET_STORE_4){
                if (!getPlayer().getPetShop().hasRequirements(item.getId())){
                    return;
                }
            }

            return;
        }

    }

    public void sellItem(Player player, int slot, int amountToSell) {
        this.setPlayer(player);

        Item itemToSell = player.getInventory().getItems()[slot];

        if (!player.isShopping() || player.isBanking()) {
            player.getPacketSender().sendInterfaceRemoval();
            return;
        }

        if (id == TRAVELLING_MERCHANT) {
            return;
        }
        Object[] exchangeItem = ShopManager.getCustomShopData(id, itemToSell.getId());

        if (id == SELL_ITEMS && (itemToSell != null && exchangeItem == null)) {
            player.getPacketSender().sendMessage( " @red@This item cant be sold to this shop");
            return;
        }
        /*
         * if(id == GENERAL_STORE) { if(player.getRights() ==
         * PlayerRights.ADMINISTRATOR) { player.getPacketSender().
         * sendMessage("You cannot sell items as a staff member who can spawn.");
         * return; } }
         */
        if (!player.isShopping() || player.isBanking()) {
            player.getPacketSender().sendInterfaceRemoval();
            return;
        }
        if (UltimateIronmanHandler.hasItemsStored(player) && player.getLocation() != Location.DUNGEONEERING) {
            player.getPacketSender().sendMessage(
                    "<shad=0>@red@You cannot use the shop until you claim your stored Dungeoneering items.");
            return;
        }
        if (!itemToSell.sellable() && !(itemToSell.getId() >= 23003 && itemToSell.getId() <= 23007)) {
            player.getPacketSender().sendMessage("This item cannot be sold.");
            return;
        }
        if (!shopBuysItem(id, itemToSell)) {
            player.getPacketSender().sendMessage("You cannot sell this item to this store.");
            return;
        }
        if (!player.getInventory().contains(itemToSell.getId()) || itemToSell.getId() == 995 || itemToSell.getId() == ItemDefinition.COIN_ID)
            return;
        if (this.full(itemToSell.getId()))
            return;
        if (player.getInventory().getAmount(itemToSell.getId()) < amountToSell)
            amountToSell = player.getInventory().getAmount(itemToSell.getId());
        if (amountToSell == 0)
            return;
        /*
         * if(amountToSell > 300) { String s =
         * ItemDefinition.forId(itemToSell.getId()).getName().endsWith("s") ?
         * ItemDefinition.forId(itemToSell.getId()).getName() :
         * ItemDefinition.forId(itemToSell.getId()).getName() + "s";
         * player.getPacketSender().sendMessage("You can only sell 300 "+s+" at a time."
         * ); return; }
         */
        int itemId = itemToSell.getId();
        boolean customShop = this.getCurrency().getId() == -1;
        boolean inventorySpace = customShop;
        if (!customShop) {
            if (!itemToSell.getDefinition().isStackable()) {
                if (!player.getInventory().contains(this.getCurrency().getId()))
                    inventorySpace = true;
            }
            if (player.getInventory().getFreeSlots() <= 0
                    && player.getInventory().getAmount(this.getCurrency().getId()) > 0)
                inventorySpace = true;
            if (player.getInventory().getFreeSlots() > 0
                    || player.getInventory().getAmount(this.getCurrency().getId()) > 0)
                inventorySpace = true;
        }
        int itemValue = 0;
        if (getCurrency().getId() > 0 && id != 119) {
            itemValue = ItemDefinition.forId(itemToSell.getId()).getValue();
            if (itemValue == 0) {
                Object[] obj = ShopManager.getCustomShopData(id, itemToSell.getId());
                if (obj == null)
                    return;
                itemValue = (int) obj[0];
            }
        } else {
            Object[] obj = ShopManager.getCustomShopData(id, itemToSell.getId());
            if (obj == null)
                return;
            itemValue = (int) obj[0];
        }
        if (itemValue <= 0)
            return;

        itemValue = (int) (itemValue * 0.5D);

        if (itemValue <= 0) {
            itemValue = 1;
        }

        if (id == HIGH_TIER_STORE) {
            int amount = (itemValue * amountToSell);
            if ((GuardianSpawnSystem.highTierCount + amount) >= 100) {
                amount = 100 - GuardianSpawnSystem.highTierCount;
            }
            GuardianSpawnSystem.highTierCount += amount;
            if (amount >= 10) {
                World.sendMessage("<col=4141ff><img=1463>[Vozzath]<img=1463> <col=c80101><shad=500202>" + player.getUsername() + " <col=191919>has contributed <col=c80101>" + amount + " <col=191919>Premium Tickets.");
            }
            if (GuardianSpawnSystem.highTierCount >= 100) {
                String message = "Vozzath has appeared ::Vozzath";
                NPC npc = new NPC(3830, new Position(2655, 3803, 0)); //NPC npc = new NPC(3830, new Position(3491, 2782));
                World.setGuardianActive(true);
                World.register(npc);
                World.sendMessage(message);
                World.sendBroadcastMessage(message);
                GuardianSpawnSystem.highTierCount = 0;
            }
        }
        for (int i = amountToSell; i > 0; i--) {
            itemToSell = new Item(itemId);
            if (this.full(itemToSell.getId()) || !player.getInventory().contains(itemToSell.getId())
                    || !player.isShopping())
                break;
            if (!itemToSell.getDefinition().isStackable()) {
                if (inventorySpace) {
                    super.switchItem(player.getInventory(), this, itemToSell.getId(), -1);
                    if (!customShop) {
                        if (ReducedSellPrice.forId(itemToSell.getId()) != null) {
                            player.getInventory().add(new Item(getCurrency().getId(),
                                    ReducedSellPrice.forId(itemToSell.getId()).getSellValue()), false);
                            PlayerLogs.logStores(player.getUsername(), "Player sold to store: " + ShopManager.getShops().get(id).getName()
                                    + ". Item: " + itemToSell.getDefinition().getName() + ", id: " + itemToSell.getId() + ", amount: " + 1 + ", profit: " + itemValue);
                        } else {
                            player.getInventory().add(new Item(getCurrency().getId(), itemValue), false);
                            if (id == 119)
                                player.getInventory().add(new Item(getCurrency().getId(), itemValue), false);
                        }
                    } else {
                        // Return points here
                    }
                } else {
                    player.getPacketSender().sendMessage("Please free some inventory space before doing that.");
                    break;
                }
            } else {
                if (inventorySpace) {
                    super.switchItem(player.getInventory(), this, itemToSell.getId(), amountToSell);
                    if (!customShop) {
                        if (itemToSell.reducedPrice()) {
                            player.getInventory()
                                    .add(new Item(getCurrency().getId(),
                                                    ReducedSellPrice.forId(itemToSell.getId()).getSellValue() * amountToSell),
                                            false);
                        } else {
                            player.getInventory().add(new Item(getCurrency().getId(), itemValue * amountToSell), false);
                        }
                    } else {
                        // Return points here
                    }
                    break;
                } else {
                    player.getPacketSender().sendMessage("Please free some inventory space before doing that.");
                    break;
                }
            }
            amountToSell--;
        }
        if (customShop) {
            PlayerPanel.refreshPanel(player);
        }
        player.getInventory().refreshItems();
        fireRestockTask();
        refreshItems();
        publicRefresh();
    }

    /**
     * Buying an item from a shop
     */
    @Override
    public Shop switchItem(ItemContainer to, Item item, int slot, boolean sort, boolean refresh) {
        final Player player = getPlayer();
        if (player == null)
            return this;
        if (!player.isShopping() || player.isBanking()) {
            player.getPacketSender().sendInterfaceRemoval();
            return this;
        }
        if (this.id == GENERAL_STORE) {
            if (player.getGameMode() == GameMode.IRONMAN || player.getGameMode() == GameMode.ULTIMATE_IRONMAN || player.getGameMode() == GameMode.GROUP_IRONMAN) {
                player.getPacketSender()
                        .sendMessage("Ironman-players are not allowed to buy items from the General store.");
                return this;
            }
        }
        if (!shopSellsItem(item))
            return this;
        if (getItems()[slot].getAmount() <= 1 && id != GENERAL_STORE && id != SELL_ITEMS && id != TRAVELLING_MERCHANT) {
            player.getPacketSender().sendMessage("The shop has run out of stock for this item.");
            return this;
        }
        if (item.getAmount() > getItems()[slot].getAmount())
            item.setAmount(getItems()[slot].getAmount());
        int amountBuying = item.getAmount();
        if (amountBuying == getItems()[slot].getAmount() && id != GENERAL_STORE && id != SELL_ITEMS && id != TRAVELLING_MERCHANT) {
            amountBuying = getItems()[slot].getAmount() - 1;
            player.getPacketSender().sendMessage("You buy the maximum amount you can from the shop.");
        }
        if (amountBuying <= 0)
            return this;
        if (amountBuying > GameSettings.Shop_Buy_Limit) {
            player.getPacketSender().sendMessage("You can only buy " + GameSettings.Shop_Buy_Limit + " "
                    + ItemDefinition.forId(item.getId()).getName() + "s at a time.");
            return this;
        }
        if (UltimateIronmanHandler.hasItemsStored(player) && player.getLocation() != Location.DUNGEONEERING) {
            player.getPacketSender().sendMessage("You must claim your stored items at Dungeoneering first.");
            return this;
        }
        if (UltimateIronmanHandler.hasItemsStored(player) && id == DUNGEONEERING_STORE) {
            player.getPacketSender().sendMessage("You must claim your stored items at Dungeoneering first.");
            return this;
        }
        boolean customShop = getCurrency().getId() == -1;
        boolean usePouch = false;
        int playerCurrencyAmount = 0;
        int value = ItemDefinition.forId(item.getId()).getValue();
        String currencyName = "";


        if (id ==  PET_STORE_1 || id ==  PET_STORE_2 || id ==  PET_STORE_3 || id == PET_STORE_4){
            if (!getPlayer().getPetShop().hasRequirements(item.getId())){
                return this;
            }
        }
        if (id == SELL_ITEMS){
            getPlayer().sendMessage("You can not purchase items from this shop.");
            return this;
        }
        if (id == PET_STORE_2){
            getPlayer().sendMessage("Coming soon...");
            return this;
        }
        if (getCurrency().getId() != -1) {
            playerCurrencyAmount = player.getInventory().getAmount(currency.getId());
            currencyName = ItemDefinition.forId(currency.getId()).getName().toLowerCase();
                /** CUSTOM CURRENCY, CUSTOM SHOP VALUES **/
                if (id == TOKKUL_EXCHANGE_STORE || id == BOSS_SLAYER_SHOP  || id == SLAYER_SHOP || id == PEST_CONTROL || id == PVM
                        || id == AFK
                        || id == TRAIN_MELEE
                        || id == TRAIN_RANGED
                        || id == SAPPHIRE_STORE || id == GLOBAL_BOSS || id == EMERALD_STORE || id == RUBY_STORE || id == DIAMOND_STORE || id == ONYX_STORE || id == ZENYTE_STORE || id == HIGH_TIER_STORE
                        || id == EASTER_STORE_1 ||  id == HWEEN_STORE|| id == EASTER_STORE_2 || id == DUNGEONEERING_STORE_NEW || id == KOL_STORE
                        || id == TRAIN_MAGIC
                        || id == STARDUST_EXCHANGE_STORE
                        || id == SHILLINGS || id == ENERGY_FRAGMENT_STORE || id == AGILITY_TICKET_STORE
                        || id == PYRAMID_OUTBREAK_SHOP || id == BARROWS_STORE || id == MEMBERS_STORE_I
                        || id == MEMBERS_STORE_II || id == DONATOR_STORE_1 || id == DONATOR_STORE_2 || id == DONATOR_STORE_3 || id == DONATOR_STORE_4
                        || id ==  PET_STORE_1 || id ==  PET_STORE_2 || id ==  PET_STORE_3 || id == PET_STORE_4) {
                    value = (int) ShopManager.getCustomShopData(id, item.getId())[0];
                } else if (id == TRAVELLING_MERCHANT) {
                    value = (int) Objects.requireNonNull(ShopManager.getCustomShopData(id, item.getId()))[0];
                }
        } else {
            Object[] obj = ShopManager.getCustomShopData(id, item.getId());
            if (obj == null)
                return this;
            value = (int) obj[0];
            currencyName = (String) obj[1];
            if (id == PKING_REWARDS_STORE) {
                playerCurrencyAmount = player.getPointsHandler().getPkPoints();
            } else if (id == SLAYER_SHOP) {
                playerCurrencyAmount = player.getPointsHandler().getSlayerPoints();
            } else if (id == PEST_CONTROL) {
                playerCurrencyAmount = player.getPointsHandler().getCommendations();
            } else if (id == VOTE_STORE) {
                playerCurrencyAmount = player.getPointsHandler().getVotingPoints();
            } else if (id == EVENT_SHOP) {
                playerCurrencyAmount = player.getPointsHandler().getEventPoints();
            } else if (id == BOSS_SHOP) {
                playerCurrencyAmount = player.getPointsHandler().getBossPoints();
            } else if (id == DUNGEONEERING_STORE) {
                playerCurrencyAmount = player.getPointsHandler().getDungeoneeringTokens();
            } else if (id == PRESTIGE_STORE) {
                playerCurrencyAmount = player.getPointsHandler().getPrestigePoints();
            } else if (id == LOYALTY_POINT_SHOP) {
                playerCurrencyAmount = player.getPointsHandler().getLoyaltyPoints();
            } else if (id == BARROWS_STORE) {
                playerCurrencyAmount = player.getPointsHandler().getBarrowsPoints();
            } else if (id == MEMBERS_STORE_I || id == MEMBERS_STORE_II || id == DONATOR_STORE_1
                    || id == DONATOR_STORE_2 || id == DONATOR_STORE_3 || id == DONATOR_STORE_4) {
                playerCurrencyAmount = player.getPointsHandler().getDonatorPoints();
            }

        }

        if (player.getLocation() == Location.SKILLING_ISLAND) {
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FENRIR_PET.npcId) {
                value -= value / 4;
            }
        }

        if (value <= 0) {
            return this;
        }
        if (!hasInventorySpace(player, item, getCurrency().getId(), value)) {
            player.getPacketSender().sendMessage("You do not have any free inventory slots.");
            return this;
        }
        if (playerCurrencyAmount <= 0 || playerCurrencyAmount < value) {
            player.getPacketSender()
                    .sendMessage("You do not have enough "
                            + ((currencyName.endsWith("s") ? (currencyName) : (currencyName + "s")))
                            + " to purchase this item.");
            return this;
        }
        if (id == SKILLCAPE_STORE_1 || id == SKILLCAPE_STORE_2 || id == SKILLCAPE_STORE_3) {
            for (int i = 0; i < item.getDefinition().getRequirement().length; i++) {
                int req = item.getDefinition().getRequirement()[i];
                if ((i == 3 || i == 5) && req == 99)
                    req *= 10;
                if (req > player.getSkillManager().getMaxLevel(i)) {
                    player.getPacketSender().sendMessage("You need to have at least level 99 in "
                            + Misc.formatText(Skill.forId(i).toString().toLowerCase()) + " to buy this item.");
                    return this;
                }
            }
        } else if (id == 83) {
            if (!player.getClickDelay().elapsed(3000)) {
                player.getPacketSender().sendMessage("Please wait 3 seconds before doing that again.");
                return this;
            }
            int b = 0;
            for (int i = 0; i < BossPets.BossPet.values().length; i++) {
                if (player.getBossPet(i)) {
                    b++;
                }
            }
            if (b < 1) {
                player.getPacketSender().sendMessage("You must have unlocked a Boss pet first.");
                return this;
            }
            player.getPacketSender().sendMessage("You can use the 'Pet return' item to get your pets back."); // Have
            // inventory/bank
            // space.");
            player.getPacketSender()
                    .sendMessage("You have " + b + " pets unlocked, have inventory/bank space available.");
            player.getClickDelay().reset();
        }else if (id == GAMBLING_STORE) {
            if (item.getId() == 15084 || item.getId() == 299) {
                player.getPacketSender().sendMessage("Gambling isn't ready yet.");
                return this;
            }
        } else if (id == 32
                && (item.getId() == 5510 || item.getId() == 5512 || item.getId() == 5514 || item.getId() == 5509)) {
            if (!player.getRights().isMember()) {
                player.getPacketSender().sendMessage("You must be a Member to purchase from this store.");
                return this;
            }
            if (item.getId() == 5510 && player.getSkillManager().getMaxLevel(Skill.RUNECRAFTING) < 25) {
                player.getPacketSender().sendMessage("You must have at least 25 Runecrafting to buy this pouch.");
                return this;
            }
            if (item.getId() == 5512 && player.getSkillManager().getMaxLevel(Skill.RUNECRAFTING) < 50) {
                player.getPacketSender().sendMessage("You must have at least 50 Runecrafting to buy this pouch.");
                return this;
            }
            if (item.getId() == 5514 && player.getSkillManager().getMaxLevel(Skill.RUNECRAFTING) < 75) {
                player.getPacketSender().sendMessage("You must have at least 75 Runecrafting to buy this pouch.");
                return this;
            }
        } else if (id == 33) { // id == 33
            if (item.getId() == 5509 || item.getId() == 5510 || item.getId() == 5512 || item.getId() == 5514) {
                for (int i = 0; i < 3; i++) {
                    if (player.getInventory().contains(item.getId())) {
                        player.getPacketSender().sendMessage("You already have that pouch!");
                        return this;
                    }
                    for (Bank b : player.getBanks()) {
                        if (b.contains(item.getId())) {
                            player.getPacketSender().sendMessage("You have that pouch in your bank!");
                            return this;
                        }
                    }
                }
            }
        } else if (id == 99) { // id == 33
            if (item.getId() == 19131 || item.getId() == 19135 || item.getId() == 19164 || item.getId() == 19163
                    || item.getId() == 19161 || item.getId() == 19163 || item.getId() == 4401) {
                for (int i = 0; i < 3; i++) {
                    if (player.getInventory().contains(item.getId())) {
                        player.getPacketSender().sendMessage("You already have that item!");
                        return this;
                    }
                    for (Bank b : player.getBanks()) {
                        if (b.contains(item.getId())) {
                            player.getPacketSender().sendMessage("You have that item in your bank!");
                            return this;
                        }
                    }
                }
            }
            if (item.getId() == 5510 && player.getSkillManager().getMaxLevel(Skill.RUNECRAFTING) < 25) {
                player.getPacketSender().sendMessage("You must have at least 25 Runecrafting to buy this pouch.");
                return this;
            }
            if (item.getId() == 5512 && player.getSkillManager().getMaxLevel(Skill.RUNECRAFTING) < 50) {
                player.getPacketSender().sendMessage("You must have at least 50 Runecrafting to buy this pouch.");
                return this;
            }
            if (item.getId() == 5514 && player.getSkillManager().getMaxLevel(Skill.RUNECRAFTING) < 75) {
                player.getPacketSender().sendMessage("You must have at least 75 Runecrafting to buy this pouch.");
                return this;
            }
        } else if (id == 21) {
            if (item.getId() == 6797) {
                if (!player.getRights().isMember()) {
                    player.getPacketSender().sendMessage("That item can only be bought by Members.");
                    return this;
                }
            }
        } else if (id == 90) {
            PlayerLogs.log("1 - Vote Shop",
                    player.getUsername() + " purchased " + item.getDefinition().getName() + " from vote shop.");
            DiscordMessager.sendDebugMessage(":bangbang: " + player.getUsername() + " has purchased "
                    + item.getDefinition().getName() + " from vote shop.");
        }  else if (id == 201 && item.getId() == 23102) {
        } else if (id == 81) {
            if (item.getId() == 9013 || item.getId() == 13150) {
                if (!player.didFriday13May2016()) {
                    player.getPacketSender().sendMessage("You must have participated in a Friday the 13th event.");
                    return this;
                }
            }
            switch (item.getId()) {
                // start hween 2016 list
                case 22036:
                case 22037:
                case 22038:
                case 22039:
                case 22040:
                case 9922:
                case 9921:
                    for (int i = 0; i < GameSettings.hweenIds2016.length; i++) {
                        if (GameSettings.hweenIds2016[i] == item.getId() && !player.getHween2016(i)) {
                            //		player.getPacketSender().sendMessage("You must have participated in the Halloween 2016 event.");
                            //	return this;
                        }
                    }
                    break;
                case 15420:
                    if (player.getChristmas2016() < 7) {
                        //			player.getPacketSender()
                        //				.sendMessage("You must have completed the Christmas 2016 event to unlock this.");
                        //		return this;
                    }
                    break;
                case 2946:
                    if (player.getNewYear2017() < 1) {
                        player.getPacketSender()
                                .sendMessage("You must have completed the New Year 2017 mini-event to unlock this.");
                    }
                    break;
            }
        }

        for (int i = amountBuying; i > 0; i--) {
            if (!shopSellsItem(item)) {
                break;
            }
            if (getItems()[slot].getAmount() <= 1 && id != GENERAL_STORE && id != SELL_ITEMS && id != TRAVELLING_MERCHANT) {
                player.getPacketSender().sendMessage("The shop has run out of stock for this item.");
                break;
            }
            if (!item.getDefinition().isStackable()) {
                if (playerCurrencyAmount >= value && hasInventorySpace(player, item, getCurrency().getId(), value)) {

                    if (!customShop) {
                        if (usePouch) {
                        } else {
                            player.getInventory().delete(currency.getId(), value, false);
                        }
                    } else {
                        if (id == PKING_REWARDS_STORE) {
                            player.getPointsHandler().setPkPoints(-value, true);
                        } else if (id == VOTE_STORE) {
                            player.getPointsHandler().setVotingPoints(-value, true);
                        } else if (id == SLAYER_SHOP) {
                            player.getPointsHandler().setSlayerPoints(-value, true);
                        } else if (id == PEST_CONTROL) {
                            player.getPointsHandler().setCommendations(-value, true);
                        } else if (id == DUNGEONEERING_STORE) {
                            player.getPointsHandler().setDungeoneeringTokens(-value, true);
                        } else if (id == EVENT_SHOP) {
                            player.getPointsHandler().setEventPoints(-value, true);
                        } else if (id == BOSS_SHOP) {
                            player.getPointsHandler().setBossPoints(-value, true);
                        } else if (id == PRESTIGE_STORE) {
                            player.getPointsHandler().setPrestigePoints(-value, true);
                        } else if (id == LOYALTY_POINT_SHOP) {
                            player.getPointsHandler().setLoyaltyPoints(-value, true);
                        } else if (id == BARROWS_STORE) {
                            player.getPointsHandler().setBarrowsPoints(-value, true);
                        } else if (id == MEMBERS_STORE_I || id == MEMBERS_STORE_II || id == DONATOR_STORE_1
                                || id == DONATOR_STORE_2 || id == DONATOR_STORE_3 || id == DONATOR_STORE_4) {
                            player.getPointsHandler().setDonatorPoints(-value, true);
                        }
                    }
                    if (id == PKING_REWARDS_STORE) {
                        player.getPacketSender().sendString(3903, "Pk points: " + player.getPointsHandler().getPkPoints());
                    } else if (id == SLAYER_SHOP) {
                        player.getPacketSender().sendString(3903, "Slayer Points: " + player.getPointsHandler().getSlayerPoints());
                    } else if (id == PEST_CONTROL) {
                        player.getPacketSender().sendString(3903, "Pest Control Points: " + player.getPointsHandler().getCommendations());
                    } else if (id == VOTE_STORE) {
                        player.getPacketSender().sendString(3903, "Voting Points: " + player.getPointsHandler().getVotingPoints());
                    } else if (id == EVENT_SHOP) {
                        player.getPacketSender().sendString(3903, "Event Points: " + player.getPointsHandler().getEventPoints());
                    } else if (id == BOSS_SHOP) {
                        player.getPacketSender().sendString(3903, "Boss Points: " + player.getPointsHandler().getBossPoints());
                    } else if (id == DUNGEONEERING_STORE) {
                        player.getPacketSender().sendString(3903, "Dung Points: " + player.getPointsHandler().getDungeoneeringTokens());
                    } else if (id == PRESTIGE_STORE) {
                        player.getPacketSender().sendString(3903, "Prestige Points: " + player.getPointsHandler().getPrestigePoints());
                    } else if (id == LOYALTY_POINT_SHOP) {
                        player.getPacketSender().sendString(3903, "Loyalty Points: " + player.getPointsHandler().getLoyaltyPoints());
                    } else if (id == BARROWS_STORE) {
                        player.getPacketSender().sendString(3903, "Barrows Points: " + player.getPointsHandler().getBarrowsPoints());
                    } else if (id == MEMBERS_STORE_I) {
                        playerCurrencyAmount = player.getPointsHandler().getDonatorPoints();
                        player.getPacketSender().sendString(3903, "Donator Points: " + player.getPointsHandler().getDonatorPoints());
                    } else if (id == AFK) {
                        player.getPacketSender().sendString(3903,
                                "AFK Tickets in Inventory: " + player.getInventory().getAmount(5020) + "");
                    }
                    super.switchItem(to, new Item(item.getId(), 1), slot, false, false);

                    if (id == PYRAMID_OUTBREAK_SHOP) {
                        MINIGAMES.log(player, CollectionLog.PYRAMID_OUTBREAK, new Item(item.getId()));
                    }
                    if (id == PEST_CONTROL) {
                        MINIGAMES.log(player, CollectionLog.PEST_CONTROL, new Item(item.getId()));
                    }
                    playerCurrencyAmount -= value;
                } else {
                    break;
                }
            } else {
                if (playerCurrencyAmount >= value && hasInventorySpace(player, item, getCurrency().getId(), value)) {

                    int canBeBought = playerCurrencyAmount / (value);
                    if (canBeBought >= amountBuying) {
                        canBeBought = amountBuying;
                    }
                    if (canBeBought == 0)
                        break;

                    if (!customShop) {
                        if (usePouch) {
                        } else {
                            player.getInventory().delete(currency.getId(), value * canBeBought, false);
                        }
                    } else {
                        if (id == PKING_REWARDS_STORE) {
                            player.getPointsHandler().setPkPoints(-value * canBeBought, true);
                        } else if (id == VOTE_STORE) {
                            player.getPointsHandler().setVotingPoints(-value * canBeBought, true);
                        } else if (id == SLAYER_SHOP) {
                            player.getPointsHandler().setSlayerPoints(-value * canBeBought, true);
                        } else if (id == PEST_CONTROL) {
                            player.getPointsHandler().setCommendations(-value * canBeBought, true);
                        } else if (id == DUNGEONEERING_STORE) {
                            player.getPointsHandler().setDungeoneeringTokens(-value * canBeBought, true);
                        } else if (id == EVENT_SHOP) {
                            player.getPointsHandler().setEventPoints(-value * canBeBought, true);
                        } else if (id == BOSS_SHOP) {
                            player.getPointsHandler().setBossPoints(-value * canBeBought, true);
                        } else if (id == PRESTIGE_STORE) {
                            player.getPointsHandler().setPrestigePoints(-value * canBeBought, true);
                        }else if (id == LOYALTY_POINT_SHOP) {
                            player.getPointsHandler().setLoyaltyPoints(-value * canBeBought, true);
                        } else if (id == BARROWS_STORE) {
                            player.getPointsHandler().setBarrowsPoints(-value * canBeBought, true);
                        } else if (id == MEMBERS_STORE_I || id == MEMBERS_STORE_II || id == DONATOR_STORE_1
                                || id == DONATOR_STORE_2 || id == DONATOR_STORE_3 || id == DONATOR_STORE_4) {
                            player.getPointsHandler().setDonatorPoints(-value * canBeBought, true);
                        }
                    }
                    if (id == PKING_REWARDS_STORE) {
                        player.getPacketSender().sendString(3903, "Pk points: " + player.getPointsHandler().getPkPoints());
                    } else if (id == SLAYER_SHOP) {
                        player.getPacketSender().sendString(3903, "Slayer Points: " + player.getPointsHandler().getSlayerPoints());
                    } else if (id == PEST_CONTROL) {
                        player.getPacketSender().sendString(3903, "Pest Control Points: " + player.getPointsHandler().getCommendations());
                    } else if (id == VOTE_STORE) {
                        player.getPacketSender().sendString(3903, "Voting Points: " + player.getPointsHandler().getVotingPoints());
                    } else if (id == EVENT_SHOP) {
                        player.getPacketSender().sendString(3903, "Event Points: " + player.getPointsHandler().getEventPoints());
                    } else if (id == BOSS_SHOP) {
                        player.getPacketSender().sendString(3903, "Boss Points: " + player.getPointsHandler().getBossPoints());
                    } else if (id == DUNGEONEERING_STORE) {
                        player.getPacketSender().sendString(3903, "Dung Points: " + player.getPointsHandler().getDungeoneeringTokens());
                    } else if (id == PRESTIGE_STORE) {
                        player.getPacketSender().sendString(3903, "Prestige Points: " + player.getPointsHandler().getPrestigePoints());
                    } else if (id == LOYALTY_POINT_SHOP) {
                        player.getPacketSender().sendString(3903, "Loyalty Points: " + player.getPointsHandler().getLoyaltyPoints());
                    } else if (id == BARROWS_STORE) {
                        player.getPacketSender().sendString(3903, "Barrows Points: " + player.getPointsHandler().getBarrowsPoints());
                    } else if (id == MEMBERS_STORE_I) {
                        playerCurrencyAmount = player.getPointsHandler().getDonatorPoints();
                        player.getPacketSender().sendString(3903, "Donator Points: " + player.getPointsHandler().getDonatorPoints());
                    } else if (id == AFK) {
                        player.getPacketSender().sendString(3903,
                                "AFK Tickets in Inventory: " + player.getInventory().getAmount(5020) + "");
                    }
                    super.switchItem(to, new Item(item.getId(), canBeBought), slot, false, false);

                    if (id == PYRAMID_OUTBREAK_SHOP) {
                        MINIGAMES.log(player, CollectionLog.PYRAMID_OUTBREAK, new Item(item.getId()));
                    }
                    if (id == PEST_CONTROL) {
                        MINIGAMES.log(player, CollectionLog.PEST_CONTROL, new Item(item.getId()));
                    }
                    if (id == TRAVELLING_MERCHANT) {
                        player.getDailyTaskManager().submitProgressToIdentifier(7, 1);
                    }


                    playerCurrencyAmount -= value;
                    break;
                } else {
                    break;
                }
            }
            amountBuying--;
        }
        if (!customShop) {
        } else {
            PlayerPanel.refreshPanel(player);
        }
        player.getInventory().refreshItems();
        fireRestockTask();
        refreshItems();
        publicRefresh();
        return this;
    }

    @Override
    public Shop add(Item item, boolean refresh) {
        super.add(item, false);
        if (id != RECIPE_FOR_DISASTER_STORE)
            publicRefresh();
        return this;
    }

    @Override
    public int capacity() {
        return 100;
    }
    @Override
    public Item[] getItems() {
        if (id == TRAVELLING_MERCHANT && getPlayer() != null) {
            return getPlayer().getMerchantItems();
        }
        return items;
    }

    @Override
    public ItemContainer setItems(Item[] items) {
        if (id == TRAVELLING_MERCHANT) {
            getPlayer().setMerchantItems(items);
            //this.items = getPlayer().getMerchantItems();
            return this;
        }
        this.items = items;
        return this;
    }

    @Override
    public int getSlot(int id) {
        for (int i = 0; i < capacity(); i++) {
            if (getItems()[i].getId() > 0 && getItems()[i].getId() == id) {
                if (getItems()[i].getAmount() > 0 || (this instanceof Shop) && getItems()[i].getAmount() == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int getAmount(int id) {
        int totalAmount = 0;
        for (Item item : getItems()) {
            if (item.getId() == id) {
                totalAmount += item.getAmount();
            }
        }
        return totalAmount;
    }
    @Override
    public ItemContainer delete(Item item, int slot, boolean refresh, ItemContainer toContainer) {
        if (item == null || slot < 0)
            return this;

        boolean leavePlaceHolder = this instanceof Shop;
        if (item.getAmount() > getAmount(item.getId()))
            item.setAmount(getAmount(item.getId()));
        if (item.getDefinition().isStackable() || stackType() == StackType.STACKS) {
            if (toContainer != null && !item.getDefinition().isStackable()
                    && item.getAmount() > toContainer.getFreeSlots() && !(this instanceof Shop))
                item.setAmount(toContainer.getFreeSlots());

            getItems()[slot].setAmount(getItems()[slot].getAmount() - item.getAmount());

            if (getItems()[slot].getAmount() < 1) {
                getItems()[slot].setAmount(0);
                if (!leavePlaceHolder) {
                    getItems()[slot].setId(-1);
                }
            }
        } else {
            int amount = item.getAmount();
            while (amount > 0) {
                if (slot == -1 || (toContainer != null && toContainer.isFull()))
                    break;
                if (!leavePlaceHolder) {
                    getItems()[slot].setId(-1);
                }
                getItems()[slot].setAmount(0);
                slot = getSlot(item.getId());
                amount--;
            }
        }
        if (refresh)
            refreshItems();
        return this;
    }

    @Override
    public StackType stackType() {
        return StackType.STACKS;
    }

    @Override
    public Shop refreshItems() {
        if (id == RECIPE_FOR_DISASTER_STORE) {
            RecipeForDisaster.openRFDShop(getPlayer());
            return this;
        }
        for (Player player : World.getPlayers()) {
            if (player == null || !player.isShopping() || player.getShop() == null || player.getShop().id != id)
                continue;
            if (id == TRAVELLING_MERCHANT && getPlayer() != null && !getPlayer().equals(player)) {
                continue;
            }

            int scrollAmount = 5 + ((getValidItemsArray().length / 8) * 56);
            if (getValidItemsArray().length % 8 != 0)
                scrollAmount += 56;

            if (scrollAmount < 221) {
                scrollAmount = 221;
            }
            player.getPacketSender().setScrollBar(29995, scrollAmount);

            player.getPacketSender().sendItemContainer(player.getInventory(), INVENTORY_INTERFACE_ID);
            player.getPacketSender().sendItemContainer(this, ITEM_CHILD_ID);
            player.getPacketSender().sendString(NAME_INTERFACE_CHILD_ID, name);
            if (player.getInputHandling() == null || !(player.getInputHandling() instanceof EnterAmountToSellToShop
                    || player.getInputHandling() instanceof EnterAmountToBuyFromShop))
                player.getPacketSender().sendInterfaceSet(INTERFACE_ID, INVENTORY_INTERFACE_ID - 1);

            String name = "";
            int points = 0;

            if (id == SLAYER_SHOP) {
                name = "Slayer Points:";
                points = player.getPointsHandler().getSlayerPoints();
            } else if (id == VOTE_STORE) {
                name = "Vote Points:";
                points = player.getPointsHandler().getVotingPoints();
            } else if (id == LOYALTY_POINT_SHOP) {
                name = "Loyalty Points:";
                points = player.getPointsHandler().getLoyaltyPoints();
            } else if (id == DONATOR_STORE_1) {
                name = "Donator Points:";
                points = player.getPointsHandler().getDonatorPoints();
            } else if (id == BOSS_SHOP) {
                name = "Boss Points:";
                points = player.getPointsHandler().getBossPoints();
            } else if (id == PEST_CONTROL) {
                name = "Pest Control Points:";
                points = player.getPointsHandler().getCommendations();
            }

            if (id == SELL_ITEMS){
                player.getPacketSender().sendString(3903, "Items can only be sold to this store");
            }else if (id == TRAVELLING_MERCHANT){
                player.getPacketSender().sendString(3903, "Store items will change in: @whi@" + Misc.getTimeTillReset());
            }else{
                if (id == HIGH_TIER_STORE || id == PVM) {
                    player.getPacketSender().sendString(3903, "You can exchange items to this shop for half the price");
                } else {
                    if (name.equals(""))
                        player.getPacketSender().sendString(3903, "");
                    else
                        player.getPacketSender().sendString(3903, name + " " + points);
                }
            }
        }
        return this;
    }

    public int getItemChildId() {
        if (DonatorShop.DonatorShopType.isDonatorStore(id)) {
            return DonatorShop.ITEM_CHILD_ID;
        } else if (PetShop.PetShopType.isPetStore(id)) {
            return PetShop.ITEM_CHILD_ID;
        }
        return ITEM_CHILD_ID;
    }

    public int getInterfaceId() {
        if (DonatorShop.DonatorShopType.isDonatorStore(id)) {
            return DonatorShop.INTERFACE_ID;
        } else if (PetShop.PetShopType.isPetStore(id)) {
            return PetShop.INTERFACE_ID;
        }
        return INTERFACE_ID;
    }

    @Override
    public Shop full() {
        getPlayer().getPacketSender().sendMessage("The shop is currently full. Please come back later.");
        return this;
    }

    public String shopPriceEx(int shopPrice) {
        String ShopAdd = "";
        if (shopPrice >= 1000 && shopPrice < 1000000) {
            ShopAdd = " (" + (shopPrice / 1000) + "K)";
        } else if (shopPrice >= 1000000) {
            ShopAdd = " (" + (shopPrice / 1000000) + "M)";
        }

        return ShopAdd;
    }

    private boolean shopSellsItem(Item item) {
        return contains(item.getId()) && id != EASTER_STORE_2;
    }

    public void fireRestockTask() {
        if (isRestockingItems() || fullyRestocked())
            return;
        setRestockingItems(true);
        TaskManager.submit(new ShopRestockTask(this));
    }

    public boolean fullyRestocked() {
        if (id == TRAVELLING_MERCHANT) {
        return true;
    }
        if (id == GENERAL_STORE) {
            return getValidItems().size() == 0;
        } else if (id == RECIPE_FOR_DISASTER_STORE) {
            return true;
        }
        if (getOriginalStock() != null) {
            for (int shopItemIndex = 0; shopItemIndex < getOriginalStock().length; shopItemIndex++) {
                if (getItems()[shopItemIndex].getAmount() != getOriginalStock()[shopItemIndex].getAmount())
                    return false;
            }
        }
        return true;
    }

    public static class ShopManager {

        private static final Map<Integer, Shop> shops = new HashMap<Integer, Shop>();
        private static int slot = 0;

        public static Map<Integer, Shop> getShops() {
            return shops;
        }

        public static JsonLoader parseShops() {
            return new JsonLoader() {
                @Override
                public void load(JsonObject reader, Gson builder) {
                    int id = reader.get("id").getAsInt();
                    String name = reader.get("name").getAsString();
                    Item[] items = builder.fromJson(reader.get("items").getAsJsonArray(), Item[].class);
                    Item currency = new Item(reader.get("currency").getAsInt());
                    shops.put(id, new Shop(null, id, name, currency, items));
                }

                //
                @Override
                public String filePath() {
                    return "./data/def/json/world_shops.json";
                }
            };
        }

        public static void saveTaxShop() {
            final Item[] items = getShops().get(119).getItems();
            final Path path = Paths.get("./data/shopdata.txt");
            List<String> lines = new ArrayList<>();
            for (Item item : items) {
                lines.add(item.getId() + ":" + item.getAmount());
            }

            try {
                Files.write(path, lines);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        //i have the vortex u sent me in the project exlporer if u need for reference, nah it doesnt have it, i deleted it probably months ago.
        public static void parseTaxShop() {
            slot = 0;
            final Path path = Paths.get("./data/shopdata.txt");

            Shop shop = new Shop(null, 119, "Item Exchange", new Item(ItemDefinition.UPGRADE_TOKEN_ID), new Item[]{});
            try (Stream<String> lines = Files.lines(path)) {

                lines.forEach(line -> {
                    String[] data = line.split(":");
                    int id = Integer.parseInt(data[0]);
                    int amount = Integer.parseInt(data[1]);

                    shop.setItem(slot, new Item(id, amount));
                    slot++;
                    // oh shit ive deleted it on my local to show an example to some1 i think lol gotta rewrite

                });
                shops.put(119, shop);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        public static Object[] getCustomShopData(int shop, int item) {
                if (shop == TRAVELLING_MERCHANT) {
                    return new Object[]{TravellingMerchant.getPrice(item), "Levincia tokens"};
                } else if (shop == VOTE_STORE) {
                switch (item) {
                    case 21218:
                        return new Object[] { 5, "Vote points" };
                    case 3907:
                        return new Object[] { 10, "Vote points" };
                        case 10947:
                        return new Object[] { 15, "Vote points" };
                    case 9083:
                        return new Object[] { 1500, "Vote points" };
                    case 3739:
                    case 3738:
                    case 3737:
                        return new Object[] { 25, "Vote points" };
                    case 8087:
                    case 8088:
                    case 8089:
                        return new Object[] { 50, "Vote points" };
                    case 20086:
                    case 20087:
                    case 20088:
                    case 20091:
                    case 20090:
                    case 20089:
                        return new Object[] { 75, "Vote points" };
                    case 19886:
                    case 4446:
                        return new Object[] { 50, "Vote points" };
                    case 20488:
                        return new Object[] { 50, "Vote points" };
                    case 11316:
                    case 11319:
                        return new Object[] { 1250, "Vote points" };
                    case 11314:
                        return new Object[] { 750, "Vote points" };
                    case 15004:
                        return new Object[] { 2500, "Vote points" };
                    case 15355:
                    case 15356:
                    case 15357:
                        return new Object[] { 150, "Vote points" };
                    case 15358:
                    case 15359:
                        return new Object[] { 100, "Vote points" };
                    case 10946:
                        return new Object[] { 100, "Vote points" };
                    case 15330:
                        return new Object[] { 500, "Vote points" };
                }

            } else if (shop == SELL_ITEMS) {
                switch (item) {

                    case 11137:
                        return new Object[]{100, "Levincia tokens"};
                    case 21218:
                        return new Object[]{5000, "Levincia tokens"};
                    case 23020:
                        return new Object[]{75000, "Levincia tokens"};
                    case 8410:
                    case 8411:
                    case 8412:
                        return new Object[]{2_500_000, "Levincia tokens"};
                    case 4684:
                        return new Object[]{4_000_000, "Levincia tokens"};
                    case 4685:
                    case 4686:
                        return new Object[]{5_000_000, "Levincia tokens"};
                    case 5012:
                    case 12535:
                    case 17011:
                        return new Object[]{15_000_000, "Levincia tokens"};

                    case 5011:
                    case 12537:
                    case 17013:
                        return new Object[]{25_000_000, "Levincia tokens"};


                    case 22113:
                    case 22114:
                    case 22115:
                        return new Object[]{75_000_000, "Levincia tokens"};


                    case 8136:
                    case 23226:
                    case 23227:
                        return new Object[]{225_000_000, "Levincia tokens"};
                    case 18889:
                    case 18885:
                    case 18887:
                        return new Object[]{5_000_000, "Levincia tokens"};
                    case 9080:
                    case 9081:
                    case 9082:
                        return new Object[]{100_000, "Levincia tokens"};
                    case 23258:
                    case 22005:
                        return new Object[]{2_000_000, "Levincia tokens"};
                    case 23281:
                    case 23282:
                    case 23283:
                    case 23284:
                    case 23285:
                        return new Object[]{20_000_000, "Levincia tokens"};
                    case 23303:
                    case 23304:
                    case 23305:
                    case 23306:
                    case 23307:
                    case 23308:
                    case 23309:
                    case 23310:
                    case 23311:
                        return new Object[]{25_000_000, "Levincia tokens"};

                    case 23230:
                    case 23231:
                    case 23232:
                        return new Object[]{45_000_000, "Levincia tokens"};
                    case 18818:
                    case 18888:
                        return new Object[]{1_000_000, "Levincia tokens"};
                    case 4278:
                        return new Object[]{500, "Levincia tokens"};
                    case 23264:
                        return new Object[]{4000, "Levincia tokens"};
                    case 23321:
                    case 22006:
                        case 23044:
                        return new Object[]{10000, "Levincia tokens"};
                    case 23045:
                        return new Object[]{100_000, "Levincia tokens"};
                    case 23046:
                        return new Object[]{300_000, "Levincia tokens"};
                    case 23047:
                        return new Object[]{750_000, "Levincia tokens"};
                    case 23048:
                        return new Object[]{1_500_000, "Levincia tokens"};
                    case 23049:
                        return new Object[]{3_000_000, "Levincia tokens"};
                    case 22100:
                    case 22101:
                    case 22102:
                        return new Object[]{12_000_000, "Levincia tokens"};
                    case 22103:
                    case 22104:
                        return new Object[]{8_000_000, "Levincia tokens"};
                    case 22105:
                        return new Object[]{40_000_000, "Levincia tokens"};
                    case 20591:
                        return new Object[]{15_000_000, "Levincia tokens"};
                    case 20400:
                        return new Object[]{25_000_000, "Levincia tokens"};
                    case 7995:
                        return new Object[]{40_000_000, "Levincia tokens"};
                    case 18883:
                    case 18881:
                        return new Object[]{1_500_000, "Levincia tokens"};
                    case 19810:
                        return new Object[]{2_500_000, "Levincia tokens"};
                    case 9084:
                        return new Object[]{1_000_000, "Levincia tokens"};
                    case 9083:
                        return new Object[]{15_000_000, "Levincia tokens"};
                }

            } else if (shop == PKING_REWARDS_STORE) {
                switch (item) {
                    case 6918:
                    case 6914:
                    case 6889:
                    case 2579:
                        return new Object[]{25, "Pk points"};
                    case 6916:
                    case 6924:
                        return new Object[]{30, "Pk points"};
                    case 6920:
                    case 6922:
                        return new Object[]{20, "Pk points"};
                    case 2581:
                    case 11730:
                        return new Object[]{100, "Pk points"};
                    case 2577:
                        return new Object[]{100, "Pk points"};
                    case 15486:
                    case 19111:
                        return new Object[]{250, "Pk points"};
                    case 13879:
                    case 13883:
                    case 15243:
                    case 15332:
                        return new Object[]{4, "Pk points"};
                    case 15241:
                    case 17273:
                        return new Object[]{200, "Pk points"};
                    case 10548:
                    case 10547:
                    case 10551:
                        return new Object[]{150, "Pk points"};
                    case 6570:
                    case 11235:
                    case 4151:
                    case 11696:
                    case 11698:
                    case 11700:
                        return new Object[]{500, "Pk points"};
                    case 14484:
                    case 19780:
                        return new Object[]{750, "Pk points"};
                    case 11728:
                    case 15018:
                    case 15019:
                    case 15020:
                    case 15220:
                        return new Object[]{50, "Pk points"};
                    case 11694:
                        return new Object[]{600, "Pk points"};
                }
            } else if (shop == EVENT_SHOP) {
                switch (item) {
                    case 9013:
                    case 13150:
                    case 22036:
                    case 22037:
                    case 22038:
                    case 22039:
                    case 22040:
                    case 9922:
                    case 9921:

                        return new Object[]{100, "Event points"};
                    case 15420:
                    case 2946:
                        return new Object[]{600, "Event Points"};
                    case 19828:
                    case 19823:
                    case 19822:
                    case 19815:
                    case 19817:
                    case 19818:
                    case 19813:
                    case 4395:
                        return new Object[]{400, "Event Points"};

                }
            } else if (shop == BOSS_SHOP) {
                switch (item) {
                    case 15331:
                        return new Object[]{125, "Boss points"};
                    case 19335:
                    case 11716:
                    case 11730:
                    case 18337:
                    case 6500:
                    case 15486:
                    case 13754:
                    case 19682:
                    case 18819:
                        return new Object[]{150, "Boss Points"};
                    case 20488:
                        return new Object[]{450, "Boss Points"};
                    case 15288:
                        return new Object[]{500, "Boss Points"};
                    case 6927:
                    case 6928:
                    case 6929:
                    case 6930:
                    case 6931:
                    case 6932:
                    case 6933:
                    case 6934:
                    case 6935:
                    case 6936:
                    case 19136:
                    case 22077:
                        return new Object[]{350, "Boss Points"};
                    case 3907:
                        return new Object[]{80, "Boss Points"};
                    case 19114:
                        return new Object[]{250, "Boss Points"};
                    case 19115:
                        return new Object[]{100, "Boss Points"};
                    case 3905:
                    case 3805:
                        return new Object[]{100, "Boss Points"};
                    case 18750:
                    case 18636:
                    case 18629:
                        return new Object[]{2500, "Boss Points"};
                    case 18753:
                    case 18752:
                    case 18751:
                    case 18749:
                    case 18748:
                    case 18638:
                    case 18631:
                    case 18637:
                    case 18623:
                        return new Object[]{1750, "Boss Points"};
                }
            } else if (shop == ENERGY_FRAGMENT_STORE) {
                switch (item) {
                    case 5509:
                        return new Object[]{25, "energy fragments"};
                    case 5510:
                        return new Object[]{100, "energy fragments"};
                    case 5512:
                        return new Object[]{250, "energy fragments"};
                    case 5514:
                        return new Object[]{500, "energy fragments"};
                    case 13613: // hats
                    case 13616:
                    case 13626:
                        return new Object[]{1500, "energy fragments"};
                    case 13619: // bodies
                    case 13614:
                    case 13624:
                        return new Object[]{1000, "energy fragments"};
                    case 13622: // legs
                    case 13617:
                    case 13627:
                        return new Object[]{1000, "energy fragments"};
                    case 13623: // gloves
                    case 13618:
                    case 13628:
                        return new Object[]{500, "energy fragments"};
                }
            } else if (shop == AGILITY_TICKET_STORE) {
                switch (item) {
                    case 14936:
                    case 14938:
                        return new Object[]{200, "agility tickets"};
                    case 10941:
                    case 10939:
                    case 10940:
                    case 10933:
                        return new Object[]{100, "agility tickets"};
                    case 13661:
                        return new Object[]{1000, "agility tickets"};
                }
            } else if (shop == STARDUST_EXCHANGE_STORE) {
                switch (item) {
                    case 6180:
                    case 6181:
                    case 6182:
                    case 9945:
                    case 9472:
                    case 10394:
                    case 13674:
                    case 13673:
                    case 19735:
                    case 18776:
                        return new Object[]{2500, "stardust"};
                    case 7409:
                    case 9944:
                        return new Object[]{3500, "stardust"};
                    case 6666:
                    case 13661:
                    case 2997:
                    case 2651:
                    case 13672:
                        return new Object[]{5000, "stardust"};
                    case 454:
                        return new Object[]{2, "stardust"};
                    case 9185:
                        return new Object[]{250, "stardust"};
                    case 5609:
                    case 5608:
                        return new Object[]{4000, "stardust"};
                    case 9005:
                        return new Object[]{750, "stardust"};
                    case 5607:
                        return new Object[]{7500, "stardust"};
                    case 13675:
                        return new Object[]{1000, "stardust"};
                }
            } else if (shop == PYRAMID_OUTBREAK_SHOP) {
                switch (item) {
                    case 4151:
                    case 11235:
                    case 15486:
                        return new Object[]{100, "Mummy fragments"};
                    case 18353:
                        return new Object[]{125, "Mummy fragments"};
                    case 7462:
                    case 15031:
                    case 6585:
                    case 7956:
                        return new Object[]{250, "Mummy fragments"};
                    case 22077:
                    case 6927:
                    case 6928:
                    case 6929:
                    case 19136:
                    case 6930:
                    case 6931:
                    case 6932:
                    case 6936:
                    case 6933:
                    case 6934:
                    case 6935:
                        return new Object[]{1250, "Mummy fragments"};
                    case 12634:
                    case 23045:
                        return new Object[]{2000, "Mummy fragments"};
                    case 10946:
                        return new Object[]{25000, "Mummy fragments"};
                }
            } else if (shop == BOSS_SLAYER_SHOP) {
                switch (item) {
                    case 22006://add
                        return new Object[] { 5, "Boss Slayer tickets" };
                    case 15358:
                    case 15359:
                    case 20488:
                        return new Object[] { 100, "Boss Slayer tickets" };
                    case 23215:
                        return new Object[] { 25, "Boss Slayer tickets" };
                    case 4446:
                    case 19886:
                        return new Object[] { 250, "Boss Slayer tickets" };
                    case 23071:
                        return new Object[] { 1000, "Boss Slayer tickets" };
                    case 22005:
                    case 22107:
                    case 23258://add
                    case 23259://add
                    case 23260://add
                    case 23261://add
                    case 23262://add
                    case 23263://add
                        return new Object[] { 3500, "Boss Slayer tickets" };
                    case 15330:
                        return new Object[] { 2000, "Boss Slayer tickets" };
                }
            } else if (shop == EASTER_STORE_1) {
                switch (item) {
                    case 23004:
                    case 23005:
                    case 23006:
                    case 23007:
                        return new Object[]{1000, "Easter ticket"};
                }
            } else if (shop == HWEEN_STORE) {
                    switch (item) {
                        case 15289:
                        case 15358:
                        case 15359:
                        case 20488:
                            return new Object[]{20, "Turkey feathers"};
                        case 10946:
                            return new Object[]{30, "Turkey feathers"};
                        case 6769:
                            return new Object[]{150, "Turkey feathers"};
                        case 10942:
                            return new Object[]{300, "Turkey feathers"};
                        case 23428:
                            return new Object[]{100, "Turkey feathers"};
                        case 23511:
                        case 23454:
                            return new Object[]{2000, "Turkey feathers"};
                    }
            } else if (shop == PEST_CONTROL) {
                switch (item) {
                    case 11674:
                    case 11676:
                    case 11675:
                        return new Object[]{500, "Commendation points"};
                    case 8839:
                    case 8840:
                        return new Object[]{600, "Commendation points"};
                    case 8842:
                        return new Object[]{400, "Commendation points"};
                    case 15288:
                        return new Object[]{25, "Commendation points"};
                    case 22219:
                        return new Object[]{5, "Commendation points"};
                    case 15358:
                    case 15359:
                        return new Object[]{50, "Commendation points"};
                    case 20488:
                        return new Object[]{20, "Commendation points"};
                }
            } else if (shop == GLOBAL_BOSS) {
                switch (item) {
                    case 15290:
                    case 19116:
                        return new Object[] { 2, "Global tickets" };

                    case 19115:
                        return new Object[] { 4, "Global tickets" };
                    case 19114:
                        return new Object[] { 6, "Global tickets" };
                    case 20488:
                        return new Object[] { 10, "Global tickets" };
                    case 20489:
                        return new Object[] { 100, "Global tickets" };
                    case 4446:
                    case 19886:
                        return new Object[] { 250, "Global tickets" };
                    case 15358:
                    case 15359:
                        return new Object[] { 200, "Global tickets" };
                    case 1486:
                        return new Object[] { 500, "Global tickets" };
                    case 10947:
                        return new Object[] { 750, "Global tickets" };
                    case 9084:
                    case 10946:
                        return new Object[] { 1000, "Global tickets" };
                }
            } else if (shop == SAPPHIRE_STORE) {
                switch (item) {
                    case 23197:
                        return new Object[]{1000, "Sapphire fragments"};
                }
            } else if (shop == EMERALD_STORE) {
                switch (item) {
                    case 23198:
                        return new Object[]{1000, "Emerald fragments"};
                }
            } else if (shop == RUBY_STORE) {
                switch (item) {
                    case 23199:
                        return new Object[]{1000, "Ruby fragments"};
                }
            } else if (shop == DIAMOND_STORE) {
                switch (item) {
                    case 23200:
                        return new Object[]{1000, "Diamond fragments"};
                }
            } else if (shop == ONYX_STORE) {
                switch (item) {
                    case 23201:
                        return new Object[]{1000, "Onyx fragments"};
                }
            } else if (shop == ZENYTE_STORE) {
                switch (item) {
                    case 23201:
                        return new Object[]{1000, "Zenyte fragments"};
                }
            } else if (shop == HIGH_TIER_STORE) {
                switch (item) {
                    case 9084:
                    case 9080:
                    case 9081:
                    case 9082:
                        return new Object[]{20, "Premium Tickets"};
                    case 12630:
                        return new Object[]{75, "Premium Tickets"};
                    case 20591:
                        return new Object[]{90, "Premium Tickets"};
                    case 9083:
                        return new Object[]{100, "Premium Tickets"};
                    case 20400:
                        return new Object[]{200, "Premium Tickets"};
                    case 7995:
                        return new Object[]{350, "Premium Tickets"};
                    case 23231:
                    case 23232:
                    case 23230:
                    case 22110:
                        return new Object[]{400, "Premium Tickets"};
                    case 23254:
                    case 4442:
                        return new Object[]{725, "Premium Tickets"};
                }
            } else if (shop == EASTER_STORE_2) {
                switch (item) {
                    case 23003:
                        return new Object[]{118, "Levincia tokens"};
                }
            } else if (shop == DUNGEONEERING_STORE_NEW) {
                switch (item) {
                    case 23146:
                    case 23145:
                    case 23144:
                        return new Object[]{250000, "Dungeoneering Tokens"};
                }
            } else if (shop == KOL_STORE) {
                switch (item) {
                    case 23134:
                    case 23135:
                    case 23136:
                        return new Object[]{1500, "Light tickets"};
                    case 23137:
                    case 23138:
                        return new Object[]{750, "Light tickets"};
                }
            } else if (shop == TOKKUL_EXCHANGE_STORE) {
                switch (item) {
                    case 11978:
                        return new Object[]{300000, "tokkul"};
                    case 438:
                    case 436:
                        return new Object[]{10, "tokkul"};
                    case 440:
                        return new Object[]{25, "tokkul"};
                    case 453:
                        return new Object[]{30, "tokkul"};
                    case 442:
                        return new Object[]{30, "tokkul"};
                    case 444:
                        return new Object[]{40, "tokkul"};
                    case 447:
                        return new Object[]{70, "tokkul"};
                    case 449:
                        return new Object[]{120, "tokkul"};
                    case 451:
                        return new Object[]{250, "tokkul"};
                    case 1623:
                        return new Object[]{20, "tokkul"};
                    case 1621:
                        return new Object[]{40, "tokkul"};
                    case 1619:
                        return new Object[]{70, "tokkul"};
                    case 1617:
                        return new Object[]{150, "tokkul"};
                    case 1631:
                        return new Object[]{1600, "tokkul"};
                    case 6571:
                        return new Object[]{50000, "tokkul"};
                    case 11128:
                        return new Object[]{22000, "tokkul"};
                    case 6522:
                        return new Object[]{20, "tokkul"};
                    case 6524:
                    case 6523:
                    case 6526:
                        return new Object[]{5000, "tokkul"};
                    case 6528:
                    case 6568:
                        return new Object[]{800, "tokkul"};
                }
            } else if (shop == AFK) {
                switch (item) {
                    case 7587:
                        return new Object[]{100000, "AFK tickets"};
                    case 455:
                        return new Object[]{25000, "AFK tickets"};
                    case 18417:
                        return new Object[]{500000, "AFK tickets"};
                    case 13281:
                        return new Object[]{10, "AFK tickets"};
                    case 20481:
                        return new Object[]{10000, "AFK tickets"};

                    case 13172:
                    case 13169:
                    case 9920:
                    case 19278:
                    case 10721:
                    case 14825:
                    case 14826:
                    case 14824:
                        return new Object[]{175000, "AFK tickets"};
                    case 19812:
                        return new Object[]{250000, "AFK tickets"};
                    case 18719:
                    case 19753:
                        return new Object[]{250000, "AFK tickets"};
                    case 18415:
                    case 18416:
                    case 18418:
                        return new Object[]{1250000, "AFK tickets"};
                    case 463:
                        return new Object[]{2000000, "AFK tickets"};
                    case 20511:
                    case 14068:
                    case 14069:
                    case 14070:
                    case 14071:
                    case 14072:
                    case 14073:
                        return new Object[]{500000, "AFK tickets"};
                    case 15915:
                    case 16014:
                    case 15926:
                        return new Object[]{5000000, "AFK ticket"};
                    case 20488:
                        return new Object[]{150000, "AFK ticket"};

                    case 10946:
                        return new Object[]{150000, "AFK ticket"};
                }
            } else if (shop == PVM) {
                switch (item) {
                    case 8323:
                    case 8324:
                    case 8325:
                    case 8326:
                    case 8327:
                    case 8328:
                    case 8330:
                    case 8331:
                    case 8332:
                        return new Object[]{50000, "PVM tickets"};
                    case 22084:
                    case 22083:
                    case 22092:
                        return new Object[]{60000, "PVM tickets"};
                    case 15332:
                        return new Object[]{2000, "PVM tickets"};
                    case 2023:
                        return new Object[]{100, "PVM tickets"};
                    case 11314:
                        return new Object[]{2500000, "PVM tickets"};
                    case 18350:
                    case 18352:
                    case 18354:
                    case 18356:
                    case 18358:
                    case 18360:
                    case 11235:

                    case 15289:
                        return new Object[]{22000, "PVM tickets"};
                    case 15288:
                        return new Object[]{85000, "PVM tickets"};
                    case 15330:
                        return new Object[]{10_000_000, "PVM tickets"};
                    case 11137:
                        return new Object[]{15000, "PVM tickets"};
                    case 10947:
                        return new Object[]{40000, "PVM tickets"};
                    case 11236:
                        return new Object[]{750, "PVM tickets"};
                    case 15486:
                    case 15487:
                    case 4151:
                    case 4152:
                        return new Object[]{1500, "PVM tickets"};
                    case 15290:
                        return new Object[]{5000, "PVM tickets"};
                    case 3324:
                        return new Object[]{7000, "PVM tickets"};
                    case 22077:
                        return new Object[]{8000, "PVM tickets"};
                    case 20553:
                    case 20555:
                    case 20554:

                        return new Object[]{12500, "PVM tickets"};
                    case 19959:
                    case 19958:
                    case 19957:
                        return new Object[]{45000, "PVM tickets"};

                }
            } else if (shop == TRAIN_MELEE) {
                switch (item) {
                    case ItemDefinition.MILL_ID:
                        return new Object[]{1, "Warrior ticket"};
                    case 5022:
                        return new Object[]{1, "Warrior ticket"};
                    case 537:
                        return new Object[]{2, "Warrior ticket"};
                    case 4882:
                    case 4894:
                    case 4900:
                    case 4888:
                    case 20456:
                    case 20460:
                    case 18747:

                        return new Object[]{25, "Warrior tickets"};
                    case 4151:
                    case 10350:
                    case 10348:
                    case 10346:
                    case 12933:
                    case 18353:
                        return new Object[]{55, "Warrior tickets"};
                    case 14910:
                    case 14911:
                    case 14912:
                        return new Object[]{280, "Warrior tickets"};
                    case 14913:
                    case 14914:
                        return new Object[]{250, "Warrior tickets"};
                    case 14915:
                        return new Object[]{325, "Warrior tickets"};
                    case 15289:
                        return new Object[]{7000, "Warrior tickets"};

                }
            } else if (shop == TRAIN_RANGED) {
                switch (item) {
                    case ItemDefinition.MILL_ID:
                        return new Object[]{1, "Archer ticket"};
                    case 5022:
                        return new Object[]{1, "Archer ticket"};
                    case 537:
                        return new Object[]{2, "Archer ticket"};
                    case 17043:
                    case 17175:
                    case 17321:
                    case 18332:
                    case 10696:
                    case 15026:
                    case 18747:

                        return new Object[]{25, "Archer tickets"};
                    case 11235:
                    case 3751:
                    case 17193:
                    case 17339:
                    case 15031:
                    case 6585:
                        return new Object[]{55, "Archer tickets"};
                    case 14916:
                    case 14917:
                    case 14918:
                        return new Object[]{280, "Archer tickets"};

                    case 14919:
                        return new Object[]{325, "Archer tickets"};

                    case 14920:
                        return new Object[]{260, "Archer tickets"};

                    case 15289:
                        return new Object[]{7000, "Archer tickets"};

                }
            } else if (shop == TRAIN_MAGIC) {
                switch (item) {
                    case ItemDefinition.MILL_ID:
                        return new Object[]{1, "Wizard ticket"};
                    case 5022:
                        return new Object[]{1, "Wizard ticket"};
                    case 537:
                        return new Object[]{2, "Wizard ticket"};
                    case 14733:
                    case 14732:
                    case 14734:
                    case 14377:
                    case 10865:
                    case 12864:
                        //case 18747:

                        return new Object[]{25, "Wizard tickets"};
                    case 15486:
                    case 14499:
                    case 14497:
                    case 14501:
                    case 6737:
                    case 7462:
                        return new Object[]{55, "Wizard tickets"};
                    case 14921:
                    case 14922:
                    case 14923:
                        return new Object[]{280, "Wizard tickets"};
                    case 14924:
                    case 14925:
                        return new Object[]{325, "Wizard tickets"};
                    case 15289:

                        return new Object[]{7000, "Wizard tickets"};

                }
            } else if (shop == SHILLINGS) {
                switch (item) {
                    case 12845:
                        return new Object[]{500, "Pebbles"};
                    case 5154:
                        return new Object[]{26000, "Pebbles"};
                    case 5155:
                        return new Object[]{260000, "Pebbles"};
                    case 5156:
                        return new Object[]{2600000, "Pebbles"};
                    case 19123:
                        return new Object[]{55000, "Pebbles"};
                    case 16043:
                    case 20118:
                        return new Object[]{10000, "Pebbles"};
                    case 19135:
                        return new Object[]{70000, "Pebbles"};
                    case 19164:
                    case 19163:
                    case 19161:
                        return new Object[]{100000, "Pebbles"};
                    case 4401:
                        return new Object[]{2000000, "Pebbles"};
                    case 8830:
                        return new Object[]{20000000, "Pebbles"};
                    case 8831:
                        return new Object[]{10000000, "Pebbles"};
                    case 8833:
                    case 8834:
                    case 8835:
                        return new Object[]{50000000, "Pebbles"};

                }
            } else if (shop == DUNGEONEERING_STORE) {
                switch (item) {
                    case 18351:
                    case 18349:
                    case 18353:
                    case 18357:
                    case 18355:
                    case 18359:
                    case 18361:
                    case 18363:
                    case 6500:
                    case 18337:
                        return new Object[]{200000, "Dungeoneering tokens"};
                    case 18344:
                        return new Object[]{153000, "Dungeoneering tokens"};
                    case 18839:
                        return new Object[]{140000, "Dungeoneering tokens"};
                    case 18335:
                        return new Object[]{75000, "Dungeoneering tokens"};
                }
            } else if (shop == LOYALTY_POINT_SHOP) {
                switch (item) {
                    case 15290:
                        return new Object[] { 5000, "Loyalty Points" };
                    case 19886:
                    case 4446:
                        return new Object[] { 250000, "Loyalty Points" };
                    case 20488:
                    case 8323:
                    case 8324:
                    case 8325:
                    case 22092:
                    case 8326:
                    case 8327:
                    case 8328:
                    case 22084:
                    case 8330:
                    case 8331:
                    case 8332:
                    case 22083:
                        return new Object[] { 50000, "Loyalty Points" };
                    case 15358:
                    case 15359:
                        return new Object[] { 75000, "Loyalty Points" };
                    case 10946:
                        return new Object[] { 100000, "Loyalty Points" };
                    case 15330:
                        return new Object[] { 1000000, "Loyalty Points" };
                }
            } else if (shop == PRESTIGE_STORE) {
                switch (item) {
                    case 19333:
                        return new Object[]{20, "Prestige points"};
                    case 15220:
                    case 15020:
                    case 15019:
                    case 15018:
                        return new Object[]{20, "Prestige points"};
                    case 6927:
                    case 6928:
                    case 6929:
                    case 6930:
                    case 6931:
                    case 6932:
                    case 6933:
                    case 6934:
                    case 6935:
                        return new Object[]{25, "Prestige points"};
                    case 8326:
                    case 8327:
                    case 8328:
                    case 8330:
                    case 8331:
                    case 8332:
                    case 8323:
                    case 8324:
                    case 8325:
                        return new Object[]{150, "Prestige points"};
                    case 20000:
                    case 20001:
                    case 20002:
                        return new Object[]{50, "Prestige points"};
                    case 4084:
                        return new Object[]{170, "Prestige points"};
                    case 13857:
                    case 13855:
                    case 13848:
                    case 13856:
                    case 13854:
                    case 13853:
                    case 13852:
                    case 13851:
                    case 13850:
                    case 13849:
                        return new Object[]{5, "Prestige points"};
                    case 10400:
                    case 10402:
                    case 10416:
                    case 10418:
                    case 10408:
                    case 10410:
                    case 10412:
                    case 10414:
                    case 10404:
                    case 10406:
                        return new Object[]{2, "Prestige points"};
                    case 14595:
                    case 14603:
                        return new Object[]{5, "Prestige points"};
                    case 14602:
                    case 14605:
                        return new Object[]{3, "Prestige points"};
                    case 22052:
                        return new Object[]{75, "Prestige points"};
                }
            }  else if (shop == SLAYER_SHOP) {
                switch (item) {
                    case 4155:
                    case 13281:
                        return new Object[] { 1, "Slayer points" };
                    case 14819:
                        return new Object[] { 200, "Slayer points" };
                    case 21219:
                    case 21218:
                        return new Object[] { 20, "Slayer points" };
                    case 21220:
                        return new Object[] { 15, "Slayer points" };
                    case 4446:
                    case 19886:
                        return new Object[] { 750, "Slayer points" };
                    case 4151:
                    case 15486:
                    case 11235:
                    case 7120:
                        return new Object[] { 10, "Slayer points" };

                    case 8323:
                    case 8324:
                    case 8325:
                    case 8326:
                    case 8327:
                    case 8328:
                    case 8330:
                    case 8331:
                    case 8332:
                    case 22123:
                        return new Object[] { 50, "Slayer points" };
                    case 3737:
                    case 3738:
                    case 3739:
                        return new Object[] { 600, "Slayer points" };
                    case 21221:
                    case 21222:
                    case 21223:
                    case 23499:
                    case 23498:
                    case 23497:
                        return new Object[] { 1500, "Slayer points" };
                }
            } else if (shop == BARROWS_STORE) {
                switch (item) {
                    case 10350:
                    case 4718:
                    case 10348:
                    case 10346:
                        return new Object[]{110, "Barrows points"};
                    case 4753:
                    case 3751:
                    case 4724:
                    case 14499:
                        return new Object[]{80, "Barrows points"};
                    case 4755:
                    case 4747:
                    case 4726:
                    case 4734:
                    case 4710:
                    case 4745:
                        return new Object[]{90, "Barrows points"};
                    case 4757:
                    case 4749:
                    case 4728:
                    case 17193:
                    case 14497:
                    case 4759:
                    case 4751:
                    case 4730:
                    case 17339:
                    case 14501:
                        return new Object[]{100, "Barrows points"};
                }
            } else if (shop == MEMBERS_STORE_I) {
                switch (item) {

                    case 15330:// infinite overload
                        return new Object[] { 50, "Donation Points @bla@- <shad=1>@red@Boosts stats to +165" };
                    case 15288: // 100k orb pack
                        return new Object[] { 1, "Donation Points @bla@- <shad=1>@red@this box contains 100,000 Levincia tokens" };
                    case 4446: // collector ring
                    case 19886: // collector necklace
                        return new Object[] { 5, "Donation Points @bla@- <shad=1>@red@loots drops automatically" };
                    case 1486: // Creeper cape
                        return new Object[] { 15, "Donation Points @bla@- <shad=1>@red@Infinite Soulsplit effect" };
                    case 15355: // 1H DR Scroll
                    case 15356: // 1H 1.5X Scroll
                    case 15357: // 1H DMG Scroll
                        return new Object[] { 3, "Donation Points @bla@- <shad=1>@red@60 minutes of power" };
                    case 8087: //dragon rider lance
                        return new Object[] { 25, "Donation Points @bla@- <shad=1>@red@Strong Melee Weapon" };
                    case 8089: //purifier staff
                        return new Object[] { 25, "Donation Points  @bla@- <shad=1>@red@Strong Magic Weapon" };
                    case 8088: //crossbow
                        return new Object[] { 25, "Donation Points  @bla@- <shad=1>@red@Strong Range Weapon" };
                    case 3739: //aoe weapon
                        return new Object[] { 15, "Donation Points @bla@- <shad=1>@red@AOE Magic Weapon" };
                    case 3738: //aoe weapon
                        return new Object[] { 15, "Donation Points  @bla@- <shad=1>@red@AOE Range Weapon" };
                    case 3737: //aoe weapon
                        return new Object[] { 15, "Donation Points  @bla@- <shad=1>@red@AOE Melee Weapon" };
                    case 22166: //chance scroll
                        return new Object[] { 15, "Donation Points  @bla@- <shad=1>@red@Increases upgrade success rate" };
                    case 4186: //case key
                        return new Object[] { 15, "Donation Points  @bla@- <shad=1>@red@Used to open Cases" };
                    case 10830: //Diminished key
                        return new Object[] { 10, "Donation Points  @bla@- <shad=1>@red@Used to open the Diminshed chest" };
                    case 23401: //scroll of insurance
                        return new Object[] { 15, "Donation Points  @bla@- <shad=1>@red@Chance to keep boxes/caskets" };
                    case 11319: // Goku
                        return new Object[] { 50, "Donation Points @bla@- <shad=1>@red@50% DR pet" };
                    case 11314: // Raichu
                        return new Object[] { 75, "Donation Points @bla@- <shad=1>@red@X2 KC pet" };
                    case 20591: // Madman cape
                        return new Object[] { 225, "Donation Points @bla@- <shad=1>@red@+10K All stats & 25% DR" };
                    case 12630: // Donators Aura
                        return new Object[] { 200, "Donation Points @bla@- <shad=1>@red@+5K All stats & 25% DR" };
                    case 9084: // Collectors Attachment
                        return new Object[] { 50, "Donation Points @bla@- <shad=1>@red@Use on  Collector II items" };
                    case 9083: // Rage Attachment
                        return new Object[] { 250, "Donation Points @bla@- <shad=1>@red@Use on Madman cape" };
                    case 22110: // Owners Attachment
                        return new Object[] { 750, "Donation Points @bla@- <shad=1>@red@Used to upgrade Owner items" };
                    case 15004: // Exclusive casket
                        return new Object[] { 75, "Donation Points" };
                    case 14999: // Legendary casket
                        return new Object[] { 150, "Donation Points" };
                    case 23253: // Supreme casket
                        return new Object[] { 250, "Donation Points" };
                    case 18404: // Raids box
                        return new Object[] { 5, "Donation Points" };
                    case 3578: // Owner cape goodiebag
                    case 23240: // Owner jewelry goodiebag
                        return new Object[] { 150, "Donation Points" };
                }
            } else if (shop == MEMBERS_STORE_II) {
                switch (item) {
                    case 12926:
                    case 22008:
                    case 12931:
                        return new Object[]{10, "Member Points"};
                    case 18744:
                    case 18745:
                    case 18746:
                        return new Object[]{15, "Member Points"};
                    case 1048:
                    case 1046:
                    case 1042:
                    case 1038:
                    case 1044:
                    case 1040:
                        return new Object[]{30, "Member Points"};
                    case 18405:
                    case 18406:
                    case 18407:
                    case 18408:
                    case 18409:
                    case 18410:
                    case 18411:
                    case 18412:
                    case 18413:
                    case 18414:
                    case 18415:
                    case 18416:
                    case 18417:
                    case 18418:
                    case 18419:
                        return new Object[]{35, "Member Points"};
                    case 962:
                        return new Object[]{100, "Member Points"};
                    case 1055:
                    case 1053:
                    case 1057:
                    case 19293:
                        return new Object[]{25, "Member Points"};
                    case 1050:
                    case 10284:
                        return new Object[]{60, "Member Points"};
                    case 13744:
                    case 13738:
                        return new Object[]{20, "Member Points"};
                    case 2572:
                        return new Object[]{25, "Member Points"};
                    case 12601:
                    case 12603:
                    case 12605:
                        return new Object[]{10, "Member Points"};
                    case 15018:
                    case 15019:
                    case 15020:
                    case 15220:
                        return new Object[]{5, "Member Points"};
                    case 20080:
                    case 15441:
                    case 15442:
                    case 15443:
                    case 15444:
                        return new Object[]{5, "Member Points"};
                    case 20000:
                    case 20001:
                    case 20002:
                        return new Object[]{10, "Member Points"};
                    case 11995:
                    case 11996:
                    case 11997:
                    case 12001:
                    case 12002:
                    case 11991:
                    case 11992:
                    case 11987:
                    case 11989:
                    case 12004:
                        return new Object[]{10, "Member Points"};
                    case 13740:
                        return new Object[]{75, "Member Points"};
                    case 11858:
                    case 11860:
                    case 11862:
                    case 19580:
                        return new Object[]{40, "Member Points"};
                    case 13742:
                        return new Object[]{50, "Member Points"};
                }
            } else if (shop == DONATOR_STORE_1
                    || shop == DONATOR_STORE_2
                    || shop == DONATOR_STORE_3
                    || shop == DONATOR_STORE_4) {
                return DonatorShop.getPrice(item);
            }else if (shop == PET_STORE_1
                    || shop == PET_STORE_2
                    || shop == PET_STORE_3
                    || shop == PET_STORE_4) {
                return PetShop.getPrice(item);
            }
            return null;
        }
    }
}
