package org.necrotic.client.cache.definition;


public class ItemDef3 {
	public byte[] customSpriteLocation;

	private ItemDef3() {
	}

	public static ItemDefinition newIDS1(ItemDefinition itemDef, int id) {


		ItemDefinition itemdefedit;
		switch (id) {


			case 23428:
				itemDef.copyItem(18768);
				itemDef.actions = new String[]{"Open", null, null, null, null};
				itemDef.name = "Autumn Box";
				itemDef.newColors = new int[]{
						2999, 926, 22410
				};
				itemDef.oldColors = new int[]{
						3967,  59314,  59314
				};
				break;
			case 23883:
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.name = "Coronet of Autumn";
				itemDef.modelID = 86900;
				itemDef.maleEquip1 = 86880;
				itemDef.femaleEquip1 = 86890;
				itemDef.modelZoom = 395;
				itemDef.rotationY = 190;
				itemDef.rotationX = 85;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = -9;
				break;

			case 23884:
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.name = "Cloak of autumn";
				itemDef.modelID = 95814;
				itemDef.maleEquip1 = 95795;
				itemDef.femaleEquip1 = 95795;
				itemDef.modelZoom = 1974;
				itemDef.rotationY = 368;
				itemDef.rotationX = 228;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 3;
				itemDef.modelOffsetY = 4;
				break;

			case 1959:
				itemDef.name = "Pumpkin";
				itemDef.actions = new String[]{"Open", null, null, null, "Drop"};
				break;

			case 23204:
			itemDef.name = "Sapphire fragments";
			itemdefedit = ItemDefinition.get(9189);
			itemDef.modelID = itemdefedit.modelID;
			itemDef.maleEquip1 = itemdefedit.maleEquip1;
			itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
			itemDef.modelOffsetX = itemdefedit.modelOffsetX;
			itemDef.modelOffsetY = itemdefedit.modelOffsetY;
			itemDef.modelZoom = 300;
			itemDef.rotationY = itemdefedit.rotationY;
			itemDef.rotationX = itemdefedit.rotationX;
			itemDef.rdc2 = 27280;
			itemDef.actions = new String[]{null, null, null, null, "Drop"};
			itemDef.stackable = true;
			break;
		case 23205:
			itemDef.name = "Emerald fragments";
			itemdefedit = ItemDefinition.get(9190);
			itemDef.modelID = itemdefedit.modelID;
			itemDef.maleEquip1 = itemdefedit.maleEquip1;
			itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
			itemDef.modelOffsetX = itemdefedit.modelOffsetX;
			itemDef.modelOffsetY = itemdefedit.modelOffsetY;
			itemDef.modelZoom = 300;
			itemDef.rotationY = itemdefedit.rotationY;
			itemDef.rotationX = itemdefedit.rotationX;
			itemDef.rdc2 = 863532;
			itemDef.actions = new String[]{null, null, null, null, "Drop"};
			itemDef.stackable = true;
			break;

		case 23206:
			itemDef.name = "Ruby fragments";
			itemdefedit = ItemDefinition.get(9188);
			itemDef.modelID = itemdefedit.modelID;
			itemDef.maleEquip1 = itemdefedit.maleEquip1;
			itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
			itemDef.modelOffsetX = itemdefedit.modelOffsetX;
			itemDef.modelOffsetY = itemdefedit.modelOffsetY;
			itemDef.modelZoom = 300;
			itemDef.rotationY = itemdefedit.rotationY;
			itemDef.rotationX = itemdefedit.rotationX;
			itemDef.rdc2 = 55780;
			itemDef.actions = new String[]{null, null, null, null, "Drop"};
			itemDef.stackable = true;
			break;

		case 23207:
			itemDef.name = "Diamond fragments";
			itemdefedit = ItemDefinition.get(9192);
			itemDef.modelID = itemdefedit.modelID;
			itemDef.maleEquip1 = itemdefedit.maleEquip1;
			itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
			itemDef.modelOffsetX = itemdefedit.modelOffsetX;
			itemDef.modelOffsetY = itemdefedit.modelOffsetY;
			itemDef.modelZoom = 300;
			itemDef.rotationY = itemdefedit.rotationY;
			itemDef.rotationX = itemdefedit.rotationX;
			itemDef.colorChange = new double[]{0.1, 1, 1.2};
			itemDef.actions = new String[]{null, null, null, null, "Drop"};
			itemDef.stackable = true;
			break;
			
		case 23208:
			itemDef.name = "Onyx fragments";
			itemdefedit = ItemDefinition.get(9194);
			itemDef.modelID = itemdefedit.modelID;
			itemDef.maleEquip1 = itemdefedit.maleEquip1;
			itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
			itemDef.modelOffsetX = itemdefedit.modelOffsetX;
			itemDef.modelOffsetY = itemdefedit.modelOffsetY;
			itemDef.modelZoom = 300;
			itemDef.rotationY = itemdefedit.rotationY;
			itemDef.rotationX = itemdefedit.rotationX;
			itemDef.rdc2 = 580;
			itemDef.actions = new String[]{null, null, null, null, "Drop"};
			itemDef.stackable = true;
			break;
			
		case 23209:
			itemDef.name = "Zenyte fragments";
			itemdefedit = ItemDefinition.get(9191);
			itemDef.modelID = itemdefedit.modelID;
			itemDef.maleEquip1 = itemdefedit.maleEquip1;
			itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
			itemDef.modelOffsetX = itemdefedit.modelOffsetX;
			itemDef.modelOffsetY = itemdefedit.modelOffsetY;
			itemDef.modelZoom = 300;
			itemDef.rotationY = itemdefedit.rotationY;
			itemDef.rotationX = itemdefedit.rotationX;
			itemDef.colorChange = new double[]{1.2, 0.8, 0.1};
			itemDef.actions = new String[]{null, null, null, null, "Drop"};
			itemDef.stackable = true;
			break;

			case 10482:
				itemDef.name = "Tanzanite fragments";
				itemdefedit = ItemDefinition.get(9191);
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 300;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.rdc2 = 38420;
				break;

			case 10481:
				itemDef.name = "Platinum fragments";
				itemdefedit = ItemDefinition.get(9191);
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 300;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{"Claim", null, null, null, null};
				itemDef.rdc2 = 623532;
				break;
			
			case 23000:
				itemDef.copyItem(6585);
				itemDef.name = "Carrot Necklace";
				itemDef.modelID = 100051;
				itemDef.maleEquip1 = 100052;
				itemDef.femaleEquip1 = 100052;
				itemDef.modelZoom = 635;
				itemDef.rotationX = 254;
				itemDef.rotationY = 449;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 5;
				itemDef.modelOffsetY = 11;
				break;
				
			case 23002:
				itemDef.copyItem(290);
				itemDef.name = "Fortune Chest";
				itemDef.modelID = 100054;
				itemDef.modelZoom = 936;
				itemDef.rotationX = 110;
				itemDef.rotationY = 127;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -6;
				break;
				
			case 23003:
				itemDef.copyItem(12855);
				itemDef.name = "Easter Tickets";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 100056;
				itemDef.modelZoom = 1874;
				itemDef.rotationX = 0;
				itemDef.rotationY = 525;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;

			case 23004:
				itemDef.copyItem(12855);
				itemDef.name = "Orange Easter Egg";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 100057;
				itemDef.modelZoom = 535;
				itemDef.rotationX = 0;
				itemDef.rotationY = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;

			case 23254:
				itemDef.copyItem(18344);
				itemDef.name = "X1.5 DR Booster";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.rdc2 = 35252;
				break;

			case 23005:
				itemDef.copyItem(23004);
				itemDef.name = "Cyan Easter Egg";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 100058;
				break;
				
			case 23006:
				itemDef.copyItem(23004);
				itemDef.name = "Purple Easter Egg";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 100059;
				break;
				
			case 23007:
				itemDef.copyItem(23004);
				itemDef.name = "Red Easter Egg";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 100060;
				break;

			case 23008:
				itemDef.copyItem(12855);
				itemDef.name = "White Easter Dye";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 100061;
				itemDef.modelZoom = 769;
				itemDef.rotationX = 0;
				itemDef.rotationY = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -3;
				break;
				
			case 23009:
				itemDef.copyItem(23008);
				itemDef.name = "Green Easter Dye";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 100062;
				break;
				
			case 23010:
				itemDef.copyItem(23008);
				itemDef.name = "Gold Easter Dye";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 100063;
				break;
				
			case 23011:
				itemDef.copyItem(23008);
				itemDef.name = "Blue Easter Dye";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 100064;
				break;
				
			case 23012:
				itemDef.copyItem(23008);
				itemDef.name = "Red Easter Dye";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 100065;
				break;


			case 23430:
				itemDef.copyItem(23008);
				itemDef.name = "Purple'Ween Dye";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 19657;
				break;

			case 23431:
				itemDef.copyItem(23008);
				itemDef.name = "Black'Ween Dye";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 19658;
				break;

			case 23432:
				itemDef.copyItem(23008);
				itemDef.name = "Orange'Ween Dye";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 19659;
				break;

			case 23433:
				itemDef.copyItem(1959);
				itemDef.name = "Purple Pumpkin";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 19660;
				itemDef.stackable = false;
				break;
			case 23434:
				itemDef.copyItem(1959);
				itemDef.name = "Black Pumpkin";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 19661;
				itemDef.stackable = false;
				break;
			case 23435:
				itemDef.copyItem(1959);
				itemDef.name = "Red Pumpkin";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 19662;
				itemDef.stackable = false;
				break;
			case 23013:
				itemDef.copyItem(1053);
				itemDef.name = "Easter Bunny Mask";
				itemDef.modelID = 100066;
				itemDef.maleEquip1 = 100067;
				itemDef.femaleEquip1 = 100067;
				itemDef.modelZoom = 1505;
				itemDef.rotationX = 0;
				itemDef.rotationY = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23014:
				itemDef.copyItem(23013);
				itemDef.name = "Green Easter Bunny Mask";
				itemDef.modelID = 100068;
				itemDef.maleEquip1 = 100069;
				itemDef.femaleEquip1 = 100069;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 23015:
				itemDef.copyItem(23014);
				itemDef.name = "Golden Easter Bunny Mask";
				itemDef.modelID = 100070;
				itemDef.maleEquip1 = 100071;
				itemDef.femaleEquip1 = 100071;
				break;
				
			case 23016:
				itemDef.copyItem(23014);
				itemDef.name = "Blue Easter Bunny Mask";
				itemDef.modelID = 100072;
				itemDef.maleEquip1 = 100073;
				itemDef.femaleEquip1 = 100073;
				break;
				
			case 23017:
				itemDef.copyItem(23014);
				itemDef.name = "Red Easter Bunny Mask";
				itemDef.modelID = 100074;
				itemDef.maleEquip1 = 100075;
				itemDef.femaleEquip1 = 100075;
				break;

			case 23018:
				itemDef.copyItem(5074);
				itemDef.name = "Armoured Bunny Pet";
				itemDef.modelID = 100050;
				itemDef.modelZoom = 4000;
				break;

			case 23020:
				itemDef.copyItem(19670);
				itemDef.name = "Vote Scroll";
				itemDef.rdc2 = 15345;
				break;

			case 7539:
				//itemDef.copyItem(4882);
				itemDef.modelID = 19487;
				itemDef.maleEquip1 = 19494;
				itemDef.femaleEquip1 = 19494;
				itemDef.name = "Crab helmet";
				break;
			case 15509:
				//itemDef.copyItem(4882);
				itemDef.name = "Autumn Coronet";
				itemDef.rdc2 = 59664;
				break;

			case 23439:
				itemDef.copyItem(4882);
				itemDef.name = "Pennywise Mask";
				itemDef.modelID = 19650;
				itemDef.maleEquip1 = 19651;
				itemDef.femaleEquip1 = 19651;
				itemDef.rotationY = 265;
				break;
			case 23440:
				itemDef.copyItem(4882);
				itemDef.name = "Purple Pennywise Mask";
				itemDef.modelID = 19663;
				itemDef.maleEquip1 = 19664;
				itemDef.femaleEquip1 = 19664;
				itemDef.rotationY = 265;
				break;

			case 23441:
				itemDef.copyItem(4882);
				itemDef.name = "Black Pennywise Mask";
				itemDef.modelID = 19665;
				itemDef.maleEquip1 = 19666;
				itemDef.femaleEquip1 = 19666;
				itemDef.rotationY = 265;
				break;

			case 23442:
				itemDef.copyItem(4882);
				itemDef.name = "Orange Pennywise Mask";
				itemDef.modelID = 19667;
				itemDef.maleEquip1 = 19668;
				itemDef.femaleEquip1 = 19668;
				itemDef.rotationY = 265;
				break;

			case 23396:
				itemDef.copyItem(4882);
				itemDef.name = "Cosmetic helm";
				itemDef.modelID = 19584;
				itemDef.maleEquip1 = 19584;
				itemDef.femaleEquip1 = 19584;
				itemDef.modelZoom = 600;
				itemDef.rotationX = 9;
				itemDef.rotationY = 165;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 172;
				break;
			case 23397:
				itemDef.copyItem(4894);
				itemDef.name = "Cosmetic platebody";
				itemDef.modelID = 19585;
				itemDef.maleEquip1 = 19585;
				itemDef.femaleEquip1 = 19585;
				itemDef.modelZoom = 2374;
				itemDef.rotationX = 0;
				itemDef.rotationY = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 26;
				break;

			case 23398:
				itemDef.copyItem(4900);
				itemDef.name = "Cosmetic leggings";
				itemDef.modelID = 19588;
				itemDef.maleEquip1 = 19588;
				itemDef.femaleEquip1 = 19588;
				itemDef.modelZoom = 1661;
				itemDef.rotationX = 0;
				itemDef.rotationY = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 10;
				break;

			case 23399:
				itemDef.copyItem(20456);
				itemDef.name = "Cosmetic boots";
				itemDef.modelID = 19586;
				itemDef.maleEquip1 = 19586;
				itemDef.femaleEquip1 = 19586;
				itemDef.modelZoom = 617;
				itemDef.rotationX = 0;
				itemDef.rotationY = 340;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 22;
				break;

			case 23400:
				itemDef.copyItem(20460);
				itemDef.name = "Cosmetic gloves";
				itemDef.modelID = 19587;
				itemDef.maleEquip1 = 19587;
				itemDef.femaleEquip1 = 19587;
				itemDef.modelZoom = 1678;
				itemDef.rotationX = 0;
				itemDef.rotationY = 96;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 43;
				break;



			case 23259:
				itemDef.copyItem(4882);
				itemDef.name = "Reaper helm";
				itemDef.rdc2 = 37664;
				break;
			case 23260:
				itemDef.copyItem(4894);
				itemDef.name = "Reaper platebody";
				itemDef.rdc2 = 37664;
				break;

			case 23261:
				itemDef.copyItem(4900);
				itemDef.name = "Reaper platelegs";
				itemDef.rdc2 = 37664;
				break;

			case 23262:
				itemDef.copyItem(20460);
				itemDef.name = "Reaper gloves";
				itemDef.rdc2 = 37664;
				break;

			case 23263:
				itemDef.copyItem(20456);
				itemDef.name = "Reaper boots";
				itemDef.rdc2 = 37664;
				break;
				
			case 23021:
				itemDef.copyItem(4708);
				itemDef.name = "Magic helm";
				itemDef.modelID = 100084;
				itemDef.maleEquip1 = 100085;
				itemDef.femaleEquip1 = 100085;
				break;
				
			case 23022:
				itemDef.copyItem(4712);
				itemDef.name = "Magic body";
				itemDef.modelID = 100093;
				itemDef.maleEquip1 = 100094;
				itemDef.femaleEquip1 = 100094;
				break;
				
			case 23023:
				itemDef.copyItem(4714);
				itemDef.name = "Magic legs";
				itemDef.modelID = 100091;
				itemDef.maleEquip1 = 100092;
				itemDef.femaleEquip1 = 100092;
				break;
				
			case 23024:
				itemDef.copyItem(4708);
				itemDef.name = "Magic gloves";
				itemDef.modelID = 100089;
				itemDef.maleEquip1 = 100090;
				itemDef.femaleEquip1 = 100090;
				break;
				
			case 23025:
				itemDef.copyItem(20456);
				itemDef.name = "Magic boots";
				itemDef.modelID = 100088;
				itemDef.maleEquip1 = 100088;
				itemDef.femaleEquip1 = 100088;
				break;
				
			case 23026:
				itemDef.copyItem(1391);
				itemDef.name = "Magic staff";
				itemDef.modelZoom = 2000;
				itemDef.rotationZ = 10;
				itemDef.modelOffsetX = 10;
				itemDef.modelID = 100095;
				itemDef.maleEquip1 = 100096;
				itemDef.femaleEquip1 = 100096;
				break;
				
			case 23027:
				itemDef.copyItem(3841);
				itemDef.name = "Magic book";
				itemDef.modelID = 100086;
				itemDef.maleEquip1 = 100087;
				itemDef.femaleEquip1 = 100087;
				break;
				
			case 23028:
				itemDef.copyItem(4708);
				itemDef.name = "Melee helm";
				itemDef.modelZoom = 500;
				itemDef.modelID = 100105;
				itemDef.maleEquip1 = 100106;
				itemDef.femaleEquip1 = 100106;
				break;
				
			case 23029:
				itemDef.copyItem(4712);
				itemDef.name = "Melee body";
				itemDef.modelID = 100098;
				itemDef.maleEquip1 = 100099;
				itemDef.femaleEquip1 = 100099;
				break;
				
			case 23030:
				itemDef.copyItem(4714);
				itemDef.name = "Melee legs";
				itemDef.modelID = 100107;
				itemDef.maleEquip1 = 100108;
				itemDef.femaleEquip1 = 100108;
				break;
				
			case 23031:
				itemDef.copyItem(4708);
				itemDef.name = "Melee gloves";
				itemDef.modelID = 100101;
				itemDef.maleEquip1 = 100102;
				itemDef.femaleEquip1 = 100102;
				break;
				
			case 23032:
				itemDef.copyItem(20456);
				itemDef.name = "Melee boots";
				itemDef.modelID = 100100;
				itemDef.maleEquip1 = 100100;
				itemDef.femaleEquip1 = 100100;
				break;
				
			case 23033:
				itemDef.copyItem(4710);
				itemDef.name = "Melee hammers";
				itemDef.modelID = 100103;
				itemDef.maleEquip1 = 100104;
				itemDef.femaleEquip1 = 100104;
				break;

			case 23034:
				itemDef.copyItem(4708);
				itemDef.name = "Range helm";
				itemDef.modelID = 100117;
				itemDef.maleEquip1 = 100118;
				itemDef.femaleEquip1 = 100118;
				break;
				
			case 23035:
				itemDef.copyItem(4712);
				itemDef.name = "Range body";
				itemDef.modelID = 100119;
				itemDef.maleEquip1 = 100115;
				itemDef.femaleEquip1 = 100115;
				break;
				
			case 23036:
				itemDef.copyItem(4714);
				itemDef.name = "Range legs";
				itemDef.modelID = 100120;
				itemDef.maleEquip1 = 100121;
				itemDef.femaleEquip1 = 100121;
				break;
				
			case 23037:
				itemDef.copyItem(4708);
				itemDef.name = "Range gloves";
				itemDef.modelID = 100112;
				itemDef.maleEquip1 = 100113;
				itemDef.femaleEquip1 = 100113;
				break;
				
			case 23038:
				itemDef.copyItem(20456);
				itemDef.name = "Range boots";
				itemDef.modelID = 100116;
				itemDef.maleEquip1 = 100116;
				itemDef.femaleEquip1 = 100116;
				break;
				
			case 23039:
				itemDef.copyItem(4710);
				itemDef.name = "Range bow";
				itemDef.modelID = 100110;
				itemDef.maleEquip1 = 100111;
				itemDef.femaleEquip1 = 100111;
				break;

			case 23040:
				itemDef.copyItem(290);
				itemDef.modelZoom = 3000;
				itemDef.name = "Chest";
				itemDef.modelID = 100122;
				itemDef.maleEquip1 = 100122;
				itemDef.femaleEquip1 = 100122;
				break;

			case 23041:
				itemDef.copyItem(5074);
				itemDef.name = "Mage Pet";
				itemDef.modelID = 100097;
				itemDef.modelZoom = 3400;
				break;
				
			case 23042:
				itemDef.copyItem(5074);
				itemDef.name = "Melee Pet";
				itemDef.modelID = 100109;
				itemDef.modelZoom = 3400;
				break;
				
			case 23043:
				itemDef.copyItem(5074);
				itemDef.name = "Ranged Pet";
				itemDef.modelID = 100114;
				itemDef.modelZoom = 3400;
				break;

			case 23044:
				itemDef.copyItem(1);
				itemDef.name = "Aura 1";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.modelID = 100123;
				itemDef.rotationX = 0;
				itemDef.modelZoom = 2000;
				break;
			case 23045:
				itemDef.copyItem(23044);
				itemDef.name = "Aura 2";
				itemDef.modelID = 100124;
				break;
			case 23046:
				itemDef.copyItem(23044);
				itemDef.name = "Aura 3";
				itemDef.modelID = 100125;
				break;
			case 23047:
				itemDef.copyItem(23044);
				itemDef.name = "Aura 4";
				itemDef.modelID = 100126;
				break;
			case 23048:
				itemDef.copyItem(23044);
				itemDef.name = "Aura 5";
				itemDef.modelID = 100127;
				break;
			case 23049:
				itemDef.copyItem(23044);
				itemDef.name = "Aura 6";
				itemDef.modelID = 100128;
				break;
			case 23281:
				itemDef.copyItem(6585);
				itemDef.name = "Vozzath helm";
				itemDef.modelID = 19689;
				itemDef.maleEquip1 = 19689;
				itemDef.femaleEquip1 = 19689;
				itemDef.modelZoom = 850;
				itemDef.rotationX = 0;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 90;
				itemDef.modelOffsetX = 0;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;
			case 22373:
				itemDef.copyItem(6585);
				itemDef.name = "Pumpkin head";
				itemDef.modelID = 19697;
				itemDef.maleEquip1 = 19697;
				itemDef.femaleEquip1 = 19697;
				itemDef.modelZoom = 850;
				itemDef.rotationX = 0;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 90;
				itemDef.modelOffsetX = 0;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;
			case 22374:
				itemDef.copyItem(6585);
				itemDef.name = "Chucky doll";
				itemDef.modelID = 19746;
				itemDef.maleEquip1 = 19746;
				itemDef.femaleEquip1 = 19746;
				itemDef.modelZoom = 1539;
				itemDef.rotationX = 148;
				itemDef.rotationY = 0;
				itemDef.rotationZ = 96;
				itemDef.modelOffsetX = -26;
				itemDef.modelOffsetY = 12;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;
			case 22376:
				itemDef.name = "Festival boots";
				itemDef.modelID = 19693;
				itemDef.maleEquip1 = 19693;
				itemDef.femaleEquip1 = 19693;
				itemDef.modelZoom = 800;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelOffsetX = 1;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.oldColors = new int[]{57};
				itemDef.newColors = new int[]{106};
				break;

			case 22377:
				itemDef.copyItem(23281);
				itemDef.name = "Festival gloves";
				itemDef.modelID = 19749;
				itemDef.maleEquip1 = 19749;
				itemDef.femaleEquip1 = 19749;
				itemDef.modelZoom = 1680;
				itemDef.rotationX = 0;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 65;
				itemDef.modelOffsetX = 0;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.oldColors = new int[]{57};
				itemDef.newColors = new int[]{106};
				break;

			case 23282:
				itemDef.copyItem(4712);
				itemDef.name = "Vozzath body";
				itemDef.modelID = 19690;
				itemDef.maleEquip1 = 19690;
				itemDef.femaleEquip1 = 19690;
				itemDef.modelZoom = 1380;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 45;
				itemDef.modelOffsetX = 0;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 23283:
				itemDef.name = "Vozzath legs";
				itemDef.modelID = 19691;
				itemDef.maleEquip1 = 19691;
				itemDef.femaleEquip1 = 19691;
				itemDef.modelZoom = 1560;
				itemDef.rotationX = 0;
				itemDef.rotationY = 20;
				itemDef.modelOffsetY = 10;
				itemDef.modelOffsetX = 0;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;

			case 23284:
				itemDef.copyItem(23281);
				itemDef.name = "Vozzath gloves";
				itemDef.modelID = 19692;
				itemDef.maleEquip1 = 19692;
				itemDef.femaleEquip1 = 19692;
				itemDef.modelZoom = 1680;
				itemDef.rotationX = 0;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 65;
				itemDef.modelOffsetX = 0;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 23285:
				itemDef.name = "Vozzath boots";
				itemDef.modelID = 19693;
				itemDef.maleEquip1 = 19693;
				itemDef.femaleEquip1 = 19693;
				itemDef.modelZoom = 800;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelOffsetX = 1;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;



			case 23286:
				itemDef.copyItem(4708);
				itemDef.name = "Tanzanite helm";
				itemDef.modelZoom = 1000;
				itemDef.modelID = 18801;
				itemDef.maleEquip1 = 18802;
				itemDef.femaleEquip1 = 18802;
				break;

			case 23287:
				itemDef.copyItem(4712);
				itemDef.name = "Tanzanite body";
				itemDef.modelZoom = 1500;
				itemDef.modelID = 18805;
				itemDef.maleEquip1 = 18806;
				itemDef.femaleEquip1 = 18806;
				break;

			case 23288:
				itemDef.copyItem(4714);
				itemDef.name = "Tanzanite legs";
				itemDef.modelZoom = 1800;
				itemDef.modelID = 18803;
				itemDef.maleEquip1 = 18804;
				itemDef.femaleEquip1 = 18804;
				break;

			case 23289:
				itemDef.copyItem(4708);
				itemDef.name = "Tanzanite gloves";
				itemDef.modelID = 18799;
				itemDef.modelZoom = 1000;
				itemDef.maleEquip1 = 18800;
				itemDef.femaleEquip1 = 18800;
				break;

			case 23290:
				itemDef.copyItem(20456);
				itemDef.name = "Tanzanite boots";
				itemDef.modelID = 18798;
				itemDef.maleEquip1 = 18798;
				itemDef.femaleEquip1 = 18798;
				break;

			case 23303:
				itemDef.copyItem(4708);
				itemDef.name = "Mystic helm";
				itemDef.modelZoom = 800;
				itemDef.modelID = 19420;
				itemDef.maleEquip1 = 19421;
				itemDef.femaleEquip1 = 19421;
				itemDef.rdc2 = 421788;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[2] = "<col=C3C0B2>Dissolve";
				break;

			case 23304:
				itemDef.copyItem(4712);
				itemDef.name = "Mystic body";
				itemDef.modelZoom = 1400;
				itemDef.modelID = 19422;
				itemDef.maleEquip1 = 19423;
				itemDef.femaleEquip1 = 19423;
				itemDef.rdc2 = 421788;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[2] = "<col=C3C0B2>Dissolve";
				break;

			case 23305:
				itemDef.copyItem(4714);
				itemDef.name = "Mystic legs";
				itemDef.modelZoom = 1600;
				itemDef.modelID = 19424;
				itemDef.maleEquip1 = 19425;
				itemDef.femaleEquip1 = 19425;
				itemDef.rdc2 = 421788;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[2] = "<col=C3C0B2>Dissolve";
				break;

			case 23312:
				itemDef.copyItem(4708);
				itemDef.name = "Mystic helm (u)";
				itemDef.modelZoom = 800;
				itemDef.modelID = 19420;
				itemDef.maleEquip1 = 19421;
				itemDef.femaleEquip1 = 19421;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;

			case 23313:
				itemDef.copyItem(4712);
				itemDef.name = "Mystic body (u)";
				itemDef.modelZoom = 1400;
				itemDef.modelID = 19422;
				itemDef.maleEquip1 = 19423;
				itemDef.femaleEquip1 = 19423;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;

			case 23314:
				itemDef.copyItem(4714);
				itemDef.name = "Mystic legs (u)";
				itemDef.modelZoom = 1600;
				itemDef.modelID = 19424;
				itemDef.maleEquip1 = 19425;
				itemDef.femaleEquip1 = 19425;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;

			case 23309:
				itemDef.copyItem(4708);
				itemDef.name = "Midnight helm";
				itemDef.modelZoom = 600;
				itemDef.modelID = 19434;
				itemDef.maleEquip1 = 19435;
				itemDef.femaleEquip1 = 19435;
				itemDef.rdc2 = 421788;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[2] = "<col=C3C0B2>Dissolve";
				break;

			case 23310:
				itemDef.copyItem(4712);
				itemDef.name = "Midnight body";
				itemDef.modelZoom = 1300;
				itemDef.rotationX = 2000;
				itemDef.modelOffsetX = -5;
				itemDef.modelID = 19440;
				itemDef.maleEquip1 = 19441;
				itemDef.femaleEquip1 = 19441;
				itemDef.rdc2 = 421788;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[2] = "<col=C3C0B2>Dissolve";
				break;

			case 23311:
				itemDef.copyItem(4714);
				itemDef.name = "Midnight legs";
				itemDef.modelZoom = 1400;
				itemDef.rotationX = 1960;
				itemDef.modelID = 19442;
				itemDef.maleEquip1 = 19444;
				itemDef.femaleEquip1 = 19444;
				itemDef.rdc2 = 421788;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[2] = "<col=C3C0B2>Dissolve";
				break;


			case 23306:
				itemDef.copyItem(4708);
				itemDef.name = "Hellish helm";
				itemDef.modelZoom = 700;
				itemDef.modelID = 19426;
				itemDef.maleEquip1 = 19427;
				itemDef.femaleEquip1 = 19427;
				itemDef.rdc2 = 421788;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[2] = "<col=C3C0B2>Dissolve";
				break;

			case 23307:
				itemDef.copyItem(4712);
				itemDef.name = "Hellish body";
				itemDef.modelZoom = 1300;
				itemDef.modelID = 19428;
				itemDef.maleEquip1 = 19429;
				itemDef.femaleEquip1 = 19429;
				itemDef.rdc2 = 421788;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[2] = "<col=C3C0B2>Dissolve";
				break;

			case 23308:
				itemDef.copyItem(4714);
				itemDef.name = "Hellish legs";
				itemDef.modelZoom = 1600;
				itemDef.modelOffsetY = 3;
				itemDef.modelID = 19432;
				itemDef.maleEquip1 = 19433;
				itemDef.femaleEquip1 = 19433;
				itemDef.rdc2 = 421788;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[2] = "<col=C3C0B2>Dissolve";
				break;


			case 23315:
				itemDef.copyItem(4708);
				itemDef.name = "Hellish helm (u)";
				itemDef.modelZoom = 700;
				itemDef.modelID = 19426;
				itemDef.maleEquip1 = 19427;
				itemDef.femaleEquip1 = 19427;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;

			case 23316:
				itemDef.copyItem(4712);
				itemDef.name = "Hellish body (u)";
				itemDef.modelZoom = 1300;
				itemDef.modelID = 19428;
				itemDef.maleEquip1 = 19429;
				itemDef.femaleEquip1 = 19429;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;

			case 23317:
				itemDef.copyItem(4714);
				itemDef.name = "Hellish legs (u)";
				itemDef.modelZoom = 1600;
				itemDef.modelOffsetY = 3;
				itemDef.modelID = 19432;
				itemDef.maleEquip1 = 19433;
				itemDef.femaleEquip1 = 19433;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;

			case 23318:
				itemDef.copyItem(4708);
				itemDef.name = "Midnight helm (u)";
				itemDef.modelZoom = 600;
				itemDef.modelID = 19434;
				itemDef.maleEquip1 = 19435;
				itemDef.femaleEquip1 = 19435;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;

			case 23319:
				itemDef.copyItem(4712);
				itemDef.name = "Midnight body (u)";
				itemDef.modelZoom = 1300;
				itemDef.rotationX = 2000;
				itemDef.modelOffsetX = -5;
				itemDef.modelID = 19440;
				itemDef.maleEquip1 = 19441;
				itemDef.femaleEquip1 = 19441;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;

			case 23320:
				itemDef.copyItem(4714);
				itemDef.name = "Midnight legs (u)";
				itemDef.modelZoom = 1400;
				itemDef.rotationX = 1960;
				itemDef.modelID = 19442;
				itemDef.maleEquip1 = 19444;
				itemDef.femaleEquip1 = 19444;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;



			case 23291:
				itemDef.copyItem(23133);
				itemDef.name = "Tanzanite wings";
				itemDef.modelID = 18807;
				itemDef.maleEquip1 = 18808;
				itemDef.femaleEquip1 = 18808;
				break;


			case 23050:
				itemDef.copyItem(4708);
				itemDef.name = "Ebony helm";
				itemDef.modelZoom = 1000;
				itemDef.modelID = 100129;
				itemDef.maleEquip1 = 100130;
				itemDef.femaleEquip1 = 100130;
				break;
				
			case 23051:
				itemDef.copyItem(4712);
				itemDef.name = "Ebony body";
				itemDef.modelZoom = 1500;
				itemDef.modelID = 100131;
				itemDef.maleEquip1 = 100132;
				itemDef.femaleEquip1 = 100132;
				break;
				
			case 23052:
				itemDef.copyItem(4714);
				itemDef.name = "Ebony legs";
				itemDef.modelZoom = 1800;
				itemDef.modelID = 100133;
				itemDef.maleEquip1 = 100134;
				itemDef.femaleEquip1 = 100134;
				break;
				
			case 23053:
				itemDef.copyItem(4708);
				itemDef.name = "Ebony gloves";
				itemDef.modelID = 100135;
				itemDef.modelZoom = 1000;
				itemDef.maleEquip1 = 100136;
				itemDef.femaleEquip1 = 100136;
				break;
				
			case 23054:
				itemDef.copyItem(20456);
				itemDef.name = "Ebony boots";
				itemDef.modelID = 100137;
				itemDef.maleEquip1 = 100137;
				itemDef.femaleEquip1 = 100137;
				break;
				
			case 23055:
				itemDef.copyItem(4710);
				itemDef.name = "Ebony sword";
				itemDef.modelZoom = 2000;
				itemDef.rotationX = 1024;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelID = 100138;
				itemDef.maleEquip1 = 100139;
				itemDef.femaleEquip1 = 100139;
				break;
				
			case 23056:
				itemDef.copyItem(4710);
				itemDef.name = "Ebony shield";
				itemDef.modelID = 100140;
				itemDef.maleEquip1 = 100141;
				itemDef.femaleEquip1 = 100141;
				break;
				
			case 23057:
				itemDef.copyItem(1);
				itemDef.name = "$10 Bond";
				itemDef.actions = new String[]{"Claim", null, null, null, "Drop"};
				itemDef.modelID = 100148;
				itemDef.rotationX = 0;
				itemDef.modelZoom = 2500;
				break;
				
			case 23257:
				itemDef.copyItem(1);
				itemDef.name = "Nephilim Token";
				itemDef.actions = new String[]{"Claim", null, null, null, "Drop"};
				itemDef.modelID = 18536;
				itemDef.rotationX = 0;
				itemDef.modelZoom = 700;
				break;
				
			case 23058:
				itemDef.copyItem(23057);
				itemDef.name = "$25 Bond";
				itemDef.modelID = 100149;
				break;
				
			case 23059:
				itemDef.copyItem(23057);
				itemDef.name = "$100 Bond";
				itemDef.modelID = 100150;
				break;
				
			case 23060:
				itemDef.copyItem(23057);
				itemDef.name = "$250 Bond";
				itemDef.modelID = 100151;
				break;
				
			case 23210:
				itemDef.copyItem(4708);
				itemDef.name = "test helm";
				itemDef.modelZoom = 900;
				itemDef.modelID = 15581;
				itemDef.maleEquip1 = 15583;
				itemDef.femaleEquip1 = 15583;
				break;
				
			case 23211:
				itemDef.copyItem(4714);
				itemDef.name = "test body";
				itemDef.modelZoom = 1500;
				itemDef.modelID = 15584;
				itemDef.maleEquip1 = 15585;
				itemDef.femaleEquip1 = 15585;
				break;
				
			case 23212:
				itemDef.copyItem(4712);
				itemDef.name = "test legs";
				itemDef.modelZoom = 1700;
				itemDef.modelID = 15660;
				itemDef.maleEquip1 = 15660;
				itemDef.femaleEquip1 = 15660;
				break;
				
			case 23213:
				itemDef.copyItem(4708);
				itemDef.name = "test gloves";
				itemDef.modelID = 15661;
				itemDef.maleEquip1 = 15662;
				itemDef.femaleEquip1 = 15662;
				itemDef.modelZoom = 700;
				break;
				
			case 23214:
				itemDef.copyItem(4708);
				itemDef.name = "test boots";
				itemDef.modelID = 15663;
				itemDef.maleEquip1 = 15663;
				itemDef.femaleEquip1 = 15663;
				itemDef.modelZoom = 700;
				break;

			case 23216:
				itemDef.copyItem(4714);
				itemDef.name = "Kyojuru body";
				itemDef.modelZoom = 1500;
				itemDef.modelID = 15676;
				itemDef.maleEquip1 = 15685;
				itemDef.femaleEquip1 = 15685;
				break;
				
			case 23217:
				itemDef.copyItem(4712);
				itemDef.name = "Kyojuru legs";
				itemDef.modelZoom = 1700;
				itemDef.modelID = 15677;
				itemDef.maleEquip1 = 15678;
				itemDef.femaleEquip1 = 15678;
				break;
				
			case 23218:
				itemDef.copyItem(4708);
				itemDef.name = "Kyojuru gloves";
				itemDef.modelID = 15679;
				itemDef.maleEquip1 = 15680;
				itemDef.femaleEquip1 = 15680;
				itemDef.modelZoom = 700;
				break;
				
			case 23219:
				itemDef.copyItem(4708);
				itemDef.name = "Kyojuru boots";
				itemDef.modelID = 15681;
				itemDef.maleEquip1 = 15681;
				itemDef.femaleEquip1 = 15681;
				itemDef.modelZoom = 700;
				break;
				
			case 23220:
				itemDef.copyItem(4708);
				itemDef.name = "Nephilim helm";
				itemDef.modelZoom = 700;
				itemDef.modelID = 18429;
				itemDef.maleEquip1 = 18446;
				itemDef.femaleEquip1 = 18446;
				itemDef.actions = new String[]{null, "Wear", "Disassemble", null, "Drop"};
				break;
				
			case 23221:
				itemDef.copyItem(4714);
				itemDef.name = "Nephilim body";
				itemDef.modelZoom = 1200;
				itemDef.modelOffsetY = 8;
				itemDef.modelID = 18461;
				itemDef.maleEquip1 = 18486;
				itemDef.femaleEquip1 = 18486;
				itemDef.actions = new String[]{null, "Wear", "Disassemble", null, "Drop"};
				break;
				
			case 23222:
				itemDef.copyItem(4712);
				itemDef.name = "Nephilim legs";
				itemDef.modelZoom = 1300;
				itemDef.modelID = 18495;
				itemDef.maleEquip1 = 18511;
				itemDef.femaleEquip1 = 18511;
				itemDef.actions = new String[]{null, "Wear", "Disassemble", null, "Drop"};
				break;
				
			case 23223:
				itemDef.copyItem(4708);
				itemDef.name = "Nephilim gloves";
				itemDef.modelID = 18512;
				itemDef.maleEquip1 = 18516;
				itemDef.femaleEquip1 = 18516;
				itemDef.modelZoom = 550;
				itemDef.actions = new String[]{null, "Wear", "Disassemble", null, "Drop"};
				break;
				
			case 23224:
				itemDef.copyItem(20456);
				itemDef.name = "Nephilim boots";
				itemDef.modelID = 18519;
				itemDef.maleEquip1 = 18519;
				itemDef.femaleEquip1 = 18519;
				itemDef.modelZoom = 700;
				itemDef.actions = new String[]{null, "Wear", "Disassemble", null, "Drop"};
				break;
				
			case 23062:
				itemDef.copyItem(4708);
				itemDef.name = "Nephilim Staff";
				itemDef.modelZoom = 2287;
				itemDef.rotationX = 2026;
				itemDef.rotationY = 635;
				itemDef.rotationZ = 26;
				itemDef.modelOffsetX = 9;
				itemDef.modelOffsetY = 10;
				itemDef.modelID = 18532;
				itemDef.maleEquip1 = 18531;
				itemDef.femaleEquip1 = 18531;
				itemDef.actions = new String[]{null, "Wear", "Disassemble", null, "Drop"};
				break;
				
			case 23061:
				itemDef.copyItem(4714);
				itemDef.name = "Nephilim bow";
				itemDef.modelZoom = 2096;
				itemDef.rotationX = 1139;
				itemDef.rotationY = 339;
				itemDef.rotationZ = 25;
				itemDef.modelOffsetX = 25;
				itemDef.modelOffsetY = 30;
				itemDef.modelID = 18530;
				itemDef.maleEquip1 = 18529;
				itemDef.femaleEquip1 = 18529;
				itemDef.actions = new String[]{null, "Wear", "Disassemble", null, "Drop"};
				break;

			case 23063:
				itemDef.copyItem(4712);
				itemDef.name = "Nephilim Sword";
				itemDef.modelZoom = 1700;
				itemDef.modelID = 18533;
				itemDef.maleEquip1 = 18534;
				itemDef.femaleEquip1 = 18534;
				itemDef.actions = new String[]{null, "Wear", "Disassemble", null, "Drop"};
				break;

			case 15870:
				itemDef.name = "Diyos Sword";
				itemDef.modelID = 19957;
				itemDef.maleEquip1 = 19957;
				itemDef.femaleEquip1 = 19957;
				itemDef.modelOffsetX = -125;
				itemDef.modelOffsetY = -4;
				itemDef.modelZoom = 2200;
				itemDef.rotationY = 448;
				itemDef.rotationZ = 96;
				itemDef.rotationX = 1261;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 15872:
				itemDef.name = "Diyos Range Sword";
				itemDef.modelID = 19942;
				itemDef.maleEquip1 = 19942;
				itemDef.femaleEquip1 = 19942;
				itemDef.modelOffsetX = -125;
				itemDef.modelOffsetY = -4;
				itemDef.modelZoom = 2200;
				itemDef.rotationY = 448;
				itemDef.rotationZ = 96;
				itemDef.rotationX = 1261;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 15874:
				itemDef.name = "Diyos Magic Sword";
				itemDef.modelID = 19757;
				itemDef.maleEquip1 = 19757;
				itemDef.femaleEquip1 = 19757;
				itemDef.modelOffsetX = -125;
				itemDef.modelOffsetY = -4;
				itemDef.modelZoom = 2200;
				itemDef.rotationY = 448;
				itemDef.rotationZ = 96;
				itemDef.rotationX = 1261;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 23064:
				itemDef.copyItem(4710);
				itemDef.name = "Avaryss blade";
				itemDef.modelZoom = 1400;
				itemDef.rotationX = 2000;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelID = 100158;
				itemDef.maleEquip1 = 100160;
				itemDef.femaleEquip1 = 100160;
				break;
				
			case 23065:
				itemDef.copyItem(4710);
				itemDef.name = "Off-hand Avaryss blade";
				itemDef.modelZoom = 1400;
				itemDef.rotationX = 490;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelID = 100158;
				itemDef.maleEquip1 = 100159;
				itemDef.femaleEquip1 = 100159;
				break;
				
			case 23066:
				itemDef.copyItem(23064);
				itemDef.name = "Nymora crossbow";
				itemDef.rotationX = 150;
				itemDef.modelID = 100161;
				itemDef.maleEquip1 = 100163;
				itemDef.femaleEquip1 = 100163;
				break;
				
			case 23067:
				itemDef.copyItem(23065);
				itemDef.name = "Off-hand Nymora crossbow";
				itemDef.rotationX = 1400;
				itemDef.modelID = 100161;
				itemDef.maleEquip1 = 100162;
				itemDef.femaleEquip1 = 100162;
				break;
				
			case 23068:
				itemDef.copyItem(669);
				itemDef.name = "Nymora wings";
				itemDef.modelZoom = 2200;
				itemDef.rotationX = 0;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelID = 100164;
				itemDef.maleEquip1 = 100165;
				itemDef.femaleEquip1 = 100165;
				break;
			case 23071:
				itemDef.copyItem(13263);
				itemDef.name = "Boss Slayer Helmet [1]";
				itemDef.modelID = 100170;
				itemDef.maleEquip1 = 100171;
				itemDef.femaleEquip1 = 100171;
				itemDef.equipOptions[1] = "Teleport";
				break;
				
			case 23069:
				itemDef.copyItem(13263);
				itemDef.name = "Boss Slayer Helmet [2]";
				itemDef.modelID = 100166;
				itemDef.maleEquip1 = 100167;
				itemDef.femaleEquip1 = 100167;
				itemDef.equipOptions[1] = "Teleport";
				break;
				
			case 23070:
				itemDef.copyItem(13263);
				itemDef.name = "Boss Slayer Helmet [3]";
				itemDef.modelID = 100168;
				itemDef.maleEquip1 = 100169;
				itemDef.femaleEquip1 = 100169;
				itemDef.equipOptions[1] = "Teleport";
				break;
				
			case 23074:
				itemDef.copyItem(13263);
				itemDef.name = "Boss Slayer Helmet [4]";
				itemDef.modelID = 100176;
				itemDef.equipOptions[1] = "Teleport";
				itemDef.maleEquip1 = 100177;
				itemDef.femaleEquip1 = 100177;
				itemDef.equipOptions[1] = "Teleport";
				break;
				
			case 23072:
				itemDef.copyItem(13263);
				itemDef.name = "Boss Slayer Helmet [5]";
				itemDef.modelID = 100172;
				itemDef.maleEquip1 = 100173;
				itemDef.femaleEquip1 = 100173;
				itemDef.equipOptions[1] = "Teleport";
				break;
				
			case 23073:
				itemDef.copyItem(13263);
				itemDef.name = "Boss Slayer Helmet [6]";
				itemDef.modelID = 100174;
				itemDef.maleEquip1 = 100175;
				itemDef.femaleEquip1 = 100175;
				itemDef.equipOptions[1] = "Teleport";
				break;
				
			case 23075:
				itemDef.copyItem(13263);
				itemDef.name = "Vindicta helm";
				itemDef.modelID = 100178;
				itemDef.maleEquip1 = 100179;
				itemDef.femaleEquip1 = 100179;
				break;
				
			case 23076:
				itemDef.copyItem(4712);
				itemDef.name = "Vindicta body";
				itemDef.modelZoom = 1500;
				itemDef.modelID = 100180;
				itemDef.maleEquip1 = 100181;
				itemDef.femaleEquip1 = 100181;
				break;
				
			case 23077:
				itemDef.copyItem(4714);
				itemDef.name = "Vindicta legs";
				itemDef.modelZoom = 1800;
				itemDef.modelID = 100182;
				itemDef.maleEquip1 = 100183;
				itemDef.femaleEquip1 = 100183;
				break;
				
			case 23078:
				itemDef.copyItem(4710);
				itemDef.name = "Vitatlity lance";
				itemDef.modelZoom = 2700;
				itemDef.rotationX = 1200;
				itemDef.rotationY = 400;
				itemDef.modelOffsetX = -20;
				itemDef.modelOffsetY = -20;
				itemDef.modelID = 100184;
				itemDef.maleEquip1 = 100185;
				itemDef.femaleEquip1 = 100185;
				break;
				
			case 23079:
				itemDef.copyItem(4710);
				itemDef.name = "Vindicta sword";
				itemDef.modelZoom = 2400;
				itemDef.rotationX = 1200;
				itemDef.rotationY = 520;
				itemDef.modelOffsetX = -10;
				itemDef.modelOffsetY = -10;
				itemDef.modelID = 100186;
				itemDef.maleEquip1 = 100187;
				itemDef.femaleEquip1 = 100187;
				break;
				
			case 23080:
				itemDef.copyItem(4710);
				itemDef.name = "Off-hand Vindicta sword";
				itemDef.modelZoom = 2400;
				itemDef.rotationX = 200;
				itemDef.rotationY = 520;
				itemDef.modelOffsetX = 10;
				itemDef.modelOffsetY = 10;
				itemDef.modelID = 100186;
				itemDef.maleEquip1 = 100188;
				itemDef.femaleEquip1 = 100188;
				break;
				
			case 23081:
				itemDef.copyItem(5074);
				itemDef.name = "Gorvek Pet";
				itemDef.modelID = 100190;
				itemDef.modelZoom = 3500;
				itemDef.rotationY = 400;
				itemDef.rotationX = 210;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23082:
				itemDef.copyItem(5074);
				itemDef.name = "Vindicta Pet";
				itemDef.modelID = 100192;
				itemDef.modelZoom = 1500;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23083:
				itemDef.copyItem(5074);
				itemDef.name = "Avaryss Pet";
				itemDef.modelID = 100143;
				itemDef.modelZoom = 2700;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23084:
				itemDef.copyItem(5074);
				itemDef.name = "Conjkoined Pet";
				itemDef.modelID = 100145;
				itemDef.modelZoom = 2700;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23085:
				itemDef.copyItem(5074);
				itemDef.name = "Nymora Pet";
				itemDef.modelID = 100147;
				itemDef.modelZoom = 2700;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;

			case 23086:
				itemDef.copyItem(3849);
				itemDef.name = "Isles Chest";
				itemDef.actions = new String[]{"Open", null, null, null, "Drop"};
				itemDef.modelID = 100201;
				itemDef.modelOffsetX = itemDef.modelOffsetX;
				itemDef.modelOffsetY = itemDef.modelOffsetY;
				itemDef.modelZoom = 3000;
				itemDef.rotationY = itemDef.rotationY;
				itemDef.rotationX = itemDef.rotationX;
				break;

			case 23237:
				itemDef.copyItem(3849);
				itemDef.name = "Crpytic Chest";
				itemDef.actions = new String[]{"Open", null, null, null, "Drop"};
				itemDef.modelID = 14941;
				itemDef.modelOffsetX = itemDef.modelOffsetX;
				itemDef.modelOffsetY = itemDef.modelOffsetY;
				itemDef.modelZoom = 3000;
				itemDef.rotationY = itemDef.rotationY;
				itemDef.rotationX = itemDef.rotationX;
				itemDef.rdc2 = 195533;
				break;
				
				
			case 23087:
				itemDef.copyItem(6585);
				itemDef.name = "Collectors necklace";
				itemDef.modelID = 100203;
				itemDef.maleEquip1 = 100204;
				itemDef.femaleEquip1 = 100204;
				itemDef.modelZoom = 800;
				itemDef.rotationX = 0;
				itemDef.rotationY = 350;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 15;
				break;
				
			case 23088:
				itemDef.copyItem(23087);
				itemDef.name = "Green Valor Amulet";
				itemDef.modelID = 100205;
				itemDef.maleEquip1 = 100206;
				itemDef.femaleEquip1 = 100206;
				break;
				
			case 23089:
				itemDef.copyItem(23087);
				itemDef.name = "Starter amulet";
				itemDef.modelID = 100207;
				itemDef.maleEquip1 = 100208;
				itemDef.femaleEquip1 = 100208;
				break;
				
			case 23090:
				itemDef.copyItem(23087);
				itemDef.name = "Starter Collector";
				itemDef.modelID = 100209;
				itemDef.maleEquip1 = 100210;
				itemDef.femaleEquip1 = 100210;
				break;

			case 23091:
				itemDef.copyItem(6737);
				itemDef.name = "Starter ring";
				itemDef.modelID = 100211;
				itemDef.modelZoom = 1400;
				itemDef.rotationX = 0;
				itemDef.rotationY = 520;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23092:
				itemDef.copyItem(23091);
				itemDef.name = "Valor's wizard ring";
				itemDef.modelID = 100212;
				break;
				
			case 23093:
				itemDef.copyItem(23091);
				itemDef.name = "Valor's archer ring";
				itemDef.modelID = 100213;
				break;
				
			case 23094:
				itemDef.copyItem(23091);
				itemDef.name = "Valor's warrior ring";
				itemDef.modelID = 100214;
				break;
				
			case 9719:
				itemDef.name = "Slayer skip scroll";
				break;

			case 12852:
				itemDef.name = "Vault token";
				break;
			case 23367:
				itemDef.copyItem(14808);
				itemDef.name = "Magician pet scroll";
				itemDef.rdc2 = 67606;
				break;

			case 23386:
				itemDef.copyItem(14808);
				itemDef.name = "Warrior pet scroll";
				itemDef.rdc2 = 77606;
				break;

			case 23409:
				itemDef.copyItem(14808);
				itemDef.name = "Archers pet scroll";
				itemDef.rdc2 = 44226;
				break;
			case 23427:
				itemDef.copyItem(14808);
				itemDef.name = "Supreme unlock scroll";
				itemDef.rdc2 = 388238;
				break;

			case 17474:
				itemDef.name = "Supreme essence";
				break;

			case 23095:
				itemDef.copyItem(2902);
				itemDef.name = "Mercenary gloves";
				itemDef.modelID = 100215;
				itemDef.maleEquip1 = 100216;
				itemDef.femaleEquip1 = 100216;
				itemDef.modelZoom = 750;
				itemDef.rotationX = 0;
				itemDef.rotationY = 520;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23096:
				itemDef.copyItem(23095);
				itemDef.name = "Wizard gloves";
				itemDef.modelID = 100217;
				itemDef.maleEquip1 = 100218;
				itemDef.femaleEquip1 = 100218;
				break;
				
			case 23097:
				itemDef.copyItem(23095);
				itemDef.name = "Warrior gloves";
				itemDef.modelID = 100219;
				itemDef.maleEquip1 = 100220;
				itemDef.femaleEquip1 = 100220;
				break;
				
			case 23098:
				itemDef.copyItem(23095);
				itemDef.name = "Archer gloves";
				itemDef.modelID = 100221;
				itemDef.maleEquip1 = 100222;
				itemDef.femaleEquip1 = 1002222;
				break;

			case 23099:
				itemDef.copyItem(2902);
				itemDef.name = "Bork gauntlets";
				itemDef.modelID = 19549;
				itemDef.maleEquip1 = 19550;
				itemDef.femaleEquip1 = 19550;
				itemDef.modelZoom = 700;
				itemDef.rotationX = 0;
				itemDef.rotationY = 520;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

				
			case 23100:
				itemDef.copyItem(23099);
				itemDef.name = "War gauntlets (T2)";
				itemDef.modelID = 100225;
				itemDef.maleEquip1 = 100226;
				itemDef.femaleEquip1 = 100226;
				break;
				
			case 23101:
				itemDef.copyItem(23099);
				itemDef.name = "War gauntlets (T3)";
				itemDef.modelID = 100227;
				itemDef.maleEquip1 = 100228;
				itemDef.femaleEquip1 = 100228;
				break;
				
			case 23102:
				itemDef.copyItem(23099);
				itemDef.name = "War gauntlets (T4)";
				itemDef.modelID = 100229;
				itemDef.maleEquip1 = 100230;
				itemDef.femaleEquip1 = 1002230;
				break;

			case 23103:
				itemDef.copyItem(1);
				itemDef.name = "Treasure Key 1";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 100231;
				itemDef.rotationX = 0;
				itemDef.rotationY = 520;
				itemDef.modelZoom = 800;
				break;
				
			case 23104:
				itemDef.copyItem(23103);
				itemDef.name = "Treasure Key 2";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 100232;
				break;
				
			case 23105:
				itemDef.copyItem(23103);
				itemDef.name = "Treasure Key 3";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 100233;
				break;
				
			case 23106:
				itemDef.copyItem(23103);
				itemDef.name = "Treasure Key 4";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 100234;
				break;
				
			case 23107:
				itemDef.copyItem(23103);
				itemDef.name = "Master Treasure Key";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.modelID = 100235;
				itemDef.modelZoom = 400;
				break;

			case 23381:
				itemDef.copyItem(5074);
				itemDef.name = "Bork Pet";
				itemDef.modelID = 19542;
				itemDef.modelZoom = 5800;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;

			case 23108:
				itemDef.copyItem(5074);
				itemDef.name = "Fenrir Pet";
				itemDef.modelID = 100196;
				itemDef.modelZoom = 2700;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23109:
				itemDef.copyItem(5074);
				itemDef.name = "Green Fenrir Pet";
				itemDef.modelID = 100197;
				itemDef.modelZoom = 2700;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23110:
				itemDef.copyItem(5074);
				itemDef.name = "Red Fenrir Pet";
				itemDef.modelID = 100198;
				itemDef.modelZoom = 2700;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23111:
				itemDef.copyItem(5074);
				itemDef.name = "Odin Pet";
				itemDef.modelID = 100199;
				itemDef.modelZoom = 3500;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23112:
				itemDef.copyItem(5074);
				itemDef.name = "Heimdall Pet";
				itemDef.modelID = 100200;
				itemDef.modelZoom = 3500;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;

			case 23113:
				itemDef.copyItem(5074);
				itemDef.name = "Demon Pet";
				itemDef.modelID = 100076;
				itemDef.modelZoom = 5000;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23114:
				itemDef.copyItem(5074);
				itemDef.name = "Kil'jaeden Pet";
				itemDef.modelID = 100077;
				itemDef.modelZoom = 5500;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23115:
				itemDef.copyItem(5074);
				itemDef.name = "Skreeg Pet";
				itemDef.modelID = 100078;
				itemDef.modelZoom = 5000;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23116:
				itemDef.copyItem(5074);
				itemDef.name = "Orix Pet";
				itemDef.modelID = 100079;
				itemDef.modelZoom = 5000;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23117:
				itemDef.copyItem(5074);
				itemDef.name = "Crystal orc Pet";
				itemDef.modelID = 100080;
				itemDef.modelZoom = 5500;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;

			case 23118:
				itemDef.copyItem(2436);
				itemDef.name = "Infinite healing potion (T1)";
				itemDef.modelID = 100250;
				itemDef.modelZoom = 1000;
				break;
			case 23119:
				itemDef.copyItem(23118);
				itemDef.name = "Infinite healing potion (T2)";
				itemDef.modelID = 100251;
				break;
			case 23120:
				itemDef.copyItem(23118);
				itemDef.name = "Infinite healing potion (T3)";
				itemDef.modelID = 100252;
				break;
			case 23121:
				itemDef.copyItem(23118);
				itemDef.name = "Infinite prayer potion (T1)";
				itemDef.modelID = 100253;
				break;
			case 23122:
				itemDef.copyItem(23118);
				itemDef.name = "Infinite prayer potion (T2)";
				itemDef.modelID = 100254;
				break;
			case 23123:
				itemDef.copyItem(23118);
				itemDef.name = "Infinite prayer potion (T3)";
				itemDef.modelID = 100255;
				break;
			case 23124:
				itemDef.copyItem(23118);
				itemDef.name = "Infinite overload potion (T1)";
				itemDef.modelID = 100256;
				break;
			case 23125:
				itemDef.copyItem(23118);
				itemDef.name = "Infinite overload potion (T2)";
				itemDef.modelID = 100257;
				break;
			case 23126:
				itemDef.copyItem(23118);
				itemDef.name = "Infinite overload potion (T3)";
				itemDef.modelID = 100258;
				break;

			case 23127:
				itemDef.copyItem(4708);
				itemDef.name = "Creator's helm";
				itemDef.modelID = 100264;
				itemDef.maleEquip1 = 100265;
				itemDef.femaleEquip1 = 100265;
				itemDef.modelZoom = 800;
				break;
				
			case 23128:
				itemDef.copyItem(4712);
				itemDef.name = "Creator's body";
				itemDef.modelID = 100259;
				itemDef.maleEquip1 = 100260;
				itemDef.femaleEquip1 = 100260;
				itemDef.modelZoom = 1500;
				break;
				
			case 23129:
				itemDef.copyItem(4714);
				itemDef.name = "Creator's legs";
				itemDef.modelID = 100266;
				itemDef.maleEquip1 = 100267;
				itemDef.femaleEquip1 = 100267;
				itemDef.modelZoom = 1800;
				break;
				
			case 23130:
				itemDef.copyItem(4708);
				itemDef.name = "Creator's gloves";
				itemDef.modelID = 100262;
				itemDef.maleEquip1 = 100263;
				itemDef.femaleEquip1 = 100263;
				itemDef.modelZoom = 700;
				break;
				
			case 23131:
				itemDef.copyItem(20456);
				itemDef.name = "Creator's boots";
				itemDef.modelID = 100261;
				itemDef.maleEquip1 = 100261;
				itemDef.femaleEquip1 = 100261;
				itemDef.modelZoom = 700;
				break;
				
			case 23132:
				itemDef.copyItem(4710);
				itemDef.name = "Creator's scythe";
				itemDef.modelID = 100268;
				itemDef.maleEquip1 = 100269;
				itemDef.femaleEquip1 = 100269;
				itemDef.modelZoom = 3000;
				itemDef.rotationX = 1024;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = -5;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = -5;
				break;
				
			case 23133:
				itemDef.copyItem(669);
				itemDef.name = "Legends wings";
				itemDef.modelID = 100270;
				itemDef.maleEquip1 = 100271;
				itemDef.femaleEquip1 = 100271;
				itemDef.modelZoom = 2300;
				itemDef.rotationX = 1050;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 25;
				break;
				
			case 23139:
				itemDef.copyItem(4708);
				itemDef.name = "Ruthless helm";
				itemDef.modelID = 100323;
				itemDef.maleEquip1 = 100324;
				itemDef.femaleEquip1 = 100324;
				itemDef.modelZoom = 900;
				break;
				
			case 23140:
				itemDef.copyItem(4712);
				itemDef.name = "Ruthless body";
				itemDef.modelID = 100325;
				itemDef.maleEquip1 = 100326;
				itemDef.femaleEquip1 = 100326;
				itemDef.modelZoom = 1500;
				break;
				
			case 23141:
				itemDef.copyItem(4714);
				itemDef.name = "Ruthless legs";
				itemDef.modelID = 100327;
				itemDef.maleEquip1 = 100328;
				itemDef.femaleEquip1 = 100328;
				itemDef.modelZoom = 1800;
				break;
				
			case 23142:
				itemDef.copyItem(4708);
				itemDef.name = "Ruthless gloves";
				itemDef.modelID = 100287;
				itemDef.maleEquip1 = 100288;
				itemDef.femaleEquip1 = 100288;
				itemDef.modelZoom = 700;
				break;
				
			case 23143:
				itemDef.copyItem(20456);
				itemDef.name = "Ruthless boots";
				itemDef.modelID = 100286;
				itemDef.maleEquip1 = 100286;
				itemDef.femaleEquip1 = 100286;
				itemDef.modelZoom = 700;
				break;
				
			case 23144:
				itemDef.copyItem(4710);
				itemDef.name = "Ruthless bow";
				itemDef.modelID = 100295;
				itemDef.maleEquip1 = 100296;
				itemDef.femaleEquip1 = 100296;
				itemDef.modelZoom = 2300;
				itemDef.rotationX = 1100;
				itemDef.rotationY = 450;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23145:
				itemDef.copyItem(4710);
				itemDef.name = "Ruthless staff";
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
				
			case 23146:
				itemDef.copyItem(4710);
				itemDef.name = "Ruthless sword";
				itemDef.modelID = 100299;
				itemDef.maleEquip1 = 100300;
				itemDef.femaleEquip1 = 100300;
				itemDef.modelZoom = 1500;
				itemDef.rotationX = 1100;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				break;

			case 23147:
				itemDef.copyItem(1505);
				itemDef.name = "Melee attachement";
				itemDef.modelID = 100301;
				itemDef.modelZoom = 1500;
				itemDef.actions = new String[]{null, null, null, null, null};
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.rotationZ = 0;
				break;
				
			case 23148:
				itemDef.copyItem(23147);
				itemDef.name = "Magic attachement";
				itemDef.modelID = 100302;
				itemDef.modelZoom = 1600;
				break;
				
			case 23149:
				itemDef.copyItem(23147);
				itemDef.name = "Ranged attachement";
				itemDef.modelID = 100303;
				itemDef.modelZoom = 1600;
				break;

			case 995:
				itemDef.actions = new String[5];
				itemDef.actions[2] = "@gre@Convert to Tokens";
				break;
			case 13066:
				itemDef.name = "<img=1663> @yel@Treasure Casket <img=1663>          ";
				break;
				
			case 23150:
				itemDef.copyItem(669);
				itemDef.name = "Flat cape";
				itemDef.modelID = 100304;
				itemDef.maleEquip1 = 100304;
				itemDef.femaleEquip1 = 100304;
				itemDef.modelZoom = 2300;
				itemDef.rotationX = 1050;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 25;
				break;

			case 23151:
				itemDef.copyItem(5074);
				itemDef.name = "Demon of Light Pet";
				itemDef.modelID = 100281;
				itemDef.modelZoom = 1500;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.scaleX = 32;
				itemDef.scaleY = 32;
				itemDef.scaleZ = 32;
				break;
				
			case 23152:
				itemDef.copyItem(23151);
				itemDef.name = "Bat of Light Pet";
				itemDef.modelID = 100282;
				itemDef.modelZoom = 1500;
				itemDef.scaleX = 8;
				itemDef.scaleY = 8;
				itemDef.scaleZ = 8;
				itemDef.rotationY = 300;
				itemDef.rotationX = 300;
				break;
				
			case 23153:
				itemDef.copyItem(23151);
				itemDef.name = "Goblin of Light Pet";
				itemDef.modelID = 100283;
				itemDef.scaleX = 8;
				itemDef.scaleY = 8;
				itemDef.scaleZ = 8;
				itemDef.modelZoom = 1500;
				break;
				
			case 23154:
				itemDef.copyItem(23151);
				itemDef.name = "Lava hound Pet";
				itemDef.modelID = 100306;
				itemDef.modelZoom = 700;
				itemDef.rotationX = 200;
				break;
				
			case 23155:
				itemDef.copyItem(23151);
				itemDef.name = "Mutated hound Pet";
				itemDef.modelID = 100305;
				itemDef.modelZoom = 1600;
				break;

			case 23156:
				itemDef.copyItem(23151);
				itemDef.name = "Scorpion Pet";
				itemDef.modelID = 100313;
				itemDef.rotationX = 0;
				itemDef.rotationY = 300;
				itemDef.modelZoom = 1000;
				break;
				
			case 23157:
				itemDef.copyItem(23151);
				itemDef.name = "Zombie Pet";
				itemDef.modelID = 100314;
				itemDef.modelZoom = 800;
				break;

			case 23158:
				itemDef.copyItem(669);
				itemDef.name = "Magic max cape";
				itemDef.modelID = 100307;
				itemDef.maleEquip1 = 100308;
				itemDef.femaleEquip1 = 100308;
				itemDef.modelZoom = 1800;
				itemDef.rotationX = 0;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23159:
				itemDef.copyItem(669);
				itemDef.name = "Melee max cape";
				itemDef.modelID = 100309;
				itemDef.maleEquip1 = 100310;
				itemDef.femaleEquip1 = 100310;
				itemDef.modelZoom = 1800;
				itemDef.rotationX = 0;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23160:
				itemDef.copyItem(669);
				itemDef.name = "Ranged max cape";
				itemDef.modelID = 100311;
				itemDef.maleEquip1 = 100312;
				itemDef.femaleEquip1 = 100312;
				itemDef.modelZoom = 2500;
				itemDef.rotationX = 0;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				break;

			case 23161:
				itemDef.copyItem(5074);
				itemDef.name = "Demon Pet";
				itemDef.modelID = 100237;
				itemDef.modelZoom = 5500;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23162:
				itemDef.copyItem(5074);
				itemDef.name = "Dragon Pet";
				itemDef.modelID = 100238;
				itemDef.modelZoom = 4200;
				itemDef.rotationY = 520;
				itemDef.rotationX = 250;
				itemDef.scaleX = 32;
				itemDef.scaleY = 32;
				itemDef.scaleZ = 32;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23163:
				itemDef.copyItem(5074);
				itemDef.name = "Golem Pet";
				itemDef.modelID = 100239;
				itemDef.modelZoom = 5000;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23164:
				itemDef.copyItem(5074);
				itemDef.name = "Rammus Pet";
				itemDef.modelID = 100240;
				itemDef.modelZoom = 4500;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				break;

			case 23165:
				itemDef.copyItem(1505);
				itemDef.name = "Hunter's Eye prayer scroll";
				itemDef.modelID = 100318;
				itemDef.actions = new String[]{"Claim", null, null, null, null};
				itemDef.modelZoom = 2600;
				itemDef.rotationX = 1534;
				itemDef.rotationY = 554;
				itemDef.modelOffsetX = -4;
				itemDef.modelOffsetY = 0;
				break;
				
			case 23166:
				itemDef.copyItem(23165);
				itemDef.name = "Fury's Swipe prayer scroll";
				itemDef.modelID = 100316;
				break;
				
			case 23167:
				itemDef.copyItem(23165);
				itemDef.name = "Destruction prayer scroll";
				itemDef.modelID = 100317;
				break;
				
			case 23168:
				itemDef.copyItem(23165);
				itemDef.name = "Blurr prayer scroll";
				itemDef.modelID = 100319;
				break;
				
			case 23169:
				itemDef.copyItem(23165);
				itemDef.name = "Coup de grace prayer scroll";
				itemDef.modelID = 100320;
				break;
				
			case 23170:
				itemDef.copyItem(23165);
				itemDef.name = "Gnome greed prayer scroll";
				itemDef.modelID = 100315;
				break;

			case 2734:
				itemDef.name = "Slayer casket";
				itemDef.rdc2 = 847;
				break;
				
			case 23174:
				itemDef.copyItem(2996);
				itemDef.name = "Premium ticket";
				itemDef.rdc3 = 6626262;
				itemDef.actions = new String[5];
				break;

			case 23175:
				itemDef.copyItem(6889);
				itemDef.name = "Vindicta book";
				itemDef.rdc2 = 54666;//15888 - 45366
				break;

			case 23176:
				itemDef.copyItem(669);
				itemDef.name = "Master max cape";
				itemDef.modelID = 100321;
				itemDef.maleEquip1 = 100322;
				itemDef.femaleEquip1 = 100322;
				itemDef.modelZoom = 1900;
				itemDef.rotationX = 0;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				break;

			case 23177:
				itemDef.copyItem(290);
				itemDef.name = "Starter box";
				itemDef.rdc2 = 3455;//15888 - 45366
				break;
				
			case 19336:
			case 19337:
			case 19338:
			case 19339:
			case 19340:
				itemDef.rdc2 = 814488;
				break;
				
			case 7394:
			case 10689:
				itemDef.rdc2 = 2299;
				break;
				
			case 21372:
				itemDef.rdc2 = 24929;
				break;
				
			case 21373:
				itemDef.rdc2 = 10843;
				break;
				
			case 21374:
				itemDef.rdc2 = 88753;
				break;
				
			case 13887:
			case 13905:
			case 13867:
			case 15877:
			case 15922:
			case 15933:
			case 16021:
			case 8816:
			case 8817:
			case 8818:
			case 18356:
			case 12931:
			case 15511:
			case 1149:
			case 1249:
			case 3204:
			case 1305:
			case 1215:
			case 1377:
			case 1434:
			case 7158:
				break;

			case 19776:
				itemDef.name = "Bork boots";
				itemDef.modelID = 19551;itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 17043:
				itemDef.name = "Leafy coif";
				itemDef.modelOffsetX = -0;
				itemDef.modelOffsetY = -0;
				itemDef.modelZoom = 750;
				itemDef.modelID = 96120;
				itemDef.maleEquip1 = 96121;
				itemDef.femaleEquip1 = 96121;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 18332:
				itemDef.name = "Leafy Longbow";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 13591:
				itemDef.name = "Raids [1] Key";
				itemDef.stackable = true;
				itemDef.actions = new String[]{null, null, null, null, null};
				break;
				
			case 3578:
				itemDef.name = "<col=FF0000><shad=0>Owner's Cape Goodiebag";
				break;
			case 23240:
				itemDef.copyItem(3578);
				itemDef.name = "Owner Jewelry Goodiebag";
				break;
			case 23446:
				itemDef.copyItem(3578);
				itemDef.name = "Elite Goodiebag";
				break;


			case 23414:
				itemDef.copyItem(290);
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.modelID = 19609;
				itemDef.modelZoom = 2650;
				itemDef.name = "WreckedYou's Creator Box";
				break;

			case 23415:
				itemDef.copyItem(290);
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.modelID = 19611;
				itemDef.modelZoom = 2650;
				itemDef.name = "Inherited's Creator Box";
				break;
			case 23416:
				itemDef.copyItem(290);
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.modelID = 19613;
				itemDef.modelZoom = 2650;
				itemDef.name = "Celestial's Creator Box";
				break;
			case 23417:
				itemDef.copyItem(290);
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{126};
				itemDef.modelID = 19612;
				itemDef.modelZoom = 2650;
				itemDef.name = "Walkchaos' Creator Box";
				break;

			case 23425:
				itemDef.copyItem(290);
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{126};
				itemDef.modelID = 19612;
				itemDef.modelZoom = 2650;
				itemDef.name = "Lano's Creator Box";
				break;

			case 17175:
				itemDef.name = "Leafy body";
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelID = 96122;
				itemDef.maleEquip1 = 96123;
				itemDef.femaleEquip1 = 96123;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 17321:
				itemDef.name = "Leafy chaps";
				itemDef.modelID = 96124;
				itemDef.maleEquip1 = 96125;
				itemDef.femaleEquip1 = 96125;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 10696:
				itemDef.name = "Leafy boots";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 15026:
				itemDef.name = "Leafy gloves";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 14733:
				itemDef.name = "Chilling helmet";
				itemDef.modelOffsetX = -0;
				itemDef.modelOffsetY = -0;
				itemDef.modelZoom = 750;
				itemDef.modelID = 99929;
				itemDef.maleEquip1 = 99930;
				itemDef.femaleEquip1 = 99930;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 14732:
				itemDef.name = "Chilling Body";
				itemDef.modelOffsetX = -0;
				itemDef.modelOffsetY = -0;
				itemDef.modelZoom = 1400;
				itemDef.modelID = 99931;
				itemDef.maleEquip1 = 99932;
				itemDef.femaleEquip1 = 99932;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 14734:
				itemDef.modelID = 99933;
				itemDef.maleEquip1 = 99934;
				itemDef.femaleEquip1 = 99934;
				itemDef.modelOffsetX = -0;
				itemDef.modelOffsetY = -0;
				itemDef.modelZoom = 1550;
				itemDef.name = "Chilling legs";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 14377:
				itemDef.name = "Chilling Staff";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 10865:
				itemDef.modelID = 99926;
				itemDef.maleEquip1 = 99926;
				itemDef.femaleEquip1 = 99926;
				itemDef.name = "Chilling boots";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 12864:
				itemDef.modelID = 99927;
				itemDef.maleEquip1 = 99928;
				itemDef.femaleEquip1 = 99928;
				itemDef.name = "Chilling gloves";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 4367:
				itemDef.name = "Art's cape";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.modelID = 65333;
				itemDef.maleEquip1 = 65334;
				itemDef.femaleEquip1 = 65334;
				itemDef.oldColors = new int[]{59};
				itemDef.newColors = new int[]{66};
				itemDef.rdc2 = 762432;
				itemDef.modelZoom = 1385;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 24;
				itemDef.rotationY = 279;
				itemDef.rotationX = 948;
				break;
				
			case 7996:
				itemDef.name = "robin's cape";
				itemDef.modelID = 64365;
				itemDef.maleEquip1 = 64366;
				itemDef.femaleEquip1 = 64366;
				itemdefedit = ItemDefinition.get(2414);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 10946:
				itemDef.name = "$1 Scroll";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop";
				itemDef.actions[0] = "Claim";
				itemDef.actions[2] = "Claim-All";
				itemdefedit = ItemDefinition.get(761);
				itemDef.modelID = itemdefedit.modelID;
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelZoom = 1300;
				break;
				
			case 7997:
				itemDef.name = "Exciter Cape";
				itemDef.modelID = 64367;
				itemDef.maleEquip1 = 64368;
				itemDef.femaleEquip1 = 64368;
				itemdefedit = ItemDefinition.get(2414);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{95};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 7995:
				itemDef.name = "Owner's cape";
				itemDef.modelID = 65448;
				itemDef.maleEquip1 = 65449;
				itemDef.femaleEquip1 = 65449;
				itemdefedit = ItemDefinition.get(2414);
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.oldColors = new int[]{57};
				itemDef.newColors = new int[]{52};
				break;
				
			case 11000:
				itemDef.name = "@red@Owner's Attachment";
				itemDef.modelID = 65448;
				itemDef.maleEquip1 = 65449;
				itemDef.femaleEquip1 = 65449;
				itemdefedit = ItemDefinition.get(2414);
				itemDef.actions = itemdefedit.actions;
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1000;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				break;
				
			case 5594:
				itemDef.name = "Katherine's cape";
				itemDef.modelID = 64315;
				itemdefedit = ItemDefinition.get(6570);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 65447;
				itemDef.maleEquip1 = 65446;
				itemDef.femaleEquip1 = 65446;
				itemDef.actions = itemdefedit.actions;
				itemDef.newColors = new int[2]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[2]; // same here
				itemDef.oldColors[0] = 54;
				itemDef.newColors[0] = 88;
				itemDef.oldColors[1] = 65;
				itemDef.newColors[1] = 88;
				itemDef.stackable = false;
				itemDef.value = 1;
				break;
				
			case 15219:
				itemDef.name = "Del's cape";
				itemDef.modelID = 65333;
				itemDef.maleEquip1 = 65334;
				itemDef.femaleEquip1 = 65334;
				itemDef.oldColors = new int[]{57};
				itemDef.newColors = new int[]{78};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 36232;
				itemDef.modelZoom = 1385;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 24;
				itemDef.rotationY = 279;
				itemDef.rotationX = 948;
				break;
				
			case 20591:
				itemDef.copyItem(4363);
				itemDef.name = "Rage Cape";
				itemDef.modelID = 65333;
				itemDef.maleEquip1 = 65334;
				itemDef.femaleEquip1 = 65334;
				itemDef.modelZoom = 1700;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 29295;
				itemDef.rotationX = 200;
				break;
				
			case 11320:
				itemDef.name = "Dragon Rider helm";
				itemDef.modelID = 15723;
				itemDef.maleEquip1 = 15747;
				itemDef.femaleEquip1 = 99852;
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{52};
				break;
				
			case 11321:
				itemDef.name = "Dragon Rider body";
				itemDef.modelID = 15773;
				itemDef.maleEquip1 = 15785;
				itemDef.femaleEquip1 = 15785;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{52};
				break;
				
			case 11322:
				itemDef.name = "Dragon Rider legs";
				itemDef.modelID = 15787;
				itemDef.maleEquip1 = 15814;
				itemDef.femaleEquip1 = 15814;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{52};
				break;
				
			case 18819:
				itemDef.name = "<shad=1><col=FF0000>Infinity Slayer Ring";
				itemdefedit = ItemDefinition.get(13281);
				itemDef.actions = itemdefedit.actions;
				break;
				
			case 21221:
				ItemDefinition itemdefyogipic100 = ItemDefinition.get(290);
				itemDef.modelOffsetX = itemdefyogipic100.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic100.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic100.modelZoom;
				itemDef.rotationY = itemdefyogipic100.rotationY;
				itemDef.rotationX = itemdefyogipic100.rotationX;
				itemDef.name = "Cash box";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.modelID = 65284;
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{64};
				itemDef.animateInventory = true;
				break;
				
			case 21222:		
				ItemDefinition itemdefyogipic1001 = ItemDefinition.get(290);
				itemDef.modelOffsetX = itemdefyogipic1001.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1001.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1001.modelZoom;
				itemDef.rotationY = itemdefyogipic1001.rotationY;
				itemDef.rotationX = itemdefyogipic1001.rotationX;
				itemDef.name = "Cash box (t2)";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.modelID = 65284;
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{88};
				itemDef.animateInventory = true;
				break;
				
			case 22121:
				itemDef.name = "@yel@Golden Scratch Card";
				itemdefedit = ItemDefinition.get(455);
				itemDef.actions = new String[]{"Scratch", null, null, null, "Drop"};
				itemDef.modelID = 100053;
				itemDef.modelZoom = 1171;
				itemDef.rotationX = 322;
				itemDef.rotationY = 525;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 4;
				itemDef.modelOffsetY = -3;
				break;
				
			case 11421:
				itemDef.copyItem(18753);
				itemDef.modelZoom = 1000;
				itemDef.name = "Purifier helm";
				itemDef.modelID = 15715;
				itemDef.maleEquip1 = 15716;
				itemDef.femaleEquip1 = 15716;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{51};
				break;
				
			case 11422:
				itemDef.copyItem(18752);
				itemDef.name = "Purifier body";
				itemDef.modelID = 15719;
				itemDef.maleEquip1 = 15720;
				itemDef.femaleEquip1 = 15720;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{51};
				break;
				
			case 11423:
				itemDef.copyItem(18751);
				itemDef.name = "Purifier legs";
				itemDef.modelID = 15717;
				itemDef.maleEquip1 = 15718;
				itemDef.femaleEquip1 = 15718;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{51};
				break;
				
			case 11340:
				itemDef.name = "Judicator helm";
				itemDef.modelID = 15840;
				itemDef.maleEquip1 = 15841;
				itemDef.femaleEquip1 = 15841;
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 19738;
				break;

			case 11341:
				itemDef.name = "Judicator body";
				itemDef.modelID = 15865;
				itemDef.maleEquip1 = 16060; 
				itemDef.femaleEquip1 = 16060;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 19738;
				break;
				
			case 11342:
				itemDef.name = "Judicator legs";
				itemDef.modelID = 15863;
				itemDef.maleEquip1 = 15864;
				itemDef.femaleEquip1 = 15864;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 19738;
				break;

			case 8087:
				itemDef.copyItem(4675);
				itemDef.name = "Dragon Rider lance";
				itemDef.modelID = 15815;
				itemDef.maleEquip1 = 15831;
				itemDef.femaleEquip1 = 15831;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 8088:
				itemDef.name = "Judicator Crossbow";
				itemDef.modelID = 15838;
				itemDef.maleEquip1 = 15839;
				itemDef.femaleEquip1 = 64359;
				itemdefedit = ItemDefinition.get(9185);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1200;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 19738;
				break;
				
			case 8001:
				itemDef.name = "Sir Levincia's crossbow";
				itemDef.modelID = 64495;
				itemDef.maleEquip1 = 64496;
				itemDef.femaleEquip1 = 64496;
				itemdefedit = ItemDefinition.get(9185);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1700;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				//itemDef.rdc2 = 654332;
				break;
				
			case 8089:
				itemDef.copyItem(4675);
				itemDef.name = "Purifier Staff";
				itemDef.modelID = 15721;
				itemDef.maleEquip1 = 15722;
				itemDef.modelZoom = 2500;
				itemDef.femaleEquip1 = 15722;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 19888:
				itemDef.name = "Collector necklace @cya@II";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 18823:
				itemDef.name = "Collector ring @cya@II";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 18888:
				itemdefedit = ItemDefinition.get(19888);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.name = "Collector necklace @mag@III";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 18818:
				itemdefedit = ItemDefinition.get(18823);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.name = "Collector ring @mag@III";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 21816:
				itemDef.name = "Warrior ticket";
				//itemDef.rdc2 = 45367587;
				break;

			case 21815:
				itemDef.name = "Archer ticket";
				itemDef.rdc2 = 45367587;
				break;
				
			case 21814:
				itemDef.name = "Wizard ticket";
				itemDef.rdc2 = 35734;
				break;
				
			case 14910:
				itemDef.name = "Demonic Torva full helm";
				itemdefedit = ItemDefinition.get(14008);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 14911:
				itemDef.name = "Demonic Torva platebody";
				itemdefedit = ItemDefinition.get(14009);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 14912:
				itemDef.name = "Demonic Torva platelegs";
				itemdefedit = ItemDefinition.get(14010);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 14913:
				itemDef.name = "Demonic gloves";
				itemdefedit = ItemDefinition.get(5556);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 14914:
				itemDef.name = "Demonic boots";
				itemdefedit = ItemDefinition.get(20456);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 14915:
				itemDef.name = "Demonic Sword";
				itemdefedit = ItemDefinition.get(20536);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 14916:
				itemDef.name = "Nature pernix cowl";
				itemdefedit = ItemDefinition.get(14011);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 14917:
				itemDef.name = "Nature pernix body";
				itemdefedit = ItemDefinition.get(14012);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 14918:
				itemDef.name = "Nature pernix chaps";
				itemdefedit = ItemDefinition.get(14013);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 14919:
				itemDef.name = "Nature crossbow";
				itemdefedit = ItemDefinition.get(14684);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 14920:
				itemDef.name = "Nature cape";
				itemdefedit = ItemDefinition.get(14022);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 6833:
				itemDef.name = "Goodiebag Box";
				itemDef.rdc2 = 12512;
				itemDef.actions = new String[]{"Open", null, null, null, "Drop"};
				break;

			case 23274:
				itemDef.copyItem(6833);
				itemDef.name = "Special goodiebag";
				itemDef.rdc2 = 32312;
				itemDef.actions = new String[]{"Open", null, null, null, "Drop"};
				break;

			case 14921:
				itemDef.name = "Icey virtus mask";
				itemdefedit = ItemDefinition.get(14014);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 14922:
				itemDef.name = "Icey virtus robe top";
				itemdefedit = ItemDefinition.get(14015);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 14923:
				itemDef.name = "Icey virtus legs";
				itemdefedit = ItemDefinition.get(14016);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 14924:
				itemDef.name = "Icey staff of festive";
				itemdefedit = ItemDefinition.get(18667);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 14925:
				itemDef.name = "Icey shield";
				itemdefedit = ItemDefinition.get(14577);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 15115:
				itemDef.name = "<shad=1><col=00e673>Extreme helm";
				itemDef.modelID = 65192;
				itemDef.maleEquip1 = 65193;
				itemDef.femaleEquip1 = 65193;
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 88205;
				break;
				
			case 15116:
				itemDef.name = "<shad=1><col=00e673>Extreme body";
				itemDef.modelID = 65194;
				itemDef.maleEquip1 = 65195;
				itemDef.femaleEquip1 = 65195;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 88205;
				break;
				
			case 15117:
				itemDef.name = "<shad=1><col=00e673>Extreme legs";
				itemDef.modelID = 65196;
				itemDef.maleEquip1 = 65197;
				itemDef.femaleEquip1 = 65197;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 88205;
				break;
				
			case 15118:
				itemDef.name = "<shad=1><col=00e673>Extreme gloves";
				itemDef.modelID = 65198;
				itemDef.maleEquip1 = 65199;
				itemDef.femaleEquip1 = 65199;
				itemdefedit = ItemDefinition.get(7462);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 88205;
				break;
				
			case 15119:
				itemDef.name = "<shad=1><col=00e673>Extreme boots";
				itemDef.modelID = 65200;
				itemDef.maleEquip1 = 65200;
				itemDef.femaleEquip1 = 65200;
				itemdefedit = ItemDefinition.get(20456);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 88205;
				break;
				
			case 15121:
				itemDef.name = "Extreme spear";
				itemDef.modelID = 65201;
				itemDef.maleEquip1 = 65202;
				itemDef.femaleEquip1 = 65202;
				itemdefedit = ItemDefinition.get(1237);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 88205;
				break;
				
			case 19331:
				itemDef.name = "Frozen staff";
				itemdefedit = ItemDefinition.get(15486);
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 7792950;
				break;
				
			case 15448:
				itemDef.name = "Ipotane-death power";
				break;
				
			case 15449:
				itemDef.name = "Extreme Aura";
				break;
				
			case 15450:
				itemDef.name = "Custom Extreme Aura";
				break;
				
			case 3107:
				itemDef.groundActions = new String[5];
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.name = "Ipotane-death boots";
				break;
				
			case 13640:
				itemDef.groundActions = new String[5];
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.name = "Ipotane-death staff";
				break;
				
			case 13964:
				itemDef.groundActions = new String[5];
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.name = "Ipotane-death shield";
				break;
				
			case 11317:
				ItemDefinition votingpoting = ItemDefinition.get(12479);
				itemDef.modelID = 64304;
				itemDef.modelOffsetX = votingpoting.modelOffsetX;
				itemDef.modelOffsetY = votingpoting.modelOffsetY;
				itemDef.modelZoom = 2000;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.name = "Bumble bee pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", "Upgrade-pet", "Drop"};
				itemDef.rdc2 = 664466;
				break;
				
			case 5074:
				ItemDefinition inuyashapet = ItemDefinition.get(12479);
				itemDef.modelID = 15194;
				itemDef.modelOffsetX = inuyashapet.modelOffsetX;
				itemDef.modelOffsetY = inuyashapet.modelOffsetY;
				itemDef.modelZoom = 2000;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.name = "Inuyasha pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
				
			case 21934:
				itemDef.name = "Ipotane-death helm";
				itemDef.modelID = 65112;
				itemDef.maleEquip1 = 65113;
				itemDef.femaleEquip1 = 65113;
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40;
				itemDef.newColors[0] = 126;
				itemDef.stackable = false;
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
				
			case 19918:
				itemDef.name = "Ipotane-death body";
				itemDef.modelID = 65114;
				itemDef.maleEquip1 = 65115;
				itemDef.femaleEquip1 = 65115;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40;
				itemDef.newColors[0] = 126;
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
				
			case 19913:
				itemDef.name = "Ipotane-death legs";
				itemDef.modelID = 65116;
				itemDef.maleEquip1 = 65117;
				itemDef.femaleEquip1 = 65117;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40;
				itemDef.newColors[0] = 126;
				itemDef.stackable = false;
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
				
			case 20060:
				itemDef.name = "Lytsu void helm";
				itemDef.modelID = 65385;
				itemDef.maleEquip1 = 65386;
				itemDef.femaleEquip1 = 65386;
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{88};
				break;
				
			case 20062:
				itemDef.name = "Lytsu void body";
				itemDef.modelID = 65387;
				itemDef.maleEquip1 = 65388;
				itemDef.femaleEquip1 = 65388;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{88};
				break;
				
			case 20063:
				itemDef.name = "Lytsu Void legs";
				itemDef.modelID = 65389;
				itemDef.maleEquip1 = 65390;
				itemDef.femaleEquip1 = 65390;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{88};
				break;
				
			case 20073:
				itemDef.name = "Lytsu void boots";
				itemdefedit = ItemDefinition.get(7114);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 64177;
				itemDef.maleEquip1 = 64178;
				itemDef.femaleEquip1 = 64178;
				itemDef.actions = itemdefedit.actions;
				break;

			case 19800:
				itemDef.name = "Lytsu void Teddybear";
				itemDef.modelID = 64034;
				itemDef.maleEquip1 = 64035;
				itemDef.femaleEquip1 = 64035;
				itemdefedit = ItemDefinition.get(8848);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1000;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 19802:
				itemDef.name = "Lytsu void gloves";
				itemdefedit = ItemDefinition.get(7461);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1100;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 64175;
				itemDef.maleEquip1 = 64176;
				itemDef.femaleEquip1 = 64176;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 22950:
			itemDef.copyItem(12159);
			itemDef.name = "Fantasy Attachment";
			itemDef.actions = new String[]{null, null, "Disassemble", null, "Destroy"};
			itemDef.stackable = false;
			itemDef.oldColors = new int[]{0, 15556, 16685, 16677, 16565, 16573};
			itemDef.newColors = new int[]{46700, 45759, 45759, 45759, 46003, 46700};
			break;

			case 23443:
				itemDef.copyItem(14050);
				itemDef.name = "Fantasy helmet";
				itemDef.modelID = 19758;
				itemDef.maleEquip1 = 19759;
				itemDef.femaleEquip1 = 19759;
			break;

			case 23444:
				itemDef.copyItem(14051);
				itemDef.name = "Fantasy body";
				itemDef.modelID = 19760;
				itemDef.maleEquip1 = 19761;
				itemDef.femaleEquip1 = 19761;
				break;
			case 23445:
				itemDef.copyItem(14052);
				itemDef.name = "Fantasy legs";
				itemDef.modelID = 19762;
				itemDef.maleEquip1 = 19763;
				itemDef.femaleEquip1 = 19763;
				break;

			case 14050:
				itemDef.name = "Dragon Rider helm";
				itemDef.modelID = 65385;
				itemDef.maleEquip1 = 65386;
				itemDef.femaleEquip1 = 65386;
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{98};
				break;
				
			case 14051:
				itemDef.name = "Dragon Rider body";
				itemDef.modelID = 65387;
				itemDef.maleEquip1 = 65388;
				itemDef.femaleEquip1 = 65388;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{98};
				break;
				
			case 14052:
				itemDef.name = "Dragon Rider legs";
				itemDef.modelID = 65389;
				itemDef.maleEquip1 = 65390;
				itemDef.femaleEquip1 = 65390;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{98};
				break;
				
			case 14053:
				itemDef.name = "Dragon Rider boots";
				itemdefedit = ItemDefinition.get(20456);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 64177;
				itemDef.maleEquip1 = 64178;
				itemDef.femaleEquip1 = 64178;
				itemDef.actions = itemdefedit.actions;
				break;
				
			case 14054:
				itemDef.name = "Alex void Shield";
				itemdefedit = ItemDefinition.get(12930);
				itemDef.modelID = itemdefedit.modelID;
				itemDef.maleEquip1 = itemdefedit.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit.femaleEquip1;
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1600;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 14055:
				itemDef.name = "Dragon Rider gloves";
				itemdefedit = ItemDefinition.get(7461);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1100;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 64175;
				itemDef.maleEquip1 = 64176;
				itemDef.femaleEquip1 = 64176;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 14056:
				itemDef.name = "Alex Levincia bow";
				itemDef.modelID = 64358;
				itemDef.maleEquip1 = 64359;
				itemDef.femaleEquip1 = 64359;
				itemdefedit = ItemDefinition.get(9185);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1700;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 11181:
				itemDef.name = "X File gloves";
				itemdefedit = ItemDefinition.get(7461);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1200;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 64277;
				itemDef.maleEquip1 = 64278;
				itemDef.femaleEquip1 = 64278;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
				
			case 11182:
				itemDef.name = "X File boots";
				itemdefedit = ItemDefinition.get(7114);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 64279;
				itemDef.maleEquip1 = 64279;
				itemDef.femaleEquip1 = 64279;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;

			case 11183:
				itemDef.name = "X File helm";
				itemDef.modelID = 65272;
				itemDef.maleEquip1 = 65273;
				itemDef.femaleEquip1 = 65273;
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 19188731;
				break;

			case 11184:
				itemDef.name = "X File body";
				itemDef.modelID = 65274;
				itemDef.maleEquip1 = 65275;
				itemDef.femaleEquip1 = 65275;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 19188731;
				break;

			case 11179:
				itemDef.name = "X File legs";
				itemDef.modelID = 65276;
				itemDef.maleEquip1 = 65277;
				itemDef.femaleEquip1 = 65277;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 19188731;
				break;
			case 11759:
				itemDef.name = "x file Teddybear";
				itemDef.modelID = 64034;
				itemDef.maleEquip1 = 64035;
				itemDef.femaleEquip1 = 64035;
				itemdefedit = ItemDefinition.get(8848);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1000;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 11762:
				itemDef.name = "x file cape";
				itemDef.modelID = 64315;
				itemdefedit = ItemDefinition.get(6570);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 65447;
				itemDef.maleEquip1 = 65446;
				itemDef.femaleEquip1 = 65446;
				itemDef.actions = itemdefedit.actions;
				itemDef.newColors = new int[2]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[2]; // same here
				itemDef.oldColors[0] = 54;
				itemDef.newColors[0] = 56;
				itemDef.oldColors[1] = 65;
				itemDef.newColors[1] = 56;
				itemDef.stackable = false;
				itemDef.value = 1;
				break;

			case 17702:
				itemDef.name = "Hanto claws";
				itemDef.modelID = 64046;
				itemDef.maleEquip1 = 64047;
				itemDef.femaleEquip1 = 64047;
				itemdefedit = ItemDefinition.get(20562);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 23368:
				itemDef.copyItem(17702);
				itemDef.name = "Magic claws";
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 28998;
				break;

			case 11763:
				itemDef.name = "Hanto helm";
				itemDef.modelID = 18692;
				itemDef.maleEquip1 = 18693;
				itemDef.femaleEquip1 = 18693;
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 900;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 11764:
				itemDef.name = "Hanto body";
				itemDef.modelID = 18703;
				itemDef.maleEquip1 = 18704;
				itemDef.femaleEquip1 = 18704;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 11765:
				itemDef.name = "Hanto legs";
				itemDef.modelID = 18694;
				itemDef.maleEquip1 = 18695;
				itemDef.femaleEquip1 = 18695;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom; //#564245 #3c4541
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 11766:
				itemDef.name = "Hanto gloves";
				itemdefedit = ItemDefinition.get(7461);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1200;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 18794;
				itemDef.maleEquip1 = 18793;
				itemDef.femaleEquip1 = 18793;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
				
			case 11767:
				itemDef.name = "Hanto boots";
				itemdefedit = ItemDefinition.get(7114);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 15170;
				itemDef.maleEquip1 = 15170;
				itemDef.femaleEquip1 = 15170;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
				
			case 9478:
				itemDef.name = "Goku helm";
				itemDef.modelID = 15180;
				itemDef.maleEquip1 = 15181;
				itemDef.femaleEquip1 = 15181;
				itemDef.rotationZ = 0;
				itemDef.rotationX = 0;
				itemDef.rotationY = 380;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelZoom = 500;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 9479:
				itemDef.name = "Goku body";
				itemDef.modelID = 15182;
				itemDef.maleEquip1 = 15183;
				itemDef.femaleEquip1 = 15183;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 900;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 9480:
				itemDef.name = "Goku legs";
				itemDef.modelID = 15184;
				itemDef.maleEquip1 = 15185;
				itemDef.femaleEquip1 = 15185;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1100;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 9481:
				itemDef.name = "Raditz helm";
				itemDef.modelID = 15171;
				itemDef.maleEquip1 = 15172;
				itemDef.femaleEquip1 = 15172;
				itemDef.rotationZ = 0;
				itemDef.rotationX = 0;
				itemDef.rotationY = 380;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelZoom = 1200;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 9482:
				itemDef.name = "Raditz body";
				itemDef.modelID = 15173;
				itemDef.maleEquip1 = 15174;
				itemDef.femaleEquip1 = 15174;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 9483:
				itemDef.name = "Raditz legs";
				itemDef.modelID = 15175;
				itemDef.maleEquip1 = 15176;
				itemDef.femaleEquip1 = 15176;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 2947:
				itemDef.modelID = 64362;
				itemDef.modelOffsetX = 2;
				itemDef.modelOffsetY = 80;
				itemDef.rotationY = 204;
				itemDef.rotationX = 20;
				itemDef.modelZoom = 2100;
				itemDef.name = "Frieza Pet (first form)";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
				
			case 2948:
				itemDef.modelID = 64363;
				itemDef.modelOffsetX = 2;
				itemDef.modelOffsetY = 80;
				itemDef.rotationY = 204;
				itemDef.rotationX = 20;
				itemDef.modelZoom = 2100;
				itemDef.name = "Frieza Pet (second form)";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
				
			case 2949:
				itemDef.modelID = 64364;
				itemDef.modelOffsetX = 2;
				itemDef.modelOffsetY = 80;
				itemDef.rotationY = 204;
				itemDef.rotationX = 20;
				itemDef.modelZoom = 2100;
				itemDef.name = "Frieza Pet (final form)";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
				
			case 9929:
				itemDef.name = "Lytsu void Rifle";
				ItemDefinition itemDef2 = ItemDefinition.get(20538);
				itemDef.modelID = 65024;
				itemDef.femaleEquip1 = 65025;
				itemDef.maleEquip1 = 65025;
				itemDef.modelOffsetX = 1;
				itemDef.modelOffsetY = 30;
				itemDef.modelZoom = 2100;
				itemDef.rotationY = 200;
				itemDef.rotationX = itemDef2.rotationX;
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 26:
				itemDef.name = "Sassy Aura";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 18768:
				itemDef.name = "Dragonball Saga box";
				itemDef.rdc2 = 2233311;
				break;
				
			case 7543:
				itemDef.name = "Raditz Rifle";
				ItemDefinition itemdefedit1 = ItemDefinition.get(20538);
				itemDef.modelID = 65024;
				itemDef.femaleEquip1 = 65025;
				itemDef.maleEquip1 = 65025;
				itemDef.modelOffsetX = 1;
				itemDef.modelOffsetY = 30;
				itemDef.modelZoom = 2100;
				itemDef.rotationY = 200;
				itemDef.rotationX = itemdefedit1.rotationX;
				itemDef.stackable = false;
				itemDef.rdc2 = 2233311;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 7544:
				itemDef.name = "Raditz Teddybear";
				itemDef.modelID = 64034;
				itemDef.maleEquip1 = 64035;
				itemDef.femaleEquip1 = 64035;
				itemdefedit1 = ItemDefinition.get(8848);
				itemDef.modelOffsetX = itemdefedit1.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit1.modelOffsetY;
				itemDef.modelZoom = 1000;
				itemDef.rotationY = itemdefedit1.rotationY;
				itemDef.rotationX = itemdefedit1.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 8410:
				itemDef.copyItem(22078);
				itemDef.rotationX = 500;
				itemDef.rotationZ = 140;
				itemDef.modelOffsetX = -6;
				itemDef.modelOffsetY = 0;
				itemDef.name = "Elite Sword (AoE)";
				itemDef.modelID = 16005;
				itemDef.femaleEquip1 = 16006;
				itemDef.maleEquip1 = 16006;
				itemDef.modelZoom = 2300;
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{60};
				break;
				
			case 8411:
				itemDef.name = "Elite Crossbow (AoE)";
				itemdefedit1 = ItemDefinition.get(18799);
				itemDef.modelID = 16007;
				itemDef.femaleEquip1 = 16021;
				itemDef.maleEquip1 = 16021;
				itemDef.modelOffsetX = -7;
				itemDef.modelOffsetY = 0;
				itemDef.modelZoom = 1070;
				itemDef.rotationY = 617;
				itemDef.rotationZ = 0;
				itemDef.rotationX = 1261;
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{59};
				break;
				
			case 8412:
				itemDef.name = "Elite Staff (AoE)";
				itemdefedit1 = ItemDefinition.get(4675);
				itemDef.modelID = 16003;
				itemDef.femaleEquip1 = 16004;
				itemDef.maleEquip1 = 16004;
				itemDef.modelOffsetX = -12;
				itemDef.modelOffsetY = 0;
				itemDef.modelZoom = 3300;
				itemDef.rotationY = 322;
				itemDef.rotationX = 0;
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{58};
				break;
				
			case 3737:
				itemDef.name = "Enraged AoE Sword";
				itemdefedit1 = ItemDefinition.get(4587);
				itemDef.modelID = 64395;
				itemDef.femaleEquip1 = 64396;
				itemDef.maleEquip1 = 64396;
				itemDef.modelOffsetX = itemdefedit1.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit1.modelOffsetY;
				itemDef.modelZoom = itemdefedit1.modelZoom;
				itemDef.rotationY = itemdefedit1.rotationY;
				itemDef.rotationX = itemdefedit1.rotationX;
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 3738:
				itemDef.name = "Botanic AoE Bow";
				itemdefedit1 = ItemDefinition.get(859);
				itemDef.modelID = 64397;
				itemDef.femaleEquip1 = 64398;
				itemDef.maleEquip1 = 64398;
				itemDef.modelOffsetX = itemdefedit1.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit1.modelOffsetY;
				itemDef.modelZoom = itemdefedit1.modelZoom;
				itemDef.rotationY = itemdefedit1.rotationY;
				itemDef.rotationX = itemdefedit1.rotationX;
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
			
				break;
			case 3739:
				itemDef.name = "Elemental AoE Staff";
				itemdefedit1 = ItemDefinition.get(4675);
				itemDef.modelID = 64399;
				itemDef.femaleEquip1 = 64400;
				itemDef.maleEquip1 = 64400;
				itemDef.modelOffsetX = itemdefedit1.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit1.modelOffsetY;
				itemDef.modelZoom = itemdefedit1.modelZoom;
				itemDef.rotationY = itemdefedit1.rotationY;
				itemDef.rotationX = itemdefedit1.rotationX;
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 7545:
				itemdefedit1 = ItemDefinition.get(7535);
				itemDef.name = "Raditz apparatus";
				itemDef.modelID = itemdefedit1.modelID;
				itemDef.maleEquip1 = itemdefedit1.maleEquip1;
				itemDef.femaleEquip1 = itemdefedit1.femaleEquip1;
				itemDef.modelOffsetX = itemdefedit1.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit1.modelOffsetY;
				itemDef.modelZoom = itemdefedit1.modelZoom;
				itemDef.rotationY = itemdefedit1.rotationY;
				itemDef.rotationX = itemdefedit1.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 6545:
				itemDef.modelID = 15171;
				itemDef.modelOffsetX = 2;
				itemDef.modelOffsetY = 80;
				itemDef.rotationY = 204;
				itemDef.rotationX = 20;
				itemDef.modelZoom = 1100;
				itemDef.name = "Raditz pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
				
			case 15279:
				itemDef.modelID = 64381;
				itemDef.modelOffsetX = 2;
				itemDef.modelOffsetY = 80;
				itemDef.rotationY = 204;
				itemDef.rotationX = 20;
				itemDef.modelZoom = 2100;
				itemDef.name = "Majin Buu Pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
				
			case 15278:
				itemDef.modelID = 15180;
				itemDef.modelOffsetX = 2;
				itemDef.modelOffsetY = 80;
				itemDef.rotationY = 204;
				itemDef.rotationX = 20;
				itemDef.modelZoom = 1100;
				itemDef.name = "Goku pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
				
			case 16249:
				itemDef.name = "Goku Staff";
				break;
				
			case 16265:
				itemDef.name = "Goku boots";	
				itemDef.modelID = 15186;
				itemDef.femaleEquip1 = 15187;
				itemDef.maleEquip1 = 15187;
				break;
				
			case 15832:
				itemDef.name = "Goku ward";
				break;
				
			case 1485:
				itemDef.name = "Landen Cape";
				ItemDefinition SoulCape = ItemDefinition.get(19709);
				itemDef.modelID = 64393;
				itemDef.femaleEquip1 = 64394;
				itemDef.maleEquip1 = 64394;
				itemDef.modelOffsetX = 20;
				itemDef.modelOffsetY = 100;
				itemDef.modelZoom = 2300;
				itemDef.rotationY = 300;
				itemDef.rotationX = 1000;
				itemDef.stackable = false;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40;
				itemDef.newColors[0] = 96;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 1486:
				itemDef.name = "Creeper Cape";
				ItemDefinition SoulCape1 = ItemDefinition.get(19709);
				itemDef.modelID = 64393;
				itemDef.femaleEquip1 = 64394;
				itemDef.maleEquip1 = 64394;
				itemDef.modelOffsetX = 20;
				itemDef.modelOffsetY = 100;
				itemDef.modelZoom = 2300;
				itemDef.rotationY = 300;
				itemDef.rotationX = 1000;
				itemDef.stackable = false;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40;
				itemDef.newColors[0] = 97;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 3740:
				itemDef.name = "Yogi helm";
				itemDef.modelID = 64401;
				itemDef.maleEquip1 = 64402;
				itemDef.femaleEquip1 = 64402;
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 23453;
				break;
				
			case 3741:
				itemDef.name = "Yogi body";
				itemDef.modelID = 64403;
				itemDef.maleEquip1 = 64404;
				itemDef.femaleEquip1 = 64404;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 23453;
				break;
				
			case 3742:
				itemDef.name = "Yogi legs";
				itemDef.modelID = 64405;
				itemDef.maleEquip1 = 64406;
				itemDef.femaleEquip1 = 64406;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 23453;
				break;
				
			case 3743:
				itemDef.name = "Yogi Sword";
				itemdefedit1 = ItemDefinition.get(4587);
				itemDef.modelID = 64395;
				itemDef.femaleEquip1 = 64396;
				itemDef.maleEquip1 = 64396;
				itemDef.modelOffsetX = itemdefedit1.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit1.modelOffsetY;
				itemDef.modelZoom = itemdefedit1.modelZoom;
				itemDef.rotationY = itemdefedit1.rotationY;
				itemDef.rotationX = itemdefedit1.rotationX;
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 23453;
				break;
				
			case 3744:
				itemDef.name = "Yogi Bow";
				itemdefedit1 = ItemDefinition.get(859);
				itemDef.modelID = 64397;
				itemDef.femaleEquip1 = 64398;
				itemDef.maleEquip1 = 64398;
				itemDef.modelOffsetX = itemdefedit1.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit1.modelOffsetY;
				itemDef.modelZoom = itemdefedit1.modelZoom;
				itemDef.rotationY = itemdefedit1.rotationY;
				itemDef.rotationX = itemdefedit1.rotationX;
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 23453;
				break;
				
			case 3745:
				itemDef.name = "Magician Staff";
				itemdefedit1 = ItemDefinition.get(4675);
				itemDef.modelID = 64399;
				itemDef.femaleEquip1 = 64400;
				itemDef.maleEquip1 = 64400;
				itemDef.modelOffsetX = itemdefedit1.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit1.modelOffsetY;
				itemDef.modelZoom = itemdefedit1.modelZoom;
				itemDef.rotationY = itemdefedit1.rotationY;
				itemDef.rotationX = itemdefedit1.rotationX;
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 23453;
				break;
				
			case 3720:
				itemDef.name = "Enraged helm";
				itemDef.modelID = 15664;
				itemDef.maleEquip1 = 15665;
				itemDef.femaleEquip1 = 15665;
				itemDef.rotationZ = 0;
				itemDef.rotationX = 0;
				itemDef.rotationY = 380;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelZoom = 800;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 3721:
				itemDef.name = "Enraged body";
				itemDef.modelID = 15667;
				itemDef.maleEquip1 = 15669;
				itemDef.femaleEquip1 = 15669;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 3722:
				itemDef.name = "Enraged legs";
				itemDef.modelID = 15668;
				itemDef.maleEquip1 = 15670;
				itemDef.femaleEquip1 = 15670;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 3726:
				itemDef.name = "Elemental helm";
				itemDef.modelID = 64419;
				itemDef.maleEquip1 = 64420;
				itemDef.femaleEquip1 = 64420;
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 3728:
				itemDef.name = "Elemental body";
				itemDef.modelID = 64421;
				itemDef.maleEquip1 = 64422;
				itemDef.femaleEquip1 = 64422;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 3730:
				itemDef.name = "Elemental legs";
				itemDef.modelID = 64423;
				itemDef.maleEquip1 = 64424;
				itemDef.femaleEquip1 = 64424;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 3723:
				itemDef.name = "Botanic helm";
				itemDef.modelID = 65266;
				itemDef.maleEquip1 = 65267;
				itemDef.femaleEquip1 = 65267;
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 3724:
				itemDef.name = "Botanic body";
				itemDef.modelID = 65268;
				itemDef.maleEquip1 = 65269;
				itemDef.femaleEquip1 = 65269;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 3725:
				itemDef.name = "Botanic legs";
				itemDef.modelID = 65270;
				itemDef.maleEquip1 = 65271;
				itemDef.femaleEquip1 = 65271;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 8100:
				itemDef.name = "Light guild helmet";
				itemDef.modelID = 64428;
				itemDef.maleEquip1 = 64429;
				itemDef.femaleEquip1 = 64429;
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 8101:
				itemDef.name = "Light guild body";
				itemDef.modelID = 64430;
				itemDef.maleEquip1 = 64431;
				itemDef.femaleEquip1 = 64431;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 8102:
				itemDef.name = "Light guild legs";
				itemDef.modelID = 64432;
				itemDef.maleEquip1 = 64433;
				itemDef.femaleEquip1 = 64433;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 8103:
				itemDef.name = "Light guild boots";
				itemdefedit = ItemDefinition.get(7114);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 64434;
				itemDef.maleEquip1 = 64434;
				itemDef.femaleEquip1 = 64434;
				itemDef.actions = itemdefedit.actions;
				break;

			case 8104:
				itemDef.name = "Light guild gloves";
				itemdefedit = ItemDefinition.get(7461);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1100;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 64436;
				itemDef.maleEquip1 = 64436;
				itemDef.femaleEquip1 = 64436;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 8105:
				itemDef.name = "Dark guild helmet";
				itemDef.modelID = 64437;
				itemDef.maleEquip1 = 64438;
				itemDef.femaleEquip1 = 64438;
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 8106:
				itemDef.name = "Dark guild body";
				itemDef.modelID = 64439;
				itemDef.maleEquip1 = 64440;
				itemDef.femaleEquip1 = 64440;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 8107:
				itemDef.name = "Dark guild legs";
				itemDef.modelID = 64441;
				itemDef.maleEquip1 = 64442;
				itemDef.femaleEquip1 = 64442;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 8108:
				itemDef.name = "Dark guild boots";
				itemdefedit = ItemDefinition.get(7114);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 64443;
				itemDef.maleEquip1 = 64443;
				itemDef.femaleEquip1 = 64443;
				itemDef.actions = itemdefedit.actions;
				break;

			case 8109:
				itemDef.name = "Dark guild gloves";
				itemdefedit = ItemDefinition.get(7461);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1100;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 64444;
				itemDef.maleEquip1 = 64445;
				itemDef.femaleEquip1 = 64445;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				break;
			case 13128:
				itemDef.name = "Dark guild Flail";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 729987;
				break;
			case 8110:
				itemDef.name = "Light guild sword";
				itemDef.modelID = 64446;
				itemDef.maleEquip1 = 64447;
				itemDef.femaleEquip1 = 64447;
				itemdefedit = ItemDefinition.get(22034);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1500;
				itemDef.rotationY = 400;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				break;
			case 11318:
				ItemDefinition adminsraichu = ItemDefinition.get(12479);
				itemDef.modelID = 64448;
				itemDef.modelOffsetX = adminsraichu.modelOffsetX;
				itemDef.modelOffsetY = adminsraichu.modelOffsetY;
				itemDef.modelZoom = 2000;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.name = "@yel@Raichu pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", "Upgrade-pet", "Drop"};
				break;
			case 11319:
				ItemDefinition zorbak = ItemDefinition.get(12479);
				itemDef.modelID = 64476;
				itemDef.modelOffsetX = zorbak.modelOffsetX;
				itemDef.modelOffsetY = zorbak.modelOffsetY;
				itemDef.modelZoom = 2000;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.name = "Zorbak (elite) pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", "Upgrade-pet", "Drop"};
				break;
			case 11310:
				ItemDefinition zorbak2 = ItemDefinition.get(12479);
				itemDef.modelID = 97666;
				itemDef.modelOffsetX = zorbak2.modelOffsetX;
				itemDef.modelOffsetY = zorbak2.modelOffsetY;
				itemDef.modelZoom = 6500;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.name = "Youtube JR Pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 21600:
				itemDef.name = "TheHammer Torva helm";
				itemDef.modelID = 64449;
				itemDef.maleEquip1 = 64450;
				itemDef.femaleEquip1 = 64450;
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 21601:
				itemDef.name = "TheHammer Torva body";
				itemDef.modelID = 64451;
				itemDef.maleEquip1 = 64452;
				itemDef.femaleEquip1 = 64452;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 21602:
				itemDef.name = "TheHammer Torva legs";
				itemDef.modelID = 64453;
				itemDef.maleEquip1 = 64454;
				itemDef.femaleEquip1 = 64454;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 21603:
				itemDef.name = "TheHammer wings";
				itemDef.modelID = 64455;
				itemDef.maleEquip1 = 64456;
				itemDef.femaleEquip1 = 64456;
				itemdefedit = ItemDefinition.get(18509);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 21604:
				itemDef.name = "TheHammer kiteshield";
				itemDef.modelID = 64457;
				itemDef.maleEquip1 = 64458;
				itemDef.femaleEquip1 = 64458;
				itemdefedit = ItemDefinition.get(18509);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 21780:
				itemDef.name = "TheHammer gloves";
				itemDef.modelID = 65136;
				itemDef.maleEquip1 = 65137;
				itemDef.femaleEquip1 = 65137;
				itemdefedit = ItemDefinition.get(7462);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40;
				itemDef.newColors[0] = 65;
				itemDef.stackable = false;
				break;
				
			case 21605:
				itemDef.name = "TheHammer boots";
				itemDef.modelID = 64459;
				itemDef.maleEquip1 = 64459;
				itemDef.femaleEquip1 = 64459;
				itemdefedit = ItemDefinition.get(11732);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 21606:
				itemDef.name = "TheHammer Rifle";
				itemdefedit = ItemDefinition.get(20538);
				itemDef.modelID = 64491;
				itemDef.femaleEquip1 = 64492;
				itemDef.maleEquip1 = 64492;
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
				
			case 5068:
				itemDef.copyItem(6585);
				itemDef.name = "Inuyasha helm";
				itemDef.modelID = 15194;
				itemDef.maleEquip1 = 15194;
				itemDef.femaleEquip1 = 15194;
                itemDef.modelZoom = 1680;
                itemDef.rotationX = 0;
                itemDef.rotationY = 0;
                itemDef.modelOffsetY = 65;
                itemDef.modelOffsetX = 0;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 5069:
				itemDef.name = "Inuyasha body";
				itemDef.modelID = 15195;
				itemDef.maleEquip1 = 15195;
				itemDef.femaleEquip1 = 15195;
                itemDef.modelZoom = 1380;
                itemDef.rotationX = 50;
                itemDef.rotationY = 0;
                itemDef.modelOffsetY = 45;
                itemDef.modelOffsetX = 0;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 5070:
				itemDef.name = "Inuyasha legs";
				itemDef.modelID = 15196;
				itemDef.maleEquip1 = 15196;
				itemDef.femaleEquip1 = 15196;
                itemDef.modelZoom = 1560;
                itemDef.rotationX = 0;
                itemDef.rotationY = 20;
                itemDef.modelOffsetY = 10;
                itemDef.modelOffsetX = 0;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 5071:
				itemDef.name = "Inuyasha gloves";
				itemDef = ItemDefinition.get(7461);
				itemDef.modelOffsetX = itemDef.modelOffsetX;
				itemDef.modelOffsetY = itemDef.modelOffsetY;
				itemDef.modelZoom = itemDef.modelZoom;
				itemDef.rotationY = itemDef.rotationY;
				itemDef.rotationX = itemDef.rotationX;
				itemDef.modelID = 64129;
				itemDef.maleEquip1 = 15198;
				itemDef.femaleEquip1 = 15198;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 5072:
				itemDef.name = "Inuyasha boots";
				itemDef.modelID = 15197;
				itemDef.maleEquip1 = 15197;
				itemDef.femaleEquip1 = 15197;
                itemDef.modelZoom = 800;
                itemDef.rotationX = 50;
                itemDef.rotationY = 0;
                itemDef.modelOffsetY = 0;
                itemDef.modelOffsetX = 1;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 5073:
				itemDef.name = "Inuyasha Blade";
				itemDef.modelID = 15199;
				itemDef.femaleEquip1 = 15199;
				itemDef.maleEquip1 = 15199;
                itemDef.modelZoom = 1800;
                itemDef.rotationX = 235;
                itemDef.rotationY = 652;
                itemDef.modelOffsetY = 25;
                itemDef.modelOffsetX = 60;
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.rdc2 = 2412432;
				break;
				
			case 14060:
				itemDef.name = "Crystalized helm";
				itemDef.modelID = 64513;
				itemDef.maleEquip1 = 64514;
				itemDef.femaleEquip1 = 64514;
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = 1;
				itemDef.modelZoom = 1250;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 14061:
				itemDef.name = "Crystalized body";
				itemDef.modelID = 64515;
				itemDef.maleEquip1 = 64516;
				itemDef.femaleEquip1 = 64516;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1700;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 14062:
				itemDef.name = "Crystalized legs";
				itemDef.modelID = 64517;
				itemDef.maleEquip1 = 64518;
				itemDef.femaleEquip1 = 64518;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1650;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 14063:
				itemdefedit = ItemDefinition.get(7461);
				itemDef.name = "Crystalized gloves";
				itemDef.modelID = 64519;
				itemDef.maleEquip1 = 64520;
				itemDef.femaleEquip1 = 64520;
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1700;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1];
				itemDef.oldColors = new int[1];
				itemDef.oldColors[0] = 40;
				itemDef.newColors[0] = 65;
				itemDef.stackable = false;
				break;
				
			case 14064:
				itemDef.name = "Crystalized boots";
				itemDef.modelID = 64521;
				itemDef.maleEquip1 = 64521;
				itemDef.femaleEquip1 = 64521;
                itemDef.modelZoom = 750;
                itemDef.rotationX = 100;
                itemDef.rotationY = 20;
                itemDef.rotationZ = 50;
                itemDef.modelOffsetY = -2;
                itemDef.modelOffsetX = -3;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 14065:
				itemDef.name = "Crystalized sword";
				itemdefedit = ItemDefinition.get(1333);
				itemDef.modelID = 64522;
				itemDef.femaleEquip1 = 64523;
				itemDef.maleEquip1 = 64523;
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1340;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
				
			case 14066:
				itemDef.name = "Crystalized wings";
				itemdefedit = ItemDefinition.get(1419);
				itemDef.modelID = 64524;
				itemDef.femaleEquip1 = 64525;
				itemDef.maleEquip1 = 64525;
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 2250;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
				
			case 9054:
				itemDef.copyItem(4708);
				itemDef.name = "Creeper helm";
				itemDef.modelID = 100279;
				itemDef.maleEquip1 = 100280;
				itemDef.femaleEquip1 = 100280;
				itemDef.modelZoom = 800;
				break;

			case 9055:
				itemDef.copyItem(4712);
				itemDef.name = "Creeper body";
				itemDef.modelID = 100272;
				itemDef.maleEquip1 = 100273;
				itemDef.femaleEquip1 = 100273;
				itemDef.modelZoom = 1500;
				break;

			case 9056:
				itemDef.copyItem(4714);
				itemDef.name = "Creeper legs";
				itemDef.modelID = 100277;
				itemDef.maleEquip1 = 100278;
				itemDef.femaleEquip1 = 100278;
				itemDef.modelZoom = 1800;
				break;

			case 9057:
				itemDef.copyItem(4708);
				itemDef.name = "Creeper gloves";
				itemDef.modelID = 100275;
				itemDef.maleEquip1 = 100276;
				itemDef.femaleEquip1 = 100276;
				itemDef.modelZoom = 700;
				break;
				
			case 9058:
				itemDef.copyItem(4708);
				itemDef.name = "Creeper boots";
				itemDef.modelID = 100274;
				itemDef.maleEquip1 = 100274;
				itemDef.femaleEquip1 = 100274;
				itemDef.modelZoom = 700;
				break;
				
			case 9059:
				itemDef.name = "Creeper sword";
				itemdefedit = ItemDefinition.get(1333);
				itemDef.modelID = 64522;
				itemDef.femaleEquip1 = 64523;
				itemDef.maleEquip1 = 64523;
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1000;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.rdc2 = 5523329;
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
				
			case 9060:
				itemDef.name = "Creeper wings";
				itemdefedit = ItemDefinition.get(1419);
				itemDef.modelID = 64524;
				itemDef.femaleEquip1 = 64525;
				itemDef.maleEquip1 = 64525;
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 2000;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.rdc2 = 5523329;
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
				
			case 14067:
				itemDef.modelID = 18037;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelZoom = 4500;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.name = "Tolrokoth pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
				
			case 14068:
				itemDef.name = "Garfield mask";
				itemDef.modelID = 64526;
				itemDef.maleEquip1 = 64527;
				itemDef.femaleEquip1 = 64527;
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 14069:
				itemDef.name = "Garfield body";
				itemDef.modelID = 64528;
				itemDef.maleEquip1 = 64529;
				itemDef.femaleEquip1 = 64529;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 14070:
				itemDef.name = "Garfield legs";
				itemDef.modelID = 64530;
				itemDef.maleEquip1 = 64531;
				itemDef.femaleEquip1 = 64531;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 14071:
				itemDef.name = "Garfield gloves";
				itemDef.modelID = 64532;
				itemDef.maleEquip1 = 64533;
				itemDef.femaleEquip1 = 64533;
				itemdefedit = ItemDefinition.get(20458);
				itemDef.modelOffsetX = 30;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 400;
				itemDef.rotationY = 240;
				itemDef.rotationX = 20;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40;
				itemDef.newColors[0] = 65;
				itemDef.stackable = false;
				break;
				
			case 14072:
				itemDef.name = "Garfield boots";
				itemDef.modelID = 64534;
				itemDef.maleEquip1 = 64534;
				itemDef.femaleEquip1 = 64534;
				itemdefedit = ItemDefinition.get(11732);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 14073:
				itemDef.name = "Garfield Scarf";
				itemdefedit = ItemDefinition.get(1419);
				itemDef.modelID = 64535;
				itemDef.femaleEquip1 = 64536;
				itemDef.maleEquip1 = 64536;
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1000;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
				
			case 21607:
				itemDef.name = "Custom Extreme helm";
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 64194;
				itemDef.maleEquip1 = 64195;
				itemDef.femaleEquip1 = 64195;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				
				itemDef.rdc2 = 123829;//77777
				break;

			case 21608:
				itemDef.name = "Custom Extreme body";
				itemdefedit = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 64196;
				itemDef.maleEquip1 = 64197;
				itemDef.femaleEquip1 = 64197;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				
				itemDef.rdc2 = 123829;
				break;
			case 21609:
				itemDef.name = "Custom Extreme legs";
				itemdefedit = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 64198;
				itemDef.maleEquip1 = 64199;
				itemDef.femaleEquip1 = 64199;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				
				itemDef.rdc2 = 123829;
				break;
			case 21610:
				itemDef.name = "Custom Extreme Teddy bear";
				itemDef.modelID = 64034;
				itemDef.maleEquip1 = 64035;
				itemDef.femaleEquip1 = 64035;
				itemdefedit = ItemDefinition.get(8848);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = 1000;
				itemDef.rotationY = itemdefedit.rotationY;

				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 204929;
				break;

			case 21611:
				itemDef.name = "Custom Extreme gloves";
				itemdefedit = ItemDefinition.get(7461);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 64202;
				itemDef.maleEquip1 = 64203;
				itemDef.femaleEquip1 = 64203;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				
				itemDef.rdc2 = 123829;
				break;
			case 21612:
				itemDef.name = "Custom Extreme boots";
				itemdefedit = ItemDefinition.get(7114);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.modelID = 64204;
				itemDef.maleEquip1 = 64204;
				itemDef.femaleEquip1 = 64204;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				
				itemDef.rdc2 = 123829;
				break;
			case 21613:
				itemDef.name = "Custom Extreme owner cape";
				itemDef.modelID = 64462;
				itemDef.maleEquip1 = 64463;
				itemDef.femaleEquip1 = 64463;
				itemdefedit = ItemDefinition.get(2414);
