package com.ruse.world.content;

import com.ruse.model.Item;
import com.ruse.webhooks.discord.DiscordMessager;
import com.ruse.world.World;

public class DonoDeal {

    public static int amountClaimed = 0;
    public static int totalAmount = 0;
    public static int donoAmount = 0;

    public static Item reward = null;

    public static void createDonoDeal(int total, int dono, int itemId, int amount) {
        amountClaimed = 0;
        totalAmount = total;
        donoAmount = dono;

        reward = new Item(itemId, amount);

        World.sendMessage1("@blu@Dono-deal: @red@" + getMessage());
        DiscordMessager.sendDonationAnnouncement ("***Dono-deal: *** " + getDiscordMessage() +"");
    }

    public static String getMessage() {
        return "Every $" + donoAmount + " donated you will get <shad>x" + reward.getAmount() + " " + reward.getDefinition().getName()
                + (reward.getId() == 11027 ? " and x1 Spring box" : "")+
               (totalAmount == -5 ?
        ""
                       :
                 ("</shad> <col=842307>(" +(totalAmount -  amountClaimed) + " left to claim)"));
    }
    public static String getDiscordMessage() {
        return "Every ***$" + donoAmount + "*** donated you will get ***x" + reward.getAmount() + " " + reward.getDefinition().getName()
                +"***"+
                (totalAmount == -5 ? "" : (" - (" +(totalAmount -  amountClaimed) + " left to claim)"));
    }
    public static void endDonoDeal() {

        amountClaimed = 0;
        totalAmount = 0;
        donoAmount = 0;

        reward = null;
        World.sendMessage1("@blu@Dono-deal: @red@The current donation deal has ended!");

        DiscordMessager.sendDonationAnnouncement2 ("***Dono-deal: *** " + "The current donation deal has ended!" +"");
    }


}
