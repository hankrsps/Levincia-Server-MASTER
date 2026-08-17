package com.ruse.world.content;

import com.ruse.world.entity.impl.player.Player;
import lombok.Getter;

@Getter
public enum SetBonuses {

   // LUCIFER(0, 1.05,22100, 22101, 22102),
    ;

    SetBonuses(double dropRate, double damageBoost, int... items) {
        this.dropRate = dropRate;
        this.damageBoost = damageBoost;
        this.items = items;
    }

    public static SetBonuses forID(Player player) {
        for (SetBonuses setBonuses : SetBonuses.values()) {
            boolean contains = true;
            for (int wear : setBonuses.getItems()) {
                if (!player.getEquipment().contains(wear))
                    contains = false;
            }
            if (contains)
                return setBonuses;
        }
        return null;
    }


    public static double getDamageBoost(Player player) {
        SetBonuses bonuses = forID(player);
        if (bonuses == null)
            return 1;
        return bonuses.getDamageBoost();
    }

    private double dropRate;
    private double damageBoost;
    private int[] items;
}