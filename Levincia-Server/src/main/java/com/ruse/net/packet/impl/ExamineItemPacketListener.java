package com.ruse.net.packet.impl;

import com.ruse.model.PlayerRights;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.net.packet.Packet;
import com.ruse.net.packet.PacketListener;
import com.ruse.world.entity.impl.player.Player;
import mysql.impl.CheckPriceExamine;

public class ExamineItemPacketListener implements PacketListener {
/*
	@Override
	public void handleMessage(Player player, Packet packet) {
		int item = packet.readShort();
		if(item == ItemDefinition.COIN_ID || item == 18201) {
			player.getPacketSender().sendMessage("Mhmm... Shining coins...");
			return;
		}
		ItemDefinition itemDef = ItemDefinition.forId(item);
		if(itemDef != null) {
			if (itemDef.getDescription().contains("--")){
				String[] split = itemDef.getDescription().split("--");

				player.getPacketSender().sendMessage(split[0]);
				player.getPacketSender().sendMessage(split[1]);
			}else {
				player.getPacketSender().sendMessage(itemDef.getDescription());
			}
			for (Skill skill : Skill.values()) {
				if (itemDef.getRequirement()[skill.ordinal()] > player.getSkillManager().getMaxLevel(skill)) {
					player.getPacketSender().sendMessage("@red@WARNING: You need " + new StringBuilder().append(skill.getName().startsWith("a") || skill.getName().startsWith("e") || skill.getName().startsWith("i") || skill.getName().startsWith("o") || skill.getName().startsWith("u") ? "an " : "a ").toString() + Misc.formatText(skill.getName()) + " level of at least " + itemDef.getRequirement()[skill.ordinal()] + " to wear this.");
				}
			}
		}
	}*/

	@Override
	public void handleMessage(Player player, Packet packet) {
	int item = packet.readShort();
		if (player.getRights().equals(PlayerRights.OWNER)) {
			player.getPacketSender().sendMessage("@red@Item ID: <shad=10>@bla@" + ItemDefinition.forId(item));
		}
		if (item == ItemDefinition.COIN_ID || item == 18201) {
			player.getPacketSender().sendMessage("Mhmm... Shining coins...");
		return;
		}
		new Thread(new CheckPriceExamine(player, item)).run();
	}

	public void handleExaminationInterface(Player player, int itemId) {
		int count = 52103;
		ItemDefinition itemDef = ItemDefinition.forId(itemId);
		player.sendMessage("@bla@<img=30>[PRICE CHECK] <col=5e0606>" + itemDef.getName()
				+ ": <col=06195e>Value of this item is : <col=065e16> " + formatCoins(itemDef.getValue()) + ".");
	}

	public static String formatCoins(int amount) {
		if (amount > 9999 && amount <= 9999999) {
			return (amount / 1000) + "K";
		} else if (amount > 9999999 && amount <= 999999999) {
			return (amount / 1000000) + "M";
		} else if (amount > 999999999) {
			return (amount / 1000000000) + "B";
		}
		return String.valueOf(amount);
	}
}
