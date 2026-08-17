package com.ruse.world.content.dissolving;

import com.ruse.engine.task.TaskManager;
import com.ruse.engine.task.impl.SupremeLairTask;
import com.ruse.model.Animation;
import com.ruse.model.Item;
import com.ruse.model.Skill;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.entity.impl.player.Player;

import java.util.HashMap;
import java.util.Map;

public class SupremeDissolving {

	private Player player;

	public SupremeDissolving(Player player) {
		this.player = player;
	}
	static int anim = 11904;
	static int SUPREME_ENERGY = 23426;
	public enum DissolvingData {
		PURIFIER_STAFF(8089, new Item[]{new Item(SUPREME_ENERGY, 50)}, 900_000, anim),
		JUDICATOR_BOW(8088, new Item[]{new Item(SUPREME_ENERGY, 50)}, 900_000, anim),
		DRAGON_LANCE(8087, new Item[]{new Item(SUPREME_ENERGY, 50)}, 900_000, anim),
		ENRAGED_SWORD(3737, new Item[]{new Item(SUPREME_ENERGY, 10)}, 50000, anim),
		BOTANIC_BOW(3738, new Item[]{new Item(SUPREME_ENERGY, 10)}, 50000, anim),
		ELEMENTAL_STAFF(3739, new Item[]{new Item(SUPREME_ENERGY, 10)}, 50000, anim),
		CREEPER_CAPE(1486, new Item[]{new Item(SUPREME_ENERGY, 20)}, 100_000, anim),
		CHAINSAW(22080, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15500, anim),
		HADESSHIELD(21035, new Item[]{new Item(SUPREME_ENERGY, 2)}, 16000, anim),
		VIGGORCHAIN(20554, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15000, anim),
		FLAMETHRO(17712, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12854, anim),
		FLAMETHRO_NOTE(17713, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12854, anim),
		HADESHAMMER(21034, new Item[]{new Item(SUPREME_ENERGY, 2)}, 16000, anim),
		HADESLEGS(21033, new Item[]{new Item(SUPREME_ENERGY, 2)}, 16000, anim),
		CREEPER_1(9054, new Item[]{new Item(SUPREME_ENERGY, 3)}, 18493, anim),
		CREEPER_2(9055, new Item[]{new Item(SUPREME_ENERGY, 3)}, 18493, anim),
		CREEPER_3(9056, new Item[]{new Item(SUPREME_ENERGY, 3)}, 18493, anim),
		CREEPER_4(9057, new Item[]{new Item(SUPREME_ENERGY, 3)}, 18493, anim),
		CREEPER_5(9058, new Item[]{new Item(SUPREME_ENERGY, 3)}, 18493, anim),
		CREEPER_6(9059, new Item[]{new Item(SUPREME_ENERGY, 3)}, 18493, anim),
		SWOODOO(19149, new Item[]{new Item(SUPREME_ENERGY, 2)}, 16000, anim),
		SWOODOO_4(16055, new Item[]{new Item(SUPREME_ENERGY, 2)}, 16000, anim),
		SWOODOO_NOTE(19150, new Item[]{new Item(SUPREME_ENERGY, 2)}, 16000, anim),
		SWOODOO_2(12930, new Item[]{new Item(SUPREME_ENERGY, 2)}, 16000, anim),
		SWOODOO_3(4405, new Item[]{new Item(SUPREME_ENERGY, 2)}, 16000, anim),
		SWOODOO_3_NOTE(4406, new Item[]{new Item(SUPREME_ENERGY, 2)}, 16000, anim),
		SWOODOO_5(16077, new Item[]{new Item(SUPREME_ENERGY, 2)}, 16000, anim),
		SWOODOO_6(16066, new Item[]{new Item(SUPREME_ENERGY, 2)}, 16000, anim),
		SWOODOO_7(16114, new Item[]{new Item(SUPREME_ENERGY, 2)}, 16000, anim),
		SWOODOO_8(16011, new Item[]{new Item(SUPREME_ENERGY, 2)}, 16000, anim),
		HADESBODY(21032, new Item[]{new Item(SUPREME_ENERGY, 2)}, 16000, anim),
		HADESHELM(21031, new Item[]{new Item(SUPREME_ENERGY, 2)}, 16000, anim),
		ELECTRICBOOTS(15236, new Item[]{new Item(SUPREME_ENERGY, 1)}, 11900, anim),
		ELECTRICGLOVES(15235, new Item[]{new Item(SUPREME_ENERGY, 1)}, 11900, anim),
		GRO_BOOTS(3107, new Item[]{new Item(SUPREME_ENERGY, 3)}, 18493, anim),
		GRO_STAFF(13640, new Item[]{new Item(SUPREME_ENERGY, 3)}, 18493, anim),
		GRO_SHIELD(13964, new Item[]{new Item(SUPREME_ENERGY, 3)}, 18493, anim),
		GRO_SHIELD_NOTE(13965, new Item[]{new Item(SUPREME_ENERGY, 3)}, 18493, anim),
		GRO_POWER(15448, new Item[]{new Item(SUPREME_ENERGY, 3)}, 18493, anim),
		GRO_HELM(21934, new Item[]{new Item(SUPREME_ENERGY, 3)}, 18493, anim),
		GRO_BODY(19918, new Item[]{new Item(SUPREME_ENERGY, 3)}, 18493, anim),
		GRO_LEG(19913, new Item[]{new Item(SUPREME_ENERGY, 3)}, 18493, anim),
		T4_MELEE1(8326, new Item[]{new Item(SUPREME_ENERGY, 8)}, 60_000, anim),
		T4_MELEE2(8327, new Item[]{new Item(SUPREME_ENERGY, 8)}, 60_000, anim),
		T4_MELEE3(8328, new Item[]{new Item(SUPREME_ENERGY, 8)}, 60_000, anim),
		T4_MELEE4(22084, new Item[]{new Item(SUPREME_ENERGY, 8)}, 60_000, anim),
		T4_RANGE1(8330, new Item[]{new Item(SUPREME_ENERGY, 8)}, 60_000, anim),
		T4_RANGE2(8331, new Item[]{new Item(SUPREME_ENERGY, 8)}, 60_000, anim),
		T4_RANGE3(8332, new Item[]{new Item(SUPREME_ENERGY, 8)}, 60_000, anim),
		T4_RANGE4(22083, new Item[]{new Item(SUPREME_ENERGY, 8)}, 60_000, anim),
		T4_MAGIC1(8323, new Item[]{new Item(SUPREME_ENERGY, 8)}, 60_000, anim),
		T4_MAGIC2(8325, new Item[]{new Item(SUPREME_ENERGY, 8)}, 60_000, anim),
		T4_MAGIC3(8324, new Item[]{new Item(SUPREME_ENERGY, 8)}, 60_000, anim),
		T4_MAGIC4(22092, new Item[]{new Item(SUPREME_ENERGY, 8)}, 60_000, anim),
		COLLECTOR_RING(4446, new Item[]{new Item(SUPREME_ENERGY, 30)}, 150_000, anim),
		COLLECTOR_AMULET(19886, new Item[]{new Item(SUPREME_ENERGY, 30)}, 150_000, anim),
		COLLECTOR_RING_ii(18823, new Item[]{new Item(SUPREME_ENERGY, 60)}, 250_000, anim),
		COLLECTOR_AMULET_ii(19888, new Item[]{new Item(SUPREME_ENERGY, 60)}, 250_000, anim),
		COLLECTOR_RING_iiI(18818, new Item[]{new Item(SUPREME_ENERGY, 100)}, 350_000, anim),
		COLLECTOR_AMULET_iiI(18888, new Item[]{new Item(SUPREME_ENERGY, 100)}, 350_000, anim),
		CORRUPT_ARCHIE1(18636, new Item[]{new Item(SUPREME_ENERGY, 30)}, 150_000, anim),
		CORRUPT_ARCHIE2(18638, new Item[]{new Item(SUPREME_ENERGY, 30)}, 150_000, anim),
		CORRUPT_ARCHIE3(18748, new Item[]{new Item(SUPREME_ENERGY, 30)}, 150_000, anim),
		CORRUPT_ARCHIE4(18749, new Item[]{new Item(SUPREME_ENERGY, 30)}, 150_000, anim),
		CORRUPT_MOONLIGHT1(18623, new Item[]{new Item(SUPREME_ENERGY, 30)}, 150_000, anim),
		CORRUPT_MOONLIGHT2(18629, new Item[]{new Item(SUPREME_ENERGY, 30)}, 150_000, anim),
		CORRUPT_MOONLIGHT3(18631, new Item[]{new Item(SUPREME_ENERGY, 30)}, 150_000, anim),
		CORRUPT_MOONLIGHT4(18637, new Item[]{new Item(SUPREME_ENERGY, 30)}, 150_000, anim),
		CORRUPT_MAXIBLOOD1(18750, new Item[]{new Item(SUPREME_ENERGY, 30)}, 150_000, anim),
		CORRUPT_MAXIBLOOD2(18751, new Item[]{new Item(SUPREME_ENERGY, 30)}, 150_000, anim),
		CORRUPT_MAXIBLOOD3(18752, new Item[]{new Item(SUPREME_ENERGY, 30)}, 150_000, anim),
		CORRUPT_MAXIBLOOD4(18753, new Item[]{new Item(SUPREME_ENERGY, 30)}, 150_000, anim),
		CASE_KEY(4186, new Item[]{new Item(SUPREME_ENERGY, 20)}, 100_000, anim),
		SERAPHIC_CASE(23411, new Item[]{new Item(SUPREME_ENERGY, 20)}, 100_000, anim),
		ETHEREAL_CASE(23412, new Item[]{new Item(SUPREME_ENERGY, 20)}, 100_000, anim),
		AGONY_WINGS(8810, new Item[]{new Item(SUPREME_ENERGY, 3)}, 20_000, anim),
		WOOS_CAPE(4367, new Item[]{new Item(SUPREME_ENERGY, 8)}, 60_000, anim),
		WOOS_CAPE_NOTED(4368, new Item[]{new Item(SUPREME_ENERGY, 8)}, 60_000, anim),
		PURIFIER1(11421, new Item[]{new Item(SUPREME_ENERGY, 50)}, 325_000, anim),
		PURIFIER2(11422, new Item[]{new Item(SUPREME_ENERGY, 50)}, 325_000, anim),
		PURIFIER3(11423, new Item[]{new Item(SUPREME_ENERGY, 50)}, 325_000, anim),
		PURIFIER4(7640, new Item[]{new Item(SUPREME_ENERGY, 50)}, 325_000, anim),
		JUDICATOR1(11340, new Item[]{new Item(SUPREME_ENERGY, 50)}, 325_000, anim),
		JUDICATOR2(11341, new Item[]{new Item(SUPREME_ENERGY, 50)}, 325_000, anim),
		JUDICATOR3(11342, new Item[]{new Item(SUPREME_ENERGY, 50)}, 325_000, anim),
		JUDICATOR4(19843, new Item[]{new Item(SUPREME_ENERGY, 50)}, 325_000, anim),
		DRAGONRIDER1(11320, new Item[]{new Item(SUPREME_ENERGY, 50)}, 325_000, anim),
		DRAGONRIDER2(11321, new Item[]{new Item(SUPREME_ENERGY, 50)}, 325_000, anim),
		DRAGONRIDER3(11322, new Item[]{new Item(SUPREME_ENERGY, 50)}, 325_000, anim),
		DRAGONRIDER4(4178, new Item[]{new Item(SUPREME_ENERGY, 50)}, 325_000, anim),
		empgloves(8812, new Item[]{new Item(SUPREME_ENERGY, 1)}, 1240, anim),
		LAVARING(15401, new Item[]{new Item(SUPREME_ENERGY, 1)}, 1240, anim),
		SHADOWAMULET(11195, new Item[]{new Item(SUPREME_ENERGY, 1)}, 1240, anim),
		WINGSHIELD(19749, new Item[]{new Item(SUPREME_ENERGY, 1)}, 1240, anim),
		ARTRING(8335, new Item[]{new Item(SUPREME_ENERGY, 1)}, 1240, anim),

