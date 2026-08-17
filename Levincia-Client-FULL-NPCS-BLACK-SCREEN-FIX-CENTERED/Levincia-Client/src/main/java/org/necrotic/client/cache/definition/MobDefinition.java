package org.necrotic.client.cache.definition;

import org.necrotic.Configuration;
import org.necrotic.client.Client;
import org.necrotic.client.FrameReader;
import org.necrotic.client.List;
import org.necrotic.client.cache.Archive;
import org.necrotic.client.io.ByteBuffer;
import org.necrotic.client.world.Model;

import java.util.HashMap;
import java.util.Objects;

//use npc 6208
public final class MobDefinition {
	public int rdc = 0;
	public int rdc2 = 0;
	public int rdc3 = 0;
	public static Client clientInstance;
	public static List mruNodes = new List(30);
	private static ByteBuffer buffer;
	private static int[] streamIndices;
	public static HashMap<Integer, MobDefinition> map = new HashMap<>();

	public static void applyTexturing1(Model model, int id) {
		switch (id) {
			case 1084:
				model.setTexture(52);
				break;
			case 1085:
				model.setTexture(30);
				break;
			case 1086:
				model.setTexture(51);
				break;
		}
	}

	public static MobDefinition get(int id) {
		MobDefinition definition = map.get(id);
		if (definition != null) {
			return definition;
		}
		definition = new MobDefinition();
		if (id >= streamIndices.length) {
			return null;
		}
		buffer.position = streamIndices[id];
		definition.id = id;
		definition.readValues(buffer);

		if (definition.name != null && definition.name.toLowerCase().contains("bank")) {
			if (definition.actions != null) {
				for (int l = 0; l < definition.actions.length; l++) {
					if (definition.actions[l] != null && definition.actions[l].equalsIgnoreCase("Collect")) {
						definition.actions[l] = null;
					}
				}
			}

		}


		        applyCustomNpcs1(id, definition);
        applyCustomNpcs2(id, definition);
        applyCustomNpcs3(id, definition);
        applyCustomNpcs4(id, definition);
        applyCustomNpcs5(id, definition);
        applyCustomNpcs6(id, definition);
        applyCustomNpcs7(id, definition);
        applyCustomNpcs8(id, definition);
        applyCustomNpcs9(id, definition);
        applyCustomNpcs10(id, definition);
        applyCustomNpcs11(id, definition);
        applyCustomNpcs12(id, definition);
        applyCustomNpcs13(id, definition);
        applyCustomNpcs14(id, definition);
        applyCustomNpcs15(id, definition);
        applyCustomNpcs16(id, definition);
        applyCustomNpcs17(id, definition);
        applyCustomNpcs18(id, definition);
        applyCustomNpcs19(id, definition);


		if (definition.name != null) {
			if (definition.name.toLowerCase().contains("pet ") || definition.name.toLowerCase().contains(" pet"))
				definition.drawYellowDotOnMap = false;
		}

		map.put(id, definition);
		return definition;
	}

