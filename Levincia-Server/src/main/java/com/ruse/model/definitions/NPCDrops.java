package com.ruse.model.definitions;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ruse.model.*;
import com.ruse.model.Locations.Location;
import com.ruse.model.container.impl.Bank;
import com.ruse.model.container.impl.Equipment;
import com.ruse.util.JsonLoader;
import com.ruse.util.Misc;
import com.ruse.util.RandomUtility;
import com.ruse.world.World;
import com.ruse.world.content.*;
import com.ruse.world.content.DropLog.DropLogEntry;
import com.ruse.world.content.clan.ClanChatManager;
import com.ruse.world.content.cluescrolls.OLD_ClueScrolls;
import com.ruse.world.content.combat.CombatBuilder.CombatDamageCache;
import com.ruse.world.content.combat.CombatFactory;
import com.ruse.world.content.minigames.impl.TreasureHunter;
import com.ruse.world.content.minigames.impl.VaultOfWar;
import com.ruse.world.content.skill.impl.prayer.BonesData;
import com.ruse.world.entity.impl.GroundItemManager;
import com.ruse.world.entity.impl.mini.MiniPlayer;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;
import lombok.Getter;
import lombok.Setter;

import java.security.SecureRandom;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.ruse.world.content.osrscollectionlog.LogType.*;


/**
 * Controls the npc drops
 *
 * @author 2012 <http://www.rune-server.org/members/dexter+morgan/>, Gabbe &
 * Samy
 */
public class NPCDrops {
    public static final HashSet<Integer> globalNpcs = new HashSet<Integer>(Arrays.asList(
            3779, 8013,187,9017,3305,4972,3830,587,9318,9319,9312,492
    ));
    public static final HashSet<Integer> multiKillNpcs = new HashSet<Integer>(Arrays.asList(
            TreasureHunter.NPC_1, TreasureHunter.NPC_2,
            TreasureHunter.NPC_3, TreasureHunter.NPC_4));
    private static final List<NpcDropItem> constantDrops = new ArrayList<>();
    private static final List<NpcDropItem> potentialDrops = new ArrayList<>();
    private static final List<NpcDropItem> finalDropList = new ArrayList<>();

    private static Map<Integer, NPCDrops> dropControllers = new HashMap<Integer, NPCDrops>();

    public static boolean Misc1 = (Misc.getRandom (2) == 1);
    private int[] npcIds;

    private NpcDropItem[] drops;

    public static JsonLoader parseDrops() {

        return new JsonLoader() {

            @Override
            public void load(JsonObject reader, Gson builder) {
                int[] npcIds = builder.fromJson(reader.get("npcIds"), int[].class);
                NpcDropItem[] drops = builder.fromJson(reader.get("drops"), NpcDropItem[].class);

                NPCDrops d = new NPCDrops();
                d.npcIds = npcIds;
                d.drops = drops;
                for (int id : npcIds) {
                    dropControllers.put(id, d);
                }
            }

            @Override
            public String filePath() {
                return "./data/def/json/drops.json";
            }
        };
    }

    public static NPCDrops forId(int id) {
        return dropControllers.get(id);
    }

    public static Map<Integer, NPCDrops> getDrops() {
        return dropControllers;
    }

    public static void getDropTable(Player p, int npcId) {
        NPCDrops drops = NPCDrops.forId(npcId);
        if (drops == null) {
            p.getPacketSender().sendMessage("No drops were found. [Error 194510]");
            return;
        }
        for (int i = 0; i < drops.getDropList().length; i++) {
            if (drops.getDropList()[i].getItem().getId() <= 0
                    || drops.getDropList()[i].getItem().getId() > ItemDefinition.getMaxAmountOfItems()
                    || drops.getDropList()[i].getItem().getAmount() <= 0) {
                continue;
            }

            final int dropChance = drops.getDropList()[i].getChance();
            p.getPacketSender().sendMessage(drops.getDropList()[i].getItem().getAmount() + "x "
                    + ItemDefinition.forId(drops.getDropList()[i].getItem().getId()).getName() + " at a chance of 1/"
                    + dropChance + ".");
        }
    }

