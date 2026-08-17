package com.ruse.world.content.upgrading;

import com.ruse.model.Item;
import com.ruse.model.PlayerRights;
import com.ruse.model.Skill;
import com.ruse.model.container.impl.Bank;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.PlayerLogs;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.content.startertasks.StarterTasks;
import com.ruse.world.entity.impl.player.Player;
import mysql.impl.Store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class UpgradeInterface {

    private Player player;
    private Upgradeables selectedUpgrade;
    private ArrayList<Upgradeables> upgradeablesArrayList;

    public UpgradeInterface(Player player) {
        this.player = player;
    }

    public boolean handleButton(int buttonId) {

        switch (buttonId) {
            case -3284:
                handleUpgrade(true);
                return true;
            case -3334:
                handleUpgrade(false);
                return true;
            case -3295:
            case 30867:
                openInterface(Upgradeables.UpgradeType.TIER_1);
                return true;
            case -3301:
            case 30868:
                if (player.getSkillManager().getMaxLevel(Skill.INVENTION) < 15) {
                player.getPacketSender()
                        .sendMessage("You need a Invention Level of at-least @blu@15 Invention@bla@ to view this Tier.");
                return false;
            }
                openInterface(Upgradeables.UpgradeType.TIER_2);
                return true;
            case -3300:
            case 30869:
                if (player.getSkillManager().getMaxLevel(Skill.INVENTION) < 35) {
                    player.getPacketSender()
                            .sendMessage("You need a Invention Level of at-least @blu@35 Invention@bla@ to view this Tier.");
                    return false;
                }
                openInterface(Upgradeables.UpgradeType.TIER_3);
                return true;
            case -3296:
            case 30870:
                if (player.getSkillManager().getMaxLevel(Skill.INVENTION) < 55) {
                player.getPacketSender()
                        .sendMessage("You need a Invention Level of at-least @blu@55 Invention@bla@ to view this Tier.");
                return false;
            }
                openInterface(Upgradeables.UpgradeType.TIER_4);
                return true;
            case -3293:
            case 30871:
                if (player.getSkillManager().getMaxLevel(Skill.INVENTION) < 80) {
                player.getPacketSender()
                        .sendMessage("You need a Invention Level of at-least @blu@80 Invention@bla@ to view this Tier.");
                return false;
            }
                openInterface(Upgradeables.UpgradeType.TIER_5);
                return true;
            case -3292:
            case 30872:
                if (player.getSkillManager().getMaxLevel(Skill.INVENTION) < 90) {
                player.getPacketSender()
                        .sendMessage("You need a Invention Level of at-least @blu@90 Invention@bla@ to view this Tier.");
                return false;
            }
                openInterface(Upgradeables.UpgradeType.TIER_6);
                return true;
            case -3285:
            case 30873:
                if (player.getSkillManager().getMaxLevel(Skill.INVENTION) < 119) {
                    player.getPacketSender()
                            .sendMessage("You need a Invention Level of at-least @blu@120 Invention@bla@ to view this Tier.");
                    return false;
                }
                player.getCustomCombiner().open();
                return true;
        }

        return false;
    }


    public void handleUpgrade(boolean all) {

        if (!player.getClickDelay().elapsed(1200)) {
            player.getPacketSender().sendMessage("<shad=1>@red@Please wait a few seconds before trying to upgrade again.");
            return;
        }
        player.getClickDelay().reset();
        if (player.getInventory().getAmount(selectedUpgrade.getRequired().getId()) > 2500) {
            player.sendMessage("You can only upgrade 5,000 of an item at one time, try banking some first!");
            return;
        }

        if (selectedUpgrade == null) {
            player.sendMessage("Choose an item to upgrade.");
            return;
        }
        Arrays.stream(Upgradeables.values()).forEach(val -> {
            if (val.getRequired().getId() == selectedUpgrade.getRequired().getId()) {
                if (getRestrictions(val, all)) {
                    ItemDefinition definition = ItemDefinition.forId(val.getRequired().getId() + 1);
                    boolean noted = false;
                    if (all) {
                        if (definition.isNoted() && definition.isStackable()) {
                            String name = definition.getName();
                            definition = ItemDefinition.forId(val.getRequired().getId());
                            String originalName = definition.getName();
                            noted = name.equals(originalName);
                        }
                        int amount = player.getInventory().getAmount(selectedUpgrade.getRequired().getId()) +
                                (noted ? player.getInventory().getAmount(val.getRequired().getId() + 1) : 0);
                        if (val.getReward().getDefinition ().getId () == 15004 || val.getReward().getDefinition ().getId () == 14999 ||
                        val.getReward().getDefinition ().getId () == 23253)
                            amount = (amount / 2);

                        int failed = 0, success = 0;
                        for (int i = 0; i < amount; i++) {
                            if (player.getInventory().contains(ItemDefinition.UPGRADE_TOKEN_ID,
                                    val.getCost())) {
                                if (noted) {
                                    if (player.getInventory().contains(val.getRequired().getId())) {
                                        player.getInventory().delete(val.getRequired());
                                    } else if (player.getInventory().contains(val.getRequired().getId() + 1)) {
                                        player.getInventory().delete(new Item(val.getRequired().getId() + 1,
                                                val.getRequired().getAmount()));
                                    }
                                } else {
                                    player.getInventory().delete(val.getRequired());
                                }
                                player.getInventory().delete(ItemDefinition.UPGRADE_TOKEN_ID,
                                        val.getCost());

                                StarterTasks.doProgress(player, StarterTasks.StarterTask.UPGRADE_ITEMS, success);
                                player.getAchievementTracker().progress(AchievementData.UPGRADE_A_ITEM, 1);
                              
                                boolean random =  Misc.getRandomDouble(99) < getBoost(val.getSuccessRate());
                                if (random) {
                                    player.getAchievementTracker().progress(AchievementData.UPGRADE_2_TIMES, 1);
                                    player.getSkillManager().addExperience(Skill.INVENTION, 1000);
                                    success++;
                                    if (noted) {
                                        if (player.getGameMode().isUltIronman()) {
                                            player.getUimBank().deposit(val.getReward().getId(),val.getReward().getAmount());
                                            player.sendMessage("Your items have been added to your collection box.");
                                        } else if (!player.getGameMode().isUltIronman()) {
                                            player.getBank(Bank.getTabForItem(player, val.getReward().getId())).add(val.getReward(), false);
                                            player.sendMessage("Your items have been banked.");
                                        }
                                    } else {
                                        player.getInventory().add(val.getReward());
                                    }
                                    if (val.isRare()) {
                                        String msg = "@blu@<img=5>[UPGRADE]<img=5>@red@ " + player.getUsername()
                                                + " Has successfully upgraded his "
                                                + val.getRequired().getDefinition().getName() + " to "
                                                + val.getReward().getDefinition().getName();
                                        World.sendMessage(msg);
                                    }
                                    PlayerLogs.logUpgrades(player.getUsername(), "UPGRADED : " + val.getRequired().getDefinition().getName()
                                            + ", id: " + val.getRequired().getId() + ", amount: " + val.getRequired().getAmount() + " --into-- " +
                                            val.getReward().getDefinition().getName() + ", id: " + val.getReward().getId() + ", amount: " + val.getReward().getAmount());

                                } else {
                                    failed++;
                                }
                            } else {
                                break;
                            }
                        }
                        player.getPacketSender().sendMessage("You successfully upgraded " + success
                                + " items and failed to upgrade " + failed + " items.");
                    } else {
                        if (definition.isNoted() && definition.isStackable()) {
                            String name = definition.getName();
                            definition = ItemDefinition.forId(val.getRequired().getId());
                            String originalName = definition.getName();
                            noted = name.equals(originalName);
                        }
                        if (noted) {
                            if (player.getInventory().contains(val.getRequired().getId())) {
                                player.getInventory().delete(val.getRequired());
                            } else if (player.getInventory().contains(val.getRequired().getId() + 1)) {
                                player.getInventory().delete(new Item(val.getRequired().getId() + 1,
                                        val.getRequired().getAmount()));
                            }
                        } else {
                            player.getInventory().delete(val.getRequired());
                        }
                        player.getInventory().delete(ItemDefinition.UPGRADE_TOKEN_ID, val.getCost());

                        TimerTask task = new TimerTask() {
                            int tick = 0;

                            @Override
                            public void run() {
                                if (tick == 0) {
                                    player.getPacketSender().sendMessage("You try to upgrade....");
                                    player.getAchievementTracker().progress(AchievementData.UPGRADE_A_ITEM, 1);
                                } else if (tick == 2) {
                                    boolean success =  Misc.getRandomDouble(99) < getBoost(val.getSuccessRate());
                                    if (success) {
                                        player.getSkillManager().addExperience(Skill.INVENTION, 1000);
                                        player.getPacketSender().sendMessage("You successfully upgraded your item!");
                                        player.getAchievementTracker().progress(AchievementData.UPGRADE_2_TIMES, 1);
                                        player.getInventory().add(val.getReward());
                                        if (val.isRare()) {
                                            String msg = "@blu@<img=5>Upgrade:<img=5>@red@ " + player.getUsername()
                                                    + " Has successfully upgraded his "
                                                    + val.getRequired().getDefinition().getName() + " to "
                                                    + val.getReward().getDefinition().getName();
                                            World.sendMessage(msg);
                                        }

                                    } else {
                                        player.getPacketSender().sendMessage("You failed to upgrade!");
                                    }
                                    cancel();
                                }
                                tick++;
                            }

                        };

                        Timer timer = new Timer();
                        timer.schedule(task, 500, 500);
                    }
                }
            }
        });
    }
    
    public double getBoost(double chance){
        double percentBoost = 0D;
        if (player.getAmountDonated() >= Store.ZENYTE_DONATION_AMOUNT ||
                player.getAmountDonated() >= Store.TANZANITE_DONATION_AMOUNT ||
                player.getRights().equals(PlayerRights.YOUTUBER)) {
            percentBoost += 15;
        } else
            if (player.getAmountDonated() >= Store.ONYX_DONATION_AMOUNT) {
            percentBoost += 10;
        } else
            if (player.getAmountDonated() >= Store.DIAMOND_DONATION_AMOUNT) {
            percentBoost += 7;
        } else
            if (player.getAmountDonated() >= Store.RUBY_DONATION_AMOUNT) {
            percentBoost += 5;
        }

        // creator set:
        if (player.getEquipment().contains(23127))
            percentBoost += 2;
        if (player.getEquipment().contains(23128))
            percentBoost += 2;
        if (player.getEquipment().contains(23129))
            percentBoost += 2;
        if (player.getEquipment().contains(23130))
            percentBoost += 1;
        if (player.getEquipment().contains(23131))
            percentBoost += 1;
        if (player.getEquipment().contains(23132))
            percentBoost += 1;
        if (player.getEquipment().contains(23133))
            percentBoost += 1;
        //
/*
        if(!player.isInsideRaids()) {
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.RAMMUS_PET.npcId) {
                percentBoost += 20;
            }
        }
        if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                && player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.BLOOD_DEMON.npcId) {
            percentBoost += 25;
        }
*/

        double multiplier = 1 + (percentBoost / 100D);

        chance *= multiplier;

        return chance;
    }

    private boolean getRestrictions(Upgradeables data, boolean all) {
        ItemDefinition definition = ItemDefinition.forId(data.getRequired().getId() + 1);
        boolean noted = false;
        if (definition.isNoted() && definition.isStackable()) {
            String name = definition.getName();
            definition = ItemDefinition.forId(data.getRequired().getId());
            String originalName = definition.getName();
            noted = name.equals(originalName);
        }
        if (noted && player.getInventory().contains(data.getRequired().getId() + 1)) {
            int amount = all ? player.getInventory().getAmount(data.getRequired().getId() + 1) : 1;
            if (!player.getInventory().contains(data.getRequired().getId() + 1) && !player.getInventory().contains(ItemDefinition.UPGRADE_TOKEN_ID, amount *
                            data.getCost())) {
                player.getPacketSender().sendMessage("You do not have the required items!");
                return false;
            }
        } else {
            if (!player.getInventory().contains(data.getRequired().getId()) ||
                    !player.getInventory().contains(ItemDefinition.UPGRADE_TOKEN_ID,  data.getCost())) {
                player.getPacketSender().sendMessage("You do not have the required items!");
                return false;
            }
        }
        return true;
    }

    public void handleItemAction(int slot) {
        if (upgradeablesArrayList != null && upgradeablesArrayList.get(slot) != null) {
            showUpgrade(upgradeablesArrayList.get(slot));
        }
    }


    public void showUpgrade(Upgradeables upgrade) {

        selectedUpgrade = upgrade;

        player.getPacketSender().sendItemOnInterface(62210, upgrade.getReward());
        player.getPacketSender().sendString(62231, "Tokens req: @whi@" + Misc.formatNumber(upgrade.getCost()));
        player.getPacketSender().sendString(62234, "Success rate: @whi@" + Misc.format(upgrade.getSuccessRate()) + "%");

    }

        public void openInterface(Upgradeables.UpgradeType type) {
            player.getPacketSender().sendConfig(5334, type.ordinal());


            player.getPacketSender().sendItemOnInterface(62210, -1, 1);
            player.getPacketSender().sendString(62231, "Tokens req: @whi@---");
            player.getPacketSender().sendString(62234, "Success rate: @whi@---");

            upgradeablesArrayList = Upgradeables.getForType(type);
            for (int i = 0; i < 50; i++) {
                if (upgradeablesArrayList.size() > i) {
                    player.getPacketSender().sendItemOnInterface(62209,
                            upgradeablesArrayList.get(i).getRequired().getId(), i, upgradeablesArrayList.get(i).getRequired().getAmount());
                } else {
                    player.getPacketSender().sendItemOnInterface(62209, -1, i, 1);
                }
            }

            if (selectedUpgrade != null) {
                showUpgrade (selectedUpgrade);
            } else
            selectedUpgrade = null;

            player.getPacketSender().sendInterface(62200);

        }
    }