    private static void applyCustomNpcs1(int id, MobDefinition definition) {
        switch (id) {

			case 10034:
				definition.name = "Yugi Muto";
				definition.npcModels = new int[]{22340};
				definition.walkAnimation = 819;
				definition.standAnimation = 808;
				definition.scaleXZ = 300;
				definition.scaleY = 300;
				definition.maleModelScale = 2;
				definition.degreesToTurn = 32;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 4;
				definition.drawYellowDotOnMap = true;
				definition.headIcon = -1;
				break;
			case 10035:
				definition.name = "Dark Magician";
				definition.npcModels = new int[]{22345};//22346 for staff
				definition.walkAnimation = 819;
				definition.standAnimation = 808;
				definition.scaleXZ = 200;
				definition.scaleY = 200;
				definition.maleModelScale = 2;
				definition.degreesToTurn = 32;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 3;
				definition.drawYellowDotOnMap = true;
				definition.headIcon = -1;
				definition.originalModelColours = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				definition.changedModelColours = new int[1]; // same here
				definition.changedModelColours[0] = 104; // the texture that it currently has
				definition.originalModelColours[0] = 102; // the new texture u want it to have
				break;
			case 10036:
				definition.name = "Armed Protector Dragon";
				definition.npcModels = new int[]{22341};
				definition.walkAnimation = 819;
				definition.standAnimation = 808;
				definition.scaleXZ = 200;
				definition.scaleY = 200;
				definition.maleModelScale = 2;
				definition.degreesToTurn = 32;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 3;
				definition.drawYellowDotOnMap = true;
				definition.headIcon = -1;
				break;

			case 10037:
				definition.name = "Exodia the forgotten one";
				definition.npcModels = new int[]{22342};
				definition.walkAnimation = 819;
				definition.standAnimation = 808;
				definition.scaleXZ = 300;
				definition.scaleY = 300;
				definition.maleModelScale = 2;
				definition.degreesToTurn = 32;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 3;
				definition.drawYellowDotOnMap = true;
				definition.headIcon = -1;
				break;

			case 10038:
				definition.name = "Yugi Muto";
				definition.npcModels = new int[]{22340};
				definition.walkAnimation = 819;
				definition.standAnimation = 808;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.maleModelScale = 2;
				definition.degreesToTurn = 32;
				definition.actions = new String[]{null, null, null, null, null};
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = true;
				definition.headIcon = -1;
				break;
			case 10039:
				definition.name = "Dark Magician";
				definition.npcModels = new int[]{22345};
				definition.walkAnimation = 819;
				definition.standAnimation = 808;
				definition.scaleXZ = 50;
				definition.scaleY = 50;
				definition.maleModelScale = 2;
				definition.degreesToTurn = 32;
				definition.actions = new String[]{null, null, null, null, null};
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = true;
				definition.headIcon = -1;
				definition.originalModelColours = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				definition.changedModelColours = new int[1]; // same here
				definition.changedModelColours[0] = 104; // the texture that it currently has
				definition.originalModelColours[0] = 102; // the new texture u want it to have
				break;
			case 10040:
				definition.name = "Armed Protector Dragon";
				definition.npcModels = new int[]{22341};
				definition.walkAnimation = 819;
				definition.standAnimation = 808;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.maleModelScale = 2;
				definition.degreesToTurn = 32;
				definition.actions = new String[]{null, null, null, null, null};
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = true;
				definition.headIcon = -1;
				break;

			case 10041:
				definition.name = "Exodia the forgotten one";
				definition.npcModels = new int[]{22342};
				definition.walkAnimation = 819;
				definition.standAnimation = 808;
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				definition.maleModelScale = 2;
				definition.degreesToTurn = 32;
				definition.actions = new String[]{null, null, null, null, null};
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = true;
				definition.headIcon = -1;
				break;

			case 10042:
				definition.name = "Yugi Muto";
				definition.npcModels = new int[]{22340};
				definition.walkAnimation = 819;
				definition.standAnimation = 808;
				definition.scaleXZ = 120;
				definition.scaleY = 120;
				definition.maleModelScale = 2;
				definition.degreesToTurn = 32;
				definition.actions = new String[]{null, null, null, null, null};
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = true;
				definition.headIcon = -1;
				break;
			case 10026:
				definition.name = "Dark Magician";
				definition.npcModels = new int[]{22345};
				definition.walkAnimation = 819;
				definition.standAnimation = 808;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.maleModelScale = 2;
				definition.degreesToTurn = 32;
				definition.actions = new String[]{null, null, null, null, null};
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = true;
				definition.headIcon = -1;
				definition.originalModelColours = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				definition.changedModelColours = new int[1]; // same here
				definition.changedModelColours[0] = 104; // the texture that it currently has
				definition.originalModelColours[0] = 102; // the new texture u want it to have
				break;
			case 10044:
				definition.name = "Armed Protector Dragon";
				definition.npcModels = new int[]{22341};
				definition.walkAnimation = 819;
				definition.standAnimation = 808;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.maleModelScale = 2;
				definition.degreesToTurn = 32;
				definition.actions = new String[]{null, null, null, null, null};
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = true;
				definition.headIcon = -1;
				break;

			case 10045:
				definition.name = "Exodia the forgotten one";
				definition.npcModels = new int[]{22342};
				definition.walkAnimation = 819;
				definition.standAnimation = 808;
				definition.scaleXZ = 115;
				definition.scaleY = 115;
				definition.maleModelScale = 2;
				definition.degreesToTurn = 32;
				definition.actions = new String[]{null, null, null, null, null};
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = true;
				definition.headIcon = -1;
				break;
			case 9890:
				definition.setDefault();
				definition.npcModels = MobDefinition.get(3313).npcModels;
				definition.standAnimation =  MobDefinition.get(3313).standAnimation;
				definition.walkAnimation = MobDefinition.get(3313).walkAnimation;
				definition.actions = MobDefinition.get(3313).actions;
				definition.combatLevel = 0;
				definition.name = "Prysm";
				definition.scaleXZ = 125;
				definition.scaleY = 125;
				definition.npcSizeInSquares = 2;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.rdc2 = 35734;//892435
				break;
			case 3313:
				definition.name = "Prysm";
				definition.combatLevel = 324;
				definition.scaleXZ = 200;
				definition.scaleY = 200;
				definition.npcSizeInSquares = 3;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.rdc2 = 34734;
				break;
			case 9886:
				definition.setDefault();
				definition.npcModels = new int[]{62717};
				definition.name = "Nihil Offspring";
				definition.combatLevel = 0;
				definition.standAnimation = 6320;
				definition.walkAnimation = 6319;
				definition.actions = new String[] {null, null, null, null, null};
				definition.drawYellowDotOnMap = false;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 60;
				definition.scaleY = 60;
				definition.colorChange = new double[]{0.2, 0.5, 1.0};
				break;
			case 9885:
				definition.setDefault();
				definition.npcModels = new int[]{62717};
				definition.name = "Ice Nihil";
				definition.combatLevel = 0;
				definition.standAnimation = 6320;
				definition.walkAnimation = 6319;
				definition.actions = new String[] {null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 2;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.colorChange = new double[]{0.2, 0.5, 1.0};
				break;

			case 3373:
				definition.npcModels[0] = 6775;
				definition.npcModels[5] = 65334;//cape
				definition.actions = new String[]{"Talk-to" ,null, null, null, null};
				break;
				
			case 289:
				definition.name = "Daily Task Manager";
				definition.actions = new String[]{"Get-Task", null, "Claim-Reward", "Cancel-Task", null};
				break;

			case 409:
				definition.actions = new String[]{"Talk-to", "Dismiss", null, null, null};
				break;
			case 10200:
				definition.name = "Drezel";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{100329};
				definition.npcSizeInSquares = 1;
				definition.combatLevel = 10;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.drawYellowDotOnMap = true;
				break;
			case 9001:
				definition.name = "Phase [1]";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{22383};
				definition.npcSizeInSquares = 1;
				definition.combatLevel = 10;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.drawYellowDotOnMap = true;
				definition.originalModelColours = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				definition.changedModelColours = new int[1]; // same here
				definition.changedModelColours[0] = 57; // the texture that it currently has
				definition.originalModelColours[0] = 104; // the new texture u want it to have

				break;

			case 492:
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.scaleXZ = 400;
				definition.scaleY = 400;
				definition.combatLevel = 1031;
				definition.npcSizeInSquares = 3;
				break;

			case 4594:
				definition.npcModels = new int[]{21155};
				definition.name = "Spirit of Scorpius pet";
				definition.standAnimation = MobDefinition.get(492).standAnimation;
				definition.walkAnimation = MobDefinition.get(492).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 0;
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = false;
				break;
			case 4592:
				definition.npcModels = new int[]{21155};
				definition.name = "Evil Spirit of Scorpius pet";
				definition.standAnimation = MobDefinition.get(492).standAnimation;
				definition.walkAnimation = MobDefinition.get(492).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 0;
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				definition.npcSizeInSquares = 1;
				definition.rdc3 = 10;
				definition.drawYellowDotOnMap = false;
				break;
			case 9222:
				definition.setDefault();
				definition.npcModels = new int[]{163, 254, 292, 320, 230, 247, 176, 181, };
				definition.originalModelColours = new int[]{25238, 8741, 9104, 4626,  };
				definition.changedModelColours = new int[]{0, 0, 20, 0,  };
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.combatLevel = 0;
				definition.name = "Travelling Merchant";
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{"Trade",null,  "Items", null, null};
				break;
			case 9002:
				definition.name = "Phase [2]";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{22382};
				definition.npcSizeInSquares = 1;
				definition.combatLevel = 50;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				definition.drawYellowDotOnMap = true;
				definition.originalModelColours = new int[2]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				definition.changedModelColours = new int[2]; // same here
				definition.changedModelColours[0] = 57; // the texture that it currently has
				definition.originalModelColours[0] = 119; // the new texture u want it to have
				definition.changedModelColours[1] = 57; // the texture that it currently has
				definition.originalModelColours[1] = 119; // the new texture u want it to have
				break;
				
			case 9003:
				definition.name = "Phase [3]";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{22379};
				definition.npcSizeInSquares = 1;
				definition.combatLevel = 100;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.drawYellowDotOnMap = true;
				break;
				
			case 9004:
				definition.name = "Phase [4]";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{16349};
				definition.npcSizeInSquares = 1;
				definition.combatLevel = 150;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 260;
				definition.scaleY = 260;
				definition.drawYellowDotOnMap = true;
				break;
				
			case 9005:
				definition.name = "Phase [5]";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{16351};
				definition.npcSizeInSquares = 1;
				definition.combatLevel = 225;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 105;
				definition.scaleY = 105;
				definition.drawYellowDotOnMap = true;
				break;
				
			case 9006:
				definition.name = "Phase [6]";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{16352};
				definition.npcSizeInSquares = 1;
				definition.combatLevel = 300;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.drawYellowDotOnMap = true;
				break;

			// LEVINCIA MIDGAME NPCS - reuse cache-compatible geometry
			case 10050:
				definition.setDefault();
				definition.name = "Infernal Warden";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{16349};
				definition.npcSizeInSquares = 1;
				definition.combatLevel = 350;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 260;
				definition.scaleY = 260;
				definition.drawYellowDotOnMap = true;
				break;

			case 10051:
				definition.setDefault();
				definition.name = "Infernal Overlord";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{16349};
				definition.npcSizeInSquares = 2;
				definition.combatLevel = 450;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 360;
				definition.scaleY = 360;
				definition.drawYellowDotOnMap = true;
				break;

			case 10052:
				definition.setDefault();
				definition.name = "Shadow Reaver";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{16351};
				definition.npcSizeInSquares = 1;
				definition.combatLevel = 475;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 115;
				definition.scaleY = 115;
				definition.drawYellowDotOnMap = true;
				break;

			case 10053:
				definition.setDefault();
				definition.name = "Shadow Lord";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{16351};
				definition.npcSizeInSquares = 2;
				definition.combatLevel = 575;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 180;
				definition.scaleY = 180;
				definition.drawYellowDotOnMap = true;
				break;

			case 10054:
				definition.setDefault();
				definition.name = "Dragon Knight";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{16352};
				definition.npcSizeInSquares = 1;
				definition.combatLevel = 600;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 120;
				definition.scaleY = 120;
				definition.drawYellowDotOnMap = true;
				break;

			case 10055:
				definition.setDefault();
				definition.name = "Dragon Champion";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{16352};
				definition.npcSizeInSquares = 2;
				definition.combatLevel = 725;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 200;
				definition.scaleY = 200;
				definition.drawYellowDotOnMap = true;
				break;

			case 9106:
				definition.name = "Cthulu";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{19256};
				definition.npcSizeInSquares = 3;
				definition.combatLevel = 300;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 250;
				definition.scaleY = 250;
				definition.drawYellowDotOnMap = true;
				break;

			case 9107:
				definition.name = "Zodia";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{19257,19297,19302,19322,19324,19339};
				definition.npcSizeInSquares = 1;
				definition.combatLevel = 300;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 250;
				definition.scaleY = 250;
				definition.drawYellowDotOnMap = true;
				break;

			case 9108:
				definition.name = "Gutter";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{19370,19372,19398,19403,19404,19410,19411};
				definition.npcSizeInSquares = 3;
				definition.combatLevel = 300;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 250;
				definition.scaleY = 250;
				definition.drawYellowDotOnMap = true;
				break;

			case 9109:
				definition.name = "Midnight Sufferer";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{19435,19441,19444,100137,18943,100136};
				definition.npcSizeInSquares = 3;
				definition.combatLevel = 300;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 250;
				definition.scaleY = 250;
				definition.drawYellowDotOnMap = true;
				break;
            default:
                break;
        }
    }

    private static void applyCustomNpcs2(int id, MobDefinition definition) {
        switch (id) {
			case 9110:
				definition.name = "Souless Sufferer";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{19421,19423,19425,100137,100139,100136};
				definition.npcSizeInSquares = 3;
				definition.combatLevel = 300;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 250;
				definition.scaleY = 250;
				definition.drawYellowDotOnMap = true;
				break;

			case 9111:
				definition.name = "Hellish Sufferer";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{19427,19429,19433,100137,18552,100136};
				definition.npcSizeInSquares = 3;
				definition.combatLevel = 300;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 250;
				definition.scaleY = 250;
				definition.drawYellowDotOnMap = true;
				break;
				/*
			case 9115:
				definition.name = "Akuji";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{19583};
				definition.npcSizeInSquares = 2;
				definition.combatLevel = 200;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 150;
				definition.scaleY = 150;
				definition.drawYellowDotOnMap = true;
				break;
			case 9244:
				definition.name = "Akuji";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{19584,19585,19588,19586,19587};
				definition.npcSizeInSquares = 2;
				definition.combatLevel = 200;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 150;
				definition.scaleY = 150;
				definition.drawYellowDotOnMap = true;
				break;*/

			case 2359:
				definition.name = "Immortal Warrior";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{19582};
				definition.npcSizeInSquares = 1;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 115;
				definition.scaleY = 115;
				definition.drawYellowDotOnMap = true;
				break;

			case 277:
				definition.name = "Lesarkus Warrior";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{19580};
				definition.npcSizeInSquares = 1;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 125;
				definition.scaleY = 125;
				definition.drawYellowDotOnMap = true;
				break;

			case 1914:
				definition.name = "Fatal Warrior";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{19581};
				definition.npcSizeInSquares = 1;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 125;
				definition.scaleY = 125;
				definition.drawYellowDotOnMap = true;
				break;

			case 9116:
				definition.name = "Faceless Magician";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{19463};
				definition.npcSizeInSquares = 1;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 140;
				definition.scaleY = 140;
				definition.drawYellowDotOnMap = true;
				break;

			case 2270:
				definition.name = "Rogue Guard";
				definition.npcModels = new int[]{ItemDefinition.get (10612).maleEquip1,
				ItemDefinition.get (5553).maleEquip1,ItemDefinition.get (5555).maleEquip1,ItemDefinition.get (19335).maleEquip1,
				ItemDefinition.get (5557).maleEquip1,ItemDefinition.get (5559).maleEquip1,346,354,};
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
			break;
			case 2274:
				definition.name = "Armadyl Guard";
				definition.npcModels = new int[]{ItemDefinition.get (11718).maleEquip1,
						ItemDefinition.get (11720).maleEquip1,ItemDefinition.get (11722).maleEquip1,
						ItemDefinition.get (4119).maleEquip1,346,353,};
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				break;
			case 2276:
				definition.name = "Noobie Guard";
				definition.npcModels = new int[]{ItemDefinition.get (19900).maleEquip1,
						ItemDefinition.get (10939).maleEquip1,ItemDefinition.get (10940).maleEquip1,
						ItemDefinition.get (5557).maleEquip1,346,355};
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				break;


			case 9117:
				definition.name = "Lotus Magician";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{19483};
				definition.npcSizeInSquares = 1;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 140;
				definition.scaleY = 140;
				definition.drawYellowDotOnMap = true;
				break;

			case 9118:
				definition.name = "Shadow Magician";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{19484};
				definition.npcSizeInSquares = 1;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 140;
				definition.scaleY = 140;
				definition.drawYellowDotOnMap = true;
				break;

			case 9121:
				definition.name = "Faceless Magician";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcModels = new int[]{19463};
				definition.npcSizeInSquares = 1;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				definition.drawYellowDotOnMap = false;
				break;

			case 9122:
				definition.name = "Lotus Magician";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcModels = new int[]{19483};
				definition.npcSizeInSquares = 1;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				definition.drawYellowDotOnMap = false;
				break;

			case 3242:
				definition.drawYellowDotOnMap = false;
				definition.scaleXZ = 250;
				definition.scaleY = 250;
				break;

			case 9123:
				definition.name = "Shadow Magician";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcModels = new int[]{19484};
				definition.npcSizeInSquares = 1;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				definition.drawYellowDotOnMap = false;
				break;


			case 9124:
				definition.copy(277);
				definition.name = "Lesarkus Warrior";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				definition.drawYellowDotOnMap = false;
				break;

			case 9125:
				definition.copy(1914);
				definition.name = "Fatal Warrior";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				definition.drawYellowDotOnMap = false;
				break;

			case 9126:
				definition.copy(2359);
				definition.name = "Immortal Warrior";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				definition.drawYellowDotOnMap = false;
				break;

				
			case 12810:
				definition.npcModels = new int[]{15435};
				definition.name = "Plutonic demon";
				definition.standAnimation = get(1).standAnimation;
				definition.walkAnimation = get(1).walkAnimation;
				definition.scaleXZ = 200;
				definition.scaleY = 200;
				break;
			case 9000:
				definition.npcModels = get(12810).npcModels;
				definition.combatLevel = 0;
				definition.name = "Boss Slayer Master";
				definition.actions = new String[]{"Talk-To", null, "Get-Task", "Trade", "Cancel-Task"};
				definition.standAnimation = get(12810).standAnimation;
				definition.walkAnimation = get(12810).walkAnimation;
				definition.npcSizeInSquares = 1;
				definition.scaleY = 95;
				definition.scaleXZ = 95;
				definition.rdc2 = 28315;
				//definition.walkingBackwardsAnimation = 4;
				//definition.walkLeftAnimation = 4;
				//definition.walkRightAnimation = 4;
				break;

			case 1830:
				definition.name = "Obsidian Dragon";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.standAnimation = 12248;
				definition.walkAnimation = 12246;
				//definition.walkingBackwardsAnimation = 4;
				//definition.walkLeftAnimation = 4;
				//definition.walkRightAnimation = 4;
				break;

			case 271:
				definition.name = "Scorpian pet";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 0;
				definition.scaleXZ = 40;
				definition.scaleY = 40;
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = false;
				break;

			case 9112:
				definition.name = "Cthulu offspring";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcModels = new int[]{19256};
				definition.npcSizeInSquares = 1;
				definition.combatLevel = 300;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 60;
				definition.scaleY = 60;
				definition.drawYellowDotOnMap = false;
				break;
			case 3712:
				definition.name = "The Chain Warden";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{15202,15204,15264,15278,15279,15285,15287};
				definition.npcSizeInSquares = 2;
				definition.combatLevel = 0;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 120;
				definition.scaleY = 120;
				break;

			case 688:
				definition.name = "Caitlyn The Sheriff";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{15420,15421,15422,15426,15427,15428};
				definition.npcSizeInSquares = 1;
				definition.combatLevel = 0;
				definition.standAnimation = 11973;
				definition.walkAnimation = 11975;
				break;

			case 125:
				definition.name = "The Hand of Noxus";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{15330,15331,15332,15333,15334,15381,15382};
				definition.npcSizeInSquares = 1;
				definition.combatLevel = 0;
				definition.standAnimation = 11973;
				definition.walkAnimation = 11975;
				break;

			case 585:
				definition.name = "Veigar The Master of Evil";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{15429};
				definition.npcSizeInSquares = 5;
				definition.combatLevel = 0;
				definition.standAnimation = 1338;
				definition.walkAnimation = 1339;
				break;

			case 587:
				definition.name = "Iron";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{95170};
				definition.npcSizeInSquares = 5;
				definition.combatLevel = 0;
				definition.standAnimation = 1338;
				definition.walkAnimation = 1339;
				break;

			case 241:
				definition.name = "Global Boss Store";
				definition.actions = new String[] {"Trade", null, null, null, null};
				definition.combatLevel = 0;
				break;

			case 1880:
				definition.name = "@or2@SOD Daemon";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{97666};
				definition.npcSizeInSquares = 5;
				definition.combatLevel = 0;
				definition.standAnimation = 11973;
				definition.walkAnimation = 11975;
				break;

			case 586:
				definition.name = "Wukong";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{15289,15322,15324,15326,15327,15329};
				definition.npcSizeInSquares = 2;
				definition.combatLevel = 0;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 125;
				definition.scaleY = 125;
				break;

			case 7553:
				definition.name = "General Khazard";
				definition.description = "It's a General Khazard.".getBytes();
				definition.combatLevel = 112;
				definition.walkAnimation = 11662;
				definition.standAnimation = 11667;
				definition.actions = new String[5];
				definition.actions[0] = "Talk-to";
				definition.actions[1] = "Attack";
				definition.npcModels = new int[1];
				definition.npcModels[0] = 46712;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				definition.npcSizeInSquares = 3;
				definition.rdc2 = 63262;
				break;
				
			case 100:
				definition.rdc2 = 9999;
				break;
				
			case 406:
				definition.name = "General Champion";
				definition.description = "It's a General Khazard.".getBytes();
				definition.combatLevel = 112;
				definition.walkAnimation = 11662;
				definition.standAnimation = 11667;
				definition.actions = new String[5];
				definition.actions[1] = "Attack";
				definition.npcModels = new int[1];
				definition.npcModels[0] = 46712;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				definition.npcSizeInSquares = 3;
				definition.rdc2 = 565;
				break;
				
			case 1120:
				definition.name = "Vasa Nistirio";
				definition.description = "Olm Dragon.".getBytes();
				definition.npcModels = new int[]{64328};
				definition.combatLevel = 333;
				definition.standAnimation = 303;
				definition.walkAnimation = 304;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 1;
				//definition.rdc2 = 800;
				definition.rdc2 = 677;
				break;
				
			case 1121:
				definition.name = "Ice Demon";
				definition.npcModels = new int[]{64329};
				MobDefinition icedemon = get(82);
				definition.combatLevel = 40;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.description = icedemon.description;
				definition.drawYellowDotOnMap = true;
				definition.standAnimation = icedemon.standAnimation;
				definition.walkAnimation = icedemon.walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 1;
				break;
				
			case 1122:
				definition.name = "Revenant Hellhound";
				definition.npcModels = new int[]{64330};
				MobDefinition antwyv = get(49);
				definition.combatLevel = 40;
				definition.scaleXZ = 150;
				definition.scaleY = 150;
				definition.npcSizeInSquares = 1;
				definition.description = antwyv.description;
				definition.drawYellowDotOnMap = true;
				definition.standAnimation = antwyv.standAnimation;
				definition.walkAnimation = antwyv.walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 1;
				break;
				
			case 1123:
				definition.name = "Supreme Darkbeast";
				definition.npcModels = new int[]{64331};
				MobDefinition hoondon = get(2783);
				definition.combatLevel = 40;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.description = hoondon.description;
				definition.drawYellowDotOnMap = true;
				definition.standAnimation = hoondon.standAnimation;
				definition.walkAnimation = hoondon.walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 1;
				break;
            default:
                break;
        }
    }

    private static void applyCustomNpcs3(int id, MobDefinition definition) {
        switch (id) {
			case 1124:
				definition.name = "Pestilent Bloat";

				definition.npcModels = new int[]{64332};
				MobDefinition justgaurd = get(7553);
				definition.combatLevel = 870;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.description = justgaurd.description;
				definition.drawYellowDotOnMap = true;
				definition.standAnimation = 502;
				definition.walkAnimation = 520;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 1;
				break;
			case 1125:
				definition.name = "TzHaar Ga'al";
				MobDefinition rek = get(2616);
				definition.npcModels = rek.npcModels;

				definition.combatLevel = 40;
				definition.scaleXZ = 200;
				definition.scaleY = 200;
				definition.npcSizeInSquares = 1;
				definition.description = rek.description;
				definition.drawYellowDotOnMap = true;
				definition.standAnimation = rek.standAnimation;
				definition.walkAnimation = rek.walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.rdc2 = 9999;
				definition.npcSizeInSquares = 1;
				break;
			case 2017:
				definition.name = "OLM BOSS";
				definition.description = "Olm Dragon.".getBytes();
				definition.npcModels = new int[]{64327};
				definition.combatLevel = 83;
				definition.standAnimation = 12248;
				definition.walkAnimation = 12246;
				definition.scaleXZ = 210;
				definition.scaleY = 210;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 1;
				break;
			case 402:
				definition.name = "Olm adult";
				definition.description = "Olm Dragon.".getBytes();
				definition.npcModels = new int[]{64327};
				definition.combatLevel = 83;
				definition.standAnimation = 12248;
				definition.walkAnimation = 12246;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.rdc2 = 9483;
				definition.npcSizeInSquares = 1;
				break;
			case 401:
				definition.name = "Olm teenager";
				definition.description = "Olm Dragon.".getBytes();
				definition.npcModels = new int[]{64327};
				definition.combatLevel = 83;
				definition.standAnimation = 12248;
				definition.walkAnimation = 12246;
				definition.scaleXZ = 60;
				definition.scaleY = 60;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.rdc2 = 722;
				definition.npcSizeInSquares = 1;
				break;
			case 408:
				definition.name = "Olm baby";
				definition.description = "Olm Dragon.".getBytes();
				definition.npcModels = new int[]{64327};
				definition.combatLevel = 83;
				definition.standAnimation = 12248;
				definition.walkAnimation = 12246;
				definition.scaleXZ = 30;
				definition.scaleY = 30;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.rdc2 = 11245;
				definition.npcSizeInSquares = 1;
				break;
			case 133:
				definition.name = "Black unicorn pet";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 0;
				definition.scaleXZ = 60;
				definition.scaleY = 60;
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = false;

				break;
			case 105:
				definition.name = "Grizzly bear pet";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 0;
				definition.scaleXZ = 60;
				definition.scaleY = 60;
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = false;

				break;
			case 4414:
				definition.name = "Wolf pet";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 0;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = false;

				break;
				
				/*
				case 500:
				definition.npcModels = new int[]{64326};
				definition.scaleXZ = 250;
				definition.scaleY = 250;
				//definition.rdc2 = 56789876543;
				break;
				*/
				
			case 4972:
				definition.npcModels = new int[]{15079};
				definition.name = "Dragon king";
				definition.combatLevel = 320;
				//definition.rdc2 = 2592952;
				definition.scaleXZ = 125;
				definition.scaleY = 125;
				definition.npcSizeInSquares = 5;
				break;
				
			case 505:
				MobDefinition poke2 = MobDefinition.get(1);
				definition.description = "GWD.".getBytes();
				definition.combatLevel = 162;
				definition.standAnimation = poke2.standAnimation;
				definition.walkAnimation = poke2.walkAnimation;
				definition.npcModels = new int[]{20567};
				definition.name = "Elemental Guardian";
				//definition.rdc2 = 2592952;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 2;
				break;
				
			case 4969:
				definition.npcModels = new int[]{15189};
				definition.name = "Blue-eyes White Dragon pet";
				definition.standAnimation = 5022;
				definition.walkAnimation = 5022;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 0;
				definition.scaleXZ = 50;
				definition.scaleY = 50;
				//definition.rdc2 = 2592952;
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = false;
				break;
			case 9019:
				definition.name = "<col=ff00fb>St. Patrick Leprechaun";
				definition.npcModels = new int[]{98001};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 150;
				definition.scaleY = 150;
				break;
			case 9020:
				definition.name = "<col=ff00fb>Armoured Bunny";
				definition.npcModels = new int[]{100050};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				//      definition.adjustVertextPointsXOrY = 150;
				//      definition.adjustVertextPointZ = 150;
				break;
			case 9021:
				definition.name = "<col=ff00fb>Armoured Bunny Pet";
				definition.npcModels = new int[]{100050};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 32;
				definition.scaleY = 32;
				break;
			case 9022:
				definition.name = "<col=ff00fb>Server Perks";
				definition.npcModels = new int[]{100055};
				definition.combatLevel = 0;
				definition.standAnimation = -1;
				definition.walkAnimation = -1;
				definition.actions = new String[5];
				definition.actions[0] = "Open";
				definition.drawYellowDotOnMap = false;
				definition.npcSizeInSquares = 1;
				definition.degreesToTurn = 90;
				definition.npcSizeInSquares = 3;
				break;


			case 9024:
				definition.setDefault();
				definition.name = "Kil'jaeden";
				definition.npcModels = new int[]{100077};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;
			case 9025:
				definition.setDefault();
				definition.name = "Skreeg";
				definition.npcModels = new int[]{100078};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				definition.headIcon = 0;
				break;
			case 9026:
				definition.setDefault();
				definition.name = "Orix";
				definition.npcModels = new int[]{100079};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				definition.headIcon = 1;
				break;
			case 9027:
				definition.setDefault();
				definition.name = "Crystal orc";
				definition.npcModels = new int[]{100080};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				definition.headIcon = 2;
				break;

//
			case 9826:
				definition.setDefault();
				definition.name = "Kil'jaeden pet";
				definition.npcModels = new int[]{100077};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 32;
				definition.scaleY = 32;
				break;
			case 9827:
				definition.setDefault();
				definition.name = "Skreeg pet";
				definition.npcModels = new int[]{100078};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 50;
				definition.scaleY = 50;
				break;
			case 9828:
				definition.setDefault();
				definition.name = "Orix pet";
				definition.npcModels = new int[]{100079};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 50;
				definition.scaleY = 50;
				break;
			case 9829:
				definition.setDefault();
				definition.name = "Crystal orc pet";
				definition.npcModels = new int[]{100080};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 50;
				definition.scaleY = 50;
				break;

			//

			case 9031:
				definition.setDefault();
				definition.name = "Magic Npc Pet";
				definition.npcModels = new int[]{100097};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				break;
			case 9032:
				definition.setDefault();
				definition.name = "Melee Npc Pet";
				definition.npcModels = new int[]{100109};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				break;
			case 9033:
				definition.setDefault();
				definition.name = "Ranged Npc Pet";
				definition.npcModels = new int[]{100114};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				break;


			case 9800:
				definition.setDefault();
				definition.name = "Avaryss";
				definition.npcModels = new int[]{100142};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;
			case 9801:
				definition.setDefault();
				definition.name = "Conjkoined";
				definition.npcModels = new int[]{100144};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;
			case 13458:
				definition.npcModels = new int[]{19695};
				definition.npcSizeInSquares = 3;
				definition.scaleXZ = 238;
				definition.scaleY = 238;
				break;
			case 9802:
				definition.setDefault();
				definition.name = "Nymora";
				definition.npcModels = new int[]{19699};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;

			case 9803:
				definition.setDefault();
				definition.visibilityOrRendering = true;
				definition.name = "Avaryss pet";
				definition.npcModels = new int[]{100143};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;
			case 9804:
				definition.setDefault();
				definition.name = "Conjkoined pet";
				definition.npcModels = new int[]{100145};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;
			case 9805:
				definition.setDefault();
				definition.name = "Nymora pet";
				definition.npcModels = new int[]{100147};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;


			case 9806:
				definition.setDefault();
				definition.name = "Gorvek";
				definition.npcModels = new int[]{100189};
				definition.combatLevel = MobDefinition.get(50).combatLevel;
				definition.standAnimation = 5022;
				definition.walkAnimation = 5022;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;


			case 9808:
				definition.setDefault();
				definition.name = "Gorvek pet";
				definition.npcModels = new int[]{100190};
				definition.combatLevel = 0;
				definition.standAnimation = 5022;
				definition.walkAnimation = 5022;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				break;
			case 9809:
				definition.setDefault();
				definition.name = "Vindicta pet";
				definition.npcModels = new int[]{100192};
				definition.combatLevel = 0;
				definition.standAnimation = MobDefinition.get(82).standAnimation;
				definition.walkAnimation = MobDefinition.get(82).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 200;
				definition.scaleY = 200;
				break;

				//HoV NPC's
			case 9810:
				definition.setDefault();
				definition.name = "Fenrir";
				definition.npcModels = new int[]{100196};
				definition.combatLevel = MobDefinition.get(95).combatLevel;
				definition.standAnimation = MobDefinition.get(95).standAnimation;
				definition.walkAnimation = MobDefinition.get(95).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;
			case 9811:
				definition.setDefault();
				definition.name = "Green Fenrir";
				definition.npcModels = new int[]{100197};
				definition.combatLevel = MobDefinition.get(95).combatLevel;
				definition.standAnimation = MobDefinition.get(95).standAnimation;
				definition.walkAnimation = MobDefinition.get(95).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;
            default:
                break;
        }
    }

    private static void applyCustomNpcs4(int id, MobDefinition definition) {
        switch (id) {
			case 9812:
				definition.setDefault();
				definition.name = "Midnight Fenrir";
				definition.npcModels = new int[]{19705};
				definition.combatLevel = MobDefinition.get(95).combatLevel;
				definition.standAnimation = MobDefinition.get(95).standAnimation;
				definition.walkAnimation = MobDefinition.get(95).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 2;
				definition.scaleXZ = 178;
				definition.scaleY = 178;
				break;
				
			case 9813:
				definition.setDefault();
				definition.name = "Blood Demon";
				definition.combatLevel = 666;
				definition.npcModels = new int[]{18146};
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;
				
				
			case 205:
				definition.setDefault();
				definition.name = "Elite Valdis";
				definition.combatLevel = 420;
				definition.npcModels = new int[]{18151};
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 205;
				definition.scaleY = 205;
				break;
				
			case 9814:
				definition.setDefault();
				definition.name = "Heimdall";
				definition.npcModels = new int[]{100200};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;
			//HoV NPC End
			case 204:
				definition.setDefault();
				definition.name = "Blood Demon pet";
				definition.npcModels = new int[]{18146};
				definition.combatLevel = MobDefinition.get(9813).combatLevel;
				definition.standAnimation = MobDefinition.get(9813).standAnimation;
				definition.walkAnimation = MobDefinition.get(9813).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 64;
				definition.scaleY = 64;
				break;
			case 9830:
				definition.setDefault();
				definition.name = "Fenrir pet";
				definition.npcModels = new int[]{100196};
				definition.combatLevel = MobDefinition.get(95).combatLevel;
				definition.standAnimation = MobDefinition.get(95).standAnimation;
				definition.walkAnimation = MobDefinition.get(95).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 64;
				definition.scaleY = 64;
				break;
			case 9831:
				definition.setDefault();
				definition.name = "Green Fenrir pet";
				definition.npcModels = new int[]{100197};
				definition.combatLevel = 0;
				definition.standAnimation = MobDefinition.get(95).standAnimation;
				definition.walkAnimation = MobDefinition.get(95).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 64;
				definition.scaleY = 64;
				break;
			case 9832:
				definition.setDefault();
				definition.name = "Red Fenrir pet";
				definition.npcModels = new int[]{100198};
				definition.combatLevel = 0;
				definition.standAnimation = MobDefinition.get(95).standAnimation;
				definition.walkAnimation = MobDefinition.get(95).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 64;
				definition.scaleY = 64;
				break;
			case 9833:
				definition.setDefault();
				definition.name = "Odin pet";
				definition.npcModels = new int[]{100199};
				definition.combatLevel = 0;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 64;
				definition.scaleY = 64;
				break;
			case 9834:
				definition.setDefault();
				definition.name = "Heimdall pet";
				definition.npcModels = new int[]{100200};
				definition.combatLevel = 0;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 64;
				definition.scaleY = 64;
				break;




			//TH Mobs
			case 9815:
				definition.setDefault();
				definition.name = "Demon";
				definition.npcModels = new int[]{100237};
				definition.combatLevel = MobDefinition.get(82).combatLevel;
				definition.standAnimation = MobDefinition.get(82).standAnimation;
				definition.walkAnimation = MobDefinition.get(82).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 6;
				definition.scaleXZ = 256;
				definition.scaleY = 256;
				definition.headIcon = 0;
				break;
			case 9816:
				definition.setDefault();
				definition.name = "Dragon";
				definition.npcModels = new int[]{100238};
				definition.combatLevel = MobDefinition.get(5022).combatLevel;
				definition.standAnimation = 5022;
				definition.walkAnimation = 5022;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 6;
				definition.scaleXZ = 96;
				definition.scaleY = 96;
				break;
			case 7743:
			case 9817:
				definition.setDefault();
				definition.name = "Golem";
				definition.npcModels = new int[]{100239};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 6;
				definition.scaleXZ = 256;
				definition.scaleY = 256;
				definition.headIcon = 1;
				break;

			case 7742:
			case 9818:
				definition.setDefault();
				definition.name = "Rammus";
				definition.npcModels = new int[]{100240};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 6;
				definition.scaleXZ = 256;
				definition.scaleY = 256;
				definition.headIcon = 2;
				break;
				//End of TH Mobs

			case 9819:
				definition.setDefault();
				definition.name = "Demon pet";
				definition.npcModels = new int[]{100237};
				definition.combatLevel = 0;
				definition.standAnimation = MobDefinition.get(82).standAnimation;
				definition.walkAnimation = MobDefinition.get(82).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 32;
				definition.scaleY = 32;
				break;
			case 9820:
				definition.setDefault();
				definition.name = "Dragon pet";
				definition.npcModels = new int[]{100242};
				definition.combatLevel = 0;
				definition.standAnimation = 5022;
				definition.walkAnimation = 5022;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;
			case 9821:
				definition.setDefault();
				definition.name = "Golem pet";
				definition.npcModels = new int[]{100243};
				definition.combatLevel = 0;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;
			case 9822:
				definition.setDefault();
				definition.name = "Rammus pet";
				definition.npcModels = new int[]{100244};
				definition.combatLevel = 0;
				definition.standAnimation = MobDefinition.get(2292).standAnimation;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;



			case 9835:
				definition.setDefault();
				definition.name = "Demon of light";
				definition.npcModels = new int[]{100281};
				definition.combatLevel = 200;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 3;
				break;
			case 9836:
				definition.setDefault();
				definition.name = "Bat of Light";
				MobDefinition icebeast2s = get(78);
				definition.npcModels = new int[]{100282};
				definition.combatLevel = 200;
				definition.standAnimation = 5022;
				definition.walkAnimation = 5022;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 3;
				definition.scaleXZ = 32;
				definition.scaleY = 32;
				break;
			case 9837:
				definition.setDefault();
				definition.name = "Midnight Goblin";
				definition.npcModels = new int[]{100283};
				definition.combatLevel = 200;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 3;
				definition.scaleXZ = 32;
				definition.scaleY = 32;
				definition.rdc2 = 11001;
				break;
			case 9838:
				definition.setDefault();
				definition.name = "Ember Giant";
				definition.npcModels = new int[]{18036};
				definition.combatLevel = 200;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				break;
			case 9839:
				definition.setDefault();
				definition.name = "Mutated hound";
				definition.npcModels = new int[]{100305};
				definition.combatLevel = 200;
				definition.standAnimation = MobDefinition.get(138).standAnimation;
				definition.walkAnimation = MobDefinition.get(138).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 2;
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				break;

				//

			case 9840:
				definition.setDefault();
				definition.name = "Demon of light pet";
				definition.npcModels = new int[]{100281};
				definition.combatLevel = 0;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.actions = new String[5];
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 32;
				definition.scaleY = 32;
				break;
			case 9841:
				definition.setDefault();
				definition.name = "Bat of light pet";
				definition.npcModels = new int[]{100282};
				definition.combatLevel = 0;
				definition.standAnimation = 5022;
				definition.walkAnimation = 5022;
				definition.actions = new String[5];
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 10;
				definition.scaleY = 10;
				break;
			case 9842:
				definition.setDefault();
				definition.name = "Goblin of light pet";
				definition.npcModels = new int[]{100283};
				definition.combatLevel = 0;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.actions = new String[5];
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 32 / 4;
				definition.scaleY = 32 / 4;
				break;
			case 9843:
				definition.setDefault();
				definition.name = "Lava hound pet";
				definition.npcModels = new int[]{100306};
				definition.combatLevel = 0;
				definition.standAnimation = MobDefinition.get(49).standAnimation;
				definition.walkAnimation = MobDefinition.get(49).walkAnimation;
				definition.actions = new String[5];
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 45;
				definition.scaleY = 45;
				break;
			case 9844:
				definition.setDefault();
				definition.name = "Mutated hound pet";
				definition.npcModels = new int[]{100305};
				definition.combatLevel = 0;
				definition.standAnimation = MobDefinition.get(138).standAnimation;
				definition.walkAnimation = MobDefinition.get(138).walkAnimation;
				definition.actions = new String[5];
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 32;
				definition.scaleY = 32;
				break;

			case 9845:
				definition.setDefault();
				definition.name = "Scorpion";
				definition.npcModels = new int[]{100313};
				definition.combatLevel = 200;
				definition.standAnimation = 1310 ;
				definition.walkAnimation = 1311 ;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 5;
				definition.scaleXZ = 220;
				definition.scaleY = 220;
				break;
			case 9846:
				definition.setDefault();
				definition.name = "Zombie";
				definition.npcModels = new int[]{100314};
				definition.combatLevel = 200;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 3;
				break;
			case 9847:
				definition.setDefault();
				definition.name = "Scorpion pet";
				definition.npcModels = new int[]{100313};
				definition.combatLevel = 0;
				definition.standAnimation = 1310 ;
				definition.walkAnimation = 1311 ;
				definition.actions = new String[5];
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 64;
				definition.scaleY = 64;
				break;
			case 9848:
				definition.setDefault();
				definition.name = "Zombie pet";
				definition.npcModels = new int[]{100314};
				definition.combatLevel = 0;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1	).walkAnimation;
				definition.actions = new String[5];
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				break;
			case 9849:
				definition.setDefault();
				definition.name = "Scorpion";
				definition.npcModels = new int[]{100313};
				definition.combatLevel = 200;
				definition.standAnimation = 1310 ;
				definition.walkAnimation = 1311 ;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 3;
				definition.headIcon = 0;
				break;
			case 9850:
				definition.setDefault();
				definition.name = "Scorpion";
				definition.npcModels = new int[]{100313};
				definition.combatLevel = 500;
				definition.standAnimation = 1310 ;
				definition.walkAnimation = 1311 ;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 3;
				definition.headIcon = 1;
				break;
			case 9851:
				definition.setDefault();
				definition.name = "Scorpion";
				definition.npcModels = new int[]{100313};
				definition.combatLevel = 200;
				definition.standAnimation = 1310 ;
				definition.walkAnimation = 1311 ;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 3;
				definition.headIcon = 2;
				break;

			case 13651:
				definition.degreesToTurn = MobDefinition.get(2292).degreesToTurn;
				definition.name = "Easter Eggs";
				break;
			case 1835:
				definition.name = "Sell Easter Tickets";
				break;
			case 9015:
				definition.name = "Group Ironman Manager";
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = 4113;//5316
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[]{"Talk-to", null, null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.npcModels = new int[5];
				definition.npcModels[0] = 65441; //HEAD
				definition.npcModels[1] = 65443; //BODY
				definition.npcModels[2] = 179; //GLOVES
				definition.npcModels[3] = 65445; //LEG
				definition.npcModels[4] = 185; //BOOT
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				definition.rdc2 = 91291;
				break;
            default:
                break;
        }
    }

    private static void applyCustomNpcs5(int id, MobDefinition definition) {
        switch (id) {
			case 1:
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.npcModels = new int[]{100130,100132,100134,179,185};
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;

			case 2:
				definition.combatLevel = MobDefinition.get(1).combatLevel;
				definition.standAnimation =  MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.npcModels = new int[]{80048,80050,80052,179,185};
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;

			case 3:
				definition.combatLevel = MobDefinition.get(1).combatLevel;
				definition.standAnimation =  MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.npcModels = new int[]{65441,65443,65445,179,185};
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;
			case 5838:
				definition.combatLevel = 0;
				definition.name = "Premium Exchange";
				definition.actions = new String[]{"Trade", null, null, null, null};
				break;
			case 3001:
				definition.name = "Gorilla pet";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 0;
				definition.scaleXZ = 60;
				definition.npcModels = new int[]{65154};
				//	definition.combatLevel = 785;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleY = 60;
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = false;

				break;
			case 3377:
				definition.name = "Yoshi pet";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 0;
				definition.scaleXZ = 100;
				//	definition.npcModels = new int[] {65154};
				//	definition.combatLevel = 785;
				//definition.standAnimation = 808;
				//definition.walkAnimation = 819;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.rdc2 = 7923;//blak 2822
				definition.drawYellowDotOnMap = false;

				break;
			case 3378:
				definition.name = "The Incredible Hulk";
				MobDefinition hulk2 = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{64064};
				definition.combatLevel = hulk2.combatLevel;
				definition.standAnimation = hulk2.standAnimation;
				definition.walkAnimation = hulk2.walkAnimation;
				definition.scaleXZ = hulk2.scaleXZ;
				definition.scaleY = hulk2.scaleY;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.rdc2 = 1112;
				definition.drawYellowDotOnMap = false;
				break;
			case 8009:
				definition.name = "Brutal Hulk";
				//	64064
				//65177
				definition.description = "Brutal.".getBytes();
				definition.npcModels = new int[]{64064};
				definition.combatLevel = 699;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 250;
				definition.scaleY = 250;
				//    definition.npcSizeInSquares =4 ;
				definition.actions = new String[]{null, "Attack", null, null, null};
				//definition.rdc2 = 5666;
				break;
			case 5001:
				definition.name = "Vegeta pet";
				definition.combatLevel = 0;

				definition.scaleXZ = 80;
				definition.scaleY = 80;
				definition.walkAnimation = 1660;
				definition.standAnimation = 11973;
				definition.npcModels = new int[9];
				definition.npcModels[0] = 65304; //HEAD
				definition.npcModels[1] = 246; //JAW
				definition.npcModels[2] = 65305; //CHEST
				//	definition.npcModels[3] = -1; //CAPE
				//definition.npcModels[4] = -1; //ARM
				definition.npcModels[5] = 65308; //HAND//shield
				//	definition.npcModels[6] = -1; //WEP
				definition.npcModels[7] = 65306; //LEG
				definition.npcModels[8] = 65307; //BOOT

				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = false;

				break;
			case 5382:
				definition.name = "Ultimate Ironman Dungeoneer";
				definition.description = "He's discovered a way for UIM to do Dungeoneering.".getBytes();
				definition.actions = new String[]{"Talk-to", null, "Quick-store", "Quick-retrieve", null, null, null};
				definition.combatLevel = 0;
				break;
			case 220:
				definition.name = "Guild Expert";
				definition.actions = new String[]{"Talk-to", null, "Options2", "Options3", "Options4", null, null};
				break;
			case 788:
				definition.name = "Lottery Expert";
				definition.actions = new String[]{"Talk-to", null, "Enter Lottery", "Check current pot", null, null, null};
				break;
			case 2067:
				definition.name = "@red@AFK fishing spot";
				definition.actions = new String[]{"Net", null, null, null, null, null, null};
				definition.rdc2 = 633;
				break;
			case 1050:
				definition.name = "Deep sea ghost";
				definition.actions = new String[]{"Teleport", null, null, null, null, null, null};
				break;
			case 5748:
				definition.name = "Deep sea Fishing spot";
				definition.actions = new String[]{"Harpoon", null, null, null, null, null, null};
				definition.rdc2 = 633;
				break;
			case 2577:
				definition.name = "Xxsk1ll3zxx";
				definition.description = "I hope that's the last time I ever type your name.".getBytes();
				definition.actions = new String[6];
				definition.actions[0] = "Talk-to";
				definition.actions[2] = "Follow";
				definition.actions[3] = "Trade";
				break;
			case 2643:
				definition.name = "Kids Ranq";
				definition.description = "Stupid noob uses a magic shortbow? Lol l2pk scrub.".getBytes();
				definition.actions = new String[6];
				definition.actions[0] = "Talk-to";
				definition.actions[2] = "Follow";
				definition.actions[3] = "Trade";
				definition.combatLevel = 103;
				break;
			case 1066:
				definition.name = "Ticket Exchange";
				definition.actions = new String[6];
				definition.actions[0] = "Talk-to";
				definition.actions[1] = "Exchange";
				definition.actions[2] = "Trade";
				definition.combatLevel = 0;
				definition.drawYellowDotOnMap = true;
				definition.rdc2 = 14449;
				definition.modelShadowing = 22;
				break;

			case 5210:
				definition.name = "La'Roy-Jahnkins";
				definition.description = "At least he's got turkey.".getBytes();
				definition.actions = new String[6];
				definition.actions[0] = "Talk-to";
				definition.actions[2] = "Follow";
				definition.actions[3] = "Trade";
				break;
			case 2589:
				definition.name = "An0nymous26";
				definition.description = "Browses 4chan.".getBytes();
				definition.actions = new String[6];
				definition.actions[0] = "Talk-to";
				definition.actions[2] = "Follow";
				definition.actions[3] = "Trade";
				break;
			case 2576:
				definition.name = "Snakeskin Guy";
				definition.description = "He was born at a very young age.".getBytes();
				definition.actions = new String[6];
				definition.actions[0] = "Talk-to";
				definition.actions[2] = "Follow";
				definition.actions[3] = "Trade";
				break;
			case 5604:
				definition.name = "Boss Point Store";
				definition.description = "Spend your boss points on some rewards in my shop!".getBytes();
				definition.actions = new String[6];
				definition.actions[0] = null;
				definition.actions[2] = null;
				definition.actions[3] = "Trade";
				break;
			case 736:
				definition.name = "Emily0_o";
				definition.description = "A `professional` grill gamer.".getBytes();
				definition.actions = new String[5];
				definition.actions[0] = "Ban";
				definition.actions[2] = "Follow on Twitch";
				definition.actions[3] = "Subscribe ($4.99/mo)";
				break;

			case 2782:
				definition.drawYellowDotOnMap = false;
				break;
			case 2578:
				definition.name = "Ima GuYiRL";
				definition.description = "Will get married for 1m lolzzzz.".getBytes();
				definition.actions = new String[6];
				definition.actions[0] = "Talk-to";
				definition.actions[2] = "Follow";
				definition.actions[3] = "Trade";
				break;
			case 2575:
				definition.name = "OrcRogueIRL";
				definition.description = "You can't see him, he's stealthed! ;)".getBytes();
				definition.actions = new String[6];
				definition.actions[0] = "Talk-to";
				definition.actions[2] = "Follow";
				definition.actions[3] = "Trade";
				break;
			case 433:
				definition.name = "iTry2tribryd";
				definition.description = "I bet was tri-bridding before it was cool.".getBytes();
				definition.actions = new String[6];
				definition.actions[0] = "Talk-to";
				definition.actions[2] = "Follow";
				definition.actions[3] = "Trade";
				break;
			case 6040:
				definition.standAnimation = 4113;//5316
				definition.actions = new String[]{"Talk-to", null, null, null, null};
				break;

			case 927:
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.actions = new String[]{"Bait", null, null, null, null};
				break;

			case 1541:
				definition.name = "Spirit";
				definition.actions = new String[]{"Talk-to", null, null, null, null};
				break;
			case 5861:
				definition.name = "The Riftsplitter";
				break;

			case 4650:
				definition.name = "Sir Lotto";
				definition.drawYellowDotOnMap = true;
				definition.actions = new String[]{"Talk-to", null, null, null, null};
				break;

			case 4653:
				definition.name = "Sir Away";
				MobDefinition worsk = get(1);
				definition.combatLevel = 0;
				definition.scaleXZ = 120;
				definition.scaleY = 120;
				definition.npcSizeInSquares = 1;
				definition.description = worsk.description;
				definition.drawYellowDotOnMap = true;
				definition.standAnimation = worsk.standAnimation;
				definition.walkAnimation = worsk.walkAnimation;
				definition.actions = new String[]{"Talk-to", null, null, null, null};
				definition.npcSizeInSquares = 1;
				break;
			case 438:
				definition.name = "Dark Supreme";
				definition.npcModels = new int[]{64427};
				MobDefinition lightguild = get(202);
				definition.combatLevel = 0;
				definition.scaleXZ = 250;
				definition.scaleY = 250;
				definition.npcSizeInSquares = 1;
				definition.description = lightguild.description;
				definition.drawYellowDotOnMap = true;
				definition.standAnimation = lightguild.standAnimation;
				definition.walkAnimation = lightguild.walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 1;
				break;
			case 6804:
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				break;
			case 440:
				definition.name = "Demon of Deity";
				definition.npcModels = new int[]{16358};
				MobDefinition lightguild1 = get(202);
				definition.combatLevel = 333;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.description = lightguild1.description;
				definition.drawYellowDotOnMap = true;
				definition.standAnimation = lightguild1.standAnimation;
				definition.walkAnimation = lightguild1.walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 1;
				//	definition.rdc2  = 47473432;
				break;
			case 19:
				definition.walkAnimation = 7046;
				break;//35.196.75.24

			case 434:
				definition.name = "Elvemage";
				definition.description = "Farcasting n3rd? Rofl get a lyfe. 1v1".getBytes();
				definition.actions = new String[6];
				definition.actions[0] = "Talk-to";
				definition.actions[2] = "Follow";
				definition.actions[3] = "Trade";
				break;
			case 6247:
				definition.npcModels = new int[]{28057, 28071, 28078, 28056};
				break;

			case 5529:
				definition.rdc2 = 3253;
				definition.walkAnimation = 5781;
				definition.standAnimation = 5785;
				definition.npcSizeInSquares = 2;
				break;
            default:
                break;
        }
    }

    private static void applyCustomNpcs6(int id, MobDefinition definition) {
        switch (id) {
			case 6873:
				//definition.rdc2 = 8248;
				definition.walkAnimation = 5781;
				definition.standAnimation = 5785;
				definition.npcSizeInSquares = 2;
				if (id == 6873) { //Yak summon
					definition.actions = new String[]{"Store", null, null, null, null};
				}
				break;
				
			case 13465:
				definition.combatLevel = 91;
				break;
				
			case 13469:
				definition.combatLevel = 128;
				break;
				
			case 13474:
				definition.combatLevel = 173;
				break;
				
			case 13478:
				definition.combatLevel = 224;
				break;
				
			case 13479:
				definition.name = "Supreme Dark beast";
				definition.scaleXZ = 200;
				definition.scaleY = 200;
				definition.rdc2 = 385238;
				definition.combatLevel = 301;
				break;

			case 1007:
				definition.name = "Supreme wizard";
				definition.actions = new String[]{"Talk-to", null, null, null, null, null, null};
				break;

			case 519:
				definition.actions = new String[]{"Talk-to", null, null, null, null, null, null};
				break;
				
			case 2938:
				definition.name = "Daily Rewards";
				break;
				
			case 4601:
				definition.name = "Loyalty Program";
				definition.actions = new String[]{"Talk-to", null, "Trade", null, null};
				break;
				
			case 2538:
				definition.name = "<img=28>Vote Manager";
				definition.actions = new String[]{"View Shop", null, null, null, null};
				definition.combatLevel = 0;
				definition.walkAnimation = 1660;
				definition.standAnimation = 4113;//5316
				break;
			case 741:
				definition.name = "<img=1891>Donator Store";
				definition.actions = new String[]{null, null, "View Shop", null, null, null, null};
				definition.combatLevel = 0;
				definition.walkAnimation = 1660;
				definition.standAnimation = 4113;//5316
				definition.originalModelColours = new int[1];
				definition.changedModelColours = new int[1];
				definition.originalModelColours[0] = 40; // current
				definition.changedModelColours[0] = 71; // New
				break;
			case 14:
				definition.name = "<col=fce38a>Billbag+ store";
				break;
			case 10030:
				definition.name = "Silverhawk";
				definition.npcModels = MobDefinition.get(6222).npcModels;
				definition.combatLevel = 0;
				definition.standAnimation =   MobDefinition.get(6222).standAnimation;
				definition.walkAnimation =  MobDefinition.get(6222).walkAnimation;
				definition.actions = new String[] {null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 2;
				definition.scaleXZ = 90;
				definition.scaleY = 90;
				break;

			case 10031:
				definition.name = "Silverhawk pet";
				definition.npcModels = MobDefinition.get(6222).npcModels;
				definition.combatLevel = 0;
				definition.standAnimation =   MobDefinition.get(6222).standAnimation;
				definition.walkAnimation =  MobDefinition.get(6222).walkAnimation;
				definition.actions = new String[] {null, null, null, null, null};
				definition.drawYellowDotOnMap = false;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 25;
				definition.scaleY = 25;
				break;
			case 10032:
				definition.name = "Avianse";
				definition.npcModels = MobDefinition.get(6246).npcModels;
				definition.combatLevel = 0;
				definition.standAnimation =   MobDefinition.get(6246).standAnimation;
				definition.walkAnimation =  MobDefinition.get(6246).walkAnimation;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.scaleXZ = definition.scaleY = 55;
				break;

			case 1837:
				definition.name = "Ancient Mage";
				definition.description = "Creepy... yet helpful. Trade your Trio Tokens to him.".getBytes();
				definition.combatLevel = 0;
				definition.actions = new String[]{"Talk-to", null, "Quick-tele to Trio", null, null, null, null};
				definition.npcModels = new int[5];
				definition.npcModels[0] = 62737;
				definition.npcModels[1] = 62745;
				definition.npcModels[2] = 62740;
				definition.npcModels[3] = 62735;
				definition.npcModels[4] = 62734;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				break;
			case 3580:
				definition.combatLevel = 80;
				break;

			case 2891:
				definition.name = "Whirpool";
				definition.description = "You do not want to fall in there!".getBytes();
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[1];
				definition.npcModels[0] = 26699;
				definition.scaleY = 100;
				definition.scaleXZ = 100;
				definition.npcSizeInSquares = 5;
				ObjectDefinition whirpool2 = ObjectDefinition.forID(25275);
				definition.walkAnimation = whirpool2.animation;
				definition.standAnimation = whirpool2.animation;
				definition.combatLevel = 0;
				break;
			case 2895:
				definition.name = "Whirpool";
				definition.description = "You do not want to fall in there!".getBytes();
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[1];
				definition.npcModels[0] = 26699;
				definition.scaleY = 50;
				definition.scaleXZ = 50;
				definition.npcSizeInSquares = 4;
				ObjectDefinition whirpool = ObjectDefinition.forID(25275);
				definition.walkAnimation = whirpool.animation;
				definition.standAnimation = whirpool.animation;
				definition.combatLevel = 0;
				break;
			case 2900:
				definition.name = "Whirpool";
				definition.description = "You do not want to fall in there!".getBytes();
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[1];
				definition.npcModels[0] = 26699;
				definition.scaleY = 50;
				definition.scaleXZ = 50;
				definition.npcSizeInSquares = 4;
				ObjectDefinition whirpool1 = ObjectDefinition.forID(25275);
				definition.walkAnimation = whirpool1.animation;
				definition.standAnimation = whirpool1.animation;
				definition.combatLevel = 0;
				break;
			case 2902:
				definition.name = "Whirpool";
				definition.description = "You do not want to fall in there!".getBytes();
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[1];
				definition.npcModels[0] = 26699;
				definition.scaleY = 50;
				definition.scaleXZ = 50;
				definition.npcSizeInSquares = 4;
				ObjectDefinition whirpool11 = ObjectDefinition.forID(25275);
				definition.walkAnimation = whirpool11.animation;
				definition.standAnimation = whirpool11.animation;
				definition.combatLevel = 0;
				break;
			case 2903:
				definition.name = "Whirpool";
				definition.description = "You do not want to fall in there!".getBytes();
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[1];
				definition.npcModels[0] = 26699;
				definition.scaleY = 50;
				definition.scaleXZ = 50;
				definition.npcSizeInSquares = 4;
				ObjectDefinition whirpool111 = ObjectDefinition.forID(25275);
				definition.walkAnimation = whirpool111.animation;
				definition.standAnimation = whirpool111.animation;
				definition.combatLevel = 0;
				break;
			case 2127:
				definition.name = "Snakeling";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[1];
				definition.npcModels[0] = 14407;
				definition.standAnimation = 5070;
				definition.walkAnimation = 5070;
				definition.combatLevel = 1;
				definition.scaleY = 30;
				definition.scaleXZ = 30;
				break;
			case 2128:
				definition.name = "Snakeling";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[1];
				definition.npcModels[0] = 14408;
				definition.standAnimation = 5070;
				definition.walkAnimation = 5070;
				definition.combatLevel = 725;
				definition.scaleY = 30;
				definition.scaleXZ = 30;
				break;
			case 2129:
				definition.name = "Snakeling";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[1];
				definition.npcModels[0] = 14409;
				definition.standAnimation = 5070;
				definition.walkAnimation = 5070;
				definition.combatLevel = 725;
				definition.scaleY = 30;
				definition.scaleXZ = 30;
				break;
			case 2042://regular
				definition.name = "Zulrah";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[1];
				definition.npcModels[0] = 14408;
				definition.standAnimation = 5070;
				definition.walkAnimation = 5070;
				definition.combatLevel = 725;
				definition.scaleY = 100;
				definition.scaleXZ = 100;
				break;
			case 2043://melee
				definition.name = "Zulrah";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[1];
				definition.npcModels[0] = 14409;
				definition.standAnimation = 5070;
				definition.walkAnimation = 5070;
				definition.combatLevel = 725;
				definition.scaleY = 100;
				definition.scaleXZ = 100;
				break;
			case 2044://mage
				definition.name = "Zulrah";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[1];
				definition.npcModels[0] = 14407;
				definition.standAnimation = 5070;
				definition.walkAnimation = 5070;
				definition.combatLevel = 725;
				definition.scaleY = 100;
				definition.scaleXZ = 100;
				break;
			case 2000:
				definition.npcModels = new int[2];
				definition.npcModels[0] = 28294;
				definition.npcModels[1] = 28295;
				definition.name = "Venenatis";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.scaleY = 200;
				definition.scaleXZ = 200;
				MobDefinition ven = get(2035);
				definition.standAnimation = ven.standAnimation;
				definition.walkAnimation = ven.walkAnimation;
				definition.combatLevel = 464;
				definition.npcSizeInSquares = 5;
				break;
			case 2001:
				definition.npcModels = new int[1];
				definition.npcModels[0] = 28293;
				definition.name = "Scorpia";
				definition.actions = new String[]{null, "Attack", null, null, null};
				MobDefinition scor = get(107);
				definition.standAnimation = scor.standAnimation;
				definition.walkAnimation = scor.walkAnimation;
				definition.combatLevel = 464;
				definition.npcSizeInSquares = 3;
				break;
			case 109:
				definition.name = "Baby Scorpion";
				definition.combatLevel = 80;
				break;
			case 2006:
				definition.npcModels = new int[1];
				definition.npcModels[0] = 28299;
				definition.name = "Vet'ion";
				definition.actions = new String[]{null, "Attack", null, null, null};
				MobDefinition vet = get(90);
				definition.standAnimation = vet.standAnimation;
				definition.walkAnimation = vet.walkAnimation;
				definition.combatLevel = 464;
				break;
			case 2007:
				definition.name = "Kraken";
				definition.actions = new String[]{null, "Attack", null, null, null};
				MobDefinition eld = get(3847);
				definition.npcModels = new int[1];
				definition.npcModels[0] = 28231;
				definition.combatLevel = 291;
				definition.standAnimation = 3989;
				definition.walkAnimation = eld.walkAnimation;
				definition.scaleY = definition.scaleXZ = 140;
				definition.npcSizeInSquares = 5;
				//definition.rdc2 = 800;
				break;
			case 2008:
				definition.npcModels = new int[1];
				definition.npcModels[0] = 28231;
				definition.name = "Cave kraken";
				definition.actions = new String[]{null, "Attack", null, null, null};
				MobDefinition cave = get(3847);
				definition.combatLevel = 127;
				definition.standAnimation = 3989;
				definition.walkAnimation = cave.walkAnimation;
				definition.scaleY = definition.scaleXZ = 42;
				break;
			case 2009:
				definition.name = "Callisto";
				definition.npcModels = new int[]{28298};
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 470;
				MobDefinition callisto = get(1326);
				definition.standAnimation = callisto.standAnimation;
				definition.walkAnimation = callisto.walkAnimation;
				definition.actions = callisto.actions;
				definition.scaleY = 110;
				definition.scaleXZ = 100;
				definition.npcSizeInSquares = 4;
				break;


			case 198:
				definition.name = "Master Warrior";
				definition.description = "Born to kill".getBytes();
				definition.npcModels = new int[7];
				definition.npcModels[0] = 65530; //pern mask
				definition.npcModels[1] = 65275; //pern body
				definition.npcModels[2] = 65485; //pern legs
				definition.npcModels[3] = 65105; //max
				definition.npcModels[4] = 13319; //bgloves
				definition.npcModels[5] = 53309; //glaivens
				definition.npcModels[6] = 19553; //bow
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.originalModelColours = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				definition.changedModelColours = new int[1]; // same here
				definition.changedModelColours[0] = 40; // the texture that it currently has
				definition.originalModelColours[0] = 52; // the new texture u want it to have
				break;

			case 1821:
				definition.name = "<col=89584A>Fantasy Being";
				definition.description = "a God from the Fantasy Realm".getBytes();
				definition.npcModels = new int[]{19712};
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 120;
				definition.scaleY = 120;
				break;

			case 200:
				definition.name = "The Diminisher";
				definition.description = "Thanks for the memories.".getBytes();
				definition.combatLevel = 439;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{22349};
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.originalModelColours = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				definition.changedModelColours = new int[1]; // same here
				definition.changedModelColours = new int[]{52};
				definition.originalModelColours = new int[]{111};
				break;

			case 457:
				definition.name = "Revenant Citizen";
				definition.rdc2 = 2929529;
				definition.actions = new String[]{"Talk-to", null, "Teleport", null, null};
				break;
            default:
                break;
        }
    }

    private static void applyCustomNpcs7(int id, MobDefinition definition) {
        switch (id) {
			case 6139:
				definition.scaleXZ = definition.scaleY = 100;
				break;

			case 5417:
				definition.combatLevel = 210;
				break;

			case 5418:
				definition.combatLevel = 90;
				break;

			case 6715:
				definition.combatLevel = 14;
				break;

			case 6716:
				definition.combatLevel = 16;
				break;

			case 6701:
				definition.combatLevel = 53;
				break;

			case 6725:
				definition.combatLevel = 98;
				break;

			case 6691://dark beast
				definition.npcSizeInSquares = 2;
				definition.combatLevel = 112;
				break;

			case 8710:
			case 8707:
			case 8706:
			case 8705:
				definition.name = "Musician";
				definition.actions = new String[]{"Listen-to", null, null, null, null};
				break;

			case 131:
				definition.name = "Penguin";
				definition.scaleXZ = 120;
				definition.scaleY = 120;
				break;
			case 5188:
				definition.name = "Yeti";
				definition.scaleXZ = 120;
				definition.scaleY = 120;
				break;
			case 8405:
				definition.name = "<col=5af96d>Penguin Shop";
				definition.actions = new String[]{"Trade", null, null, null, null};
				definition.scaleXZ = 150;
				definition.scaleY = 150;
				break;
			case 4651:
				definition.name = "<col=5af96d>Player Owned Shop Manager";
				definition.actions = new String[]{"Talk-to", null, "View Shops", "My Shop", "Claim Earnings"};
				break;

			case 4652:
				definition.name = "<col=aedaf9>Currency Exchange";
				definition.actions = new String[]{"Talk-to", null, null, null, null};
				break;

			case 4896:
				definition.name = "Zeus";
				definition.npcModels = new int[]{58935};
				definition.actions = new String[]{"Talk-to", null, null, null, null};
				break;

			case 947:
				definition.name = "Grand Exchange clerk";
				break;

			case 9939:
				definition.combatLevel = 607;
				break;

			case 4540:
				definition.npcModels = new int[]{16429};
				definition.name = "@cya@Colossal Avatar";
				definition.npcSizeInSquares = 4;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = definition.scaleY = 150;
				definition.combatLevel = 299;
				break;

			case 4476:
				definition.actions = new String[]{"Talk-to", null, "Start-minigame", "Trade", null};
				break;

			case 6222:
				definition.name = "Kree'arra";
				definition.npcSizeInSquares = 5;
				definition.standAnimation = 6972;
				definition.walkAnimation = 6973;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.scaleXZ = definition.scaleY = 110;
				break;

			case 6203:
				definition.npcModels = new int[]{27768, 27773, 27764, 27765, 27770};
				definition.name = "K'ril Tsutsaroth";
				definition.npcSizeInSquares = 5;
				definition.standAnimation = 6943;
				definition.walkAnimation = 6942;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.scaleXZ = definition.scaleY = 110;
				break;

			case 1610:
			case 491:
			case 10216:
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;

			case 7969:
				definition.actions = new String[]{"Talk-to", null, "Trade", null, null};
				break;

			case 8275:
				definition.name = "Duradel (Medium)";
				definition.actions = new String[]{"Talk-to", null, "Get-task", "Trade", "Rewards"};
				break;

			case 9085:
				definition.name = "Kuradal (Hard)";
				break;

			case 7780:
				definition.name = "Sumona (Elite)";
				break;

			case 925:
				definition.name = "<img=15>Slayer GrandMaster";
				definition.actions = new String[]{"Talk-to", null, "Get-task", "Trade", null};
				definition.npcModels = new int[]{57778};
				definition.dialogueModels = null;
				definition.scaleXZ = 180;
				definition.scaleY = 180;
				break;

			case 1382:
				definition.name = "Glacor";
				definition.npcModels = new int[]{58940};
				definition.npcSizeInSquares = 3;
				definition.scaleY = definition.scaleXZ = 180;
				definition.standAnimation = 10869;
				definition.walkAnimation = 10867;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 123;
				definition.drawYellowDotOnMap = true;
				definition.combatLevel = 188;
				break;

			case 4249:
				definition.name = "Gambler";
				break;

			case 6970:
				definition.actions = new String[]{"Trade", null, "Exchange Shards", null, null};
				break;

			case 4657:
				definition.actions = new String[]{"Talk-to", null, "Claim Items", "Check Total", "Teleport"};
				break;

			case 8549:
				definition.name = "Floreox Bird";
				definition.rdc2 = 9978;
				break;

			case 8591:
				definition.actions = new String[]{"Talk-to", null, "Trade", null, null};
				break;

			case 316:
				definition.name = "River fishing spot";
				definition.scaleXZ = 30;
				break;

			case 315:
				definition.scaleXZ = 30;
				break;
            default:
                break;
        }
    }

    private static void applyCustomNpcs8(int id, MobDefinition definition) {
        switch (id) {
			case 309:
				definition.scaleXZ = 30;
				break;

			case 310:
				definition.scaleXZ = 30;
				break;

			case 314:
				definition.scaleXZ = 30;
				break;

			case 312:
				definition.name = "Sea fishing spot";
				definition.scaleXZ = 30;
				break;

			case 313:
				definition.name = "Ocean fishing spot";
				definition.scaleXZ = 30;
				break;

			case 318:
				definition.name = "Monk fishing spot";
				definition.scaleXZ = 30;
				definition.actions = new String[]{"Net", null, "Lure", null, null};
				break;

			case 805:
				definition.actions = new String[]{"Trade", null, "Tan hide", null, null};
				break;

			case 461:
			case 844:
			case 650:
			case 5112:
			case 3789:
			case 802:
			case 521:
			case 11226:
			case 4906:
			case 308:
				definition.actions = new String[]{"Trade", null, null, null, null};
				break;

			case 520:
				definition.name = "General Store <col=bfa0fe>(@yel@Sell Junk<col=bfa0fe>)";
				definition.actions = new String[]{"Trade", null, null, null, null};
				break;

			case 13635:
				definition.name = "Titanium Ripper";
				definition.npcModels = new int[] {17216};
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 800;
				definition.standAnimation = 808;
				definition.walkAnimation = 809;
				definition.npcSizeInSquares = 1;
				break;

			case 970:
				definition.actions = new String[]{"Event Shop", null, null, null, null};
				break;

			case 8022:
			case 8028:
				String color = id == 8022 ? "Yellow" : "Green";
				definition.name = "" + color + " energy source";
				definition.actions = new String[]{"Siphon", null, null, null, null};
				break;

			case 8444:
				definition.actions = new String[5];
				definition.actions[0] = "Trade";
				break;

			case 2579:
				definition.name = "Prestige Master";
				definition.description = "Prestige Master.".getBytes();
				definition.combatLevel = 126;
				definition.actions = new String[5];
				definition.actions[0] = "Talk-to";
				definition.actions[2] = "Trade";
				definition.npcModels = new int[7];
				definition.npcModels[0] = 55761;
				definition.npcModels[1] = 62746;
				definition.npcModels[2] = 62743;
				definition.npcModels[3] = 65297;
				definition.npcModels[4] = 13319;
				definition.npcModels[5] = 27738;
				definition.npcModels[6] = 20147;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				break;

			case 810:
				definition.name = "Champion";
				definition.description = "Champion.".getBytes();
				definition.npcModels = new int[]{2545};
				definition.combatLevel = 624;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 350;
				definition.scaleY = 300;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.rdc2 = 1112;
				break;

			case 811:
				definition.name = "Hades";
				definition.description = "Hades.".getBytes();
				definition.npcModels = new int[]{65028};
				definition.combatLevel = 624;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 200;
				definition.scaleY = 200;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.rdc2 = 240250;
				break;

			case 812:
				definition.name = "Stoned toad";
				definition.description = "stoned toad.".getBytes();
				definition.npcModels = new int[]{65145};
				definition.combatLevel = 699;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 200;
				definition.scaleY = 200;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;

			case 8000:
				definition.name = "Galvek the great";
				definition.description = "Great Swordsman.".getBytes();
				definition.npcModels = new int[]{65172};
				definition.combatLevel = 699;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 180;
				definition.scaleY = 180;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;

			case 8617:
				definition.name = "Alchemical Hydra";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 426;
				definition.npcModels = new int[]{65318, 65319};
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				definition.standAnimation = 8240;
				definition.walkAnimation = 8239;
				definition.npcSizeInSquares = 6;
				break;

			case 8002:
				definition.name = "Malvek the wonderer";
				definition.description = "Great Swordsman.".getBytes();
				definition.npcModels = new int[]{65172};
				definition.combatLevel = 699;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 180;
				definition.scaleY = 180;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.rdc2 = 73533;
				break;

			case 8004:
				definition.name = "Mahatma Gandhi";
				definition.description = "Mahatma Gandhi.".getBytes();
				definition.npcModels = new int[]{65173};
				definition.combatLevel = 699;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;

			case 8005:
				definition.name = "Blood sorceror";
				definition.description = "Blood sorceror.".getBytes();
				definition.npcModels = new int[]{65174};
				definition.combatLevel = 699;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;

			case 8006:
				definition.name = "Mist sorceror";
				definition.description = "Blood sorceror.".getBytes();
				definition.npcModels = new int[]{65174};
				definition.combatLevel = 699;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.rdc2 = 19385;
				break;

			case 8007:
				definition.name = "Bob marley";
				definition.description = "Bob marley.".getBytes();
				definition.npcModels = new int[]{65175};
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;

			case 8008:
				definition.npcModels = new int[]{65176};
				definition.name = "Avatar Titan";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 138;
				definition.standAnimation = 7949;
				definition.walkAnimation = 7952;
				definition.scaleXZ = 150;
				definition.scaleY = 150;
				definition.npcSizeInSquares = 2;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.rdc2 = 2232356;
				break;


			case 3300:
				definition.name = "Corporeal Beast";
				MobDefinition definition2 = MobDefinition.get(8133);
				definition.description = "Corporeal beast.".getBytes();
				definition.npcModels = new int[]{64059};
				definition.combatLevel = definition2.combatLevel;
				definition.standAnimation = definition2.standAnimation;
				definition.walkAnimation = definition2.walkAnimation;
				definition.scaleXZ = definition2.scaleXZ;
				definition.scaleY = definition2.scaleY;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 3301:
				definition.name = "WildyWyrm 1";
				MobDefinition Wyrm2 = MobDefinition.get(3334);
				definition.description = "WildyWyrm.".getBytes();
				definition.npcModels = new int[]{64060};
				definition.combatLevel = Wyrm2.combatLevel;
				definition.standAnimation = Wyrm2.standAnimation;
				definition.walkAnimation = Wyrm2.walkAnimation;
				definition.scaleXZ = Wyrm2.scaleXZ;
				definition.scaleY = Wyrm2.scaleY;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 3302:
				definition.name = "WildyWyrm 2";
				MobDefinition Wyrm3 = MobDefinition.get(3334);
				definition.description = "WildyWyrm.".getBytes();
				definition.npcModels = new int[]{64061};
				definition.combatLevel = Wyrm3.combatLevel;
				definition.standAnimation = Wyrm3.standAnimation;
				definition.walkAnimation = Wyrm3.walkAnimation;
				definition.scaleXZ = Wyrm3.scaleXZ;
				definition.scaleY = Wyrm3.scaleY;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 3303:
				definition.name = "Donkey Kong";
				MobDefinition gwd = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{64062};
				definition.combatLevel = gwd.combatLevel;
				definition.standAnimation = gwd.standAnimation;
				definition.walkAnimation = gwd.walkAnimation;
				definition.scaleXZ = gwd.scaleXZ;
				definition.scaleY = gwd.scaleY;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;

			case 3304:
				definition.name = "Thor";
				MobDefinition Thor = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{64063};
				definition.combatLevel = Thor.combatLevel;
				definition.standAnimation = Thor.standAnimation;
				definition.walkAnimation = Thor.walkAnimation;
				definition.scaleXZ = Thor.scaleXZ;
				definition.scaleY = Thor.scaleY;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
            default:
                break;
        }
    }

    private static void applyCustomNpcs9(int id, MobDefinition definition) {
        switch (id) {
			case 3305:
				definition.name = "Naraku";
				MobDefinition theincredhulk = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.combatLevel = 456;
				definition.npcModels = new int[]{14939,14940,14941,14942,14943,14944};
				definition.combatLevel = theincredhulk.combatLevel;
				definition.standAnimation = theincredhulk.standAnimation;
				definition.walkAnimation = theincredhulk.walkAnimation;
				definition.scaleXZ = 270;
				definition.scaleY = 270;
				definition.npcSizeInSquares = 2;
				definition.actions = new String[]{null, "Attack", null, null, null};
				//definition.rdc2 = 6211;
				break;
				
			case 1890:
				definition.name = "Charizard pet";
				MobDefinition chari = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{64067};

				definition.combatLevel = 0;

				definition.standAnimation = chari.standAnimation;
				definition.walkAnimation = chari.walkAnimation;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.actions = new String[5];
				definition.actions[0] = null;
				//definition.rdc2 = 664466;
				break;

			case 1892:
				definition.name = "Mario pet";
				MobDefinition chari1 = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{64223};
				definition.combatLevel = chari1.combatLevel;
				definition.standAnimation = chari1.standAnimation;
				definition.walkAnimation = chari1.walkAnimation;
				definition.scaleXZ = 100;
				definition.drawYellowDotOnMap = false;
				definition.scaleY = 100;
				definition.combatLevel = 0;
				definition.actions = new String[5];
				definition.actions[0] = null;
				//definition.rdc2 = 664466;
				break;

			case 1902:
				definition.name = "Bumble bee pet";
				MobDefinition chevycama = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{64304};
				definition.combatLevel = chevycama.combatLevel;
				definition.standAnimation = chevycama.standAnimation;
				definition.walkAnimation = chevycama.walkAnimation;
				definition.scaleXZ = 80;
				definition.drawYellowDotOnMap = false;
				definition.scaleY = 80;
				definition.combatLevel = 0;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.rdc2 = 664466;
				break;
			case 1801:
				definition.name = "Raichu Pet";//this is raichu
				MobDefinition adminspet = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{64448}; // where is this.
				definition.combatLevel = adminspet.combatLevel;
				definition.standAnimation = adminspet.standAnimation;
				definition.walkAnimation = adminspet.walkAnimation;
				definition.scaleXZ = 80;
				definition.drawYellowDotOnMap = false;
				definition.scaleY = 80;
				definition.combatLevel = 0;
				definition.actions = new String[5];
				definition.actions[0] = null;

				break;
			case 1904:
				definition.name = "Super star pet";
				MobDefinition sueprstrar = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{64305};
				definition.combatLevel = sueprstrar.combatLevel;
				definition.standAnimation = sueprstrar.standAnimation;
				definition.walkAnimation = sueprstrar.walkAnimation;
				definition.scaleXZ = 80;
				definition.drawYellowDotOnMap = false;
				definition.scaleY = 80;
				definition.combatLevel = 0;
				definition.actions = new String[5];
				definition.actions[0] = null;
				//definition.rdc2 = 664466;
				break;
			case 1905:
				definition.name = "Car";
				MobDefinition grandchevy = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{64304};
				definition.combatLevel = grandchevy.combatLevel;
				definition.standAnimation = grandchevy.standAnimation;
				definition.walkAnimation = grandchevy.walkAnimation;
				definition.scaleXZ = 100;
				definition.drawYellowDotOnMap = false;
				definition.scaleY = 100;
				definition.combatLevel = 0;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.rdc2 = 99733;
				break;
			case 1901:
				definition.name = "Universal star pet";
				MobDefinition cars2 = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{64304};
				definition.combatLevel = cars2.combatLevel;
				definition.standAnimation = cars2.standAnimation;
				definition.walkAnimation = cars2.walkAnimation;
				definition.scaleXZ = 100;
				definition.drawYellowDotOnMap = false;
				definition.scaleY = 100;
				definition.combatLevel = 0;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.rdc2 = 441199;
				//definition.rdc2 = 664466;
				break;
			case 1906:
				definition.name = "Zorbak (Elite)";
				MobDefinition zorkak = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{64476};
				definition.combatLevel = zorkak.combatLevel;
				definition.standAnimation = zorkak.standAnimation;
				definition.walkAnimation = zorkak.walkAnimation;
				definition.scaleXZ = 120;
				definition.drawYellowDotOnMap = false;
				definition.scaleY = 120;
				definition.combatLevel = 0;
				definition.actions = new String[5];
				definition.actions[0] = null;
				//   definition.rdc2 = 441199;
				//definition.rdc2 = 664466;
				break;
			case 1910:
				definition.name = "@or2@Youtube Junior";

				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcModels = new int[]{97666};
				definition.npcSizeInSquares = 1;
				definition.combatLevel = 0;
				definition.standAnimation = 11973;
				definition.walkAnimation = 11975;
				definition.scaleXZ = 30;
				definition.scaleY = 30;
				break;
			case 1893:
				definition.name = "Sonic pet";
				MobDefinition sonicx = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{64224};
				definition.combatLevel = sonicx.combatLevel;
				definition.standAnimation = sonicx.standAnimation;
				definition.walkAnimation = sonicx.walkAnimation;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.drawYellowDotOnMap = false;
				definition.actions = new String[5];
				definition.combatLevel = 0;
				definition.actions[0] = null;
				//definition.rdc2 = 664466;
				break;
			case 1894:
				definition.name = "Donkeykong pet";
				MobDefinition donkeyk = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{64225};
				definition.combatLevel = donkeyk.combatLevel;
				definition.standAnimation = donkeyk.standAnimation;
				definition.walkAnimation = donkeyk.walkAnimation;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 0;
				definition.drawYellowDotOnMap = false;
				//definition.rdc2 = 664466;
				break;
			case 1896:
				definition.name = "Maximus pet";
				MobDefinition chari11 = MobDefinition.get(53);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{64226};
				definition.combatLevel = chari11.combatLevel;
				definition.standAnimation = chari11.standAnimation;
				definition.walkAnimation = chari11.walkAnimation;
				definition.scaleXZ = 20;
				definition.scaleY = 20;
				definition.actions = new String[5];
				definition.drawYellowDotOnMap = false;
				definition.combatLevel = 0;
				definition.actions[0] = null;
				//definition.rdc2 = 664466;
				break;
			case 1897:
				definition.name = "Spyro";
				MobDefinition mixmiads = MobDefinition.get(53);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{64290};
				definition.combatLevel = mixmiads.combatLevel;
				definition.standAnimation = mixmiads.standAnimation;
				definition.walkAnimation = mixmiads.walkAnimation;
				definition.scaleXZ = 120;
				definition.scaleY = 120;
				definition.actions = new String[5];
				definition.drawYellowDotOnMap = false;
				definition.actions[0] = null;
				//definition.rdc2 = 664466;
				break;

			case 9767:
				definition.name = "Crimson";
				definition.combatLevel = 0;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 3;
				definition.scaleXZ = 180;
				definition.scaleY = 180;
				definition.originalModelColours = new int[] {64790, 64536, 64568, 64573, 8498, 8522, 64907, 5290, 5301, 64788, 64662, 7440, 64640, 64795, 64565, 64566, 20287, 64671, 5305, 64643, 64521, 5296, 64556, 64552, 64541, 64529, 64576, 64526, 5280, 64522, 5281, 64539, 64802, 64900, 64652, 64679, 64791, 64530, 64551, 64534, 64782, 64571, 5311, 64580, 64546, 64772, 64548, 64547, 64561, 64649, 64670, 64807, 64654, 64554, 64516, 64512, 64656, 64569, 8514, 64684, 64812, 64669, 64524, 64528, 64792, 5318, 64564, 64560, 64675, };
				definition.changedModelColours = new int[] {85823, 64536, 64568, 64573, 8498, 8522, 25, 5290, 5301, 85823, 85823, 7440, 64640, 87823, 64565, 64566, 20287, 87823, 5305, 64643, 64521, 5296, 64556, 64552, 64541, 64529, 64576, 64526, 5280, 64522, 5281, 64539, 85823, 64900, 85823, 85823, 87823, 12, 64551, 64534, 85823, 64571, 5311, 64580, 64546, 25, 64548, 64547, 64561, 85823, 87823, 87823, 25, 64554, 25, 64512, 87823, 64569, 8514, 85823, 87823, 87823, 64524, 25, 87823, 5318, 64564, 64560, 87823, };
				break;

			case 4285:
				definition.name = "Item Exchange";
				definition.scaleXZ = 130;
				definition.drawYellowDotOnMap = true;
				definition.scaleY = 130;
				definition.combatLevel = 0;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.actions = new String[5];
				definition.actions[0] = "Trade";

				break;

			case 8711:
				definition.name = "Mini lucifer";
				MobDefinition miniLucifer = MobDefinition.get(2292);
				definition.npcModels = new int[]{100000, 100001, 100002, 100003, 100004, 100005};
				definition.combatLevel = miniLucifer.combatLevel;
				definition.standAnimation = miniLucifer.standAnimation;
				definition.walkAnimation = miniLucifer.walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 120;
				definition.scaleY = 120;
				break;
			case 8712:
				definition.name = "Lucifer";
				MobDefinition lucifer = MobDefinition.get(2292);
				definition.npcModels = new int[]{100000, 100001, 100002, 100003, 100004, 100005};
				definition.combatLevel = lucifer.combatLevel;
				definition.standAnimation = lucifer.standAnimation;
				definition.walkAnimation = lucifer.walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 225;
				definition.scaleY = 225;
				break;
			case 1988:
				definition.name = "<img=15>Slayer Progression";
				MobDefinition spryi2 = MobDefinition.get(53);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{64290};
				definition.combatLevel = 0;
				definition.standAnimation = spryi2.standAnimation;
				definition.walkAnimation = spryi2.walkAnimation;
				definition.scaleXZ = 110;
				definition.scaleY = 110;
				definition.actions = new String[5];
				definition.drawYellowDotOnMap = true;
				definition.actions[0] = null;
				definition.rdc2 = 252525;
				definition.actions = new String[5];
				definition.actions[0] = "Talk-to";
				break;

			case 3309:
				definition.npcModels = new int[]{64100};
				definition.name = "<col=f8ac00>double afk pet";
				MobDefinition doubldon = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.combatLevel = doubldon.combatLevel;
				definition.standAnimation = doubldon.standAnimation;
				definition.walkAnimation = doubldon.walkAnimation;
				definition.scaleXZ = 20;
				definition.drawYellowDotOnMap = false;
				definition.scaleY = 20;
				definition.actions = new String[5];
				definition.actions[0] = null;
				break;

			case 8802:
				definition.name = "<col=f8ac00>Double vote pet";
				MobDefinition darkath = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{20565};
				definition.combatLevel = darkath.combatLevel;
				definition.standAnimation = darkath.standAnimation;
				definition.walkAnimation = darkath.walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = false;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 15;
				definition.scaleY = 15;
				break;
			case 9011:
				definition.name = "Fallen Warrior";
				MobDefinition fallenWarrior = MobDefinition.get(2292);
				definition.npcModels = new int[]{17030};
				definition.combatLevel = fallenWarrior.combatLevel;
				definition.standAnimation = fallenWarrior.standAnimation;
				definition.walkAnimation = fallenWarrior.walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 120;
				definition.scaleY = 120;
				break;
			case 9012:
				definition.name = "Fallen Angel";
				MobDefinition fallenAngel = MobDefinition.get(2292);
				definition.npcModels = new int[]{17049,17056,17061,17066,17097,17197};
				definition.combatLevel = fallenAngel.combatLevel;
				definition.standAnimation = fallenAngel.standAnimation;
				definition.walkAnimation = fallenAngel.walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 200;
				definition.scaleY = 200;
				break;

			case 9312:
				definition.name = "Nephilim Warrior";
				MobDefinition Shinda = MobDefinition.get(2292);
				definition.npcModels = new int[]{18446,18486,18511,18516,18519,18520,18525,18527,18528};
				definition.combatLevel = Shinda.combatLevel;
				definition.standAnimation = Shinda.standAnimation;
				definition.walkAnimation = Shinda.walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 4;
				definition.scaleXZ = 350;
				definition.scaleY = 350;
				break;
			case 9013:
				definition.name = "Fallen Angel pet";
				MobDefinition luciferPet = MobDefinition.get(2292);
				definition.npcModels = new int[]{17049,17056,17061,17066,17097,17197};
				definition.combatLevel = luciferPet.combatLevel;
				definition.standAnimation = luciferPet.standAnimation;
				definition.walkAnimation = luciferPet.walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = false;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				break;
			case 9014:
				definition.name = "Zelos";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 120;
				definition.scaleY = 120;
				definition.npcModels = new int[1];
				definition.npcModels[0] = 20563;
				definition.drawYellowDotOnMap = true;
				break;

			case 9016:
				definition.name = "Levincia The Great pet";
				MobDefinition ironPet = MobDefinition.get(2292);
				definition.npcModels = new int[]{100026};
				definition.combatLevel = ironPet.combatLevel;
				definition.standAnimation = ironPet.standAnimation;
				definition.walkAnimation = ironPet.walkAnimation;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.drawYellowDotOnMap = false;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 50;
				definition.scaleY = 50;
				break;

			case 9319:
				definition.name = "Zenyte Golem";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 170;
				definition.scaleY = 170;
				definition.npcModels = new int[1];
				definition.npcModels[0] = 100027;
				definition.drawYellowDotOnMap = true;
				break;

			case 9017:
				definition.name = "Nightmare Boss";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 2;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 170;
				definition.scaleY = 170;
				definition.npcModels = new int[1];
				definition.npcModels[0] = 14959;
				definition.drawYellowDotOnMap = true;

				break;
			case 302:
				MobDefinition x2 = MobDefinition.get(1);
				definition.name = "Hellraiser (x2 KC)";
				definition.npcSizeInSquares = 1;
				definition.standAnimation = x2.standAnimation;
				definition.walkAnimation = x2.walkAnimation;
				definition.npcModels = new int[]{16050,16052,16054,16056,16057,16058,16059};
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.actions = new String[5];
				definition.drawYellowDotOnMap = false;
				definition.actions[0] = null;
				break;
				
			case 3310:
				definition.name = "Yoshi";
				MobDefinition drv = MobDefinition.get(2292);
				definition.description = "npc.".getBytes();
				definition.npcModels = new int[]{64068};
				definition.combatLevel = drv.combatLevel;
				definition.standAnimation = drv.standAnimation;
				definition.walkAnimation = drv.walkAnimation;
				definition.scaleXZ = drv.scaleXZ;
				definition.scaleY = drv.scaleY;
				definition.actions = new String[]{null, "Attack", null, null, null};

				break;

			case 3306:
				definition.name = "Event Organizer";
				MobDefinition drv1 = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{64065};
				definition.combatLevel = drv1.combatLevel;
				definition.standAnimation = drv1.standAnimation;
				definition.walkAnimation = drv1.walkAnimation;
				definition.scaleXZ = drv1.scaleXZ;
				definition.scaleY = drv1.scaleY;
				definition.actions = new String[]{null, null, "Event Points Shop", null, null};
				break;

			case 130:
				definition.name = "Locked Santa";
				MobDefinition xmas = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{51156};
				definition.combatLevel = xmas.combatLevel;
				definition.standAnimation = 12686;
				definition.walkAnimation = xmas.walkAnimation;
				definition.scaleXZ = xmas.scaleXZ;
				definition.scaleY = xmas.scaleY;
				definition.actions = new String[]{"Open-Xmas", null, "Event Points Shop", null, null};
				break;

			case 3307:
				definition.name = "Darkrealm Gatekeeper";
				break;

			case 3308:
				definition.name = "Legendary Wyvern";
				MobDefinition poke = MobDefinition.get(4972);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{17218};
				definition.combatLevel = poke.combatLevel;
				definition.standAnimation = poke.standAnimation;
				definition.walkAnimation = poke.walkAnimation;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;

			case 3312:
				definition.name = "Darkrealm Lugia";
				MobDefinition lugiatextured = MobDefinition.get(4972);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{64096};
				definition.combatLevel = lugiatextured.combatLevel;
				definition.standAnimation = lugiatextured.standAnimation;
				definition.walkAnimation = lugiatextured.walkAnimation;
				definition.scaleXZ = lugiatextured.scaleXZ;
				definition.scaleY = lugiatextured.scaleY;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.changedModelColours[0] = 40; // the texture that it currently has
				definition.originalModelColours[0] = 52; // the new texture u want it to have
				break;

			case 12241:
				definition.name = "Kermit the frog";
				definition.scaleXZ = 162;
				definition.scaleY = 162;
				definition.actions = new String[]{"Upgrade Shop", null, null, null, null};
				break;

			case 8010:
				definition.name = "Ipotane";
				definition.description = "Ipotane.".getBytes();
				definition.npcModels = new int[]{17296};
				definition.combatLevel = 699;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;

			case 9807:
				definition.setDefault();
				definition.name = "Vindicta";
				definition.npcModels = new int[]{100191, 100193};
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = MobDefinition.get(82).standAnimation;
				definition.walkAnimation = MobDefinition.get(82).walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 128;
				definition.scaleY = 128;
				break;

			case 350:
				definition.name = "Trump Jr.";
				definition.description = "Frieza.".getBytes();
				definition.npcModels = new int[]{15161,15164,15167,15169,15170};
				definition.combatLevel = 0;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 50 + 20;
				definition.scaleY = 50 + 20;
				definition.actions = new String[5];
				definition.actions[0] = null;
				break;
            default:
                break;
        }
    }

    private static void applyCustomNpcs10(int id, MobDefinition definition) {
        switch (id) {
			case 351:
				definition.name = "Frieza (second form)";
				definition.description = "Frieza.".getBytes();
				definition.npcModels = new int[]{64363};
				definition.combatLevel = 0;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 70 + 20;
				definition.scaleY = 70 + 20;
				definition.actions = new String[5];
				definition.actions[0] = null;
				break;

			case 352:
				definition.name = "Frieza (final form)";
				definition.description = "Frieza.".getBytes();
				definition.npcModels = new int[]{64364};
				definition.combatLevel = 0;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 60 + 20;
				definition.scaleY = 60 + 20;
				definition.actions = new String[5];
				definition.actions[0] = null;
				break;

			case 928:
				definition.name = "Raditz";
				definition.description = "Cell.".getBytes();
				definition.npcModels = new int[]{15172,15174,15176,15177,15178};
				definition.combatLevel = 200;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				//   definition.rdc2 = 2931;
				definition.actions = new String[5];
				definition.actions[0] = null;
				break;
			case 4000:
				definition.name = "Majin Buu";
				definition.description = "Buu.".getBytes();
				definition.npcModels = new int[]{64381};
				definition.combatLevel = 200;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				//   definition.rdc2 = 2931;
				definition.actions = new String[5];
				definition.actions[0] = null;
				break;
			case 4001:
				definition.name = "Goku";
				definition.description = "Goku.".getBytes();
				definition.npcModels = new int[]{15187,15181,15183,15185,15188};
				definition.combatLevel = 200;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				//   definition.rdc2 = 2931;
				definition.actions = new String[5];
				definition.actions[0] = null;
				break;

			case 7134:
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				break;
			case 6142:
			case 6143:
			case 6144:
			case 6145:
				definition.npcSizeInSquares = 2;
				definition.scaleXZ = 140;
				definition.scaleY = 140;
				break;
			case 225:
				definition.npcModels = new int[]{19542};
				definition.name = "Bork pet";
				definition.scaleXZ = 40;
				definition.scaleY = 40;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.standAnimation = MobDefinition.get(7134).standAnimation;
				definition.walkAnimation = MobDefinition.get(7134).walkAnimation;
				break;
				
			case 450:
				definition.name = "Majin Buu";
				definition.description = "Buu.".getBytes();
				definition.npcModels = new int[]{64381};//64381
				definition.combatLevel = 100;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 145;
				definition.scaleY = 145;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 451:
				definition.name = "Kidd Buu";
				definition.description = "Buu.".getBytes();
				definition.npcModels = new int[]{64382};
				definition.combatLevel = 200;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 145;
				definition.scaleY = 145;
				//   definition.rdc2 = 2931;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 449:
				definition.name = "Raditz";
				definition.npcModels = new int[]{15172,15174,15176,15177,15178};
				definition.combatLevel = 200;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 185;
				definition.scaleY = 185;
				//   definition.rdc2 = 2931;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 452:
				definition.name = "Goku";
				definition.description = "Goku.".getBytes();
				definition.npcModels = new int[]{15187,15181,15183,15185,15188};
				definition.combatLevel = 300;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 180;
				definition.scaleY = 180;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;

			case 9318:
				definition.name = "Onyx Panther";
				definition.description = "Onyx Donator boss.".getBytes();
				definition.npcModels = new int[]{18788,18790,18789,18792,18795};
				definition.combatLevel = 300;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 180;
				definition.scaleY = 180;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;

			case 9313:
				definition.name = "Suffered Soul";
				definition.description = "Goku.".getBytes();
				definition.npcModels = new int[]{18679};
				definition.combatLevel = 666;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 180;
				definition.scaleY = 180;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 9314:
				definition.name = "Suffered Soul";
				definition.description = "Goku.".getBytes();
				definition.npcModels = new int[]{18684};
				definition.combatLevel = 666;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 180;
				definition.scaleY = 180;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 9315:
				definition.name = "Suffered Soul";
				definition.description = "Goku.".getBytes();
				definition.npcModels = new int[]{18682};
				definition.combatLevel = 666;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 180;
				definition.scaleY = 180;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 9316:
				definition.name = "Suffered Soul";
				definition.description = "Goku.".getBytes();
				definition.npcModels = new int[]{18687};
				definition.combatLevel = 666;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 180;
				definition.scaleY = 180;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 9317:
				definition.name = "Suffered Soul";
				definition.description = "Goku.".getBytes();
				definition.npcModels = new int[]{18679};
				definition.combatLevel = 666;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 180;
				definition.scaleY = 180;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 4648:
				definition.actions = new String[5];
				definition.actions[0] = "Talk-to";
				break;
			case 250:
				definition.name = "Hanto warrior";
				definition.description = "Hanto warriors are part of the samurai clan.".getBytes();
				definition.npcModels = new int[]{18693,18704,18695,18793,15170}; //18795
				definition.combatLevel = 100;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 225;
				definition.scaleY = 225;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 251:
				definition.name = "Frieza (second form)";
				definition.description = "Frieza.".getBytes();
				definition.npcModels = new int[]{64363};
				definition.combatLevel = 200;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 170;
				definition.scaleY = 170;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 252:
				definition.name = "Frieza (final form)";
				definition.description = "Frieza.".getBytes();
				definition.npcModels = new int[]{64364};
				definition.combatLevel = 300;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 190;
				definition.scaleY = 190;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 1023:
				definition.name = "Trapper";
				MobDefinition slayer10 = MobDefinition.get(1618);
				definition.description = "GWD.".getBytes();
				//definition.npcModels = new int[] {64064};
				definition.combatLevel = 40;
				definition.scaleXZ = 110;
				definition.scaleY = 110;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = slayer10.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = slayer10.npcModels.clone();
				definition.standAnimation = slayer10.standAnimation;
				definition.walkAnimation = slayer10.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 48754;
				break;
			case 1233://2643
				MobDefinition gargoyle = get(1610);
				definition.name = "Rusted Gargoyle";
				definition.combatLevel = 40;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = gargoyle.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = gargoyle.npcModels.clone();
				definition.standAnimation = gargoyle.standAnimation;
				definition.walkAnimation = gargoyle.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 2467;
				break;
			case 1234://2643
				MobDefinition slayer5 = get(1612);
				definition.name = "Crazy witch";
				definition.combatLevel = 100;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = slayer5.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = slayer5.npcModels.clone();
				definition.standAnimation = slayer5.standAnimation;
				definition.walkAnimation = slayer5.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 2345;
				break;

			case 6692:
				definition.name = "Revenant Tarragon";
				definition.combatLevel = 126;
				definition.walkAnimation = 8590;
				definition.standAnimation = 8589;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[1];
				definition.npcModels[0] = 31721;
				definition.rdc2 = 385238;
				definition.scaleXZ = 190;
				definition.scaleY = 190;
				break;

			case 5510:
				definition.name = "Groudon";
				definition.description = "Groudon.".getBytes();
				definition.npcModels = new int[]{65191};
				definition.combatLevel = 699;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				//originalModelColours
				//
				definition.originalModelColours = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				definition.changedModelColours = new int[1]; // same here
				definition.changedModelColours[0] = 71; // the texture that it currently has
				definition.originalModelColours[0] = 40; // the new texture u want it to have

				definition.actions = new String[]{null, "Attack", null, null, null};
				break;

			case 5511:
				definition.name = "Groudon";
				definition.description = "Groudon.".getBytes();
				definition.npcModels = new int[]{65191};
				definition.combatLevel = 699;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.originalModelColours = new int[1]; // if only 1 texture is modified this has to be 1, if 2 then 2 etc
				definition.changedModelColours = new int[1]; // same here
				definition.changedModelColours[0] = 95; // the texture that it currently has
				definition.originalModelColours[0] = 40; // the new texture u want it to have
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;

			case 1614:
				definition.name = "Dustclaw";
				definition.scaleXZ = 190;
				definition.scaleY = 190;
				definition.npcModels = new int[]{17199};
				definition.combatLevel = 699;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.npcSizeInSquares = 1;
				break;

			case 8011:
				definition.name = "Event box";
				definition.description = "Event Box.".getBytes();
				definition.npcModels = new int[]{65205};
				definition.combatLevel = 699;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 12886:
				definition.name = "Cyantrix";
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				break;
			case 8014:
				definition.name = "Klatooinian";
				definition.description = "Klatooinian.".getBytes();
				definition.npcModels = new int[]{65207};
				definition.combatLevel = 83;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 12843:
				definition.npcModels = new int[]{17203,17205,17207,17209,17210,17212,65015}; //17203,17204,17206,17208,17210,17211
				definition.name = "Shadow hunter";
				definition.combatLevel = 347;
				definition.scaleXZ = 200;
				definition.scaleY = 200;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 13217;
				definition.walkAnimation = 13218;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 12343:
				definition.name = "Predator";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.scaleXZ = 600;
				definition.scaleY = 600;
				definition.npcSizeInSquares = 3;
				definition.combatLevel = 427;
				definition.degreesToTurn = 32;
				break;
			case 13747:
				definition.name = "Ice Demon";

				definition.npcModels = new int[]{64329};
				MobDefinition icedemon2 = get(82);
				definition.combatLevel = 40;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.description = icedemon2.description;
				definition.drawYellowDotOnMap = true;
				definition.standAnimation = icedemon2.standAnimation;
				definition.walkAnimation = icedemon2.walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 1;
				break;
			case 8018:
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.name = "Shetani";
				definition.npcModels = new int[]{17215};
				MobDefinition icebeasts = get(1);
				definition.combatLevel = 130;
				definition.scaleXZ = 150;
				definition.scaleY = 150;
				definition.npcSizeInSquares = 1;
				definition.description = icebeasts.description;
				definition.drawYellowDotOnMap = true;
				definition.degreesToTurn = 32;
				definition.standAnimation = icebeasts.standAnimation;
				definition.walkAnimation = icebeasts.walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 1;
				//definition.rdc2 = 29492;
				break;
			case 662:
				definition.name = "Lottie (Lottery)";
				break;
            default:
                break;
        }
    }

    private static void applyCustomNpcs11(int id, MobDefinition definition) {
        switch (id) {
			case 8015:
				definition.name = "@cya@Elite Dragon";
				definition.description = "Evil Dragon.".getBytes();
				definition.npcModels = new int[]{65208};
				definition.combatLevel = 333;
				definition.standAnimation = 12248;
				definition.walkAnimation = 12246;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.colorChange = new double[]{0.1, 0.1, 1.2};
				definition.npcSizeInSquares = 2;
				break;
			case 8012:
				definition.name = "Delectro";
				definition.combatLevel = 492;
				definition.walkAnimation = 1660;
				definition.standAnimation = 11973;
				definition.npcModels = new int[9];
				definition.npcModels[0] = 65193; //HEAD
				definition.npcModels[1] = 65204; //JAW
				definition.npcModels[2] = 65195; //CHEST
				definition.npcModels[3] = -1; //CAPE
				//	definition.npcModels[4] = 65199; //ARM
				definition.npcModels[5] = -1; //HAND//shield
				definition.npcModels[6] = 65202; //WEP
				definition.npcModels[7] = 65197; //LEG
				definition.npcModels[8] = 65200; //BOOT
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.actions[1] = "Attack";
				definition.actions[2] = null;
				definition.actions[3] = null;
				definition.actions[4] = null;
				break;
			case 8003:
				definition.name = "Immortal Warrior";
				definition.description = "Immortal Warrior.".getBytes();
				definition.npcModels = new int[]{18667};
				definition.combatLevel = 699;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 250;
				definition.scaleY = 250;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 273:
				definition.name = "Slayer Instructor";
				definition.description = "Creepy guy, but 200m Slayer XP will do that to you.".getBytes();
				definition.actions = new String[5];
				definition.actions[0] = "Talk-to";
				break;

			case 1685:
				MobDefinition shop22 = MobDefinition.get(410);
				definition.npcModels = shop22.npcModels;
				definition.name = "Pure";
				definition.actions = new String[]{"Trade", null, null, null, null};
				break;

			case 3030:
				definition.name = "King black dragon";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcModels = new int[]{17414, 17415, 17429, 17422};
				definition.combatLevel = 276;
				definition.standAnimation = 90;
				definition.walkAnimation = 4635;
				definition.scaleXZ = 63;
				definition.scaleY = 63;
				definition.npcSizeInSquares = 3;
				break;

			case 3031:
				definition.name = "General graardor";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcModels = new int[]{27785, 27789};
				definition.combatLevel = 624;
				definition.standAnimation = 7059;
				definition.walkAnimation = 7058;
				definition.scaleXZ = 40;
				definition.scaleY = 40;
				break;


			case 3032:
				definition.name = "TzTok-Jad";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcModels = new int[]{34131};
				definition.combatLevel = 702;
				definition.standAnimation = 9274;
				definition.walkAnimation = 9273;
				definition.scaleXZ = 45;
				definition.scaleY = 45;
				definition.npcSizeInSquares = 2;
				break;

			case 3033:
				definition.name = "Chaos elemental";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcModels = new int[]{11216};
				definition.combatLevel = 305;
				definition.standAnimation = 3144;
				definition.walkAnimation = 3145;
				definition.scaleXZ = 62;
				definition.scaleY = 62;
				break;
			case 3034:
				definition.name = "Corporeal beast";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcModels = new int[]{40955};
				definition.combatLevel = 785;
				definition.standAnimation = 10056;
				definition.walkAnimation = 10055;
				definition.scaleXZ = 45;
				definition.scaleY = 45;
				definition.npcSizeInSquares = 2;
				break;

			case 3035:
				definition.name = "Kree'arra";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcModels = new int[]{28003, 28004};
				definition.combatLevel = 580;
				definition.standAnimation = 6972;
				definition.walkAnimation = 6973;
				definition.scaleXZ = 43;
				definition.scaleY = 43;
				definition.npcSizeInSquares = 2;
				break;

			case 3036:
				definition.name = "K'ril tsutsaroth";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcModels = new int[]{27768, 27773, 27764, 27765, 27770};
				definition.combatLevel = 650;
				definition.standAnimation = 6943;
				definition.walkAnimation = 6942;
				definition.scaleXZ = 43;
				definition.scaleY = 43;
				definition.npcSizeInSquares = 2;
				break;
			case 804:
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.name = "Darth Vaider";
				definition.npcModels = new int[]{65150};
				definition.combatLevel = 785;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 150;
				definition.scaleY = 150;
				definition.npcSizeInSquares = 2;
				break;
			case 3000:
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.name = "King Kong";
				definition.npcModels = new int[]{65154};
				definition.combatLevel = 785;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 400;
				definition.scaleY = 400;
				definition.npcSizeInSquares = 2;
				break;

			case 3002:
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.name = "GodZilla";
				definition.npcModels = new int[]{65155};
				definition.combatLevel = 785;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 300;
				definition.scaleY = 300;
				definition.npcSizeInSquares = 3;
				break;
			case 3115:
				definition.name = "Evil Lucien";
				definition.combatLevel = 785;
				definition.standAnimation = 66;
				definition.walkAnimation = 63;
				//definition.type = 51;
				definition.degreesToTurn = 32;
				definition.npcModels = new int[]{65158};
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.scaleXZ = 72;
				definition.scaleY = 72;
				definition.npcSizeInSquares = 2;
				definition.rdc2 = 7656789;
				break;
			case 3116:
				definition.name = "Skotizo";
				definition.combatLevel = 785;
				definition.standAnimation = 66;
				definition.walkAnimation = 63;
				//definition.type = 51;
				definition.degreesToTurn = 32;
				definition.npcModels = new int[]{65158};
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.scaleXZ = 72;
				definition.scaleY = 72;
				definition.npcSizeInSquares = 2;
				definition.rdc2 = 987896875;
				break;
			case 3117:
				definition.name = "Oni";
				definition.combatLevel = 785;
				definition.standAnimation = 808;
				definition.walkAnimation = 809;
				//definition.type = 51;
				definition.degreesToTurn = 32;
				definition.npcModels = new int[]{17219};
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.scaleXZ = 125;
				definition.scaleY = 125;
				definition.npcSizeInSquares = 1;
				break;

			case 3003:
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.name = "BabyZilla";
				definition.npcModels = new int[]{65155};
				definition.combatLevel = 785;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 2;
				definition.rdc2 = 2424;
				break;
			case 3779:
				MobDefinition GF = get(4275);
				definition.name = "Terrorstep";
				definition.combatLevel = 40;
				definition.scaleXZ = 280;
				definition.scaleY = 280;
				definition.npcSizeInSquares = 4;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = GF.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = new int[]{18719};
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.degreesToTurn = 32;
				break;

			case 3830:
				definition.setDefault();
				definition.npcModels = new int[]{19688};
				definition.standAnimation =  MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.actions = MobDefinition.get(1).actions;
				definition.combatLevel = 0;
				definition.name = "Vozzath";
				definition.scaleXZ = 230;
				definition.scaleY = 230;
				definition.npcSizeInSquares = 3;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
				
			case 3831:
				definition.name = "Abbadon";
				//definition.description = "MegaBeast".getBytes();
				definition.npcModels = new int[]{18678};
				definition.combatLevel = 800;
				definition.standAnimation = 10921;
				definition.walkAnimation = 10920;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.npcSizeInSquares = 1;
				definition.degreesToTurn = 32;

				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 2949:
				definition.name = "Enraged Guardian";
				definition.npcModels = new int[]{18014};
				MobDefinition Botanic1 = get(1);
				definition.combatLevel = 260;
				definition.scaleXZ = 190;
				definition.scaleY = 170;
				definition.npcSizeInSquares = 2;
				definition.description = Botanic1.description;
				definition.drawYellowDotOnMap = true;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 2950:
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.name = "herbal minion";
				definition.npcModels = new int[]{64478};
				MobDefinition Herbal = get(20);
				definition.combatLevel = 100;
				definition.scaleXZ = 23;
				definition.scaleY = 23;
				definition.npcSizeInSquares = 1;
				definition.description = Herbal.description;
				definition.drawYellowDotOnMap = true;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 1;
				//definition.rdc2 = 29492;
				break;
			case 2340:
				definition.name = "Elemental minion";
				//definition.description = "MegaBeast".getBytes();
				definition.npcModels = new int[]{65209};
				definition.combatLevel = 100;
				definition.standAnimation = 10921;
				definition.walkAnimation = 10920;
				definition.scaleXZ = 35;
				definition.scaleY = 35;
				definition.npcSizeInSquares = 1;
				definition.degreesToTurn = 32;

				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 2341:
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.name = "Enraged minion";
				definition.npcModels = new int[]{64477};
				MobDefinition Enraged1 = get(4972);
				definition.combatLevel = 100;
				definition.scaleXZ = 35;
				definition.scaleY = 35;
				definition.npcSizeInSquares = 1;
				definition.description = Enraged1.description;
				definition.drawYellowDotOnMap = true;
				definition.standAnimation = Enraged1.standAnimation;
				definition.walkAnimation = Enraged1.walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 1;
				//definition.rdc2 = 29492;
				break;
			case 2342:
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.name = "Botanic Guardian";
				definition.npcModels = new int[]{20566};
				MobDefinition Herbal11 = get(1);
				definition.combatLevel = 300;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 2;
				definition.description = Herbal11.description;
				definition.drawYellowDotOnMap = true;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 1;
				break;
			case 3814:
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.name = "Juggernaut";
				definition.npcModels = new int[]{19927};
				MobDefinition worsk1 = get(202);
				definition.combatLevel = 40;
				definition.scaleXZ = 300;
				definition.scaleY = 300;
				definition.npcSizeInSquares = 2;
				definition.description = worsk1.description;
				definition.drawYellowDotOnMap = true;
				definition.standAnimation = worsk1.standAnimation;
				definition.walkAnimation = worsk1.walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};

				//.	definition.rdc2 = 238;
				break;
			case 1850:
				definition.npcModels = new int[]{3293};
				definition.combatLevel = 0;
				definition.standAnimation = 0;
				definition.walkAnimation = 0;
				break;
			case 1851:
				definition.npcModels = new int[]{65439};
				definition.combatLevel = 0;
				definition.standAnimation = 0;
				definition.walkAnimation = 0;
				break;
			case 1852:
				definition.npcModels = new int[]{37192};
				definition.combatLevel = 0;
				definition.standAnimation = 0;
				definition.walkAnimation = 0;
				break;
			case 1853://hidden
				definition.npcModels = new int[]{15885};
				definition.combatLevel = 0;
				definition.standAnimation = 0;
				definition.walkAnimation = 0;
				break;
			case 1854://curse
				definition.npcModels = new int[]{15848};
				definition.combatLevel = 0;
				definition.standAnimation = 0;
				definition.walkAnimation = 0;
				break;
			case 1855://damned
				definition.npcModels = new int[]{5494};
				definition.combatLevel = 0;
				definition.standAnimation = 0;
				definition.walkAnimation = 0;
				break;
			case 1856://betrayed
				definition.npcModels = new int[]{15567};
				definition.combatLevel = 0;
				definition.standAnimation = 0;
				definition.walkAnimation = 0;
				break;
			case 201:
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.name = "Super Shenron";
				definition.npcModels = new int[]{17220};
				MobDefinition Shenron = get(4972);
				definition.combatLevel = 100;
				definition.scaleXZ = 35;
				definition.scaleY = 35;
				definition.npcSizeInSquares = 1;
				definition.description = Shenron.description;
				definition.drawYellowDotOnMap = true;
				definition.standAnimation = Shenron.standAnimation;
				definition.walkAnimation = Shenron.walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 1;
				break;
				
			case 202:
				definition.name = "Subzero";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 150;
				definition.scaleY = 150;
				definition.npcModels = new int[]{17232,17228,17226,17234,17222,17295};
				break;
				
			case 203:
				definition.name = "Almighty Zeus";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 190;
				definition.scaleY = 190;
				definition.npcModels = new int[9];
				definition.npcModels[0] = 64260; //HEAD
				definition.npcModels[1] = 64009; //JAW
				definition.npcModels[2] = 64262; //BODY
				definition.npcModels[3] = 64110; //CAPE
				definition.npcModels[4] = 64176; //HAND
				definition.npcModels[5] = 64268; ////shield
				definition.npcModels[6] = 64266; //WEP
				definition.npcModels[7] = 64264; //LEG
				definition.npcModels[8] = 64178; //BOOT
				definition.originalModelColours = new int[1];
				definition.changedModelColours = new int[1];
				definition.originalModelColours[0] = 40; // current
				definition.changedModelColours[0] = 96; // New
				break;
			case 186:
				definition.name = "Mr. Grinch";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 8900;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 230;
				definition.scaleY = 230;
				definition.npcModels = new int[9];
				definition.npcModels[0] = 64307; //HEAD
				definition.npcModels[1] = 0; //JAW
				definition.npcModels[2] = 64309; //BODY
				definition.npcModels[3] = 0; //CAPE
				definition.npcModels[4] = 64313; //GLOVES
				definition.npcModels[5] = 0; ////shield
				definition.npcModels[6] = 0; //WEP
				definition.npcModels[7] = 64311; //LEG
				definition.npcModels[8] = 64314; //BOOT
				break;
				
				case 117:
				definition.setDefault();
				definition.name = "Arachnes";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.scaleXZ = 150;
				definition.scaleY = 150;
				definition.npcModels = new int[]{18062};
				break;
            default:
                break;
        }
    }

    private static void applyCustomNpcs12(int id, MobDefinition definition) {
        switch (id) {
				case 500:
				MobDefinition poke1 = MobDefinition.get(4972);
				definition.npcModels = new int[]{15142};
				definition.description = "GWD.".getBytes();
				definition.combatLevel = poke1.combatLevel;
				definition.standAnimation = poke1.standAnimation;
				definition.walkAnimation = poke1.walkAnimation;
				definition.scaleXZ = 85;
				definition.scaleY = 85;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.name = "@yel@Cash Dragon";
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = true;
				break;

				case 501:
				definition.name = "Demon goddess";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.npcModels = new int[]{15158};
				break;

				case 503:
				definition.name = "Energy Skeleton";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 150;
				definition.scaleY = 150;
				definition.npcModels = new int[]{15159};
				break;
			case 9129:
				definition.name = "@red@Slayer Champion";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 250;
				definition.scaleY = 250;
				definition.npcModels = new int[]{19574};
				break;
				case 187:
				definition.name = "Hellraiser";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 250;
				definition.scaleY = 250;
				definition.npcModels = new int[]{16050,16052,16054,16056,16057,16058,16059};
				break;
				
				case 76:
				MobDefinition mummy = MobDefinition.get(2015);
				definition.npcModels = mummy.npcModels;
				definition.description = "He must have been down here for years..".getBytes();
				definition.combatLevel = mummy.combatLevel;
				definition.standAnimation = mummy.standAnimation;
				definition.walkAnimation = mummy.walkAnimation;
				definition.name = "Mummy";
				definition.rdc2 = 800;
				break;
				case 5664:
				MobDefinition mummy1 = MobDefinition.get(2015);
				definition.npcModels = mummy1.npcModels;
				definition.description = "He must have been down here for years..".getBytes();
				definition.combatLevel = mummy1.combatLevel;
				definition.standAnimation = mummy1.standAnimation;
				definition.walkAnimation = mummy1.walkAnimation;
				definition.name = "Mummy";
				definition.rdc2 = 59511;
				break;
			case 1508:
				definition.name = "Forest archer";
				definition.npcModels = new int[]{19593};
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares =2;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 140;
				definition.scaleY = 140;
				break;
			case 1507:
				definition.copy(1508);
				definition.name = "Forest archer pet";
				definition.actions = new String[]{null, null, null, null, null};
				definition.npcSizeInSquares =1;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				break;
			case 1458:
				definition.name = "Chaotic archer";
				definition.npcModels = new int[]{19592};
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares =2;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 120;
				definition.scaleY = 120;
				break;

			case 1455:
				definition.npcModels = new int[]{19592};
				definition.name = "Chaotic archer pet";
				definition.actions = new String[]{null, null, null, null, null};
				definition.npcSizeInSquares =1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				break;

			case 1457:
				definition.name = "Divine archer";
				definition.npcModels = new int[]{19594};
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares =2;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 140;
				definition.scaleY = 140;
				definition.rdc2 = 34343;
				break;

			case 1456:
				definition.npcModels = new int[]{19594};
				definition.name = "Divine archer pet";
				definition.actions = new String[]{null, null, null, null, null};
				definition.npcSizeInSquares =1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.rdc2 = 34343;
				break;
		case 827:
			definition.name = "Unknown archer";
			definition.actions = new String[]{null, "Attack", null, null, null};
			definition.combatLevel = 456;
			definition.npcSizeInSquares =2;
			definition.standAnimation = 808;
			definition.walkAnimation = 819;
			definition.scaleXZ = 170;
			definition.scaleY = 170;
			definition.npcModels = new int[] {16283};
	            break;
    
		case 823:
			definition.name = "The Unknown";
			definition.actions = new String[]{null, "Attack", null, null, null};
			definition.combatLevel = 456;
			definition.npcSizeInSquares =2;
			definition.standAnimation = 808;
			definition.walkAnimation = 819;
			definition.scaleXZ = 300;
			definition.scaleY = 300;
			definition.npcModels = new int[] {16272,65105};
	            break;
	            
	            
		case 825:
			definition.name = "Unknown ghost";
			definition.actions = new String[]{null, "Attack", null, null, null};
			definition.combatLevel = 456;
			definition.npcSizeInSquares =2;
			definition.standAnimation = 808;
			definition.walkAnimation = 819;
			definition.scaleXZ = 150;
			definition.scaleY = 150;
			definition.npcModels = new int[] {16275};
	            break;
	            
		case 828:
			definition.name = "Unknown creature";
			definition.actions = new String[]{null, "Attack", null, null, null};
			definition.combatLevel = 456;
			definition.npcSizeInSquares =2;
			definition.standAnimation = 808;
			definition.walkAnimation = 819;
			definition.scaleXZ = 250;
			definition.scaleY = 250;
			definition.npcModels = new int[] {16279};
	            break;
	            
				case 5400:
				MobDefinition mummy2 = MobDefinition.get(2015);
				definition.npcModels = mummy2.npcModels;
				definition.description = "He must have been down here for years..".getBytes();
				definition.combatLevel = mummy2.combatLevel;
				definition.standAnimation = mummy2.standAnimation;
				definition.walkAnimation = mummy2.walkAnimation;
				definition.name = "Mummy";
				definition.rdc2 = 6254;
				break;
				case 8162:
				MobDefinition mummy3 = MobDefinition.get(2015);
				definition.npcModels = mummy3.npcModels;
				definition.description = "He must have been down here for years..".getBytes();
				definition.combatLevel = mummy3.combatLevel;
				definition.standAnimation = mummy3.standAnimation;
				definition.walkAnimation = mummy3.walkAnimation;
				definition.name = "Mummy";
				definition.rdc2 = 21877;
				break;
				case 185:
				definition.name = "Inuyasha";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 190;
				definition.scaleY = 190;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.npcModels = new int[]{15194,15195,15196,15197,15198,15199};
				break;
				
				case 6430:
				definition.name = "Tolrokoth";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.npcModels = new int[]{18037};
				break;
				
			case 6431:
				definition.name = "Tolrokoth pet";
				definition.actions = null;
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 50;
				definition.scaleY = 50;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.npcModels = new int[]{18037};
				break;
				
			case 184:
				definition.name = "Inuyasha pet";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.npcModels = new int[]{15194,15195,15196,15197,15198,15199};
				break;
				
			case 903:
				definition.name = "Sephiroth";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.npcModels = new int[6];
				definition.npcModels[0] = 64133; //HEAD
				definition.npcModels[1] = 64135; //BODY
				definition.npcModels[2] = 354; //GLOVES
				definition.npcModels[3] = 64140; //WEP
				definition.npcModels[4] = 64137; //LEG
				definition.npcModels[5] = 64138; //BOOT
				break;

			case 904:
				definition.name = "Devil";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.npcModels = new int[7];
				definition.npcModels[0] = 21822; //HEAD
				definition.npcModels[1] = 21846; //BODY
				definition.npcModels[2] = 21855; //GLOVES
				definition.npcModels[3] = 21858; //WEP
				definition.npcModels[4] = 21854; //LEG
				definition.npcModels[5] = 21856; //BOOT
				definition.npcModels[6] = 21887; //CAPE
				break;

			case 905:
				definition.name = "Samurai";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.npcModels = new int[5];
				definition.npcModels[0] = 21957; //HEAD
				definition.npcModels[1] = 21962; //BODY
				definition.npcModels[2] = 353; //GLOVES
				definition.npcModels[3] = 21972; //LEG
				definition.npcModels[4] = ItemDefinition.get (1061).maleEquip1; //BOOT
				break;


			case 906:
				definition.name = "Black Knight";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.npcModels = new int[5];
				definition.npcModels[0] = 21987; //HEAD
				definition.npcModels[1] = 21997; //BODY
				definition.npcModels[2] = 22065; //GLOVES
				definition.npcModels[3] = 21998; //LEG
				definition.npcModels[4] = 22005; //BOOT
				break;



			case 3006:
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.name = "BabyZilla";
				definition.npcModels = new int[]{65155};
				definition.combatLevel = 785;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 2;
				definition.rdc2 = 9023;
				break;
				
			case 3004:
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.name = "BabyZilla";
				definition.npcModels = new int[]{65155};
				definition.combatLevel = 785;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 2;
				definition.rdc2 = 6178;
				break;

			case 8133:
				definition.rdc2 = 2143611;
				break;
				
			case 3112:
				definition.name = "Ezkel-Nojad";
				definition.actions = new String[]{null, "Attack", null, null, null};

				definition.npcModels = new int[]{34131};
				definition.combatLevel = 702;
				definition.standAnimation = 9274;
				definition.walkAnimation = 9273;
				definition.scaleXZ = 145;
				definition.scaleY = 145;
				definition.npcSizeInSquares = 2;
				definition.rdc2 = 3333;
				break;
				
			case 3005:
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.name = "BabyZilla";
				definition.npcModels = new int[]{65155};
				definition.combatLevel = 785;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 2;
				definition.rdc2 = 6464;
				break;
				
			case 603:
				definition.name = "Inferior Elite Lord";
				definition.combatLevel = 492;
				definition.walkAnimation = 1660;
				definition.standAnimation = 11973;
				definition.npcModels = new int[]{17200};
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.actions[1] = "Attack";
				definition.actions[2] = null;
				definition.actions[3] = null;
				definition.actions[4] = null;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.npcSizeInSquares = 1;
				break;
			case 606:
				definition.name = "<col=7d9781>Zero Killer";
				definition.combatLevel = 284;
				definition.walkAnimation = 1660;
				definition.standAnimation = 11973;
				definition.npcModels = new int[1];
				definition.npcModels[0] = 19576;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.actions[1] = "Attack";
				definition.actions[2] = null;
				definition.actions[3] = null;
				definition.actions[4] = null;
				definition.npcSizeInSquares = 1;
				break;
			case 607:
				definition.name = "<col=7d9781>Shadow Warrior";
				definition.combatLevel = 284;
				definition.walkAnimation = 1660;
				definition.standAnimation = 11973;
				definition.npcModels = new int[9];
				definition.npcModels[0] = 65499; //HEAD
				definition.npcModels[1] = 55820; //JAW
				definition.npcModels[2] = 65501; //CHEST
				definition.npcModels[3] = 65505; //CAPE
				definition.npcModels[4] = 64090; //ARM
				definition.npcModels[5] = 65507; //HAND//shield
				definition.npcModels[6] = 65510; //WEP
				definition.npcModels[7] = 65503; //LEG
				definition.npcModels[8] = 65508; //BOOT
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.actions[1] = "Attack";
				definition.actions[2] = null;
				definition.actions[3] = null;
				definition.actions[4] = null;
				break;

			case 5002:
				definition.name = "Maxiblood @red@(Melee)";
				definition.combatLevel = 138;
				definition.walkAnimation = 1660;
				definition.standAnimation = 11973;
				definition.npcModels = new int[9];
				definition.npcModels[0] = 65131; //HEAD
				//definition.npcModels[1] = 246; //JAW
				definition.npcModels[2] = 65133; //CHEST
				definition.npcModels[3] = 9638; //CAPE
				definition.npcModels[4] = 65137; //HAND
				definition.npcModels[5] = 65128; ////shield
				definition.npcModels[6] = 65142; //WEP
				definition.npcModels[7] = 65135; //LEG
				definition.npcModels[8] = 65138; //BOOT
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.actions[1] = "Attack";
				definition.actions[2] = null;
				definition.actions[3] = null;
				definition.actions[4] = null;
				definition.originalModelColours = new int[1];
				definition.changedModelColours = new int[1];
				definition.originalModelColours[0] = 40; // current
				definition.changedModelColours[0] = 67; // New

				break;
			case 783:
				definition.rdc2 = 63664;
				definition.scaleXZ = 140;
				definition.scaleY = 140;
				definition.name = "<col=ff4f4f><shad=222>Starter Tasks<shad=-1>";
				break;
	/*	case 8013:
			definition.adjustVertextPointsXOrY = 90;
			definition.adjustVertextPointZ = 200;
			definition.name = "@bla@<shad=f9f6f6>Darkath Boss<shad=-1>";
			definition.combatLevel = 2043;
			definition.walkAnimation = 1660;
			definition.standAnimation = 11973;
			definition.npcModels = new int[9];
			definition.npcModels[0] = 65421; //HEAD
			//definition.npcModels[1] = 246; //JAW
			definition.npcModels[2] = 65423; //CHEST
		definition.npcModels[3] = 65039; //CAPE
			definition.npcModels[4] = 65199; //HAND
			definition.npcModels[5] = 65432; ////shield
			definition.npcModels[6] = 65202; //WEP
			definition.npcModels[7] = 65425; //LEG
			definition.npcModels[8] = 65200; //BOOT
			definition.actions = new String[5];
			definition.actions[0] = null;
			definition.actions[1] = "Attack";
			definition.actions[2] = null;
			definition.actions[3] = null;
			definition.actions[4] = null;
			 definition.originalModelColours = new int[1];
	            definition.changedModelColours = new int[1];
	            definition.originalModelColours[0] = 52; // current
	            definition.changedModelColours[0] = 66; // New
			break;*/
			case 8013:
				definition.name = "<shad=f9f6f6>Vote Boss<shad=-1>";
				MobDefinition votingbosser = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{20565};
				definition.combatLevel = votingbosser.combatLevel;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				//definition.adjustVertextPointsXOrY = darkath.adjustVertextPointsXOrY;
				//  definition.adjustVertextPointZ = darkath.adjustVertextPointZ;
				definition.actions = new String[]{null, "Attack", null, null, null};
				//definition.rdc2 = 21415;
				definition.npcSizeInSquares = 4;
				definition.scaleXZ = 250;
				definition.scaleY = 250;
				break;
			case 5000:
				definition.name = "Moonlight @cya@(Magic)";
				definition.combatLevel = 138;
				definition.walkAnimation = 1660;
				definition.standAnimation = 11973;
				definition.npcModels = new int[9];
				definition.npcModels[0] = 65297; //HEAD
				//definition.npcModels[1] = 246; //JAW
				definition.npcModels[2] = 65299; //CHEST
				definition.npcModels[3] = 9638; //CAPE
				definition.npcModels[4] = 65137; //HAND
				definition.npcModels[5] = 65227; ////shield
				definition.npcModels[6] = 65295; //WEP
				definition.npcModels[7] = 65301; //LEG
				definition.npcModels[8] = 65138; //BOOT
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.actions[1] = "Attack";
				definition.actions[2] = null;
				definition.actions[3] = null;
				definition.actions[4] = null;
				definition.originalModelColours = new int[3];
				definition.changedModelColours = new int[3];
				definition.originalModelColours[0] = 40; // current
				definition.changedModelColours[0] = 66; // New
				definition.originalModelColours[1] = 60; // current
				definition.changedModelColours[1] = 66; // New
				definition.originalModelColours[2] = 62; // current
				definition.changedModelColours[2] = 66; // New

				break;
			case 9172:
				//definition.rdc2 = 229929;
				break;
            default:
                break;
        }
    }

    private static void applyCustomNpcs13(int id, MobDefinition definition) {
        switch (id) {
			case 4999:
				definition.name = "Archie @gre@(Ranger)";
				definition.combatLevel = 138;
				definition.walkAnimation = 1660;
				definition.standAnimation = 11973;
				definition.npcModels = new int[9];
				definition.npcModels[0] = 65232; //HEAD
				//definition.npcModels[1] = 246; //JAW
				definition.npcModels[2] = 65234; //CHEST
				definition.npcModels[3] = 9638; //CAPE
				definition.npcModels[4] = 65137; //HAND
				//definition.npcModels[5] = 65227; ////shield
				definition.npcModels[6] = 65211; //WEP
				definition.npcModels[7] = 65236; //LEG
				definition.npcModels[8] = 65138; //BOOT
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.actions[1] = "Attack";
				definition.actions[2] = null;
				definition.actions[3] = null;
				definition.actions[4] = null;
				definition.originalModelColours = new int[2];
				definition.changedModelColours = new int[2];
				definition.originalModelColours[0] = 40; // current
				definition.changedModelColours[0] = 58; // New
				definition.originalModelColours[1] = 60; // current
				definition.changedModelColours[1] = 58; // New

				break;
			case 5040:
				definition.npcModels = new int[]{51848, 51850};
				definition.name = "dzone strykewyrm";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 130;
				definition.standAnimation = 12790;
				definition.walkAnimation = 12790;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.rdc2 = 87654;
				break;
			case 304:
				definition.name = "Fragment shop";
				break;
			case 2050:
				definition.name = "Ezone skeleton";
				definition.combatLevel = 1000;
				break;
			case 2051:
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.name = "Ezone creeper";

				definition.npcModels = new int[]{64537};
				definition.combatLevel = 1000;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 190;
				definition.scaleY = 190;
				definition.npcSizeInSquares = 2;

				break;
			case 600:
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.name = "Storm trooper";
				definition.npcModels = new int[]{65151};
				definition.combatLevel = 785;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 190;
				definition.scaleY = 190;
				break;

			case 602:
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.name = "Force Priestesses";
				definition.npcModels = new int[]{65153};
				definition.combatLevel = 785;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 75;
				definition.scaleY = 75;
				//definition.npcSizeInSquares = 2;
				break;
			case 3037:
				definition.name = "Commander zilyana";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcModels = new int[]{28057, 28071, 28078, 28056};
				definition.combatLevel = 596;
				definition.standAnimation = 6963;
				definition.walkAnimation = 6962;

				definition.scaleXZ = 103;
				definition.scaleY = 103;
				definition.npcSizeInSquares = 2;
				break;
			case 4444:
				definition.name = "Hooker pet";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcModels = new int[]{36071};
				definition.combatLevel = 0;
				definition.standAnimation = 6963;
				definition.walkAnimation = 6962;
				definition.scaleXZ = 90;
				definition.scaleY = 90;
				definition.npcSizeInSquares = 1;
				break;
			case 3038:
				definition.name = "Dagannoth supreme";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcModels = new int[]{9941, 9943};
				definition.combatLevel = 303;
				definition.standAnimation = 2850;
				definition.walkAnimation = 2849;
				definition.scaleXZ = 105;
				definition.scaleY = 105;
				definition.npcSizeInSquares = 2;
				break;

			case 3039:
				definition.name = "Dagannoth prime"; //9940, 9943, 9942
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcModels = new int[]{9940, 9943, 9942};
				definition.originalModelColours = new int[]{11930, 27144, 16536, 16540};
				definition.changedModelColours = new int[]{5931, 1688, 21530, 21534};
				definition.combatLevel = 303;
				definition.standAnimation = 2850;
				definition.walkAnimation = 2849;
				definition.scaleXZ = 105;
				definition.scaleY = 105;
				definition.npcSizeInSquares = 2;
				break;

			case 3040:
				definition.name = "Dagannoth rex";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.npcModels = new int[]{9941};
				definition.originalModelColours = new int[]{16536, 16540, 27144, 2477};
				definition.changedModelColours = new int[]{7322, 7326, 10403, 2595};
				definition.combatLevel = 303;
				definition.standAnimation = 2850;
				definition.walkAnimation = 2849;
				definition.scaleXZ = 105;
				definition.scaleY = 105;
				definition.npcSizeInSquares = 2;
				break;
			case 3047:
				definition.name = "Frost dragon";
				definition.combatLevel = 166;
				definition.standAnimation = 13156;
				definition.walkAnimation = 13157;
				definition.walkingBackwardsAnimation = -1;
				definition.walkRightAnimation = -1;
				definition.walkLeftAnimation = -1;
				//definition.type = 51;
				definition.degreesToTurn = 32;
				definition.npcModels = new int[]{56767, 55294};
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.scaleXZ = 72;
				definition.scaleY = 72;
				definition.npcSizeInSquares = 2;
				break;

			case 3048:
				definition.npcModels = new int[]{44733};
				definition.name = "Tormented demon";
				definition.combatLevel = 450;
				definition.standAnimation = 10921;
				definition.walkAnimation = 10920;
				definition.walkingBackwardsAnimation = -1;
				definition.walkRightAnimation = -1;
				definition.walkLeftAnimation = -1;
				//	definition.type = 8349;
				definition.degreesToTurn = 32;
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.scaleXZ = 60;
				definition.scaleY = 60;
				definition.npcSizeInSquares = 2;
				break;
			case 8349:
				definition.name = "Tormented Demon";
				break;
			case 3114:
				definition.npcModels = new int[]{44733};
				definition.name = "Corrupted demon";
				definition.combatLevel = 450;
				definition.standAnimation = 10921;
				definition.walkAnimation = 10920;
				definition.walkingBackwardsAnimation = -1;
				definition.walkRightAnimation = -1;
				definition.walkLeftAnimation = -1;
				//	definition.type = 8349;
				definition.degreesToTurn = 32;
				definition.actions = new String[5];
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 2;
				definition.rdc2 = 8876;
				break;
			case 3050:
				definition.npcModels = new int[]{24602, 24605, 24606};
				definition.name = "Kalphite queen";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 333;
				definition.standAnimation = 6236;
				definition.walkAnimation = 6236;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.npcSizeInSquares = 2;
				break;

			case 3051:
				definition.npcModels = new int[]{46141};
				definition.name = "Slash bash";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 111;
				definition.standAnimation = 11460;
				definition.walkAnimation = 11461;
				definition.scaleXZ = 65;
				definition.scaleY = 65;
				definition.npcSizeInSquares = 2;
				break;
			case 3052:
				definition.npcModels = new int[]{45412};
				definition.name = "Phoenix";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 235;
				definition.standAnimation = 11074;
				definition.walkAnimation = 11075;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.npcSizeInSquares = 2;
				break;
			case 3053:
				definition.npcModels = new int[]{46058, 46057};
				definition.name = "Collosal avatar";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 299;
				definition.standAnimation = 11242;
				definition.walkAnimation = 11255;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.npcSizeInSquares = 2;
				break;
			case 3054:
				definition.npcModels = new int[]{62717};
				definition.name = "Nex";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 565;
				definition.standAnimation = 6320;
				definition.walkAnimation = 6319;
				definition.scaleXZ = 95;
				definition.scaleY = 95;
				definition.npcSizeInSquares = 1;
			break;
			case 13453:
			case 13451:
			case 13452:
			case 13454:
				definition.scaleXZ = 150;
				definition.scaleY = 150;
				//	definition.rdc2 = 546546546;
				break;
			case 13738:

				definition.actions = new String[]{"Talk-to", null, null, null, null};
				definition.name = "<img=101><col=C3C0B2>Upgrade Lady";
				break;
			case 12649:


				definition.name = "Shukarhazh";
				definition.scaleY = 60;
				definition.scaleXZ = 60;
				break;
			case 10103:
				definition.npcSizeInSquares = 1;
				definition.name = "Bulwark";
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				//definition.rdc2 = 60;
				break;
				
			case 58:
				definition.name = "Super Mini Zulrah";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[1];
				definition.npcModels[0] = 14409;
				definition.standAnimation = 5070;
				definition.walkAnimation = 5070;
				definition.combatLevel = 725;
				definition.scaleY = 50;
				definition.scaleXZ = 50;
				definition.rdc2 = 34563;
				definition.drawYellowDotOnMap = true;
				break;

			case 13447:
				definition.name = "Nex";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 565;
				definition.standAnimation = 6320;
				definition.walkAnimation = 6319;
				definition.scaleXZ = 120;
				definition.scaleY = 120;
				definition.npcSizeInSquares = 1;
				break;
			case 3055:
				definition.npcModels = new int[]{51852, 51853};
				definition.name = "Jungle strykewyrm";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 110;
				definition.standAnimation = 12790;
				definition.walkAnimation = 12790;
				definition.scaleXZ = 60;
				definition.scaleY = 60;
				definition.npcSizeInSquares = 1;
				break;
			case 3056:
				definition.npcModels = new int[]{51848, 51850};
				definition.name = "Desert strykewyrm";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 130;
				definition.standAnimation = 12790;
				definition.walkAnimation = 12790;
				definition.scaleXZ = 60;
				definition.scaleY = 60;
				definition.npcSizeInSquares = 1;
				break;
			case 3057:
				definition.npcModels = new int[]{51847, 51849};
				definition.name = "Ice strykewyrm";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 210;
				definition.standAnimation = 12790;
				definition.walkAnimation = 12790;
				definition.scaleXZ = 65;
				definition.scaleY = 65;
				definition.npcSizeInSquares = 1;
				break;
			case 3058:
				definition.npcModels = new int[]{49142, 49144};
				definition.name = "Green dragon";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 79;
				definition.standAnimation = 12248;
				definition.walkAnimation = 12246;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.npcSizeInSquares = 2;
				break;
			case 4677:
				definition.name = "<col=89584A>Fantasy dragon";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 79;
				definition.rdc2 = 34233;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.npcSizeInSquares = 2;
				break;
			case 3059:
				definition.npcModels = new int[]{57937};
				definition.name = "Baby blue dragon";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 48;
				definition.standAnimation = 14267;
				definition.walkAnimation = 14268;
				definition.scaleXZ = 85;
				definition.scaleY = 85;
				definition.npcSizeInSquares = 1;
				break;
			case 9893:
				definition.setDefault();
				definition.npcModels = new int[]{19684};
				definition.standAnimation =  MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.actions = MobDefinition.get(1).actions;
				definition.combatLevel = 0;
				definition.name = "Evil Witch";
				definition.scaleXZ = 230;
				definition.scaleY = 230;
				definition.npcSizeInSquares = 3;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;

			case 8499:
				definition.npcModels = MobDefinition.get(8501).npcModels;
				definition.standAnimation =  MobDefinition.get(8501).standAnimation;
				definition.walkAnimation = MobDefinition.get(8501).walkAnimation;
				definition.actions = MobDefinition.get(8501).actions;
				definition.npcSizeInSquares = 4;
				definition.scaleXZ = 350;
				definition.scaleY = 350;
				definition.combatLevel = 0;
				break;
			case 9861:
				definition.setDefault();
				definition.name = "Turkey pet";
				definition.npcModels = MobDefinition.get(8501).npcModels;
				definition.combatLevel = 0;
				definition.standAnimation =  MobDefinition.get(8501).standAnimation;
				definition.walkAnimation = MobDefinition.get(8501).walkAnimation;
				definition.actions = new String[] {null, null, null, null, null};
				definition.drawYellowDotOnMap = false;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 50;
				definition.scaleY = 50;
				break;
			case 9862:
				definition.setDefault();
				definition.name = "Turkey pet (Mutated)";
				definition.npcModels = MobDefinition.get(8501).npcModels;
				definition.combatLevel = 0;
				definition.standAnimation =  MobDefinition.get(8501).standAnimation;
				definition.walkAnimation = MobDefinition.get(8501).walkAnimation;
				definition.actions = new String[] {null, null, null, null, null};
				definition.drawYellowDotOnMap = false;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 60;
				definition.scaleY = 60;
				definition.colorChange = new double[]{0.9, 0, 0};
				break;
            default:
                break;
        }
    }

    private static void applyCustomNpcs14(int id, MobDefinition definition) {
        switch (id) {
			case 9863:
				definition.setDefault();
				definition.name = "Turkey pet (Mutated)";
				definition.npcModels = MobDefinition.get(8501).npcModels;
				definition.combatLevel = 0;
				definition.standAnimation =  MobDefinition.get(8501).standAnimation;
				definition.walkAnimation = MobDefinition.get(8501).walkAnimation;
				definition.actions = new String[] {null, null, null, null, null};
				definition.drawYellowDotOnMap = false;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 60;
				definition.scaleY = 60;
				definition.colorChange = new double[]{0, 0.8, 0};
				break;
			case 9864:
				definition.setDefault();
				definition.name = "Turkey pet (Mutated)";
				definition.npcModels = MobDefinition.get(8501).npcModels;
				definition.combatLevel = 0;
				definition.standAnimation =  MobDefinition.get(8501).standAnimation;
				definition.walkAnimation = MobDefinition.get(8501).walkAnimation;
				definition.actions = new String[] {null, null, null, null, null};
				definition.drawYellowDotOnMap = false;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 60;
				definition.scaleY = 60;
				definition.colorChange = new double[]{0, 0, 1.2};
				break;
			case 9865:
				definition.setDefault();
				definition.name = "Turkey pet (Mutated)";
				definition.npcModels = MobDefinition.get(8501).npcModels;
				definition.combatLevel = 0;
				definition.standAnimation =  MobDefinition.get(8501).standAnimation;
				definition.walkAnimation = MobDefinition.get(8501).walkAnimation;
				definition.actions = new String[] {null, null, null, null, null};
				definition.drawYellowDotOnMap = false;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 60;
				definition.scaleY = 60;
				definition.colorChange = new double[]{0.9, 0.5, 0};
				break;
			case 9866:
				definition.setDefault();
				definition.name = "Turkey pet (Mutated)";
				definition.npcModels = MobDefinition.get(8501).npcModels;
				definition.combatLevel = 0;
				definition.standAnimation =  MobDefinition.get(8501).standAnimation;
				definition.walkAnimation = MobDefinition.get(8501).walkAnimation;
				definition.actions = new String[] {null, null, null, null, null};
				definition.drawYellowDotOnMap = false;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 60;
				definition.scaleY = 60;
				definition.colorChange = new double[]{0.8, 0, 0.8};
				break;
			case 9867:
				definition.setDefault();
				definition.name = "Turkey pet (Mutated)";
				definition.npcModels = MobDefinition.get(8501).npcModels;
				definition.combatLevel = 0;
				definition.standAnimation =  MobDefinition.get(8501).standAnimation;
				definition.walkAnimation = MobDefinition.get(8501).walkAnimation;
				definition.actions = new String[] {null, null, null, null, null};
				definition.drawYellowDotOnMap = false;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 60;
				definition.scaleY = 60;
				definition.colorChange = new double[]{0.9, 0.9, 0};
				break;
			case 9868:
				definition.setDefault();
				definition.name = "Turkey pet (Mutated)";
				definition.npcModels = MobDefinition.get(8501).npcModels;
				definition.combatLevel = 0;
				definition.standAnimation =  MobDefinition.get(8501).standAnimation;
				definition.walkAnimation = MobDefinition.get(8501).walkAnimation;
				definition.actions = new String[] {null, null, null, null, null};
				definition.drawYellowDotOnMap = false;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 60;
				definition.scaleY = 60;
				definition.colorChange = new double[]{3, 3, 4};
				break;

			case 9894:
				definition.setDefault();
				definition.npcModels = new int[]{19731};
				definition.standAnimation =  MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.actions = MobDefinition.get(1).actions;
				definition.combatLevel = 666;
				definition.name = "Necromancer";
				definition.scaleXZ = 230;
				definition.scaleY = 230;
				definition.npcSizeInSquares = 3;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;

			case 9895:
				definition.setDefault();
				definition.npcModels = new int[]{19731};
				definition.standAnimation =  MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.actions = MobDefinition.get(1).actions;
				definition.combatLevel = 666;
				definition.name = "Necromancer pet";
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, null, null, null, null};
				break;

			case 11812:
				definition.name = "Tumeken's Guardian";
				definition.npcModels = new int[] { 21698,21669 };
				definition.standAnimation = 9655;
				definition.npcSizeInSquares = 1;
				definition.walkAnimation = 9651;
				definition.actions = new String[] { "Talk-to", null, "Metamorphosis", "Pick-up", null };
				definition.drawYellowDotOnMap = false;
				definition.combatLevel = 0;
				definition.scaleXZ = 65;
				definition.scaleY = 65;
				break;

			case 10005:
				definition.setDefault();
				definition.npcModels = new int[]{20593,20594,20595,20596,20605};
				definition.standAnimation =  MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.actions = MobDefinition.get(1).actions;
				definition.combatLevel = 0;
				definition.name = "Krampus";
				definition.scaleXZ = 330;
				definition.scaleY = 330;
				definition.npcSizeInSquares = 4;
				definition.headIcon = -1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;

			case 12006:
				definition.setDefault();
				definition.npcModels = new int[]{20593,20594,20595,20596,20605};
				definition.standAnimation =  MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.actions = MobDefinition.get(1).actions;
				definition.combatLevel = 0;
				definition.name = "Krampus pet";
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.npcSizeInSquares = 1;
				definition.headIcon = -1;
				definition.actions = new String[]{null, null, null, null, null};
				break;
			case 10002:
				definition.setDefault();
					definition.npcModels = new int[]{20611};
				definition.standAnimation =  MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.actions = MobDefinition.get(1).actions;
				definition.combatLevel = 0;
				definition.name = "Christmas Bear";
				definition.scaleXZ = 110;
				definition.scaleY = 110;
				definition.npcSizeInSquares = 1;
				definition.headIcon = -1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 9891://2880 4096
				definition.setDefault();
				definition.npcModels = MobDefinition.get(3313).npcModels;
				definition.standAnimation =  MobDefinition.get(3313).standAnimation;
				definition.walkAnimation = MobDefinition.get(3313).walkAnimation;
				definition.actions = MobDefinition.get(3313).actions;
				definition.combatLevel = 0;
				definition.name = "Dark Prysm";
				definition.scaleXZ = 230;
				definition.scaleY = 230;
				definition.npcSizeInSquares = 3;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.rdc2 = 662436;
				break;

			case 53:
				definition.name = "Joyx Golem";
				definition.npcModels = new int[]{17213};
				definition.scaleXZ = 229;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleY = 229;
				definition.npcSizeInSquares = 2;
				break;
			case 3060:
				definition.npcModels = new int[]{49137, 49144};
				definition.name = "Blue dragon";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 111;
				definition.standAnimation = 12248;
				definition.walkAnimation = 12246;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.npcSizeInSquares = 2;
				break;
			case 3061:
				definition.npcModels = new int[]{14294, 49144};
				definition.name = "Black dragon";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 227;
				definition.standAnimation = 12248;
				definition.walkAnimation = 12246;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.npcSizeInSquares = 2;
				break;
			case 3062:
				definition.npcModels = new int[]{63604, 63606};
				definition.name = "WildyWyrm Jr";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 382;
				definition.standAnimation = 12790;
				definition.walkAnimation = 12790;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.npcSizeInSquares = 2;
				break;
			case 3334:
				definition.rdc2 = 92581;//this is how its recoloured.
				definition.name = "Deadly WildyWyrm";
				break;
			// boss pets
			case 6302:
				definition.npcModels = new int[]{26262};
				definition.name = "Skeleton hellhound";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 97;
				definition.standAnimation = 6580;
				definition.walkAnimation = 6577;
				definition.scaleXZ = 75;
				definition.scaleY = 75;
				definition.npcSizeInSquares = 1;
				definition.description = "A skilling pet from the Prayer skill.".getBytes();
				break;
			case 6303:
				definition.npcModels = new int[]{10633, 10640, 10637, 10638, 10632};
				definition.name = "Maze Guardian";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 0;
				definition.standAnimation = 3033;
				definition.walkAnimation = 3034;
				definition.scaleXZ = 50;
				definition.scaleY = 50;
				definition.npcSizeInSquares = 1;
				definition.description = "A skilling pet from the Runecrafting skill.".getBytes();
				break;
			case 6304:
				definition.npcModels = new int[]{26631, 26636, 26641, 23932, 26624, 11788};
				definition.name = "Skeleton Warlord";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 97;
				definition.standAnimation = 2065;
				definition.walkAnimation = 2064;
				definition.scaleXZ = 85;
				definition.scaleY = 85;
				definition.npcSizeInSquares = 1;
				break;
			case 6305:
				definition.npcModels = new int[]{21547};
				definition.name = "Penguin";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 2;
				definition.standAnimation = 5668;
				definition.walkAnimation = 5666;
				definition.scaleXZ = 75;
				definition.scaleY = 75;
				definition.npcSizeInSquares = 1;
				definition.description = "A skilling pet from the Agility skill.".getBytes();
				break;
			case 6306:
				definition.npcModels = new int[]{217, 181, 250, 292, 170, 176, 260};
				definition.name = "Druid";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 0;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 75;
				definition.scaleY = 75;
				definition.npcSizeInSquares = 1;
				definition.originalModelColours = new int[3];
				definition.originalModelColours[0] = 25238;
				definition.originalModelColours[1] = 8741;
				definition.originalModelColours[2] = 6798;
				definition.changedModelColours = new int[3];
				definition.changedModelColours[0] = 127;
				definition.changedModelColours[1] = 127;
				definition.changedModelColours[2] = 127;
				definition.description = "A skilling pet from the Herblore skill.".getBytes();
				break;
			case 613:
				definition.name = "Lost Survivor";
				definition.actions = new String[]{"Talk-to", null, null, null, null};
				break;

			case 2899:
				definition.walkAnimation = 1660;
				definition.standAnimation = 4113;//5316
				definition.actions = new String[]{"Talk-to", null, null, null, null};
				break;

			case 9127:
				definition.copy(741);
				definition.standAnimation = 1386;
				definition.walkAnimation = 1380;
				definition.drawYellowDotOnMap = true;
				definition.name = "Duke Horacio";
				definition.combatLevel = MobDefinition.get(2292).combatLevel;
				definition.standAnimation = 346;
				definition.walkAnimation = MobDefinition.get(2292).walkAnimation;
				definition.actions = new String[]{"Talk-to", null, null, null, null};
				break;

			case 9128:
				definition.copy(942);
				definition.drawYellowDotOnMap = true;
				definition.scaleXZ = 200;
				definition.scaleY = 200;
				definition.name = "Evil cook";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.rdc2 = 800;
				break;

			case 677:
				definition.rdc2 = 800;
				break;

			case 6307:
				definition.npcModels = new int[]{4821, 4828, 4833};
				definition.name = "Monkey guard";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 149;
				definition.standAnimation = 1386;
				definition.walkAnimation = 1380;
				definition.scaleXZ = 125;
				definition.scaleY = 125;
				definition.npcSizeInSquares = 1;
				definition.description = "A skilling pet from the Thieving skill.".getBytes();
				break;
			case 6308:
				definition.npcModels = new int[]{14104, 14103};
				definition.name = "Clockwork cat";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 0;
				definition.standAnimation = 317;
				definition.walkAnimation = 314;
				definition.scaleXZ = 75;
				definition.scaleY = 75;
				definition.npcSizeInSquares = 1;
				definition.description = "A skilling pet from the Crafting skill.".getBytes();
				break;
			case 6309:
				definition.npcModels = new int[]{26863};
				definition.name = "Jubbly bird";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 9;
				definition.standAnimation = 6803;
				definition.walkAnimation = 6804;
				definition.scaleXZ = 50;
				definition.scaleY = 50;
				definition.npcSizeInSquares = 1;
				definition.description = "A skilling pet from the Fletching skill.".getBytes();
				break;
			case 6310:
				definition.npcModels = new int[]{5076, 5077};
				definition.name = "Dust devil";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 122;
				definition.standAnimation = 1556;
				definition.walkAnimation = 1554;
				definition.scaleXZ = 75;
				definition.scaleY = 75;
				definition.npcSizeInSquares = 1;
				definition.description = "A skilling pet from the Slayer skill.".getBytes();
				break;
			case 6312:
				definition.npcModels = new int[]{19371};
				definition.name = "Chinchompa";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 2;
				definition.standAnimation = 5182;
				definition.walkAnimation = 5181;
				definition.scaleXZ = 125;
				definition.scaleY = 125;
				definition.npcSizeInSquares = 1;
				definition.description = "A skilling pet from the Hunter skill.".getBytes();
				break;
			case 6313:
				definition.npcModels = new int[]{6146, 6148, 6150};
				definition.name = "Clay Golem";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 0;
				definition.standAnimation = 1913;
				definition.walkAnimation = 1912;
				definition.scaleXZ = 75;
				definition.scaleY = 75;
				definition.npcSizeInSquares = 1;
				definition.description = "A skilling pet from the Mining skill.".getBytes();
				break;
			case 6314:
				definition.npcModels = new int[]{2970, 2982, 2977, 2983, 2985, 2989, 2993, 2991};
				definition.name = "Chaos Dwarf";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 97;
				definition.standAnimation = 101;
				definition.walkAnimation = 98;
				definition.scaleXZ = 90;
				definition.scaleY = 90;
				definition.npcSizeInSquares = 1;
				definition.description = "A skilling pet from the Smithing skill.".getBytes();
				break;
			case 6315:
				definition.npcModels = new int[]{2848};
				definition.name = "Shark";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 0;
				definition.standAnimation = 10;
				definition.walkAnimation = 10;
				definition.scaleXZ = 75;
				definition.scaleY = 75;
				definition.npcSizeInSquares = 1;
				definition.description = "A skilling pet from the Fishing skill.".getBytes();
				break;
			case 6316:
				definition.npcModels = new int[]{24461, 24490, 24439, 24480, 24446, 24452, 24503};
				definition.name = "Goblin cook";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 0;
				definition.standAnimation = 6181;
				definition.walkAnimation = 6180;
				definition.scaleXZ = 75;
				definition.scaleY = 75;
				definition.npcSizeInSquares = 1;
				definition.description = "A skilling pet from the Cooking skill.".getBytes();
				break;
			case 6317:
				definition.npcModels = new int[]{335};
				definition.name = "Fire elemental";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 35;
				definition.standAnimation = 1027;
				definition.walkAnimation = 1028;
				definition.scaleXZ = 75;
				definition.scaleY = 75;
				definition.npcSizeInSquares = 1;
				definition.description = "A skilling pet from the Firemaking skill.".getBytes();
				break;
			case 6318:
				definition.npcModels = new int[]{21150};
				definition.name = "Tree spirit";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 101;
				definition.standAnimation = 5530;
				definition.walkAnimation = 5531;
				definition.scaleXZ = 75;
				definition.scaleY = 75;
				definition.npcSizeInSquares = 1;
				definition.description = "A skilling pet from the Woodcutting skill.".getBytes();
				break;
			case 6319:
				definition.npcModels = new int[]{10220};
				definition.name = "Leprechaun";//3021
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 0;
				definition.standAnimation = 2904;
				definition.walkAnimation = 189;
				definition.scaleXZ = 75;
				definition.scaleY = 75;
				definition.npcSizeInSquares = 1;
				definition.description = "A skilling pet from the Farming skill.".getBytes();
				break;
            default:
                break;
        }
    }

