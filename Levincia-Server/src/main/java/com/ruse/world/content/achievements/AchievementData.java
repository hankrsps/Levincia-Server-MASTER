package com.ruse.world.content.achievements;

import com.ruse.model.Item;
import org.apache.commons.lang3.text.WordUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Project Levincia
 * Author @Levincia (AlwaysDreaming.ai@gmail.com)
 * Created on - 6/14/2022
 */
//i replaced the achievements since then so where is it? this is the new ones where do u complete it?
public enum AchievementData {
	//Easy
	SUPPORT_AVALON(0, AchievementType.EASY, 1, "SUPPORT AVALON","Vote for Levincia",
            new Item[] {new Item(19114, 1)},
            new LoyaltyPointReward(2000),new VotingPointReward(1)
    ),
    UPGRADE_A_ITEM(1, AchievementType.EASY, 1, "Upgrade an Item","Attempt an ::upgrade",
            new Item[] {new Item(12855, 2500)},
            new LoyaltyPointReward(2000)
    ),
    DEAL_100K_MELEE_DAMAGE(2, AchievementType.EASY, 100_000, "Deal 100k Melee Damage","Deal 100,000 melee damage to any npc!",
            new Item[] {new Item(5022, 1000)},
            new LoyaltyPointReward(2000)
    ),
    DEAL_100K_RANGE_DAMAGE(3, AchievementType.EASY, 100_000, "Deal 100k Range Damage","Deal 100,000 range damage to any npc!",
            new Item[] {new Item(5022, 1000)},
            new LoyaltyPointReward(2000)
    ),
    DEAL_100K_MAGIC_DAMAGE(4, AchievementType.EASY, 100_000, "Deal 100k Magic Damage","Deal 100,000 magic damage to any npc!",
            new Item[] {new Item(5022, 1000)},
            new LoyaltyPointReward(2000)
    ),
    TRAIN_NPCS(5, AchievementType.EASY, 50, "Train Npcs","Kill x50 Armoured Minotuars",
            new Item[] {new Item(19114, 1)},
            new LoyaltyPointReward(2000)
    ),
    MELEE_NPCS(6, AchievementType.EASY, 50, "Melee Npcs","Kill x50 Ember Giants",
            new Item[] {new Item(19114, 1)},
            new LoyaltyPointReward(2000)
    ),
    RANGE_NPCS(7, AchievementType.EASY, 50, "Range Npcs","Kill x50 Tree Gorgons",
            new Item[] {new Item(19114, 1)},
            new LoyaltyPointReward(2000)
    ),
    MAGIC_NPCS(8, AchievementType.EASY, 50, "Magic Npcs","Kill x50 Aquanites",
            new Item[] {new Item(19114, 1)},
            new LoyaltyPointReward(2000)
    ),
    GIANT_SPIDERS(9, AchievementType.EASY, 100, "Arachne","Kill x100 Arachnes",
            new Item[] {new Item(19114, 1)},
            new LoyaltyPointReward(2000)
    ),
    DEMON_GODDESS(10, AchievementType.EASY, 100, "Demon Goddess","Kill x100 Demon Goddess",
            new Item[] {new Item(19114, 1)},
            new LoyaltyPointReward(2000)
    ),
    ENERGY_SKELETON(11, AchievementType.EASY, 100, "Energy Skeletons","Kill x100 Energy Skeletons",
            new Item[] {new Item(5022, 2500)},
            new LoyaltyPointReward(2000)
    ),
    TUROTHS(12, AchievementType.EASY, 100, "Turoths","Kill x100 Turoths",
            new Item[] {new Item(5022, 2500)},
            new LoyaltyPointReward(2000)
    ),

    DUSTCLAW(13, AchievementType.EASY, 100, "Dustclaw","Kill x100 Dustclaw",
            new Item[] {new Item(5022, 1500)},
            new LoyaltyPointReward(2000)
    ),

    SLAYER(14, AchievementType.EASY, 1, "Slayer","Complete a slayer task on any difficulty",
            new Item[] {new Item(7120, 1)},
            new LoyaltyPointReward(2000),
            new SlayerPointReward(25)
    ),

