package com.ruse.model.input;

import com.ruse.world.content.dialogue.Dialogue;
import com.ruse.world.content.dialogue.DialogueExpression;
import com.ruse.world.content.dialogue.DialogueManager;
import com.ruse.world.content.dialogue.DialogueType;
import com.ruse.world.entity.impl.player.Player;

public class EnterAmountToBurn extends EnterAmount {

    @Override
    public void handleAmount(Player player, int amount) {
        if (amount <= 0) {
            player.sendMessage("You must enter a valid amount.");
            return;
        }

        if (!player.getInventory().contains(14639, amount)) {
            player.sendMessage("You don't have that many souls.");
            return;
        }

        // Save gamble amount to player and set action ID
        player.setSoulGambleAmount(amount);
        player.setDialogueActionId(5556); // You handle this case in DialogueActions

        // Display confirmation dialogue
        DialogueManager.start(player, new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.OPTION;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NO_EXPRESSION;
            }

            @Override
            public String[] dialogue() {
                return new String[] {
                        "Yes, burn " + amount + " souls."
                };

            }
        });
    }
}