    private static void applyCustomNpcs15(int id, MobDefinition definition) {
        switch (id) {
			case 6320:
				definition.name = "Night spider @bla@x1.5 EXP - X1.5 DMG";
				MobDefinition nightspider = MobDefinition.get(63);
				definition.description = "night spider.".getBytes();
				definition.npcModels = nightspider.npcModels;
				definition.combatLevel = nightspider.combatLevel;
				definition.standAnimation = nightspider.standAnimation;
				definition.walkAnimation = nightspider.walkAnimation;
				definition.degreesToTurn = 32;
				definition.scaleXZ = nightspider.scaleXZ;
				definition.scaleY = nightspider.scaleY;
				definition.rdc2 = 23523;
				definition.combatLevel = 144;
				definition.description = "A halloween pet gives bonus Exp and bonus dmg boost.".getBytes();
				break;
			case 6311:
				definition.npcModels = new int[]{5062};
				definition.name = "Abyssal demon";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 124;
				definition.standAnimation = 1536;
				definition.walkAnimation = 1534;
				definition.scaleXZ = 50;
				definition.scaleY = 50;
				definition.npcSizeInSquares = 1;
				definition.description = "A skilling pet from the Slayer skill.".getBytes();
				break;
			case 6440:
				definition.npcModels = new int[]{65176};
				definition.name = "Ice titan";
				definition.actions = new String[5];
				definition.actions[0] = null;
				definition.combatLevel = 138;
				definition.standAnimation = 7949;
				definition.walkAnimation = 7952;
				definition.scaleXZ = 50;
				definition.scaleY = 50;
				definition.npcSizeInSquares = 1;
				definition.description = "A skilling pet from the Slayer skill.".getBytes();
				break;
			case 6322:
				definition.name = "Serpentine Spawn";
				definition.actions = new String[]{null, null, null, null, null};
				definition.npcModels = new int[1];
				definition.combatLevel = 53;
				definition.standAnimation = 5070;
				definition.walkAnimation = 5070;
				definition.scaleY = 25;
				definition.scaleXZ = 25;
				definition.npcSizeInSquares = 2;
				definition.npcModels = new int[1];
				definition.npcModels[0] = 14408;
				break;
			case 6323:
				definition.name = "Tanzanite Spawn";
				definition.actions = new String[]{null, null, null, null, null};
				definition.npcModels = new int[1];
				definition.combatLevel = 52;
				definition.standAnimation = 5070;
				definition.walkAnimation = 5070;
				definition.scaleY = 25;
				definition.scaleXZ = 25;
				definition.npcSizeInSquares = 2;
				definition.npcModels = new int[1];
				definition.npcModels[0] = 14407;
				break;
			case 6324:
				definition.name = "Magma Spawn";
				definition.actions = new String[]{null, null, null, null, null};
				definition.npcModels = new int[1];
				definition.combatLevel = 52;
				definition.standAnimation = 5070;
				definition.walkAnimation = 5070;
				definition.scaleY = 25;
				definition.scaleXZ = 25;
				definition.npcSizeInSquares = 2;
				definition.npcModels = new int[1];
				definition.npcModels[0] = 14409;
				break;
			case 6830:
			case 6841:
			case 6796:
			case 7331:
			case 6831:
			case 7361:
			case 6847:
			case 6872:
			case 7353:
			case 6835:
			case 6845:
			case 6808:
			case 7370:
			case 7333:
			case 7351:
			case 7367:
			case 6853:
			case 6855:
			case 6857:
			case 6859:
			case 6861:
			case 6863:
			case 9481:
			case 6827:
			case 6889:
			case 6813:
			case 6817:
			case 7372:
			case 6839:
			case 8575:
			case 7345:
			case 7335:
			case 7347:
			case 6800:
            default:
                break;
        }
    }

