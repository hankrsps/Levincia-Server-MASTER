package com.ruse.world.content.youtube;

import com.ruse.world.entity.impl.player.Player;

/**
 * @author Levincia
 * Contact email: AlwaysDreaming.ai@gmail.com
 * Date coded 9/14/2022
 */

public class YoutubeInterfaceHandler {

    private Player player;

    public YoutubeInterfaceHandler(Player player) {
        this.player = player;
    }

    /* This cache's enum values to prevent it from constantly using arraysOnCopy */

    public final YoutubeData data[] = YoutubeData.values();

    public void open() {
        player.getPacketSender().resetItemsOnInterface(48080 + 20, 20);
        switchTab();
        player.getPA().sendInterface(82350);
        if (player.getTeleportData() == null) {
            player.setYoutubeType(YoutubeCategory.MAIN);
            sendItemsOnInterface(YoutubeData.WRECKEDYOU);
            player.setCurrentData(YoutubeData.WRECKEDYOU);;
            player.getPA().sendString(82358, "Claim " + YoutubeData.WRECKEDYOU.getName() + "'s Creator box");
            player.getPA().sendString(82356, YoutubeData.WRECKEDYOU.getLive() ? "<img=10> Youtuber is @gre@Live" : "<img=10> Youtuber is @red@Offline");
            player.getPA().sendString(82357, "");
        }
    }

    public void switchData() {
        int count = 82461;
        for (int i = 82461; i < 82475; i++) {
            player.getPA().sendString(i, "");
        }
        for (YoutubeData data : data) {
            if (data.getLive() == true && data.getType() == player.getYoutubeType())
                player.getPA().sendString(count++, data.getName() + " @gre@Live Now");
           else if (data.getLive() == false && data.getType() == player.getYoutubeType())
                player.getPA().sendString(count++, data.getName());

        }
    }
    public void switchTab() {
        player.setYoutubeType(YoutubeCategory.MAIN);
        switchData();
        }

    public void sendItemsOnInterface(YoutubeData data1) {
        player.getPA().sendScrollableItemsOnInterface(48080, data1.getItems());
        player.getPA().sendString(82358, "Claim " + data1.getName() + "'s Creator box");
        player.getPA().sendString(82356, data1.live ? "<img=10> Youtuber is @gre@Live" : "<img=10> Youtuber is @red@Offline");
        player.getPA().sendString(82357, "");
    }

    public void button(int buttonId) {
        for (YoutubeData data : data) {
            if (data.getType() == player.getYoutubeType()) {
                if (buttonId == data.getTextButtonId() || buttonId == data.getBackgroundButtonId()) {
                    player.setCurrentData(data);
                    sendItemsOnInterface(data);
                    } else {
                    }
                }
            }
        }
}
