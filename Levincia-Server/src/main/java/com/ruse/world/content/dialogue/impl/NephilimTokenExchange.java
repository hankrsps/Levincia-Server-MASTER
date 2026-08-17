package com.ruse.world.content.dialogue.impl;

import com.ruse.model.input.impl.SpawnGuardianBoss;
import com.ruse.model.input.impl.SpawnNephilimBoss;
import com.ruse.world.content.dialogue.Dialogue;
import com.ruse.world.content.dialogue.DialogueExpression;
import com.ruse.world.content.dialogue.DialogueType;
import com.ruse.world.entity.impl.player.Player;

public class NephilimTokenExchange {

	public static Dialogue getDialogue(Player player) {

		return new Dialogue() {

			@Override
			public DialogueType type() {
				return DialogueType.STATEMENT;
			}

			@Override
			public DialogueExpression animation() {
				return DialogueExpression.NORMAL;
			}

			@Override
			public int npcId() {
				return 437;
			}

			@Override
			public String[] dialogue() {
				return new String[] { "Sacrifice Nephilim tokens to spawn the Nephilim Warrior" };
			}

			@Override
			public void specialAction() {
				player.getPacketSender().sendInterfaceRemoval();
				player.setInputHandling(new SpawnNephilimBoss());
				player.getPacketSender().sendEnterAmountPrompt("Sacrifice Nephilim Tokens");
			}
		};
	}

}
