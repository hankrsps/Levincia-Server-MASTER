package org.necrotic.client.cache.definition;

import org.necrotic.client.Client;
import org.necrotic.client.List;
import org.necrotic.client.cache.Archive;
import org.necrotic.client.graphics.DrawingArea;
import org.necrotic.client.graphics.Sprite;
import org.necrotic.client.io.ByteBuffer;
import org.necrotic.client.world.Model;
import org.necrotic.client.world.Rasterizer;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;

public final class ItemDefinition {
	public int rdc = 0;
	public int rdc2 = 0;
	public int rdc3 = 0;
	private static final int[] BLACK_FIX = {5073,11341, 13101, 13672, 13675, 6568, 10636, 12158, 12159, 12160, 12161, 12162, 12163, 12164, 12165, 12166, 12167, 12168, 12527, 18017, 18018, 18019, 18020, 3140, 13481, 14479, 14481, 19337, 19342};
	private static ByteBuffer buffer;
	boolean animateInventory = true; //Use selectively, not on everything
	private Object lentID;
	public static boolean isMembers = true;
	public static List mruNodes1 = new List(100);
	public static List mruNodes2 = new List(50);
	private static int[] streamIndices;
	public static int totalItems;


	public double maleModelScale = 1;

	public static void applyTexturing(Model model, int id) {
		switch (id) {

			case 299:
				model.setTexture(87);
				break;
			case 15084:
				model.setTexture(87);
				break;
			case 22006:
				model.setTexture(71);
				break;

			case 22005:
			case 23258:
				model.setTexture(121);
				break;
			case 7543:
			case 7544:
			case 7545:
				model.setTexture(81);
				break;
			case 16249:
			case 15832:
				model.setTexture(86);
				break;
				
			case 17714:
			case 17686:
			case 15888:
			case 12994:
				model.setTexture(12);
				break;
			case 18683:
			case 15511:
			case 13306:
				//	case 17606:
				model.setTexture(111);
				break;
			case 23447://Necromancer key
				model.setTexture(119);
				break;
			case 15328:
				model.setTexture(76);
				break;
			case 15330:
				model.setTexture(127);
				break;
			case 21013:
				model.setTexture(55, 4018);
				break;
			case 4888:
			case 18747:
				model.setTexture(71);
				break;
			case 17702:
				model.setTexture(57);
				break;
			case 22089:
			case 11759:
			case 11182:
			case 11181:
				model.setTexture(56);
				break;
			case 15026:
			case 18332:
			case 10696:
				model.setTexture(68);
				break;
            /*case 7478:
                model.setTexture(76);
                break;*/
			case 20073:
			case 19800:
			case 19802:
			case 9929:
				model.setTexture(88);
				break;
			case 14377:
				model.setTexture(69);
				break;
			case 14053:
			case 14055:
			case 14056:
			case 14054:
				model.setTexture(98);
				break;
			case 9080:
				model.setTexture(62);
				break;

			case 9081:
				model.setTexture(66);
				break;

			case 9082:
				model.setTexture(78);
				break;

			case 18883:
			case 17540:
				model.setTexture(93);
				break;

			case 10795:
				model.setTexture(52);
				break;

			case 18885:
				model.setTexture(78);

				break;
			case 4569:
				model.setTexture(60);
				break;
			case 6183:
				model.setTexture(61);
				break;
			case 15246:
			case 6855:
				model.setTexture(70);
				break;
			case 4570:
				model.setTexture(66);
				break;
			case 8840:
				model.setTexture(11, 10, 100);
				break;
			case 19892:
			case 11140:
			case 16137:

				model.setTexture(62);
				break;
			case 13640:
			case 3107:
			case 13964:
			case 15448:
				model.setTexture(126);

				break;
			case 23240:
			case 23242:
				model.setTexture(52);
				break;

			case 15449:
				model.setTexture(64);

				break;
			case 15450:
				model.setTexture(62);

				break;
			case 20533:
				model.setTexture(51);
				break;
			case 7643:
				model.setTexture(80);
				break;
			case 14910:
			case 14911:
			case 14912:
			case 14913:
			case 14914:
			case 14915:
				model.setTexture(52);
				break;
			case 14921:
			case 14922:
			case 14923:
			case 14924:
			case 14925:
				model.setTexture(51);
				break;
				
			case 23225:
				model.setTexture(128);
				break;

			case 10830:
				model.setTexture(52);
				break;

			case 14916:
			case 14917:
			case 14918:
			case 14919:
			case 14920:
				model.setTexture(30);
				break;
			case 7642:
				model.setTexture(75);
				break;
			case 7927:
				model.setTexture(56);
			case 20438:
			case 757:
				model.setTexture(57);
				break;

			case 19886:
			case 4446:
				model.setTexture(115);
				break;
				
			case 19888:
			case 18823:
				model.setTexture(129);
				break;

			case 18888:
			case 18818:
			case 16043:
			case 20118:
				model.setTexture(63);
				break;
			case 12860:
			case 12565:
			case 2021:
			case 16140:
				model.setTexture(121);
				break;
			case 16133:
			case 15920:
				model.setTexture(67);
				break;


			case 20054:
			case 882:


			case 18784:
				model.setTexture(77);
				break;
			case 18783:
				model.setTexture(54);
				break;
			case 4387:
				model.setTexture(84);
				break;
			case 18665:
			case 3849:
				model.setTexture(82);
				break;
			case 16269:
			case 15943:
			case 15877:
				model.setTexture(76);
				break;
			case 19149:
			case 16055:
			case 16077:
			case 16066:
			case 16011:
			case 16114:
			case 12930:
				model.setTexture(60);
				break;
			case 16337:
			case 19887:
				model.setTexture(122);
				break;
			case 6629:
			case 15043:
			case 5424:
			case 5432:
				model.setTexture(81);
				break;
		}
	}

