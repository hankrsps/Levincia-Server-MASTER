package com.ruse.world.content.upgrading;

import com.ruse.model.Item;
import com.ruse.model.PlayerRights;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;
import mysql.impl.Store;

public class MaxUpgradesInterface {

    private Player player;

    public MaxUpgradesInterface(Player player) {
        this.player = player;
    }

    enum CustomCombinerData {
    	//ROW 1
    	ELITE_MELEE_WEAPON(100,new Item(8410, 1), new Item(12855, 3000000), new Item(8087, 1),new Item(4151, 1), new Item(18686, 1),new Item(22077, 1), new Item(20549, 1), new Item(22084, 1), new Item(18750, 1)),
        ELITE_MELEE_HELM(100, new Item(8828, 1), new Item(12855, 2000000), new Item(11320, 1),new Item(8810, 1), new Item(11140, 1),new Item(5022, 40000), new Item(6927, 1)),
        ELITE_MELEE_BODY(100, new Item(8829, 1), new Item(12855, 2000000), new Item(11321, 1), new Item(19749, 1), new Item(8335, 1),new Item(5022, 40000), new Item(6928, 1)),
        ELITE_MELEE_LEGS(100, new Item(8833, 1), new Item(12855, 2000000), new Item(11322, 1), new Item(22080, 1), new Item(19114, 2),new Item(5022, 40000), new Item(6929, 1)),
        EXCECUTION_HELMET(100, new Item(4684, 1), new Item(12855, 3000000), new Item(8828, 1), new Item(15642, 1),new Item(15645, 1), new Item(10947, 1)),
        SUPREME_GLOVES(100, new Item(18883, 1),new Item(5071, 1),new Item(14063, 1), new Item(10947, 1), new Item(12855, 4_000_000), new Item(5022, 1_000_000)),
        //ROW 2
        ELITE_RANGED_WEAPON(100, new Item(8411, 1), new Item(12855, 3000000), new Item(8088, 1),  new Item(11235, 1), new Item(18799, 1),new Item(19136, 1), new Item(20173, 1), new Item(22083, 1), new Item(18636, 1)),
        ELITE_RANGED_HELM(100, new Item(15642, 1), new Item(12855, 2000000), new Item(11340, 1), new Item(8811, 1), new Item(8334, 1),new Item(5022, 40000), new Item(6930, 1)),
        ELITE_RANGED_BODY(100, new Item(15643, 1), new Item(12855, 2000000), new Item(11341, 1), new Item(11195, 1), new Item(16137, 1),new Item(5022, 40000), new Item(6931, 1)),
        ELITE_RANGED_LEGS(100, new Item(15644, 1), new Item(12855, 2000000), new Item(11342, 1), new Item(19115, 2), new Item(19114, 2),new Item(5022, 40000), new Item(6932, 1)),
        EXCECUTION_BODY(100, new Item(4685, 1), new Item(12855, 3000000), new Item(8829, 1), new Item(15643, 1),new Item(15646, 1), new Item(10947, 1)),
        SUPREME_BOOTS(100,new Item(18881, 1), new Item(3107, 1), new Item(5072, 1), new Item(16265, 1), new Item(10947, 1), new Item(12855, 4_000_000)),
        //ROW 3
    	ELITE_MAGE_WEAPON(100, new Item(8412, 1), new Item(12855, 3000000), new Item(8089, 1), new Item(15486, 1), new Item(5095, 1),new Item(6936, 1), new Item(8809, 1), new Item(22092, 1), new Item(18629, 1)),
        ELITE_MAGE_HELM(100, new Item(15645, 1), new Item(12855, 2000000), new Item(11421, 1),  new Item(8812, 1), new Item(4367, 1),new Item(5022, 40000), new Item(6933, 1)),
        ELITE_MAGE_BODY(100, new Item(15646, 1), new Item(12855, 2000000), new Item(11422, 1),  new Item(19115, 2), new Item(19892, 1),new Item(5022, 40000), new Item(6934, 1)),
        ELITE_MAGE_LEGS(100, new Item(15647, 1), new Item(12855, 2000000), new Item(11423, 1),  new Item(15401, 1), new Item(8329, 1),new Item(5022, 40000), new Item(6935, 1)),
        EXCECUTION_LEGS(100, new Item(4686, 1), new Item(12855, 3000000), new Item(8833, 1), new Item(15644, 1),new Item(15647, 1), new Item(10947, 1)),
        SUPREME_SHIELD(100,new Item(19810, 1), new Item(15832, 1), new Item(17702, 1), new Item(7544, 1), new Item(10947, 1), new Item(12855, 5_000_000), new Item(5022, 1_000_000)),

