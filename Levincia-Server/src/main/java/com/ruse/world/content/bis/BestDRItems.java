package com.ruse.world.content.bis;

import com.ruse.model.definitions.ItemDefinition;
import com.ruse.world.entity.impl.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BestDRItems {
	public BestDRItems(Player player) {
		this.player = player;
	}
	public List<ItemDefinition> definitions = new ArrayList<>();
	@SuppressWarnings("unchecked")
	public List<Integer> itemsToIgnore = new ArrayList() {
		{
			add(5420);
			add(5422);
			add(15870);
			add(5428);
			add(525);
			add(524);
			add(523);
			add(21036);
			add(21038);
			add(7885);
			add(26);
			add(13023);
			add(13025);
			add(13027);
			add(22089);
			add(8001);
			add(14056);
			add(9929);
			add(8336);
			add(8337);
			add(8338);
			add(6818);
			add(22090);
			add(20555);
			add(11305);
			add(11306);
			add(11307);
			add(11308);
			add(11303);

//			add (13289); //Elidinis' ward
//			add (13293); //Elidinis' ward (f)
//			add (13295); //Elidinis' ward (or)
//			add (13297); //Lightbearer
//			add (13662); //Osmumten's fang
//			add (13664); //Osmumten's fang (or)
//			add (18485); //Tumeken's shadow (charged)
//			add (18487); //Tumeken's shadow (uncharged)
//			add (13273); //Masori Mask
//			add (13274); //Masori Body
//			add (13275); //Masori Chaps
//			add (13841); //Masori Mask (f)
//			add (13842); //Masori Body (f)
//			add (13843); //Masori Chaps (f)


			add(5424);
			add(9253);
			add(22071);
			add(22076);
			add(21604);

			add(21603);
			add(5423);
			add(5432);
			add(7014);
			add(19800);
			add(19802);
			add(20060);
			add(20062);
			add(20063);
			add(20073);
			add(7642);
			add(17678);
			add(7643);
			add(20533);
			add(20551);
			add(20552);
			add(20558);
			add(11179);
			add(11181);
			add(11182);
			add(11183);
			add(11184);
			add(11759);
			add(11762);
			add(5594);

			add(12285);
			
			add(21780);
			add(21605);
			add(21602);
			add(21601);
			add(21600);
			add(22093);
			add(21606);
			add(15219);
			add(1485);
			add(22073);
			add(14055);
			add(14054);
			add(14053);
			add(14052);
			add(14051);
			add(14050);
			add(23418);
			add(23419);
			add(23420);
			add(23421);
			add(23422);
			add(23423);
			add(23424);

		}
	};
	private int definitionIndex;
	public void fillDefinitions() {
		Collections.addAll(definitions, ItemDefinition.getDefinitions());
		definitions.removeIf(def -> def == null || itemsToIgnore.contains(def.getId()));

		for (int i = 0; i < 5; i++) {
			player.getPacketSender().sendString(109310 + i, (definitionIndex == i ? "@whi@Check " : "Check ") + text[i]);
		}
		for (int i = 5; i < 10; i++) {
			player.getPacketSender().sendString(109311 + i, (definitionIndex == i ? "@whi@Check " : "Check ") + text[i]);
		}
		player.getPacketSender().sendString(109322, (definitionIndex == 14 ? "@whi@Check " : "Check ") + text[10]);
		player.getPacketSender().sendString(109323, (definitionIndex == 15 ? "@whi@Check " : "Check ") + text[11]);
		player.getPacketSender().sendString(109324, (definitionIndex == 17 ? "@whi@Check " : "Check ") + text[12]);
	}
	public void open() {
		definitionIndex = 0;
		definitions.sort(new sortDR(definitionIndex).reversed());
		displayBonuses();
		player.getPA().sendInterface(109300);
	}


	private static String[] text = new String[] { "Stab", "Slash", "Crush", "Magic", "Range", "Stab", "Slash", "Crush",
			"Magic", "Range", "Strength", "Ranged Str", "Magic Damage" };

	private void sortDefinitions(int index) {
		definitionIndex = index;
		definitions.sort(new sortDR(definitionIndex).reversed());

		for (int i = 0; i < 5; i++) {
			player.getPacketSender().sendString(109310 + i, (definitionIndex == i ? "@whi@Check " : "Check ") + text[i]);
		}
		for (int i = 5; i < 10; i++) {
			player.getPacketSender().sendString(109311 + i, (definitionIndex -1== i  ? "@whi@Check " : "Check ") + text[i]);
		}
		player.getPacketSender().sendString(109322, (definitionIndex == 11 ? "@whi@Check " : "Check ") + text[12]);
		player.getPacketSender().sendString(109323, (definitionIndex == 12 ? "@whi@Check " : "Check ") + text[11]);
		player.getPacketSender().sendString(109324, (definitionIndex == 13 ? "@whi@Check " : "Check ") + text[10]);

	}
	
	private void displayBonuses() {
		int bonusRank = 109402;
		int name = 109403;
		int itemModel = 109404;
		for(int i = 0; i < 100; i++) {
			player.getPA().sendString(bonusRank, "" + definitions.get(i).getBonus()[definitionIndex]);
			player.getPA().sendString(name, definitions.get(i).getName());
			player.getPA().sendItemOnInterface(itemModel, definitions.get(i).getId(), 1);
			bonusRank += 4;
			name += 4;
			itemModel += 4;
		}
	}
	public boolean handleButton(int id) {
		if(id >= 109310 && id <= 109424) {
			int index = id - 109410;
			sortDefinitions(index);
			displayBonuses();
		}
		return false;
	}
	
	private final Player player;
}
 class sortDR implements Comparator<ItemDefinition> {
	 private final int bonusIndex;
	 public sortDR(int bonusIndex) {
		 this.bonusIndex = bonusIndex;
	 }
	@Override
	public int compare(ItemDefinition def, ItemDefinition other) {
		
		return (int) (def.getBonus()[bonusIndex] - other.getBonus()[bonusIndex]);
	}
	
}
