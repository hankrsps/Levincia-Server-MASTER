package com.ruse.world.content.celestial;

import com.ruse.world.content.dialogue.Dialogue;
import com.ruse.world.content.dialogue.DialogueExpression;
import com.ruse.world.content.dialogue.DialogueType;
import com.ruse.world.entity.impl.player.Player;
    /*
     * Project Levincia
     * Author @Levincia (AlwaysDreaming.ai@gmail.com)
     * Created on - 6/23/2022
     */
public class CelestialDialogues {

    /**
     * Dialogues that can't be handled by XML
     */
    public static Dialogue main(final Player player) {
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
                return DialogueExpression.NO_EXPRESSION;
            }

            @Override
            public String[] dialogue() {
                return new String[] { "How to become a member of the Fantasy Realm?", "What is the Fantasy Realm?",
                        "What is Dark Matter?", "Cancel" };
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8221);
            }

        };
    }

    public static Dialogue becomingCelestial(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 1821;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "To become a member of the Fantasy Realm you must:";
                String line2 = "- Complete x50 Souls of Suffering Raids";
                String line3 = "- Sacrifice x2 Owner items (Cape, Aura, Bracelet, Ring, or Amulet)";
                return new String[] { "" + line1 + "", "" + line2 + "", "" + line3 };
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8221);
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
                        return null;
                    }

                    @Override
                    public String[] dialogue() {
                        return new String[] { "How to become a member of the Fantasy Realm?", "What is the Fantasy Realm?",
                                "What is Dark Matter?", "Cancel" };
                    }
                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8221);
                    }
                };
            }
        };
    }

    public static Dialogue celestialZone(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 1821;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "The Fantasy Realm opens for 1 hour every 3 hours.";
                String line2 = "Complete tasks in the Fantasy Realm to get Dark Matter";
                return new String[] { "" + line1 + "", "" + line2 + ""};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8221);
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
                        return null;
                    }

                    @Override
                    public String[] dialogue() {
                        return new String[] { "How to become a member of the Fantasy Realm?", "What is the Fantasy Realm?",
                                "What is Dark Matter?", "Cancel" };
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8221);
                    }
                };
            }
        };
    }

    public static Dialogue celestialEnergy(final Player player) {
        return new Dialogue() {

            @Override
            public DialogueType type() {
                return DialogueType.NPC_STATEMENT;
            }

            @Override
            public int npcId() {
                return 1821;
            }

            @Override
            public DialogueExpression animation() {
                return DialogueExpression.NORMAL;
            }

            @Override
            public String[] dialogue() {
                String line1 = "Dark Matter can only be obtained from the Fantasy Realm.";
                String line2 = "Dark Matter is used to craft Fantasy items.";
                return new String[] { "" + line1 + "", "" + line2 + ""};
            }

            @Override
            public void specialAction() {
                player.setDialogueActionId(8221);
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
                        return null;
                    }

                    @Override
                    public String[] dialogue() {
                        return new String[] { "How to become a member of the Fantasy Realm?", "What is the Fantasy Realm?",
                                "What is Dark Matter?", "Cancel" };
                    }

                    @Override
                    public void specialAction() {
                        player.setDialogueActionId(8221);
                    }
                };
            }
        };
    }
}

