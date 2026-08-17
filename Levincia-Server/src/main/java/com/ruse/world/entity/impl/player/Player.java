package com.ruse.world.entity.impl.player;

import com.google.gson.annotations.Expose;
import com.ruse.GameSettings;
import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.engine.task.impl.PlayerDeathTask;
import com.ruse.engine.task.impl.WalkToTask;
import com.ruse.model.*;
import com.ruse.model.container.impl.*;
import com.ruse.model.container.impl.Bank.BankSearchAttributes;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.model.definitions.WeaponAnimations;
import com.ruse.model.definitions.WeaponInterfaces;
import com.ruse.model.definitions.WeaponInterfaces.WeaponInterface;
import com.ruse.model.input.Input;
import com.ruse.motivote3.doMotivote;
import com.ruse.net.PlayerSession;
import com.ruse.net.SessionState;
import com.ruse.net.packet.PacketSender;
import com.ruse.util.FrameUpdater;
import com.ruse.util.Misc;
import com.ruse.util.Stopwatch;
import com.ruse.world.World;
import com.ruse.world.allornothing.AONType;
import com.ruse.world.content.BankPin.BankPinAttributes;
import com.ruse.world.content.*;
import com.ruse.world.content.DropLog.DropLogEntry;
import com.ruse.world.content.KillsTracker.KillsEntry;
import com.ruse.world.content.LoyaltyProgramme.LoyaltyTitles;
import com.ruse.world.content.achievements.AchievementHandler;
import com.ruse.world.content.achievements.AchievementInterface;
import com.ruse.world.content.achievements.AchievementTracker;
import com.ruse.world.content.achievements.AchievementsOLD;
import com.ruse.world.content.bis.BestItems;
import com.ruse.world.content.bossEvents.BossEventData;
import com.ruse.world.content.cardPacks.CardPack;
import com.ruse.world.content.casketopening.CasketOpening;
import com.ruse.world.content.clan.ClanChat;
import com.ruse.world.content.cluescrolls.ClueScrollTask;
import com.ruse.world.content.collectionlog.CollectionEntry;
import com.ruse.world.content.collectionlog.CollectionLogInterface;
import com.ruse.world.content.combat.CombatFactory;
import com.ruse.world.content.combat.CombatType;
import com.ruse.world.content.combat.effect.CombatPoisonEffect.CombatPoisonData;
import com.ruse.world.content.combat.magic.CombatSpell;
import com.ruse.world.content.combat.prayer.CurseHandler;
import com.ruse.world.content.combat.prayer.PrayerHandler;
import com.ruse.world.content.combat.pvp.PlayerKillingAttributes;
import com.ruse.world.content.combat.range.CombatRangedAmmo.RangedWeaponData;
import com.ruse.world.content.combat.strategy.CombatStrategies;
import com.ruse.world.content.combat.strategy.CombatStrategy;
import com.ruse.world.content.combat.weapon.CombatSpecial;
import com.ruse.world.content.combat.weapon.FightType;
import com.ruse.world.content.cosmetic.WardrobeCategory;
import com.ruse.world.content.cosmetic.WardrobeData;
import com.ruse.world.content.cosmetic.WardrobeHandler;
import com.ruse.world.content.dailyTask.DailyTaskData;
import com.ruse.world.content.dailyTask.DailyTaskDifficulty;
import com.ruse.world.content.dailyTasksNew.DailyTaskManager;
import com.ruse.world.content.dailytasks_new.DailyTask;
import com.ruse.world.content.dailytasks_new.TaskChallenge;
import com.ruse.world.content.dialogue.Dialogue;
import com.ruse.world.content.dissolving.MainDissolving;
import com.ruse.world.content.dissolving.NephilimDisassemble;
import com.ruse.world.content.dissolving.OwnerDisassemble;
import com.ruse.world.content.dissolving.SupremeDissolving;
import com.ruse.world.content.event_chest.EventChestHandler;
import com.ruse.world.content.eventboss.EventBossManager;
import com.ruse.world.content.gamblinginterface.GamblingInterface;
import com.ruse.world.content.grandexchange.GrandExchangeSlot;
import com.ruse.world.content.groupironman.IronmanGroup;
import com.ruse.world.content.instanceMananger.InstanceData;
import com.ruse.world.content.instanceMananger.InstanceManager;
import com.ruse.world.content.leaderboards.LeaderboardManager;
import com.ruse.world.content.membership.MembershipInterfaceHandler;
import com.ruse.world.content.membership.MembershipManager;
import com.ruse.world.content.minigames.MinigameAttributes;
import com.ruse.world.content.minigames.impl.*;
import com.ruse.world.content.minigames.impl.dungeoneering.Dungeoneering;
import com.ruse.world.content.newspinner.MysteryBoxManager;
import com.ruse.world.content.osrscollectionlog.CollectionLog;
import com.ruse.world.content.osrscollectionlog.LogType;
import com.ruse.world.content.pos.PlayerOwnedShopManager;
import com.ruse.world.content.properscratchcard.Scratchcard;
import com.ruse.world.content.quests.QuestInterfaceHandler;
import com.ruse.world.content.raids.elders.TelosRaidParty;
import com.ruse.world.content.raids.legends.LegendsRaidParty;
import com.ruse.world.content.raids.shadows.NecromancerRaidParty;
import com.ruse.world.content.raids.system.RaidDifficulty;
import com.ruse.world.content.raids.system.RaidsParty;
import com.ruse.world.content.randomevents.Genie;
import com.ruse.world.content.scratchcards.ScratchCard;
import com.ruse.world.content.seasonpass.SeasonPass;
import com.ruse.world.content.skill.SkillManager;
import com.ruse.world.content.skill.impl.construction.HouseFurniture;
import com.ruse.world.content.skill.impl.construction.Portal;
import com.ruse.world.content.skill.impl.construction.Room;
import com.ruse.world.content.skill.impl.farming.Farming;
import com.ruse.world.content.skill.impl.slayer.Slayer;
import com.ruse.world.content.skill.impl.slayer.SlayerFavourites;
import com.ruse.world.content.skill.impl.summoning.BossPets;
import com.ruse.world.content.skill.impl.summoning.Pouch;
import com.ruse.world.content.skill.impl.summoning.Summoning;
import com.ruse.world.content.startertasks.StarterTaskHandler;
import com.ruse.world.content.teleport.TeleportCategory;
import com.ruse.world.content.teleport.TeleportData;
import com.ruse.world.content.upgrading.MaxUpgradesInterface;
import com.ruse.world.content.upgrading.UpgradeInterface;
import com.ruse.world.content.valentine.HweenEvent;
import com.ruse.world.content.youtube.YoutubeCategory;
import com.ruse.world.content.youtube.YoutubeData;
import com.ruse.world.entity.actor.player.controller.ControllerManager;
import com.ruse.world.entity.impl.Character;
import com.ruse.world.entity.impl.mini.MiniPManager;
import com.ruse.world.entity.impl.mini.MiniPlayer;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.StartScreen.GameModes;
import com.ruse.world.instance.impl.DungeoneeringInstance;
import com.ruse.world.region.Region;
import com.ruse.world.region.RegionManager;
import com.ruse.world.region.dynamic.DynamicRegion;
import lombok.Getter;
import lombok.Setter;
import mysql.impl.Store;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//import com.ruse.mysql.Hiscores;

public class Player extends Character {
    public static int MYSTERY_BOXES_OPENED,PVM_BOXES_OPENED,PVM_BOXES_T2_OPENED,SUPER_BOXES_OPENED,EXTREME_BOXES_OPENED,
            OP_BOXES_OPENED,GRAND_BOXES_OPENED,VOTE_BOXES_OPENED,PROGRESSIVE_BOXES_OPENED,SLAYER_BOXES_OPENED,SLAYER_BOXESU_OPENED,
            DRAGON_BALL_BOXES_OPENED,RAID_BOXES_OPENED,LAUNCH_BOXES_OPENED,AZURE_CASKETS_OPENED,ELITE_CASKETS_OPENED,
            EXCLUSIVE_CASKETS_OPENED, LEGENDARY_CASKETS_OPENED, SUPREME_CASKETS_OPENED,
            SPIDERS_KILLED,DUSTCLAWS_KILLED,HANTO_KILLED,
            SUFFERING_COMPLETED,NECROMANCER_COMPLETED,DEMON_GODDESS_KILLED,ENERGY_SKELETONS_KILLED,TUROTH_KILLED,
            FALLEN_WARRIOR_KILLED,CAVE_DRONE_KILLED,CAVE_MUTANT_KILLED,CAVE_SNAIL_KILLED
    ,LORDS_KILLED,SHADOW_KILLED,GOLEM_KILLED,SHETANI_KILLED,RIPPER_KILLED,AVATAR_KILLED,WYVERNS_KILLED,
            ONI_KILLED,SHENRON_KILLED,SUBZERO_KILLED,ZEUS_KILLED,IPOTANE_KILLED,VINDICTA_KILLED,BEAST_KILLED,NIHIL_KILLED
            ,RADITZ_KILLED,GOKU_KILLED,BOTANIC_KILLED,ENRAGED_GUARDIAN_KILLED,ELEMENTAL_GUARDIAN_KILLED,
            INYUASHA_KILLED,TOLROKOTH_KILLED,DEITY_DEMON_KILLED,MUTATED_HOUND_KILLED,VALDIS_KILLED,COLLOSAL_AVATAR_KILLED,
            INFERNAL_DEMON_KILLED,FALLEN_ANGEL_KILLED,MIDNIGHT_GOBLIN_KILLED,BLOOD_DEMON_KILLED,UNKNOWN_MINIGAMES_COMPLETED,
            ISLES_OF_AVALON_COMPLETED,
            TREASURE_HUNTER_COMPLETED,
            PEST_CONTROL_COMPLETED,
            PYRAMID_OUTBREAK_COMPLETED
            ;
    public static boolean MYSTERY_BOX_LOG_CLAIMED,PVM_BOX_LOG_CLAIMED,PVM_BOX_T2_LOG_CLAIMED,SUPER_BOX_LOG_CLAIMED,
            EXTREME_BOX_LOG_CLAIMED,GRAND_BOX_LOG_CLAIMED,OP_BOX_LOG_CLAIMED,VOTE_BOX_LOG_CLAIMED,PROGRESSIVE_BOX_LOG_CLAIMED,
            SLAYER_BOX_LOG_CLAIMED,SLAYER_BOXU_LOG_CLAIMED,DRAGON_BALL_BOX_LOG_CLAIMED,RAID_BOX_LOG_CLAIMED,NIHIL_LOG_CLAIMED,
            LAUNCH_BOX_LOG_CLAIMED,AZURE_CASKET_LOG_CLAIMED,ELITE_CASKET_LOG_CLAIMED,EXCLUSIVE_CASKET_LOG_CLAIMED,LEGENDARY_CASKET_LOG_CLAIMED,SUPREME_CASKET_LOG_CLAIMED,
            ARACHNES_LOG_CLAIMED,DUSTCLAW_LOG_CLAIMED,HANTO_LOG_CLAIMED, SUFFERING_LOG_CLAIMED,NECROMANCER_LOG_CLAIMED,
            DEMON_GODDESS_LOG_CLAIMED, ENERGY_SKELETONS_LOG_CLAIMED, TUROTH_LOG_CLAIMED,
            FALLEN_WARRIOR_LOG_CLAIMED,CAVE_DRONE_LOG_CLAIMED,CAVE_MUTANT_LOG_CLAIMED,CAVE_SNAIL_LOG_CLAIMED,
            LORD_LOG_CLAIMED,SHADOW_LOG_CLAIMED,GOLEM_LOG_CLAIMED,SHETANI_LOG_CLAIMED,RIPPER_LOG_CLAIMED,AVATAR_LOG_CLAIMED
            ,WYVERNS_LOG_CLAIMED,ONI_LOG_CLAIMED,SHENRON_LOG_CLAIMED,SUBZERO_LOG_CLAIMED,ZEUS_LOG_CLAIMED,IPOTANE_LOG_CLAIMED,
            VINDICTA_LOG_CLAIMED,BEAST_LOG_CLAIMED,RADITZ_LOG_CLAIMED,GOKU_LOG_CLAIMED,BOTANIC_LOG_CLAIMED,
            ENRAGED_GUARDIAN_LOG_CLAIMED,ELEMENTAL_GUARDIAN_LOG_CLAIMED,INYUASHA_LOG_CLAIMED,TOLROKOTH_LOG_CLAIMED,
            DEITY_DEMON_LOG_CLAIMED,MUTATED_HOUND_LOG_CLAIMED,VALDIS_LOG_CLAIMED,COLLOSAL_AVATAR_LOG_CLAIMED,
            INFERNAL_DEMON_LOG_CLAIMED,FALLEN_ANGEL_LOG_CLAIMED,MIDNIGHT_GOBLIN_LOG_CLAIMED,BLOOD_DEMON_LOG_CLAIMED,
            UNKNOWN_MINIGAMES_LOG_CLAIMED,
            ISLES_OF_AVALON_LOG_CLAIMED,
            TREASURE_HUNTER_LOG_CLAIMED,
            PEST_CONTROL_LOG_CLAIMED,
            PYRAMID_OUTBREAK_LOG_CLAIMED
            ;
    private final CollectionLog collectionLog2 = new CollectionLog(this);
    public Object incrementMiniLuciferkillcount;

    public CollectionLog getCollectionLog2() {
        return collectionLog2;
    }
    public com.ruse.world.content.osrscollectionlog.Collection logwerechecking;
    public com.ruse.world.content.osrscollectionlog.Collection getLogtoCheck() {
        return logwerechecking;
    }
    public com.ruse.world.content.osrscollectionlog.Collection setLogtoCheck(com.ruse.world.content.osrscollectionlog.Collection log){
        logwerechecking = log;
        return logwerechecking;
    }
    public LogType logtype;
    public boolean idleEventUsed;
    private AchievementHandler achievementHandler;

    public AchievementHandler getAchievements() {
        if (achievementHandler == null)
            achievementHandler = new AchievementHandler(this);
        return achievementHandler;
    }
    @Getter
    private final DailyTaskManager dailyTaskManager = new DailyTaskManager(this);

    public AchievementsOLD.AchievementAttributes getAchievementAttributes() {
        return achievementAttributes;
    }

    @Getter
    private final SlayerFavourites slayerFavourites = new SlayerFavourites(this);

    private int soulRiskAmount;

    public void setSoulRiskAmount(int amount) {
        this.soulRiskAmount = amount;
    }

    public int getSoulRiskAmount() {
        return soulRiskAmount;
    }

    @Getter
    @Setter
    private int sealedUrnAmount;

    private int soulGambleAmount;

    public void setSoulGambleAmount(int amount) {
        this.soulGambleAmount = amount;
    }

    public int getSoulGambleAmount() {
        return soulGambleAmount;
    }

    @Getter
    @Setter
    private boolean canKillSlayerBoss = false;

    private ClanChat currentClanChat;

    public ClanChat getCurrentClanChat() {
        return currentClanChat;
    }

    public Player setCurrentClanChat(ClanChat clanChat) {
        this.currentClanChat = clanChat;
        return this;
    }
    private boolean afkSoulMessages = true;

    public boolean isAfkSoulMessagesEnabled() {
        return afkSoulMessages;
    }

    public void toggleAfkSoulMessages() {
        this.afkSoulMessages = !afkSoulMessages;
        sendMessage("AFK soul message toggle: " + (afkSoulMessages ? "ON" : "OFF"));
    }
    private int afkWhispers = 0;
    public int getAfkWhispers() { return afkWhispers; }
    public void setAfkWhispers(int amt) { this.afkWhispers = amt; }


    public String getClanChatName() {
        return clanChatName;
    }

    public Player setClanChatName(String clanChatName) {
        this.clanChatName = clanChatName;
        return this;
    }

    @Getter
    private final LeaderboardManager leaderboardManager = new LeaderboardManager(this);

    @Setter
    @Getter
    private int dailyTasksCompleted;

    @Getter
    private HweenEvent ghweenEvent = new HweenEvent(this);

    public HweenEvent getHweenEvent() {
        return ghweenEvent;
    }

    @Getter
    @Setter
    private boolean[] turkeysMutated = new boolean[6];

    @Getter
    @Setter
    private RaidDifficulty lastDifficulty;

    @Getter
    @Setter
    private int easyIsleGodKC,medIsleGodKC,hardIsleGodKC;

    @Getter
    @Setter
    private int easyElderGodKC,medElderGodKC,hardElderGodKC;
    @Setter
    @Getter
    private long serverPerksContributions;
    
    @Getter
    private Stopwatch seasonPassPlaytime = new Stopwatch();


    @Getter
    private CardPack cardPack = new CardPack(this);

    @Getter
    private ArrayList<Item> partyChestCoffer = new ArrayList<>();

    /*** LONGS **/
    private Long longUsername;
    private long moneyInPouch;
    private long soulInPouch;
    private long totalPlayTime;


    @Getter
    public InstanceManager instanceManager = new InstanceManager(this);

