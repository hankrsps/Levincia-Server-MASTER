package com.ruse.world.content;

import com.ruse.model.Item;
import com.ruse.model.PlayerRights;
import com.ruse.model.Position;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.model.definitions.NPCDrops;
import com.ruse.world.World;
import com.ruse.world.content.boxes.Raids1;
import com.ruse.world.content.boxes.Starter;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.minigames.impl.HallsOfAmmo;
import com.ruse.world.content.minigames.impl.PyramidOutbreak;
import com.ruse.world.content.minigames.impl.TreasureHunter;
import com.ruse.world.content.progressionzone.ProgressionZone;
import com.ruse.world.content.skill.impl.old_dungeoneering.Dungeoneering;
import com.ruse.world.content.teleport.TeleportInterfaceHandler;
import com.ruse.world.content.transportation.TeleportHandler;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

public class TeleportInterface {

    public static void resetOldData(Player player) {
        player.setCurrentTeleportTab(0);
        player.setCurrentTeleportClickIndex(0);
    }


    private static void clearData(Player player) {
        for (int i = 122302; i < 122400; i += 3) {
            player.getPacketSender().sendString(i, "");
        }
    }

    public static boolean handleButton(Player player, int buttonID) {

        switch (buttonID) {
            case 1716:
                /*if (!player.isOpenedTeleports()) {
                player.setOpenedTeleports(true);
                TeleportInterface.sendMonsterData(player, TeleportInterface.Monsters.values()[0]);
                TeleportInterface.sendMonsterTab(player);
            } else {
                player.getPacketSender().sendInterface(122000);
            }*/
            case 11004:
            case 71517:
            case 77147:
            case 88147:
                if (!player.busy() && !player.getCombatBuilder().isBeingAttacked()
                        && !Dungeoneering.doingOldDungeoneering(player)) {
                    player.getSkillManager().stopSkilling();
                    new TeleportInterfaceHandler(player).open();
                    return true;
                } else {
                    player.getPacketSender().sendMessage("You cannot open this right now.");
                    return false;
                }
                
            case 122005:
            case 5519:
                TeleportInterface.sendMonsterTab(player);
                return true;
            case 122006:
            case 11008:
                TeleportInterface.sendBossTab(player);
                return true;
            case 122007:
            case 11011:
                TeleportInterface.sendMinigamesTab(player);
                return true;
            case 122008:
            case 11014:
                TeleportInterface.sendDungeonsTab(player);
                return true;
            case 122009:
            case 11017:
                TeleportInterface.sendMiscTab(player);
                return true;
            case 122018:
            case 1717:
                Teleport data = player.getPreviousTeleport();
                if (data != null) {
                    if (data instanceof Monsters) {
                        handleMonsterTeleport(player, (Monsters) data);
                    } else if (data instanceof Bosses) {
                        handleBossTeleport(player, (Bosses) data);
                    } else if (data instanceof Minigames) {
                        handleMinigameTeleport(player, (Minigames) data);
                    } else if (data instanceof Dungeons) {
                        handleDungeonsTeleport(player, (Dungeons) data);
                    } else if (data instanceof Misc) {
                        handleMiscTeleport(player, (Misc) data);
                    }
                }
                return true;
        }

        if (buttonID >= 122202 && buttonID <= 122229) {
            int index = (buttonID - 122202) / 3;
            if ((buttonID - 122202) % 3 == 0) {
                if (index < player.getFavoriteTeleports().size()) {
                    Teleport data = player.getFavoriteTeleports().get(index);
                    if (data != null) {
                        if (data instanceof Monsters) {
                            handleMonsterTeleport(player, (Monsters) data);
                        } else if (data instanceof Bosses) {
                            handleBossTeleport(player, (Bosses) data);
                        } else if (data instanceof Minigames) {
                            handleMinigameTeleport(player, (Minigames) data);
                        } else if (data instanceof Dungeons) {
                            handleDungeonsTeleport(player, (Dungeons) data);
                        } else if (data instanceof Misc) {
                            handleMiscTeleport(player, (Misc) data);
                        }
                    }
                }
            } else if ((buttonID - 122202) % 3 == 1) {
                if (index < player.getFavoriteTeleports().size()) {
                    player.getFavoriteTeleports().remove(index);
                }
                showFavorites(player);
                updateTab(player);
            }
            return true;
        }

        if (buttonID >= 122302 && buttonID <= 122500) {
            int index = (buttonID - 122302) / 3;

            if ((buttonID - 122302) % 3 == 0) {
                if (player.getCurrentTeleportTab() == 0) {
                    if (index < Monsters.values().length) {
                        Monsters monsterData = Monsters.values()[index];
                        player.setCurrentTeleportClickIndex(index);
                        sendMonsterData(player, monsterData);
                    }
                }
                if (player.getCurrentTeleportTab() == 1) {
                    if (index < Bosses.values().length) {
                        Bosses bossData = Bosses.values()[index];
                        player.setCurrentTeleportClickIndex(index);
                        sendBossData(player, bossData);
                    }
                }
                if (player.getCurrentTeleportTab() == 2) {
                    if (index < Minigames.values().length) {
                        Minigames minigamesData = Minigames.values()[index];
                        player.setCurrentTeleportClickIndex(index);
                        sendMinigameData(player, minigamesData);
                    }
                }
                if (player.getCurrentTeleportTab() == 3) {
                    if (index < Dungeons.values().length) {
                        Dungeons wildyData = Dungeons.values()[index];
                        player.setCurrentTeleportClickIndex(index);
                        sendDungeonsData(player, wildyData);
                    }
                }
                if (player.getCurrentTeleportTab() == 4) {
                    if (index < Misc.values().length) {
                        Misc miscData = Misc.values()[index];
                        player.setCurrentTeleportClickIndex(index);
                        sendMiscData(player, miscData);
                    }
                }
            } else if ((buttonID - 122302) % 3 == 1) {
                Teleport data = null;

                System.out.println("here " + index);
                if (player.getCurrentTeleportTab() == 0 && index < Monsters.values().length) {
                    data = Monsters.values()[index];
                } else if (player.getCurrentTeleportTab() == 1 && index < Bosses.values().length) {
                    data = Bosses.values()[index];
                } else if (player.getCurrentTeleportTab() == 2 && index < Minigames.values().length) {
                    data = Minigames.values()[index];
                } else if (player.getCurrentTeleportTab() == 3 && index < Dungeons.values().length) {
                    data = Dungeons.values()[index];
                } else if (player.getCurrentTeleportTab() == 4 && index < Misc.values().length) {
                    data = Misc.values()[index];
                }

                if (data != null) {
                    if (!player.getFavoriteTeleports().contains(data)) {
                        if (player.getFavoriteTeleports().size() >= 10) {
                            player.sendMessage("Your favorites section is full.");
                            updateTab(player);
                            return true;
                        }
                        player.getFavoriteTeleports().add(data);
                        player.sendMessage("Added favorite");
                    } else {
                        player.getFavoriteTeleports().remove(data);
                        player.sendMessage("Removed favorite");
                    }
                    showFavorites(player);
                }
                updateTab(player);


            }
            return true;
        }
        return false;
    }

