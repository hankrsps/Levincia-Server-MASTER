package com.ruse.world.content.combat;

import com.ruse.model.Locations;
import com.ruse.model.Position;
import com.ruse.model.Skill;
import com.ruse.model.container.impl.Costumes;
import com.ruse.model.container.impl.Equipment;
import com.ruse.util.Misc;
import com.ruse.world.content.SetBonuses;
import com.ruse.world.content.combat.effect.EquipmentBonus;
import com.ruse.world.content.combat.prayer.CurseHandler;
import com.ruse.world.content.combat.prayer.PrayerHandler;
import com.ruse.world.content.combat.weapon.FightStyle;
import com.ruse.world.content.skill.DropUtils;
import com.ruse.world.content.skill.impl.summoning.BossPets;
import com.ruse.world.content.skill.impl.summoning.Familiar;
import com.ruse.world.entity.impl.Character;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

public class Maxhits {

    public static NPC baseNPC = new NPC(1, new Position (1,1,0));

    public static double getDamageBoost(Player player, Character victim, CombatType combatType) {
        double maxHit = 1;


        if (player.getInventory().contains(23781)) {
            maxHit *=  1.75;
        } else if (player.getInventory().contains(4442)) {
            maxHit *=  1.5;
        }
        //Fantasy armor set
        if (player.getEquipment().contains(23443) && player.getEquipment().contains(23444)
                && player.getEquipment().contains(23445)) {
            maxHit *= 1.2;
        }
        //Diminisher armor set
        if (player.getEquipment().contains(10823) && player.getEquipment().contains(10824)
                && player.getEquipment().contains(10825)) {
            maxHit *= 1.3;
        }

        //Masori armor set
        if (player.getEquipment().contains(13273) && player.getEquipment().contains(13274)
                && player.getEquipment().contains(13275)) {
            maxHit *= 1.4;
        }

        //Masori armor set (f)
        if (player.getEquipment().contains(13841) && player.getEquipment().contains(13842)
                && player.getEquipment().contains(13843)) {
            maxHit *= 1.5;
        }
        //Diyos Custom armor set
        if (player.getEquipment().contains(23418) && player.getEquipment().contains(23419)
                && player.getEquipment().contains(23420)) {
            maxHit *= 1.5;
        }
        if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 22373
                || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23627
                || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23628) {
            maxHit *=  1.1;
        }
        if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23013) {
            maxHit *=  1.05;
        }
        if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23014
                || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23015
                || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23016
                || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23017) {
            maxHit *=  1.1;
        }
        if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23814
                || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 1037
                || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23621) {
            maxHit *=  1.2;
        }

        maxHit *= SetBonuses.getDamageBoost(player);


        return maxHit;
    }

    public static double getMaxHit(Player player, Character victim, CombatType combatType, boolean slayerNPC) {
        int percent = 0;

        if (victim.isNpc()) {
            if (((NPC) victim).getId() == player.getSlayer().getSlayerTask().getNpcId()
                    || slayerNPC) {
                if (player.getInventory().contains(23413))
                    percent += 75;
                else if (player.getInventory().contains(4442)) {
                    percent += 50;
                }
                if (player.getEquipment().getItems()[Equipment.CHARM_SLOT].getId() == 23482) {
                    percent += 25;
                }
                if (player.getEquipment().getItems()[Equipment.CHARM_SLOT].getId() == 23509) {
                    percent += 10;
                }

                if (player.getEquipment().contains(7539)) {
                    percent += 50;
                }
                int charges = player.getSupremeCharges();

            }
            if (player.getWarriorMaster() == true) {
                percent += 20;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.RAICHU_PET.npcId) {
                percent += 15;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.FALLEN_ANGEL_PET.npcId) {
                percent += 25;
            }
            for (Costumes costume : Costumes.values()) {
                if (player.getEquipment().contains(costume.getItemId()))
                    percent += costume.getDamageBoost();
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.SUMMER_SURFER.npcId) {
                percent += 20;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.BLOOD_DEMON_PET.npcId) {
                percent += 30;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.FACELESS_MAGICIAN.npcId) {
                percent += 25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.LOTUS_MAGICIAN.npcId) {
                percent += 25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.SHADOW_MAGICIAN.npcId) {
                percent += 25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.LESARKUS_WARRIOR.npcId) {
                percent += 25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.VAMPIRE_WARRIOR.npcId) {
                percent += 25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.ELF_WARRIOR.npcId) {
                percent += 25;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.DIVINE_ARCHER.npcId) {
                percent += 25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.CHAOTIC_ARCHER.npcId) {
                percent += 25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FOREST_ARCHER.npcId) {
                percent += 25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.SPIRIT_OF_SCORPIUS.npcId) {
                percent += 25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.EVIL_SCORPIUS.npcId) {
                percent += 35;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.NECROMANCER.npcId) {
                percent += 50;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.YUGI_MOTO.npcId) {
                percent += 30;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.DARK_MAGICIAN.npcId) {
                percent += 30;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.ARMED_PROTECTOR.npcId) {
                percent += 30;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.EXODIA.npcId) {
                percent += 30;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.BEWD.npcId) {
                percent += 60;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.KRAMPUS_PET.npcId) {
                percent += 20;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY.npcId) {
                percent += 10;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY1.npcId) {
                percent += 20;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY2.npcId) {
                percent += 20;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY3.npcId) {
                percent += 20;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY4.npcId) {
                percent += 20;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY5.npcId) {
                percent += 20;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY6.npcId) {
                percent += 20;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY7.npcId) {
                percent += 20;
            }

            if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 20592 ||
                    player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 15916 ||
                    player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 13800) {
                percent += 100;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 1906) {
                percent += 10;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 1801) {
                percent += 15;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 9013) {
                percent += 25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 9016) {
                percent += 25;
            }
        }
            /*
            Halloween Seasonal items
             */
                    /*
            Halloween Seasonal items
             */
        if (player.getEquipment().contains(23439)) {
            percent += 1.05;
        }
        if (player.getEquipment().contains(23440)) {
            percent += 1.10;
        }
        if (player.getEquipment().contains(23441)) {
            percent += 1.10;
        }
        if (player.getEquipment().contains(23442)) {
            percent += 1.10;
        }
        if (player.getEquipment().contains(15509) && player.getEquipment().contains(23268)) {
            percent += 1.25;
        }

        if (player.getEquipment().contains(23424) && player.getEquipment().contains(23418)) {
            percent += 1.25;
        }
        if (player.getEquipment().contains(23418)) {
            percent += 1.30;
        }
        if (player.getDoubleDMGTimer() > 0) {
            percent *= 2;
        }
        if (player.getMinutesVotingDMG() > 0) {
            percent *= 2;
        }

        if (player.getEquipment().contains(11676) && player.getEquipment().contains(8839)
                && player.getEquipment().contains(8840) && player.getEquipment().contains(8842)) {
            percent *= 20;
        }

        //Fantasy armor set
        if (player.getEquipment().contains(23443) && player.getEquipment().contains(23444)
                && player.getEquipment().contains(23445)) {
            percent *= 20;
        }

        //Diyos Custom armor set
        if (player.getEquipment().contains(23418) && player.getEquipment().contains(23419)
                && player.getEquipment().contains(23420)) {
            percent *= 25;
        }

        if (player.getAmountDonated() >= 25000) {
            percent += 90;
        } else   if (player.getAmountDonated() >= 10000) {
            percent += 75;
        } else  if (player.getAmountDonated() >= 5000) {
            percent += 50;
        } else if (player.getAmountDonated() >= 1000) {
            percent += 35;
        } else if (player.getAmountDonated() >= 500) {
            percent += 25;
        } else if (player.getAmountDonated() >= 250) {
            percent += 15;
        } else if (player.getAmountDonated() >= 50) {
            percent += 10;
        } else if (player.getAmountDonated() >= 10) {
            percent += 5;
        }       // percent += 50;

        return percent;
    }

    public static int melee(Character entity, Character victim) {
        double maxHit = 0;
        if (entity.isNpc()) {
            NPC npc = (NPC) entity;
            maxHit = npc.getDefinition().getMaxHit();
            if (npc.getStrengthWeakened()[0]) {
                maxHit -= (int) (0.10 * maxHit);
            } else if (npc.getStrengthWeakened()[1]) {
                maxHit -= (int) (0.20 * maxHit);
            } else if (npc.getStrengthWeakened()[2]) {
                maxHit -= (int) (0.30 * maxHit);
            }
        } else if (entity.isPlayer()) {
            Player player = (Player) entity;

            double base = 0;
            double effective = getEffectiveStr(player);
            double strengthBonus = player.getBonusManager().getOtherBonus()[0];
            double specialBonus = 1;

            // Use our multipliers to adjust the maxhit...

            base = 1.4 + effective / 10 + strengthBonus / 80 + effective * strengthBonus / 640;

            // Special effects also affect maxhit
            if (player.isSpecialActivated() && player.getCombatSpecial().getCombatType() == CombatType.MELEE) {
                specialBonus = player.getCombatSpecial().getStrengthBonus();
            }

            if (specialBonus > 1) {
                base = Math.round(base) * specialBonus;
            } else {
                base = (int) base;
            }

            if (victim.isNpc()) {
                if (((NPC) victim).getId() == player.getSlayer().getSlayerTask().getNpcId()) {
                    if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23071
                            || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23069) {
                        base *= 1.05;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23070) {
                        base *= 1.07;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23074) {
                        base *= 1.10;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23072) {
                        base *= 1.15;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23073) {
                        base *= 1.25;
                    } else if (player.getEquipment().getItems()[Equipment.CHARM_SLOT].getId() == 23482) {
                        base *= 1.25;
                    } else if (player.getEquipment().getItems()[Equipment.CHARM_SLOT].getId() == 23509) {
                        base *= 1.10;
                    }

                }
            }
            Familiar playerFamiliar = player.getSummoning().getFamiliar();

            if (playerFamiliar != null) {
                double bonus = DropUtils.getDamageBonus(playerFamiliar.getSummonNpc().getId());
                base *= bonus;
            }
            if (player.getInventory().contains(23413))
                base *= 1.75;
           else if (player.getInventory().contains(4442)) {
                base *= 1.5;
            }
            if (player.getEquipment().contains(7539)) {
                base *= 1.5;
            }
            int charges = player.getSupremeCharges();

            if (charges > 0) {
                base *= 1.20;
                player.decrementSupremeCharges(1);
                if (charges == 25) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 5%");
                } else if (charges == 50) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 10%");
                }else if (charges == 100) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 20%");
                }else if (charges == 200) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 40%");
                }else if (charges == 250) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 50%");
                }else if (charges == 300) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 60%");
                }else if (charges == 350) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 70%");
                }else if (charges == 400) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 80%");
                }else if (charges == 450) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 90%");
                }else {
                }

            }
            int MeleeDamage = Misc.getRandom(1,100);
            if (player.isMembershipUnlocked() == true && MeleeDamage > 90) {
                base *= 2;
            }

            if (player.getWarriorMaster() == true) {
                base *= 1.2;
            }

            if (Misc.isWednesday()) {
                base *= 1.05;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.RAICHU_PET.npcId) {
                base *= 1.15;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.FALLEN_ANGEL_PET.npcId) {
                base *= 1.25;
            }
            for (Costumes costume : Costumes.values()) {
                if (player.getEquipment().contains(costume.getItemId()))
                    base += costume.getDamageBoost();
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.SUMMER_SURFER.npcId) {
                base *= 1.20;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.BLOOD_DEMON_PET.npcId) {
                base *= 1.30;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.FACELESS_MAGICIAN.npcId) {
                base *= 1.25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.LOTUS_MAGICIAN.npcId) {
                base *= 1.25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.SHADOW_MAGICIAN.npcId) {
                base *= 1.25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.LESARKUS_WARRIOR.npcId) {
                base *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.VAMPIRE_WARRIOR.npcId) {
                base *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.ELF_WARRIOR.npcId) {
                base *= 1.25D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.DIVINE_ARCHER.npcId) {
                base *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.CHAOTIC_ARCHER.npcId) {
                base *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FOREST_ARCHER.npcId) {
                base *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.SPIRIT_OF_SCORPIUS.npcId) {
                base *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.EVIL_SCORPIUS.npcId) {
                base *= 1.35D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.NECROMANCER.npcId) {
                base *= 1.5D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.YUGI_MOTO.npcId) {
                base *= 1.3D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.DARK_MAGICIAN.npcId) {
                base *= 1.3D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.ARMED_PROTECTOR.npcId) {
                base *= 1.3D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.EXODIA.npcId) {
                base *= 1.3D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.BEWD.npcId) {
                base *= 1.6D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.KRAMPUS_PET.npcId) {
                base *= 1.20D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.TURKEY.npcId) {
                base *= 1.10D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY1.npcId) {
                base *= 1.20D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY2.npcId) {
                base *= 1.20D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY3.npcId) {
                base *= 1.20D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY4.npcId) {
                base *= 1.20D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY5.npcId) {
                base *= 1.20D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY6.npcId) {
                base *= 1.20D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY7.npcId) {
                base *= 1.20D;
            }

            if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 20592 ||
                    player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 15916 ||
                    player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 13800) {
                base *= 2;
            }

            maxHit = base * 10;


            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 1906) {
                maxHit *= 1.1D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 1801) {
                maxHit *= 1.15D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 9013) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 9016) {
                maxHit *= 1.25D;
            }

            if (victim.isNpc()) {
                if (((NPC) victim).getId() == player.getSlayer().getSlayerTask().getNpcId()
                        && victim.getConstitution() >= ((NPC) victim).getDefaultConstitution()) {
                    int percent = -1;
                    if (player.getEquipment().contains(23071)) {
                        percent = Misc.getRandom(5);
                    } else if (player.getEquipment().contains(23069)) {
                        percent = Misc.getRandom(10);
                    } else if (player.getEquipment().contains(23070)) {
                        percent = Misc.getRandom(15);
                    } else if (player.getEquipment().contains(23074)) {
                        percent = Misc.getRandom(20);
                    } else if (player.getEquipment().contains(23072)) {
                        percent = Misc.getRandom(25);
                    } else if (player.getEquipment().contains(23073)) {
                        percent = Misc.getRandom(30);
                    }

                    if (Misc.random(99) + 1 <= percent) {
                        maxHit = victim.getConstitution() * 10;
                    }
                }
            }
            if (player.getEquipment().contains(23439)) {
                maxHit *= 1.05;
            }
            if (player.getEquipment().contains(23440)) {
                maxHit *= 1.10;
            }
            if (player.getEquipment().contains(23441)) {
                maxHit *= 1.10;
            }

            if (player.getEquipment().contains(23443) && player.getEquipment().contains(23444)
                    && player.getEquipment().contains(23445)) {
                maxHit *= 1.2;
            }

            if (player.getEquipment().contains(23442)) {
                maxHit *= 1.10;
            }
            if (player.getEquipment().contains(15509) && player.getEquipment().contains(23268)) {
                maxHit *= 1.30;
            }
            if (player.getEquipment().contains(15509) && player.getEquipment().contains(23268)) {
                maxHit *= 1.25;
            }
            if (player.getEquipment().contains(23418)) {
                maxHit *= 1.25;
            }
            if (player.getDoubleDMGTimer() > 0) {
                maxHit *= 2;
            }
            if (player.getMinutesVotingDMG() > 0) {
                maxHit *= 2;
            }

            if (player.getEquipment().contains(11676) && player.getEquipment().contains(8839)
                    && player.getEquipment().contains(8840) && player.getEquipment().contains(8842)) {
                maxHit *= 1.2;
            }

            if (player.getAmountDonated() >= 25000) {
                maxHit *= 1.9D;
            } else   if (player.getAmountDonated() >= 10000) {
                maxHit *= 1.75D;
            } else  if (player.getAmountDonated() >= 5000) {
                maxHit *= 1.50D;
            } else if (player.getAmountDonated() >= 1000) {
                maxHit *= 1.35D;
            } else if (player.getAmountDonated() >= 500) {
                maxHit *= 1.25D;
            } else if (player.getAmountDonated() >= 250) {
                maxHit *= 1.15D;
            } else if (player.getAmountDonated() >= 50) {
                maxHit *= 1.1D;
            } else if (player.getAmountDonated() >= 10) {
                maxHit *= 1.05D;
            }

            if (player.getLocation() == Locations.Location.FREE_FOR_ALL_ARENA) {
                maxHit = Misc.getRandom(0,30);
            }
        }

        // Dharoks effect
        if (CombatFactory.fullDharoks(entity)) {
            int hitpoints = entity.getConstitution() / 10;
            if (entity.isNpc()) {
                int missingHealth = ((NPC) entity).getDefinition().getHitpoints() - hitpoints;
                double addToHit = missingHealth * 0.01 + 1;
                maxHit *= addToHit;
            } else {
                int missingHealth = ((Player) entity).getSkillManager().getMaxLevel(Skill.CONSTITUTION) - hitpoints;
                double addToHit = missingHealth * 0.01 + 1;
                maxHit *= addToHit;
                if (maxHit >= 990)
                    maxHit = 990;
            }
        }

        if (victim != null && victim.isNpc()) {
            maxHit = NpcMaxHitLimit.limit((NPC) victim, maxHit, CombatType.MELEE);
        }

        return (int) Math.floor(maxHit);
    }

    public static int ranged(Character entity, Character victim) {
        double maxHit = 0;

        if (entity.isNpc()) {
            NPC npc = (NPC) entity;
            maxHit = npc.getDefinition().getMaxHit() / 10;
        } else if (entity.isPlayer()) {
            Player player = (Player) entity;

            double rangedStrength = player.getBonusManager().getOtherBonus()[1];
            double rangeLevel = player.getSkillManager().getCurrentLevel(Skill.RANGED);

            // Prayers
            double prayerMod = 1.0;
            if (PrayerHandler.isActivated(player, PrayerHandler.SHARP_EYE) || CurseHandler.isActivated(player, CurseHandler.LEECH_RANGED)) {
                prayerMod = 1.05;
            } else if (PrayerHandler.isActivated(player, PrayerHandler.HAWK_EYE)) {
                prayerMod = 1.10;
            } else if (PrayerHandler.isActivated(player, PrayerHandler.EAGLE_EYE)) {
                prayerMod = 1.15;
            } else if (PrayerHandler.isActivated(player, PrayerHandler.RIGOUR)) {
                prayerMod = 1.23;
            } else if (CurseHandler.isActivated(player, CurseHandler.TURMOIL)) {
                prayerMod = 1.25;
            } else if (PrayerHandler.isActivated(player,PrayerHandler.SOUL_LEECH)) {
                prayerMod = 1.15 + +(player.getLeechedBonuses()[2] * 0.01);
                if (Misc.getRandom(100) <= 1) {
                    player.setDoubleDMGTimer(1);
                    player.getPacketSender().sendMessage("Coup de grace activated");
                }
            }

            double otherBonuses = 1;

            if (EquipmentBonus.voidRange(player)) {// , CombatType.RANGED)) {
                if (player.getCurrentClanChat() != null
                        && player.getCurrentClanChat().getName().equalsIgnoreCase("debug")) {
                    player.getPacketSender().sendMessage("Void buff applied");
                }
                otherBonuses = 1.2;
            }
            if (EquipmentBonus.voidmRange(player)) {// , CombatType.RANGED)) {
                if (player.getCurrentClanChat() != null
                        && player.getCurrentClanChat().getName().equalsIgnoreCase("debug")) {
                    player.getPacketSender().sendMessage("Master Void buff applied");
                }
                otherBonuses = 1.2;
            }

            // Do calculations of maxhit...
            double effectiveRangeDamage = (int) (rangeLevel * prayerMod * otherBonuses);

            double baseDamage = 1.6 + effectiveRangeDamage / 10 + rangedStrength / 80 + effectiveRangeDamage * rangedStrength / 640;

            double specialBonus = 1;
            // Special attacks!
            if (player.isSpecialActivated() && player.getCombatSpecial().getCombatType() == CombatType.RANGED) {
                specialBonus = player.getCombatSpecial().getStrengthBonus();
            }

            maxHit = (int) baseDamage * specialBonus;

            if (victim.isNpc()) {
                if (((NPC) victim).getId() == player.getSlayer().getSlayerTask().getNpcId()) {
                    if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23071
                            || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23069) {
                        maxHit *= 1.05;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23070) {
                        maxHit *= 1.07;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23074) {
                        maxHit *= 1.10;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23072) {
                        maxHit *= 1.15;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23073) {
                        maxHit *= 1.25;
                    } else if (player.getEquipment().getItems()[Equipment.CHARM_SLOT].getId() == 23482) {
                        maxHit += 1.25;
                    }else if (player.getEquipment().getItems()[Equipment.CHARM_SLOT].getId() == 23509) {
                        maxHit *= 1.10;
                    }
                }
            }
            if (player.getInventory().contains(23413))
                maxHit *= 1.75;
            else if (player.getInventory().contains(4442)) {
                maxHit *= 1.5;
            }
            if (player.getEquipment().contains(7539)) {
                maxHit *= 1.5;
            }
            int charges = player.getSupremeCharges();
            if (charges > 0) {
                maxHit *= 1.20;
                player.decrementSupremeCharges(1);
                if (charges == 0) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge has ran out!");
                } else if (charges == 25) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 5%");
                } else if (charges == 50) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 10%");
                }else if (charges == 100) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 20%");
                }else if (charges == 200) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 40%");
                }else if (charges == 250) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 50%");
                }else if (charges == 300) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 60%");
                }else if (charges == 350) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 70%");
                }else if (charges == 400) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 80%");
                }else if (charges == 450) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 90%");
                }else {
                }

            }
            if (player.getEquipment().contains(23439)) {
                maxHit *= 1.05;
            }
            if (player.getEquipment().contains(23440)) {
                maxHit *= 1.10;
            }
            if (player.getEquipment().contains(23441)) {
                maxHit *= 1.10;
            }
            if (player.getEquipment().contains(23442)) {
                maxHit *= 1.10;
            }
            if (player.getEquipment().contains(15509) && player.getEquipment().contains(23268)) {
                maxHit *= 1.25;
            }

            if (player.getEquipment().contains(15509) && player.getEquipment().contains(23268)) {
                maxHit *= 1.25;
            }
            if (player.getEquipment().contains(23418)) {
                maxHit *= 1.30;
            }
            if (player.getEquipment().contains(23443) && player.getEquipment().contains(23444)
                    && player.getEquipment().contains(23445)) {
                maxHit *= 1.2;
            }
            int RangeDamage = Misc.getRandom(1, 100);
            if (player.isMembershipUnlocked() == true && RangeDamage > 90) {
                maxHit *= 2;
            }
            if (player.getArcherMaster() == true) {
                maxHit *= 1.2;
            }
            if (Misc.isTuesday()) {
                maxHit *= 1.05;
            }
            for (Costumes costume : Costumes.values()) {
                if (player.getEquipment().contains(costume.getItemId()))
                    maxHit += costume.getDamageBoost();
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.RAICHU_PET.npcId) {
                maxHit *= 1.15D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FALLEN_ANGEL_PET.npcId) {
                maxHit *= 1.25D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.SUMMER_SURFER.npcId) {
                maxHit *= 1.20D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.BLOOD_DEMON_PET.npcId) {
                maxHit *= 1.30D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FACELESS_MAGICIAN.npcId) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.LOTUS_MAGICIAN.npcId) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.SHADOW_MAGICIAN.npcId) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.LESARKUS_WARRIOR.npcId) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.VAMPIRE_WARRIOR.npcId) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.ELF_WARRIOR.npcId) {
                maxHit *= 1.25D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.DIVINE_ARCHER.npcId) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.CHAOTIC_ARCHER.npcId) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FOREST_ARCHER.npcId) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.SPIRIT_OF_SCORPIUS.npcId) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.EVIL_SCORPIUS.npcId) {
                maxHit *= 1.35D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.NECROMANCER.npcId) {
                maxHit *= 1.5D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.YUGI_MOTO.npcId) {
                maxHit *= 1.3D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.DARK_MAGICIAN.npcId) {
                maxHit *= 1.3D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.ARMED_PROTECTOR.npcId) {
                maxHit *= 1.3D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.EXODIA.npcId) {
                maxHit *= 1.3D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.BEWD.npcId) {
                maxHit *= 1.6D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.KRAMPUS_PET.npcId) {
                maxHit *= 1.20D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY.npcId) {
                maxHit *= 1.10D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY1.npcId) {
                maxHit *= 1.20D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY2.npcId) {
                maxHit *= 1.20D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY3.npcId) {
                maxHit *= 1.20D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY4.npcId) {
                maxHit *= 1.20D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY5.npcId) {
                maxHit *= 1.20D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY6.npcId) {
                maxHit *= 1.20D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY7.npcId) {
                maxHit *= 1.20D;
            }
            if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 20592 ||
                    player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 15916 ||
                    player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 13800) {
                maxHit *= 2;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 1906) {
                maxHit *= 1.1D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 1801) {
                maxHit *= 1.15D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 9013) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 9016) {
                maxHit *= 1.25D;
            }
            if (player.getEquipment().contains(23034) &&
                    player.getEquipment().contains(23035) &&
                    player.getEquipment().contains(23036)) {
                maxHit *= 1.10;
            }

            if (player.getAmountDonated() >= 25000) {
                maxHit *= 1.9D;
            } else   if (player.getAmountDonated() >= 10000) {
                maxHit *= 1.75D;
            } else  if (player.getAmountDonated() >= 5000) {
                maxHit *= 1.50D;
            } else if (player.getAmountDonated() >= 1000) {
                maxHit *= 1.35D;
            } else if (player.getAmountDonated() >= 500) {
                maxHit *= 1.25D;
            } else if (player.getAmountDonated() >= 250) {
                maxHit *= 1.15D;
            } else if (player.getAmountDonated() >= 50) {
                maxHit *= 1.1D;
            } else if (player.getAmountDonated() >= 10) {
                maxHit *= 1.05D;
            }

            if (victim.isNpc()) {
                if (((NPC) victim).getId() == player.getSlayer().getSlayerTask().getNpcId()
                        && victim.getConstitution() >= ((NPC) victim).getDefaultConstitution()) {
                    int percent = -1;
                    if (player.getEquipment().contains(23071)) {
                        percent = Misc.getRandom(5);
                    } else if (player.getEquipment().contains(23069)) {
                        percent = Misc.getRandom(10);
                    } else if (player.getEquipment().contains(23070)) {
                        percent = Misc.getRandom(15);
                    } else if (player.getEquipment().contains(23074)) {
                        percent = Misc.getRandom(20);
                    } else if (player.getEquipment().contains(23072)) {
                        percent = Misc.getRandom(25);
                    } else if (player.getEquipment().contains(23073)) {
                        percent = Misc.getRandom(30);
                    }
                    if (Misc.random(99) + 1 <= percent) {
                        maxHit = victim.getConstitution();
                    }
                }
            }
            if (player.getDoubleDMGTimer() > 0) {
                maxHit *= 2;
            }
            if (player.getMinutesVotingDMG() > 0) {
                maxHit *= 2;
            }
            if (player.getEquipment().contains(11675) && player.getEquipment().contains(8839)
                    && player.getEquipment().contains(8840) && player.getEquipment().contains(8842)) {
                maxHit *= 1.2;
            }
            if (player.getLocation() == Locations.Location.FREE_FOR_ALL_ARENA) {
                maxHit = Misc.getRandom(0,25);
            }
        }

        maxHit *= 10;

        if (victim != null && victim.isNpc()) {
            maxHit = (int) NpcMaxHitLimit.limit((NPC) victim, maxHit, CombatType.RANGED);
        }
        return (int) Math.floor(maxHit);
    }

    public static int magic(Character entity, Character victim) {
        double maxHit = 0;

        if (entity.isNpc()) {
            NPC npc = (NPC) entity;
            maxHit = npc.getDefinition().getMaxHit() / 10;
        } else if (entity.isPlayer()) {
            Player player = (Player) entity;

            double magicStrength = player.getBonusManager().getOtherBonus()[3];
            double magicLevel = player.getSkillManager().getCurrentLevel(Skill.MAGIC);

            // Prayers
            double prayerMod = 1.0;
            if (PrayerHandler.isActivated(player, PrayerHandler.MYSTIC_WILL) || CurseHandler.isActivated(player, CurseHandler.LEECH_MAGIC)) {
                prayerMod = 1.05;
            } else if (PrayerHandler.isActivated(player, PrayerHandler.MYSTIC_LORE)) {
                prayerMod = 1.10;
            } else if (PrayerHandler.isActivated(player, PrayerHandler.MYSTIC_MIGHT)) {
                prayerMod = 1.15;
            } else if (PrayerHandler.isActivated(player, PrayerHandler.AUGURY)) {
                prayerMod = 1.23;
            } else if (CurseHandler.isActivated(player, CurseHandler.TURMOIL)) {
                prayerMod = 1.25;
            } else if(PrayerHandler.isActivated(player, PrayerHandler.SOUL_LEECH)){
                prayerMod = 1.25 + +(player.getLeechedBonuses()[2] * 0.01);
                if (Misc.getRandom(100) <= 1) {
                    player.setDoubleDMGTimer(1);
                    player.getPacketSender().sendMessage("Coup de grace activated");
                }
            }
            double otherBonuses = 1;

            // Void hits 10% more
            // Do calculations of maxhit...
            double effectiveMagicDamage = (int) (magicLevel * prayerMod * otherBonuses);


            double baseDamage = 2 + effectiveMagicDamage / 10 + magicStrength / 80 + effectiveMagicDamage * magicStrength / 640;

            double specialBonus = 1;
            // Special attacks!
            if (player.isSpecialActivated() && player.getCombatSpecial().getCombatType() == CombatType.MAGIC) {
                specialBonus = player.getCombatSpecial().getStrengthBonus();
            }

            maxHit = (int) baseDamage * specialBonus;

            if (victim.isNpc()) {
                if (((NPC) victim).getId() == player.getSlayer().getSlayerTask().getNpcId()) {
                    if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23071
                            || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23069) {
                        maxHit *= 1.05;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23070) {
                        maxHit *= 1.07;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23074) {
                        maxHit *= 1.10;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23072) {
                        maxHit *= 1.15;
                    } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23073) {
                        maxHit *= 1.25;
                    } else if (player.getEquipment().getItems()[Equipment.CHARM_SLOT].getId() == 23482) {
                        maxHit *= 1.25;
                    } else if (player.getEquipment().getItems()[Equipment.CHARM_SLOT].getId() == 23509) {
                        maxHit *= 1.10;
                    }
                }
            }
            if (player.getEquipment().contains(23439)) {
                maxHit *= 1.05;
            }
            if (player.getEquipment().contains(23440)) {
                maxHit *= 1.10;
            }
            if (player.getEquipment().contains(23441)) {
                maxHit *= 1.10;
            }
            if (player.getEquipment().contains(23442)) {
                maxHit *= 1.10;
            }
            if (player.getEquipment().contains(15509) && player.getEquipment().contains(23268)) {
                maxHit *= 1.25;
            }

            if (player.getEquipment().contains(15509) && player.getEquipment().contains(23268)) {
                maxHit *= 1.25;
            }
            if (player.getEquipment().contains(23418)) {
                maxHit *= 1.30;
            }
            if (player.getEquipment().contains(23443) && player.getEquipment().contains(23444)
                    && player.getEquipment().contains(23445)) {
                maxHit *= 1.2;
            }
            if (player.getEquipment().contains(23048)) { //Tier 5 Aura
                maxHit *= 1.05D;
            }
            if (player.getEquipment().contains(23049)) { //Tier 6 Aura
                maxHit *= 1.10D;
            }
            if (player.getInventory().contains(23413))
                maxHit *= 1.75;
            else if (player.getInventory().contains(4442)) {
                maxHit *= 1.5;
            }
            if (player.getEquipment().contains(7539)) {
                maxHit *= 1.5;
            }

            for (Costumes costume : Costumes.values()) {
                if (player.getEquipment().contains(costume.getItemId()))
                    maxHit += costume.getDamageBoost();
            }

            int charges = player.getSupremeCharges();


            if (charges > 0) {
                maxHit *= 1.20;
                player.decrementSupremeCharges(1);
                 if (charges == 25) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 5%");
                } else if (charges == 50) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 10%");
                }else if (charges == 100) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 20%");
                }else if (charges == 200) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 40%");
                }else if (charges == 250) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 50%");
                }else if (charges == 300) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 60%");
                }else if (charges == 350) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 70%");
                }else if (charges == 400) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 80%");
                }else if (charges == 450) {
                    player.getPacketSender().sendMessage("Your weapons Supreme charge is now at @red@ 90%");
                }else {
                }

            }


            int MagicDamage = Misc.getRandom(1, 100);
            if (player.isMembershipUnlocked() == true && MagicDamage > 90) {
                maxHit *= 2;
            }
            if (player.getMagicianMaster() == true) {
                maxHit *= 1.2D;
            }

            if (Misc.isMonday ()) {
                maxHit *= 1.05D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.RAICHU_PET.npcId) {
                maxHit *= 1.15D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FALLEN_ANGEL_PET.npcId) {
                maxHit *= 1.25D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.SUMMER_SURFER.npcId) {
                maxHit *= 1.2D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.BLOOD_DEMON_PET.npcId) {
                maxHit *= 1.3D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.NECROMANCER.npcId) {
                maxHit *= 1.5D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.YUGI_MOTO.npcId) {
                maxHit *= 1.3D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.DARK_MAGICIAN.npcId) {
                maxHit *= 1.3D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.ARMED_PROTECTOR.npcId) {
                maxHit *= 1.3D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.EXODIA.npcId) {
                maxHit *= 1.3D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.BEWD.npcId) {
                maxHit *= 1.6D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FACELESS_MAGICIAN.npcId) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.LOTUS_MAGICIAN.npcId) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.SHADOW_MAGICIAN.npcId) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.LESARKUS_WARRIOR.npcId) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.VAMPIRE_WARRIOR.npcId) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.ELF_WARRIOR.npcId) {
                maxHit *= 1.25D;
            }


            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.DIVINE_ARCHER.npcId) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.CHAOTIC_ARCHER.npcId) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FOREST_ARCHER.npcId) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.SPIRIT_OF_SCORPIUS.npcId) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.EVIL_SCORPIUS.npcId) {
                maxHit *= 1.35D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc()
                    .getId() == BossPets.BossPet.KRAMPUS_PET.npcId) {
                maxHit *= 1.2D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY.npcId) {
                maxHit *= 1.1D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY1.npcId) {
                maxHit *= 1.2D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY2.npcId) {
                maxHit *= 1.2D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY3.npcId) {
                maxHit *= 1.2D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY4.npcId) {
                maxHit *= 1.2D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY5.npcId) {
                maxHit *= 1.2D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY6.npcId) {
                maxHit *= 1.2D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY7.npcId) {
                maxHit *= 1.2D;
            }


            if (player.getAmountDonated() >= 25000) {
                maxHit *= 1.9D;
            } else   if (player.getAmountDonated() >= 10000) {
                maxHit *= 1.75D;
            } else  if (player.getAmountDonated() >= 5000) {
                maxHit *= 1.50D;
            } else if (player.getAmountDonated() >= 1000) {
                maxHit *= 1.35D;
            } else if (player.getAmountDonated() >= 500) {
                maxHit *= 1.25D;
            } else if (player.getAmountDonated() >= 250) {
                maxHit *= 1.15D;
            } else if (player.getAmountDonated() >= 50) {
                maxHit *= 1.1D;
            } else if (player.getAmountDonated() >= 10) {
                maxHit *= 1.05D;
            }
            if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 20592 ||
                    player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 15916 ||
                    player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 13800) {
                maxHit *= 2;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 1906) {
                maxHit *= 1.1D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 1801) {
                maxHit *= 1.15D;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 9013) {
                maxHit *= 1.25D;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == 9016) {
                maxHit *= 1.25D;
            }
            if (victim.isNpc()) {
                if (((NPC) victim).getId() == player.getSlayer().getSlayerTask().getNpcId()
                        && victim.getConstitution() >= ((NPC) victim).getDefaultConstitution()) {
                    int percent = -1;
                    if (player.getEquipment().contains(23071)) {
                        percent = Misc.getRandom(5);
                    } else if (player.getEquipment().contains(23069)) {
                        percent = Misc.getRandom(10);
                    } else if (player.getEquipment().contains(23070)) {
                        percent = Misc.getRandom(15);
                    } else if (player.getEquipment().contains(23074)) {
                        percent = Misc.getRandom(20);
                    } else if (player.getEquipment().contains(23072)) {
                        percent = Misc.getRandom(25);
                    } else if (player.getEquipment().contains(23073)) {
                        percent = Misc.getRandom(30);
                    }
                    if (Misc.random(99) + 1 <= percent) {
                        maxHit = victim.getConstitution();
                    }
                }
            }
            if (player.getDoubleDMGTimer() > 0) {
                maxHit *= 2;
            }
            if (player.getMinutesVotingDMG() > 0) {
                maxHit *= 2;
            }

            if (player.getEquipment().contains(11674) && player.getEquipment().contains(8839)
                    && player.getEquipment().contains(8840) && player.getEquipment().contains(8842)) {
                maxHit *= 1.2;
            }
            if (player.getLocation() == Locations.Location.FREE_FOR_ALL_ARENA) {
                maxHit = Misc.getRandom(0,28);
            }
        }

        maxHit *= 10;


        if (victim != null && victim.isNpc()) {
            maxHit = (int) NpcMaxHitLimit.limit((NPC) victim, maxHit, CombatType.RANGED);
        }
        return (int) Math.floor(maxHit);
    }

    public static double getEffectiveStr(Player player) {
        double styleBonus = 0;
        FightStyle style = player.getFightType().getStyle();

        double otherBonus = 1;

        double prayerMod = 1.0;
        double random = Math.random() * 10;
        if (PrayerHandler.isActivated(player, PrayerHandler.BURST_OF_STRENGTH) || CurseHandler.isActivated(player, CurseHandler.LEECH_STRENGTH)) {
            prayerMod = 1.05;
        } else if (PrayerHandler.isActivated(player, PrayerHandler.SUPERHUMAN_STRENGTH)) {
            prayerMod = 1.1;
        } else if (PrayerHandler.isActivated(player, PrayerHandler.ULTIMATE_STRENGTH)) {
            prayerMod = 1.15;
        } else if (PrayerHandler.isActivated(player, PrayerHandler.CHIVALRY)) {
            prayerMod = 1.18;
        } else if (PrayerHandler.isActivated(player, PrayerHandler.PIETY)) {
            prayerMod = 1.23;
        } else if (CurseHandler.isActivated(player, CurseHandler.TURMOIL)) {
            prayerMod = 1.25;
        } else if(PrayerHandler.isActivated(player, PrayerHandler.SOUL_LEECH)) {
            prayerMod = 1.15 + +(player.getLeechedBonuses()[2] * 0.01);
            if (Misc.getRandom(100) <= 1) {
                player.setDoubleDMGTimer(1);
                player.getPacketSender().sendMessage("Coup de grace activated");

            }
        }

        int number = (int) (player.getSkillManager().getCurrentLevel(Skill.STRENGTH) * prayerMod * otherBonus + styleBonus);
        return number;
    }

}
