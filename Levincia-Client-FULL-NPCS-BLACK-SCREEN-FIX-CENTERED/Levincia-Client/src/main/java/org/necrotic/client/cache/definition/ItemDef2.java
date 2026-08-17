package org.necrotic.client.cache.definition;

public class ItemDef2 {
	private ItemDef2() {
	}

	public byte[] customSpriteLocation;

	public static ItemDefinition newIDS(ItemDefinition itemDef, int id) {

		ItemDefinition itemDef2;
		ItemDefinition itemDef21;
		ItemDefinition finity;
		switch (id) {		case 14008:
		case 14009:
		case 14010:
		case 14011:
		case 14012:
		case 14013:
		case 14014:
		case 14015:
		case 14016:
		case 6927:
		case 6928:
		case 6929:
		case 6930:
		case 6931:
		case 6932:
		case 6933:
		case 6934:
		case 6935:
		case 13996:
		case 22077:
		case 19136:
		case 6936:
		case 20173:
		case 11724:
		case 11726:
		case 11728:
		case 11710:
		case 11712:
		case 11714:
		case 11704:
		case 11716:
		case 6585:
		case 11708:
		case 11718:
		case 11720:
		case 11722:
		case 11730:
		case 15486:
		case 13896:
		case 13884:
		case 13890:
		case 13902:
		case 4151:
		case 13893:
		case 13899:
		case 13864:
		case 13858:
		case 13861:
		case 13878:
		case 13870:
		case 13876:
		case 13873:
		case 11702:
		case 4708:
		case 4712:
		case 4714:
		case 4710:
		case 4716:
		case 4720:
		case 4722:
		case 4751:
		case 4718:
		case 4753:
		case 4757:
		case 4759:
		case 4755:
		case 4724:
		case 4728:
		case 4730:
		case 4726:
		case 4745:
		case 4749:
		case 4571:
		case 4747:
		case 4732:
		case 4734:
		case 4736:
		case 4738:
		case 18351:
		case 18349:
		case 18353:
		case 18355:
		case 18357:
		case 4882:
		case 4888: 
		case 4894: 
		case 4900: 
		case 18747: 
		case 20460:
		case 20456: 
		case 19111:
		case 19140:
		case 19139:
		case 19138:
		case 22078:
		case 4411:
		case 16337:
		case 19887:
		case 4393:
		case 22075:
		case 19471:
		case 19470:
		case 19469:
		case 4369:
		case 15887:
		case 16269:
		case 15943:
		case 19153:
		case 19142:
		case 19141:
		case 5095:
		case 2572:
		case 19931:
		case 19933:
		case 19934:
		case 19919:
		case 19917:
		case 7927:
		case 18684:
		case 18686:
		case 14733:
		case 14732:
		case 14734:
		case 13746:
		case 13748:
		case 13750:
		case 13752:
		case 18350:
		case 18360:
		case 18352:
		case 18358:
		case 18354:
		case 7158:
		case 6739:
		case 3204:
		case 1305:
		case 1249:
		case 1215:
		case 1377:
		case 1434:
		case 1149:
		case 11732:
			case 4152:
			case 11236:
			itemDef.actions[3] = "<col=C3C0B2>Dissolve";
			break;
			//Ring of dueling:
		  	case 2552:
			case 2554:
			case 2556:
			case 2558:
			case 2560:
			case 2562:
			case 2564:
			case 2566:
				itemDef.equipOptions[3] = "Duel Arena";
				itemDef.equipOptions[2] = "Castle Wars";
				itemDef.equipOptions[1] = "Clan wars";
				break;
				
			case 17670:
				itemDef.name = "<col=b3b4f2>Demon Scythe";
				itemDef.modelID = 64016;
				itemDef.maleEquip1 = 64017;
				itemDef.femaleEquip1 = 64017;
				itemDef21 = ItemDefinition.get(1319);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 8851:
				itemDef.actions = new String[]{"Exchange", null, "Exchange-X", null, null};
				itemDef.name = "1k Token";
				itemDef.rdc2 = 45895;
				break;
			case 17672:
				itemDef.name = "Doomicia bow";
				itemDef.modelID = 64018;
				itemDef.maleEquip1 = 64019;
				itemDef.femaleEquip1 = 64019;
				itemDef21 = ItemDefinition.get(7809);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17674:
				itemDef.name = "Golden Microphone";
				itemDef.modelID = 64020;
				itemDef.maleEquip1 = 64021;
				itemDef.femaleEquip1 = 64021;
				itemDef21 = ItemDefinition.get(7809);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17676:
				itemDef.name = "Demonhunter blade";
				itemDef.modelID = 64022;
				itemDef.maleEquip1 = 64023;
				itemDef.femaleEquip1 = 64023;
				itemDef21 = ItemDefinition.get(1319);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17678:
				itemDef.name = "Noblelords Sycthe";
				itemDef.modelID = 64024;
				itemDef.maleEquip1 = 64025;
				itemDef.femaleEquip1 = 64025;
				itemDef21 = ItemDefinition.get(1319);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17680:
				itemDef.name = "Bazooka";
				itemDef.modelID = 64026;
				itemDef.maleEquip1 = 64027;
				itemDef.femaleEquip1 = 64027;
				itemDef21 = ItemDefinition.get(1333);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17682:
				itemDef.name = "Crownred Cape";
				itemDef.modelID = 64028;
				itemDef.maleEquip1 = 64029;
				itemDef.femaleEquip1 = 64029;
				itemDef21 = ItemDefinition.get(19709);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17684:
				itemDef.name = "Wyvern Cape";
				itemDef.modelID = 64030;
				itemDef.maleEquip1 = 64031;
				itemDef.femaleEquip1 = 64031;
				itemDef21 = ItemDefinition.get(19709);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 12994:
				itemDef.name = "Oni gloves";
				break;
				
			case 17686:
				itemDef.name = "Oni wings";
				itemDef.modelID = 64032;
				itemDef.maleEquip1 = 64033;
				itemDef.femaleEquip1 = 64033;
				itemDef21 = ItemDefinition.get(19709);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
			
				break;
			case 17658:
				itemDef.name = "Teddybear";
				itemDef.modelID = 64034;
				itemDef.maleEquip1 = 64035;
				itemDef.femaleEquip1 = 64035;
				itemDef21 = ItemDefinition.get(8848);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17688:
				itemDef.name = "Demoncore Sycthe";
				itemDef.modelID = 64036;
				itemDef.maleEquip1 = 64037;
				itemDef.femaleEquip1 = 64037;
				itemDef21 = ItemDefinition.get(1319);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17714:
				itemDef.name = "Oni Axe";
				itemDef.modelID = 64058;
				itemDef.maleEquip1 = 64057;
				itemDef.femaleEquip1 = 64057;
				itemDef21 = ItemDefinition.get(1319);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 17690:
				itemDef.name = "Nocturan MoonSlicer";
				itemDef.modelID = 64038;
				itemDef.maleEquip1 = 64039;
				itemDef.femaleEquip1 = 64039;
				itemDef21 = ItemDefinition.get(1319);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17692:
				itemDef.name = "Paladin's Bliss";
				itemDef.modelID = 64040;
				itemDef.maleEquip1 = 64041;
				itemDef.femaleEquip1 = 64041;
				itemDef21 = ItemDefinition.get(1333);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17694:
				itemDef21 = ItemDefinition.get(18953);
				itemDef.name = "Necromancer Hammer";
				itemDef.modelID = 19725;
				itemDef.maleEquip1 = 19725;
				itemDef.femaleEquip1 = 19725;
				itemDef.modelOffsetX = 29;
				itemDef.rotationZ = 1574;
				itemDef.modelOffsetY = -200;
				itemDef.modelZoom = 3300;
				itemDef.rotationY = 339;
				itemDef.rotationX = 1243;
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 22379:
				itemDef.copyItem(11235);
				itemDef.name = "Pumpkin Bow";
				itemDef.modelID = 19751;
				itemDef.femaleEquip1 = 19751;
				itemDef.maleEquip1 = 19751;

				itemDef.modelZoom = 2150;
				itemDef.rotationY = 362;
				itemDef.rotationX = 183;
				itemDef.rotationZ = 391;
				itemDef.modelOffsetX = 96;
				itemDef.modelOffsetY = -61;
				break;
			case 22380:
				itemDef.copyItem(12608);
				itemDef.name = "Spooky Aura";
				itemDef.modelID = 19755;
				itemDef.femaleEquip1 = 19755;
				itemDef.maleEquip1 = 19755;
				itemDef.modelZoom = 3900;
				itemDef.rotationX = 0;
				itemDef.rotationY = 217;
				itemDef.rotationZ = 9;
				itemDef.modelOffsetX = -3;
				itemDef.modelOffsetY = 23;
				break;
			case 22375:
				itemDef21 = ItemDefinition.get(18953);
				itemDef.name = "Pumpkin Staff";
				itemDef.modelID = 19750;
				itemDef.maleEquip1 = 19750;
				itemDef.femaleEquip1 = 19750;
				itemDef.modelZoom = 4000;
				itemDef.rotationY = 513;
				itemDef.rotationX = 1261;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetX = -43;
				itemDef.modelOffsetY = 0;
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 23551:
				itemDef21 = ItemDefinition.get(18953);
				itemDef.name = "Necrotic Longsword";
				itemDef.modelID = 19733;
				itemDef.maleEquip1 = 19733;
				itemDef.femaleEquip1 = 19733;
				itemDef.modelOffsetX = 29;
				itemDef.rotationZ = 1574;
				itemDef.modelOffsetY = -200;
				itemDef.modelZoom = 2300;
				itemDef.rotationY = 339;
				itemDef.rotationX = 1243;
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 1419:
				itemDef.modelZoom = 2800;
				break;
				
			case 17696:
				itemDef.name = "Victory Hammer Offhand";
				itemDef.modelID = 64043;
				itemDef.maleEquip1 = 64043;
				itemDef.femaleEquip1 = 64043;
				itemDef21 = ItemDefinition.get(1333);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 17698:
				itemDef21 = ItemDefinition.get(18953);
				itemDef.name = "Infernal Hammer";
				itemDef.modelID = 19121;
				itemDef.maleEquip1 = 19122;
				itemDef.femaleEquip1 = 19122;
				itemDef.modelOffsetX = 0;
				itemDef.rotationZ = 0;
				itemDef.modelOffsetY = 0;
				itemDef.modelZoom = 2496;
				itemDef.rotationY = 478;
				itemDef.rotationX = 0;
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 23301:
				itemDef.name = "Infernal Staff";
				itemDef.modelID = 18936;
				itemDef.maleEquip1 = 18936;
				itemDef.femaleEquip1 = 18936;
				itemDef.modelOffsetX = -55;
				itemDef.modelOffsetY = 140;
				itemDef.modelZoom = 2339;
				itemDef.rotationY = 200;
				itemDef.rotationZ = 0;
				itemDef.rotationX = 1209;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 23302:
				itemDef.name = "Necromancer staff";
				itemDef.modelID = 19724;
				itemDef.maleEquip1 = 19724;
				itemDef.femaleEquip1 = 19724;
				itemDef.modelOffsetX = -43;
				itemDef.modelOffsetY = 26;
				itemDef.modelZoom = 4200;
				itemDef.rotationY = 548;
				itemDef.rotationZ = 96;
				itemDef.rotationX = 1261;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 22951:
				itemDef.name = "Necromancer crystal";
				itemDef.modelID = 19724;
				itemDef.maleEquip1 = 19724;
				itemDef.femaleEquip1 = 19724;
				itemDef.modelOffsetX = -78;
				itemDef.modelOffsetY = -148;
				itemDef.modelZoom = 2096;
				itemDef.rotationY = 391;
				itemDef.rotationZ = 0;
				itemDef.rotationX = 1191;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 22952:
				itemDef.name = "Necromancer hammer head";
				itemDef.modelID = 19725;
				itemDef.maleEquip1 = 19725;
				itemDef.femaleEquip1 = 19725;
				itemDef.modelZoom = 2426;
				itemDef.rotationX = 1070;
				itemDef.rotationY = 339;
				itemDef.rotationZ = 1574;
				itemDef.modelOffsetX = 61;
				itemDef.modelOffsetY = -322;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 22953:
				itemDef.copyItem(11235);
				itemDef.name = "Necromancer Bow staff";
				itemDef.modelID = 19723;
				itemDef.femaleEquip1 = 19723;
				itemDef.maleEquip1 = 19723;
				itemDef.modelOffsetX = 9;
				itemDef.modelOffsetY = 26;
				itemDef.modelZoom = 1574;
				itemDef.rotationY = 0;
				itemDef.rotationX = 1626;
				itemDef.rotationZ = 0;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				break;
			case 22954:
				itemDef.copyItem(5074);
				itemDef.name = "Necromancer Pet";
				itemDef.modelID = 19731;
				itemDef.modelZoom = 3700;
				break;
			case 13653:
				itemDef.name = "Death fragments";
				itemDef.rdc2 = 45895;
				break;

			case 18753:
				itemDef.name = "<col=eed81d><shad=9283>Corrupt Maxiblood helm<shad-1>";
				itemDef.modelID = 65130;
				itemDef.maleEquip1 = 65131;
				itemDef.femaleEquip1 = 65131;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 66;
				itemDef.stackable = false;
				break;
			case 18752:
				itemDef.name = "<col=eed81d><shad=9283>Corrupt Maxiblood platebody<shad-1>";
				itemDef.modelID = 65132;
				itemDef.maleEquip1 = 65133;
				itemDef.femaleEquip1 = 65133;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = 1;
				
				itemDef.modelOffsetY = -10;
				itemDef.modelZoom = 1400;
				itemDef.rotationY = 700;
				itemDef.rotationX = 1;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 66;
				itemDef.stackable = false;
				break;
			case 18751:
				itemDef.name = "<col=eed81d><shad=9283>Corrupt Maxiblood legs<shad-1>";
				itemDef.modelID = 65134;
				itemDef.maleEquip1 = 65135;
				itemDef.femaleEquip1 = 65135;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = 1800;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 66;
				itemDef.stackable = false;
				break;
			case 18750:
				itemDef.name = "<col=eed81d><shad=9283>Corrupt maxiblood whip<shad-1>";
				itemDef.modelID = 65141;
				itemDef.maleEquip1 = 65142;
				itemDef.femaleEquip1 = 65142;
				itemDef21 = ItemDefinition.get(13131);
				itemDef.modelOffsetX = 10;
				
				itemDef.modelOffsetY = 1;
				itemDef.modelZoom = 1000;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = 120;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 66; // the new texture u want it to have
				

				itemDef.stackable = false;
				break;

			case 17544:
				itemDef.name = "<col=353><shad=272625> Necrotic Potion<shad-1>";
				itemDef.rdc2 = 5774;
				itemDef.modelZoom = 600;
				itemDef.actions = new String[]{"Drink", null, null, null, "Destroy"};
				break;
			case 17546:
				itemDef.name = "<col=969695><shad=272625> God Potion (1)<shad-1>";
				itemDef.rdc2 = 9090;
				itemDef.modelZoom = 600;
				itemDef.actions = new String[]{"Drink", null, null, null, "Destroy"};
				break;
			case 17542:
				itemDef.name = "<col=ff0000><shad=272625>Super Overload (1)<shad-1>";
				itemDef.rdc2 = 42500;
				itemDef.modelZoom = 600;
				itemDef.actions = new String[]{"Drink", null, null, null, "Destroy"};
				break;
			case 17540:
				itemDef.name = "<col=ff0000><shad=272625>Infinite Super Overload<shad-1>";
				itemDef.rdc2 = 42500;
				itemDef.modelZoom = 600;
				itemDef.actions = new String[]{"Drink", null, null, null, "Destroy"};
				break;
			case 18749:
				itemDef.name = "<col=fb9ae5><shad=9283>Corrupt archie helm<shad-1>";
				itemDef.modelID = 15917;
				itemDef.maleEquip1 = 15918;
				itemDef.femaleEquip1 = 15918;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = 850;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = 90;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 18748:
				itemDef.name = "<col=fb9ae5><shad=9283>Corrupt archie body<shad-1>";
				itemDef.modelID = 15925;
				itemDef.maleEquip1 = 15927;
				itemDef.femaleEquip1 = 15927;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 18638:
				itemDef.name = "<col=fb9ae5><shad=9283> Corrupt archie chaps<shad-1>";
				itemDef.modelID = 16001;
				itemDef.maleEquip1 = 16002;
				itemDef.femaleEquip1 = 16002;// im not lagging
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 18631:
				itemDef.name = "<col=57d0fd><shad=9283>Corrupt moonlight hood<shad-1>";
				itemDef.modelID = 65296;
				itemDef.maleEquip1 = 65297;
				itemDef.femaleEquip1 = 65297;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 57;
				itemDef.stackable = false;
				break;
			case 18637:
				itemDef.name = "<col=57d0fd><shad=9283>Corrupt moonlight robetop<shad-1>";
				itemDef.modelID = 65298;
				itemDef.maleEquip1 = 65299;
				itemDef.femaleEquip1 = 65299;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 57;
				itemDef.stackable = false;
				break;
			case 18623:
				itemDef.name = "<col=57d0fd><shad=9283>Corrupt moonlight robebottom<shad-1>";
				itemDef.modelID = 65300;
				itemDef.maleEquip1 = 65301;
				itemDef.femaleEquip1 = 65301;
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 57;
				itemDef.stackable = false;
				break;
			case 18629:
				itemDef.name = "<col=57d0fd><shad=9283>Corrupt moonlight staff<shad-1>";
				itemDef.modelID = 65294;
				itemDef.maleEquip1 = 65295;
				itemDef.femaleEquip1 = 65295;
				itemDef21 = ItemDefinition.get(19146);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = 2700;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[1] = "Wear";
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 62; // the texture that it currently has
				itemDef.newColors[0] = 57; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 18636:
				itemDef.name = "<col=fb9ae5><shad=9283>Corrupt Archie bow<shad-1>";
				ItemDefinition itemDef211 = ItemDefinition.get(21223);
				itemDef.modelID = 15886;
				itemDef.femaleEquip1 = 15883;
				itemDef.maleEquip1 = 15883;// 95099
				itemDef.modelOffsetX = 10;
				itemDef.modelOffsetY = -19;
				itemDef.modelZoom = 2513;
				itemDef.rotationX = 1591;
				itemDef.rotationY = 1591;
				itemDef.rotationZ = 1017;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 8253:
				itemDef.newColors = new int[2]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[2]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 66; // the new texture u want it to have

				itemDef.oldColors[1] = 24; // the texture that it currently has
				itemDef.newColors[1] = 71; // the new texture u want it to have
				itemDef.name = "<col=ff2a00><shad=761401>Defiled minigun<shad-1>";
				ItemDefinition def = ItemDefinition.get(20538);
				itemDef.modelID = 65210;
				itemDef.femaleEquip1 = 65211;
				itemDef.maleEquip1 = 65211;// 95099
				itemDef.actions = new String[]{null, "Wield", null, null, "Destroy"};
				itemDef.modelOffsetX = def.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.stackable = false;
				break;
			case 17700:
				itemDef.name = "Wrath Hammer Offhand";
				itemDef.maleEquip1 = 64045;
				itemDef.modelID = 64045;
				itemDef.femaleEquip1 = 64045;
				def = ItemDefinition.get(1333);
				itemDef.modelOffsetX = 46;
				itemDef.modelOffsetY = 10;
				itemDef.modelZoom = 2500;
				itemDef.rotationY = 300;
				itemDef.rotationX = 600;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 23376:
				itemDef.name = "Wrath Hammer";
				itemDef.modelID = 64044;
				itemDef.maleEquip1 = 64044;
				itemDef.femaleEquip1 = 64044;
				def = ItemDefinition.get(1333);
				itemDef.modelOffsetX = -45;
				itemDef.modelOffsetY = 10;
				itemDef.modelZoom = 2500;
				itemDef.rotationY = 260;
				itemDef.rotationX = 1400;
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 5420:
				itemDef.name = "Madman helm";
				itemDef.modelID = 65231;
				itemDef.maleEquip1 = 65232;
				itemDef.femaleEquip1 = 65232;
				itemDef21 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.oldColors = new int[]{60};
				itemDef.newColors = new int[]{87};
				itemDef.stackable = false;
				break;
			case 5422:
				itemDef.name = "Madman body<shad-1>";
				itemDef.modelID = 65233;
				itemDef.maleEquip1 = 65234;
				itemDef.femaleEquip1 = 65234;
				itemDef21 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.oldColors = new int[]{60};
				itemDef.newColors = new int[]{87};
				itemDef.stackable = false;
				break;
			case 5428:
				itemDef.name = "Madman legs<shad-1>";
				itemDef.modelID = 65235;
				itemDef.maleEquip1 = 65236;
				itemDef.femaleEquip1 = 65236;// im not lagging
				itemDef21 = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				//		itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.oldColors = new int[]{60};
				itemDef.newColors = new int[]{87};

				itemDef.stackable = false;
				break;
			case 15043:
				itemDef.name = "madman boots";
				break;
			case 6629:
				itemDef.name = "madman gloves";
				itemDef.modelID = 64046;
				//itemDef.maleWearId = 64047;
				//itemDef.femaleWearId = 64047;
				def = ItemDefinition.get(20562);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17704:
				itemDef.name = "Astrogun (Halo)";
				itemDef.modelID = 64048;
				itemDef.maleEquip1 = 64049;
				itemDef.femaleEquip1 = 64049;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17706:
				itemDef.name = "Chest";
				itemDef.modelID = 64050;
				itemDef.maleEquip1 = 64050;
				itemDef.femaleEquip1 = 64050;
				def = ItemDefinition.get(290);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = 2300;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				//	itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
				itemDef.stackable = false;
				break;
			case 17708:
				itemDef.name = "<col=b5f2b3>Joyxox Sword";
				itemDef.modelID = 64051;
				itemDef.maleEquip1 = 64052;
				itemDef.femaleEquip1 = 64052;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				
				break;
			case 15328:
				itemDef.name = "<shad=1><col=ff0000>Infinity Rage Potion";
				break;
			case 23242:
				itemDef.copyItem(15328);
				itemDef.name = "Owner Potion";
				break;
			case 15330:
				itemDef.name = "<shad=1><col=ff0000>Infinite Super Overload";
				itemDef.actions = new String[]{"Drink", null, "Upgrade", null, "Drop"};
				break;
			case 23225:
				def = ItemDefinition.get(15330);
				itemDef.modelID = def.modelID;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.rotationZ = def.rotationZ;
				itemDef.name = "<col=ff0000><shad=272625>Infinity Rage potion<shad-1>";
				itemDef.actions = new String[]{"Drink", null, null, null, "Drop"};
				break;
				
			case 17710:
				itemDef.name = "Dictator Maul";
				itemDef.modelID = 64053;
				itemDef.maleEquip1 = 64054;
				itemDef.femaleEquip1 = 64054;
				def = ItemDefinition.get(4153);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = 2200;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 13760:
				itemDef.name = "Elder Maul";
				itemDef.modelID = 64334;
				itemDef.maleEquip1 = 64335;
				itemDef.femaleEquip1 = 64335;
				def = ItemDefinition.get(4153);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = 2200;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 11798:
				itemDef.name = "Dinh's bulwark";
				itemDef.modelID = 64336;
				itemDef.maleEquip1 = 64337;
				itemDef.femaleEquip1 = 64337;
				def = ItemDefinition.get(4153);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = 2200;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				

				break;
			case 17712:
				itemDef.name = "<col=b5aaaa>Angels Flamethrower";
				itemDef.modelID = 64055;
				itemDef.maleEquip1 = 64056;
				itemDef.femaleEquip1 = 64056;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.rdc2 = 7654;
				break;
			case 17638:
				itemDef.name = "<col=b5aaaa>Legendary helm";
				itemDef.modelID = 65519;
				itemDef.maleEquip1 = 65520;
				itemDef.femaleEquip1 = 65520;
				def = ItemDefinition.get(4882);
				itemDef.modelOffsetX = def.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 3511;
				break;

			case 17640:
				itemDef.name = "<col=b5aaaa>Legendary body";
				itemDef.modelID = 65521;
				itemDef.maleEquip1 = 65522;
				itemDef.femaleEquip1 = 65522;
				def = ItemDefinition.get(4894);
				itemDef.modelOffsetX = def.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 3511;
				break;
			case 15593:
				itemDef.name = "<col=b5aaaa>Legendary platelegs";
				itemDef.modelID = 65523;
				itemDef.maleEquip1 = 65524;
				itemDef.femaleEquip1 = 65524;
				itemDef21 = ItemDefinition.get(16669);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 3511;
				break;
			case 12860:
				itemDef.name = "Legendary gloves";
				break;
			case 12565:
				itemDef.name = "Legendary boots";
				break;
			case 16140:
				itemDef.name = "Legendary amulet";
				break;

			case 2021:
				itemDef.name = "<col=b5aaaa>Legendary wings";
				itemDef.modelID = 65517;
				itemDef.maleEquip1 = 65518;
				itemDef.femaleEquip1 = 65518;
				def = ItemDefinition.get(18509);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

				
			case 10025:
				itemDef.copyItem(290);
				itemDef.name = "Reward Crate";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.modelID = 19645;
				itemDef.modelZoom = 2000;
				itemDef.rotationY = 43;
				itemDef.rotationX = 100;
				break;
				
			case 10027:
				itemDef.name = "<img=15>Slayer Reward Box";
				itemDef.rdc2 = 2536531;
				itemDef.actions = new String[]{"Open", null, null, null, "Drop"};

				break;

			case 17716:
				itemDef.name = "Doom wings";
				itemDef.modelID = 64071;
				itemDef.maleEquip1 = 64072;
				itemDef.femaleEquip1 = 64072;
				def = ItemDefinition.get(19893);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 18189:
				itemDef.name = "Baby web spiders";
				itemDef.stackable = true;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				break;
			case 20422:
				itemDef.name = "Cracker Urn";
				itemDef.stackable = true;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				break;
			case 4568:
				itemDef.name = "Basket of undead (@bla@Discontinued@or1@)";
				//	itemDef.stackable = true;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				def = ItemDefinition.get(4565);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.actions = def.actions;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.rdc2 = 35473;
				break;
			case 4569:
				itemDef.name = "Basket of Xmas (@whi@Xmas 2019@or1@)";
				//	itemDef.stackable = true;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				def = ItemDefinition.get(4565);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.actions = def.actions;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.rdc2 = 90999;
				break;
			case 4570:
				itemDef.name = "Golden Cracker (@whi@Xmas 2019@or1@)";
				//	itemDef.stackable = true;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				def = ItemDefinition.get(20083);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.actions = def.actions;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.rdc2 = 7775;
				break;
			case 15367:
				itemDef.name = "Event pack";
				itemDef.stackable = false;
				itemDef.actions = new String[]{"Open", null, null, null, "Drop"};

				itemDef.rdc2 = 621133;
				break;
			case 15290:
				itemDef.name = "Levincia token pack (5k)";
				itemDef.stackable = false;
				itemDef.actions = new String[] { "Open", null, "Open-all", null, "Drop" };
				def = ItemDefinition.get(15262);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = 2000;
				//itemDef.actions = itemDef211.actions;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.rdc2 = 293613;
				break;
			case 15289:
				itemDef.name = "Levincia token pack (25k)";
				itemDef.stackable = false;
				itemDef.actions = new String[] { "Open", null, "Open-all", null, "Drop" };
				def = ItemDefinition.get(15262);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = 2000;
				//itemDef.actions = itemDef211.actions;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.rdc2 = 283613;
				break;
			case 15288:
				itemDef.name = "Levincia token pack (100k)";
				itemDef.stackable = false;
				itemDef.actions = new String[] { "Open", null, "Open-all", null, "Drop" };
				def = ItemDefinition.get(15262);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = 2000;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.rdc2 = 223613;
				break;
			case 22209:
				itemDef.name = "Levincia token pack (250k)";
				itemDef.stackable = false;
				itemDef.actions = new String[] { "Open", null, "Open-all", null, "Drop" };
				def = ItemDefinition.get(15262);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = 2000;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.rdc2 = 214153;
				break;
			case 22211:
				itemDef.name = "PVM ticket pack (50k)";
				itemDef.stackable = false;
				itemDef.actions = new String[] { "Open", null, "Open-all", null, "Drop" };
				ItemDefinition itemdefyogipic1111 = ItemDefinition.get(15262);
				itemDef.modelID = itemdefyogipic1111.modelID;
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelZoom = 2000;
				itemDef.colorChange = new double[]{0.6, 0.5, 0.1};
				break;
			case 8213:
				itemDef.name = "Christmas token";
				itemDef.stackable = true;
				itemDef.actions = new String[]{"Claim", null, null, null, "Drop"};
				def = ItemDefinition.get(1050);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = 5;
				itemDef.modelOffsetY = -3;
				itemDef.modelZoom = 600;
				//itemDef.actions = itemDef211.actions;
				itemDef.rotationY = 20;
				itemDef.rotationX = 900;
				//itemDef.rdc2 = 743;
				break;

			case 6183:
				itemDef.name = "Halloween Box (@bla@Discontinued@or1@)";
				itemDef.rdc2 = 32535;
				break;
			case 15246:
				itemDef.name = "Xmas Mystery Box (@whi@Xmas 2019@or1@)";
				itemDef.rdc2 = 32535;
				break;
			case 20083:
				itemDef.name = "Halloween cracker (@bla@Discontinued@or1@)";
				//itemDef.stackable = true;
				itemDef.actions = new String[]{"Pull", null, null, null, "Drop"};
				itemDef.rdc2 = 294295;
				break;
			case 19775:
				itemDef.name = "Small event rate Lamp";
				itemDef.rdc2 = 47388;
				break;
			case 19768:
				itemDef.name = "Large event rate Lamp";
				itemDef.rdc2 = 23643315;
				itemDef.modelZoom = 700;
				break;
			case 15222:
				itemDef.name = "Poison Ivy";
				itemDef.stackable = true;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				break;
			case 588:
				itemDef.name = "Spirit Orb";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.rdc2 = 12233;
				itemDef.stackable = true;

				break;
			case 14505:
				itemDef.name = "Phantom orb";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.rdc2 = 3274772;
				itemDef.stackable = true;

				break;
			case 18761:
				itemDef.name = "Transylvanian orb";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.rdc2 = 3465736;
				itemDef.stackable = true;

				break;
			case 19640:
				itemDef.name = "Undead orb";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.rdc2 = 8844;
				itemDef.stackable = true;
				break;
			case 17831:
				itemDef.name = "Mystery Shards";
				itemDef.stackable = true;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				//itemDef.rdc2 = 234563434;
				break;
			case 2862:
				itemDef.name = "Grinch logs";
				itemDef.stackable = true;
				itemDef.rdc2 = 857664;
				break;
			case 10593:
				itemDef.name = "Cowbell";
				itemDef.stackable = true;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				//	itemDef.rdc2=  857664;
				break;
			case 6855:
				itemDef.name = "Christmas Mystery Box";
				itemDef.stackable = false;
				itemDef.actions = new String[]{"open", null, null, null, "Drop"};
				//itemDef.rdc2 = 234563434;
				break;
			case 8212:
				itemDef.name = "Spirit Dust";
				itemDef.stackable = true;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.rdc2 = 234563434;
				break;
			case 6849:
				itemDef.name = "Blue bell";
				itemDef.stackable = true;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				//itemDef.rdc2 = 234563434;
				break;
			case 6850:
				itemDef.name = "Green bell";
				itemDef.stackable = true;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				//itemDef.rdc2 = 234563434;
				break;
			case 6847:
				itemDef.name = "Yellow bell";
				itemDef.stackable = true;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				//itemDef.rdc2 = 234563434;
				break;
			case 6851:
				itemDef.name = "pink bell";
				itemDef.stackable = true;
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				//itemDef.rdc2 = 234563434;
				break;
			case 2396:
				itemDef.name = "Merry scroll";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				itemDef.stackable = true;

				itemDef.rdc2 = 2344321;
				break;
			case 5733:
				itemDef.actions = new String[]{"Eat", null, "Heal", "Commands", "Drop"};
				break;
			case 17718:
				itemDef.copyItem(22083);
				itemDef.name = "Batman's bow";
				itemDef.modelID = 64073;
				itemDef.maleEquip1 = 64074;
				itemDef.femaleEquip1 = 64074;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.stackable = false;
				break;
			case 17720:
				itemDef.name = "Dracula sword";
				itemDef.modelID = 64075;
				itemDef.maleEquip1 = 64076;
				itemDef.femaleEquip1 = 64076;
				def = ItemDefinition.get(1311);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17722:
				itemDef.name = "Gunther sword";
				itemDef.modelID = 64077;
				itemDef.maleEquip1 = 64078;
				itemDef.femaleEquip1 = 64078;
				def = ItemDefinition.get(1311);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17724:
				itemDef.name = "COL sword I";
				itemDef.modelID = 64079;
				itemDef.maleEquip1 = 64080;
				itemDef.femaleEquip1 = 64080;
				def = ItemDefinition.get(1281);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17726:
				itemDef.name = "COL sword II";
				itemDef.modelID = 64081;
				itemDef.maleEquip1 = 64082;
				itemDef.femaleEquip1 = 64082;
				def = ItemDefinition.get(1281);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17728:
				itemDef.name = "COL shield I";
				itemDef.modelID = 64083;
				itemDef.maleEquip1 = 64084;
				itemDef.femaleEquip1 = 64084;
				def = ItemDefinition.get(1193);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17730:
				itemDef.name = "COL shield II";
				itemDef.modelID = 64085;
				itemDef.maleEquip1 = 64086;
				itemDef.femaleEquip1 = 64086;
				def = ItemDefinition.get(1193);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

			case 17732:
				itemDef.name = "FyreFighter";
				itemDef.modelID = 64087;
				itemDef.maleEquip1 = 64088;
				itemDef.femaleEquip1 = 64088;
				def = ItemDefinition.get(1311);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17734:
				itemDef.name = "GreatRealm Axe";
				itemDef.modelID = 64089;
				itemDef.maleEquip1 = 64090;
				itemDef.femaleEquip1 = 64090;
				def = ItemDefinition.get(1311);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17636:
				itemDef.name = "Flaming Skeleton";
				itemDef.modelID = 65525;
				itemDef.maleEquip1 = 65526;
				itemDef.femaleEquip1 = 65526;
				def = ItemDefinition.get(4882);
				itemDef.modelOffsetX = def.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
			case 17644:
				itemDef.name = "Flaming Katana";
				itemDef.modelID = 65527;
				itemDef.maleEquip1 = 65528;
				itemDef.femaleEquip1 = 65528;
				def = ItemDefinition.get(1333);
				itemDef.modelOffsetX = def.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;


			case 17642:
				itemDef.name = "xat legs";
				itemDef.modelID = 65523;
				itemDef.maleEquip1 = 65524;
				itemDef.femaleEquip1 = 65524;
				def = ItemDefinition.get(4900);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 1511;

				break;

			case 17632:
				itemDef.name = "Firefly wings";
				itemDef.modelID = 65517;
				itemDef.maleEquip1 = 65518;
				itemDef.femaleEquip1 = 65518;
				def = ItemDefinition.get(18509);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				
				itemDef.rdc2 = 29638936;

				break;
			case 17999:
				itemDef.name = "<col=E3E3E3>COL Torva helm";
				itemDef.modelID = 65498;
				itemDef.maleEquip1 = 65499;
				itemDef.femaleEquip1 = 65499;
				def = ItemDefinition.get(4882);
				itemDef.modelOffsetX = def.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 8239113;
				


				break;

			case 18001:
				itemDef.name = "<col=E3E3E3>COL Torva body";
				itemDef.modelID = 65500;
				itemDef.maleEquip1 = 65501;
				itemDef.femaleEquip1 = 65501;
				def = ItemDefinition.get(4894);
				itemDef.modelOffsetX = def.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 8239113;
				


				break;

			case 18003:
				itemDef.name = "<col=E3E3E3>COL Torva legs";
				itemDef.modelID = 65502;
				itemDef.maleEquip1 = 65503;
				itemDef.femaleEquip1 = 65503;
				def = ItemDefinition.get(4900);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 8239113;
				

				break;
			case 18005:
				itemDef.name = "<col=E3E3E3>COL wings";
				itemDef.modelID = 65504;
				itemDef.maleEquip1 = 65505;
				itemDef.femaleEquip1 = 65505;
				def = ItemDefinition.get(18509);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 8239113;
				

				break;
			case 18007:
				itemDef.name = "<col=E3E3E3>COL kiteshield";
				itemDef.modelID = 65506;
				itemDef.maleEquip1 = 65507;
				itemDef.femaleEquip1 = 65507;
				def = ItemDefinition.get(18509);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 8239113;
				


				break;
			case 18009:
				itemDef.name = "<col=E3E3E3>COL boots";
				itemDef.modelID = 65508;
				itemDef.maleEquip1 = 65508;
				itemDef.femaleEquip1 = 65508;
				def = ItemDefinition.get(11732);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 8239113;
				

				break;
			case 18011:
				itemDef.name = "<col=E3E3E3>COL whip";
				itemDef.modelID = 65509;
				itemDef.maleEquip1 = 65510;
				itemDef.femaleEquip1 = 65510;
				def = ItemDefinition.get(4151);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 8239113;
				


				break;
			case 17616:
			case 17614:
			case 17606:
			case 17618:

				

				break;

			case 17620:
				itemDef.name = "Shadow kiteshield";
				itemDef.modelID = 65506;
				itemDef.maleEquip1 = 65507;
				itemDef.femaleEquip1 = 65507;
				def = ItemDefinition.get(18509);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				

				break;
			case 17622:
				itemDef.name = "Shadow boots";
				itemDef.modelID = 65508;
				itemDef.maleEquip1 = 65508;
				itemDef.femaleEquip1 = 65508;
				def = ItemDefinition.get(11732);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				

				break;
			case 17624:
				itemDef.name = "Shadow whip";
				itemDef.modelID = 65509;
				itemDef.maleEquip1 = 65510;
				itemDef.femaleEquip1 = 65510;
				def = ItemDefinition.get(4151);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				

				break;
			case 757:
				itemDef.name = "<col=5cc6cf>Starter Tasks Book";
				//	itemDef.rdc2 = 92942;
				break;
			case 882:
				itemDef.name = "Starter arrow";
				//	itemDef.rdc2 = 92942;
				break;
			case 17600:
				itemDef.name = "Titan staff";
				itemDef.modelID = 65486;
				itemDef.maleEquip1 = 65487;
				itemDef.femaleEquip1 = 65487;
				def = ItemDefinition.get(4158);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;

				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 222222;
				break;
			case 675:
				itemDef.name = "<col=b5f2b3>Indravox full helmet";
				def = ItemDefinition.get(10350);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 2324222;
				break;
			case 10350:
			case 10348:
			case 10346:
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 1000;
				break;
			case 14499:
			case 14497:
			case 14501:
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 10;
				break;

			case 3751:
				itemDef.copyItem(16054);
				itemDef.name = "Sagittarian coif";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 10;
				break;

			case 23410:
				itemDef.name = "Sagittarian coif";
				itemDef.actions = new String[]{null, null, null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 10;
				break;

			case 17193:
			case 17339:
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 10;
				break;
			case 702:
				itemDef.name = "<col=b5f2b3>Indravox platebody";
				def = ItemDefinition.get(10348);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = 20154;
				itemDef.femaleEquip1 = 20154;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 2324222;
				
				break;
			case 700:
				itemDef.name = "<col=b5f2b3>Indravox platelegs";
				def = ItemDefinition.get(10346);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 2324222;
				
				break;
			case 701:
				itemDef.name = "<col=b5f2b3>Indravox kiteshield";
				def = ItemDefinition.get(10352);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 2324222;
				
				break;
			case 17602:
				itemDef.name = "<col=b5f2b3>Indravox Cape";
				itemDef.modelID = 65488;
				itemDef.maleEquip1 = 65489;
				itemDef.femaleEquip1 = 65489;
				def = ItemDefinition.get(18509);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				
				itemDef.rdc2 = 2324222;
				break;
			case 17604:
				itemDef.name = "Champion Cape";
				itemDef.modelID = 65490;
				itemDef.maleEquip1 = 65491;
				itemDef.femaleEquip1 = 65491;
				def = ItemDefinition.get(18509);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 7733;
				break;

			case 4555:
				itemDef.name = "Riddler's helm";
				itemDef.modelID = 65354;
				itemDef.maleEquip1 = 65355;
				itemDef.femaleEquip1 = 65355;
				def = ItemDefinition.get(4882);
				itemDef.modelOffsetX = def.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 57; // the texture that it currently has
				itemDef.newColors[0] = 68; //
				break;

			case 4556:
				itemDef.name = "Riddler's body";
				itemDef.modelID = 65356;
				itemDef.maleEquip1 = 65357;
				itemDef.femaleEquip1 = 65357;
				def = ItemDefinition.get(4894);
				itemDef.modelOffsetX = def.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				// itemDef.rdc2 = 23945;
				//itemDef.rdc2 = 34737;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 57; // the texture that it currently has
				itemDef.newColors[0] = 68; //
				break;

			case 4557:
				itemDef.name = "Riddler's legs";
				itemDef.modelID = 65358;
				itemDef.maleEquip1 = 65359;
				itemDef.femaleEquip1 = 65359;
				def = ItemDefinition.get(4900);
				itemDef.modelOffsetX = def.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 57; // the texture that it currently has
				itemDef.newColors[0] = 68; //
				//	itemDef.rdc2 = 34737;
				break;
			case 4558:
				itemDef.name = "Riddler's Offhand";
				itemDef.modelID = 65409;
				itemDef.maleEquip1 = 65411;
				itemDef.femaleEquip1 = 65411;
				def = ItemDefinition.get(19146);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[1] = "Wear";
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{55};
				itemDef.newColors = new int[]{68};
				break;
			case 7014:
				itemDef.name = "Saggy's whacker";
				itemDef.modelID = 65341;
				itemDef.maleEquip1 = 65342;
				itemDef.femaleEquip1 = 65342;
				def = ItemDefinition.get(20551);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[1] = "Wear";
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{60, 62};
				itemDef.newColors = new int[]{70, 70};
				break;
			case 9360:
				itemDef.name = "Master void helm (ranged)";

				itemDef.modelID = 65385;
				itemDef.maleEquip1 = 65386;
				itemDef.femaleEquip1 = 65386;
				itemDef2 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemDef2.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemDef2.modelOffsetY;
				itemDef.modelZoom = itemDef2.modelZoom;
				itemDef.rotationY = itemDef2.rotationY;
				itemDef.rotationX = itemDef2.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{73};
				break;
			case 9361:
				itemDef.name = "Master void body";
				itemDef.modelID = 65387;
				itemDef.maleEquip1 = 65388;
				itemDef.femaleEquip1 = 65388;
				itemDef2 = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemDef2.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemDef2.modelOffsetY;
				itemDef.modelZoom = itemDef2.modelZoom;
				itemDef.rotationY = itemDef2.rotationY;
				itemDef.rotationX = itemDef2.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{73};

				break;
			case 9362:
				itemDef.name = "Master Void legs";

				itemDef.modelID = 65389;
				itemDef.maleEquip1 = 65390;
				itemDef.femaleEquip1 = 65390;
				def = ItemDefinition.get(4900);
				itemDef.modelOffsetX = def.modelOffsetX;
//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{73};

				break;
			case 9363:
				itemDef.name = "Master void helm (melee)";
				itemDef.modelID = 65130;
				itemDef.maleEquip1 = 65131;
				itemDef.femaleEquip1 = 65131;
				def = ItemDefinition.get(4882);
				itemDef.modelOffsetX = def.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 73;
				itemDef.stackable = false;
				break;
			case 9364:
				itemDef.name = "Master void helm (magic)";
				itemDef.modelID = 65112;
				itemDef.maleEquip1 = 65113;
				itemDef.femaleEquip1 = 65113;
				def = ItemDefinition.get(4882);
				itemDef.modelOffsetX = def.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 73; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 15922:
				itemDef.name = "Ripper helm";
				itemDef.modelID = 65450;
				itemDef.maleEquip1 = 65451;
				itemDef.femaleEquip1 = 65451;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 57; // the texture that it currently has
				itemDef.newColors[0] = 126; // the new texture u want it to have
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 16021:
				itemDef.name = "Ripper body";
				itemDef.modelID = 65452;
				itemDef.maleEquip1 = 65453;
				itemDef.femaleEquip1 = 65453;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 57; // the texture that it currently has
				itemDef.newColors[0] = 126; // the new texture u want it to have
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 15933:
				itemDef.name = "Ripper legs";
				itemDef.modelID = 65454;
				itemDef.maleEquip1 = 65455;
				itemDef.femaleEquip1 = 65455;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 57; // the texture that it currently has
				itemDef.newColors[0] = 126; // the new texture u want it to have
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 7885:
				itemDef.name = "Mac's blade";
				ItemDefinition trinity = ItemDefinition.get(20538);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = 65428;
				itemDef.femaleEquip1 = 65429;
				itemDef.maleEquip1 = 65429;
				itemDef.modelOffsetX = trinity.modelOffsetX;
				//itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{52};
				break;
			case 20551:
				itemDef.modelID = 65341;
				itemDef.maleEquip1 = 65342;
				itemDef.femaleEquip1 = 65342;
				itemDef.name = "Riddler's Glaive";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.oldColors = new int[]{60, 62};
				itemDef.newColors = new int[]{68, 68};
				//itemDef.rdc2 = 7007;
				break;
			case 20558:
				itemDef.modelID = 65341;
				itemDef.maleEquip1 = 65342;
				itemDef.femaleEquip1 = 65342;
				itemDef.name = "Aids spreader (glaive)";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.oldColors = new int[]{60, 62};
				itemDef.newColors = new int[]{57, 57};
				//itemDef.rdc2 = 7007;
				break;
			case 20559:
				itemDef.name = "Rabies spreader (offhand)";
				itemDef.modelID = 65409;
				itemDef.maleEquip1 = 65411;
				itemDef.femaleEquip1 = 65411;
				def = ItemDefinition.get(19146);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[1] = "Wear";
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{55};
				itemDef.newColors = new int[]{57};
				break;
			case 4017:
				itemDef.modelID = 65341;
				itemDef.maleEquip1 = 65342;
				itemDef.femaleEquip1 = 65342;
				itemDef.name = "<shad=1><col=00e673>Extreme Glaive";
				trinity = ItemDefinition.get(20551);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.oldColors = new int[]{60, 62};
				itemDef.newColors = new int[]{59, 59};
				//itemDef.rdc2 = 7007;
				break;
			case 4018:
				itemDef.name = "<shad=1><col=00e673>Extreme Offhand";
				itemDef.modelID = 65409;
				itemDef.maleEquip1 = 65411;
				itemDef.femaleEquip1 = 65411;
				trinity = ItemDefinition.get(19146);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[1] = "Wear";
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{55};
				itemDef.newColors = new int[]{59};
				break;
			case 3260:
				itemDef.name = "@red@Supreme Blade";
				ItemDefinition trinity2 = ItemDefinition.get(20538);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = 65428;
				itemDef.femaleEquip1 = 65429;
				itemDef.maleEquip1 = 65429;
				itemDef.modelOffsetX = trinity2.modelOffsetX;
				//itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = trinity2.modelOffsetY;
				itemDef.modelZoom = trinity2.modelZoom;
				itemDef.rotationY = trinity2.rotationY;
				itemDef.rotationX = trinity2.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{52};
				break;
			case 5432:
				itemDef.modelID = 65341;
				itemDef.maleEquip1 = 65342;
				itemDef.femaleEquip1 = 65342;
				itemDef.name = "Maddest glaive";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.oldColors = new int[]{60, 62};
				itemDef.newColors = new int[]{71, 71};
				//itemDef.rdc2 = 7007;
				break;
			case 522:
				itemDef.name = "Saggy's broomstick";
				itemDef.modelID = 65127;
				itemDef.maleEquip1 = 65128;
				itemDef.femaleEquip1 = 65128;
				def = ItemDefinition.get(1321);
				itemDef.modelOffsetX = def.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 70;
				itemDef.stackable = false;
				break;
			case 523:// tetsu
				itemDef.name = "Saggy helm";
				itemDef.modelID = 65078;
				itemDef.maleEquip1 = 65079;
				itemDef.femaleEquip1 = 65079;
				def = ItemDefinition.get(4882);
				itemDef.modelOffsetX = def.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				//	itemDef.rdc2 = 9999;
				itemDef.oldColors = new int[]{55};
				itemDef.newColors = new int[]{70};
				break;
			case 524:// tetsu
				itemDef.name = "Saggy body";
				itemDef.modelID = 65080;
				itemDef.maleEquip1 = 65081;
				itemDef.femaleEquip1 = 65081;
				def = ItemDefinition.get(4894);
				itemDef.modelOffsetX = def.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				//itemDef.rdc2 = 9999;
				itemDef.oldColors = new int[]{55};
				itemDef.newColors = new int[]{70};
				break;
			case 525:// tetsu
				itemDef.name = "Saggy legs";
				itemDef.modelID = 65082;
				itemDef.maleEquip1 = 65083;
				itemDef.femaleEquip1 = 65083;
				def = ItemDefinition.get(4900);
				itemDef.modelOffsetX = def.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.oldColors = new int[]{55};
				itemDef.newColors = new int[]{70};
				//	itemDef.rdc2 = 9999;
				break;


			case 666:
			itemDef.name = "Head of Shadows";
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 80;
			itemDef.modelZoom = 773;
			itemDef.rotationY = 0;
			itemDef.rotationX = 0;
			itemDef.modelID = 17203;
			itemDef.maleEquip1 = 17203;
			itemDef.femaleEquip1 = 17203;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.stackable = false;
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[4] = "Drop";
			itemDef.actions[3] = "<col=C3C0B2>Dissolve";
			itemDef.stackable = false;
				break;
				
			case 15424:
				itemDef.copyItem(4712);
				itemDef.name = "Shadow robe top";
				itemDef.modelID = 17204;
				itemDef.maleEquip1 = 17205;
				itemDef.femaleEquip1 = 17205;
				itemDef.modelZoom = 1500;
				break;
				
			case 674:
				itemDef.copyItem(4714);
				itemDef.name = "Shadow bottoms";
				itemDef.modelID = 17206;
				itemDef.maleEquip1 = 17207;
				itemDef.femaleEquip1 = 17207;
				break;
				
			case 669:
				itemDef.name = "Grime wings ";
				def = ItemDefinition.get(4411);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 9;
				
				break;
			case 671:
				itemDef.name = "Grime HandCannon ";
				def = ItemDefinition.get(15241);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 9;
				
				break;
			case 672:
				itemDef.name = "Grime gloves";
				def = ItemDefinition.get(14602);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 9;
				break;

			case 673:
				itemDef.name = "Grime boots";
				def = ItemDefinition.get(14605);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 9;
				break;
			case 14405:
			case 14395:
			case 14415:
				itemDef.name = itemDef.name.replace("class 3", "Grime");
				itemDef.name = itemDef.name.replace("(b)", "");
				itemDef.rdc2 = 9;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 677:
				itemDef.name = "Lord helmet";
				def = ItemDefinition.get(19471);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 9183;
				
				break;
			case 678:
				itemDef.name = "Lord body";
				def = ItemDefinition.get(19470);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 9183;
				
				break;
			case 679:
				itemDef.name = "Lord legs";
				def = ItemDefinition.get(19469);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 9183;
				
				break;
			case 676:
				itemDef.name = "Lord longsword";
				def = ItemDefinition.get(22075);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 9183;
				
				break;
			case 681:
				itemDef.name = "lord of the ring";
				def = ItemDefinition.get(15398);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 9183;
				
				break;
			case 18363:
				itemDef.name = "Lords deflector";
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 9183;
				
				break;
			case 734:
				itemDef.name = "<col=b3b4f2>Big Shadow Maul";
				def = ItemDefinition.get(17710);
				itemDef.modelID = def.modelID;
				itemDef.maleEquip1 = def.maleEquip1;
				itemDef.femaleEquip1 = def.femaleEquip1;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 49494;
				
				break;
			case 19149:
				itemDef.name = "Swoodo bow";
				itemDef.actions = new String[5];
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;
				
			case 12930:
				itemDef.name = "Swoodo Shield";
				itemDef.actions = new String[5];
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;

			case 19682:
				itemDef.name = "Loot device";
				itemDef.actions = new String[]{null, null, null, null, "Drop"};
				//itemDef.rdc2 = 3222;
				break;
			case 8830:
				itemDef.name = "Penguin Cape";
				trinity = ItemDefinition.get(6570);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.modelID = 65447;
				itemDef.maleEquip1 = 65446;
				itemDef.femaleEquip1 = 65446;
				itemDef.actions = trinity.actions;
				itemDef.newColors = new int[2]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[2]; // same here
				itemDef.oldColors[0] = 54; // the texture that it currently has
				itemDef.newColors[0] = 63;
				itemDef.oldColors[1] = 65; // the texture that it currently has
				itemDef.newColors[1] = 63; // the new texture u want it to have
				itemDef.stackable = false;
				itemDef.value = 1;
				break;
			case 8812:
				itemDef.name = "Levincia gloves";
				trinity = ItemDefinition.get(7671);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = 250;
				itemDef.modelZoom = 600;
				itemDef.rotationY = 260;
				itemDef.rotationX = trinity.rotationX;
				itemDef.modelID = 65360;
				itemDef.femaleEquip1 = 65361;
				itemDef.maleEquip1 = 65361;
				itemDef.actions = trinity.actions;

				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.rdc2 = 24252;
				break;


			case 18885:
				itemDef.name = "@cya@Colossal gloves";
				trinity = ItemDefinition.get(7671);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.modelID = 65360;
				itemDef.femaleEquip1 = 65361;
				itemDef.maleEquip1 = 65361;
				itemDef.actions = trinity.actions;
				itemDef.rdc2 = 42812;
				break;

			case 8819:
				itemDef.name = "Bulwark gloves";
				trinity = ItemDefinition.get(7671);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.modelID = 65360;
				itemDef.femaleEquip1 = 65361;
				itemDef.maleEquip1 = 65361;
				itemDef.actions = trinity.actions;
				//	itemDef.rdc2 = 47333;
				

				break;
			case 8820:
				itemDef.name = "Bulwark boots";
				trinity = ItemDefinition.get(20450);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.modelID = 65362;
				itemDef.femaleEquip1 = 65362;
				itemDef.maleEquip1 = 65362;
				itemDef.actions = trinity.actions;
				
				break;
			case 8831:
				itemDef.name = "Penguin Ring";
				trinity = ItemDefinition.get(15401);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.actions = trinity.actions;

				itemDef.modelID = 65303;
				itemDef.maleEquip1 = 65303;
				itemDef.femaleEquip1 = 65303;
				itemDef.newColors = new int[1]; // same here
				itemDef.oldColors = new int[1];
				itemDef.oldColors[0] = 51; // the texture that it currently has
				itemDef.newColors[0] = 63;
				break;
			case 8832:
				itemDef.name = "Staff Ring";
				trinity = ItemDefinition.get(15401);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.actions = trinity.actions;

				itemDef.modelID = 65303;
				itemDef.maleEquip1 = 65303;
				itemDef.femaleEquip1 = 65303;
				itemDef.newColors = new int[1]; // same here
				itemDef.oldColors = new int[1];
				itemDef.oldColors[0] = 51; // the texture that it currently has
				itemDef.newColors[0] = 64;
				break;
			case 8800:
				itemDef.name = "Shikruu helm";
				itemDef.modelID = 16813;
				itemDef.maleEquip1 = 16814;
				itemDef.femaleEquip1 = 16814;
				trinity = ItemDefinition.get(4882);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{123};
				//	itemDef.rdc2 = 2353627;
				
				break;
			case 8801:
				itemDef.name = "Shikruu body";
				itemDef.modelID = 16815;
				itemDef.maleEquip1 = 16809;
				itemDef.femaleEquip1 = 16809;
				trinity = ItemDefinition.get(4894);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{123};
				
				//	itemDef.rdc2 = 2353627;
				break;

			case 8802:
				itemDef.name = "Shikruu legs";
				itemDef.modelID = 16799;
				itemDef.maleEquip1 = 16798;
				itemDef.femaleEquip1 = 16798;
				trinity = ItemDefinition.get(4900);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{123};
				
				//	itemDef.rdc2 = 2353627;
				break;
			case 1153:
				itemDef.copyItem(4977);
				itemDef.name = "Starter helm";
				itemDef.modelZoom = 890;
				itemDef.modelOffsetX = -2;
				itemDef.modelID = 99886;
				itemDef.maleEquip1 = 99885;
				itemDef.femaleEquip1 = 99885;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;
			case 1115:
				itemDef.copyItem(4712);
				itemDef.name = "Starter body";
				itemDef.modelZoom = 1500;
				itemDef.modelID = 99884;
				itemDef.maleEquip1 = 99881;
				itemDef.femaleEquip1 = 99881;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;
			case 1067:
				itemDef.copyItem(4714);
				itemDef.name = "Starter legs";
				itemDef.modelZoom = 1800;
				itemDef.modelID = 99883;
				itemDef.maleEquip1 = 99882;
				itemDef.femaleEquip1 = 99882;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				break;
			case 8323:
				itemDef.name = "T5 Magic helm";
				itemDef.modelID = 100084;
				itemDef.maleEquip1 = 100085;
				itemDef.femaleEquip1 = 100085;
				trinity = ItemDefinition.get(4882);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{56};
				itemDef.newColors = new int[]{79};
				//itemDef.rdc2 = 46880;
				break;
			case 8324:
				itemDef.name = "T5 Magic body";
				itemDef.modelID = 100093;
				itemDef.maleEquip1 = 100094;
				itemDef.femaleEquip1 = 100094;
				trinity = ItemDefinition.get(4894);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{56};
				itemDef.newColors = new int[]{79};
				//itemDef.rdc2 = 46880;
				break;

			case 8325:
				itemDef.name = "T5 Magic legs";
				itemDef.modelID = 100091;
				itemDef.maleEquip1 = 100092;
				itemDef.femaleEquip1 = 100092;
				trinity = ItemDefinition.get(4900);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{56};
				itemDef.newColors = new int[]{79};
				//itemDef.rdc2 = 46880;
				break;
				
			case 8326:
				itemDef.name = "T5 Melee helm";
				itemDef.modelID = 100105;
				itemDef.maleEquip1 = 100106;
				itemDef.femaleEquip1 = 100106;
				trinity = ItemDefinition.get(4882);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = 500;
				itemDef.rotationY = 0;
				itemDef.rotationX = 0;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				// itemDef.rdc2 = 34333;
				break;
				
			case 8327:
				itemDef.name = "T5 Melee body";
				itemDef.modelID = 100098;
				itemDef.maleEquip1 = 100099;
				itemDef.femaleEquip1 = 100099;
				trinity = ItemDefinition.get(4894);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				// itemDef.rdc2 = 34333;
				break;
			
			case 8328:
				itemDef.name = "T5 Melee legs";
				itemDef.modelID = 100107;
				itemDef.maleEquip1 = 100108;
				itemDef.femaleEquip1 = 100108;
				trinity = ItemDefinition.get(4900);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				 //itemDef.rdc2 = 34333;
				break;
				
				case 23184:
				itemDef.copyItem(4708);
				itemDef.name = "Thresh helm";
				itemDef.modelZoom = 1000;
				itemDef.modelID = 15201;
				itemDef.maleEquip1 = 15202;
				itemDef.femaleEquip1 = 15202;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
				case 23185:
				itemDef.copyItem(4712);
				itemDef.name = "Thresh body";
				itemDef.modelZoom = 1500;
				itemDef.modelID = 15203;
				itemDef.maleEquip1 = 15204;
				itemDef.femaleEquip1 = 15204;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 23186:
				itemDef.copyItem(4714);
				itemDef.name = "Thresh legs";
				itemDef.modelZoom = 1800;
				itemDef.modelID = 15205;
				itemDef.maleEquip1 = 15264;
				itemDef.femaleEquip1 = 15264;	
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
			case 23187:
				itemDef.name = "Thresh gloves";
				def = ItemDefinition.get(14602);
				itemDef.modelID = 15272;
				itemDef.maleEquip1 = 15278;
				itemDef.femaleEquip1 = 15278;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 23188:
				itemDef.name = "Thresh Boots";
				itemDef.modelID = 15279;
				itemDef.maleEquip1 = 15279;
				itemDef.femaleEquip1 = 15279;
				def = ItemDefinition.get(3791);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 23189:
				itemDef.name = "Thresh Scythe";
				itemDef.modelID = 15284;
				itemDef.maleEquip1 = 15285;
				itemDef.femaleEquip1 = 15285;
				def = ItemDefinition.get(1333);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 23190:
				itemDef.name = "Thresh Offhand";
				itemDef.modelID = 15286;
				itemDef.maleEquip1 = 15287;
				itemDef.femaleEquip1 = 15287;
				def = ItemDefinition.get(19146);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
				case 23191:
				itemDef.copyItem(4708);
				itemDef.name = "Wukong helm";
				itemDef.modelZoom = 1000;
				itemDef.modelID = 15288;
				itemDef.maleEquip1 = 15289;
				itemDef.femaleEquip1 = 15289;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
				case 23192:
				itemDef.copyItem(4712);
				itemDef.name = "Wukong body";
				itemDef.modelZoom = 1500;
				itemDef.modelID = 15291;
				itemDef.maleEquip1 = 15322;
				itemDef.femaleEquip1 = 15322;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 23193:
				itemDef.copyItem(4714);
				itemDef.name = "Wukong legs";
				itemDef.modelZoom = 1800;
				itemDef.modelID = 15323;
				itemDef.maleEquip1 = 15324;
				itemDef.femaleEquip1 = 15324;	
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 23194:
				itemDef.name = "Wukong gloves";
				def = ItemDefinition.get(14602);
				itemDef.modelID = 15325;
				itemDef.maleEquip1 = 15326;
				itemDef.femaleEquip1 = 15326;
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;
				
			case 23195:
				itemDef.name = "Wukong Boots";
				itemDef.modelID = 15327;
				itemDef.maleEquip1 = 15327;
				itemDef.femaleEquip1 = 15327;
				def = ItemDefinition.get(3791);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 23196:
				itemDef.name = "Wukong Staff";
				itemDef.modelID = 15328;
				itemDef.maleEquip1 = 15329;
				itemDef.femaleEquip1 = 15329;
				def = ItemDefinition.get(1419);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;

				
			case 9250:
				itemDef.name = "Yogifus helm";
				itemDef.modelID = 65462;
				itemDef.maleEquip1 = 65463;
				itemDef.femaleEquip1 = 65463;
				trinity = ItemDefinition.get(4882);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{56};
				itemDef.newColors = new int[]{67};
				//	itemDef.rdc2 = 2353627;
				break;
			case 9251:
				itemDef.name = "Yogifus body";
				itemDef.modelID = 65464;
				itemDef.maleEquip1 = 65465;
				itemDef.femaleEquip1 = 65465;
				trinity = ItemDefinition.get(4894);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{56};
				itemDef.newColors = new int[]{67};
				//	itemDef.rdc2 = 2353627;
				break;

			case 9252:
				itemDef.name = "Yogifus legs";
				itemDef.modelID = 65466;
				itemDef.maleEquip1 = 65467;
				itemDef.femaleEquip1 = 65467;
				trinity = ItemDefinition.get(4900);
				itemDef.modelOffsetX = trinity.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = trinity.modelOffsetY;
				itemDef.modelZoom = trinity.modelZoom;
				itemDef.rotationY = trinity.rotationY;
				itemDef.rotationX = trinity.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{56};
				itemDef.newColors = new int[]{67};
				//	itemDef.rdc2 = 2353627;
				break;
			case 9253:
				itemDef.name = "Yogi's picnic basket";
				ItemDefinition itemdefyogipic = ItemDefinition.get(20538);
				// itemDef.modelID = itemDef2.modelID;
				itemDef.modelID = 65428;
				itemDef.femaleEquip1 = 65429;
				itemDef.maleEquip1 = 65429;
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.stackable = false;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				//itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{67};
				//itemDef.rdc2 = 222222;
				break;
			case 9254:
				itemDef.name = "Madman helm";
				itemDef.modelID = 65130;
				itemDef.maleEquip1 = 65131;
				itemDef.femaleEquip1 = 65131;
				itemdefyogipic = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 71;
				itemDef.stackable = false;
				break;
			case 9255:
				itemDef.name = "Madman platebody";
				itemDef.modelID = 65132;
				itemDef.maleEquip1 = 65133;
				itemDef.femaleEquip1 = 65133;
				itemdefyogipic = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 71;
				itemDef.stackable = false;
				break;
			case 9256:
				itemDef.name = "Madman legs";
				itemDef.modelID = 65134;
				itemDef.maleEquip1 = 65135;
				itemDef.femaleEquip1 = 65135;
				itemdefyogipic = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 71;
				itemDef.stackable = false;
				break;
			case 9257:
				itemDef.name = "Epic Defender";
				itemDef.modelID = 65127;
				itemDef.maleEquip1 = 65128;
				itemDef.femaleEquip1 = 65128;
				itemdefyogipic = ItemDefinition.get(1321);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 61;
				itemDef.stackable = false;
				break;
			case 9258:
				itemDef.name = "Yogifus Cape";
				itemdefyogipic = ItemDefinition.get(6570);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = 65104;
				itemDef.maleEquip1 = 65105;
				itemDef.femaleEquip1 = 65105;
				itemDef.actions = itemdefyogipic.actions;
				itemDef.newColors = new int[2]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[2]; // same here
				itemDef.oldColors[0] = 52; // the texture that it currently has
				itemDef.newColors[0] = 67;
				itemDef.oldColors[1] = 920; // the texture that it currently has
				itemDef.newColors[1] = 50; // the new texture u want it to have
				itemDef.stackable = false;
				itemDef.value = 1;
				break;
			case 8330:
				itemDef.name = "T5 Range helm";
				itemDef.modelID = 100117;
				itemDef.maleEquip1 = 100118;
				itemDef.femaleEquip1 = 100118;
				itemdefyogipic = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{56};
				itemDef.newColors = new int[]{68};

				 //itemDef.rdc2 = 34343;
				break;
			case 8331:
				itemDef.name = "T5 Range body";
				itemDef.modelID = 100119;
				itemDef.maleEquip1 = 100115;
				itemDef.femaleEquip1 = 100115;
				itemdefyogipic = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{56};
				itemDef.newColors = new int[]{68};

				 //itemDef.rdc2 = 34343;
				break;

			case 8332:
				itemDef.name = "T5 Range legs";
				itemDef.modelID = 100120;
				itemDef.maleEquip1 = 100121;
				itemDef.femaleEquip1 = 100121;
				itemdefyogipic = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{56};
				itemDef.newColors = new int[]{68};

				 //itemDef.rdc2 = 34343;
				break;
			case 8806:
				itemDef.name = "Ganopurp visor";
				itemDef.modelID = 65371;
				itemDef.maleEquip1 = 65372;
				itemDef.femaleEquip1 = 65372;
				itemdefyogipic = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{59};
				itemDef.newColors = new int[]{131};
				//	itemDef.rdc2 = 2353627;
				
				break;
			case 8807:
				itemDef.name = "Ganopurp poncho";
				itemDef.modelID = 65373;
				itemDef.maleEquip1 = 65374;
				itemDef.femaleEquip1 = 65374;
				itemdefyogipic = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{59};
				itemDef.newColors = new int[]{131};
				
				//	itemDef.rdc2 = 2353627;
				break;

			case 8808:
				itemDef.name = "Ganopurp legging";
				itemDef.modelID = 65375;
				itemDef.maleEquip1 = 65376;
				itemDef.femaleEquip1 = 65376;
				itemdefyogipic = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{59};
				itemDef.newColors = new int[]{131};
				
				//	itemDef.rdc2 = 2353627;
				break;
			case 8803:
				itemDef.name = "Sorrow horn-coif";
				itemDef.modelID = 65377;
				itemDef.maleEquip1 = 65378;
				itemDef.femaleEquip1 = 65378;
				itemdefyogipic = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				//	itemDef.rdc2 = 2353627;
				itemDef.oldColors = new int[]{55};
				itemDef.newColors = new int[]{78};
				
				break;
			case 8804:
				itemDef.name = "Sorrow body";
				itemDef.modelID = 65379;
				itemDef.maleEquip1 = 65380;
				itemDef.femaleEquip1 = 65380;
				itemdefyogipic = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{78};
				//	itemDef.rdc2 = 2353627;
				
				break;

			case 8805:
				itemDef.name = "Sorrow chaps";
				itemDef.modelID = 65381;
				itemDef.maleEquip1 = 65382;
				itemDef.femaleEquip1 = 65382;
				itemdefyogipic = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = 1800;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{78};
				//	itemDef.rdc2 = 2353627;
				
				break;
			case 8821:
				itemDef.name = "Shikruu wings";
				itemDef.modelID = 65369;
				itemDef.maleEquip1 = 65370;
				itemDef.femaleEquip1 = 65370;
				itemdefyogipic = ItemDefinition.get(18509);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{40};
				itemDef.newColors = new int[]{123};
				//	itemDef.rdc2 = 2353627;
				break;

			case 8822:
				itemDef.name = "Loyalty helm";
				itemDef.modelID = 65385;
				itemDef.maleEquip1 = 65386;
				itemDef.femaleEquip1 = 65386;
				itemdefyogipic = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{67};
				//	itemDef.rdc2 = 2353627;
				break;
			case 8823:
				itemDef.name = "Loyalty body";
				itemDef.modelID = 65387;
				itemDef.maleEquip1 = 65388;
				itemDef.femaleEquip1 = 65388;
				itemdefyogipic = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{67};
				//	itemDef.rdc2 = 2353627;
				break;

			case 8824:
				itemDef.name = "Loyalty legs";
				itemDef.modelID = 65389;
				itemDef.maleEquip1 = 65390;
				itemDef.femaleEquip1 = 65390;
				itemdefyogipic = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{67};
				//	itemDef.rdc2 = 2353627;
				break;
			case 8825:
				itemDef.name = "KBD helm";
				itemDef.modelID = 65391;
				itemDef.maleEquip1 = 65392;
				itemDef.femaleEquip1 = 65392;
				itemdefyogipic = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{76};
				//	itemDef.rdc2 = 2353627;
				break;
			case 8826:
				itemDef.name = "KBD body";
				itemDef.modelID = 65393;
				itemDef.maleEquip1 = 65394;
				itemDef.femaleEquip1 = 65394;
				itemdefyogipic = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{76};
				//	itemDef.rdc2 = 2353627;
				break;

			case 8827:
				itemDef.name = "KBD legs";
				itemDef.modelID = 65395;
				itemDef.maleEquip1 = 65396;
				itemDef.femaleEquip1 = 65396;
				itemdefyogipic = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{76};
				//	itemDef.rdc2 = 2353627;
				break;

			case 8860:
				itemDef.name = "Diabolical helm";
				itemDef.modelID = 65397;
				itemDef.maleEquip1 = 65398;
				itemDef.femaleEquip1 = 65398;
				itemdefyogipic = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = 900;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{55};
				itemDef.newColors = new int[]{71};
				
				break;
			case 8861:
				itemDef.name = "Diabolical body";
				itemDef.modelID = 65399;
				itemDef.maleEquip1 = 65400;
				itemDef.femaleEquip1 = 65400;
				itemdefyogipic = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = 1600;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{55};
				itemDef.newColors = new int[]{71};
				
				break;

			case 8862:
				itemDef.name = "Diabolical legs";
				itemDef.modelID = 65401;
				itemDef.maleEquip1 = 65402;
				itemDef.femaleEquip1 = 65402;
				itemdefyogipic = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = 1700;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{55};
				itemDef.newColors = new int[]{71};
				
				break;
			case 8857:
				itemDef.name = "Nebula helm";
				itemDef.modelID = 65391;
				itemDef.maleEquip1 = 65392;
				itemDef.femaleEquip1 = 65392;
				itemdefyogipic = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{61};
				//	itemDef.rdc2 = 2353627;
				break;
			case 8858:
				itemDef.name = "Nebula body";
				itemDef.modelID = 65393;
				itemDef.maleEquip1 = 65394;
				itemDef.femaleEquip1 = 65394;
				itemdefyogipic = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{61};
				//	itemDef.rdc2 = 2353627;
				break;

			case 8859:
				itemDef.name = "Nebula legs";
				itemDef.modelID = 65395;
				itemDef.maleEquip1 = 65396;
				itemDef.femaleEquip1 = 65396;
				itemdefyogipic = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{52};
				itemDef.newColors = new int[]{61};
				//	itemDef.rdc2 = 2353627;
				break;
			case 16835:
				itemDef.name = "Nebula whip";
				itemDef.modelID = 65141;
				itemDef.maleEquip1 = 65142;
				itemDef.femaleEquip1 = 65142;
				itemdefyogipic = ItemDefinition.get(13131);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 61; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 5154:
				itemDef.name = "Multiplier @cya@+100";
				itemdefyogipic = ItemDefinition.get(12845);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = itemdefyogipic.actions;
				itemDef.modelID = itemdefyogipic.modelID;
				break;
			case 5155:
				itemDef.name = "Multiplier @cya@+1000";
				itemdefyogipic = ItemDefinition.get(12845);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = itemdefyogipic.actions;
				itemDef.modelID = itemdefyogipic.modelID;
				break;

			case 5156:
				itemDef.name = "Multiplier @cya@+10000";
				itemdefyogipic = ItemDefinition.get(12845);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = itemdefyogipic.actions;
				itemDef.modelID = itemdefyogipic.modelID;
				break;

			case 5500:
				itemDef.name = "<img=15>Multiplier +1";
				itemdefyogipic = ItemDefinition.get(12845);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef2.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = itemdefyogipic.actions;
				itemDef.modelID = itemdefyogipic.modelID;
				itemDef.rdc2 = 292;
				break;

			case 2023:
				itemDef.name = "Terror Bones";
				itemDef.oldColors = new int[]{63};//old
				itemdefyogipic = ItemDefinition.get(526);
				itemDef.newColors = new int[]{40};//new
				itemDef.actions = itemdefyogipic.actions;
				itemDef.modelID = 65285;
				itemDef.modelZoom = 1500;
				break;

			case 2025:
				itemDef.name = "Demon Bones";
				itemDef.oldColors = new int[]{63};//old
				itemdefyogipic = ItemDefinition.get(526);
				itemDef.newColors = new int[]{53};//new
				itemDef.actions = itemdefyogipic.actions;
				itemDef.modelID = 65285;
				itemDef.modelZoom = 1500;
				break;

			case 2026:
				itemDef.name = "Special Bones";
				itemDef.oldColors = new int[]{63};//old
				itemdefyogipic = ItemDefinition.get(526);
				itemDef.newColors = new int[]{83};//new
				itemDef.actions = itemdefyogipic.actions;
				itemDef.modelID = 65285;
				itemDef.modelZoom = 1500;
				break;

			case 20481:
				itemDef.name = "Summoning charm box";
				itemdefyogipic = ItemDefinition.get(7630);
				itemDef.modelID = itemdefyogipic.modelID;
				itemDef.rdc2 = 23454;
				itemDef.actions = itemdefyogipic.actions;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				break;

			case 13172:
				itemDef.name = "Inferno cat mask";
				itemDef.rdc2 = 852661;
				break;

			case 13169:
				itemDef.name = "Brown sheep mask";
				itemDef.rdc2 = 3256;
				break;

			case 10721:
				itemDef.name = "Black frog mask";
				itemDef.rdc2 = 46234;
				break;

			case 19278:
				itemDef.name = "Golden unicorn mask";
				itemDef.rdc2 = 9924;
				break;

			case 9920:
				itemDef.name = "Haunted jack lantern mask";
				itemDef.rdc2 = 34563;//1242
				break;

			case 14824:
				itemDef.name = "Octo mask ";
				itemDef.rdc2 = 24242;
				break;

			case 14825:
				itemDef.name = "Ray mask";
				itemDef.rdc2 = 24242;
				break;

			case 14826:
				itemDef.name = "Manta mask";
				itemDef.rdc2 = 24242;
				break;

			case 8809:
				itemDef.name = "Ganopurp staff";
				itemDef.modelID = 65383;
				itemDef.maleEquip1 = 65384;
				itemDef.femaleEquip1 = 65384;
				itemdefyogipic = ItemDefinition.get(19146);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = 2700;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[5];
				itemDef.oldColors = new int[]{59};
				itemDef.newColors = new int[]{54};
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[1] = "Wear";
				itemDef.stackable = false;
				break;

			case 15830:
				itemDef.name = "Diabolical boots";
				itemDef.modelID = 65226;
				itemDef.maleEquip1 = 65226;
				itemDef.femaleEquip1 = 65226;
				itemdefyogipic = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 71; // the new texture u want it to have
				itemDef.stackable = false;
				break;
				
			case 8834:
				itemDef.name = "Diabolical Reaper";
				itemDef.modelID = 65409;
				itemDef.maleEquip1 = 65410;
				itemDef.femaleEquip1 = 65410;
				itemdefyogipic = ItemDefinition.get(19146);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[1] = "Wear";
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{55};
				itemDef.newColors = new int[]{71};
				break;
				
			case 8835:
				itemDef.name = "Diabolical Offhand";
				itemDef.modelID = 65409;
				itemDef.maleEquip1 = 65411;
				itemDef.femaleEquip1 = 65411;
				itemdefyogipic = ItemDefinition.get(19146);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.actions[1] = "Wear";
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{55};
				itemDef.newColors = new int[]{71};
				break;

			case 8810:
				itemdefyogipic = ItemDefinition.get(12634);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = 16835;
				itemDef.maleEquip1 = 16833;
				itemDef.femaleEquip1 = 16833;
				itemDef.name = "<col=7f39f2>Levincia Wings";
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 100; // the texture that it currently has
				itemDef.newColors[0] = 71; //
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 11195:
				itemDef.name = "<col=39383a>Shadow Necklace";
				itemDef.rdc2 = 7262;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				break;

			case 8813:
				itemDef.name = "Shukarhazh helm";
				itemDef.modelID = 65272;
				itemDef.maleEquip1 = 65273;
				itemDef.femaleEquip1 = 65273;
				itemdefyogipic = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 452;
				break;

			case 8814:
				itemDef.name = "Shukarhazh body";
				itemDef.modelID = 65274;
				itemDef.maleEquip1 = 65275;
				itemDef.femaleEquip1 = 65275;
				itemdefyogipic = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				
				itemDef.rdc2 = 452;
				break;
			case 8815:
				itemDef.name = "Shukarhazh legs";
				itemDef.modelID = 65276;
				itemDef.maleEquip1 = 65277;
				itemDef.femaleEquip1 = 65277;
				itemdefyogipic = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				

				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				
				itemDef.rdc2 = 452;
				break;
			case 8816:
				itemDef.name = "Bulwark helm";
				itemDef.modelID = 65354;
				itemDef.maleEquip1 = 65355;
				itemDef.femaleEquip1 = 65355;
				itemdefyogipic = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 57; // the texture that it currently has
				itemDef.newColors[0] = 65; //
				
				// itemDef.rdc2 = 23945;
				//	itemDef.rdc2 = 34737;
				break;
			case 16691:
				itemDef.copyItem(4977);
				itemDef.name = "Ironman full helm";
				itemDef.modelID = 80047;
				itemDef.modelOffsetX = 3;
				itemDef.maleEquip1 = 80048;
				itemDef.femaleEquip1 = 80048;
				break;
			case 17239:
				itemDef.name = "Ironman platebody";
				itemDef.modelID = 80051;
				itemDef.maleEquip1 = 80052;
				itemDef.femaleEquip1 = 80052;
				break;
			case 16669:
				itemDef.name = "Ironman platelegs";
				itemDef.modelID = 80049;
				itemDef.maleEquip1 = 80050;
				itemDef.femaleEquip1 = 80050;

				break;
			case 4977:
				itemDef.name = "Ult. Ironman full helm";
				itemDef.modelID = 65440;
				itemDef.maleEquip1 = 65441;
				itemDef.femaleEquip1 = 65441;
				itemDef.rdc2 = 500;
				break;
			case 4989:
				itemDef.name = "Ult. Ironman platebody";
				itemDef.modelID = 65442;
				itemDef.maleEquip1 = 65443;
				itemDef.anInt188 = -1;
				itemDef.femaleEquip1 = 65443;
				itemDef.rdc2 = 500;
				break;
			case 4995:
				itemDef.name = "Ult. Ironman platelegs";
				itemDef.modelID = 65444;
				itemDef.maleEquip1 = 65445;
				itemDef.femaleEquip1 = 65445;
				itemDef.rdc2 = 500;
				break;
			case 15818:
				itemDef.name = "Oni Defender";
				itemDef.modelID = 65127;
				itemDef.maleEquip1 = 65128;
				itemDef.femaleEquip1 = 65128;
				itemdefyogipic = ItemDefinition.get(1321);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 12;
				
				itemDef.stackable = false;
				break;
			case 15888:
				itemDef.name = "Oni whip";
				itemDef.modelID = 65141;
				itemDef.maleEquip1 = 65142;
				itemDef.femaleEquip1 = 65142;
				itemdefyogipic = ItemDefinition.get(13131);
				itemDef.modelOffsetX = 10;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = 1;
				itemDef.modelZoom = 1000;
				itemDef.rotationY = 600;
				itemDef.rotationX = 120;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.oldColors = new int[]{59, 40};
				itemDef.newColors = new int[]{12, 74};
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 74; // the new texture u want it to hav
				
				itemDef.stackable = false;
				break;

			case 15924:
				itemDef.name = "Oni helm";
				itemDef.modelID = 65335;
				//itemDef.name = "Torva full helm";
				itemdefyogipic = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.maleEquip1 = 65336;
				itemDef.femaleEquip1 = 65336;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				// itemDef.actions[2] = "Check-charges";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				//itemDef.maleDialogue = 62729;
				//itemDef.femaleDialogue = 62729;
				itemDef.oldColors = new int[]{24, 40};
				itemDef.newColors = new int[]{105, 119};
				itemDef.stackable = false;
				
				break;
			case 16023:
				itemDef.name = "Oni platebody";
				itemDef.stackable = false;
				itemDef.modelID = 65337;
				//	itemDef.name = "Torva platebody";
				itemDef.modelZoom = 1506;
				itemDef.rotationY = 473;
				itemDef.rotationX = 2042;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = 0;
				itemDef.maleEquip1 = 65338;
				itemDef.femaleEquip1 = 65338;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				// itemDef.actions[2] = "Check-charges";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{24, 40};
				itemDef.newColors = new int[]{105, 119};
				
				break;
			case 15935:
				itemDef.name = "Oni legs";
				itemDef.stackable = false;
				itemDef.modelID = 65339;
				//		itemDef.name = "Torva platelegs";
				itemDef.modelZoom = 1740;
				itemDef.rotationY = 474;
				itemDef.rotationX = 2045;
				itemDef.modelOffsetX = 0;
				itemDef.modelOffsetY = -5;
				itemDef.maleEquip1 = 65340;
				itemDef.femaleEquip1 = 65340;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				// itemDef.actions[2] = "Check-charges";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				itemDef.oldColors = new int[]{24, 40};
				itemDef.newColors = new int[]{105, 119};
				
				break;

			case 16272:
				itemDef.name = "Oni boots";
				itemDef.modelID = 65138;
				itemDef.maleEquip1 = 65138;
				itemDef.femaleEquip1 = 65138;
				itemdefyogipic = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 12;
				itemDef.stackable = false;
				
				// itemDef.rdc2 = 8822;
				break;
			case 15591:
				itemDef.name = "xat full helm";
				itemDef.modelID = 65440;
				itemDef.maleEquip1 = 65441;
				itemDef.femaleEquip1 = 65441;
				itemdefyogipic = ItemDefinition.get(16691);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 121212;
				break;
			case 15592:
				itemDef.name = "xat platebody";
				itemDef.modelID = 65442;
				itemDef.maleEquip1 = 65443;
				itemDef.femaleEquip1 = 65443;
				itemdefyogipic = ItemDefinition.get(17239);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 121212;
				break;

			case 703:
				itemDef.name = "<col=a69eb6>Avatar titan helm";
				itemDef.modelID = 65354;
				itemDef.maleEquip1 = 65355;
				itemDef.femaleEquip1 = 65355;
				itemdefyogipic = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 57; // the texture that it currently has
				itemDef.newColors[0] = 71; //
				
				break;

			case 704:
				itemDef.name = "<col=a69eb6>Avatar titan body";
				itemDef.modelID = 65356;
				itemDef.maleEquip1 = 65357;
				itemDef.femaleEquip1 = 65357;
				itemdefyogipic = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				// itemDef.rdc2 = 23945;
				//itemDef.rdc2 = 34737;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 57; // the texture that it currently has
				itemDef.newColors[0] = 71; //
				
				break;

			case 705:
				itemDef.name = "<col=a69eb6>Avatar titan legs";
				itemDef.modelID = 65358;
				itemDef.maleEquip1 = 65359;
				itemDef.femaleEquip1 = 65359;
				itemdefyogipic = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 57; // the texture that it currently has
				itemDef.newColors[0] = 71; //
				
				//	itemDef.rdc2 = 34737;
				break;
			case 15915:
				itemDef.name = "@red@Dan's Limited Mask";
				itemDef.modelID = 65433;
				itemDef.maleEquip1 = 65434;
				itemDef.femaleEquip1 = 65434;
				break;
			case 15916:
				itemDef.name = "Crown of hearts";
				itemDef.modelID = 93514;
				itemDef.maleEquip1 = 93498;
				itemDef.femaleEquip1 = 93498;
				itemDef.maleWieldY = 5;
				itemDef.modelZoom = 658;
				itemDef.modelOffsetX = 1;
				itemDef.modelOffsetY = -4;
				itemDef.rotationX = 2031;
				itemDef.rotationY = 475;
				itemDef.rotationZ = 1;
				break;
			case 13555:
				itemDef.copyItem(6585);
				itemDef.name = "Valentine's Pendant";
				itemDef.modelID = 83812;
				itemDef.maleEquip1 = 83801;
				itemDef.femaleEquip1 = 83801;
				itemDef.maleWieldY = 5;
				itemDef.modelZoom = 464;
				itemDef.modelOffsetX = 3;
				itemDef.modelOffsetY = 54;
				itemDef.rotationX = 1964;
				itemDef.rotationY = 277;
				itemDef.rotationZ = 0;
				break;
			case 13556:
				itemDef.copyItem(17011);
				itemDef.name = "Staff of Adoration";
				itemDef.modelID = 93511;
				itemDef.maleEquip1 = 93501;
				itemDef.femaleEquip1 = 93501;
				itemDef.modelZoom = 1579;
				itemDef.modelOffsetX = -3;
				itemDef.modelOffsetY = 1;
				itemDef.rotationX = 48;
				itemDef.rotationY = 660;
				itemDef.rotationZ = 13;
				break;
			case 13557:
				itemDef.copyItem(4561);
				itemDef.name = "Valentine's Candy";
				itemDef.modelID = 93512;
				itemDef.modelZoom = 724;
				itemDef.modelOffsetX = 1;
				itemDef.modelOffsetY = 1;
				itemDef.rotationX = 1808;
				itemDef.rotationY = 308;
				itemDef.rotationZ = 308;
				break;
			case 13558:
				itemDef.copyItem(12160);
				itemDef.name = "@red@Easter Attachment";
				itemDef.rdc2 = 52966;
				itemDef.stackable = true;
				break;
			case 13800:
				itemDef.copyItem(15916);
				itemDef.name = "St. Patrick's Hat";
				itemDef.modelID = 98004;
				itemDef.maleEquip1 = 98005;
				itemDef.femaleEquip1 = 98005;
				itemDef.maleWieldY = 5;
				itemDef.modelZoom = 700;
				itemDef.modelOffsetX = 1;
				itemDef.modelOffsetY = -1;
				itemDef.rotationX = 2031;
				itemDef.rotationY = 0;
				itemDef.rotationZ = 1;
				break;
			case 13801:
				itemDef.copyItem(17011);
				itemDef.name = "St. Patrick's Sword";
				itemDef.modelID = 98002;
				itemDef.maleEquip1 = 98003;
				itemDef.femaleEquip1 = 98003;
				itemDef.modelZoom = 1579;
				itemDef.modelOffsetX = -3;
				itemDef.modelOffsetY = 1;
				itemDef.rotationX = 48;
				itemDef.rotationY = 660;
				itemDef.rotationZ = 13;
				break;
			case 13802:
				itemDef.copyItem(290);
				itemDef.name = "St. Patrick's Box";
				itemDef.oldColors = new int[]{2999, 926, 22410};
				itemDef.newColors = new int[]{19197, 20386, 20386};
				break;

			case 23322:
				itemDef.copyItem(290);
				itemDef.name = "Summer Box";
				itemDef.oldColors = new int[]{2999, 926, 22410};
				itemDef.newColors = new int[]{19197, 20386, 20386};
				break;

			case 13700:
				itemDef.copyItem(4977);
				itemDef.name = "Group Ironman full helm";
				itemDef.rdc2 = 91291;
				break;
			case 13701:
				itemDef.copyItem(4989);
				itemDef.name = "Group Ironman platebody";
				itemDef.rdc2 = 91291;
				break;
			case 13702:
				itemDef.copyItem(4995);
				itemDef.name = "Group Ironman platelegs";
				itemDef.rdc2 = 91291;
				break;

			case 16014:
				itemDef.name = "Burning top";
				itemDef.modelID = 65435;
				itemDef.maleEquip1 = 65436;
				itemDef.femaleEquip1 = 65436;
				break;
			case 15926:
				itemDef.name = "Burning legs";
				itemDef.modelID = 65437;
				itemDef.maleEquip1 = 65438;
				itemDef.femaleEquip1 = 65438;
				break;
			case 20592:
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.name = "Dan's Limited Mask";
				itemdefyogipic = ItemDefinition.get(15915);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = 65474;
				itemDef.maleEquip1 = 65475;
				itemDef.femaleEquip1 = 65475;
				itemDef.rdc2 = 29592;
				break;
			case 20593:
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.name = "Waterfall top";
				itemdefyogipic = ItemDefinition.get(16014);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = 65476;
				itemDef.maleEquip1 = 65477;
				itemDef.femaleEquip1 = 65477;
				itemDef.rdc2 = 29592;

				break;
			case 20594:
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemdefyogipic = ItemDefinition.get(15926);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.name = "Waterfall legs";
				itemDef.modelID = 65478;
				itemDef.maleEquip1 = 65479;
				itemDef.femaleEquip1 = 65479;
				itemDef.rdc2 = 29592;
				break;


			case 8817:
				itemDef.name = "Bulwark body";
				itemDef.modelID = 65356;
				itemDef.maleEquip1 = 65357;
				itemDef.femaleEquip1 = 65357;
				itemdefyogipic = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				// itemDef.rdc2 = 23945;
				//itemDef.rdc2 = 34737;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 57; // the texture that it currently has
				itemDef.newColors[0] = 65; //
				
				break;

			case 8818:
				itemDef.name = "Bulwark legs";
				itemDef.modelID = 65358;
				itemDef.maleEquip1 = 65359;
				itemDef.femaleEquip1 = 65359;
				itemdefyogipic = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 57; // the texture that it currently has
				itemDef.newColors[0] = 65; //
				
				//	itemDef.rdc2 = 34737;
				break;
			case 8811:
				itemDef.name = "<col=7f39f2>Shadow boots";
				itemDef.modelID = 65226;
				itemDef.maleEquip1 = 65226;
				itemDef.femaleEquip1 = 65226;
				itemdefyogipic = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, null, "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 71; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 16137:
				itemDef.name = "Art's 2h sword";
				

				break;
			case 8329:
				itemDef.name = "Art's Defender";
				itemDef.modelID = 65127;
				itemDef.maleEquip1 = 65128;
				itemDef.femaleEquip1 = 65128;
				itemdefyogipic = ItemDefinition.get(1321);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 40; // the texture that it currently has
				itemDef.newColors[0] = 62;
				itemDef.stackable = false;
				break;
			case 11140:
				itemDef.name = "Art's gloves";
				
				break;
			case 19892:
				itemDef.name = "Art's Amulet";
				break;
			case 8335:
				itemDef.name = "Art's Ring";
				itemDef.modelID = 65303;
				itemDef.maleEquip1 = 65303;
				itemDef.femaleEquip1 = 65303;
				itemdefyogipic = ItemDefinition.get(15401);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // same here
				itemDef.oldColors = new int[1];
				itemDef.oldColors[0] = 51; // the texture that it currently has
				itemDef.newColors[0] = 62;
				
				break;

			case 8334:
				itemDef.name = "Art's boots";
				itemDef.modelID = 65226;
				itemDef.maleEquip1 = 65226;
				itemDef.femaleEquip1 = 65226;
				itemdefyogipic = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 62; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 8336:
				itemDef.name = "eatmycaca helm";
				itemDef.modelID = 65231;
				itemDef.maleEquip1 = 65232;
				itemDef.femaleEquip1 = 65232;
				itemdefyogipic = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 70; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 8337:
				itemDef.name = "eatmycaca body";
				itemDef.modelID = 65233;
				itemDef.maleEquip1 = 65234;
				itemDef.femaleEquip1 = 65234;
				itemdefyogipic = ItemDefinition.get(4894);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//	itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};

				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 70; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 8338:
				itemDef.name = "eatmycaca chaps";
				itemDef.modelID = 65235;
				itemDef.maleEquip1 = 65236;
				itemDef.femaleEquip1 = 65236;// im not lagging
				itemdefyogipic = ItemDefinition.get(4900);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};

				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 70; //
				itemDef.stackable = false;
				break;

			case 7956:
				itemDef.copyItem(21221);
				itemDef.name = "PvM Box";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.modelID = 22385;
				itemDef.modelZoom = 1500;
				break;
			case 7120:
				itemDef.copyItem(290);
				itemDef.name = "Slayer Crate";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.modelID = 19643;
				itemDef.modelZoom = 2000;
				itemDef.rotationY = 43;
				itemDef.rotationX = 100;
				break;
			case 22123:
				itemDef.copyItem(290);
				itemDef.name = "Slayer Crate (u)";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.modelID = 19644;
				itemDef.modelZoom = 2000;
				itemDef.rotationY = 43;
				itemDef.rotationX = 100;
				break;

			case 13594:
				itemDef.name = "@red@Blood Weapon box";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemdefyogipic = ItemDefinition.get(290);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				// itemDef.modelID = itemDef2.modelID;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{52};
				itemDef.modelID = 65284;
				break;

			case 19624:
				itemDef.name = "<col=c497fc>Boss Event Box";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemdefyogipic = ItemDefinition.get(290);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				// itemDef.modelID = itemDef2.modelID;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.oldColors = new int[]{63};
				itemDef.newColors = new int[]{61};
				itemDef.modelID = 65284;
				break;

			case 13306:
				itemDef.name = "Satanic anti-hellshield";
				itemDef.modelID = 65506;
				itemDef.maleEquip1 = 65507;
				itemDef.femaleEquip1 = 65507;
				def = ItemDefinition.get(18509);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 101922;
				break;

			case 18817:
				itemDef.name = "Ring of sauron (hell)";
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
				
			case 13300:
				itemDef.copyItem(4708);
				itemDef.name = "Subzero full helm";
				itemDef.modelID = 17221;
				itemDef.maleEquip1 = 17222;
				itemDef.femaleEquip1 = 17222;
				itemDef.stackable = false;
				break;
				
			case 13301:
				itemDef.copyItem(4712);
				itemDef.name = "Subzero body";
				itemDef.modelID = 17223;
				itemDef.maleEquip1 = 17234;
				itemDef.femaleEquip1 = 17234;
				break;
				
			case 13304:
				itemDef.copyItem(4714);
				itemDef.name = "Subzero legs";
				itemDef.modelID = 17225;
				itemDef.maleEquip1 = 17226;
				itemDef.femaleEquip1 = 17226;
				break;
				
			case 13302:
				itemDef.copyItem(4708);
				itemDef.name = "Subzero gloves";
				itemDef.modelID = 17227;
				itemDef.maleEquip1 = 17228;
				itemDef.femaleEquip1 = 17228;
				break;

			case 18887:
				itemDef.name = "@cya@Colossal Boots";
				itemDef.modelID = 65226;
				itemDef.maleEquip1 = 65226;
				itemDef.femaleEquip1 = 65226;
				itemdefyogipic = ItemDefinition.get(3791);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.newColors = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				itemDef.oldColors = new int[1]; // same here
				itemDef.oldColors[0] = 60; // the texture that it currently has
				itemDef.newColors[0] = 78; // the new texture u want it to have
				itemDef.stackable = false;
				break;
			case 13305:
				itemDef.copyItem(4708);
				itemDef.name = "Subzero boots";
				itemDef.modelID = 17231;
				itemDef.maleEquip1 = 17232;
				itemDef.femaleEquip1 = 17232;
				break;
				
			case 12265:
				itemDef.name = "Ice Torva full helm";
				itemdefyogipic = ItemDefinition.get(14008);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.maleEquip1 = itemdefyogipic.maleEquip1;
				itemDef.femaleEquip1 = itemdefyogipic.femaleEquip1;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = itemdefyogipic.modelID;
				itemDef.actions = itemdefyogipic.actions;
				itemDef.rdc2 = 36262;
				break;
			case 12266:
				itemDef.name = "Ice Torva platebody";
				itemdefyogipic = ItemDefinition.get(14009);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.maleEquip1 = itemdefyogipic.maleEquip1;
				itemDef.femaleEquip1 = itemdefyogipic.femaleEquip1;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = itemdefyogipic.modelID;
				itemDef.actions = itemdefyogipic.actions;
				itemDef.rdc2 = 36262;
				break;
			case 12267:
				itemDef.name = "Ice Torva platelegs";
				itemdefyogipic = ItemDefinition.get(14010);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.maleEquip1 = itemdefyogipic.maleEquip1;
				itemDef.femaleEquip1 = itemdefyogipic.femaleEquip1;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = itemdefyogipic.modelID;
				itemDef.actions = itemdefyogipic.actions;
				itemDef.rdc2 = 36262;
				break;
			case 13323:
				itemDef.name = "Hellraiser head";
				itemDef.modelZoom = 913;
				itemDef.rotationX = 0;
				itemDef.rotationY = 443;
				itemDef.modelOffsetX = 3;
				itemDef.modelOffsetY = 15;
				itemDef.modelID = 16049;
				itemDef.maleEquip1 = 16050;
				itemDef.femaleEquip1 = 16050;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				
				break;
			case 13324:
				itemDef.name = "Hellraiser body";
				itemdefyogipic = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = 16051;
				itemDef.maleEquip1 = 16052;
				itemDef.femaleEquip1 = 16052;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				
				break;
			case 13325:
				itemDef.name = "Hellraiser legs";
				itemdefyogipic = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = 16053;
				itemDef.maleEquip1 = 16054;
				itemDef.femaleEquip1 = 16054;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
				
			case 13326:
				itemDef.name = "Hellraiser gloves";
				itemDef.modelOffsetX = 8;
				itemDef.modelOffsetY = -12;
				itemDef.modelZoom = 1139;
				itemDef.rotationY = 1520;
				itemDef.rotationX = 2015;
				itemDef.rotationZ = 322;
				itemDef.modelID = 16055;
				itemDef.maleEquip1 = 16056;
				itemDef.femaleEquip1 = 16056;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
				
			case 13327:
				itemDef.name = "Hellraiser boots";
				itemdefyogipic = ItemDefinition.get(7114);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = 16057;
				itemDef.maleEquip1 = 16057;
				itemDef.femaleEquip1 = 16057;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
				
			case 13025:
				itemDef.name = "Grinch head";
				itemdefyogipic = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = 64306;
				itemDef.maleEquip1 = 64307;
				itemDef.femaleEquip1 = 64307;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				
				break;
			case 13027:
				itemDef.name = "Grinch body";
				itemdefyogipic = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = 64308;
				itemDef.maleEquip1 = 64309;
				itemDef.femaleEquip1 = 64309;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				
				break;
			case 13023:
				itemDef.name = "Grinch legs";
				itemdefyogipic = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = 64310;
				itemDef.maleEquip1 = 64311;
				itemDef.femaleEquip1 = 64311;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				
				break;
			case 7461:
				itemDef.name = "Inuyasha gloves";
				break;
			case 13029:
				itemDef.name = "Grinch gloves";
				itemdefyogipic = ItemDefinition.get(7461);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = 64312;
				itemDef.maleEquip1 = 64313;
				itemDef.femaleEquip1 = 64313;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				
				break;
			case 13031:
				itemDef.name = "Grinch boots";
				itemdefyogipic = ItemDefinition.get(7114);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = 64314;
				itemDef.maleEquip1 = 64314;
				itemDef.femaleEquip1 = 64314;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				
				break;
			case 13328:
				itemDef.name = "Bleach head";
				itemdefyogipic = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = 64132;
				itemDef.maleEquip1 = 64133;
				itemDef.femaleEquip1 = 64133;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				
				break;
			case 13329:
				itemDef.name = "Bleach body";
				itemdefyogipic = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = 64134;
				itemDef.maleEquip1 = 64135;
				itemDef.femaleEquip1 = 64135;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				
				break;
			case 13330:
				itemDef.name = "Bleach legs";
				itemdefyogipic = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = 64136;
				itemDef.maleEquip1 = 64137;
				itemDef.femaleEquip1 = 64137;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				
				break;
			case 13332:
				itemDef.name = "Bleach boots";
				itemdefyogipic = ItemDefinition.get(7114);
				itemDef.modelOffsetX = itemdefyogipic.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic.modelZoom;
				itemDef.rotationY = itemdefyogipic.rotationY;
				itemDef.rotationX = itemdefyogipic.rotationX;
				itemDef.modelID = 64138;
				itemDef.maleEquip1 = 64138;
				itemDef.femaleEquip1 = 64138;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				
				break;
			case 13333:
				itemDef.name = "Bleach Sword";
				itemDef.modelID = 64139;
				itemDef.maleEquip1 = 64140;
				itemDef.femaleEquip1 = 64140;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				
				break;

			case 21053:
				itemDef.name = "forbidden Ballista";
				itemDef.modelID = 64291;
				itemDef.maleEquip1 = 64292;
				itemDef.femaleEquip1 = 64292;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				break;
			case 21054:
				itemDef.name = "Cursed Ballista";
				itemDef.modelID = 64291;
				itemDef.maleEquip1 = 64292;
				itemDef.femaleEquip1 = 64292;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 24204;
				break;
			case 21055:
				itemDef.name = "Hidden Ballista";
				itemDef.modelID = 64291;
				itemDef.maleEquip1 = 64292;
				itemDef.femaleEquip1 = 64292;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 9999898;
				break;
				
			case 21056:
				itemDef.name = "Damned Ballista";
				itemDef.modelID = 64291;
				itemDef.maleEquip1 = 64292;
				itemDef.femaleEquip1 = 64292;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 553535;
				break;
				
			case 21057:
				itemDef.name = "lightsaber";
				itemDef.modelID = 64293;
				itemDef.maleEquip1 = 64294;
				itemDef.femaleEquip1 = 64294;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 21058:
				itemDef.name = "dualsaber";
				itemDef.modelID = 64295;
				itemDef.maleEquip1 = 64296;
				itemDef.femaleEquip1 = 64296;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				break;
				
			case 18665:
				itemDef.name = "Slayer reward key";
				break;
				
			case 3849:
				itemDef.name = "Slayer reward chest";
				break;
				
			case 22214:
				itemDef.copyItem(21221);
				itemDef.name = "PvM Box (t2)";
				itemDef.actions = new String[5];
				itemDef.actions[0] = "Open";
				itemDef.modelID = 22386;
				itemDef.modelZoom = 1500;
				break;
				
			case 21220:
				itemDef.name = "Pvm ticket pack (1k)";
				itemDef.stackable = false;
				itemDef.actions = new String[] { "Open", null, "Open-all", null, "Drop" };
				ItemDefinition itemdefyogipic11 = ItemDefinition.get(15262);
				itemDef.modelID = itemdefyogipic11.modelID;
				itemDef.modelOffsetX = itemdefyogipic11.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic11.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic11.modelZoom;
				itemDef.rotationY = itemdefyogipic11.rotationY;
				itemDef.rotationX = itemdefyogipic11.rotationX;
				itemDef.modelZoom = 2000;
				itemDef.rdc2 = 123434;
				break;
			case 23215:
				itemDef.name = "PVM ticket pack (5k)";
				itemDef.stackable = false;
				itemDef.actions = new String[] { "Open", null, "Open-all", null, "Drop" };
				ItemDefinition itemdefyogipic111 = ItemDefinition.get(15262);
				itemDef.modelID = itemdefyogipic111.modelID;
				itemDef.modelOffsetX = itemdefyogipic111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic111.modelZoom;
				itemDef.rotationY = itemdefyogipic111.rotationY;
				itemDef.rotationX = itemdefyogipic111.rotationX;
				itemDef.modelZoom = 2000;
				itemDef.colorChange = new double[]{1, 0.3, 0.3};
				break;
			case 22219:
				itemDef.name = "PVM ticket pack (10k)";
				itemDef.stackable = false;
				itemDef.actions = new String[] { "Open", null, "Open-all", null, "Drop" };
				ItemDefinition itemdefyogipic11112 = ItemDefinition.get(15262);
				itemDef.modelID = ItemDefinition.get(15262).modelID;
				itemDef.modelOffsetX = ItemDefinition.get(15262).modelOffsetX;
				itemDef.modelOffsetY = ItemDefinition.get(15262).modelOffsetY;
				itemDef.modelZoom = ItemDefinition.get(15262).modelZoom;
				itemDef.rotationY = ItemDefinition.get(15262).rotationY;
				itemDef.rotationX = ItemDefinition.get(15262).rotationX;
				itemDef.modelZoom = 2000;
				itemDef.colorChange = new double[]{0.6, 0.1, 0.1};
				break;
			case 21060:
				itemDef.name = "Slayer dualsaber";
				itemDef.modelID = 64295;
				itemDef.maleEquip1 = 64296;
				itemDef.femaleEquip1 = 64296;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;
				itemDef.rdc2 = 295925;
				break;
			case 21061:
				itemDef.name = "dualsaber";
				itemDef.modelID = 64295;
				itemDef.maleEquip1 = 64296;
				itemDef.femaleEquip1 = 64296;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				itemDef.rdc2 = 77777;
				break;
			case 21059:
				itemDef.name = "Slapping hand";
				itemDef.modelID = 64298;
				itemDef.maleEquip1 = 64297;
				itemDef.femaleEquip1 = 64297;
				def = ItemDefinition.get(22034);
				itemDef.modelOffsetX = def.modelOffsetX;
				itemDef.modelOffsetY = def.modelOffsetY;
				itemDef.modelZoom = def.modelZoom;
				itemDef.rotationY = def.rotationY;
				itemDef.rotationX = def.rotationX;
				itemDef.actions = new String[]{null, "Wear", null, "<col=C3C0B2>Dissolve", "Drop"};
				itemDef.stackable = false;

				break;
			case 15005:
				itemDef.name = "Gladiator full helm";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64101;
				itemDef.maleEquip1 = 64102;
				itemDef.femaleEquip1 = 64102;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 15006:
				itemDef.name = "Gladiator fighterbody";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64103;
				itemDef.maleEquip1 = 64104;
				itemDef.femaleEquip1 = 64104;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 15007:
				itemDef.name = "Gladiator fighterlegs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64105;
				itemDef.maleEquip1 = 64106;
				itemDef.femaleEquip1 = 64106;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 15008:
				itemDef.name = "Gladiator kiteshield";
				itemdefyogipic1111 = ItemDefinition.get(1540);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64107;
				itemDef.maleEquip1 = 64108;
				itemDef.femaleEquip1 = 64108;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;

			case 15200:
				itemDef.name = "Gladiator gloves";
				itemdefyogipic1111 = ItemDefinition.get(7461);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64111;
				itemDef.maleEquip1 = 64112;
				itemDef.femaleEquip1 = 64112;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 15201:
				itemDef.name = "Gladiator boots";
				itemdefyogipic1111 = ItemDefinition.get(7114);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64113;
				itemDef.maleEquip1 = 64113;
				itemDef.femaleEquip1 = 64113;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 15100:
				itemDef.name = "Gladiator cape";
				itemdefyogipic1111 = ItemDefinition.get(6570);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64109;
				itemDef.maleEquip1 = 64110;
				itemDef.femaleEquip1 = 64110;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 21036:
				itemDef.name = "Exorcism helm";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64269;
				itemDef.maleEquip1 = 64270;
				itemDef.femaleEquip1 = 64270;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 21037:
				itemDef.name = "Exorcism body";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64271;
				itemDef.maleEquip1 = 64272;
				itemDef.femaleEquip1 = 64272;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 21038:
				itemDef.name = "Exorcism legs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64273;
				itemDef.maleEquip1 = 64274;
				itemDef.femaleEquip1 = 64274;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 21039:
				itemDef.name = "Exorcism cape";
				itemdefyogipic1111 = ItemDefinition.get(1540);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = 2000;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64275;
				itemDef.maleEquip1 = 64276;
				itemDef.femaleEquip1 = 64276;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;

			case 21040:
				itemDef.name = "Exorcism gloves";
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

				break;
			case 21041:
				itemDef.name = "Exorcism boots";
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
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;

			case 21042:
				itemDef.name = "Blacksir helm";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64269;
				itemDef.maleEquip1 = 64270;
				itemDef.femaleEquip1 = 64270;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 234423;
				break;
			case 21043:
				itemDef.name = "Blacksir body";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64271;
				itemDef.maleEquip1 = 64272;
				itemDef.femaleEquip1 = 64272;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 234423;
				break;
			case 21044:
				itemDef.name = "Blacksir legs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64273;
				itemDef.maleEquip1 = 64274;
				itemDef.femaleEquip1 = 64274;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 234423;
				break;
			case 21045:
				itemDef.name = "Blacksir cape";
				itemdefyogipic1111 = ItemDefinition.get(1540);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = 2000;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64275;
				itemDef.maleEquip1 = 64276;
				itemDef.femaleEquip1 = 64276;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 234423;
				break;

			case 21046:
				itemDef.name = "Blacksir gloves";
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

				itemDef.rdc2 = 234423;
				break;
			case 21047:
				itemDef.name = "Blacksir boots";
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
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 234423;
				break;
			case 19984:
				itemDef.name = "LegendarySlayer helm";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
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

				itemDef.rdc2 = 444444;
				break;
			case 19985:
				itemDef.name = "LegendarySlayer body";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
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

				itemDef.rdc2 = 444444;
				break;
			case 19986:
				itemDef.name = "LegendarySlayer legs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
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

				itemDef.rdc2 = 444444;
				break;
			case 19987:
				itemDef.copyItem(10666);
				itemDef.name = "L.S spirit shield";
				itemDef.modelID = 64200;
				itemDef.maleEquip1 = 64201;
				itemDef.femaleEquip1 = 64201;
				itemDef.modelOffsetY = 6;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 444444;
				break;

			case 19988:
				itemDef.name = "LegendarySlayer gloves";
				itemdefyogipic1111 = ItemDefinition.get(7461);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
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

				itemDef.rdc2 = 444444;
				break;
			case 19989:
				itemDef.name = "LegendarySlayer boots";
				itemdefyogipic1111 = ItemDefinition.get(7114);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
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

				itemDef.rdc2 = 444444;
				break;
			case 19991:
				itemDef.name = "L.S amulet";
				itemdefyogipic1111 = ItemDefinition.get(295);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
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

				itemDef.rdc2 = 444444;
				break;
			case 19992:
				itemDef.name = "L.S ring";
				itemdefyogipic1111 = ItemDefinition.get(1635);
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

				itemDef.rdc2 = 444444;
				break;
			case 19993:
				itemDef.name = "LegendarySlayer scimitar";
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

				itemDef.rdc2 = 444444;
				break;
			case 19994:
				itemDef.name = "LegendarySlayer cape";
				itemdefyogipic1111 = ItemDefinition.get(2413);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
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

				itemDef.rdc2 = 666666;
				break;
			case 20400:
				itemDef.name = "@cya@Enraged Cape";
				itemdefyogipic1111 = ItemDefinition.get(2413);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64211;
				itemDef.maleEquip1 = 64212;
				itemDef.femaleEquip1 = 64212;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop";
				itemDef.stackable = false;
				itemDef.rdc2 = 444444;
				break;
			case 19998:
				itemDef.name = "ExoticSlayer Rapier";
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

				itemDef.rdc2 = 444444;
				break;
			case 21010:
				itemDef.name = "Owl mage helm";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = 850;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64215;
				itemDef.maleEquip1 = 64216;
				itemDef.femaleEquip1 = 64216;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				//itemDef.rdc2= 77777;
				break;
			case 21011:
				itemDef.name = "Owl mage body";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = 10;
				itemDef.modelZoom = 1300;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64217;
				itemDef.maleEquip1 = 64218;
				itemDef.femaleEquip1 = 64218;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				//	itemDef.rdc2= 77777;
				break;
			case 21012:
				itemDef.name = "Owl mage legs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = 10;
				itemDef.modelZoom = 2000;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64219;
				itemDef.maleEquip1 = 64220;
				itemDef.femaleEquip1 = 64220;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				//	itemDef.rdc2= 77777;
				break;
			case 21014:
				itemDef.name = "Owl mage staff";
				itemDef.modelID = 64221;
				itemDef.maleEquip1 = 64222;
				itemDef.femaleEquip1 = 64222;
				itemDef21 = ItemDefinition.get(19146);
				itemDef.modelOffsetX = 3;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = 500;
				itemDef.modelZoom = 2300;
				itemDef.rotationY = 260;
				itemDef.rotationX = 100;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 21015:
				itemDef.name = "Turtle helm";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64227;
				itemDef.maleEquip1 = 64228;
				itemDef.femaleEquip1 = 64228;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				itemDef.rdc2 = 987654;

				//itemDef.rdc2= 77777;
				break;
			case 21016:
				itemDef.name = "Turtle body";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64229;
				itemDef.maleEquip1 = 64230;
				itemDef.femaleEquip1 = 64230;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				itemDef.rdc2 = 987654;

				//	itemDef.rdc2= 77777;
				break;
			case 21017:
				itemDef.name = "Turtle legs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64231;
				itemDef.maleEquip1 = 64232;
				itemDef.femaleEquip1 = 64232;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 987654;
				//	itemDef.rdc2= 77777;
				break;
			case 21018:
				itemDef.name = "Supreme bow";
				itemDef.modelID = 64233;
				itemDef.maleEquip1 = 64234;
				itemDef.femaleEquip1 = 64234;
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
				itemDef.rdc2 = 987654;
				break;
			case 21019:
				itemDef.copyItem(10666);
				itemDef.name = "Turtle spirit shield";
				itemDef.modelID = 64235;
				itemDef.maleEquip1 = 64236;
				itemDef.femaleEquip1 = 64236;
				itemDef.modelOffsetY = 6;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				itemDef.rdc2 = 987654;

				break;
			case 21020:
				itemDef.name = "Rusted G. helm";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64237;
				itemDef.maleEquip1 = 64238;
				itemDef.femaleEquip1 = 64238;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;


				break;
			case 21021:
				itemDef.name = "Rusted G. body";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64239;
				itemDef.maleEquip1 = 64240;
				itemDef.femaleEquip1 = 64240;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				break;
			case 21022:
				itemDef.name = "Rusted G. legs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 64241;
				itemDef.maleEquip1 = 64242;
				itemDef.femaleEquip1 = 64242;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;


				break;
			case 21023:
				itemDef.name = "Rusted G. sword";
				itemDef.modelID = 64243;
				itemDef.maleEquip1 = 64244;
				itemDef.femaleEquip1 = 64244;
				itemDef21 = ItemDefinition.get(19780);
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

				break;
			case 21024:
				itemDef.name = "Rusted G. wings";
				itemDef.modelID = 64245;
				itemDef.maleEquip1 = 64246;
				itemDef.femaleEquip1 = 64246;
				itemDef21 = ItemDefinition.get(17632);
				itemDef.modelOffsetX = itemDef21.modelOffsetX;
				//itemDef.modelOffsetX = itemDef21.modelOffsetX;
				itemDef.modelOffsetY = itemDef21.modelOffsetY;
				itemDef.modelZoom = itemDef21.modelZoom;
				itemDef.rotationY = itemDef21.rotationY;
				itemDef.rotationX = itemDef21.rotationX;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.rdc2 = 230;
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;

			case 20086:
				itemDef.name = "Cursed helm";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 17184;
				itemDef.maleEquip1 = 17185;
				itemDef.femaleEquip1 = 17185;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
			case 20087:
				itemDef.name = "Cursed body";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 17186;
				itemDef.maleEquip1 = 17187;
				itemDef.femaleEquip1 = 17187;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
			case 20088:
				itemDef.name = "Cursed legs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 17189;
				itemDef.maleEquip1 = 17190;
				itemDef.femaleEquip1 = 17190;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;

			case 20090:
				itemDef.copyItem(10666);
				itemDef.name = "Cursed spirit shield";
				itemDef.modelID = 64200;
				itemDef.maleEquip1 = 64201;
				itemDef.femaleEquip1 = 64201;
				itemDef.modelOffsetY = 6;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;

			case 20091:
				itemDef.name = "Cursed gloves";
				itemdefyogipic1111 = ItemDefinition.get(7461);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 17191;
				itemDef.maleEquip1 = 17192;
				itemDef.femaleEquip1 = 17192;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;
			case 20089:
				itemDef.name = "Cursed boots";
				itemdefyogipic1111 = ItemDefinition.get(7114);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
				itemDef.modelID = 17193;
				itemDef.maleEquip1 = 17193;
				itemDef.femaleEquip1 = 17193;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;
				break;

			case 20092:
				itemDef.name = "Cursed amulet";
				itemdefyogipic1111 = ItemDefinition.get(295);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
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

				itemDef.rdc2 = 44322;
				break;
			case 20093:
				itemDef.name = "Cursed ring";
				itemdefyogipic1111 = ItemDefinition.get(1635);
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

				itemDef.rdc2 = 44322;
				break;
			case 20098:
				itemDef.name = "Cursed scimitar";
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

				itemDef.rdc2 = 44322;
				break;
			case 20099:
				itemDef.name = "Cursed cape";
				itemdefyogipic1111 = ItemDefinition.get(2413);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
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

				itemDef.rdc2 = 44322;
				break;
			case 20100:
				itemDef.name = "Cursed rapier";
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

				itemDef.rdc2 = 44322;
				break;
			case 21062:
				itemDef.name = "Ruthless helm";
				itemdefyogipic1111 = ItemDefinition.get(4882);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
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

				itemDef.rdc2 = 23662;
				break;
			case 21063:
				itemDef.name = "Ruthless body";
				itemdefyogipic1111 = ItemDefinition.get(5575);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
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

				itemDef.rdc2 = 23662;
				break;
			case 21064:
				itemDef.name = "Ruthless legs";
				itemdefyogipic1111 = ItemDefinition.get(5576);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
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

				itemDef.rdc2 = 23662;
				break;
			case 21065:
				itemDef.copyItem(10666);
				itemDef.name = "Ruthless spirit shield";
				itemDef.modelID = 64200;
				itemDef.maleEquip1 = 64201;
				itemDef.femaleEquip1 = 64201;
				itemDef.modelOffsetY = 6;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.stackable = false;
				itemDef.actions = new String[5];
				itemDef.actions[1] = "Wear";
				itemDef.actions[4] = "Drop"; itemDef.actions[3] = "<col=C3C0B2>Dissolve";
				itemDef.stackable = false;

				itemDef.rdc2 = 23662;
				break;

			case 21066:
				itemDef.name = "Ruthless gloves";
				itemdefyogipic1111 = ItemDefinition.get(7461);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
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

				itemDef.rdc2 = 23662;
				break;
			case 21067:
				itemDef.name = "Ruthless boots";
				itemdefyogipic1111 = ItemDefinition.get(7114);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
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

				itemDef.rdc2 = 23662;
				break;
			case 21068:
				itemDef.name = "Ruthless amulet";
				itemdefyogipic1111 = ItemDefinition.get(295);
				itemDef.modelOffsetX = itemdefyogipic1111.modelOffsetX;
				itemDef.modelOffsetY = itemdefyogipic1111.modelOffsetY;
				itemDef.modelZoom = itemdefyogipic1111.modelZoom;
				itemDef.rotationY = itemdefyogipic1111.rotationY;
				itemDef.rotationX = itemdefyogipic1111.rotationX;
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

				itemDef.rdc2 = 23662;
				break;
		}
		return itemDef;
	}

}