    private static void applyCustomNpcs16(int id, MobDefinition definition) {
        switch (id) {
			case 9488:
			case 6822:
			case 6849:
			case 7355:
			case 7357:
			case 7359:
			case 7341:
			case 7329:
			case 7339:
			case 7349:
			case 7375:
			case 7343:
			case 6820:
			case 6865:
			case 6809:
			case 7363:
			case 7337:
			case 7365:
			case 6991:
			case 6992:
			case 6869:
			case 6818:
			case 6843:
			case 6823:
			case 7377:
			case 6887:
			case 6885:
			case 6883:
			case 6881:
			case 6879:
			case 6877:
			case 6875:
			case 6833:
			case 6851:
			case 5079:
			case 5080:
			case 6824:
				definition.actions = new String[]{null, null, null, null, null};
				break;
			case 6806: // thorny snail
			case 6807:
			case 6994: // spirit kalphite
            default:
                break;
        }
    }

    private static void applyCustomNpcs17(int id, MobDefinition definition) {
        switch (id) {
			case 6995:
			case 6867: // bull ant
			case 6868:
			case 6794: // spirit terrorbird
			case 6795:
			case 6815: // war tortoise
			case 6816:
			case 6874:// pack yak
			case 3594: // yak
			case 3590: // war tortoise
			case 3596: // terrorbird
				definition.actions = new String[]{"Store", null, null, null, null};
				break;
			case 12239:
				definition.name = "Exoden";
				definition.combatLevel = 1087;
				definition.description = "That thing can't be mortal...".getBytes();
				definition.walkAnimation = 6505;
				definition.standAnimation = 6504;//6504 stand, 6503 block, 6502 death, 6501 attack
				definition.npcSizeInSquares = 4;
				definition.npcModels = new int[]{64094};
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 91:
				definition.name = "Leo the Lion";
				definition.combatLevel = 333;
				definition.description = "That thing can't be mortal...".getBytes();
				definition.walkAnimation = 0;
				definition.standAnimation = 0;
				definition.npcSizeInSquares = 4;

				definition.npcModels = new int[]{64095};
				definition.rdc = 2;
				break;
			case 6250:
				MobDefinition other2 = get(91);
				definition.name = "Leo the Lion";
				definition.combatLevel = 333;
				definition.description = "That thing can't be mortal...".getBytes();
				definition.walkAnimation = other2.walkAnimation;
				definition.standAnimation = other2.standAnimation;

				definition.npcModels = new int[]{64095};

				break;
			case 548:
				MobDefinition shop2 = MobDefinition.get(3900);
				definition.npcModels = shop2.npcModels;
				definition.actions = new String[]{"Trade", null, null, null, null};
				break;

			case 437:
				definition.actions = new String[]{"Trade", null, null, null, null};
				break;
			case 1265:
				MobDefinition other3 = get(6250);
				definition.name = "Levincia Lion";
				definition.drawYellowDotOnMap = true;
				definition.walkAnimation = other3.walkAnimation;
				definition.standAnimation = other3.standAnimation;
				definition.npcModels = new int[]{64095};//64091
				break;
			case 1267:
				definition.drawYellowDotOnMap = true;
				definition.scaleY = 180;
				definition.scaleXZ = 180;
				definition.combatLevel = 26;
				break;
			case 1677:
				//	definition.rdc2 = 35323;
				break;
			case 1674:
				//definition.rdc2 = 18142;
				break;
			case 8459:
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = true;
				definition.actions = new String[]{"Shop", null, "Decant", null, null};
				definition.name = "Healer";
				break;
			case 3299:
				definition.actions = new String[]{"Trade" ,null, null, null, null};
				definition.name = "Master farmer";
				break;
			case 948:
				definition.actions = new String[]{"Trade" ,null, null, null, null};
				definition.name = "Master miner";
				break;
			case 961:
				definition.npcModels = new int[1];
				definition.npcModels[0] = 20562;
				definition.actions = new String[]{null, null, "Buy Consumables", "Restore Stats", "Buy Food"};
				definition.name = "Healer";
				definition.scaleY = 56;
				definition.scaleXZ = 60;
				break;
			case 705:
				MobDefinition shop3 = MobDefinition.get(14010);
				definition.npcModels = shop3.npcModels;

				definition.actions = new String[]{null, null, "Buy Armour", "Buy Weapons", "Buy Jewelries"};
				definition.name = "Warrior";
				break;
			case 1861:
				definition.actions = new String[]{null, null, "Buy Equipment", "Buy Ammunition", null};
				definition.name = "Archer";
				break;
			case 946:
				MobDefinition shop4 = MobDefinition.get(14013);
				definition.npcModels = shop4.npcModels;
				definition.actions = new String[]{null, null, "Buy Equipment", "Buy Runes", "Buy Teleports"};
				definition.name = "Mage";
				break;
			case 2253:
				definition.actions = new String[]{null, null, "Buy Skillcapes", "Buy Skillcapes (t)", "Buy Hoods"};
				break;
			case 2292:
				definition.actions = new String[]{"Trade", null, null, null, null};
				definition.name = "Merchant";
				break;
			case 2676:
				definition.actions = new String[]{"Makeover", null, null, null, null};
				break;

			case 494:
			case 1360:

				definition.actions = new String[]{"Talk-to", null, null, null, null};
				break;
			case 3089:
				definition.name = "Pvm Ticket Shop";
				definition.actions = new String[]{"Talk-to", null, null, null, null};
				break;




			//custom pets go here
			case 659:
				definition.scaleY = 180;
				definition.scaleXZ = 180;

				definition.actions = new String[]{"Open-Halloween Event", "Event-points", null, null, null};
				break;

			case 6325:
				definition.name = "Superior Abyssal Demon";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcModels = new int[]{5062, 51602};
				definition.originalModelColours = new int[]{22439, /*4015*/};
				definition.changedModelColours = new int[]{947, /*528*/};
				definition.combatLevel = 124;
				definition.standAnimation = 1536;
				definition.walkAnimation = 1534;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.description = "A denizen of the Abyss!".getBytes();
				break;

			case 6335:
				definition.name = "Zamorakian Mage";
				definition.description = "stuff".getBytes();
				definition.combatLevel = 84;
				definition.npcModels = new int[]{9981, 250, 25676, 23916, 176, 23934, 181,};
				definition.originalModelColours = new int[]{24, 16, 8, 920, 28, 12};
				definition.changedModelColours = new int[]{801, 65428, 788, 906, 119, 65428};
				definition.actions = new String[]{null, "attack", null, null, null};
				definition.degreesToTurn = 32;
				definition.headIcon = -1;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.walkingBackwardsAnimation = -1;
				definition.walkLeftAnimation = -1;
				definition.walkRightAnimation = -1;
				definition.configChild = -1;
				definition.varBitChild = -1;
				definition.modelLightning = 0;
				definition.modelShadowing = 0;
				definition.drawYellowDotOnMap = true;
				definition.disableRightClick = true;
				definition.visibilityOrRendering = false;
				break;
			case 6334:
				definition.name = "Abyssal Titan";
				definition.description = "stuff".getBytes();
				definition.combatLevel = 0;
				definition.npcModels = new int[]{30474};
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.degreesToTurn = 32;
				definition.headIcon = -1;
				definition.npcSizeInSquares = 3;
				definition.standAnimation = 7690;
				definition.walkAnimation = 7687;
				definition.walkingBackwardsAnimation = -1;
				definition.walkLeftAnimation = -1;
				definition.walkRightAnimation = -1;
				definition.configChild = -1;
				definition.varBitChild = -1;
				definition.modelLightning = 25;
				definition.modelShadowing = 0;
				definition.drawYellowDotOnMap = false;
				definition.disableRightClick = true;
				definition.visibilityOrRendering = false;
				definition.scaleXZ = 150;
				definition.scaleY = 150;
				break;

			case 6330:
				definition.name = "Giant Skeleton";
				definition.description = "stuff".getBytes();
				definition.combatLevel = 303;
				definition.npcModels = new int[]{21168, 21179, 21160, 21157, 21182, 21188, 21202};
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.degreesToTurn = 32;
				definition.headIcon = -1;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 5483;
				definition.walkAnimation = 5479;
				definition.walkingBackwardsAnimation = -1;
				definition.walkLeftAnimation = -1;
				definition.walkRightAnimation = -1;
				definition.configChild = -1;
				definition.varBitChild = -1;
				definition.modelLightning = 0;
				definition.modelShadowing = 0;
				definition.drawYellowDotOnMap = true;
				definition.disableRightClick = true;
				definition.visibilityOrRendering = false;
				break;
			case 6329:
				definition.name = "Skeleton Brute";
				definition.description = "stuff".getBytes();
				definition.combatLevel = 132;
				definition.npcModels = new int[]{26628, 26637, 26642, 23932, 26623};
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.degreesToTurn = 32;
				definition.headIcon = -1;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.walkingBackwardsAnimation = -1;
				definition.walkLeftAnimation = -1;
				definition.walkRightAnimation = -1;
				definition.configChild = -1;
				definition.varBitChild = -1;
				definition.modelLightning = 0;
				definition.modelShadowing = 0;
				definition.drawYellowDotOnMap = true;
				definition.disableRightClick = true;
				definition.visibilityOrRendering = false;
				break;
			case 1471:
				definition.name = "Monkey Skeleton";
				break;
            default:
                break;
        }
    }

