package com.ruse.net.packet.impl;

import com.ruse.model.Item;
import com.ruse.net.packet.Packet;
import com.ruse.net.packet.PacketListener;
import com.ruse.world.entity.impl.player.Player;

/**
 * This packet listener is called when a player drops an item they have placed
 * in their inventory.
 * 
 * @author relex lawl
 */

public class DropItemPacketListener implements PacketListener {

	@Override
	public void handleMessage(Player player, Packet packet) {


		int id = packet.readUnsignedShortA();
		@SuppressWarnings("unused")
		int interfaceIndex = packet.readUnsignedShort();
		int itemSlot = packet.readUnsignedShortA();
		Item item = player.getInventory().getItems()[itemSlot];

		if (player.getConstitution() <= 0 || player.getInterfaceId() > 0)
			return;
		if (itemSlot < 0 || itemSlot > player.getInventory().capacity())
			return;
		if (player.getConstitution() <= 0 || player.isTeleporting())
			return;
		if (player.isPlayerLocked())
			return;

		if (item == null)
			return;
		if (item.getId() != id) {
			return;
		}
		if (!player.getControllerManager().canDropItem(item)) {
			return;
		}
		player.sendMessage(":checkce:");//cheat engine check when dropping items
		destroyItemInterface(player, item);
	}

	public static void destroyItemInterface(Player player, Item item) {//Destroy item created by Remco
		player.setUntradeableDropItem(item);
		String[][] info = {//The info the dialogue gives
				{ "Are you sure you want to discard this item?", "14174" },
				{ "Yes.", "14175" }, { "No.", "14176" }, { "", "14177" },
				{"This item will vanish once it hits the floor.", "14182" }, {"You cannot get it back if discarded.", "14183" },
				{ item.getDefinition().getName(), "14184" } };
		player.getPacketSender().sendItemOnInterface(14171, item.getId(), 0, item.getAmount());
		for (int i = 0; i < info.length; i++)
			player.getPacketSender().sendString(Integer.parseInt(info[i][1]), info[i][0]);
		player.getPacketSender().sendChatboxInterface(14170);
	}
}