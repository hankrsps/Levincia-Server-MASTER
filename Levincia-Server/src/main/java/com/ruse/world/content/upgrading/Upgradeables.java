package com.ruse.world.content.upgrading;

import com.ruse.model.Item;
import lombok.Getter;

import java.util.ArrayList;

import static com.ruse.world.content.upgrading.Upgradeables.UpgradeType.*;

@Getter
public enum Upgradeables {

    // Tier 1 (ONE)
    WHIP(TIER_1, new Item(4151, 1), new Item(18686, 1), 125, 60),
    D_HELMET(TIER_1, new Item(10350, 1), new Item(13996, 1), 125, 60),
    D_CHAINBODY(TIER_1, new Item(10348, 1), new Item(13913, 1), 125, 60),
    D_PLATESKIRT(TIER_1, new Item(10346, 1), new Item(13919, 1), 125, 60),
    D_BOW(TIER_1, new Item(11235, 1), new Item(18799, 1), 125, 60),
    X_HELMET(TIER_1, new Item(3751, 1), new Item(18834, 1), 125, 60),
    X_CHESTPLATE(TIER_1, new Item(17193, 1), new Item(18801, 1), 125, 60),
    X_CHAINSKIRT(TIER_1, new Item(17339, 1), new Item(18800, 1), 125, 60),
    SOL(TIER_1, new Item(15486, 1), new Item(5095, 1), 125, 60),
    A_HELM(TIER_1, new Item(14499, 1), new Item(19140, 1), 125, 60),
    A_BODY(TIER_1, new Item(14497, 1), new Item(19139, 1), 125, 60),
    A_LEGS(TIER_1, new Item(14501, 1), new Item(19138, 1), 125, 60),
    FIRECAPE(TIER_1, new Item(6570, 1), new Item(4411, 1), 125, 60),
    DEFENDER(TIER_1, new Item(12933, 1), new Item(19887, 1), 125, 60),
    CMAUL(TIER_1, new Item(18353, 1), new Item(22078, 1), 125, 60),
    DBOOTS(TIER_1, new Item(15031, 1), new Item(19123, 1), 125, 60),
    FURY(TIER_1, new Item(6585, 1), new Item(11617, 1), 125, 60),
    BRING(TIER_1, new Item(6737, 1), new Item(3909, 1), 125, 60),
    GLOVES(TIER_1, new Item(7462, 1), new Item(3318, 1), 125, 60),
    T1_AURA(TIER_1, new Item(23044, 1), new Item(23045, 1), 100_000, 80),
    SLAYER_BOX(TIER_1, new Item(7120, 1), new Item(22123, 1), 5_000, 20),
    PBOX(TIER_1, new Item(7956, 1), new Item(22214, 1), 125, 60),
    // END TIER 1 (ONE)

    // TIER 2 (TW0)
    TORMENTED_WHIP(TIER_2, new Item(18686, 1), new Item(22077, 1), 250, 50),
    G_HELMET(TIER_2, new Item(13996, 1), new Item(6927, 1), 250, 50),
    G_CHAINBODY(TIER_2, new Item(13913, 1), new Item(6928, 1), 250, 50),
    G_PLATESKIRT(TIER_2, new Item(13919, 1), new Item(6929, 1), 250, 50),
    K_CBOW(TIER_2, new Item(18799, 1), new Item(19136, 1), 250, 50),
    K_HELMET(TIER_2, new Item(18834, 1), new Item(6930, 1), 250, 50),
    K_CHESTPLATE(TIER_2, new Item(18801, 1), new Item(6931, 1), 250, 50),
    K_CHAINSKIRT(TIER_2, new Item(18800, 1), new Item(6932, 1), 250, 50),
    SHETANI_STAFF(TIER_2, new Item(5095, 1), new Item(6936, 1), 250, 50),
    M_HELM(TIER_2, new Item(19140, 1), new Item(6933, 1), 250, 50),
    M_BODY(TIER_2, new Item(19139, 1), new Item(6934, 1), 250, 50),
    M_LEGS(TIER_2, new Item(19138, 1), new Item(6935, 1), 250, 50),
    DEVILWINGS(TIER_2, new Item(4411, 1), new Item(12634, 1), 250, 50),
    DEVILNECK(TIER_2, new Item(19887, 1), new Item(17291, 1), 250, 50),
    DEMONMAUL(TIER_2, new Item(22078, 1), new Item(22079, 1), 250, 50),
    UNIVERSAL_BOOTS(TIER_2, new Item(19123, 1), new Item(6937, 1), 250, 50),
    FURYZ(TIER_2, new Item(11617, 1), new Item(15418, 1), 250, 50),
    RINGZ(TIER_2, new Item(3909, 1), new Item(3324, 1), 250, 50),
    BOSSGLOVES(TIER_2, new Item(3318, 1), new Item(3905, 1), 250, 50),
    T2_AURA(TIER_2, new Item(23045, 1), new Item(23046, 1), 400_000, 70),
    //END TIER 2