    private static void applyCustomNpcs18(int id, MobDefinition definition) {
        switch (id) {
			case 6328:
				definition.name = "Skeleton Mage";
				definition.description = "stuff".getBytes();
				definition.combatLevel = 64;
				definition.npcModels = new int[]{21196};
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.degreesToTurn = 32;
				definition.headIcon = -1;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 5483;
				definition.walkAnimation = 5476;
				definition.walkingBackwardsAnimation = -1;
				definition.walkLeftAnimation = -1;
				definition.walkRightAnimation = -1;
				definition.configChild = -1;
				definition.varBitChild = -1;
				definition.modelLightning = 0;
				definition.modelShadowing = 0;
				definition.drawYellowDotOnMap = true;
				definition.disableRightClick = true;
				definition.visibilityOrRendering = false;
				break;
			case 6327:
				definition.name = "Skeleton fremennik";
				definition.description = "stuff".getBytes();
				definition.combatLevel = 60;
				definition.npcModels = new int[]{24181, 24189, 24185, 24053};
				definition.originalModelColours = new int[]{8404, 12694, 12574, 8400, 10531};
				definition.changedModelColours = new int[]{10299, 8472, 7452, 10299, 7335};
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.degreesToTurn = 32;
				definition.headIcon = -1;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 6113;
				definition.walkAnimation = 6112;
				definition.walkingBackwardsAnimation = -1;
				definition.walkLeftAnimation = -1;
				definition.walkRightAnimation = -1;
				definition.configChild = -1;
				definition.varBitChild = -1;
				definition.modelLightning = 0;
				definition.modelShadowing = 0;
				definition.drawYellowDotOnMap = true;
				definition.disableRightClick = true;
				definition.visibilityOrRendering = false;
				break;
			case 1700:
				MobDefinition slayer1 = get(6796);
				definition.name = "Granite crab";
				definition.combatLevel = 40;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = slayer1.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = slayer1.npcModels.clone();
				definition.standAnimation = slayer1.standAnimation;
				definition.walkAnimation = slayer1.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 8088;
				break;
			case 1701:
				MobDefinition slayer2 = get(78);
				definition.name = "Icicle Bat";
				definition.combatLevel = 40;
				definition.scaleXZ = 90;
				definition.scaleY = 90;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = slayer2.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = slayer2.npcModels.clone();
				definition.standAnimation = slayer2.standAnimation;
				definition.walkAnimation = slayer2.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 36462;
				break;
			case 1702:
				MobDefinition slayer3 = get(3499);
				definition.name = "Lavannoth";
				definition.combatLevel = 40;
				definition.scaleXZ = 70;
				definition.scaleY = 70;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = slayer3.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = slayer3.npcModels.clone();
				definition.standAnimation = slayer3.standAnimation;
				definition.walkAnimation = slayer3.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 5674;
				break;
			case 1703:
				MobDefinition slayer4 = get(1652);
				definition.name = "Vampyre Hands";
				definition.combatLevel = 40;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = slayer4.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = slayer4.npcModels.clone();
				definition.standAnimation = slayer4.standAnimation;
				definition.walkAnimation = slayer4.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 34567;
				break;
			case 1704:
				MobDefinition slayer55 = get(1612);
				definition.name = "Crazy witch";
				definition.combatLevel = 40;
				definition.scaleXZ = 90;
				definition.scaleY = 90;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = slayer55.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = slayer55.npcModels.clone();
				definition.standAnimation = slayer55.standAnimation;
				definition.walkAnimation = slayer55.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 2345;
				break;
			case 1705:
				MobDefinition slayer6 = get(6813);
				definition.name = "Bunyip";
				definition.combatLevel = 40;
				definition.scaleXZ = 90;
				definition.scaleY = 90;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = slayer6.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = slayer6.npcModels.clone();
				definition.standAnimation = slayer6.standAnimation;
				definition.walkAnimation = slayer6.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 267;//236773
				break;
			case 1707:
				MobDefinition slayer8 = get(4275);
				definition.name = "Terrorstep";
				definition.combatLevel = 40;
				definition.scaleXZ = 390;
				definition.scaleY = 390;
				definition.npcSizeInSquares = 4;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = slayer8.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = slayer8.npcModels.clone();
				definition.standAnimation = slayer8.standAnimation;
				definition.walkAnimation = slayer8.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 32562;
				break;
			case 1708:
				MobDefinition slayer9 = get(1604);
				definition.name = "Ghoulord";
				definition.combatLevel = 40;
				definition.scaleXZ = 90;
				definition.scaleY = 90;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = slayer9.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = slayer9.npcModels.clone();
				definition.standAnimation = slayer9.standAnimation;
				definition.walkAnimation = slayer9.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 34543;
				break;
			case 1709:
				definition.name = "Pelican bird";
				MobDefinition slayer61 = MobDefinition.get(6795);
				definition.description = "GWD.".getBytes();
				//definition.npcModels = new int[] {64064};
				definition.combatLevel = 40;
				definition.scaleXZ = 140;
				definition.scaleY = 140;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = slayer61.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = slayer61.npcModels.clone();
				definition.standAnimation = slayer61.standAnimation;
				definition.walkAnimation = slayer61.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 857;
				break;
			case 1710:
				definition.name = "Trapper";
				MobDefinition slayer101 = MobDefinition.get(1618);
				definition.description = "GWD.".getBytes();
				//definition.npcModels = new int[] {64064};
				definition.combatLevel = 40;
				definition.scaleXZ = 110;
				definition.scaleY = 110;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = slayer101.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = new int[]{18333};
				definition.standAnimation = slayer101.standAnimation;
				definition.walkAnimation = slayer101.walkAnimation;
				definition.degreesToTurn = 32;
				break;

			case 1711:
				MobDefinition firebat = get(7335);
				definition.name = "Flaming butterfly";
				definition.combatLevel = 40;
				definition.scaleXZ = 110;
				definition.scaleY = 110;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = firebat.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = firebat.npcModels.clone();
				definition.standAnimation = firebat.standAnimation;
				definition.walkAnimation = firebat.walkAnimation;
				definition.degreesToTurn = 32;
				//definition.rdc2 = 36462;
				break;
			case 1712:
				MobDefinition gargoyle2 = get(1610);
				definition.name = "Rusted Gargoyle";
				definition.combatLevel = 40;
				definition.scaleXZ = 90;
				definition.scaleY = 90;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = gargoyle2.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = gargoyle2.npcModels.clone();
				definition.standAnimation = gargoyle2.standAnimation;
				definition.walkAnimation = gargoyle2.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 2467;
				break;
			case 1713:
				MobDefinition b1712 = get(7331);
				definition.name = "Mosquito";
				definition.combatLevel = 40;
				definition.scaleXZ = 90;
				definition.scaleY = 90;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b1712.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b1712.npcModels.clone();
				definition.standAnimation = b1712.standAnimation;
				definition.walkAnimation = b1712.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 2467;
				break;
			case 1714:
				MobDefinition b1714 = get(1615);
				definition.name = "PVM Demon";
				definition.combatLevel = 40;
				definition.scaleXZ = 90;
				definition.scaleY = 90;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b1714.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b1714.npcModels.clone();
				definition.standAnimation = b1714.standAnimation;
				definition.walkAnimation = b1714.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 342;
				break;
			case 1715:
				MobDefinition b1715 = get(84);
				definition.name = "Native demon";
				definition.combatLevel = 40;
				definition.scaleXZ = 90;
				definition.scaleY = 90;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b1715.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b1715.npcModels.clone();
				definition.standAnimation = b1715.standAnimation;
				definition.walkAnimation = b1715.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 1245;
				break;
			case 1716:
				MobDefinition b1716 = get(6831);
				definition.name = "Chinese dragon";
				definition.combatLevel = 40;
				definition.scaleXZ = 190;
				definition.scaleY = 190;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b1716.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b1716.npcModels.clone();
				definition.standAnimation = b1716.standAnimation;
				definition.walkAnimation = b1716.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 9876;
				break;
			case 1717:
				MobDefinition b1717 = get(6837);
				definition.name = "Flesh Scorpian";
				definition.combatLevel = 40;
				definition.scaleXZ = 190;
				definition.scaleY = 190;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b1717.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b1717.npcModels.clone();
				definition.standAnimation = b1717.standAnimation;
				definition.walkAnimation = b1717.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 2345;
				break;

			case 1718:
				MobDefinition b1718 = get(6872);
				definition.name = "Tree Gorgon";
				definition.combatLevel = 40;
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b1718.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b1718.npcModels.clone();
				definition.standAnimation = b1718.standAnimation;
				definition.walkAnimation = b1718.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 4364;
				break;
			case 1719:
				MobDefinition b1719 = get(6860);
				definition.name = "Armoured minotaur";
				definition.combatLevel = 40;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b1719.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b1719.npcModels.clone();
				definition.standAnimation = b1719.standAnimation;
				definition.walkAnimation = b1719.walkAnimation;
				definition.degreesToTurn = 32;
				//definition.rdc2 = 15;
				break;
			case 1721:
				MobDefinition b17120 = get(7333);
				definition.name = "Jellyfish";
				definition.combatLevel = 40;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b17120.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b17120.npcModels.clone();
				definition.standAnimation = b17120.standAnimation;
				definition.walkAnimation = b17120.walkAnimation;
				definition.degreesToTurn = 32;
				//	definition.rdc2 = 964;
				break;
			case 1723:
				MobDefinition b17122 = get(7353);
				definition.name = "Evil chinchompa";
				definition.combatLevel = 40;
				definition.scaleXZ = 200;
				definition.scaleY = 200;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b17122.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b17122.npcModels.clone();
				definition.standAnimation = b17122.standAnimation;
				definition.walkAnimation = b17122.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 7454;
				break;
			case 1724:
				MobDefinition b17124 = get(6867);
				definition.name = "Ant worker";
				definition.combatLevel = 40;
				definition.scaleXZ = 200;
				definition.scaleY = 200;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b17124.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b17124.npcModels.clone();
				definition.standAnimation = b17124.standAnimation;
				definition.walkAnimation = b17124.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 7454;
				break;
			case 1725:
				MobDefinition b17125 = get(4972);
				definition.name = "Zamorak bat";
				definition.combatLevel = 40;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b17125.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = new int[]{18295};//64091
				definition.standAnimation = b17125.standAnimation;
				definition.walkAnimation = b17125.walkAnimation;
				definition.degreesToTurn = 32;
				//	definition.rdc2 = 111;
				break;

			case 9029:
				MobDefinition zd = get(4972);
				definition.name = "Zamorak Dragon";
				definition.combatLevel = 140;
				definition.scaleXZ = 140;
				definition.scaleY = 140;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = zd.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = new int[]{19595};//64091
				definition.standAnimation = zd.standAnimation;
				definition.walkAnimation = zd.walkAnimation;
				definition.degreesToTurn = 32;
				break;
			case 9028:
				MobDefinition gd = get(4972);
				definition.name = "Guthix Dragon";
				definition.combatLevel = 140;
				definition.scaleXZ = 140;
				definition.scaleY = 140;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = gd.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = new int[]{19596};//64091
				definition.standAnimation = gd.standAnimation;
				definition.walkAnimation = gd.walkAnimation;
				definition.degreesToTurn = 32;
				break;
				case 9030:
				MobDefinition sd = get(4972);
				definition.name = "Saradomin Dragon";
				definition.combatLevel = 140;
					definition.scaleXZ = 140;
					definition.scaleY = 140;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = sd.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = new int[]{19597};//64091
				definition.standAnimation = sd.standAnimation;
				definition.walkAnimation = sd.walkAnimation;
				definition.degreesToTurn = 32;
				break;

			case 6871:
				MobDefinition sc = get(1);
				definition.name = "Spirit critter";
				definition.combatLevel = 40;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = sc.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = new int[]{18031};
				definition.standAnimation = sc.standAnimation;
				definition.walkAnimation = sc.walkAnimation;
				definition.degreesToTurn = 32;
				break;
			case 6870:
				MobDefinition tc = get(1);
				definition.name = "Dino";
				definition.combatLevel = 40;
				definition.scaleXZ = 50;
				definition.scaleY = 50;
				definition.npcSizeInSquares = 1;
				definition.npcModels = new int[]{18121};
				definition.standAnimation = tc.standAnimation;
				definition.walkAnimation = tc.walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.degreesToTurn = 32;
				break;
			case 6792:
				MobDefinition cs = get(1);
				definition.name = "Cave Snail";
				definition.description = "A Cave Snail.".getBytes();
				definition.npcModels = new int[]{18034}; //65208
				definition.combatLevel = 333;
				definition.standAnimation = 12248;
				definition.walkAnimation = 12246;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.standAnimation = cs.standAnimation;
				definition.walkAnimation = cs.walkAnimation;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = true;
				break;

			case 1627:
				definition.scaleXZ = 250;
				definition.scaleY = 250;
				definition.npcSizeInSquares = 2;
				break;
				
			case 6799:
				MobDefinition cd = get(1);
				definition.name = "Cave Drone";
				definition.description = "A Cave Drone.".getBytes();
				definition.npcModels = new int[]{18122}; //65208
				definition.combatLevel = 333;
				definition.standAnimation = cd.standAnimation;
				definition.walkAnimation = cd.walkAnimation;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = true;
				break;
				
			case 6798:
				MobDefinition cm = get(1);
				definition.name = "Cave Mutant";
				definition.description = "A Cave Mutant.".getBytes();
				definition.npcModels = new int[]{18123}; //65208
				definition.combatLevel = 333;
				definition.standAnimation = cm.standAnimation;
				definition.walkAnimation = cm.walkAnimation;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 1;
				definition.drawYellowDotOnMap = true;
				break;
				
				
			case 1726:
				MobDefinition b1726 = get(6833);
				definition.name = "Crying turnip";
				definition.combatLevel = 40;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b1726.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b1726.npcModels.clone();
				definition.standAnimation = b1726.standAnimation;
				definition.walkAnimation = b1726.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 25236;
				break;

			case 1727:
				MobDefinition b1727 = get(1);
				definition.name = "Symbiote";
				definition.combatLevel = 40;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b1727.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = new int[]{18030};
				definition.standAnimation = b1727.standAnimation;
				definition.walkAnimation = b1727.walkAnimation;
				definition.degreesToTurn = 32;
				break;

			case 1729:
				MobDefinition b6992 = get(6992);
				definition.name = "Jello";
				definition.combatLevel = 40;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b6992.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b6992.npcModels.clone();
				definition.standAnimation = b6992.standAnimation;
				definition.walkAnimation = b6992.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 25236;
				break;

			case 1730:
				MobDefinition b1730 = get(6991);
				definition.name = "Tycoons bird";
				definition.combatLevel = 40;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b1730.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b1730.npcModels.clone();
				definition.standAnimation = b1730.standAnimation;
				definition.walkAnimation = b1730.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 9;
				break;
			case 1731:
				MobDefinition b6931 = get(7365);
				definition.name = "Sabertooth";
				definition.combatLevel = 40;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b6931.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b6931.npcModels.clone();
				definition.standAnimation = b6931.standAnimation;
				definition.walkAnimation = b6931.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 25212;
				break;

			case 1733:
				MobDefinition b1732 = get(7337);
				definition.name = "Leopard";
				definition.combatLevel = 40;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b1732.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = new int[] {31126};
				definition.standAnimation = b1732.standAnimation;
				definition.walkAnimation = b1732.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 9;
				definition.headIcon = -1;
				break;
            default:
                break;
        }
    }