		ZEUSCAPEFLAG(17662, new Item[]{new Item(SUPREME_ENERGY, 3)}, 17493, anim),
		ZEUSSEIHLD(15234, new Item[]{new Item(SUPREME_ENERGY, 3)}, 17493, anim),
		ZEUSHAMMER(15233, new Item[]{new Item(SUPREME_ENERGY, 3)}, 17493, anim),
		ZEUSLEGS(15232, new Item[]{new Item(SUPREME_ENERGY, 3)}, 17493, anim),
		ZEUSBODY(15231, new Item[]{new Item(SUPREME_ENERGY, 3)}, 17493, anim),
		ZEUSHELM(15230, new Item[]{new Item(SUPREME_ENERGY, 3)}, 17493, anim),
		SATANRING(18817, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15535, anim),
		SATANSWORD(20542, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15535, anim),
		SATANCAPE(18683, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15535, anim),
		SATANSHIELD(13306, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15535, anim),
		SATANAMULET(15511, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15535, anim),
		SATANBOOTS(13305, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15535, anim),
		SCYTHEOFVITUS(20555, new Item[]{new Item(SUPREME_ENERGY, 2)}, 14421, anim),
		SATANLEGS(13304, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15535, anim),
		KINGHELM(15922, new Item[]{new Item(SUPREME_ENERGY, 1)}, 11999, anim),
		KINGLEGS(15933, new Item[]{new Item(SUPREME_ENERGY, 1)}, 11999, anim),
		KINGOBDY(16021, new Item[]{new Item(SUPREME_ENERGY, 1)}, 11999, anim),
		BULWARKHELM(8816, new Item[]{new Item(SUPREME_ENERGY, 1)}, 11999, anim),
		BULWARKBODY(8817, new Item[]{new Item(SUPREME_ENERGY, 1)}, 11999, anim),
		BULWARKLEGS(8818, new Item[]{new Item(SUPREME_ENERGY, 1)}, 11999, anim),
		SATNAGLOVES(13302, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15535, anim),
		SATANBODY(13301, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15535, anim),
		SATANHELMET(13300, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15535, anim),
		SHIKRUUKATANA(20549, new Item[]{new Item(SUPREME_ENERGY, 3)}, 14000, anim),
		SHIKRUUHELMET(8800, new Item[]{new Item(SUPREME_ENERGY, 3)}, 14000, anim),
		SHIKRUUBODY(8801, new Item[]{new Item(SUPREME_ENERGY, 3)}, 14000, anim),
		SHIKRUULEGS(8802, new Item[]{new Item(SUPREME_ENERGY, 3)}, 14000, anim),
		SORROWBOW(20173, new Item[]{new Item(SUPREME_ENERGY, 3)}, 14000, anim),
		SORROWHELMET(8803, new Item[]{new Item(SUPREME_ENERGY, 3)}, 14000, anim),
		SORROWBODY(8804, new Item[]{new Item(SUPREME_ENERGY, 3)}, 14000, anim),
		SORROWCHAPS(8805, new Item[]{new Item(SUPREME_ENERGY, 3)}, 14000, anim),
		GANOSTAFF(8809, new Item[]{new Item(SUPREME_ENERGY, 3)}, 14000, anim),
		GANOHLMET(8806, new Item[]{new Item(SUPREME_ENERGY, 3)}, 14000, anim),
		GANOBODY(8807, new Item[]{new Item(SUPREME_ENERGY, 3)}, 14000, anim),
		GANOLEGS(8808, new Item[]{new Item(SUPREME_ENERGY, 3)}, 14000, anim),
		PREDATOR1(8834, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15000, anim),
		PREDATOR2(8835, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15000, anim),
		PREDATOR3(8860, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15000, anim),
		PREDATOR4(8807, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15000, anim),
		PREDATOR5(8861, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15000, anim),
		PREDATOR6(8862, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15000, anim),
		PREDATOR7(15830, new Item[]{new Item(SUPREME_ENERGY, 2)}, 15000, anim),
		TITANSTAFF(17600, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12300, anim),
		TITANCAPE(19944, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12300, anim),
		TITANHELMET(703, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12300, anim),
		TITANLEGS(705, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12300, anim),
		TITANBODY(704, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12300, anim),
		TITANBOOTS(19945, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12300, anim),
		TITANGLOVES(19946, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12300, anim),
		AGNELICHELMET(17638, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12999, anim),
		ANGELBODY(17640, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12999, anim),
		ANGELOEGS(15593, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12999, anim),
		ANGELICAMULET(16140, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12999, anim),
		ANGELICGLOVES(12860, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12999, anim),
		ANGELICWINGS(2021, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12999, anim),
		ANGLICBOOTS(12565, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12999, anim),
		LUCIENAXE(17714, new Item[]{new Item(SUPREME_ENERGY, 2)}, 14392, anim),
		LUCIENWINGS(17686, new Item[]{new Item(SUPREME_ENERGY, 2)}, 14392, anim),
		LUCIENHELMET(15924, new Item[]{new Item(SUPREME_ENERGY, 2)}, 14392, anim),
		LUCIENBODY(16023, new Item[]{new Item(SUPREME_ENERGY, 2)}, 14392, anim),
		LUCIENLEGS(15935, new Item[]{new Item(SUPREME_ENERGY, 2)}, 14392, anim),
		LUUCIENWHIP(15888, new Item[]{new Item(SUPREME_ENERGY, 2)}, 14392, anim),
		LUCIENDEFENDER(15818, new Item[]{new Item(SUPREME_ENERGY, 2)}, 14392, anim),
		LUCIENGLOVES(12994, new Item[]{new Item(SUPREME_ENERGY, 2)}, 14392, anim),
		HERCHELMET(15005, new Item[]{new Item(SUPREME_ENERGY, 2)}, 14392, anim),
		LUCIENBOOTS(16272, new Item[]{new Item(SUPREME_ENERGY, 2)}, 14392, anim),
		HERCULESSCYTHE(12284, new Item[]{new Item(SUPREME_ENERGY, 2)}, 14865, anim),
		HERCULESCAPE(15100, new Item[]{new Item(SUPREME_ENERGY, 2)}, 14865, anim),
		HERCULESBODY(15006, new Item[]{new Item(SUPREME_ENERGY, 2)}, 14865, anim),
		HERCULESSHIELD(15008, new Item[]{new Item(SUPREME_ENERGY, 2)}, 14865, anim),
		HERCULESLEGS(15007, new Item[]{new Item(SUPREME_ENERGY, 2)}, 14865, anim),
		HERCULESGLOVES(15200, new Item[]{new Item(SUPREME_ENERGY, 2)}, 4101, anim),
		HERCULESBOOTS(15201, new Item[]{new Item(SUPREME_ENERGY, 2)}, 4101, anim),
		TTTORVAHELMET(6927, new Item[]{new Item(SUPREME_ENERGY, 1)}, 4101, anim),
		TTTORVALEGS(6929, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12000, anim),
		TTROVABODY(6928, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12000, anim),
		TTPERNIXHLMET(6930, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12000, anim),
		SHUKAHELMET(8813, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12000, anim),
		SHUKAHBODY(8814, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12000, anim),
		SHUKAHLEGS(8815, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12000, anim),
		TTPERNIXBODY(6931, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12000, anim),
		TTPERNIXLEGS(6932, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12000, anim),
		TTVIRTUSMASK(6933, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12000, anim),
		TTVIRTUSBODY(6934, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12000, anim),
		TTVIRTUSLEGS(6935, new Item[]{new Item(SUPREME_ENERGY, 1)}, 12000, anim),
		CYANTORVAHELMET(19931, new Item[]{new Item(SUPREME_ENERGY, 1)}, 2100, anim),
		CYANTORVABODY(19933, new Item[]{new Item(SUPREME_ENERGY, 1)}, 2100, anim),
		CYANTORVALEGS(19934, new Item[]{new Item(SUPREME_ENERGY, 1)}, 2100, anim),
		ARCRAPIER(19919, new Item[]{new Item(SUPREME_ENERGY, 1)}, 2100, anim),
		ARCMACE(19917, new Item[]{new Item(SUPREME_ENERGY, 1)}, 2100, anim),
		CYANRING(7927, new Item[]{new Item(SUPREME_ENERGY, 1)}, 2100, anim),
		POTION_OF_FLIGHT(18719, new Item[]{new Item(SUPREME_ENERGY, 7)}, 1500, anim),
		COFFIN_OF_THE_DAMNED(7587, new Item[]{new Item(SUPREME_ENERGY, 7)}, 1500, anim),
		DEFAULT(1, new Item[]{new Item(SUPREME_ENERGY, 1)}, 4101, anim);