    /// TIER 3 (THREE)
    BRUTAL_WHIP1(TIER_3, new Item(22077, 1), new Item(20549, 1), 500, 40),
    TORVA_HELMET(TIER_3, new Item(6927, 1), new Item(8800, 1), 500, 40),
    TORVA_CHAINBODY(TIER_3, new Item(6928, 1), new Item(8801, 1), 500, 40),
    TORVA_PLATESKIRT(TIER_3, new Item(6929, 1), new Item(8802, 1), 500, 40),
    VIXIE_BOW(TIER_3, new Item(19136, 1), new Item(20173, 1), 500, 40),
    PERNIX_COWL(TIER_3, new Item(6930, 1), new Item(8803, 1), 500, 40),
    PERNIX_CHAINBODY(TIER_3, new Item(6931, 1), new Item(8804, 1), 500, 40),
    PERNIX_PLATESKIRT(TIER_3, new Item(6932, 1), new Item(8805, 1), 500, 40),
    VIXIE_STAFF(TIER_3, new Item(6936, 1), new Item(8809, 1), 500, 40),
    VIRTUS_MASK(TIER_3, new Item(6933, 1), new Item(8806, 1), 500, 40),
    VIRTUS_BODY(TIER_3, new Item(6934, 1), new Item(8807, 1), 500, 40),
    VIRTUS_LEGS(TIER_3, new Item(6935, 1), new Item(8808, 1), 500, 40),
    INFERNOWINGS(TIER_3, new Item(12634, 1), new Item(8810, 1), 500, 40),
    NECKLACE(TIER_3, new Item(17291, 1), new Item(19749, 1), 500, 40),
    ANKOUMAUL(TIER_3, new Item(22079, 1), new Item(22080, 1), 500, 40),
    VIXIEBOOTS(TIER_3, new Item(6937, 1), new Item(8811, 1), 500, 40),
    ICEFURY(TIER_3, new Item(15418, 1), new Item(11195, 1), 500, 40),
    RINGII(TIER_3, new Item(3324, 1), new Item(15401, 1), 500, 40),
    BOSSGLOVES2(TIER_3, new Item(3905, 1), new Item(8812, 1), 500, 40),
    T3_AURA(TIER_3, new Item(23046, 1), new Item(23047, 1), 1_000_000, 60),
    //END TIER 3 (THREE)

    //START TIER 4 (FOUR)
    T3_MELEE_WHIP(TIER_4, new Item(20549, 1), new Item(22084, 1), 4200, 30),
    T3_MBHELM(TIER_4, new Item(8800, 1), new Item(8326, 1), 4200, 30),
    T3_MBODY(TIER_4, new Item(8801, 1), new Item(8327, 1), 4200, 30),
    T3_MLEGS(TIER_4, new Item(8802, 1), new Item(8328, 1), 4200, 30),
    T3_BOW(TIER_4, new Item(20173, 1), new Item(22083, 1), 4200, 30),
    T3_RCOWL(TIER_4, new Item(8803, 1), new Item(8330, 1), 4200, 30),
    T3_RBODY(TIER_4, new Item(8804, 1), new Item(8331, 1), 4200, 30),
    T3_RLEGS(TIER_4, new Item(8805, 1), new Item(8332, 1), 4200, 30),
    T3_STAFF(TIER_4, new Item(8809, 1), new Item(22092, 1), 4200, 30),
    T3_VMASK(TIER_4, new Item(8806, 1), new Item(8323, 1), 4200, 30),
    T3_VBODY(TIER_4, new Item(8807, 1), new Item(8324, 1), 4200, 30),
    T3_VLEGS(TIER_4, new Item(8808, 1), new Item(8325, 1), 4200, 30),
    WING(TIER_4, new Item(8810, 1), new Item(4367, 1), 4200, 30),
    DEFENDER3(TIER_4, new Item(19749, 1), new Item(8329, 1), 4200, 30),
    BIGMAUL(TIER_4, new Item(22080, 1), new Item(16137, 1), 4200, 30),
    BOOOTS(TIER_4, new Item(8811, 1), new Item(8334, 1), 4200, 30),
    AMULET(TIER_4, new Item(11195, 1), new Item(19892, 1), 4200, 30),
    RING2(TIER_4, new Item(15401, 1), new Item(8335, 1), 4200, 30),
    GLOVES2(TIER_4, new Item(8812, 1), new Item(11140, 1), 4200, 30),
    T4_AURA(TIER_4, new Item(23047, 1), new Item(23048, 1), 2_000_000, 30),
    //END TIER 4 (FOUR)