        //ROW 4
        EXECUTION_TBOW(100,new Item(5012, 1), new Item(8411, 3), new Item(8088, 3), new Item(10947, 3), new Item(12855, 7_500_000)),
        EXECUTION_VITUR(100,new Item(12535, 1), new Item(8410, 3), new Item(8087, 3), new Item(10947, 3), new Item(12855, 7_500_000)),
        STAFF_OF_EXECUTION(100,new Item(17011, 1), new Item(8412, 3), new Item(8089, 3), new Item(10947, 3), new Item(12855, 7_500_000)),
        LIGHT_EXECUTION_TBOW(100,new Item(5011, 1),new Item(5012, 1), new Item(10949, 3)),
        LIGHT_EXECUTION_VITUR(100,new Item(12537, 1),new Item(12535, 1), new Item(10949, 3)),
        LIGHT_STAFF_OF_EXECUTION(100,new Item(17013, 1),new Item(17011, 1), new Item(10949, 3)),

        //ROW 5
        DARK_EXECUTION_TBOW(35,new Item(22113, 1),new Item(5011, 1), new Item(22112, 5), new Item(5022, 10_000_000), new Item(12855, 20_000_000)),
        DARK_EXECUTION_VITUR(35,new Item(22115, 1),new Item(12537, 1), new Item(22112, 5), new Item(5022, 10_000_000), new Item(12855, 20_000_000)),
        DARK_STAFF_OF_EXECUTION(35,new Item(22114, 1),new Item(17013, 1), new Item(22112, 5), new Item(5022, 10_000_000), new Item(12855, 20_000_000)),
        BLOOD_BOW(30,new Item(23226, 1),new Item(22113, 1),new Item(5011, 1), new Item(23239, 1), new Item(5022, 10_000_000), new Item(12855, 35_000_000)),
        BLOOD_VITUR(30,new Item(8136, 1),new Item(22115, 1),new Item(12537, 1), new Item(23239, 1), new Item(5022, 10_000_000), new Item(12855, 35_000_000)),
        BLOOD_STAFF(30,new Item(23227, 1),new Item(22114, 1),new Item(17013, 1), new Item(23239, 1), new Item(5022, 10_000_000), new Item(12855, 35_000_000)),


        //ROW 6
        LUCIFER_HEAD(100,new Item(22100, 1),new Item(4684, 1), new Item(22106, 2)),
        LUCIFER_PLATEBODY(100,new Item(22101, 1),new Item(4685, 1), new Item(22106, 2)),
        LUCIFER_PLATELEGS(100,new Item(22102, 1),new Item(4686, 1), new Item(22106, 2)),
        LUCIFER_WINGS(100,new Item(22105, 1),new Item(20400, 1), new Item(22106, 2)),
        LUCIFER_GLOVES(100,new Item(22104, 1),new Item(18885, 1), new Item(22106, 2)),
        LUCIFER_BOOTS(100,new Item(22103, 1),new Item(18887, 1), new Item(22106, 2)),