		DissolvingData(int id, Item[] rewards, int experience, int animation) {
			this.id = id;
			this.rewards = rewards;
			this.experience = experience;
			this.animation = animation;
		}

		private int id, experience, animation;

		public int getId() {
			return id;
		}
		public int getExperience() {
			return experience;
		}
		public int getAnimation() {
			return animation;
		}
		public int getreward() {
			return rewards[0].getId();
		}
		public int getrewardamt() {
			return rewards[0].getAmount();
		}

		private Item[] rewards;
		public Item[] getRewards() {
			return rewards;
		}

		public ItemDefinition getDefinition() {
			return ItemDefinition.forId(id);
		}
	}

	public int amtafterdissolvingall = 0;

	public void handle(int id) {
		for(DissolvingData data : DissolvingData.values()) {
			if(data.getId() == id) {
				player.getInventory().delete(id, 1);
				player.getInventory().addItemSet(data.getRewards());
				player.getSkillManager().addExperience(Skill.INVENTION, data.getExperience());
				player.performAnimation(new Animation(data.getAnimation()));
				player.getPacketSender().sendMessage("You dissolved " + ItemDefinition.forId(id).getName() +" for " + Misc.insertCommasToNumber(data.getRewards()[0].getAmount()) +" Levincia tokens" );
				break;
			}
		}
		
	}

