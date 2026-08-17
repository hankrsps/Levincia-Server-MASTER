package org.necrotic.client.graphics;


import org.necrotic.client.Client;
import org.necrotic.client.cache.definition.ItemDefinition;
import org.necrotic.client.graphics.gameframe.GameFrame;

import java.util.Arrays;
import java.util.HashMap;


public class HoverMenuManager {

    public static final int TEXT_COLOUR = 0xFFFFFFF;

    public static HashMap<Integer, HoverMenu> menus = new HashMap<>();

    public static void init() {
        menus.put(16459, new HoverMenu("Has a chance to give some of the most valuable items in the game!",
                Arrays.asList(
                        4151, 4153, 4155, 4157, 4159, 4161, 4163, 4165
                )));

        menus.put(6199, new HoverMenu("Has a chance at low tier weapons and equipment",
                Arrays.asList(
                        14924,14919,14915,18332,14377,4888,3318,11728,3320
                )));
        menus.put(7956, new HoverMenu("Has a chance at low tier weapons and vote scrolls.",
                Arrays.asList(
                        19582,14525,11858,4151,11235,15486,12933,18353,15031,6585,6737,7462
                )));

        menus.put(19115, new HoverMenu("Has a chance to give $1 scrolls, and up to T3 equipment.",
                Arrays.asList(
                        10946,666,15424,674,8800,8801,8802,20549,8803,8804,8805,20173,8806,8807,8808
                )));

        menus.put(19114, new HoverMenu("Has a chance to give $1 scrolls, $5 & $10 bonds, and T5 equipment.",
                Arrays.asList(
                        8326,8327,8328,22084,8330,8331,8332,22083,8323,8324,8325,22092,10946,6769,10942
                )));
        menus.put(19116, new HoverMenu("Has a chance to give some good starter weapons and gear",
                Arrays.asList(
                        14008, 14009, 14010, 12860, 2021, 16140, 12565,22077,19136,6936,12634
                )));

        menus.put(20488, new HoverMenu("Has a chance to give some good starter weapons and gear",
                Arrays.asList(
                        6769,10942,18753,18749,18631,18752,18748,18637,18751,18638,18623,18750,18636,18629,19886,4446
                )));


        menus.put(20489, new HoverMenu("Has a chance to give some good weapons and rewards",
                Arrays.asList(
                        4446,19886,8253,8087,8088,8089,10947,12608,6769,10942,10934,3578
                )));

        menus.put(15003, new HoverMenu("Has a chance to give Rage Cape & Donators Aura & Deity gear",
                Arrays.asList(
                        12630,20591,3578,19810,18883,18881,18818,15288,20489,3578,10935,10934
                )));

        menus.put(15002, new HoverMenu("Has a chance to give deity gear & some OP rewards",
                Arrays.asList(
                        3578,19810,18883,18881,18818,15288,20489,3578,10935,10934,20488,20489
                )));
        menus.put(15004, new HoverMenu("Has a chance to give legends weapons & OWNER CAPE",
                Arrays.asList(
                        7995,12535,5012,17011,12630,20400,3578,19810,18883,18881,18818,15288
                )));
        menus.put(14999, new HoverMenu("Has a chance to give BOOSTERS, ATTACHMENTS, & OWNER CAPE",
                Arrays.asList(
                        22110,4442,23254,9083,7995,5012,17011,12535,12630,19810,18883,18881
                )));

        menus.put(23253, new HoverMenu("Has a chance to give BOOSTERS, ATTACHMENTS, & OWNER CAPE",
                Arrays.asList(
                        22110,4442,23254,9083,7995,5011,17013,12630,23240,3578,19810,18883
                )));

        menus.put(23002, new HoverMenu("Has a chance to give bonds,caskets, and scratch cards",
                Arrays.asList(
                        22121, 15004, 15002, 15003, 10942, 10943, 10942, 15002, 15003, 10942
                )));

        menus.put(3578, new HoverMenu("Has a chance to give an OWNER CAPE or $25 bond",
                Arrays.asList(
                        7995,10934
                )));
        menus.put(18404, new HoverMenu("Has a chance to give Legends armor & weapons",
                Arrays.asList(
                        4686,4685,4684,17011,12535,5012,15004,6769,5022,15288,15002,10946,20489,1486
                )));

        menus.put(23276, new HoverMenu("Has a chance to give you a wide-variety of lower-tier items.",
                Arrays.asList(
                        9083,20591,10943,23240,3578,22006,12630,5012,12535,17011,4684,4685,4686
                )));


        menus.put(23277, new HoverMenu("Has a chance to give you a wide-variety of medium-tier items.",
                Arrays.asList(
                        9083,20591,10943,23240,3578,23253,22006,12630,22113,22114,22115,4684,4685,4686
                )));

        menus.put(23278, new HoverMenu("Has a chance to give you a wide-variety of Premium items.",
                Arrays.asList(
                        23254,4442,7995,22110,23225,23240,3578,23174,23239,23253,22121,10935,10943
                )));

        menus.put(23279, new HoverMenu("Has a chance to give you a wide-variety of Premium items.",
                Arrays.asList(
                        23254,4442,7995,22110,23225,23240,3578,23174,23239,23253,22121,10935,10943
                )));


        menus.put(18768, new HoverMenu("Has a chance to give you DragonballZ items & $5 Bonds",
                Arrays.asList(
                        6769,9481,9482,9483,9478,9479,9480,10946,15289
                )));


        menus.put(7120, new HoverMenu("Has a chance to give you a wide-variety of different rewards",
                Arrays.asList(
                        20542,13300,13301,13304,18683,15511,13306,18817,13302,13305,15230,15231,15232
                )));

        menus.put(10025, new HoverMenu("Has a chance to give you a wide-variety of different rewards",
                Arrays.asList(
                        20542,13300,13301,13304,18683,15511,13306,18817,13302,13305,15230,15231,15232
                )));

        menus.put(22214, new HoverMenu("Has a high chance at lower tier weapons and equipment",
                Arrays.asList(
                        13996,13913,13919,18834,18801,18800,19140,19139,19138,18686,18799,5095
                )));
        menus.put(22123, new HoverMenu("Has a chance to give you AOE weapons, and other rewards",
                Arrays.asList(
                        3739,3738,3737,10946,1486,19886,4446,15288,10947,18623,18637,18631,18629,18638
                )));
        menus.put(23412, new HoverMenu("Card packs, caskets, and a chance to obtain an Ethereal Urn",
                Arrays.asList(
                        20421,23278,23253,14999,23002,15004,15002,15003,20489,20488,19114,19115,19116
                )));
        menus.put(23411, new HoverMenu("Card packs, caskets, and a chance to obtain Seraphic dust",
                Arrays.asList(
                        14705,23278,23253,14999,23002,15004,15002,15003,20489,20488,19114,19115,19116
                )));

        menus.put(23236, new HoverMenu("Has a chance to give Owner cape, and other rewards",
                Arrays.asList(
                        7995,12535,5012,17011,12630,20400,3578,19810,18883,18881,18818,15288,10935
                )));
       // System.out.println("loaded " + menus.size() + "x menu hovers.");
    }