    WOODCUTTING(15, AchievementType.EASY, 1, "Woodcutting","Chop some wood of any kind!",
            new Item[] {new Item(12855, 1000)},
            new LoyaltyPointReward(2000)
    ),
    FISHING(16, AchievementType.EASY, 1, "Fishing","Catch some fish of any kind!",
            new Item[] {new Item(12855, 1000)},
            new LoyaltyPointReward(2000)
    ),
    COOKING(17, AchievementType.EASY, 1, "Cooking","Cook anything at all without burning it",
            new Item[] {new Item(12855, 1000)},
            new LoyaltyPointReward(2000)
    ),
    MINING(18, AchievementType.EASY, 1, "Mining","Mine some ore of any kind!",
            new Item[] {new Item(12855, 1000)},
            new LoyaltyPointReward(2000)
    ),
    SMITHING(19, AchievementType.EASY, 1, "Smithing","Make some bars of any kind!",
            new Item[] {new Item(12855, 1000)},
            new LoyaltyPointReward(2000)
    ),

    RUNECRAFTING(20, AchievementType.EASY, 1, "Runecrafting","Craft some runes of any kind!",
            new Item[] {new Item(12855, 1000)},
            new LoyaltyPointReward(2000)
    ),

    PRAYER(21, AchievementType.EASY, 1, "Prayer","Bury bones of any kind or use at the altar!",
            new Item[] {new Item(12855, 1000)},
            new LoyaltyPointReward(2000)
    ),
    FLETCHING(22, AchievementType.EASY, 1, "Fletching","Fletch some arrows of any kind!",
            new Item[] {new Item(12855, 1000)},
            new LoyaltyPointReward(2000)
    ),
    FARMING(23, AchievementType.EASY, 1, "Farming","Harvest a crop of any kind!",
            new Item[] {new Item(12855, 1000)},
            new LoyaltyPointReward(2000)
    ),
    HERBLORE(24, AchievementType.EASY, 1, "Herblore","Clean a herb of any kind!",
            new Item[] {new Item(12855, 1000)},
            new LoyaltyPointReward(2000)
    ),
    THIEVING(25, AchievementType.EASY, 1, "Thieving","Steal from any thieving stall",
            new Item[] {new Item(12855, 1000)},
            new LoyaltyPointReward(2000)
    ),
    AGILITY(26, AchievementType.EASY, 1, "Agility","Climb an obstacle of any kind!",
            new Item[] {new Item(12855, 1000)},
            new LoyaltyPointReward(2000)
    ),
    UPGRADE_2_TIMES(27, AchievementType.EASY, 2, "Upgrade 2 Times","Successfully ::upgrade two Items!",
            new Item[] {new Item(12855, 3000)},
            new LoyaltyPointReward(2000)
    ),
    REACH_10K_KILLS(28, AchievementType.EASY, 10_000, "Reach 10k Kills","Reach 10k NPC Kills!",
            new Item[] {new Item(15288, 1),new Item(6769, 1),new Item(20488, 3)},
            new LoyaltyPointReward(3000),
            new SlayerPointReward(100)
    ),
    //Medium
    LORD(29, AchievementType.MEDIUM, 250, "Lord","Kill x250 Lord!",
            new Item[] {new Item(6199, 2),new Item(10025, 1)},
            new LoyaltyPointReward(3000)
    ),
    SHADOW(30, AchievementType.MEDIUM, 300, "Shadow","Kill 300 Shadow!",
            new Item[] {new Item(6199, 2),new Item(10025, 1)},
            new LoyaltyPointReward(3000)
    ),
    GOLEM(31, AchievementType.MEDIUM, 400, "Golem","Kill x400 Joyx Golem!",
            new Item[] {new Item(6199, 2),new Item(10025, 2)},
            new LoyaltyPointReward(3000)
    ),
    SHETANI(32, AchievementType.MEDIUM, 500, "Shetani","Kill x500 Shetani!",
            new Item[] {new Item(6199, 3),new Item(10025, 2)},
            new LoyaltyPointReward(3000)
    ),
    RIPPER(33, AchievementType.MEDIUM, 750, "Ripper","Kill x750 Titanium Rippers!",
            new Item[] {new Item(6199, 3),new Item(10025, 3)},
            new LoyaltyPointReward(3000)
    ),
    AVATAR(34, AchievementType.MEDIUM, 1000, "Avatar","Kill x1000 Avatars!",
            new Item[] {new Item(6199, 3),new Item(10025, 4)},
            new LoyaltyPointReward(3000)
    ),
    WYVERNS(35, AchievementType.MEDIUM, 1000, "Wyverns","Kill x1000 Wyverns!",
            new Item[] {new Item(19114, 2),new Item(10025, 5)},
            new LoyaltyPointReward(3000)
    ),
    DEAL_10M_MELEE_DAMAGE(36, AchievementType.MEDIUM, 10_000_000, "Deal 10M Melee Damage","Deal 10,000,000 melee damage to any npc!",
            new Item[] {new Item(12855, 10000)},
            new LoyaltyPointReward(3000)
    ),
    DEAL_10M_RANGE_DAMAGE(37, AchievementType.MEDIUM, 10_000_000, "Deal 10M Range Damage","Deal 10,000,0000 range damage to any npc!",
            new Item[] {new Item(12855, 10000)},
            new LoyaltyPointReward(3000)
    ),
    DEAL_10M_MAGIC_DAMAGE(38, AchievementType.MEDIUM, 10_000_000, "Deal 10M Magic Damage","Deal 10,000,000 magic damage to any npc!",
            new Item[] {new Item(12855, 10000)},
            new LoyaltyPointReward(3000)
    ),
    PRAYER_RITUAL(39, AchievementType.MEDIUM, 50, "Prayer Ritual","Bury 50 Bones of any kind or use on altar!",
            new Item[] {new Item(18830, 100)},
            new LoyaltyPointReward(3000)
    ),
    THIEVER(40, AchievementType.MEDIUM, 50, "Thiever","Steal from any stall a total of 50 times!",
            new Item[] {new Item(12855, 10_000)},
            new LoyaltyPointReward(3000)
    ),
    MODERATE_SLAYER(41, AchievementType.MEDIUM, 10, "Moderate Slayer","Complete 10 Slayer tasks of any difficulty level!",
            new Item[] {new Item(7120, 5)},
            new LoyaltyPointReward(3000),new SlayerPointReward(100)
    ),
	SUPPORTER(42, AchievementType.MEDIUM, 10, "Supporter","Vote for Levincia 10 times!",
            new Item[] {new Item(12855, 10_000)},
            new LoyaltyPointReward(3000),new VotingPointReward(5)
    ),
    REACH_100K_KILLS(43, AchievementType.MEDIUM, 100_000, "Reach 100k Npc Kills","Reach 100k Npc Kills!",
            new Item[] {new Item(15288, 3),new Item(10942, 1),new Item(20488, 5)},
            new LoyaltyPointReward(3000),new VotingPointReward(5)
    ),


