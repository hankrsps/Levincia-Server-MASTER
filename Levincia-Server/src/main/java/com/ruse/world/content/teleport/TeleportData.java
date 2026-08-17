package com.ruse.world.content.teleport;

import com.ruse.GameSettings;
import com.ruse.model.Position;
import com.ruse.motivote3.doMotivote;
import com.ruse.world.content.VoteBossDrop;
import com.ruse.world.content.afk.AfkSystem;
import com.ruse.world.content.globalBosses.*;
import com.ruse.world.content.raids.elders.ElderGodsData;

/**
 * The teleport data.
 * 
 * @author snz
 */
/**
 * @ plugin interferences system has been initialize for only 10 because of the set vaules inserted/note
 * note for me//
 * @author snz
 *
 */
public enum TeleportData {
	/*
	 * Monsters
	 */
	MINOTAUR(28307, 28307, 28307, 28231,"Minotaurs",1,
			"@or1@Health:@whi@ 250","","", TeleportCategory.MONSTERS,
			new Position(2527, 2527, 0), 5, false, 1719, -1,
			new int[][] {{10025, 1}, {7956, 2}, {989,3 }, {6199, 2}, {5022, 3}, {5021, 6}, {14525, 1}, {11858, 1},
					{19582, 1}, {536, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},600 ),

	LAVA_HOUND(28308, 28308, 28308, 28232,"Ember Giants",1,
			"@or1@Health:@whi@ 500","","", TeleportCategory.MONSTERS,
			new Position(3424, 4126, 0), 5, false, 9838, -1,
			new int[][] {{7956, 1}, {989, 1}, {4882, 1}, {4894, 1}, {4900,1 }, {4888, 1}, {20460, 1}, {20456, 1},
					{18747, 1}, {6199, 1}, {5022, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}}, 600),

	TREE_BASILISK( 28309, 28309, 28309, 28233,"Tree Gorgon",1,
			"@or1@Health:@whi@ 500","","",  TeleportCategory.MONSTERS,
			new Position(2196, 5083, 0), 10, false, 1718, -1,
			new int[][] {{7956, 1}, {989, 1}, {17043, 1}, {17175, 1},  {17321, 1}, {18332, 1}, {15026, 1}, {10696, 1},
					{6199, 1}, {5022, 1}, {-1, 1}, {-1,-1 }, {-1,-1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}}, 550),

	AQUANITE( 28310, 28310, 28310, 28234,"Aquanite",1,
			"@or1@Health:@whi@ 500","","",  TeleportCategory.MONSTERS,
			new Position(1896, 4367, 0), 0, false, 9172, -1,
			new int[][] {{7956, 1}, {989, 1}, {14733, 1}, {14732, 1},  {14734, 1}, {14377, 1}, {10865, 1}, {12864, 1},
					{6199, 1}, {5022, 15}, {-1, 1}, {-1,-1 }, {-1,-1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}}, 620),

	GIANT_SPIDERS( 28311, 28311, 28311, 28235,"Arachnes",2,
			"@or1@Health:@whi@ 12,000","","",  TeleportCategory.MONSTERS,
			new Position(2721, 4446, 0), 10, false, 117, -1,
			new int[][] {{12855, 1000}, {5022, 100}, {22214, 3}, {22219, 2}, {781, 1}, {19811, 1}, {19473, 1}, {19472, 1},
					{17291,1 }, {3909,1 }, {11235,1 }, {6199,1 }, {2435,30 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},720),

	CASH_DRAGON( 28312, 28312, 28312, 28238, "Cash dragons",2,
			"@or1@Health:@whi@ 14,000","","",  TeleportCategory.MONSTERS,
			new Position(2911, 3613, 0), 10, false, 500, -1, new int[][] {{5022, 100},
			{21221, 1}, {22214, 3}, {6199, 1}, {989, 1},  {15270, 1}, {3025, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1,1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}}, 1500),

	DEMON_GODDESS( 28313, 28313, 28313, 28239, "Demon Goddesses",3,
			"@or1@Health:@whi@ 16,000","","",  TeleportCategory.MONSTERS,
			new Position(2784, 4445, 0), 10, false, 501, -1,
			new int[][] {{12855, 1000}, {5022, 100}, {22214, 3}, {22219, 1}, {781, 1},  {8834, 1}, {8835, 1}, {8860, 1},
					{8861, 1}, {8862, 1}, {15830, 1}, {18686, 1}, {18799,1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}}, 700),

	ENERGY_SKELETON(28314, 28314, 28314, 28240, "Energy Skeletons",3,
			"@or1@Health:@whi@ 20,000","","",  TeleportCategory.MONSTERS,
			new Position(2088, 3995, 0), 10, false, 503, -1,
			new int[][] {{12855, 1150}, {5022, 115}, {22214, 3}, {22219, 1}, {781, 1}, {19931, 1}, {19933, 1}, {19934, 1},
					{19919,1 }, {19917,1 }, {7927,1}, {18830,-1 }, {-1,-1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},700),

	TUROTH(28315, 28315, 28315, 28241, "Turoths",4,
			"@or1@Health:@whi@ 180,000","","",  TeleportCategory.MONSTERS,
			new Position(3154, 5556, 0), 10, false, 1627, -1,
			new int[][] {{12855, 1250}, {5022, 125},{22214, 1}, {22219, 1}, {781, 1}, {8816, 1}, {8817,1}, {8818, 1},
					{3905,1 }, {14018,1 }, {5022,10 }, {-1,-1 }, {-1,-1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},600),

	FALLEN_WARRIOR(28316, 28316, 28316, 28242, "Fallen Warrior",4,
			"@or1@Health:@whi@ 333,333","","",  TeleportCategory.MONSTERS,
			new Position(1951, 5148, 0), 10, false, 9011, -1,
			new int[][] {{12855, 500}, {5022, 100},{15288, 1}, {15358, 1}, {15359, 1}, {-1, 1}, {-1,1}, {-1, 1}, {-1,1 },
					{-1,1 }, {-1,1 }, {-1,-1 }, {-1,-1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},500),
	SEASON_PASS(28317, 28317, 28317, 28243, "Prysm",5,
			"@or1@Health:@whi@ 333,333","","",  TeleportCategory.MONSTERS,
			new Position(2915, 2653, 0), 10, false, 9890, -1,
			new int[][] {{12855, 2500}, {5022, 175},{10946, 1}, {10947, 1}, {15358, 1}, {15359, 1}, {22092,1}, {8323, 1},
					{8324,1 }, {8325,1 }, {15289,1 }, {20488,1 }, {10025,1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},570),
	/*
	 * Bosses
	 */
	HANTO( 28307, 28307, 28307, 28231,"Hanto Warriors",6,
			"@or1@Health:@whi@ 5,000","","",  TeleportCategory.BOSSES,
			new Position(2849, 4576, 0), 10, false, 250, -1,
			new int[][] { {10946, 1}, {6833, 1}, {11763, 1}, {11764, 1},{11765, 1}, {11766, 1}, {11767, 1}, {18686, 1}, {18799,1},
					{3318, 1}, {15418, 1}, {6199, 2}, {5022, 9}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},880),
			RADITZ( 28308, 28308, 28308, 28232, "Raditz",6,
					"@or1@Health:@whi@ 10,000","","",  TeleportCategory.BOSSES,
					new Position(2911, 3991, 0), 10, false, 449, -1,
					new int[][] {{10946, 1}, {18768, 1}, {7545, 1}, {7543, 1}, {7544, 1}, {9481, 1}, {9482, 1}, {9483, 1},
							{12855, 300}, {5022, 300}, {12855, 70}, {5022, 70}, {7956, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},780),

			GOKU( 28309, 28309, 28309, 28233, "Goku", 6,
					"@or1@Health:@whi@ 50,000","","",  TeleportCategory.BOSSES,
					new Position(3358, 9307, 0), 10, false, 452, -1,
					new int[][] {{18838, 1}, {9478, 1}, {9479, 1}, {9480, 1}, {16265, 1}, {15832, 1}, {16249, 1}, {6833, 1},
							{18768, 1}, {12855,300}, {5022,300}, {12855,70}, {7956,2}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},780),

			BOTANIC(28310, 28310, 28310, 28234,"Botanic Guardian",7,
					"@or1@Health:@whi@ 600,000","","",  TeleportCategory.BOSSES,
					new Position(2586, 9449, 0), 10, false, 2342, -1,
					new int[][] {{3738, 1}, {3723, 1}, {3724, 1}, {3725, 1}, {12855, 1000}, {12855, 1000}, {12855, 1000},
							{12855, 1000}, {989, 3}, {6199,3 }, {5022,3 }, {5021,3 }, {-1,1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1000),

			ENRAGED_GUARDIAN( 28311, 28311, 28311, 28235, "Enraged Guardian", 7,
					"@or1@Health:@whi@ 600,000","","",  TeleportCategory.BOSSES,
					new Position(3039, 3995, 0), 10, false, 2949, -1,
					new int[][] {{3737, 1}, {3720, 1}, {3721, 1}, {3722, 1}, {12855, 1000}, {12855, 1000},{12855, 1000},
							{12855, 1000}, {989, 3}, {6199, 3}, {5022, 3}, {5021, 3}, {-1, -1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1000),

			ELEMENTAL_GUARDIAN( 28312, 28312, 28312, 28236, "Elemental Guardian",7,
					"@or1@Health:@whi@ 600,000","","",  TeleportCategory.BOSSES,
					new Position(2781, 4576, 0), 10, false, 505, -1,
					new int[][] {{3739, 1}, {3726, 1}, {3728, 1}, {3730, 1}, {12855, 1000}, {12855, 1000},{12855, 1000},
							{12855, 1000}, {989, 3}, {6199, 3}, {5022, 3}, {5021, 3}, {-1, -1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1000),

			INYUASHA(28313, 28313, 28313, 28237,"Inuyasha",8,
					"@or1@Health:@whi@ 500,000","","",  TeleportCategory.BOSSES,
					new Position(2328, 5409, 0), 10, false, 185, -1,
					new int[][] {{5073, 1000}, {5068, 1}, {5069, 1}, {5070, 1}, {5071, 1}, {5072, 1},{8335, 1}, {10946, 1},
							{12855, 1000}, {12855, 1000}, {12855, 1000}, {12855, 1000}, {989, 3}, {19114, 1}, {19115, 1}, {19116, 1}, {5022, 3}},750),

			TOLROKOTH( 28314, 28314, 28314, 28238, "Tolrokoth",8,
					"@or1@Health:@whi@ 500,000","","",  TeleportCategory.BOSSES,
					new Position(1887, 5468, 0), 10, false, 6430, -1,
					new int[][] {{14067, 1}, {14060, 1}, {14061, 1}, {14062, 1}, {14066, 1}, {14065, 1}, {14063, 1}, {14064, 1},
							{12855, 70}, {989, 2}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1200),

			DEITY_DEMON(28315, 28315, 28315, 28239,"Demons of Deity",8,
					"@or1@Health:@whi@ 450,000","","",  TeleportCategory.BOSSES,
					new Position(2842, 9387, 0), 10, false, 440, -1,
					new int[][] {{10947, 1}, {15290, 2}, {15289, 2}, {19116, 3}, {15290, 1}, {989, 1}, {6199, 3}, {5022, 3},
							{5021, 3},{-1, 1},{-1, 1}, {-1, 1}, {-1,1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1000),

			MUTATED_HOUND( 28316, 28316, 28316, 28240,"Mutated Hound",9,
					"@or1@Health:@whi@ 2,500,000","","",  TeleportCategory.BOSSES,
					new Position(3421, 4777, 0), 10, false, 9839, -1,
					new int[][] {{14472, 1}, {10949, 1}, {10947, 2}, {10946, 1}, {15290,2}, {15289, 1}, {19116, 3}, {5022, 3},
							{19115, 3}, {19114,3}, {15290, 1}, {989,3}, {6199,3}, {12855, 140}, {5022, 140}, {5021, 3}},1250),

			VALDIS( 28317, 28317, 28317, 28241,"Elite Valdis",9,
					"@or1@Health:@whi@ 2,500,000","","",  TeleportCategory.BOSSES,
					new Position(2529, 4573, 0), 10, false, 205, -1,
					new int[][] {{18830, 10}, {4373, 1}, {10947, 2}, {20488, 2}, {19115,3}, {19116,5}, {19114, 1}, {1486, 1},
							{15289, 1}, {12855,1000}, {15290, 1}, {12855,1000}, {12855,1000}, {12855, 1000}, {989, 3}, {6199, 3}},750),


			COLLOSAL_AVATAR( 28318, 28318, 28318, 28242,"Collosal Avatar",9,
					"@or1@Health:@whi@ 2,500,000","","",  TeleportCategory.BOSSES,
					new Position(2375, 4947, 0), 10, false, 4540, -1,
					new int[][] {{9080, 1},{9081, 1}, {9082, 1}, {20099, 1}, {15288, 1}, {15289,2}, {15290, 3}, {20488, 2},
							{19115, 3}, {19116, 3}, {19114, 1}, {15289, 1}, {12855,10000}, {12855, 7500}, {12855, 5000}, {989, 3}, {6199, 3}},1350),

			INFERNAL_DEMON( 28319, 28319, 28319, 28243,"Plutonic Demon",10,
					"@or1@Health:@whi@ 2,500,000", "","",  TeleportCategory.BOSSES,
					new Position(2728, 4505, 0), 10, false, 12810, -1,
					new int[][] {{22005, 1}, {15288, 1}, {15289, 2}, {15290, 3}, {20488,2}, {19115, 3}, {19116, 5}, {19114, 1},
							{15289, 1}, {12855, 1000}, {15290, 1}, {12855,1000}, {12855, 1000}, {12855, 1000}, {989, 3}, {6199, 3}, {5022, 3}},1150),
			CRIMSON( 28320, 28320, 28320, 28244,"Crimson",10,
			"@or1@Health:@whi@ 7,500,000", "","",  TeleportCategory.BOSSES,
			new Position(2326, 9831, 4), 10, false, 9767, -1,
			new int[][] {{23759, 5}, {15288, 3}, {15289, 4}, {15290, 10}, {20488,3}, {7956, 100}, {19115, 7}, {19116, 15},
					{19114, 3}, {12855, 2500}, {5022, 2500}, {-1,-1}, {-1,-1}, {-1,-1}, {-1,-1}, {-1,-1}, {-1,-1}},1200),

			FALLEN_ANGEL( 28321, 28321, 28321, 28245,"Fallen Angel",10,
					"@or1@Health:@whi@ 6,666,666","","",  TeleportCategory.BOSSES,
					new Position(2335, 3998, 0), 10, false, 9012, -1,
					new int[][] {{12855, 1000}, {5022, 500},{19000, 1}, {7956, 15}, {22106, 1}, {15288, 1}, {10946, 1},
							{6769, 1}, {-1,-1 }, {-1,-1 }, {-1,-1 }, {-1,-1 }, {-1,-1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1020),

			MIDNIGHT_GOBLIN( 28322, 28322, 28322, 28246,"Midnight Goblin",10,
					"@or1@Health:@whi@ 7,500,000","","",  TeleportCategory.BOSSES,
					new Position(2522, 4648, 0), 10, false, 9837, -1,
					new int[][] {{14474, 1},{22112, 1}, {15288, 3}, {15289, 4}, {15290, 10}, {20488,3}, {7956, 100}, {19115, 7},
							{19116, 15}, {19114, 3}, {12855, 2500}, {5022, 2500}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1100),

			BLOOD_DEMON(28323, 28323, 28323, 28247, "Blood Demon",10,
					"@or1@Health:@whi@ 10,000,000","","",  TeleportCategory.BOSSES,
					new Position(3026, 5233, 0), 10, false, 9813, -1,
					new int[][] {{23238, 1}, {23239, 1},{23252, 1}, {15288, 3}, {15289, 4}, {15290, 10}, {20488, 3}, {7956, 100},
							{19115,7 }, {19116,15 }, {19114,3 }, {12855,2500 }, {5022,2500 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},820),

			NECROMANCER(28324, 28324, 28324, 28248, "Necromancer",11,
					"@or1@Health:@whi@ 10,000,000","","",  TeleportCategory.BOSSES,
					new Position(3235, 2914, 0), 10, false, 9894, -1,
					new int[][] {{22951, 1}, {22952, 1},{22953, 1}, {22954, 1}, {23550, 1}, {-1, 1}, {-1, 1}, {-1, 1},
							{-1,1 }, {-1,1 }, {-1,1 }, {-1,1 }, {-1,1 }, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},920),

	DIMINISHER(28325, 28325, 28325, 28249, "The Diminisher",12,
			"@or1@Health:@whi@ 10,000,000","","",  TeleportCategory.BOSSES,
			new Position(2900, 4386, 0), 10, false, 200, -1,
			new int[][] {{8851, 2}, {16465, 1},{5022, 750}, {8851, 5}, {4278, 3}, {19116, 1}, {19115, 1}, {19114, 1},
					{20488,1 }, {15289,2 }, {10946,1 }, {16465,100 }, {6769,1 }, {16465, 1000}, {23240, 1}, {7995, 1}, {-1, 1}},920),

			/*
	 * Minigames
	 */
			STARTER_ZONE( 28307, 28307, 28307, 28231, "Starter Progression", 1,
					"@or1@Health:@whi@ 1,000","","",  TeleportCategory.MINIGAMES,
					new Position(1, 1, 0), -1, false, 9001, -1,
					new int[][] {{22077, 1}, {19136, 1}, {6936, 1}, {12855,5000}, {7956, 3}, {19116, 2}, {19115, 3}, {10025, 3},
							{19114, 3}, {6833,1}, {14018,1}, {989,50}, {15288,1}, {5022, 50000}, {19000, 100}, {8334, 1}, {19892, 1}},600),

			OUTBREAK(28308, 28308, 28308, 28232, "Pyramid Outbreak",2,
					"@or1@Health: @whi@25,000","","",  TeleportCategory.MINIGAMES,
					new Position(3487, 9235, 0), -1, false, 4476, -1,
					new int[][] {{4151, 1}, {11235, 1}, {15486, 1}, {18353, 1}, {7462, 1}, {15031, 1}, {6585, 1}, {7956,1},
							{22077, 1}, {6927, 1}, {6928,1}, {6929,1}, {19136,1}, {6930, 1}, {6931, 1}, {6932, 1}, {6936, 1}},600),

			UNKNOWN(28309, 28309, 28309, 28233, "Unknown Crypt",4,
					"@or1@Health@whi@ 100,000","","",  TeleportCategory.MINIGAMES,
					new Position(1773,5132,0), -1, false, 823, -1,
					new int[][] {{19116, 2}, {19115, 2}, {19114, 1}, {15289, 1}, {15288, 1}, {10946, 1}, {6769, 1}, {4446,1},
							{19886, 1}, {-1, -1}, {-1,-1}, {-1,-1}, {-1,-1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},1250),

			DUNG(28310, 28310, 28310, 28234, "Legends Raids",6,
					"@or1@Health: @whi@2,500,000","","",  TeleportCategory.MINIGAMES,
					new Position(2222, 4115, 0), -1, false, 585, -1,
					new int[][] {{12855, 5000}, {19886, 1}, {4446, 1}, {1486, 1}, {20489, 1}, {10946, 1}, {15002, 1}, {15288, 5},
							{5022, 500_000}, {6769, 1}, {15004,1}, {5012,1}, {12535,1}, {17011, 1}, {4684, 1}, {4685, 1}, {4686, 1}},1450),

		/*	IOA(28311, 28311, 28311, 28235, "Isles of Levincia",7,
					"@or1@Health: @whi@1,500,000","","",  TeleportCategory.MINIGAMES,
					new Position(2195, 5037, 0), -1, false, 9024, -1,
					new int[][] {{12855,2_500}, {5022, 1000}, {23165, 1}, {23166, 1}, {23167,1}, {23168, 1}, {23169, 1},
							{23170, 1}, {23092, 1}, {23093, 1}, {23094, 1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, 1}, {-1, -1}},1200),
*/
			LOS(28311, 28311, 28311, 28235, "Souls of Suffering",10,
					"@or1@Health: @whi@25,000,000"," ","",  TeleportCategory.MINIGAMES,
					new Position(3753, 9370, 0), -1, false, 9106, -1,
					new int[][] {{23303, 1}, {23304, 1}, {23305, 1}, {23306, 1}, {23307, 1}, {23308,1}, {23309, 1}, {23310, 1},
							{23311, 1}, {14999,1}, {23276,1}, {15288,250}, {-1,-1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},1700),

			TH(28312, 28312, 28312, 28236, "Treasure Hunter",8,
					"@or1@Health: @whi@500,000"," ","",  TeleportCategory.MINIGAMES,
					new Position(2015, 5022, 0), -1, false, 9816, -1,
					new int[][] {{12855, 20_000}, {5022, 7000}, {15290, 7}, {10025, 4}, {7956, 3}, {19116,1}, {19115, 1}, {19114, 1},
							{20488, 1}, {23044, 1}, {6769,1}, {23161,1}, {23162,1}, {23163,1}, {23164, 1}, {22110, 1}, {-1, -1}},3000),

			PEST_CONTROL(28313, 28313, 28313, 28237, "Pest Control",5,
					"@or1@Health@whi@ 100,000","","",  TeleportCategory.MINIGAMES,
					new Position(2657,2646,0), -1, false, 3789, -1,
					new int[][] {{11674, 1}, {11676, 1}, {11675, 1}, {8839, 1}, {8840, 1}, {8842, 1}, {15288, 1}, {22219,1},
							{15358, 1}, {15359, 1}, {20488,1}, {-1,-1}, {-1,-1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},550),

			MAGIC_GUILD(28314, 28314, 28314, 28238, "Magic Guild",10,
					"@or1@Health: @whi@500,000"," ","",  TeleportCategory.MINIGAMES,
					new Position(2204, 4511, 0), -1, false, 9116, -1,
					new int[][] {{3745, 1}, {23299, 1}, {23367, 1}, {-1, 1}, {-1, 1}, {-1,1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1,1},
							{-1,1}, {-1,1}, {-1,1}, {-1, 1}, {-1, 1}, {-1, -1}, {-1, -1}},550),

			WARRIOR_GUILD(28315, 28315, 28315, 28239, "Warrior Guild",10,
					"@or1@Health: @whi@1,000,000"," ","",  TeleportCategory.MINIGAMES,
					new Position(1948, 4191, 0), -1, false, 277, -1,
					new int[][] {{23383, 1}, {23384, 1}, {23386, 1}, {-1, 1}, {-1, 1}, {-1,1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1,1},
							{-1,1}, {-1,1}, {-1,1}, {-1, 1}, {-1, 1}, {-1, -1}, {-1, -1}},515),

			RANGE_GUILD(28316, 28316, 28316, 28240, "Archer Guild", 10,
					"@or1@Health: @whi@1,000,000"," ","",  TeleportCategory.MINIGAMES,
					new Position(3357, 4701, 0), -1, false, 1458, -1,
					new int[][] {{17718, 1}, {23385, 1}, {23409, 1}, {-1, 1}, {-1, 1}, {-1,1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1,1},
							{-1,1}, {-1,1}, {-1,1}, {-1, 1}, {-1, 1}, {-1, -1}, {-1, -1}},515),


	ELDER_GODS(28317, 28317, 28317, 28241, "Elder Gods", 11,
			"@or1@Health: @whi@100,000,000"," ","",  TeleportCategory.MINIGAMES,
			ElderGodsData.LOBBY, -1, false, 9884, -1,
			new int[][] {{13273, 1}, {13274, 1}, {13275, 1}, {13289, 1}, {13297, 1}, {18493,1}, {13662, 1}, {18487, 1}, {13597, 1}, {9084,1},
					{9083,1}, {22110,1}, {-1,1}, {-1, 1}, {-1, 1}, {-1, -1}, {-1, -1}},1645),

	/*
	 * Dungeons
	 */
			EASY_DUNGEON(28307, 28307, 28307, 28231, "Dreaded Dungeon", 3,
					"@or1@Health:@whi@ 20,000","","",  TeleportCategory.DUNGEONS,
					new Position(1887, 5221, 0), 10, false, 1727, -1,
					new int[][] {{12855, 1000}, {5022, 75}, {7956, 1}, {22214, 1},{19116, 2}, {23215, 1}, {779, 1}, {-1,-1},
							{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},600),
			MEDIUM_DUNGEON(28308, 28308, 28308, 28232, "Violent Tunnels", 5,
					"@or1@Health:@whi@ 75,000","","",  TeleportCategory.DUNGEONS,
					new Position(2334, 5222, 0), 10, false, 1741, -1,
					new int[][] {{12855, 2000}, {5022, 75}, {7956, 3}, {22214, 1},{19116, 2}, {23215, 1}, {779, 2}, {-1,-1},
							{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},600),

			HARD_DUNGEON(28309, 28309, 28309, 28233, "Deserted Labyrinth", 7,
					"@or1@Health:@whi@ 1,000,000","","",  TeleportCategory.DUNGEONS,
					new Position(2081, 5532, 0), 10, false, 6792, -1,
					new int[][] {{12855, 2500}, {5022, 250}, {22214, 5}, {22219, 1},{-1, 1}, {-1, 1}, {-1, 1}, {-1,1}, {-1, 1}, {-1, 1},
							{-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},900),
							/*5
                     * Global bosses
                     */
			KC_BOSS(28307, 28307, 28307, 28231, "Hellraiser", 10,
					"@or1@Health:@whi@ 100,000,000","@or1@To Spawn: @whi@" + HellraiserSystem.getLeft() + " kills left","", TeleportCategory.GLOBALS,
					new Position(3109, 5530, 0), 79, false, 187, -1,
					new int[][] {{23229, 1}, {12855, 10_000}, {5022, 1000},{989, 2},{2025, 3},{6769, 1},{10946, 3},{10946, 1},
							{11314, 1},{13323, 1}, {13324, 1}, {13325, 1}, {13326, 1}, {13327, 1}, {-1, -1}, {-1, -1}, {-1, -1}},1150),
	AFK_BOSS(28308, 28308, 28308, 28232, "Afk boss",10,
			"@or1@Health:@whi@ 75,000,000", "@or1@To Spawn:@whi@ " + AfkSystem.getLeft() + " ores left","",
			TeleportCategory.GLOBALS, new Position(2013, 4505, 0), 79, false, 3779, -1,
			new int[][] {{23229, 1}, {15290, 1}, {2023, 3},{20481, 1},{989, 1},{19116, 2},{19115, 10},{15288, 1},{10946, 1},{6769, 1}, {10942, 1}, {10947, 1}, {20511, 1}, {14068, 1}, {14069, 1}, {14070, 1}, {14071, 1}},1400),


	VBOSS(28309, 28309, 28309, 28233, "Vote boss", 10,
			"@or1@Health:@whi@ 1,500,000,000","@or1@To Spawn: @whi@" + (VoteBossDrop.currentSpawn == null ?  doMotivote.getVoteCount() + "/40 please vote!"
			: "Alive ::Vboss"),"", TeleportCategory.GLOBALS, new Position(3428, 4115, 0), 79, false, 8013, -1,
			new int[][] {{23229, 2}, {23020, 1}, {15501, 1},{11137, 1},{2026, 25},{10025, 5},{15290, 1},{20488, 1},{15358, 1},{15359, 1}, {11316, 1}, {20489, 1}, {15003, 1}, {15002, 1}, {4446, 1}, {19886, 1}, {10946, 1}},1600),


	NIGHTMARE(28310, 28310, 28310, 28234, "Nightmare",10,
			"@or1@Health:@whi@ 300,000,000","@or1@To Spawn: @whi@" + (NightmareBoss.currentBoss == null
			?  NightmareBoss.timeLeft() : "@whi@Alive ::nm"),"", TeleportCategory.GLOBALS, new Position(2980, 2771, 0), 79, false, 9017, -1,
			new int[][] {{23229, 1}, {12855, 5000}, {5022, 1000},{989, 2},{10942, 1},{6769, 1},{10946, 1},{9084, 1},{10947, 1},{15290, 1}, {15289, 1}, {15288, 1}, {20488, 1}, {19114, 5}, {19115, 10}, {19116, 15}, {18719, 1}},1350),

	NARAKU(28311, 28311, 28311, 28235, "Naraku",10,
			"@or1@Health:@whi@ 300,000,000","@or1@To Spawn: @whi@" + (NarakuBoss.currentBoss == null
			?  NarakuBoss.timeLeft() : "@whi@Alive ::naraku"),"", TeleportCategory.GLOBALS, new Position(3420, 9563, 0), 79, false, 3305, -1,
			new int[][] {{23229, 1}, {12855, 5000}, {5022, 1000},{989, 2},{6769, 1},{10946, 1},{17646, 1},{17648, 1},{17650, 1},{17684, 1}, {17676, 1}, {17672, 1}, {17660, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1000),

	DRAGON_KING(28312, 28312, 28312, 28236, "Dragon King", 10,
			"@or1@Health:@whi@ 300,000,000","@or1@To Spawn: @whi@" + (DragonKingBoss.currentBoss == null
			?  DragonKingBoss.timeLeft() : "@whi@Alive ::dk"),"", TeleportCategory.GLOBALS, new Position(2139, 5019, 0), 79, false, 4972, -1,
			new int[][] {{23229, 1}, {12855, 5000}, {5022, 1000},{989, 2},{20488, 10},{19114, 5},{10942, 1},{6769, 1},{10946, 1},{14176, 1}, {14172, 1}, {14174, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1800),

	DONATION_BOSS(28313, 28313, 28313, 28237, "Vozzath", 10,
			"@or1@Health:@whi@ 3,000,000,000","@or1@To Spawn: @whi@" + GuardianSpawnSystem.getLeft() + " tickets left","",
			TeleportCategory.GLOBALS, new Position(3445, 4105, 1), 79, false, 3830, -1,
			new int[][] {{23229, 2}, {19114, 2}, {11137, 10},{12855, 10_000},{15289, 1},{15288, 1},{15003, 1},{15002, 1},{10946, 1},{6769, 1}, {10942, 1}, {14999, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1900),

	IRON(28314, 28314, 28314, 28238, "Iron",10,
			"@or1@Health:@whi@ 150,000,000","@or1@To Spawn: @whi@" + (IronmanBoss.currentBoss == null
			?  IronmanBoss.timeLeft() : "Alive ::iron"),"", TeleportCategory.GLOBALS, new Position(3808, 2842, 0), 79, false, 587, -1,
			new int[][] {{12855, 10_000}, {5022, 10_000}, {19000, 10},{15289, 1},{15289, 1},{15288, 1},{15288, 1},{15288, 1},{22116, 1},{22120, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1450),

	ONYX(28315, 28315, 28315, 28239, "Onyx Panther", 10,
			"@or1@Health:@whi@ 300,000,000","@or1@To Spawn: @whi@" + (OnyxPantherBoss.currentBoss == null
			?  OnyxPantherBoss.timeLeft() : "Alive ::onyx"),"", TeleportCategory.GLOBALS, new Position(2470, 5427, 0), 79, false, 9318, -1,
			new int[][] {{12855, 50_000}, {5022, 12_000}, {19000, 25},{19116, 3},{19115, 2},{15290, 1},{15289, 1},{15288, 1},{20488, 1},{20489, 1}, {10949, 1}, {10947, 1}, {18404, 3}, {19001, 1}, {4446, 1}, {19886, 1}, {6769, 1}},700),

	ZENYTE(28316, 28316, 28316, 28240, "Zenyte Golem", 10,
			"@or1@Health:@whi@ 500,000,000","@or1@To Spawn: @whi@" + (ZenyteGolemBoss.currentBoss == null
			?  ZenyteGolemBoss.timeLeft() : "Alive ::zenyte"),"", TeleportCategory.GLOBALS, new Position(2593, 2661, 0), 79, false, 9319, -1,
			new int[][] {{12855, 99999}, {5022, 25_000}, {19000, 50},{19116, 5},{19115, 3},{19114, 1},{15290, 1},{22117, 1},{10946, 1},{6769, 1}, {10942, 1}, {4446, 1}, {19886, 1}, {10947, 1}, {10949, 1}, {-1, 1}, {-1, 1}},1900),


	NEPHILIM(28317, 28317, 28317, 28241, "Nephilim Warrior", 10,
			"@or1@Health:@whi@ 4,000,000,000","@or1@To Spawn: @whi@" + NephilimSpawnSystem.getLeft() + " tokens left","",
			TeleportCategory.GLOBALS, new Position(2144, 3294, 0), 79, false, 9312, -1,
			new int[][] {{23229, 3}, {19114, 3}, {11137, 10},{12855, 20_000},{15288, 1},{10946, 1},{6769, 1},{10942, 1},{15002, 1},{15004, 1}, {14999, 1}, {23253, 1}, {23220, 1}, {23221, 1}, {23222, 1}, {23223, 1}, {23224, 1}},1550),
	SLAYER_CHAMPION(28318, 28318, 28318, 28242, "Slayer Champion", 10,
			"@or1@Health:@whi@ 2,000,000,000","@or1@To Spawn: @whi@" + SlayerBossSystem.getLeft() + " tasks left","",
			TeleportCategory.GLOBALS, new Position(3488, 4700, 0), 79, false, 9129, -1,
			new int[][] {{23229, 1}, {12855, 10000}, {21219, 10},{7120, 5},{22123, 3},{19116, 15},{19115, 10},{19114, 5},{20488, 2},{4446, 1}, {19886, 1}, {15003, 1}, {14999, 1}, {23253, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1200),
	SILVERHAWK(28319, 28319, 28319, 28243, "Platinum Bosses", 10,
			"@or1@Health:@whi@ 2,000,000,000","@or1@To Spawn: @whi@" + (PlatinumBosses.bossAlive
			?  PlatinumBosses.getTimeLeft () : "Alive ::platinum"),"",
			TeleportCategory.GLOBALS, new Position(2273, 4073, 0), 79, false,10034, -1,
			new int[][] {{23229, 1}, {12855, 10000}, {21219, 10},{7120, 5},{22123, 3},{19116, 15},{19115, 10},{19114, 5},{20488, 2},{4446, 1}, {19886, 1}, {15003, 1}, {14999, 1}, {23253, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1300),
    SKELETON_WARRIOR(28320, 28320, 28320, 28244, "@red@Skeleton Warrior", 10,
            "@or1@Health:@whi@ 2,000,000,000","@or1@To Spawn: @whi@" + (SkeletonWarrior.bossAlive
            ?  SkeletonWarrior.getTimeLeft () : "Alive ::oz"),"",
            TeleportCategory.GLOBALS, new Position(3490, 4698, 0), 79, false,959, -1,
            new int[][] {{23229, 1}, {12855, 10000}, {21219, 10},{7120, 5},{22123, 3},{19116, 15},{19115, 10},{19114, 5},{20488, 2},{4446, 1}, {19886, 1}, {15003, 1}, {14999, 1}, {23253, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1300),


	/*
	 * Zones
	 */
	DUST_CLAW(28307, 28307, 28307, 28231,"Dustclaw", 1,
			"","Requirements: @whi@50 Npc killcount","",
			TeleportCategory.ZONES, GameSettings.DUSTCLAW_LOCATION, -1, false, 1614, -1,
			new int[][] {{12855, 50}, {5022, 5}, {10025, 1},{671, 1},{16337, 1},{4411, 1},{14415, 1},{14395, 1},{14405, 1},{672, 1},
					{673, 1}, {19887, 1}, {6199, 1}, {1149, 1}, {1249, 1}, {3204, 1}, {1305, 1}},800),

	LORD_TELEPORT(28308, 28308, 28308, 28232,"Inferior Lord", 1,
			"","Requirements: @whi@100 Dustclaw kills","",
			TeleportCategory.ZONES, GameSettings.LORDS_LOCATION, -1, false, 603, -1,
			new int[][] {{12855, 100}, {5022, 10}, {10025, 1},{681, 1},{676, 1},{18363, 1},{677, 1},{678, 1},{679, 1},{22075, 1},
					{19471, 1}, {19470, 1}, {19469, 1}, {4393, 1}, {18830, 1}, {-1, -1}, {-1, -1}},700),

	SHADOW_HUNTER(28309, 28309, 28309, 28233,"Shadow Hunter", 2,
			"","Requirements: @whi@200 Lord kills","",
			TeleportCategory.ZONES, GameSettings.SHADOWS_LOCATION, -1, false, 12843, -1,
			new int[][] {{12855, 150}, {5022, 15}, {10025, 1},{734, 1},{666, 1},{15424, 1},{674, 1},{22078, 1},{4369, 1},{15877, 1},
					{16269, 1}, {15943, 1}, {18830, 1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},1000),

	JOYX_GOLEM(28310, 28310, 28310, 28234,"Joyx Golem", 3,
			"","Requirements: @whi@300 Shadow kills","",
			TeleportCategory.ZONES, GameSettings.GOLEMS_LOCATION, -1, false, 53, -1,
			new int[][] {{12855, 200}, {5022, 25}, {10025, 1},{675, 1},{700, 1},{702, 1},{701, 1},{17708, 1},{17602, 1},{19153, 1},
					{19142, 1}, {19141, 1}, {18830, 1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},800),


	SHETANI(28311, 28311, 28311, 28235,"Shetani", 3,
			"","Requirements: @whi@400 Golem kills","",
			TeleportCategory.ZONES, GameSettings.SHETANI_LOCATION, -1, false, 8018, -1,
			new int[][] {{12855, 250}, {5022, 35}, {10025, 1},{5095, 1},{19140, 1},{19139, 1},{19138, 1},{2572, 1},{18830, 1},{-1, -1},
					{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},650),

	RIPPER(28312, 28312, 28312, 28236,"Titanium Ripper", 4,
			"","Requirements: @whi@500 Shetani kills","",
			TeleportCategory.ZONES, GameSettings.RIPPER_LOCATION, -1, false, 13635, -1,
			new int[][] {{12855, 350}, {5022, 45}, {10025, 1},{15922, 1},{16021, 1},{15933, 1},{18350, 1},{18358, 1},{18354, 1},{18352, 1},
					{18360, 1}, {17817, 1}, {17815, 1}, {989, 3}, {-1, -1}, {-1, -1}, {-1, -1}},1200),

	AVATAR_TITAN(28313, 28313, 28313, 28237,"Avatar Titan", 5,
			"","Requirements: @whi@1,000 Ripper kills","",
			TeleportCategory.ZONES, new Position(3301, 3289, 0), -1, false, 8008, -1,
			new int[][] {{12855, 450}, {5022, 55}, {10025, 1},{17600, 1},{19944, 1},{703,1},{704, 1},{705, 1},{19946, 1},{19945, 1},
					{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},900),

	WYVERNS(28314, 28314, 28314, 28238,"Legendary Wyverns", 6,
			"","Requirements: @whi@1,200 Titan kills","",
			TeleportCategory.ZONES, new Position(3322, 3309, 0), -1, false, 3308, -1,
			new int[][] {{12855, 550}, {5022, 65}, {17712, 1},{17638, 1},{17640, 1},{15593, 1},{16140, 1},{2021, 1},{12860, 1},{12565, 1},
					{20173, 1}, {8803, 1}, {8804, 1}, {8805, 1}, {8812, 1}, {18831, 1}, {-1, -1}},1500),

	ONI(28315, 28315, 28315, 28239,"Oni", 7,
			"","Requirements: @whi@1,500 Wyvern kills","",
			TeleportCategory.ZONES, new Position(2907, 5455, 0), -1, false, 3117, -1,
			new int[][] {{12855, 650}, {5022, 75}, {15289, 1},{10025, 1},{17714, 1},{17686, 1},{15924, 1},{16023, 1},{15935, 1},{15888, 1},
					{15818, 1}, {12994, 1}, {8809, 1}, {8806, 1}, {8807, 1}, {8808, 1}, {-1, -1}},500),

	SHENRON(28316, 28316, 28316, 28240,"Super Shenron", 8,
			"","Requirements: @whi@2,500 Oni kills","",
			TeleportCategory.ZONES, new Position(2931, 5469, 0), -1, false, 201, -1,
			new int[][] {{12855, 750}, {5022, 80}, {15289, 1},{10025, 1},{12284,1},{15005, 1},{15006, 1},{15007, 1},{15008, 1},{15100, 1},
					{15200, 1}, {15201, 1}, {20549, 1}, {8800, 1}, {8801, 1}, {8802, 1}, {-1, -1}},1500),


	SUBZERO(28317, 28317, 28317, 28241,"Subzero", 9,
			"","Requirements: @whi@3,500 Shenron kills","",
			TeleportCategory.ZONES, new Position(2910, 5491, 0), -1, false, 202, -1,
			new int[][] {{12855, 1000}, {5022, 90}, {8803, 1},{8804, 1},{8805, 1},{20173, 1},{15289, 1},{10025, 1},{20542, 1},{13300, 1},
					{13301, 1}, {13304, 1}, {18683, 1}, {15511, 1}, {13306, 1}, {18817, 1}, {13302, 1}},650),


	ZEUS(28318, 28318, 28318, 28242,"Almighty Zeus", 10,
			"","Requirements: @whi@5,000 Subzero kills","",
			TeleportCategory.ZONES, new Position(2893, 5469, 0), -1, false, 203, -1,
			new int[][] {{12855, 1200}, {5022, 100}, {8803, 1},{8804, 1},{8805, 1},{20173, 1},{20488, 1},{21218, 7},{15289, 1},{10025, 2},
					{15230, 1}, {15231, 1}, {15232, 1}, {15233, 1}, {15234, 1}, {17662, 1}, {15235, 1}},900),


	IPOTANE(28319, 28319, 28319, 28243,"Ipotane", 11,
			"","Requirements: @whi@15,000 Zeus kills","",
			TeleportCategory.ZONES, new Position(2993, 3114, 0), -1, false, 8010, -1,
			new int[][] {{12855, 1500}, {5022, 125}, {8803, 1},{8804, 1},{8805, 1},{20173, 1},{15289, 1},{20488, 1},{10025, 1},{13640, 1},
					{15448, 1}, {21934, 1}, {19918, 1}, {19913, 1}, {13964, 1}, {3107, 1}, {15401, 1}},750),

	VINDICTA(28320, 28320, 28320, 28244,"Vindicta", 12,
			"","Requirements: @whi@25,000 Ipotane kills","",
			TeleportCategory.ZONES, new Position(2893, 5469, 0), -1, false, 9807, -1,
			new int[][] {{12855, 2000}, {5022, 150}, {23082, 1},{10947, 1},{22084, 1},{8326, 1},{8327, 1},{8328, 1},{22083, 1},{8330, 1},
					{8331, 1}, {8332, 1}, {22092, 1}, {8323, 1}, {8324, 1}, {8325, 1}, {15289, 1}},750),

	BORK(28321, 28321, 28321, 28245,"Bork", 13,
			"","Requirements: @whi@50,000 Vindicta kills","",
			TeleportCategory.ZONES, GameSettings.CYAN, -1, false, 7134, -1,
			new int[][] {{12855, 2500}, {5022, 175}, {23381,1},{10947, 1},{17594,1},{17596, 1},{17598, 1},{23099, 1},{19776, 1},{15289, 1},
					{20488, 1}, {10025, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},1000),
	ICE_NIHIL(28322, 28322, 28322, 28246,"Ice Nihil", 13,
			"","Requirements: @whi@75,000 Bork kills","",
			TeleportCategory.ZONES, new Position(2876, 5209, 0), -1, false, 9885, -1,
			new int[][] {{12855, 3000}, {5022, 200}, {23527,1},{10947, 1},{23522,1},{23523, 1},{23524, 1},{23525, 1},{23526, 1},{15289, 1},
					{20488, 1}, {10025, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}},750),
	;
	

	/** The name of the teleport. */
	private final int[][] items;
	public int[][] getItems() {
		return items;
	}

	private final String name;

	private int tier;
	public int getTier() {
		return tier;
	}

	private final String description;
	
	private final String req1;
	
	private final String req2;
	/** The type of the teleport. */
	private final TeleportCategory type;

	public final int buttonId;

	private int cblvl;

	private boolean wildy;

	private int npcId, spriteId;

	public int getSpriteId() {
		return spriteId;
	}

	public void setSpriteId(int spriteId) {
		this.spriteId = spriteId;
	}

	private int clickingid, textButtonId, backgroundButtonId;
	
	public int getTextButtonId() {
		return textButtonId;
	}

	public int getBackgroundButtonId() {
		return backgroundButtonId;
	}

	private Position position;

	private final int adjustedZoom;
	/** Creates a new <code>Teleport<code>. */ //might have to make it multidimensioanl
	//the format of the enumid
	TeleportData(int buttonId, int clickingid, int textButtonId, int backgroundButtonId, String name,int tier,
                  String description, String req1, String req2, TeleportCategory type, Position position,
                 int cblvl, boolean wildy, int npcId, int spriteId, int[][] items, int adjustedZoom) {
		//npcid is 3rd to last parameter
		//this.index = (index);
		this.buttonId = buttonId;
		this.clickingid = clickingid;
		this.textButtonId = textButtonId;
		this.backgroundButtonId = backgroundButtonId;
		this.name = name;
		this.tier = tier;
		this.description = description;
		this.req1 = req1;
		this.req2 = req2;
		this.type = type;
		this.cblvl = cblvl;
		this.wildy = wildy;
		this.npcId = npcId;
		this.position = position;
		this.spriteId = spriteId;
		this.items = items;
		this.adjustedZoom = adjustedZoom;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public String getName() {
		return name;
	}
	public int getAdjustedZoom() {
		return adjustedZoom;
	}
	public String getDescription() {
		return description;
	}
	public String getReq1() {
		return req1;
	}
	public String getReq2() {
		return req2;
	}

	public TeleportCategory getType() {
		return type;
	}

	public int getCblvl() {
		return cblvl;
	}

	public int getClickingId() {
		return clickingid;
	}

	public boolean getWildy() {
		return wildy;
	}

	public int getButtonId() {
		return buttonId;
	}

	public int getNpcId() {
		return npcId;
	}

}