        //ROW 7
        LIGHT_ATTACHMENT(33,new Item(10949, 1),new Item(14472, 1), new Item(10947, 5), new Item(12855, 500_000)),
        DARK_ATTACHMENT(33,new Item(22112, 1),new Item(14474, 1), new Item(10947, 20), new Item(12855, 2_000_000)),
        BLOOD_ATTACHMENT(33,new Item(23239, 1),new Item(23238, 1), new Item(10947, 30), new Item(12855, 4_000_000)),
        ANGEL_PET(30,new Item(22107, 1),new Item(22106, 1), new Item(19000, 10_000), new Item(5022, 10_000_000), new Item(12855, 10_000_000)),
        OWNER__JEWELRY_GOODIEBAG(100,new Item(23240, 2),new Item(7995, 1)),
        OWNER_CAPE(25,new Item(7995, 1),new Item(22105, 1), new Item(12855, 100_000_000)),

        //ROW 8
        OWNER_AURA(100,new Item(22111, 1),new Item(22110, 1), new Item(12630, 1)),
        OWNER_AMULET(100,new Item(23233, 1),new Item(23230, 1), new Item(22110, 2)),
        OWNERS_RING(100,new Item(23234, 1),new Item(23231, 1), new Item(22110, 2)),
        OWNERS_BRACELET(100,new Item(23235, 1),new Item(23232, 1), new Item(22110, 2)),
        UPGRADED_OWNER_AURA(100,new Item(23241, 1),new Item(22110, 2), new Item(22111, 1)),
        UPGRADED_OWNER_CAPE(100,new Item(22109, 1),new Item(22110, 2), new Item(7995, 1)),