	//Hard
    HANTO(44, AchievementType.HARD, 500, "HANTO_WARRIOR", "Kill x500 Hanto Warriors",
            new Item[] {new Item(12855, 50000),new Item(20488, 1)},
            new LoyaltyPointReward(5000)
    ),
    RADITZ(45, AchievementType.HARD, 600, "RADITZ", "Kill x600 Raditz",
            new Item[] {new Item(12855, 50000),new Item(20488, 1)},
            new LoyaltyPointReward(5000)
    ),
    GOKU(46, AchievementType.HARD, 750, "GOKU", "Kill x750 Goku",
            new Item[] {new Item(12855, 50000),new Item(20488, 1)},
            new LoyaltyPointReward(5000)
    ),
    INUYASHA(47, AchievementType.HARD, 1000, "Inuyasha", "Kill x1000 Inuyasha",
            new Item[] {new Item(12855, 50000),new Item(20488, 1)},
            new LoyaltyPointReward(5000)
    ),
    DEAL_100M_MELEE_DAMAGE(48, AchievementType.HARD, 100_000_000, "Deal 100M Melee Damage","Deal 100,000,000 melee damage to any npc!",
            new Item[] {new Item(19114, 4)},
            new LoyaltyPointReward(5000)
    ),
    DEAL_100M_RANGE_DAMAGE(49, AchievementType.HARD, 100_000_000, "Deal 100M Range Damage","Deal 100,000,0000 range damage to any npc!",
            new Item[] {new Item(19114, 4)},
            new LoyaltyPointReward(5000)
    ),
    DEAL_100M_MAGIC_DAMAGE(50, AchievementType.HARD, 100_000_000, "Deal 100M Magic Damage","Deal 100,000,000 magic damage to any npc!",
            new Item[] {new Item(19114, 4)},
            new LoyaltyPointReward(5000)
    ),
    PRAYER_DEVOTION(51, AchievementType.HARD, 500, "Prayer Devotion","Bury 500 Bones of any kind or use on altar!",
            new Item[] {new Item(12855, 30_000),new Item(19115, 2),new Item(19114, 1)},
            new LoyaltyPointReward(5000)
    ),
    KLEPTOMANIAC(52, AchievementType.HARD, 500, "Kleptomaniac","Steal from any stall a total of 500 times!",
            new Item[] {new Item(19114, 3)},
            new LoyaltyPointReward(5000)
    ),
	MEGA_SUPPORTER(53, AchievementType.HARD, 50, "Mega Supporter", "Vote for Levincia 50 times",
            new Item[] {new Item(15288, 1),new Item(10946, 3)},
            new LoyaltyPointReward(5000),new VotingPointReward(10)
    ),
    SKILL_GRINDER(54, AchievementType.HARD, 1, "Skill Grinder", "Reach level 99 in all skills",
            new Item[] {new Item(15288, 5),new Item(12630, 1),new Item(10942, 1),new Item(19886, 1)},
            new LoyaltyPointReward(5000)
    ),
    REACH_500K_KILLS(55, AchievementType.HARD, 500_000, "Reach 500k Npc Kills","Reach 500k Npc Kills!",
            new Item[] {new Item(15288, 5),new Item(10934, 1),new Item(20488, 10),new Item(4446, 1)},
            new LoyaltyPointReward(3000),new SlayerPointReward(500)
    ),
    DEAL_1B_MELEE_DAMAGE(56, AchievementType.HARD, 1_000_000_000, "Deal 1B Melee Damage","Deal 1,000,000,000 melee damage to any npc!",
            new Item[] {new Item(12855, 100_000),new Item(20488, 2)},
            new LoyaltyPointReward(3000),new SlayerPointReward(500)
    ),
    DEAL_1B_RANGE_DAMAGE(57, AchievementType.HARD, 1_000_000_000, "Deal 1B Range Damage","Deal 1,000,000,0000 range damage to any npc!",
            new Item[] {new Item(12855, 100_000),new Item(20488, 2)},
            new LoyaltyPointReward(3000),new SlayerPointReward(500)
    ),
    DEAL_1B_MAGIC_DAMAGE(58, AchievementType.HARD, 1_000_000_000, "Deal 1B Magic Damage","Deal 1,000,000,000 magic damage to any npc!",
            new Item[] {new Item(12855, 100_000),new Item(20488, 2)},
            new LoyaltyPointReward(3000),new SlayerPointReward(500)
    ),
    MAX_OUT(59, AchievementType.HARD, 1, "Max out", "Maxing (120 in all skills)",
            new Item[] {new Item(10935, 1),new Item(15004, 1)},
            new LoyaltyPointReward(5000)
    ),
    PRESTIGE_VETERAN(60, AchievementType.HARD, 3, "Prestige Veteran", "Prestige your skills a total of 3 Times",
            new Item[] {new Item(23236, 1),new Item(10946, 3),new Item(12855, 100_000)},
            new LoyaltyPointReward(5000),new VotingPointReward(5)
    ),
    TWO_BILLION_INVENTION(61, AchievementType.HARD, 1, "Two Billion Invention", "2,000,000,000 Invention XP",
            new Item[] {new Item(10935, 1),new Item(15003, 1),new Item(15288, 10)},
            new LoyaltyPointReward(5000)
    ),
    TWO_BILLION_FARMING(62, AchievementType.HARD, 1, "Two Billion Farming", "2,000,000,000 Farming XP",
            new Item[] {new Item(10935, 1),new Item(15004, 1)},
            new LoyaltyPointReward(5000)
    ),
    TWO_BILLION_HUNTER(63, AchievementType.HARD, 1, "Two Billion Hunter", "2,000,000,000 Hunter XP",
            new Item[] {new Item(10935, 1),new Item(15004, 1)},
            new LoyaltyPointReward(5000)
    ),
    BURY_ALOT(64, AchievementType.HARD, 200_000, "Bury Alot", "Bury 200,000 bones or use on an altar",
            new Item[] {new Item(10935, 1)},
            new LoyaltyPointReward(5000)
    ),
    WOODCUT_ALOT(65, AchievementType.HARD, 25_000, "Woodcut Alot","Chop 25,000 trees",
            new Item[] {new Item(10934, 1),new Item(10947, 2)},
            new LoyaltyPointReward(5000)
    ),

