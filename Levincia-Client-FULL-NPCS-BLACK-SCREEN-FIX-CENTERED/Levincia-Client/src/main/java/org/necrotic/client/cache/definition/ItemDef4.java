package org.necrotic.client.cache.definition;

public class ItemDef4 {

	public static ItemDefinition newIDS(ItemDefinition itemDef, int id) {
		ItemDefinition itemDef2;
		ItemDefinition itemDef21;
		ItemDefinition finity;
		switch (id) {
			case 23230:
				itemDef.name = "Owner Amulet";
				itemDef.modelID = 19670;
				itemDef.maleEquip1 = 19669;
				itemDef.femaleEquip1 = 19669;
				itemDef.modelZoom = 473;
				itemDef.rotationX = 50;
				itemDef.rotationY = 313;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = -3;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;
			case 23231:
				itemDef.copyItem(6737);
				itemDef.name = "Owner Ring";
				itemDef.modelID = 19671;
				itemDef.maleEquip1 = -1;
				itemDef.femaleEquip1 = -1;
				itemDef.scaleX = 32;
				itemDef.scaleY = 32;
				itemDef.scaleZ = 32;
				itemDef.modelZoom = 515;
				itemDef.rotationX = 1940;
				itemDef.rotationY = 508;
				itemDef.rotationZ = 1927;
				itemDef.modelOffsetX = -3;
				itemDef.modelOffsetY = 4;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;


			case 23232:
				itemDef.name = "Owner Bracelet";
				itemDef.modelID = 19672;
				itemDef.maleEquip1 = 19673;
				itemDef.femaleEquip1 = 19673;
				itemDef.maleModelScale = 4;
				itemDef.maleWieldY = 4;
				itemDef.maleWieldZ = -1;
				itemDef.modelZoom = 515;
				itemDef.rotationX = 228;
				itemDef.rotationY = 389;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 2;
				itemDef.actions = new String[]{null, "Wear", "Disassemble", null, null};
				break;
			case 23233:
				itemDef.copyItem(23230);
				itemDef.name = "Owner Amulet (u)";
				itemDef.modelID = 19676;
				itemDef.maleEquip1 = 19675;
				itemDef.femaleEquip1 = 19675;
				break;
			case 23234:
				itemDef.copyItem(23231);
				itemDef.name = "Owner Ring (u)";
				itemDef.modelID = 19677;
				itemDef.maleEquip1 = -1;
				itemDef.femaleEquip1 = -1;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;


			case 23235:
				itemDef.copyItem(23232);
				itemDef.name = "Owner Bracelet (u)";
				itemDef.modelID = 19678;
				itemDef.maleEquip1 = 19679;
				itemDef.femaleEquip1 = 19679;
				itemDef.maleModelScale = 4;
				itemDef.maleWieldY = 4;
				itemDef.maleWieldZ = -1;
				itemDef.modelZoom = 515;
				itemDef.rotationX = 228;
				itemDef.rotationY = 389;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 2;
				break;

			case 23293:
				itemDef.copyItem(23230);
				itemDef.name = "<col=89584A>Fantasy Amulet";
				itemDef.modelID = 19718;
				itemDef.maleEquip1 = 19719;
				itemDef.femaleEquip1 = 19719;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;

			case 23280:
				itemDef.copyItem(23231);
				itemDef.name = "<col=89584A>Fantasy Ring";
				itemDef.modelID = 19720;
				itemDef.maleEquip1 = -1;
				itemDef.femaleEquip1 = -1;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;

			case 23292:
				itemDef.copyItem(23232);
				itemDef.name = "<col=89584A>Fantasy Bracelet";
				itemDef.modelID = 19721;
				itemDef.maleEquip1 = 19722;
				itemDef.femaleEquip1 = 19722;
				itemDef.maleModelScale = 4;
				itemDef.maleWieldY = 4;
				itemDef.maleWieldZ = -1;
				itemDef.modelZoom = 515;
				itemDef.rotationX = 228;
				itemDef.rotationY = 389;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 2;
				break;


			case 23447:
				itemDef.copyItem(18665);
				itemDef.name = "Platinum Key";
				itemDef.actions = new String[]{"Teleport", null, null, null, null};
				itemDef.rdc2 = 807999;
				break;

			case 14667:
				itemDef.name = "Mummy fragment";
				itemDef.modelID = ItemDefinition.get(14639).modelID;
				break;

			case 17572:
				itemDef.name = "Weak poison";
				break;
			case 15413:
				itemDef.name = "Poisoned milk";
				itemDef.modelID = 19557;
				break;
			case 7546:
				itemDef.name = "Rancid flour";
				itemDef.rdc2 = 10;
				break;


			case 23755:
				itemDef.name = "Crimson Scroll";
				itemDef.modelID = 2774;
				itemDef.maleEquip1 = -1;
				itemDef.femaleEquip1 = -1;
				itemDef.modelZoom = 1000;
				itemDef.rotationY = 255;
				itemDef.rotationX = 1719;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 50;
				itemDef.actions = new String[]{"Claim", null, null, null, "Drop"};
				itemDef.oldColors = new int[]{5440, 5452, 1938, 5427,};
				itemDef.newColors = new int[]{85823, 38, 85823, 87823,};
				break;

			case 23759:
				itemDef.stackable = true;
				itemDef.actions = new String[]{null, null, null, null, null};
				itemDef.name = "Crimson flakes";
				itemDef.actions[2] = "Disassemble";
				itemDef.actions[3] = "Disassemble All";
				itemDef.modelID = 43204;
				itemDef.maleEquip1 = -1;
				itemDef.femaleEquip1 = -1;
				itemDef.modelZoom = 2000;
				itemDef.rotationY = 356;
				itemDef.rotationX = 148;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 18;
				itemDef.oldColors = new int[]{13392, 13412,};
				itemDef.newColors = new int[]{87823, 50,};
				break;

				case 3696:
				itemDef.name = "Necromancer DR Booster";
				itemDef.actions = new String[]{"Claim", null, null, null, "Drop"};
				itemDef.modelID = 20852;
				itemDef.rotationX = 316;
				itemDef.rotationY = 1472;
				itemDef.modelOffsetY = 1;
				itemDef.modelOffsetX = -3;
				itemDef.rotationZ = 1953;
				itemDef.modelZoom = 750;
				itemDef.oldColors = new int[] {1374, 1500, 962, 931, 945, 922};
				itemDef.newColors = new int[] {-59781, -59760, -59794, -60244, -60120, -59738};
				break;
			case 3698:
				itemDef.name = "Elder DR Booster";
				itemDef.actions = new String[]{"Claim", null, null, null, "Drop"};
				itemDef.modelID = 20852;
				itemDef.rotationX = 316;
				itemDef.rotationY = 1472;
				itemDef.modelOffsetY = 1;
				itemDef.modelOffsetX = -3;
				itemDef.rotationZ = 1953;
				itemDef.modelZoom = 750;
				itemDef.oldColors = new int[] {1374, 1500, 962, 931, 945, 922};
				itemDef.newColors = new int[] {-50244, -50120, -50738, -50781, -50760, -50794};
				break;


			case 18649:
				itemDef.name = "Suffering Booster";
				itemDef.actions = new String[]{"Claim", null, null, null, "Drop"};
				itemDef.modelID = 20852;
				itemDef.rotationX = 316;
				itemDef.rotationY = 1472;
				itemDef.modelOffsetY = 1;
				itemDef.modelOffsetX = -3;
				itemDef.rotationZ = 1953;
				itemDef.modelZoom = 750;
				break;

			case 23552:
				itemDef.copyItem(15360);
				itemDef.name = "Max Scroll";
				itemDef.rdc2 = 41124262;
				itemDef.actions = new String[]{"Claim", null, null, null, "Drop"};
				break;
			case 23553:
				itemDef.copyItem(7478);
				itemDef.name = "Tier Skip Token";
				itemDef.rdc2 = 34124262;
				itemDef.actions = new String[]{"Claim", null, null, null, "Drop"};
				break;
			case 23401:
				itemDef.copyItem(14808);
				itemDef.name = "Scroll of Insurance";
				itemDef.rdc2 = 3262;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				break;

			case 17815:
				itemDef.name = "Raw fury shark";
				itemDef2 = ItemDefinition.get(20429);
				itemDef.modelOffsetX = itemDef2.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemDef2.modelOffsetY;
				itemDef.modelZoom = itemDef2.modelZoom;
				itemDef.rotationY = itemDef2.rotationY;
				itemDef.rotationX = itemDef2.rotationX;
				itemDef.modelID = itemDef2.modelID;

				//itemDef.rdc2 = 3262;
				break;
			case 9079:
				itemDef.name = "Collector Donation [Special]";
				itemDef2 = ItemDefinition.get(15287);
				itemDef.modelOffsetX = itemDef2.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemDef2.modelOffsetY;
				itemDef.modelZoom = itemDef2.modelZoom;
				itemDef.rotationY = itemDef2.rotationY;
				itemDef.rotationX = itemDef2.rotationX;
				itemDef.modelID = itemDef2.modelID;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop";
				itemDef.actions[0] = "Claim";
				itemDef.rdc2 = 3262;
				break;
			case 9080:
				itemDef.name = "@cya@Colossal Part @or1@[1]";
				itemDef2 = ItemDefinition.get(15287);
				itemDef.modelOffsetX = itemDef2.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemDef2.modelOffsetY;
				itemDef.modelZoom = itemDef2.modelZoom;
				itemDef.rotationY = itemDef2.rotationY;
				itemDef.rotationX = itemDef2.rotationX;
				itemDef.modelID = itemDef2.modelID;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop";
				itemDef.rdc2 = 24292;
				break;
			case 9081:
				itemDef.name = "@cya@Colossal Part @or2@[2]";
				itemDef2 = ItemDefinition.get(15287);
				itemDef.modelOffsetX = itemDef2.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemDef2.modelOffsetY;
				itemDef.modelZoom = itemDef2.modelZoom;
				itemDef.rotationY = itemDef2.rotationY;
				itemDef.rotationX = itemDef2.rotationX;
				itemDef.modelID = itemDef2.modelID;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop";
				itemDef.rdc2 = 99282;
				break;
			case 9082:
				itemDef.name = "@cya@Colossal Part @or3@[3]";
				itemDef2 = ItemDefinition.get(15287);
				itemDef.modelOffsetX = itemDef2.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemDef2.modelOffsetY;
				itemDef.modelZoom = itemDef2.modelZoom;
				itemDef.rotationY = itemDef2.rotationY;
				itemDef.rotationX = itemDef2.rotationX;
				itemDef.modelID = itemDef2.modelID;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop";
				itemDef.rdc2 = 28522;
				break;
			case 9083:
				itemDef.name = "@red@Rage Attachment";
				itemDef2 = ItemDefinition.get(15287);
				itemDef.modelOffsetX = itemDef2.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemDef2.modelOffsetY;
				itemDef.modelZoom = itemDef2.modelZoom;
				itemDef.rotationY = itemDef2.rotationY;
				itemDef.rotationX = itemDef2.rotationX;
				itemDef.modelID = itemDef2.modelID;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop";
				itemDef.rdc2 = 215;
				break;
			case 9084:
				itemDef.name = "@mag@Collector's Attachment";
				itemDef2 = ItemDefinition.get(15287);
				itemDef.modelOffsetX = itemDef2.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemDef2.modelOffsetY;
				itemDef.modelZoom = itemDef2.modelZoom;
				itemDef.rotationY = itemDef2.rotationY;
				itemDef.rotationX = itemDef2.rotationX;
				itemDef.modelID = itemDef2.modelID;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop";
				itemDef.rdc2 = 39922;
				break;
			case 9085:
				itemDef.name = "Weapon set Donation  [Special]";
				itemDef2 = ItemDefinition.get(15287);
				itemDef.modelOffsetX = itemDef2.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemDef2.modelOffsetY;
				itemDef.modelZoom = itemDef2.modelZoom;
				itemDef.rotationY = itemDef2.rotationY;
				itemDef.rotationX = itemDef2.rotationX;
				itemDef.modelID = itemDef2.modelID;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop";
				itemDef.actions[0] = "Claim";

				itemDef.rdc2 = 2395328;
				break;
			case 17817:
				itemDef.name = "Fury shark";
				itemDef2 = ItemDefinition.get(20429);
				itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemDef2.modelOffsetY;
				itemDef.modelZoom = itemDef2.modelZoom;
				itemDef.rotationY = itemDef2.rotationY;
				itemDef.rotationX = itemDef2.rotationX;
				itemDef.modelID = itemDef2.modelID;
				itemDef.oldColors = itemDef2.oldColors;
				itemDef.newColors = itemDef2.newColors;
				break;

			case 8940:
				itemDef.name = "Bulwark helm";
				itemDef.modelID = 65354;
				itemDef.maleEquip1 = 65355;
				itemDef.femaleEquip1 = 65355;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 57; // the texture that it currently has
				itemDef.newColors[0] = 75; //
				break;

			case 8941:
				itemDef.name = "Bulwark body";
				itemDef.modelID = 65356;
				itemDef.maleEquip1 = 65357;
				itemDef.femaleEquip1 = 65357;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 57; // the texture that it currently has
				itemDef.newColors[0] = 75; //
				break;

			case 8942:
				itemDef.name = "Bulwark legs";
				itemDef.modelID = 65358;
				itemDef.maleEquip1 = 65359;
				itemDef.femaleEquip1 = 65359;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 57; // the texture that it currently has
				itemDef.newColors[0] = 75; //
				break;
			case 17594:
				itemDef.copyItem(4882);
				itemDef.name = "Bork helm";
				itemDef.modelID = 19543;
				itemDef.maleEquip1 = 19544;
				itemDef.femaleEquip1 = 19544;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 17596:
				itemDef.name = "Bork body";
				itemDef.modelID = 19545;
				itemDef.maleEquip1 = 19546;
				itemDef.femaleEquip1 = 19546;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				break;
			case 17598:
				itemDef.name = "Bork legs";
				itemDef.modelID = 19547;
				itemDef.maleEquip1 = 19548;
				itemDef.femaleEquip1 = 19548;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				break;
			case 17608:
				itemDef.name = "Darkrealm helm";
				itemDef.modelID = 65492;
				itemDef.maleEquip1 = 65493;
				itemDef.femaleEquip1 = 65493;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				itemDef.rdc2 = 29525;
				break;

			case 17610:
				itemDef.name = "Darkrealm body";
				itemDef.modelID = 65494;
				itemDef.maleEquip1 = 65495;
				itemDef.femaleEquip1 = 65495;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 8657;
				break;

			case 17612:
				itemDef.name = "Darkrealm legs";
				itemDef.modelID = 65496;
				itemDef.maleEquip1 = 65497;
				itemDef.femaleEquip1 = 65497;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 7467;
				break;
			case 17614:
				itemDef.name = "<col=7d9781>Shadow Torva helm";
				itemDef.modelID = 65498;
				itemDef.maleEquip1 = 65499;
				itemDef.femaleEquip1 = 65499;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;


				break;

			case 17616:
				itemDef.name = "<col=7d9781>Shadow Torva body";
				itemDef.modelID = 65500;
				itemDef.maleEquip1 = 65501;
				itemDef.femaleEquip1 = 65501;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				break;

			case 17618:
				itemDef.name = "<col=7d9781>Shadow Torva legs";
				itemDef.modelID = 65502;
				itemDef.maleEquip1 = 65503;
				itemDef.femaleEquip1 = 65503;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17606:
				itemDef.name = "<col=7d9781>Shadow wings";
				itemDef.modelID = 65504;
				itemDef.maleEquip1 = 65505;
				itemDef.femaleEquip1 = 65505;
				itemDef21 = ItemDefinition.get(18509);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17626:
				itemDef.name = "Firefly helm";
				itemDef.modelID = 65511;
				itemDef.maleEquip1 = 65512;
				itemDef.femaleEquip1 = 65512;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 3399200;

				break;

			case 17628:
				itemDef.name = "Firefly body";
				itemDef.modelID = 65513;
				itemDef.maleEquip1 = 65514;
				itemDef.femaleEquip1 = 65514;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 9999;
				break;

			case 17630:
				itemDef.name = "Firefly legs";
				itemDef.modelID = 65515;
				itemDef.maleEquip1 = 65516;
				itemDef.femaleEquip1 = 65516;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 3399200;
				break;
			case 17646:
				itemDef.name = "Salarumai helm";
				itemDef.modelID = 65529;
				itemDef.maleEquip1 = 65530;
				itemDef.femaleEquip1 = 65530;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17648:
				itemDef.name = "Salarumai body";
				itemDef.modelID = 65531;
				itemDef.maleEquip1 = 65532;
				itemDef.femaleEquip1 = 65532;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17650:
				itemDef.name = "Salarumai legs";
				itemDef.modelID = 65533;
				itemDef.maleEquip1 = 65534;
				itemDef.femaleEquip1 = 65534;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 17652:
				itemDef.name = "Rampage Claws";
				itemDef.modelID = 64001;
				itemDef.maleEquip1 = 64000;
				itemDef.femaleEquip1 = 64000;
				itemDef21 = ItemDefinition.get(15701);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 17654:
				itemDef.name = "Fiery bow";
				itemDef.modelID = 64003;
				itemDef.maleEquip1 = 64002;
				itemDef.femaleEquip1 = 64002;
				itemDef21 = ItemDefinition.get(15701);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 17656:
				itemDef.name = "Excavator spear";
				itemDef.modelID = 64004;
				itemDef.maleEquip1 = 64005;
				itemDef.femaleEquip1 = 64005;
				itemDef21 = ItemDefinition.get(7809);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 17660:
				itemDef.name = "Thor's hammer";
				itemDef.modelID = 64006;
				itemDef.maleEquip1 = 64007;
				itemDef.femaleEquip1 = 64007;
				itemDef21 = ItemDefinition.get(7809);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 17662:
				itemDef.name = "zeus flagcape";
				itemDef.modelID = 64008;
				itemDef.maleEquip1 = 64009;
				itemDef.femaleEquip1 = 64009;
				itemDef21 = ItemDefinition.get(19709);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				
				break;
			case 14829:
				itemDef.name = "Hidden flagcape";
				itemDef.modelID = 64008;
				itemDef.maleEquip1 = 64009;
				itemDef.femaleEquip1 = 64009;
				itemDef21 = ItemDefinition.get(19709);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 2052905;
				break;
			case 17664:
				itemDef.name = "Patronum Scythe";
				itemDef.modelID = 64010;
				itemDef.maleEquip1 = 64011;
				itemDef.femaleEquip1 = 64011;
				itemDef21 = ItemDefinition.get(7809);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17666:
				itemDef.name = "Patronum Blade";
				itemDef.modelID = 64012;
				itemDef.maleEquip1 = 64013;
				itemDef.femaleEquip1 = 64013;
				itemDef21 = ItemDefinition.get(7809);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17668:
				itemDef.name = "Hand stick";
				itemDef.modelID = 64014;
				itemDef.maleEquip1 = 64015;
				itemDef.femaleEquip1 = 64015;
				itemDef21 = ItemDefinition.get(7809);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 22100:
				itemDef.copyItem(4708);
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.name = "Fallen Angel's head";
				itemDef.modelID = 17048;
				itemDef.maleEquip1 = 17049;
				itemDef.femaleEquip1 = 17049;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 14472:
				itemDef.copyItem(4082);
				itemDef.name = "<col=d5d5d5>Light shard</col>";
				itemDef.rdc = 127;
				itemDef.modelOffsetY = -2;
				itemDef.actions = new String[]{null, null, null, null, "Destroy"};
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
			case 14474:
				itemDef.copyItem(4082);
				itemDef.name = "@bla@Dark shard</col>";
				itemDef.rdc = 20;
				itemDef.modelOffsetY = -2;
				itemDef.actions = new String[]{null, null, null, null, "Destroy"};
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
			case 23238:
				itemDef.copyItem(4082);
				itemDef.name = "<col=9f0808>Blood shard</col>";
				itemDef.rdc = 946;
				itemDef.modelOffsetY = -2;
				itemDef.actions = new String[]{null, null, null, null, "Destroy"};
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
			case 22101:
				itemDef.copyItem(4712);
				itemDef.name = "Fallen Angel's body";
				itemDef.modelID = 17055;
				itemDef.modelZoom = 1500;
				itemDef.maleEquip1 = 17056;
				itemDef.femaleEquip1 = 17056;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 22102:
				itemDef.copyItem(4714);
				itemDef.name = "Fallen Angel's legs";
				itemDef.modelID = 17057;
				itemDef.maleEquip1 = 17061;
				itemDef.femaleEquip1 = 17061;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 22103:
				itemDef.copyItem(20456);
				itemDef.name = "Fallen Angel's boots";
				itemDef21 = ItemDefinition.get(3791);
				itemDef.modelID = 17066;
				itemDef.maleEquip1 = 17066;
				itemDef.femaleEquip1 = 17066;
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;
			case 22104:
				itemDef.copyItem(14602);
				itemDef.name = "Fallen Angel's gloves";
				itemDef.modelID = 17096;
				itemDef.maleEquip1 = 17097;
				itemDef.femaleEquip1 = 17097;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 22105:
				itemDef.name = "Fallen Angel's wings";
				itemDef.modelID = 17198;
				itemDef.maleEquip1 = 17197;
				itemDef.femaleEquip1 = 17197;
				itemDef21 = ItemDefinition.get(19709);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = 2650;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = 1000;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 22106:
				itemDef.name = "Fallen Angel's Attachment";
				itemDef21 = ItemDefinition.get(12159);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.modelID = itemDef21.modelID;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = itemDef21.actions;
				itemDef.rdc3 = 10;
				itemDef.stackable = true;
				break;
			case 22107:
				itemDef.name = "Fallen Angel pet";
				itemDef.modelID = 17029;
				itemDef.rotationX = 0;
				itemDef.rotationY = 0;
				itemDef.modelZoom = 2800;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 23436:
				itemDef.name = "Spirit of Scorpius pet";
				itemDef.modelID = 21155;
				itemDef.rotationX = 0;
				itemDef.rotationY = 0;
				itemDef.modelZoom = 2800;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;

			case 23437:
				itemDef.name = "Evil Spirit of Scorpius pet";
				itemDef.modelID = 21155;
				itemDef.rotationX = 0;
				itemDef.rotationY = 0;
				itemDef.modelZoom = 2800;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.rdc3 = 1;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 23382:
				itemDef.name = "Cthulu offspring";
				itemDef.modelID = 19256;
				itemDef.rotationX = 0;
				itemDef.rotationY = 0;
				itemDef.modelZoom = 3500;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 23323:
				itemDef.name = "Summer Surfer pet";
				itemDef.modelID = 19486;
				itemDef.rotationX = 0;
				itemDef.rotationY = 0;
				itemDef.modelZoom = 4500;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;





			case 23387:
				itemDef.copyItem(23324);
				itemDef.modelID = 19580;
				itemDef.name = "Lesarkus Warrior pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;

			case 23388:
				itemDef.copyItem(23324);
				itemDef.modelID = 19581;
				itemDef.name = "Fatal Warrior pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;

			case 23389:
				itemDef.copyItem(23324);
				itemDef.modelID = 19582;
				itemDef.name = "Immortal Warrior pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;

			case 23324:
				itemDef.name = "Faceless Magician pet";
				itemDef.modelID = 19463;
				itemDef.rotationX = 0;
				itemDef.rotationY = 0;
				itemDef.modelZoom = 3500;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;

			case 23325:
				itemDef.name = "Lotus Magician pet";
				itemDef.modelID = 19483;
				itemDef.rotationX = 0;
				itemDef.rotationY = 0;
				itemDef.modelZoom = 3500;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;

			case 23326:
				itemDef.name = "Shadow Magician pet";
				itemDef.modelID = 19484;
				itemDef.rotationX = 0;
				itemDef.rotationY = 0;
				itemDef.modelZoom = 3500;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;

			case 18883:
				itemDef.copyItem(7671);
				itemDef.name = "Deity gloves";
				itemDef.modelID = 65360;
				itemDef.femaleEquip1 = 65361;
				itemDef.maleEquip1 = 65361;
				itemDef.actions = itemDef.actions;
				itemDef.rdc2 = 42812;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;
			case 18881:
				itemDef.copyItem(3791);
				itemDef.name = "Deity Boots";
				itemDef.modelID = 65226;
				itemDef.maleEquip1 = 65226;
				itemDef.femaleEquip1 = 65226;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 93; // the new texture u want it to have
				itemDef.stackable = false;
				break;


			case 19810:
				itemDef.copyItem(10666);
				itemDef.name = "Deity spirit shield";
				itemDef.modelID = 65228;
				itemDef.maleEquip1 = 65227;
				itemDef.femaleEquip1 = 65227;
				itemDef.modelOffsetY = 6;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 62; // the texture that it currently has
				itemDef.newColors[0] = 93; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 22108:
				itemDef.name = "Currency Pouch";
				itemDef21 = ItemDefinition.get(12155);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.modelID = itemDef21.modelID;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{"Look inside", null, "Withdraw", null, null};
				itemDef.rdc3 = 11007;
				itemDef.stackable = false;
				break;
			case 22109:
				itemDef.name = "Owner Cape (u)";
				itemDef.modelID = 100_006;
				itemDef.maleEquip1 = 100_007;
				itemDef.femaleEquip1 = 100_007;
				itemDef.modelZoom = 1947;
				itemDef.rotationX = 1254;
				itemDef.rotationY = 400;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 6;
				break;
			case 22110:
				itemDef.name = "Owner's Attachment";
				itemDef2 = ItemDefinition.get(15287);
				itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemDef2.modelOffsetY;
				itemDef.modelZoom = itemDef2.modelZoom;
				itemDef.rotationY = itemDef2.rotationY;
				itemDef.rotationX = itemDef2.rotationX;
				itemDef.modelID = itemDef2.modelID;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop";
				itemDef.rdc2 = 53921;
				break;
			case 22111:
				itemDef.name = "Owner's Aura";
				itemDef.modelID = 100_008;
				itemDef.maleEquip1 = 100_009;
				itemDef.femaleEquip1 = 100_009;
				itemDef.rotationX = 1000;
				itemDef.modelZoom = 2000;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.oldColors = new int[]{55};
				itemDef.newColors = new int[]{52};
				break;

			case 23241:
				itemDef.copyItem(22111);
				itemDef.name = "Owner's Aura (u)";
				itemDef.modelID = 100_008;
				itemDef.maleEquip1 = 100_009;
				itemDef.femaleEquip1 = 100_009;
				break;

			case 779:
				itemDef.name = "Crest part 1";
				itemDef.rdc3 = 1;
				itemDef.modelZoom = 1400;
				itemDef.modelOffsetY = -35;
				break;

			case 780:
				itemDef.name = "Crest part 2";
				itemDef.rdc3 = 1;
				itemDef.modelZoom = 1300;
				itemDef.modelOffsetX = 20;
				itemDef.modelOffsetY = -5;
				break;

			case 781:
				itemDef.name = "Crest part 3";
				itemDef.rdc3 = 1;
				itemDef.modelZoom = 1400;
				itemDef.modelOffsetY = 25;
				break;

			case 782:
				itemDef.copyItem(12855);
				itemDef.name = "Empty Crest";
				itemDef.stackable = false;
				itemDef.modelID = 17532;
				itemDef.modelZoom = 1150;
				itemDef.actions = new String[]{null, null, null, null, null};
				break;

			case 23243:
				itemDef.copyItem(12855);
				itemDef.modelID = 19792;
				itemDef.name = "Melee Crest (Dark)";
				itemDef.stackable = false;
				itemDef.modelZoom = 1150;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[2] = "Dissassemble";
				itemDef.actions[4] = "Drop";
				break;
				
			case 23244:
				itemDef.copyItem(12855);
				itemDef.modelID = 19813;
				itemDef.name = "Magic Crest (Dark)";
				itemDef.stackable = false;
				itemDef.modelZoom = 1150;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[2] = "Dissassemble";
				itemDef.actions[4] = "Drop";
				break;
				
			case 23245:
				itemDef.copyItem(12855);
				itemDef.modelID = 19816;
				itemDef.name = "Ranged Crest (Dark)";
				itemDef.stackable = false;
				itemDef.modelZoom = 1150;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[2] = "Dissassemble";
				itemDef.actions[4] = "Drop";
				break;
				

			case 23246: //outside 969696 //inside #a19a99 //bottom to top > #a9a5a4,#b0aeae,#c9c1c0,#cbc3c3  ,#d5cfce
				itemDef.copyItem(12855);
				itemDef.modelID = 19792;
				itemDef.name = "Melee Crest (Light)";
				itemDef.stackable = false;
				itemDef.modelZoom = 1150;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[2] = "Dissassemble";
				itemDef.actions[4] = "Drop";
				itemDef.oldColors = new int[]{0, 19, 6, 38, 31, 27, 23, 20};
				itemDef.newColors = new int[]{0, 19 + 80, 76, 38 + 80, 31 + 80, 27 + 80, 23 + 80, 20 + 80};
				break;
				
			case 23247:
				itemDef.copyItem(12855);
				itemDef.modelID = 19813;
				itemDef.name = "Magic Crest (Light)";
				itemDef.stackable = false;
				itemDef.modelZoom = 1150;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[2] = "Dissassemble";
				itemDef.actions[4] = "Drop";
				itemDef.oldColors = new int[]{0, 19, 6, 38, 31, 27, 23, 20};
				itemDef.newColors = new int[]{0, 19 + 80, 76, 38 + 80, 31 + 80, 27 + 80, 23 + 80, 20 + 80};
				break;
				
			case 23248:
				itemDef.copyItem(12855);
				itemDef.modelID = 19816;
				itemDef.name = "Ranged Crest (Light)";
				itemDef.stackable = false;
				itemDef.modelZoom = 1150;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[2] = "Dissassemble";
				itemDef.actions[4] = "Drop";
				itemDef.oldColors = new int[]{0, 19, 6, 38, 31, 27, 23, 20};
				itemDef.newColors = new int[]{0, 19 + 80, 76, 38 + 80, 31 + 80, 27 + 80, 23 + 80, 20 + 80};
				break;
				
			case 23249:
				itemDef.copyItem(12855);
				itemDef.modelID = 19792;
				itemDef.name = "Melee Crest (Blood)";
				itemDef.stackable = false;
				itemDef.modelZoom = 1150;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[2] = "Dissassemble";
				itemDef.actions[4] = "Drop";
				itemDef.oldColors = new int[]{0, 19, 6, 38, 31, 27, 23, 20};
				itemDef.newColors = new int[]{0, 19 + 900, 792, 38 + 900, 31 + 900, 27 + 900, 23 + 900, 20 + 900};
				break;
				
			case 23250:
				itemDef.copyItem(12855);
				itemDef.modelID = 19813;
				itemDef.name = "Magic Crest (Blood)";
				itemDef.stackable = false;
				itemDef.modelZoom = 1150;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[2] = "Dissassemble";
				itemDef.actions[4] = "Drop";
				itemDef.oldColors = new int[]{0, 19, 6, 38, 31, 27, 23, 20};
				itemDef.newColors = new int[]{0, 19 + 900, 792, 38 + 900, 31 + 900, 27 + 900, 23 + 900, 20 + 900};
				break;
				
			case 23251:
				itemDef.copyItem(12855);
				itemDef.modelID = 19816;
				itemDef.name = "Ranged Crest (Blood)";
				itemDef.stackable = false;
				itemDef.modelZoom = 1150;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[2] = "Dissassemble";
				itemDef.actions[4] = "Drop";
				itemDef.oldColors = new int[]{0, 19, 6, 38, 31, 27, 23, 20};
				itemDef.newColors = new int[]{0, 19 + 900, 792, 38 + 900, 31 + 900, 27 + 900, 23 + 900, 20 + 900};
				break;
				
				
			case 22112:
				itemDef.name = "<shad=1>@bla@Dark Attachment";
				itemDef21 = ItemDefinition.get(12159);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.modelID = itemDef21.modelID;
				System.out.println ("Model id:"+ itemDef21.modelID);
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = itemDef21.actions;
				itemDef.rdc3 = 1;
				break;
			case 23239:
				itemDef.name = "Blood Attachment";
				itemDef21 = ItemDefinition.get(12159);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.modelID = itemDef21.modelID;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = itemDef21.actions;
				itemDef.colorChange = new double[]{1.1, 0.2, 0.2};
				break;
			case 23438:
				itemDef.name = "<shad=1>@bla@Halloween Attachment";
				itemDef21 = ItemDefinition.get(12159);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.modelID = itemDef21.modelID;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = itemDef21.actions;
				itemDef.rdc3 = 1454787;
				break;

			case 11235:
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 22113:
				itemDef.copyItem(5012);
				itemDef.name = "Dark Twisted bow";
				itemDef.colorChange = new double[]{0.6, 0.6, 0.6};
				break;
				
			case 22114:
				itemDef.copyItem(17011);
				itemDef.name = "Dark Sanguinesti Staff";
				itemDef.colorChange = new double[]{0.6, 0.6, 0.6};
				break;
				
			case 22115:
				itemDef.copyItem(12537);
				itemDef.name = "Dark Scythe of Vitur";
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{57};
				break;
				
			case 22116:
				itemDef.name = "Iron's pet";
				itemDef.modelID = 100026;
				itemDef.rotationX = 0;
				itemDef.rotationY = 468;
				itemDef.modelZoom = 694;
				itemDef.modelOffsetX = 7;
				itemDef.modelOffsetY = -7;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 22117:
				itemDef.name = "Zenyte shield";
				itemDef.modelID = 100011;
				itemDef.maleEquip1 = 100010;
				itemDef.femaleEquip1 = 100010;
				ItemDefinition def = ItemDefinition.get(18509);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 22118:
				itemDef.name = "Group Ironman's Aura";
				itemDef.modelID = 100_021;
				itemDef.maleEquip1 = 100_020;
				itemDef.femaleEquip1 = 100_020;
				itemDef.rotationX = 1000;
				itemDef.modelZoom = 2000;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 22119:
				itemDef.name = "Ultimate Ironman's Aura";
				itemDef.modelID = 100_023;
				itemDef.maleEquip1 = 100_022;
				itemDef.femaleEquip1 = 100_022;
				itemDef.rotationX = 1000;
				itemDef.modelZoom = 2000;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 22120:
				itemDef.name = "Ironman's Aura";
				itemDef.modelID = 100_025;
				itemDef.maleEquip1 = 100_024;
				itemDef.femaleEquip1 = 100_024;
				itemDef.rotationX = 1000;
				itemDef.modelZoom = 2000;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 22056:
				itemDef.name = "swag chest"; // temp replace later
				itemDef.modelID = 27746;
				itemDef.maleEquip1 = 27746;
				itemDef.femaleEquip1 = 27746;
				break;
			case 22057:
				itemDef.name = "swag chest"; // temp replace later
				itemDef.modelID = 27733;
				itemDef.maleEquip1 = 27733;
				itemDef.femaleEquip1 = 27733;
				break;
			case 20427:// tetsu
				itemDef.name = "Dom!nat!on helm";
				itemDef.modelID = 65420;
				itemDef.maleEquip1 = 65421;
				itemDef.femaleEquip1 = 65421;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{67};
				break;
			case 20260:// tetsu
				itemDef.name = "Dom!nat!on body";
				itemDef.modelID = 65422;
				itemDef.maleEquip1 = 65423;
				itemDef.femaleEquip1 = 65423;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{67};
				break;
			case 20095:// tetsu
				itemDef.name = "Dom!nat!on legs";
				itemDef.modelID = 65424;
				itemDef.maleEquip1 = 65425;
				itemDef.femaleEquip1 = 65425;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{67};
				break;
			case 19828:
				itemDef.name = "Quatrix helm";
				itemDef.modelID = 65192;
				itemDef.maleEquip1 = 65193;
				itemDef.femaleEquip1 = 65193;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19823:
				itemDef.name = "Quatrix body";
				itemDef.modelID = 65194;
				itemDef.maleEquip1 = 65195;
				itemDef.femaleEquip1 = 65195;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19822:
				itemDef.name = "Quatrix legs";
				itemDef.modelID = 65196;
				itemDef.maleEquip1 = 65197;
				itemDef.femaleEquip1 = 65197;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19815:
				itemDef.name = "Quatrix gloves";
				itemDef.modelID = 65198;
				itemDef.maleEquip1 = 65199;
				itemDef.femaleEquip1 = 65199;
				itemDef21 = ItemDefinition.get(7462);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19817:
				itemDef.name = "Quatrix boots";
				itemDef.modelID = 65200;
				itemDef.maleEquip1 = 65200;
				itemDef.femaleEquip1 = 65200;
				itemDef21 = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19818:
				itemDef.name = "Quatrix spear";
				itemDef.modelID = 65201;
				itemDef.maleEquip1 = 65202;
				itemDef.femaleEquip1 = 65202;
				itemDef21 = ItemDefinition.get(1237);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19813:
				itemDef.name = "Dice chain";
				itemDef.modelID = 65203;
				itemDef.maleEquip1 = 65204;
				itemDef.femaleEquip1 = 65204;
				itemDef21 = ItemDefinition.get(1);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19829:
				itemDef.name = "textured pernix cowl";
				itemDef.modelID = 65212;
				itemDef.maleEquip1 = 65213;
				itemDef.femaleEquip1 = 65213;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19827:
				itemDef.name = "textured pernix body";
				itemDef.modelID = 65214;
				itemDef.maleEquip1 = 65215;
				itemDef.femaleEquip1 = 65215;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19826:
				itemDef.name = "textured pernix legs";
				itemDef.modelID = 65216;
				itemDef.maleEquip1 = 65217;
				itemDef.femaleEquip1 = 65217;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19619:
				itemDef.name = "Archie helm";
				itemDef.modelID = 65231;
				itemDef.maleEquip1 = 65232;
				itemDef.femaleEquip1 = 65232;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.oldColors = new int[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61};
				itemDef.newColors = new int[]{64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 64; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 19618:
				itemDef.name = "Archie body";
				itemDef.modelID = 65233;
				itemDef.maleEquip1 = 65234;
				itemDef.femaleEquip1 = 65234;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};

				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 64; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 19474:
				itemDef.name = "Archie chaps";
				itemDef.modelID = 65235;
				itemDef.maleEquip1 = 65236;
				itemDef.femaleEquip1 = 65236;// im not lagging
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};

				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 64; //
				itemDef.stackable = false;
				break;
			case 19821:
				itemDef.name = "Shadow Hood";
				itemDef.modelID = 65218;
				itemDef.maleEquip1 = 65219;
				itemDef.femaleEquip1 = 65219;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[2]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[2]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 78;
				itemDef.oldColors[1] = 1; // the texture that it currently has
				itemDef.newColors[1] = 54;// the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 19820:
				itemDef.name = "Shadow body";
				itemDef.modelID = 65220;
				itemDef.maleEquip1 = 65221;
				itemDef.femaleEquip1 = 65221;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[2]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[2]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 78;
				itemDef.oldColors[1] = 1; // the texture that it currently has
				itemDef.newColors[1] = 54;// the it to have
				itemDef.stackable = false;
				break;
			case 19816:
				itemDef.name = "Shadow legs";
				itemDef.modelID = 65222;
				itemDef.maleEquip1 = 65223;
				itemDef.femaleEquip1 = 65223;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[2]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[2]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 78;
				itemDef.oldColors[1] = 1; // the texture that it currently has
				itemDef.newColors[1] = 54;// the u want it to have
				itemDef.stackable = false;
				break;
			case 19812:
				itemDef.name = "Lava Speed pickaxe";
				itemDef.modelID = 65224;
				itemDef.maleEquip1 = 65225;
				itemDef.femaleEquip1 = 65225;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 40; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 12657:
				itemDef.name = "Penguin pebbles";
				itemDef.rdc2 = 995555;
				break;
			case 12845:
				itemDef.name = "Multiplier @cya@+2";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[2] = "Redeem";

				//itemDef.rdc2 = 4633;
				break;

			case 19620:
				itemDef.name = "Shadow boots";
				itemDef.modelID = 65226;
				itemDef.maleEquip1 = 65226;
				itemDef.femaleEquip1 = 65226;
				itemDef21 = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 71; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 19131:
				itemDef.name = "Bronze boots";
				itemDef.modelID = 65226;
				itemDef.maleEquip1 = 65226;
				itemDef.femaleEquip1 = 65226;
				itemDef21 = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[3] = "Upgrade-boots";
				itemDef.actions[1] = "Wear";
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 58; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 19130:
				itemDef.name = "Iron boots";
				itemDef.modelID = 65226;
				itemDef.maleEquip1 = 65226;
				itemDef.femaleEquip1 = 65226;
				itemDef21 = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[3] = "Upgrade-boots";
				itemDef.actions[1] = "Wear";
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 60; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 19129:
				itemDef.name = "Steel boots";
				itemDef.modelID = 65226;
				itemDef.maleEquip1 = 65226;
				itemDef.femaleEquip1 = 65226;
				itemDef21 = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[3] = "Upgrade-boots";
				itemDef.actions[1] = "Wear";
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 62; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 19128:
				itemDef.name = "Black boots";
				itemDef.modelID = 65226;
				itemDef.maleEquip1 = 65226;
				itemDef.femaleEquip1 = 65226;
				itemDef21 = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[3] = "Upgrade-boots";
				itemDef.actions[1] = "Wear";
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 64; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 19127:
				itemDef.name = "Mithril boots";
				itemDef.modelID = 65226;
				itemDef.maleEquip1 = 65226;
				itemDef.femaleEquip1 = 65226;
				itemDef21 = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[3] = "Upgrade-boots";
				itemDef.actions[1] = "Wear";
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 66; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 19126:
				itemDef.name = "Adamant boots";
				itemDef.modelID = 65226;
				itemDef.maleEquip1 = 65226;
				itemDef.femaleEquip1 = 65226;
				itemDef21 = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[3] = "Upgrade-boots";
				itemDef.actions[1] = "Wear";
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 68; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 19125:
				itemDef.name = "Rune boots";
				itemDef.modelID = 65226;
				itemDef.maleEquip1 = 65226;
				itemDef.femaleEquip1 = 65226;
				itemDef21 = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[3] = "Upgrade-boots";
				itemDef.actions[1] = "Wear";
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 70; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 19124:
				itemDef.name = "Dragon boots";
				itemDef.modelID = 65226;
				itemDef.maleEquip1 = 65226;
				itemDef.femaleEquip1 = 65226;
				itemDef21 = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[3] = "Upgrade-boots";
				itemDef.actions[1] = "Wear";
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 72; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 19123:
				itemDef.name = "Tainted boots";
				itemDef.modelID = 65226;
				itemDef.maleEquip1 = 65226;
				itemDef.femaleEquip1 = 65226;
				itemDef21 = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = 877;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 131; // the new texture u want it to have
				itemDef.stackable = false;
				break;

			case 15418:
				itemDef.name = "Ice Fury";
				itemDef.rdc2 = 407740;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 3791:
				itemDef.modelZoom = 877;
				break;

			case 6937:
				itemDef.name = "Vixie boots";
				itemDef.modelID = 65226;
				itemDef.maleEquip1 = 65226;
				itemDef.femaleEquip1 = 65226;
				itemDef21 = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = 877;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 115; // the new texture u want it to have
				itemDef.stackable = false;
				break;

			case 18889:
				itemDef.copyItem(10666);
				itemDef.name = "@cya@Colossal spirit shield";
				itemDef.modelID = 65228;
				itemDef.maleEquip1 = 65227;
				itemDef.femaleEquip1 = 65227;
				itemDef.modelOffsetY = 6;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 62; // the texture that it currently has
				itemDef.newColors[0] = 78; // the new texture u want it to have
				itemDef.stackable = false;
				break;

			case 23370:
				itemDef.copyItem(22053);
				itemDef.name = "Suffering key";
				itemDef.rdc3 = 800;
				break;

			case 6293:
				itemDef.copyItem(10666);
				itemDef.name = "Shadow spirit shield";
				itemDef.modelID = 65228;
				itemDef.maleEquip1 = 65227;
				itemDef.femaleEquip1 = 65227;
				itemDef.modelOffsetY = 6;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 62; // the texture that it currently has
				itemDef.newColors[0] = 71; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 18754:
				itemDef.copyItem(10666);
				itemDef.name = "Hellfire spirit shield";
				itemDef.modelID = 65228;
				itemDef.maleEquip1 = 65227;
				itemDef.femaleEquip1 = 65227;
				itemDef.modelOffsetY = 6;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 62; // the texture that it currently has
				itemDef.newColors[0] = 54; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 18784:
				itemDef.name = "Shadow sigil";
				// itemDef.modelID = 65228;
				itemDef.maleEquip1 = 65227;
				itemDef.femaleEquip1 = 65227;
				itemDef21 = ItemDefinition.get(13748);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = itemDef21.actions;
				itemDef.stackable = false;
				break;
			case 18783:
				itemDef.name = "Hellfire sigil";
				// itemDef.modelID = 65228;
				itemDef.maleEquip1 = 65227;
				itemDef.femaleEquip1 = 65227;
				itemDef21 = ItemDefinition.get(13746);
				itemDef.modelID = itemDef21.modelID;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = itemDef21.actions;
				itemDef.stackable = false;
				break;
			case 20057:
				itemDef.copyItem(10666);
				itemDef.name = "Moonlight spirit shield";
				itemDef.modelID = 65228;
				itemDef.maleEquip1 = 65227;
				itemDef.femaleEquip1 = 65227;
				itemDef.modelOffsetY = 6;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 62; // the texture that it currently has
				itemDef.newColors[0] = 66; // the new texture u want it to have

				itemDef.stackable = false;
				break;

			case 19753:
				itemDef.name = "Lava axe";
				itemDef.modelID = 65229;
				itemDef.maleEquip1 = 65230;
				itemDef.femaleEquip1 = 65230;
				itemDef21 = ItemDefinition.get(1265);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 40; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 19952:
				itemDef.name = "Mega helm";
				itemDef.modelID = 65095;
				itemDef.maleEquip1 = 65096;
				itemDef.femaleEquip1 = 65096;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19133:
				itemDef.name = "Thunder Partyhat";
				itemDef.modelID = 65286;
				itemDef.maleEquip1 = 65287;
				itemDef.femaleEquip1 = 65287;
				itemDef21 = ItemDefinition.get(1040);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 56; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 18415:
				itemDef.name = "Lava Partyhat";
				itemDef.modelID = 65286;
				itemDef.maleEquip1 = 65287;
				itemDef.femaleEquip1 = 65287;
				itemDef21 = ItemDefinition.get(1040);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 40; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 18416:
				itemDef.name = "Water Partyhat";
				itemDef.modelID = 65286;
				itemDef.maleEquip1 = 65287;
				itemDef.femaleEquip1 = 65287;
				itemDef21 = ItemDefinition.get(1040);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 51; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 18417:
				itemDef.name = "Firehell Partyhat";
				itemDef.modelID = 65286;
				itemDef.maleEquip1 = 65287;
				itemDef.femaleEquip1 = 65287;
				itemDef21 = ItemDefinition.get(1040);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 52; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 18418:
				itemDef.name = "@mag@Velvet Partyhat";
				itemDef.modelID = 65286;
				itemDef.maleEquip1 = 65287;
				itemDef.femaleEquip1 = 65287;
				itemDef21 = ItemDefinition.get(1040);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 54; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 18419:
				itemDef.name = "Universal Partyhat";
				itemDef.modelID = 65286;
				itemDef.maleEquip1 = 65287;
				itemDef.femaleEquip1 = 65287;
				itemDef21 = ItemDefinition.get(1040);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 66; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 23404:
				itemDef.name = "Season 1 Partyhat";
				itemDef.modelID = 65286;
				itemDef.maleEquip1 = 65287;
				itemDef.femaleEquip1 = 65287;
				itemDef21 = ItemDefinition.get(1040);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 98; // the new texture u want it to have
				itemDef.stackable = false;
				break;
				case 23405:
				itemDef.name = "Season 1 Santa hat";
				itemDef.modelID = 65288;
				itemDef.maleEquip1 = 65289;
				itemDef.femaleEquip1 = 65289;
				itemDef21 = ItemDefinition.get(1050);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 98; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 23406:
				itemDef.name = "Season 1 Sled";
				itemDef21 = ItemDefinition.get(4083);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelID = 65302;
				itemDef.femaleEquip1 = 65302;
				itemDef.maleEquip1 = 65302;
				itemDef.actions = new String[]{null, "Ride", null, null, "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 98;
				itemDef.stackable = false;
				itemDef.value = 1;
				break;
			case 19134:
				itemDef.name = "Staff Santa hat";
				itemDef.modelID = 65288;
				itemDef.maleEquip1 = 65289;
				itemDef.femaleEquip1 = 65289;
				itemDef21 = ItemDefinition.get(1050);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 74; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 18410:
				itemDef.name = "Universal Santa hat";
				itemDef.modelID = 65288;
				itemDef.maleEquip1 = 65289;
				itemDef.femaleEquip1 = 65289;
				itemDef21 = ItemDefinition.get(1050);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 66; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 18411:
				itemDef.name = "Skyrocket Santa hat";
				itemDef.modelID = 65288;
				itemDef.maleEquip1 = 65289;
				itemDef.femaleEquip1 = 65289;
				itemDef21 = ItemDefinition.get(1050);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 57; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 18412:
				itemDef.name = "Hellfire Santa hat";
				itemDef.modelID = 65288;
				itemDef.maleEquip1 = 65289;
				itemDef.femaleEquip1 = 65289;
				itemDef21 = ItemDefinition.get(1050);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 54; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 18413:
				itemDef.name = "Leafy Santa hat";
				itemDef.modelID = 65288;
				itemDef.maleEquip1 = 65289;
				itemDef.femaleEquip1 = 65289;
				itemDef21 = ItemDefinition.get(1050);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 55; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 18414:
				itemDef.name = "Velvet Santa hat";
				itemDef.modelID = 65288;
				itemDef.maleEquip1 = 65289;
				itemDef.femaleEquip1 = 65289;
				itemDef21 = ItemDefinition.get(1050);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 56; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 19132:
				itemDef.name = "Staff H'ween mask";
				itemDef.modelID = 65290;
				itemDef.maleEquip1 = 65291;
				itemDef.femaleEquip1 = 65291;
				itemDef21 = ItemDefinition.get(4716);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 74; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 20104:
				itemDef.name = "<col=a3d4f6>Key 1";
				itemDef.rdc2 = 11112;
				break;
			case 20105:
				itemDef.name = "<col=a3d4f6>Key 2";
				itemDef.rdc2 = 66667;
				break;
			case 20106:
				itemDef.name = "<col=a3d4f6>Key 3";
				itemDef.rdc2 = 22223;// 22223
				break;
			case 20107:
				itemDef.name = "<col=a3d4f6>Key 4";
				itemDef.rdc2 = 44445;
				break;
			case 20108:
				itemDef.name = "<col=a3d4f6>Key 5";
				itemDef.rdc2 = 55556;
				break;
			case 20109:
				itemDef.name = "<col=a3d4f6>Key 6";
				itemDef.rdc2 = 33334;// 33334
				break;
			case 20103:
				itemDef.name = "<col=a3d4f6>Boss Key";
				itemDef.rdc2 = 6662;// 33334
				break;

			case 11795:
				itemDef.name = "Chest Key";
				itemDef.rdc2 = 1261;
				break;
			case 18405:
				itemDef.name = "Universal H'ween mask";
				itemDef.modelID = 65290;
				itemDef.maleEquip1 = 65291;
				itemDef.femaleEquip1 = 65291;
				itemDef21 = ItemDefinition.get(4716);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 66; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 18406:
				itemDef.name = "Skyrocket H'ween mask";
				itemDef.modelID = 65290;
				itemDef.maleEquip1 = 65291;
				itemDef.femaleEquip1 = 65291;
				itemDef21 = ItemDefinition.get(4716);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 57; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 18407:
				itemDef.name = "Hellfire H'ween mask";
				itemDef.modelID = 65290;
				itemDef.maleEquip1 = 65291;
				itemDef.femaleEquip1 = 65291;
				itemDef21 = ItemDefinition.get(4716);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 54; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 18408:
				itemDef.name = "Leafy H'ween mask";
				itemDef.modelID = 65290;
				itemDef.maleEquip1 = 65291;
				itemDef.femaleEquip1 = 65291;
				itemDef21 = ItemDefinition.get(4716);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 55; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 18409:
				itemDef.name = "Velvet H'ween mask";
				itemDef.modelID = 65290;
				itemDef.maleEquip1 = 65291;
				itemDef.femaleEquip1 = 65291;
				itemDef21 = ItemDefinition.get(4716);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 56; // the new texture u want it to have
				itemDef.stackable = false;
				break;

				case 13379:
				itemDef.name = "Owner fragments";
				break;
			case 23321:
				itemDef.copyItem(19000);
				itemDef.name = "Suffered Crystals";
				itemDef.rdc2 = 421788;
				itemDef.rotationX = 150;
				break;

			case 19953:
				itemDef.name = "<col=a69eb6>Avatar titan platebody";
				itemDef.modelID = 65097;
				itemDef.maleEquip1 = 65098;
				itemDef.femaleEquip1 = 65098;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				break;
			case 19951:
				itemDef.name = "Mega legs";
				itemDef.modelID = 65099;
				itemDef.maleEquip1 = 65100;
				itemDef.femaleEquip1 = 65100;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19468:
				itemDef.name = "Darthvader mask";
				itemDef.modelID = 65249;
				itemDef.maleEquip1 = 65250;
				itemDef.femaleEquip1 = 65250;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19166:
				itemDef.name = "Darthvader body";
				itemDef.modelID = 65251;
				itemDef.maleEquip1 = 65252;
				itemDef.femaleEquip1 = 65252;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				break;
			case 19165:
				itemDef.name = "Darthvader legs";
				itemDef.modelID = 65253;
				itemDef.maleEquip1 = 65253;
				itemDef.femaleEquip1 = 65253;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19156:
				itemDef.name = "Keencher helm";
				itemDef.modelID = 65266;
				itemDef.maleEquip1 = 65267;
				itemDef.femaleEquip1 = 65267;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 2952592;
				break;
			case 19155:
				itemDef.name = "Keencher body";
				itemDef.modelID = 65268;
				itemDef.maleEquip1 = 65269;
				itemDef.femaleEquip1 = 65269;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 3253;

				break;
			case 19154:
				itemDef.name = "Keencher legs";
				itemDef.modelID = 65270;
				itemDef.maleEquip1 = 65271;
				itemDef.femaleEquip1 = 65271;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 35622;

				break;
			case 19153:
				itemDef.name = "Joyxicular helm";
				itemDef.modelID = 65272;
				itemDef.maleEquip1 = 65273;
				itemDef.femaleEquip1 = 65273;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};

				itemDef.stackable = false;
				// itemDef.rdc2 = 23945;
				break;
			case 19142:
				itemDef.name = "Joyxicular body";
				itemDef.modelID = 65274;
				itemDef.maleEquip1 = 65275;
				itemDef.femaleEquip1 = 65275;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};