        //ROW 9
        RAGE_POTION(100,new Item(23225, 1),new Item(15330, 1),new Item(12855, 50_000_000)),
        OWNER_POTION(100,new Item(23242, 1),new Item(7995, 1),new Item(23225, 1),new Item(12855, 100_000_000)),
        EMPTY_CREST(100,new Item(782, 1),new Item(779, 1),new Item(780, 1),new Item(781, 1)),
        LIGHT_MELEE_CREST(100,new Item(23246, 1),new Item(782, 1),new Item(12537, 1)),
        LIGHT_MAGIC_CREST(100,new Item(23247, 1),new Item(782, 1),new Item(17013, 1)),
        LIGHT_RANGE_CREST(100,new Item(23248, 1),new Item(782, 1),new Item(5011, 1)),
        DARK_MELEE_CREST(100,new Item(23243, 1),new Item(782, 1),new Item(22115, 1)),
        DARK_MAGIC_CREST(100,new Item(23244, 1),new Item(782, 1),new Item(22114, 1)),
        DARK_RANGE_CREST(100,new Item(23245, 1),new Item(782, 1),new Item(22113, 1)),
        BLOOD_MELEE_CREST(100,new Item(23249, 1),new Item(782, 1),new Item(8136, 1)),
        BLOOD_MAGIC_CREST(100,new Item(23250, 1),new Item(782, 1),new Item(23227, 1)),
        BLOOD_RANGE_CREST(100,new Item(23251, 1),new Item(782, 1),new Item(23226, 1)),
        GRANDMASTER_SET(100,new Item(23509, 1),new Item(23497, 1),new Item(23498, 1),new Item(23499)),
        REAPER_SET(100,new Item(23482, 1),new Item(23259, 1),new Item(23260, 1),new Item(23261, 1),new Item(23262, 1),new Item(23263, 1)),
        EMBERKEEN_BOOTS(100,new Item(23296, 1),new Item(9687, 1),new Item(22103, 1),new Item(12855, 25_000_000)),
        FLAREFROST_BOOTS(100,new Item(23297, 1),new Item(9688, 1),new Item(22103, 1),new Item(12855, 25_000_000)),
        HAILFIRE_BOOTS(100,new Item(23298, 1),new Item(9689, 1),new Item(22103, 1),new Item(12855, 25_000_000)),
        ASSASSIN_QUIVER(100,new Item(23272, 1),new Item(23299, 1),new Item(23249, 1),new Item(23250, 1),new Item(23251, 1),new Item(12855, 50_000_000)),
        NECROMANCER_BOW(100,new Item(23228, 1),new Item(22953, 1),new Item(13653, 2500), new Item(12855, 50_000_000), new Item(5022, 20_000_000), new Item(23226,1)),
        NECROMANCER_SWORD(100,new Item(17694, 1),new Item(22952, 1),new Item(13653, 2500), new Item(12855, 50_000_000), new Item(5022, 20_000_000), new Item(8136, 1)),
        NECROMANCER_STAFF(100,new Item(23302, 1),new Item(22951, 1),new Item(13653, 2500), new Item(12855, 50_000_000), new Item(5022, 20_000_000), new Item(23227, 1)),
        NEPHILIM_BOW(100,new Item(23363, 1),new Item(23061, 1),new Item(23486, 3),new Item(5022, 25000000), new Item(12855, 100_000_000)),
        NEPHILIM_SWORD(100,new Item(23365, 1),new Item(23063, 1),new Item(23486, 3),new Item(5022, 25000000), new Item(12855, 100_000_000)),
        NEPHILIM_STAFF(100,new Item(23364, 1),new Item(23062, 1),new Item(23486, 3),new Item(5022, 25000000), new Item(12855, 100_000_000)),
        DIVINE_SET(100,new Item(23395, 1),new Item(23384, 1),new Item(23385, 1),new Item(12855, 25000000)),
        DRAGON_RIDER_SET(100,new Item(23456, 1),new Item(14050, 1),new Item(14051, 1),new Item(14052, 1),new Item(14053, 1),new Item(14055, 1),new Item(12855, 5000000)),
        CELESTIAL_AMULET(100,new Item(23293, 1),new Item(23233, 1),new Item(23273, 75000)),
        CELESTIAL_RING(100,new Item(23280, 1),new Item(23234, 1),new Item(23273, 75000)),
        CELESTIAL_BRACELET(100,new Item(23292, 1),new Item(23235, 1),new Item(23273, 75000)),
        CELESTIAL_CAPE(100,new Item(23270, 1),new Item(22109, 1),new Item(23273, 200_000)),
        CELESTIAL_AURA(100,new Item(23271, 1),new Item(23241, 1),new Item(23273, 150_000)),
        CELESTIAL_QUIVER(100,new Item(23300, 1),new Item(23272, 1),new Item(23273, 100_000)),
        CRIMSON_BOOTS(100,new Item(23760, 1),new Item(23296, 1),new Item(23297, 1), new Item(23298, 1), new Item(23759, 1000)),
        ETHEREAL_SCROLL(100,new Item(23413, 1),new Item(20421, 1),new Item(23254, 1),new Item(4442, 1),new Item(12855, 250_000_000)),
        SERAPHIC_POTION(100,new Item(11465, 1),new Item(14705, 1),new Item(23242, 1),new Item(12855, 250_000_000)),
        SUPREME_SCROLL(66,new Item(23427, 1),new Item(15378, 1),new Item(17474, 25),new Item(12855, 5_000_000)),
        CELESTIAL_HELMET(100,new Item(23443, 1),new Item(23312, 1),new Item(23315, 1),new Item(23318, 1),new Item(22950, 1),new Item(23273, 25_000)),
        CELESTIAL_BODY(100,new Item(23444, 1),new Item(23313, 1),new Item(23316, 1),new Item(23319, 1),new Item(22950, 1),new Item(23273, 25_000)),
        CELESTIAL_LEGS(100,new Item(23445, 1),new Item(23314, 1),new Item(23317, 1),new Item(23320, 1),new Item(22950, 1),new Item(23273, 25_000)),
        CELESTIAL_ATTACHMENT(100,new Item(22950, 1),new Item(10949, 10),new Item(22112, 10),new Item(23239, 10),new Item(23273, 25_000)),
      //  ELF_OUTFIT(100,new Item(17746, 1),new Item(23528, 1),new Item(23529, 1),new Item(23530, 1),new Item(23531, 1),new Item(23532, 1),new Item(23488, 2500)),


