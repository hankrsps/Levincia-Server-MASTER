package com.ruse.world.content.progressionzone;

import com.ruse.model.Item;
import com.ruse.model.Position;
import com.ruse.model.definitions.NpcDefinition;
import lombok.Getter;

public class ZoneData {

    public enum Monsters {

        // Levincia themed progression rewards. Existing kill counts/zone logic are preserved.
        PHASE_1(9001, 10, new Item[]{new Item(22573), new Item(22577), new Item(22580)}),
        PHASE_2(9002, 20, new Item[]{new Item(22574), new Item(22575), new Item(22576), new Item(22578), new Item(22579)}),
        PHASE_3(9003, 30, new Item[]{new Item(22581), new Item(22582), new Item(22583), new Item(22584), new Item(22585), new Item(22586), new Item(22587), new Item(22588)}),
        PHASE_4(9004, 50, new Item[]{new Item(22589), new Item(22590), new Item(22591), new Item(22592), new Item(22593), new Item(22594), new Item(22595), new Item(22596)}),
        PHASE_5(9005, 75, new Item[]{new Item(22597), new Item(22598), new Item(22599), new Item(22600), new Item(22601), new Item(22602), new Item(22603), new Item(22604)}),
        PHASE_6(9006, 100, new Item[]{new Item(22605), new Item(8334, 1), new Item(19892, 1), new Item(8335, 1)})
        ;

        @Getter
        private int npcId;
        @Getter
        private int amountToKill;
        @Getter
        private Item[] rewards;

        Monsters(int npcId, int amountToKill, Item[] rewards) {
            this.npcId = npcId;
            this.amountToKill = amountToKill;
            this.rewards = rewards;
        }

        public static Monsters forID(int npcId) {
            for (Monsters monster : Monsters.values()) {
                if (monster.getNpcId() == npcId) {
                    return monster;
                }
            }
            return null;
        }

        public String getName() {
            return NpcDefinition.forId(npcId).getName();
        }

        public Position getCoords() {
            return new Position(3034, 4121 , 1 + + (ordinal() * 4));
        }
    }

}
