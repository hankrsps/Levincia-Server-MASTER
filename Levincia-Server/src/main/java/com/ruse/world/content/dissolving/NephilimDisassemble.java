package com.ruse.world.content.dissolving;

import com.ruse.model.Item;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.world.content.dialogue.DialogueManager;
import com.ruse.world.content.minigames.impl.DisassembleValue;
import com.ruse.world.entity.impl.player.Player;

public class NephilimDisassemble {

	private Player player;

	public NephilimDisassemble(Player player) {
		this.player = player;
	}

	static int anim = 11904;
	static int token = 23257;

	public enum DisassembleData {
		BOW(23061, new Item[]{new Item(token, 50)}, 35500, anim),
		STAFF(23062, new Item[]{new Item(token, 50)}, 35500, anim),
		SWORD(23063, new Item[]{new Item(token, 50)}, 35500, anim),
		HELMET(23220, new Item[]{new Item(token, 50)}, 35500, anim),
		BODY(23221, new Item[]{new Item(token, 50)}, 35500, anim),
		LEGS(23222, new Item[]{new Item(token, 50)}, 35500, anim),
		GLOVES(23223, new Item[]{new Item(token, 50)}, 35500, anim),
		BOOTS(23224, new Item[]{new Item(token, 50)}, 35500, anim);

		DisassembleData(int id, Item[] rewards, int experience, int animation) {
			this.id = id;
			this.rewards = rewards;
			this.experience = experience;
			this.animation = animation;
		}

		private int id, experience, animation;
		private Item[] rewards;

		public int getId() {
			return id;
		}

		public int getExperience() {
			return experience;
		}

		public int getAnimation() {
			return animation;
		}

		public Item[] getRewards() {
			return rewards;
		}

		public ItemDefinition getDefinition() {
			return ItemDefinition.forId(id);
		}
	}

	public void handleDialogue(int id) {
		DialogueManager.start(player, new DisassembleValue(player,
				"Disassemble for 50 Nephilim Tokens", "Nevermind", 6118));
		;
	}

}