        ELIDINIS_WARD_F(100,new Item(13293, 1),new Item(13289, 1),new Item(13297, 1),new Item(18889, 1)),
        ELIDINIS_WARD_OR(100,new Item(13295, 1),new Item(13293, 1),new Item(18493, 1),new Item(12855, 15_000_000)),
        MASORI_HELMET(100,new Item(13841, 1),new Item(13273, 1),new Item(23443, 1),new Item(9083, 1),new Item(12855, 15_000_000)),
        MASORI_BODY(100,new Item(13842, 1),new Item(13274, 1),new Item(23444, 1),new Item(9083, 1),new Item(12855, 15_000_000)),
        MASORI_CHAPS(100,new Item(13843, 1),new Item(13275, 1),new Item(23445, 1),new Item(9083, 1),new Item(12855, 15_000_000)),
        OSMUMTENS_FANG(100,new Item(13664, 1),new Item(13662, 1),new Item(13597, 1),new Item(12855, 50_000_000)),
        TUMEKENS_SHADOW(100,new Item(18485, 1),new Item(18487, 1),new Item(13597, 1),new Item(12855, 50_000_000)),
        BLUE_EYES_WHITE_DRAGON(100,new Item(11426, 1),new Item(22954, 1),new Item(10483, 1),new Item(10484, 1),new Item(10485, 1),new Item(10486, 1),new Item(19000, 25_000),new Item(12855, 100_000_000)),


        DIMINISHED_HELMET(100,new Item(10823, 1),new Item(23443, 1),new Item(16465, 7500),new Item(12855, 25_000_000)),
        DIMINISHED_PLATEBODY(100,new Item(10824, 1),new Item(23444, 1),new Item(16465, 10000),new Item(12855, 50_000_000)),
        DIMINISHED_PLATELEGS(100,new Item(10825, 1),new Item(23445, 1),new Item(16465, 10000),new Item(12855, 50_000_000)),
        DIMINISHED_AMULET(100,new Item(10829, 1),new Item(23293, 1),new Item(16465, 10000),new Item(12855, 50_000_000)),
        DIMINISHED_RING(100,new Item(10827, 1),new Item(23280, 1),new Item(16465, 10000),new Item(12855, 50_000_000)),
        DIMINISHED_GLOVES(100,new Item(10795, 1),new Item(23292, 1),new Item(16465, 10000),new Item(12855, 50_000_000)),
        DIMINISHED_BOOTS(100,new Item(10793, 1),new Item(23760, 1),new Item(16465, 7500),new Item(12855, 25_000_000)),
        DIMINISHED_AURA(100,new Item(10828, 1),new Item(23271, 1),new Item(16465, 7500),new Item(12855, 25_000_000)),
        DIMINISHED_WINGS(100,new Item(10826, 1),new Item(23270, 1),new Item(16465, 15000),new Item(12855, 100_000_000)),
        ;
        CustomCombinerData(int successRate, Item reward, Item... requirements) { // Upgrade item, chance, requirements
            this.successRate = successRate;
            this.reward = reward;
            this.requirements = requirements;
        }

        private Item reward;
        private int successRate;
        private Item[] requirements;

        public int getSuccessRate() {
            if (successRate > 100)
                successRate = 100;
            return successRate;
        }
    }

    private Item selectedItem = null;

    private final CustomCombinerData[] VALUES = CustomCombinerData.values();

    public void open() {
        player.getPacketSender().sendInterface(30830);
        updateInterface();
    }

    private void updateInterface() {
        int index = 0;
        for (CustomCombinerData data : VALUES) {
            player.getPacketSender().sendItemOnInterface(30851, data.reward.getId(), index, data.reward.getAmount());
            index++;
        }
    }