    COOK_ALOT(66, AchievementType.HARD, 25_000, "Cook Alot","Cook 25,000 times",
            new Item[] {new Item(10934, 1),new Item(10947, 2)},
            new LoyaltyPointReward(5000)
    ),
    FISH_ALOT(67, AchievementType.HARD, 25_000, "Fish Alot","Fish 25,000 times",
            new Item[] {new Item(10934, 1),new Item(10947, 2)},
            new LoyaltyPointReward(5000)
    ),
    ONE_MILLION(68, AchievementType.HARD, 1_000_000, "One Million","Gain 1,000,000 NPC Kills",
            new Item[] {new Item(10934, 1),new Item(15004, 1)},
            new LoyaltyPointReward(5000)
    ),
    COLOSSAL_KILLER(69, AchievementType.HARD, 10_000, "Colossal Killer","Kill 10k Colossal Avatars",
            new Item[] {new Item(10934, 1),new Item(22106, 2),new Item(5022, 3_000_000)},
            new LoyaltyPointReward(5000)
    ),
    ELITE_KILLER(70, AchievementType.HARD, 10_000, "Elite Killer","Kill 10k Elite Vladis",
            new Item[] {new Item(10934, 1),new Item(22106, 2),new Item(5022, 3_000_000)},
            new LoyaltyPointReward(5000)
    ),

