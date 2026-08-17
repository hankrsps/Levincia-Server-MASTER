package com.ruse.world.content.quests;

import com.ruse.world.content.dialogue.Dialogue;
import com.ruse.world.content.dialogue.DialogueExpression;
import com.ruse.world.content.dialogue.DialogueType;
import com.ruse.world.entity.impl.player.Player;

/*
 * Project Levincia
 * Author @Levincia (AlwaysDreaming.ai@gmail.com)
 * Created on - 6/23/2022
 */
public class TheOmegaDialogues {

    /**
     * Dialogues that can't be handled by XML
     */

    public static Dialogue Intro(final Player player) {
        return new Dialogue() {


            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 942;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Oh dear, oh dear, oh dear, I'm in a terrible, terrible mess!";
                String line2 = "The King needs an Omega Cake for the Dinner of Levincia";
                return new String[]{"" + line1  + "", "" + line2};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(4621);
            }

            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.NPC_STATEMENT;
                    }

                    @Override
                    public int npcId() {
                        return 942;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "I'll never get the ingredients in time now. He'll sack me!";
                        String line2 = "What will I do? I have four children and a goat to look after.";
                        String line3 = "Would you help me? Please?";
                        return new String[]{"" + line1 + "", "" + line2 + "", "" + line3};
                    }
                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(4621);
                    }


                    @Override
                    public Dialogue nextDialogue() {
                        return new Dialogue() {

                            @Override
                            public DialogueType type() {
                                return DialogueType.OPTION;
                            }

                            @Override
                            public int npcId() {
                                return 6040;
                            }

                            @Override
                            public DialogueExpression animation() {
                                return DialogueExpression.NORMAL;
                            }

                            @Override
                            public String[] dialogue() {
                                String line1 = "I'm always happy to help a cook in distress.";
                                String line2 = "I can't right now, Maybe later.";
                                return new String[]{"" + line1 + "", "" + line2};
                            }

                            @Override
                            public void specialAction() {
                                player.setDialogueActionId(4621);
                            }
                        };
                    }
                };
            }
        };
    }


    public static Dialogue PubIntro(final Player player) {
        return new Dialogue() {


            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 1921;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Welcome to the Blue Moon Inn traveler, you look parched.";
                String line2 = "Can I offer you a Greenman's Ale for 5 Levincia tokens?";
                return new String[]{"" + line1  + "", "" + line2};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(4622);
            }

            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.OPTION;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Yeah a drink never hurt.";
                        String line2 = "No thanks, i'm looking for poison.";
                        return new String[]{"" + line1 + "", "" + line2};
                    }
                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(4622);
                    }
                };
            }
        };
    }

    public static Dialogue PubDecline(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.PLAYER_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "I'm looking for some poison, Do you have any?";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(4622);
            }


            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.NPC_STATEMENT;
                    }

                    @Override
                    public int npcId() {
                        return 1921;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "The only poison here is Varrock's finest Greenman's Ale";
                        return new String[]{"" + line1};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(4622);
                    }
                };
            }
        };
    }

    public static Dialogue PubAccept(final Player player) {
        return new Dialogue() {


            @Override
            public DialogueType type() {
                return DialogueType.ITEM_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                    player.getPacketSender().sendMessage("You purchase a Greenman's Ale for 5 Levincia tokens.");
                player.getInventory().delete(12855, 5);
                player.getInventory().add(7746, 1);
                return new String[]{"" + "You purchase a Greenman's Ale for 5 Levincia tokens."};
            }

            @Override
            public String[] item() {
                return new String[]{"" + 7746 + "", "180", "" + "Greenman's Ale" + ""};
            }
        };
    }


    public static Dialogue PubOffer(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.PLAYER_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = " Here have a Greenman's Ale, you seem parched.";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(4622);
            }

            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {
                    public DialogueType type() {
                        return DialogueType.ITEM_STATEMENT;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        player.getPacketSender().sendMessage("You give the bartender a Greenman's Ale.");
                        player.getInventory().delete(7746, 1);
                        return new String[]{"" + "You give the bartender a Greenman's Ale."};
                    }


                    @Override
                    public String[] item() {
                        return new String[]{"" + 7746 + "", "180", "" + "Greenman's Ale" + ""};
                    }

                    @Override
                    public Dialogue nextDialogue() {
                        return new Dialogue() {

                            @Override
                            public DialogueType type() {
                                return DialogueType.NPC_STATEMENT;
                            }

                            @Override
                            public int npcId() {
                                return 1921;
                            }

                            @Override
                            public DialogueExpression animation() {
                                return DialogueExpression.CONFUSED;
                            }

                            @Override
                            public String[] dialogue() {
                                String line1 = "Thank you I was parched, that hit the spot.";
                                String line2 = "Now what were you doing here again?";
                                String line3 = "Looking for poison? Why on Earth do you need poison?";
                                return new String[]{"" + line1 + "", "" + line2 + "", "" + line3};
                            }

                            @Override
                            public void specialAction() {
                                player.setDialogueActionId(4622);
                            }
                            @Override
                            public Dialogue nextDialogue() {
                                return new Dialogue() {

                                    @Override
                                    public DialogueType type() {
                                        return DialogueType.PLAYER_STATEMENT;
                                    }

                                    @Override
                                    public int npcId() {
                                        return 1921;
                                    }

                                    @Override
                                    public DialogueExpression animation() {
                                        return DialogueExpression.CONFUSED;
                                    }

                                    @Override
                                    public String[] dialogue() {
                                        String line1 = "I'm helping the cook bake a Omega Cake.";
                                        String line2 = "It requires some poison, i'm not so sure why.";
                                        return new String[]{"" + line1 + "", "" + line2};
                                    }

                                    @Override
                                    public void specialAction() {
                                        player.setDialogueActionId(4622);
                                    }
                                    @Override
                                    public Dialogue nextDialogue() {
                                        return new Dialogue() {

                                            @Override
                                            public DialogueType type() {
                                                return DialogueType.NPC_STATEMENT;
                                            }

                                            @Override
                                            public int npcId() {
                                                return 1921;
                                            }

                                            @Override
                                            public DialogueExpression animation() {
                                                return DialogueExpression.CONFUSED;
                                            }

                                            @Override
                                            public String[] dialogue() {
                                                String line1 = "Very well then.";
                                                String line2 = "I managed to find this in the back, hopefully it helps.";
                                                return new String[]{"" + line1 + "", "" + line2};
                                            }

                                            @Override
                                            public void specialAction() {
                                                player.setDialogueActionId(4622);
                                            }

                                            @Override
                                            public Dialogue nextDialogue() {
                                                return new Dialogue() {
                                                    public DialogueType type() {
                                                        return DialogueType.ITEM_STATEMENT;
                                                    }

                                                    @Override
                                                    public DialogueExpression animation() {
                                                        return DialogueExpression.NORMAL;
                                                    }

                                                    @Override
                                                    public String[] dialogue() {
                                                        player.getPacketSender().sendMessage("The Bartender gives you some poison");
                                                        player.getInventory().add(17572, 1);
                                                        return new String[]{"" + "The Bartender gives you some poison"};
                                                    }


                                                    @Override
                                                    public String[] item() {
                                                        return new String[]{"" + 17572 + "", "180", "" + "Weak Poison" + ""};
                                                    }
                                                };
                                            }
                                        };
                                    }

                                };
                            }

                        };
                    }

                };
            }
        };
    }

    public static Dialogue Accept(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.PLAYER_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = " Yes, I'll help you.";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(4621);
            }
            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.NPC_STATEMENT;
                    }

                    @Override
                    public int npcId() {
                        return 942;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Oh thank you, thank you.";
                        String line2 = "  I need poisoned milk, an Omega egg and some rancid flour.";
                        String line3 = " I'd be very grateful if you can get them for me";
                        return new String[]{"" + line1 + "", "" + line2 + "", "" + line3};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(4621);
                    }


                    @Override
                    public Dialogue nextDialogue() {
                        return new Dialogue() {

                            @Override
                            public DialogueType type() {
                                return DialogueType.NPC_STATEMENT;
                            }

                            @Override
                            public int npcId() {
                                return 942;
                            }

                            @Override
                            public DialogueExpression animation() {
                                return DialogueExpression.NORMAL;
                            }

                            @Override
                            public String[] dialogue() {
                                String line1 = "To poison milk you first need to gather some poison and milk.";
                                String line2 = "Speak to the Bartender in the Blue Moon Inn at home";
                                String line3 = "Also I normally get my milk on the other side of the river.";
                                return new String[]{"" + line1 + "", "" + line2 + "", "" + line3};
                            }

                            @Override
                            public void specialAction() {
                                player.setDialogueActionId(4621);
                            }

                            @Override
                            public Dialogue nextDialogue() {
                                return new Dialogue() {

                                    @Override
                                    public DialogueType type() {
                                        return DialogueType.NPC_STATEMENT;
                                    }

                                    @Override
                                    public int npcId() {
                                        return 942;
                                    }

                                    @Override
                                    public DialogueExpression animation() {
                                        return DialogueExpression.NORMAL;
                                    }

                                    @Override
                                    public String[] dialogue() {
                                        String line1 = "The Omega Egg is protected by the Dragon King.";
                                        String line2 = "You will need to defeat the Dragon King to get the egg.";
                                        String line3 = "Make sure you have Chilling gloves to collect pick it up!";
                                        return new String[]{"" + line1 + "", "" + line2 + "", "" + line3};
                                    }

                                    @Override
                                    public void specialAction() {
                                        player.setDialogueActionId(4621);
                                    }

                                    @Override
                                    public Dialogue nextDialogue() {
                                        return new Dialogue() {

                                            @Override
                                            public DialogueType type() {
                                                return DialogueType.NPC_STATEMENT;
                                            }

                                            @Override
                                            public int npcId() {
                                                return 942;
                                            }

                                            @Override
                                            public DialogueExpression animation() {
                                                return DialogueExpression.NORMAL;
                                            }

                                            @Override
                                            public String[] dialogue() {
                                                String line1 = "There is a Mill fairly close, go North and then West.";
                                                String line2 = "Mill Lane Mill is just off the road to Draynor";
                                                return new String[]{"" + line1 + "", "" + line2};
                                            }

                                            @Override
                                            public void specialAction() {
                                                player.setDialogueActionId(4621);
                                            }
                                        };
                                    }
                                };
                            }
                        };
                    }
                };
            }

        };

    }
    public static Dialogue QuestReminder(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 942;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Please get the ingredients quickly. I'm running out of time!";
                String line2 = " The Duke will throw me into the streets!";
                return new String[]{"" + line1 + "", "" + line2 };
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(4621);
            }

            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.OPTION;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }


                    @Override
                    public String[] dialogue() {
                        String line1 = " Where do I find some poisoned milk? ";
                        String line2 = " Where do I find a Omega egg?";
                        String line3 = " Where do I find some rancid flour?";
                        String line4 = " Cancel";
                        return new String[]{"" + line1 + "", "" + line2 + "", "" + line3+ "", "" + line4};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(4621);
                    }
                };
            }
        };

    }

    public static Dialogue PoisonedMilk(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 942;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "To poison milk you first need to gather some poison and milk.";
                String line2 = "South of the Varrock center is a pub to get the poison.";
                String line3 = "I normally get my milk on the other side of the river.";
                return new String[]{"" + line1 + "", "" + line2 + "", "" + line3};
            }


            @Override
            public void specialAction() {
                player.setDialogueActionId(4621);
            }

            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.OPTION;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }


                    @Override
                    public String[] dialogue() {
                        String line1 = " Where do I find some poisoned milk? ";
                        String line2 = " Where do I find a Omega egg?";
                        String line3 = " Where do I find some rancid flour?";
                        String line4 = " Cancel";
                        return new String[]{"" + line1 + "", "" + line2 + "", "" + line3+ "", "" + line4};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(4621);
                    }
                };
            }
        };
    }

    public static Dialogue OmegaEgg(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 942;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "The Omega Egg is protected by the Dragon King.";
                String line2 = "You will need to defeat the Dragon King to get the egg.";
                String line3 = "Make sure you have Chilling gloves to collect pick it up!";
                return new String[]{"" + line1 + "", "" + line2 + "", "" + line3};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(4621);
            }

            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.OPTION;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }
                    @Override
                    public String[] dialogue() {
                        String line1 = " Where do I find some poisoned milk? ";
                        String line2 = " Where do I find a Omega egg?";
                        String line3 = " Where do I find some rancid flour?";
                        String line4 = " Cancel";
                        return new String[]{"" + line1 + "", "" + line2 + "", "" + line3+ "", "" + line4};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(4621);
                    }
                };
            }
        };
    }

    public static Dialogue RancidFlour(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 942;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "There is a Mill fairly close, go North and then West.";
                String line2 = "Mill Lane Mill is just off the road to Draynor";
                return new String[]{"" + line1 + "", "" + line2};
            }


            @Override
            public void specialAction() {
                player.setDialogueActionId(4621);
            }

            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.OPTION;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }


                    @Override
                    public String[] dialogue() {
                        String line1 = " Where do I find some poisoned milk? ";
                        String line2 = " Where do I find a Omega egg?";
                        String line3 = " Where do I find some rancid flour?";
                        String line4 = " Cancel";
                        return new String[]{"" + line1 + "", "" + line2 + "", "" + line3+ "", "" + line4};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(4621);
                    }
                };
            }
        };
    }

    public static Dialogue Decline(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.PLAYER_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "No, I don't feel like it. Maybe later.";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(4621);
            }


            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.NPC_STATEMENT;
                    }

                    @Override
                    public int npcId() {
                        return 942;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Go on your merry way!";
                        return new String[]{"" + line1};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(4621);
                    }
                };
            }
        };
    }
    public static Dialogue DukeHoracio(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.PLAYER_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Duke Horacio! The cook baked a poisonous cake!";
                String line2 = "He is trying to make me deliver it to you shortly.";
                String line3 = "He's in the basement of the castle as we speak!";
                return new String[]{"" + line1 + "", "" + line2  + "", "" + line3};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(4623);
            }


            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.NPC_STATEMENT;
                    }

                    @Override
                    public int npcId() {
                        return 741;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "This is complete nonsense! Who does he think he is?";
                        String line2 = "This kind of behaviour will not be tolerated.";
                        String line3 = player.getUsername() + " You must make the cook suffer for his foolish actions.";
                        player.setQuestTwoStep5(true);
                        player.getPacketSender().sendMessage("<img=832>You completed a quest objective: @blu@Warn Duke Horacio");
                        return new String[]{"" + line1 + "", "" + line2 + "", "" + line3};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(4623);
                    }
                };
            }
        };
    }
    public static Dialogue GoodDay(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 741;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "What a beautiful day, I am thankful to be breathing still.";
                return new String[]{"" + line1};
            }
            @Override
            public void specialAction() {
                player.setDialogueActionId(4623);
            }
        };
    }

    public static Dialogue QuestComplete(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.PLAYER_STATEMENT;
            }

            @Override
            public int npcId() {
                return 741;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "I have defeated the Cook!";
                return new String[]{"" + line1};
            }
            @Override
            public void specialAction() {
                player.setDialogueActionId(4623);
            }
            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.NPC_STATEMENT;
                    }

                    @Override
                    public int npcId() {
                        return 741;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "";
                        if (player != null) {
                            try {
                                    if (player.getInventory().getFreeSlots() >= 3) {
                                        player.getInventory().add(21218, 10);
                                        player.getInventory().add(19115, 10);
                                        player.getInventory().add(23390, 1);
                                        player.getPacketSender().sendMessage("<img=832> Your rewards were placed in your inventory.");
                                        player.getPointsHandler().setQuestPoints(3, true);
                                        player.setQuestTwoStep7(true);
                                        player.getPacketSender().sendMessage("<img=832> @blu@Quest Completed: @red@The Omega");
                                        player.getPacketSender().sendMessage("<img=832> You have been rewarded 3 Quest points");
                                        line1 = "Excellent work " + player.getUsername() + ", take this as a reward.";
                                    } else {
                                        line1 = "You need at least 3 inventory spaces to claim your reward.";
                                    }
                            } catch (NoSuchMethodError e) {
                                // Handle the error gracefully by logging it, or by providing a default response
                                line1 = "An error occurred while trying to complete the quest.";
                            }
                        } else {
                            line1 = "You must be logged in to complete this quest.";
                        }

                        return new String[]{"" + line1};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(4622);
                    }
                };
            }

                };
    }
    public static Dialogue DukeHoracioFinal(final Player player) {
        return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.NPC_STATEMENT;
                    }

                    @Override
                    public int npcId() {
                        return 741;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "There is no time to waste " + player.getUsername() + "!";
                        return new String[]{"" + line1};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(4623);
                    }
        };
    }
    public static Dialogue OfferItems(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.PLAYER_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "I have the ingredients you asked for";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(4622);
            }

            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {
                    public DialogueType type() {
                        return DialogueType.ITEM_STATEMENT;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        player.getPacketSender().sendMessage("You give the Cook the poisoned milk");
                        return new String[]{"" + "You give the Cook the poisoned milk"};
                    }


                    @Override
                    public String[] item() {
                        return new String[]{"" + 15413 + "", "180", "" + "Poisoned milk" + ""};
                    }
                    @Override
                    public Dialogue nextDialogue() {
                        return new Dialogue() {
                            public DialogueType type() {
                                return DialogueType.ITEM_STATEMENT;
                            }

                            @Override
                            public DialogueExpression animation() {
                                return DialogueExpression.NORMAL;
                            }

                            @Override
                            public String[] dialogue() {
                                player.getPacketSender().sendMessage("You give the Cook the Omega egg");
                                return new String[]{"" + "You give the Cook the Omega egg"};
                            }


                            @Override
                            public String[] item() {
                                return new String[]{"" + 10537 + "", "180", "" + "Omega egg" + ""};
                            }
                            @Override
                            public Dialogue nextDialogue() {
                                return new Dialogue() {
                                    public DialogueType type() {
                                        return DialogueType.ITEM_STATEMENT;
                                    }

                                    @Override
                                    public DialogueExpression animation() {
                                        return DialogueExpression.NORMAL;
                                    }

                                    @Override
                                    public String[] dialogue() {
                                        player.getPacketSender().sendMessage("You give the Cook the rancid flour");
                                        player.getInventory().delete(7546, 1);
                                        player.getInventory().delete(10537, 1);
                                        player.getInventory().delete(15413, 1);
                                        player.setQuestTwoStep4(true);
                                        player.getPacketSender().sendMessage("<img=832>You completed a quest objective: @blu@Return the ingredients to the cook");
                                        return new String[]{"" + "You give the Cook the rancid flour"};
                                    }


                                    @Override
                                    public String[] item() {
                                        return new String[]{"" + 7546 + "", "180", "" + "Rancid flour" + ""};
                                    }

            @Override
            public Dialogue nextDialogue() {
                return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.NPC_STATEMENT;
                    }

                    @Override
                    public int npcId() {
                        return 942;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "You've brought me everything I need! I am saved! Thank you!";
                        String line2 = "Meet me in the basement shortly and i will have you deliver it.";
                        String line3 = "This poison will be more than enough to kill the King!";
                        return new String[]{"" + line1 + "", "" + line2 + "", "" + line3};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(4622);
                    }


                    @Override
                    public Dialogue nextDialogue() {
                        return new Dialogue() {

                            @Override
                            public DialogueType type() {
                                return DialogueType.PLAYER_STATEMENT;
                            }

                            @Override
                            public int npcId() {
                                return 942;
                            }

                            @Override
                            public DialogueExpression animation() {
                                return DialogueExpression.NORMAL;
                            }

                            @Override
                            public String[] dialogue() {
                                String line1 = "You're going to kill the king?!";
                                return new String[]{"" + line1};
                            }

                            @Override
                            public void specialAction() {
                                player.setDialogueActionId(4622);
                            }


                            @Override
                            public Dialogue nextDialogue() {
                                return new Dialogue() {

                                    @Override
                                    public DialogueType type() {
                                        return DialogueType.NPC_STATEMENT;
                                    }

                                    @Override
                                    public int npcId() {
                                        return 942;
                                    }

                                    @Override
                                    public DialogueExpression animation() {
                                        return DialogueExpression.NORMAL;
                                    }

                                    @Override
                                    public String[] dialogue() {
                                        String line1 = "Not exactly, you're going to kill the King.";
                                        String line2 = "Just do what i tell you to do " + player.getUsername() + "!";
                                        return new String[]{"" + line1 + "", "" + line2};
                                    }

                                    @Override
                                    public void specialAction() {
                                        player.setDialogueActionId(4622);
                                    }
                                };
                            }
                        };
                    }
                };
            }
                };

            }
                        };
                    }
                };

            }
        };
    }

    }