    public static void updateTab(Player player) {
        switch (player.getCurrentTeleportTab()) {
            case 0:
                sendMonsterTab(player);
                break;
            case 1:
                sendBossTab(player);
                break;
            case 2:
                sendMinigamesTab(player);
                break;
            case 3:
                sendDungeonsTab(player);
                break;
            case 4:
                sendMiscTab(player);
                break;
        }
    }

    public static void handleTeleports(Player player) {
        switch (player.getCurrentTeleportTab()) {
            case 0:
                Monsters monsterData = Monsters.values()[player.getCurrentTeleportClickIndex()];
                handleMonsterTeleport(player, monsterData);
                break;
            case 1:
                Bosses bossData = Bosses.values()[player.getCurrentTeleportClickIndex()];
                handleBossTeleport(player, bossData);
                break;
            case 2:
                Minigames minigameData = Minigames.values()[player.getCurrentTeleportClickIndex()];
                handleMinigameTeleport(player, minigameData);
                break;
            case 3:
                Dungeons wildyData = Dungeons.values()[player.getCurrentTeleportClickIndex()];
                handleDungeonsTeleport(player, wildyData);
                break;
            case 4:
                Misc miscData = Misc.values()[player.getCurrentTeleportClickIndex()];
                handleMiscTeleport(player, miscData);
                break;
        }
    }