    /**
     * Instance Manager variables.
     */

    public String currentInstanceNpcName;
    public int currentInstanceNpcId;
    public int currentInstanceAmount;

    public long getMoneyInPouch() {
        return moneyInPouch;
    }

    public void setMoneyInPouch(long moneyInPouch) {
        this.moneyInPouch = moneyInPouch;
    }

    public int getMoneyInPouchAsInt() {
        return moneyInPouch > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) moneyInPouch;
    }

    /**
     * This si the throne id, depending on what the donator chose.
     */
    public int throneId = 1097;

    public ArrayList<GameObject> toRemove = new ArrayList<GameObject>();

    /**
     * what log type were viewing like bosses, mystery boxes, etc
     * @param logType
     */

    public void setCollectionLogOpen(LogType logType) {
        logtype = logType;
    }
    public LogType getCollectionLogOpen(){
        return logtype;
    }
    @Getter
    @Setter
    private ArrayList<String> offences = new ArrayList<>();
    public int npckillsforseasonpass = 0;
    public int skilllampxp;
    public Skill theskill;

    @Getter
    @Setter
    private int dropInterfaceNPC;

    @Getter
    @Setter
    private boolean includeDR = false;

    @Getter
    private final ArrayList<BossPets.BossPet> obtainedPets = new ArrayList<>();

    @Getter
    private final DonatorShop donatorShop = new DonatorShop(this);

    @Getter
    private final PetShop petShop = new PetShop(this);

    @Getter
    private final UpgradeInterface upgradeInterface = new UpgradeInterface(this);


    @Getter
    private final WardrobeHandler wardrobeHandler = new WardrobeHandler (this);

    @Getter
    private final ArrayList<TeleportInterface.Teleport> favoriteTeleports = new ArrayList<>();

    public boolean canMysteryBox;
    public boolean switchedPrayerBooks;

    @Getter
    @Setter
    private Genie genie = new Genie(this, false);

    private MainDissolving mainDissolving = new MainDissolving(this);

    public MainDissolving getMainDissolving() {
        return mainDissolving;
    }

    private SupremeDissolving supremeDissolving = new SupremeDissolving(this);

    public SupremeDissolving getSupremeDissolving() {
        return supremeDissolving;
    }