    ANGEL_KILLER(71, AchievementType.HARD, 10_000, "Fallen Killer","Kill 10k Fallen Angels",
            new Item[] {new Item(22107, 1),new Item(12855, 5_000_000)},
            new LoyaltyPointReward(5000)
    ),
    //Expert
    MIDNIGHT_ACHIEVER(72, AchievementType.EXPERT, 10_000, "Midnight Achiever", "Kill 10k Midnight Goblins",
            new Item[] {new Item(22112, 1),new Item(20488, 10)},
            new LoyaltyPointReward(25000)
    ),
    CRYPT_CAMPER(73, AchievementType.EXPERT, 500, "Crypt Camper", "Complete the Unknown Crypt Minigame 500 times",
            new Item[] {new Item(23237, 3),new Item(10946, 3)},
            new LoyaltyPointReward(25000)
    ),
    RAMBO_SLAYER(74, AchievementType.EXPERT, 300, "Rambo Slayer", "Complete 300 slayer task on any difficulty",
            new Item[] {new Item(23215, 5),new Item(22123, 3),new Item(21219, 10)},
            new LoyaltyPointReward(25000),new SlayerPointReward(500)
    ),
    PRESTIGE_MASTER(75, AchievementType.EXPERT, 5, "Prestige Master", "Prestige your skills a total of 5 Times",
            new Item[] {new Item(23236, 3),new Item(12855, 500_000)},
            new LoyaltyPointReward(25000),new VotingPointReward(5)
    ),
    KILL_5K_GLOBALS(76, AchievementType.EXPERT, 5_000, "Global Asset", "Participate in killing 5,000 Global bosses",
            new Item[] {new Item(10935, 1),new Item(23229, 100),new Item(23277, 1)},
            new LoyaltyPointReward(25000)
    ),
    RAIDER(77, AchievementType.EXPERT, 500, "Raider", "Complete 500 Raids",
            new Item[] {new Item(18404, 3),new Item(23276, 1)},
            new LoyaltyPointReward(25000)
    ),
    BLOOD_MASTER(78, AchievementType.EXPERT, 25_000, "Blood Master", "Kill 25k Blood Demon",
            new Item[] {new Item(23239, 1),new Item(15288, 4)},
            new LoyaltyPointReward(25000),new SlayerPointReward(500)
    ),
    CLEAR_THE_ISLES(79, AchievementType.EXPERT, 500, "Clear the Crypt", "Clear the Unknown crypt 500 times",
            new Item[] {new Item(23086, 3),new Item(10946, 3)},
            new LoyaltyPointReward(25000)
    ),
    TREASURE_HUNTER(80, AchievementType.EXPERT, 1000, "Treasure Hunter", "Open 1k Treasure Hunter keys",
            new Item[] {new Item(23107, 10),new Item(10946, 3)},
            new LoyaltyPointReward(25000)
    ),
    VETERAN_VOTER(81, AchievementType.EXPERT, 250, "Veteran Voter", "Vote for Levincia 250 times",
        new Item[] {new Item(10942, 1)},
        new LoyaltyPointReward(25000),new VotingPointReward(25)
    ),
    TWO_MILLION(82, AchievementType.EXPERT, 2_000_000, "Two Million", "Gain 2,000,000 NPC Kills ",
            new Item[] {new Item(10935, 1),new Item(23279, 1)},
            new LoyaltyPointReward(25000),new SlayerPointReward(500)
    ),
    NECROTIC(83, AchievementType.EXPERT, 1000, "Defeat Necromancer", "Defeat the Necromancer",
                    new Item[] {new Item(10942, 1),new Item(23240, 2)},
                    new LoyaltyPointReward(40000),new SlayerPointReward(500)

            ),
            ELDER_GODS(84, AchievementType.EXPERT, 1000, "Elder Gods Warrior", "Defeat the Elder Gods 1000 times",
                    new Item[] {new Item(10942, 1),new Item(13594, 1)},
                    new LoyaltyPointReward(75000),new SlayerPointReward(1000)
    ),

	
    ;

