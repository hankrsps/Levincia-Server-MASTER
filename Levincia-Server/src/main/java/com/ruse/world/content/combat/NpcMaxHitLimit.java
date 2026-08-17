package com.ruse.world.content.combat;

import com.ruse.model.definitions.NpcDefinition;
import com.ruse.world.entity.impl.npc.NPC;

public class NpcMaxHitLimit {

    public static double limit(NPC npc, double damage, CombatType type) {
        int maxLimit;
        switch (npc.getId()) {
            case 9129: //slayer champion
            case 9312: //Nephilim Warrior
            case 9319: //Zenyte Golem
            case 587:  //Ironman boss
            case 9318: //Onyx Panther
            case 3830: //Vozzath
            case 4972: //Dragon king
            case 3305: //Naraku
            case 9017: //Nightmare Boss
            case 8013: //Vote Boss
            case 3779: //Terrorstep
            case 187://Hellraiser
            case 8499://Thanksgiving Turkey
            case 10005://Krampus
                maxLimit = (NpcDefinition.forId(npc.getId()).getHitpoints() / 100) * 2;
                break;
            case 200: // the diminisher
                maxLimit = (NpcDefinition.forId(npc.getId()).getHitpoints() / 100) * 7;
                break;
            case 9899://Dragonkin
            case 9993://Beast Tok
            case 9884://Telos
                maxLimit = (NpcDefinition.forId(npc.getId()).getHitpoints() / 100) * 5;
                break;

            default:
                return damage;
        }
        return Math.min(maxLimit, damage);
    }
}