	public static void dumpItemModelsForId(int i) {
		try {
			ItemDefinition d = get(i);

			if (d != null) {
				int[] models = {d.maleEquip1, d.femaleEquip1, d.modelID,};

				for (int ids : models) {// 13655
					if (ids > 0) {
						try {
							System.out.println("Dumping item model: " + ids);
							byte abyte[] = Client.instance.decompressors[1].decompress(ids);
							File map = new File("./models/" + ids + ".gz");
							FileOutputStream fos = new FileOutputStream(map);
							fos.write(abyte);
							fos.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static HashMap<Integer, ItemDefinition> map = new HashMap<>();

	public static ItemDefinition get(int id) {
		ItemDefinition itemDef = map.get(id);
		if (itemDef != null) {
			return itemDef;
		}
		itemDef = new ItemDefinition();

		if (id > streamIndices.length) {
			id = streamIndices.length - 1;
		}

		buffer.position = streamIndices[id];
		itemDef.id = id;
		//buffer.position = streamIndices[id];
		//	itemDef.readValues(buffer);

		itemDef.setDefaults();

		/*
		 * if (Hardcode.readOSRSItem(itemDef)) { if (!itemDef.name.contains("hat") &&
		 * !itemDef.name.contains("boot") && !itemDef.name.contains("cape")) {
		 * itemDef.maleWieldY += 8; itemDef.femaleWieldY += 8; }
		 *
		 * if (itemDef.name.contains("hat")) { itemDef.maleWieldZ = 5;
		 * itemDef.femaleWieldZ = 5; }
		 *
		 * } else { itemDef.readValues(buffer); }
		 */
		itemDef.readValues(buffer);
		if (itemDef.oldColors != null) {
			for (int i2 = 0; i2 < itemDef.oldColors.length; i2++) {
				if (itemDef.newColors[i2] == 0) {
					itemDef.newColors[i2] = 1;
				}
			}
		}

		for (int a : BLACK_FIX) {
			if (itemDef.id == a) {
				itemDef.oldColors = new int[1];
				itemDef.newColors = new int[1];
				itemDef.oldColors[0] = 0;
				itemDef.newColors[0] = 1;
			}
		}

		int customId = itemDef.id;
		itemDef = ItemDef2.newIDS(itemDef, id);
		itemDef = ItemDef3.newIDS1(itemDef, id);
		itemDef = ItemDef4.newIDS(itemDef, id);
		itemDef = ItemDef5.newIDS(itemDef, id);
		itemDef = ItemDef6.newIDS(itemDef, id);
		if (customId >= 13700 && customId <= 13709) {
			/*
			 * final ItemDefinition stat = get(14876); definition.name = "Tier " + (1 +
			 * (customId - 13700)) + " Emblem"; definition.actions = stat.actions.clone();
			 * //definition.modifiedModelColors = stat.modifiedModelColors.clone();
			 * //definition.originalModelColors = stat.originalModelColors.clone();
			 * definition.modelID = stat.modelID; definition.modelOffset1 =
			 * stat.modelOffset1; definition.modelOffset2 = stat.modelOffset2;
			 * definition.modelRotationY = stat.modelRotationY; definition.modelRotationX =
			 * stat.modelRotationX; definition.groundActions = stat.groundActions;
			 * definition.value = stat.value; definition.modelZoom = stat.modelZoom;
			 * definition.certID = -1; definition.certTemplateID = -1; definition.stackable
			 * = false;
			 */
			itemDef.certID = -1;
			itemDef.certTemplateID = -1;
			itemDef.stackable = false;
		}

		switch (customId) {
			case 23418:
				itemDef.copyItem(6585);
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 51;
				itemDef.newColors[0] = 98;
				itemDef.name = "Diyos helm";
				itemDef.modelID = 19625;
				itemDef.maleEquip1 = 19626;
				itemDef.femaleEquip1 = 19626;
				itemDef.modelZoom = 704;
				itemDef.rotationX = 0;
				itemDef.rotationY = 687;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = -5;
				itemDef.modelOffsetX = -2;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 23419:
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 51;
				itemDef.newColors[0] = 98;
				itemDef.name = "Diyos body";
				itemDef.modelID = 19627;
				itemDef.maleEquip1 = 19628;
				itemDef.femaleEquip1 = 19628;
				itemDef.modelZoom = 1400;
				itemDef.rotationX = 0;
				itemDef.rotationY = 540;
				itemDef.modelOffsetY = 0;
				itemDef.modelOffsetX = -1;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 23420:
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 51;
				itemDef.newColors[0] = 98;
				itemDef.name = "Diyos legs";
				itemDef.modelID = 19629;
				itemDef.maleEquip1 = 19630;
				itemDef.femaleEquip1 = 19630;
				itemDef.modelZoom = 1765;
				itemDef.rotationX = 0;
				itemDef.rotationY = 450;
				itemDef.modelOffsetY = -1;
				itemDef.modelOffsetX = 1;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 23421:
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 51;
				itemDef.newColors[0] = 98;
				itemDef.name = "Diyos gloves";
				itemDef.modelOffsetX = 1;
				itemDef.modelOffsetY = 0;
				itemDef.modelZoom = 739;
				itemDef.rotationY = 530;
				itemDef.rotationZ = 652;
				itemDef.rotationX = 843;
				itemDef.modelID = 19631;
				itemDef.maleEquip1 = 19632;
				itemDef.femaleEquip1 = 19632;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 23422:
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 51;
				itemDef.newColors[0] = 98;
				itemDef.name = "Diyos boots";
				itemDef.modelID = 19633;
				itemDef.maleEquip1 = 19633;
				itemDef.femaleEquip1 = 19633;
				itemDef.modelZoom = 670;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelOffsetX = 0;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 23424:
				itemDef.copyItem(7995);
				itemDef.modelID = 19634;
				itemDef.femaleEquip1 = 19635;
				itemDef.maleEquip1 = 19635;
				itemDef.name = "Diyos cape";
				break;
			case 19000:
				itemDef.copyItem(14639);
				itemDef.name = "Pet fragment";
				itemDef.actions = new String[]{"Exchange", null, null, null, null};
				break;
			case 19001:
				itemDef.copyItem(15262);
				itemDef.name = "Pet fragment pack (X250)";
				itemDef.stackable = false;
				itemDef.actions = new String[]{"Open", null, null, null, "Drop"};
				itemDef.rdc2 = 487111;
				break;
			case 22000:
				itemDef.copyItem(15496);
				itemDef.name = "Boss Slayer Helmet [1]";
				itemDef.actions = new String[]{null, "Wear", "Upgrade", null, "Destroy"};
				break;
			case 22001:
				itemDef.copyItem(15496);
				itemDef.name = "Boss Slayer Helmet [2]";
				itemDef.rdc = 27570;
				itemDef.actions = new String[]{null, "Wear", "Upgrade", null, "Destroy"};
				break;
			case 22002:
				itemDef.copyItem(15496);
				itemDef.name = "Boss Slayer Helmet [3]";
				itemDef.rdc = 43954;
				itemDef.actions = new String[]{null, "Wear", "Upgrade", null, "Destroy"};
				break;
			case 22003:
				itemDef.copyItem(15496);
				itemDef.name = "Boss Slayer Helmet [4]";

				itemDef.rdc = 7116;
				itemDef.actions = new String[]{null, "Wear", "Upgrade", null, "Destroy"};
				break;
			case 22004:
				itemDef.copyItem(15496);
				itemDef.name = "Boss Slayer Helmet [5]";
				itemDef.rdc = 800;
				itemDef.actions = new String[]{null, "Wear", null, null, "Destroy"};
				break;
			case 22005:
				itemDef.copyItem(18818);
				itemDef.name = "Plutonic ring";
				itemDef.actions = new String[]{null, "Wear", null, null, "Destroy"};
				break;
			case 23258:
				itemDef.copyItem(15511);
				itemDef.name = "Plutonic Amulet";
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;
			case 22006: // Deathtouch darts
				itemDef.copyItem(11230);
				itemDef.name = "Deathtouch Darts";
				itemDef.newColors = new int[]{5409, 920, 914, 929, 10452, 10293};
				itemDef.oldColors = new int[]{943, 3866, 914, 3866, 943, 943};
				break;
			case 1050:
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", null};
				break;

			case 10501:
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;
			case 15378:
				itemDef.name = "Supreme appendage";
				break;

			case 23044:
				itemDef.name = "Aura (T1)";
				itemDef.description = "Gives 5% Drop Rate and 5% Double Drop Rate".getBytes();
				break;
			case 23045:
				itemDef.name = "Aura (T2)";
				itemDef.description = "Gives 7% Drop Rate and 7% Double Drop Rate".getBytes();
				break;
			case 23046:
				itemDef.name = "Aura (T3)";
				itemDef.description = "Gives 10% Drop Rate and 10% Double Drop Rate".getBytes();
				break;
			case 23047:
				itemDef.name = "Aura (T4)";
				itemDef.description = "Gives 15% Drop Rate and 15% Double Drop Rate".getBytes();
				break;
			case 23048:
				itemDef.name = "Aura (T5)";
				itemDef.description = "Gives 20% Drop Rate, 20% Double Drop Rate, and 5% Damage Boost".getBytes();
				break;
			case 23049:
				itemDef.name = "Aura (T6)";
				itemDef.description = "Gives 20% Drop Rate, 20% Double Drop Rate, 10% Damage Boost, and 5% Prayer Point Loss Reduction".getBytes();
				break;


			case 621:
				itemDef.name = "Light ticket";
				itemDef.actions = new String[]{"Use", null, null, null, "Destroy"};
				break;


			case 4278:
				itemDef.name = "Instance Token";
				itemDef.actions = new String[]{"Open", null, "Last instance", null, "Destroy"};
				itemDef.stackable = false;
				break;
				
			case 23264:
				itemDef.copyItem(4278);
				itemDef.name = "Instance Token (u)";
				itemDef.rdc3 = 328593;
				itemDef.stackable = false;
				break;

			case 23408:
				itemDef.copyItem(4278);
				itemDef.name = "Instance Token (s)";
				itemDef.rdc3 = 115593;
				itemDef.stackable = false;
				break;

			case 12855:
				itemDef.copyItem(7478);
				itemDef.name = "@cya@Levincia tokens";
				itemDef.modelID = 20568;
				itemDef.modelZoom = 1590;
				itemDef.actions = new String[]{"Activate", null, "Exchange", "Exchange X", "Destroy"};
				//#427743 #242323
				break;
				
			case 1563:
			case 1564:
			case 1562:
			case 12486:
			case 12490:
			case 12496:
			case 12498:
			case 12522:
			case 12514:
			case 12512:
			case 12518:
			case 12520:

				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", "Upgrade-pet", "Drop"};
				break;
			case 456:
				itemDef.name = "Scorpian pet";
				itemDef.modelID = 24610;

				itemDef.modelZoom = 4000;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", "Upgrade-pet", "Drop"};
				break;
			case 457:
				itemDef.name = "Unicorn pet";
				itemDef.modelID = 25754;

				itemDef.modelZoom = 3000;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", "Upgrade-pet", "Drop"};
				break;
			case 458:
				itemDef.name = "Bear pet";
				itemDef.modelID = 18884;
				itemDef.modelZoom = 3000;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", "Upgrade-pet", "Drop"};
				break;
			case 459:
				itemDef.name = "Wolf pet";
				itemDef.modelID = 26266;
				itemDef.modelZoom = 3000;

				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", "Upgrade-pet", "Drop"};
				break;
			case 460:
				itemDef.name = "Gorilla pet";
				itemDef.modelID = 65154;
				itemDef.modelZoom = 3000;

				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", "Upgrade-pet", "Drop"};
				break;
			case 461:
				itemDef.name = "Vegeta pet";
				itemDef.modelID = 65304;
				itemDef.modelZoom = 1100;
				itemDef.modelOffsetY = 160;

				itemDef.rotationZ = 1;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", "Upgrade-pet", "Drop"};
				break;
			case 462:
				itemDef.modelID = 13850;

				itemDef.modelZoom = 900;
				itemDef.modelOffsetY = 160;

				itemDef.rotationZ = 1;
				itemDef.name = "Yoshi pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", "Upgrade-pet", "Drop"};
				break;
			case 463:

				itemDef.modelID = 65332;
				itemDef.modelZoom = 6000;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.name = "@cya@Eternal dragon egg";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;

			case 20061:
				itemDef.name = "Case Key Crate";
				break;
			case 15682:
				itemDef.name = "Vote Crate";
				itemDef.actions = new String[]{"Open", null, null, null, "Drop"};
				break;

			/*
			 * case 13095: itemDef.name = "Crip Stick"; break;
			 */
			case 16337:
				itemDef.name = "Grime bow";
				break;
			case 7927:
				itemDef.name = "Energy ring";
				break;
			case 19887:
				itemDef.name = "Grime necklace";
				break;

			case 12601:
				itemDef.name = "Ring of the gods";
				itemDef.modelZoom = 900;
				itemDef.rotationY = 393;
				itemDef.rotationX = 1589;
				itemDef.modelOffsetX = -9;
				itemDef.modelOffsetY = -12;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.modelID = 33009;
				break;

			case 16133:
				itemDef.name = "KBD 2h sword";
				break;
				
			case 15920:
				itemDef.name = "KBD full helm";
				break;
				
			case 19886:
				itemDef.name = "Collector necklace";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 4446:
				itemDef.name = "Collector ring";
				itemDef.modelZoom = 900;
				itemDef.rotationY = 285;
				itemDef.rotationX = 1163;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 13641:
				itemDef.copyItem(4710);
				itemDef.name = "Starter staff";
				itemDef.modelID = 100297;
				itemDef.maleEquip1 = 100298;
				itemDef.femaleEquip1 = 100298;
				itemDef.modelZoom = 2600;
				itemDef.rotationX = 1100;
				itemDef.rotationY = 400;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				break;
			case 2714:
				itemDef.name = "Gold Casket";
				itemDef.actions = new String[]{"Loot", null, null, null, "Drop"};
				break;
			/*
			 * case 1505: itemDef.name = "100m Scroll"; itemDef.actions = new String[5];
			 * itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve"; break;
			 */
			case 607:
				itemDef.name = "Imbuement Scroll";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;

			/*
			 * case 12961: itemDef.name = "Dark hood"; itemDef.actions = new String [] {
			 * null, null, null, null, "Destroy" }; break;
			 *
			 * case 17680: itemDef.name = "Crushed whiteberries"; itemDef.actions = new
			 * String [] { null, null, null, null, "Destroy" }; break;
			 *
			 * case 3057: itemDef.name = "Mask"; itemDef.actions = new String [] { null,
			 * null, null, null, "Destroy" }; break;
			 *
			 * case 1633: itemDef.name = "Bonemeal"; itemDef.actions = new String [] { null,
			 * null, null, null, "Destroy" }; break;
			 *
			 * case 2424: itemDef.actions = new String[] { "Create face", null, null, null,
			 * "Destroy" }; break;
			 */

			case 11180:
				itemDef.name = "Trio Token";
				itemDef.actions = new String[]{null, null, null, null, "Destroy"};
				break;

			case 12603:
				itemDef.name = "Tyrannical ring";
				itemDef.modelZoom = 592;
				itemDef.rotationY = 285;
				itemDef.rotationX = 1163;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.modelID = 28823;
				break;

			case 20692:
				itemDef.name = "Barrel of fireworks";
				itemDef.actions = new String[]{"Fire", null, null, null, "Drop"};
				break;
			case 18719:
				itemDef.name = "Potion of flight";
				itemDef.actions = new String[]{"Drink", null, null, null, "Drop"};
				break;
			case 12605:
				itemDef.name = "Treasonous ring";
				itemDef.modelZoom = 750;
				itemDef.rotationY = 342;
				itemDef.rotationX = 252;
				itemDef.modelOffsetX = -3;
				itemDef.modelOffsetY = -12;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.modelID = 33010;
				break;
			case 12927:
				itemDef.name = "Serpentine visage";
				itemDef.modelZoom = 816;
				itemDef.rotationY = 498;
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = 7;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 19218;
				break;
			case 12922:
				itemDef.name = "Tanzanite fang";
				itemDef.modelZoom = 1411;
				itemDef.rotationY = 202;
				itemDef.rotationX = 1939;
				itemDef.modelOffsetX = -4;
				itemDef.modelOffsetY = -8;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 19228;
				break;

			case 12929:
				itemDef.name = "Serpentine helm (uncharged)";
				itemDef.modelZoom = 700;
				itemDef.rotationY = 215;
				itemDef.rotationX = 1724;
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = -1;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.modelID = 19222;
				itemDef.maleEquip1 = 14396;
				itemDef.femaleEquip1 = 14397;
				break;

			case 12931:
				itemDef.name = "Serpentine helm";
				itemDef.modelZoom = 700;
				itemDef.rotationY = 215;
				itemDef.rotationX = 1724;
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = 9;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.modelID = 19220;
				itemDef.maleEquip1 = 14395;
				itemDef.femaleEquip1 = 14398;
				break;

			case 12932:
				itemDef.name = "Magic fang";
				itemDef.modelZoom = 1095;
				itemDef.rotationY = 579;
				itemDef.rotationX = 1832;
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = 4;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 19227;
				break;

			case 12934:
				itemDef.name = "Zulrah's scales";
				itemDef.description = "Used to charge toxic items.".getBytes();
				itemDef.modelZoom = 1370;
				itemDef.rotationY = 212;
				itemDef.rotationX = 148;
				itemDef.modelOffsetX = 7;
				itemDef.stackable = true;
				itemDef.actions = new String[5];
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 19212;
				break;

			case 19908:
				itemDef.name = "Trident of the seas (full)";
				itemDef.modelZoom = 2350;
				itemDef.rotationY = 1549;
				itemDef.rotationX = 1818;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wield", "Check", "Uncharge", "Drop"};
				itemDef.modelID = 28232;
				itemDef.maleEquip1 = 28230;
				itemDef.femaleEquip1 = 28230;
				break;

			case 19906:
				itemDef.name = "Trident of the seas";
				itemDef.modelZoom = 2755;
				itemDef.rotationY = 420;
				itemDef.rotationX = 1130;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wield", "Check", "Uncharge", "Drop"};
				itemDef.modelID = 28232;
				itemDef.maleEquip1 = 28230;
				itemDef.femaleEquip1 = 28230;
				break;
			case 12899:
				itemDef.name = "Trident of the swamp";
				itemDef.modelZoom = 2421;
				itemDef.rotationY = 1818;
				itemDef.rotationX = 1549;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 9;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wield", "Check", "Uncharge", "Drop"};
				itemDef.modelID = 19223;
				itemDef.maleEquip1 = 19221;
				itemDef.femaleEquip1 = 19221;
				break;
			case 22007:
				itemDef.name = "Kraken tentacle";
				itemDef.modelZoom = 1095;
				itemDef.rotationY = 593;
				itemDef.rotationX = 741;
				itemDef.modelOffsetX = 4;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 28437;
				break;
			case 2970:
				itemDef.name = "Mort myre fungus";
				itemDef.modelZoom = 790;
				itemDef.rotationY = 60;
				itemDef.rotationX = 232;
				itemDef.modelOffsetX = 3;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 3563;
				break;
			case 22008:
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wield";
				
				itemDef.name = "Abyssal tentacle"; // Name
				itemDef.description = "An Abyssal whip fused with a Kraken tentacle.".getBytes();
				itemDef.newColors = new int[23];
				itemDef.oldColors = new int[23];
				itemDef.oldColors[0] = 944;
				itemDef.newColors[0] = 86933; // green
				itemDef.oldColors[1] = 9371;
				itemDef.newColors[1] = 9583; // cream
				itemDef.oldColors[2] = 9255;
				itemDef.newColors[2] = 9221; // black
				itemDef.oldColors[3] = 9240;
				itemDef.newColors[3] = 9221; // black
				itemDef.oldColors[4] = 9385;
				itemDef.newColors[4] = 9221; // black
				itemDef.oldColors[5] = 9395;
				itemDef.newColors[5] = 9583; // cream
				itemDef.oldColors[6] = 9239;
				itemDef.newColors[6] = 9221; // black
				itemDef.oldColors[7] = 9254;
				itemDef.newColors[7] = 9221; // black
				itemDef.oldColors[8] = 9359;
				itemDef.newColors[8] = 9583; // cream
				itemDef.oldColors[9] = 9237;
				itemDef.newColors[9] = 86933; // green
				itemDef.oldColors[10] = 8262;
				itemDef.newColors[10] = 86933; // green
				itemDef.oldColors[11] = 8244;
				itemDef.newColors[11] = 86933; // green
				itemDef.oldColors[12] = 8214;
				itemDef.newColors[12] = 9583; // cream
				itemDef.oldColors[13] = 9372;
				itemDef.newColors[13] = 9583; // cream
				itemDef.oldColors[14] = 9355;
				itemDef.newColors[14] = 9583; // cream
				itemDef.oldColors[15] = 9380;
				itemDef.newColors[15] = 9583; // cream
				itemDef.oldColors[16] = 9409;
				itemDef.newColors[16] = 9583; // cream
				itemDef.oldColors[17] = 9411;
				itemDef.newColors[17] = 9583; // cream
				itemDef.oldColors[18] = 9228;
				itemDef.newColors[18] = 9221; // black
				itemDef.oldColors[19] = 9428;
				itemDef.newColors[19] = 9583; // cream
				itemDef.oldColors[20] = 9412;
				itemDef.newColors[20] = 9583; // cream
				itemDef.oldColors[21] = 9364;
				itemDef.newColors[21] = 9583; // cream
				itemDef.oldColors[22] = 9425;
				itemDef.newColors[22] = 9583; // cream
				itemDef.rotationY = 280;
				itemDef.rotationX = 0;
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = 56;
				itemDef.modelID = 5412;
				itemDef.maleEquip1 = 5409;
				itemDef.femaleEquip1 = 5409;
				itemDef.modelZoom = 840;
				break;
			case 247:
				itemDef.actions = new String[]{null, null, null, null, null};
				break;
			case 22009:
				itemDef.name = "Abyssal tentacle"; // Name
				itemDef.actions = new String[]{null, null, null, null, null};
				itemDef.certID = 22008;
				itemDef.certTemplateID = 799;
				itemDef.rotationY = 552;
				itemDef.rotationX = 28;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 2;
				itemDef.modelID = 2429;
				break;
			case 12900:
				itemDef.name = "Uncharged toxic trident";
				itemDef.modelZoom = 2421;
				itemDef.rotationY = 1818;
				itemDef.rotationX = 1549;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 9;
				itemDef.stackable = false;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wield", "Check", "Dismantle", "Drop"};
				itemDef.modelID = 19226;
				itemDef.maleEquip1 = 14401;
				itemDef.femaleEquip1 = 14401;
				break;
			case 4566:
				itemDef.actions = new String[]{null, "Wield", null, "Dance", "Drop"};
				break;
			case 12902:
				itemDef.name = "Toxic staff (uncharged)";
				itemDef.modelID = 19224;
				itemDef.maleEquip1 = 14404;
				itemDef.femaleEquip1 = 14404;
				itemDef.modelZoom = 2150;
				itemDef.rotationX = 512;
				itemDef.rotationY = 1010;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.stackable = false;
				// itemDef.rotationZ = 229;
				itemDef.actions[1] = "Wield";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.oldColors = new int[1];
				itemDef.newColors = new int[1];
				break;
			case 12904:
				itemDef.name = "Toxic staff of the dead";
				itemDef.modelID = 19224;
				itemDef.maleEquip1 = 14402;
				itemDef.femaleEquip1 = 14402;
				itemDef.modelZoom = 2150;
				itemDef.rotationX = 512;
				itemDef.rotationY = 1010;
				// itemDef.rotationZ = 229;
				itemDef.actions[1] = "Wield";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				break;
			case 13740:
			case 13742:
				itemDef.actions = new String[]{null, "Wear", "Dissolve", null, "Drop"};
				break;
			case 13738:
			case 13744:
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 6818:
				itemDef.name = "Bow Sword of 1k Truths";
				itemDef.description = "How do you kill that which has no life?".getBytes();
				break;
			case 6797:
				itemDef.name = "Unlimited Watering Can";
				itemDef.description = "Great for member farmers!".getBytes();
				break;
			case 7510:
			case 7509:
				itemDef.actions = new String[]{"Munch", null, "Guzzle", null, "Destroy"};
				break;
			case 12926:
				itemDef.actions = new String[5];
				itemDef.modelID = 19219;
				itemDef.name = "Toxic blowpipe";
				itemDef.modelZoom = 1158;
				itemDef.rotationX = 189;
				itemDef.rotationY = 768;
				itemDef.modelOffsetX = -7;
				itemDef.modelOffsetY = 4;
				itemDef.value = 20000000;
				itemDef.maleEquip1 = 14403;
				itemDef.femaleEquip1 = 14403;
				itemDef.actions[1] = "Wield";
				// itemDef.actions[2] = "Uncharge";
				itemDef.actions[3] = "Uncharge";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				break;
			case 12924:
				itemDef.actions = new String[5];
				itemDef.modelID = 19221;
				itemDef.name = "Toxic blowpipe (empty)";
				itemDef.modelZoom = 1158;
				itemDef.rotationX = 189;
				itemDef.rotationY = 768;
				itemDef.modelOffsetX = -7;
				itemDef.modelOffsetY = 4;
				itemDef.value = 200000000;
				itemDef.maleEquip1 = 14405;
				itemDef.femaleEquip1 = 14405;
				// itemDef.actions[1] = "Wield";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				break;
			case 14023:
				itemDef.modelID = 64994;// 64994;
				itemDef.name = "Drygore Long-sword";
				itemDef.description = "A powerful sword made from the chitlin of the Kalphite King.".getBytes();
				itemDef.modelZoom = 1493;
				itemDef.rotationY = 618;
				itemDef.rotationX = 1086;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -5;
				itemDef.maleEquip1 = 64995;
				itemDef.femaleEquip1 = 64996;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wield";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;


			case 1514:
			case 1515:
			case 1516:
			case 1517:
			case 1518:
			case 449:
			case 450:
			case 451:
			case 452:
			case 383:
			case 384:
			case 15270:
			case 15271:
			case 2362:
			case 2361:
			case 2364:
			case 2363:
			case 18199:
				itemDef.actions = new String[5];
				
				break;

			case 14024:
				itemDef.modelID = 64997;
				itemDef.name = "Drygore Rapier";
				itemDef.description = "A powerful rapier made from the chitlin of the Kalphite King.".getBytes();
				itemDef.modelZoom = 1493;
				itemDef.rotationY = 618;
				itemDef.rotationX = 996;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -5;
				itemDef.maleEquip1 = 64998;
				itemDef.femaleEquip1 = 64999;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wield";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";

				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 16055:
			case 16077:
			case 16066:
			case 16011:
			case 16114:
				itemDef.name = itemDef.name.replace("Tyrannoleather", "Swoodoo");
				itemDef.name = itemDef.name.replace("(b)", "");
				itemDef.rdc2 = 328593;
				itemDef.actions = new String[5];
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
			case 18352:
			case 18354:
			case 18350:
			case 18358:
			case 18356:
			case 18360:
				itemDef.name = itemDef.name.replace("(broken)", "");
				itemDef.name = itemDef.name.replace("Chaotic", "Chaos");
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 876543;

				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 16184:
				itemDef.name = itemDef.name.replace("Primal", "Frozen");
				itemDef.name = itemDef.name.replace("(b)", "");
				itemDef.rdc2 = 61161;

				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 16045:
				itemDef.name = itemDef.name.replace("Primal", "Frozen");
				itemDef.name = itemDef.name.replace("(b)", "");
				itemDef.rdc2 = 61161;

				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 16217:
				itemDef.name = itemDef.name.replace("Primal", "Frozen");
				itemDef.name = itemDef.name.replace("(b)", "");
				itemDef.rdc2 = 61161;

				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 15785:
				itemDef.name = itemDef.name.replace("Sagittarian", "Frozen");
				itemDef.name = itemDef.name.replace("(b)", "");
				itemDef.rdc2 = 61161;

				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;


			case 18351:
			case 18353:
			case 18349:
			case 18357:
			case 18355:
				itemDef.rdc2 = 69896;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 6585:
			itemDef.name = "Amulet of Gluttony";
			ItemDefinition itemDef2122 = ItemDefinition.get(295);
			itemDef.modelOffsetX = itemDef2122.modelOffsetX;
			itemDef.modelOffsetY = 5;
			itemDef.modelZoom = itemDef2122.modelZoom;
			itemDef.rotationY = itemDef2122.rotationY;
			itemDef.rotationX = itemDef2122.rotationX;
			itemDef.modelID = 64205;
			itemDef.maleEquip1 = 64206;
			itemDef.femaleEquip1 = 64206;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.stackable = false;
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
			itemDef.stackable = false;
			itemDef.rdc2 = 78757;
				break;
			case 19670:
				itemDef.name = "Vote scroll";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[0] = "Claim";
				itemDef.actions[2] = "Claim-All";
				break;
			case 10944:
				itemDef.name = "Member scroll";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[0] = "Claim";
				break;

			case 10034:
			case 10033:
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				break;
			case 13727:
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				break;
			case 6500:
				itemDef.modelID = 9123;
				itemDef.name = "Charming imp";
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, null, "Check", "Config", "Drop"};
				break;
			case 15332:
				itemDef.oldColors = new int[1];
				itemDef.newColors = new int[1];
				itemDef.oldColors[0] = 61;
				itemDef.newColors[0] = 0;
				itemDef.modelID = 2789;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = -5;
				itemDef.rotationY = 84;
				itemDef.rotationX = 1996;
				itemDef.modelZoom = 550;
				break;
			case 15331:
				itemDef.name = "<shad=1><col=ff0000>Super Overload";
				break;

			case 11995:
				itemDef.name = "Pet Chaos elemental";
				ItemDefinition itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 11996:
				itemDef.name = "Pet King black dragon";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 11997:
				itemDef.name = "Pet General graardor";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 11978:
				itemDef.name = "Pet TzTok-Jad";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 12001:
				itemDef.name = "Pet Corporeal beast";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 12002:
				itemDef.name = "Pet Kree'arra";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 12003:
				itemDef.name = "Pet K'ril tsutsaroth";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;

				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 12004:
				itemDef.name = "Pet Commander zilyana";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 12005:
				itemDef.name = "Pet Dagannoth supreme";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 12006:
				itemDef.name = "Pet Dagannoth prime";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 17992:
				itemDef.name = "Pet Naked lady";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 11990:
				itemDef.name = "Pet Dagannoth rex";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 11991:
				itemDef.name = "Pet Frost dragon";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 11992:
				itemDef.name = "Pet Tormented demon";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 11993:
				itemDef.name = "Pet Kalphite queen";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 11994:
				itemDef.name = "Pet Slash bash";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;

			case 989:
				itemDef.actions = new String[]{"@cya@Teleport To Chest", null, null, null, null};
				break;
			case 11989:
				itemDef.name = "Pet Phoenix";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 11988:
				itemDef.name = "Pet Bandos avatar";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 11987:
				itemDef.name = "Pet Nex";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 11986:
				itemDef.name = "Pet Jungle strykewyrm";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 11985:
				itemDef.name = "Pet Desert strykewyrm";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 11984:
				itemDef.name = "Pet Ice strykewyrm";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 11983:
				itemDef.name = "Pet Green dragon";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 11982:
				itemDef.name = "Pet Baby blue dragon";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 11981:
				itemDef.name = "Pet Blue dragon";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 11979:
				itemDef.name = "Pet Black dragon";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			// custom pets
			case 22014:
				itemDef.name = "Pet Skeleton Hellhound";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22015:
				itemDef.name = "Pet Maze Guardian";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22016:
				itemDef.name = "Pet Skeleton Warlord";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22017:
				itemDef.name = "Pet Penguin";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22018:
				itemDef.name = "Pet Druid";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22019:
				itemDef.name = "Pet Monkey Guard";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22020:
				itemDef.name = "Pet Clockwork Cat";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22021:
				itemDef.name = "Pet Jubbly Bird";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22022:
				itemDef.name = "Pet Dust Devil";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22023:
				itemDef.name = "Pet Abyssal Demon";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22024:
				itemDef.name = "Pet Chinchompa";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22025:
				itemDef.name = "Pet Golem";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22026:
				itemDef.name = "Pet Chaos Dwarf";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22027:
				itemDef.name = "Pet Shark";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22028:
				itemDef.name = "Pet Goblin Cook";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22029:
				itemDef.name = "Pet Fire Elemental";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22030:
				itemDef.name = "Pet Tree Spirit";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22031:
				itemDef.name = "Pet Leprechaun";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;

			case 22032:

				itemDef.name = "Night spider pet (@bla@x1.5 EXP - X1.5 DMG BOOST@or1@)";
				itemDef21 = ItemDefinition.get(18504);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;

			case 22033:
				itemDef.name = "Pet serpentine";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22049:
				itemDef.name = "Pet tanzanite";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22051:
				itemDef.name = "<img=101> @cya@Bunny's letter";
				itemDef.modelID = 10013;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 7;
				itemDef.rotationY = 316;
				itemDef.rotationX = 184;
				itemDef.modelZoom = 960;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{"Read", null, null, null, "Destroy"};
				break;
			case 22050:
				itemDef.name = "Pet magma";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22055:
				itemDef.name = "Pet WildyWyrm";
				itemDef21 = ItemDefinition.get(12458);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 20054:
				itemDef.name = "Starter ring";
				itemDef.rdc2 = 20402;
				break;
			case 2550:
				itemDef.actions = new String[]{null, "Wear", "Check-charges", "Break", null, null};
				break;
			case 15182:
				itemDef.actions[0] = "Bury";
				break;
			case 15084:
				itemDef.actions[0] = "Roll";
				itemDef.name = "Dice (up to 100)";
				itemDef21 = ItemDefinition.get(15098);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				break;
			case 2996:
				itemDef.name = "Agility ticket";
				break;
			case 5510:
			case 5512:
			case 5509:
			case 5514:
				itemDef.actions = new String[]{"Fill", null, "Empty", "Check", null, null};
				break;
			case 11998:
				itemDef.name = "Scimitar";
				itemDef.actions = new String[5];
				
				break;
			case 11999:
				itemDef.name = "Scimitar";
				itemDef.actions = new String[]{null, null, null, null, null, null};
				itemDef.modelZoom = 700;
				itemDef.rotationY = 0;
				itemDef.rotationX = 350;
				itemDef.modelID = 2429;
				itemDef.rotationZ = itemDef.modelOffsetX = 0;
				itemDef.stackable = true;
				itemDef.certID = 11998;
				itemDef.certTemplateID = 799;
				break;
			case 1389:
				itemDef.name = "Staff";
				itemDef.actions = new String[5];
				
				break;
			case 1390:
				itemDef.name = "Staff";
				itemDef.actions = new String[]{null, null, null, null, null, null};
				break;
			case 17401:
				itemDef.name = "Damaged Hammer";
				itemDef.actions = new String[5];
				
				break;
			case 17402:
				itemDef.name = "Damaged Hammer";
				itemDef.actions = new String[]{null, null, null, null, null, null};
				itemDef.modelZoom = 760;
				itemDef.rotationY = 28;
				itemDef.rotationX = 552;
				itemDef.modelID = 2429;
				itemDef.rotationZ = itemDef.modelOffsetX = 0;
				itemDef.stackable = true;
				itemDef.certID = 17401;
				itemDef.certTemplateID = 799;
				break;
			case 15009:
				itemDef.name = "Gold Ring";
				itemDef.actions = new String[5];
				
				break;
			case 5010:
				itemDef.name = "Crystalized bow";
				break;
			case 15010:
				itemDef.modelID = 2429;
				itemDef.name = "Gold Ring";
				itemDef.actions = new String[]{null, null, null, null, null, null};
				itemDef.modelZoom = 760;
				itemDef.rotationY = 28;
				itemDef.rotationX = 552;
				itemDef.rotationZ = itemDef.modelOffsetX = 0;
				itemDef.stackable = true;
				itemDef.certID = 15009;
				itemDef.certTemplateID = 799;
				break;
			case 11884:
			case 15420:
				itemDef.actions = new String[]{"Open", null, null, null, null, null};
				break;

			case 15262:
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.actions[2] = "Open-All";
				break;
			case 6570:
				itemDef.actions[2] = "<col=C3C0B2>Dissolve";
				break;
			case 4155:
				itemDef.name = "Slayer gem";
				itemDef.description = "A magical stone created by the gods of Levincia".getBytes();
				itemDef.actions = new String[5];
				itemDef.actions = new String[]{"Check", "Teleport", null, null, null};
				break;
			case 13663:
				itemDef.name = "Stat reset cert.";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[0] = "Open";
				break;
			case 13653:
				itemDef.name = "Energy fragment";
				break;
			case 292:
				itemDef.name = "Ingredients book";
				break;
			case 4882:
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.name = "Volcanic helm";
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -3;
				itemDef.modelID = 99971;
				itemDef.maleEquip1 = 99972;
				itemDef.femaleEquip1 = 99972;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				itemDef.modelZoom = 750;
				break;
			case 4888:
				itemDef.name = "Volcanic axe";
				
				// itemDef.rdc2 = 57306150;
				break;
			case 4894:		
				itemDef.modelZoom = 1450;
				itemDef.name = "Volcanic platebody";
				itemDef.modelID = 99973;
				itemDef.maleEquip1 = 99974;
				itemDef.femaleEquip1 = 99974;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
				
			case 4900:		
				itemDef.modelZoom = 1650;
				itemDef.name = "Volcanic platelegs";
				itemDef.modelID = 99975;
				itemDef.maleEquip1 = 99976;
				itemDef.femaleEquip1 = 99976;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
				
			case 18747:
				itemDef.name = "Volcanic shield";
				
				// itemDef.rdc2 = 57306150;
				break;
			case 20460:
				itemDef.name = "Volcanic gloves";
				itemDef.modelID = 99977;
				itemDef.maleEquip1 = 99978;
				itemDef.femaleEquip1 = 99978;
				// itemDef.rdc2 = 57306150;		
				itemDef.modelZoom = 1000;
				break;
			case 20456:
				itemDef.name = "Volcanic boots";
				itemDef.modelID = 99979;
				itemDef.maleEquip1 = 99979;
				itemDef.femaleEquip1 = 99979;
				// itemDef.rdc2 = 57306150;
				break;
			case 15707:
				itemDef.actions = new String[5];
				// itemDef.actions[1] = "Wear";
				// itemDef.actions[0] = "Create Party";
				break;
			case 14501:
				itemDef.modelID = 44574;
				itemDef.maleEquip1 = 43693;
				itemDef.femaleEquip1 = 43693;
				break;
			case 19111:
				itemDef.name = "TokHaar-Kal";
				itemDef.maleEquip1 = 62575;
				itemDef.femaleEquip1 = 62582;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.modelOffsetX = -4;
				itemDef.modelID = 62592;
				itemDef.description = "A cape made of ancient, enchanted rocks.".getBytes();
				itemDef.modelZoom = 1616;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.rotationZ = 0;
				itemDef.rotationY = 339;
				
				itemDef.rotationX = 192;
				// itemDef.rdc2 = 16368;//this is for you dope :)
				break;

			case 6769:
				itemDef.name = "$5 Bond";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop";
				itemDef.actions[0] = "Claim";
				itemDef.actions[2] = "Claim-All";
				itemDef.modelID = 99900;
				itemDef.modelZoom = 2400;
				itemDef21 = ItemDefinition.get(10942);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				break;
			case 10942:
				itemDef.name = "@red@$10 Bond";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop";
				itemDef.actions[0] = "Claim";
				itemDef.actions[2] = "Claim-All";
				itemDef.modelID = 99901;
				;
				itemDef.modelZoom = 2400;
				break;
			case 10934:
				itemDef.name = "$25 Bond";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop";
				itemDef.actions[0] = "Claim";
				itemDef.actions[2] = "Claim-All";
				itemDef.modelID = 99903;
				itemDef21 = ItemDefinition.get(10942);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelZoom = 2400;
				break;
			case 10935:
				itemDef.name = "@blu@$50 Bond";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop";
				itemDef.actions[0] = "Claim";
				itemDef.actions[2] = "Claim-All";
				itemDef.modelID = 99902;
				itemDef21 = ItemDefinition.get(10942);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelZoom = 2400;
				break;
			case 10943:
				itemDef.name = "@mag@$100 Bond";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop";
				itemDef.actions[0] = "Claim";
				itemDef.actions[2] = "Claim-All";
				itemDef.modelID = 99902;
				itemDef.modelZoom = 2300;
				itemDef.rdc2 = 661177;//661177

				break;
			case 7630:
				itemDef.name = "Zulrah's Scale Box";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[0] = "Open";
				break;
			case 11261:
			case 1748:
			case 1750:
			case 1752:
			case 1754:
			case 228:
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[0] = "Un-note";
				break;
			case 13150:
				itemDef.name = "Spooky Box";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Destroy";
				itemDef.actions[0] = "Open";

				break;
			case 9013:
				itemDef.name = "Skull sceptre";
				itemDef.actions = new String[]{"Spook", "Wear", null, null, "Destroy"};
				break;
			/*case 995:
				itemDef.name = "Coins";
				itemDef.actions = new String[5];
				*//*itemDef.actions[3] = "Convert to 1-bill";
				//itemDef.actions[2] = "Convert to 1-mill";
				itemDef.actions[0] = "Add to pouch";
				itemDef.modelID = 100284;
				itemDef.modelZoom = 1500;
				itemDef.rotationX = 0;
				itemDef.rotationY = 520;
				itemDef.stackAmounts = null;
				itemDef.stackIDs = null;*//*
				break;

			case 10835:
				itemDef.copyItem(995);
				itemDef.name = "1B coin";

				itemDef.actions = new String[5];
				itemDef.actions[0] = "Convert-to-coin";
				itemDef.stackable = true;

				itemDef.modelID = 100285;
				break;*/

			case 17291:
				itemDef.name = "Webby necklace";
				itemDef.rdc = 85266;
				//itemDef.rotationX = 700;
				itemDef.actions = new String[]{null, "Wear", null, null, null, null};
				

				break;
			case 20084:
				itemDef.name = "Golden Maul";
				break;

			case 290:
				itemDef.name = "Loot box";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				break;
			case 6198:
				itemDef.name = "3% Droprate Pet";
				itemDef21 = ItemDefinition.get(290);
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef21 = ItemDefinition.get(290);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				// itemDef.modelID = itemDef2.modelID;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{66};
				itemDef.modelID = 65284;
				break;
			case 10947:
				itemDef.name = "@red@Deity Attachment";
				itemDef21 = ItemDefinition.get(12159);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.modelID = itemDef21.modelID;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.rdc2 = 416546661;
				break;
			case 10949:
				itemDef.name = "Light Attachment";
				itemDef21 = ItemDefinition.get(12159);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.modelID = itemDef21.modelID;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.rdc2 = 123412;
				break;
			case 15501:
				itemDef.name = "Vote Mystery Box";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef21 = ItemDefinition.get(290);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = 1600;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelID = 64099;
				break;
			case 23812:
				itemDef.name = "Money case";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.actions[2] = "<col=C3C0B2>Dissolve";
				itemDef.modelOffsetX = -43;
				itemDef.modelOffsetY = 0;
				itemDef.modelZoom = 2000;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelID = 19601;
				itemDef.rdc2 = 123412;
				break;
			case 23411:
				itemDef.name = "Seraphic case";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.actions[2] = "<col=C3C0B2>Dissolve";
				itemDef.modelOffsetX = -43;
				itemDef.modelOffsetY = 0;
				itemDef.modelZoom = 2000;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelID = 19601;
				break;
			case 14705:
				itemDef.name = "Seraphic dust";
				itemDef.actions = new String[]{null, null, null, null, null, null};
				itemDef.modelZoom = 1025;
				break;
			case 11465:
				itemDef.copyItem(14277);
				itemDef.name = "Seraphic potion";
				itemDef.actions = new String[]{"Drink", null, null, null, "Drop"};
				itemDef.modelID = 20851;
				itemDef.modelZoom = 720;
				break;
			case 20421:
				itemDef.name = "Ethereal urn";
				itemDef.actions = new String[]{null, null, null, null, null, null};
				itemDef.modelZoom = 1125;
				break;
			case 23412:
				itemDef.name = "Ethereal case";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.actions[2] = "<col=C3C0B2>Dissolve";
				itemDef.modelOffsetX = -43;
				itemDef.modelOffsetY = 0;
				itemDef.modelZoom = 2000;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelID = 19602;
				break;

			case 4186:
				itemDef.copyItem(21201);
				itemDef.name = "Case key";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.rdc2 = 4710;
				break;

			case 20489:
				itemDef.name = "Launch Casket";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef21 = ItemDefinition.get(6199);
				itemDef.modelZoom = 1452;
				itemDef.modelOffsetX = -2;
				itemDef.modelOffsetY = 4;
				itemDef.rotationY = 43;
				itemDef.rotationX = 107;
				itemDef.modelID = 19619;
				break;

			case 15003:
				itemDef.name = "Azure Casket";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef21 = ItemDefinition.get(6199);
				itemDef.modelZoom = 1452;
				itemDef.modelOffsetX = -2;
				itemDef.modelOffsetY = 4;
				itemDef.rotationY = 43;
				itemDef.rotationX = 107;
				itemDef.modelID = 19620;
				break;

			case 15002:
				itemDef.name = "Elite Casket";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef21 = ItemDefinition.get(6199);
				itemDef.modelZoom = 1452;
				itemDef.modelOffsetX = -2;
				itemDef.modelOffsetY = 4;
				itemDef.rotationY = 43;
				itemDef.rotationX = 107;
				itemDef.modelID = 19621;
				break;

			case 15004:
				itemDef.name = "Exclusive Casket";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef21 = ItemDefinition.get(6199);
				itemDef.modelZoom = 1452;
				itemDef.modelOffsetX = -2;
				itemDef.modelOffsetY = 4;
				itemDef.rotationY = 43;
				itemDef.rotationX = 107;
				itemDef.modelID = 19622;
				break;

			case 14999:
				itemDef.name = "Legendary Casket";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef21 = ItemDefinition.get(6199);
				itemDef.modelZoom = 1452;
				itemDef.modelOffsetX = -2;
				itemDef.modelOffsetY = 4;
				itemDef.rotationY = 43;
				itemDef.rotationX = 107;
				itemDef.modelID = 19623;
				break;

			case 23253:
				itemDef.name = "Supreme Casket";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef21 = ItemDefinition.get(6199);
				itemDef.modelZoom = 1452;
				itemDef.modelOffsetX = -2;
				itemDef.modelOffsetY = 4;
				itemDef.rotationY = 43;
				itemDef.rotationX = 107;
				itemDef.modelID = 19624;
				break;

			case 15355:
				itemDef.name = "@gre@<shad=0>Double DR Scroll (1 Hour)<shad-1>";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Activate";
				itemDef.rdc2 = 921211;
				break;

			case 15356:
				itemDef.name = "@gre@<shad=0>1.5X DDR Scroll (1 Hour)<shad-1>";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Activate";
				itemDef.rdc2 = 348132;
				break;

			case 15357:
				itemDef.name = "@gre@<shad=0>Double Damage Scroll (1 Hour)<shad-1>";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Activate";
				itemDef.rdc2 = 23333;
				break;

			case 15358:
				itemDef.name = "@gre@<shad=0>Double DR Scroll (30 Minutes)<shad-1>";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Activate";
				itemDef.rdc2 = 663712;
				break;

			case 15359:
				itemDef.name = "@gre@<shad=0>Double Damage Scroll (30 Minutes)<shad-1>";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Activate";
				itemDef.rdc2 = 12411;
				break;

			case 6542:
				itemDef.name = "@bla@<shad=0>Dan's Present<shad-1>";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef21 = ItemDefinition.get(290);
				itemDef.modelOffsetX = 2;
				itemDef.modelOffsetY = 1;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = 100;
				itemDef.rotationX = 90;
				itemDef.rdc2 = 28312;
				break;

			case 19659:
				itemDef.copyItem(290);
				itemDef.name = "Super Box";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.modelID = 64099;
				itemDef.rdc2 = 32521;
				break;

			case 6199:
				itemDef.name = "Beginner Mystery Box";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.modelID = 22387;
				itemDef.modelZoom = 2900;
				itemDef.modelOffsetY = 0;
				break;
			case 19114:
				itemDef.copyItem(6199);
				itemDef.name = "Ruby Mystery Box";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.modelID = 19617;
				itemDef.modelZoom = 450;
				itemDef.modelOffsetY = 0;
				break;

			case 20488:
				itemDef.copyItem(6199);
				itemDef.name = "OP Mystery Box";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.modelID = 19615;
				itemDef.modelZoom = 450;
				itemDef.modelOffsetY = 0;
				break;
			case 19115:
				itemDef.copyItem(6199);
				itemDef.name = "Emerald Mystery Box";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.modelID = 19618;
				itemDef.modelZoom = 450;
				itemDef.modelOffsetY = 0;
				break;
			case 19116:
				itemDef.copyItem(6199);
				itemDef.name = "Sapphire Mystery Box";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.modelID = 19616;
				itemDef.modelZoom = 450;
				itemDef.modelOffsetY = 0;
				break;

			case 19117:
				itemDef.copyItem(290);
				itemDef.name = "Execution Box";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{87};
				itemDef.modelID = 65284;
				break;


			case 18404:
				itemDef.copyItem(290);
				itemDef.name = "Legends Raids Box";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{120};
				itemDef.modelID = 65284;
				break;
				


			case 23407:
				itemDef.copyItem(290);
				itemDef.name = "Season 1 Cosmetic set";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{98};
				itemDef.modelID = 65284;
				break;

			case 23236:
				itemDef.copyItem(290);
				itemDef.name = "Prestige Mystery Box";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{118};
				itemDef.modelID = 65284;
				break;
				
			case 6568: // To replace Transparent black with opaque black.
				itemDef.oldColors = new int[1];
				itemDef.newColors = new int[1];
				itemDef.oldColors[0] = 0;
				itemDef.newColors[0] = 2059;
				break;
			case 13262:
				itemDef.name = "Dragon Defender";
				itemDef21 = ItemDefinition.get(20072);
				itemDef.modelID = itemDef21.modelID;
				itemDef.maleEquip1 = itemDef21.maleEquip1;
				itemDef.femaleEquip1 = itemDef21.femaleEquip1;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelZoom = itemDef21.modelZoom;
				// itemDef.name = itemDef2.name;
				itemDef.actions = itemDef21.actions;
				break;
			case 996:
			case 997:
			case 998:
			case 999:
			case 1000:
			case 1001:
			case 1002:
			case 1003:
			case 1004:
				itemDef.name = "Coins";
				break;
			case 23413:
				itemDef21 = ItemDefinition.get(19890);
				itemDef.modelOffsetX = 15;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = 30;
				itemDef.modelZoom = 1340;
				itemDef.rotationY = 340;
				itemDef.rotationX = 1300;
				itemDef.modelID = itemDef21.modelID;
				itemDef.maleEquip1 = itemDef21.maleEquip1;
				itemDef.femaleEquip1 = itemDef21.femaleEquip1;
				itemDef.name = "1.75x Ethereal scroll";
				itemDef.rdc2 = 16151;
				break;
			case 4442:
				itemDef21 = ItemDefinition.get(19890);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelID = itemDef21.modelID;
				itemDef.maleEquip1 = itemDef21.maleEquip1;
				itemDef.femaleEquip1 = itemDef21.femaleEquip1;
				itemDef.name = "@red@X1.5 Damage Booster";
				itemDef.rdc2 = 99252;
				break;

			case 14017:
				itemDef.name = "Brackish blade";
				itemDef.modelZoom = 1488;
				itemDef.rotationX = 276;
				itemDef.rotationY = 1580;
				itemDef.rotationX = 1;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wield", "<col=C3C0B2>Dissolve", null, "Destroy"};
				itemDef.modelID = 64593;
				itemDef.maleEquip1 = 64704;
				itemDef.femaleEquip1 = 64704;
				break;
			case 15220:
				itemDef.name = "Berserker ring (i)";
				itemDef.modelZoom = 600;
				itemDef.rotationY = 324;
				itemDef.rotationX = 1916;
				itemDef.modelOffsetX = 3;
				itemDef.modelOffsetY = -15;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.modelID = 7735;
				itemDef.maleEquip1 = -1;
				itemDef.femaleEquip1 = -1;
				break;
			case 14019:
				itemDef.modelID = 65333;
				itemDef.name = "Max Cape";
				itemDef.description = "A cape worn by those who've achieved 99 in all skills.".getBytes();
				itemDef.modelZoom = 1385;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 24;
				itemDef.rotationY = 279;
				itemDef.rotationX = 948;
				itemDef.maleEquip1 = 65334;
				itemDef.femaleEquip1 = 65334;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				break;
			case 23270:
				itemDef.modelID = 19729;
				itemDef.name = "<col=89584A>Fantasy Wings";
				itemDef.description = "A cape worn by those who've achieved greatness.".getBytes();
				itemDef.maleEquip1 = 19730;
				itemDef.femaleEquip1 = 19730;
				itemDef.modelZoom = 3850;
				itemDef.rotationX = 0;
				itemDef.rotationY = 357;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				break;

			case 23271:
				itemDef.copyItem(12608);
				itemDef.modelID = 19706;
				itemDef.modelZoom = 1700;
				itemDef.maleEquip1 = 19706;
				itemDef.femaleEquip1 = 19706;
				itemDef.modelOffsetX = -15;
				itemDef.modelOffsetY = 60;
				itemDef.name = "<col=89584A>Fantasy Aura";
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};

				break;
				
			case 23272:
				itemDef.copyItem(12855);
				itemDef.name = "Imbued Symbol";
				itemDef.modelZoom = 950;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.modelID = 19485;
				break;

			case 23300:
				itemDef.copyItem(12855);
				itemDef.name = "<col=89584A>Fantasy Symbol";
				itemDef.modelZoom = 500;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.modelID = 19714;
				//itemDef.rdc2 = 99252;
				break;

			case 14020:
				itemDef.name = "Veteran hood";
				itemDef.description = "A hood worn by Etherear veterans.".getBytes();
				itemDef.modelZoom = 760;
				itemDef.rotationY = 11;
				itemDef.rotationX = 81;
				itemDef.modelOffsetX = 1;
				itemDef.modelOffsetY = -3;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.modelID = 65271;
				itemDef.maleEquip1 = 65289;
				itemDef.femaleEquip1 = 65314;
				break;
			case 14021:
				// itemDef.modelID = 65261;
				itemDef.name = "Veteran Cape";
				itemDef.description = "A cape worn by Necrotic's veterans.".getBytes();
				itemDef.modelZoom = 760;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 24;
				itemDef.rotationY = 279;
				itemDef.rotationX = 948;
				// itemDef.maleWearId = 65305;
				itemDef.modelID = 65333;
				itemDef.maleEquip1 = 65334;
				itemDef.femaleEquip1 = 65334;
				// itemDef.femaleWearId = 65318;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.rdc2 = 99252;
				break;
			case 14022:
				// itemDef.modelID = 65270;
				itemDef.name = "Completionist Cape";
				itemDef.description = "We'd pat you on the back, but this cape would get in the way.".getBytes();
				itemDef.modelZoom = 1385;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 24;
				itemDef.rotationY = 279;
				itemDef.rotationX = 948;
				// itemDef.modifiedModelColors = new int[]{65214, 65200, 65186, 62995};
				// itemDef.originalModelColors = new int[]{44988, 44988, 32463, 44988};
				// itemDef.maleWearId = 65297;
				// itemDef.femaleWearId = 65297;
				itemDef.modelID = 65333;
				itemDef.maleEquip1 = 65334;
				itemDef.femaleEquip1 = 65334;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.rdc2 = 25262;
				break;
			case 14004:
				itemDef.name = "Staff of light";
				itemDef.modelID = 51845;
				itemDef.oldColors = new int[11];
				itemDef.newColors = new int[11];
				itemDef.oldColors[0] = 7860;
				itemDef.newColors[0] = 38310;
				itemDef.oldColors[1] = 7876;
				itemDef.newColors[1] = 38310;
				itemDef.oldColors[2] = 7892;
				itemDef.newColors[2] = 38310;
				itemDef.oldColors[3] = 7884;
				itemDef.newColors[3] = 38310;
				itemDef.oldColors[4] = 7868;
				itemDef.newColors[4] = 38310;
				itemDef.oldColors[5] = 7864;
				itemDef.newColors[5] = 38310;
				itemDef.oldColors[6] = 7880;
				itemDef.newColors[6] = 38310;
				itemDef.oldColors[7] = 7848;
				itemDef.newColors[7] = 38310;
				itemDef.oldColors[8] = 7888;
				itemDef.newColors[8] = 38310;
				itemDef.oldColors[9] = 7872;
				itemDef.newColors[9] = 38310;
				itemDef.oldColors[10] = 7856;
				itemDef.newColors[10] = 38310;
				itemDef.modelZoom = 2256;
				itemDef.rotationX = 456;
				itemDef.rotationY = 513;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.maleEquip1 = 51795;
				itemDef.femaleEquip1 = 51795;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;

			case 14005:
				itemDef.name = "Staff of light";
				itemDef.modelID = 51845;
				itemDef.oldColors = new int[11];
				itemDef.newColors = new int[11];
				itemDef.oldColors[0] = 7860;
				itemDef.newColors[0] = 432;
				itemDef.oldColors[1] = 7876;
				itemDef.newColors[1] = 432;
				itemDef.oldColors[2] = 7892;
				itemDef.newColors[2] = 432;
				itemDef.oldColors[3] = 7884;
				itemDef.newColors[3] = 432;
				itemDef.oldColors[4] = 7868;
				itemDef.newColors[4] = 432;
				itemDef.oldColors[5] = 7864;
				itemDef.newColors[5] = 432;
				itemDef.oldColors[6] = 7880;
				itemDef.newColors[6] = 432;
				itemDef.oldColors[7] = 7848;
				itemDef.newColors[7] = 432;
				itemDef.oldColors[8] = 7888;
				itemDef.newColors[8] = 432;
				itemDef.oldColors[9] = 7872;
				itemDef.newColors[9] = 432;
				itemDef.oldColors[10] = 7856;
				itemDef.newColors[10] = 432;
				itemDef.modelZoom = 2256;
				itemDef.rotationX = 456;
				itemDef.rotationY = 513;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.maleEquip1 = 51795;
				itemDef.femaleEquip1 = 51795;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;

			case 14006:
				itemDef.name = "Staff of light";
				itemDef.modelID = 51845;
				itemDef.oldColors = new int[11];
				itemDef.newColors = new int[11];
				itemDef.oldColors[0] = 7860;
				itemDef.newColors[0] = 24006;
				itemDef.oldColors[1] = 7876;
				itemDef.newColors[1] = 24006;
				itemDef.oldColors[2] = 7892;
				itemDef.newColors[2] = 24006;
				itemDef.oldColors[3] = 7884;
				itemDef.newColors[3] = 24006;
				itemDef.oldColors[4] = 7868;
				itemDef.newColors[4] = 24006;
				itemDef.oldColors[5] = 7864;
				itemDef.newColors[5] = 24006;
				itemDef.oldColors[6] = 7880;
				itemDef.newColors[6] = 24006;
				itemDef.oldColors[7] = 7848;
				itemDef.newColors[7] = 24006;
				itemDef.oldColors[8] = 7888;
				itemDef.newColors[8] = 24006;
				itemDef.oldColors[9] = 7872;
				itemDef.newColors[9] = 24006;
				itemDef.oldColors[10] = 7856;
				itemDef.newColors[10] = 24006;
				itemDef.modelZoom = 2256;
				itemDef.rotationX = 456;
				itemDef.rotationY = 513;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.maleEquip1 = 51795;
				itemDef.femaleEquip1 = 51795;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
			case 14007:
				itemDef.name = "Staff of light";
				itemDef.modelID = 51845;
				itemDef.oldColors = new int[11];
				itemDef.newColors = new int[11];
				itemDef.oldColors[0] = 7860;
				itemDef.newColors[0] = 14285;
				itemDef.oldColors[1] = 7876;
				itemDef.newColors[1] = 14285;
				itemDef.oldColors[2] = 7892;
				itemDef.newColors[2] = 14285;
				itemDef.oldColors[3] = 7884;
				itemDef.newColors[3] = 14285;
				itemDef.oldColors[4] = 7868;
				itemDef.newColors[4] = 14285;
				itemDef.oldColors[5] = 7864;
				itemDef.newColors[5] = 14285;
				itemDef.oldColors[6] = 7880;
				itemDef.newColors[6] = 14285;
				itemDef.oldColors[7] = 7848;
				itemDef.newColors[7] = 14285;
				itemDef.oldColors[8] = 7888;
				itemDef.newColors[8] = 14285;
				itemDef.oldColors[9] = 7872;
				itemDef.newColors[9] = 14285;
				itemDef.oldColors[10] = 7856;
				itemDef.newColors[10] = 14285;
				itemDef.modelZoom = 2256;
				itemDef.rotationX = 456;
				itemDef.rotationY = 513;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.maleEquip1 = 51795;
				itemDef.femaleEquip1 = 51795;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
			case 14003:
				itemDef.name = "Robin hood hat";
				itemDef.modelID = 3021;
				itemDef.oldColors = new int[3];
				itemDef.newColors = new int[3];
				itemDef.oldColors[0] = 15009;
				itemDef.newColors[0] = 30847;
				itemDef.oldColors[1] = 17294;
				itemDef.newColors[1] = 32895;
				itemDef.oldColors[2] = 15252;
				itemDef.newColors[2] = 30847;
				itemDef.modelZoom = 650;
				itemDef.rotationY = 2044;
				itemDef.rotationX = 256;
				itemDef.modelOffsetX = -3;
				itemDef.modelOffsetY = -5;
				itemDef.maleEquip1 = 3378;
				itemDef.femaleEquip1 = 3382;
				itemDef.maleDialogue = 3378;
				itemDef.femaleDialogue = 3382;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;

			case 14001:
				itemDef.name = "Robin hood hat";
				itemDef.modelID = 3021;
				itemDef.oldColors = new int[3];
				itemDef.newColors = new int[3];
				itemDef.oldColors[0] = 15009;
				itemDef.newColors[0] = 10015;
				itemDef.oldColors[1] = 17294;
				itemDef.newColors[1] = 7730;
				itemDef.oldColors[2] = 15252;
				itemDef.newColors[2] = 7973;
				itemDef.modelZoom = 650;
				itemDef.rotationY = 2044;
				itemDef.rotationX = 256;
				itemDef.modelOffsetX = -3;
				itemDef.modelOffsetY = -5;
				itemDef.maleEquip1 = 3378;
				itemDef.femaleEquip1 = 3382;
				itemDef.maleDialogue = 3378;
				itemDef.femaleDialogue = 3382;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;

			case 14002:
				itemDef.name = "Robin hood hat";
				itemDef.modelID = 3021;
				itemDef.oldColors = new int[3];
				itemDef.newColors = new int[3];
				itemDef.oldColors[0] = 15009;
				itemDef.newColors[0] = 35489;
				itemDef.oldColors[1] = 17294;
				itemDef.newColors[1] = 37774;
				itemDef.oldColors[2] = 15252;
				itemDef.newColors[2] = 35732;
				itemDef.modelZoom = 650;
				itemDef.rotationY = 2044;
				itemDef.rotationX = 256;
				itemDef.modelOffsetX = -3;
				itemDef.modelOffsetY = -5;
				itemDef.maleEquip1 = 3378;
				itemDef.femaleEquip1 = 3382;
				itemDef.maleDialogue = 3378;
				itemDef.femaleDialogue = 3382;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;

			case 14000:
				itemDef.name = "Robin hood hat";
				itemDef.modelID = 3021;
				itemDef.oldColors = new int[3];
				itemDef.newColors = new int[3];
				itemDef.oldColors[0] = 15009;
				itemDef.newColors[0] = 3745;
				itemDef.oldColors[1] = 17294;
				itemDef.newColors[1] = 3982;
				itemDef.oldColors[2] = 15252;
				itemDef.newColors[2] = 3988;
				itemDef.modelZoom = 650;
				itemDef.rotationY = 2044;
				itemDef.rotationX = 256;
				itemDef.rotationZ = 1;
				itemDef.modelOffsetY = -5;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.maleEquip1 = 3378;
				itemDef.femaleEquip1 = 3382;
				itemDef.maleDialogue = 3378;
				itemDef.femaleDialogue = 3382;
				break;
			case 20000:
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.modelID = 53835;
				itemDef.name = "Steadfast boots";
				itemDef.modelZoom = 900;
				itemDef.rotationY = 165;
				itemDef.rotationX = 99;
				itemDef.modelOffsetX = 3;
				itemDef.modelOffsetY = -7;
				itemDef.maleEquip1 = 53327;
				itemDef.femaleEquip1 = 53643;
				itemDef.description = "A pair of Steadfast boots.".getBytes();
				break;

			case 20001:
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.modelID = 53828;
				itemDef.name = "Glaiven boots";
				itemDef.modelZoom = 900;
				itemDef.rotationY = 165;
				itemDef.rotationX = 99;
				itemDef.modelOffsetX = 3;
				itemDef.modelOffsetY = -7;
				itemDef.femaleEquip1 = 53309;
				itemDef.maleEquip1 = 53309;
				itemDef.description = "A pair of Glaiven boots.".getBytes();
				break;

			case 20002:
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.description = "A pair of Ragefire boots.".getBytes();
				itemDef.modelID = 53897;
				itemDef.name = "Ragefire boots";
				itemDef.modelZoom = 900;
				itemDef.rotationY = 165;
				itemDef.rotationX = 99;
				itemDef.modelOffsetX = 3;
				itemDef.modelOffsetY = -7;
				itemDef.maleEquip1 = 53330;
				itemDef.femaleEquip1 = 53651;
				break;
			case 14018:
				itemDef.modelID = 6277;

				itemDef.name = "<shad=255>Tornado Katana<shad=-1>";
				itemDef.modelZoom = 2025;
				itemDef.rotationY = 593;
				itemDef.rotationX = 2040;
				itemDef.modelOffsetX = 5;
				itemDef.modelOffsetY = 1;
				itemDef.value = 50000;
				itemDef.membersObject = true;
				itemDef.maleEquip1 = 5324;
				itemDef.femaleEquip1 = 5324;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wield";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				

				break;
			case 14008:
				itemDef.modelID = 62714;
				itemDef.name = "Torva full helm";
				itemDef.modelZoom = 672;
				itemDef.rotationY = 85;
				itemDef.rotationX = 1867;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -3;
				itemDef.maleEquip1 = 62738;
				itemDef.femaleEquip1 = 62754;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				// itemDef.actions[2] = "Check-charges";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.maleDialogue = 62729;
				itemDef.femaleDialogue = 62729;
				

				break;
			case 14009:
				itemDef.modelID = 62699;
				itemDef.name = "Torva platebody";
				itemDef.modelZoom = 1506;
				itemDef.rotationY = 473;
				itemDef.rotationX = 2042;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.maleEquip1 = 62746;
				itemDef.femaleEquip1 = 62762;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				// itemDef.actions[2] = "Check-charges";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				

				break;

			case 14010:
				itemDef.modelID = 62701;
				itemDef.name = "Torva platelegs";
				itemDef.modelZoom = 1740;
				itemDef.rotationY = 474;
				itemDef.rotationX = 2045;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -5;
				itemDef.maleEquip1 = 62743;
				itemDef.femaleEquip1 = 62760;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				// itemDef.actions[2] = "Check-charges";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				

				break;

			case 20556:
				itemDef.modelID = 65341;
				itemDef.maleEquip1 = 65342;
				itemDef.femaleEquip1 = 65342;
				itemDef.name = "<col=ff6f6f>Super Glaive";
				//	itemDef.rdc2 = 8008;
				break;
			case 19749:
				itemDef.modelID = 65345;
				itemDef.maleEquip1 = 65346;
				itemDef.femaleEquip1 = 65346;
				itemDef.modelZoom = 2150;
				itemDef.name = "Wing kitesield";
				itemDef.modelOffsetX = 5;
				itemDef.modelOffsetY = 0;
				itemDef.modelZoom = 2230;
				itemDef.rotationY = 339;
				itemDef.rotationX = 1000;
				itemDef.rotationZ = 0;
				break;
			case 10638:
				itemDef.modelID = 65349;
				itemDef.maleEquip1 = 65350;
				itemDef.femaleEquip1 = 65350;
				itemDef.name = "<col=ff6f6f>Inferno Cape";
				break;
			case 12634:
				itemDef.modelID = 65351;
				itemDef.maleEquip1 = 65352;
				itemDef.femaleEquip1 = 65352;
				itemDef.modelZoom = 2650;
				itemDef.name = "<col=ff6f6f>Inferno Wings";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 20549:
					itemDef.copyItem(4710);
					itemDef.name = "Demonic scythe";
					itemDef.modelID = 18154;
					itemDef.femaleEquip1 = 18153;
					itemDef.maleEquip1 = 18153;
					itemDef.modelZoom = 4600;
					itemDef.rotationX = 357;//189
					itemDef.rotationY = 478;//768
					itemDef.modelOffsetX = -2;
					itemDef.modelOffsetY = 15;
					break;
					
			case 20173:
				itemDef.copyItem(11235);
				itemDef.modelID = 65343;
				itemDef.maleEquip1 = 65344;
				itemDef.femaleEquip1 = 65344;
				itemDef.name = "Sorrow Bow";
				itemDef.modelZoom = 2809;
				itemDef.rotationX = 861;
				itemDef.rotationY = 391;
				itemDef.rotationZ = 1887;
				itemDef.modelOffsetX = 15;
				itemDef.modelOffsetY = -19;
				itemDef.oldColors = new int[]{24, 40};
				itemDef.newColors = new int[]{68, 78};
				itemDef.actions[2] = null;
				
				break;
			case 20557:
				itemDef.modelID = 65341;
				itemDef.maleEquip1 = 65342;
				itemDef.femaleEquip1 = 65342;
				itemDef.name = "<col=ff6f6f>Nex Glaive";
				itemDef.oldColors = new int[]{60, 62};
				itemDef.newColors = new int[]{66, 66};
				
				break;
			case 20552:
				itemDef.modelID = 65341;
				itemDef.maleEquip1 = 65342;
				itemDef.femaleEquip1 = 65342;
				itemDef.name = "Soul Glaive";
				itemDef.oldColors = new int[]{60, 62};
				itemDef.newColors = new int[]{96, 96};
				///	itemDef.rdc2 = 5006;
				break;
				
			case 6930:
				itemDef.copyItem(4708);
				itemDef.stackable = false;
				itemDef.modelID = 17176;
				itemDef.maleEquip1 = 17177;
				itemDef.femaleEquip1 = 17177;
				itemDef.name = "Pernix Cowl";
				itemDef.modelOffsetY = -10;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.maleDialogue = 62728;
				itemDef.femaleDialogue = 62728;
				itemDef.stackable = false;
				break;
			case 6931:
				itemDef.copyItem(4712);
				itemDef.stackable = false;
				itemDef.modelID = 17178;
				itemDef.maleEquip1 = 17179;
				itemDef.femaleEquip1 = 17179;
				itemDef.modelOffsetY = 4;
				itemDef.name = "Pernix body";
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;

			case 6932:
				itemDef.copyItem(4714);
				itemDef.stackable = false;
				itemDef.modelID = 17180;
				itemDef.maleEquip1 = 17181;
				itemDef.femaleEquip1 = 17181;
				itemDef.modelOffsetY = 10;
				itemDef.name = "Pernix chaps";
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
			case 6933:// arlox
				itemDef.copyItem(4708);
				itemDef.stackable = false;
				itemDef.modelID = 17122;
				itemDef.maleEquip1 = 17123;
				itemDef.femaleEquip1 = 17123;
				itemDef.name = "Virtus mask";
				itemDef.modelOffsetY = -5;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.maleDialogue = 62728;
				itemDef.femaleDialogue = 62728;
				itemDef.stackable = false;
				break;

			case 6934:
				itemDef.copyItem(4712);
				itemDef.stackable = false;
				itemDef.modelID = 17153;
				itemDef.maleEquip1 = 17156;
				itemDef.femaleEquip1 = 17156;
				itemDef.name = "Virtus robe top";
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;

			case 6935:
				itemDef.copyItem(4714);
				itemDef.stackable = false;
				itemDef.modelID = 17161;
				itemDef.maleEquip1 = 17174;
				itemDef.femaleEquip1 = 17174;
				itemDef.name = "Virtus robe legs";
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
				
			case 14011:
				itemDef.modelID = 62693;
				itemDef.name = "Pernix cowl";
				itemDef.modelZoom = 800;
				itemDef.rotationY = 532;
				itemDef.rotationX = 14;
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = 1;
				itemDef.maleEquip1 = 62739;
				itemDef.femaleEquip1 = 62756;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.maleDialogue = 62731;
				itemDef.femaleDialogue = 62727;
				

				/*
				 * itemDef.originalModelColors = new int[2]; itemDef.modifiedModelColors = new
				 * int[2]; itemDef.modifiedModelColors[0] = 48543;
				 * itemDef.originalModelColors[0] = 86933; itemDef.modifiedModelColors[1] =
				 * 49567; itemDef.originalModelColors[1] = 86933;
				 */
				break;
			case 14012:
				itemDef.modelID = 62709;
				itemDef.name = "Pernix body";
				itemDef.modelZoom = 1378;
				itemDef.rotationY = 485;
				itemDef.rotationX = 2042;
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = 7;
				itemDef.maleEquip1 = 62744;
				itemDef.femaleEquip1 = 62765;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				// itemDef.actions[2] = "Check-charges";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				

				break;

			case 14013:
				itemDef.modelID = 62695;
				itemDef.name = "Pernix chaps";
				itemDef.modelZoom = 1740;
				itemDef.rotationY = 504;
				itemDef.rotationX = 0;
				itemDef.modelOffsetX = 4;
				itemDef.modelOffsetY = 3;
				itemDef.maleEquip1 = 62741;
				itemDef.femaleEquip1 = 62757;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				// itemDef.actions[2] = "Check-charges";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				

				break;
			case 22036:
				itemDef.modelID = 5419;// 62693;
				itemDef.name = "Death's hood";
				itemDef.modelZoom = 730;// 800;
				itemDef.rotationY = 0;// 532;
				itemDef.rotationX = 2036;// 14;
				itemDef.modelOffsetX = 0;// -1;
				itemDef.modelOffsetY = 0;// 1;
				itemDef.maleEquip1 = 62739;
				itemDef.femaleEquip1 = 62756;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.maleDialogue = 62731;
				itemDef.femaleDialogue = 62727;
				itemDef.newColors = new int[10];
				itemDef.oldColors = new int[10];
				itemDef.oldColors[0] = 48543; // NORM (TRIM)
				itemDef.newColors[0] = 1030; // CHANGE (TRIM)
				itemDef.oldColors[1] = 49567; // NORM (TRIM)
				itemDef.newColors[1] = 1030; // CHANGE (TRIM)
				itemDef.oldColors[2] = 8741; // NORM (INV MODEL)
				itemDef.newColors[2] = 10; // CHANGE (INV MODEL)
				itemDef.oldColors[3] = 0; // NORM (FACE)
				itemDef.newColors[3] = 100; // CHANGE (FACE) -- 25 = grey, 100 = white, 0 = black
				itemDef.oldColors[4] = 13; // NORM
				itemDef.newColors[4] = 1030; // CHANGE
				itemDef.oldColors[5] = 11; // NORM
				itemDef.newColors[5] = 1030; // CHANGE
				itemDef.oldColors[6] = 18; // NORM
				itemDef.newColors[6] = 1030; // CHANGE
				itemDef.oldColors[7] = 10; // NORM
				itemDef.newColors[7] = 1030; // CHANGE
				itemDef.oldColors[8] = 16; // NORM
				itemDef.newColors[8] = 1030; // CHANGE
				itemDef.oldColors[8] = 1032; // NORM
				itemDef.newColors[8] = 16; // CHANGE
				break;

			case 22037:
				itemDef.modelID = 6578;// 62693;
				itemDef.name = "Death's robe top";
				itemDef.modelZoom = 1250;// 800;
				itemDef.rotationY = 468;// 532;
				itemDef.rotationX = 0;// 14;
				itemDef.modelOffsetX = 0;// -1;
				itemDef.modelOffsetY = 3;// 1;
				itemDef.maleEquip1 = 6669;
				itemDef.femaleEquip1 = 6669;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[5];
				itemDef.oldColors = new int[5];
				itemDef.oldColors[0] = 14490; // NORM
				itemDef.newColors[0] = 1030; // CHANGE
				itemDef.oldColors[1] = 10396; // NORM
				itemDef.newColors[1] = 1; // CHANGE
				itemDef.oldColors[2] = 10388; // NORM
				itemDef.newColors[2] = 4; // CHANGE
				itemDef.oldColors[3] = 8741; // NORM
				itemDef.newColors[3] = 1030; // CHANGE
				itemDef.oldColors[4] = 16652; // NORM
				itemDef.newColors[4] = 1; // CHANGE
				itemDef.anInt188 = 170;
				break;

			case 22038:
				itemDef.modelID = 6577;// 62693;
				itemDef.name = "Death's robe bottoms";
				itemDef.modelZoom = 1600;// 800;
				itemDef.rotationY = 500;// 532;
				itemDef.rotationX = 2036;// 14;
				itemDef.modelOffsetX = 0;// -1;
				itemDef.modelOffsetY = 0;// 1;
				itemDef.maleEquip1 = 6659;
				itemDef.femaleEquip1 = 6659;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[3];
				itemDef.oldColors = new int[3];
				itemDef.oldColors[0] = 14490; // NORM
				itemDef.newColors[0] = 1030; // CHANGE
				itemDef.oldColors[1] = 10396; // NORM
				itemDef.newColors[1] = 1; // CHANGE
				itemDef.oldColors[2] = 10388; // NORM
				itemDef.newColors[2] = 4; // CHANGE
				break;

			case 22039:
				itemDef.modelID = 2718;// 62693;
				itemDef.name = "Defiled shank";
				itemDef.modelZoom = 760;// 800;
				itemDef.rotationY = 472;// 532;
				itemDef.rotationX = 1276;// 14;
				itemDef.modelOffsetX = 0;// -1;
				itemDef.modelOffsetY = 0;// 1;
				itemDef.maleEquip1 = 539;
				itemDef.femaleEquip1 = 539;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				itemDef.newColors = new int[4];
				itemDef.oldColors = new int[4];
				itemDef.oldColors[0] = 37; // NORM
				itemDef.newColors[0] = 1030; // CHANGE
				itemDef.oldColors[1] = 6036; // NORM
				itemDef.newColors[1] = 1030; // CHANGE
				itemDef.oldColors[2] = 924; // NORM
				itemDef.newColors[2] = 127; // CHANGE
				itemDef.oldColors[3] = 22459; // NORM
				itemDef.newColors[3] = 924; // CHANGE
				break;

			case 22052:
				itemDef.name = "Prestige cape";
				itemDef.modelID = 56785;
				itemDef.maleEquip1 = 55904;
				itemDef.femaleEquip1 = 56557;
				itemDef.newColors = new int[17];
				itemDef.oldColors = new int[17];
				itemDef.oldColors[0] = 54352; // NORM
				itemDef.newColors[0] = 11200; // CHANGE
				itemDef.oldColors[1] = 54307; // NORM
				itemDef.newColors[1] = 10; // CHANGE
				itemDef.oldColors[2] = 54317; // NORM
				itemDef.newColors[2] = 20; // CHANGE
				itemDef.oldColors[3] = 54312; // NORM
				itemDef.newColors[3] = 15; // CHANGE
				itemDef.oldColors[4] = 54302; // NORM
				itemDef.newColors[4] = 8; // CHANGE
				itemDef.oldColors[5] = 54322; // NORM
				itemDef.newColors[5] = 28; // CHANGE
				itemDef.oldColors[6] = 54315; // NORM
				itemDef.newColors[6] = 21; // CHANGE
				itemDef.oldColors[7] = 54310; // NORM
				itemDef.newColors[7] = 13; // CHANGE
				itemDef.oldColors[8] = 54297; // NORM
				itemDef.newColors[8] = 1; // CHANGE
				itemDef.oldColors[9] = 54292; // NORM
				itemDef.newColors[9] = 1; // CHANGE
				itemDef.oldColors[10] = 54316; // NORM
				itemDef.newColors[10] = 9; // CHANGE
				itemDef.oldColors[11] = 54311; // NORM
				itemDef.newColors[11] = 4; // CHANGE
				itemDef.oldColors[12] = 54318; // NORM
				itemDef.newColors[12] = 20; // CHANGE
				itemDef.oldColors[13] = 54313; // NORM
				itemDef.newColors[13] = 14; // CHANGE
				itemDef.oldColors[14] = 54308; // NORM
				itemDef.newColors[14] = 11; // CHANGE
				itemDef.oldColors[15] = 54319; // NORM
				itemDef.newColors[15] = 22; // CHANGE
				itemDef.oldColors[16] = 54320; // NORM
				itemDef.newColors[16] = 23; // CHANGE
				itemDef.modelOffsetX = -1;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				itemDef.rotationY = 252;
				itemDef.rotationX = 54;
				itemDef.modelZoom = 1616;
				itemDef.actions = new String[]{null, "Wear", null, null, "Destroy"};
				itemDef.groundActions = new String[]{null, null, "Take", null, null};

				break;

			case 22064:
				itemDef.name = "Malediction ward";
				itemDef.modelID = 9354;
				itemDef.modelZoom = 1200;
				itemDef.rotationY = 568;
				itemDef.rotationX = 1836;
				itemDef.rotationZ = 2;
				itemDef.modelOffsetY = 3;
				itemDef.oldColors = new int[]{908};
				itemDef.newColors = new int[]{-21608};
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.maleEquip1 = 9347;
				itemDef.femaleEquip1 = 9347;
				break;

			case 22066:
				itemDef.name = "Odium ward";
				itemDef.modelID = 9354;
				itemDef.modelZoom = 1200;
				itemDef.rotationY = 568;
				itemDef.rotationX = 1836;
				itemDef.rotationZ = 2;
				itemDef.modelOffsetY = 3;
				itemDef.oldColors = new int[]{908};
				itemDef.newColors = new int[]{15252};
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.maleEquip1 = 9347;
				itemDef.femaleEquip1 = 9347;
				break;

			case 22041:
				itemDef.name = "Black h'ween mask";
				itemDef.modelID = 2438;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = -10;
				itemDef.rotationY = 516;
				itemDef.rotationX = 0;
				itemDef.modelZoom = 730;
				itemDef.newColors = new int[2];
				itemDef.oldColors = new int[2];
				itemDef.oldColors[0] = 0; // NORM
				itemDef.newColors[0] = 11200; // CHANGE --EYES
				itemDef.oldColors[1] = 926; // NORM
				itemDef.newColors[1] = 4; // CHANGE --MASK COLOR
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.maleEquip1 = 3188;
				itemDef.femaleEquip1 = 3192;
				break;

			case 22045:
				itemDef.name = "Dragonstone ring (e)";
				itemDef.modelID = 47752;
				itemDef.modelOffsetX = -1;
				itemDef.rotationZ = 2042;
				itemDef.modelOffsetY = 1;
				itemDef.rotationY = 322;
				itemDef.rotationX = 135;
				itemDef.modelZoom = 830;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.maleEquip1 = -1;
				itemDef.femaleEquip1 = -1;
				break;

			case 22047:
				itemDef.name = "Giant snake spine";
				itemDef.modelID = 48229;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				itemDef.rotationY = 201;
				itemDef.rotationX = 1649;
				itemDef.modelZoom = 2000;
				itemDef.actions = new String[]{"Bury", null, null, null, "Drop"};
				itemDef.maleEquip1 = -1;
				itemDef.femaleEquip1 = -1;
				break;

			case 22040:
				itemDef.modelID = 2543;// 62693;
				itemDef.name = "The Levincia book";
				itemDef.modelZoom = 760;// 800;
				itemDef.rotationY = 244;// 532;
				itemDef.rotationX = 116;// 14;
				itemDef.modelOffsetX = 1;// -1;
				itemDef.modelOffsetY = 0;// 1;
				itemDef.maleEquip1 = 556;
				itemDef.femaleEquip1 = 556;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				itemDef.newColors = new int[4];
				itemDef.oldColors = new int[4];
				itemDef.oldColors[0] = 11177; // NORM
				itemDef.newColors[0] = 1030; // CHANGE
				itemDef.oldColors[1] = 61; // NORM
				itemDef.newColors[1] = 1030; // CHANGE
				itemDef.oldColors[2] = 5018; // NORM
				itemDef.newColors[2] = 16; // CHANGE
				itemDef.oldColors[3] = 10351; // NORM
				itemDef.newColors[3] = 50; // CHANGE
				break;

			case 22043:
				itemDef.modelID = 7702;
				itemDef.name = "Santa sack";
				itemDef.modelZoom = 2280;// 800;
				itemDef.rotationY = 64;// 532;
				itemDef.rotationX = 112;// 14;
				itemDef.modelOffsetX = 0;// -1;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;// 1;
				itemDef.maleEquip1 = 7122;
				itemDef.femaleEquip1 = 7122;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[4];
				itemDef.oldColors = new int[4];
				itemDef.oldColors[0] = 6674; // NORM
				itemDef.newColors[0] = 30; // CHANGE --Yellow Trim = 11200
				itemDef.oldColors[1] = 6430; // NORM
				itemDef.newColors[1] = 933; // CHANGE
				itemDef.oldColors[2] = 6554; // NORM
				itemDef.newColors[2] = 933; // CHANGE
				itemDef.oldColors[3] = 6550; // NORM
				itemDef.newColors[3] = 933; // CHANGE
				break;

			case 14014:
				itemDef.modelID = 62710;
				itemDef.name = "Virtus mask";
				itemDef.modelZoom = 928;
				itemDef.rotationY = 406;
				itemDef.rotationX = 2041;
				itemDef.modelOffsetX = 1;
				itemDef.modelOffsetY = -5;
				itemDef.maleEquip1 = 62736;
				itemDef.femaleEquip1 = 62755;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.maleDialogue = 62728;
				itemDef.femaleDialogue = 62728;
				break;

			case 14015:
				itemDef.modelID = 62704;
				itemDef.name = "Virtus robe top";
				itemDef.modelZoom = 1122;
				itemDef.rotationY = 488;
				itemDef.rotationX = 3;
				itemDef.modelOffsetX = 1;
				itemDef.modelOffsetY = 0;
				itemDef.maleEquip1 = 62748;
				itemDef.femaleEquip1 = 62764;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;

			case 14016:
				itemDef.modelID = 62700;
				itemDef.name = "Virtus robe legs";
				itemDef.modelZoom = 1740;
				itemDef.rotationY = 498;
				itemDef.rotationX = 2045;
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = 4;
				itemDef.maleEquip1 = 62742;
				itemDef.femaleEquip1 = 62758;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;

			case 6082:
				itemDef.name = "RPG";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.rdc2 = 2252;
				break;

			case 15901:
				itemDef.name = "Saradomin hood (b)";
				break;

			case 14140:
			case 14141:
				itemDef.name = "Sacred clay axe";
				break;
			case 14130:
			case 14131:
				itemDef.name = "Sacred clay pickaxe";
				break;

			case 16753:
				itemDef.name = "Saradomin hood";
				
				break;

			case 16754:
				itemDef.name = "Saradomin hood";
				

				break;

			case 15846:
				itemDef.name = "Saradomin robe top (b)";
				
				break;

			case 17235:
				itemDef.name = "Saradomin robe top";
				
				break;

			case 17236:
				itemDef.name = "Saradomin robe top";
				
				break;

			case 15806:
				itemDef.name = "Saradomin robe bottom (b)";
				
				break;

			case 16863:
				itemDef.name = "Saradomin robe bottom";
				
				break;

			case 16864:
				itemDef.name = "Saradomin robe bottom";
				
				break;
			case 11846:
			case 11848:
			case 11850:
			case 11852:
			case 11854:
			case 11856:
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.actions[2] = "Open-All";
				break;
				
			case 19582:
				itemDef.name = "Sagittarian range set";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.actions[2] = "Open-All";
				break;

			case 11858:
			case 14525:
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.actions[2] = "Open-All";
				break;
				
			case 9666:
			case 11814:
			case 11816:
			case 11818:
			case 11820:
			case 11822:
			case 11824:
			case 11826:
			case 11828:
			case 11830:
			case 11832:
			case 11834:
			case 11836:
			case 11838:
			case 11840:
			case 11842:
			case 11844:
			case 11860:
			case 19580:
			case 11862:
			case 11864:
			case 11866:
			case 11868:
			case 11870:
			case 11874:
			case 11876:
			case 11878:
			case 11882:
			case 11886:
			case 11890:
			case 11894:
			case 11898:
			case 11902:
			case 11904:
			case 11906:
			case 11926:
			case 11928:
			case 11930:
			case 11938:
			case 11942:
			case 11944:
			case 11946:
			case 14527:
			case 14529:
			case 14531:
			case 19588:
			case 19592:
			case 19596:
			case 11908:
			case 11910:
			case 11912:
			case 11914:
			case 11916:
			case 11618:
			case 11920:
			case 11922:
			case 11924:
			case 11960:
			case 11962:
			case 11967:
			case 19586:
			case 19584:
			case 19590:
			case 19594:
			case 19598:
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				break;
			case 7587:
				itemDef.name = "Coffin of the Damned";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				break;
			case 7980:
				itemDef.name = "KBD heads";
				itemDef.description = "I should get these stuffed!".getBytes();
				itemDef.actions = new String[5];
				break;
			case 8141:
				itemDef.name = "Baby Dagannoth Prime";
				itemDef.description = "A miniature Dagannoth Prime.".getBytes();
				break;
			case 8142:
				itemDef.name = "Baby Dagannoth Rex";
				itemDef.description = "A miniature Dagannoth Rex.".getBytes();

				ItemDefinition def2 = ItemDefinition.get(8141);
				itemDef.modelID = def2.modelID;
				itemDef.modelZoom = def2.modelZoom;
				itemDef.rotationY = def2.rotationY;
				itemDef.rotationX = def2.rotationX;
				itemDef.modelOffsetX = def2.modelOffsetX;
				itemDef.modelOffsetY = def2.modelOffsetY;
				break;
			case 8143:
				itemDef.name = "Baby Dagannoth Supreme";
				itemDef.description = "A miniature Dagannoth Supreme.".getBytes();

				ItemDefinition def3 = ItemDefinition.get(8141);
				itemDef.modelID = def3.modelID;
				itemDef.modelZoom = def3.modelZoom;
				itemDef.rotationY = def3.rotationY;
				itemDef.rotationX = def3.rotationX;
				itemDef.modelOffsetX = def3.modelOffsetX;
				itemDef.modelOffsetY = def3.modelOffsetY;
				break;
			case 8144:
				// 11216
				itemDef.name = "Baby Chaos Elemental";
				itemDef.description = "A miniature Chaos Elemental.".getBytes();

				ItemDefinition def4 = ItemDefinition.get(8141);
				itemDef.modelID = 11216;
				itemDef.modelZoom = def4.modelZoom;
				itemDef.rotationY = def4.rotationY;
				itemDef.rotationX = def4.rotationX;
				itemDef.modelOffsetX = def4.modelOffsetX;
				itemDef.modelOffsetY = def4.modelOffsetY;
				break;
			// 28057
			case 8145:
				// 11216
				itemDef.name = "Baby Commander Zilyana";
				itemDef.description = "A miniature Commander Zilyana.".getBytes();

				ItemDefinition def5 = ItemDefinition.get(8141);
				itemDef.modelID = 28078;
				itemDef.modelZoom = 2000;
				// System.out.println("" + def5.modelZoom);
				itemDef.rotationY = def5.rotationY;
				itemDef.rotationX = def5.rotationX;
				itemDef.modelOffsetX = 7;
				itemDef.modelOffsetY = 7;
				break;
			case 8146:
				// 11216
				itemDef.name = "Baby Penance Queen";
				itemDef.description = "A miniature Penance Queen.".getBytes();

				ItemDefinition def6 = ItemDefinition.get(8141);
				itemDef.modelID = 20715;
				itemDef.modelZoom = def6.modelZoom;
				itemDef.rotationY = def6.rotationY;
				itemDef.rotationX = def6.rotationX;
				itemDef.modelOffsetX = def6.modelOffsetX;
				itemDef.modelOffsetY = def6.modelOffsetY;
				break;
			case 8147:
				// 11216
				itemDef.name = "Baby General Graardor";
				itemDef.description = "A miniature General Graardor.".getBytes();

				ItemDefinition def7 = ItemDefinition.get(8141);
				itemDef.modelID = 27785;
				itemDef.modelZoom = def7.modelZoom;
				itemDef.rotationY = def7.rotationY;
				itemDef.rotationX = def7.rotationX;
				itemDef.modelOffsetX = def7.modelOffsetX;
				itemDef.modelOffsetY = def7.modelOffsetY;
				break;
			case 8148:
				// 11216
				itemDef.name = "Baby Kree'arra";
				itemDef.description = "A miniature Kree'arra.".getBytes();
				ItemDefinition def8 = ItemDefinition.get(8141);
				itemDef.modelID = 28004;
				itemDef.modelZoom = def8.modelZoom;
				itemDef.rotationY = def8.rotationY;
				itemDef.rotationX = def8.rotationX;
				itemDef.modelOffsetX = def8.modelOffsetX;
				itemDef.modelOffsetY = def8.modelOffsetY;
				break;
			case 8149:
				// 11216
				itemDef.name = "Baby Giant Mole";
				itemDef.description = "A miniature Giant Mole.".getBytes();

				ItemDefinition def9 = ItemDefinition.get(8141);
				itemDef.modelID = 12076;
				itemDef.modelZoom = 3500;
				itemDef.rotationY = def9.rotationY;
				itemDef.rotationX = def9.rotationX;
				itemDef.modelOffsetX = def9.modelOffsetX;
				itemDef.modelOffsetY = def9.modelOffsetY;
				break;
			case 15109:
				itemDef.name = "Jar of the swamp";
				break;
			case 1513:
				itemDef.actions = new String[5];
				
				itemDef.newColors = new int[2];
				itemDef.oldColors = new int[2];
				itemDef.oldColors[0] = 127;
				itemDef.newColors[0] = 8481;
				break;
			case 303:
				itemDef.newColors = new int[2];
				itemDef.oldColors = new int[2];
				itemDef.oldColors[0] = 127; // white plague
				itemDef.newColors[0] = 7100;
			case 305:
				itemDef.newColors = new int[2];
				itemDef.oldColors = new int[2];
				itemDef.oldColors[0] = 127; // white plague
				itemDef.newColors[0] = 7446;
				break;
			case 10284:
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.newColors = new int[2];
				itemDef.oldColors = new int[2];
				itemDef.oldColors[0] = 933;
				itemDef.newColors[0] = 6;
				itemDef.modelID = 2537;
				itemDef.modelZoom = 540;
				itemDef.rotationY = 72;
				itemDef.rotationX = 136;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -3;
				itemDef.maleEquip1 = 189;
				itemDef.anInt188 = -1;
				itemDef.femaleEquip1 = 366;
				itemDef.anInt164 = -1;
				itemDef.maleDialogue = 69;
				itemDef.femaleDialogue = 127;
				itemDef.stackable = false;
				itemDef.name = "Black santa hat";
				itemDef.description = "Black santa hat.".getBytes();
				break;
			case 20110:// tpig
				itemDef.name = "Pig mask";
				itemDef.modelID = 65087;
				itemDef.maleEquip1 = 65088;
				itemDef.femaleEquip1 = 65088;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				// itemDef.rdc2 = 6666;
				break;


			case 18789:
				ItemDefinition itemZammy1 = ItemDefinition.get(11700);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = itemZammy1.modelID;
				itemDef.femaleEquip1 = itemZammy1.femaleEquip1;
				itemDef.maleEquip1 = itemZammy1.maleEquip1;
				itemDef.modelOffsetX = itemZammy1.modelOffsetX;
				itemDef.rotationZ = itemZammy1.rotationZ;
				itemDef.modelOffsetY = itemZammy1.modelOffsetY;
				itemDef.modelZoom = itemZammy1.modelZoom;
				itemDef.rotationY = itemZammy1.rotationY;
				itemDef.rotationX = itemZammy1.rotationX;
				itemDef.actions = itemZammy1.actions;
				itemDef.name = "Tsutsaroth godsword";
				
				itemDef.rdc2 = 33333;
				break;
			case 18791:
				ItemDefinition itemZammy11 = ItemDefinition.get(18746);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = itemZammy11.modelID;
				itemDef.femaleEquip1 = itemZammy11.femaleEquip1;
				itemDef.maleEquip1 = itemZammy11.maleEquip1;
				itemDef.modelOffsetX = itemZammy11.modelOffsetX;
				itemDef.rotationZ = itemZammy11.rotationZ;
				itemDef.modelOffsetY = itemZammy11.modelOffsetY;
				itemDef.modelZoom = itemZammy11.modelZoom;
				itemDef.rotationY = itemZammy11.rotationY;
				itemDef.rotationX = itemZammy11.rotationX;
				itemDef.actions = itemZammy11.actions;
				itemDef.name = itemZammy11.name;
				itemDef.rdc2 = 55555;
				
				itemDef.name = "Tsutsaroth halo";
				break;
			case 18787:
				ItemDefinition itemZammy111 = ItemDefinition.get(20000);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = itemZammy111.modelID;
				itemDef.femaleEquip1 = itemZammy111.femaleEquip1;
				itemDef.maleEquip1 = itemZammy111.maleEquip1;
				itemDef.modelOffsetX = itemZammy111.modelOffsetX;
				itemDef.rotationZ = itemZammy111.rotationZ;
				itemDef.modelOffsetY = itemZammy111.modelOffsetY;
				itemDef.modelZoom = itemZammy111.modelZoom;
				itemDef.rotationY = itemZammy111.rotationY;
				itemDef.rotationX = itemZammy111.rotationX;
				itemDef.actions = itemZammy111.actions;
				itemDef.name = "Tsutsaroth boots";
				
				itemDef.rdc2 = 77777;
				break;
			case 5021:
				itemDef.name = "1M ticket";
				//itemDef.rdc2 = 23452;//333233 gold
				itemDef.stackable = true;
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Convert-to-coin";
				itemDef21 = ItemDefinition.get(18652);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.modelID = itemDef21.modelID;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{67};
				break;
			case 5022:
				itemDef.name = "<col=ff4f4f>PVM ticket";
				itemDef.rdc2 = 325111;
				itemDef21 = ItemDefinition.get(18652);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.modelID = itemDef21.modelID;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				break;
			case 5023:
				itemDef.name = "<col=aaaaaa><shad=2>Slayer ticket";
				itemDef.rdc2 = 23452;//666455
				itemDef.stackable = true;
				itemDef21 = ItemDefinition.get(18652);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.modelID = itemDef21.modelID;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{67};
				break;
			case 9000:
				itemDef.copyItem(5023);
				itemDef.rdc2 = 23452;//666455
				itemDef.name = "<col=aaaaaa><shad=2>Boss Slayer tickets";
				break;
			case 23275:
				itemDef.copyItem(5020);
				itemDef.rdc3 = 73403;//666455
				itemDef.actions = new String[]{ "Claim",null, null, null, "Drop"};
				itemDef.name = "Gold Season Pass";
				itemDef.stackable = false;
				break;

			case 23392:
				itemDef.copyItem(5020);
				itemDef.rdc3 = 498503;//666455
				itemDef.actions = new String[]{ "Claim",null, null, null, "Drop"};
				itemDef.name = "Monthly Benefits Pass";
				itemDef.stackable = false;
				break;
			case 23393:
				itemDef.copyItem(5020);
				itemDef.rdc3 = 2340503;//666455
				itemDef.actions = new String[]{ "Claim",null, null, null, "Drop"};
				itemDef.name = "Monthly Cosmetic Pass";
				itemDef.stackable = false;
				break;
			case 22044:
				itemDef.modelID = 65270;
				itemDef.name = "Completionist Cape";
				itemDef.description = "We'd pat you on the back, but this cape would get in the way.".getBytes();
				itemDef.modelZoom = 1385;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 24;
				itemDef.rotationY = 279;
				itemDef.rotationX = 948;
				itemDef.oldColors = new int[]{65214, 65200, 65186, 62995};
				itemDef.newColors = new int[]{44988, 44988, 32463, 44988};
				itemDef.maleEquip1 = 65297;
				itemDef.femaleEquip1 = 65297;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				break;

			case 2722:
			case 2723:
			case 2725:
			case 2727:
			case 2729:
			case 2731:
			case 2733:
			case 2735:
			case 2737:
			case 2739:
			case 2741:
			case 2743:
			case 2745:
			case 2747:
			case 2774:
			case 2776:
			case 2778:
			case 2780:
			case 2782:
			case 2783:
			case 2785:
			case 2786:
			case 2788:
			case 2790:
			case 2792:
			case 2793:
			case 2794:
			case 2796:
			case 2797:
			case 2799:
			case 3520:
			case 3522:
			case 3524:
			case 3525:
			case 3526:
			case 3528:
			case 3530:
			case 3532:
			case 3534:
			case 3536:
			case 3538:
			case 3540:
			case 3542:
			case 3544:
			case 3546:
			case 3548:
			case 3550:
				itemDef.name = "Clue scroll";
				break;
			case 2773:
				itemDef.name = "Clue scroll (hard)";
				break;
			case 15752:
			case 15751:
			case 15750:
				itemDef.name = "Saber Crystal";
				itemDef.actions = new String[]{"Break-crystal", null, null, null, "Destroy"};
				break;
			case 2946:
				itemDef.actions = new String[]{"Open", null, null, null, "Destroy"};
				break;
			case 1561:
				itemDef.name = "Pet return";
				itemDef.actions = new String[]{"Claim pets", null, null, null, "Destroy"};
				break;
			case 9004:
				itemDef.name = "Tome of Inquisition";
				break;
			case 9003:
				itemDef.name = "Tome of Inquisition";
				itemDef.actions = new String[]{"Instructions", null, "View drops", null, "Drop"};
				break;
			case 554:
				itemDef.rotationY = 528;
				itemDef.rotationX = 1012;
				break;
			case 22060:
				itemDef.name = "Mahogany logs";
				itemDef.description = "Some well-cut mahogany logs.".getBytes();
				itemDef.actions = new String[]{null, null, null, null, null};
				itemDef.groundActions = new String[]{null, null, "Take", "Light", null};
				itemDef.newColors = new int[]{6585, 4758, 5006};
				itemDef.oldColors = new int[]{5665, 5784, 5559};
				itemDef.modelID = 7760;
				itemDef.modelZoom = 1180;
				itemDef.rotationY = 120;
				itemDef.rotationX = 1852;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -7;
				itemDef.maleEquip1 = -1;
				itemDef.anInt188 = -1;
				itemDef.femaleEquip1 = -1;
				itemDef.anInt164 = -1;
				itemDef.maleDialogue = -1;
				itemDef.femaleDialogue = -1;
				itemDef.stackable = false;
				break;
			case 22061:
				itemDef.name = "Mahogany logs";
				itemDef.description = "Some well-cut mahogany logs.".getBytes();
				itemDef.actions = new String[]{null, null, null, null, null};
				itemDef.groundActions = new String[]{null, null, null, null, null};
				itemDef.newColors = new int[]{6585, 4758, 5006};
				itemDef.oldColors = new int[]{5665, 5784, 5559};

				itemDef.certID = 22060;
				itemDef.certTemplateID = 799;
				itemDef.rotationY = 552;
				itemDef.rotationX = 28;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 2;
				// itemDef.modelID = 2429;
				itemDef.modelZoom = 1385;

				itemDef.modelID = 7760;
				// itemDef.modelZoom = 1180;
				// itemDef.modelRotationY = 120;
				// itemDef.modelRotationX = 1852;
				// itemDef.modelOffsetX = 0;
				// itemDef.modelOffset1 = 0;
				// itemDef.modelOffsetY = -7;
				itemDef.maleEquip1 = -1;
				itemDef.anInt188 = -1;
				itemDef.femaleEquip1 = -1;
				itemDef.anInt164 = -1;
				itemDef.maleDialogue = -1;
				itemDef.femaleDialogue = -1;
				itemDef.stackable = true;
				break;
			case 22062:
				itemDef.name = "barb axe";
				itemDef.description = "something.".getBytes();
				itemDef.modelID = 11788;
				itemDef.maleEquip1 = 11788;
				itemDef.femaleEquip1 = 11788;
				itemDef.actions[1] = "Wield";
				break;
			// LEVINCIA PROGRESSION GEAR - safe reserved range 22573-22605
			case 22573:
				itemDef.copyItem(1163);
				itemDef.name = "Frostborn Helm";
				itemDef.description = "Levincia Frostborn progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22574:
				itemDef.copyItem(1127);
				itemDef.name = "Frostborn Platebody";
				itemDef.description = "Levincia Frostborn progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22575:
				itemDef.copyItem(1079);
				itemDef.name = "Frostborn Platelegs";
				itemDef.description = "Levincia Frostborn progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22576:
				itemDef.copyItem(6570);
				itemDef.name = "Frostborn Cape";
				itemDef.description = "Levincia Frostborn progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22577:
				itemDef.copyItem(4151);
				itemDef.name = "Frostborn Frostblade";
				itemDef.description = "Levincia Frostborn progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22578:
				itemDef.copyItem(861);
				itemDef.name = "Frostborn Frost Bow";
				itemDef.description = "Levincia Frostborn progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22579:
				itemDef.copyItem(1381);
				itemDef.name = "Frostborn Frost Staff";
				itemDef.description = "Levincia Frostborn progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22580:
				itemDef.copyItem(1187);
				itemDef.name = "Frostborn Frost Shield";
				itemDef.description = "Levincia Frostborn progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22581:
				itemDef.copyItem(1163);
				itemDef.name = "Bloodforged Helm";
				itemDef.description = "Levincia Bloodforged progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22582:
				itemDef.copyItem(1127);
				itemDef.name = "Bloodforged Platebody";
				itemDef.description = "Levincia Bloodforged progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22583:
				itemDef.copyItem(1079);
				itemDef.name = "Bloodforged Platelegs";
				itemDef.description = "Levincia Bloodforged progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22584:
				itemDef.copyItem(6570);
				itemDef.name = "Bloodforged Cape";
				itemDef.description = "Levincia Bloodforged progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22585:
				itemDef.copyItem(4151);
				itemDef.name = "Bloodforged Bloodblade";
				itemDef.description = "Levincia Bloodforged progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22586:
				itemDef.copyItem(861);
				itemDef.name = "Bloodforged Blood Bow";
				itemDef.description = "Levincia Bloodforged progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22587:
				itemDef.copyItem(1381);
				itemDef.name = "Bloodforged Blood Staff";
				itemDef.description = "Levincia Bloodforged progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22588:
				itemDef.copyItem(1187);
				itemDef.name = "Bloodforged Blood Shield";
				itemDef.description = "Levincia Bloodforged progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22589:
				itemDef.copyItem(1163);
				itemDef.name = "Toxic Helm";
				itemDef.description = "Levincia Toxic progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22590:
				itemDef.copyItem(1127);
				itemDef.name = "Toxic Platebody";
				itemDef.description = "Levincia Toxic progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22591:
				itemDef.copyItem(1079);
				itemDef.name = "Toxic Platelegs";
				itemDef.description = "Levincia Toxic progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22592:
				itemDef.copyItem(6570);
				itemDef.name = "Toxic Cape";
				itemDef.description = "Levincia Toxic progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22593:
				itemDef.copyItem(1249);
				itemDef.name = "Toxic Spear";
				itemDef.description = "Levincia Toxic progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22594:
				itemDef.copyItem(861);
				itemDef.name = "Toxic Venom Bow";
				itemDef.description = "Levincia Toxic progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22595:
				itemDef.copyItem(1381);
				itemDef.name = "Toxic Staff";
				itemDef.description = "Levincia Toxic progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22596:
				itemDef.copyItem(1187);
				itemDef.name = "Toxic Shield";
				itemDef.description = "Levincia Toxic progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22597:
				itemDef.copyItem(1163);
				itemDef.name = "Storm Helm";
				itemDef.description = "Levincia Storm progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22598:
				itemDef.copyItem(1127);
				itemDef.name = "Storm Platebody";
				itemDef.description = "Levincia Storm progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22599:
				itemDef.copyItem(1079);
				itemDef.name = "Storm Platelegs";
				itemDef.description = "Levincia Storm progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22600:
				itemDef.copyItem(6570);
				itemDef.name = "Storm Cape";
				itemDef.description = "Levincia Storm progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22601:
				itemDef.copyItem(4151);
				itemDef.name = "Stormblade";
				itemDef.description = "Levincia Storm progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22602:
				itemDef.copyItem(861);
				itemDef.name = "Storm Bow";
				itemDef.description = "Levincia Storm progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22603:
				itemDef.copyItem(1381);
				itemDef.name = "Storm Staff";
				itemDef.description = "Levincia Storm progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22604:
				itemDef.copyItem(1187);
				itemDef.name = "Storm Shield";
				itemDef.description = "Levincia Storm progression equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22605:
				itemDef.copyItem(23697);
				itemDef.name = "Levincia Void Scythe";
				itemDef.description = "A weapon forged in the void, imbued with Levincia power.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;
			// LEVINCIA MIDGAME GEAR - cache-safe template models
			case 22610:
				itemDef.copyItem(1163);
				itemDef.name = "Infernal Helm";
				itemDef.description = "Levincia mid-game infernal equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22611:
				itemDef.copyItem(1127);
				itemDef.name = "Infernal Platebody";
				itemDef.description = "Levincia mid-game infernal equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22612:
				itemDef.copyItem(1079);
				itemDef.name = "Infernal Platelegs";
				itemDef.description = "Levincia mid-game infernal equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22613:
				itemDef.copyItem(6570);
				itemDef.name = "Infernal Cape";
				itemDef.description = "Levincia mid-game infernal equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22614:
				itemDef.copyItem(7158);
				itemDef.name = "Infernal Greatsword";
				itemDef.description = "Levincia mid-game infernal equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22615:
				itemDef.copyItem(861);
				itemDef.name = "Infernal Bow";
				itemDef.description = "Levincia mid-game infernal equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22616:
				itemDef.copyItem(1387);
				itemDef.name = "Infernal Staff";
				itemDef.description = "Levincia mid-game infernal equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22617:
				itemDef.copyItem(1187);
				itemDef.name = "Infernal Shield";
				itemDef.description = "Levincia mid-game infernal equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22618:
				itemDef.copyItem(4708);
				itemDef.name = "Shadow Hood";
				itemDef.description = "Levincia mid-game shadow equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22619:
				itemDef.copyItem(4712);
				itemDef.name = "Shadow Robe Top";
				itemDef.description = "Levincia mid-game shadow equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22620:
				itemDef.copyItem(4714);
				itemDef.name = "Shadow Robe Bottom";
				itemDef.description = "Levincia mid-game shadow equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22621:
				itemDef.copyItem(6570);
				itemDef.name = "Shadow Cape";
				itemDef.description = "Levincia mid-game shadow equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22622:
				itemDef.copyItem(1419);
				itemDef.name = "Shadow Scythe";
				itemDef.description = "Levincia mid-game shadow equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22623:
				itemDef.copyItem(11235);
				itemDef.name = "Shadow Bow";
				itemDef.description = "Levincia mid-game shadow equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22624:
				itemDef.copyItem(1389);
				itemDef.name = "Shadow Staff";
				itemDef.description = "Levincia mid-game shadow equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22625:
				itemDef.copyItem(11924);
				itemDef.name = "Shadow Shield";
				itemDef.description = "Levincia mid-game shadow equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22626:
				itemDef.copyItem(11335);
				itemDef.name = "Dragon Helm";
				itemDef.description = "Levincia mid-game dragon equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22627:
				itemDef.copyItem(14479);
				itemDef.name = "Dragon Platebody";
				itemDef.description = "Levincia mid-game dragon equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22628:
				itemDef.copyItem(4087);
				itemDef.name = "Dragon Platelegs";
				itemDef.description = "Levincia mid-game dragon equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22629:
				itemDef.copyItem(6570);
				itemDef.name = "Dragon Cape";
				itemDef.description = "Levincia mid-game dragon equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 22630:
				itemDef.copyItem(4587);
				itemDef.name = "Dragon Cleaver";
				itemDef.description = "Levincia mid-game dragon equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22631:
				itemDef.copyItem(861);
				itemDef.name = "Dragon Bow";
				itemDef.description = "Levincia mid-game dragon equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22632:
				itemDef.copyItem(1387);
				itemDef.name = "Dragon Staff";
				itemDef.description = "Levincia mid-game dragon equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wield", null, null, "Drop"};
				break;

			case 22633:
				itemDef.copyItem(11283);
				itemDef.name = "Dragon Shield";
				itemDef.description = "Levincia mid-game dragon equipment.".getBytes();
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 113:
			case 2428:
			case 2430:
			case 2432:
			case 2434:
			case 2436:
			case 2438:
			case 2440:
			case 2442:
			case 2444:
			case 2446:
			case 2448:
			case 2450:
			case 2452:
			case 3008:
			case 3016:
			case 3024:
			case 3032:
			case 3040:
			case 3408:
			case 3422:
			case 3430:
			case 4842:
			case 5943:
			case 5952:
			case 6470:
			case 6685:
			case 7660:
			case 9739:
			case 9998:
			case 10925:
			case 12140:
			case 14838:
			case 14846:
			case 15300:
			case 15304:
			case 15308:
			case 15312:
			case 15316:
			case 15320:
			case 15328:

			case 21630:
				// potion (4) doses
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = -5;
				itemDef.rotationY = 84;
				itemDef.rotationX = 1996;
				itemDef.modelZoom = 550;
				break;

			case 12333:
				itemDef.copyItem(21814);
				itemDef.name = "Dungeoneering token";
				itemDef.stackable = true;
				break;

		}
		setCustomItemDefData(customId, itemDef);
		if (itemDef.certTemplateID != -1) {
			itemDef.toNote();
		}

		if (itemDef.lendTemplateID != -1) {
			itemDef.toLend();
		}

		if (!isMembers && itemDef.membersObject) {
			itemDef.name = "Members Object";
			itemDef.description = "Login to a members' server to use this object.".getBytes();
			itemDef.groundActions = null;
			itemDef.actions = null;
			itemDef.team = 0;
		}

		switch (itemDef.id) {

			case 20147:
				itemDef.oldColors = new int[2];
				itemDef.newColors = new int[2];
				itemDef.oldColors[0] = 4550;
				itemDef.newColors[0] = 1;
				itemDef.oldColors[1] = 4540;
				itemDef.newColors[1] = 1;
				break;
		}
		ItemDef2.newIDS(itemDef, id);
		map.put(id, itemDef);
		return itemDef; //
		//	return ItemDef3.newIDS1(itemDef, id);

	}

	private static void setCustomItemDefData(int customId, ItemDefinition itemDef) {

		if (customId == 13655) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.name = "Dragon kiteshield";
			itemDef.description = "A rare, protective kiteshield.".getBytes();
			itemDef.modelZoom = 1560;
			itemDef.rotationY = 344;
			itemDef.rotationX = 1104;
			itemDef.rotationZ = 0;
			itemDef.modelOffsetX = -6;
			itemDef.modelOffsetY = -14;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.maleDialogue = -1;
			itemDef.femaleDialogue = -1;
		}

		if (customId == 13997) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 13995;
			itemDef.maleEquip1 = 13994;// anInt165
			itemDef.femaleEquip1 = 13994;// anInt200
			itemDef.modelZoom = 720;
			itemDef.rotationY = 396;
			itemDef.rotationX = 336;
			itemDef.modelOffsetX = 8;
			itemDef.modelOffsetY = 11;
			itemDef.name = "Death-touched Darts";
			itemDef.description = "Use these powerful darts to instantly slay any monster.".getBytes();
		}
		if (customId == 13999) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 13998;
			itemDef.maleEquip1 = 13999;// anInt165
			itemDef.femaleEquip1 = 13999;// anInt200
			itemDef.modelZoom = 789;
			itemDef.rotationY = 240;
			itemDef.rotationX = 60;
			itemDef.modelOffsetX = -1;
			itemDef.modelOffsetY = -23;
			itemDef.name = "Hydra claws";
			itemDef.description = "Viscosity has shaped them.".getBytes();
		}
		if (customId == 20051) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Open";
			itemDef.modelID = 61044;
			itemDef.modelZoom = 2300;
			itemDef.rotationY = 126;
			itemDef.rotationX = 1826;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 0;
			itemDef.name = "Archery kit";
		}
		if (customId == 22010) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 65527;// 65526;
			itemDef.maleEquip1 = 65527;// anInt165
			itemDef.femaleEquip1 = 65527;// anInt200
			itemDef.modelZoom = 2000;
			itemDef.rotationY = 240;
			itemDef.rotationX = 60;
			itemDef.modelOffsetX = -1;
			itemDef.modelOffsetY = -23;
			itemDef.name = "Ginrei Kojaku";
			itemDef.description = "Naruto is sooo overrated.".getBytes();
		}
		if (customId == 22011) {
			itemDef.name = "Ginrei Kojaku"; // Name
			itemDef.actions = new String[]{null, null, null, null, null};
			itemDef.certID = 22010;
			itemDef.certTemplateID = 799;
			itemDef.rotationY = 552;
			itemDef.rotationX = 28;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 2;
			itemDef.modelID = 2429;
		}
		if (customId == 22012) {
			itemDef.modelID = 6277;
			itemDef.name = "Crimson's Katana"; // Name
			itemDef.modelZoom = 2025;
			itemDef.rotationY = 593;
			itemDef.rotationX = 2040;
			itemDef.modelOffsetX = 5;
			itemDef.modelOffsetY = 1;
			itemDef.value = 50000;
			itemDef.membersObject = true;
			itemDef.maleEquip1 = 5324;
			itemDef.femaleEquip1 = 5324;
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
			itemDef.rdc2 = 25363;
		}

		if (customId == 20080) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 65524;
			itemDef.maleEquip1 = 65522;// anInt165
			itemDef.anInt188 = 65523;
			itemDef.femaleEquip1 = 65522;// anInt200
			itemDef.modelZoom = 1506;
			itemDef.rotationY = 473;
			itemDef.rotationX = 2042;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 0;
			itemDef.name = "Metallica Shirt";
			itemDef.description = "Metallica.".getBytes();
		}
		if (customId == 20079) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 65520;
			itemDef.maleEquip1 = 65519;// anInt165
			itemDef.femaleEquip1 = 65519;// anInt200
			itemDef.modelZoom = 2128;
			itemDef.rotationY = 504;
			itemDef.rotationX = 0;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 1;
			itemDef.name = "Member Cape";
			itemDef.description = "It's a nice cape..".getBytes();
		}
		if (customId == 20081) {
			itemDef.modelID = 65270;
			itemDef.name = "200m Cape";
			itemDef.description = "We'd pat you on the back, but this cape would get in the way.".getBytes();
			itemDef.modelZoom = 1385;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 24;
			itemDef.rotationY = 279;
			itemDef.rotationX = 948;
			itemDef.oldColors = new int[]{65214, 65200, 65186, 62995, 64639};
			itemDef.newColors = new int[]{1, 6, 1, 5759, 5706};
			itemDef.maleEquip1 = 65297;
			itemDef.femaleEquip1 = 65297;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
		}
		if (customId == 22012) {
			itemDef.modelID = 6277;
			itemDef.name = "Crimson's Katana"; // Name
			itemDef.modelZoom = 2025;
			itemDef.rotationY = 593;
			itemDef.rotationX = 2040;
			itemDef.modelOffsetX = 5;
			itemDef.modelOffsetY = 1;
			itemDef.value = 50000;
			itemDef.membersObject = true;
			itemDef.maleEquip1 = 5324;
			itemDef.femaleEquip1 = 5324;
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
			itemDef.rdc2 = 25363;
		}
		if (customId == 22035) {
			itemDef.name = "Armadyl Crossbow"; // Name
			itemDef.actions = new String[]{null, null, null, null, null};
			itemDef.certID = 22034;
			itemDef.certTemplateID = 799;
			itemDef.stackable = true;
		}
		if (customId == 22042) {
			itemDef.name = "Black h'ween mask"; // Name
			itemDef.actions = new String[]{null, null, null, null, null};
			itemDef.certID = 22041;
			itemDef.certTemplateID = 799;
			itemDef.stackable = true;
		}
		if (customId == 22046) {
			itemDef.name = "Dragonstone ring (e)"; // Name
			itemDef.actions = new String[]{null, null, null, null, null};
			itemDef.certID = 22045;
			itemDef.certTemplateID = 799;
			itemDef.stackable = true;
		}
		if (customId == 22048) {
			itemDef.name = "Giant snake spine"; // Name
			itemDef.actions = new String[]{null, null, null, null, null};
			itemDef.certID = 22047;
			itemDef.certTemplateID = 799;
			itemDef.stackable = true;
		}
		if (customId == 22065) { // maled
			itemDef.name = "Malediction ward";
			itemDef.actions = new String[]{null, null, null, null, null};
			itemDef.certID = 22064;
			itemDef.certTemplateID = 799;
			itemDef.stackable = true;
		}

		if (customId == 22067) { // odium
			itemDef.actions = new String[]{null, null, null, null, null};
			itemDef.certID = 22066;
			itemDef.certTemplateID = 799;
			itemDef.stackable = true;
		}
		if (customId == 22070) { // sword
			itemDef.name = "Shadowspike long";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65000;
			itemDef.femaleEquip1 = 65001;
			itemDef.maleEquip1 = 65001;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
		}
		if (customId == 22071) { // sword
			itemDef.name = "Sunrise sword";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65003;
			itemDef.femaleEquip1 = 65002;
			itemDef.maleEquip1 = 65002;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
		}
		if (customId == 22072) { // sword
			itemDef.name = "Death's sword";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65004;
			itemDef.femaleEquip1 = 65005;
			itemDef.maleEquip1 = 65005;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
		}
		if (customId == 22073) { // sword
			itemDef.name = "Forgiveness blade";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65006;
			itemDef.femaleEquip1 = 65007;
			itemDef.maleEquip1 = 65007;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
			//itemDef.rdc2 = 981231;
		}
		if (customId == 20542) { // sword
			itemDef.name = "Satanic hellblade";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65006;
			itemDef.femaleEquip1 = 65007;
			itemDef.maleEquip1 = 65007;
			itemDef.modelOffsetX = -70;
			itemDef.rotationZ = 300;
			itemDef.modelOffsetY = 30;
			itemDef.modelZoom = 4000;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			
			itemDef.stackable = false;
			itemDef.rdc2 = 14432;
		}
		if (customId == 22074) { // sword
			itemDef.name = "Floreox scimitar";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65008;
			itemDef.femaleEquip1 = 65009;
			itemDef.maleEquip1 = 65009;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
			itemDef.rdc2 = 78525;
			

		}
		if (customId == 22075) { // sword
			itemDef.name = "Starlight sword";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65010;
			itemDef.femaleEquip1 = 65011;
			itemDef.maleEquip1 = 65011;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
		}
		if (customId == 22076) { // sword
			itemDef.name = "Starbright long";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65010;
			itemDef.femaleEquip1 = 65011;
			itemDef.maleEquip1 = 65011;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
			itemDef.rdc2 = 11020;
		}
		if (customId == 20533) { // sword
			itemDef.name = "Ryan's sycthe";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65189;
			itemDef.femaleEquip1 = 65190;
			itemDef.maleEquip1 = 65190;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;

		}
		if (customId == 7643) { // sword
			itemDef.name = "Ryan's sycthe";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65189;
			itemDef.femaleEquip1 = 65190;
			itemDef.maleEquip1 = 65190;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;

		}
		if (customId == 7642) { // sword
			itemDef.name = "Ryan's sycthe";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65189;
			itemDef.femaleEquip1 = 65190;
			itemDef.maleEquip1 = 65190;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;

		}
		if (customId == 22077) { // whip
			itemDef.name = "Brutal Tentacle";
			ItemDefinition itemDef2 = ItemDefinition.get(4151);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65012;
			itemDef.femaleEquip1 = 65013;
			itemDef.maleEquip1 = 65013;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
			itemDef.rdc2 = 97431;

			itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};

		}
		if (customId == 22078) { // weapon
			itemDef.name = "Deadly maul";
			ItemDefinition itemDef2 = ItemDefinition.get(18353);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 95001;
			itemDef.femaleEquip1 = 95000;
			itemDef.maleEquip1 = 95000;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = 2200;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = 1000;
			itemDef.stackable = false;
			

		}
		if (customId == 12284) { // Darkcrab
			itemDef.name = "Scythe of hercules";
			ItemDefinition itemDef2 = ItemDefinition.get(1333);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65320;
			itemDef.femaleEquip1 = 65321;
			itemDef.maleEquip1 = 65321;
			itemDef.actions = itemDef2.actions;

			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = 400;
			itemDef.modelOffsetY = 1;
			itemDef.modelZoom = 3000;
			itemDef.rotationY = 600;
			itemDef.rotationX = 400;
			itemDef.stackable = false;

			
		}
		

		if (customId == 20553) {
			itemDef.actions = new String[5];
			itemDef.modelID = 19219;
			itemDef.name = "Starter blowpipe";
			itemDef.modelZoom = 1158;
			itemDef.rotationX = 189;//189
			itemDef.rotationY = 768;//768
			itemDef.modelOffsetX = -7;
			itemDef.modelOffsetY = 4;
			itemDef.value = 20000000;
			itemDef.maleEquip1 = 14403;
			itemDef.femaleEquip1 = 14403;
			itemDef.actions[1] = "Wield";
			// itemDef.actions[2] = "Uncharge";
			//	itemDef.actions[3] = "Uncharge";
			itemDef.groundActions = new String[]{null, null, "Take", null, null};
			itemDef.rdc2 = 78787997;//23622
		}
		if (customId == 20554) { // Darkcrab
			itemDef.name = "Viggora's chainmace";
			ItemDefinition itemDef2 = ItemDefinition.get(4755);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65322;
			itemDef.femaleEquip1 = 65323;
			itemDef.maleEquip1 = 65323;
			itemDef.actions = itemDef2.actions;

			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
			itemDef.actions[3] = "<col=C3C0B2>Dissolve";
		}
		if (customId == 20555) { // Darkcrab
			itemDef.name = "Scythe of vitur";
			ItemDefinition itemDef2 = ItemDefinition.get(1333);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65320;
			itemDef.femaleEquip1 = 65321;
			itemDef.maleEquip1 = 65321;
			itemDef.actions = itemDef2.actions;

			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
			

			//itemDef.rdc2 = 272356;
		}
		if (customId == 12285) { // Darkcrab
			itemDef.name = "Viggora's chainmace";
			ItemDefinition itemDef2 = ItemDefinition.get(4755);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65322;
			itemDef.femaleEquip1 = 65323;
			itemDef.maleEquip1 = 65323;
			itemDef.actions = itemDef2.actions;

			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
		}
		if (customId == 12283) { //
			itemDef.name = "Twisted Bow";
			ItemDefinition itemDef2 = ItemDefinition.get(1235);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65324;
			itemDef.femaleEquip1 = 65325;
			itemDef.maleEquip1 = 65325;
			itemDef.actions = itemDef2.actions;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
		}
		if (customId == 19843) { // weapon
			itemDef.newColors = new int[2]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
			itemDef.oldColors = new int[2]; // same here
			itemDef.oldColors[0] = 40; // the texture that it currently has
			itemDef.newColors[0] = 64; // the new texture u want it to have

			itemDef.oldColors[1] = 24; // the texture that it currently has
			itemDef.newColors[1] = 41; // the new texture u want it to have
			itemDef.name = "Archie minigun";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			itemDef.modelID = 65210;
			itemDef.femaleEquip1 = 65211;
			itemDef.maleEquip1 = 65211;// 95099
			itemDef.actions = new String[]{null, "Wield", null, null, "Destroy"};
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			
			itemDef.stackable = false;
		}
		if (customId == 19137) { // weapon
			itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
			itemDef.oldColors = new int[1]; // same here
			itemDef.oldColors[0] = 40; // the texture that it currently has
			itemDef.newColors[0] = 60; // the new texture u want it to have
			itemDef.name = "Iron minigun";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			itemDef.modelID = 65210;
			itemDef.femaleEquip1 = 65211;
			itemDef.maleEquip1 = 65211;// 95099
			itemDef.actions = new String[]{null, "Wield", null, null, "Destroy"};
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
		}
		if (customId == 19135) {
			itemDef.oldColors = new int[]{40, 24};
			itemDef.newColors = new int[]{66, 66};
			// itemDef.originalModelColors = new int[1]; // if only 1 texture is modified
			// this has to be 1, if 2 then 2 etc
			// itemDef.modifiedModelColors = new int[1]; // same here
			// itemDef.modifiedModelColors[0] = 40; // the texture that it currently has
			// itemDef.originalModelColors[0] = 66; // the new texture u want it to have
			itemDef.name = "Mithril minigun";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			itemDef.modelID = 65210;
			itemDef.femaleEquip1 = 65211;
			itemDef.maleEquip1 = 65211;// 95099
			itemDef.actions = new String[]{null, "Wield", null, null, "Destroy"};
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
			
		}
		if (customId == 19136) { // weapon
			itemDef.name = "Brutal minigun";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			itemDef.modelID = 15713;
			itemDef.femaleEquip1 = 15714;
			itemDef.maleEquip1 = 15714;// 95099
			itemDef.actions = new String[]{null, "Wield", null, null, "Destroy"};
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = 2000;
			itemDef.rotationY = 300;
			itemDef.rotationX = 170;
			itemDef.stackable = false;
		}
		if (customId == 20538) { // weapon
			itemDef.rotationX = 1570;
			itemDef.modelZoom = 2000;
		}
		
		if (customId == 22079) { // weapon
			itemDef.name = "Ankoue maul";
			ItemDefinition itemDef2 = ItemDefinition.get(18353);
			itemDef.modelID = 65014;
			itemDef.femaleEquip1 = 65015;
			itemDef.maleEquip1 = 65015;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = 2200;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = 1000;
			itemDef.stackable = false;
			itemDef.rdc2 = 983777;
		}
		if (customId == 22080) { // weapon
			itemDef.name = "Heavy chainsaw";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65016;
			itemDef.femaleEquip1 = 65017;
			itemDef.maleEquip1 = 65017;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = 0;
			itemDef.modelZoom = 1450;
			itemDef.stackable = false;
			itemDef.actions[3] = "<col=C3C0B2>Dissolve";

		}
		if (customId == 22081) { // weapon
			itemDef.name = "Wooden chainsaw";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65016;
			itemDef.femaleEquip1 = 65017;
			itemDef.maleEquip1 = 65017;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
			itemDef.rdc2 = 2364622;
		}
		if (customId == 22082) { // weapon
			itemDef.name = "dildo";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65018;
			itemDef.femaleEquip1 = 65019;
			itemDef.maleEquip1 = 65019;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
			// itemDef.rdc2 = 2364622;
		}
		if (customId == 22083) { // weapon
			itemDef.name = "BlastBomb bow";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
			itemDef.modelID = 100110;
			itemDef.femaleEquip1 = 100111;
			itemDef.maleEquip1 = 100111;
			itemDef.modelOffsetX = 0;
			itemDef.rotationZ = 1104;
			itemDef.modelOffsetY = -15;
			itemDef.modelZoom = 1800;
			itemDef.rotationY = 1678;
			itemDef.rotationX = 2043;
			itemDef.oldColors = new int[]{55};
			itemDef.newColors = new int[]{68};
			itemDef.stackable = false;
			// itemDef.rdc2 = 34343;
		}
		if (customId == 22084) { // weapon
			itemDef.name = "Trinity Hammers";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			itemDef.modelID = 100103;
			itemDef.femaleEquip1 = 100104;
			itemDef.maleEquip1 = 100104;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 0;
			itemDef.modelZoom = 1500;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = 1200;
			itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
			itemDef.stackable = false;
			itemDef.oldColors = new int[]{52};
			itemDef.newColors = new int[]{52};
			// itemDef.rdc2 = 34333;
		}
		if (customId == 22085) { // weapon
			itemDef.name = "Karos Scimitar";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65430;
			itemDef.femaleEquip1 = 65431;
			itemDef.maleEquip1 = 65431;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
			//	itemDef.rdc2 = 333333;
		}
		if (customId == 22086) { // weapon
			itemDef.name = "Karos offhand";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65430;
			itemDef.femaleEquip1 = 65432;
			itemDef.maleEquip1 = 65432;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;

		}
		if (customId == 22087) { // gun
			itemDef.name = "Burning Staff";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65020;
			itemDef.femaleEquip1 = 65021;
			itemDef.maleEquip1 = 65021;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
		}
		if (customId == 22088) { // gun
			itemDef.name = "AK-47";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65022;
			itemDef.femaleEquip1 = 65023;
			itemDef.maleEquip1 = 65023;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
		}
		if (customId == 22089) { // gun
			itemDef.name = "Assault Rifle";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65024;
			itemDef.femaleEquip1 = 65025;
			itemDef.maleEquip1 = 65025;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
		}
		if (customId == 22090) { // gun
			itemDef.name = "Golden Rifle";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65024;
			itemDef.femaleEquip1 = 65025;
			itemDef.maleEquip1 = 65025;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
			itemDef.rdc2 = 99824;
		}
		if (customId == 22091) { // staff
			itemDef.name = "Legion scythe";
			ItemDefinition itemDef2 = ItemDefinition.get(15486);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65026;
			itemDef.femaleEquip1 = 65027;
			itemDef.maleEquip1 = 65027;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
			itemDef.rdc2 = 235267;
		}
		if (customId == 22092) { // staff
			itemDef.name = "Art's Staff";
			ItemDefinition itemDef2 = ItemDefinition.get(16137);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 100095;
			itemDef.femaleEquip1 = 100096;
			itemDef.maleEquip1 = 100096;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
			itemDef.oldColors = new int[]{52};
			itemDef.newColors = new int[]{79};
			itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};	
			//itemDef.rdc2 = 46880;
		}
		if (customId == 12933) { // staff
			itemDef.name = "Tanker shield";
			itemDef.rdc2 = 46880;
			itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
		}
		if (customId == 15031) { // staff
			itemDef.name = "Tanker boots";
			itemDef.rdc2 = 46880;
			itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
		}
		if (customId == 22093) { // sword
			itemDef.name = "Darklight long";
			ItemDefinition itemDef2 = ItemDefinition.get(20538);
			// itemDef.modelID = itemDef2.modelID;
			itemDef.modelID = 65010;
			itemDef.femaleEquip1 = 65011;
			itemDef.maleEquip1 = 65011;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.rotationZ = itemDef2.rotationZ;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.rotationY = itemDef2.rotationY;
			itemDef.rotationX = itemDef2.rotationX;
			itemDef.stackable = false;
			itemDef.rdc2 = 3929;
		}
	}


	public static Sprite getSprite(int i, int j, int k) {
		if (k == 0) {
			Sprite sprite = (Sprite) mruNodes1.insertFromCache(i);

			if (sprite != null && sprite.maxHeight != j && sprite.maxHeight != -1) {
				sprite.unlink();
				sprite = null;
			}

			if (sprite != null) {
				return sprite;
			}
		}

		if (i > ItemDefinition.totalItems) {
			return null;
		}
		ItemDefinition definition = get(i);

		if (definition.stackIDs == null) {
			j = -1;
		}

		if (j > 1) {
			int i1 = -1;

			for (int j1 = 0; j1 < 10; j1++) {
				if (j >= definition.stackAmounts[j1] && definition.stackAmounts[j1] != 0) {
					i1 = definition.stackIDs[j1];
				}
			}

			if (i1 != -1) {
				definition = get(i1);
			}
		}

		Model model = definition.getInventoryModel(1);

		if (model == null) {
			return null;
		}

		Sprite sprite = null;

		if (definition.certTemplateID != -1) {
			sprite = getSprite(definition.certID, 10, -1);

			if (sprite == null) {
				return null;
			}
		}

		if (definition.lendTemplateID != -1) {
			sprite = getSprite(definition.lendID, 50, 0);

			if (sprite == null) {
				return null;
			}
		}

		Sprite sprite2 = new Sprite(32, 32);
		int k1 = Rasterizer.centerX;
		int l1 = Rasterizer.centerY;
		int ai[] = Rasterizer.lineOffsets;
		int ai1[] = DrawingArea.raster;
		float depthBuffer[] = DrawingArea.depthBuffer;
		int i2 = DrawingArea.width;
		int j2 = DrawingArea.height;
		int k2 = DrawingArea.topX;
		int l2 = DrawingArea.bottomX;
		int i3 = DrawingArea.topY;
		int j3 = DrawingArea.clipBottom;
		Rasterizer.notTextured = false;
		DrawingArea.initDrawingArea(32, 32, sprite2.myPixels, depthBuffer);
		DrawingArea.drawPixels(32, 0, 0, 0, 32);
		Rasterizer.clearDepthBuffer();
		Rasterizer.method364();
		int k3 = definition.modelZoom;

		if (k == -1) {
			k3 = (int) (k3 * 1.5D);
		}

		if (k > 0) {
			k3 = (int) (k3 * 1.04D);
		}

		int l3 = Rasterizer.SINE[definition.rotationY] * k3 >> 16;
		int i4 = Rasterizer.COSINE[definition.rotationY] * k3 >> 16;
		model.renderSingle(definition.rotationX, definition.rotationZ, definition.rotationY, definition.modelOffsetX, l3 + model.modelHeight / 2 + definition.modelOffsetY, i4 + definition.modelOffsetY);

		sprite2.outline(1);
		if (k > 0) {
			sprite2.outline(16777215);
		}
		if (k == 0) {
			sprite2.shadow(3153952);
		}
		DrawingArea.initDrawingArea(32, 32, sprite2.myPixels, depthBuffer);

		if (definition.certTemplateID != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = 32;
			sprite.maxHeight = 32;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}

		if (definition.lendTemplateID != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = 32;
			sprite.maxHeight = 32;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}

		/*
		 * if (k == 0) { mruNodes1.removeFromCache(sprite2, i); }
		 */
		// Client.instance.method37(i, -1);
		if (k == 0 && !definition.animateInventory) {
			mruNodes1.removeFromCache(sprite2, (long) i);
		}
		DrawingArea.initDrawingArea(j2, i2, ai1, depthBuffer);
		DrawingArea.setBounds(k2, i3, l2, j3);
		Rasterizer.centerX = k1;
		Rasterizer.centerY = l1;
		Rasterizer.lineOffsets = ai;
		Rasterizer.notTextured = true;

		if (definition.stackable) {
			sprite2.maxWidth = 33;
		} else {
			sprite2.maxWidth = 32;
		}

		sprite2.maxHeight = j;
		return sprite2;
	}

	public static Sprite getSizedSprite(int i, int j, int k, int width, int height) {
		if (k == 0) {
			Sprite sprite = (Sprite) mruNodes1.insertFromCache(i);

			if (sprite != null && sprite.maxHeight != j && sprite.maxHeight != -1) {
				sprite.unlink();
				sprite = null;
			}

			if (sprite != null) {
				return sprite;
			}
		}

		if (i > ItemDefinition.totalItems) {
			return null;
		}
		ItemDefinition definition = get(i);

		if (definition.stackIDs == null) {
			j = -1;
		}

		if (j > 1) {
			int i1 = -1;

			for (int j1 = 0; j1 < 10; j1++) {
				if (j >= definition.stackAmounts[j1] && definition.stackAmounts[j1] != 0) {
					i1 = definition.stackIDs[j1];
				}
			}

			if (i1 != -1) {
				definition = get(i1);
			}
		}

		Model model = definition.getInventoryModel(1);

		if (model == null) {
			return null;
		}

		Sprite sprite = null;

		if (definition.certTemplateID != -1) {
			sprite = getSprite(definition.certID, 10, -1);

			if (sprite == null) {
				return null;
			}
		}

		if (definition.lendTemplateID != -1) {
			sprite = getSprite(definition.lendID, 50, 0);

			if (sprite == null) {
				return null;
			}
		}

		Sprite sprite2 = new Sprite(width, height);
		int k1 = Rasterizer.centerX;
		int l1 = Rasterizer.centerY;
		int ai[] = Rasterizer.lineOffsets;
		int ai1[] = DrawingArea.raster;
		float depthBuffer[] = DrawingArea.depthBuffer;
		int i2 = DrawingArea.width;
		int j2 = DrawingArea.height;
		int k2 = DrawingArea.topX;
		int l2 = DrawingArea.bottomX;
		int i3 = DrawingArea.topY;
		int j3 = DrawingArea.clipBottom;
		Rasterizer.notTextured = false;
		DrawingArea.initDrawingArea(height, width, sprite2.myPixels, depthBuffer);
		DrawingArea.drawPixels(height, 0, 0, 0, width);
		Rasterizer.clearDepthBuffer();
		Rasterizer.method364();
		int k3 = definition.modelZoom;

		if (k == -1) {
			k3 = (int) (k3 * 1.5D);
		}

		if (k > 0) {
			k3 = (int) (k3 * 1.04D);
		}

		k3 /= (width / 32D);

		int l3 = Rasterizer.SINE[definition.rotationY] * k3 >> 16;
		int i4 = Rasterizer.COSINE[definition.rotationY] * k3 >> 16;
		model.renderSingle(definition.rotationX, definition.rotationZ, definition.rotationY, definition.modelOffsetX, l3 + model.modelHeight / 2 + definition.modelOffsetY, i4 + definition.modelOffsetY);

		sprite2.outline(1);
		if (k > 0) {
			sprite2.outline(16777215);
		}
		if (k == 0) {
			sprite2.shadow(3153952);
		}
		DrawingArea.initDrawingArea(height, width, sprite2.myPixels, depthBuffer);

		if (definition.certTemplateID != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = width;
			sprite.maxHeight = height;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}

		if (definition.lendTemplateID != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = width;
			sprite.maxHeight = height;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}

		/*
		 * if (k == 0) { mruNodes1.removeFromCache(sprite2, i); }
		 */
		// Client.instance.method37(i, -1);
		if (k == 0 && !definition.animateInventory) {
			mruNodes1.removeFromCache(sprite2, (long) i);
		}
		DrawingArea.initDrawingArea(j2, i2, ai1, depthBuffer);//here 
		DrawingArea.setBounds(k2, i3, l2, j3);
		Rasterizer.centerX = k1;
		Rasterizer.centerY = l1;
		Rasterizer.lineOffsets = ai;
		Rasterizer.notTextured = true;

		if (definition.stackable) {
			sprite2.maxWidth = width;
		} else {
			sprite2.maxWidth = width;
		}

		sprite2.maxHeight = j;
		return sprite2;
	}

	public static HashMap<Integer, Sprite> spriteCacheEffectTimers = new HashMap<>();

	public static Sprite getSprite(int i, int j, int k, double zoom, boolean effectTimers) {
		if (k == 0 && zoom != -1) {
			Sprite sprite = (Sprite) mruNodes1.insertFromCache(i);

			if (effectTimers) {
				sprite = spriteCacheEffectTimers.get(i);
			}

			if (sprite != null && sprite.maxHeight != j && sprite.maxHeight != -1) {
				sprite.unlink();
				sprite = null;
			}

			if (sprite != null) {
				return sprite;
			}
		}

		ItemDefinition definition = get(i);

		if (definition.stackIDs == null) {
			j = -1;
		}

		if (j > 1) {
			int i1 = -1;

			for (int j1 = 0; j1 < 10; j1++) {
				if (j >= definition.stackAmounts[j1] && definition.stackAmounts[j1] != 0) {
					i1 = definition.stackIDs[j1];
				}
			}

			if (i1 != -1) {
				definition = get(i1);
			}
		}

		Model model = definition.getInventoryModel(1);

		if (model == null) {
			return null;
		}

		Sprite sprite = null;

		if (definition.certTemplateID != -1) {
			sprite = getSprite(definition.certID, 10, -1);

			if (sprite == null) {
				return null;
			}
		}

		if (definition.lendTemplateID != -1) {
			sprite = getSprite(definition.lendID, 50, 0);

			if (sprite == null) {
				return null;
			}
		}

		Sprite sprite2 = new Sprite(32, 32);
		int k1 = Rasterizer.centerX;
		int l1 = Rasterizer.centerY;
		int ai[] = Rasterizer.lineOffsets;
		int ai1[] = DrawingArea.raster;
		float depthBuffer[] = DrawingArea.depthBuffer;
		int i2 = DrawingArea.width;
		int j2 = DrawingArea.height;
		int k2 = DrawingArea.topX;
		int l2 = DrawingArea.bottomX;
		int i3 = DrawingArea.topY;
		int j3 = DrawingArea.clipBottom;
		Rasterizer.notTextured = false;
		DrawingArea.initDrawingArea(32, 32, sprite2.myPixels, depthBuffer);
		DrawingArea.drawPixels(32, 0, 0, 0, 32);
		Rasterizer.clearDepthBuffer();
		Rasterizer.method364();
		int k3 = definition.modelZoom;
		if (zoom != -1 && zoom != 0) {
			k3 = (int) ((double) (k3 * zoom));
		}
		if (k == -1) {
			k3 = (int) (k3 * 1.5D);
		}

		if (k > 0) {
			k3 = (int) (k3 * 1.04D);
		}

		int l3 = Rasterizer.SINE[definition.rotationY] * k3 >> 16;
		int i4 = Rasterizer.COSINE[definition.rotationY] * k3 >> 16;
		model.renderSingle(definition.rotationX, definition.rotationZ, definition.rotationY, definition.modelOffsetX, l3 + model.modelHeight / 2 + definition.modelOffsetY, i4 + definition.modelOffsetY);

		sprite2.outline(1);
		if (k > 0) {
			sprite2.outline(16777215);
		}
		if (k == 0) {
			sprite2.shadow(3153952);
		}
		DrawingArea.initDrawingArea(32, 32, sprite2.myPixels, depthBuffer);

		if (definition.certTemplateID != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = 32;
			sprite.maxHeight = 32;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}

		if (definition.lendTemplateID != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = 32;
			sprite.maxHeight = 32;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}

		/*
		 * if (k == 0) { mruNodes1.removeFromCache(sprite2, i); }
		 */
/*
        if (k == 0 && !definition.animateInventory) {
            mruNodes1.removeFromCache(sprite2, (long) i);
        }*/

		// Client.instance.method37(i, -1);

		if (k == 0 && i != 5572 && i != 5573 && i != 640 && i != 650 && i != 630 && !definition.animateInventory) {
			if (effectTimers) {
				spriteCacheEffectTimers.put(i, sprite2);
			} else {
				mruNodes1.removeFromCache(sprite2, (long) i);
			}
		}
		DrawingArea.initDrawingArea(j2, i2, ai1, depthBuffer);
		DrawingArea.setBounds(k2, i3, l2, j3);
		Rasterizer.centerX = k1;
		Rasterizer.centerY = l1;
		Rasterizer.lineOffsets = ai;
		Rasterizer.notTextured = true;

		if (definition.stackable) {
			sprite2.maxWidth = 33;
		} else {
			sprite2.maxWidth = 32;
		}

		sprite2.maxHeight = j;
		return sprite2;
	}

	public static void nullify() {
		mruNodes2 = null;
		mruNodes1 = null;
		streamIndices = null;
		map.clear();
		map = null;
		buffer = null;
		spriteCacheEffectTimers = null;

	}

	public static void unpackConfig(Archive streamLoader) {
		buffer = new ByteBuffer(streamLoader.get("obj.dat"));
		ByteBuffer stream = new ByteBuffer(streamLoader.get("obj.idx"));
		totalItems = stream.getUnsignedShort() + 10000;
		streamIndices = new int[totalItems];
		int i = 2;

		for (int j = 0; j < totalItems; j++) {
			streamIndices[j] = i;
			i += stream.getUnsignedShort();
			//dump();
		}
	}

	public String[] actions;
	public String[] equipOptions;
	private int anInt162;
	int anInt164;
	public int maleEquip1;
	private int anInt166;
	public int scaleX;
	private int anInt173;
	private int maleDialogue;
	private int anInt184;
	private int anInt185;
	int anInt188; // male arms
	public int scaleZ;
	public int scaleY;
	private int anInt196;
	private int femaleDialogue;
	public int femaleEquip1;
	public int rotationZ;
	public int certID;
	public int certTemplateID;
	public byte[] description;
	public byte femaleWieldX;
	public byte femaleWieldY;
	public byte femaleWieldZ;
	public String[] groundActions;
	public int id;
	public int lendID;
	private int lendTemplateID;
	public byte maleWieldX;
	public byte maleWieldY;
	public byte maleWieldZ;
	public boolean membersObject;
	public int modelID;
	public int modelOffsetX;
	public int modelOffsetY;
	public int rotationY;
	public int rotationX;
	public int modelZoom;
	public int[] oldColors;
	public String name;
	public int[] newColors;
	public boolean stackable;
	public int[] stackAmounts;
	public int[] stackIDs;
	public int team;
	public int value;
	public byte[] customSpriteLocation;

	public ItemDefinition() {
		id = -1;
	}

	public void copyItem(int id) {
		this.setDefaults();
		ItemDefinition target = ItemDefinition.get(id);
		this.modelID = target.modelID;
		this.maleEquip1 = target.maleEquip1;
		this.femaleEquip1 = target.femaleEquip1;
		this.modelZoom = target.modelZoom;
		this.rotationY = target.rotationY;
		this.rotationX = target.rotationX;
		this.modelOffsetX = target.modelOffsetX;
		this.rotationZ = target.rotationZ;
		this.modelOffsetY = target.modelOffsetY;
		this.actions = target.actions;
		this.maleDialogue = target.maleDialogue;
		this.stackable = target.stackable;
		this.scaleX = target.scaleX;
		this.scaleY = target.scaleY;
		this.scaleZ = target.scaleZ;
	}

	public Model getInventoryModel(int amount) {
		if (stackIDs != null && amount > 1) {
			int id = -1;

			for (int i = 0; i < 10; i++) {
				if (amount >= stackAmounts[i] && stackAmounts[i] != 0) {
					id = stackIDs[i];
				}
			}

			if (id != -1) {
				return get(id).getInventoryModel(1);
			}
		}

		Model model = (Model) mruNodes2.insertFromCache(id);

		if (model != null) {
			return model;
		}

		model = Model.get(modelID);

		if (model == null) {
			return null;
		}

		if (scaleX != 128 || scaleY != 128 || scaleZ != 128) {
			model.scaleT(scaleX, scaleZ, scaleY);
		}

		if (oldColors != null) {
			for (int l = 0; l < oldColors.length; l++) {
				model.method476(oldColors[l], newColors[l]);
			}
		}

		if (rdc > 0) {
			model.method1337(rdc);
		}
		if (rdc2 != 0) {
			model.method1338(rdc2);
		}
		if (rdc3 != 0) {
			model.method1339(rdc3);
		}

		if (colorChange != null)
			Objects.requireNonNull(model).tint(colorChange);

		applyTexturing(model, id);
		model.light(64 + anInt196, 768 + anInt184, -50, -10, -50, true);
		model.aBoolean1659 = true;
		mruNodes2.removeFromCache(model, id);
		return model;
	}

	public boolean dialogueModelFetched(int j) {
		int k = maleDialogue;
		int l = anInt166;

		if (j == 1) {
			k = femaleDialogue;
			l = anInt173;
		}

		if (k == -1) {
			return true;
		}

		boolean flag = true;

		if (!Model.method463(k)) {
			flag = false;
		}

		if (l != -1 && !Model.method463(l)) {
			flag = false;
		}

		return flag;
	}
	public static Sprite getLargeSprite(int itemId) {
		ItemDefinition itemDef = get(itemId);
		Model model = itemDef.getInventoryModel(1);
		if (model == null) {
			return null;
		}

		Sprite enabledSprite = new Sprite(150, 150);
		int k1 = Rasterizer.centerX;
		int l1 = Rasterizer.centerY;
		int ai[] = Rasterizer.lineOffsets;
		int ai1[] = DrawingArea.raster;
		float depthBuffer[] = DrawingArea.depthBuffer;
		int i2 = DrawingArea.width;
		int j2 = DrawingArea.height;
		int k2 = DrawingArea.topX;
		int l2 = DrawingArea.bottomX;
		int i3 = DrawingArea.topY;
		int j3 = DrawingArea.clipBottom;
		Rasterizer.notTextured = false;
		DrawingArea.initDrawingArea(150, 150, enabledSprite.myPixels, new float[1024]);
		DrawingArea.drawPixels(150, 0, 0, 0, 150);
		Rasterizer.method364();
		int k3 = itemId == 25910 ||itemId == 23073 || itemId == 24370 || itemId == 25904? 300 : 180;
		//	System.out.println("k3: "+k3+" and zoom: "+itemDef.modelZoom+" and multiplied: "+(itemDef.modelZoom * 1.9D));
		int l3 = Rasterizer.SINE[itemDef.rotationY] * k3 >> 16;
		int i4 = Rasterizer.COSINE[itemDef.rotationY] * k3 >> 16;
		model.renderSingle(itemDef.rotationX, itemDef.rotationZ, itemDef.rotationY, itemDef.modelOffsetX, l3 + model.modelHeight / 2 + itemDef.modelOffsetY, i4 + itemDef.modelOffsetY);
		DrawingArea.initDrawingArea(j2, i2, ai1, new float[1024]);
		DrawingArea.setDrawingArea(j3, k2, l2, i3);
		Rasterizer.centerX = k1;
		Rasterizer.centerY = l1;
		Rasterizer.lineOffsets = ai;
		Rasterizer.notTextured = true;
		enabledSprite.maxWidth = 150;
		enabledSprite.maxHeight = 150;
		return enabledSprite;
	}

	public Model method194(int j) {
		int k = maleDialogue;
		int l = anInt166;

		if (j == 1) {
			k = femaleDialogue;
			l = anInt173;
		}

		if (k == -1) {
			return null;
		}

		Model model = Model.get(k);
		if (rdc > 0) {
			model.method1337(rdc);
		}
		if (rdc2 != 0) {
			model.method1338(rdc2);
		}
		if (rdc3 != 0) {
			model.method1339(rdc3);
		}
		applyTexturing(model, id);
		if (l != -1) {
			Model model_1 = Model.get(l);
			Model models[] = {model, model_1};
			model = new Model(2, models);
		}

		if (colorChange != null)
			Objects.requireNonNull(model).tint(colorChange);
		if (oldColors != null) {
			for (int i1 = 0; i1 < oldColors.length; i1++) {
				model.method476(oldColors[i1], newColors[i1]);
			}
		}
		applyTexturing(model, id);
		return model;
	}

	public boolean method195(int j) {
		int k = maleEquip1;
		int l = anInt188;
		int i1 = anInt185;

		if (j == 1) {
			k = femaleEquip1;
			l = anInt164;
			i1 = anInt162;
		}

		if (k == -1) {
			return true;
		}

		boolean flag = true;

		if (!Model.method463(k)) {
			flag = false;
		}

		if (l != -1 && !Model.method463(l)) {
			flag = false;
		}

		if (i1 != -1 && !Model.method463(i1)) {
			flag = false;
		}

		return flag;
	}

	public Model method196(int i) {
		int j = maleEquip1;
		int k = anInt188;
		int l = anInt185;

		if (i == 1) {
			j = femaleEquip1;
			k = anInt164;
			l = anInt162;
		}

		if (j == -1) {
			return null;
		}

		Model model = Model.get(j);
		if (rdc > 0) {
			model.method1337(rdc);
		}
		if (rdc2 != 0) {
			model.method1338(rdc2);
		}
		if (rdc3 != 0) {
			model.method1339(rdc3);
		}
		applyTexturing(model, id);
		if (k != -1) {
			if (l != -1) {
				Model model_1 = Model.get(k);
				Model model_3 = Model.get(l);
				Model model_1s[] = {model, model_1, model_3};
				model = new Model(3, model_1s);
			} else {
				Model model_2 = Model.get(k);
				Model models[] = {model, model_2};
				model = new Model(2, models);
			}
		}

		if (maleModelScale != 1) {
			model.scaleT((int)(128D / maleModelScale), (int)(128D /maleModelScale), (int)(128D /maleModelScale));
		}
		if (i == 0 && (maleWieldX != 0 || maleWieldY != 0 || maleWieldZ != 0)) {
			model.translate(maleWieldX, maleWieldY, maleWieldZ);
		}

		if (i == 1 && (femaleWieldX != 0 || femaleWieldY != 0 || femaleWieldZ != 0)) {
			model.translate(femaleWieldX, femaleWieldY, femaleWieldZ);
		}

		if (colorChange != null)
			Objects.requireNonNull(model).tint(colorChange);
		if (oldColors != null) {
			for (int i1 = 0; i1 < oldColors.length; i1++) {
				model.method476(oldColors[i1], newColors[i1]);
			}
		}
		applyTexturing(model, id);
		return model;
	}

	public Model method202(int i) {
		if (stackIDs != null && i > 1) {
			int j = -1;

			for (int k = 0; k < 10; k++) {
				if (i >= stackAmounts[k] && stackAmounts[k] != 0) {
					j = stackIDs[k];
				}
			}

			if (j != -1) {
				return get(j).method202(1);
			}
		}

		Model model = Model.get(modelID);
		if (rdc > 0) {
			model.method1337(rdc);
		}
		if (rdc2 != 0) {
			model.method1338(rdc2);
		}
		if (rdc3 != 0) {
			model.method1339(rdc3);
		}

		if (colorChange != null)
			Objects.requireNonNull(model).tint(colorChange);
		applyTexturing(model, id);
		if (model == null) {
			return null;
		}

		if (oldColors != null) {
			for (int l = 0; l < oldColors.length; l++) {
				model.method476(oldColors[l], newColors[l]);
			}
		}
		applyTexturing(model, id);
		return model;
	}

	private void readValues(ByteBuffer buffer) {
		do {
			int opcode = buffer.getUnsignedByte();

			if (opcode == 0) {
				return;
			} else if (opcode == 1) {
				modelID = buffer.getUnsignedShort();
			} else if (opcode == 2) {
				name = buffer.getString();
			} else if (opcode == 3) {
				description = buffer.getBytes();
			} else if (opcode == 4) {
				modelZoom = buffer.getUnsignedShort();
			} else if (opcode == 5) {
				rotationY = buffer.getUnsignedShort();
			} else if (opcode == 6) {
				rotationX = buffer.getUnsignedShort();
			} else if (opcode == 7) {
				modelOffsetX = buffer.getUnsignedShort();

				if (modelOffsetX > 32767) {
					modelOffsetX -= 0x10000;
				}
			} else if (opcode == 8) {
				modelOffsetY = buffer.getUnsignedShort();

				if (modelOffsetY > 32767) {
					modelOffsetY -= 0x10000;
				}
			} else if (opcode == 10) {
				buffer.getUnsignedShort();
			} else if (opcode == 11) {
				stackable = true;
			} else if (opcode == 12) {
				value = buffer.getIntLittleEndian();
			} else if (opcode == 16) {
				membersObject = true;
			} else if (opcode == 23) {
				maleEquip1 = buffer.getUnsignedShort();
				maleWieldY = buffer.getSignedByte();
			} else if (opcode == 24) {
				anInt188 = buffer.getUnsignedShort();
			} else if (opcode == 25) {
				femaleEquip1 = buffer.getUnsignedShort();
				femaleWieldY = buffer.getSignedByte();
			} else if (opcode == 26) {
				anInt164 = buffer.getUnsignedShort();
			} else if (opcode >= 30 && opcode < 35) {
				if (groundActions == null) {
					groundActions = new String[5];
				}

				groundActions[opcode - 30] = buffer.getString();

				if (groundActions[opcode - 30].equalsIgnoreCase("hidden")) {
					groundActions[opcode - 30] = null;
				}
			} else if (opcode >= 35 && opcode < 40) {
				if (actions == null) {
					actions = new String[5];
				}

				actions[opcode - 35] = buffer.getString();
			} else if (opcode == 40) {
				int size = buffer.getUnsignedByte();
				oldColors = new int[size];
				newColors = new int[size];

				for (int k = 0; k < size; k++) {
					oldColors[k] = buffer.getUnsignedShort();
					newColors[k] = buffer.getUnsignedShort();
				}
			} else if (opcode == 78) {
				anInt185 = buffer.getUnsignedShort();
			} else if (opcode == 79) {
				anInt162 = buffer.getUnsignedShort();
			} else if (opcode == 90) {
				maleDialogue = buffer.getUnsignedShort();
			} else if (opcode == 91) {
				femaleDialogue = buffer.getUnsignedShort();
			} else if (opcode == 92) {
				anInt166 = buffer.getUnsignedShort();
			} else if (opcode == 93) {
				anInt173 = buffer.getUnsignedShort();
			} else if (opcode == 95) {
				rotationZ = buffer.getUnsignedShort();
			} else if (opcode == 97) {
				certID = buffer.getUnsignedShort();
			} else if (opcode == 98) {
				certTemplateID = buffer.getUnsignedShort();
			} else if (opcode >= 100 && opcode < 110) {
				if (stackIDs == null) {
					stackIDs = new int[10];
					stackAmounts = new int[10];
				}

				stackIDs[opcode - 100] = buffer.getUnsignedShort();
				stackAmounts[opcode - 100] = buffer.getUnsignedShort();
			} else if (opcode == 110) {
				scaleX = buffer.getUnsignedShort();
			} else if (opcode == 111) {
				scaleY = buffer.getUnsignedShort();
			} else if (opcode == 112) {
				scaleZ = buffer.getUnsignedShort();
			} else if (opcode == 113) {
				anInt196 = buffer.getSignedByte();
			} else if (opcode == 114) {
				anInt184 = buffer.getSignedByte() * 5;
			} else if (opcode == 115) {
				team = buffer.getUnsignedByte();
			} else if (opcode == 121) {
				lendID = buffer.getUnsignedShort();
			} else if (opcode == 122) {
				lendTemplateID = buffer.getUnsignedShort();
			}
		} while (true);
	}

	
	
	private void setDefaults() {
		equipOptions = new String[70];
		equipOptions[1] = "Operate";
		modelID = 0;
		name = null;
		maleModelScale = 1;
		description = null;
		newColors = null;
		oldColors = null;
		modelZoom = 2000;
		rotationY = 0;
		rotationX = 0;
		rotationZ = 0;
		modelOffsetX = 0;
		modelOffsetY = 0;
		stackable = false;
		value = 1;
		membersObject = false;
		groundActions = null;
		actions = null;
		lendID = -1;
		lendTemplateID = -1;
		maleEquip1 = -1;
		anInt188 = -1;
		femaleEquip1 = -1;
		anInt164 = -1;
		anInt185 = -1;
		anInt162 = -1;
		maleDialogue = -1;
		anInt166 = -1;
		femaleDialogue = -1;
		anInt173 = -1;
		stackIDs = null;
		stackAmounts = null;
		certID = -1;
		certTemplateID = -1;
		scaleX = 128;
		scaleY = 128;
		scaleZ = 128;
		anInt196 = 0;
		anInt184 = 0;
		team = 0;
		rdc = 0;
		rdc2 = 0;
		rdc3 = 0;
		femaleWieldY = 0;
		femaleWieldX = 0;
		femaleWieldZ = 0;
		maleWieldX = 0;
		maleWieldZ = 0;
		maleWieldY = 0;
		colorChange = null;
	}

	private void toLend() {
		ItemDefinition itemDef = get(lendTemplateID);
		actions = new String[5];
		modelID = itemDef.modelID;
		modelOffsetX = itemDef.modelOffsetX;
		rotationX = itemDef.rotationX;
		modelOffsetY = itemDef.modelOffsetY;
		modelZoom = itemDef.modelZoom;
		rotationY = itemDef.rotationY;
		rotationZ = itemDef.rotationZ;
		value = 0;
		ItemDefinition definition = get(lendID);
		anInt166 = definition.anInt166;
		newColors = definition.newColors;
		anInt185 = definition.anInt185;
		femaleEquip1 = definition.femaleEquip1;
		anInt173 = definition.anInt173;
		maleDialogue = definition.maleDialogue;
		groundActions = definition.groundActions;
		maleEquip1 = definition.maleEquip1;
		name = definition.name;
		anInt188 = definition.anInt188;
		membersObject = definition.membersObject;
		femaleDialogue = definition.femaleDialogue;
		anInt164 = definition.anInt164;
		anInt162 = definition.anInt162;
		oldColors = definition.oldColors;
		team = definition.team;

		if (definition.actions != null) {
			for (int i = 0; i < 4; i++) {
				actions[i] = definition.actions[i];
			}
		}

		actions[4] = "Discard";
	}

	private void toNote() {
		ItemDefinition definition = get(certTemplateID);
		modelID = definition.modelID;
		modelZoom = definition.modelZoom;
		rotationY = definition.rotationY;
		rotationX = definition.rotationX;
		rotationZ = definition.rotationZ;
		modelOffsetX = definition.modelOffsetX;
		modelOffsetY = definition.modelOffsetY;
		oldColors = definition.oldColors;
		newColors = definition.newColors;
		definition = get(certID);
		name = definition.name;
		membersObject = definition.membersObject;
		value = definition.value;
		String s = "a";
		char c = definition.name.charAt(0);

		if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
			s = "an";
		}

		description = ("Swap this note at any bank for " + s + " " + definition.name + ".").getBytes();
		stackable = true;
	}

	public static void printDefinitionsForId(int itemId) {
		/* Print out Grain */
		ItemDefinition dumpitem = ItemDefinition.get(itemId);
		if (dumpitem.name != null) {
			System.out.println("Dumping: " + dumpitem.name);
		} else {
			System.out.println("ItemDefinition.get(" + itemId + ").name == null");
		}
		System.out.println("itemId: " + dumpitem.id);
		System.out.println("modelId: " + dumpitem.modelID);
		System.out.println("maleWearId: " + dumpitem.maleEquip1);
		System.out.println("femaleWearId: " + dumpitem.femaleEquip1);
		System.out.println("modelOffset1: " + dumpitem.modelOffsetX);
		System.out.println("modelOffSetX: " + dumpitem.rotationZ);
		System.out.println("modelOffSetY: " + dumpitem.modelOffsetY);
		System.out.println("modelRotationY: " + dumpitem.rotationY);
		System.out.println("modelRotationX: " + dumpitem.rotationX);
		System.out.println("modelZoom: " + dumpitem.modelZoom);
		// System.out.println("def "+dumpitem);
		if (dumpitem.oldColors != null) {
			for (int i = 0; i < dumpitem.oldColors.length; i++) {
				System.out.println("modifiedModelColors[" + i + "]: " + dumpitem.oldColors[i]);
			}
		}
		if (dumpitem.newColors != null) {
			for (int i = 0; i < dumpitem.newColors.length; i++) {
				System.out.println("originalModelColors[" + i + "]: " + dumpitem.newColors[i]);
			}
		}
		if (dumpitem.actions != null) {
			for (int i = 0; i < dumpitem.actions.length; i++) {
				System.out.println("Action[" + i + "]: " + dumpitem.actions[i]);
			}
		}
		if (dumpitem.groundActions != null) {
			for (int i = 0; i < dumpitem.groundActions.length; i++) {
				System.out.println("groundAction[" + i + "]: " + dumpitem.groundActions[i]);
			}
		}
	}

	public static void dump() {
		File f = new File("itemnames.txt");
		//System.out.println("Dumping Item names..");
		// String[] variableNames = new String[] { "name", };
		try {
			f.createNewFile();
			BufferedWriter bf = new BufferedWriter(new FileWriter(f));
			for (int i = 0; i < streamIndices.length; i++) {
				ItemDefinition item = get(i);
				if (item != null)
				if (item.name != null && !item.name.equalsIgnoreCase("dwarf remains")) {
					bf.write("Item Id: " + item.id);
					bf.newLine();
					bf.write("name: " + item.name);
					bf.newLine();
					bf.write("modelID: " + item.modelID);
					bf.newLine();
					bf.newLine();
				}
			}
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println("Dumping Complete!");
	}

	public double[] colorChange = null;
}