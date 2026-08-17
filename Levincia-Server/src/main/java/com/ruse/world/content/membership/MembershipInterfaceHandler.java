package com.ruse.world.content.membership;

import com.ruse.world.content.seasonpass.SeasonPass;
import com.ruse.world.entity.impl.player.Player;

import java.util.Calendar;


public class MembershipInterfaceHandler {
    public int costume = 0;
    Calendar cal = Calendar.getInstance();
    int day = cal.get(Calendar.DAY_OF_YEAR);
    public int daysLeft = SeasonPass.SEASONEND - day;
    private final Player player;

    public MembershipInterfaceHandler(Player player) {this.player = player;}
    public void openBenefitTab() {
            player.getPacketSender().sendString(28024, (player.isMembershipUnlocked() == true) ?
                    "@gre@20% DR and 10% DDR boost" : "@or2@20% DR and 10% DDR boost");
        player.getPacketSender().sendString(28025, (player.isMembershipUnlocked() == true) ?
                "@gre@15% Chance to deal X2 DMG" : "@or2@15% Chance to deal X2 DMG");
        player.getPacketSender().sendString(28026, (player.isMembershipUnlocked() == true) ?
                "@gre@10% Chance to double KC" : "@or2@10% Chance to double KC");
        player.getPacketSender().sendString(28027, (player.isMembershipUnlocked() == true) ?
                "@gre@10% Chance to keep boxes" : "@or2@10% Chance to keep boxes");

        player.getPacketSender().sendInterface(28002);
        player.getPacketSender().sendString(28006, ("Resets in: " + daysLeft + " days"));
        player.getPacketSender().sendString(28030, (player.isMembershipUnlocked() == true) ?
                "Membership: @gre@Active" : "Membership: @red@Inactive");
    }
    public void openCosmeticTab() {
        player.getPacketSender().sendInterface(60600);
        player.getPacketSender().sendString(60606, ("Resets in: " + daysLeft + " days"));
        player.getPacketSender().sendString(60630, (player.isCosmeticUnlocked() == true) ?
                "Membership: @gre@Active" : "Membership: @red@Inactive");
        if (costume == 0) {
            player.getPacketSender ().sendItemOnInterface (60623, 13265, 0, 1);
            player.getPacketSender ().sendItemOnInterface (60624, 13267, 0, 1);
            player.getPacketSender ().sendItemOnInterface (60625, 13269, 0, 1);
        }
    }
    public void changeCostumeForward() {
        costume++;
    if (costume == 1) {
     player.getPacketSender().sendNpcOnInterface(60622, 2270, 320);

        player.getPacketSender().sendInterface(60600);
        player.getPacketSender().sendItemOnInterface(60623, 13258, 0, 1);
        player.getPacketSender().sendItemOnInterface(60624, 13267,0, 1);
        player.getPacketSender().sendItemOnInterface(60625, 13269,0, 1);
    }
    else if (costume == 2) {
        player.getPacketSender().sendNpcOnInterface(60622, 2274, 320);
        player.getPacketSender().sendInterface(60600);
        player.getPacketSender().sendItemOnInterface(60623, 13258, 0, 1);
        player.getPacketSender().sendItemOnInterface(60624, 13259,0, 1);
        player.getPacketSender().sendItemOnInterface(60625, 13269,0, 1);
    }
    else if (costume == 3) {
        player.getPacketSender().sendNpcOnInterface(60622, 2276, 320);

        player.getPacketSender().sendInterface(60600);
        player.getPacketSender().sendItemOnInterface(60623, 13258, 0, 1);
        player.getPacketSender().sendItemOnInterface(60624, 13259,0, 1);
        player.getPacketSender().sendItemOnInterface(60625, 13267,0, 1);
    } else

        player.getPacketSender().sendNpcOnInterface(60622, 1552, 320);

        player.getPacketSender().sendInterface(60600);
        player.getPacketSender().sendItemOnInterface(60623, 13265, 0, 1);
        player.getPacketSender().sendItemOnInterface(60624, 13267,0, 1);
        player.getPacketSender().sendItemOnInterface(60625, 13269,0, 1);

        if (costume >= 4 || costume < 0) {
            costume = 0;
        }
    }


    public void changeCostumeBackward() {
        costume--;
        if (costume == 1) {
            player.getPacketSender().sendNpcOnInterface(60622, 2270, 320);
            player.getPacketSender().sendInterface(60600);
            player.getPacketSender().sendItemOnInterface(60623, 13258, 0, 1);
            player.getPacketSender().sendItemOnInterface(60624, 13267,0, 1);
            player.getPacketSender().sendItemOnInterface(60625, 13269,0, 1);
        }
        else if (costume == 2) {
            player.getPacketSender().sendNpcOnInterface(60622, 2274, 320);
            player.getPacketSender().sendInterface(60600);
            player.getPacketSender().sendItemOnInterface(60623, 13258, 0, 1);
            player.getPacketSender().sendItemOnInterface(60624, 13259,0, 1);
            player.getPacketSender().sendItemOnInterface(60625, 13269,0, 1);
        }
        else if (costume == 3) {
            player.getPacketSender().sendNpcOnInterface(60622, 2276, 320);

            player.getPacketSender().sendInterface(60600);
            player.getPacketSender().sendItemOnInterface(60623, 13258, 0, 1);
            player.getPacketSender().sendItemOnInterface(60624, 13259,0, 1);
            player.getPacketSender().sendItemOnInterface(60625, 13267,0, 1);
        } else
            player.getPacketSender().sendNpcOnInterface(60622, 1552, 320);
        player.getPacketSender().sendInterface(60600);
        player.getPacketSender().sendItemOnInterface(60623, 13265, 0, 1);
        player.getPacketSender().sendItemOnInterface(60624, 13267,0, 1);
        player.getPacketSender().sendItemOnInterface(60625, 13269,0, 1);

        if (costume >= 4 || costume < 0) {
            costume = 0;
        }

    }
}