public int howmuchdissolveamt = 0;
    private NephilimDisassemble nephilimDissolving = new NephilimDisassemble(this);

    public NephilimDisassemble getNephilimDissolving() {
        return nephilimDissolving;
    }
    private CharmDisassemble charmDissolving = new CharmDisassemble(this);

    public CharmDisassemble getCharmDissolving() {
        return charmDissolving;
    }

    private OwnerDisassemble ownerDissolving = new OwnerDisassemble(this);

    public OwnerDisassemble getOwnerDissolving() {
        return ownerDissolving;
    }

    private MysteryBoxManager newSpinner = new MysteryBoxManager(this);

    public MysteryBoxManager getNewSpinner() {
        return newSpinner;
    }

    public int[] mboxLoot = {-1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1};

    public boolean levelNotifications = true;

    @Getter
    @Setter
    private boolean openedTeleports = false;
    @Getter
    @Setter
    private int currentTeleportTab = 0;
    @Getter
    @Setter
    private int currentTeleportClickIndex = 0;
    @Getter
    @Setter
    private TeleportInterface.Teleport previousTeleport;


    public NPC findSpawnedFor() {
        return findSpawnedFor(position.getRegionId());
    }
    public NPC findSpawnedFor(int regionId) {
        Region region = RegionManager.getRegion(regionId);
        if(region == null) {
            return null;
        }
        for(int npcIndex : region.getVisibleNpcs()) {
            NPC npc = World.getNpcs().get(npcIndex);
            if (npc == null) {
                continue;
            }
            if(this.equals(npc.getSpawnedFor())) {
                return npc;
            }

        }
        return null;
    }
    public int getDungeoneeringPrestige() {
        return dungeoneeringPrestige;
    }

    public void setDungeoneeringPrestige(int dungeoneeringPrestige) {
        this.dungeoneeringPrestige = dungeoneeringPrestige;
    }

    private int dungeoneeringPrestige = 0;


    public int getDungeoneeringFloor() {
        return dungeoneeringFloor;
    }

    public void setDungeoneeringFloor(int dungeoneeringFloor) {
        this.dungeoneeringFloor = dungeoneeringFloor;
    }

    private int dungeoneeringFloor = 0;

    public void incrementDungFloor() {
        if(dungeoneeringFloor < Dungeoneering.Constants.NUMBER_FLOORS) {
            dungeoneeringFloor++;
        } else {
            dungeoneeringFloor = 0;
            dungeoneeringPrestige++;
        }
    }

    private final ControllerManager controllerManager = new ControllerManager(this);
    public ControllerManager getControllerManager() {
        return controllerManager;
    }

    public ClueScrollTask currentClue = new ClueScrollTask(this);

    public HallsOfAmmo hov = new HallsOfAmmo(this);
    public VoidOfDarkness vod = new VoidOfDarkness(this);
    public int lastTGloveIndex = -1;
    private final WheelOfFortune wheelOfFortune = new WheelOfFortune(this);

    public WheelOfFortune getWheelOfFortune() {
        return wheelOfFortune;
    }

   
    /*
     * minime
     */
	@Getter
	@Setter
	private boolean miniPlayer;

    @Getter
    private final MiniPManager miniPManager = new MiniPManager(this);
    @Getter
    @Setter
    private boolean hasMiniPlayer, isMiniPlayer;
	@Getter
	@Setter
	private Player miniPlayerOwner;
    
    /*
     * end of minime
     */
    public Scratchcard scratchcard = new Scratchcard(this);

    public Scratchcard getScratchcard() {
        return scratchcard;
    }

    private int perkIndex = 0;

    public int getPerkIndex() {
        return perkIndex;
    }

    public void setPerkIndex(int perkIndex) {
        this.perkIndex = perkIndex;
    }


    @Getter
    @Setter
    private long sanctumEasyTimer;
    @Getter
    @Setter
    private long sanctumHardTimer;
    @Getter
    @Setter
    private long animaEasyTimer;
    @Getter
    @Setter
    private long animaHardTimer;
    @Getter
    @Setter
    private long isleEasyTimer;
    @Getter
    @Setter
    private long isleMedTimer;
    @Getter
    @Setter
    private long isleHardTimer;

    @Getter
    @Setter
    private long elderEasyTimer;
    @Getter
    @Setter
    private long elderMedTimer;
    @Getter
    @Setter
    private long elderHardTimer;

    @Getter
    @Setter
    private double isleDropRate;

    @Getter
    @Setter
    private double elderDropRate;

    @Getter
    @Setter
    private double scrollBonus;

    @Getter
    private ArrayList<Item> godsCoffer = new ArrayList<>();

    @Getter
    private ArrayList<Item> telosCoffer = new ArrayList<>();

    @Getter
    @Setter
    private boolean receivedSharkCostume;

    @Getter
    @Setter
    private boolean receivedBattlegearCostume;

    @Setter
    @Getter
    private boolean unlockedRammernaut;

    @Setter
    @Getter
    private int travelingMerchantDay;
    @Getter
    private ArrayList<Item> travelingMerchantItems = new ArrayList<>();

    public Item[] getMerchantItems() {
        return merchantItems;
    }

    public void setMerchantItems(Item[] merchantItems) {
        this.merchantItems = merchantItems;
    }

    @Setter
    private Item[] merchantItems = new Item[250];

    @Getter
    @Setter
    private long discordUser;
    @Getter
    @Setter
    private int discordPoints;

    public void increaseDiscordPoints(int amount) {
        discordPoints += amount;
    }
    @Getter
    @Setter
    private String discordTag;

    @Getter
    @Setter
    private Stopwatch epochDay;


    @Getter
    @Setter
    private int groupInvitationId;
    @Getter
    @Setter
    private IronmanGroup ironmanGroup = null;
    @Getter
    @Setter
    private boolean groupIronmanLocked;

    public GroupIronmanBank getGroupIronmanBank() {
        return getIronmanGroup() != null ? getIronmanGroup().getBank() : null;
    }

    public Player setGroupIronmanBank(GroupIronmanBank bank) {
        if (getIronmanGroup() != null)
            getIronmanGroup().setBank(bank);
        return this;
    }


    @Getter
    private final Stopwatch easterDelay = new Stopwatch();

    @Getter
    @Setter
    private boolean gambleBanned;

    @Getter
    @Setter
    private int[] progressionZones = new int[6];
    @Getter
    @Setter
    private boolean[] zonesComplete = new boolean[6];


    private final CasketOpening casketOpening = new CasketOpening(this);
    private boolean spinning;
    public CasketOpening getCasketOpening() {
        return casketOpening;
    }

    public boolean isSpinning() {
        return spinning;
    }

    public void setSpinning(boolean spinning) {
        this.spinning = spinning;
    }
    public static int Amount_Donated;
    private final List<GroundItem> itemsInScene = new CopyOnWriteArrayList<>();
    private final DailyRewards dailyRewards = new DailyRewards(this);
    private final PlayerOwnedShopManager playerOwnedShopManager = new PlayerOwnedShopManager(this);
    // Timers (Stopwatches)
    private final Stopwatch sqlTimer = new Stopwatch();
    private final Stopwatch foodTimer = new Stopwatch();
    private final Stopwatch potionTimer = new Stopwatch();
    private final Stopwatch lastRunRecovery = new Stopwatch();
    private final Stopwatch clickDelay = new Stopwatch();
    private final Stopwatch lastItemPickup = new Stopwatch();
    private final Stopwatch lastYell = new Stopwatch();
    private final Stopwatch lastVoteClaim = new Stopwatch();
    private final Stopwatch lastVengeance = new Stopwatch();
    private final Stopwatch emoteDelay = new Stopwatch();
    private final Stopwatch specialRestoreTimer = new Stopwatch();
    private final Stopwatch lastSummon = new Stopwatch();
    private final Stopwatch recordedLogin = new Stopwatch();
    private final Stopwatch creationDate = new Stopwatch();
    private final Stopwatch tolerance = new Stopwatch();
    private final Stopwatch lougoutTimer = new Stopwatch();
    private final Stopwatch lastDfsTimer = new Stopwatch();
    private final Stopwatch lastNephSwordTimer = new Stopwatch();
    /*** INSTANCES ***/
    private final CopyOnWriteArrayList<KillsEntry> killsTracker = new CopyOnWriteArrayList<KillsEntry>();
    private final CopyOnWriteArrayList<DropLogEntry> dropLog = new CopyOnWriteArrayList<DropLogEntry>();
    private final CopyOnWriteArrayList<NPC> npc_faces_updated = new CopyOnWriteArrayList<NPC>();
    private final List<Player> localPlayers = new LinkedList<Player>();
    private final List<NPC> localNpcs = new LinkedList<NPC>();
    private final PlayerProcess process = new PlayerProcess(this);
    private boolean unlockedseasonpass;
    private boolean unlockedMembership;
    private boolean unlockedCosmetic;
    private EventChestHandler eventChestHandler = new EventChestHandler();
    @Getter
    @Setter
    private boolean santaTransform;
    @Getter
    @Setter
    private boolean yugiTransform;

    @Getter
    @Setter
    private boolean darkMagicianTransform;

    @Getter
    @Setter
    private boolean protectorTransform;


    @Getter
    @Setter
    private boolean exodiaTransform;

    @Getter
    @Setter
    private boolean evilSantaTransform;

    @Getter
    @Setter
    private boolean voteBossTransform;

    @Getter
    @Setter
    private boolean nightmareTransform;
    @Getter
    @Setter
    private boolean dragonKingTransform;

    @Getter
    @Setter
    private boolean vozzathTransform;
    @Getter
    @Setter
    private boolean golemTransform;
    public EventChestHandler getEventChestHandler() {
        return eventChestHandler;
    }
    private final PlayerKillingAttributes playerKillingAttributes = new PlayerKillingAttributes(this);
    private final MinigameAttributes minigameAttributes = new MinigameAttributes();
    private final BankPinAttributes bankPinAttributes = new BankPinAttributes();
    private final BankSearchAttributes bankSearchAttributes = new BankSearchAttributes();
    private final AchievementsOLD.AchievementAttributes achievementAttributes = new AchievementsOLD.AchievementAttributes ();
    private final BonusManager bonusManager = new BonusManager();
    private final PointsHandler pointsHandler = new PointsHandler(this);
    public final UnknownZone unknownZone = new UnknownZone(this);
    public final MotivationalMessages motivationalMessages = new MotivationalMessages(this);
    public final QuestInterfaceHandler questInterface = new QuestInterfaceHandler(this);
    public final MembershipInterfaceHandler membershipInterfaceHandler = new MembershipInterfaceHandler(this);
    public final PrestigeInterfaceHandler prestigeInterface = new PrestigeInterfaceHandler(this);
    public final MagicGuild magicGuildUnlock = new MagicGuild(this);
    public final MagicGuild magicGuildT1 = new MagicGuild(this);
    public final MagicGuild magicGuildT2 = new MagicGuild(this);
    public final MagicGuild magicGuildT3 = new MagicGuild(this);
    public final ArcherGuild archerGuildUnlock = new ArcherGuild(this);
    public final ArcherGuild archerGuildT1 = new ArcherGuild(this);
    public final ArcherGuild archerGuildT2 = new ArcherGuild(this);
    public final ArcherGuild archerGuildT3 = new ArcherGuild(this);
    public final WarriorGuild warriorGuildUnlock = new WarriorGuild(this);
    public final WarriorGuild warriorGuildT1 = new WarriorGuild(this);
    public final WarriorGuild warriorGuildT2 = new WarriorGuild(this);
    public final WarriorGuild warriorGuildT3 = new WarriorGuild(this);
    private final PacketSender packetSender = new PacketSender(this);
    private final Appearance appearance = new Appearance(this);
    private final FrameUpdater frameUpdater = new FrameUpdater();
    private CurrencyPouch currencyPouch = new CurrencyPouch();
    public boolean bot;
    public int selectedGoodieBag = -1;
    public int currentPlayerPanelIndex = 1;
    public boolean day1Claimed = false;
    public boolean day2Claimed = false;
    public boolean day3Claimed = false;
    public boolean day4Claimed = false;
    public boolean day5Claimed = false;
    public boolean day6Claimed = false;
    public boolean day7Claimed = false;
    public long lastLogin;
    public long lastDailyClaim;
    public long lastVoteTime;
    public long lastPurchase;
    public boolean hasVotedToday;
    public boolean claimedFirst;
    public boolean claimedSecond;
    public boolean claimedThird;
    public long lastDonation;
    public long lastTimeReset;
    /**
     * Lottery
     */
    public int lotteryNumberChoosing;
    public int lotteryNumberEntered;
    public long lotteryTotalProfit;
    public long lastLotteryEnter;
    public double entriesCurrency;
    /**
     * Double or nothing vars
     **/

    public int aonBoxItem;
    public AONType aonBoxType;
    public AONType aonBoxTypeGamble;
    /**
     * Poll System vars
     **/

    // Poll System
    public String pollTitle;
    public String pollOptionOne;
    public String pollOptionTwo;
    public int pollHours;
    public String currentTime, date;
    public String connectedFrom = "";
    /**
     * Loyalty Streak Vars.
     **/

    public int daysVoted;
    public int totalTimesClaimed;
    public int longestDaysVoted;
    public long timeUntilNextReward;
    public long minsPlayed;
    public String lastVoted;
    public int currentVotingStreak;
    public int currentVotes;

    /**;
    public int currentVotes;
    /**
     * Instance Manager variables.
     */

    public InstanceData data;
    /**
     * Stores the players current daily tasks
     */

    public String currentDailyTask;
    public int currentDailyTaskAmount;
    public int dailiesCompleted;

    /**
     * Daily Money Making Variables Getters and setters for enums
     */
    public int xPosDailyTask;
    public int yPostDailyTask;
    public int zPosDailyTask;
    public int rewardDailyTask;

    @Expose
    public HashMap<DailyTask, TaskChallenge> dailies = new HashMap<>();
    public void setDailies(HashMap<DailyTask, TaskChallenge> dailyTasks) {
        dailies = dailyTasks;
    }
    public boolean skillingTask;
    public int dailySkips = 3;
    public String taskInfo;
    public long[] taskReceivedTime = {-1, -1, -1};

    public DailyTaskData dailyTasks, dailyTasksTemporary;
    public DailyTaskDifficulty dailyTasksDifficulty;
    public boolean hasPlayerCompletedBossTask = false;
    public int currentBossTask;
    public int currentBossTaskAmount;
    public BossEventData bossevent;
    public boolean starterClaimed;
    // Timers (Stopwatches)
    public long lastHelpRequest;
    //	public GameModes selectedGameMode;
    public GameModes selectedGameMode;
    public boolean dropMessageToggle = false;
    public boolean motivationalToggle = false;
    public boolean membershipMessages = true;
    public boolean hasReferral;
    public long lastDonationClaim;
    private boolean placeholders = true;
    private boolean enteredZombieRaids;
    private int zombieRaidsKC;
    private int islesKC;
    private int telosKC;
    private boolean enteredSODRaids;
    private boolean enteredShadowRaids;
    private boolean enteredTelosRaids;
    private int sodRaidsKC;
    private RaidsParty raidsParty;
    private LegendsRaidParty zombieRaidsParty;
    private NecromancerRaidParty shadowRaidsParty;
    private TelosRaidParty telosRaidsParty;
    private boolean insideRaids;
    private int afkTree;
    private int afkSapphire;
    private int afkEmerald;
    private int afkbRuby;
    private int afkDiamond;
    private int afkOnyx;
    private int afkZenyte;
    private int afkTanzanite;
    private int afkPlatinum;
    @Getter
    @Setter
    private int godModeTimer;
    @Getter
    @Setter
    private int shadowRareDropBoost;
    @Getter
    @Setter
    private int shadowKeysOpened;
    @Getter
    private final BestItems bestItems = new BestItems(this);
    private final GoodieBag goodieBag = new GoodieBag(this);
    /**
     * Custom Combiner
     */
    private String savedPin;
    private String savedIp;
    private boolean hasPin2 = false;
    private final MysteryBoxOpener mysteryBoxOpener = new MysteryBoxOpener(this);
    /**
     * Collection Log Start
     */

    @Getter
    private final CollectionLogInterface collectionLog = new CollectionLogInterface(this);
    @Getter
    @Setter
    private List<CollectionEntry> collectionLogData = new ArrayList<>();
    private Map<Integer, Map<Integer, Integer>> collectedItems = new HashMap<>(); //wtf
    private final GamblingInterface gambling = new GamblingInterface(this);
    private final ScratchCard scratchCard = new ScratchCard(this);
    /**
     * Donation deals
     */

    private final DonationDeals donationDeals = new DonationDeals(this);
    private int amountDonatedToday;
    private boolean opMode;
    private final BonusXp bonusXp = new BonusXp(this); // instance of BonusXp class
    private final CofferRewards cofferRewards = new CofferRewards(this); // instance of BonusXp class
    private String mac;
    private String uuid;
    /*** STRINGS ***/
    private String username;
    private String password;
    private String salt;
    private String serial_number;
    private String emailAddress;
    private String hostAddress;
    private String clanChatName;
    private String yellHex;
    private String strippedJewelryName;
    private String yellTitle;
    private ArrayList<HouseFurniture> houseFurniture = new ArrayList<HouseFurniture>();
    private ArrayList<Portal> housePortals = new ArrayList<>();
    private final PlayerSession session;
    private CharacterAnimations characterAnimations = new CharacterAnimations();
    private PlayerRights rights = PlayerRights.PLAYER;
    private final SkillManager skillManager = new SkillManager(this);
    private final PlayerRelations relations = new PlayerRelations(this);
    private final ChatMessage chatMessages = new ChatMessage();
    private Inventory inventory = new Inventory(this);
    private Equipment equipment = new Equipment(this);
    private Equipment preSetEquipment = new Equipment(this);
    private DungeoneeringIronInventory dungeoneeringIronInventory = new DungeoneeringIronInventory(this);
    private DungeoneeringIronEquipment dungeoneeringIronEquipment = new DungeoneeringIronEquipment(this);
    private final PriceChecker priceChecker = new PriceChecker(this);
    private final Trading trading = new Trading(this);
    private Slayer slayer = new Slayer(this);
    private final Dueling dueling = new Dueling(this);
    private final Farming farming = new Farming(this);
    private final Summoning summoning = new Summoning(this);
    private final Bank[] bankTabs = new Bank[9];
    private Room[][][] houseRooms = new Room[5][13][13];
    private PlayerInteractingOption playerInteractingOption = PlayerInteractingOption.NONE;
    private GameMode gameMode = GameMode.NORMAL;
    private Difficulty difficulty = Difficulty.MODERN; // modern now default difficulty, was extreme
    private CombatType lastCombatType = CombatType.MELEE;
    private FightType fightType = FightType.UNARMED_PUNCH;
    private Prayerbook prayerbook = Prayerbook.NORMAL;
    private MagicSpellbook spellbook = MagicSpellbook.NORMAL;
    private LoyaltyTitles loyaltyTitle = LoyaltyTitles.NONE;
    private Input inputHandling;
    private WalkToTask walkToTask;
    private Shop shop;
    private GameObject interactingObject;
    private Item interactingItem;
    private Dialogue dialogue;
    private DwarfCannon cannon;
    private CombatSpell autocastSpell, castSpell, previousCastSpell;
    private RangedWeaponData rangedWeaponData;
    private CombatSpecial combatSpecial;
    private WeaponInterface weapon;
    private Item untradeableDropItem;
    private Object[] usableObject;
    private GrandExchangeSlot[] grandExchangeSlots = new GrandExchangeSlot[6];
    private Task currentTask;
    private Position resetPosition;
    private Pouch selectedPouch;
    /*** INTS ***/
    private int[] brawlerCharges = new int[11];
    private int[] ancientArmourCharges = new int[15];
    private int[] forceMovement = new int[7];
    private final int[] leechedBonuses = new int[7];
    private int[] ores = new int[2];
    private int[] constructionCoords;
    private int[] previousTeleports = new int[]{0, 0, 0, 0};
    private int recoilCharges;
    private int starterCharges;
    private int forgingCharges;
    private int blowpipeCharges;
    private int runEnergy = 100;
    private int currentBankTab;
    private int interfaceId, walkableInterfaceId, multiIcon;
    private int dialogueActionId;

    @Getter
    @Setter
    private int doubleDRTimer, doubleDDRTimer, doubleDMGTimer;

    private int overloadPotionTimer, prayerRenewalPotionTimer;
    private int fireImmunity, fireDamageModifier;
    private int amountDonated;
    private int npckillcount;
    private int unknownCompleted;
    private int totalprestiges;
    private int totalsprees;
    private int wildernessLevel;
    private int fireAmmo;
    private int specialPercentage = 100;
    private int skullIcon = -1, skullTimer;
    private int teleblockTimer;
    private int dragonFireImmunity;
    private int poisonImmunity;
    /*
     * Fields
     */
    private int shadowState;
    private int effigy;
    private int dfsCharges;
    private int supremeCharges;
    private int nephSwordCharges;
    private int nephStaffCharges;
    private int nephBowCharges;
    private int nephilimBonus;
    private int guardianBonus;
    private int playerViewingIndex;
    private int staffOfLightEffect;
    private int minutesBonusExp = 0;
    private int minutesVotingDR = 0;
    private int minutesVotingDMG = 0;
    private int selectedGeSlot = -1;
    private int selectedGeItem = -1;
    private int geQuantity;
    private int gePricePerItem;
    private int selectedSkillingItem;
    private int currentBookPage;
    private int storedRuneEssence, storedPureEssence;
    private int trapsLaid;
    private int skillAnimation;
    private int houseServant;
    private int houseServantCharges;
    private int servantItemFetch;
    private int portalSelected;
    private int constructionInterface;
    private int buildFurnitureId;
    private int buildFurnitureX;
    private int buildFurnitureY;
    private int combatRingType;
    private int barrowsKilled;
    private int vodKilled;
    private int hovKilled;
    private int clueProgress;
    private int christmas2016;
    private int newYear2017;
    private int lastTomed;
    private int selectedSkillingItemTwo;
    private int easter2017 = 0;
    private final UIMBank uimBank = new UIMBank(this);
    private boolean[] crossedObstacles = new boolean[7];
    private boolean processFarming;
    private boolean crossingObstacle;
    private boolean targeted;
    private boolean isBanking, noteWithdrawal, swapMode;
    private boolean regionChange, allowRegionChangePacket;
    private boolean isDying;
    private boolean isRunning = true, isResting;
    private boolean experienceLocked;
    private boolean clientExitTaskActive;
    private boolean drainingPrayer;
    private boolean shopping;
    private boolean settingUpCannon;
    private boolean hasVengeance;
    private boolean killsTrackerOpen;
    private boolean acceptingAid;
    private boolean autoRetaliate;
    private boolean autocast;
    private boolean specialActivated;
    private boolean isCoughing;
    private boolean playerLocked;
    private boolean recoveringSpecialAttack;
    private boolean soundsActive, musicActive;
    private boolean newPlayer;
    private boolean openBank;
    private boolean inActive;
    private boolean supremeTbed;
    private boolean inConstructionDungeon;
    private boolean isBuildingMode;
    private boolean voteMessageSent;
    private boolean receivedStarter;
    private boolean fri13may16;
    private boolean toggledglobalmessages;
    private boolean spiritdebug;
    private boolean reffered;
    private boolean indung;
    private boolean doingClanBarrows;
    private boolean flying;
    private boolean canFly;
    private boolean ghostWalking;
    private boolean canGhostWalk;
    private boolean[] hween2016 = new boolean[7];
    private boolean doneHween2016;
    private boolean bonecrushEffect = true;
    private List<Integer> lootList;
    private boolean clickToTeleport;
    private final EventBossManager eventBossManager = new EventBossManager(this);
    /**
     * Progression Manager
     */

    private Map<Integer, Integer> uimBankItems = new LinkedHashMap<>();
    /**
     * Combiner
     */

    private boolean chargingAttack;
    private final SeasonPass seasonPass = new SeasonPass(this);
    private final MembershipManager membershipManager = new MembershipManager(this);
    public Player(PlayerSession playerIO) {
        super(GameSettings.HOME_CORDS.copy());
        this.session = playerIO;
    }

    public boolean isPlaceholders() {
        return placeholders;
    }

    public void setPlaceholders(boolean placeholders) {
        this.placeholders = placeholders;
    }

    public List<GroundItem> getItemsInScene() {
        return itemsInScene;
    }

    public boolean isBot() {
        return bot;
    }

    public void setBot(boolean bot) {
        this.bot = bot;
    }


    public boolean hasFallenWarrior;

    public boolean isFallenWarrior() {
        return hasFallenWarrior;
    }

    public void setFallenWarrior(boolean hasFallenWarrior) {
        this.hasFallenWarrior = hasFallenWarrior;
    }

    public boolean getFallenWarrior() {
        return hasFallenWarrior;
    }



    public boolean hasSupreme;

    public boolean isSupreme() {
        return hasSupreme;
    }

    public void setSupreme(boolean hasSupreme) {
        this.hasSupreme = hasSupreme;
    }

    public boolean getSupreme() {
        return hasSupreme;
    }



    public boolean hasCelestial;

    public boolean isCelestial() {
        return hasCelestial;
    }

    public void setCelestial(boolean hasCelestial) {
        this.hasCelestial = hasCelestial;
    }

    public boolean getCelestial() {
        return hasCelestial;
    }

    public boolean isInsideRaids() {
        return insideRaids;
    }

    public void setInsideRaids(boolean insideRaids) {
        this.insideRaids = insideRaids;
    }

    public boolean isEnteredZombieRaids() {
        return enteredZombieRaids;
    }

    public void setEnteredZombieRaids(boolean enteredZombieRaids) {
        this.enteredZombieRaids = enteredZombieRaids;
    }

    public int getSODRaidsKC() {
        return sodRaidsKC;
    }

    public void setSODRaidsKC(int sodRaidsKC) {
        this.sodRaidsKC = sodRaidsKC;
    }

    public boolean isEnteredShadowRaids() {
        return enteredShadowRaids;
    }

    public void setEnteredShadowRaids(boolean enteredShadowRaids) {
        this.enteredShadowRaids = enteredShadowRaids;
    }


    public boolean isEnteredTelosRaids() {
        return enteredTelosRaids;
    }

    public void setEnteredTelosRaids(boolean enteredTelosRaids) {
        this.enteredTelosRaids = enteredTelosRaids;
    }

    public boolean isEnteredSODRaids() {
        return enteredSODRaids;
    }

    public void setEnteredSODRaids(boolean enteredSODRaids) {
        this.enteredSODRaids = enteredSODRaids;
    }

    public RaidsParty getRaidsParty() {
        return raidsParty;
    }

    public void setRaidsParty(RaidsParty raidsParty) {
        this.raidsParty = raidsParty;
    }

    public LegendsRaidParty getZombieRaidsParty() {
        return zombieRaidsParty;
    }

    public void setZombieRaidsParty(LegendsRaidParty zombieRaidsParty) {
        this.zombieRaidsParty = zombieRaidsParty;
    }

    public NecromancerRaidParty getShadowRaidsParty() {
        return shadowRaidsParty;
    }

    public void setShadowRaidsParty(NecromancerRaidParty shadowRaidsParty) {
        this.shadowRaidsParty = shadowRaidsParty;
    }

    public TelosRaidParty getTelosRaidsParty() {
        return telosRaidsParty;
    }

    public void setTelosRaidParty(TelosRaidParty telosRaidsParty) {
        this.telosRaidsParty = telosRaidsParty;
    }

    public int getAfkTree() {
        return afkTree;
    }
    public void setAfkTree(int afkTree) {
        this.afkTree = afkTree;
    }

    private boolean threebythree;
    public boolean get3x3() {
        return threebythree;
    }
    public void set3x3(boolean threebythree) {
        this.threebythree = threebythree;
    }

    private boolean fourbyfour;
    public boolean get4x4() {
        return fourbyfour;
    }
    public void set4x4(boolean fourbyfour) {
        this.fourbyfour = fourbyfour;
    }


    @Getter
    @Setter
    private long[] posInfo = new long[4];


    public int getAfkSapphire() {
        return afkSapphire;
    }
    public void setAfkSapphire(int afkSapphire) {
        this.afkSapphire = afkSapphire;
    }

    public int getAfkEmerald() { return afkEmerald; }
    public void setAfkEmerald(int afkEmerald) {
        this.afkEmerald = afkEmerald;
    }

    public int getAfkbRuby() {
        return afkbRuby;
    }
    public void setAfkbRuby(int afkbRuby) {
        this.afkbRuby = afkbRuby;
    }

    public int getAfkDiamond() { return afkDiamond;
    }
    public void setAfkDiamond(int afkDiamond) {
        this.afkDiamond = afkDiamond;
    }

    public int getAfkOnyx() { return afkOnyx;
    }
    public void setAfkOnyx(int afkOnyx) { this.afkOnyx = afkOnyx;
    }

    public int getAfkZenyte() { return afkZenyte;
    }
    public void setAfkZenyte(int afkZenyte) {
        this.afkZenyte = afkZenyte;
    }

    public int getAfkTanzanite() { return afkTanzanite;
    }
    public void setAfkTanzanite(int afkTanzanite) {
        this.afkTanzanite = afkTanzanite;
    }

    public int getAfkPlatinum() { return afkPlatinum;
    }
    public void setAfkPlatinum(int afkPlatinum) {
        this.afkPlatinum = afkPlatinum;
    }
    public GoodieBag getGoodieBag() {
        return goodieBag;
    }

    public String getSavedIp() {
        return savedIp;
    }

    public void setSavedIp(String savedIp) {
        this.savedIp = savedIp;
    }

    public boolean getHasPin() {
        return hasPin2;
    }

    public void setHasPin(boolean hasPin2) {
        this.hasPin2 = hasPin2;
    }

    public String getSavedPin() {
        return savedPin;
    }

    public void setSavedPin(String savedPin) {
        this.savedPin = savedPin;
    }

    public MysteryBoxOpener getMysteryBoxOpener() {
        return mysteryBoxOpener;
    }


    public Map<Integer, Map<Integer, Integer>> getCollectedItems() {
        return collectedItems;
    }

    public void setCollectedItems(Map<Integer, Map<Integer, Integer>> collectedItems) {
        this.collectedItems = collectedItems;
    }

    public void handleCollectedItem(int npcId, Item item) {
        int id = item.getId();
        int amount = item.getAmount();
        if (collectedItems.get(npcId) == null) {
            Map<Integer, Integer> itemData = new HashMap<>();
            itemData.put(id, amount);
            collectedItems.put(npcId, itemData);
        } else {
            collectedItems.get(npcId).merge(id, amount, Integer::sum);
        }
    }

    public Position lastTeleport;

    public GamblingInterface getGambling() {
        return gambling;
    }

    public ScratchCard getScratchCard() {
        return scratchCard;
    }

    public DailyRewards getDailyRewards() {
        return dailyRewards;
    }

    public DonationDeals getDonationDeals() {
        return donationDeals;
    }

    public int getAmountDonatedToday() {
        return amountDonatedToday;
    }

    public void setAmountDonatedToday(int amount) {
        this.amountDonatedToday = amount;
    }

    public void incrementAmountDonatedToday(int amount) {
        this.amountDonatedToday += amount;
    }

    public double getEntriesCurrency() {
        return entriesCurrency;
    }

    public void setEntriesCurrency(double entriesCurrency) {
        this.entriesCurrency = entriesCurrency;
    }

    public int getDaysVoted() {
        return daysVoted;
    }

    public void setDaysVoted(int daysVoted) {
        this.daysVoted = daysVoted;
    }

    public int getTotalTimesClaimed() {
        return totalTimesClaimed;
    }

    public void setTotalTimesClaimed(int totalTimesClaimed) {
        this.totalTimesClaimed = totalTimesClaimed;
    }

    public int getLongestDaysVoted() {
        return longestDaysVoted;
    }

    public void setLongestDaysVoted(int longestDaysVoted) {
        this.longestDaysVoted = longestDaysVoted;
    }

    public long getTimeUntilNextReward() {
        return timeUntilNextReward;
    }

    public void setTimeUntilNextReward(long timeUntilNextReward) {
        this.timeUntilNextReward = timeUntilNextReward;
    }

    public long getMinsPlayed() {
        return minsPlayed;
    }

    public void setMinsPlayed(long minsPlayed) {
        this.minsPlayed = minsPlayed;
    }


    public String getLastVoted() {
        return lastVoted;
    }

    public void setLastVoted(String lastVoted) {
        this.lastVoted = lastVoted;
    }

    public int getCurrentVotingStreak() {
        return currentVotingStreak;
    }

    public void setCurrentVotingStreak(int currentVotingStreak) {
        this.currentVotingStreak = currentVotingStreak;
    }

    public String getTimeString() {
        long playTime = minsPlayed;
        int days = 0;
        int hours = 0;

        if (playTime >= 1440) {
            while (playTime >= 1440) {
                playTime -= 1440;
                days++;
            }
        }
        if (playTime >= 60) {
            while (playTime >= 60) {
                playTime -= 60;
                hours++;
            }
        }
        return days + ":" + hours + ":" + playTime;
    }

    public int getCurrentVotes() {
        return currentVotes;
    }

    public InstanceData getData() {
        return data;
    }

    public void setData(InstanceData data) {
        this.data = data;
    }

    public String getCurrentInstanceNpcName() {
        return currentInstanceNpcName;
    }

    public void setCurrentInstanceNpcName(String currentInstanceNpcName) {
        this.currentInstanceNpcName = currentInstanceNpcName;
    }

    public int getCurrentInstanceAmount() {
        return currentInstanceAmount;
    }

    public void setCurrentInstanceAmount(int currentInstanceAmount) {
        this.currentInstanceAmount = currentInstanceAmount;
    }

    public int getCurrentInstanceNpcId() {
        return currentInstanceNpcId;
    }

    public void setCurrentInstanceNpcId(int currentInstanceNpcId) {
        this.currentInstanceNpcId = currentInstanceNpcId;
    }



    public String getCurrentDailyTask() {
        return currentDailyTask;
    }

    public void setCurrentDailyTask(String currentDailyTask) {
        this.currentDailyTask = currentDailyTask;
    }

    public int getCurrentDailyTaskAmount() {
        return currentDailyTaskAmount;
    }

    public void setCurrentDailyTaskAmount(int currentDailyTaskAmount) {
        this.currentDailyTaskAmount = currentDailyTaskAmount;
    }

    public int getxPosDailyTask() {
        return xPosDailyTask;
    }

    public void setxPosDailyTask(int xPosDailyTask) {
        this.xPosDailyTask = xPosDailyTask;
    }

    public int getyPostDailyTask() {
        return yPostDailyTask;
    }

    public void setyPostDailyTask(int yPostDailyTask) {
        this.yPostDailyTask = yPostDailyTask;
    }

    public int getzPosDailyTask() {
        return zPosDailyTask;
    }

    public void setzPosDailyTask(int zPosDailyTask) {
        this.zPosDailyTask = zPosDailyTask;
    }

    public int getRewardDailyTask() {
        return rewardDailyTask;
    }

    public void setRewardDailyTask(int rewardDailyTask) {
        this.rewardDailyTask = rewardDailyTask;
    }

    public DailyTaskData getDailyTasksTemporary() {
        return dailyTasksTemporary;
    }

    public void setDailyTasksTemporary(DailyTaskData dailyTasksTemporary) {
        this.dailyTasksTemporary = dailyTasksTemporary;
    }

    public DailyTaskData getDailyTasks() {
        return dailyTasks;
    }

    public void setDailyTasks(DailyTaskData dailyTasks) {
        this.dailyTasks = dailyTasks;
    }

    public DailyTaskDifficulty getDailyTasksDifficulty() {
        return dailyTasksDifficulty;
    }

    public void setDailyTasksDifficulty(DailyTaskDifficulty dailyTasksDifficulty) {
        this.dailyTasksDifficulty = dailyTasksDifficulty;
    }

    public boolean isHasPlayerCompletedBossTask() {
        return hasPlayerCompletedBossTask;
    }

    public void setHasPlayerCompletedBossTask(boolean hasPlayerCompletedBossTask) {
        this.hasPlayerCompletedBossTask = hasPlayerCompletedBossTask;
    }

    public int getCurrentBossTaskAmount() {
        return currentBossTaskAmount;
    }

    public void setCurrentBossTaskAmount(int currentBossTaskAmount) {
        this.currentBossTaskAmount = currentBossTaskAmount;
    }

    public int getCurrentBossTask() {
        return currentBossTask;
    }

    public void setCurrentBossTask(int currentBossTask) {
        this.currentBossTask = currentBossTask;
    }

    public boolean isOpMode() {
        return opMode;
    }

    public void setOpMode(boolean newMode) {
        this.opMode = newMode;
    }

    public BonusXp getBonusXp() { // getter for that instance.
        return bonusXp;
    }

    public CofferRewards getCofferRewards() { // getter for that instance.
        return cofferRewards;
    }

    public BossEventData getBossevent() {
        return bossevent;
    }

    public void setBossevent(BossEventData bossevent) {
        this.bossevent = bossevent;
    }


    public PlayerOwnedShopManager getPlayerOwnedShopManager() {
        return playerOwnedShopManager;
    }

    public String getMac() {
        return mac;
    }

    public Player setMac(String mac) {
        this.mac = mac;
        return this;
    }

    public String getUUID() {
        return uuid;
    }

    public Player setUUID(String uuid) {
        this.uuid = uuid;
        return this;
    }

    @Override
    public void appendDeath() {
        if (!isDying) {
            isDying = true;
            if (!controllerManager.appendDeath())
                return;
            TaskManager.submit(new PlayerDeathTask(this));
        }
    }

    @Override
    public int getConstitution() {
        return getSkillManager().getCurrentLevel(Skill.CONSTITUTION);
    }

    public int getHP() {
        return getConstitution();
    }


    @Override
    public Character setConstitution(int constitution) {
        if (isDying) {
            return this;
        }
        skillManager.setCurrentLevel(Skill.CONSTITUTION, constitution);
        packetSender.sendSkill(Skill.CONSTITUTION);
        if (getConstitution() <= 0 && !isDying)
            appendDeath();
        return this;
    }

    /*** BOOLEANS ***/
    private boolean[] unlockedLoyaltyTitles = new boolean[12];

    @Override
    public void heal(int amount) {
        boolean nexEffect = getEquipment().wearingNexAmours();
        int level = skillManager.getMaxLevel(Skill.CONSTITUTION);
        int nexHp = level + 400;
        int currentlevel = skillManager.getCurrentLevel(Skill.CONSTITUTION);

        if (currentlevel >= level && !nexEffect) {
            return;
        }
        if (currentlevel >= nexHp && nexEffect) {
            return;
        }

        if ((currentlevel + amount) >= (nexEffect ? nexHp : level)) {
            setConstitution(nexEffect ? nexHp : level);
        } else if ((currentlevel + amount) < (nexEffect ? nexHp : level)) {
            setConstitution(currentlevel + amount);
        }

        getSkillManager().updateSkill(Skill.CONSTITUTION);
    }

    @Override
    public int getBaseAttack(CombatType type) {
        if (type == CombatType.RANGED)
            return skillManager.getCurrentLevel(Skill.RANGED);
        else if (type == CombatType.MAGIC)
            return skillManager.getCurrentLevel(Skill.MAGIC);
        return skillManager.getCurrentLevel(Skill.ATTACK);
    }

    @Override
    public int getBaseDefence(CombatType type) {
        if (type == CombatType.MAGIC)
            return skillManager.getCurrentLevel(Skill.MAGIC);
        return skillManager.getCurrentLevel(Skill.DEFENCE);
    }

    @Override
    public int getAttackSpeed() {
        int speed = weapon.getSpeed();
        String weapon = equipment.get(Equipment.WEAPON_SLOT).getDefinition().getName();
        if (equipment.get(Equipment.WEAPON_SLOT).getId() == 22006){
            return 2;
        }
        return 1;
    }

    @Override
    public boolean isPlayer() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Player)) {
            return false;
        }

        Player p = (Player) o;
        return p.getIndex() == getIndex() || p.getUsername().equals(username);
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public void poisonVictim(Character victim, CombatType type) {
        if (type == CombatType.MELEE || weapon == WeaponInterface.DART || weapon == WeaponInterface.KNIFE
                || weapon == WeaponInterface.THROWNAXE || weapon == WeaponInterface.JAVELIN) {
            CombatFactory.poisonEntity(victim, CombatPoisonData.getPoisonType(equipment.get(Equipment.WEAPON_SLOT)));
        } else if (type == CombatType.RANGED) {
            CombatFactory.poisonEntity(victim,
                    CombatPoisonData.getPoisonType(equipment.get(Equipment.AMMUNITION_SLOT)));
        }
    }

    public CombatStrategy getStrategy(int npc) {
        return CombatStrategies.getStrategy(npc);
    }

    @Override
    public CombatStrategy determineStrategy() {
        if (specialActivated && castSpell == null) {

            if (combatSpecial.getCombatType() == CombatType.MELEE) {
                return CombatStrategies.getDefaultMeleeStrategy();
            } else if (combatSpecial.getCombatType() == CombatType.RANGED) {
                setRangedWeaponData(RangedWeaponData.getData(this));
                return CombatStrategies.getDefaultRangedStrategy();
            } else if (combatSpecial.getCombatType() == CombatType.MAGIC) {
                return CombatStrategies.getDefaultMagicStrategy();
            }
        }

        if (castSpell != null || autocastSpell != null) {
            return CombatStrategies.getDefaultMagicStrategy();
        }

        RangedWeaponData data = RangedWeaponData.getData(this);
        if (data != null) {
            setRangedWeaponData(data);
            return CombatStrategies.getDefaultRangedStrategy();
        }

        return CombatStrategies.getDefaultMeleeStrategy();
    }

    public void process() {
        processGodMode();
        process.sequence();

    }

    public boolean isGodMode() {
        return godModeTimer > 0;
    }

    public void initGodMode() {
        if (!isGodMode()) {
            return;
        }
        packetSender.sendWalkableInterface(48300, true);
    }

    public void overlodemode() {
        packetSender.sendWalkableInterface(48300, true);
    }

    public void endovlmode() {
        overloadPotionTimer = 0;
        if(getWalkableInterfaceId() == 48300)
            packetSender.sendWalkableInterface(48300, false);
    }

    public void endGodMode() {
        godModeTimer = 0;
        packetSender.sendWalkableInterface(48300, false);
        for (Skill skill : Skill.values()) {
            skillManager.setCurrentLevel(skill, skillManager.getMaxLevel(skill));
        }
        setSpecialPercentage(100);
        sendMessage("Your god mode timer has run out.");
    }

    private void processGodMode() {
        if (!isGodMode()) {
            return;
        }
        skillManager.setCurrentLevel(Skill.PRAYER, 15000);
        skillManager.setCurrentLevel(Skill.ATTACK, 1500);
        skillManager.setCurrentLevel(Skill.STRENGTH, 1500);
        skillManager.setCurrentLevel(Skill.DEFENCE, 1500);
        skillManager.setCurrentLevel(Skill.RANGED, 1500);
        skillManager.setCurrentLevel(Skill.MAGIC, 1500);
        skillManager.setCurrentLevel(Skill.CONSTITUTION, 15000);
        packetSender.sendString(48302, (godModeTimer / 100) + " minutes");
        packetSender.sendString(48303, "God Mode");
        godModeTimer--;
        if (godModeTimer < 1) {
            endGodMode();
        }
    }


    public void dispose() {
        // save();
        packetSender.sendLogout();
    }

    public void save() {
        if (session.getState() != SessionState.LOGGED_IN && session.getState() != SessionState.LOGGING_OUT) {
            return;
        }
        PlayerSaving.save(this);
    }

    private MaxUpgradesInterface customCombiner = new MaxUpgradesInterface(this);

    public MaxUpgradesInterface getCustomCombiner() {
        return customCombiner;
    }

    private StarterTaskHandler starterTaskHandler;
    public StarterTaskHandler getStarterTasks() {
        if (starterTaskHandler == null)
            starterTaskHandler = new StarterTaskHandler(this);
        return starterTaskHandler;
    }
    /*
     * Getters & Setters
     */

    @Setter
 	private boolean spawningMiniPlayer;
    
    public boolean logout() {
    	if (spawningMiniPlayer)
			return false;
        boolean debugMessage = false;
        int[] playerXP = new int[Skill.values().length];
        for (int i = 0; i < Skill.values().length; i++) {
            playerXP[i] = this.getSkillManager().getExperience(Skill.forId(i));
        }
        /*
        if (this.getGameMode() == GameMode.VETERAN_MODE) {
            com.everythingrs.hiscores.Hiscores.update("B3MkcPlRDNcgBkUydRM5Q7D0HKS64tayioIjhzSNTG2064qz06SUIIMDwnf5efZKxYM8spq5",
                    "Normal Mode", this.getUsername(),
                    this.getRights().ordinal(), playerXP, debugMessage);
            this.getGameMode();
        }*/

        if (getCombatBuilder().isBeingAttacked()) {
            getPacketSender().sendMessage("You must wait a few seconds after being out of combat before doing this.");
            return false;
        }
        if (getConstitution() <= 0 || isDying || settingUpCannon || crossingObstacle) {
            getPacketSender().sendMessage("You cannot log out at the moment.");
            return false;
        }
        if (getSummoning().getFamiliar() != null && getInventory().getFreeSlots() > 0) {
            getSummoning().unsummon(true, true);
        }
        // new Thread(new Hiscores(this)).start();
        return true;
    }

    public void restart() { // @TODO TO-DO brandon pk update shit here ???
        setStunDelay(0);
        setFreezeDelay(0);
        setOverloadPotionTimer(0);
        setPrayerRenewalPotionTimer(0);
        setSpecialPercentage(100);
        setSpecialActivated(false);
        CombatSpecial.updateBar(this);
        setHasVengeance(false);
        setSkullTimer(0);
        setSkullIcon(0);
        setTeleblockTimer(0);
        setPoisonDamage(0);
        setStaffOfLightEffect(0);
        performAnimation(new Animation(65535));
        WeaponInterfaces.assign(this, getEquipment().get(Equipment.WEAPON_SLOT));
        WeaponAnimations.update(this);
        PrayerHandler.deactivateAll(this);
        CurseHandler.deactivateAll(this);
        getEquipment().refreshItems();
        getInventory().refreshItems();
        if (!isGodMode()) {
            for (Skill skill : Skill.values()) {
                getSkillManager().setCurrentLevel(skill, getSkillManager().getMaxLevel(skill));
            }
        } else {
            this.getSkillManager().setCurrentLevel(Skill.CONSTITUTION, this.getSkillManager().getMaxLevel(Skill.CONSTITUTION));
        }
        setRunEnergy(100);
        setDying(false);
        getMovementQueue().setLockMovement(false).reset();

        getUpdateFlag().flag(Flag.APPEARANCE);
        getUpdateFlag().flag(Flag.APPEARANCE);
    }
    public void updateAppearance() {
        getUpdateFlag().flag(Flag.APPEARANCE);
    }
    public boolean busy() {
    	if (this instanceof MiniPlayer)
			return false;
        return interfaceId > 0 || isBanking || shopping || trading.inTrade() || dueling.inDuelScreen || isResting || spawningMiniPlayer;
    }

    @Getter
    @Setter
    private boolean cosmeticOveride = true;

    @Getter
    @Setter
    private int instanceID;

    private CustomTeleportInterface customTeleportInterface = new CustomTeleportInterface(this);

    public CustomTeleportInterface getCustomTeleportInterface() {
        return customTeleportInterface;
    }

    @Getter
    @Setter
    private boolean renderPlayerEquipment = true;

    public String getTitle(int i) {
        switch (i) {
            case 1:
                return "Killer";
            case 2:
                return "Slaughterer";
            case 3:
                return "Genocidal";
            case 4:
                return "Immortal";
            case 5:
                return "Skiller";
            case 6:
                return "Combatant";
            case 7:
                return "Maxed";
            case 8:
                return "Godslayer";
            case 9:
                return "Loyalist";
            case 10:
                return "Veteran";
            case 11:
                return "Looter";
            case 12:
                return "King";
            case 13:
                return "Queen";
            case 14:
                return "Lord";
            case 15:
                return "Duke";
            case 16:
                return "Duchess";
            case 17:
                return "Baron";
            case 18:
                return "Baroness";
            case 19:
                return "Sir";
            case 20:
                return "Lady";
            case 21:
                return "Evil";
            case 22:
                return "Good";
        }
        return "";
    }

    @Getter
    @Setter
    private boolean fantasy;


    @Getter
    @Setter
    private boolean diminisher;

    @Getter
    @Setter
    private boolean sacrificedFantasyItem;

    public UIMBank getUimBank() {
        return uimBank;
    }

    public EventBossManager getEventBossManager() {
        return eventBossManager;
    }

    public Map<Integer, Integer> getUimBankItems() {
        return uimBankItems;
    }

    public void setUimBankItems(Map<Integer, Integer> items) {
        uimBankItems = items;
    }

    public PlayerSession getSession() {
        return session;
    }

    public int getSlayerSprees() {
        return totalsprees;
    }

    public Slayer getSlayer() {
        return slayer;
    }
    public void incrementSlayerSprees(int totalsprees) {
        this.totalsprees += totalsprees;
    }

    public Inventory getInventory() {
    	if (this instanceof MiniPlayer)
			return getMiniPlayerOwner().getInventory();
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    /*
     * Getters and setters
     */

    public DungeoneeringIronInventory getDungeoneeringIronInventory() {
        return dungeoneeringIronInventory;
    }

    public void setDungeoneeringStorage(DungeoneeringIronInventory dungeoneeringIronInventory) {
        this.dungeoneeringIronInventory = dungeoneeringIronInventory;
    }

    public DungeoneeringIronEquipment getDungeoneeringIronEquipment() {
        return dungeoneeringIronEquipment;
    }

    public void setDungeoneeringIronEquipment(DungeoneeringIronEquipment dungeoneeringIronEquipment) {
        this.dungeoneeringIronEquipment = dungeoneeringIronEquipment;
    }

    public Equipment getPreSetEquipment() {
        return preSetEquipment;
    }

    public void setPreSetEquipment(Equipment equipment) {
        this.preSetEquipment = equipment;
    }

    public PriceChecker getPriceChecker() {
        return priceChecker;
    }

    public String getUsername() {
        return username;
    }

    public Player setUsername(String username) {
        this.username = username;
        return this;
    }

    public Long getLongUsername() {
        return longUsername;
    }

    public Player setLongUsername(Long longUsername) {
        this.longUsername = longUsername;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Player setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String address) {
        this.emailAddress = address;
    }

    public void unlockPkTitles() {
        if (this.getPlayerKillingAttributes().getPlayerKills() >= 1) {
            LoyaltyProgramme.unlock(this, LoyaltyTitles.KILLER);
        }
        if (this.getPlayerKillingAttributes().getPlayerKills() >= 20) {
            LoyaltyProgramme.unlock(this, LoyaltyTitles.SLAUGHTERER);
        }
        if (this.getPlayerKillingAttributes().getPlayerKills() >= 50) {
            LoyaltyProgramme.unlock(this, LoyaltyTitles.GENOCIDAL);
        }
        if (this.getPlayerKillingAttributes().getPlayerKillStreak() >= 15) {
            LoyaltyProgramme.unlock(this, LoyaltyTitles.IMMORTAL);
        }
        PlayerPanel.refreshPanel(this);
    }

    public void updateGearBonuses() {
        Misc.updateGearBonuses(this);
    }

    public void newStance() {
        WeaponAnimations.update(this);
        this.getUpdateFlag().flag(Flag.APPEARANCE);
        return;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public Player setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
        return this;
    }

    public String getSerialNumber() {
        return serial_number;
    }

    public Player setSerialNumber(String serial_number) {
        this.serial_number = serial_number;
        return this;
    }

    /*
Start new yt interface
 */

    public YoutubeCategory youtubeType;

    public YoutubeCategory getYoutubeType() {
        return youtubeType;
    }

    public void setYoutubeType(YoutubeCategory youtubeType) {
        this.youtubeType = youtubeType;
    }
/*
End new yt interface
 */
public YoutubeData youtubeData;

    public YoutubeData getYoutubeData() {
        return youtubeData;
    }

    public void setYoutubeData(YoutubeData youtubeData) {
        this.youtubeData = youtubeData;
    }

    public YoutubeData getCurrentData() {
        return youtubeData;
    }

    public void setCurrentData(YoutubeData youtubeData) {
        this.youtubeData = youtubeData;
    }


/*
Start new teleport
 */

    public TeleportCategory teleportType;

    public TeleportCategory getTeleportType() {
        return teleportType;
    }

    public void setTeleportType(TeleportCategory teleportType) {
    this.teleportType = teleportType;
    }
/*
End new teleport
 */

    /*
    Start Quest One
     */
    public boolean questOneStarted;
    private boolean questOneStep1;
    private boolean questOneStep2;
    private boolean questOneStep3;
    private boolean questOneStep4;
    private boolean questOneStep5;
    private boolean questOneStep6;
    private boolean questOneStep7;
    private boolean talkedToGhost;
    public void setQuestOneStarted(boolean questOneStarted) {
        this.questOneStarted = questOneStarted;
    }
    public boolean getQuestOneStarted() {
        return questOneStarted;
    }

    public void setQuestOneStep1(boolean questOneStep1) {
        this.questOneStep1 = questOneStep1;
    }
    public boolean getQuestOneStep1() {
        return questOneStep1;
    }

    public void setQuestOneStep2(boolean questOneStep2) {
        this.questOneStep2 = questOneStep2;
    }
    public boolean getQuestOneStep2() {return questOneStep2;
    }

    public void setQuestOneStep3(boolean questOneStep3) {
        this.questOneStep3 = questOneStep3;
    }
    public boolean getQuestOneStep3() {
        return questOneStep3;
    }

    public void setQuestOneStep4(boolean questOneStep4) {
        this.questOneStep4 = questOneStep4;
    }
    public boolean getQuestOneStep4() {
        return questOneStep4;
    }

    public void setQuestOneStep5(boolean questOneStep5) {
        this.questOneStep5 = questOneStep5;
    }
    public boolean getQuestOneStep5() {
        return questOneStep5; }

    public void setQuestOneStep6(boolean questOneStep6) {
        this.questOneStep6 = questOneStep6;
    }
    public boolean getQuestOneStep6() {
        return questOneStep6; }

    public void setQuestOneStep7(boolean questOneStep7) {
        this.questOneStep7 = questOneStep7;
    }
    public boolean getQuestOneStep7() {
        return questOneStep7; }

    public void setTalkedToGhost(boolean talkedToGhost) {
        this.talkedToGhost = talkedToGhost;
    }
    public boolean getTalkedToGhost() {return talkedToGhost;
    }

    /*
    End Quest One
     */


    /*
    Start Quest Two
     */
    public boolean questTwoStarted;
    private boolean questTwoStep1;
    private boolean questTwoStep2;
    private boolean questTwoStep3;
    private boolean questTwoStep4;
    private boolean questTwoStep5;
    private boolean questTwoStep6;
    private boolean questTwoStep7;

    public void setQuestTwoStarted(boolean questTwoStarted) {
        this.questTwoStarted = questTwoStarted;
    }
    public boolean getQuestTwoStarted() {
        return questTwoStarted;
    }

    public void setQuestTwoStep1(boolean questTwoStep1) {
        this.questTwoStep1 = questTwoStep1;
    }
    public boolean getQuestTwoStep1() {
        return questTwoStep1;
    }

    public void setQuestTwoStep2(boolean questTwoStep2) {
        this.questTwoStep2 = questTwoStep2;
    }
    public boolean getQuestTwoStep2() {return questTwoStep2;
    }

    public void setQuestTwoStep3(boolean questTwoStep3) {
        this.questTwoStep3 = questTwoStep3;
    }
    public boolean getQuestTwoStep3() {
        return questTwoStep3;
    }

    public void setQuestTwoStep4(boolean questTwoStep4) {
        this.questTwoStep4 = questTwoStep4;
    }
    public boolean getQuestTwoStep4() {
        return questTwoStep4;
    }

    public void setQuestTwoStep5(boolean questTwoStep5) {
        this.questTwoStep5 = questTwoStep5;
    }
    public boolean getQuestTwoStep5() {
        return questTwoStep5; }

    public void setQuestTwoStep6(boolean questTwoStep6) {
        this.questTwoStep6 = questTwoStep6;
    }
    public boolean getQuestTwoStep6() {
        return questTwoStep6; }

    public void setQuestTwoStep7(boolean questTwoStep7) {
        this.questTwoStep7 = questTwoStep7;
    }
    public boolean getQuestTwoStep7() {
        return questTwoStep7; }
    /*
    End Quest Two
     */


    /*
    Start Quest Three
     */
    public boolean questThreeStarted;
    private boolean questThreeStep1;
    private boolean questThreeStep2;
    private boolean questThreeStep3;
    private boolean questThreeStep4;
    private boolean questThreeStep5;
    private boolean questThreeStep6;
    private boolean questThreeStep7;

    public void setQuestThreeStarted(boolean questThreeStarted) {
        this.questThreeStarted = questThreeStarted;
    }
    public boolean getQuestThreeStarted() {
        return questThreeStarted;
    }

    public void setQuestThreeStep1(boolean questThreeStep1) {
        this.questThreeStep1 = questThreeStep1;
    }
    public boolean getQuestThreeStep1() {
        return questThreeStep1;
    }

    public void setQuestThreeStep2(boolean questThreeStep2) {
        this.questThreeStep2 = questThreeStep2;
    }
    public boolean getQuestThreeStep2() {return questThreeStep2;
    }

    public void setQuestThreeStep3(boolean questThreeStep3) {
        this.questThreeStep3 = questThreeStep3;
    }
    public boolean getQuestThreeStep3() {
        return questThreeStep3;
    }

    public void setQuestThreeStep4(boolean questThreeStep4) {
        this.questThreeStep4 = questThreeStep4;
    }
    public boolean getQuestThreeStep4() {
        return questThreeStep4;
    }

    public void setQuestThreeStep5(boolean questThreeStep5) {
        this.questThreeStep5 = questThreeStep5;
    }
    public boolean getQuestThreeStep5() {
        return questThreeStep5; }

    public void setQuestThreeStep6(boolean questThreeStep6) {
        this.questThreeStep6 = questThreeStep6;
    }
    public boolean getQuestThreeStep6() {
        return questThreeStep6; }

    public void setQuestThreeStep7(boolean questThreeStep7) {
        this.questThreeStep7 = questThreeStep7;
    }
    public boolean getQuestThreeStep7() {
        return questThreeStep7; }
    /*
    End Quest Three
     */

    /*
    Start Magic Guild
     */
    private boolean magicianMaster;
    private boolean magicguildtier1;
    private boolean magicguildtier2;
    private boolean magicguildtier3;
    public void setMagicGuildTier1(boolean magicguildtier1) {
        this.magicguildtier1 = magicguildtier1;
    }
    public boolean getMagicGuildTier1() {
        return magicguildtier1;
    }

    public void setMagicGuildTier2(boolean magicguildtier2) {
        this.magicguildtier2 = magicguildtier2;
    }
    public boolean getMagicGuildTier2() {
        return magicguildtier2;
    }

    public void setMagicGuildTier3(boolean magicguildtier3) {
        this.magicguildtier3 = magicguildtier3;
    }
    public boolean getMagicGuildTier3() {
        return magicguildtier3;
    }

    public void setMagicianMaster(boolean magicianMaster) {
        this.magicianMaster = magicianMaster;
    }
    public boolean getMagicianMaster() {
        return magicianMaster;
    }

    /*
    End Magic Guild
     */
    /*
    Start Warrior Guild
     */
    private boolean warriorMaster;
    private boolean warriorguildtier1;
    private boolean warriorguildtier2;
    private boolean warriorguildtier3;
    public void setWarriorGuildTier1(boolean warriorguildtier1) {
        this.warriorguildtier1 = warriorguildtier1;
    }
    public boolean getWarriorGuildTier1() {
        return warriorguildtier1;
    }

    public void setWarriorGuildTier2(boolean warriorguildtier2) {
        this.warriorguildtier2 = warriorguildtier2;
    }
    public boolean getWarriorGuildTier2() {
        return warriorguildtier2;
    }

    public void setWarriorGuildTier3(boolean warriorguildtier3) {
        this.warriorguildtier3 = warriorguildtier3;
    }
    public boolean getWarriorGuildTier3() {
        return warriorguildtier3;
    }

    public void setWarriorMaster(boolean warriorMaster) {
        this.warriorMaster = warriorMaster;
    }
    public boolean getWarriorMaster() {
        return warriorMaster;
    }

    /*
    End Warrior Guild
     */
    /*
    Start Archer Guild
     */
    private boolean archerMaster;
    private boolean archerguildtier1;
    private boolean archerguildtier2;
    private boolean archerguildtier3;
    public void setArcherGuildTier1(boolean archerguildtier1) {
        this.archerguildtier1 = archerguildtier1;
    }
    public boolean getArcherGuildTier1() {
        return archerguildtier1;
    }

    public void setArcherGuildTier2(boolean archerguildtier2) {
        this.archerguildtier2 = archerguildtier2;
    }
    public boolean getArcherGuildTier2() {
        return archerguildtier2;
    }

    public void setArcherGuildTier3(boolean archerguildtier3) {
        this.archerguildtier3 = archerguildtier3;
    }
    public boolean getArcherGuildTier3() {
        return archerguildtier3;
    }

    public void setArcherMaster(boolean archerMaster) {
        this.archerMaster = archerMaster;
    }
    public boolean getArcherMaster() {
        return archerMaster;
    }

    /*
    End Archer Guild
     */




    /*
    Start Fallen Angels
     */
    private boolean miniLucifer;
    public void setMiniLucifer(boolean miniLucifer) {
        this.miniLucifer = miniLucifer;
    }
    public boolean getMiniLucifer() {
        return miniLucifer;
    }

    /*
    End Fallen Angels
     */

    @Getter
    @Setter
    private int lastVotedDay = 0;
    /*
    Start Midnight Goblins
     */
    private boolean darkSupreme;
    public void setDarkSupreme(boolean darkSupreme) {
        this.darkSupreme = darkSupreme;
    }
    public boolean getDarkSupreme() {
        return darkSupreme;
    }
    /*
    End Midnight Goblins
     */

    public TeleportData teleportData;

    public TeleportData getTeleportData() {
        return teleportData;
    }

    public void setTeleportData(TeleportData teleportData) {
        this.teleportData = teleportData;
    }

    public TeleportData getCurrentTeleport() {
        return teleportData;
    }

    public void setCurrentTeleport(TeleportData teleportData) {
        this.teleportData = teleportData;
    }


    public WardrobeData wardrobeData;

    public WardrobeData getWardrobeData() {
        return wardrobeData;
    }

    public void setWardrobeData() {
        this.wardrobeData = wardrobeData;
    }
    public void setWardrobeData(WardrobeData wardrobeData) {
        this.wardrobeData = wardrobeData;
    }

    public WardrobeData getCurrentWardrobe() {
        return wardrobeData;
    }

    public void setCurrentWardrobe(WardrobeData wardrobeData) {
        this.wardrobeData = wardrobeData;
    }

    public WardrobeCategory wardrobeType;

    public WardrobeCategory getWardrobeType() {
        return wardrobeType;
    }

    public void setWardrobeType(WardrobeCategory wardrobeType) {
        this.wardrobeType = wardrobeType;
    }


    @Getter
    private VotingStreak votingStreak = new VotingStreak(this);
    /*
End new teleport
 */
    public FrameUpdater getFrameUpdater() {
        return this.frameUpdater;
    }

    public PlayerRights getRights() {
        return rights;
    }

    public Player setRights(PlayerRights rights) {
        this.rights = rights;
        return this;
    }

    public ChatMessage getChatMessages() {
        return chatMessages;
    }

    public PacketSender getPacketSender() {
        return packetSender;
    }

    public PacketSender getPA() {
        return packetSender;
    }

    public SkillManager getSkillManager() {
        return skillManager;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public PlayerRelations getRelations() {
        return relations;
    }

    public PlayerKillingAttributes getPlayerKillingAttributes() {
        return playerKillingAttributes;
    }

    public PointsHandler getPointsHandler() {
        return pointsHandler;
    }
    public void setunlockedseasonpass(boolean unlockedpass) {
        this.unlockedseasonpass = unlockedpass;
    }
    public boolean isunlockedseasonpass() {
        return unlockedseasonpass;
    }

    public void setUnlockedMembership(boolean unlockedMembership) {
        this.unlockedMembership = unlockedMembership;
    }
    public boolean isMembershipUnlocked() {
        return unlockedMembership;
    }
    public void setUnlockedCosmetic(boolean unlockedCosmetic) {
        this.unlockedCosmetic = unlockedCosmetic;
    }
    public boolean isCosmeticUnlocked() {
        return unlockedCosmetic;
    }
    public int set500kcforseasonpass(int kc) {
        return this.kc500forseasonpass = kc;
    }
    public int getkc500forseasonpass() {
        return this.kc500forseasonpass;
    }
    private int kc500forseasonpass;

    public CurrencyPouch getCurrencyPouch() {
        return currencyPouch;
    }

    public boolean isImmuneToDragonFire() {
        return dragonFireImmunity > 0;
    }

    public int getDragonFireImmunity() {
        return dragonFireImmunity;
    }

    public void setDragonFireImmunity(int dragonFireImmunity) {
        this.dragonFireImmunity = dragonFireImmunity;
    }

    public void incrementDragonFireImmunity(int amount) {
        dragonFireImmunity += amount;
    }

    public void decrementDragonFireImmunity(int amount) {
        dragonFireImmunity -= amount;
    }

    public int getPoisonImmunity() {
        return poisonImmunity;
    }

    public void setPoisonImmunity(int poisonImmunity) {
        this.poisonImmunity = poisonImmunity;
    }

    public void incrementPoisonImmunity(int amount) {
        poisonImmunity += amount;
    }

    public void decrementPoisonImmunity(int amount) {
        poisonImmunity -= amount;
    }

    public boolean isAutoRetaliate() {
        return autoRetaliate;
    }

    public void setAutoRetaliate(boolean autoRetaliate) {
        this.autoRetaliate = autoRetaliate;
    }

    /**
     * @return the castSpell
     */
    public CombatSpell getCastSpell() {
        return castSpell;
    }

    /**
     * @param castSpell the castSpell to set
     */
    public void setCastSpell(CombatSpell castSpell) {
        this.castSpell = castSpell;
    }

    public CombatSpell getPreviousCastSpell() {
        return previousCastSpell;
    }

    public void setPreviousCastSpell(CombatSpell previousCastSpell) {
        this.previousCastSpell = previousCastSpell;
    }

    /**
     * @return the autocast
     */
    public boolean isAutocast() {
        return autocast;
    }

    /**
     * @param autocast the autocast to set
     */
    public void setAutocast(boolean autocast) {
        this.autocast = autocast;
    }

    public boolean couldHeal() {
        boolean nexEffect = getEquipment().wearingNexAmours();
        int level = skillManager.getMaxLevel(Skill.CONSTITUTION);
        int nexHp = level + 400;
        int currentlevel = skillManager.getCurrentLevel(Skill.CONSTITUTION);

        if (currentlevel >= level && !nexEffect) {
            return false;
        }
        return currentlevel < nexHp || !nexEffect;
    }

    /**
     * @return the skullTimer
     */
    public int getSkullTimer() {
        return skullTimer;
    }

    /**
     * @param skullTimer the skullTimer to set
     */
    public void setSkullTimer(int skullTimer) {
        this.skullTimer = skullTimer;
    }

    public void decrementSkullTimer() {
        skullTimer -= 50;
    }

    /**
     * @return the skullIcon
     */
    public int getSkullIcon() {
        return skullIcon;
    }

    /**
     * @param skullIcon the skullIcon to set
     */
    public void setSkullIcon(int skullIcon) {
        this.skullIcon = skullIcon;
    }

    /**
     * @return the teleblockTimer
     */
    public int getTeleblockTimer() {
        return teleblockTimer;
    }

    /**
     * @param teleblockTimer the teleblockTimer to set
     */
    public void setTeleblockTimer(int teleblockTimer) {
        this.teleblockTimer = teleblockTimer;
    }

    public void decrementTeleblockTimer() {
        teleblockTimer--;
    }

    /**
     * @return the autocastSpell
     */
    public CombatSpell getAutocastSpell() {
        return autocastSpell;
    }

    /**
     * @param autocastSpell the autocastSpell to set
     */
    public void setAutocastSpell(CombatSpell autocastSpell) {
        this.autocastSpell = autocastSpell;
    }

    /**
     * @return the specialPercentage
     */
    public int getSpecialPercentage() {
        return specialPercentage;
    }

    /**
     * @param specialPercentage the specialPercentage to set
     */
    public void setSpecialPercentage(int specialPercentage) {
        this.specialPercentage = specialPercentage;
    }

    /**
     * @return the fireAmmo
     */
    public int getFireAmmo() {
        return fireAmmo;
    }

    /**
     * @param fireAmmo the fireAmmo to set
     */
    public void setFireAmmo(int fireAmmo) {
        this.fireAmmo = fireAmmo;
    }

    public int getWildernessLevel() {
        return wildernessLevel;
    }

    public void setWildernessLevel(int wildernessLevel) {
        this.wildernessLevel = wildernessLevel;
    }

    /**
     * @return the combatSpecial
     */
    public CombatSpecial getCombatSpecial() {
        return combatSpecial;
    }

    /**
     * @param combatSpecial the combatSpecial to set
     */
    public void setCombatSpecial(CombatSpecial combatSpecial) {
        this.combatSpecial = combatSpecial;
    }

    /**
     * @return the specialActivated
     */
    public boolean isSpecialActivated() {
        return specialActivated;
    }

    /**
     * @param specialActivated the specialActivated to set
     */
    public void setSpecialActivated(boolean specialActivated) {
        this.specialActivated = specialActivated;
    }

    public void decrementSpecialPercentage(int drainAmount) {
        this.specialPercentage -= drainAmount;

        if (specialPercentage < 0) {
            specialPercentage = 0;
        }
    }

    public void incrementSpecialPercentage(int gainAmount) {
        this.specialPercentage += gainAmount;

        if (specialPercentage > 100) {
            specialPercentage = 100;
        }
    }

    /**
     * @return the rangedAmmo
     */
    public RangedWeaponData getRangedWeaponData() {
        return rangedWeaponData;
    }

    public void setRangedWeaponData(RangedWeaponData rangedWeaponData) {
        this.rangedWeaponData = rangedWeaponData;
    }

    /**
     * @return the weapon.
     */
    public WeaponInterface getWeapon() {
        return weapon;
    }

    /**
     * @param weapon the weapon to set.
     */
    public void setWeapon(WeaponInterface weapon) {
        this.weapon = weapon;
    }

    /**
     * @return the fightType
     */
    public FightType getFightType() {
        return fightType;
    }

    /**
     * @param fightType the fightType to set
     */
    public void setFightType(FightType fightType) {
        this.fightType = fightType;
    }

    public Bank[] getBanks() {
    	if (this instanceof MiniPlayer)
			return this.getMiniPlayerOwner().getBanks();
        return bankTabs;
    }

    public void setMiniPBanks() {
		for (int i = 0; i <= 8; i++) {
			bankTabs[i] = new Bank(this);
		}
	}
    
    public Bank getBank(int index) {
        return bankTabs[index];
    }

    public Player setBank(int index, Bank bank) {
        this.bankTabs[index] = bank;
        return this;
    }

    public boolean isAcceptAid() {
        return acceptingAid;
    }

    public void setAcceptAid(boolean acceptingAid) {
        this.acceptingAid = acceptingAid;
    }

    public Trading getTrading() {
        return trading;
    }

    public Dueling getDueling() {
        return dueling;
    }

    public CopyOnWriteArrayList<KillsEntry> getKillsTracker() {
        return killsTracker;
    }

    public CopyOnWriteArrayList<DropLogEntry> getDropLog() {
        return dropLog;
    }

    public WalkToTask getWalkToTask() {
        return walkToTask;
    }

    public void setWalkToTask(WalkToTask walkToTask) {
        this.walkToTask = walkToTask;
    }

    public MagicSpellbook getSpellbook() {
        return spellbook;
    }

    public Player setSpellbook(MagicSpellbook spellbook) {
        this.spellbook = spellbook;
        return this;
    }

    public Prayerbook getPrayerbook() {
        return prayerbook;
    }

    public Player setPrayerbook(Prayerbook prayerbook) {
        this.prayerbook = prayerbook;
        return this;
    }

    /**
     * The player's local players list.
     */
    public List<Player> getLocalPlayers() {
        return localPlayers;
    }

    /**
     * The player's local npcs list getter
     */
    public List<NPC> getLocalNpcs() {
        return localNpcs;
    }

    public CopyOnWriteArrayList<NPC> getNpcFacesUpdated() {
        return npc_faces_updated;
    }

    public int getInterfaceId() {
        return this.interfaceId;
    }

    public Player setInterfaceId(int interfaceId) {
        this.interfaceId = interfaceId;
        return this;
    }

    public boolean isDying() {
        return isDying;
    }

    public void setDying(boolean isDying) {
        this.isDying = isDying;
    }

    public int[] getForceMovement() {
        return forceMovement;
    }

    public Player setForceMovement(int[] forceMovement) {
        this.forceMovement = forceMovement;
        return this;
    }

    /**
     * @return the equipmentAnimation
     */
    public CharacterAnimations getCharacterAnimations() {
        return characterAnimations;
    }

    /**
     * @return the equipmentAnimation
     */
    public void setCharacterAnimations(CharacterAnimations equipmentAnimation) {
        this.characterAnimations = equipmentAnimation.clone();
    }

    public LoyaltyTitles getLoyaltyTitle() {
        return loyaltyTitle;
    }

    public void setLoyaltyTitle(LoyaltyTitles loyaltyTitle) {
        this.loyaltyTitle = loyaltyTitle;
    }

    public PlayerInteractingOption getPlayerInteractingOption() {
        return playerInteractingOption;
    }

    public Player setPlayerInteractingOption(PlayerInteractingOption playerInteractingOption) {
        this.playerInteractingOption = playerInteractingOption;
        return this;
    }

    public int getMultiIcon() {
        return multiIcon;
    }

    public Player setMultiIcon(int multiIcon) {
        this.multiIcon = multiIcon;
        return this;
    }

    // This is pretty much useless because walkableinterface is an array and is not saved on logout
    public int getWalkableInterfaceId() {
        return walkableInterfaceId;
    }

    public void setWalkableInterfaceId(int interfaceId2) {
        this.walkableInterfaceId = interfaceId2;
    }

    public boolean soundsActive() {
        return soundsActive;
    }

    public void setSoundsActive(boolean soundsActive) {
        this.soundsActive = soundsActive;
    }

    public boolean musicActive() {
        return musicActive;
    }

    public void setMusicActive(boolean musicActive) {
        this.musicActive = musicActive;
    }

    public BonusManager getBonusManager() {
        return bonusManager;
    }

    public int getRunEnergy() {
        return runEnergy;
    }

    public Player setRunEnergy(int runEnergy) {
        this.runEnergy = runEnergy;
        return this;
    }

    public Stopwatch getLastRunRecovery() {
        return lastRunRecovery;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public Player setRunning(boolean isRunning) {
        this.isRunning = isRunning;
        return this;
    }

    public boolean isResting() {
        return isResting;
    }

    public Player setResting(boolean isResting) {
        this.isResting = isResting;
        return this;
    }


    public long getSoulInPouch() {
        return soulInPouch;
    }

    public void setSoulInPouch(long soulInPouch) {
        this.soulInPouch = soulInPouch;
    }

    public int getSoulInPouchAsInt() {
        return soulInPouch > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) soulInPouch;
    }

    public boolean experienceLocked() {
        return experienceLocked;
    }

    public void setExperienceLocked(boolean experienceLocked) {
        this.experienceLocked = experienceLocked;
    }

    public boolean isClientExitTaskActive() {
        return clientExitTaskActive;
    }

    public void setClientExitTaskActive(boolean clientExitTaskActive) {
        this.clientExitTaskActive = clientExitTaskActive;
    }


    public String getYellHex() {
        return yellHex;
    }

    public Player setYellHex(String yellHex) {
        this.yellHex = yellHex;
        return this;
    }

    public Input getInputHandling() {
        return inputHandling;
    }

    public void setInputHandling(Input inputHandling) {
        this.inputHandling = inputHandling;
    }

    public boolean isDrainingPrayer() {
        return drainingPrayer;
    }

    public void setDrainingPrayer(boolean drainingPrayer) {
        this.drainingPrayer = drainingPrayer;
    }

    public Stopwatch getClickDelay() {
        return clickDelay;
    }

    public int[] getLeechedBonuses() {
        return leechedBonuses;
    }

    public Stopwatch getLastItemPickup() {
        return lastItemPickup;
    }

    public Stopwatch getLastSummon() {
        return lastSummon;
    }

    public BankSearchAttributes getBankSearchingAttribtues() {
        return bankSearchAttributes;
    }


    public BankPinAttributes getBankPinAttributes() {
        return bankPinAttributes;
    }

    public int getCurrentBankTab() {
        return currentBankTab;
    }

    public Player setCurrentBankTab(int tab) {
        this.currentBankTab = tab;
        return this;
    }

    public boolean isBanking() {
        return isBanking;
    }

    public Player setBanking(boolean isBanking) {
        this.isBanking = isBanking;
        return this;
    }

    public void setNoteWithdrawal(boolean noteWithdrawal) {
        this.noteWithdrawal = noteWithdrawal;
    }

    public boolean withdrawAsNote() {
        return noteWithdrawal;
    }

    public void setSwapMode(boolean swapMode) {
        this.swapMode = swapMode;
    }

    public boolean swapMode() {
        return swapMode;
    }

    public boolean isShopping() {
        return shopping;
    }

    public void setShopping(boolean shopping) {
        this.shopping = shopping;
    }

    public Shop getShop() {
        return shop;
    }

    public Player setShop(Shop shop) {
        this.shop = shop;
        return this;
    }

    public GameObject getInteractingObject() {
        return interactingObject;
    }

    public Player setInteractingObject(GameObject interactingObject) {
        this.interactingObject = interactingObject;
        return this;
    }

    public Item getInteractingItem() {
        return interactingItem;
    }

    public void setInteractingItem(Item interactingItem) {
        this.interactingItem = interactingItem;
    }

    public Dialogue getDialogue() {
        return this.dialogue;
    }

    public void setDialogue(Dialogue dialogue) {
        this.dialogue = dialogue;
    }

    public int getDialogueActionId() {
        return dialogueActionId;
    }

    public void setDialogueActionId(int dialogueActionId) {
        this.dialogueActionId = dialogueActionId;
    }

    public boolean isSettingUpCannon() {
        return settingUpCannon;
    }

    public void setSettingUpCannon(boolean settingUpCannon) {
        this.settingUpCannon = settingUpCannon;
    }

    public DwarfCannon getCannon() {
        return cannon;
    }

    public Player setCannon(DwarfCannon cannon) {
        this.cannon = cannon;
        return this;
    }

    public int getOverloadPotionTimer() {
        return overloadPotionTimer;
    }

    public void setOverloadPotionTimer(int overloadPotionTimer) {
        this.overloadPotionTimer = overloadPotionTimer;
    }

    public int getPrayerRenewalPotionTimer() {
        return prayerRenewalPotionTimer;
    }

    public void setPrayerRenewalPotionTimer(int prayerRenewalPotionTimer) {
        this.prayerRenewalPotionTimer = prayerRenewalPotionTimer;
    }

    public Stopwatch getSpecialRestoreTimer() {
        return specialRestoreTimer;
    }

    public boolean[] getUnlockedLoyaltyTitles() {
        return unlockedLoyaltyTitles;
    }

    public void setUnlockedLoyaltyTitles(boolean[] unlockedLoyaltyTitles) {
        this.unlockedLoyaltyTitles = unlockedLoyaltyTitles;
    }

    public void setUnlockedLoyaltyTitle(int index) {
        unlockedLoyaltyTitles[index] = true;
    }

    public Stopwatch getEmoteDelay() {
        return emoteDelay;
    }

    public MinigameAttributes getMinigameAttributes() {
        return minigameAttributes;
    }

    public int getFireImmunity() {
        return fireImmunity;
    }

    public Player setFireImmunity(int fireImmunity) {
        this.fireImmunity = fireImmunity;
        return this;
    }

    public int getFireDamageModifier() {
        return fireDamageModifier;
    }

    public Player setFireDamageModifier(int fireDamageModifier) {
        this.fireDamageModifier = fireDamageModifier;
        return this;
    }

    public boolean hasVengeance() {
        return hasVengeance;
    }

    public void setHasVengeance(boolean hasVengeance) {
        this.hasVengeance = hasVengeance;
    }

    public Stopwatch getLastVengeance() {
        return lastVengeance;
    }

    public Stopwatch getTolerance() {
        return tolerance;
    }

    public boolean isTargeted() {
        return targeted;
    }

    public void setTargeted(boolean targeted) {
        this.targeted = targeted;
    }

    public Stopwatch getLastYell() {
        return lastYell;
    }

    public Stopwatch getLastVoteClaim() {
        return lastVoteClaim;
    }

    public int getAmountDonated() {
        return amountDonated;
    }

    public void incrementAmountDonated(int amountDonated) {
        this.amountDonated += amountDonated;
    }

    //u can take right method of killtracker   yeah ik, just tryna see what suic was doing that's all ;p
    public int getNPCKILLCount() {
        return npckillcount;
    }

    public void incrementNPCKILLCount(int npckillcount) {
        this.npckillcount += npckillcount;
    }

    public int getTotalPrestiges() {
        return totalprestiges;
    }
    public void incrementTotalPrestiges(int totalprestiges) {
        this.totalprestiges += totalprestiges;
    }


    public long getTotalPlayTime() {
        return totalPlayTime;
    }

    public void setTotalPlayTime(long amount) {
        this.totalPlayTime = amount;
    }

    public Stopwatch getRecordedLogin() {
        return recordedLogin;
    }

    public Player setRegionChange(boolean regionChange) {
        this.regionChange = regionChange;
        return this;
    }

    public boolean isChangingRegion() {
        return this.regionChange;
    }

    public boolean isAllowRegionChangePacket() {
        return allowRegionChangePacket;
    }

    public void setAllowRegionChangePacket(boolean allowRegionChangePacket) {
        this.allowRegionChangePacket = allowRegionChangePacket;
    }

    public boolean isKillsTrackerOpen() {
        return killsTrackerOpen;
    }

    public void setKillsTrackerOpen(boolean killsTrackerOpen) {
        this.killsTrackerOpen = killsTrackerOpen;
    }

    public boolean isCoughing() {
        return isCoughing;
    }

    public void setCoughing(boolean isCoughing) {
        this.isCoughing = isCoughing;
    }

    public int getShadowState() {
        return shadowState;
    }

    public void setShadowState(int shadow) {
        this.shadowState = shadow;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public int getGameModeIconId() {
        if (this.getGameMode() == GameMode.IRONMAN) {
            return 840;
        }
        if (this.getGameMode() == GameMode.ULTIMATE_IRONMAN) {
            return 839;
        }
        if (this.getGameMode() == GameMode.VETERAN_MODE) {
            return 838;
        }
        if (this.getGameMode() == GameMode.GROUP_IRONMAN) {
            return 1509;
        }
        return -1;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isPlayerLocked() {
        return playerLocked;
    }

    public Player setPlayerLocked(boolean playerLocked) {
        this.playerLocked = playerLocked;
        return this;
    }

    public Stopwatch getSqlTimer() {
        return sqlTimer;
    }

    public Stopwatch getFoodTimer() {
        return foodTimer;
    }

    public Stopwatch getPotionTimer() {
        return potionTimer;
    }

    public Item getUntradeableDropItem() {
        return untradeableDropItem;
    }

    public void setUntradeableDropItem(Item untradeableDropItem) {
        this.untradeableDropItem = untradeableDropItem;
    }

    public boolean isRecoveringSpecialAttack() {
        return recoveringSpecialAttack;
    }

    public void setRecoveringSpecialAttack(boolean recoveringSpecialAttack) {
        this.recoveringSpecialAttack = recoveringSpecialAttack;
    }

    public CombatType getLastCombatType() {
        return lastCombatType;
    }

    public void setLastCombatType(CombatType lastCombatType) {
        this.lastCombatType = lastCombatType;
    }

    public int getEffigy() {
        return this.effigy;
    }

    public void setEffigy(int effigy) {
        this.effigy = effigy;
    }

    public int getDfsCharges() {
        return dfsCharges;
    }
    public void setDfsCharges(int amount) {
        this.dfsCharges = amount;
    }

    public void incrementDfsCharges(int amount) {
        this.dfsCharges += amount;
    }

    public int getSupremeCharges() {
        return supremeCharges;
    }
    public void setSupremeCharges(int amount) {
        this.supremeCharges = amount;
    }

    public void incrementSupremeCharges(int amount) {
        this.supremeCharges += amount;
    }
    public void decrementSupremeCharges(int amount) {
        this.supremeCharges -= amount;
    }

    public int getNephSwordCharges() {
        return nephSwordCharges;
    }
    public void setNephSwordCharges(int amount) {
        this.nephSwordCharges = amount;
    }

    public void incrementNephSwordCharges(int amount) {
        this.nephSwordCharges += amount;
    }


    public int getNephStaffCharges() {
        return nephStaffCharges;
    }
    public void setNephStaffCharges(int amount) {
        this.nephStaffCharges = amount;
    }
    public void incrementNephStaffCharges(int amount) {
        this.nephStaffCharges += amount;
    }

    public int getNephBowCharges() {
        return nephBowCharges;
    }
    public void setNephBowCharges(int amount) {
        this.nephBowCharges = amount;
    }
    public void incrementNephBowCharges(int amount) {
        this.nephBowCharges += amount;
    }



    public int getGuardianBonus() {
        return guardianBonus;
    }

    public void setGuardianBonus(int amount) {
        this.guardianBonus = amount;
    }

    public void incrementGuardianBonus(int amount) {
        this.guardianBonus += amount;
    }


    public int lastInstanceNpc = -1;

    public int getNephilimBonus() {
        return nephilimBonus;
    }

    public void setNephilimBonus(int amount) {
        this.nephilimBonus = amount;
        if (this.nephilimBonus > 250)
            this.nephilimBonus = 250;
    }

    public void incrementNephilimBonus(int amount) {
        this.nephilimBonus += amount;
        if (this.nephilimBonus > 250)
            this.nephilimBonus = 250;
    }

    public void setNewPlayer(boolean newPlayer) {
        this.newPlayer = newPlayer;
    }

    public boolean newPlayer() {
        return newPlayer;
    }

    public Stopwatch getLogoutTimer() {
        return lougoutTimer;
    }

    public Player setUsableObject(int index, Object usableObject) {
        this.usableObject[index] = usableObject;
        return this;
    }

    public Object[] getUsableObject() {
        return usableObject;
    }

    public Player setUsableObject(Object[] usableObject) {
        this.usableObject = usableObject;
        return this;
    }

    public int getPlayerViewingIndex() {
        return playerViewingIndex;
    }

    public void setPlayerViewingIndex(int playerViewingIndex) {
        this.playerViewingIndex = playerViewingIndex;
    }

    public boolean hasStaffOfLightEffect() {
        return staffOfLightEffect > 0;
    }

    public int getStaffOfLightEffect() {
        return staffOfLightEffect;
    }

    public void setStaffOfLightEffect(int staffOfLightEffect) {
        this.staffOfLightEffect = staffOfLightEffect;
    }

    public void decrementStaffOfLightEffect() {
        this.staffOfLightEffect--;
    }

    public boolean openBank() {
        return openBank;
    }

    public void setOpenBank(boolean openBank) {
        this.openBank = openBank;
    }

    public int getMinutesBonusExp() {
        return minutesBonusExp;
    }

    public void setMinutesBonusExp(int minutesBonusExp, boolean add) {
        this.minutesBonusExp = (add ? this.minutesBonusExp + minutesBonusExp : minutesBonusExp);
    }

    public void setInactive(boolean inActive) {
        this.inActive = inActive;
    }

    public boolean isInActive() {
        return inActive;
    }


    public void setSupremeTbed(boolean supremeTbed) {
        this.supremeTbed = supremeTbed;
    }

    public boolean isSupremeTbed(boolean supremeTbed) {
        return supremeTbed;
    }

    public int getMinutesVotingDR() {
        return minutesVotingDR;
    }

    public void setMinutesVotingDR(int minutesVotingDR, boolean add) {
        this.minutesVotingDR = (add ? this.minutesVotingDR + minutesVotingDR : minutesVotingDR);
    }

    public int getMinutesVotingDMG() {
        return minutesVotingDMG;
    }

    public void setMinutesVotingDMG(int minutesVotingDMG, boolean add) {
        this.minutesVotingDMG = (add ? this.minutesVotingDMG + minutesVotingDMG : minutesVotingDMG);
    }

    public int getSelectedGeItem() {
        return selectedGeItem;
    }

    public void setSelectedGeItem(int selectedGeItem) {
        this.selectedGeItem = selectedGeItem;
    }

    public int getGeQuantity() {
        return geQuantity;
    }

    public void setGeQuantity(int geQuantity) {
        this.geQuantity = geQuantity;
    }

    public int getGePricePerItem() {
        return gePricePerItem;
    }

    public void setGePricePerItem(int gePricePerItem) {
        this.gePricePerItem = gePricePerItem;
    }

    public GrandExchangeSlot[] getGrandExchangeSlots() {
        return grandExchangeSlots;
    }

    public void setGrandExchangeSlots(GrandExchangeSlot[] GrandExchangeSlots) {
        this.grandExchangeSlots = GrandExchangeSlots;
    }

    public void setGrandExchangeSlot(int index, GrandExchangeSlot state) {
        this.grandExchangeSlots[index] = state;
    }

    public int getSelectedGeSlot() {
        return selectedGeSlot;
    }

    public void setSelectedGeSlot(int slot) {
        this.selectedGeSlot = slot;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(Task currentTask) {
        this.currentTask = currentTask;
    }

    public int getSelectedSkillingItem() {
        return selectedSkillingItem;
    }

    public void setSelectedSkillingItem(int selectedItem) {
        this.selectedSkillingItem = selectedItem;
    }

    public int getSelectedSkillingItemTwo() {
        return selectedSkillingItemTwo;
    }

    public void setSelectedSkillingItemTwo(int selectedItem) {
        this.selectedSkillingItemTwo = selectedItem;
    }

    public boolean shouldProcessFarming() {
        return processFarming;
    }

    public void setProcessFarming(boolean processFarming) {
        this.processFarming = processFarming;
    }

    public Pouch getSelectedPouch() {
        return selectedPouch;
    }

    public void setSelectedPouch(Pouch selectedPouch) {
        this.selectedPouch = selectedPouch;
    }

    public int getCurrentBookPage() {
        return currentBookPage;
    }

    public void setCurrentBookPage(int currentBookPage) {
        this.currentBookPage = currentBookPage;
    }

    public int getStoredRuneEssence() {
        return storedRuneEssence;
    }

    public void setStoredRuneEssence(int storedRuneEssence) {
        this.storedRuneEssence = storedRuneEssence;
    }

    public int getStoredPureEssence() {
        return storedPureEssence;
    }

    public void setStoredPureEssence(int storedPureEssence) {
        this.storedPureEssence = storedPureEssence;
    }

    public int getTrapsLaid() {
        return trapsLaid;
    }

    public void setTrapsLaid(int trapsLaid) {
        this.trapsLaid = trapsLaid;
    }

    public boolean isCrossingObstacle() {
        return crossingObstacle;
    }

    public Player setCrossingObstacle(boolean crossingObstacle) {
        this.crossingObstacle = crossingObstacle;
        return this;
    }

    public boolean[] getCrossedObstacles() {
        return crossedObstacles;
    }

    public void setCrossedObstacles(boolean[] crossedObstacles) {
        this.crossedObstacles = crossedObstacles;
    }

    public boolean[] getHween2016All() {
        return hween2016;
    }

    public void setHween2016All(boolean[] boolAray) {
        this.hween2016 = boolAray;
    }
    private boolean[] bossPets = new boolean[100]; // [BossPet.values().length]

    public Player setBossPet(int i, boolean completed) {
        bossPets[i] = completed;
        return this;
    }
    public boolean[] getBossPetsAll() {
        return bossPets;
    }
    public boolean getBossPet(int i) {
        return bossPets[i];
    }

    public void setBossPetsAll(boolean[] Array) {
        this.bossPets = Array;
    }
    public int getChristmas2016() {
        return christmas2016;
    }


    public boolean getCrossedObstacle(int i) {
        return crossedObstacles[i];
    }

    public boolean getHween2016(int i) {
        return hween2016[i];
    }


    public int getEaster2017() {
        return this.easter2017;
    }

    public void setEaster2017(int easter2017) {
        this.easter2017 = easter2017;
    }

    public Player setCrossedObstacle(int i, boolean completed) {
        crossedObstacles[i] = completed;
        return this;
    }

    public Player setHween2016(int i, boolean completed) {
        hween2016[i] = completed;
        return this;
    }

    public int getSkillAnimation() {
        return skillAnimation;
    }

    public Player setSkillAnimation(int animation) {
        this.skillAnimation = animation;
        return this;
    }

    public int[] getOres() {
        return ores;
    }

    public void setOres(int[] ores) {
        this.ores = ores;
    }

    public Position getResetPosition() {
        return resetPosition;
    }

    public void setResetPosition(Position resetPosition) {
        this.resetPosition = resetPosition;
    }


    public ClueScrollTask getCurrentClue() {
        return currentClue;
    }

    public Summoning getSummoning() {
        return summoning;
    }

    public Farming getFarming() {
        return farming;
    }

    public boolean inConstructionDungeon() {
        return inConstructionDungeon;
    }

    public void setInConstructionDungeon(boolean inConstructionDungeon) {
        this.inConstructionDungeon = inConstructionDungeon;
    }

    public int getHouseServant() {
        return houseServant;
    }

    public void setHouseServant(int houseServant) {
        this.houseServant = houseServant;
    }

    public int getHouseServantCharges() {
        return this.houseServantCharges;
    }

    public void setHouseServantCharges(int houseServantCharges) {
        this.houseServantCharges = houseServantCharges;
    }

    public void incrementHouseServantCharges() {
        this.houseServantCharges++;
    }

    public int getServantItemFetch() {
        return servantItemFetch;
    }

    public void setServantItemFetch(int servantItemFetch) {
        this.servantItemFetch = servantItemFetch;
    }

    public int getPortalSelected() {
        return portalSelected;
    }

    public void setPortalSelected(int portalSelected) {
        this.portalSelected = portalSelected;
    }

    public boolean isBuildingMode() {
        return this.isBuildingMode;
    }

    public void setIsBuildingMode(boolean isBuildingMode) {
        this.isBuildingMode = isBuildingMode;
    }

    public int[] getConstructionCoords() {
        return constructionCoords;
    }

    public void setConstructionCoords(int[] constructionCoords) {
        this.constructionCoords = constructionCoords;
    }

    public int getBuildFurnitureId() {
        return this.buildFurnitureId;
    }

    public void setBuildFuritureId(int buildFuritureId) {
        this.buildFurnitureId = buildFuritureId;
    }

    public void setchristmas2016(int christmas2016) {
        this.christmas2016 = christmas2016;
    }

    public int getLastTomed() {
        return this.lastTomed;
    }

    public void setLastTomed(int lastTomed) {
        this.lastTomed = lastTomed;
    }

    public int getNewYear2017() {
        return this.newYear2017;
    }

    public void setNewYear2017(int newYear2017) {
        this.newYear2017 = newYear2017;
    }

    public int getBuildFurnitureX() {
        return this.buildFurnitureX;
    }

    public void setBuildFurnitureX(int buildFurnitureX) {
        this.buildFurnitureX = buildFurnitureX;
    }

    public int getBuildFurnitureY() {
        return this.buildFurnitureY;
    }

    public void setBuildFurnitureY(int buildFurnitureY) {
        this.buildFurnitureY = buildFurnitureY;
    }

    public int getCombatRingType() {
        return this.combatRingType;
    }

    public void setCombatRingType(int combatRingType) {
        this.combatRingType = combatRingType;
    }

    public Room[][][] getHouseRooms() {
        return houseRooms;
    }

    public void setHouseRooms(Room[][][] houseRooms) {
        this.houseRooms = houseRooms;
    }

    public ArrayList<Portal> getHousePortals() {
        return housePortals;
    }

    public void setHousePortals(ArrayList<Portal> housePortals) {
        this.housePortals = housePortals;
    }

    public ArrayList<HouseFurniture> getHouseFurniture() {
        return houseFurniture;
    }

    public void setHouseFurniture(ArrayList<HouseFurniture> houseFurniture) {
        this.houseFurniture = houseFurniture;

    }

    public int getConstructionInterface() {
        return this.constructionInterface;
    }

    public void setConstructionInterface(int constructionInterface) {
        this.constructionInterface = constructionInterface;
    }

    public int[] getBrawlerChargers() {
        return this.brawlerCharges;
    }

    public void setBrawlerCharges(int[] brawlerCharges) {
        this.brawlerCharges = brawlerCharges;
    }

    public int[] getAncientArmourCharges() {
        return this.ancientArmourCharges;
    }

    public void setAncientArmourCharges(int[] ancientArmourCharges) {
        this.ancientArmourCharges = ancientArmourCharges;
    }

    public int getRecoilCharges() {
        return this.recoilCharges;
    }

    public int setRecoilCharges(int recoilCharges) {
        return this.recoilCharges = recoilCharges;
    }

    public int getStarterCharges() {
        return this.starterCharges;
    }

    public int setStarterCharges(int starterCharges) {
        return this.starterCharges = starterCharges;
    }

    public int getBlowpipeCharges() {
        return this.blowpipeCharges;
    }

    public int setBlowpipeCharges(int blowpipeCharges) {
        return this.blowpipeCharges = blowpipeCharges;
    }

    public boolean voteMessageSent() {
        return this.voteMessageSent;
    }

    public void setVoteMessageSent(boolean voteMessageSent) {
        this.voteMessageSent = voteMessageSent;
    }

    public boolean didReceiveStarter() {
        return receivedStarter;
    }

    public boolean didFriday13May2016() {
        return fri13may16;
    }

    public boolean isFlying() {
        return flying;
    }

    public void setFlying(boolean flying) {
        this.flying = flying;
    }

    public boolean canFly() {
        return canFly;
    }

    public boolean isGhostWalking() {
        return ghostWalking;
    }

    public void setGhostWalking(boolean ghostWalking) {
        this.ghostWalking = ghostWalking;
    }

    public boolean canGhostWalk() {
        return canGhostWalk;
    }

    public boolean doneHween2016() {
        return doneHween2016;
    }

    public boolean toggledGlobalMessages() {
        return toggledglobalmessages;
    }

    public boolean isSpiritDebug() {
        return spiritdebug;
    }

    public void setSpiritDebug(boolean spiritdebug) {
        this.spiritdebug = spiritdebug;
    }

    public boolean isInDung() {
        return indung;
    }

    public void setInDung(boolean indung) {
        this.indung = indung;
    }

    public boolean gotReffered() {
        return reffered;
    }

    public boolean checkItem(int slot, int id) {
        return this.getEquipment().getItems()[slot].getId() == id;
    } // (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 15492

    public void setReceivedStarter(boolean receivedStarter) {
        this.receivedStarter = receivedStarter;
    }

    public void setFriday13May2016(boolean fri13may16) {
        this.fri13may16 = fri13may16;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public void setCanGhostWalk(boolean canGhostWalk) {
        this.canGhostWalk = canGhostWalk;
    }

    public void setDoneHween2016(boolean isDone) {
        this.doneHween2016 = isDone;
    }

    public void setToggledGlobalMessages(boolean toggledglobalmessages) {
        this.toggledglobalmessages = toggledglobalmessages;
    }

    public void setReffered(boolean reffered) {
        this.reffered = reffered;
    }

    public boolean doingClanBarrows() {
        return doingClanBarrows;
    }

    public void setDoingClanBarrows(boolean doingClanBarrows) {
        this.doingClanBarrows = doingClanBarrows;
    }

    public int getBarrowsKilled() {
        return barrowsKilled;
    }

    public void setBarrowsKilled(int barrowsKilled) {
        this.barrowsKilled = barrowsKilled;
    }

    public int getVodKilled() {
        return vodKilled;
    }

    public void setVodKilled(int vodK) {
        this.vodKilled = vodK;
    }

    public int getHovKilled() {
        return hovKilled;
    }

    public void setHovKilled(int hovK) {
        this.hovKilled = hovK;
    }

    public int getClueProgress() {
        return clueProgress;
    }

    public void setClueProgress(int clueProgress) {
        this.clueProgress = clueProgress;
    }

    public boolean isChargingAttack() {
        return chargingAttack;
    }

    public String getStrippedJewelryName() {
        return strippedJewelryName;
    }

    public void setStrippedJewelryName(String strippedJewelryName) {
        this.strippedJewelryName = strippedJewelryName;
    }

    public int getForgingCharges() {
        return forgingCharges;
    }

    public int setForgingCharges(int forgingCharges) {
        return this.forgingCharges = forgingCharges;
    }

    public boolean getBonecrushEffect() {
        return bonecrushEffect;
    }

    public void setBonecrushEffect(boolean bonecrushEffect) {
        this.bonecrushEffect = bonecrushEffect;
    }

    public int[] getPreviousTeleports() {
        return previousTeleports;
    }

    public void setPreviousTeleports(int[] previousTeleports) {
        this.previousTeleports = previousTeleports;
    }

    public long[] getTaskReceivedTimes() {
        return taskReceivedTime;
    }

    public void setTaskReceivedTimes(long[] taskReceivedTime) {
        this.taskReceivedTime = taskReceivedTime;
    }

    public int getPreviousTeleportsIndex(int index) {
        return previousTeleports[index];
    }

    public void setPreviousTeleportsIndex(int index, int previousTeleport) {
        this.previousTeleports[index] = previousTeleport;
    }

    public String getYellTitle() {
        return yellTitle;
    }

    public void setYellTitle(String yellTitle) {
        if (yellTitle.equalsIgnoreCase("null")) {
            this.yellTitle = "";
        }
        this.yellTitle = yellTitle;
    }

    public List<Integer> getLootList() {
        return lootList;
    }

    public void setLootList(List<Integer> lootList) {
        this.lootList = lootList;
    }

    public boolean isClickToTeleport() {
        return clickToTeleport;
    }

    public void setClickToTeleport(boolean clickToTeleport) {
        this.clickToTeleport = clickToTeleport;
    }

    public Stopwatch getLastDfsTimer() {
        return lastDfsTimer;
    }
    public Stopwatch getLastNephSwordTimer() {
        return lastNephSwordTimer;
    }
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void giveItem(int itemId, int itemAmount) {

        final ItemDefinition definition = ItemDefinition.forId(itemId);

        if (definition == null) {
            sendMessage("@red@[Error]: Could not find definition (" + itemId + "-" + itemAmount + ")");
            sendMessage("@red@Please take a screenshot and post it on the forums.");
            return;
        }

        final int occupiedSlots = definition.isNoted() || definition.isStackable() ? 1 : itemAmount;

        if (inventory.getFreeSlots() >= occupiedSlots) {
            inventory.add(itemId, itemAmount).refreshItems();
        } else if (new Bank(this).getFreeSlots() >= occupiedSlots) {
            boolean added = false;
            for (Bank bank : getBanks()) {
                if (!added && !Bank.isEmpty(bank)) {
                    bank.add(itemId, itemAmount).refreshItems();
                    added = true;
                }
            }
        } else {
            sendMessage("@red@[Error]: Could not give (" + itemId + "-" + itemAmount + ")");
            sendMessage("@red@Please take a screenshot and post it on the forums.");
            World.sendStaffMessage("@red@[Error]: Could not give (" + itemId + "-" + itemAmount + ") to " + username);
        }
    }

    @Override
    public void loadMap() {
        loadMap(false);
    }

    public void loadMap(boolean login) {
        // note(walied):
        // Another way that this can be reworked to if you want to sacrifice memory is doing it using `Chunk` objects,
        // which makes some stuff easier however, it will cost a lot more memory which I think we cannot afford much of
        // it since we currently preload the entire world.
        Region previousRegion = RegionManager.getRegion(currentRegionId);
        if (previousRegion != null) {
            previousRegion.getPlayers().remove(index);
        }
        currentRegionId = position.getRegionId();
        Region currentRegion = RegionManager.getRegion(currentRegionId);
        if (currentRegion != null) {
            currentRegion.getPlayers().add(index);
        }
        // Calculate the current chunk x and y positions.
        int baseChunkX = position.getRealChunkX();
        int baseChunkY = position.getRealChunkY();
        // Clear the player region(id)s and visbility in other region(s).
        regionIds
                .stream()
                .map(RegionManager::getRegion)
                .filter(Objects::nonNull)
                .forEach(region -> region.getVisiblePlayers().remove(index));
        regionIds.clear();
        boolean dynamicRegion = false;
        // Rebuild the region id(s) that are visible to the player.
        for (int chunkX = baseChunkX - 6; chunkX <= baseChunkX + 6; chunkX++) {
            for (int chunkY = baseChunkY - 6; chunkY <= baseChunkY + 6; chunkY++) {
                int regionId = ((chunkX >> 3) << 8) | (chunkY >> 3);
                if (regionIds.contains(regionId)) {
                    continue;
                }
                regionIds.add(regionId);
                Region region = RegionManager.getRegion(regionId);
                if (region != null) {
                    region.getVisiblePlayers().add(index);
                }
                if (region instanceof DynamicRegion) {
                    dynamicRegion = true;
                }
            }
        }
        // ...
        setRegionChange(true);
        setAllowRegionChangePacket(true);
        setCurrentMapCenter(position.copy());

        // Send the map to the the client.
        if (dynamicRegion) {
            packetSender.sendDynamicMapRegion();
        } else {
            packetSender.sendMapRegion();
        }
        // Refresh all of the objects for the player.
        regionIds.stream().map(RegionManager::getRegion).filter(Objects::nonNull).forEach(region -> region.refreshAll(this));
        // Refresh all of the private objects.
        for (GameObject object : privateObjects.values()) {
            if (!object.getPosition().withinScene(getCurrentMapCenter())) {
                continue;
            }
            packetSender.sendObject(object);
        }
        // Refresh the farming objects for the player.
        /*if (!login) {
            farming.updateAll();
        }*/
    }

    @Override
    public void removeFromMap() {
        Region currentRegion = RegionManager.getRegion(currentRegionId);
        if (currentRegion != null) {
            currentRegion.getPlayers().remove(index);
        }
        regionIds.stream().map(RegionManager::getRegion).filter(Objects::nonNull).forEach(region -> region.getVisiblePlayers().remove(index));
    }
    @Getter
    private final Map<Long, GameObject> privateObjects = new HashMap<>();

    public void addObject(GameObject object) {
        privateObjects.put(object.getUid(), object);
        packetSender.sendObject(object);
    }

    public void removeObject(GameObject object) {
        if (privateObjects.remove(object.getUid()) == null) {
            return;
        }
        GameObject spawned = RegionManager.getObjectWithType(object.getPosition(), object.getType());
        if (spawned == null) {
            packetSender.sendObjectRemoval(object);
        } else {
            packetSender.sendObject(spawned);
        }
    }
    public void sendMessage(String string) {
        packetSender.sendMessage(string);
    }

    private int bossPoints;

    public int getBossPoints() {
        return bossPoints;
    }

    public void setBossPoints(int bossPoints) {
        this.bossPoints = bossPoints;
    }


    public boolean isActive() {
        return true;
    }

    public void setVoteCount(int voteCount) {
        doMotivote.setVoteCount(voteCount);
    }

    public void claimDonation(Player player, boolean fromLogin) {
        if (player.lastDonationClaim < System.currentTimeMillis())
            new Store(player).run();
        else if (!fromLogin)
            player.sendMessage("You can only claim donations once every 30seconds!");
    }


    public void depositItemBank(Item item) {
        if (ItemDefinition.forId(item.getId()).isNoted()) {
            item.setId(Item.getUnNoted(item.getId()));
        }
        getBank(Bank.getTabForItem(this, item.getId())).add(item);
    }

    public void depositItemBank(Item item, boolean refresh) {
        if (ItemDefinition.forId(item.getId()).isNoted()) {
            item.setId(Item.getUnNoted(item.getId()));
        }
        getBank(Bank.getTabForItem(this, item.getId())).add(item, refresh);
    }
    public void depositItemBank(int tab, Item item, boolean refresh) {
        if (ItemDefinition.forId(item.getId()).isNoted()) {
            item.setId(Item.getUnNoted(item.getId()));
        }
        getBank(tab).add(item, refresh);
    }
    public ArrayList<Integer> walkableInterfaceList = new ArrayList<>();
    public void resetInterfaces() {
        walkableInterfaceList.stream().filter((i) -> !(i == 41005 || i == 41000)).forEach((i) -> {
            getPacketSender().sendWalkableInterface(i, false);
        });

        walkableInterfaceList.clear();
    }
    public void sendParallellInterfaceVisibility(int interfaceId, boolean visible) {
        if (this != null && this.getPacketSender() != null) {
            if (visible) {
                if (walkableInterfaceList.contains(interfaceId)) {
                    return;
                } else {
                    walkableInterfaceList.add(interfaceId);
                }
            } else {
                if (!walkableInterfaceList.contains(interfaceId)) {
                    return;
                } else {
                    walkableInterfaceList.remove((Object) interfaceId);
                }
            }

            getPacketSender().sendWalkableInterface(interfaceId, visible);
        }
    }

    @Getter @Setter
    public int bondClicked;

    @Getter @Setter
    public boolean bondClickedClaimAll;

    public void setCurrencyPouch(CurrencyPouch pouch) {
        this.currencyPouch = pouch;
    }

    @Getter @Setter
    public boolean unlockedLucifers;


    @Getter @Setter
    public boolean chestLooted;

    @Getter @Setter
    public boolean isFishCollected;

    @Getter @Setter
    public boolean isRewardCollected;


    @Getter @Setter
    public boolean isTreasureMap1Collected;

    @Getter @Setter
    public boolean isTreasureMap2Collected;

    @Getter @Setter
    public boolean isTreasureMap3Collected;
    @Getter
    @Setter
    public boolean unlockedDarkSupreme;

    public int distanceToPoint(int pointX, int pointY) {
        return (int) Math.sqrt(Math.pow(getPosition().getX() - pointX, 2) + Math.pow(getPosition().getY() - pointY, 2));
    }

    public int afkTicks;
    public boolean afk;

    public boolean register() {
        return World.getPlayers().add(this);
    }

    public SeasonPass getSeasonPass() {
        return seasonPass;
    }
    public MembershipManager getMembershipManager() {
        return membershipManager;
    }

    @Getter
    @Setter
    private String potionUsed = "Super Ovl";

    @Getter
    @Setter
    private ItemDefinition.EquipmentType selectedEquipmentType = ItemDefinition.EquipmentType.FULL_HELMET;

    @Getter
    @Setter
    private int monthlyVoteCount;

    @Getter
    @Setter
    private int monthlyDonationCount;

    @Getter
    @Setter
    private int attemptDissolve;

    @Getter
    @Setter
    private boolean visible = true;

    @Getter
    @Setter
    private boolean canChat = true;


    @Getter
    @Setter
    private boolean set1;

    @Getter
    @Setter
    private boolean unlockedSet1;

    @Getter
    @Setter
    private boolean set2;

    @Getter
    @Setter
    private boolean unlockedSet2;

    @Getter
    @Setter
    private boolean set3;

    @Getter
    @Setter
    private boolean unlockedSet3;

    @Getter
    @Setter
    private boolean set4;

    @Getter
    @Setter
    private boolean unlockedSet4;

    @Getter
    @Setter
    private boolean set5;

    @Getter
    @Setter
    private boolean unlockedSet5;

    @Getter
    @Setter
    private boolean set6;

    @Getter
    @Setter
    private boolean unlockedSet6;

    @Getter
    @Setter
    private boolean set7;

    @Getter
    @Setter
    private boolean unlockedSet7;

    @Getter
    @Setter
    private boolean set8;

    @Getter
    @Setter
    private boolean unlockedSet8;

    @Getter
    @Setter
    private boolean set9;

    @Getter
    @Setter
    private boolean unlockedSet9;

    @Getter
    @Setter
    private boolean set10;

    @Getter
    @Setter
    private boolean unlockedSet10;

    @Getter
    @Setter
    private boolean set11;

    @Getter
    @Setter
    private boolean unlockedSet11;

    @Getter
    @Setter
    private boolean set12;

    @Getter
    @Setter
    private boolean unlockedSet12;

    @Getter
    @Setter
    private boolean set13;

    @Getter
    @Setter
    private boolean unlockedSet13;

    @Getter
    @Setter
    private boolean set14;

    @Getter
    @Setter
    private boolean unlockedSet14;

    @Getter
    @Setter
    private boolean set15;

    @Getter
    @Setter
    private boolean unlockedSet15;

    @Getter
    @Setter
    private boolean set16;

    @Getter
    @Setter
    private boolean unlockedSet16;

    @Getter
    @Setter
    private boolean set17;

    @Getter
    @Setter
    private boolean unlockedSet17;

    @Getter
    @Setter
    private boolean set18;

    @Getter
    @Setter
    private boolean unlockedSet18;

    @Getter
    @Setter
    private boolean set19;

    @Getter
    @Setter
    private boolean unlockedSet19;

    @Getter
    @Setter
    private boolean set20;

    @Getter
    @Setter
    private boolean unlockedSet20;

    public boolean isInMinigame() {
        boolean inMinigameLoc = getLocation() == Locations.Location.KEEPERS_OF_LIGHT_GAME || getLocation() == Locations.Location.VAULT_OF_WAR || getLocation() == Locations.Location.HALLS_OF_VALOR || getLocation() == Locations.Location.TREASURE_HUNTER;
        boolean inMinigameInstance = getMapInstance() instanceof DungeoneeringInstance;
        return inMinigameLoc || inMinigameInstance;
    }

    private boolean[] unlockedHolyPrayers = new boolean[6];

    public boolean[] getUnlockedHolyPrayers() {
        return unlockedHolyPrayers;
    }
    public void setUnlockedHolyPrayer(int idx, boolean val) {
        if(idx >= 0 && idx < unlockedHolyPrayers.length) {
            unlockedHolyPrayers[idx] = val;
        }
    }
    public void setUnlockedHolyPrayers(boolean[] val) {
        unlockedHolyPrayers = val;
    }
    public boolean isHolyPrayerUnlocked(int idx) {
        if(idx >= 0 && idx < unlockedHolyPrayers.length) {
            return unlockedHolyPrayers[idx];
        } else {
            return false;
        }
    }
    private AchievementInterface achievementInterface;

    public void setAchievementInterface(AchievementInterface achievementInterface) {
        this.achievementInterface = achievementInterface;
    }

    public AchievementInterface getAchievementInterface() {
        return this.achievementInterface;
    }

    private AchievementTracker achievementTracker = new AchievementTracker(this);

    public AchievementTracker getAchievementTracker() {
        return this.achievementTracker;
    }



}
