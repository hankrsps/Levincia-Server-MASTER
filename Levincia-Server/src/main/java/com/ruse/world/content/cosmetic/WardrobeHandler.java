package com.ruse.world.content.cosmetic;

import com.ruse.world.entity.impl.player.Player;

/**
 * @author Levincia
 * @date December,2022
 */
public class WardrobeHandler {

    private Player player;

    public WardrobeHandler(Player player) {
        this.player = player;
    }
    public final WardrobeData data[] = WardrobeData.values ();

    public void open() {

        player.getPacketSender ().resetItemsOnInterface (31875 + 10, 10);
        player.getPA ().sendInterface (133700);
            player.setWardrobeType (WardrobeCategory.FAVORITES);
            sendItemsOnInterface (WardrobeData.COSTUME_1);
            player.setCurrentWardrobe (WardrobeData.COSTUME_1);
            player.getPA().sendNpcOnInterface(133709, player.getWardrobeData ().getNpcId(), player.getWardrobeData ().getAdjustedZoom());

        player.getPA ().sendString (133710, "");
            if (player.getWardrobeData().getNpcId () == 2270 && player.isSet1())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 9244 && player.isSet2())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 607 && player.isSet3())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 903 && player.isSet4())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 904 && player.isSet5())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 905 && player.isSet6())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 906 && player.isSet7())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 907 && player.isSet8())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 908 && player.isSet9())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 909 && player.isSet10())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 910 && player.isSet11())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 911 && player.isSet12())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 912 && player.isSet13())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 913 && player.isSet14())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 914 && player.isSet15())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 915 && player.isSet16())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 916 && player.isSet17())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 917 && player.isSet18())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 918 && player.isSet19())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else if (player.getWardrobeData().getNpcId () == 919 && player.isSet20())
                player.getPA ().sendString (31886, " Unequip Outfit");
            else
                player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ? " Equip Outfit" :
                        "" + "Unlock Outfit");

            switchData ();
    }


    public void open(WardrobeCategory type) {
        player.setWardrobeType (type);
        player.getPA ().sendInterface (133700);
    }

    public void switchData() {
        int count = 133071;
        for (int i = 133071; i < 133121; i++) {
            player.getPA ().sendString (i, "");
        }
        for (WardrobeData data : data) {
                player.getPA ().sendString (count++, data.getName ());
        }
    }


    public void sendItemsOnInterface(WardrobeData data) {
        player.getPA ().sendScrollableItemsOnInterface (31875, new int[][]{data.getHelmet ()});
        player.getPA ().sendScrollableItemsOnInterface (31876, new int[][]{data.getAmulet ()});
        player.getPA ().sendScrollableItemsOnInterface (31877, new int[][]{data.getBody ()});
        player.getPA ().sendScrollableItemsOnInterface (31878, new int[][]{data.getLegs ()});
        player.getPA ().sendScrollableItemsOnInterface (31879, new int[][]{data.getBoots ()});
        player.getPA ().sendScrollableItemsOnInterface (31880, new int[][]{data.getGloves ()});
        player.getPA ().sendScrollableItemsOnInterface (31881, new int[][]{data.getRing ()});
        player.getPA ().sendScrollableItemsOnInterface (31882, new int[][]{data.getAura ()});
        player.getPA ().sendScrollableItemsOnInterface (31883, new int[][]{data.getShield ()});
        player.getPA ().sendScrollableItemsOnInterface (31884, new int[][]{data.getWeapon ()});
        player.getPA ().sendScrollableItemsOnInterface (31885, new int[][]{data.getCape ()});
    }

    public void button(int buttonId) {
        for (WardrobeData data : data) {
                if (buttonId == data.getButtonId ()) {
                    player.setCurrentWardrobe (data);
                    sendItemsOnInterface (data);
                    player.getPA ().sendString (133710, "");

                    if (player.getWardrobeData().getNpcId () == 2270 && player.isSet1())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 9244 && player.isSet2())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 607 && player.isSet3())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 903 && player.isSet4())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 904 && player.isSet5())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 905 && player.isSet6())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 906 && player.isSet7())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 907 && player.isSet8())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 908 && player.isSet9())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 909 && player.isSet10())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 910 && player.isSet11())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 911 && player.isSet12())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 912 && player.isSet13())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 913 && player.isSet14())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 914 && player.isSet15())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 915 && player.isSet16())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 916 && player.isSet17())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 917 && player.isSet18())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 918 && player.isSet19())
                        player.getPA ().sendString (31886, " Unequip Outfit");
                    else if (player.getWardrobeData().getNpcId () == 919 && player.isSet20())
                        player.getPA ().sendString (31886, " Unequip Outfit");

                    else
                        player.getPA ().sendString (31886, player.getWardrobeData ().getOutfitUnlocked () ? " Equip Outfit" :
                                "" + "Unlock Outfit");

                    player.getPA ().sendString (player.getWardrobeData ().buttonId, data.getName ());
                    player.getPA().sendNpcOnInterface(133709, data.getNpcId(), data.getAdjustedZoom());
                    System.err.println ("" + data.getNpcId ());

                }
        }
    }

}
