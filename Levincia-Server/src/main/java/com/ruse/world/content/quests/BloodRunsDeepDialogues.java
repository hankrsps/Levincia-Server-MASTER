package com.ruse.world.content.quests;

import com.ruse.model.PlayerRights;
import com.ruse.world.content.dialogue.Dialogue;
import com.ruse.world.content.dialogue.DialogueExpression;
import com.ruse.world.content.dialogue.DialogueType;
import com.ruse.world.entity.impl.player.Player;

/*
 * Project Levincia
 * Author @Levincia (AlwaysDreaming.ai@gmail.com)
 * Created on - 6/23/2022
 */
public class BloodRunsDeepDialogues {

    /**
     * Dialogues that can't be handled by XML
     */

    public static Dialogue questBloodRunsDeepIntro(final Player player) {
        return new Dialogue() {


            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
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
                String line1 = "I need your help adventurer.";
                return new String[]{"" + line1 + ""};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
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
                        return 6040;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "This sick man has showed up at my house";
                        String line2 = "He washed ashore, and has been asleep since.";
                        return new String[]{"" + line1 + "", "" + line2 + "", ""};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8621);
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
                                return 6040;
                            }

                            @Override
                            public DialogueExpression animation() {
                                return DialogueExpression.NORMAL;
                            }

                            @Override
                            public String[] dialogue() {
                                String line1 = "We have to help this sick old man!";
                                String line2 = "Travel into his dreams and obtain a Lecturn";
                                String line3 = "You then need to successfully fight off the Army.";
                                return new String[]{"" + line1 + "", "" + line2 + "", "" + line3};
                            }

                            @Override
                            public void specialAction() {
                                player.setDialogueActionId(8621);
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
                                        return 6040;
                                    }

                                    @Override
                                    public DialogueExpression animation() {
                                        return DialogueExpression.NORMAL;
                                    }

                                    @Override
                                    public String[] dialogue() {
                                        String line1 = "Afterwards, you will have to enter the Spiritual Realm";
                                        String line2 = "and retrieve the Prophecy Tablet.";
                                        String line3 = "Use it on the Lecturn to Craft a Dagonnoth Cave Teleport";
                                        String line4 = "There you will need to Defeat the Dagonnoth Boss.";
                                        return new String[]{"" + line1 + "", "" + line2
                                                + "", "" + line3 + "", "" + line4};
                                    }

                                    @Override
                                    public void specialAction() {
                                        player.setDialogueActionId(8621);
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
                                                return 6040;
                                            }

                                            @Override
                                            public DialogueExpression animation() {
                                                return DialogueExpression.NORMAL;
                                            }

                                            @Override
                                            public String[] dialogue() {
                                                String line1 = "After you defeat the Dagganoth Boss,";
                                                String line2 = "obtain the Enchanted herbs and return them to me.";
                                                String line3 = "I will then reward you for helping me save the man.";
                                                return new String[]{"" + line1 + "", "" + line2
                                                        + "", "" + line3};
                                            }

                                            @Override
                                            public void specialAction() {
                                                player.setDialogueActionId(8621);
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
                                                        String line1 = "Help Ksenia retrieve the Enchanted Herbs.";
                                                        String line2 = "No thanks, i didn't sign up for this.";
                                                        return new String[]{"" + line1 + "", "" + line2};
                                                    }