    public static int drawType() {
        if (Client.getClient().mouseX > 0 && Client.getClient().mouseX < 500 &&Client.getClient().mouseY > 0
                && Client.getClient().mouseY < 300) {
            return 1;
        }
        return 0;
    }

    public static boolean shouldDraw(int id) {
        return menus.get(id) != null;
    }

    public static boolean showMenu;

    public static String hintName;

    public static int hintId;

    public static int displayIndex;

    public static long displayDelay;

    public static int[] itemDisplay = new int[4];

    private static int lastDraw;

    public static void reset() {
        showMenu = false;
        hintId = -1;
        hintName = "";
    }

    public static boolean canDraw() {

        if (Client.getClient().menuActionName[Client.getClient().menuActionRow] != null) {
            if (Client.getClient().menuActionName[Client.getClient().menuActionRow].contains("Walk")) {
                return false;
            }
        }

        if (Client.getClient().menuOpen) {
            return false;
        }
        if (hintId == -1) {
            return false;
        }
        return showMenu;
    }

    public static void drawHintMenu() {
        int mouseX = Client.getClient().mouseX;
        int mouseY = Client.getClient().mouseY;
        // System.out.println("here after examine");
        if (!canDraw()) {
            return;
        }

        Client client = Client.getClient();

        switch (GameFrame.getScreenMode()) {
            case FIXED: {
                if (client.mouseY < 210 || client.mouseX < 561) {
                    //  return;
                } else {
                    mouseX -= 516;
                    mouseY -= 158;
                }
                if (client.mouseX > 600 && client.mouseX < 685) {
                    mouseX -= 60;

                }
                if (client.mouseX > 685) {
                    mouseX -= 80;
                }
                break;
            }
            default: {
                if (client.mouseY < client.getScreenHeight() - 450
                        && client.mouseX < client.getScreenWidth() - 200) {
                    return;
                }
                mouseX -= 100;
                mouseY -= 50;
                break;
            }
        }

        if (lastDraw != hintId) {
            lastDraw = hintId;
            itemDisplay = new int[4];
        }

        HoverMenu menu = menus.get(hintId);
        if (menu != null) {
            String[] text = split(menu.text).split("<br>");

            int height = (text.length * 12) + (menu.items != null ? 40 : 0);

            int width = (16 + text[0].length() * 5) + (menu.items != null ? 30 : 0);

            switch (GameFrame.getScreenMode()) {
                case FIXED: {
                    if (drawType() == 1) {
                        if (width + mouseX > 500) {
                            mouseX = 500 - width;
                        }
                    } else {
                        mouseX = 293;
                        mouseY = 235;
                    }
                    break;
                }
            }

            DrawingArea.drawRect(mouseX, mouseY + 5, width + 4, 26 + height, 0x383023);
            DrawingArea.fillRect(mouseX + 1, mouseY + 6, width + 2, 24 + height, 0x352e26, 180);
            DrawingArea.fillRect(mouseX + 1, mouseY + 58, width + 2, height - 34, 0x2b261f, 200);

            Client.getClient().newSmallFont.drawBasicString("<col=ff9040>" + hintName, mouseX + 4, mouseY + 19,
                    TEXT_COLOUR, 1);
            int y = 0;

            for (String string : text) {
                Client.getClient().newSmallFont.drawBasicString(string, mouseX + 4, mouseY + 35 + y, TEXT_COLOUR, 1);
                y += 12;
            }

            if (menu.items != null) {
                int spriteX = 10;

                if (displayDelay + 250 < System.currentTimeMillis()) {
                    displayDelay = System.currentTimeMillis();
                    displayIndex++;
                    if (displayIndex == menu.items.size()) {
                        displayIndex = 0;
                    }

                    if (menu.items.size() <= 4) {
                        for (int i = 0; i < menu.items.size(); i++) {
                            itemDisplay[i] = menu.items.get(i);
                        }
                    } else {
                        if (displayIndex >= menu.items.size() - 1) {
                            displayIndex = menu.items.size() - 1;
                        }
                        int next = menu.items.get(displayIndex);
                        if (itemDisplay.length - 1 >= 0)
                            System.arraycopy(itemDisplay, 1, itemDisplay, 0, itemDisplay.length - 1);
                        itemDisplay[3] = next;
                    }
                }

                for (int id : itemDisplay) {
                    if (id < 1) {
                        continue;
                    }
                    Sprite item = ItemDefinition.getSprite(id, 1, 0);
                    if (item != null) {
                        item.drawSprite(mouseX + spriteX, mouseY + 35 + y);
                        spriteX += 40;
                    }
                }
            }
        }
    }

    private static String split(String text) {
        StringBuilder string = new StringBuilder();

        int size = 0;

        for (String s : text.split(" ")) {
            string.append(s).append(" ");
            size += s.length();
            if (size > 20) {
                string.append("<br>");
                size = 0;
            }
        }
        return string.toString();
    }

}
