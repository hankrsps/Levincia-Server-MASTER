package org.necrotic.client.cache.definition;

public class ItemDef5 {

	public static ItemDefinition newIDS(ItemDefinition itemDef, int id) {

		switch (id) {

			case 10483:
				itemDef.copyItem(23511);
				itemDef.modelID = 22340;
				itemDef.name = "Yugi Muto pet";
				break;
			case 10484:
				itemDef.copyItem(23511);
				itemDef.modelID = 22345;
				itemDef.modelZoom = 1309;
				itemDef.name = "Dark magician pet";
				break;
			case 10485:
				itemDef.copyItem(23511);
				itemDef.modelID = 22341;
				itemDef.modelZoom = 1209;
				itemDef.name = "Armed protector pet";
				break;
			case 10486:
				itemDef.copyItem(23511);
				itemDef.modelID = 22342;
				itemDef.modelZoom = 1109;
				itemDef.name = "Exodia pet";
				break;
			case 11426:
				itemDef.copyItem(23511);
				itemDef.modelID = 15189;
				itemDef.modelZoom = 1109;
				itemDef.name = "Blue-Eyes White Dragon pet";
				break;
			case 10502:
				itemDef.copyItem(10483);
				itemDef.name = "Yugi Muto Transformer";
				break;
			case 10503:
				itemDef.certID = 10502;
				itemDef.certTemplateID = 23652;
				itemDef.name = "Yugi Muto Transformer";
				itemDef.actions = new String[]{"Transform", null, null, null, null};
				break;

			case 10597:
				itemDef.copyItem(10484);
				itemDef.name = "Dark Magician Transformer";
				break;
			case 10598:
				itemDef.certID = 10597;
				itemDef.certTemplateID = 23652;
				itemDef.name = "Dark Magician Transformer";
				itemDef.actions = new String[]{"Transform", null, null, null, null};
				break;

			case 10506:
				itemDef.copyItem(10485);
				itemDef.name = "Armed Protector Transformer";
				break;
			case 10585:
				itemDef.certID = 10506;
				itemDef.certTemplateID = 23652;
				itemDef.name = "Armed Protector Transformer";
				itemDef.actions = new String[]{"Transform", null, null, null, null};
				break;

			case 10586:
				itemDef.copyItem(10486);
				itemDef.name = "Exodia Transformer";
				break;
			case 10587:
				itemDef.certID = 10486;
				itemDef.certTemplateID = 23652;
				itemDef.name = "Exodia Transformer";
				itemDef.actions = new String[]{"Transform", null, null, null, null};
				break;

			case 11425:
				itemDef.copyItem(13742);
				itemDef.name = "Duel-Disc Offhand";
				itemDef.modelZoom = 1100;
				itemDef.modelID = 22339;
				itemDef.maleEquip1 = 22338;
				itemDef.femaleEquip1 = 22338;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;

			case 13223:
				itemDef.copyItem(23324);
				itemDef.modelID = 19593;
				itemDef.name = "Forest Archer pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;

			case 13224:
				itemDef.copyItem(23324);
				itemDef.modelID = 19592;
				itemDef.name = "Chaotic Archer pet";
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 13225:
				itemDef.copyItem(23324);
				itemDef.modelID = 19594;
				itemDef.name = "Divine Archer pet";
				itemDef.rdc2 = 34343;
				itemDef.groundActions = new String[]{null, null, "Take", null, null};
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;

			case 14434:
				itemDef.copyItem(14050);
				itemDef.name = "Black Dragon helmet";
				itemDef.modelID = 22335;
				itemDef.maleEquip1 = 22336;
				itemDef.femaleEquip1 = 22336;
				break;
			case 14435:
				itemDef.copyItem(14051);
				itemDef.name = "Black Dragon body";
				itemDef.modelID = 22321;
				itemDef.maleEquip1 = 22322;
				itemDef.femaleEquip1 = 22096;
				break;
			case 14436:
				itemDef.copyItem(14052);
				itemDef.name = "Black Dragon legs";
				itemDef.modelID = 22323;
				itemDef.maleEquip1 = 22329;
				itemDef.femaleEquip1 = 22329;
				break;
			case 14437:
				itemDef.copyItem(23066);
				itemDef.name = "Black Dragon crossbow";
				itemDef.modelID = 22330;
				itemDef.maleEquip1 = 22331;
				itemDef.femaleEquip1 = 22331;
				itemDef.modelZoom = 1000;
				break;
			case 14438:
				itemDef.copyItem(11283);
				itemDef.name = "Black Dragonfire shield";
				itemDef.modelID = 22332;
				itemDef.maleEquip1 = 22334;
				itemDef.femaleEquip1 = 22334;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 10793:
				itemDef.copyItem(3791);
				itemDef.name = "Diminished Boots";
				itemDef.modelID = 65226;
				itemDef.maleEquip1 = 65226;
				itemDef.femaleEquip1 = 65226;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 52; // the new texture u want it to have
				itemDef.stackable = false;
				break;

			case 10795:
				itemDef.copyItem(7671);
				itemDef.name = "Diminished gloves";
				itemDef.modelID = 65360;
				itemDef.femaleEquip1 = 65361;
				itemDef.maleEquip1 = 65361;
				itemDef.actions = itemDef.actions;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;


			case 10823:
				itemDef.copyItem(5068);
				itemDef.name = "Diminished helmet";
				itemDef.modelID = 22355;
				itemDef.maleEquip1 = 22355;
				itemDef.modelZoom = 700;
				itemDef.femaleEquip1 = 22355;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 101; // the texture that it currently has
				itemDef.newColors[0] = 52; // the new texture u want it to have
				itemDef.modelOffsetY = 80;
				break;

			case 10824:
				itemDef.copyItem(5069);
				itemDef.name = "Diminished body";
				itemDef.modelID = 22356;
				itemDef.maleEquip1 = 22356;
				itemDef.femaleEquip1 = 22356;
				itemDef.modelZoom = 1480;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 101; // the texture that it currently has
				itemDef.newColors[0] = 52; // the new texture u want it to have
				break;

			case 10825:
				itemDef.copyItem(5070);
				itemDef.name = "Diminished legs";
				itemDef.modelID = 22357;
				itemDef.maleEquip1 = 22357;
				itemDef.femaleEquip1 = 22357;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 101; // the texture that it currently has
				itemDef.newColors[0] = 52; // the new texture u want it to have
				break;

			case 10826:
				itemDef.copyItem(23270);
				itemDef.modelID = 22360;
				itemDef.name = "Diminished Wings";
				itemDef.description = "A cape worn by those who've achieved greatness.".getBytes();
				itemDef.maleEquip1 = 22360;
				itemDef.femaleEquip1 = 22360;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 101; // the texture that it currently has
				itemDef.newColors[0] = 52; // the new texture u want it to have
				itemDef.modelOffsetY = 0;
				itemDef.rotationY = 0;
				break;

			case 10827:
				itemDef.copyItem(23092);
				itemDef.name = "Diminished Ring";
				itemDef.modelID = 22361;
				itemDef.maleEquip1 = -1;
				itemDef.femaleEquip1 = -1;
				itemDef.modelZoom = 1050;
				itemDef.rotationX = 870;
				itemDef.rotationY = 410;
				itemDef.modelOffsetX = -7;
				itemDef.modelOffsetY = 15;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 114; // the texture that it currently has
				itemDef.newColors[0] = 52; // the new texture u want it to have
				break;

			case 10828:
				itemDef.copyItem(23271);
				itemDef.modelID = 19706;
				itemDef.modelZoom = 1700;
				itemDef.maleEquip1 = 19706;
				itemDef.femaleEquip1 = 19706;
				itemDef.modelOffsetX = -15;
				itemDef.modelOffsetY = 60;
				itemDef.name = "Diminished Aura";
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 98; // the texture that it currently has
				itemDef.newColors[0] = 52; // the new texture u want it to have
				break;

			case 10829:
				itemDef.copyItem(5068);
				itemDef.name = "Diminished Amulet";
				itemDef.modelID = 22362;
				itemDef.maleEquip1 = 22362;
				itemDef.modelZoom = 450;
				itemDef.femaleEquip1 = 22362;
				itemDef.modelOffsetY = 75;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 119; // the texture that it currently has
				itemDef.newColors[0] = 52; // the new texture u want it to have
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;


			case 10830:
				itemDef.copyItem(18665);
				itemDef.name = "Diminished Key";
				itemDef.actions = new String[]{"Teleport", null, null, null, null};
				itemDef.rdc2 = 807999;
				break;


			case 16465:
				itemDef.copyItem(23552);
				itemDef.name = "Diminished shards";
				itemDef.modelZoom = 1696;
				itemDef.modelID = 22359;
				break;
			case 14439:
				itemDef.copyItem(14880);
				itemDef.name = "Diminished emblem";
				itemDef.colorChange = new double[]{0.5, 0.2, 1.2};
				break;


			case 13264:
				itemDef.copyItem(5553);
				itemDef.name = "Rogue Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;

			case 13265:
				itemDef.copyItem(13264);
				itemDef.certID = 13264;
				itemDef.certTemplateID = 23390;
				itemDef.name = "Rogue Costume";
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;

			case 13266:
				itemDef.copyItem(11720);
				itemDef.name = "Armadyl Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;

			case 13267:
				itemDef.copyItem(13266);
				itemDef.certID = 13266;
				itemDef.certTemplateID = 23390;
				itemDef.name = "Armadyl Costume";
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;

			case 13268:
				itemDef.copyItem(10939);
				itemDef.name = "Noobie Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;

			case 13269:
				itemDef.copyItem(13268);
				itemDef.certID = 13268;
				itemDef.certTemplateID = 23390;
				itemDef.name = "Noobie Costume";
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;

			case 13257:
				itemDef.copyItem(14595);
				itemDef.name = "Santa's Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;

			case 13258:
				itemDef.copyItem(13257);
				itemDef.certID = 13257;
				itemDef.certTemplateID = 23390;
				itemDef.name = "Santa's Costume";
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;

			case 13289:
				itemDef.copyItem(22066);
				itemDef.oldColors = new int[] { 908 };
				itemDef.newColors = new int[] { -10304 };
				itemDef.femaleEquip1 = 21509;
				itemDef.actions = new String[] { null, "Wield", null, null, "Drop" };
				itemDef.modelID = 21225;
				itemDef.maleEquip1 = 21515;
				itemDef.name = "Elidinis' ward";
				itemDef.modelZoom = 1368;
				break;

			case 13293:
				itemDef.copyItem(22066);
				itemDef.oldColors = new int[] { 908 };
				itemDef.newColors = new int[] { -10304 };
				itemDef.femaleEquip1 = 21518;
				itemDef.actions = new String[] { null, "Wield", null, "Dismantle", "Drop" };
				itemDef.modelID = 21516;
				itemDef.maleEquip1 = 21517;
				itemDef.name = "Elidinis' ward (f)";
				itemDef.modelZoom = 1368;
				break;

			case 13295:
				itemDef.copyItem(22066);
				itemDef.femaleEquip1 = 21555;
				itemDef.actions = new String[] { null, "Wield", null, "Dismantle", "Drop" };
				itemDef.modelID = 21553;
				itemDef.maleEquip1 = 21554;
				itemDef.name = "Elidinis' ward (or)";
				itemDef.modelZoom = 1368;
				break;

			case 13297:
				itemDef.copyItem(21069);
				itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
				itemDef.modelID = 21556;
				itemDef.name = "Lightbearer";
				itemDef.modelZoom = 830;
				break;

			case 13299:
				itemDef.femaleEquip1 = 21639;
				itemDef.actions = new String[] { null, "Wear", null, null, "Destroy" };
				itemDef.modelID = 21607;
				itemDef.maleEquip1 = 21684;
				itemDef.name = "Mask of rebirth";
				itemDef.rotationX = 89;
				itemDef.rotationY = 42;
				itemDef.modelOffsetY = -7;
				itemDef.modelZoom = 832;
				break;

			case 13596:
				itemDef.copyItem(14019);
				itemDef.femaleEquip1 = 21696;
				itemDef.actions = new String[] { null, "Wear", null, "Commune", "Drop" };
				itemDef.modelID = 21695;
				itemDef.maleEquip1 = 21697;
				itemDef.modelOffsetX = -9;
				itemDef.name = "Masori assembler max cape";
				itemDef.modelZoom = 1600;
				break;


			case 13597:
				itemDef.copyItem(18491);
				itemDef.actions = new String[] { "Inspect", "Attach", null, null, "Drop" };
				itemDef.modelID = 21700;
				itemDef.name = "Cursed phalanx";
				itemDef.modelZoom = 1086;
				break;

			case 13662:
				itemDef.femaleEquip1 = 21702;
				itemDef.actions = new String[] { null, "Wield", null, null, "Drop" };
				itemDef.modelID = 21701;
				itemDef.maleEquip1 = 21703;
				itemDef.name = "Osmumten's fang";
				itemDef.modelOffsetX = 0;
				itemDef.rotationY = 1603;
				itemDef.modelOffsetY = 0;
				itemDef.rotationZ = 782;
				itemDef.rotationX = 0;
				//itemDef.rotationX = 552;
				itemDef.modelZoom = 1800;
				break;

			case 13664:
				itemDef.copyItem(13662);
				itemDef.femaleEquip1 = 21801;
				itemDef.modelID = 21733;
				itemDef.maleEquip1 = 21820;
				itemDef.name = "Osmumten's fang (or)";
				break;

			case 18495:
				itemDef.actions = new String[] { "Attach", "Inspect", null, null, "Drop" };
				itemDef.modelID = 20852;
				itemDef.name = "Jewel of the sun";
				itemDef.rotationX = 316;
				itemDef.rotationY = 1472;
				itemDef.modelOffsetY = 1;
				itemDef.modelOffsetX = -3;
				itemDef.rotationZ = 1953;
				itemDef.modelZoom = 750;
				break;

			case 18489:
				itemDef.oldColors = new int[] { 74 };
				itemDef.newColors = new int[] { 9168 };
				itemDef.actions = new String[] { "Inspect", null, null, null, "Destroy" };
				itemDef.modelID = 20850;
				itemDef.isMembers = true;
				itemDef.name = "Thread of elidinis";
				itemDef.rotationX = 248;
				itemDef.modelOffsetX = 2;
				itemDef.rotationY = 1644;
				itemDef.modelZoom = 590;
				break;

			case 18491:
				itemDef.actions = new String[] { "Open", null, "Revert", "Empty", "Destroy" };
				itemDef.modelID = 20849;
				itemDef.name = "Divine rune pouch";
				itemDef.rotationX = 512;
				itemDef.modelOffsetX = -13;
				itemDef.rotationY = 475;
				itemDef.modelOffsetY = 1;
				itemDef.rotationZ = 13;
				itemDef.modelZoom = 850;
				break;

			case 18493:
				itemDef.copyItem(11465);
				itemDef.oldColors = new int[] { 28126, 28482 };
				itemDef.newColors = new int[] { -3401, 9026 };
				itemDef.actions = new String[] { "Inspect", "Attach", null, null, "Drop" };
				itemDef.modelID = 20851;
				itemDef.name = "Menaphite ornament kit";
				break;

			case 18485:
				itemDef.actions = new String[] { null, "Wield", "Charge", null, "Drop" };
				itemDef.modelID = 20848;
				itemDef.maleEquip1 = 20845;
				itemDef.femaleEquip1 = 20846;
				itemDef.name = "Tumeken's shadow (charged)";
				itemDef.rotationX = 405;
				itemDef.modelOffsetX = 0;
				itemDef.rotationY = 1481;
				itemDef.modelOffsetY = -10;
				itemDef.rotationZ = 290;
				itemDef.modelZoom = 1760;
				break;

			case 18487:
				itemDef.actions = new String[] { null, "Wield", "Charge", null, "Drop" };
				itemDef.modelID = 20847;
				itemDef.maleEquip1 = 20845;
				itemDef.femaleEquip1 = 20846;
				itemDef.name = "Tumeken's shadow (uncharged)";
				itemDef.rotationX = 405;
				itemDef.modelOffsetX = 0;
				itemDef.rotationY = 1481;
				itemDef.modelOffsetY = -10;
				itemDef.rotationZ = 290;
				itemDef.modelZoom = 1760;
				itemDef.rdc2 = 2;
				break;


			case 13273:
				itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
				itemDef.modelID = 20914;
				itemDef.maleEquip1 = 20898;
				itemDef.femaleEquip1 = 20898;
				itemDef.name = "Masori mask";
				itemDef.rotationX = 41;
				itemDef.modelOffsetX = -2;
				itemDef.rotationY = 102;
				itemDef.modelOffsetY = -3;
				itemDef.modelZoom = 1033;
				itemDef.stackable = false;
			break;

			case 13274:
				itemDef.femaleEquip1 = 21137;
				itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
				itemDef.modelID = 20943;
				itemDef.maleEquip1 = 21138;
				itemDef.name = "Masori body";
				itemDef.rotationY = 453;
				itemDef.modelOffsetY = 11;
				itemDef.modelZoom = 1240;
				itemDef.stackable = false;
				break;

			case 13275:
				itemDef.copyItem (23320);
				itemDef.femaleEquip1 = 45269;
				itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
				itemDef.modelID = 21021;
				itemDef.maleEquip1 = 21033;
				itemDef.rotationX = 0;
				itemDef.name = "Masori chaps";
				itemDef.modelZoom = 1475;
				itemDef.stackable = false;
				break;

			case 13841:
				itemDef.femaleEquip1 = 46451;
				itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
				itemDef.modelID = 21034;
				itemDef.maleEquip1 = 21044;
				itemDef.name = "Masori mask (f)";
				itemDef.rotationX = 41;
				itemDef.modelOffsetX = -2;
				itemDef.rotationY = 102;
				itemDef.modelOffsetY = -3;
				itemDef.modelZoom = 1033;
				break;

			case 13842:
				itemDef.copyItem(13274);
				itemDef.femaleEquip1 = 45271;
				itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
				itemDef.modelID = 21062;
				itemDef.maleEquip1 = 21091;
				itemDef.name = "Masori body (f)";
				itemDef.modelZoom = 1240;
				break;

			case 13843:
				itemDef.copyItem(13275);
				itemDef.femaleEquip1 = 45268;
				itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
				itemDef.modelID = 21114;
				itemDef.maleEquip1 = 21120;
				itemDef.name = "Masori chaps (f)";
				break;



			case 23423:
				itemDef.copyItem(17011);
				itemDef.modelID = 57641;
				itemDef.maleEquip1 = 57642;
				itemDef.femaleEquip1 = 57642;
				itemDef.name = "Levincia Staff";
				break;
			case 23364:
				itemDef.copyItem(4708);
				itemDef.name = "Nephilim Staff (u)";
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
				itemDef.colorChange = new double[]{0.2, 1.0, 1.2};
				break;

			case 23363:
				itemDef.copyItem(4714);
				itemDef.name = "Nephilim bow (u)";
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
				itemDef.colorChange = new double[]{0.2, 1.0, 1.2};
				break;

			case 23365:
				itemDef.copyItem(4712);
				itemDef.name = "Nephilim Sword (u)";
				itemDef.modelZoom = 1700;
				itemDef.modelID = 18533;
				itemDef.maleEquip1 = 18534;
				itemDef.femaleEquip1 = 18534;
				itemDef.actions = new String[]{null, "Wear", "Disassemble", null, "Drop"};
				itemDef.colorChange = new double[]{0.2, 1.0, 1.2};
				break;

			case 23366:
				itemDef.copyItem(9650);
				itemDef.name = "Ancient Sigil";
				itemDef.modelID = 20612;
				itemDef.modelOffsetY = -20;
				itemDef.modelZoom = 720;
				//itemDef.colorChange = new double[]{0.1, 0.5, 0.1};
				break;

			case 23486:
				itemDef.name = "Faceted Diamond";
				itemDef.modelID = 20613;
				itemDef.modelZoom = 635;
				itemDef.rotationY = 217;
				itemDef.rotationX = 217;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				break;

			case 22200:
				itemDef.copyItem(14050);
				itemDef.name = "Justiciar helmet";
				itemDef.modelID = 20620;
				itemDef.maleEquip1 = 20640;
				itemDef.femaleEquip1 = 20640;
				itemDef.colorChange = new double[]{0.2, 1.1, 1.0};
				break;
			case 22201:
				itemDef.copyItem(8324);
				itemDef.name = "Justiciar body";
				itemDef.modelID = 20625;
				itemDef.maleEquip1 = 20641;
				itemDef.femaleEquip1 = 20641;
				itemDef.colorChange = new double[]{0.2, 1.1, 1.0};
				break;
			case 22202:
				itemDef.copyItem(14052);
				itemDef.name = "Justiciar legs";
				itemDef.modelID = 20626;
				itemDef.maleEquip1 = 20642;
				itemDef.femaleEquip1 = 20642;
				itemDef.colorChange = new double[]{0.2, 1.1, 1.0};
				break;

			case 22203:
				itemDef.copyItem(14050);
				itemDef.name = "Justiciar coif";
				itemDef.modelID = 20648;
				itemDef.maleEquip1 = 20649;
				itemDef.femaleEquip1 = 20649;
				itemDef.colorChange = new double[]{0.2, 1.1, 1.0};
				break;
			case 22204:
				itemDef.copyItem(8324);
				itemDef.name = "Justiciar body";
				itemDef.modelID = 20690;
				itemDef.maleEquip1 = 20691;
				itemDef.femaleEquip1 = 20691;
				itemDef.colorChange = new double[]{0.2, 1.1, 1.0};
				break;
			case 22205:
				itemDef.copyItem(14052);
				itemDef.name = "Justiciar legs";
				itemDef.modelID = 20724;
				itemDef.maleEquip1 = 20716;
				itemDef.femaleEquip1 = 20716;
				itemDef.colorChange = new double[]{0.2, 1.1, 1.0};
				break;

			case 22206:
				itemDef.copyItem(14050);
				itemDef.name = "Justiciar hood";
				itemDef.modelID = 20733;
				itemDef.maleEquip1 = 20734;
				itemDef.femaleEquip1 = 20734;
				itemDef.colorChange = new double[]{0.2, 1.1, 1.0};
				break;
			case 22207:
				itemDef.copyItem(8324);
				itemDef.name = "Justiciar robetop";
				itemDef.modelID = 20811;
				itemDef.maleEquip1 = 20812;
				itemDef.femaleEquip1 = 20812;
				itemDef.colorChange = new double[]{0.2, 1.1, 1.0};
				break;
			case 22208:
				itemDef.copyItem(14052);
				itemDef.name = "Justiciar robe bottoms";
				itemDef.modelID = 20813;
				itemDef.maleEquip1 = 20814;
				itemDef.femaleEquip1 = 20814;
				itemDef.colorChange = new double[]{0.2, 1.1, 1.0};
				break;

			case 23357:
				itemDef.copyItem(12608);
				itemDef.name = "Christmas Aura";
				itemDef.modelID = 20558;
				itemDef.femaleEquip1 = 20558;
				itemDef.maleEquip1 = 20558;
				itemDef.modelZoom = 3900;
				itemDef.rotationX = 0;
				itemDef.rotationY = 217;
				itemDef.rotationZ = 9;
				itemDef.modelOffsetX = -3;
				itemDef.modelOffsetY = 23;
				break;

			case 23358:
				itemDef.copyItem(4407);
				itemDef.name = "Winter Cloak";
				itemDef.modelID = 20559;
				itemDef.maleEquip1 = 20559;
				itemDef.femaleEquip1 = 20559;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.modelZoom = 3500;
				itemDef.rotationX = 1070;
				itemDef.rotationY = 9;
				itemDef.rotationZ = 130;
				itemDef.modelOffsetX = -26;
				itemDef.modelOffsetY = -15;
				break;
			case 23359:
				itemDef.copyItem(6737);
				itemDef.name = "Reindeer Ring";
				itemDef.modelID = 20560;
				itemDef.maleEquip1 = -1;
				itemDef.femaleEquip1 = -1;
				itemDef.modelZoom = 1122;
				itemDef.rotationX = 1122;
				itemDef.rotationY = 322;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;
			case 23360:
				itemDef.copyItem(6737);
				itemDef.name = "Santa's Maul";
				itemDef.modelID = 20580;
				itemDef.maleEquip1 = 20580;
				itemDef.femaleEquip1 = 20580;
				itemDef.modelZoom = 3200;
				itemDef.rotationX = 1226;
				itemDef.rotationY = 322;
				itemDef.rotationZ = 1643;
				itemDef.modelOffsetX = 26;
				itemDef.modelOffsetY = -252;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;

			case 23361:
				itemDef.copyItem(6737);
				itemDef.name = "Santa's Blaster";
				itemDef.modelID = 20581;
				itemDef.maleEquip1 = 20581;
				itemDef.femaleEquip1 = 20581;
				itemDef.modelZoom = 1104;
				itemDef.rotationX = 322;
				itemDef.rotationY = 1591;
				itemDef.rotationZ = 530;
				itemDef.modelOffsetX = 43;
				itemDef.modelOffsetY = -61;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;
			case 10792:
				itemDef.copyItem(290);
				itemDef.name = "Celebration Box";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{40};
				itemDef.modelID = 65284;
				break;

			case 23362:
				itemDef.copyItem(290);
				itemDef.modelID = 20583;
				itemDef.name = "Christmas Box";
				itemDef.modelZoom = 1180;
				itemDef.rotationX = 67;
				itemDef.rotationY = 152;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -14;
				break;
			case 23652:
				itemDef.copyItem(7478);
				itemDef.modelZoom = 432;
				itemDef.rotationX = 254;
				itemDef.rotationY = 415;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 3;
				break;
			case 23685:
				itemDef.copyItem(5074);
				itemDef.name = "Krampus Pet";
				itemDef.modelID = MobDefinition.get(10005).npcModels[4];
				itemDef.modelZoom = 802 * 2;
				itemDef.rotationX = 84;
				itemDef.rotationY = 135;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 145;
				break;
			case 23686:
				itemDef.copyItem(5074);
				itemDef.name = "Evil Santa Pet";
				itemDef.modelZoom = 972 * 4;
				itemDef.rotationX = 84;
				itemDef.rotationY = 135;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -3;
				itemDef.modelID = MobDefinition.get(9400).npcModels[0];
				itemDef.oldColors = new int[]{666, 655, 671, 675, 670, 673, 680, 660};
				itemDef.newColors = new int[]{4, 8, 12, 0, 11, 7, 16, 10};
				break;
			case 11316:
				itemDef.copyItem(5074);
				itemDef.modelZoom = 972 * 5;
				itemDef.name = "Double vote pet";
				itemDef.rotationX = 84;
				itemDef.rotationY = 135;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -3;
				itemDef.modelID = 20565;
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 23663:
				itemDef.copyItem(5074);
				itemDef.modelZoom = 1070 * 5;
				itemDef.name = "Nightmare pet";
				itemDef.rotationX = 84;
				itemDef.rotationY = 135;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = -10;
				itemDef.modelOffsetY = 25;
				itemDef.modelID = 14959;
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 23664:
				itemDef.copyItem(23663);
				itemDef.name = "Nightmare Transformer";
				break;
			case 23665:
				itemDef.copyItem(23664);
				itemDef.certID = 23664;
				itemDef.certTemplateID = 23652;
				itemDef.name = "Nightmare Transformer";
				itemDef.actions = new String[]{"Transform", null, null, null, null};
				break;
			case 23667:
				itemDef.copyItem(5074);
				itemDef.name = "Dragon king pet";
				itemDef.modelZoom = 5300;
				itemDef.rotationY = 520;
				itemDef.rotationX = 750;
				itemDef.modelOffsetX = 15;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = -25;
				itemDef.modelID = 15079;
				itemDef.scaleX = 70;
				itemDef.scaleY = 70;
				itemDef.scaleZ = 70;
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 23668:
				itemDef.copyItem(23667);
				itemDef.name = "Dragon king Transformer";
				break;
			case 23669:
				itemDef.copyItem(23668);
				itemDef.certID = 23668;
				itemDef.scaleX = 100;
				itemDef.scaleY = 100;
				itemDef.scaleZ = 100;
				itemDef.certTemplateID = 23652;
				itemDef.name = "Dragon king Transformer";
				itemDef.actions = new String[]{"Transform", null, null, null, null};
				break;
			case 23670:
				itemDef.copyItem(5074);
				itemDef.name = "Vozzath pet";
				itemDef.modelZoom = 972 * 5;
				itemDef.rotationX = 84;
				itemDef.rotationY = 135;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -3;
				itemDef.modelID = 19688;
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 23671:
				itemDef.copyItem(23670);
				itemDef.name = "Vozzath Transformer";
				break;
			case 23672:
				itemDef.copyItem(23671);
				itemDef.certID = 23671;
				itemDef.certTemplateID = 23652;
				itemDef.name = "Vozzath Transformer";
				itemDef.actions = new String[]{"Transform", null, null, null, null};
				break;
			case 23673:
				itemDef.copyItem(5074);
				itemDef.name = "Zenyte Golem pet";
				itemDef.modelZoom = 5000;
				itemDef.rotationX = 84;
				itemDef.rotationY = 135;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -3;
				itemDef.modelID = 20540;
				itemDef.actions = new String[]{null, null, "Summon", null, "Drop"};
				break;
			case 23674:
				itemDef.copyItem(23673);
				itemDef.name = "Zenyte Golem Transformer";
				break;
			case 23675:
				itemDef.copyItem(23674);
				itemDef.certID = 23674;
				itemDef.certTemplateID = 23652;
				itemDef.name = "Zenyte Golem Transformer";
				itemDef.actions = new String[]{"Transform", null, null, null, null};
				break;
			case 23655:
				itemDef.copyItem(23685);
				itemDef.name = "Santa Transformer";
				break;
			case 23651:
				itemDef.copyItem(23686);
				itemDef.name = "Evil Santa Transformer";
				itemDef.oldColors = new int[]{666, 655, 671, 675, 670, 673, 680, 660};
				itemDef.newColors = new int[]{4, 8, 12, 0, 11, 7, 16, 10};
				break;
			case 23661:
				itemDef.copyItem(11316);
				itemDef.name = "Vote boss Transformer";
				break;
			case 23662:
				itemDef.copyItem(23661);
				itemDef.certID = 23661;
				itemDef.certTemplateID = 23652;
				itemDef.name = "Vote boss Transformer";
				itemDef.actions = new String[]{"Transform", null, null, null, null};
				break;
			case 23653:
				itemDef.copyItem(23655);
				itemDef.certID = 23655;
				itemDef.certTemplateID = 23652;
				itemDef.name = "Santa Transformer";
				itemDef.actions = new String[]{"Transform", null, null, null, null};
				break;
			case 23654:
				itemDef.copyItem(23651);
				itemDef.certID = 23651;
				itemDef.certTemplateID = 23652;
				itemDef.name = "Evil Santa Transformer";
				itemDef.actions = new String[]{"Transform", null, null, null, null};
				itemDef.oldColors = new int[]{666, 655, 671, 675, 670, 673, 680, 660};
				itemDef.newColors = new int[]{4, 8, 12, 0, 11, 7, 16, 10};
				break;



			case 3067:
				itemDef.copyItem(14050);
				itemDef.name = "Devil helmet";
				itemDef.modelID = 21821;
				itemDef.maleEquip1 = 21822;
				itemDef.femaleEquip1 = 21822;
				break;
			case 3068:
				itemDef.copyItem(14051);
				itemDef.name = "Devil body";
				itemDef.modelID = 21843;
				itemDef.maleEquip1 = 21846;
				itemDef.femaleEquip1 = 21846;
				break;
			case 3069:
				itemDef.copyItem(14052);
				itemDef.name = "Devil legs";
				itemDef.modelID = 21847;
				itemDef.maleEquip1 = 21854;
				itemDef.femaleEquip1 = 21854;
				break;
			case 3070:
				itemDef.copyItem(14053);
				itemDef.name = "Devil boots";
				itemDef.modelID = 21856;
				itemDef.maleEquip1 = 21856;
				itemDef.femaleEquip1 = 21856;
				break;
			case 3071:
				itemDef.copyItem(14055);
				itemDef.name = "Devil gloves";
				itemDef.modelID = 21855;
				itemDef.maleEquip1 = 21855;
				itemDef.femaleEquip1 = 21855;
				break;

			case 3072:
				itemDef.copyItem(5011);
				itemDef.name = "Devil bow";
				itemDef.modelID = 21857;
				itemDef.maleEquip1 = 21858;
				itemDef.femaleEquip1 = 21858;
				break;



			case 3073:
				itemDef.copyItem(17632);
				itemDef.name = "Devil wings";
				itemDef.modelID = 21859;
				itemDef.maleEquip1 = 21887;
				itemDef.femaleEquip1 = 21887;
				itemDef.scaleX = 50;
				itemDef.scaleY = 50;
				itemDef.scaleZ = 50;
				break;


			case 3074:
				itemDef.copyItem(14050);
				itemDef.name = "Samurai helmet";
				itemDef.modelID = 21952;
				itemDef.maleEquip1 = 21957;
				itemDef.femaleEquip1 = 21957;
				break;
			case 3075:
				itemDef.copyItem(14051);
				itemDef.name = "Samurai body";
				itemDef.modelID = 21959;
				itemDef.maleEquip1 = 21962;
				itemDef.femaleEquip1 = 21962;
				break;
			case 3076:
				itemDef.copyItem(14052);
				itemDef.name = "Samurai legs";
				itemDef.modelID = 21963;
				itemDef.maleEquip1 = 21972;
				itemDef.femaleEquip1 = 21972;
				break;
			case 3077:
				itemDef.copyItem(5072);
				itemDef.name = "Zelda boots";
				itemDef.modelID = 21932;
				itemDef.maleEquip1 = 21932;
				itemDef.femaleEquip1 = 21932;
				break;
			case 3078:
				itemDef.copyItem(5071);
				itemDef.name = "Zelda gloves";
				itemDef.modelID = 21935;
				itemDef.maleEquip1 = 21935;
				itemDef.femaleEquip1 = 21935;
				break;

			case 3079:
				itemDef.copyItem(5011);
				itemDef.name = "Zelda Sword";
				itemDef.modelID = 21947;
				itemDef.maleEquip1 = 21951;
				itemDef.femaleEquip1 = 21951;
				break;



			case 3080:
				itemDef.copyItem(5068);
				itemDef.name = "Black Knight helmet";
				itemDef.modelID = 21987;
				itemDef.maleEquip1 = 21987;
				itemDef.femaleEquip1 = 21987;
				break;
			case 3081:
				itemDef.copyItem(5069);
				itemDef.name = "Black Knight body";
				itemDef.modelID = 21997;
				itemDef.maleEquip1 = 21997;
				itemDef.femaleEquip1 = 21997;
				break;
			case 3082:
				itemDef.copyItem(5070);
				itemDef.name = "Black Knight legs";
				itemDef.modelID = 21998;
				itemDef.maleEquip1 = 21998;
				itemDef.femaleEquip1 = 21998;
				break;
			case 3083:
				itemDef.copyItem(5072);
				itemDef.name = "Black Knight boots";
				itemDef.modelID = 22005;
				itemDef.maleEquip1 = 22005;
				itemDef.femaleEquip1 = 22005;
				break;
			case 3084:
				itemDef.copyItem(5071);
				itemDef.name = "Black Knight gloves";
				itemDef.modelID = 22065;
				itemDef.maleEquip1 = 22065;
				itemDef.femaleEquip1 = 22065;
				break;


			case 23528:
				itemDef.copyItem(6737);
				itemDef.name = "Elf hat";
				itemDef.modelID = 20528;
				itemDef.maleEquip1 = 20529;
				itemDef.femaleEquip1 = 20529;
				itemDef.maleWieldY = 5;
				itemDef.modelZoom = 681;
				itemDef.rotationX = 203;
				itemDef.rotationY = 228;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -6;
				break;
			case 23529:
				itemDef.copyItem(6737);
				itemDef.name = "Elf body";
				itemDef.modelID = 20530;
				itemDef.maleEquip1 = 20531;
				itemDef.femaleEquip1 = 20531;
				itemDef.maleWieldY = 5;
				itemDef.modelZoom = 1283;
				itemDef.rotationX = 0;
				itemDef.rotationY = 525;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 1;
				break;
			case 23530:
				itemDef.copyItem(6737);
				itemDef.modelZoom = 1302;
				itemDef.rotationX = 0;
				itemDef.rotationY = 525;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 3;
				itemDef.modelOffsetY = 7;
				itemDef.name = "Elf legs";
				itemDef.modelID = 20532;
				itemDef.maleEquip1 = 20533;
				itemDef.femaleEquip1 = 20533;
				itemDef.maleWieldY = 5;
				break;
			case 23531:
				itemDef.copyItem(6737);
				itemDef.name = "Elf boots";
				itemDef.modelID = 20536;
				itemDef.maleEquip1 = 20536;
				itemDef.femaleEquip1 = 20536;
				itemDef.maleWieldY = 5;
				itemDef.modelZoom = 743;
				itemDef.rotationX = 203;
				itemDef.rotationY = 152;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 2;
				itemDef.modelOffsetY = -13;
				break;
			case 23532:
				itemDef.copyItem(6737);
				itemDef.modelZoom = 494;
				itemDef.rotationX = 1703;
				itemDef.rotationY = 152;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = 90;
				itemDef.name = "Elf gloves";
				itemDef.modelID = 20534;
				itemDef.maleEquip1 = 20535;
				itemDef.femaleEquip1 = 20535;
				break;
			case 17747:
				itemDef.copyItem(6737);
				itemDef.name = "Krampus head";
				itemDef.modelID = 20605;
				itemDef.maleEquip1 = 20605;
				itemDef.femaleEquip1 = 20605;
				itemDef.maleWieldY = 5;
				itemDef.modelZoom = 681;
				itemDef.rotationX = 203;
				itemDef.rotationY = 228;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -6;
				break;
			case 17748:
				itemDef.copyItem(6737);
				itemDef.name = "Krampus body";
				itemDef.modelID = 20593;
				itemDef.maleEquip1 = 20593;
				itemDef.femaleEquip1 = 20593;
				itemDef.modelZoom = 1680;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 45;
				itemDef.modelOffsetX = 0;
				break;
			case 17749:
				itemDef.copyItem(6737);
				itemDef.modelZoom = 1302;
				itemDef.rotationX = 0;
				itemDef.rotationY = 525;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 3;
				itemDef.modelOffsetY = 7;
				itemDef.name = "Krampus legs";
				itemDef.modelID = 20594;
				itemDef.maleEquip1 = 20594;
				itemDef.femaleEquip1 = 20594;
				itemDef.maleWieldY = 5;
				break;
			case 17750:
				itemDef.copyItem(6737);
				itemDef.name = "Krampus boots";
				itemDef.modelID = 20596;
				itemDef.maleEquip1 = 20596;
				itemDef.femaleEquip1 = 20596;
				itemDef.maleWieldY = 5;
				itemDef.modelZoom = 743;
				itemDef.rotationX = 203;
				itemDef.rotationY = 152;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 2;
				itemDef.modelOffsetY = -13;
				break;
			case 17751:
				itemDef.copyItem(6737);
				itemDef.modelZoom = 494;
				itemDef.rotationX = 1703;
				itemDef.rotationY = 152;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = 90;
				itemDef.name = "Krampus gloves";
				itemDef.modelID = 20595;
				itemDef.maleEquip1 = 20595;
				itemDef.femaleEquip1 = 20595;
				break;
			case 23527:
				itemDef.copyItem(5074);
				itemDef.name = "Nihil Offspring";
				itemDef.modelID = 62717;
				itemDef.modelZoom = 4000;
				itemDef.colorChange = new double[]{0.2, 0.5, 1.0};
				break;
			case 23522: //Nihil's head
				itemDef.name = "Nihil head";
				itemDef.modelID = 65232;
				itemDef.maleEquip1 = 65232;
				itemDef.femaleEquip1 = 65232;
				itemDef.actions = new String[]{null, "Wear", null, null, "Destroy"};
				itemDef.stackable = false;
				itemDef.modelZoom = 702;
				itemDef.rotationX = 1915;
				itemDef.rotationY = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 2;
				itemDef.modelOffsetY = 80;
				itemDef.oldColors = new int[] {60, };
				itemDef.newColors = new int[] {91, };
				break;
			case 23523: //Nihil's body
				itemDef.name = "Nihil body";
				itemDef.modelID = 65234;
				itemDef.maleEquip1 = 65234;
				itemDef.femaleEquip1 = 65234;
				itemDef.actions = new String[]{null, "Wear", null, null, "Destroy"};
				itemDef.stackable = false;
				itemDef.modelZoom = 1470;
				itemDef.rotationX = 2;
				itemDef.rotationY = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 2;
				itemDef.modelOffsetY = 51;
				itemDef.oldColors = new int[] {60, };
				itemDef.newColors = new int[] {91, };
				break;
			case 23524: //Nihil's legs
				itemDef.name = "Nihil legs";
				itemDef.modelID = 65236;
				itemDef.maleEquip1 = 65236;
				itemDef.femaleEquip1 = 65236;
				itemDef.actions = new String[]{null, "Wear", null, null, "Destroy"};
				itemDef.stackable = false;
				itemDef.modelZoom = 1885;
				itemDef.rotationX = 2;
				itemDef.rotationY = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 4;
				itemDef.oldColors = new int[] {60, };
				itemDef.newColors = new int[] {91, }; //62
				break;
			case 23525:
				itemDef.name = "Nihil boots";
				itemDef.modelOffsetX = ItemDefinition.get(20119).modelOffsetX;
				itemDef.modelOffsetY = ItemDefinition.get(20119).modelOffsetY;
				itemDef.modelID = 100003;
				itemDef.maleEquip1 = 100003;
				itemDef.femaleEquip1 = 100003;
				itemDef.modelZoom = ItemDefinition.get(20119).modelZoom;
				itemDef.rotationY = ItemDefinition.get(20119).rotationY;
				itemDef.rotationX = ItemDefinition.get(20119).rotationX;
				itemDef.actions = ItemDefinition.get(20119).actions;
				itemDef.stackable = false;
				itemDef.colorChange = new double[]{0.1, 0.1, 3.1};
				break;
			case 23526:
				itemDef.name = "Nihil gloves";
				itemDef.modelID = 100004;
				itemDef.maleEquip1 = 100004;
				itemDef.femaleEquip1 = 100004;
				itemDef.rotationX = 1045;
				itemDef.rotationY = 826;
				itemDef.modelZoom = 1648;
				itemDef.modelOffsetX = 7;
				itemDef.modelOffsetY = 25;
				itemDef.actions = new String[]{null, "Wear", null, null, "Destroy"};
				itemDef.stackable = false;
				itemDef.colorChange = new double[]{0.1, 0.1, 3.1};
				break;
			case 22166:
				itemDef.name = "Chance scroll";
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
				itemDef.newColors = new int[]{25823, 26638, 25823, 27823,};
				break;
			case 23512:
				itemDef.copyItem(23511);
				itemDef.name = "Turkey pet (Mutated)";
				itemDef.colorChange = new double[]{0.9, 0, 0};
				break;
			case 23513:
				itemDef.copyItem(23511);
				itemDef.name = "Turkey pet (Mutated)";
				itemDef.colorChange = new double[]{0, 0.8, 0};
				break;
			case 23514:
				itemDef.copyItem(23511);
				itemDef.name = "Turkey pet (Mutated)";
				itemDef.colorChange = new double[]{0, 0, 1.2};
				break;
			case 23515:
				itemDef.copyItem(23511);
				itemDef.name = "Turkey pet (Mutated)";
				itemDef.colorChange = new double[]{0.9, 0.5, 0};
				break;
			case 23516:
				itemDef.copyItem(23511);
				itemDef.name = "Turkey pet (Mutated)";
				itemDef.colorChange = new double[]{0.8, 0, 0.8};
				break;
			case 23517:
				itemDef.copyItem(23511);
				itemDef.name = "Turkey pet (Mutated)";
				itemDef.colorChange = new double[]{0.9, 0.9, 0};
				break;
			case 23510:
				itemDef.copyItem(4621);
				itemDef.name = "Turkey feather";
				itemDef.oldColors = new int[]{
						7512, 4011, 8150, 8670, 2880, 6084,
				};
				itemDef.newColors = new int[]{
						7481, 3360, 7481, 7481, 3345, 3345,
				};
				itemDef.actions = new String[]{"Claim", null, null, null, null};
				break;
			case 17580:
				itemDef.name = "Turkey Pet Mutation";
				itemDef.rdc2 = 65155;
				itemDef.actions = new String[]{null, null, null, null, null};
				break;
			case 23511:
				itemDef.copyItem(5074);
				itemDef.name = "Turkey Pet";
				itemDef.modelID = MobDefinition.get(8501).npcModels[0];
				itemDef.scaleX = 32;
				itemDef.scaleY = 32;
				itemDef.scaleZ = 32;
				itemDef.modelZoom = 909;
				itemDef.rotationX = 161;
				itemDef.rotationY = 144;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = -3;
				itemDef.modelOffsetY = -1;
				break;
			case 23508:
				itemDef.copyItem(23498);
				itemDef.name = "Grandmaster Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;
			case 23509:
				itemDef.copyItem(23508);
				itemDef.certID = 23508;
				itemDef.certTemplateID = 23390;
				itemDef.name = "Grandmaster Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;

			case 17777:
				itemDef.copyItem(17748);
				itemDef.name = "Krampus Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;

			case 17778:
				itemDef.copyItem(17777);
				itemDef.certID = 17777;
				itemDef.certTemplateID = 23390;
				itemDef.name = "Krampus Costume";
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;

			case 17745:
				itemDef.copyItem(23529);
				itemDef.name = "Elf Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;

			case 17746:
				itemDef.copyItem(17745);
				itemDef.certID = 17745;
				itemDef.certTemplateID = 23390;
				itemDef.name = "Elf Costume";
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;

			case 23497:
				itemDef.copyItem(6737);
				itemDef.name = "Grandmaster hood";
				itemDef.modelID = 96496;
				itemDef.maleEquip1 = 96497;
				itemDef.femaleEquip1 = 96497;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.modelZoom = 868;
				itemDef.rotationX = 110;
				itemDef.rotationY = 152;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 3;
				itemDef.modelOffsetY = -15;
				break;
			case 23498:
				itemDef.copyItem(6737);
				itemDef.name = "Grandmaster body";
				itemDef.modelID = 96498;
				itemDef.maleEquip1 = 96499;
				itemDef.femaleEquip1 = 96499;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.modelZoom = 1387;
				itemDef.rotationX = 0;
				itemDef.rotationY = 525;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = 2;
				break;
			case 23499:
				itemDef.copyItem(6737);
				itemDef.name = "Grandmaster legs";
				itemDef.modelID = 96500;
				itemDef.maleEquip1 = 96501;
				itemDef.femaleEquip1 = 96501;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.modelZoom = 1636;
				itemDef.rotationX = 2000;
				itemDef.rotationY = 525;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = -1;
				itemDef.modelOffsetY = 2;
				break;
			case 23483:
				itemDef.copyItem(4685);
				itemDef.name = "Legends Costume";
				break;
			case 23484:
				itemDef.copyItem(23483);
				itemDef.certID = 23483;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Legends Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23481:
				itemDef.copyItem(23260);
				itemDef.name = "Reaper Costume";
				itemDef.rdc2 = 37664;
				break;
			case 23482:
				itemDef.copyItem(23481);
				itemDef.certID = 23481;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Reaper Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23403:
				itemDef.copyItem(23477);
				itemDef.certID = 23477;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Lucifer Costume";
				itemDef.actions = new String[]{null, "Wear", "<col=C3C0B2>Dissolve", null, null};
				itemDef.stackable = false;
				break;
			case 23477:
				itemDef.copyItem(23810);
				itemDef.name = "Lucifer Costume";
				break;
			case 23809:
				itemDef.copyItem(14050);
				itemDef.name = "Lucifer helmet";
				itemDef.modelID = 100000;
				itemDef.maleEquip1 = 100000;
				itemDef.femaleEquip1 = 100000;
				break;
			case 23810:
				itemDef.copyItem(14051);
				itemDef.name = "Lucifer body";
				itemDef.modelID = 100001;
				itemDef.maleEquip1 = 100001;
				itemDef.femaleEquip1 = 100001;
				itemDef.modelZoom = 1380;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 45;
				itemDef.modelOffsetX = 0;
				break;
			case 23811:
				itemDef.copyItem(14052);
				itemDef.name = "Lucifer legs";
				itemDef.modelID = 100002;
				itemDef.maleEquip1 = 100002;
				itemDef.femaleEquip1 = 100002;
				break;
			case 23812:
				itemDef.copyItem(14602);
				itemDef.name = "Lucifer gloves";
				itemDef.modelID = 100003;
				itemDef.maleEquip1 = 100003;
				itemDef.femaleEquip1 = 100003;
				itemDef.modelZoom = 1000;
				break;
			case 23813:
				itemDef.name = "Lucifer boots";
				itemDef.modelID = 100004;
				itemDef.maleEquip1 = 100004;
				itemDef.femaleEquip1 = 100004;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 23478:
				itemDef.copyItem(23815);
				itemDef.name = "Divine Costume";
				break;
			case 23395:
				itemDef.copyItem(23478);
				itemDef.certID = 23478;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Divine Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23814:
				itemDef.copyItem(14050);
				itemDef.name = "Divine helmet";
				itemDef.modelID = 100289;
				itemDef.maleEquip1 = 100290;
				itemDef.femaleEquip1 = 100290;
				break;
			case 23815:
				itemDef.copyItem(14051);
				itemDef.name = "Divine body";
				itemDef.modelID = 100294;
				itemDef.maleEquip1 = 100294;
				itemDef.femaleEquip1 = 100294;
				itemDef.modelZoom = 1380;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 45;
				itemDef.modelOffsetX = 0;
				break;
			case 23816:
				itemDef.copyItem(14052);
				itemDef.name = "Divine legs";
				itemDef.modelID = 100291;
				itemDef.maleEquip1 = 100292;
				itemDef.femaleEquip1 = 100292;
				break;
			case 23817:
				itemDef.copyItem(14602);
				itemDef.name = "Divine gloves";
				itemDef.modelID = 100287;
				itemDef.maleEquip1 = 100288;
				itemDef.femaleEquip1 = 100288;
				itemDef.modelZoom = 1000;
				break;
			case 23818:
				itemDef.name = "Divine boots";
				itemDef.modelID = 100286;
				itemDef.maleEquip1 = 100286;
				itemDef.femaleEquip1 = 100286;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 23479:
				itemDef.copyItem(23820);
				itemDef.name = "Kismet Costume";
				break;
			case 23384:
				itemDef.copyItem(23479);
				itemDef.certID = 23479;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Kismet Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23819:
				itemDef.copyItem(14050);
				itemDef.name = "Kismet helmet";
				itemDef.modelID = 20356;
				itemDef.maleEquip1 = 20356;
				itemDef.femaleEquip1 = 20356;
				break;
			case 23820:
				itemDef.copyItem(14051);
				itemDef.name = "Kismet body";
				itemDef.modelID = 20430;
				itemDef.maleEquip1 = 20430;
				itemDef.femaleEquip1 = 20430;
				itemDef.modelZoom = 1380;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 45;
				itemDef.modelOffsetX = 0;
				break;
			case 23821:
				itemDef.copyItem(14052);
				itemDef.name = "Kismet legs";
				itemDef.modelID = 20431;
				itemDef.maleEquip1 = 20431;
				itemDef.femaleEquip1 = 20431;
				break;
			case 23822:
				itemDef.copyItem(14602);
				itemDef.name = "Kismet gloves";
				itemDef.modelID = 20408;
				itemDef.maleEquip1 = 20408;
				itemDef.femaleEquip1 = 20408;
				itemDef.modelZoom = 1000;
				break;
			case 23823:
				itemDef.name = "Kismet boots";
				itemDef.modelID = 20355;
				itemDef.maleEquip1 = 20355;
				itemDef.femaleEquip1 = 20355;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 23480:
				itemDef.copyItem(23825);
				itemDef.name = "Lucky Costume";
				break;
			case 23385:
				itemDef.copyItem(23480);
				itemDef.certID = 23480;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Lucky Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23824:
				itemDef.copyItem(14050);
				itemDef.name = "Lucky helmet";
				itemDef.modelID = 20432;
				itemDef.maleEquip1 = 20432;
				itemDef.femaleEquip1 = 20432;
				break;
			case 23825:
				itemDef.copyItem(14051);
				itemDef.name = "Lucky body";
				itemDef.modelID = 20433;
				itemDef.maleEquip1 = 20433;
				itemDef.femaleEquip1 = 20433;
				itemDef.modelZoom = 1380;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 45;
				itemDef.modelOffsetX = 0;
				break;
			case 23826:
				itemDef.copyItem(14052);
				itemDef.name = "Lucky legs";
				itemDef.modelID = 20434;
				itemDef.maleEquip1 = 20434;
				itemDef.femaleEquip1 = 20434;
				break;
			case 23827:
				itemDef.copyItem(14602);
				itemDef.name = "Lucky gloves";
				itemDef.modelID = 20435;
				itemDef.maleEquip1 = 20435;
				itemDef.femaleEquip1 = 20435;
				itemDef.modelZoom = 1000;
				break;
			case 23828:
				itemDef.name = "Lucky boots";
				itemDef.modelID = 20436;
				itemDef.maleEquip1 = 20436;
				itemDef.femaleEquip1 = 20436;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 23390:
				itemDef.copyItem(23473);
				itemDef.certID = 23473;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Omega Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23473:
				itemDef.copyItem(23795);
				itemDef.name = "Omega Costume";
				break;
			case 23794:
				itemDef.copyItem(14050);
				itemDef.name = "Omega helmet";
				itemDef.modelID = 20128;
				itemDef.maleEquip1 = 20128;
				itemDef.femaleEquip1 = 20128;
				break;
			case 23795:
				itemDef.copyItem(14051);
				itemDef.name = "Omega body";
				itemDef.modelID = 20181;
				itemDef.maleEquip1 = 20181;
				itemDef.femaleEquip1 = 20181;
				itemDef.modelZoom = 1380;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 45;
				itemDef.modelOffsetX = 0;
				break;
			case 23796:
				itemDef.copyItem(14052);
				itemDef.name = "Omega legs";
				itemDef.modelID = 20227;
				itemDef.maleEquip1 = 20227;
				itemDef.femaleEquip1 = 20227;
				break;
			case 23797:
				itemDef.copyItem(14602);
				itemDef.name = "Omega gloves";
				itemDef.modelID = 20278;
				itemDef.maleEquip1 = 20278;
				itemDef.femaleEquip1 = 20278;
				itemDef.modelZoom = 1000;
				break;
			case 23798:
				itemDef.name = "Omega boots";
				itemDef.modelID = 20296;
				itemDef.maleEquip1 = 20296;
				itemDef.femaleEquip1 = 20296;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 7677:
				itemDef.copyItem(23476);
				itemDef.certID = 23476;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Unknown Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23476:
				itemDef.copyItem(23805);
				itemDef.name = "Unknown Costume";
				break;
			case 23804:
				itemDef.copyItem(14050);
				itemDef.name = "Unknown helmet";
				itemDef.modelID = 20297;
				itemDef.maleEquip1 = 20297;
				itemDef.femaleEquip1 = 20297;
				break;
			case 23805:
				itemDef.copyItem(14051);
				itemDef.name = "Unknown body";
				itemDef.modelID = 20299;
				itemDef.maleEquip1 = 20299;
				itemDef.femaleEquip1 = 20299;
				itemDef.modelZoom = 1380;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 45;
				itemDef.modelOffsetX = 0;
				break;
			case 23806:
				itemDef.copyItem(14052);
				itemDef.name = "Unknown legs";
				itemDef.modelID = 20300;
				itemDef.maleEquip1 = 20300;
				itemDef.femaleEquip1 = 20300;
				break;
			case 23807:
				itemDef.copyItem(14602);
				itemDef.name = "Unknown gloves";
				itemDef.modelID = 20343;
				itemDef.maleEquip1 = 20343;
				itemDef.femaleEquip1 = 20343;
				itemDef.modelZoom = 1000;
				break;
			case 23808:
				itemDef.name = "Unknown boots";
				itemDef.modelID = 20354;
				itemDef.maleEquip1 = 20354;
				itemDef.femaleEquip1 = 20354;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;

				case 23550:
					itemDef.copyItem(23800);
					itemDef.certID = 23800;
					itemDef.certTemplateID = 3062;
					itemDef.name = "Necrotic Costume";
					itemDef.actions = new String[]{null, "Wear", null, null, null};
				break;
			case 23799:
				itemDef.copyItem(14050);
				itemDef.name = "Necromancer helmet";
				itemDef.modelID = 20105;
				itemDef.maleEquip1 = 20107;
				itemDef.femaleEquip1 = 20107;
				break;
			case 23800:
				itemDef.copyItem(14051);
				itemDef.name = "Necrotic Costume";
				itemDef.modelID = 20114;
				itemDef.maleEquip1 = 20115;
				itemDef.femaleEquip1 = 20115;
				break;
			case 23801:
				itemDef.copyItem(14052);
				itemDef.name = "Necromancer legs";
				itemDef.modelID = 20116;
				itemDef.maleEquip1 = 20116;
				itemDef.femaleEquip1 = 20116;
				break;
			case 23802:
				itemDef.copyItem(14602);
				itemDef.name = "Necromancer gloves";
				itemDef.modelID = 20117;
				itemDef.maleEquip1 = 20117;
				itemDef.femaleEquip1 = 20117;
				itemDef.modelZoom = 1000;
				break;
			case 23803:
				itemDef.name = "Necromancer boots";
				itemDef.modelID = 20118;
				itemDef.maleEquip1 = 20118;
				itemDef.femaleEquip1 = 20118;
				itemDef.modelZoom = 800;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelOffsetX = 1;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 23785:
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.name = "Sanguine bow";
				itemDef.modelID = 19921;
				itemDef.maleEquip1 = 19923;
				itemDef.femaleEquip1 = 19923;
				itemDef.modelZoom = 2583;
				itemDef.rotationY = 391;
				itemDef.rotationX = 965;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 26;
				itemDef.modelOffsetY = -26;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 23786:
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.name = "Sanguine Wand";
				itemDef.modelID = 19937;
				itemDef.maleEquip1 = 19936;
				itemDef.femaleEquip1 = 19936;
				itemDef.modelZoom = 2409;
				itemDef.rotationY = 391;
				itemDef.rotationX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 4;
				itemDef.modelOffsetY = -4;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 23787:
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.name = "Sanguine Sword";
				itemDef.modelID = 19938;
				itemDef.maleEquip1 = 19939;
				itemDef.femaleEquip1 = 19939;
				itemDef.modelZoom = 2043;
				itemDef.rotationY = 391;
				itemDef.rotationX = 1243;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = -4;
				itemDef.modelOffsetY = 0;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 23783:
				itemDef.copyItem(15674);
				itemDef.name = "Sanguine box";
				itemDef.actions = new String[]{"Open", null, null, null, null};
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 23788:
				itemDef.copyItem(10666);
				itemDef.modelOffsetY = 6;
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.name = "Sanguine Shield";
				itemDef.modelID = 19940;
				itemDef.maleEquip1 = 19941;
				itemDef.femaleEquip1 = 19941;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 23789:
				itemDef.copyItem(14050);
				itemDef.name = "Sanguine helmet";
				itemDef.modelID = 19850;
				itemDef.maleEquip1 = 19876;
				itemDef.femaleEquip1 = 19876;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 23790:
				itemDef.copyItem(14051);
				itemDef.name = "Sanguine body";
				itemDef.modelID = 19877;
				itemDef.maleEquip1 = 19900;
				itemDef.femaleEquip1 = 19900;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 23791:
				itemDef.copyItem(14052);
				itemDef.name = "Sanguine legs";
				itemDef.modelID = 19901;
				itemDef.maleEquip1 = 19902;
				itemDef.femaleEquip1 = 19902;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 23792:
				itemDef.copyItem(14602);
				itemDef.name = "Sanguine gloves";
				itemDef.modelID = 19914;
				itemDef.maleEquip1 = 19915;
				itemDef.femaleEquip1 = 19915;
				itemDef.modelZoom = 1000;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 23793:
				itemDef.name = "Sanguine boots";
				itemDef.modelID = 19912;
				itemDef.maleEquip1 = 19912;
				itemDef.femaleEquip1 = 19912;
				itemDef.modelZoom = 800;
				itemDef.rotationX = 50;
				itemDef.rotationY = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelOffsetX = 1;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				itemDef.colorChange = new double[]{1.0, 0.1, 0.1};
				break;
			case 9650:
				itemDef.name = "Sanguine Seed";
				itemDef.actions = new String[]{"Combine", null, null, null, null};
				itemDef.modelID = 19919;
				itemDef.maleEquip1 = -1;
				itemDef.femaleEquip1 = -1;
				itemDef.modelOffsetY = 8;
				itemDef.colorChange = new double[]{1.5, 0.1, 0.1};
				break;
			case 3062: //Costume Box
				itemDef.stackable = false;
				itemDef.name = "Costume Box";
				itemDef.modelZoom = 2695;
				itemDef.rotationX = 1576;
				itemDef.rotationY = 42;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = 9;
				itemDef.modelOffsetY = -93;
				itemDef.actions = new String[]{null, null, null, null, null};
				break;
			case 23518:
				itemDef.modelID = 15177;
				itemDef.maleEquip1 = 15177;
				itemDef.femaleEquip1 = 15177;
				break;
			case 23519:
				itemDef.modelID = 15178;
				itemDef.maleEquip1 = 15178;
				itemDef.femaleEquip1 = 15178;
				break;
			case 23520:
				itemDef.modelID = 15188;
				itemDef.maleEquip1 = 15188;
				itemDef.femaleEquip1 = 15188;
				break;
			case 23461:
				itemDef.copyItem(11764);
				itemDef.name = "Hanto Costume";
				break;
			case 23462:
				itemDef.copyItem(23461);
				itemDef.certID = 23461;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Hanto Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;

			case 23487:
				itemDef.copyItem(8213);
				itemDef.name = "Christmas Token";
				break;

			case 23488:
				itemDef.copyItem(23487);
				itemDef.certID = 23487;
				itemDef.certTemplateID = 1436;
				itemDef.name = "Christmas Token";
				itemDef.actions = new String[]{"Claim", null, null, null, null};
				itemDef.stackable = false;
				itemDef.scaleX = 115;
				itemDef.scaleY = 115;
				itemDef.scaleZ = 115;
				itemDef.colorChange = new double[]{0.2, 1.1, 0.2};
				break;


			case 23463:
				itemDef.copyItem(9482);
				itemDef.name = "Raditz Costume";
				break;
			case 23464:
				itemDef.copyItem(23463);
				itemDef.certID = 23463;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Raditz Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23465:
				itemDef.copyItem(9479);
				itemDef.name = "Goku Costume";
				break;
			case 23466:
				itemDef.copyItem(23465);
				itemDef.certID = 23465;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Goku Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23467:
				itemDef.copyItem(5069);
				itemDef.name = "Inuyasha Costume";
				break;
			case 23468:
				itemDef.copyItem(23467);
				itemDef.certID = 23467;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Inuyasha Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23469:
				itemDef.copyItem(22101);
				itemDef.name = "Fallen Angel Costume";
				break;
			case 23470:
				itemDef.copyItem(23469);
				itemDef.certID = 23469;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Fallen Angel Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23471:
				itemDef.copyItem(14069);
				itemDef.name = "Garfield Costume";
				break;
			case 23472:
				itemDef.copyItem(23471);
				itemDef.certID = 23471;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Garfield Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23521:
				itemDef.copyItem(23282);
				itemDef.name = "Vozzath Costume";
				break;
			case 23458:
				itemDef.copyItem(23521);
				itemDef.certID = 23521;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Vozzath Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23459:
				itemDef.copyItem(23221);
				itemDef.name = "Nephilim Costume";
				break;
			case 23460:
				itemDef.copyItem(23459);
				itemDef.certID = 23459;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Nephilim Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
			case 23448:
				itemDef.copyItem(14050);
				itemDef.name = "Turkey helmet";
				itemDef.modelID = 20437;
				itemDef.maleEquip1 = 20438;
				itemDef.femaleEquip1 = 20438;
				itemDef.rdc2 = 100777;
				break;
			case 23449:
				itemDef.copyItem(14051);
				itemDef.name = "Turkey body";
				itemDef.modelID = 20439;
				itemDef.maleEquip1 = 20440;
				itemDef.femaleEquip1 = 20440;
				itemDef.rdc2 = 100777;
				break;
			case 23450:
				itemDef.copyItem(14052);
				itemDef.name = "Turkey legs";
				itemDef.modelID = 20441;
				itemDef.maleEquip1 = 20442;
				itemDef.femaleEquip1 = 20442;
				itemDef.rdc2 = 100777;
				break;
			case 23451:
				itemDef.copyItem(23421);
				itemDef.name = "Turkey gloves";
				itemDef.modelID = 20448;
				itemDef.maleEquip1 = 20465;
				itemDef.femaleEquip1 = 20465;
				itemDef.rdc2 = 100777;
				break;
			case 23452:
				itemDef.copyItem(20456);
				itemDef.name = "Turkey boots";
				itemDef.modelID = 20466;
				itemDef.maleEquip1 = 20466;
				itemDef.femaleEquip1 = 20466;
				itemDef.rdc2 = 100777;
				break;
			case 23453:
				itemDef.copyItem(23449);
				itemDef.name = "Turkey Costume";
				itemDef.rdc2 = 100777;
				break;
			case 23454:
				itemDef.copyItem(23453);
				itemDef.certID = 23453;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Turkey Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;

			case 23455:
				itemDef.copyItem(14051);
				itemDef.name = "Dragon Rider Costume";
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{98};
				break;
			case 23456:
				itemDef.copyItem(23455);
				itemDef.certID = 23455;
				itemDef.certTemplateID = 3062;
				itemDef.name = "Dragon Rider Costume";
				itemDef.actions = new String[]{null, "Wear", null, null, null};
				itemDef.stackable = false;
				break;
		}
		return itemDef;
	}
}