	private static Map<Integer, DissolvingData> dataMap = new HashMap<Integer, DissolvingData>();
		static {
			for (DissolvingData data : DissolvingData.values()) {
				dataMap.put(data.getId(),data);
			}
	}

	public void handleAll(int id) {
		for(DissolvingData data : DissolvingData.values()) {
			if(data.getId() == id) {
				player.getInventory().add(data.getreward(),data.getrewardamt() * player.getInventory().getAmount(data.getId()));
				player.howmuchdissolveamt+=data.getrewardamt() * player.getInventory().getAmount(data.getId());
				player.getSkillManager().addExperience(Skill.INVENTION, data.getExperience() * player.getInventory().getAmount(data.getId()));
				player.getPacketSender().sendMessage("You dissolved " + ItemDefinition.forId(id).getName() +" for " + Misc.insertCommasToNumber(data.getrewardamt() * player.getInventory().getAmount(data.getId())) +" Supreme Energy" );
				player.getInventory().delete(id, player.getInventory().getAmount(data.getId()));//only 1 gets dissolved is it possible to make it the amount of the stack in inventory
				player.performAnimation(new Animation(-1));
				TaskManager.submit(new SupremeLairTask(player));
				break;
			}
		}
	}

	public int handleAllAmount(int slot) {
		return dataMap == null ? 0 : dataMap.get(player.getInventory().get(slot).getId()).getrewardamt() * player.getInventory().get(slot).getAmount();
	}

}