                                                    @Override
                                                    public void specialAction() {
                                                        player.setDialogueActionId(8621);
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


    public static Dialogue questBloodRunsDeepAccept(final Player player) {
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
                String line1 = "Im not afraid of anything, You can count on me.";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
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
                        return 6040;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Good luck on your quest, adventurer!";
                        String line2 = "Speak to me when you're ready to teleport.";
                        return new String[]{"" + line1 + "", "" + line2};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8621);
                    }
                };
            }

        };

    }


    public static Dialogue questBloodRunsDeepKingRoald(final Player player) {
        return new Dialogue() {
            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 648;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Hello Adventurer, i advise you to leave this moment.";
                String line2 = "This place should not be open to people as you,";
                String line3 = "don't you see the dead soldiers around you?";
                String line4 = "This place is full of ghosts! What are you doing?";
                return new String[]{"" + line1+ "", "" + line2+ "", "" + line3+ "", "" + line4};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
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
                        return 648;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Ksenia has sent me to retrieve the prophecy tablet.";
                        String line2 = "I hear you guys have a ghost problem!";
                        return new String[]{"" + line1+ "", "" + line2};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8631);
                    }
                };
            }
        };
    }


    public static Dialogue questBloodRunsDeepKingRoald2(final Player player) {
        return new Dialogue() {
            @Override
            public DialogueType type() {
                return DialogueType.PLAYER_STATEMENT;
            }

            @Override
            public int npcId() {
                return 648;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Ksenia has sent me to retrieve the prophecy tablet.";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
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
                        return 648;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "A Prophecy tablet? Why on Earth would you need that?";
                        String line2 = "This tablet, combined with a Lectern can open";
                        String line3 = "a gateway into the heart of the Dagganoth Cave";
                        String line4 = "What is the reasoning behind Ksenia's needs?";
                        return new String[]{"" + line1+ "", "" + line2 + "", "" + line3 + "", "" + line4};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8631);
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
                                return 648;
                            }

                            @Override
                            public DialogueExpression animation() {
                                return DialogueExpression.NORMAL;
                            }

                            @Override
                            public String[] dialogue() {
                                String line1 = "We need to kill the Dagganoth Boss, and retrieve";
                                String line2 = "the enchanted herbs. An old man washed ashore,";
                                String line3 = "and she has been taking care of him. He is really";
                                String line4 = "sick and needs these herbs will help revive him.";
                                return new String[]{"" + line1+ "", "" + line2 + "", "" + line3 + "", "" + line4};
                            }

                            @Override
                            public void specialAction() {
                                player.setDialogueActionId(8631);
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
                                        return 648;
                                    }

                                    @Override
                                    public DialogueExpression animation() {
                                        return DialogueExpression.NORMAL;
                                    }

                                    @Override
                                    public String[] dialogue() {
                                        String line1 = "Such bad news, sincerely I will help.";
                                        String line2 = "First I will need you to catch 5 eels from";
                                        String line3 = "the pond North of here, but be careful traveler.";
                                        String line4 = "This pond lurks some terrible, hungry shadows.";
                                        return new String[]{"" + line1+ "", "" + line2 + "", "" + line3 + "", "" + line4};
                                    }

                                    @Override
                                    public void specialAction() {
                                        player.setDialogueActionId(8631);
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
                                                return 648;
                                            }

                                            @Override
                                            public DialogueExpression animation() {
                                                return DialogueExpression.NORMAL;
                                            }

                                            @Override
                                            public String[] dialogue() {
                                                String line1 = "I will trade you the prophecy tablet for";
                                                String line2 = "the eels. Be careful! The shadows will steal and eat them.";
                                                String line3 = "I Have an extra fishing pole and bait right here.";
                                                return new String[]{"" + line1+ "", "" + line2 + "", "" + line3};
                                            }

                                            @Override
                                            public void specialAction() {
                                                player.setDialogueActionId(8631);
                                            }


                                            @Override
                                            public Dialogue nextDialogue() {
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
                                                        player.getInventory().add(307, 1);
                                                        return new String[]{"" + "King Roald gives you a Fishing rod."};
                                                    }

                                                    @Override
                                                    public String[] item() {
                                                        return new String[]{"" + 307 + "", "180", "" + "Fishing rod" + ""};
                                                    }

                                                    @Override
                                                    public Dialogue nextDialogue() {
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
                                                                player.getInventory().add(10515, 25);
                                                                return new String[]{"" + "King Roald gives you some worms."};
                                                            }

                                                            @Override
                                                            public String[] item() {
                                                                return new String[]{"" + 10515 + "", "180", "" + "Worms" + ""};
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

    public static Dialogue questBloodRunsDeepKingRoald3(final Player player) {
        return new Dialogue() {
            @Override
            public DialogueType type() {
                return DialogueType.PLAYER_STATEMENT;
            }

            @Override
            public int npcId() {
                return 648;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "I hear you guys have a ghost problem!";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
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
                        return 648;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Unfortunately this place is littered with ghosts.";
                        String line2 = "They all have seem to have a reason to why they";
                        String line3 = "haunt the caves, I pray one day they will get to see";
                        String line4 = "the light again. I'm working on freeing them.";
                        return new String[]{"" + line1+ "", "" + line2 + "", "" + line3 + "", "" + line4};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8631);
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
                                return 648;
                            }

                            @Override
                            public DialogueExpression animation() {
                                return DialogueExpression.NORMAL;
                            }

                            @Override
                            public String[] dialogue() {
                                String line1 = "Good luck on that!";
                                return new String[]{"" + line1};
                            }

                            @Override
                            public void specialAction() {
                                player.setDialogueActionId(8631);
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
                                        return 648;
                                    }

                                    @Override
                                    public DialogueExpression animation() {
                                        return DialogueExpression.NORMAL;
                                    }

                                    @Override
                                    public String[] dialogue() {
                                        String line1 = "Thank you adventurer, I better get back to work now.";
                                        return new String[]{"" + line1};
                                    }

                                    @Override
                                    public void specialAction() {
                                        player.setDialogueActionId(8631);
                                    }
                                };
                            }
                        };
                    }
                };
            }
        };
    }
    public static Dialogue questBloodRunsDeepVisitDagonnoth(final Player player) {
        return new Dialogue() {
            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
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
                String line1 = "Excellent work " + player.getUsername() + ", use the teleport when you're ready!";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
            }
        };
    }

    public static Dialogue questBloodRunsDeepAfterCompletion(final Player player) {
        return new Dialogue() {
            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
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
                String line1 = "Excellent work " + player.getUsername() + ", thanks to you the old man is healed.";
                String line2 = "You can enter the Dagannoth cave whenever you please, just be careful.";
                return new String[]{"" + line1+ "", "" + line2 };
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
            }
        };
    }

    public static Dialogue questBloodRunsDeepFinalReturn(final Player player) {
        return new Dialogue() {
            @Override
            public DialogueType type() {
                return DialogueType.PLAYER_STATEMENT;
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
                String line1 = "I have the Enchanted herbs from the Cave";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
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
                        return 6040;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Excellent work adventurer, now i can heal the sick man.";
                        return new String[]{"" + line1};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8631);
                    }

                    @Override
                    public Dialogue nextDialogue() {
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
                                if (player.getInventory().getFreeSlots() < 3) {
                                    return new String[]{"You need at least 3 inventory spaces to claim your reward."};
                                }
                                player.getInventory().delete(17510, 1);
                                    player.getInventory().add(21218, 10);
                                    player.getInventory().add(19116, 5);
                                    player.getPointsHandler().setQuestPoints(2, true);
                                    player.getPacketSender().sendMessage("<img=832> Your rewards were placed in your inventory .");
                                    player.getPacketSender().sendMessage("<img=832> @blu@Quest Completed: @red@Blood Runs Deep");
                                    player.getPacketSender().sendMessage("<img=832> You have been rewarded 3 Quest points");

                                if (player.getQuestOneStep7() == false) {
                                    if (player.getAmountDonated() < 10 && player.getRights() != PlayerRights.OWNER) {
                                        player.incrementAmountDonated(10);
                                        player.setRights(PlayerRights.SAPPHIRE_DONATOR);
                                        player.getPacketSender().sendMessage("<img=832> You have obtained free Sapphire Donator rank status for completing the quest.");
                                    }
                                }
                                player.setQuestOneStep7(true);

                                return new String[]{"" + "You give the Enchanted Herb to Ksenia."};
                            }

                            @Override
                            public String[] item() {
                                return new String[]{"" + 17510 + "", "180", "" + "Enchanted Herb" + ""};
                            }
                        };
                    }
                };
            }
        };
    }

    public static Dialogue questBloodRunsDeepReturnItemsNotFound(final Player player) {
        return new Dialogue() {
            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 648;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Excellent work " + player.getUsername() + " return the items to me.";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
            }
        };
    }


    public static Dialogue questBloodRunsDeepReturnItems(final Player player) {
        return new Dialogue() {
            @Override
            public DialogueType type() {
                return DialogueType.PLAYER_STATEMENT;
            }

            @Override
            public int npcId() {
                return 648;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "I have the items you asked me to obtain.";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
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
                        return 6040;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Excellent work traveler, give them here.";
                        return new String[]{"" + line1};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8631);
                    }

                    @Override
                    public Dialogue nextDialogue() {
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
                                player.getInventory().delete(8534, 1);
                                return new String[]{"" + "You give the lectern to Ksenia."};
                            }

                            @Override
                            public String[] item() {
                                return new String[]{"" + 8534 + "", "180", "" + "Lectern" + ""};
                            }

                            @Override
                            public Dialogue nextDialogue() {
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
                                        player.getInventory().delete(15406, 1);
                                        player.getInventory().add(18813, 1);
                                        player.setQuestOneStep6(true);
                                        player.getPacketSender().sendMessage("<img=832>You completed a quest objective: @blu@Help Craft the Daganoth lair teleport.");
                                        return new String[]{"" + "You give Ksenia the Prophecy tablet for the Daganoth teleport."};
                                    }
                                    @Override
                                    public String[] item() {
                                        return new String[]{"" + 15406 + "", "180", "" + "Prophecy tablet" + ""};
                                    }
                                };
                            }

                        };
                    }
                };
            }
        };
    }

    public static Dialogue questBloodRunsDeepKingRoaldComplete(final Player player) {
        return new Dialogue() {
            @Override
            public DialogueType type() {
                return DialogueType.PLAYER_STATEMENT;
            }

            @Override
            public int npcId() {
                return 648;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "I have the 5 eels for you King Roald.";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
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
                        return 648;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Excellent work traveler, give them here.";
                        return new String[]{"" + line1};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8631);
                    }

                    @Override
                    public Dialogue nextDialogue() {
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
                                player.getInventory().delete(17801, 5);
                                return new String[]{"" + "You give the eels to King Roald"};
                            }

                            @Override
                            public String[] item() {
                                return new String[]{"" + 10515 + "", "180", "" + "Eels" + ""};
                            }

                            @Override
                            public Dialogue nextDialogue() {
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
                                        player.getInventory().add(15406, 1);
                                        player.setQuestOneStep5(true);
                                        player.getPacketSender().sendMessage("<img=832>You completed a quest objective: @blu@Obtain the Prophecy tablet");
                                        return new String[]{"" + "Gives you the Prophecy tablet"};
                                    }

                                    @Override
                                    public String[] item() {
                                        return new String[]{"" + 10515 + "", "180", "" + "Prophecy tablet" + ""};
                                    }
                                };
                            }

                        };
                    }
                };
            }
        };
    }

    public static Dialogue questBloodRunsDeepKingRoaldExit(final Player player) {
        return new Dialogue() {
            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 648;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Return the tablet to Ksenia to build the portal.";
                return new String[]{"" + line1};
            }
            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
            }
        };
    }

    public static Dialogue questBloodRunsDeepDream(final Player player) {
        return new Dialogue() {
                    @Override
                    public DialogueType type() {
                        return DialogueType.NPC_STATEMENT;
                    }

                    @Override
                    public int npcId() {
                        return 305;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Hello Adventurer, i was starting to wonder if we would ";
                        String line2 = "make it out alive, now hurry! we don't have all day ";
                        String line3 = "You need to craft a lectern using ingredients obtained here.";
                        String line4 = "This will require 25 Iron nails and 10 Drowsy Branches.";
                        return new String[]{"" + line1+ "", "" + line2+ "", "" + line3+ "", "" + line4};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8621);
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
                        return 305;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "You will also need to kill 50 Spirit Dagonnoths.";
                        String line2 = "Good luck adventurer, and may the Levincia Gods be with you.";
                        return new String[]{"" + line1+ "", "" + line2};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8621);
                    }
                };
            }
        };
    }


    public static Dialogue questBloodRunsDeepEnterRealm(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }
            @Override
            public int npcId() {
                return 6040;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Excellent work adventurer, I have another request to ask.";
                String line2 = "King Roald holds an ancient tablet that can be used on";
                String line3 = "the lectern, granting us a teleport to the Dagonnoth Cave.";
                String line4 = "Speak with King Roald in the Spiritual Realm, tell him I sent you.";
                return new String[]{"" + line1 + "","" + line2+ "","" + line3+ "","" + line4};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
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
                        return 6040;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Rumor has it a ghost haunts the hometown graveyard";
                        String line2 = "whom will take you into the Spiritual Realm.";
                        String line3 = "Father Reen has a Ghostspeak amulet for you";
                        String line4 = "Speak with him at home to obtain it.";
                        return new String[]{"" + line1 + "","" + line2+ "","" + line3+ "","" + line4};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8621);
                    }
                };
            }
        };
    }

    public static Dialogue questBloodRunsDeepFatherReen(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }
            @Override
            public int npcId() {
                return 2899;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Hello adventurer, what brings you around Levincia?";
                return new String[]{"" + line1 };
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
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
                        return 2899;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "I have a ghost haunting me.";
                        String line2 = "I'm looking for a Ghost-speak Amulet";
                        String line3 = "Nothing, I'm leaving.";
                        return new String[]{"" + line1 + "","" + line2+ "","" + line3};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8625);
                    }
                };
            }
        };
    }


    public static Dialogue questBloodRunsDeepFatherReen2(final Player player) {
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
            public int npcId() {
                return 2899;
            }

            @Override
            public String[] dialogue() {
                String line1 = "I have a ghost haunting me at night, what do i do?";
                return new String[]{"" + line1 };
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
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
                        return 2899;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "No need to fear my child, this is quite common.";
                        String line2 = "You can use a Holy symbol on this amulet here,";
                        String line3 = "to achieve the ability to talk to ghosts.";
                        String line4 = "Pick up the Holy symbol behind the pew over there.";
                        return new String[]{"" + line1 + "","" + line2+ "","" + line3+ "","" + line4};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8625);
                    }

                    @Override
                    public Dialogue nextDialogue() {
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
                                player.getInventory().add(23369, 1);
                                return new String[]{"" + "Father Reen gives you an Holy amulet."};
                            }

                            @Override
                            public String[] item() {
                                return new String[] { "" + 552 + "", "180", "" + "Holy amulet" + "" };
                            }
                        };
                    }
                };
            }
        };
    }

    public static Dialogue questBloodRunsDeepLumbridgeGhost(final Player player) {
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
            public int npcId() {
                return 1541;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Hello, I hear you can help me get to the Spirit Realm.";
                return new String[]{"" + line1 };
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
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
                        return 1541;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "The Spirit Realm? Who told you this?";
                        String line2 = "WAIT!!? How can you understand me?";
                        return new String[]{"" + line1 + "","" + line2};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8625);
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
                                return 1541;
                            }

                            @Override
                            public DialogueExpression animation() {
                                return DialogueExpression.NORMAL;
                            }

                            @Override
                            public String[] dialogue() {
                                String line1 = "Ksenia has sent me, she needs my help.";
                                String line2 = "I have crafted a ghost-speak amulet to talk to you.";
                                String line3 = "She said I need to talk to King Roald in the Realm";
                                String line4 = "to obtain the Prophecy tablet.";
                                return new String[]{"" + line1 + "","" + line2+ "","" + line3+ "","" + line4};
                            }

                            @Override
                            public void specialAction() {
                                player.setDialogueActionId(8625);
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
                                        return 1541;
                                    }

                                    @Override
                                    public DialogueExpression animation() {
                                        return DialogueExpression.NORMAL;
                                    }

                                    @Override
                                    public String[] dialogue() {
                                        player.setTalkedToGhost(true);
                                        String line1 = "Very well traveler, I will open a rift for you.";
                                        String line2 = "Make sure you have the proper equipment before entering.";
                                        String line3 = "The Spirit Realm has been known for it's tales.";
                                        String line4 = "The Rift is located in the Shed, When you are ready.";
                                        return new String[]{"" + line1 + "","" + line2+ "","" + line3+ "","" + line4};
                                    }

                                    @Override
                                    public void specialAction() {
                                        player.setDialogueActionId(8625);
                                    }
                                };
                            }

                        };
                    }

                };
            }
        };
    }

    public static Dialogue questBloodRunsDeepLumbridgeGhostGibberish(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 1541;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Wooo wooo wooooo";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8625);
            }
        };
    }

    public static Dialogue questBloodRunsDeepFatherReen3(final Player player) {
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
            public int npcId() {
                return 2899;
            }

            @Override
            public String[] dialogue() {
                String line1 = "I'm in search of an ghost-speak amulet.";
                return new String[]{"" + line1 };
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
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
                        return 2899;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "A ghost-speak Amulet? You should know";
                        String line2 = "Speaking to ghosts can lead to some terrible";
                        String line3 = "outcomes, these cheeky ghosts haunt the nearby";
                        String line4 = "Graveyard. Some nights you can hear them boo-ing.";
                        return new String[]{"" + line1 + "","" + line2+ "","" + line3+ "","" + line4};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8625);
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
                                return 2899;
                            }

                            @Override
                            public DialogueExpression animation() {
                                return DialogueExpression.NORMAL;
                            }

                            @Override
                            public String[] dialogue() {
                                String line1 = "I have a Holy Amulet that can be used with";
                                String line2 = "an Holy Symbol. Together they make a ghost-speak";
                                String line3 = "Amulet. You can gather the holy symbol from behind";
                                String line4 = "the church pew over there. Good luck, adventurer.";
                                return new String[]{"" + line1 + "","" + line2+ "","" + line3+ "","" + line4};
                            }

                            @Override
                            public void specialAction() {
                                player.setDialogueActionId(8625);
                            }

                            @Override
                            public Dialogue nextDialogue() {
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
                                        player.getInventory().add(23369, 1);
                                        return new String[]{"" + "Father Reen gives you an Holy amulet."};
                                    }

                                    @Override
                                    public String[] item() {
                                        return new String[] { "" + 552 + "", "180", "" + "Holy amulet" + "" };
                                    }
                                };
                            }

                        };
                    }

                };
            }
        };
    }


    public static Dialogue questBloodRunsDeepDreamComplete(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }
            @Override
            public int npcId() {
                return 305;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Great work " + player.getUsername() + ", return to Ksenia.";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
            }


        };
    }


    public static Dialogue questBloodRunsDeepDecline(final Player player) {
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
                String line1 = "Sorry Ksenia, this doesn't sound to safe for me.";
                return new String[]{"" + line1};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8621);
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
                        return 6040;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Come back when you are ready, adventurer.";
                        return new String[]{"" + line1};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8621);
                    }
                };
            }
        };
    }


    public static Dialogue questBloodRunsDeepInProgress(final Player player) {
        return new Dialogue() {

                    @Override
                    public DialogueType type() {
                        return DialogueType.OPTION;
                    }

                    @Override
                    public int npcId() {
                        return -1;
                    }

                    @Override
                    public DialogueExpression animation() {
                        return DialogueExpression.NORMAL;
                    }

                    @Override
                    public String[] dialogue() {
                        String line1 = "Teleport";
                        String line2 = "Cancel";
                        return new String[]{"" + line1 + "", "" + line2};
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8622);
                    }
                };
        };
    }