package com.ruse.world.content.dialogue.impl;

import com.ruse.model.input.impl.SpawnGuardianBoss;
import com.ruse.world.content.dialogue.Dialogue;
import com.ruse.world.content.dialogue.DialogueExpression;
import com.ruse.world.content.dialogue.DialogueType;
import com.ruse.world.entity.impl.player.Player;

public class GuardianTokenExchange {


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
				return new String[] { "Sacrifice Premium Tickets to spawn Vozzath" };
			}

			@Override
			public void specialAction() {
				player.getPacketSender().sendInterfaceRemoval();
				player.setInputHandling(new SpawnGuardianBoss());
				player.getPacketSender().sendEnterAmountPrompt("Sacrifice Premium Tickets");
			}
		};
	}

}