    public void handleSelection(Item item) {
        selectedItem = item;

        for(CustomCombinerData data : VALUES) {
            if(data.reward.getId() == selectedItem.getId()) {
                player.getPacketSender().resetItemsOnInterface(30840, 17);
                player.getPacketSender().sendCombinerItemsOnInterface(30840, data.requirements);
                player.getPacketSender().sendItemOnInterface(30836, data.reward.getId(), 0, data.reward.getAmount());
                player.getPacketSender().sendString(77454, "Success rate: @whi@" + (getBoost (data.getSuccessRate()) == 100 ? "@gre@ " :
                        getBoost (data.getSuccessRate()) <= 99 ? "@red@ " : "@whi@ ")  + (getBoost (data.getSuccessRate()) > 100 ? "@gre@100%" :
                        Misc.formatNumber ((long) getBoost (data.getSuccessRate())) + "%" ));
                break;
            }
        }

    }

    public double getBoost(double chance){
        double percentBoost = 0D;
        if(player.getAmountDonated() >= Store.ZENYTE_DONATION_AMOUNT || player.getRights().equals(PlayerRights.YOUTUBER)) {
            percentBoost += 50;
        } else if(player.getAmountDonated() >= Store.ONYX_DONATION_AMOUNT) {
            percentBoost += 40;
        } else if(player.getAmountDonated() >= Store.DIAMOND_DONATION_AMOUNT) {
            percentBoost += 30;
        } else if(player.getAmountDonated() >= Store.RUBY_DONATION_AMOUNT) {
            percentBoost += 20;
        } else if(player.getAmountDonated() >= Store.EMERALD_DONATION_AMOUNT) {
            percentBoost += 10;
        }

        if (player.getScrollBonus() == 1)
            percentBoost +=  20;

        if (player.getScrollBonus() == 2)
            percentBoost +=  40;

        if (player.getScrollBonus() == 3)
            percentBoost +=  60;

        if (player.getScrollBonus() == 4)
            percentBoost +=  80;

        if (player.getScrollBonus() == 5)
            percentBoost +=  100;

        double multiplier = 1 + (percentBoost / 100D);

        chance *= multiplier;

        return chance;
    }

    public void combine() {
        if (selectedItem == null) {
            player.sendMessage("@red@You haven't selected an item yet.");
            return;
        }

        for (CustomCombinerData data : VALUES) {
            boolean random =  Misc.getRandomDouble(99) < getBoost(data.getSuccessRate());
            if (data.reward.getId() == selectedItem.getId()) {
                if (player.getInventory().containsAll(data.requirements)) {
                    if (random == true) {
                        player.getDailyTaskManager().submitProgressToIdentifier(32, 1);
                        if (player.getScrollBonus () > 0) {
                            player.setScrollBonus (0);
                            player.sendMessage("Your bonus upgrade % has been consumed.");
                            player.getPacketSender().sendString(77454, "Success rate: @whi@" + (getBoost (data.getSuccessRate()) == 100 ? "@gre@ " :  getBoost (data.getSuccessRate()) <= 99 ? "@red@ " : "@whi@ ")  + Misc.formatNumber ((long) getBoost (data.getSuccessRate())) + "%" );

                        }
                        player.getInventory().deleteItemSet(data.requirements);
                        player.getInventory().add(data.reward);
                        World.sendMessage("<img=5>@blu@[Max Invention]<img=5> @red@" + player.getUsername() + "@blu@ Has invented " + selectedItem.getDefinition().getName());
                    }
                    else if (!random) {
                        player.getInventory().deleteItemSet(data.requirements);
                        player.sendMessage("@red@You have failed your upgrade.");
                        if (player.getScrollBonus () > 0) {
                        }
                    }
                    } else {
                    player.sendMessage("@red@You don't have the required items for this invention.");
                }
                break;
            }
        }

    }



}