    public static final AchievementData[] values = AchievementData.values();
    public static final AchievementData[][] arraysByType = new AchievementData[AchievementType.values().length][];

    public static void checkDuplicateIds() {
        Set<Integer> ids = new HashSet<>();
        for (AchievementData achievement : values) {
            if (ids.contains(achievement.id)) {
                System.err.println("AchievementData sharing the same id!!! Shutting Down. Each achievement must have a unique id.");
                for (AchievementData data : values) {
                    if (data.id == achievement.id) {
                        System.out.println(data.name() + " id: " + data.id);
                    }
                }
                System.exit(0);
            }
            ids.add(achievement.id);
        }
    }

    final int id;
    final AchievementType type;
    final String title;
	String desc;
    final int progressAmount;
    final Item[] itemRewards;
    final NonItemReward[] nonItemRewards;

    AchievementData(int id, AchievementType type, int progressAmount, String title,String desc, Item[] itemRewards, NonItemReward... nonItemRewards) {
        this.id = id;
        this.type = type;
        this.progressAmount = progressAmount;
        this.title = title;
		this.desc = desc;
        this.itemRewards = itemRewards;
        this.nonItemRewards = nonItemRewards;
    }

    @Override
    public String toString() {
        return WordUtils.capitalize(this.name().toLowerCase().replaceAll("_", " "));
    }

    public static AchievementData[] getAchievementsOfType(AchievementType type){
        int index = type.ordinal();
        if (arraysByType[index] != null) {
            return arraysByType[index];
        }
        arraysByType[index] = Arrays.stream(AchievementData.values).filter(a -> a.type.equals(type)).toArray(AchievementData[]::new);
        return arraysByType[index];
    }

}