    public static void dropItemsMultiKill(NPC npc) {
        // // System.out.println("Multi dropping for " + npc.getId() + " " +
        // npc.getDefinition().getName());
        if (npc.getCombatBuilder().getDamageMap().isEmpty()) {
            // System.out.println("return 1");
            return;
        }

        Map<Player, Integer> killers = new HashMap<>();

        for (Entry<Player, CombatDamageCache> entry : npc.getCombatBuilder().getDamageMap().entrySet()) {

            // // System.out.println("here 1");
            if (entry == null) {
                continue;
            }
            // // System.out.println("here 2");

            long timeout = entry.getValue().getStopwatch().elapsed();

            if (timeout > CombatFactory.DAMAGE_CACHE_TIMEOUT) {
                continue;
            }
            // // System.out.println("here 3");

            Player player = entry.getKey();

            if (player.getConstitution() <= 0 || !player.isRegistered()) {
                continue;
            }
            // // System.out.println("here 4");

            killers.put(player, entry.getValue().getDamage());

        }

        // npc.getCombatBuilder().getDamageMap().clear();

        List<Entry<Player, Integer>> result = sortEntries(killers);
        int count = 0;// brb

        for (Entry<Player, Integer> entry : result) {

            Player killer = entry.getKey();
            int damage = entry.getValue();

            handleDrops(killer, npc);

           /* if (npc.getId() >= TreasureHunter.NPC_1 && npc.getId() <= TreasureHunter.NPC_4 && npc.getPosition().getRegionId() == 8014) {
                TreasureHunter.addKey(killer, npc);
            }*/
            // // System.out.println("Multi dropping for " + killer.getUsername() + " dealt " +
            // damage);

            if (++count >= 10) {
                break;
            }

        }
    }