    //START TIER 5 (FIVE)
    TRINITY(TIER_5, new Item(22084, 1), new Item(18750, 1), 5000, 20),
    MELEE_HELM(TIER_5, new Item(8326, 1), new Item(18753, 1), 5000, 20),
    MELEE_BODY(TIER_5, new Item(8327, 1), new Item(18752, 1), 5000, 20),
    MELEE_LEGS(TIER_5, new Item(8328, 1), new Item(18751, 1), 5000, 20),
    BLASTBOMB(TIER_5, new Item(22083, 1), new Item(18636, 1), 5000, 20),
    RANGE_HELM(TIER_5, new Item(8330, 1), new Item(18749, 1), 5000, 20),
    RANGE_BODY(TIER_5, new Item(8331, 1), new Item(18748, 1), 5000, 20),
    RANGE_LEGS(TIER_5, new Item(8332, 1), new Item(18638, 1), 5000, 20),
    ARTS_STAFF(TIER_5, new Item(22092, 1), new Item(18629, 1), 5000, 20),
    MAGE_HELM(TIER_5, new Item(8323, 1), new Item(18631, 1), 5000, 20),
    MAGE_BODY(TIER_5, new Item(8324, 1), new Item(18637, 1), 5000, 20),
    MAGE_LEGS(TIER_5, new Item(8325, 1), new Item(18623, 1), 5000, 20),
    ARTDEF(TIER_5, new Item(8329, 1), new Item(17700, 1), 5000, 20),
    ARTSWORD(TIER_5, new Item(16137, 1), new Item(23376, 1), 5000, 20),
    T5_AURA(TIER_5, new Item(23048, 1), new Item(23049, 1), 4_000_000, 40),
    //END TIER 5 (FIVE)

    //START TIER 6 (SIX)
    MAX_MELEE_WEAPON(TIER_6, new Item(18750, 1), new Item(8087, 1), 35000, 22),
    MAX_MELEE_HELM(TIER_6, new Item(18753, 1), new Item(11320, 1), 35000, 25),
    MAX_MELEE_BODY(TIER_6, new Item(18752, 1), new Item(11321, 1), 35000, 25),
    MAX_MELEE_LEGS(TIER_6, new Item(18751, 1), new Item(11322, 1), 35000, 25),
    MAX_RANGE_CBOW(TIER_6, new Item(18636, 1), new Item(8088, 1), 35000, 22),
    MAX_RANGE_HELM(TIER_6, new Item(18749, 1), new Item(11340, 1), 35000, 25),
    MAX_RANGE_BODY(TIER_6, new Item(18748, 1), new Item(11341, 1), 35000, 25),
    MAX_RANGE_LEGS(TIER_6, new Item(18638, 1), new Item(11342, 1), 35000, 25),
    MAX_MAGE_STAFF(TIER_6, new Item(18629, 1), new Item(8089, 1), 35000, 22),
    MAX_MAGE_HELM(TIER_6, new Item(18631, 1), new Item(11421, 1), 35000, 25),
    MAX_MAGE_BODY(TIER_6, new Item(18637, 1), new Item(11422, 1), 35000, 25),
    MAX_MAGE_LEGS(TIER_6, new Item(18623, 1), new Item(11423, 1), 35000, 25),
    COLLECTOR_NECK(TIER_6, new Item(19886, 1), new Item(19888, 1), 35000, 25),
    COLLECTOR_RING(TIER_6, new Item(4446, 1), new Item(18823, 1), 35000, 25),
    T6_AURA(TIER_6, new Item(23049, 1), new Item(12630, 1), 10_000_000, 30),
    INSTANCE_TOKEN(TIER_6, new Item(4278, 1), new Item(23264, 1), 2500, 25),
    XP_LAMP(TIER_6, new Item(11137, 1), new Item(21218, 1), 10_000, 20),
    CREEPER_CAPE(TIER_6, new Item(1486, 1), new Item(23133, 1), 1_000_000, 20),

    RUBY_CASKET(TIER_6, new Item(15003, 1), new Item(15002, 1), 2000000, 100),
    DIAMOND_CASKET(TIER_6, new Item(15002, 2), new Item(15004, 1), 0, 100),
    ONYX_CASKET(TIER_6, new Item(15004, 2), new Item(14999, 1), 0,100),
    ZENYTE_CASKET(TIER_6, new Item(14999, 2), new Item(23253, 1), 0,100),
    //END TIER 6 (SIX)

    ;

    private UpgradeType type;
    private Item required, reward;
    private int cost, successRate;
    private boolean rare;

    Upgradeables(UpgradeType type, Item required, Item reward, int cost, int successRate, boolean rare) {
        this.type = type;
        this.required = required;
        this.reward = reward;
        this.cost = cost;
        this.successRate = successRate;
        this.rare = rare;
    }

    Upgradeables(UpgradeType type, Item required, Item reward, int cost, int successRate) {
        this.type = type;
        this.required = required;
        this.reward = reward;
        this.cost = cost;
        this.successRate = successRate;
        this.rare = false;
    }
    
    public static ArrayList<Upgradeables> getForType(UpgradeType type){
        ArrayList<Upgradeables> upgradeablesArrayList = new ArrayList<>();
        for (Upgradeables upgradeables : values()){
            if (upgradeables.getType() == type){
                upgradeablesArrayList.add(upgradeables);
            }
        }
        return upgradeablesArrayList;
    }
    

    public enum UpgradeType{

        TIER_1, TIER_2, TIER_3, TIER_4, TIER_5, TIER_6, MAX;

    }


}
