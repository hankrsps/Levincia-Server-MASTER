package com.ruse.world.content.valentine;

import com.ruse.model.Item;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HweenEvent {

    public static int maxAmount = 500;
    public static int GOODIEBAG = 19806;

    private Player player;
    private int trick;
    private int treat;
    private boolean[] unlockedTrick = new boolean[TrickRewards.values().length];
    private boolean[] unlockedTreat= new boolean[TreatRewards.values().length];
    private Boolean unlockedCrown = false;

    public HweenEvent(Player player) {
        this.player = player;
    }

    public void openInterface(int amount) {
        player.getPacketSender().sendProgressBar(143012, 0, (int) (((double)trick / (double)maxAmount) * 100D), 0);
        player.getPacketSender().sendProgressBar(143013, 0, (int) (((double)treat / (double)maxAmount) * 100D), 0);

        player.getPacketSender().sendString(143015, "" + trick);
        player.getPacketSender().sendString(143017, "" + treat);


        player.getPacketSender().sendString(143009, "" + amount);

        player.getPacketSender().sendItemOnInterface(143014, 22373, 1);

        int interfaceID = 143026;
        for (int i = 0 ; i < unlockedTrick.length; i ++) {
            player.getPacketSender().sendString(interfaceID--, unlockedTrick[i] ? "Unlocked!" : "" + Misc.insertCommasToNumber(TrickRewards.values()[i].getPercentage()));
            player.getPacketSender().sendItemOnInterface(interfaceID--, TrickRewards.values()[i].getItemId(), 1);
        }

        interfaceID = 143034;
        for (int i = 0 ; i < unlockedTreat.length; i ++) {
            player.getPacketSender().sendString(interfaceID--, unlockedTreat[i] ? "Unlocked!" : "" +  Misc.insertCommasToNumber(TreatRewards.values()[i].getPercentage()));
            player.getPacketSender().sendItemOnInterface(interfaceID--, TreatRewards.values()[i].getItemId(), 1);
        }

        player.getPacketSender().sendInterface(143000);
    }

    public void sprinkle() {
        int amount = player.getInventory().getAmount(GOODIEBAG);

        if (trick >= maxAmount) {
            player.sendMessage("@red@You have already reached the maximum amount of tricks.");
            return;
        }

        if (amount == 0) {
            player.sendMessage("@red@You need Candy Corn in your inventory to do this.");
            return;
        }

        if (trick + amount >= maxAmount) {
            amount = maxAmount - trick;
        }
        player.sendMessage("@red@You offer " + amount + " Candy Corns.");
        player.getInventory().delete(GOODIEBAG, amount);
        trick += amount;

        for (int i = 0 ; i < unlockedTrick.length; i ++){
            if (!unlockedTrick[i] && trick >= TrickRewards.values()[i].getPercentage()){
                unlockedTrick[i] = true;
                if (player.getInventory().hasSpaceFor(TrickRewards.values()[i].getItemId(), 1))
                    player.getInventory().add(TrickRewards.values()[i].getItemId(), 1);
                else
                    player.depositItemBank(new Item(TrickRewards.values()[i].getItemId(), 1));
                player.sendMessage("@red@You have unlocked " + ItemDefinition.forId(TrickRewards.values()[i].getItemId()).getName());
                World.sendMessage("<img=1760><shad=1><col=303030>[Trick or Treat]<img=1760> <col=bb2528></shad>" + player.getUsername()
                        + "<shad=1><col=303030> has just received <col=bb2528></shad>"+ItemDefinition.forId(TrickRewards.values()[i].getItemId()).getName()+"!");
            }
        }

        if (!unlockedCrown && trick >= maxAmount && treat >= maxAmount){
            unlockedCrown = true;
            if (player.getInventory().hasSpaceFor(22373, 1))
            player.getInventory().add(22373, 1);
            else
                player.depositItemBank(new Item(22373, 1));
            player.sendMessage("@red@You have unlocked " + ItemDefinition.forId(22373).getName());
            World.sendMessage("<img=1760><shad=1><col=303030>[Trick or Treat]<img=1760> </shad><col=bb2528>" + player.getUsername()
                    + "<shad=1><col=303030> has just received <col=bb2528></shad>"+ItemDefinition.forId(22373).getName()+"!");
        }

        openInterface(player.getInventory().getAmount(GOODIEBAG));
    }

    public void crush() {
        int amount = player.getInventory().getAmount(GOODIEBAG);

        if (treat >= maxAmount) {
            player.sendMessage("@red@You have already reached the maximum amount of treats.");
            return;
        }

        if (amount == 0) {
            player.sendMessage("@red@You need Candy Corns in your inventory to do this.");
            return;
        }

        if (treat + amount >= maxAmount) {
            amount = maxAmount - treat;
        }
        player.sendMessage("@red@You offer " + amount + " Candy Corns.");
        player.getInventory().delete(GOODIEBAG, amount);
        treat += amount;

        for (int i = 0 ; i < unlockedTreat.length; i ++) {
            if (!unlockedTreat[i] && treat >= TreatRewards.values()[i].getPercentage()){
                unlockedTreat[i] = true;
                if (player.getInventory().hasSpaceFor(TreatRewards.values()[i].getItemId(), 1))
                    player.getInventory().add(TreatRewards.values()[i].getItemId(), 1);
                else
                    player.depositItemBank(new Item(TreatRewards.values()[i].getItemId(), 1));
                player.sendMessage("@red@You have unlocked " + ItemDefinition.forId(TreatRewards.values()[i].getItemId()).getName());
                World.sendMessage("<img=1760><shad=1><col=303030>[Trick or Treat]<img=1760></shad> <col=bb2528>" + player.getUsername()
                        + "<shad=1><col=303030> has just received <col=bb2528></shad>"+ItemDefinition.forId(TreatRewards.values()[i].getItemId()).getName()+"!");
            }
        }

        if (!unlockedCrown && trick >= maxAmount && treat >= maxAmount){
            unlockedCrown = true;
            if (player.getInventory().hasSpaceFor(22373, 1))
                player.getInventory().add(22373, 1);
            else
                player.depositItemBank(new Item(22373, 1));
            player.sendMessage("@red@You have unlocked " + ItemDefinition.forId(22373).getName());
            World.sendMessage("<img=1760><shad=1><col=303030>[Trick or Treat]<img=1760> <col=bb2528></shad>" + player.getUsername()
                    + "<shad=1><col=303030> has just received <col=bb2528></shad>"+ItemDefinition.forId(22373).getName()+"!");
        }
        openInterface(player.getInventory().getAmount(GOODIEBAG));
    }


    public boolean handleButton(final int buttonId) {
        if (buttonId == 143010) {
            sprinkle();
            return true;
        } else if (buttonId == 143011) {
            crush();
            return true;
        }
        return false;
    }

    @Getter
    @AllArgsConstructor
    public enum TrickRewards {
        AMULET(20061, 100),
        SHIELD(22376, 200),
        WEAPON(22380, 300),
        HELM(22375, 400),

        ;
        private int itemId;
        private int percentage;
    }

    @Getter
    @AllArgsConstructor
    public enum TreatRewards {
        AMULET(20061, 100),
        SHIELD(22377, 200),
        WEAPON(22374, 300),
        HELM(22379, 400),
        ;
        private int itemId;
        private int percentage;
    }

}