				itemDef.stackable = false;
				// itemDef.rdc2 = 23945;
				break;
			case 19141:
				itemDef.name = "Joyxicular legs";
				itemDef.modelID = 65276;
				itemDef.maleEquip1 = 65277;
				itemDef.femaleEquip1 = 65277;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};

				itemDef.stackable = false;
				// itemDef.rdc2 = 23945;
				break;
			case 19160:
				itemDef.name = "Galvek helm";
				itemDef.modelID = 65260;
				itemDef.maleEquip1 = 65261;
				itemDef.femaleEquip1 = 65261;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;


				break;
			case 19159:
				itemDef.name = "Galvek body";
				itemDef.modelID = 65262;
				itemDef.maleEquip1 = 65263;
				itemDef.femaleEquip1 = 65263;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;


				break;
			case 19158:
				itemDef.name = "Galvek legs";
				itemDef.modelID = 65264;
				itemDef.maleEquip1 = 65265;
				itemDef.femaleEquip1 = 65265;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;


				break;
			case 19140:
				itemDef.name = "Shetani helm";
				itemDef.modelID = 16361;
				itemDef.maleEquip1 = 16362;
				itemDef.femaleEquip1 = 16362;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = 700;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;

			case 19139:
				itemDef.name = "Shetani body";
				itemDef.modelID = 16359;
				itemDef.maleEquip1 = 16360;
				itemDef.femaleEquip1 = 16360;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;

			case 19138:
				itemDef.name = "Shetani legs";
				itemDef.modelID = 16363;
				itemDef.maleEquip1 = 16364;
				itemDef.femaleEquip1 = 16364;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;

			case 19164:
				itemDef.name = "Combatant hood";
				itemDef.modelID = 65254;
				itemDef.maleEquip1 = 65255;
				itemDef.femaleEquip1 = 65255;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				break;
			case 19163:
				itemDef.name = "Combatant body";
				itemDef.modelID = 65256;
				itemDef.maleEquip1 = 65257;
				itemDef.femaleEquip1 = 65257;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				//	itemDef.rdc2 = 6642;
				break;
			case 19161:
				itemDef.name = "Combatant legs";
				itemDef.modelID = 65258;
				itemDef.maleEquip1 = 65259;
				itemDef.femaleEquip1 = 65259;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				break;
			case 19471:
				itemDef.name = "Inferior helm";
				itemDef.modelID = 65243;
				itemDef.maleEquip1 = 65244;
				itemDef.femaleEquip1 = 65244;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				break;
			case 19470:
				itemDef.name = "Inferior body";
				itemDef.modelID = 65245;
				itemDef.maleEquip1 = 65246;
				itemDef.femaleEquip1 = 65246;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;


				break;
			case 19469:
				itemDef.name = "Inferior legs";
				itemDef.modelID = 65247;
				itemDef.maleEquip1 = 65248;
				itemDef.femaleEquip1 = 65248;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				break;
			case 19811:
				itemDef.copyItem(4708);
				itemDef.name = "Webby head";
				itemDef.modelID = 18124;
				itemDef.maleEquip1 = 18063;
				itemDef.femaleEquip1 = 18063;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				break;
			case 19473:
				itemDef.copyItem(4712);
				itemDef.name = "Webby body";
				itemDef.modelID = 18143;
				itemDef.maleEquip1 = 18064;
				itemDef.femaleEquip1 = 18064;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 19472:
				itemDef.copyItem(4712);
				itemDef.name = "Webby legs";
				itemDef.modelID = 18142;
				itemDef.maleEquip1 = 18065;
				itemDef.femaleEquip1 = 18065;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 19946:
				itemDef.name = "<col=a69eb6>Avatar titan gloves";
				itemDef.modelID = 65101;
				itemDef.maleEquip1 = 65102;
				itemDef.femaleEquip1 = 65102;
				itemDef21 = ItemDefinition.get(7462);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors[0] = 52; // the texture that it currently has
				itemDef.newColors[0] = 71; // the new text

				break;
			case 19945:
				itemDef.name = "<col=a69eb6>Avatar titan boots";
				itemDef.modelID = 65103;
				itemDef.maleEquip1 = 65103;
				itemDef.femaleEquip1 = 65103;
				itemDef21 = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors[0] = 52; // the texture that it currently has
				itemDef.newColors[0] = 71; // the new text

				break;
			case 19944:
				itemDef.name = "<col=a69eb6>Avatar titan cape";
				itemDef.modelID = 65104;
				itemDef.maleEquip1 = 65105;
				itemDef.femaleEquip1 = 65105;
				itemDef21 = ItemDefinition.get(1007);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors[0] = 52; // the texture that it currently has
				itemDef.newColors[0] = 71; // the new text

				break;
			case 19921:
				itemDef.name = "wrath helm";
				itemDef.modelID = 65118;
				itemDef.maleEquip1 = 65119;
				itemDef.femaleEquip1 = 65119;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19915:
				itemDef.name = "wrath body";
				itemDef.modelID = 65120;
				itemDef.maleEquip1 = 65121;
				itemDef.femaleEquip1 = 65121;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19920:
				itemDef.name = "wrath legs";
				itemDef.modelID = 65122;
				itemDef.maleEquip1 = 65123;
				itemDef.femaleEquip1 = 65123;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 15914:
				itemDef.name = "KanX full helm";
				itemDef.rdc2 = 7248247;
				break;
			case 16262:
				itemDef.name = "KanX boots";
				itemDef.rdc2 = 7248247;
				break;
			case 16207:
				itemDef.name = "KanX battleaxe";
				itemDef.rdc2 = 7248247;
				break;
			case 15936:
				itemDef.name = "KanX gauntles";
				itemDef.rdc2 = 7248247;
				break;
			case 16024:
				itemDef.name = "KanX longsword";
				itemDef.rdc2 = 7248247;
				break;
			case 15925:
				itemDef.name = "KanX platelegs";
				itemDef.rdc2 = 7248247;
				break;
			case 16142:
				itemDef.name = "KanX pickaxe";
				itemDef.rdc2 = 7248247;
				break;
			case 16080:
				itemDef.name = "KanX chainbody";
				itemDef.rdc2 = 7248247;
				break;
			case 16013:
				itemDef.name = "KanX platebody";
				itemDef.rdc2 = 7248247;
				break;
			case 16174:
				itemDef.name = "KanX maul";
				itemDef.rdc2 = 7248247;
				break;
			case 16196:
				itemDef.name = "KanX plateskirt";
				itemDef.rdc2 = 7248247;
				break;

			case 19930://
				itemDef.name = "jack helm";
				itemDef.modelID = 65166;
				itemDef.maleEquip1 = 65167;
				itemDef.femaleEquip1 = 65167;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19929:
				itemDef.name = "jack body";
				itemDef.modelID = 65168;
				itemDef.maleEquip1 = 65169;
				itemDef.femaleEquip1 = 65169;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19928:
				itemDef.name = "jack legs";
				itemDef.modelID = 65170;
				itemDef.maleEquip1 = 65171;
				itemDef.femaleEquip1 = 65171;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19943:
				itemDef.name = "Maxiblood helm";
				itemDef.modelID = 65130;
				itemDef.maleEquip1 = 65131;
				itemDef.femaleEquip1 = 65131;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 65;
				itemDef.stackable = false;
				break;
			case 19941:
				itemDef.name = "Maxiblood platebody";
				itemDef.modelID = 65132;
				itemDef.maleEquip1 = 65133;
				itemDef.femaleEquip1 = 65133;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 65;
				itemDef.stackable = false;
				break;
			case 19940:
				itemDef.name = "Maxiblood legs";
				itemDef.modelID = 65134;
				itemDef.maleEquip1 = 65135;
				itemDef.femaleEquip1 = 65135;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 65;
				itemDef.stackable = false;
				break;
			case 18840:
				itemDef.name = "Moonlight hood";
				itemDef.modelID = 65296;
				itemDef.maleEquip1 = 65297;
				itemDef.femaleEquip1 = 65297;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 66;
				itemDef.stackable = false;
				break;
			case 18837:
				itemDef.name = "Moonlight robetop";
				itemDef.modelID = 65298;
				itemDef.maleEquip1 = 65299;
				itemDef.femaleEquip1 = 65299;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 66;
				itemDef.stackable = false;
				break;
			case 19806:
				itemDef.name = "Candy Corn";
				itemDef.modelID = 19754;
				itemDef.modelZoom = 584;
				itemDef.rotationY = 774;
				itemDef.rotationX = 184;
				itemDef.rotationZ = 217;
				itemDef.modelOffsetX = 9;
				itemDef.modelOffsetY = 0;
				itemDef.actions = new String[]{"Claim", null, "Dissolve", null, null};
				break;
			case 18836:
				itemDef.name = "Moonlight robebottom";
				itemDef.modelID = 65300;
				itemDef.maleEquip1 = 65301;
				itemDef.femaleEquip1 = 65301;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 66;
				itemDef.stackable = false;
				break;
			case 3904:
				itemDef.name = "Starter Box";
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
				itemDef.newColors = new int[]{71};
				itemDef.modelID = 65284;
				break;
			case 18830:
				itemDef.name = "Elite dragonbone";
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{78};
				itemDef.modelID = 65285;
				break;

			case 23402:
				itemDef.copyItem(18830);
				itemDef.name = "Starter bones";
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{67};
				itemDef.modelID = 65285;
				break;

			case 3281:
				itemDef.copyItem(18830);
				itemDef.name = "Volcanic bones";
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{71};
				itemDef.modelID = 65285;
				break;

			case 3282:
				itemDef.copyItem(18830);
				itemDef.name = "Leafy bones";
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{68};
				itemDef.modelID = 65285;
				break;

			case 3283:
				itemDef.copyItem(18830);
				itemDef.name = "Chilling bones";
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{69};
				itemDef.modelID = 65285;
				break;

			case 3284:
				itemDef.copyItem(18830);
				itemDef.name = "Spider bones";
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{74};
				itemDef.modelID = 65285;
				break;

			case 3285:
				itemDef.copyItem(18830);
				itemDef.name = "Diabolical bones";
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{71};
				itemDef.modelID = 65285;
				break;

			case 3286:
				itemDef.copyItem(18830);
				itemDef.name = "Energy bones";
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{56};
				itemDef.modelID = 65285;
				break;


			case 23294:
				itemDef.copyItem(18639);
				itemDef.name = "<col=89584A>Fantasy scales";
				itemDef.modelID = 18814;
				break;
			case 23295:
				itemDef.copyItem(18639);
				itemDef.name = "<col=89584A>Fantasy rocks";
				itemDef.modelID = 18878;
				itemDef.rotationX = 0;
				itemDef.modelZoom = 1900;
				break;

			case 23760:
				itemDef.name = "Crimson boots";
				itemDef.modelID = 20836;
				itemDef.maleEquip1 = 20836;
				itemDef.femaleEquip1 = 20836;
				itemDef.modelZoom = 1122;
				itemDef.rotationX = 252;
				itemDef.rotationY = 200;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = -15;
				itemDef.modelOffsetX = 0;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 23296:
				itemDef.name = "Frostlight boots";
				itemDef.modelID = 20815;
				itemDef.maleEquip1 = 20815;
				itemDef.femaleEquip1 = 20815;
				itemDef.modelZoom = 1122;
				itemDef.rotationX = 252;
				itemDef.rotationY = 200;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = -15;
				itemDef.modelOffsetX = 0;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 23297:
				itemDef.name = "Elderbone boots";
				itemDef.modelID = 20817;
				itemDef.maleEquip1 = 20817;
				itemDef.femaleEquip1 = 20817;
				itemDef.modelZoom = 1122;
				itemDef.rotationX = 252;
				itemDef.rotationY = 200;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = -15;
				itemDef.modelOffsetX = 0;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;
			case 23298:
				itemDef.name = "Hailfire boots";
				itemDef.modelID = 20819;
				itemDef.maleEquip1 = 20819;
				itemDef.femaleEquip1 = 20819;
				itemDef.modelZoom = 1122;
				itemDef.rotationX = 252;
				itemDef.rotationY = 200;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = -15;
				itemDef.modelOffsetX = 0;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;
			case 1468:
				itemDef.name = "Drowsy Branches";
				itemDef.description = "A Drowsy Branch".getBytes();
				itemDef.rdc2 = 11000000;
				itemDef.actions = new String[5];
				itemDef.actions[1] = null;
				itemDef.actions[4] = "Drop";
				break;

			case 23369:
				itemDef.copyItem(552);
				itemDef.name = "Holy amulet";
				itemDef.rdc2 = 200;
				break;
			case 23377:
				itemDef.copyItem(632);
				itemDef.name = "Ironman boots";
				itemDef.rdc3 = 785;
				break;
			case 23378:
				itemDef.copyItem(632);
				itemDef.name = "Ultimate boots";
				itemDef.rdc2 = 10;
				break;

			case 23379:
				itemDef.copyItem(18740);
				itemDef.name = "Ironman cape";
				itemDef.rdc3 = 785;
				break;
			case 23380:
				itemDef.copyItem(18740);
				itemDef.name = "Ultimate cape";
				itemDef.rdc2 = 10;
				break;
			case 18813:
				itemDef.name = "Dagonnoth Cave Teleport";
				itemDef.rdc2 = 10000;
				break;
			case 17510:
				itemDef.name = "Enchanted Herb";
				itemDef.rdc2 = 5000;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.actions[4] = "Drop";
				break;
			case 8534:
				itemDef.name = "Lectern";
				itemDef.rdc2 = 5000;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.actions[4] = "Drop";
				break;

			case 2893:
				itemDef.modelID = 18871;
				itemDef.name = "<col=89584A>Fantasy bar";
				break;
			case 23276:
				itemDef.copyItem(23275);
				itemDef.rotationX = 0;
				itemDef.stackable = false;
				itemDef.name = "Bronze Card Pack";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop";
				itemDef.actions[0] = "Open";
				itemDef.modelID = 22373;
				itemDef.modelZoom = 900;
				break;

			case 23277:
				itemDef.copyItem(23275);
				itemDef.rotationX = 0;
				itemDef.stackable = false;
				itemDef.name = "Quill's Card Pack";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop";
				itemDef.actions[0] = "Open";
				itemDef.modelID = 19577;
				itemDef.modelZoom = 900;
				break;


			case 23278:
				itemDef.copyItem(23275);
				itemDef.rotationX = 0;
				itemDef.stackable = false;
				itemDef.name = "Celestial's Card Pack";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop";
				itemDef.actions[0] = "Open";
				itemDef.modelID = 19578;
				itemDef.modelZoom = 900;
				break;

			case 23279:
				itemDef.copyItem(23275);
				itemDef.rotationX = 0;
				itemDef.stackable = false;
				itemDef.name = "Levincia's Card Pack";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop";
				itemDef.actions[0] = "Open";
				itemDef.modelID = 22369;
				itemDef.modelZoom = 900;
				break;

			case 3906:
				itemDef.name = "Maxiblood Package";
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
				itemDef.newColors = new int[]{61};
				itemDef.modelID = 65284;
				break;
			case 3908:
				itemDef.name = "Moonlight Package";
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
				itemDef.newColors = new int[]{60};
				itemDef.modelID = 65284;
				break;
			case 3910:
				itemDef.name = "Archie Package";
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
				itemDef.newColors = new int[]{59};
				itemDef.modelID = 65284;
				break;
			case 19939:
				itemDef.copyItem(4708);
				itemDef.name = "Starter gloves";
				itemDef.modelID = 100135;
				itemDef.modelZoom = 1000;
				itemDef.maleEquip1 = 100136;
				itemDef.femaleEquip1 = 100136;
				itemDef.oldColors = new int[]{51};
				itemDef.newColors = new int[]{52};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 15432:
				itemDef.name = "Starter cape";
				itemDef.rdc2 = 18822;
				break;
			case 16995:
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
				itemDef.rdc = 6421272;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;
			case 18365:
				itemDef.copyItem(4710);
				itemDef.name = "Starter sword";
				itemDef.modelID = 100299;
				itemDef.maleEquip1 = 100300;
				itemDef.femaleEquip1 = 100300;
				itemDef.modelZoom = 1500;
				itemDef.rotationX = 1100;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				itemDef.rdc = 6421272;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;
			case 16879:
				itemDef.copyItem(4710);
				itemDef.name = "Starter bow";
				itemDef.modelID = 100295;
				itemDef.maleEquip1 = 100296;
				itemDef.femaleEquip1 = 100296;
				itemDef.modelZoom = 2300;
				itemDef.rotationX = 1100;
				itemDef.rotationY = 450;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				itemDef.rdc = 6421272;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;
			case 18766:
				itemDef.name = "Archie gloves";
				itemDef.modelID = 65136;
				itemDef.maleEquip1 = 65137;
				itemDef.femaleEquip1 = 65137;
				itemDef21 = ItemDefinition.get(7462);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 64;
				itemDef.stackable = false;
				// itemDef.rdc2 = 8822;
				break;
			case 18802:
				itemDef.name = "Moonlight gloves";
				itemDef.modelID = 65136;
				itemDef.maleEquip1 = 65137;
				itemDef.femaleEquip1 = 65137;
				itemDef21 = ItemDefinition.get(7462);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 66;
				itemDef.stackable = false;
				// itemDef.rdc2 = 8822;
				break;
			case 19938:
				itemDef.copyItem(4708);
				itemDef.name = "Starter boots";
				itemDef.modelID = 100137;
				itemDef.maleEquip1 = 100137;
				itemDef.femaleEquip1 = 100137;
				itemDef.oldColors = new int[]{51};
				itemDef.newColors = new int[]{52};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 18755:
				itemDef.name = "Archie boots";
				itemDef.modelID = 65138;
				itemDef.maleEquip1 = 65138;
				itemDef.femaleEquip1 = 65138;
				itemDef21 = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 64;
				itemDef.stackable = false;
				// itemDef.rdc2 = 8822;
				break;
			case 18785:
				itemDef.name = "Moonlight boots";
				itemDef.modelID = 65138;
				itemDef.maleEquip1 = 65138;
				itemDef.femaleEquip1 = 65138;
				itemDef21 = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 66;
				itemDef.stackable = false;
				// itemDef.rdc2 = 8822;
				break;
			case 2178:
				itemDef.name = "Maxiblood Cape";
				itemDef21 = ItemDefinition.get(6570);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelID = 65104;
				itemDef.maleEquip1 = 65105;
				itemDef.femaleEquip1 = 65105;
				itemDef.actions = itemDef21.actions;
				itemDef.newColors = new int[2]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[2]; // same here
				itemDef.oldColors[0] = 52; // the texture that it currently has
				itemDef.newColors[0] = 65;
				itemDef.oldColors[1] = 920; // the texture that it currently has
				itemDef.newColors[1] = 50; // the new texture u want it to have
				itemDef.stackable = false;
				itemDef.value = 1;
				break;
			case 4355:
				itemDef.name = "Archie Cape";
				itemDef21 = ItemDefinition.get(6570);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelID = 65104;
				itemDef.maleEquip1 = 65105;
				itemDef.femaleEquip1 = 65105;
				itemDef.actions = itemDef21.actions;
				itemDef.newColors = new int[2]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[2]; // same here
				itemDef.oldColors[0] = 52; // the texture that it currently has
				itemDef.newColors[0] = 64;
				itemDef.oldColors[1] = 920; // the texture that it currently has
				itemDef.newColors[1] = 39; // the new texture u want it to have
				itemDef.stackable = false;
				itemDef.value = 1;
				break;
			case 4357:
				itemDef.name = "Moonlight Cape";
				itemDef21 = ItemDefinition.get(6570);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelID = 65104;
				itemDef.maleEquip1 = 65105;
				itemDef.femaleEquip1 = 65105;
				itemDef.actions = itemDef21.actions;
				itemDef.newColors = new int[2]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[2]; // same here
				itemDef.oldColors[0] = 52; // the texture that it currently has
				itemDef.newColors[0] = 66;
				itemDef.oldColors[1] = 920; // the texture that it currently has
				itemDef.newColors[1] = 50; // the new texture u want it to have
				itemDef.stackable = false;
				itemDef.value = 1;
				break;

			case 15401:
				itemDef.name = "Galactic Ring";
				itemDef.modelID = 65303;
				itemDef.maleEquip1 = 65303;
				itemDef.femaleEquip1 = 65303;
				itemDef.newColors = new int[1]; // same here
				itemDef.oldColors = new int[1];
				itemDef.oldColors[0] = 51; // the texture that it currently has
				itemDef.newColors[0] = 98;
				itemDef21 = ItemDefinition.get(6737);
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = 0;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;

				break;

			case 5497:
				itemDef.name = "Lava Sled";
				itemDef21 = ItemDefinition.get(4083);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelID = 65302;
				itemDef.femaleEquip1 = 65302;
				itemDef.maleEquip1 = 65302;

				itemDef.actions = new String[]{null, "Ride", null, null, "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 40;
				itemDef.stackable = false;
				itemDef.value = 1;
				break;
			case 18437:
				itemDef.name = "Universal Sled";
				itemDef21 = ItemDefinition.get(4083);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelID = 22381;
				itemDef.femaleEquip1 = 22381;
				itemDef.maleEquip1 = 22381;
				itemDef.actions = new String[]{null, "Ride", null, null, "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 98; // the texture that it currently has
				itemDef.newColors[0] = 61;
				itemDef.stackable = false;
				itemDef.value = 1;
				break;

			/*
			 * case 19936: itemDef.name = "Shadow cape"; itemDef.modelID = 65139;
			 * itemDef.maleWearId = 65140;// its right itemDef.femaleWearId = 65140;
			 * itemDef21 = ItemDefinition.get(1007); itemDef.modelOffset1 =
			 * itemDef21.modelOffset1; itemDef.modelOffsetX = itemDef21.modelOffsetX;
			 * itemDef.modelOffsetY = itemDef21.modelOffsetY; itemDef.modelZoom =
			 * itemDef21.modelZoom; itemDef.modelRotationY = itemDef21.modelRotationY;
			 * itemDef.modelRotationX = itemDef21.modelRotationX; itemDef.actions = new
			 * String[] { null, "Wear", null, null, "Drop" }; itemDef.originalModelColors =
			 * new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2
			 * etc itemDef.modifiedModelColors = new int[1]; // same here
			 * itemDef.modifiedModelColors[0] = 40; // the texture that it currently has
			 * itemDef.originalModelColors[0] = 71; itemDef.stackable = false; itemDef.value
			 * = 11; // itemDef.rdc2 = 8822; break;
			 */
			case 18838:
				itemDef.name = "Dollar Chain";
				itemDef.modelID = 65292;
				itemDef.maleEquip1 = 65293;// its right
				itemDef.femaleEquip1 = 65293;
				itemDef21 = ItemDefinition.get(14599);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};

				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 58; // the texture that it currently has
				itemDef.newColors[0] = 86;
				itemDef.stackable = false;
				itemDef.value = 1;
				// itemDef.rdc2 = 8822;
				break;
			case 19919:
				itemDef.name = "Arc rapier";
				itemDef.modelID = 65124;
				itemDef.maleEquip1 = 65125;
				itemDef.femaleEquip1 = 65125;
				itemDef21 = ItemDefinition.get(1323);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19917:
				itemDef.name = "Arc mace";
				itemDef.modelID = 65126;
				itemDef.maleEquip1 = 65129;
				itemDef.femaleEquip1 = 65129;
				itemDef21 = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 19914:
				itemDef.copyItem(4710);
				itemDef.name = "Starter shield";
				itemDef.modelID = 100140;
				itemDef.maleEquip1 = 100141;
				itemDef.femaleEquip1 = 100141;
				itemDef.oldColors = new int[]{51};
				itemDef.newColors = new int[]{52};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 4178:
				itemDef.copyItem(4710);
				itemDef.name = "Starter sword";
				itemDef.modelZoom = 2000;
				itemDef.rotationX = 1024;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelID = 100138;
				itemDef.maleEquip1 = 100139;
				itemDef.femaleEquip1 = 100139;
				itemDef.oldColors = new int[]{51};
				itemDef.newColors = new int[]{52};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 23197:
				itemDef.copyItem(4710);
				itemDef.name = "Sapphire Blade";
				itemDef.modelZoom = 2000;
				itemDef.rotationX = 1024;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelID = 15461;
				itemDef.maleEquip1 = 15462;
				itemDef.femaleEquip1 = 15462;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 23198:
				itemDef.copyItem(4710);
				itemDef.name = "Emerald Blade";
				itemDef.modelZoom = 2000;
				itemDef.rotationX = 1024;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelID = 15463;
				itemDef.maleEquip1 = 15464;
				itemDef.femaleEquip1 = 15464;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 23199:
				itemDef.copyItem(4710);
				itemDef.name = "Ruby Blade";
				itemDef.modelZoom = 2000;
				itemDef.rotationX = 1024;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelID = 15465;
				itemDef.maleEquip1 = 15466;
				itemDef.femaleEquip1 = 15466;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 23200:
				itemDef.copyItem(4710);
				itemDef.name = "Ruby Blade";
				itemDef.modelZoom = 2000;
				itemDef.rotationX = 1024;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelID = 15465;
				itemDef.maleEquip1 = 15466;
				itemDef.femaleEquip1 = 15466;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 23201:
				itemDef.copyItem(4710);
				itemDef.name = "Diamond Blade";
				itemDef.modelZoom = 2000;
				itemDef.rotationX = 1024;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelID = 15467;
				itemDef.maleEquip1 = 15468;
				itemDef.femaleEquip1 = 15468;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 23202:
				itemDef.copyItem(4710);
				itemDef.name = "Onyx Blade";
				itemDef.modelZoom = 2000;
				itemDef.rotationX = 1024;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelID = 15469;
				itemDef.maleEquip1 = 15470;
				itemDef.femaleEquip1 = 15470;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 23203:
				itemDef.copyItem(4710);
				itemDef.name = "Zenyte Blade";
				itemDef.modelZoom = 2000;
				itemDef.rotationX = 1024;
				itemDef.rotationY = 525;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelID = 15482;
				itemDef.maleEquip1 = 15484;
				itemDef.femaleEquip1 = 15484;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 20438:
				itemDef.name = "Eternal shield";


				break;
			case 20534:
				itemDef.name = "Eternal whip";
				itemDef.modelID = 65141;
				itemDef.maleEquip1 = 65142;
				itemDef.femaleEquip1 = 65142;
				itemDef21 = ItemDefinition.get(13147);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";

				itemDef.actions[1] = "Wear";
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 57; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 20535:
				itemDef.name = "Brutal whip";
				itemDef.modelID = 65141;
				itemDef.maleEquip1 = 65142;
				itemDef.femaleEquip1 = 65142;
				itemDef21 = ItemDefinition.get(21371);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";

				itemDef.actions[1] = "Wear";
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 60; // the new texture u want it to have
				itemDef.stackable = false;
				break;

			case 3323:
				itemDef.name = "Bonecrusher (i)";

				itemDef21 = ItemDefinition.get(18337);
				itemDef.modelID = itemDef21.modelID;

				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = itemDef21.actions;
				itemDef.rdc2 = 6541;
				itemDef.stackable = false;
				break;
			case 3322:
				itemDef.name = "Fighter Torso (i)";

				itemDef21 = ItemDefinition.get(10551);
				itemDef.modelID = itemDef21.modelID;
				itemDef.maleEquip1 = itemDef21.maleEquip1;
				itemDef.femaleEquip1 = itemDef21.femaleEquip1;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = itemDef21.actions;
				itemDef.rdc2 = 98241;
				itemDef.stackable = false;

				break;
			case 3321:
				itemDef.name = "Fighter hat (i)";
				itemDef21 = ItemDefinition.get(10548);
				itemDef.modelID = itemDef21.modelID;
				itemDef.maleEquip1 = itemDef21.maleEquip1;
				itemDef.femaleEquip1 = itemDef21.femaleEquip1;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = itemDef21.actions;
				itemDef.rdc2 = 98241;
				itemDef.stackable = false;


				break;
			//
			case 3318:
				itemDef.name = "Blessed gloves";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef21 = ItemDefinition.get(7462);
				itemDef.modelID = itemDef21.modelID;
				itemDef.maleEquip1 = itemDef21.maleEquip1;
				itemDef.femaleEquip1 = itemDef21.femaleEquip1;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = itemDef21.actions;
				itemDef.rdc2 = 98641;

				itemDef.stackable = false;
				break;

			case 7462:
				itemDef.rdc2 = 58887;
				itemDef.name = "Champion gloves";
				break;
				/*
				itemDef21 = ItemDefinition.get(7462);
				itemDef.modelID = itemDef21.modelID;
				itemDef.maleEquip1 = itemDef21.maleEquip1;
				itemDef.femaleEquip1 = itemDef21.femaleEquip1;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = itemDef21.actions;
				itemDef.stackable = false;
				break;*/

			case 3320:
				itemDef.name = "Runner hat (i)";
				itemDef21 = ItemDefinition.get(10549);
				itemDef.modelID = itemDef21.modelID;
				itemDef.maleEquip1 = itemDef21.maleEquip1;
				itemDef.femaleEquip1 = itemDef21.femaleEquip1;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 98241;
				itemDef.stackable = false;


				break;
			case 3319:
				itemDef.name = "Ranger hat (i)";

				itemDef21 = ItemDefinition.get(10550);
				itemDef.modelID = itemDef21.modelID;
				itemDef.maleEquip1 = itemDef21.maleEquip1;
				itemDef.femaleEquip1 = itemDef21.femaleEquip1;
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = itemDef21.actions;
				itemDef.rdc2 = 98241;
				itemDef.stackable = false;


				break;
			case 3324:
				itemDef.copyItem(2572);
				itemDef.name = "Ring of wealth (ii)";
				itemDef.rdc2 = 86521;
				itemDef.stackable = false;
				break;
			/*
			 * case 20536: itemDef.name = "Steel whip"; itemDef.modelID = 65141;
			 * itemDef.maleWearId = 65142; itemDef.femaleWearId = 65142; itemDef21 =
			 * ItemDefinition.get(4755); itemDef.modelOffset1 = itemDef21.modelOffset1;
			 * itemDef.modelOffsetX = itemDef21.modelOffsetX; itemDef.modelOffsetY =
			 * itemDef21.modelOffsetY; itemDef.modelZoom = itemDef21.modelZoom;
			 * itemDef.modelRotationY = itemDef21.modelRotationY; itemDef.modelRotationX =
			 * itemDef21.modelRotationX; itemDef.actions = new String[5]; itemDef.actions[4]
			 * = "Drop"; itemDef.actions[3] = "Upgrade-whip"; itemDef.actions[1] = "Wear";
			 * itemDef.originalModelColors = new int[1]; // if only 1 texture is modified
			 * this has to be 1, if 2 then 2 etc itemDef.modifiedModelColors = new int[1];
			 * // same here itemDef.modifiedModelColors[0] = 40; // the texture that it
			 * currently has itemDef.originalModelColors[0] = 64; // the new texture u want
			 * it to have itemDef.stackable = false; break;
			 */
			case 7640:
				itemDef.name = "Moonlight staff";
				itemDef.modelID = 65294;
				itemDef.maleEquip1 = 65295;
				itemDef.femaleEquip1 = 65295;
				itemDef21 = ItemDefinition.get(19146);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = 2700;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 62; // the texture that it currently has
				itemDef.newColors[0] = 66; // the new texture u want it to have
				itemDef.stackable = false;

				break;
			case 6936:
				itemDef.name = "Brutal staff";
				itemDef.modelID = 65294;
				itemDef.maleEquip1 = 65295;
				itemDef.femaleEquip1 = 65295;
				itemDef21 = ItemDefinition.get(19146);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = 2700;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 62; // the texture that it currently has
				itemDef.newColors[0] = 131; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 5095:
				itemDef.name = "Shetani staff";
				itemDef.modelID = 16365;
				itemDef.maleEquip1 = 16366;
				itemDef.femaleEquip1 = 16366;
				itemDef21 = ItemDefinition.get(19146);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = 1530;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[1] = "Wear";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;

			case 17017:
				itemDef.name = "Blaster staff";
				itemDef.rdc2 = 666;

				break;
			case 21371:
				itemDef.name = "Vine Whip";

				break;
			case 21372:

				break;
			case 21373:

				break;
			case 21374:

				break;
			case 5096:
				itemDef.name = "Evil staff";
				itemDef.modelID = 65294;
				itemDef.maleEquip1 = 65295;
				itemDef.femaleEquip1 = 65295;
				itemDef21 = ItemDefinition.get(19146);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = 2700;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 62; // the texture that it currently has
				itemDef.newColors[0] = 64; // the new texture u want it to have
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};

				break;
			/*
			 * case 20537: itemDef.name = "Black whip"; itemDef.modelID = 65141;
			 * itemDef.maleWearId = 65142; itemDef.femaleWearId = 65142; itemDef21 =
			 * ItemDefinition.get(21371); itemDef.modelOffset1 = itemDef21.modelOffset1;
			 * itemDef.modelOffsetX = itemDef21.modelOffsetX; itemDef.modelOffsetY =
			 * itemDef21.modelOffsetY; itemDef.modelZoom = itemDef21.modelZoom;
			 * itemDef.modelRotationY = itemDef21.modelRotationY; itemDef.modelRotationX =
			 * itemDef21.modelRotationX; itemDef.actions = new String[5]; itemDef.actions[4]
			 * = "Drop"; itemDef.actions[3] = "Upgrade-whip"; itemDef.actions[1] = "Wear";
			 * itemDef.originalModelColors = new int[1]; // if only 1 texture is modified
			 * this has to be 1, if 2 then 2 etc itemDef.modifiedModelColors = new int[1];
			 * // same here itemDef.modifiedModelColors[0] = 40; // the texture that it
			 * currently has itemDef.originalModelColors[0] = 66; // the new texture u want
			 * it to have itemDef.stackable = false; break; case 20538: itemDef.name =
			 * "Mithril whip"; itemDef.modelID = 65141; itemDef.maleWearId = 65142;
			 * itemDef.femaleWearId = 65142; itemDef21 = ItemDefinition.get(21371);
			 * itemDef.modelOffset1 = itemDef21.modelOffset1; itemDef.modelOffsetX =
			 * itemDef21.modelOffsetX; itemDef.modelOffsetY = itemDef21.modelOffsetY;
			 * itemDef.modelZoom = itemDef21.modelZoom; itemDef.modelRotationY =
			 * itemDef21.modelRotationY; itemDef.modelRotationX = itemDef21.modelRotationX;
			 * itemDef.actions = new String[5]; itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
			 * itemDef.actions[3] = "Upgrade-whip"; itemDef.actions[1] = "Wear";
			 * itemDef.originalModelColors = new int[1]; // if only 1 texture is modified
			 * this has to be 1, if 2 then 2 etc itemDef.modifiedModelColors = new int[1];
			 * // same here itemDef.modifiedModelColors[0] = 40; // the texture that it
			 * currently has itemDef.originalModelColors[0] = 68; // the new texture u want
			 * it to have itemDef.stackable = false; break; case 20539: itemDef.name =
			 * "Adamant whip"; itemDef.modelID = 65141; itemDef.maleWearId = 65142;
			 * itemDef.femaleWearId = 65142; itemDef21 = ItemDefinition.get(21371);
			 * itemDef.modelOffset1 = itemDef21.modelOffset1; itemDef.modelOffsetX =
			 * itemDef21.modelOffsetX; itemDef.modelOffsetY = itemDef21.modelOffsetY;
			 * itemDef.modelZoom = itemDef21.modelZoom; itemDef.modelRotationY =
			 * itemDef21.modelRotationY; itemDef.modelRotationX = itemDef21.modelRotationX;
			 * itemDef.actions = new String[5]; itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
			 * itemDef.actions[3] = "Upgrade-whip"; itemDef.actions[1] = "Wear";
			 * itemDef.originalModelColors = new int[1]; // if only 1 texture is modified
			 * this has to be 1, if 2 then 2 etc itemDef.modifiedModelColors = new int[1];
			 * // same here itemDef.modifiedModelColors[0] = 40; // the texture that it
			 * currently has itemDef.originalModelColors[0] = 70; // the new texture u want
			 * it to have itemDef.stackable = false; break; case 20540: itemDef.name =
			 * "Rune whip"; itemDef.modelID = 65141; itemDef.maleWearId = 65142;
			 * itemDef.femaleWearId = 65142; itemDef21 = ItemDefinition.get(21371);
			 * itemDef.modelOffset1 = itemDef21.modelOffset1; itemDef.modelOffsetX =
			 * itemDef21.modelOffsetX; itemDef.modelOffsetY = itemDef21.modelOffsetY;
			 * itemDef.modelZoom = itemDef21.modelZoom; itemDef.modelRotationY =
			 * itemDef21.modelRotationY; itemDef.modelRotationX = itemDef21.modelRotationX;
			 * itemDef.actions = new String[5]; itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
			 * itemDef.actions[3] = "Upgrade-whip"; itemDef.actions[1] = "Wear";
			 * itemDef.originalModelColors = new int[1]; // if only 1 texture is modified
			 * this has to be 1, if 2 then 2 etc itemDef.modifiedModelColors = new int[1];
			 * // same here itemDef.modifiedModelColors[0] = 40; // the texture that it
			 * currently has itemDef.originalModelColors[0] = 72; // the new texture u want
			 * it to have itemDef.stackable = false; break; case 20541: itemDef.name =
			 * "Dragon whip"; itemDef.modelID = 65141; itemDef.maleWearId = 65142;
			 * itemDef.femaleWearId = 65142; itemDef21 = ItemDefinition.get(21371);
			 * itemDef.modelOffset1 = itemDef21.modelOffset1; itemDef.modelOffsetX =
			 * itemDef21.modelOffsetX; itemDef.modelOffsetY = itemDef21.modelOffsetY;
			 * itemDef.modelZoom = itemDef21.modelZoom; itemDef.modelRotationY =
			 * itemDef21.modelRotationY; itemDef.modelRotationX = itemDef21.modelRotationX;
			 * itemDef.actions = new String[5]; itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
			 * itemDef.actions[3] = "Upgrade-whip"; itemDef.actions[1] = "Wear";
			 * itemDef.originalModelColors = new int[1]; // if only 1 texture is modified
			 * this has to be 1, if 2 then 2 etc itemDef.modifiedModelColors = new int[1];
			 * // same here itemDef.modifiedModelColors[0] = 40; // the texture that it
			 * currently has itemDef.originalModelColors[0] = 74; // the new texture u want
			 * it to have itemDef.stackable = false; break;
			 */

			case 19910:
				itemDef.name = "Thantor helm";
				itemDef.modelID = 65106;
				itemDef.maleEquip1 = 65107;
				itemDef.femaleEquip1 = 65107;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				// itemDef.setTexture(matid, textureid);
				// itemDef.applyTexturing(model, id);
				// itemDef.rdc2 = 8822;
				break;
			case 19916:
				itemDef.name = "Thantor body";
				itemDef.modelID = 65108;
				itemDef.maleEquip1 = 65109;
				itemDef.femaleEquip1 = 65109;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				// itemDef.rdc2 = 8822;
				break;
			case 19911:
				itemDef.name = "Thantor legs";
				itemDef.modelID = 65110;
				itemDef.maleEquip1 = 65111;
				itemDef.femaleEquip1 = 65111;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				// itemDef.rdc2 = 8822;
				break;

			case 15877:
				itemDef.name = "Nuetron Dagger";
				itemDef.rdc2 = 24326;// 24326
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 15921:
				itemDef.name = "Nuetron helmet";
				itemDef.rdc2 = 24326;// 24326
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 16269:
				itemDef.name = "Nuetron boots";
				itemDef.rdc2 = 24326;// 24326
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 15943:
				itemDef.name = "Nuetron gauntlets";
				itemDef.rdc2 = 24326;// 24326
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 15815:
				itemDef.name = "Nuetron shield";
				itemDef.rdc2 = 24326;// 24326
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 19924:
				itemDef.name = "Ryan's shield";
				itemDef21 = ItemDefinition.get(16933);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelID = 65179;
				itemDef.maleEquip1 = 65180;
				itemDef.femaleEquip1 = 65180;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19898:
				itemDef.name = "Barrel hat";
				itemDef21 = ItemDefinition.get(15921);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelID = 65181;
				itemDef.maleEquip1 = 65182;
				itemDef.femaleEquip1 = 65182;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19899:
				itemDef.name = "Beats headphones";
				itemDef21 = ItemDefinition.get(15921);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelID = 65183;
				itemDef.maleEquip1 = 65184;
				itemDef.femaleEquip1 = 65184;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19825:
				itemDef.name = "Necromancer hood";
				itemDef21 = ItemDefinition.get(15921);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelID = 65185;
				itemDef.maleEquip1 = 65186;
				itemDef.femaleEquip1 = 65186;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 19900:
				itemDef.name = "Lumberjack hat";
				itemDef21 = ItemDefinition.get(9920);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelID = itemDef21.modelID;
				itemDef.maleEquip1 = itemDef21.maleEquip1;
				itemDef.femaleEquip1 = itemDef21.femaleEquip1;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 8843;

				break;
			case 19931:
				itemDef.name = "Energy Torva helm";
				itemDef.modelID = 65159;
				itemDef.maleEquip1 = 65160;
				itemDef.femaleEquip1 = 65160;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = -5;
				itemDef.modelZoom = 900;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 19933:
				itemDef.name = "Energy Torva body";
				itemDef.modelID = 65161;
				itemDef.maleEquip1 = 65162;
				itemDef.femaleEquip1 = 65162;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				break;
			case 19934:
				itemDef.name = "Energy Torva legs";
				itemDef.modelID = 65163;
				itemDef.maleEquip1 = 65164;
				itemDef.femaleEquip1 = 65164;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 13922:// stat help
				itemDef.name = "Frost full helm";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 623522;
				break;

			case 13928:// stat help
				itemDef.name = "Frost war hammer";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 623522;
				break;

			case 13916:// stat help
				itemDef.name = "Frost platelegs";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 623522;
				break;

			case 13910:// stat help
				itemDef.name = "Frost platebody";
				itemDef.rdc2 = 623522;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 13952:
				itemDef.rdc2 = 638528482;
				itemDef.name = "Lime coif";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 13946:
				itemDef.rdc2 = 638528482;
				itemDef.name = "Lime leather body";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 13949:
				itemDef.rdc2 = 638528482;
				itemDef.name = "Lime leather chaps";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 16043:
				itemDef.name = "Penguin rapier";
				break;

			case 20118:
				itemDef.name = "Penguin gloves";
				break;

			case 13959:
				itemDef.rdc2 = 638528482;
				itemDef.name = "Lime javelin";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;// 236799 purp - 2356 gold / 773red

			case 13940:
				itemDef.name = "Pink hood";
				itemDef.rdc2 = 2483285;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 13943:
				itemDef.name = "Pink staff";
				itemDef.rdc2 = 2483285;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 13934:
				itemDef.name = "Pink robe top";
				itemDef.rdc2 = 2483285;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 13937:
				itemDef.name = "Pink robe bottom";
				itemDef.rdc2 = 2483285;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 13996:
				//itemDef.rdc2 = 23339;
				itemDef.name = "Exotic helmet";
				ItemDefinition itemGWD113 = ItemDefinition.get(4882);
				itemDef.modelID = 16367;
				itemDef.femaleEquip1 = 16368;
				itemDef.maleEquip1 = 16368;
				itemDef.modelOffsetX = itemGWD113.modelOffsetX;
				itemDef.rotationZ = itemGWD113.rotationZ;
				itemDef.modelOffsetY = itemGWD113.modelOffsetY;
				itemDef.modelZoom = itemGWD113.modelZoom;
				itemDef.rotationY = itemGWD113.rotationY;
				itemDef.rotationX = itemGWD113.rotationX;
				itemDef.actions = itemGWD113.actions;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 13913:
				itemDef.name = "Exotic chainbody";
				ItemDefinition itemGWD1112 = ItemDefinition.get(4894);
				itemDef.modelID = 16369;
				itemDef.femaleEquip1 = 16370;
				itemDef.maleEquip1 = 16370;
				itemDef.modelOffsetX = itemGWD1112.modelOffsetX;
				itemDef.rotationZ = itemGWD1112.rotationZ;
				itemDef.modelOffsetY = -20;
				itemDef.modelZoom = itemGWD1112.modelZoom;
				itemDef.rotationY = itemGWD1112.rotationY;
				itemDef.rotationX = itemGWD1112.rotationX;
				itemDef.actions = itemGWD1112.actions;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 13919:
				ItemDefinition itemGWDs1112 = ItemDefinition.get(5576);
				itemDef.name = "Exotic platelegs";
				itemDef.modelID = 16371;
				itemDef.femaleEquip1 = 16372;
				itemDef.maleEquip1 = 16372;
				itemDef.modelOffsetX = itemGWDs1112.modelOffsetX;
				itemDef.rotationZ = itemGWDs1112.rotationZ;
				itemDef.modelOffsetY = itemGWDs1112.modelOffsetY;
				itemDef.modelZoom = itemGWDs1112.modelZoom;
				itemDef.rotationY = itemGWDs1112.rotationY;
				itemDef.rotationX = itemGWDs1112.rotationX;
				itemDef.actions = itemGWDs1112.actions;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 13931:
				itemDef.name = "Exotic spear";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 44556;
				break;

			case 13925:
				itemDef.name = "Exotic longsword";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 44556;
				break;

			case 19901:
				itemDef.name = "Eternal helm";
				itemDef.modelID = 65095;
				itemDef.maleEquip1 = 65096;
				itemDef.femaleEquip1 = 65096;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 52; // the texture that it currently has
				itemDef.newColors[0] = 60; // the new texture u want it to have
				break;

			case 19902:
				itemDef.name = "Eternal body";
				itemDef.modelID = 65097;
				itemDef.maleEquip1 = 65098;
				itemDef.femaleEquip1 = 65098;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.stackAmounts = new int[10];
				itemDef.stackIDs = new int[10];
				itemDef.stackAmounts[0] = 2;
				itemDef.stackIDs[0] = 19902;
				itemDef.stackAmounts[1] = 3;
				itemDef.stackIDs[1] = 19902;
				itemDef.stackAmounts[2] = 4;
				itemDef.stackIDs[2] = 19902;
				itemDef.stackAmounts[3] = 5;
				itemDef.stackIDs[3] = 19902;
				itemDef.oldColors[0] = 52; // the texture that it currently has
				itemDef.newColors[0] = 60; // the new texture u want it to have
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 19903:
				itemDef.name = "Eternal legs";
				itemDef.modelID = 65099;
				itemDef.maleEquip1 = 65100;
				itemDef.femaleEquip1 = 65100;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors[0] = 52; // the texture that it currently has
				itemDef.newColors[0] = 60; // the new texture u want it to have
				break;

			case 19904:
				itemDef.name = "Eternal gloves";
				itemDef.modelID = 65101;
				itemDef.maleEquip1 = 65102;
				itemDef.femaleEquip1 = 65102;
				itemDef21 = ItemDefinition.get(7462);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors[0] = 52; // the texture that it currently has
				itemDef.newColors[0] = 60; // the new texture u want it to have
				break;

			case 19905:
				itemDef.name = "Eternal boots";
				itemDef.modelID = 65103;
				itemDef.maleEquip1 = 65103;
				itemDef.femaleEquip1 = 65103;
				itemDef21 = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				//	itemDef.rdc2 = 724733835;
				itemDef.oldColors[0] = 52; // the texture that it currently has
				itemDef.newColors[0] = 60; // the new texture u want it to have
				break;

			case 19909:
				itemDef.name = "Moonlight cape";
				itemDef.modelID = 65104;
				itemDef.maleEquip1 = 65105;
				itemDef.femaleEquip1 = 65105;
				itemDef21 = ItemDefinition.get(1007);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				//	itemDef.rdc2 = 724733835;
				itemDef.oldColors[0] = 52; // the texture that it currently has
				itemDef.newColors[0] = 60; // the new texture u want it to have
				itemDef.oldColors[1] = 920; // the texture that it currently has
				itemDef.newColors[1] = 36133; // the new texture u want it to have
				break;
			case 10138:
				itemDef.name = "Fish";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[0] = "Claim";
				itemDef.actions[2] = "Claim-All";
				break;
			case 17634:
				itemDef.name = "Ore";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[0] = "Claim";
				itemDef.actions[2] = "Claim-All";
				break;
			case 14803:
				itemDef.name = "Eternal hat";
				itemDef.modelID = 65326;
				itemDef.maleEquip1 = 65327;
				itemDef.femaleEquip1 = 65327;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				// itemDef.rdc2 = 9303;
				break;
			case 14804:
				/*
				 * itemDef.name = "Eternal robetop"; itemDef.modelID = 65328; itemDef.maleWearId
				 * = 65329; itemDef.femaleWearId = 65329; itemDef2 = ItemDefinition.get(4894);
				 * itemDef.modelOffset1 = itemDef2.modelOffset1; itemDef.modelOffsetX =
				 * itemDef2.modelOffsetX; itemDef.modelOffsetY = itemDef2.modelOffsetY;
				 * itemDef.modelZoom = itemDef2.modelZoom; itemDef.modelRotationY =
				 * itemDef2.modelRotationY; itemDef.modelRotationX = itemDef2.modelRotationX;
				 * itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
				 * itemDef.stackable = false;
				 */
				// itemDef.rdc2 = 9303;
				break;
			case 14805:
				itemDef.name = "Eternal robebottom";
				itemDef.modelID = 65330;
				itemDef.maleEquip1 = 65331;
				itemDef.femaleEquip1 = 65331;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				// itemDef.rdc2 = 9303;
				break;

			case 19956:
				itemDef.name = "Primrose helm";
				itemDef.modelID = 65094;
				itemDef.maleEquip1 = 65090;
				itemDef.femaleEquip1 = 65090;
				itemDef21 = ItemDefinition.get(12960);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 888;
				break;
			case 19955:
				itemDef.name = "Primrose body";
				itemDef.modelID = 65091;
				itemDef.maleEquip1 = 65092;
				itemDef.femaleEquip1 = 65092;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 888;
				break;
			case 19954:
				itemDef.name = "Primrose legs";
				itemDef.modelID = 65093;
				itemDef.maleEquip1 = 65089;// itemDef.modelID = 65089;65094
				itemDef.femaleEquip1 = 65089;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 888;
				break;
			case 20259:
				itemDef.name = "UltraPernix helm";
				itemDef.modelID = 65094;
				itemDef.maleEquip1 = 65090;
				itemDef.femaleEquip1 = 65090;
				itemDef21 = ItemDefinition.get(12960);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 20097:
				itemDef.name = "UltraPernix body";
				itemDef.modelID = 65091;
				itemDef.maleEquip1 = 65092;
				itemDef.femaleEquip1 = 65092;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 19960:
				itemDef.name = "UltraPernix legs";
				itemDef.modelID = 65093;
				itemDef.maleEquip1 = 65089;// itemDef.modelID = 65089;65094
				itemDef.femaleEquip1 = 65089;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 19959:// tetsu
				itemDef.name = "Tetsu helm";
				itemDef.modelID = 65078;
				itemDef.maleEquip1 = 65079;
				itemDef.femaleEquip1 = 65079;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				//	itemDef.rdc2 = 9999;
				itemDef.oldColors = new int[]{55};
				itemDef.newColors = new int[]{54};
				break;
			case 19958:// tetsu
				itemDef.name = "Tetsu body";
				itemDef.modelID = 65080;
				itemDef.maleEquip1 = 65081;
				itemDef.femaleEquip1 = 65081;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				//itemDef.rdc2 = 9999;
				itemDef.oldColors = new int[]{55};
				itemDef.newColors = new int[]{54};
				break;
			case 19957:// tetsu
				itemDef.name = "Tetsu legs";
				itemDef.modelID = 65082;
				itemDef.maleEquip1 = 65083;
				itemDef.femaleEquip1 = 65083;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.oldColors = new int[]{55};
				itemDef.newColors = new int[]{54};
				//	itemDef.rdc2 = 9999;
				break;
			case 19119:
				itemDef.name = "<img=6>Donator Rank Ticket";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[0] = "Claim";
				itemDef21 = ItemDefinition.get(10944);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelID = itemDef21.modelID;
				itemDef.actions = new String[]{"Inspect", null, "Claim-rank", null, "Drop"};
				// itemDef.rdc2 = 55555;
				break;
			case 19120:
				itemDef.name = "<img=7>Super Rank Ticket";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[0] = "Claim";
				itemDef21 = ItemDefinition.get(10944);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelID = itemDef21.modelID;
				itemDef.actions = new String[]{"Inspect", null, "Claim-rank", null, "Drop"};
				// itemDef.rdc2 = 22222;
				break;
			case 19121:
				itemDef.name = "<img=8>Extreme Rank Ticket";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[0] = "Claim";
				itemDef21 = ItemDefinition.get(10944);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelID = itemDef21.modelID;
				itemDef.actions = new String[]{"Inspect", null, "Claim-rank", null, "Drop"};
				// itemDef.rdc2 = 11111;
				break;
			case 19122:
				itemDef.name = "<img=9>Sponsor Rank Ticket";
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[0] = "Claim";
				itemDef21 = ItemDefinition.get(10944);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.modelID = itemDef21.modelID;
				itemDef.actions = new String[]{"Inspect", null, "Claim-rank", null, "Drop"};
				// itemDef.rdc2 = 44444;
				break;
			case 20094:// tetsu
				itemDef.name = "Extetsu helm";
				itemDef.modelID = 65412;
				itemDef.maleEquip1 = 65413;
				itemDef.femaleEquip1 = 65413;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				//	itemDef.rdc2 = 6666;

				break;
			case 20082:// tetsu
				itemDef.name = "Extetsu body";
				itemDef.modelID = 65414;
				itemDef.maleEquip1 = 65415;
				itemDef.femaleEquip1 = 65415;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				//	itemDef.rdc2 = 6666;
				break;
			case 19961:// tetsu
				itemDef.name = "Extetsu legs";
				itemDef.modelID = 65416;
				itemDef.maleEquip1 = 65417;
				itemDef.femaleEquip1 = 65417;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				//	itemDef.rdc2 = 6666;
				break;
			case 10709:// wolf
				itemDef.name = "Wolf helm";
				itemDef.modelID = 65084;
				itemDef.maleEquip1 = 65084;
				itemDef.femaleEquip1 = 65084;
				itemDef21 = ItemDefinition.get(4387);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;

				break;
			case 19173:// wilf
				itemDef.name = "Wolf body";
				itemDef.modelID = 65085;
				itemDef.maleEquip1 = 65085;
				itemDef.femaleEquip1 = 65085;
				break;
			case 19175:// wolf
				itemDef.name = "Wolf legs";
				itemDef.modelID = 65086;
				itemDef.maleEquip1 = 65086;
				itemDef.femaleEquip1 = 65086;
				break;
			case 14367:// wolf
				itemDef.name = "Greenfox helm";
				itemDef.modelID = 65084;
				itemDef.maleEquip1 = 65084;
				itemDef.femaleEquip1 = 65084;
				itemDef21 = ItemDefinition.get(4387);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.rotationZ = itemDef21.rotationZ;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.rdc = 822;

				break;
			case 14347:// wilf
				itemDef.name = "Greenfox body";
				itemDef.modelID = 65085;
				itemDef.maleEquip1 = 65085;
				itemDef.femaleEquip1 = 65085;
				itemDef.rdc2 = 822;
				break;
			case 14357:// wolf
				itemDef.name = "Greenfox legs";
				itemDef.modelID = 65086;
				itemDef.maleEquip1 = 65086;
				itemDef.femaleEquip1 = 65086;
				itemDef.rdc2 = 822;
				break;
			case 4413:// cape
				itemDef.name = "RedSaphron Wings";
				itemDef.modelID = 65030;
				itemDef.maleEquip1 = 65031;
				itemDef.femaleEquip1 = 65031;
				// itemDef.rdc2 = 82222;
				break;
			case 4353:// cape
				itemDef.name = "dragon rider cape";
				itemDef.modelID = 65187;
				itemDef.maleEquip1 = 65188;
				itemDef.femaleEquip1 = 65188;
				// itemDef.rdc2 = 82222;
				break;
			case 12608:
				itemDef.name = "SS Aura";
				itemDef.modelID = 65074;
				itemDef.maleEquip1 = 65074;
				itemDef.femaleEquip1 = 65074;
				itemDef.modelZoom = 3500;
				itemDef.rotationY = 0;
				itemDef.rotationZ = 0;
				//itemDef.rotationX = 0;
				itemDef.oldColors = new int[]{56};
				itemDef.newColors = new int[]{51};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 12630:
				itemDef.copyItem(12608);
				itemDef.name = "Donators Aura";
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;
			case 12610:
				itemDef.name = "SS-BLACK";
				itemDef.modelID = 65075;
				itemDef.maleEquip1 = 65075;
				itemDef.femaleEquip1 = 65075;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 12612:
				itemDef.name = "SS-4";
				itemDef.modelID = 65076;
				itemDef.maleEquip1 = 65076;
				itemDef.femaleEquip1 = 65076;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 12614:
				itemDef.name = "SS-GOD";
				itemDef.modelID = 65077;
				itemDef.maleEquip1 = 65077;
				itemDef.femaleEquip1 = 65077;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 4405:
				itemDef.name = "swoodoo";
				itemDef.modelID = 65032;
				itemDef.maleEquip1 = 65033;
				itemDef.femaleEquip1 = 65033;
				itemDef.actions = new String[5];
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
			case 4371:
				itemDef.name = "Blue wings";
				itemDef.modelID = 65036;
				itemDef.maleEquip1 = 65037;
				itemDef.femaleEquip1 = 65037;
				break;
			case 4373:
				itemDef.name = "<col=000222>Elite Winged Aura"; // slayer
				itemDef.modelID = 65038;
				itemDef.maleEquip1 = 65039;
				itemDef.femaleEquip1 = 65039;
				break;
			case 4315:
				itemDef.name = "Craft Wings"; // slayer
				itemDef.modelID = 65038;
				itemDef.maleEquip1 = 65039;
				itemDef.femaleEquip1 = 65039;
				itemDef.rdc2 = 2252;
				break;
			case 4375:
				itemDef.name = "Angelic Wings"; // slayer
				itemDef.modelID = 65040;
				itemDef.maleEquip1 = 65041;
				itemDef.femaleEquip1 = 65041;
				break;
			case 4377:
				itemDef.name = "Hit cape"; //
				itemDef.modelID = 65042;
				itemDef.maleEquip1 = 65043;
				itemDef.femaleEquip1 = 65043;
				break;
			case 4379:
				itemDef.name = "Cyan Wings"; //
				itemDef.modelID = 65044;
				itemDef.maleEquip1 = 65045;
				itemDef.femaleEquip1 = 65045;
				break;
			case 4407:
				itemDef.name = "Donator wingcape"; //
				itemDef.modelID = 65046;
				itemDef.maleEquip1 = 65047;
				itemDef.femaleEquip1 = 65047;
				break;
			case 4409:
				itemDef.name = "Yellow wings"; //
				itemDef.modelID = 65050;
				itemDef.maleEquip1 = 65051;
				itemDef.femaleEquip1 = 65051;
				break;
			case 4385:
				itemDef.name = "Purple wings"; //
				itemDef.modelID = 65052;
				itemDef.maleEquip1 = 65053;
				itemDef.femaleEquip1 = 65053;
				break;
			case 4387:
				itemDef.name = "Camo wings"; //
				itemDef.modelID = 65054;
				itemDef.maleEquip1 = 65055;
				itemDef.femaleEquip1 = 65055;
				break;
			case 4319:
				itemDef.name = "cryswamp wings"; //
				itemDef.modelID = 65054;
				itemDef.maleEquip1 = 65055;
				itemDef.femaleEquip1 = 65055;
				itemDef.rdc2 = 92020;
				break;
			case 4389:
				itemDef.name = "Dragonslayer wings"; //
				itemDef.modelID = 65056;
				itemDef.maleEquip1 = 65057;
				itemDef.femaleEquip1 = 65057;
				break;
			case 4391:
				itemDef.name = "Red fairy wings"; //
				itemDef.modelID = 65058;
				itemDef.maleEquip1 = 65059;
				itemDef.femaleEquip1 = 65059;
				break;
			case 4321:
				itemDef.name = "dark fairy wings"; //
				itemDef.modelID = 65058;
				itemDef.maleEquip1 = 65059;
				itemDef.femaleEquip1 = 65059;
				itemDef.rdc2 = 1013;
				break;
			case 16755:
			case 16865:
			case 16931:
			case 17171:
			case 17237:
				itemDef.rdc2 = 00000;
				break;
			case 4393:
				itemDef.name = "Inferior wings"; //
				itemDef.modelID = 65060;
				itemDef.maleEquip1 = 65061;
				itemDef.femaleEquip1 = 65061;
				break;
			case 4395:
				itemDef.name = "Demonic wings"; //
				itemDef.modelID = 65062;
				itemDef.maleEquip1 = 65062;
				itemDef.femaleEquip1 = 65063;
				break;
			case 4403:
				itemDef.name = "Tawn wings"; //
				itemDef.modelID = 65062;
				itemDef.maleEquip1 = 65062;
				itemDef.femaleEquip1 = 65063;
				itemDef.rdc2 = 357782;
				break;
			case 4401:
				itemDef.name = "Angel wings"; //
				itemDef.modelID = 65071;
				itemDef.maleEquip1 = 65071;
				itemDef.femaleEquip1 = 65072;
				break;
			case 4411:
				itemDef.name = "Grime wings"; //
				itemDef.modelID = 65064;
				itemDef.maleEquip1 = 65065;
				itemDef.femaleEquip1 = 65065;
				itemDef.rdc2 = 357782;

				break;
			case 4397:
				itemDef.name = "Green wingcape"; //
				itemDef.modelID = 65066;
				itemDef.maleEquip1 = 65067;
				itemDef.femaleEquip1 = 65067;
				break;
			case 4399:
				itemDef.name = "Big bird wings"; //
				itemDef.modelID = 65069;
				itemDef.maleEquip1 = 65068;
				itemDef.femaleEquip1 = 65068;
				break;
			case 4381:
				itemDef.name = "Chicken feathers"; //
				itemDef.modelID = 65048;
				itemDef.maleEquip1 = 65048;
				itemDef.femaleEquip1 = 65048;
				break;
			case 4383:
				itemDef.name = "Royal cape"; //
				itemDef.modelID = 65049;
				itemDef.maleEquip1 = 65049;
				itemDef.femaleEquip1 = 65049;
				break;
			case 4317:
				itemDef.name = "Neptune cape"; //
				itemDef.modelID = 65049;
				itemDef.maleEquip1 = 65049;
				itemDef.femaleEquip1 = 65049;
				itemDef.rdc2 = 32523;
				break;

			case 4369:
				itemDef.name = "Shadow wings";
				itemDef.modelID = 65034;
				itemDef.maleEquip1 = 65035;
				itemDef.femaleEquip1 = 65035;
				break;

			case 22058:
				itemDef.name = "swag chest"; // temp replace later
				itemDef.modelID = 27725;
				itemDef.maleEquip1 = 27725;
				itemDef.femaleEquip1 = 27725;
				break;
			case 22059:
				itemDef.name = "swag chest"; // temp replace later
				itemDef.modelID = 27740;
				itemDef.maleEquip1 = 27740;
				itemDef.femaleEquip1 = 27740;
				break;
			case 22054:
				itemDef.name = "Tuxedo";
				itemDef.modelID = 12752;
				itemDef.maleEquip1 = 12752;
				itemDef.femaleEquip1 = 12752;
				itemDef.anInt188 = 10301;
				itemDef.newColors = new int[1];
				itemDef.oldColors = new int[1];
				itemDef.oldColors[0] = 8741; // NORM
				itemDef.newColors[0] = 920; // CHANGE
				itemDef.rotationY = 200;
				itemDef.rotationX = 0;
				itemDef.modelZoom = 1180;
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = 120;
				break;
			case 18686:
				ItemDefinition itemTormented = ItemDefinition.get(22008);
				itemDef.modelID = itemTormented.modelID;
				itemDef.femaleEquip1 = itemTormented.femaleEquip1;
				itemDef.maleEquip1 = itemTormented.maleEquip1;
				itemDef.modelOffsetX = itemTormented.modelOffsetX;
				itemDef.rotationZ = itemTormented.rotationZ;
				itemDef.modelOffsetY = itemTormented.modelOffsetY;
				itemDef.modelZoom = itemTormented.modelZoom;
				itemDef.rotationY = itemTormented.rotationY;
				itemDef.rotationX = itemTormented.rotationX;
				itemDef.actions = itemTormented.actions;
				itemDef.name = "Noxious tentacle";
				itemDef.rdc2 = 63777333;

				break;
			case 18683:
				ItemDefinition itemTormented1 = ItemDefinition.get(19111);
				itemDef.modelID = itemTormented1.modelID;
				itemDef.femaleEquip1 = itemTormented1.femaleEquip1;
				itemDef.maleEquip1 = itemTormented1.maleEquip1;
				itemDef.modelOffsetX = itemTormented1.modelOffsetX;
				itemDef.rotationZ = itemTormented1.rotationZ;
				itemDef.modelOffsetY = itemTormented1.modelOffsetY;
				itemDef.modelZoom = itemTormented1.modelZoom;
				itemDef.rotationY = itemTormented1.rotationY;
				itemDef.rotationX = itemTormented1.rotationX;
				itemDef.actions = itemTormented1.actions;
				itemDef.name = "Satanic tokhaar-kal";
				itemDef.rdc2 = 883563;
				break;
			case 17273:

				break;
			case 18684:
				ItemDefinition itemTormented11 = ItemDefinition.get(17273);
				itemDef.modelID = itemTormented11.modelID;
				itemDef.femaleEquip1 = itemTormented11.femaleEquip1;
				itemDef.maleEquip1 = itemTormented11.maleEquip1;
				itemDef.modelOffsetX = itemTormented11.modelOffsetX;
				itemDef.rotationZ = itemTormented11.rotationZ;
				itemDef.modelOffsetY = itemTormented11.modelOffsetY;
				itemDef.modelZoom = itemTormented11.modelZoom;
				itemDef.rotationY = itemTormented11.rotationY;
				itemDef.rotationX = itemTormented11.rotationX;
				itemDef.actions = itemTormented11.actions;
				itemDef.name = "Tormented defender";
				itemDef.rdc2 = 53664333;

				break;
			case 11617:
				ItemDefinition itemFury = ItemDefinition.get(15418);
				itemDef.modelID = 17182;
				itemDef.femaleEquip1 = 17183;
				itemDef.maleEquip1 = 17183;
				itemDef.modelOffsetX = itemFury.modelOffsetX;
				itemDef.rotationZ = itemFury.rotationZ;
				itemDef.modelOffsetY = -80;
				itemDef.modelZoom = itemFury.modelZoom;
				itemDef.rotationY = itemFury.rotationY;
				itemDef.rotationX = 40;
				itemDef.actions = itemFury.actions;
				itemDef.name = "Amulet of Gluttony (u)";
				break;

			case 23299:
				itemDef.copyItem(18829);
				itemDef.name = "Gemstone Kaseki";
				itemDef.rotationX = 0;
				itemDef.rdc2 = 23815;
				break;

			case 9687:
				itemDef.copyItem(18829);
				itemDef.name = "Steadfast scale";
				itemDef.rotationX = 180;
				itemDef.rotationY = 150;
				itemDef.rotationZ = 10;
				itemDef.rdc3 = 11;
				itemDef.modelZoom = 1000;
				break;
			case 9688:
				itemDef.copyItem(7860);
				itemDef.name = "Drone tail-part";
				itemDef.rotationX = 350;
				itemDef.rotationY = 330;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 5;
				itemDef.modelOffsetY = 0;
				itemDef.rdc3 = 11;
				itemDef.modelZoom = 1000;
				break;
				case 9689:
				itemDef.copyItem(19950);
				itemDef.name = "Mutant gland";
				itemDef.rdc3 = 11;
				break;

			case 3909:
				ItemDefinition itemFury1 = ItemDefinition.get(1635);
				itemDef.modelOffsetX = itemFury1.modelOffsetX;
				itemDef.rotationZ = itemFury1.rotationZ;
				itemDef.modelZoom = itemFury1.modelZoom;
				itemDef.rotationY = itemFury1.rotationY;
				itemDef.rotationX = itemFury1.rotationX;
				itemDef.actions = itemFury1.actions;
				itemDef.name = "Ring of Gluttony (u)";
				itemDef.modelID = 64207;
				itemDef.maleEquip1 = 64208;
				itemDef.femaleEquip1 = 64208;
				itemDef.modelOffsetY = 0;
				itemDef.colorChange = new double[]{1.5, 0.1, 0.1};
				break;

			case 6737:
				itemDef.copyItem(3909);
				itemDef.name = "Ring of Gluttony";
				itemDef.modelID = 64207;
				itemDef.maleEquip1 = 64208;
				itemDef.femaleEquip1 = 64208;
				itemDef.stackable = false;
				itemDef.rdc2 = 76657; //54440
				itemDef.modelOffsetY = 0;
				break;

			case 3905:
				ItemDefinition itemFury11 = ItemDefinition.get(13007);
				itemDef.modelID = itemFury11.modelID;
				itemDef.femaleEquip1 = itemFury11.femaleEquip1;
				itemDef.maleEquip1 = itemFury11.maleEquip1;
				itemDef.modelOffsetX = itemFury11.modelOffsetX;
				itemDef.rotationZ = itemFury11.rotationZ;
				itemDef.modelOffsetY = itemFury11.modelOffsetY;
				itemDef.modelZoom = itemFury11.modelZoom;
				itemDef.rotationY = itemFury11.rotationY;
				itemDef.rotationX = itemFury11.rotationX;
				itemDef.actions = itemFury11.actions;
				itemDef.name = "Boss Gloves";
				itemDef.rdc2 = 810;
				break;

			case 3805:
				ItemDefinition itemFury111 = ItemDefinition.get(20068);
				itemDef.modelID = itemFury111.modelID;
				itemDef.femaleEquip1 = itemFury111.femaleEquip1;
				itemDef.maleEquip1 = itemFury111.maleEquip1;
				itemDef.modelOffsetX = itemFury111.modelOffsetX;
				itemDef.rotationZ = itemFury111.rotationZ;
				itemDef.modelOffsetY = itemFury111.modelOffsetY;
				itemDef.modelZoom = itemFury111.modelZoom;
				itemDef.rotationY = itemFury111.rotationY;
				itemDef.rotationX = itemFury111.rotationX;
				itemDef.actions = itemFury111.actions;
				itemDef.name = "Zara's accumulator";
				itemDef.rdc2 = 7234;
				break;
			case 3907:
				ItemDefinition itemFury1111 = ItemDefinition.get(18782);
				itemDef.modelID = itemFury1111.modelID;
				itemDef.femaleEquip1 = itemFury1111.femaleEquip1;
				itemDef.maleEquip1 = itemFury1111.maleEquip1;
				itemDef.modelOffsetX = itemFury1111.modelOffsetX;
				itemDef.rotationZ = itemFury1111.rotationZ;
				itemDef.modelOffsetY = itemFury1111.modelOffsetY;
				itemDef.modelZoom = itemFury1111.modelZoom;
				itemDef.rotationY = itemFury1111.rotationY;
				itemDef.rotationX = itemFury1111.rotationX;
				itemDef.actions = itemFury1111.actions;
				itemDef.name = "Zara's xp lamp";
				itemDef.rdc2 = 7623;
				break;
			case 18685:
				ItemDefinition itemTormented111 = ItemDefinition.get(14484);
				itemDef.modelID = itemTormented111.modelID;
				itemDef.femaleEquip1 = itemTormented111.femaleEquip1;
				itemDef.maleEquip1 = itemTormented111.maleEquip1;
				itemDef.modelOffsetX = itemTormented111.modelOffsetX;
				itemDef.rotationZ = itemTormented111.rotationZ;
				itemDef.modelOffsetY = itemTormented111.modelOffsetY;
				itemDef.modelZoom = itemTormented111.modelZoom;
				itemDef.rotationY = itemTormented111.rotationY;
				itemDef.rotationX = itemTormented111.rotationX;
				itemDef.actions = itemTormented111.actions;
				itemDef.name = "Tormented claws";
				itemDef.rdc2 = 53664333;

				break;
			case 22053:
				itemDef.name = "Ecumenical key";
				itemDef.modelID = 2372;
				itemDef.stackable = false;
				itemDef.actions = null;
				itemDef.groundActions = null;
				itemDef.rotationY = 338;
				itemDef.rotationX = 1701;
				itemDef.modelZoom = 775;
				itemDef.modelOffsetX = -2;
				// itemDef.modelOffsetX = -3;
				itemDef.modelOffsetY = -7;
				itemDef.oldColors = new int[2];
				itemDef.newColors = new int[2];
				itemDef.oldColors[0] = 8128;
				itemDef.newColors[0] = 41189;// 43069;
				/*
				 * Dumping: Crystal key itemId: 989 modelId: 2372 maleWearId: -1 femaleWearId:
				 * -1 modelOffset1: -3 modelOffSetX: 0 modelOffSetY: 5 modelRotationY: 328
				 * modelRotationX: 20 modelZoom: 700 modifiedModelColors[0]: 8128
				 * originalModelColors[0]: 43069 Action[0]: null Action[1]: null Action[2]: null
				 * Action[3]: null Action[4]: Drop groundAction[0]: null groundAction[1]: null
				 * groundAction[2]: Take groundAction[3]: null groundAction[4]: null
				 */
				break;
			case 78:
				itemDef.name = "Soul arrow";
				break;
			case 22034:

				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wield";
				itemDef.newColors = new int[6];
				itemDef.oldColors = new int[6];
				itemDef.certID = -1;
				itemDef.certTemplateID = -1;
				itemDef.stackable = false;
				/*
				 * itemDef.modifiedModelColors[0] = 115; itemDef.modifiedModelColors[1] = 107;
				 * itemDef.modifiedModelColors[2] = 10167; itemDef.modifiedModelColors[3] =
				 * 10171; itemDef.originalModelColors[0] = 5409; itemDef.originalModelColors[1]
				 * = 5404; itemDef.originalModelColors[2] = 6449; itemDef.originalModelColors[3]
				 * = 7390;
				 */
				itemDef.oldColors[0] = 5409;
				itemDef.oldColors[1] = 5404;
				itemDef.oldColors[2] = 6449;
				itemDef.oldColors[3] = 7390;
				itemDef.newColors[0] = 115;
				itemDef.newColors[1] = 107;
				itemDef.newColors[2] = 10167;
				itemDef.newColors[3] = 10171;
				itemDef.modelID = 19967;
				itemDef.modelZoom = 1325;
				itemDef.rotationY = 240;
				itemDef.rotationX = 110;
				// itemDef.modelOffsetX = 0;
				// itemDef.modelOffset1 = 0;
				// itemDef.modelOffsetY = -3;
				itemDef.maleEquip1 = 19839;
				// itemDef.anInt188 = -1;
				itemDef.femaleEquip1 = 19839;
				// itemDef.anInt164 = -1;
				// itemDef.maleDialogue = 69;
				// itemDef.femaleDialogue = 127;
				itemDef.stackable = false;
				itemDef.name = "Armadyl Crossbow";
				itemDef.description = "Black santa hat.".getBytes();
				break;
			case 5020:
				itemDef.name = "<col=ddc99f>AFK ticket";
				// itemDef.rdc2 = 999122;
				itemDef.stackable = true;
				break;
			case 3686:
				itemDef.name = "<col=4689fe>100M ticket";
				itemDef.rdc2 = 999122;
				ItemDefinition itemDefticket11 = ItemDefinition.get(5020);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = itemDefticket11.modelID;
				itemDef.femaleEquip1 = itemDefticket11.femaleEquip1;
				itemDef.maleEquip1 = itemDefticket11.maleEquip1;
				itemDef.modelOffsetX = itemDefticket11.modelOffsetX;
				itemDef.rotationZ = itemDefticket11.rotationZ;
				itemDef.modelOffsetY = itemDefticket11.modelOffsetY;
				itemDef.modelZoom = itemDefticket11.modelZoom;
				itemDef.rotationY = itemDefticket11.rotationY;
				itemDef.rotationX = itemDefticket11.rotationX;
				// itemDef.rdc2 = ;
				itemDef.stackable = true;
				break;
			case 3687:
				itemDef.name = "<col=c762fb>1B ticket";
				ItemDefinition itemDefticket = ItemDefinition.get(5020);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = itemDefticket.modelID;
				itemDef.femaleEquip1 = itemDefticket.femaleEquip1;
				itemDef.maleEquip1 = itemDefticket.maleEquip1;
				itemDef.modelOffsetX = itemDefticket.modelOffsetX;
				itemDef.actions = itemDefticket.actions;
				itemDef.rotationZ = itemDefticket.rotationZ;
				itemDef.modelOffsetY = itemDefticket.modelOffsetY;
				itemDef.modelZoom = itemDefticket.modelZoom;
				itemDef.rotationY = itemDefticket.rotationY;
				itemDef.rotationX = itemDefticket.rotationX;
				itemDef.rdc2 = 2352;
				itemDef.stackable = true;
				break;
			case 18835:
				ItemDefinition itemDefticket1 = ItemDefinition.get(11694);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = itemDefticket1.modelID;
				itemDef.femaleEquip1 = itemDefticket1.femaleEquip1;
				itemDef.maleEquip1 = itemDefticket1.maleEquip1;
				itemDef.modelOffsetX = itemDefticket1.modelOffsetX;
				itemDef.rotationZ = itemDefticket1.rotationZ;
				itemDef.modelOffsetY = itemDefticket1.modelOffsetY;
				itemDef.modelZoom = itemDefticket1.modelZoom;
				itemDef.rotationY = itemDefticket1.rotationY;
				itemDef.rotationX = itemDefticket1.rotationX;
				itemDef.actions = itemDefticket1.actions;
				itemDef.name = "Kree'arra godsword";

				itemDef.rdc2 = 6235;
				break;
			case 18834:
				itemDef.name = "Kree'arra helmet";
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 80;
				itemDef.modelZoom = 773;
				itemDef.rotationY = 10;
				itemDef.rotationX = 250;
				itemDef.modelID = 16596;
				itemDef.maleEquip1 = 16596;
				itemDef.femaleEquip1 = 16596;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
			case 18801:
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 50;
				itemDef.modelZoom = 1580;
				itemDef.rotationY = 20;
				itemDef.rotationX = 0;
				itemDef.name = "Kree'arra chestplate ";
				itemDef.modelZoom = 1500;
				itemDef.modelID = 16602;
				itemDef.maleEquip1 = 16602;
				itemDef.femaleEquip1 = 16602;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
			case 18800:
				itemDef.name = "Kree'arra chainskirt";
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -12;
				itemDef.modelZoom = 1757;
				itemDef.rotationY = 0;
				itemDef.rotationX = 2040;
				itemDef.modelID = 16642;
				itemDef.maleEquip1 = 16642;
				itemDef.femaleEquip1 = 16642;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
			case 18799:
				ItemDefinition itemGWD11111 = ItemDefinition.get(22034);
				itemDef.modelID = itemGWD11111.modelID;
				itemDef.femaleEquip1 = itemGWD11111.femaleEquip1;
				itemDef.maleEquip1 = itemGWD11111.maleEquip1;
				itemDef.modelOffsetX = itemGWD11111.modelOffsetX;
				itemDef.rotationZ = itemGWD11111.rotationZ;
				itemDef.modelOffsetY = itemGWD11111.modelOffsetY;
				itemDef.modelZoom = itemGWD11111.modelZoom;
				itemDef.rotationY = itemGWD11111.rotationY;
				itemDef.rotationX = itemGWD11111.rotationX;
				itemDef.actions = itemGWD11111.actions;
				itemDef.name = "Kree'arra crossbow";
				itemDef.rdc2 = 10135;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
			case 18798:
				ItemDefinition itemBando = ItemDefinition.get(11696);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = itemBando.modelID;
				itemDef.femaleEquip1 = itemBando.femaleEquip1;
				itemDef.maleEquip1 = itemBando.maleEquip1;
				itemDef.modelOffsetX = itemBando.modelOffsetX;
				itemDef.rotationZ = itemBando.rotationZ;
				itemDef.modelOffsetY = itemBando.modelOffsetY;
				itemDef.modelZoom = itemBando.modelZoom;
				itemDef.rotationY = itemBando.rotationY;
				itemDef.rotationX = itemBando.rotationX;
				itemDef.actions = itemBando.actions;
				itemDef.name = "General godsword";

				itemDef.rdc2 = 4488;
				break;
			case 18797:
				ItemDefinition itemBando1 = ItemDefinition.get(11724);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = itemBando1.modelID;
				itemDef.femaleEquip1 = itemBando1.femaleEquip1;
				itemDef.maleEquip1 = itemBando1.maleEquip1;
				itemDef.modelOffsetX = itemBando1.modelOffsetX;
				itemDef.rotationZ = itemBando1.rotationZ;
				itemDef.modelOffsetY = itemBando1.modelOffsetY;
				itemDef.modelZoom = itemBando1.modelZoom;
				itemDef.rotationY = itemBando1.rotationY;
				itemDef.rotationX = itemBando1.rotationX;
				itemDef.actions = itemBando1.actions;
				itemDef.name = "General chestplate";

				itemDef.rdc2 = 445488;
				break;
			case 18795:
				ItemDefinition itemBando11 = ItemDefinition.get(11726);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = itemBando11.modelID;
				itemDef.femaleEquip1 = itemBando11.femaleEquip1;
				itemDef.maleEquip1 = itemBando11.maleEquip1;
				itemDef.modelOffsetX = itemBando11.modelOffsetX;
				itemDef.rotationZ = itemBando11.rotationZ;
				itemDef.modelOffsetY = itemBando11.modelOffsetY;
				itemDef.modelZoom = itemBando11.modelZoom;
				itemDef.rotationY = itemBando11.rotationY;
				itemDef.rotationX = itemBando11.rotationX;
				itemDef.actions = itemBando11.actions;

				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.name = "General tassets";
				itemDef.rdc2 = 445488;
				break;
			case 19794:
				ItemDefinition itemBando111 = ItemDefinition.get(11728);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = itemBando111.modelID;
				itemDef.femaleEquip1 = itemBando111.femaleEquip1;
				itemDef.maleEquip1 = itemBando111.maleEquip1;
				itemDef.modelOffsetX = itemBando111.modelOffsetX;
				itemDef.rotationZ = itemBando111.rotationZ;
				itemDef.modelOffsetY = itemBando111.modelOffsetY;
				itemDef.modelZoom = itemBando111.modelZoom;
				itemDef.rotationY = itemBando111.rotationY;
				itemDef.rotationX = itemBando111.rotationX;
				itemDef.actions = itemBando111.actions;
				itemDef.name = "General boots";

				itemDef.rdc2 = 445488;
				break;

			case 18792:
				ItemDefinition itemZara = ItemDefinition.get(11730);
				itemDef.modelID = itemZara.modelID;
				itemDef.femaleEquip1 = itemZara.femaleEquip1;
				itemDef.maleEquip1 = itemZara.maleEquip1;
				itemDef.modelOffsetX = itemZara.modelOffsetX;
				itemDef.rotationZ = itemZara.rotationZ;
				itemDef.modelOffsetY = itemZara.modelOffsetY;
				itemDef.modelZoom = itemZara.modelZoom;
				itemDef.rotationY = itemZara.rotationY;
				itemDef.rotationX = itemZara.rotationX;
				itemDef.actions = itemZara.actions;
				itemDef.name = "Zilyana sword";

				itemDef.rdc2 = 53633;
				break;
			case 15900:
				itemDef.name = "Zilyana hood";

				itemDef.rdc2 = 87295;
				break;
			case 15845:
				itemDef.name = "Zilyana robe top";

				itemDef.rdc2 = 87295;
				break;
			case 15805:
				itemDef.name = "Zilyana robe bottom";

				itemDef.rdc2 = 87295;
				break;
			case 18796:
				ItemDefinition itemSara1 = ItemDefinition.get(11698);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = itemSara1.modelID;
				itemDef.femaleEquip1 = itemSara1.femaleEquip1;
				itemDef.maleEquip1 = itemSara1.maleEquip1;
				itemDef.modelOffsetX = itemSara1.modelOffsetX;
				itemDef.rotationZ = itemSara1.rotationZ;
				itemDef.modelOffsetY = itemSara1.modelOffsetY;
				itemDef.modelZoom = itemSara1.modelZoom;
				itemDef.rotationY = itemSara1.rotationY;
				itemDef.rotationX = itemSara1.rotationX;
				itemDef.actions = itemSara1.actions;

				itemDef.name = "Zilyana godsword";
				itemDef.rdc2 = 53633;
				break;
			case 18790:
				ItemDefinition itemZammy = ItemDefinition.get(11716);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = itemZammy.modelID;
				itemDef.femaleEquip1 = itemZammy.femaleEquip1;
				itemDef.maleEquip1 = itemZammy.maleEquip1;
				itemDef.modelOffsetX = itemZammy.modelOffsetX;
				itemDef.rotationZ = itemZammy.rotationZ;
				itemDef.modelOffsetY = itemZammy.modelOffsetY;
				itemDef.modelZoom = itemZammy.modelZoom;
				itemDef.rotationY = itemZammy.rotationY;
				itemDef.rotationX = itemZammy.rotationX;
				itemDef.actions = itemZammy.actions;
				itemDef.name = "Tsutsaroth spear";
				itemDef.rdc2 = 11332;
				break;
			case 21069:
				itemDef.name = "Ruthless ring";
				ItemDefinition itemdefyogipic1111 = ItemDefinition.get(1635);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64207;
				itemDef.maleEquip1 = 64208;
				itemDef.femaleEquip1 = 64208;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				itemDef.rdc2 = 23662;
				break;
			case 21070:
				itemDef.name = "Ruthless scimitar";
				itemdefyogipic1111 = ItemDefinition.get(4587);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64209;
				itemDef.maleEquip1 = 64210;
				itemDef.femaleEquip1 = 64210;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 23662;
				break;
			case 21071:
				itemDef.name = "Ruthless cape";
				itemdefyogipic1111 = ItemDefinition.get(2413);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = -50;
				itemDef.modelZoom = 2300;
				itemDef.rotationY = 200;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64211;
				itemDef.maleEquip1 = 64212;
				itemDef.femaleEquip1 = 64212;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 23662;
				break;
			case 21072:
				itemDef.name = "Ruthless rapier";
				itemdefyogipic1111 = ItemDefinition.get(4587);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64213;
				itemDef.maleEquip1 = 64214;
				itemDef.femaleEquip1 = 64214;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 77743;
				break;
			case 21073:
				itemDef.name = "Ruthless Scimitar";
				itemdefyogipic1111 = ItemDefinition.get(4587);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.maleEquip1 = itemdefyogipic1111.maleEquip1;
				itemDef.femaleEquip1 = itemdefyogipic1111.femaleEquip1;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wear", null, "Upgrade", "Drop"};
				itemDef.stackable = false;

				itemDef.rdc2 = 12124;
				break;
			case 13263:
				itemDef.actions = new String[]{null, "Wear", null, "Upgrade", "Drop"};
				break;

			case 21075:
				itemDef.name = "Slayer helmet [Level 1]";
				itemdefyogipic1111 = ItemDefinition.get(13263);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.maleEquip1 = itemdefyogipic1111.maleEquip1;
				itemDef.femaleEquip1 = itemdefyogipic1111.femaleEquip1;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wear", null, "Upgrade", "Drop"};
				itemDef.stackable = false;
				//
				itemDef.rdc2 = 35363;
				break;
			case 21076:
				itemDef.name = "Slayer helmet [Level 2]";
				itemdefyogipic1111 = ItemDefinition.get(13263);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.maleEquip1 = itemdefyogipic1111.maleEquip1;
				itemDef.femaleEquip1 = itemdefyogipic1111.femaleEquip1;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wear", null, "Upgrade", "Drop"};
				itemDef.stackable = false;
				//
				itemDef.rdc2 = 444444;
				break;
			case 21077:
				itemDef.name = "Slayer helmet [level 3]";
				itemdefyogipic1111 = ItemDefinition.get(13263);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.maleEquip1 = itemdefyogipic1111.maleEquip1;
				itemDef.femaleEquip1 = itemdefyogipic1111.femaleEquip1;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wear", null, "Upgrade", "Drop"};
				itemDef.stackable = false;
				//
				itemDef.rdc2 = 8858;
				break;

			case 21078:
				itemDef.name = "Slayer helmet [Level 4]";
				itemdefyogipic1111 = ItemDefinition.get(13263);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.maleEquip1 = itemdefyogipic1111.maleEquip1;
				itemDef.femaleEquip1 = itemdefyogipic1111.femaleEquip1;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wear", null, "Upgrade", "Drop"};
				itemDef.stackable = false;
				//
				itemDef.rdc2 = 8808080;//8808080
				break;
			case 21079:
				itemDef.name = "Slayer helmet [MAX]";
				itemdefyogipic1111 = ItemDefinition.get(13263);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.maleEquip1 = itemdefyogipic1111.maleEquip1;
				itemDef.femaleEquip1 = itemdefyogipic1111.femaleEquip1;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				//
				itemDef.rdc2 = 74623;
				break;
			case 15230:
				itemDef.name = "Zeus full helm";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = 950;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64165;
				itemDef.maleEquip1 = 64166;
				itemDef.femaleEquip1 = 64166;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{73};
				break;
			case 15231:
				itemDef.name = "Zeus body";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64167;
				itemDef.maleEquip1 = 64168;
				itemDef.femaleEquip1 = 64168;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{73};
				break;
			case 15232:
				itemDef.name = "Zeus legs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64169;
				itemDef.maleEquip1 = 64170;
				itemDef.femaleEquip1 = 64170;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{73};
				break;
			case 15233:
				itemDef.name = "Zeus Hammer";
				itemDef.modelID = 64171;
				itemDef.maleEquip1 = 64172;
				itemDef.femaleEquip1 = 64172;
				itemDef21 = ItemDefinition.get(4755);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{73};
				break;
			case 15234:
				itemDef.name = "Zeus shield";
				itemdefyogipic1111 = ItemDefinition.get(1540);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64173;
				itemDef.maleEquip1 = 64174;
				itemDef.femaleEquip1 = 64174;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{73};
				break;
			case 21048:
				itemDef.name = "Fiya Sword+";
				itemDef.modelID = 64280;
				itemDef.maleEquip1 = 64281;
				itemDef.femaleEquip1 = 64281;
				itemDef21 = ItemDefinition.get(4755);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{73};
				break;
			case 21049:
				itemDef.name = "Fiya Shield+";
				itemdefyogipic1111 = ItemDefinition.get(1540);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64282;
				itemDef.maleEquip1 = 64283;
				itemDef.femaleEquip1 = 64283;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{73};
				break;
			case 21031:
				itemDef.name = "Hades full helm";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = 950;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64259;
				itemDef.maleEquip1 = 64260;
				itemDef.femaleEquip1 = 64260;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 2724624;
				break;
			case 21032:
				itemDef.name = "Hades body";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64261;
				itemDef.maleEquip1 = 64262;
				itemDef.femaleEquip1 = 64262;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 2724624;
				break;
			case 21033:
				itemDef.name = "Hades legs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64263;
				itemDef.maleEquip1 = 64264;
				itemDef.femaleEquip1 = 64264;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.rdc2 = 2724624;
				break;
			case 21034:
				itemDef.name = "Hades Hammer";
				itemDef.modelID = 64265;
				itemDef.maleEquip1 = 64266;
				itemDef.femaleEquip1 = 64266;
				itemDef21 = ItemDefinition.get(4755);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.rdc2 = 99957;
				break;
			case 21035:
				itemDef.name = "Hades shield";
				itemdefyogipic1111 = ItemDefinition.get(1540);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64267;
				itemDef.maleEquip1 = 64268;
				itemDef.femaleEquip1 = 64268;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				itemDef.rdc2 = 2724624;
				break;
			case 15235:
				itemDef.name = "Electric gloves";
				itemdefyogipic1111 = ItemDefinition.get(7461);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = 1270;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64175;
				itemDef.maleEquip1 = 64176;
				itemDef.femaleEquip1 = 64176;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
			case 15236:
				itemDef.name = "Electric boots";
				itemdefyogipic1111 = ItemDefinition.get(7114);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = 1200;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64177;
				itemDef.maleEquip1 = 64178;
				itemDef.femaleEquip1 = 64178;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
			case 11305:
				itemDef.name = "Earthquake full helm";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64151;
				itemDef.maleEquip1 = 64152;
				itemDef.femaleEquip1 = 64152;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 3462;
				break;
			case 11306:
				itemDef.name = "Earthquake platebody";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64153;
				itemDef.maleEquip1 = 64154;
				itemDef.femaleEquip1 = 64154;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 3462;
				break;

			case 11307:
				itemDef.name = "Earthquake platelegs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64155;
				itemDef.maleEquip1 = 64156;
				itemDef.femaleEquip1 = 64156;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 3462;
				break;
			case 11308:
				itemDef.name = "Earthquake battlesword";
				itemDef.modelID = 64157;
				itemDef.maleEquip1 = 64158;
				itemDef.femaleEquip1 = 64158;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 3462;

				break;
			case 11300:
				itemDef.name = "Defender full helm";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64141;
				itemDef.maleEquip1 = 64142;
				itemDef.femaleEquip1 = 64142;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{58};
				break;
			case 11301:
				itemDef.name = "Defender fighterbody";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64143;
				itemDef.maleEquip1 = 64144;
				itemDef.femaleEquip1 = 64144;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{58};
				break;
			case 11302:
				itemDef.name = "Defender fighterlegs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64145;
				itemDef.maleEquip1 = 64146;
				itemDef.femaleEquip1 = 64146;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{58};
				break;
			case 11303:
				itemDef.name = "Defender kiteshield";
				itemdefyogipic1111 = ItemDefinition.get(1540);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64147;
				itemDef.maleEquip1 = 64148;
				itemDef.femaleEquip1 = 64148;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{58};
				break;
			case 11304:
				itemDef.name = "Defender cape";
				itemdefyogipic1111 = ItemDefinition.get(2413);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64149;
				itemDef.maleEquip1 = 64150;
				itemDef.femaleEquip1 = 64150;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{58};
				break;
			case 11315:
				ItemDefinition itemDef2111 = ItemDefinition.get(12479);
				itemDef.modelID = 64100;
				itemDef.modelOffsetX = itemDef2111.modelOffsetX;
				//itemDef.modelOffsetX = itemDef211.modelOffsetX;
				itemDef.modelOffsetY = itemDef2111.modelOffsetY;
				itemDef.modelZoom = 7950;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.name = "<img=1355><col=f8ac00>double afk pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;

			case 2098:
				itemDef.name = "Skilling ticket";
				itemDef.rdc2 = 12511;
				itemDef.stackable = true;
				itemDef21 = ItemDefinition.get(18652);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.modelID = itemDef21.modelID;
				itemDef.actions = itemDef21.actions;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				break;
			case 20511:
				ItemDefinition hooker = ItemDefinition.get(12479);
				itemDef.modelID = 36071;
				itemDef.modelOffsetX = 2;
				//itemDef.modelOffsetX = itemDef211.modelOffsetX;
				itemDef.modelOffsetY = 80;
				itemDef.rotationY = 204;
				itemDef.rotationX = 20;
				itemDef.modelZoom = 2700;
				itemDef.name = "Hooker pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 23252:
				ItemDefinition bloodpet = ItemDefinition.get(12479);
				itemDef.modelID = 18146;
				itemDef.modelOffsetX = 2;
				//itemDef.modelOffsetX = itemDef211.modelOffsetX;
				itemDef.modelOffsetY = 80;
				itemDef.rotationY = 204;
				itemDef.rotationX = 20;
				itemDef.modelZoom = 3200;
				itemDef.name = "Blood demon pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 5504:
				ItemDefinition charizard = ItemDefinition.get(12479);
				itemDef.modelID = 64067;
				itemDef.modelOffsetX = charizard.modelOffsetX;
				//itemDef.modelOffsetX = itemDef211.modelOffsetX;
				itemDef.modelOffsetY = charizard.modelOffsetY;
				itemDef.modelZoom = 4000;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.name = "Charizard pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", "Upgrade-pet", "Drop"};
				break;
			case 5506:
				ItemDefinition donkeykong2 = ItemDefinition.get(12479);
				itemDef.modelID = 64225;
				itemDef.modelOffsetX = donkeykong2.modelOffsetX;
				//itemDef.modelOffsetX = itemDef211.modelOffsetX;
				itemDef.modelOffsetY = donkeykong2.modelOffsetY;
				itemDef.modelZoom = 4000;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.name = "Donkeykong pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", "Upgrade-pet", "Drop"};
				break;
			case 5507:
				ItemDefinition sonicw = ItemDefinition.get(12479);
				itemDef.modelID = 64224;
				itemDef.modelOffsetX = sonicw.modelOffsetX;
				//itemDef.modelOffsetX = itemDef211.modelOffsetX;
				itemDef.modelOffsetY = sonicw.modelOffsetY;
				itemDef.modelZoom = 3000;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.name = "Sonic pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", "Upgrade-pet", "Drop"};
				break;
			case 5508:
				ItemDefinition Mario = ItemDefinition.get(12479);
				itemDef.modelID = 64223;
				itemDef.modelOffsetX = Mario.modelOffsetX;
				//itemDef.modelOffsetX = itemDef211.modelOffsetX;
				itemDef.modelOffsetY = Mario.modelOffsetY;
				itemDef.modelZoom = 3000;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.name = "Mario pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", "Upgrade-pet", "Drop"};
				break;
			case 5560:
				ItemDefinition superstar2 = ItemDefinition.get(12479);
				itemDef.modelID = 64305;
				itemDef.modelOffsetX = superstar2.modelOffsetX;
				//itemDef.modelOffsetX = itemDef211.modelOffsetX;
				itemDef.modelOffsetY = superstar2.modelOffsetY;
				itemDef.modelZoom = 2000;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.name = "Super Star pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", "Upgrade-pet", "Drop"};
				break;
			case 5563:
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = 1000;
				itemDef.rotationY = 10;
				itemDef.rotationX = 10;
				itemDef.modelID = 64306;

				itemDef.name = "Grinch pet @whi@X2 EXP@or1@";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;


			case 14819:
				itemDef.name = "x2 Slayer XP Certificate";
				break;

			case 14817:
				itemdefyogipic1111 = ItemDefinition.get(14819);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.name = "x2 Invention XP Certificate";
				itemDef.rdc2 = 2592;
				break;
			case 14822:
				itemDef.name = "<img=15>VIP Slayer License";
				itemDef.actions = new String[]{"Claim", null, null, null, "Drop"};
				break;
			case 28:
				itemDef.name = "Slayer chest key";
				itemdefyogipic1111 = ItemDefinition.get(989);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = 760;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = 800;
				itemDef.modelID = 64299;
				itemDef.stackable = false;
				break;
			case 29:
				itemDef.name = "Locked slayer chest";
				itemdefyogipic1111 = ItemDefinition.get(405);
				itemDef.modelOffsetX = 2;
				itemDef.modelOffsetY = 1;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = 100;
				itemDef.rotationX = 90;
				itemDef.modelID = 64300;
				itemDef.modelZoom = 1100;
				itemDef.stackable = false;
				break;

			case 27:
				itemDef.name = "<img=15>VIP Slayer Gem";
				itemDef.actions = new String[]{"Teleport to task", null, "Teleport to VIP", null, "Drop"};
				itemDef.rdc2 = 37483;
				itemdefyogipic1111 = ItemDefinition.get(4155);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				break;
			case 14827:
				itemDef.name = "American pernix hood";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = 1;
				itemDef.modelOffsetY = 200;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = 260;
				itemDef.rotationX = 20;
				itemDef.modelID = 64159;
				itemDef.maleEquip1 = 64160;
				itemDef.femaleEquip1 = 64160;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 14818:
				itemDef.name = "American pernix body";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = 1350;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64161;
				itemDef.maleEquip1 = 64162;
				itemDef.femaleEquip1 = 64162;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 15441:
			case 15442:
			case 15443:
			case 15444:
				itemDef.actions[2] = "<col=C3C0B2>Dissolve";
				break;
			case 13953:
			case 13954:
			case 13955:
			case 13956:
			case 13957:

				break;
			case 14820:
				itemDef.name = "American pernix legs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = 7;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64163;
				itemDef.maleEquip1 = 64164;
				itemDef.femaleEquip1 = 64164;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 21050:
				itemDef.name = "Slayermaster hood";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64284;
				itemDef.maleEquip1 = 64285;
				itemDef.femaleEquip1 = 64285;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 21051:
				itemDef.name = "Slayermaster body";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64286;
				itemDef.maleEquip1 = 64287;
				itemDef.femaleEquip1 = 64287;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 21052:
				itemDef.name = "Slayermaster legs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64288;
				itemDef.maleEquip1 = 64289;
				itemDef.femaleEquip1 = 64289;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 21025:
				itemDef.name = "Samurai head";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64247;
				itemDef.maleEquip1 = 64248;
				itemDef.femaleEquip1 = 64248;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 21026:
				itemDef.name = "Samurai body";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64249;
				itemDef.maleEquip1 = 64250;
				itemDef.femaleEquip1 = 64250;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 21027:
				itemDef.name = "Samurai legs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64251;
				itemDef.maleEquip1 = 64252;
				itemDef.femaleEquip1 = 64252;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 21028:
				itemDef.name = "eSamurai head";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64253;
				itemDef.maleEquip1 = 64254;
				itemDef.femaleEquip1 = 64254;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 923295;
				break;
			case 21029:
				itemDef.name = "eSamurai body";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64255;
				itemDef.maleEquip1 = 64256;
				itemDef.femaleEquip1 = 64256;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 923295;
				break;
			case 21030:
				itemDef.name = "eSamurai legs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64257;
				itemDef.maleEquip1 = 64258;
				itemDef.femaleEquip1 = 64258;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 923295;
				break;
			case 11009:
				itemDef.name = "Hotshot helm";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64186;
				itemDef.maleEquip1 = 64187;
				itemDef.femaleEquip1 = 64187;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 11010:
				itemDef.name = "Hotshot body";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64188;
				itemDef.maleEquip1 = 64189;
				itemDef.femaleEquip1 = 64189;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 11011:
				itemDef.name = "Hotshot legs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64190;
				itemDef.maleEquip1 = 64191;
				itemDef.femaleEquip1 = 64191;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 11012:
				itemDef.name = "Hotshot wings";
				itemdefyogipic1111 = ItemDefinition.get(2413);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64192;
				itemDef.maleEquip1 = 64193;
				itemDef.femaleEquip1 = 64193;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 11001:
				itemDef.name = "Hiddenvally coif";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64179;
				itemDef.maleEquip1 = 64180;
				itemDef.femaleEquip1 = 64180;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 11002:
				itemDef.name = "Hiddenvally leatherbody";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64181;
				itemDef.maleEquip1 = 64182;
				itemDef.femaleEquip1 = 64182;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;

			case 2575:
				itemDef.name = "Goku Watch";

				break;
			case 11003:
				itemDef.name = "Hiddenvally leatherchaps";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64183;
				itemDef.maleEquip1 = 64184;
				itemDef.femaleEquip1 = 64184;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 11006:
				itemDef.name = "Forbidden coif";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64179;
				itemDef.maleEquip1 = 64180;
				itemDef.femaleEquip1 = 64180;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 29592;
				break;
			case 11007:
				itemDef.name = "Forbidden leatherbody";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64181;
				itemDef.maleEquip1 = 64182;
				itemDef.femaleEquip1 = 64182;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 29592;
				break;
			case 11008:
				itemDef.name = "Forbidden leatherchaps";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64183;
				itemDef.maleEquip1 = 64184;
				itemDef.femaleEquip1 = 64184;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 29592;
				break;
			case 11314:
				itemDef.modelZoom = 793;
				itemDef.rotationX = 0;
				itemDef.rotationY = 443;
				itemDef.modelOffsetX = 3;
				itemDef.modelOffsetY = 15;
				itemDef.modelID = 16049;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.name = "Hellraiser pet (x2 KC)";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;

			case 8868:
				itemDef.name = "<col=f8ac00>Betrayed key@lre@";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				break;
			case 21201:
				itemDef.name = "Betrayed key [<col=92d49a>Uncommon@lre@]";
				itemdefyogipic1111 = ItemDefinition.get(8868);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 4710;
				break;
			case 21202:
				itemDef.name = "Betrayed key [<col=789eea>Rare@lre@]";
				itemdefyogipic1111 = ItemDefinition.get(8868);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 888888;
				break;
			case 21203:
				itemDef.name = "Betrayed key [<col=c378ea>Legendary@lre@]";
				itemdefyogipic1111 = ItemDefinition.get(8868);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 111111;
				break;
			case 21204:
				itemDef.name = "Betrayed key [<col=eae678>Exotic@lre@]";
				itemdefyogipic1111 = ItemDefinition.get(8868);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 88757;
				break;
			case 9662:
				itemDef.name = "<col=f8ac00>Damned key@lre@";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				break;
			case 21205:
				itemDef.name = "Damned key [<col=92d49a>Uncommon@lre@]";
				itemdefyogipic1111 = ItemDefinition.get(9662);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 4710;
				break;
			case 21206:
				itemDef.name = "Damned key [<col=789eea>Rare@lre@]";
				itemdefyogipic1111 = ItemDefinition.get(9662);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 888888;
				break;
			case 21207:
				itemDef.name = "Damned key [<col=c378ea>Legendary@lre@]";
				itemdefyogipic1111 = ItemDefinition.get(9662);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 111111;
				break;
			case 21208:
				itemDef.name = "Damned key [<col=eae678>Exotic@lre@]";
				itemdefyogipic1111 = ItemDefinition.get(9662);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 88757;
				break;
			case 14471:
				itemDef.name = "<col=f8ac00>Hidden key@lre@";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				break;
			case 21209:
				itemDef.name = "Hidden key [<col=92d49a>Uncommon@lre@]";
				itemdefyogipic1111 = ItemDefinition.get(14471);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 1896;
				break;
			case 21210:
				itemDef.name = "Hidden key [<col=789eea>Rare@lre@]";
				itemdefyogipic1111 = ItemDefinition.get(14471);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 888888;
				break;
			case 21211:
				itemDef.name = "Loot key";
				itemdefyogipic1111 = ItemDefinition.get(14471);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 111111;
				break;
			case 21212:
				itemDef.name = "Hidden key [<col=eae678>Exotic@lre@]";
				itemdefyogipic1111 = ItemDefinition.get(14471);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 88757;
				break;
			case 3468:
				itemDef.name = "<col=f8ac00>Cursed key@lre@";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				break;
			case 21213:
				itemDef.name = "Cursed key [<col=92d49a>Uncommon@lre@]";
				itemdefyogipic1111 = ItemDefinition.get(3468);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 5364;
				break;
			case 21214:
				itemDef.name = "Cursed key [<col=789eea>Rare@lre@]";
				itemdefyogipic1111 = ItemDefinition.get(3468);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 888888;
				break;
			case 21215:
				itemDef.name = "Cursed key [<col=c378ea>Legendary@lre@]";
				itemdefyogipic1111 = ItemDefinition.get(3468);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 7326;
				break;
			case 21216:
				itemDef.name = "Cursed key [<col=eae678>Exotic@lre@]";
				itemdefyogipic1111 = ItemDefinition.get(3468);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 88757;
				break;
			case 21217:
				itemDef.name = "Slayer xp lamp ";
				itemdefyogipic1111 = ItemDefinition.get(19750);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 36262;
				break;
			case 15403:
				itemDef.name = "Sharp balmung";
				itemDef.rdc2 = 9224592;
				break;
			case 10887:
				itemDef.name = "Pirates ancor";
				itemDef.rdc2 = 9939;
				break;
			case 21219:
				itemDef.name = "Slayer xp lamp ";
				itemdefyogipic1111 = ItemDefinition.get(19750);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = 750;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 36262;
				break;
			case 21218:
				itemDef.name = "Invention xp lamp ";
				itemdefyogipic1111 = ItemDefinition.get(19750);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.actions = itemdefyogipic1111.actions;
				itemDef.rdc2 = 3344;
				break;
			case 21260:
				itemDef.name = "offhand glaive";
				itemDef.modelID = 64301;
				itemDef.maleEquip1 = 64302;
				itemDef.femaleEquip1 = 64302;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;


				break;
			case 20505:
				itemDef.name = "saggy offhand glaive";
				itemDef.modelID = 64301;
				itemDef.maleEquip1 = 64302;
				itemDef.femaleEquip1 = 64302;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				//

				break;
			case 5424:
				itemDef.name = "madman offhand glaive";
				itemDef.modelID = 64301;
				itemDef.maleEquip1 = 64302;
				itemDef.femaleEquip1 = 64302;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				//

				break;
			case 21261:
				itemDef.name = "offhand glaive";
				itemDef.modelID = 64301;
				itemDef.maleEquip1 = 64302;
				itemDef.femaleEquip1 = 64302;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				itemDef.rdc2 = 464646;
				break;
			case 21262:
				itemDef.name = "offhand glaive";
				itemDef.modelID = 64301;
				itemDef.maleEquip1 = 64302;
				itemDef.femaleEquip1 = 64302;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				itemDef.rdc2 = 85722;
				break;
			case 21263:
				itemDef.name = "offhand glaive";
				itemDef.modelID = 64301;
				itemDef.maleEquip1 = 64302;
				itemDef.femaleEquip1 = 64302;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				itemDef.rdc2 = 43722;
				break;
			case 455:
				itemDef.name = "Scratch Card";
				break;
			case 18599:
				itemDef.name = "Pink Bikini head";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = 1;
				itemDef.modelOffsetY = -60;
				itemDef.modelZoom = 1000;
				itemDef.rotationY = 230;
				itemDef.rotationX = 200;
				itemDef.modelID = 64317;
				itemDef.maleEquip1 = 64318;
				itemDef.femaleEquip1 = 64318;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
			case 18600:
				itemDef.name = "Bikini body";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = 1600;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64319;
				itemDef.maleEquip1 = 64320;
				itemDef.femaleEquip1 = 64320;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
			case 18601:
				itemDef.name = "Bikini legs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = 20;
				itemDef.modelZoom = 2000;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64321;
				itemDef.maleEquip1 = 64322;
				itemDef.femaleEquip1 = 64322;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
			case 18602:
				itemDef.name = "Bikini hands";
				itemdefyogipic1111 = ItemDefinition.get(7461);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64323;
				itemDef.maleEquip1 = 64324;
				itemDef.femaleEquip1 = 64324;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
			case 18603:
				itemDef.name = "Bikini feet";
				itemdefyogipic1111 = ItemDefinition.get(7114);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64325;
				itemDef.maleEquip1 = 64325;
				itemDef.femaleEquip1 = 64325;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
			case 5012:
				itemDef.name = "Legends Twisted Bow";
				ItemDefinition tbow = ItemDefinition.get(1419);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = 65324;
				itemDef.femaleEquip1 = 65325;
				itemDef.maleEquip1 = 65325;
				itemDef.actions = tbow.actions;
				itemDef.modelOffsetX = tbow.modelOffsetX;
				itemDef.modelOffsetY = tbow.modelOffsetY;
				itemDef.modelZoom = 2000;
				itemDef.rotationY = tbow.rotationY;
				itemDef.rotationX = tbow.rotationX;
				itemDef.stackable = false;
				break;
			case 23226:
				itemDef.copyItem(5012);
				itemDef.name = "Blood Twisted bow";
				itemDef.rdc3 = 750;
				break;
			case 23227:
				itemDef.copyItem(17011);
				itemDef.name = "Blood Sanguinesti Staff";
				itemDef.rdc2 = 800;
				break;
			case 5011:
				itemDef.copyItem(5012);
				itemDef.name = "Light Twisted bow";
				itemDef.rdc2 = 888833;
				break;
			case 23228:
				itemDef.copyItem(11235);
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.name = "Necromancer Bow";
				itemDef.modelID = 19723;
				itemDef.femaleEquip1 = 19723;
				itemDef.maleEquip1 = 19723;
				itemDef.modelOffsetX = 68;
				itemDef.modelOffsetY = 78;
				itemDef.modelZoom = 3000;
				itemDef.rotationY = 1539;
				itemDef.rotationX = 1765;
				itemDef.rotationZ = 583;
				break;
			case 23267:
				itemDef.copyItem(11235);
				itemDef.name = "Infernal Bow";
				itemDef.modelID = 18545;
				itemDef.femaleEquip1 = 18552;
				itemDef.maleEquip1 = 18552;
				itemDef.modelOffsetX = 15;
				itemDef.modelOffsetY = -15;
				itemDef.modelZoom = 3000;
				itemDef.rotationY = 500;
				itemDef.rotationX = 120;
				itemDef.rotationZ = 20;
				break;
			case 5010:
				itemDef.name = "Crystalized bow";
				ItemDefinition tbow3 = ItemDefinition.get(1419);
				itemDef.modelID = 71222;
				itemDef.femaleEquip1 = 71223;
				itemDef.maleEquip1 = 71223;
				itemDef.actions = tbow3.actions;
				itemDef.modelOffsetX = tbow3.modelOffsetX;
				itemDef.modelOffsetY = tbow3.modelOffsetY;
				itemDef.modelZoom = tbow3.modelZoom;
				itemDef.rotationY = tbow3.rotationY;
				itemDef.rotationX = tbow3.rotationX;
				itemDef.stackable = false;
				break;
			case 8136:
				itemDef.copyItem(12537);
				itemDef.name = "Blood Scythe of Vitur";
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{52};
				break;
			case 23391:
				itemDef.name = "Empyrean maul";
				itemDef.modelID = 19562;
				itemDef.femaleEquip1 = 19563;
				itemDef.maleEquip1 = 19563;
				itemDef.modelZoom = 3000;
				itemDef.rotationX = 617;//189
				itemDef.rotationY = 1626;//768
				itemDef.rotationZ = 26;//768
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = 12;
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				break;
			case 23383:
				itemDef.copyItem(23079);
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.name = "Lesarkus Blade";
				itemDef.modelID = 19552;
				itemDef.femaleEquip1 = 19553;
				itemDef.maleEquip1 = 19553;
				itemDef.stackable = false;
				break;
			case 12535:
				itemDef.copyItem(12537);
				itemDef.name = "Legends Scythe of Vitur";
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{104};
				break;

			case 12537:
				itemDef.name = "Light Scythe Of Vitur";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.modelID = 65320;
				itemDef.femaleEquip1 = 65321;
				itemDef.maleEquip1 = 65321;
				itemDef.modelOffsetX = -19;
				itemDef.modelOffsetY = 85;
				itemDef.modelZoom = 3000;
				itemDef.rotationY = 259;
				itemDef.rotationX = 883;
				itemDef.rotationZ = 0;
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{76};
				break;

			case 9940:
				itemDef.name = "Execution chainmace";
				ItemDefinition execution = ItemDefinition.get(4755);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = 65322;
				itemDef.femaleEquip1 = 65323;
				itemDef.maleEquip1 = 65323;
				itemDef.actions = execution.actions;

				itemDef.modelOffsetX = execution.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = execution.modelOffsetY;
				itemDef.modelZoom = execution.modelZoom;
				itemDef.rotationY = execution.rotationY;
				itemDef.rotationX = execution.rotationX;
				itemDef.stackable = false;
				itemDef.rdc2 = 3645768;//23622

				break;
			case 9942:
				itemDef.name = "Execution Staff";

				ItemDefinition execution1 = ItemDefinition.get(21777);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = execution1.modelID;
				itemDef.femaleEquip1 = execution1.femaleEquip1;
				itemDef.maleEquip1 = execution1.maleEquip1;
				itemDef.actions = execution1.actions;

				itemDef.modelOffsetX = execution1.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = execution1.modelOffsetY;
				itemDef.modelZoom = execution1.modelZoom;
				itemDef.rotationY = execution1.rotationY;
				itemDef.rotationX = execution1.rotationX;
				itemDef.stackable = false;
				itemDef.rdc2 = 85748;//23622

				break;
			case 9939:
				itemDef.name = "Legends cape";
				ItemDefinition execape = ItemDefinition.get(21039);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = execape.modelID;
				itemDef.femaleEquip1 = execape.femaleEquip1;
				itemDef.maleEquip1 = execape.maleEquip1;
				itemDef.actions = execape.actions;
				itemDef.modelZoom = 3000;
				itemDef.modelOffsetX = execape.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = execape.modelOffsetY;
				//itemDef.modelZoom = execape.modelZoom;
				itemDef.rotationY = execape.rotationY;
				itemDef.rotationX = execape.rotationX;
				itemDef.stackable = false;
				itemDef.rdc2 = 565656;//23622

				break;
			case 17011:
				itemDef.name = "Legends Sanguinesti Staff";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Destroy";
				itemDef.modelID = 99513;
				itemDef.maleEquip1 = 99506;
				itemDef.femaleEquip1 = 99506;
				itemDef.modelZoom = 2238;
				itemDef.rotationX = 1059;
				itemDef.rotationY = 525;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = -3;
				itemDef.modelOffsetY = 0;
				break;

			case 17013:
				itemDef.copyItem(17011);
				itemDef.name = "Light Sanguinesti Staff";
				itemDef.rdc2 = 888833;
				break;
			case 8273:
				itemDef.name = "Legends gloves";
				itemdefyogipic1111 = ItemDefinition.get(7461);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = 1200;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
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
				itemDef.rdc2 = 565656;
				break;
			case 8274:
				itemDef.name = "Legends boots";
				itemdefyogipic1111 = ItemDefinition.get(7114);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64279;
				itemDef.maleEquip1 = 64279;
				itemDef.femaleEquip1 = 64279;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.stackable = false;
				itemDef.rdc2 = 565656;
				break;
			case 9941:
				itemDef.actions = new String[5];
				itemDef.modelID = 19219;
				itemDef.name = "Legends blowpipe";
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
				itemDef.rdc2 = 666737;//23622
				break;

			case 4684:
				itemDef.copyItem(15642);
				itemDef.name = "Legends helm";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.modelID = 16776;
				itemDef.maleEquip1 = 16776;
				itemDef.femaleEquip1 = 16776;
				itemDef.modelZoom = 800;
				break;

			case 23229:
				itemDef.copyItem(10936);
				itemDef.name = "@yel@Global ticket";
				itemDef.rdc2 = 2170811;
				break;

			case 19864:
				itemDef.name = "Halloween Token";
				itemDef.rdc2 = 466708;
				break;

			case 23426:
				itemDef.copyItem(14859);
				itemDef.name = "@red@Supreme Energy";
				itemDef.rdc2 = 388238;
				break;


			case 23273:
				itemDef.copyItem(14859);
				itemDef.name = "<col=89584A>Dark Matter";
				itemDef.modelID = 19711;
				itemDef.modelZoom = 550;
				itemDef.rotationZ = 189;//189
				itemDef.actions = new String[5];
				itemDef.actions[1] = null;
				break;

			case 23268:
				itemDef.copyItem(4407);
				itemDef.name = "Autumn Cloak";
				itemDef.modelID = 18553;
				itemDef.maleEquip1 = 18554;
				itemDef.femaleEquip1 = 18554;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				//itemDef.rdc2 = 23708;
				itemDef.rotationX = 1220;
				break;
			case 23269:
				itemDef.copyItem(3738);
				itemDef.name = "Super Soaker";
				itemDef.modelID = 18555;
				itemDef.maleEquip1 = 18556;
				itemDef.femaleEquip1 = 18556;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				//itemDef.rdc2 = 23708;
				itemDef.modelZoom = 1180;
				itemDef.rotationX = 0;
				break;
			case 4685:
				itemDef.copyItem(15643);
				itemDef.name = "Legends body";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.modelID = 16780;
				itemDef.maleEquip1 = 16780;
				itemDef.femaleEquip1 = 16780;
				itemDef.modelZoom = 1500;
				break;

			case 4686:
				itemDef.copyItem(15644);
				itemDef.name = "Legends legs";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.modelID = 16797;
				itemDef.maleEquip1 = 16797;
				itemDef.femaleEquip1 = 16797;
				itemDef.modelZoom = 1800;
				break;
		}
		return itemDef;
	}
}
