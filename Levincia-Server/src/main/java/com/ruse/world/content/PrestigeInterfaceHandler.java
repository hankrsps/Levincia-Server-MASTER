package com.ruse.world.content;

import com.ruse.world.entity.impl.player.Player;


public class PrestigeInterfaceHandler {
    private final Player player;

    public PrestigeInterfaceHandler(Player player) {this.player = player;}
    public void openPrestigeInterface() {
        player.getPacketSender().sendInterface(77930);
        if (player.getPointsHandler().getTotalPrestiges() == 0) {
            player.getPacketSender().sendSpriteChange(77936, 1709);
            player.getPacketSender().sendSpriteChange(77938, 1710);
            player.getPacketSender().sendString(77998, "Prestige: @whi@None");
            player.getPacketSender().sendString(77999, "Prestige: @whi@1");
            player.getPacketSender().sendItemOnInterface(77939, 20488, 10);
            player.getPacketSender().sendItemOnInterface(77940, 15003, 1);
            player.getPacketSender().sendItemOnInterface(77942, 23236, 1);
        } else if (player.getPointsHandler().getTotalPrestiges() == 1) {
            player.getPacketSender().sendString(77998, "Prestige: @whi@1");
            player.getPacketSender().sendString(77999, "Prestige: @whi@2");
            player.getPacketSender().sendSpriteChange(77936, 1710);
            player.getPacketSender().sendSpriteChange(77938, 1711);
            player.getPacketSender().sendItemOnInterface(77939, 19115, 50);
            player.getPacketSender().sendItemOnInterface(77940, 19114, 25);
            player.getPacketSender().sendItemOnInterface(77942, 23236, 2);
        } else if (player.getPointsHandler().getTotalPrestiges() == 2) {
            player.getPacketSender().sendString(77998, "Prestige: @whi@2");
            player.getPacketSender().sendString(77999, "Prestige: @whi@3");
            player.getPacketSender().sendSpriteChange(77936, 1711);
            player.getPacketSender().sendSpriteChange(77938, 1712);
            player.getPacketSender().sendItemOnInterface(77939, 19115, 50);
            player.getPacketSender().sendItemOnInterface(77940, 19114, 25);
            player.getPacketSender().sendItemOnInterface(77942, 23236, 3);
        } else if (player.getPointsHandler().getTotalPrestiges() == 3) {
            player.getPacketSender().sendString(77998, "Prestige: @whi@3");
            player.getPacketSender().sendString(77999, "Prestige: @whi@4");
            player.getPacketSender().sendSpriteChange(77936, 1712);
            player.getPacketSender().sendSpriteChange(77938, 1713);
            player.getPacketSender().sendItemOnInterface(77939, 19115, 50);
            player.getPacketSender().sendItemOnInterface(77940, 19114, 25);
            player.getPacketSender().sendItemOnInterface(77942, 23236, 4);
        } else if (player.getPointsHandler().getTotalPrestiges() == 4) {
            player.getPacketSender().sendString(77998, "Prestige: @whi@4");
            player.getPacketSender().sendString(77999, "Prestige: @whi@5");
            player.getPacketSender().sendSpriteChange(77936, 1713);
            player.getPacketSender().sendSpriteChange(77938, 1714);
            player.getPacketSender().sendItemOnInterface(77939, 19115, 50);
            player.getPacketSender().sendItemOnInterface(77940, 19114, 25);
            player.getPacketSender().sendItemOnInterface(77942, 23236, 5);
        } else if (player.getPointsHandler().getTotalPrestiges() == 5) {
            player.getPacketSender().sendString(77998, "Prestige: @whi@5");
            player.getPacketSender().sendString(77999, "Prestige: @whi@6");
            player.getPacketSender().sendSpriteChange(77936, 1714);
            player.getPacketSender().sendSpriteChange(77938, 1715);
            player.getPacketSender().sendItemOnInterface(77939, 19115, 50);
            player.getPacketSender().sendItemOnInterface(77940, 19114, 25);
            player.getPacketSender().sendItemOnInterface(77942, 23236, 6);
        } else if (player.getPointsHandler().getTotalPrestiges() == 6) {
            player.getPacketSender().sendString(77998, "Prestige: @whi@6");
            player.getPacketSender().sendString(77999, "Prestige: @whi@7");
            player.getPacketSender().sendSpriteChange(77936, 1715);
            player.getPacketSender().sendSpriteChange(77938, 1716);
            player.getPacketSender().sendItemOnInterface(77939, 19115, 50);
            player.getPacketSender().sendItemOnInterface(77940, 19114, 25);
            player.getPacketSender().sendItemOnInterface(77942, 23236, 7);
        } else if (player.getPointsHandler().getTotalPrestiges() == 7) {
            player.getPacketSender().sendString(77998, "Prestige: @whi@7");
            player.getPacketSender().sendString(77999, "Prestige: @whi@8");
            player.getPacketSender().sendSpriteChange(77936, 1716);
            player.getPacketSender().sendSpriteChange(77938, 1717);
            player.getPacketSender().sendItemOnInterface(77939, 19115, 50);
            player.getPacketSender().sendItemOnInterface(77940, 19114, 25);
            player.getPacketSender().sendItemOnInterface(77942, 23236, 8);
        } else if (player.getPointsHandler().getTotalPrestiges() == 8) {
            player.getPacketSender().sendString(77998, "Prestige: @whi@8");
            player.getPacketSender().sendString(77999, "Prestige: @whi@9");
            player.getPacketSender().sendSpriteChange(77936, 1717);
            player.getPacketSender().sendSpriteChange(77938, 1718);
            player.getPacketSender().sendItemOnInterface(77939, 19115, 50);
            player.getPacketSender().sendItemOnInterface(77940, 19114, 25);
            player.getPacketSender().sendItemOnInterface(77942, 23236, 9);
        } else if (player.getPointsHandler().getTotalPrestiges() == 9) {
            player.getPacketSender().sendString(77998, "Prestige: @whi@9");
            player.getPacketSender().sendString(77999, "Prestige: @whi@10");
            player.getPacketSender().sendSpriteChange(77936, 1718);
            player.getPacketSender().sendSpriteChange(77938, 1719);
            player.getPacketSender().sendItemOnInterface(77939, 19115, 50);
            player.getPacketSender().sendItemOnInterface(77940, 19114, 25);
            player.getPacketSender().sendItemOnInterface(77942, 23236, 10);
        } else if (player.getPointsHandler().getTotalPrestiges() == 10) {
            player.getPacketSender().sendString(77998, "Prestige: @whi@10");
            player.getPacketSender().sendString(77999, "Prestige: @whi@11");
            player.getPacketSender().sendSpriteChange(77936, 1719);
            player.getPacketSender().sendSpriteChange(77938, 1720);
            player.getPacketSender().sendItemOnInterface(77939, 19115, 50);
            player.getPacketSender().sendItemOnInterface(77940, 19114, 25);
            player.getPacketSender().sendItemOnInterface(77942, 23236, 11);
        } else {
            player.getPacketSender().sendItemOnInterface(77939, 19115, 50);
            player.getPacketSender().sendItemOnInterface(77940, 19114, 25);
            player.getPacketSender().sendItemOnInterface(77942, 6199, 12);
        }
    }
}