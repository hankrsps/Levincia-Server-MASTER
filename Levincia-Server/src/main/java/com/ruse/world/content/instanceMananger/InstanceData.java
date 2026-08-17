package com.ruse.world.content.instanceMananger;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InstanceData {

	EMBER_GIANT(9838, "Ember Giant", 1500),
	TREE_BASILISK(1718, "Tree Gorgon", 2000),
	AQUANITE(9172, "Aquanite", 1800),
	GIANT_SPIDER( 117, "Arachne", 1700),
	CASH_DRAGONS( 500, "Cash Dragon", 2500),
	DEMON_GODDESS(501, "Demon Goddess", 1800),
	ENERGY_SKELETONS(503, "Energy Skeleton", 1500),
	TUROTHS(1627, "Turoth", 800),
	LORD(603, "Lord", 2600),
	SHADOW_HUNTERS(12843, "Shadow Hunter", 1400),
	GOLEM(53, "Jynx Golem", 1200),
	SHETANI( 8018, "Shetani", 1200),
	TITANIUM_RIPPER(13635, "Titanium Ripper", 2000),
	TITAN(8008, "Avatar Titan", 1800),
	WYVERNS(3308, "Legendary Wyvern", 3800),
	ONI( 3117, "Oni", 1250),
	SHENRON(201, "Shenron" , 2700),
	SUBZERO(202, "Subzero", 1300),
	ZEUS( 203, "Zeus", 1300),
	IPOTANE(8010, "Ipotane", 1300),
	VINDICTA(9807, "Vindicta", 2000),
	BORK(7134, "Bork", 3200),
	NIHIL(9885, "Ice Nihil", 1850),
	HANTO( 250, "Hanto", 1300),
	RADITZ(449, "Raditz", 1300),
	GOKU(452, "Goku", 1300),
	BOTANIC( 2342, "Botanic Guardian", 3500),
	ENRAGED_GUARDIAN(2949, "Enraged Guardian", 1500),
	ELEMENTAL_GUARDIAN(505, "Elemental Guardian", 3500),
	INNUYASHA(185, "Inuyasha", 1300),
	TOLOROKOTH(6430, "Tolrokoth", 2000),

	FACELESS_MAGICIAN(9116, "Faceless Magician", 1100),
	LOTUS_MAGICIAN(9117, "Lotus Magician", 1100),
	SHADOW_MAGICIAN(9118, "Shadow Magician", 1100),

	IMMORTAL_WARRIOR(2359, "Immortal Warrior", 1100),
	LESARKUS_WARRIOR(277, "Lesarkus Warrior", 1100),
	FATAL_WARRIOR(1914, "Fatal Warrior", 1100),

	FOREST_ARCHER(1508, "Forest Archer", 1100),
	CHAOTIC_ARCHER(1458, "Chaotic Archer", 1100),
	DIVINE_ARCHER(1457, "Divine Archer", 1100),

	;

	private int npcId;
	private String name;
	private int zoom;
}
