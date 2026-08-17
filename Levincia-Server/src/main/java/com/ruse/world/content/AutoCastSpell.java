package com.ruse.world.content;

import com.ruse.model.container.impl.Equipment;
import com.ruse.world.content.combat.magic.CombatSpells;
import com.ruse.world.entity.impl.player.Player;

public enum AutoCastSpell {

    BLASTER(17017, CombatSpells.BATTLESTAFF),
    EVIL_STAFF(5096, CombatSpells.DARKSTAFF),
    STARTER1(13641, CombatSpells.AVERNICBLAST),
    CHILLING(14377, CombatSpells.SORCEBLAST),
    FESTIVE_STAFF(14924, CombatSpells.ICEYBLAST),
    SHETANI(5095, CombatSpells.SHETANISTAFF),
    VIXIE(6936, CombatSpells.VIXIESTAFF),
    PURP(8809, CombatSpells.PURPSTAFF),
    GIANT(17600, CombatSpells.GIANTSTAFF),
    MOON(7640, CombatSpells.MOONSTAFF),
    LMOONSTAFF(18629, CombatSpells.LMOONSTAFF),
    MAX(8089, CombatSpells.MAXSTAFF),
    GMSTAFF(8412, CombatSpells.GMSTAFF),
    SANGUINE(23786, CombatSpells.GMSTAFFsang),
    BUU(16249, CombatSpells.BUUSTAFF),
    ARR0(22092, CombatSpells.ARROWSTAFF),
    ARR01(3739, CombatSpells.ARROWSTAFF),
    FLAME(17712, CombatSpells.FLAMETHROWER),
    ASTRO(17704, CombatSpells.ASTROGUN),
    FIREG(13640, CombatSpells.FIREG),
    FROZEN(19331, CombatSpells.FROZEN),
    batt(18356, CombatSpells.BATTLESTAFF),
    STARTER(16995, CombatSpells.BEGINNER),
    FESTIVE(14924, CombatSpells.BEGINNER),
    ARTS(22092, CombatSpells.BEGINNER),
    GANO(8809, CombatSpells.BEGINNER),
    MOONLIGHT(18629, CombatSpells.MEDIUM),
    VINDICTA(17600, CombatSpells.MEDIUM),
    RUTHLESS(23145, CombatSpells.MEDIUM),
    LEGENDS(17011, CombatSpells.SANGSTAFF2),
    LIGHT(17013, CombatSpells.SANGGSTAFF),
    DARK(22114, CombatSpells.SANGGSTAFF),
    BLOOD(23227, CombatSpells.SANGGSTAFF),
    DIYOS(15874, CombatSpells.DIYOS),
    NEPHILIM(23062, CombatSpells.NEPHILIM),
    NEPHILIMU(23364, CombatSpells.NEPHILIMU),
    TUMEKENS_SHADOW(18485, CombatSpells.TUMEKEN),
    TUMEKENS_SHADOWU(18487, CombatSpells.TUMEKEN),
    NECROMANCER(23302, CombatSpells.NECROMANCER),
    PUMPKIN(22375, CombatSpells.PUMPKIN),
    MAGICIAN_STAFF(3745, CombatSpells.MEDIUM),
    MAGIC(23026,CombatSpells.MEDIUM)
    ;

    private int itemId;
    private CombatSpells spell;

    AutoCastSpell(int itemId, CombatSpells spell) {
        this.itemId = itemId;
        this.spell = spell;
    }

    public static CombatSpells getAutoCastSpell(Player player) {
        if (player.getEquipment().get(Equipment.WEAPON_SLOT).getId() == 18629) {
            return CombatSpells.MEDIUM;
        }
        for (AutoCastSpell d : AutoCastSpell.values()) {
            if (player.getEquipment().get(Equipment.WEAPON_SLOT).getId() == d.getItemId()) {
                return d.getSpell();
            }
        }
        return null;
    }


    public static AutoCastSpell getAutoCast(Player player) {
        for (AutoCastSpell d : AutoCastSpell.values()) {
            if (player.getEquipment().get(Equipment.WEAPON_SLOT).getId() == d.getItemId()) {
                return d;
            }
        }
        return null;
    }

    public int getItemId() {
        return itemId;
    }

    public CombatSpells getSpell() {
        return spell;
    }

}