    public static void handleBossTeleport(Player player, Bosses bossData) {

        if (bossData == Bosses.FALLEN_ANGEL) {
            if ((player.isUnlockedLucifers() &&
                player.getPointsHandler().getMiniLuciferkillcount() >= 10_000 ) || player.getRights() == PlayerRights.OWNER|| player.getRights() == PlayerRights.YOUTUBER) {
            TeleportHandler.teleportPlayer(player,
                    new Position(bossData.teleportCords[0], bossData.teleportCords[1], bossData.teleportCords[2]),
                    player.getSpellbook().getTeleportType());
            boolean contains = false;
            for (NPC others : World.getNpcs()) {
                if (others == null) {
                    continue;
                }

                if (others.getId() == 9012 && others.getPosition().getRegionId() == 7760 &&
                        others.getPosition().getZ() == (player.getIndex() * 4)) {
                    contains = true;
                }
            }
            if (!contains) {
                NPC npc_ = new NPC(9012, new Position(1952, 5146, player.getIndex() * 4));
                npc_.setSpawnedFor(player);
                World.register(npc_);
            }
        } else {
            player.sendMessage("You need to have killed 10k Fallen warriors to go here.");
        }
        return;
    }

        if (bossData == Bosses.MIDNIGHT_GOBLIN) {
            if (player.getRights() == PlayerRights.OWNER|| player.getRights() == PlayerRights.YOUTUBER)
                player.sendMessage("@red@Your rank allows you to bypass the teleport requirements!");
            if (!player.isUnlockedDarkSupreme()) {
                Item[] requirements = new Item[]{ new Item(5011, 1), new Item(12537, 1), new Item(17013, 1)};
                if (player.getInventory().containsAll(requirements)) {
                    player.getInventory().deleteItemSet(requirements);
                    player.setUnlockedDarkSupreme(true);
                    player.sendMessage("@red@Congratulations, you have unlocked Midnight Goblin's zone!");
                    return;
                } else  if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
                    TeleportHandler.teleportPlayer(player,
                            new Position(bossData.teleportCords[0], bossData.teleportCords[1], bossData.teleportCords[2]),
                            player.getSpellbook().getTeleportType());
                }  else
                    player.sendMessage("You do not have the requirements to unlock Midnight Goblins!");
                player.sendMessage("You need to sacrifice a Legends Light bow, sword, and staff!");
                player.sendMessage("@red@Try again with these items in your inventory!");
                return;

            } else if (player.isUnlockedDarkSupreme()) {
                TeleportHandler.teleportPlayer(player,
                        new Position(bossData.teleportCords[0], bossData.teleportCords[1], bossData.teleportCords[2]),
                        player.getSpellbook().getTeleportType());
                return;
            }

        }


