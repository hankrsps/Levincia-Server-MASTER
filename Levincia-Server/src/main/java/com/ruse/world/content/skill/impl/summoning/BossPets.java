package com.ruse.world.content.skill.impl.summoning;

import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;
import lombok.Getter;

public class BossPets {

	@Getter
	public enum BossPet {

		// UPGRADABLE PETS
		WOLF_PET(4414, 4414,459,1000,"1% DR Bonus"),
		GORILLA_PET(3001,3001, 460,1000,"3% DR Bonus"),
		MARIO_PET(1892, 1892,5508,1000,"5% DR Bonus"),
		DONKEY_KONG_PET(1894,1894, 5506,1000,"7% DR Bonus"),
		VEGETA_PET(5001,5001, 461,1000,"10% DR Bonus"),
		YOSHI_PET(3377,3377, 462,1000,"15% DR Bonus"),
		TOLROKOTH_PET(6431,6431, 14067,1000,"15% DR Bonus"),
		ZORBAK_PET(1906,1906, 11319,1000,"25% DR Bonus"),
		RAICHU_PET(1801,1801, 11318,1000,"50% DR & 15% DMG"),

		HOOKER(4444,4444, 20511,1000,""),
		//Boss pets & Minigame pets
		FALLEN_ANGEL_PET(9013,9013, 22107,1000,"60% DR & 25% DMG"),
		FENRIR_PET(9830,9830, 23108,1000,"50% DR & 25% DMG"),
		GREEN_FENRIR_PET(9831,9831, 23109,1000,"50% DR & 25% DMG"),
		RED_FENRIR_PET(9832,9832, 23110,1000,"50% DR & 25% DMG"),
		VOTE_PET(8802,8802, 11316,1000,"Doubles your Votes"),
		HELLRAISER(302,302, 11314,1000,"10% DR & X2 KC"),
		RAMMUS_PET(9822,9822, 23164,1000,"100% key drop & 25% DR"),
		DEMON_PET(9819,9819, 23161,1000,"100% key drop & 25% DR"),
		GOLEM_PET(9821,9821, 23163,1000,"100% key drop & 25% DR"),
		DRAGON_PET(9820,9820, 23162,1000,"100% key drop & 25% DR"),
		IRONS_PET(9016,9016, 22116,1000,"60% DR Bonus"),
		SUMMER_SURFER(9120,9120, 23323,1000,"60% DR Bonus & 20% DMG"),
		FACELESS_MAGICIAN(9121,9121, 23324,1000,"45% DR & 25% DMG"),
		LOTUS_MAGICIAN(9122,9122, 23325,1000,"45% DR & 25% DMG"),
		SHADOW_MAGICIAN(9123,9123, 23326,1000,"45% DR & 25% DMG"),
		LESARKUS_WARRIOR(9124,9124, 23387,1000,"45% DR & 25% DMG"),
		VAMPIRE_WARRIOR(9125,9125, 23388,1000,"45% DR & 25% DMG"),
		ELF_WARRIOR(9126, 9126,23389,1000,"45% DR & 25% DMG"),
		BLOOD_DEMON_PET(204,204, 23252,1000,"70% DR & 30% DMG"),
		VINDICTA_PET(9809,9809, 23082,1000,"50% DR Bonus"),
		BORK_PET(225,225, 23381,1000,"60% DR Bonus"),
		NIHIL_PET(9886,9886, 23527,1000,"65% DR Bonus & 5% DMG"),
		SPIRIT_OF_SCORPIUS(4594,4594, 23436,1000,"70% DR & 25% DMG"),
		KRAMPUS_PET(12006,12006, 23685,700,"75% DR & 20% DMG"),
		EVIL_SCORPIUS(4592,4592, 23437,1000,"80% DR & 35% DMG"),



		FOREST_ARCHER(1507,1507, 13223,400,"45% DR & 25% DMG"),
		CHAOTIC_ARCHER(1455,1455, 13224,400,"45% DR & 25% DMG"),
		DIVINE_ARCHER(1456, 1456,13225,400,"45% DR & 25% DMG"),


		YUGI_MOTO(10038,10038, 10483,1000,"90% DR & 30% DMG"),
		DARK_MAGICIAN(10039,10039, 10484,1000,"90% DR & 30% DMG"),
		ARMED_PROTECTOR(10040, 10040,10485,1000,"90% DR & 30% DMG"),
		EXODIA(10041, 10041,10486,1000,"90% DR & 30% DMG"),

		BEWD(4969, 4969,11426,1000,"115% DR & 60% DMG"),

		TURKEY(9861, 8499,23511,750,"60% DR and 10% DMG"),
		TURKEY1(9862,8499, 23512,750,"70% DR and 20% DMG"),
		TURKEY2(9863,8499, 23513,750,"70% DR and 20% DMG"),
		TURKEY3(9864,8499, 23514,750,"70% DR and 20% DMG"),
		TURKEY4(9865,8499, 23515,750,"70% DR and 20% DMG"),
		TURKEY5(9866,8499, 23516,750,"70% DR and 20% DMG"),
		TURKEY6(9867,8499, 23517,750,"70% DR and 20% DMG"),
		TURKEY7(9868,8499, 23518,750,"70% DR and 20% DMG"),

		NECROMANCER(9895,9895, 22954,1000,"100% DR & 50% DMG"),
		;
		BossPet(int npcId, int spawnNpcId, int itemId,int zoom, String boost) {
			this.npcId = npcId;
			this.spawnNpcId = spawnNpcId;
			this.itemId = itemId;
			this.zoom = zoom;
			this.boost = boost;
		}
		public int npcId,spawnNpcId, itemId, zoom = 800;
		public String boost = "None";

		public static BossPet forId(int itemId) {
			for (BossPet p : BossPet.values()) {
				if (p != null && p.itemId == itemId) {
					return p;
				}
			}
			return null;
		}

		public static BossPet forSpawnId(int spawnNpcId) {
			for (BossPet p : BossPet.values()) {
				if (p != null && p.npcId == spawnNpcId) {
					return p;
				}
			}
			return null;
		}
	}

	public static boolean pickup(Player player, NPC npc) {
		BossPet pet = BossPet.forSpawnId(npc.getId());
		if (pet != null) {
			if (player.getInventory().getFreeSlots() < 1) {
				player.getPacketSender().sendMessage("You need a free inventory space to pick up a pet.");
				return false;
			}
			if (player.getSummoning().getFamiliar() != null
					&& player.getSummoning().getFamiliar().getSummonNpc() != null
					&& player.getSummoning().getFamiliar().getSummonNpc().isRegistered()) {
				if (player.getSummoning().getFamiliar().getSummonNpc().getId() == pet.npcId
						&& player.getSummoning().getFamiliar().getSummonNpc().getIndex() == npc.getIndex()) {
					player.getSummoning().unsummon(true, true);
					player.getPacketSender().sendMessage("You pick up your pet.");
					return true;
				} else {
					player.getPacketSender().sendMessage("This is not your pet to pick up.");
				}
			} else {
				player.getPacketSender().sendMessage("This is not your pet to pick up.");
			}
		}
		return false;
	}

}