    private static void applyCustomNpcs19(int id, MobDefinition definition) {
        switch (id) {
			case 1734:
				MobDefinition b69334 = get(7363);
				definition.name = "Wild Graahk";
				definition.combatLevel = 40;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b69334.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b69334.npcModels.clone();
				definition.standAnimation = b69334.standAnimation;
				definition.walkAnimation = b69334.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 152;
				definition.headIcon = -1;
				break;
				//111158 for protection
			case 1735:
				MobDefinition b1734 = get(6809);
				definition.name = "Sea creature";
				definition.combatLevel = 40;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b1734.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b1734.npcModels.clone();
				definition.standAnimation = b1734.standAnimation;
				definition.walkAnimation = b1734.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 9;
				break;
			case 1736:
				MobDefinition b6936 = get(6865);
				definition.name = "Kree devil";
				definition.combatLevel = 40;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b6936.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b6936.npcModels.clone();
				definition.standAnimation = b6936.standAnimation;
				definition.walkAnimation = b6936.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 273234;
				break;

			case 1737:
				MobDefinition b1737 = get(6827);
				definition.name = "War plant";
				definition.combatLevel = 40;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b1737.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b1737.npcModels.clone();
				definition.standAnimation = b1737.standAnimation;
				definition.walkAnimation = b1737.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 22;
				break;
			case 1738:
				MobDefinition b6938 = get(6889);
				definition.name = "Hallucination toad";
				definition.combatLevel = 40;
				definition.scaleXZ = 190;
				definition.scaleY = 170;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b6938.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b6938.npcModels.clone();
				definition.standAnimation = b6938.standAnimation;
				definition.walkAnimation = b6938.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 2367;
				break;

			case 1739:
				MobDefinition b1739 = get(7339);
				definition.name = "Blast cloud";
				definition.combatLevel = 40;
				definition.scaleXZ = 60;
				definition.scaleY = 60;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b1739.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b1739.npcModels.clone();
				definition.standAnimation = b1739.standAnimation;
				definition.walkAnimation = b1739.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 12345;
				break;
			case 1740:
				MobDefinition b69340 = get(7357);
				definition.name = "Elemental moss";
				definition.combatLevel = 40;
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b69340.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b69340.npcModels.clone();
				definition.standAnimation = b69340.standAnimation;
				definition.walkAnimation = b69340.walkAnimation;
				definition.degreesToTurn = 32;
				//	definition.rdc2 = 2367;
				break;

			case 1741:
				MobDefinition b17341 = get(7355);
				definition.name = "Elemental fire";
				definition.combatLevel = 40;
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b17341.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b17341.npcModels.clone();
				definition.standAnimation = b17341.standAnimation;
				definition.walkAnimation = b17341.walkAnimation;
				definition.degreesToTurn = 32;
				//definition.rdc2 = 12345;
				break;
			case 1742:
				MobDefinition b6932 = get(6822);
				definition.name = "Nature unicorn";
				definition.combatLevel = 40;
				definition.scaleXZ = 200;
				definition.scaleY = 200;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b6932.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b6932.npcModels.clone();
				definition.standAnimation = b6932.standAnimation;
				definition.walkAnimation = b6932.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 9090;
				break;

			case 9877:
				definition.setDefault();
				definition.name = "Santa Claus";
				definition.npcModels = MobDefinition.get(9400).npcModels;
				definition.combatLevel = 0;
				definition.standAnimation =MobDefinition.get(9400).standAnimation;
				definition.walkAnimation = MobDefinition.get(9400).walkAnimation;
				definition.actions = new String[] {null, null, null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 60;
				definition.scaleY = 60;
				break;
			case 9878:
				definition.setDefault();
				definition.name = "Evil Santa Claus";
				definition.npcModels = MobDefinition.get(9400).npcModels;
				definition.combatLevel = 0;
				definition.standAnimation =MobDefinition.get(9400).standAnimation;
				definition.walkAnimation = MobDefinition.get(9400).walkAnimation;
				definition.actions = new String[] {null, null, null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.npcSizeInSquares = 1;
				definition.scaleXZ = 100;
				definition.scaleY = 110;
				definition.name = "Evil Santa Claus";
				definition.originalModelColours = new int[]{666, 655, 671, 675, 670, 673, 680, 660 };
				definition.changedModelColours = new int[]{4, 8, 12, 0, 11, 7, 16, 10};
				break;
			case 9879:
				definition.name = "<shad=f9f6f6>Vote Boss<shad=-1>";
				MobDefinition votingboss2 = MobDefinition.get(2292);
				definition.description = "GWD.".getBytes();
				definition.npcModels = new int[]{18539};
				definition.combatLevel = votingboss2.combatLevel;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.npcSizeInSquares = 2;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				break;
			case 9880:
				definition.name = "Nightmare Boss";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 2;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 90;
				definition.scaleY = 90;
				definition.npcModels = new int[1];
				definition.npcModels[0] = 14959;
				definition.drawYellowDotOnMap = true;
				break;
			case 9881:
				definition.npcModels = new int[]{15079};
				definition.name = "Dragon king";
				definition.combatLevel = 320;
				//definition.rdc2 = 2592952;
				definition.scaleXZ = 50;
				definition.scaleY = 50;
				definition.npcSizeInSquares = 3;
				break;
			case 9882:
				definition.setDefault();
				definition.npcModels = new int[]{19688};
				definition.standAnimation =  MobDefinition.get(1).standAnimation;
				definition.walkAnimation = MobDefinition.get(1).walkAnimation;
				definition.combatLevel = 0;
				definition.name = "Vozzath";
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 2;
				definition.actions = new String[]{null, "Attack", null, null, null};
				break;
			case 9883:
				definition.name = "Zenyte Golem";
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.combatLevel = 456;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 808;
				definition.walkAnimation = 819;
				definition.scaleXZ = 60;
				definition.scaleY = 60;
				definition.npcModels = new int[1];
				definition.npcModels[0] = 100027;
				definition.drawYellowDotOnMap = true;
				break;
			case 9993:
				definition.walkAnimation = 1660;
				definition.standAnimation = 11973;
				definition.npcModels = new int[]{20551};
				definition.name = "TokHaar-Hok";
				definition.combatLevel = 1337;
				definition.degreesToTurn = 32;
				definition.actions = new String[5];
				definition.actions[1] = "Attack";
				definition.scaleY = 125;
				definition.scaleXZ = 125;
				definition.npcSizeInSquares = 2;
				break;
			case 9897:
				MobDefinition elizard = MobDefinition.get(1); //#37b33a
				definition.name = "Dragonkin minion";
				definition.npcSizeInSquares = 1;
				definition.standAnimation = elizard.standAnimation;
				definition.walkAnimation = elizard.walkAnimation;
				definition.npcModels = new int[]{20557};
				definition.scaleXZ = 80;
				definition.scaleY = 80;
				definition.actions = new String[5];
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.actions[0] = null;
				break;
			case 9899:
				MobDefinition elizard2 = MobDefinition.get(1); //#37b33a
				definition.name = "Dragonkin";
				definition.npcSizeInSquares = 3;
				definition.standAnimation = elizard2.standAnimation;
				definition.walkAnimation = elizard2.walkAnimation;
				definition.npcModels = new int[]{20557};
				definition.scaleXZ = 220;
				definition.scaleY = 220;
				definition.actions = new String[5];
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.actions[0] = null;
				break;
			case 9884:
				MobDefinition Telos = MobDefinition.get(1);
				definition.name = "Telos";
				definition.npcSizeInSquares = 1;
				definition.standAnimation = Telos.standAnimation;
				definition.walkAnimation = Telos.walkAnimation;
				definition.npcModels = new int[]{20544};
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.actions = new String[5];
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.drawYellowDotOnMap = true;
				definition.actions[0] = null;
				break;
			case 1743:
				MobDefinition b17343 = get(9488);
				definition.name = "Hyndra";
				definition.combatLevel = 40;
				definition.scaleXZ = 300;
				definition.scaleY = 300;
				definition.npcSizeInSquares = 5;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b17343.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b17343.npcModels.clone();
				definition.standAnimation = b17343.standAnimation;
				definition.walkAnimation = b17343.walkAnimation;
				definition.degreesToTurn = 32;
				definition.colorChange = new double[]{1.0, 0.5, 0.1};
				break;
			case 1744:
				MobDefinition b6935 = get(6800);
				definition.name = "Grooter";
				definition.combatLevel = 40;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b6935.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b6935.npcModels.clone();
				definition.standAnimation = b6935.standAnimation;
				definition.walkAnimation = b6935.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 3216;
				break;

			case 1745:
				MobDefinition b17346 = get(6816);
				definition.name = "Runite Turtle";
				definition.combatLevel = 40;
				definition.scaleXZ = 130;
				definition.scaleY = 130;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b17346.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b17346.npcModels.clone();
				definition.standAnimation = b17346.standAnimation;
				definition.walkAnimation = b17346.walkAnimation;
				definition.degreesToTurn = 32;
				definition.rdc2 = 9532352;
				break;
			case 1746:
				MobDefinition b17376 = get(8549);
				definition.name = "ohhoo";
				definition.combatLevel = 40;
				definition.scaleXZ = 100;
				definition.scaleY = 100;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.description = b17376.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = b17376.npcModels.clone();
				definition.standAnimation = b17376.standAnimation;
				definition.walkAnimation = b17376.walkAnimation;
				definition.degreesToTurn = 32;
				definition.colorChange = new double[]{0.3, 0.8, 1.0};
				break;
			case 6326:
				definition.name = "Skeleton fremennik";
				definition.description = "stuff".getBytes();
				definition.combatLevel = 40;
				definition.npcModels = new int[]{24180, 24187, 24184, 24054};
				definition.actions = new String[]{null, "Attack", null, null, null};
				definition.degreesToTurn = 32;
				definition.headIcon = -1;
				definition.npcSizeInSquares = 1;
				definition.standAnimation = 6113;
				definition.walkAnimation = 6112;
				definition.walkingBackwardsAnimation = -1;
				definition.walkLeftAnimation = -1;
				definition.walkRightAnimation = -1;
				definition.configChild = -1;
				definition.varBitChild = -1;
				definition.modelLightning = 0;
				definition.modelShadowing = 0;
				definition.drawYellowDotOnMap = true;
				definition.disableRightClick = true;
				definition.visibilityOrRendering = false;
				break;
			case 1084:
				MobDefinition warriorshop = get(652);
				definition.name = "Warrior Shop";
				definition.combatLevel = 0;
				definition.scaleXZ = 190;
				definition.scaleY = 190;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{"Talk-to", null, null, null, null};
				definition.description = warriorshop.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = new int[]{64509};
				definition.standAnimation = warriorshop.standAnimation;
				definition.walkAnimation = warriorshop.walkAnimation;
				definition.degreesToTurn = 32;
				//	definition.rdc2 = 4444444;
				break;
			case 1085:
				MobDefinition archer = get(652);
				definition.name = "Archer shop";
				definition.combatLevel = 0;
				definition.scaleXZ = 190;
				definition.scaleY = 190;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{"Talk-to", null, null, null, null};
				definition.description = archer.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = new int[]{64510};
				definition.standAnimation = archer.standAnimation;
				definition.walkAnimation = archer.walkAnimation;
				definition.degreesToTurn = 32;
				//definition.rdc2 = 777777777;
				break;
			case 1086:
				MobDefinition wizaardo1 = get(652);
				definition.name = "Crazy wizard shop";
				definition.combatLevel = 40;
				definition.scaleXZ = 155;
				definition.scaleY = 155;
				definition.npcSizeInSquares = 1;
				definition.actions = new String[]{"Talk-to", null, null, null, null};
				definition.description = wizaardo1.description;
				definition.drawYellowDotOnMap = true;
				definition.npcModels = new int[]{64511};
				definition.standAnimation = wizaardo1.standAnimation;
				definition.walkAnimation = wizaardo1.walkAnimation;
				definition.degreesToTurn = 32;
				break;

				// Dung boss
			case 8435:
				definition.copy(9000);
				definition.name = "DG Boss protect range";
				definition.headIcon = 1;
				break;
			case 8436:
				definition.copy(9000);
				definition.name = "DG Boss protect mage";
				definition.headIcon = 2;
				break;
			case 8437:
				definition.copy(9000);
				definition.name = "DG Boss protect melee";
				definition.headIcon = 0;
				break;
			case 8438:
				definition.copy(9000);
				definition.name = "DG Boss no icon";
				break;
            default:
                break;
        }
    }


	public void copy(int id) {
		MobDefinition other = get(id);
		changedModelColours = other.changedModelColours.clone();
		combatLevel = other.combatLevel;
		degreesToTurn = other.degreesToTurn;
		description = other.description;
		dialogueModels = other.dialogueModels;
		disableRightClick = other.disableRightClick;
		drawYellowDotOnMap = other.drawYellowDotOnMap;
		headIcon = other.headIcon;
		modelLightning = other.modelLightning;
		modelShadowing = other.modelShadowing;
		npcModels = other.npcModels.clone();
		originalModelColours = other.originalModelColours.clone();
		standAnimation = other.standAnimation;
		visibilityOrRendering = other.visibilityOrRendering;
		walkAnimation = other.walkAnimation;
		walkingBackwardsAnimation = other.walkingBackwardsAnimation;
		walkLeftAnimation = other.walkLeftAnimation;
		walkRightAnimation = other.walkRightAnimation;
	}

	public static void nullify() {
		mruNodes = null;
		streamIndices = null;
		map.clear();
		map = null;
		buffer = null;
	}

	public static void load(Archive archive) {
		buffer = new ByteBuffer(archive.get("npc.dat"));
		ByteBuffer stream2 = new ByteBuffer(archive.get("npc.idx"));
		int totalNPCs = stream2.getUnsignedShort();
		streamIndices = new int[totalNPCs];
		int position = 2;

		for (int i = 0; i < totalNPCs; i++) {
			streamIndices[i] = position;
			position += stream2.getUnsignedShort();
		}
	}

	public double maleModelScale = 1;
	public String[] actions;
	public int scaleXZ;
	public int scaleY;
	public int[] changedModelColours;
	public int[] childrenIDs;
	public int combatLevel;
	private int configChild;
	public int degreesToTurn;
	public byte[] description;
	private int[] dialogueModels;
	public boolean disableRightClick;
	public boolean drawYellowDotOnMap;
	public int headIcon;
	private int modelLightning;
	private int modelShadowing;
	public String name;
	public int[] npcModels;
	public byte npcSizeInSquares;
	public int[] originalModelColours;
	public int standAnimation;
	public int id;
	private int varBitChild;
	public boolean visibilityOrRendering;
	public int walkAnimation;

	public int getStandAnimation() {
		return standAnimation;
	}

	public int getWalkAnimation() {
		return walkAnimation;
	}

	public int walkingBackwardsAnimation;
	public int walkLeftAnimation;
	public int walkRightAnimation;

	private MobDefinition() {
		walkRightAnimation = -1;
		varBitChild = -1;
		walkingBackwardsAnimation = -1;
		configChild = -1;
		combatLevel = -1;
		walkAnimation = -1;
		npcSizeInSquares = 1;
		headIcon = -1;
		standAnimation = -1;
		id = -1;
		degreesToTurn = 32;
		walkLeftAnimation = -1;
		disableRightClick = true;
		scaleY = 128;
		drawYellowDotOnMap = true;
		scaleXZ = 128;
		visibilityOrRendering = false;
		rdc = 0;
		rdc2 = 0;
		rdc3 = 0;

	}
	private void setDefault() {
		walkRightAnimation = -1;
		varBitChild = -1;
		walkingBackwardsAnimation = -1;
		configChild = -1;
		combatLevel = -1;
		walkAnimation = -1;
		npcSizeInSquares = 1;
		headIcon = -1;
		standAnimation = -1;
		degreesToTurn = 32;
		walkLeftAnimation = -1;
		disableRightClick = true;
		scaleY = 128;
		drawYellowDotOnMap = true;
		scaleXZ = 128;
		visibilityOrRendering = false;
		rdc = 0;
		rdc2 = 0;
		rdc3 = 0;

	}

	public Model method160() {
		if (childrenIDs != null) {
			MobDefinition definition = method161();

			if (definition == null) {
				return null;
			} else {
				return definition.method160();
			}
		}

		if (dialogueModels == null) {
			return null;
		}

		boolean flag1 = false;

		for (int i = 0; i < dialogueModels.length; i++) {
			if (!Model.method463(dialogueModels[i])) {
				flag1 = true;
			}
		}

		if (flag1) {
			return null;
		}

		Model aclass30_sub2_sub4_sub6s[] = new Model[dialogueModels.length];

		for (int j = 0; j < dialogueModels.length; j++) {
			aclass30_sub2_sub4_sub6s[j] = Model.get(dialogueModels[j]);
		}

		Model model;

		if (aclass30_sub2_sub4_sub6s.length == 1) {
			model = aclass30_sub2_sub4_sub6s[0];
		} else {
			model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);
		}

		if (originalModelColours != null) {
			for (int k = 0; k < originalModelColours.length; k++) {
				model.method476(originalModelColours[k], changedModelColours[k]);
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

		applyTexturing1(model, id);
		return model;
	}

	private void applyTexturing(Model model, int id) {
		// TODO Auto-generated method stub

	}

	public MobDefinition method161() {
		int j = -1;

		try {
			if (varBitChild != -1 && varBitChild < VarBit.cache.length) {
				VarBit varBit = VarBit.cache[varBitChild];
				int k = varBit.configId;
				int l = varBit.configValue;
				int i1 = varBit.anInt650;
				int j1 = Client.anIntArray1232[i1 - l];
				// System.out.println("k: " + k + " l: " + l);
				j = clientInstance.variousSettings[k] >> l & j1;
			} else if (configChild != -1) {
				j = clientInstance.variousSettings[configChild];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (j < 0 || j >= childrenIDs.length || childrenIDs[j] == -1) {
			return null;
		} else {
			return get(childrenIDs[j]);
		}
	}

	public Model method164(int j, int frame, int ai[], int nextFrame, int cycle1, int cycle2) {
		if (childrenIDs != null) {
			MobDefinition entityDef = method161();

			if (entityDef == null) {
				return null;
			} else {
				return entityDef.method164(j, frame, ai, nextFrame, cycle1, cycle2);
			}
		}

		Model model = (Model) mruNodes.insertFromCache(id);

		if (model == null) {
			boolean flag = false;

			for (int i1 = 0; i1 < npcModels.length; i1++) {
				if (!Model.method463(npcModels[i1])) {
					flag = true;
				}
			}

			if (flag) {
				return null;
			}


			Model aclass30_sub2_sub4_sub6s[] = new Model[npcModels.length];

			for (int j1 = 0; j1 < npcModels.length; j1++) {
				aclass30_sub2_sub4_sub6s[j1] = Model.get(npcModels[j1]);
			}

			if (aclass30_sub2_sub4_sub6s.length == 1) {
				model = aclass30_sub2_sub4_sub6s[0];
			} else {
				model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);
			}

			if (originalModelColours != null) {
				for (int k1 = 0; k1 < originalModelColours.length; k1++) {
					model.method476(originalModelColours[k1], changedModelColours[k1]);
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

			applyTexturing1(model, id);
			model.createBones();
			model.light(84 + modelLightning, 1000 + modelShadowing, -90, -580, -90, true);
			mruNodes.removeFromCache(model, id);
		}

		Model model_1 = Model.aModel_1621;
		model_1.method464(model, FrameReader.isNullFrame(frame) & FrameReader.isNullFrame(j));
/*
		if (frame != -1 && j != -1) {
			model_1.method471(ai, j, frame);
		} else if (frame != -1 && !Configuration.TWEENING_ENABLED) {
			model_1.applyTransform(frame);
		} else if (frame != -1 && nextFrame != -1 && Configuration.TWEENING_ENABLED) {
			model_1.interpolateFrames(frame, nextFrame, cycle1, cycle2);
		}*/

		if (frame != -1 && j != -1) {
			model_1.method471(ai, j, frame);
		} else if (frame != -1 && nextFrame != -1 && Configuration.TWEENING_ENABLED) {
			model_1.interpolateFrames(frame, nextFrame, cycle1, cycle2);
		} else if (frame != -1) {
			model_1.applyTransform(frame);
		}

		if (scaleXZ != 128 || scaleY != 128) {
			model_1.scaleT(scaleXZ, scaleXZ, scaleY);
		}

		model_1.method466();
		model_1.triangleSkin = null;
		model_1.vertexSkin = null;

		if (npcSizeInSquares == 1) {
			model_1.aBoolean1659 = true;
		}

		return model_1;
	}

	private void readValues(ByteBuffer buffer) {
		do {
			final int opcode = buffer.getUnsignedByte();

			if (opcode == 0) {
				return;
			}

			if (opcode == 1) {
				int j = buffer.getUnsignedByte();
				npcModels = new int[j];

				for (int j1 = 0; j1 < j; j1++) {
					npcModels[j1] = buffer.getUnsignedShort();
				}
			} else if (opcode == 2) {
				name = buffer.getString();
			} else if (opcode == 3) {
				description = buffer.getBytes();
			} else if (opcode == 12) {
				npcSizeInSquares = buffer.getSignedByte();
			} else if (opcode == 13) {
				standAnimation = buffer.getUnsignedShort();
			} else if (opcode == 14) {
				walkAnimation = buffer.getUnsignedShort();
			} else if (opcode == 17) {
				walkAnimation = buffer.getUnsignedShort();
				walkingBackwardsAnimation = buffer.getUnsignedShort();
				walkLeftAnimation = buffer.getUnsignedShort();
				walkRightAnimation = buffer.getUnsignedShort();

				if (walkAnimation == 65535) {
					walkAnimation = -1;
				}

				if (walkingBackwardsAnimation == 65535) {
					walkingBackwardsAnimation = -1;
				}

				if (walkLeftAnimation == 65535) {
					walkLeftAnimation = -1;
				}

				if (walkRightAnimation == 65535) {
					walkRightAnimation = -1;
				}
			} else if (opcode >= 30 && opcode < 40) {
				if (actions == null) {
					actions = new String[5];
				}

				actions[opcode - 30] = buffer.getString();

				if (actions[opcode - 30].equalsIgnoreCase("hidden")) {
					actions[opcode - 30] = null;
				}
			} else if (opcode == 40) {
				int length = buffer.getUnsignedByte();
				changedModelColours = new int[length];
				originalModelColours = new int[length];

				for (int i = 0; i < length; i++) {
					originalModelColours[i] = buffer.getUnsignedShort();
					changedModelColours[i] = buffer.getUnsignedShort();
				}
			} else if (opcode == 60) {
				int length = buffer.getUnsignedByte();
				dialogueModels = new int[length];

				for (int i = 0; i < length; i++) {
					dialogueModels[i] = buffer.getUnsignedShort();
				}
			} else if (opcode == 90) {
				buffer.getUnsignedShort();
			} else if (opcode == 91) {
				buffer.getUnsignedShort();
			} else if (opcode == 92) {
				buffer.getUnsignedShort();
			} else if (opcode == 93) {
				drawYellowDotOnMap = false;
			} else if (opcode == 95) {
				combatLevel = buffer.getUnsignedShort();
			} else if (opcode == 97) {
				scaleXZ = buffer.getUnsignedShort();
			} else if (opcode == 98) {
				scaleY = buffer.getUnsignedShort();
			} else if (opcode == 99) {
				visibilityOrRendering = true;
			} else if (opcode == 100) {
				modelLightning = buffer.getSignedByte();
			} else if (opcode == 101) {
				modelShadowing = buffer.getSignedByte() * 5;
			} else if (opcode == 102) {
				headIcon = buffer.getUnsignedShort();
			} else if (opcode == 103) {
				degreesToTurn = buffer.getUnsignedShort();
			} else if (opcode == 106) {
				varBitChild = buffer.getUnsignedShort();

				if (varBitChild == 65535) {
					varBitChild = -1;
				}

				configChild = buffer.getUnsignedShort();

				if (configChild == 65535) {
					configChild = -1;
				}

				int length = buffer.getUnsignedByte();
				childrenIDs = new int[length + 1];

				for (int i = 0; i <= length; i++) {
					childrenIDs[i] = buffer.getUnsignedShort();

					if (childrenIDs[i] == 65535) {
						childrenIDs[i] = -1;
					}
				}
			} else if (opcode == 107) {
				disableRightClick = false;
			}
		} while (true);
	}

	public static void printDefinitionsForId(int mobId) {
		/*Print out Grain*/
		MobDefinition dump = MobDefinition.get(mobId);
		if (dump.name != null) {
			System.out.println("Dumping: " + dump.name);
		} else {
			System.out.println("MobDefinition.get(" + mobId + ").name == null");
		}
		System.out.println("combatlevel: " + dump.combatLevel);
		System.out.println("id: " + dump.id);
		if (dump.npcModels != null) {
			for (int i = 0; i < dump.npcModels.length; i++) {
				System.out.println("npcModels[" + i + "]: " + dump.npcModels[i]);
			}
		}
		if (dump.actions != null) {
			for (int i = 0; i < dump.actions.length; i++) {
				System.out.println("Action[" + i + "]: " + dump.actions[i]);
			}
		}
		System.out.println("degreesToTurn: " + dump.degreesToTurn);
		System.out.println("headIcon: " + dump.headIcon);
		System.out.println("npcSizeInSquares: " + dump.npcSizeInSquares);
		System.out.println("standAnimation: " + dump.standAnimation);
		System.out.println("walkAnimation: " + dump.walkAnimation);
		System.out.println("walkingBackwardsAnimation: " + dump.walkingBackwardsAnimation);
		System.out.println("walkLeftAnimation: " + dump.walkLeftAnimation);
		System.out.println("walkRightAnimation: " + dump.walkRightAnimation);
		if (dump.originalModelColours != null) {
			for (int i = 0; i < dump.originalModelColours.length; i++) {
				System.out.println("originalModelColours[" + i + "]: " + dump.originalModelColours[i]);
			}
		}
		if (dump.changedModelColours != null) {
			for (int i = 0; i < dump.changedModelColours.length; i++) {
				System.out.println("changedModelColours[" + i + "]: " + dump.changedModelColours[i]);
			}
		}
		if (dump.childrenIDs != null) {
			for (int i = 0; i < dump.childrenIDs.length; i++) {
				System.out.println("childrenIDs[" + i + "]: " + dump.changedModelColours[i]);
			}
		}
		System.out.println("configChild: " + dump.configChild);
		System.out.println("varBitChild: " + dump.varBitChild);
		System.out.println("modelLightning: " + dump.modelLightning);
		System.out.println("modelShadowing: " + dump.modelShadowing);
		System.out.println("drawYellowDotOnMap: " + dump.drawYellowDotOnMap);
		System.out.println("disableRightClick: " + dump.disableRightClick);
		System.out.println("visibilityOrRendering: " + dump.visibilityOrRendering);


	}

	public double[] colorChange = null;
}