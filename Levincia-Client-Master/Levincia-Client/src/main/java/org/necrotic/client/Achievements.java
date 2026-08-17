package org.necrotic.client;

import org.necrotic.client.graphics.fonts.TextDrawingArea;

import static org.necrotic.client.RSInterface.*;

/*
 * Project Levincia
 * Author @Avalon (AlwaysDreaming.ai@gmail.com)
 * Created on - 6/14/2022
 */

public class Achievements {
    private static final int ORANGE = 0xFF8624;
    private static final int GREY = 0x858585;
    private static final int LIGHT_GREY = 0xC2C2C2;
    private static final int PROGRESS_BAR_COLOR = 0xFFAE00;

    public static void unpack(TextDrawingArea[] tda) {
        int id = 11290;
        int frame = 0;
        RSInterface rs = addInterface(id++);
        rs.totalChildren(25);

        addSpriteLoader(id, 1679);
        rs.child(frame++, id++, 14, 15);

        addText(id, "Achievements", fonts, 2, ORANGE, true, true);
        rs.child(frame++, id++, 259, 24);

        addText(id, "Achievements", fonts, 2, ORANGE, true, true);
        rs.child(frame++, id++, 107, 76);

        addText(id, "Point Rewards", fonts, 0, ORANGE, true, true);
        rs.child(frame++, id++, 266, 178);

        addText(id, "Item Rewards", fonts, 0, ORANGE, true, true);
        rs.child(frame++, id++, 413, 176);

        addHoverButtonWSpriteLoader(id, 714, 16, 16, "Close Window", 0, id+1, 1);
        addHoveredImageWSpriteLoader(id+1, 715, 16, 16, id+2);
        rs.child(frame++, id, 472, 24);
        rs.child(frame++, id + 1, 472, 24);
        id += 3;

        addHoverButtonWSpriteLoader(id, 1686, 35, 25, "Collect Reward", 0, id+1, 1);
        addHoveredImageWSpriteLoader(id+1, 1687, 35, 25, id+2);
        rs.child(frame++, id, 444, 139);
        rs.child(frame++, id + 1, 444, 139);
        id += 3;

        addText(id, "Achievement Name", fonts, 2, ORANGE, true, true);
        rs.child(frame++, id++, 340, 58);

        addText(73049, "Achievement Description", fonts, 1, ORANGE, true, true);
        rs.child(frame++, 73049, 340, 100);

        addText(id, "Tier", fonts, 1, GREY, true, true);
        rs.child(frame++, id++, 340, 71);

        addConfigButtonWSpriteLoader(id, id, 1680, 1681, 42, 20, "Easy", 0, 5, 1086);
        addConfigButtonWSpriteLoader(id + 1, id, 1680, 1681, 42, 20, "Medium", 1, 5, 1086);
        addConfigButtonWSpriteLoader(id + 2, id, 1680, 1681, 42, 20, "Hard", 2, 5, 1086);
        addConfigButtonWSpriteLoader(id + 3, id, 1680, 1681, 42, 20, "Expert", 3, 5, 1086);
        rs.child(frame++, id++, 24, 53);
        rs.child(frame++, id++, 65, 53);
        rs.child(frame++, id++, 106, 53);
        rs.child(frame++, id++, 147, 53);

        addText(id, "Easy", fonts, 1, ORANGE, true, true);
        rs.child(frame++, id++, 44, 56);
        addText(id, "Med", fonts, 1, ORANGE, true, true);
        rs.child(frame++, id++, 85, 56);
        addText(id, "Hard", fonts, 1, ORANGE, true, true);
        rs.child(frame++, id++, 126, 56);
        addText(id, "Expert", fonts, 1, ORANGE, true, true);
        rs.child(frame++, id++, 167, 56);

        addWrappingText(id, "A simple description of the achievement. A simple description of the achievement. A simple description of the achievement.", tda, 1, LIGHT_GREY, false, true, 279, 14);

        rs.child(frame++, id++, 200, 95);

        addText(id,"Points: 100k",  fonts, 0, ORANGE, false, true);
        rs.child(frame++, id++, 198, 194);

        addContainer(id, 0, 3, 3, 10, 6, false, new String[] {null, null, null, null, null});
        for (int i = 0; i < 9; i++) {
            interfaceCache[id].inv[i] = i % 2 == 0 ? 4152 : 4154;
            interfaceCache[id].invStackSizes[i] = 1;
        }
        rs.child(frame++, id++, 357, 194);
        addText(11316, "45% | 45/100", fonts, 1, 0xffff00, true, true);
       // System.out.println("Interface id: " + id);
        rs.child(frame++, 11316, 340, 145);

        createList();
        rs.child(frame++, 11690, 26, 95);
    }



    private static void createProgressBar(int id) {
        int frame = 0;
        RSInterface rs = addInterface(id++);
        rs.totalChildren(1);
        rs.width = 280;
        rs.height = 4;

        addRectangle(id, 0, PROGRESS_BAR_COLOR, true, 274, 4);
        rs.child(frame++, id++, 0, 0);
    }

    private static void createList() {
        int id = 11690;
        int frame = 0;
        RSInterface rs = addInterface(id++);
        int totalSlots = 80;
        rs.totalChildren(totalSlots*2);
        rs.width = 146;
        rs.height = 212;
        rs.scrollMax = totalSlots*22;

        for (int i = 0; i < totalSlots; i++) {
            addButtonWSpriteLoader(id, i % 2 == 0 ? 1684 : 1685, "Select");
            rs.child(frame++, id++, 0, i * 22);
            addText(id, "Achievement " + i, fonts, 0, ORANGE, false, true);
            rs.child(frame++, id++, 4, i * 22 + 6);
        }
    }
}