//	itemDef.modelID = 65333;
				//itemDef.maleWearId = 65334;
				//itemDef.femaleWearId = 65334;
				itemDef.actions = itemdefedit.actions;
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				//	itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.oldColors = new int[]{57};
				itemDef.newColors = new int[]{52};
//	itemDef.actions[3] = "<col=f8a6c1>Activate god mode";

				//itemDef.rdc2 = 762432;
//	itemDef.modelZoom = 1385;
//	itemDef.modelOffset1 = 0;
//	itemDef.modelOffsetY = 24;
//	itemDef.modelRotationY = 279;
//	itemDef.modelRotationX = 948;
				break;
			case 8828:
				itemDef.name = "Elite helm (melee)";
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 80;
				itemDef.modelZoom = 913;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.modelID = 16373;
				itemDef.maleEquip1 = 16373;
				itemDef.femaleEquip1 = 16373;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
			case 8829:
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 50;
				itemDef.modelZoom = 1580;
				itemDef.rotationY = 20;
				itemDef.rotationX = 0;
				itemDef.name = "Elite body (melee)";
				itemDef.modelZoom = 1400;
				itemDef.modelID = 16374;
				itemDef.maleEquip1 = 16374;
				itemDef.femaleEquip1 = 16374;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;

			case 8833:
				itemDef.name = "Elite legs (melee)";
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 5;
				itemDef.modelZoom = 1757;
				itemDef.rotationY = 0;
				itemDef.rotationX = 2040;
				itemDef.modelID = 16375;
				itemDef.maleEquip1 = 16375;
				itemDef.femaleEquip1 = 16375;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
				
			case 15642:
				itemDef.name = "Elite helm (ranged)";
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 80;
				itemDef.modelZoom = 773;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.modelID = 16377;
				itemDef.maleEquip1 = 16377;
				itemDef.femaleEquip1 = 16377;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
				
			case 15643:
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 50;
				itemDef.modelZoom = 1580;
				itemDef.rotationY = 20;
				itemDef.rotationX = 0;
				itemDef.name = "Elite body (ranged)";
				itemDef.modelZoom = 1400;
				itemDef.modelID = 16376;
				itemDef.maleEquip1 = 16376;
				itemDef.femaleEquip1 = 16376;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;

			case 15644:
				itemDef.name = "Elite legs (ranged)";
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 5;
				itemDef.modelZoom = 1757;
				itemDef.rotationY = 0;
				itemDef.rotationX = 2040;
				itemDef.modelID = 16390;
				itemDef.maleEquip1 = 16390;
				itemDef.femaleEquip1 = 16390;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
				
			case 15645:
				itemDef.name = "Elite helm (mage)";
				itemDef.modelID = 16396;
				itemDef.maleEquip1 = 16396;
				itemDef.femaleEquip1 = 16396;
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 80;
				itemDef.modelZoom = 913;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 15646:
				itemDef.name = "Elite body (mage)";
				itemDef.modelID = 16399;
				itemDef.maleEquip1 = 16399;
				itemDef.femaleEquip1 = 16399;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 50;
				itemDef.modelZoom = 1400;
				itemDef.rotationY = 20;
				itemDef.rotationX = 0;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 15647:
				itemDef.name = "Elite legs (mage)";
				itemDef.modelID = 16404;
				itemDef.maleEquip1 = 16404;
				itemDef.femaleEquip1 = 16404;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 5;
				itemDef.modelZoom = 1757;
				itemDef.rotationY = 0;
				itemDef.rotationX = 2040;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 6927:
				//itemDef.rdc2 = 23339;
				itemDef.name = "Paladins helmet";
				ItemDefinition itemGWD3113 = ItemDefinition.get(4882);
				itemDef.modelID = 16913;
				itemDef.femaleEquip1 = 16913;
				itemDef.maleEquip1 = 16913;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 200;
				itemDef.modelZoom = 513;
				itemDef.rotationY = 180;
				itemDef.rotationX = 0;
				itemDef.actions = itemGWD3113.actions;
				itemDef.stackable = false;
				break;
			case 6928:
				itemDef.name = "Paladins chainbody";
				ItemDefinition itemGWD31133 = ItemDefinition.get(4894);
				itemDef.modelID = 17006;
				itemDef.femaleEquip1 = 17006;
				itemDef.maleEquip1 = 17006;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 50;
				itemDef.modelZoom = 1680;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.actions = itemGWD31133.actions;	
				itemDef.stackable = false;
				break;
			case 6929:
				ItemDefinition itemGWD311dd3 = ItemDefinition.get(5576);
				itemDef.name = "Paladins plateskirt";		
				itemDef.modelID = 17027;
				itemDef.femaleEquip1 = 17027;
				itemDef.maleEquip1 = 17027;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelZoom = 1870;
				itemDef.rotationY = 0;
				itemDef.rotationX = 40;
				itemDef.actions = itemGWD311dd3.actions;
				itemDef.stackable = false;
				break;
			case 14176:
				itemDef.name = "Dragon King helmet";
				itemDef.modelID = 16061;
				itemDef.maleEquip1 = 16062;
				itemDef.femaleEquip1 = 16062;
				itemdefedit = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 14172:
				itemDef.name = "Dragon King body";
				itemDef.modelID = 16065;
				itemDef.maleEquip1 = 16066;
				itemDef.femaleEquip1 = 16066;
				itemdefedit = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				break;
			case 14174:
				itemDef.name = "Dragon King legs";
				itemDef.modelID = 16063;
				itemDef.maleEquip1 = 16064;
				itemDef.femaleEquip1 = 16064;
				itemdefedit = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefedit.modelOffsetX;
				itemDef.modelOffsetY = itemdefedit.modelOffsetY;
				itemDef.modelZoom = itemdefedit.modelZoom;
				itemDef.rotationY = itemdefedit.rotationY;
				itemDef.rotationX = itemdefedit.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				//itemDef.rdc2  = 20483;
				break;
		}
		return itemDef;
	}

	public static ItemDefinition itemDef(int id, ItemDefinition itemDef) {
		// TODO Auto-generated method stub
		return null;
	}

}