    static <K, V extends Comparable<? super V>> List<Entry<K, V>> sortEntries(Map<K, V> map) {

        List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K, V>>(map.entrySet());

        Collections.sort(sortedEntries, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        return sortedEntries;

    }

    public static void dropClue(Player player, Position pos, NPC npc) {
        boolean cont = true;
        for (int q = 0; q < player.getBanks().length; q++) {
            if (player.getBank(q).containsAny(OLD_ClueScrolls.hardClueId)) {
                cont = false;
            }
        }
        if (player.getInventory().containsAny(OLD_ClueScrolls.hardClueId)) {
            cont = false;
        }
        if (cont) {
            if (npc.getId() == 2007 || npc.getId() == 2042 || npc.getId() == 2043 || npc.getId() == 2044) {
                pos = player.getPosition().copy();
            }
            int rand = Misc.getRandom(100);
            if (rand == 1 || (rand == 2 && player.checkItem(Equipment.RING_SLOT, 2572))) {
                if (rand == 2) {
                    player.getPacketSender()
                            .sendMessage("@mag@<shad=0><img=11> Your Ring of Wealth activates, spawning a clue!");
                } else {
                    player.getPacketSender().sendMessage("@red@<shad=0><img=5> A clue scroll has appeared!");
                }
                GroundItemManager.spawnGroundItem(player, new GroundItem(new Item(
                        OLD_ClueScrolls.values()[Misc.getRandom((int) (OLD_ClueScrolls.values().length - 1))].getClueId()), pos,
                        player.getUsername(), false, 150, true, 200));
            }
        }
    }

    public static void dropPetFragment(Player player, Position pos, NPC npc) {
            int reward = 19000;
            int rand = Misc.getRandom(40);
            if (rand == 1) {
                if (player.dropMessageToggle)
                    player.getPacketSender().sendMessage("X1 Pet Fragment has been sent to your inventory.");
                player.getInventory().add(reward, 1);
                }
            }
    public static void dropInstanceToken(Player player, Position pos, NPC npc) {
        int reward = 4278;
        int rand = Misc.getRandom(50);
        if (rand == 1) {
            if (player.dropMessageToggle)
            player.getPacketSender().sendMessage("X1 Instance token has been sent to your inventory.");
            player.getInventory().add(reward, 1);
        }
    }

    public static void handleDrops(Player player, NPC npc) {
        handleDrops(player, npc, 1);
    }

    public static void handleDrops(Player player, NPC npc, double divider) {
        int npcId = npc.getId();

        NPCDrops dropt = getDrops().get(npcId);
        if(dropt == null) {
            return;
        }
        NpcDropItem[] drops = dropt.getDropList();

        if (drops == null)
            return;

        final Position npcPos = npc.getPosition().copy();
        dropPetFragment(player,npcPos,npc);
        dropInstanceToken(player,npcPos,npc);
        HashMap<Double, ArrayList<NpcDropItem>> dropRates = new HashMap<>();

        for (NpcDropItem drop : drops) {
            if (drop == null)
                continue;
            double divisor = drop.getChance();
            if (drop.getChance() == 1 && drop.getCount()[0] != -1) {
                constantDrops.add(drop);
            } else {
                if (npc.getId() == VaultOfWar.AVATAR_ID) {
                } else {
                    if (!dropRates.containsKey(divisor)) {
                        ArrayList<NpcDropItem> items = new ArrayList<>();
                        items.add(drop);
                        dropRates.put(divisor, items);
                    } else {
                        dropRates.get(divisor).add(drop);
                    }
                }
            }
        }
        for (double dropRate : dropRates.keySet()) {
            double roll_chance = new SecureRandom().nextDouble() / divider;

            double divide = (CustomDropUtils.drBonus(player, npc.getId()) > 0 ? (CustomDropUtils.drBonus(player, npc.getId()) / 70.0) + 1 : 1);

            double required = 1 / dropRate;
            if (roll_chance / divide <= required) {
                potentialDrops.add(dropRates.get(dropRate).get(Misc.getRandom(dropRates.get(dropRate).size() - 1)));
            }
        }
        if (!constantDrops.isEmpty()) {
            finalDropList.addAll(constantDrops);
        }
        if (!potentialDrops.isEmpty()) {
            finalDropList.add(potentialDrops.get(Misc.randomMinusOne(potentialDrops.size())));
        }
        if (!finalDropList.isEmpty()) {
            sendDrop(player, npc);
        }

        if (npc.getId() == 8013) {
            if (player.lastVoteTime >= System.currentTimeMillis() - 86400000) {
                player.sendMessage("You received Double rewards because you voted in the last 12 hours!");
            }
        }


    }

    public static void sendDrop(Player player, NPC npc) {

        List<NpcDropItem> list = finalDropList;
        if (list == null) {
            System.err.println("List of UniversalDrops is null for " + npc);
            return;
        }

        Position pos = npc.getPosition().copy();

        if (player instanceof MiniPlayer) {
            finalDropList.clear();
            constantDrops.clear();
            potentialDrops.clear();
            return;
        }
        final boolean goGlobal = player.getPosition().getZ() >= 0 && player.getPosition().getZ() < 4;

        for (NpcDropItem drop : list) {
            int[] count = drop.getCount();
            int amount = count[0];

            if (count.length > 1) {
                if (count[0] == count[1])
                    amount = 1;
                else if (count[1] - count[0] > 0)
                    amount = Misc.getRandom(count[1] - count[0]) + count[0];
            }

            Item item = new Item(drop.getId(), amount);
            int itemId = item.getId();

            if (npc.getId() == 2007 || npc.getId() == 2042 || npc.getId() == 2043 || npc.getId() == 2044
                    || npc.getId() == 4972 || npc.getId() == 9017 || npc.getId() == 3305) {
                pos = player.getPosition().copy();
            }

            if (item.getId() == 22120) {
                boolean iron = player.getGameMode().equals(GameMode.IRONMAN);
                boolean ultimateIron = player.getGameMode().equals(GameMode.ULTIMATE_IRONMAN);
                boolean groupIron = player.getGameMode().equals(GameMode.GROUP_IRONMAN);

                if (iron) {
                    item.setId(22120);
                } else if (ultimateIron) {
                    item.setId(22119);
                } else if (groupIron) {
                    item.setId(22118);
                }
            }
            if ((player.getInventory().contains(3323) || player.getInventory().contains(18337)
                    || (player.getSkillManager().skillCape(Skill.PRAYER) && player.getBonecrushEffect()))
                    && BonesData.forId(item.getId()) != null) {
                player.getPacketSender().sendGlobalGraphic(new Graphic(777), pos);
                if (player.getRights().isMember()) {
                    player.getSkillManager().addExperience(Skill.PRAYER, BonesData.forId(item.getId()).getBuryingXP() * 2);
                    continue;
                } else {
                    player.getSkillManager().addExperience(Skill.PRAYER, BonesData.forId(item.getId()).getBuryingXP());
                    continue;
                }
            }

            boolean ccAnnounce = false;
            if (Location.inMulti(player)) {
                if (player.getCurrentClanChat() != null && player.getCurrentClanChat().getLootShare()) {
                    CopyOnWriteArrayList<Player> playerList = new CopyOnWriteArrayList<Player>();
                    for (Player member : player.getCurrentClanChat().getMembers()) {
                        if (member != null) {
                            if (member.getPosition().isWithinDistance(player.getPosition())) {
                                playerList.add(member);
                            }
                        }
                    }
                    if (playerList.size() > 0) {
                        player = playerList.get(Misc.getRandom(playerList.size() - 1));
                        if (player == null || player.getCurrentClanChat() == null
                                || player.getCurrentClanChat() != player.getCurrentClanChat()) {
                            player = player;
                        }
                        ccAnnounce = true;
                    }
                }
            }

            if (npc.getId() == 8013) {
                if (player.lastVoteTime >= System.currentTimeMillis() - 86400000) {
                    item.setAmount(item.getAmount() * 2);
                }
            }

            if (npc.getId() == 8013 && player.isVoteBossTransform() && Misc1 == true) {
                item.setAmount(item.getAmount() * 2);
            }
            if (npc.getId() == 4972 && player.isDragonKingTransform() && Misc1 == true) {
                item.setAmount(item.getAmount() * 2);
            }
            if (npc.getId() == 9319 && player.isGolemTransform() && Misc1 == true) {
                item.setAmount(item.getAmount() * 2);
            }
            if (npc.getId() == 3830 && player.isVozzathTransform() && Misc1 == true) {
                item.setAmount(item.getAmount() * 2);
            }
            if (npc.getId() == 9017 && player.isNightmareTransform() && Misc1 == true) {
                item.setAmount(item.getAmount() * 2);
            }

            if (npc.getId() == 9839 && drop.isAnnounce() || drop.getChance() >= 2000) {
                player.getDailyTaskManager().submitProgressToIdentifier(30, 1);
            }
            if (npc.getId() == 9813 && drop.isAnnounce() || drop.getChance() >= 2000) {
                player.getDailyTaskManager().submitProgressToIdentifier(36, 1);
            }
            if (npc.getId() == 4677 && drop.isAnnounce() || drop.getChance() >= 2000) {
                player.getDailyTaskManager().submitProgressToIdentifier(48, 1);
            }
            int kills = KillsTracker.getTotalKillsForNpc(npc.getId(), player);
            if (drop.isAnnounce() || drop.getChance() >= 2000 && item.getId() != 12855 && item.getId() != 10025
                    && item.getId() != 5022 && item.getId() != 1050 && item.getId() != 19000
            || npc.getId() == 8013 && drop.getChance() >= 20||
            npc.getId() == 187 && drop.getChance() >= 100 ||
            npc.getId() == 3779 && drop.getChance() >= 1000||
            npc.getId() == 9017 && drop.getChance() >= 100 ||
            npc.getId() == 4972 && drop.getChance() >= 100 ||
            npc.getId() == 9318 && drop.getChance() >= 100 ||
            npc.getId() == 9319 && drop.getChance() >= 50 ||
            npc.getId() == 9319 && drop.getChance() >= 50 ||
            npc.getId() == 9312 && drop.getChance() >= 5 ||
            npc.getId() == 3830 && drop.getChance() >= 5 ||
            npc.getId() == 3305 && drop.getChance() >= 10) {
                String itemName = item.getDefinition().getName();
                String itemMessage = "x" + amount + " " + itemName;
                String npcName = Misc.formatText(npc.getDefinition().getName());
                player.getDailyTaskManager().submitProgressToIdentifier(40, 1);
                String message = "<img=5><shad><col=ff4f4f>[</col>@cya@DROP<col=ff4f4f>]</col>@cya@ " + player.getUsername()
                        + " has received <col=ff4f4f>" + itemMessage + "@cya@ from <col=ff4f4f>" + npcName + "@cya@ -" + "<col=ff4f4f> KC: " + kills;
                World.sendMessage(message);

                if (ccAnnounce) {
                    ClanChatManager.sendMessage(player.getCurrentClanChat(),
                            "<col=16777215>[<col=255>Lootshare<col=16777215>]<col=3300CC> " + player.getUsername()
                                    + " received " + itemMessage + " from " + npcName + "!");
                }

                PlayerLogs.log(player.getUsername(),
                        "" + player.getUsername() + " received " + itemMessage + " from " + npcName + "!");

                PlayerLogs.logNpcDrops(player.getUsername(), "Player received drop: " + itemMessage
                        + ", id: " + itemId + ", amount: " + amount + ", from: " + npcName);
                        }

            if (CustomDropUtils.getDoubleDropChance(player, npc.getId()) > 0) {
                int chance = RandomUtility.exclusiveRandom(0, 100);
                if (chance <= CustomDropUtils.getDoubleDropChance(player, npc.getId())) {
                    player.performGraphic(new Graphic(436));
                    if (player.getGameMode() == GameMode.ULTIMATE_IRONMAN) {
                        player.getInventory().add(new Item(item.getId(), item.getAmount()));
                        player.getInventory().add(new Item(item.getId(), item.getAmount()));
                    } else {
                        int tab = Bank.getTabForItem(player, item.getId());
                        if (item.getId() == ItemDefinition.COIN_ID || item.getId() == ItemDefinition.MILL_ID) {
                            player.getInventory().add(item.getId(), item.getAmount());
                            player.getInventory().add(item.getId(), item.getAmount());
                        } else {
					if ( player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 4446
                                    || player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 18818
                                    || player.getEquipment().getItems()[Equipment.AMULET_SLOT].getId() == 19886
                                    || player.getEquipment().getItems()[Equipment.AMULET_SLOT].getId() == 23258
                                    || player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 22005
                                    || player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 23231
                                    || player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 23359
                                    || player.getEquipment().getItems()[Equipment.AMULET_SLOT].getId() == 23230
                                    || player.getEquipment().getItems()[Equipment.HANDS_SLOT].getId() == 23232
                                    || player.getEquipment().getItems()[Equipment.AMULET_SLOT].getId() == 23233
                                    || player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 23234
                                    || player.getEquipment().getItems()[Equipment.HANDS_SLOT].getId() == 23235
                                    || player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 23280
                                    || player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 10827
                                    || player.getEquipment().getItems()[Equipment.AMULET_SLOT].getId() == 23293
                                    || player.getEquipment().getItems()[Equipment.AMULET_SLOT].getId() == 19888
                                    || player.getEquipment().getItems()[Equipment.AMULET_SLOT].getId() == 18888
                                    || player.getEquipment().getItems()[Equipment.AMULET_SLOT].getId() == 774
                                    || player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 22119
                                    || player.getEquipment().getItems()[Equipment.HANDS_SLOT].getId() == 22120
                                    || player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 18823
                                    ||  player.getEquipment().getItems()[Equipment.AMULET_SLOT].getId() == 23090 ) {
                        if (player.getEquipment().contains(23090)) {
                            ItemDegrading.handleItemDegrading(player, ItemDegrading.DegradingItem.STARTER_COLLECTOR);
                            int startercharges = (ItemDegrading.maxStarterCollects - player.getStarterCharges());
                            String charges = String.valueOf(player.getStarterCharges());
                            if (charges.endsWith(String.valueOf(0)))
                                player.getPacketSender().sendMessage("You have " + startercharges + " starter amulet "
                                        + (startercharges == 1 ? "charge" : "charges") + " remaining.");
                        }

                                if (player.getInventory().canHold(item)) {
                                    player.getInventory().add(item);
                                    player.getInventory().add(item);
                                    if (player.dropMessageToggle)
                                        player.sendMessage("x" + item.getAmount() + " "
                                                + item.getDefinition().getName() + " has been sent to your inventory.");
                                } else {
                                    player.depositItemBank(item);
                                    player.depositItemBank(item);
                                    if (player.dropMessageToggle)
                                        player.sendMessage("x" + item.getAmount() + " "
                                                + item.getDefinition().getName() + " has been sent to your bank.");
                                }
                            } else {
                                GroundItemManager.spawnGroundItem(player,
                                        new GroundItem(item, pos, player.getUsername(), false, 150, goGlobal, 200));
                                GroundItemManager.spawnGroundItem(player,
                                        new GroundItem(item, pos, player.getUsername(), false, 150, goGlobal, 200));
                            }
                        }
                        if (player.dropMessageToggle)
                            player.sendMessage("You received x2 of your drop.");

                    }


                    DropLog.submit(player, new DropLogEntry(itemId, item.getAmount(), drop.isAnnounce()));
                    DropLog.submit(player, new DropLogEntry(itemId, item.getAmount(), drop.isAnnounce()));
                    MONSTERS.log(player, npc.getId(), item);
                    ZONES.log(player, npc.getId(), item);
                    BOSSES.log(player, npc.getId(), item);
                    continue;
                }
            }
            if ( player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 4446
                    || player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 18818
                    || player.getEquipment().getItems()[Equipment.AMULET_SLOT].getId() == 19886
                    || player.getEquipment().getItems()[Equipment.AMULET_SLOT].getId() == 23258
                    || player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 22005
                    || player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 23359
                    || player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 23231
                    || player.getEquipment().getItems()[Equipment.AMULET_SLOT].getId() == 23230
                    || player.getEquipment().getItems()[Equipment.HANDS_SLOT].getId() == 23232
                    || player.getEquipment().getItems()[Equipment.AMULET_SLOT].getId() == 23233
                    || player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 23234
                    || player.getEquipment().getItems()[Equipment.HANDS_SLOT].getId() == 23235
                    || player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 23280
                    || player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 10827
                    || player.getEquipment().getItems()[Equipment.AMULET_SLOT].getId() == 23293
                    || player.getEquipment().getItems()[Equipment.AMULET_SLOT].getId() == 19888
                    || player.getEquipment().getItems()[Equipment.AMULET_SLOT].getId() == 18888
                    || player.getEquipment().getItems()[Equipment.AMULET_SLOT].getId() == 774
                    || player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 22119
                    || player.getEquipment().getItems()[Equipment.HANDS_SLOT].getId() == 22120
                    || player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 18823
                    ||  player.getEquipment().getItems()[Equipment.AMULET_SLOT].getId() == 23090
                    || (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
                    && (!player.isInsideRaids()))) {
                if (player.getEquipment().contains(23090)) {
                    ItemDegrading.handleItemDegrading(player, ItemDegrading.DegradingItem.STARTER_COLLECTOR);
                    int startercharges = (ItemDegrading.maxStarterCollects - player.getStarterCharges());
                        String charges = String.valueOf(player.getStarterCharges());
                    if (charges.endsWith(String.valueOf(0)))
                    player.getPacketSender().sendMessage("You have " + startercharges + " starter amulet "
                            + (startercharges == 1 ? "charge" : "charges") + " remaining.");
                }
                if (player.getGameMode() != GameMode.ULTIMATE_IRONMAN) {
                    player.performGraphic(new Graphic(385));
                    if (player.getInventory().canHold(item)) {
                        player.getInventory().add(item);
                        if (player.dropMessageToggle)
                            player.sendMessage("x" + item.getAmount() + " "
                                    + item.getDefinition().getName() + " has been sent to your inventory.");
                    } else {
                        player.depositItemBank(item);
                        if (player.dropMessageToggle)
                            player.sendMessage("x" + item.getAmount() + " "
                                    + item.getDefinition().getName() + " has been sent to your bank.");
                    }
                } else {
                    player.performGraphic(new Graphic(385));
                    player.getInventory().add(new Item(item.getId(), item.getAmount()));
                    DropLog.submit(player, new DropLogEntry(itemId, item.getAmount(), drop.isAnnounce()));
                }
            } else {
                GroundItemManager.spawnGroundItem(player,
                        new GroundItem(item, pos, player.getUsername(), false, 150, goGlobal, 200));
                DropLog.submit(player, new DropLogEntry(itemId, item.getAmount(), drop.isAnnounce()));
            }

            MONSTERS.log(player, npc.getId(), item);

            ZONES.log(player, npc.getId(), item);

            BOSSES.log(player, npc.getId(), item);

        //    new CollectionEntry(npc.getId(), item.getId(), item.getAmount()).submit(player);
        }


        finalDropList.clear();
        constantDrops.clear();
        potentialDrops.clear();

    }

    public NpcDropItem[] getDropList() {
        return drops;
    }

    public int[] getNpcIds() {
        return npcIds;
    }

    public static class NpcDropItem {

        @Getter
        private final int id;

        @Getter
        private final int[] count;

        @Getter
        @Setter
        private int chance;

        @Getter
        @Setter
        private boolean announce;

        public NpcDropItem(int id, int[] count, int chance) {
            this.id = id;
            this.count = count;
            this.chance = chance;
            this.announce = false;
        }

        public NpcDropItem(int id, int[] count, int chance, boolean announce) {
            this.id = id;
            this.count = count;
            this.chance = chance;
            this.announce = announce;
        }

        public Item getItem() {
            int amount = 0;
            for (int i = 0; i < count.length; i++)
                amount += count[i];
            if (amount > count[0])
                amount = count[0] + Misc.getRandom(count[1]);
            return new Item(id, amount);
        }

        public Item getMaxAmount() {
            int amount = 0;
            for (int i = 0; i < count.length; i++)
                amount += count[i];
            if (amount > count[0])
                amount = count[0] + Misc.getRandom(count[1]);
            return new Item(id, amount);
        }
    }
}