        if (bossData == Bosses.BLOOD_DEMON) {
            if (player.getRights() == PlayerRights.OWNER)
                player.sendMessage("@red@Your rank allows you to bypass the teleport requirements!");
            if (player.getPointsHandler().getMIDNIGHTKILLCount() >= 10_000 || player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
                TeleportHandler.teleportPlayer(player,
                        new Position(bossData.teleportCords[0], bossData.teleportCords[1], bossData.teleportCords[2]),
                        player.getSpellbook().getTeleportType());
            }
            else
                player.sendMessage("@red@You need 10k Midnight Goblin kills to go here!");
            return;
        }
        player.setPreviousTeleport(bossData);
        TeleportHandler.teleportPlayer(player,
                new Position(bossData.teleportCords[0], bossData.teleportCords[1], bossData.teleportCords[2]),
                player.getSpellbook().getTeleportType());
    }

    public static void handleMonsterTeleport(Player player, Monsters monsterData) {
        player.setPreviousTeleport(monsterData);

        if (monsterData == Monsters.FALLEN_WARRIOR) {
            if (!player.isUnlockedLucifers()) {
                Item[] requirements = new Item[]{new Item(ItemDefinition.UPGRADE_TOKEN_ID, 25_000_000), new Item(20591, 1),
                        new Item(18823, 2), new Item(19888, 2)};
                if (player.getInventory().containsAll(requirements)) {
                    player.getInventory().deleteItemSet(requirements);
                    player.setUnlockedLucifers(true);
                    player.sendMessage("@red@Congratulations, you have unlocked Fallen Angel's zone!");
                    return;
                } else {
                    player.sendMessage("You do not have the requirements to unlock Fallen Angels!");
                    player.sendMessage("Must sacrifice 10m Levincia tokens, a rage cape,2 coll rings II, 2 colls necks II");
                    player.sendMessage("@red@Try again with these items in your inventory!");
                    return;
                }
            } else {
                TeleportHandler.teleportPlayer(player,
                        new Position(monsterData.teleportCords[0], monsterData.teleportCords[1], monsterData.teleportCords[2]),
                        player.getSpellbook().getTeleportType());
            }
        }
        else {
            TeleportHandler.teleportPlayer(player,
                    new Position(monsterData.teleportCords[0], monsterData.teleportCords[1], monsterData.teleportCords[2]),
                    player.getSpellbook().getTeleportType());
        }
        /*if (monsterData == Monsters.STARTER_ZONE) {
            ProgressionZone.teleport(player);
            return;
        }*/
        TeleportHandler.teleportPlayer(player,
                new Position(monsterData.teleportCords[0], monsterData.teleportCords[1], monsterData.teleportCords[2]),
                player.getSpellbook().getTeleportType());
    }

    public static void handleDungeonsTeleport(Player player, Dungeons wildyData) {
        player.setPreviousTeleport(wildyData);
        TeleportHandler.teleportPlayer(player,
                new Position(wildyData.teleportCords[0], wildyData.teleportCords[1], wildyData.teleportCords[2]),
                player.getSpellbook().getTeleportType());
    }

    public static void handleMiscTeleport(Player player, Misc miscData) {
        player.setPreviousTeleport(miscData);



        TeleportHandler.teleportPlayer(player,
                new Position(miscData.teleportCords[0], miscData.teleportCords[1], miscData.teleportCords[2]),
                player.getSpellbook().getTeleportType());
    }

    public static void handleMinigameTeleport(Player player, Minigames minigameData) {
        player.setPreviousTeleport(minigameData);

        if (minigameData == Minigames.IOA) {
            player.hov.initArea();
            player.hov.start();
            player.getPacketSender().sendInterfaceRemoval();
            return;
        }
      /*  if (minigameData == Minigames.VOD) {
            player.vod.initArea();
            player.vod.start();
            player.getPacketSender().sendInterfaceRemoval();
            return;
        }*/
        if (minigameData == Minigames.STARTER_ZONE) {
            ProgressionZone.teleport(player);
            player.getPacketSender().sendInterfaceRemoval();
            return;
        }
            TeleportHandler.teleportPlayer(player, new Position(minigameData.teleportCords[0],
                    minigameData.teleportCords[1], minigameData.teleportCords[2]), player.getSpellbook().getTeleportType());
    }

    public static void sendBossData(Player player, Bosses data) {
        player.getPacketSender().sendNpcOnInterface(122051, data.npcId, data.adjustedZoom);
        //player.getPacketSender().sendString(122202, NpcDefinition.forId(data.npcId).getHitpoints() + " - " + data.npcId);
        sendDrops(player, data.npcId);
    }

    public static void sendMonsterData(Player player, Monsters data) {
        player.getPacketSender().sendNpcOnInterface(122051, data.npcId, data.adjustedZoom);
      //  player.getPacketSender().sendString(122202, NpcDefinition.forId(data.npcId).getHitpoints() + " - " + data.npcId);
        sendDrops(player, data.npcId);
    }

    public static void sendDungeonsData(Player player, Dungeons data) {
        player.getPacketSender().sendNpcOnInterface(122051, data.npcId, data.adjustedZoom);
        sendDrops(player, data.npcId);
    }

    public static void sendMiscData(Player player, Misc data) {
        player.getPacketSender().sendNpcOnInterface(122051, data.npcId, data.adjustedZoom);
        sendDrops(player, data.npcId);
    }

    public static void sendMinigameData(Player player, Minigames data) {
        player.getPacketSender().sendNpcOnInterface(122051, data.npcId, data.adjustedZoom);
        if (data.loot != null)
            sendDrops(player, data.loot);
        else
            sendDrops(player, data.npcId);
    }

    public static void showFavorites(Player player) {
        int id = 122202;
        for (int i = 0; i < 10; i++) {
            if (player.getFavoriteTeleports().size() > i) {
                player.getPacketSender().sendString(id, player.getFavoriteTeleports().get(i).getName());
            } else {
                player.getPacketSender().sendString(id, "---");
            }
            id += 3;
        }
    }


    public static void setUp(Player player, int index) {
        resetOldData(player);
        player.setCurrentTeleportTab(index);
        sendTitles(player);
        clearData(player);
        player.getPacketSender().sendConfig(2877, player.getCurrentTeleportTab());
        showFavorites(player);
    }

    public static void showList(Player player, Teleport[] list) {
        int id = 122302;
        int config = 5340;
        for (Teleport data : list) {
            player.getPacketSender().sendString(id, data.getName());
            if (player.getFavoriteTeleports().contains(data))
                player.getPacketSender().sendConfig(config++, 1);
            else
                player.getPacketSender().sendConfig(config++, 0);

            id += 3;
        }
        player.getPacketSender().setScrollBar(122300, ((id - 122302) / 3) * 20);
        player.getPacketSender().sendInterface(122000);
    }

    public static void sendMonsterTab(Player player) {
        setUp(player, 0);
        showList(player, Monsters.values());
    }

    public static void sendBossTab(Player player) {
        setUp(player, 1);
        showList(player, Bosses.values());
    }

    public static void sendMinigamesTab(Player player) {
        setUp(player, 2);
        showList(player, Minigames.values());
    }

    public static void sendDungeonsTab(Player player) {
        setUp(player, 3);
        showList(player, Dungeons.values());
    }

    public static void sendMiscTab(Player player) {
        setUp(player, 4);
        showList(player, Misc.values());
    }

    public static void sendTitles(Player player) {
        String[] categories = new String[]{"Monsters", "Bosses", "Minigames", "Dungeons", "Globals"};
        for (int i = 0; i < 5; i++) {
            player.getPacketSender().sendString(122011 + i, (player.getCurrentTeleportTab() == i ? "@whi@" : "") + categories[i]);
        }
    }

    public static void sendDrops(Player player, int npcId) {
        if (npcId == -1) {
            int length = 10;

            for (int i = 0; i < length; i++) {
                player.getPacketSender().sendItemOnInterface1(35500, -1, i,
                        0);
            }
            int scroll = 43;
            player.getPacketSender().setScrollBar(122060, scroll);
        } else {
            try {
                NPCDrops drops = NPCDrops.getDrops().get(npcId);
                if (drops != null) {
                    int length = drops.getDropList().length;
                    if (length >= 160)
                        length = 160;


                    if (length >= 10 && length % 5 == 0){
                    }else{
                        length += 5 - (length % 5);
                    }

                    for (int i = 0; i < length + 5; i++) {
                        if (drops.getDropList().length > i) {
                            player.getPacketSender().sendItemOnInterface1(35500, drops.getDropList()[i].getId(), i,
                                    drops.getDropList()[i].getCount()[drops.getDropList()[i].getCount().length - 1] == -1 ? 25000
                                            : drops.getDropList()[i].getCount()[drops.getDropList()[i].getCount().length - 1]);
                        } else {
                            player.getPacketSender().sendItemOnInterface1(35500, -1, i,
                                    0);
                        }
                    }

                    int scroll = 7 + (length / 5) * 35;
                    if (scroll <= 43)
                        scroll = 43;

                    player.getPacketSender().setScrollBar(122060, scroll);
                }else{
                    sendDrops(player, -1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendDrops(Player player, Box[] drops) {
        try {
            if (drops != null) {
                int length = drops.length;
                if (length >= 160)
                    length = 160;

                length += 5 - (length % 5);
                for (int i = 0; i < length + 5; i++) {
                    if (drops.length > i)
                        player.getPacketSender().sendItemOnInterface1(35500, drops[i].getId(), i,
                                drops[i].getAmount());
                    else
                        player.getPacketSender().sendItemOnInterface1(35500, -1, i,
                                0);
                }
                int scroll = 7 + (length / 5) * 35;
                if (scroll <= 43)
                    scroll = 43;
                player.getPacketSender().setScrollBar(122060, scroll);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public enum Monsters implements Teleport {

        MINOTAUR("Minotaurs", 1719, new int[]{2527, 2527, 0}, 600),
        LAVA_HOUND("Ember Giant", 9838, new int[]{3424, 4126, 0}, 600),
        GORGON("Tree Gorgon", 1718, new int[]{2196, 5083, 0}, 550),//replace 1727 with 1718 in world npc
        BAT("Aquanite", 9836, new int[]{2388, 5019, 0}, 1500),
        GIANT_SPIDERS("Arachne", 117, new int[]{2721, 4446, 0}, 720),
        CASH_DRAGON("Cash dragon", 500, new int[]{2911, 3613, 0}, 1500),
        DEMON_GODDESS("Demon Goddess", 501, new int[]{2784, 4445, 0}, 725),
        ENERGY_SKELETON("Energy Skeleton", 503, new int[]{2088, 3995, 0}, 700),
        TUROTH("Turoth", 1627, new int[]{3154, 5556, 0}, 550),
        FALLEN_WARRIOR("Fallen Warrior", 9011, new int[]{1955, 5154, 0}, 500),
        ;

        private final String name;
        private final int npcId;
        private final int[] teleportCords;
        private final int adjustedZoom;

        Monsters(String name, int npcId, int[] teleportCords, int adjustedZoom) {
            this.name = name;
            this.npcId = npcId;
            this.teleportCords = teleportCords;
            this.adjustedZoom = adjustedZoom;
        }
        public static boolean contains(int npcID) {
            for (Monsters d : Monsters.values()) {
                if (d.getNpcId() == npcID)
                    return true;
            }
            return false;
        }

        public int getNpcId() {
            return npcId;
        }
        @Override
        public String getName() {
            return name;
        }
    }




    public enum Bosses implements Teleport {
        HANTO("Hanto warrior", 250, new int[]{3040, 2846, 0}, 780),
        RADITZ("Raditz", 449, new int[]{2911, 3991, 0}, 780),
        GOKU("Goku", 452, new int[]{3358, 9307, 0}, 780),
        BOTANIC("Botanic Guardian", 2342, new int[]{2586, 9449, 0}, 1000),
        ENRAGED_GUARDIAN("Enraged Guardian", 2949, new int[]{3039, 3995, 0}, 1000),
        ELEMENTAL_GUARDIAN("Elemental Guardian", 505, new int[]{2847, 2846, 0}, 1000),
        INYUASHA("Inuyasha", 185, new int[]{2328, 5409, 0}, 750),
        TOLROKOTH("Tolrokoth", 6430, new int[]{1887, 5468, 0}, 1200),
        DEITY_DEMON("Demons of Deity", 440, new int[]{2842, 9387, 0}, 1000),
        MUTATED_HOUND("Mutated Hound", 9839, new int[]{3421, 4777, 0}, 1250),
        ELITE("Elite Valdis", 205, new int[]{2529, 4573, 0}, 1150),
        COLLOSAL_AVATAR("Collosal Avatar", 4540, new int[]{2375, 4947, 0}, 1350),
        INFERNAL_DEMON("Plutonic Demon", 12810, new int[]{2728, 4505, 0}, 1150),
        FALLEN_ANGEL("Fallen Angel", 9012, new int[]{2335, 3998, 0}, 1000),
        MIDNIGHT_GOBLIN("Midnight Goblin", 9837, new int[]{2522, 4648, 0}, 1100),
        BLOOD_DEMON("Blood Demon", 9813, new int[]{3026, 5233, 0}, 750),
        /*
        CRYSTAL_QUEEN("Crystal queen", 6430, new int[]{1887, 5468, 0}, 1100),
        LUCIFER("Fallen Angel", 9012, new int[]{2335, 3998, 0}, 1000),
        MEGA_AVATAR("Mega avatar", 4540, new int[]{1884, 5334, 0}, 1600),

        CRAZY_WITCH("Crazy witch", 1234, new int[]{2784, 4445, 0}, 1000),
        LIGHT_SUPREME("Light supreme", 440, new int[]{2761, 4575, 0}, 1000),
        DARK_SUPREME("Dark supreme", 438, new int[]{2721, 4450, 0}, 1500),
        FRACTITE_DEMON("Fractite demon", 12843, new int[]{2785, 4525, 0}, 1000),
        INFERNAL_DEMON("Infernal demon", 12810, new int[]{2712, 4508, 0}, 1500),
*/
        ;

        private final int npcId;
        private final int[] teleportCords;
        private final int adjustedZoom;
        private final String name;

        Bosses(String name, int npcId, int[] teleportCords, int adjustedZoom) {
            this.name = name;
            this.npcId = npcId;
            this.teleportCords = teleportCords;
            this.adjustedZoom = adjustedZoom;
        }

        public static boolean contains(int npcID) {
            for (Bosses d : Bosses.values()) {
                if (d.getNpcId() == npcID)
                    return true;
            }
            return false;
        }

        public int getNpcId() {
            return npcId;
        }

        @Override
        public String getName() {
            return name;
        }
    }


    public enum Minigames implements Teleport {
        STARTER_ZONE("Starter Progression", 9001, new int[]{1, 1, 0}, Starter.rewards, 600),
        OUTBREAK("Pyramid Outbreak", 4476, new int[]{3487, 9235, 0}, PyramidOutbreak.loot, 600),
        UNKNOWN("Unknown Crypt", 823, new int[]{1754, 5133, 0}, 1250),
        DUNG("Legends Raids", 585, new int[]{2222, 4115, 0}, Raids1.rewards, 1450),
        IOA("Isles of Levincia", 9024, new int[]{2195, 5037, 0}, HallsOfAmmo.loot, 1200),
        //VOD("Void of Deception", 9028, new int[]{1954, 5010, 0}, VoidOfDarkness.loot, 600),
        TH("Treasure Hunter", 9816, new int[]{2015, 5022, 0}, TreasureHunter.loot, 3000),
       // KOL("Keepers of Light", 9835, new int[]{2322, 5028, 0}, KeepersOfLight.loot, 1200),
        ;

        private final String name;
        private final int npcId;
        private final int[] teleportCords;
        private final int adjustedZoom;
        private final Box[] loot;

        Minigames(String name, int npcId, int[] teleportCords, Box[] loot, int adjustedZoom) {
            this.name = name;
            this.npcId = npcId;
            this.teleportCords = teleportCords;
            this.adjustedZoom = adjustedZoom;
            this.loot = loot;
        }

        Minigames(String name, int npcId, int[] teleportCords, int adjustedZoom) {
            this.name = name;
            this.npcId = npcId;
            this.teleportCords = teleportCords;
            this.adjustedZoom = adjustedZoom;
            this.loot = null;
        }

        @Override
        public String getName() {
            return name;
        }
    }

//flesh scorpian id 1717
    public enum Dungeons implements Teleport {
        EASY_DUNGEON("Dreaded Dungeon", 1727, new int[]{1887, 5221, 0}, 600),
        MEDIUM_DUNGEON("Violent Tunnels", 1741, new int[]{2334, 5222, 0}, 600),
        HARD_DUNGEON("Deserted Labyrinth", 6792, new int[]{2081, 5532, 0}, 900),
       /* EASY_DUNGEON("Easy Dungeon", 1705, new int[]{1905, 4870, 0}, 700),
        EASY_DUNGEON_1("Easy Dungeon 2", 1724, new int[]{2016, 4767, 0}, 700),
        MEDIUM_DUNGEON("Medium Dungeon", 1742, new int[]{2227, 4946, 0}, 1200),
        HARD_DUNGEON("Hard Dungeon", 1715, new int[]{1637, 4856, 0}, 1200),*/
        ;

        private final String name;
        private final int npcId;
        private final int[] teleportCords;
        private final int adjustedZoom;

        Dungeons(String name, int npcId, int[] teleportCords, int adjustedZoom) {
            this.name = name;
            this.npcId = npcId;
            this.teleportCords = teleportCords;
            this.adjustedZoom = adjustedZoom;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum Misc implements Teleport {

        KC_BOSS("Hellraiser", 187, new int[]{3109, 5530, 0}, 1350),
        AFK_BOSS("Afk boss", 3779, new int[]{2013, 4505, 0}, 1500),
        TELE6("Vote boss", 8013, new int[]{2848, 4577, 0}, 1600),
        TELE0("Nightmare", 9017, new int[]{2980, 2771, 0}, 1500),
        TELE1("Naraku", 3305, new int[]{3420, 9563, 0}, 1350),
        TELE2("Dragon King", 4972, new int[]{2139, 5019, 0}, 1800),
        TELE3("Vozzath", 3830, new int[]{3491, 2772, 0}, 1900),
        TELE4("Iron", 587, new int[]{3808, 2842, 0}, 1500),
        TELE5("Nephilim Warrior", 9312, new int[]{2144, 3294, 0}, 1100),
        ;

        private final String name;
        private final int npcId;
        private final int[] teleportCords;
        private final int adjustedZoom;

        Misc(String name, int npcId, int[] teleportCords, int adjustedZoom) {
            this.name = name;
            this.npcId = npcId;
            this.teleportCords = teleportCords;
            this.adjustedZoom = adjustedZoom;

        }

        @Override
        public String getName() {
            return name;
        }

    }

    public interface Teleport {
        String getName();
    }



    public enum Zones implements Teleport {
        DUSTCLAW("Dustclaw", 1614, new int[]{3040, 2846, 0}, 780),
        LORD("Inferior Elite Lord", 603, new int[]{2911, 3991, 0}, 780),
        SHADOW("Shadow", 12843, new int[]{3358, 9307, 0}, 780),
        GOLEM("Golem", 53, new int[]{2586, 9449, 0}, 1000),
        SHETANI("Shetani", 8018, new int[]{3039, 3995, 0}, 1000),
        RIPPER("Rippers", 13635, new int[]{2847, 2846, 0}, 1000),
        AVATAR("Avatar titans", 8008, new int[]{2328, 5409, 0}, 750),
        WYVERNS("Legendary Wyverns", 3308, new int[]{2328, 5409, 0}, 750),
        ONI("Oni", 3117, new int[]{2328, 5409, 0}, 750),
        SHENRON("Shenron", 201, new int[]{2328, 5409, 0}, 750),
        SUBZERO("Subzero", 202, new int[]{2328, 5409, 0}, 750),
        ZEUS("Zeus", 203, new int[]{2328, 5409, 0}, 750),
        IPOTANE("Ipotane", 8010, new int[]{2328, 5409, 0}, 750),
        VINDICTA("Vindicta", 9807, new int[]{2328, 5409, 0}, 750),
        BEAST("Beast", 225, new int[]{2328, 5409, 0}, 750),
        ;

        private final int npcId;
        private final int[] teleportCords;
        private final int adjustedZoom;
        private final String name;

        Zones(String name, int npcId, int[] teleportCords, int adjustedZoom) {
            this.name = name;
            this.npcId = npcId;
            this.teleportCords = teleportCords;
            this.adjustedZoom = adjustedZoom;
        }

        public static boolean contains(int npcID) {
            for (Zones d : Zones.values()) {
                if (d.getNpcId() == npcID)
                    return true;
            }
            return false;
        }

        public int getNpcId() {
            return npcId;
        }

        @Override
        public String getName() {
            return name;
        }
    }


}
