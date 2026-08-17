package com.ruse.world.content.raids.elders;

import com.ruse.model.Item;
import com.ruse.util.Misc;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.raids.system.RaidDifficulty;
import com.ruse.world.entity.impl.player.Player;

public class TelosInterfaces {

    public static void openInterface(Player player) {
        player.getPacketSender().sendString(144002, "Elder Gods Interface");
        TelosRaidParty party = player.getTelosRaidsParty();
        if (party == null || !party.getOwner().equals(player)) {
            player.sendMessage("You must be the leader of your party to do this.");
            return;
        }
        if (party.getDifficulty() == null)
            party.setDifficulty(RaidDifficulty.EASY1);

        player.getPacketSender().sendString(144017, Misc.insertCommasToNumber(party.getDifficulty().getGodsRequirement().getCost()) + " Necromancer KC");

        if (party.getDifficulty() == RaidDifficulty.EASY1) {
            player.getPacketSender().sendString(144018, "Unlocked Guild Master");
        } else if (party.getDifficulty() == RaidDifficulty.INTERMEDIATE1) {
            player.getPacketSender().sendString(144018, "100 Easy KC");
        } else if (party.getDifficulty() == RaidDifficulty.ADVANCED1) {
            player.getPacketSender().sendString(144018, "200 Medium KC");
        }

        player.getPacketSender().sendConfig(4511, party.getDifficulty().ordinal());
        player.getPacketSender().sendInterface(144000);
    }

    public static void openCofferRewards(Player player) {
        player.getPacketSender().sendString(144102, "Elder Gods Coffer");
        int length = player.getTelosCoffer().size() >= 40 ? player.getTelosCoffer().size() : 40;

        for (int i = 0; i < length; i++) {
            Item item = player.getTelosCoffer().size() > i ? player.getTelosCoffer().get(i) : new Item(-1, 1);
            player.getPacketSender().sendItemOnInterface(144151 + i, item.getId(), item.getAmount());
        }

        int itemsScroll = (length / 8 * 41);
        if (itemsScroll <= 205)
            itemsScroll = 205;
        player.getPacketSender().setScrollBar(144150, itemsScroll);

        player.getPacketSender().sendString(144112, "Drop Rate: @whi@" + player.getElderDropRate() + "%");

        player.getPacketSender().sendConfig(4511, 0);
        player.getPacketSender().sendInterface(144100);
        player.sendMessage("@red@Withdrawing from your coffer will reset your Elder Gods Drop rate to 0%");

    }

    public static void takeCofferRewards(Player player) {
        boolean took = false;
        for (int i = 0; i < player.getTelosCoffer().size();i ++ ) {
            Item item = player.getTelosCoffer().get(i);
            if (item != null)
            if (player.getInventory().hasSpaceFor(item.getId(), item.getAmount())) {
                player.getInventory().add(item.getId(), item.getAmount());
                took = true;
                player.getTelosCoffer().remove(i);
                i --;
            }
        }
        if (took) {
            player.sendMessage("Your coffer rewards were added to your inventory.");
            player.setElderDropRate( 0);
        }
        openCofferRewards(player);
    }

    public static void bankCofferRewards(Player player) {

        for (Item item : player.getTelosCoffer()) {
            player.depositItemBank(item);
        }

        player.setElderDropRate( 0);

        player.getTelosCoffer().clear();
        openCofferRewards(player);
    }

    public static void viewCofferItems(Player player, int interfaceId, int itemID) {
        int index = interfaceId - 13079;

        if (index < player.getTelosCoffer().size()) {
            if (itemID == player.getTelosCoffer().get(index).getId() &&
                    player.getInventory().hasSpaceFor(player.getTelosCoffer().get(index).getId(), player.getTelosCoffer().get(index).getAmount())) {
                player.setElderDropRate( 0);
                player.getInventory().add(player.getTelosCoffer().get(index));
                player.sendMessage("x" + player.getTelosCoffer().get(index).getAmount() + " " + player.getTelosCoffer().get(index).getDefinition().getName() +
                        " has been added to your inventory.");
                player.getTelosCoffer().remove(index);
            } else {
                player.getPacketSender().sendMessage("You don't have enough free inventory space.");
            }
        }
        openCofferRewards(player);
    }


    public static void viewRewards(Player player, Box[] loot) {
        player.getPacketSender().sendString(144502, "Elder Gods Rewards");
        int length = loot.length >= 40 ? loot.length : 40;
        int interID = 144551;

        for (int i = 0; i < length; i++) {
            Box item = loot.length > i ? loot[i] : new Box(-1, 0);
            int rate = (int) (100D / item.getRate());
            String chance = item.getRate() == 0 ? "" : item.getRate() >= 100 ? "Always" : item.getRate() >= 10 ? "Common" : ("1/" + rate);

            player.getPacketSender().sendItemOnInterface(interID++, item.getId(), item.getAmount());
            player.getPacketSender().sendString(interID++, chance);
        }

        int itemsScroll = (length / 8 * 41);
        if (itemsScroll <= 205)
            itemsScroll = 205;
        player.getPacketSender().setScrollBar(144550, itemsScroll);

        player.getPacketSender().sendConfig(4511, 1);
        player.getPacketSender().sendInterface(144500);

        player.getPacketSender().sendString(144516, "Drop Rate: @whi@" + player.getElderDropRate() + "%");


    }


}