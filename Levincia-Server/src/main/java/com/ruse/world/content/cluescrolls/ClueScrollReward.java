package com.ruse.world.content.cluescrolls;

import com.ruse.model.definitions.ItemDefinition;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum ClueScrollReward {
    //TODO: missing item IDs

    //Easy rewards
    $1_BOND(10946, 100, ClueScroll.EASY),
    DR_SCROLL(15358, 50, ClueScroll.EASY),
    DMG_SCROLL(15358, 50, ClueScroll.EASY),
    $5_BOND(6769, 1000, ClueScroll.EASY),
    OVERPOWERED_CHEST(20488, 10, ClueScroll.EASY),
    GRAND_MYSTERY_BOX(19114, 10, ClueScroll.EASY),
    EXTREME_MYSTERY_BOX(19115, 5, ClueScroll.EASY),
    SUPER_MYSTERY_BOX(19116, 3, ClueScroll.EASY),
    TOKENS(ItemDefinition.UPGRADE_TOKEN_ID, 30000, 1, ClueScroll.EASY),
    PVM_TICKETS(ItemDefinition.PVM_TICKETS, 20000, 1, ClueScroll.EASY),

    //Medium rewards
    a$1_BOND(10946, 50, ClueScroll.MEDIUM),
    aDR_SCROLL(15358, 25, ClueScroll.MEDIUM),
    aDMG_SCROLL(15358, 25, ClueScroll.MEDIUM),
    a$5_BOND(6769, 500, ClueScroll.MEDIUM),
    aOVERPOWERED_CHEST(20488, 5, ClueScroll.MEDIUM),
    aGRAND_MYSTERY_BOX(19114, 5, ClueScroll.MEDIUM),
    aEXTREME_MYSTERY_BOX(19115, 3, ClueScroll.MEDIUM),
    aSUPER_MYSTERY_BOX(19116, 2, ClueScroll.MEDIUM),
    aTOKENS(ItemDefinition.UPGRADE_TOKEN_ID, 60000, 1, ClueScroll.MEDIUM),
    aPVM_TICKETS(ItemDefinition.PVM_TICKETS, 40000, 1, ClueScroll.MEDIUM),

    //Hard rewards
    b$1_BOND(10946, 25, ClueScroll.HARD),
    bDR_SCROLL(15358, 15, ClueScroll.HARD),
    bDMG_SCROLL(15358, 15, ClueScroll.HARD),
    b$5_BOND(6769, 250, ClueScroll.HARD),
    bOVERPOWERED_CHEST(20488, 3, ClueScroll.HARD),
    bGRAND_MYSTERY_BOX(19114, 2, ClueScroll.HARD),
    bTOKENS(ItemDefinition.UPGRADE_TOKEN_ID, 100_000, 1, ClueScroll.HARD),
    bPVM_TICKETS(ItemDefinition.PVM_TICKETS, 75_000, 1, ClueScroll.HARD),
    ;

    public int getMinAmt() {
        return minAmt;
    }

    public int getMaxAmt() {
        return maxAmt;
    }

    public int getItemId() {
        return itemId;
    }

    int minAmt;
    int maxAmt;
    int itemId;
    int rate;
    ClueScroll type;
    public static final List<ClueScrollReward> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();

    ClueScrollReward(int itemId, int amt, int rate, ClueScroll type) {
        this.itemId = itemId;
        this.minAmt = amt;
        this.maxAmt = amt;
        this.rate = rate;
        this.type = type;
    }
    ClueScrollReward(int itemId, int minAmt, int maxAmt, int rate, ClueScroll type) {
        this.itemId = itemId;
        this.minAmt = minAmt;
        this.maxAmt = maxAmt;
        this.rate = rate;
        this.type = type;
    }
    ClueScrollReward(int itemId, int rate, ClueScroll type) {
        this.itemId = itemId;
        this.minAmt = 1;
        this.maxAmt = 1;
        this.rate = rate;
        this.type = type;
    }

    public static ClueScrollReward getWeightedReward(ClueScroll difficulty) {
        double totalWeight = 0;
        double[] pointWeight = new double[SIZE];
        for(int i = 0; i < pointWeight.length; i++) {
            ClueScrollReward current = VALUES.get(i);
            if(current.type == difficulty) {
                pointWeight[i] = 1D / current.rate;
            } else {
                pointWeight[i] = 0;
            }
            totalWeight += pointWeight[i];
        }

        double r = Math.random() * totalWeight;
        double runningWeight = 0.0;
        int winner = 0;
        for(int i = 0; i < pointWeight.length; i++) {
            runningWeight += pointWeight[i];
            if (runningWeight >= r) {
                winner = i;
                break;
            }
        }
        return VALUES.get(winner);
    }
}
