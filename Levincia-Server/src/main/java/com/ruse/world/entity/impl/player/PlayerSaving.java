package com.ruse.world.entity.impl.player;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.ruse.GameServer;
import com.ruse.GameSettings;
import com.ruse.util.Misc;
import com.ruse.world.content.dailyTask.DailyTaskData;
import org.apache.commons.lang3.text.WordUtils;
import org.mindrot.jbcrypt.BCrypt;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;

public class PlayerSaving {

	private static final DailyTaskData[] daily = DailyTaskData.values();

	public static void save(Player player) {
		if (player.newPlayer())
			return;
		// Create the path and file objects.
		Path path = Paths.get("./data/saves/characters/", player.getUsername() + ".json");
		File file = path.toFile();
		file.getParentFile().setWritable(true);

		// Attempt to make the player save directory if it doesn't
		// exist.
		if (!file.getParentFile().exists()) {
			try {
				file.getParentFile().mkdirs();
			} catch (SecurityException e) {
				// System.out.println("Unable to create directory for player data!");
			}
		}
		try (FileWriter writer = new FileWriter(file)) {

			Gson builder = new GsonBuilder().setPrettyPrinting().create();
			JsonObject object = new JsonObject();
			object.addProperty("total-play-time-ms", player.getTotalPlayTime());
			object.addProperty("username", player.getUsername().trim());

			if (GameSettings.BCRYPT_HASH_PASSWORDS) {
				object.addProperty("hash", BCrypt.hashpw(player.getPassword(), player.getSalt()));
			} else {
				object.addProperty("password", player.getPassword().trim());
			}

			object.addProperty("email", player.getEmailAddress() == null ? "null" : player.getEmailAddress().trim());
			object.addProperty("staff-rights", player.getRights().name());			
			object.addProperty("game-mode", player.getGameMode().name());
			object.addProperty("loyalty-title", player.getLoyaltyTitle().name());
			
			/** HEX YELL COLORS **/
			object.addProperty("yellhexcolor", player.getYellHex() == null ? "ffffff" : player.getYellHex());
			object.add("position", builder.toJsonTree(player.getPosition()));
			object.addProperty("online-status", player.getRelations().getStatus().name());
			object.addProperty("given-starter", new Boolean(player.didReceiveStarter()));
			object.addProperty("has-pin2", player.getHasPin());
			object.addProperty("saved-pin2", player.getSavedPin());
			object.addProperty("saved-ip", player.getSavedIp());
			object.addProperty("donated", new Long(player.getAmountDonated()));
			object.addProperty("current-boss-task", player.getCurrentBossTask());
			object.addProperty("current-boss-amount", player.getCurrentBossTaskAmount());
			object.addProperty("global-rate", player.getPointsHandler().getGlobalRate());
			object.addProperty("peng-rate", player.getPointsHandler().getPengRate());
			object.addProperty("has-completed-boss-task", player.isHasPlayerCompletedBossTask());
			object.addProperty("current-daily-task-id", player.getCurrentDailyTask());
			object.addProperty("current-daily-task-amount", player.getCurrentDailyTaskAmount());
			if (player.getDailyTasks() != null) {
				object.addProperty("current-daily-task-data", player.getDailyTasks().getNpcId());
			}
			object.addProperty("current-daily-task-x-pos", player.getxPosDailyTask());
			object.addProperty("current-daily-task-y-pos", player.getyPostDailyTask());
			object.addProperty("current-daily-task-z-pos", player.getzPosDailyTask());
			object.addProperty("current-daily-task-reward", player.getRewardDailyTask());
			object.addProperty("unlocked-rammernaut", player.isUnlockedRammernaut());
			object.addProperty("travelling-day", player.getTravelingMerchantDay());
			object.add("travelling-merchant", builder.toJsonTree(player.getMerchantItems()));
			object.add("uim-bank", builder.toJsonTree(player.getUimBankItems()));

			object.addProperty("discord-user", player.getDiscordUser());
			object.addProperty("discord-tag", player.getDiscordTag());
			object.addProperty("discord-points", player.getDiscordPoints());
			object.addProperty("dg-floor", player.getDungeoneeringFloor());
			object.addProperty("dg-prestige", player.getDungeoneeringPrestige());
			object.addProperty("clue-task", player.getCurrentClue().getCurrentTask().name());
			object.addProperty("clue-kc", player.getCurrentClue().getAmountToSlay());
			object.addProperty("daysVoted", player.getDaysVoted());
			object.addProperty("totalTimesClaimed", player.getTotalTimesClaimed());
			object.addProperty("longestDaysVoted", player.getLongestDaysVoted());
			object.addProperty("timeUntilNextReward", player.getTimeUntilNextReward());
			object.addProperty("lastVoted", player.getLastVoted());
			object.addProperty("last-voted", player.getLastVotedDay());
			object.addProperty("current-voting-streak", player.getCurrentVotingStreak());
			object.addProperty("entriesCurrency", player.getEntriesCurrency());
			object.addProperty("amount-donated-today", player.getAmountDonatedToday());
			object.addProperty("claimed-first", player.claimedFirst);
			object.addProperty("claimed-second", player.claimedSecond);
			object.addProperty("claimed-third", player.claimedThird);
			object.addProperty("last-donation", player.lastDonation);
			object.addProperty("last-time-reset", player.lastTimeReset);
			object.addProperty("lastlogin", new Long(player.lastLogin));
			object.addProperty("lastdailyclaim", new Long(player.lastDailyClaim));
			object.addProperty("lastvotetime", new Long(player.lastVoteTime));
			object.addProperty("hasvotedtoday", new Boolean(player.hasVotedToday));
			object.addProperty("day1claimed", new Boolean(player.day1Claimed));
			object.addProperty("day2claimed", new Boolean(player.day2Claimed));
			object.addProperty("day3claimed", new Boolean(player.day3Claimed));
			object.addProperty("day4claimed", new Boolean(player.day4Claimed));
			object.addProperty("day5claimed", new Boolean(player.day5Claimed));
			object.addProperty("day6claimed", new Boolean(player.day6Claimed));
			object.addProperty("day7claimed", new Boolean(player.day7Claimed));
			object.addProperty("minutes-bonus-exp", new Integer(player.getMinutesBonusExp()));
			object.addProperty("minutes-voting-dr", new Integer(player.getMinutesVotingDR()));
			object.addProperty("minutes-voting-dmg", new Integer(player.getMinutesVotingDMG()));
			object.addProperty("total-gained-exp", new Long(player.getSkillManager().getTotalGainedExp()));
			object.addProperty("barrows-points", new Integer(player.getPointsHandler().getBarrowsPoints()));
			object.addProperty("donator-points", new Integer(player.getPointsHandler().getDonatorPoints()));
			object.addProperty("Skilling-points", new Integer(player.getPointsHandler().getSkillingPoints()));
			object.addProperty("prestige-points", new Integer(player.getPointsHandler().getPrestigePoints()));
			object.addProperty("achievement-points", new Integer(player.getPointsHandler().getAchievementPoints()));
			object.add("daily-task-slots", builder.toJsonTree(player.getDailyTaskManager().getTaskSlots()));
			object.add("achievements", player.getAchievementTracker().jsonSave());
			object.addProperty("achievements-daily", player.getAchievements().getDailyAchievementsDate());
			object.add("achievements-completion",
					builder.toJsonTree(player.getAchievementAttributes().getCompletion()));
			object.add("achievements-progress", builder.toJsonTree(player.getAchievementAttributes().getProgress()));
			object.add("achievements-points", builder.toJsonTree(player.getAchievements().getPoints()));
			object.add("achievements-amount", builder.toJsonTree(player.getAchievements().getAmountRemaining()));
			object.add("achievements-completed", builder.toJsonTree(player.getAchievements().getCompleted()));
			object.addProperty("achievements-daily", player.getAchievements().getDailyAchievementsDate());
			object.addProperty("daily-tasks-completed", player.getDailyTasksCompleted());
			object.addProperty("dung-tokens", new Integer(player.getPointsHandler().getDungeoneeringTokens()));
			object.addProperty("commendations", new Integer(player.getPointsHandler().getCommendations()));
			object.addProperty("loyalty-points", new Integer(player.getPointsHandler().getLoyaltyPoints()));
			object.addProperty("godmodetime", player.getGodModeTimer());
			object.addProperty("voting-points", new Integer(player.getPointsHandler().getVotingPoints()));
			object.addProperty("total-prestiges", new Integer(player.getPointsHandler().getTotalPrestiges()));
			object.addProperty("slayer-rate", player.getPointsHandler().getSlayerRate());
			object.addProperty("slayer-spree", new Integer(player.getPointsHandler().getSlayerSpree()));
			object.addProperty("slayer-points", new Integer(player.getPointsHandler().getSlayerPoints()));
			object.addProperty("slayer-master1", player.getSlayer().getTaskType().name());
			object.addProperty("slayer-task1", player.getSlayer().getSlayerTask().name());
			object.addProperty("prev-slayer-task1", player.getSlayer().getLastTask().name());
			object.addProperty("task-amount1", player.getSlayer().getAmountToSlay());
			object.addProperty("task-streak", player.getSlayer().getTaskStreak());
			object.addProperty("duo-partner",
					player.getSlayer().getDuoPartner() == null ? "null" : player.getSlayer().getDuoPartner());
			object.addProperty("double-slay-xp", player.getSlayer().doubleSlayerXP);
			object.addProperty("easy-task-kc", player.getSlayer().getEasyTaskKC());
			object.addProperty("med-task-kc", player.getSlayer().getMedTaskKC());
			object.addProperty("hard-task-kc", player.getSlayer().getHardTaskKC());
			object.addProperty("boss-task-kc", player.getSlayer().getBossTaskKC());
			object.add("slayer-fav", builder.toJsonTree(player.getSlayerFavourites().getFavouriteNpcIds()));
			object.add("slayer-blocked", builder.toJsonTree(player.getSlayerFavourites().getBlockedNpcIds()));
			object.addProperty("minigame1-killcount", new Integer(player.getPointsHandler().getMG1Count()));
			object.addProperty("minigame2-killcount", new Integer(player.getPointsHandler().getMG2Count()));
			object.addProperty("minigame3-killcount", new Integer(player.getPointsHandler().getMG3Count()));
			object.addProperty("npc-killcount", new Integer(player.getPointsHandler().getNPCKILLCount()));
			object.addProperty("unknown-completed", new Integer(player.getPointsHandler().getUnknownCompleted()));
			object.addProperty("spawn-killcount", new Integer(player.getPointsHandler().getSPAWNKILLCount()));
			object.addProperty("lord-killcount", new Integer(player.getPointsHandler().getLORDKILLCount()));
			object.addProperty("demon-killcount", new Integer(player.getPointsHandler().getDEMONKILLCount()));
			object.addProperty("dragon-killcount", new Integer(player.getPointsHandler().getDRAGONKILLCount()));
			object.addProperty("beast-killcount", new Integer(player.getPointsHandler().getBEASTKILLCount()));
			object.addProperty("king-killcount", new Integer(player.getPointsHandler().getKINGKILLCount()));
			object.addProperty("avatar-killcount", new Integer(player.getPointsHandler().getAVATARKILLCount()));
			object.addProperty("angel-killcount", new Integer(player.getPointsHandler().getANGELKILLCount()));
			object.addProperty("lucien-killcount", new Integer(player.getPointsHandler().getLUCIENKILLCount()));
			object.addProperty("hercules-killcount", new Integer(player.getPointsHandler().getHERCULESKILLCount()));
			object.addProperty("satan-killcount", new Integer(player.getPointsHandler().getSATANKILLCount()));
			object.addProperty("zeus-killcount", new Integer(player.getPointsHandler().getZEUSKILLCount()));
			object.addProperty("vindicta-killcount", new Integer(player.getPointsHandler().getFENRIRKILLCount()));
			object.addProperty("groudon-killcount", new Integer(player.getPointsHandler().getGROUDONKILLCount()));
			object.addProperty("midnight-killcount", new Integer(player.getPointsHandler().getMIDNIGHTKILLCount()));
			object.addProperty("ab-killcount", new Integer(player.getPointsHandler().getBorkKC()));
			object.addProperty("cosmetic-override", player.isCosmeticOveride());
			object.addProperty("quest-one-dream-kc", new Integer(player.getPointsHandler().getQuestOneDreamKC()));
			object.addProperty("zombie-raid-kc", new Integer(player.getPointsHandler().getZombieRaidKC()));
			object.addProperty("isles-kc", new Integer(player.getPointsHandler().getIslesKC()));
			object.addProperty("suffering-kc", new Integer(player.getPointsHandler().getSufferingKC()));
			object.addProperty("necromancer-kc", new Integer(player.getPointsHandler().getNecromancerKC()));
			object.addProperty("isle-easy-timer", player.getIsleEasyTimer());
			object.addProperty("isle-med-timer", player.getIsleMedTimer());
			object.addProperty("isle-hard-timer", player.getIsleHardTimer());
			object.addProperty("elder-easy-timer", player.getElderEasyTimer());
			object.addProperty("elder-med-timer", player.getElderMedTimer());
			object.addProperty("elder-hard-timer", player.getElderHardTimer());
			object.addProperty("easy-isle-god-kc", player.getEasyIsleGodKC());
			object.addProperty("med-isle-god-kc", player.getMedIsleGodKC());
			object.addProperty("hard-isle-god-kc", player.getHardIsleGodKC());

			object.addProperty("easy-elder-god-kc", player.getEasyElderGodKC());
			object.addProperty("med-elder-god-kc", player.getMedElderGodKC());
			object.addProperty("hard-elder-god-kc", player.getHardElderGodKC());

			object.addProperty("isle-dr", player.getIsleDropRate());
			object.addProperty("elder-dr", player.getElderDropRate());
			object.addProperty("upg-dr", player.getScrollBonus ());

			object.add("turkeys-mutated", builder.toJsonTree(player.getTurkeysMutated()));
			object.add("gods-coffer", builder.toJsonTree(player.getGodsCoffer().toArray()));
			object.add("telos-coffer", builder.toJsonTree(player.getTelosCoffer().toArray()));
			object.addProperty("shadow-drop-rate", player.getShadowRareDropBoost());
			object.addProperty("shadow-key-opened", player.getShadowKeysOpened());
			object.addProperty("lastInstanceNpc", player.lastInstanceNpc);
			object.addProperty("pumpkins-collected", new Integer(player.getSoulInPouchAsInt()));
			object.addProperty("treasure-hunter-kc", new Integer(player.getPointsHandler().getTreasureHunterKC()));
			object.addProperty("faceless-magician-killcount", new Integer(player.getPointsHandler().getFacelessMagicianKC()));
			object.addProperty("lotus-magician-killcount", new Integer(player.getPointsHandler().getLotusMagicianKC()));
			object.addProperty("shadow-magician-killcount", new Integer(player.getPointsHandler().getShadowMagicianKC()));
			object.addProperty("forest-archer-killcount", new Integer(player.getPointsHandler().getForestArcherKC()));
			object.addProperty("chaotic-archer-killcount", new Integer(player.getPointsHandler().getChaoticArcherKC()));
			object.addProperty("divine-archer-killcount", new Integer(player.getPointsHandler().getDivineArcherKC()));
			object.addProperty("lesarkus-warrior-killcount", new Integer(player.getPointsHandler().getLesarkusWarriorKC()));
			object.addProperty("vampire-warrior-killcount", new Integer(player.getPointsHandler().getVampireWarriorKC()));
			object.addProperty("ancient-warrior-killcount", new Integer(player.getPointsHandler().getAncientWarriorKC()));
			object.addProperty("seasonpass-xp", new Integer(player.getSeasonPass().getXp()));
			object.addProperty("seasonpass-tier", new Integer(player.getSeasonPass().getTier()));
			object.addProperty("stream-count", new Integer(player.getPointsHandler().getStreamCount()));
			object.addProperty("seasonpass-kc", new Integer(player.getkc500forseasonpass()));
			object.addProperty("seasonpass-season", player.getSeasonPass().getCurrentSeason());
			object.addProperty("unlockedseasonpass", new Boolean(player.isunlockedseasonpass()));
			object.addProperty("unlockedMembership", new Boolean(player.isMembershipUnlocked()));
			object.addProperty("unlockedCosmetic", new Boolean(player.isCosmeticUnlocked()));
			object.addProperty("mini-lucifer-killcount", player.getPointsHandler().getMiniLuciferkillcount());
			object.addProperty("lucifer-killcount", player.getPointsHandler().getLuciferkillcount());
			object.addProperty("monthly-vote-count", player.getMonthlyVoteCount());
			object.addProperty("monthly-donator-count", player.getMonthlyDonationCount());
			object.addProperty("celestial-member", new Boolean(player.getCelestial()));
			object.addProperty("supreme-member", new Boolean(player.getSupreme()));
			object.addProperty("supreme-charges", player.getSupremeCharges());
			object.addProperty("fallen-warrior-unlocked", new Boolean(player.getFallenWarrior()));
			object.addProperty("mini-lucifer", new Boolean(player.getMiniLucifer()));
			object.addProperty("dark-supreme", new Boolean(player.getDarkSupreme()));
			object.addProperty("event-points", new Integer(player.getPointsHandler().getEventPoints()));
			object.addProperty("boss-points", new Integer(player.getPointsHandler().getBossPoints()));
			object.addProperty("shilling-rate", new Integer(player.getPointsHandler().getSHILLINGRate()));


			object.addProperty("sacrificed-owner", player.isSacrificedFantasyItem());
			object.addProperty("fantasy", player.isFantasy());

			object.addProperty("diminisher", player.isDiminisher());

			object.addProperty("hween-trick", player.getHweenEvent().getTrick());
			object.addProperty("hween-treat", player.getHweenEvent().getTreat());
			object.add("unlocked-trick", builder.toJsonTree(player.getHweenEvent().getUnlockedTrick()));
			object.add("unlocked-treat", builder.toJsonTree(player.getHweenEvent().getUnlockedTreat()));
			object.addProperty("unlocked-crown", player.getHweenEvent().getUnlockedCrown());


			object.add("bosspets", builder.toJsonTree(player.getBossPetsAll()));
			object.addProperty("quest-points", new Integer(player.getPointsHandler().getQuestPoints()));
			object.addProperty("pk-points", new Integer(player.getPointsHandler().getPkPoints()));
			object.addProperty("player-kills", new Integer(player.getPlayerKillingAttributes().getPlayerKills()));
			object.addProperty("player-killstreak",
					new Integer(player.getPlayerKillingAttributes().getPlayerKillStreak()));
			object.addProperty("player-deaths", new Integer(player.getPlayerKillingAttributes().getPlayerDeaths()));
			object.addProperty("target-percentage",
					new Integer(player.getPlayerKillingAttributes().getTargetPercentage()));
			object.addProperty("bh-rank", new Integer(player.getAppearance().getBountyHunterSkull()));
			object.addProperty("prestigeicon", new Integer(player.getAppearance().getprestigeIcon()));
			object.addProperty("gender", player.getAppearance().getGender().name());
			object.addProperty("spell-book", player.getSpellbook().name());
			object.addProperty("prayer-book", player.getPrayerbook().name());

			object.addProperty("running", new Boolean(player.isRunning()));
			object.addProperty("run-energy", new Integer(player.getRunEnergy()));
			object.addProperty("music", new Boolean(player.musicActive()));
			object.addProperty("sounds", new Boolean(player.soundsActive()));
			object.addProperty("auto-retaliate", new Boolean(player.isAutoRetaliate()));
			object.addProperty("xp-locked", new Boolean(player.experienceLocked()));
			object.addProperty("veng-cast", new Boolean(player.hasVengeance()));
			object.addProperty("last-veng", new Long(player.getLastVengeance().elapsed()));
			object.addProperty("fight-type", player.getFightType().name());
			object.addProperty("sol-effect", new Integer(player.getStaffOfLightEffect()));
			object.addProperty("skull-timer", new Integer(player.getSkullTimer()));
			object.addProperty("accept-aid", new Boolean(player.isAcceptAid()));
			object.addProperty("poison-damage", new Integer(player.getPoisonDamage()));
			object.addProperty("poison-immunity", new Integer(player.getPoisonImmunity()));
			object.addProperty("overload-timer", new Integer(player.getOverloadPotionTimer()));

			object.addProperty("double-dr-timer", new Integer(player.getDoubleDRTimer()));
			object.addProperty("double-ddr-timer", new Integer(player.getDoubleDDRTimer()));
			object.addProperty("double-dmg-timer", new Integer(player.getDoubleDMGTimer()));
			object.add("days-voted", builder.toJsonTree(player.getVotingStreak().getDaysVoted()));
			object.addProperty("daily-reward-day", player.getVotingStreak().getCurrentDay());
			object.addProperty("daily-reward-epoch", player.getVotingStreak().getEpochDay());

			object.addProperty("fire-immunity", new Integer(player.getFireImmunity()));
			object.addProperty("fire-damage-mod", new Integer(player.getFireDamageModifier()));
			object.addProperty("prayer-renewal-timer", new Integer(player.getPrayerRenewalPotionTimer()));
			object.addProperty("teleblock-timer", new Integer(player.getTeleblockTimer()));
			object.addProperty("special-amount", new Integer(player.getSpecialPercentage()));
			object.addProperty("entered-gwd-room",
					new Boolean(player.getMinigameAttributes().getGodwarsDungeonAttributes().hasEnteredRoom()));
			object.addProperty("gwd-altar-delay",
					new Long(player.getMinigameAttributes().getGodwarsDungeonAttributes().getAltarDelay()));
			object.add("gwd-killcount",
					builder.toJsonTree(player.getMinigameAttributes().getGodwarsDungeonAttributes().getKillcount()));
			object.addProperty("effigy", new Integer(player.getEffigy()));
			object.addProperty("summon-npc",
					new Integer(player.getSummoning().getFamiliar() != null
							? player.getSummoning().getFamiliar().getSummonNpc().getId()
							: -1));
			object.addProperty("summon-death",
					new Integer(player.getSummoning().getFamiliar() != null
							? player.getSummoning().getFamiliar().getDeathTimer()
							: -1));
			object.addProperty("process-farming", new Boolean(player.shouldProcessFarming()));
			object.addProperty("clanchat", player.getClanChatName() == null ? "null" : player.getClanChatName().trim());
			object.addProperty("autocast", new Boolean(player.isAutocast()));
			object.addProperty("autocast-spell",
					player.getAutocastSpell() != null ? player.getAutocastSpell().spellId() : -1);
			object.addProperty("dfs-charges", player.getDfsCharges());
			object.addProperty("recoil-deg", new Integer(player.getRecoilCharges()));
			object.addProperty("starter-deg", new Integer(player.getStarterCharges()));
			object.addProperty("blowpipe-deg", new Integer(player.getBlowpipeCharges()));
			object.add("brawlers-deg", builder.toJsonTree(player.getBrawlerChargers()));
			object.add("ancient-deg", builder.toJsonTree(player.getAncientArmourCharges()));
			object.add("killed-players", builder.toJsonTree(player.getPlayerKillingAttributes().getKilledPlayers()));
			object.add("vod-brother",
					builder.toJsonTree(player.getMinigameAttributes().getVoidOfDarknessAttributes().getBarrowsData()));
			object.addProperty("vod-killcount",
					new Integer(player.getMinigameAttributes().getVoidOfDarknessAttributes().getKillcount()));
			object.addProperty("hov-killcount",
					new Integer(player.getMinigameAttributes().getHallsOfValorAttributes().getKillcount()));
			object.add("barrows-brother",
					builder.toJsonTree(player.getMinigameAttributes().getBarrowsMinigameAttributes().getBarrowsData()));
			object.addProperty("random-coffin",
					new Integer(player.getMinigameAttributes().getBarrowsMinigameAttributes().getRandomCoffin()));
			object.addProperty("barrows-killcount",
					new Integer(player.getMinigameAttributes().getBarrowsMinigameAttributes().getKillcount()));
			object.add("nomad",
					builder.toJsonTree(player.getMinigameAttributes().getNomadAttributes().getQuestParts()));
			object.add("recipe-for-disaster", builder
					.toJsonTree(player.getMinigameAttributes().getRecipeForDisasterAttributes().getQuestParts()));
			object.addProperty("recipe-for-disaster-wave",
					new Integer(player.getMinigameAttributes().getRecipeForDisasterAttributes().getWavesCompleted()));
			object.addProperty("clue-progress", new Integer(player.getClueProgress()));
			object.add("dung-items-bound",
					builder.toJsonTree(player.getMinigameAttributes().getDungeoneeringAttributes().getBoundItems()));

			object.add("collection-data", builder.toJsonTree(player.getCollectionLogData()));
			object.add("collectionlog-data", builder.toJsonTree(player.getCollectionLog2().collectionLog));
			object.add("collectionlog-data2", builder.toJsonTree(player.getCollectionLog2().collectionLogofkills));
			object.add("collectionlog-data3", builder.toJsonTree(player.getCollectionLog2().collectionLogofrewards));
			object.add("holy-prayers-unlocked", builder.toJsonTree(player.getUnlockedHolyPrayers()));
			object.add("unlocked-set1", builder.toJsonTree(player.isUnlockedSet1()));
			object.add("unlocked-set2", builder.toJsonTree(player.isUnlockedSet2()));
			object.add("unlocked-set3", builder.toJsonTree(player.isUnlockedSet3()));
			object.add("unlocked-set4", builder.toJsonTree(player.isUnlockedSet4()));
			object.add("unlocked-set5", builder.toJsonTree(player.isUnlockedSet5()));
			object.add("unlocked-set6", builder.toJsonTree(player.isUnlockedSet6()));
			object.add("unlocked-set7", builder.toJsonTree(player.isUnlockedSet7()));
			object.add("unlocked-set8", builder.toJsonTree(player.isUnlockedSet8()));
			object.add("unlocked-set9", builder.toJsonTree(player.isUnlockedSet9()));
			object.add("unlocked-set10", builder.toJsonTree(player.isUnlockedSet10()));
			object.add("unlocked-set11", builder.toJsonTree(player.isUnlockedSet11()));
			object.add("unlocked-set12", builder.toJsonTree(player.isUnlockedSet12()));
			object.add("unlocked-set13", builder.toJsonTree(player.isUnlockedSet13()));
			object.add("unlocked-set14", builder.toJsonTree(player.isUnlockedSet14()));
			object.add("unlocked-set15", builder.toJsonTree(player.isUnlockedSet15()));
			object.add("unlocked-set16", builder.toJsonTree(player.isUnlockedSet16()));
			object.add("unlocked-set17", builder.toJsonTree(player.isUnlockedSet17()));
			object.add("unlocked-set18", builder.toJsonTree(player.isUnlockedSet18()));
			object.add("unlocked-set19", builder.toJsonTree(player.isUnlockedSet19()));
			object.add("unlocked-set20", builder.toJsonTree(player.isUnlockedSet20()));
			object.addProperty("rune-ess", new Integer(player.getStoredRuneEssence()));
			object.addProperty("pure-ess", new Integer(player.getStoredPureEssence()));
			object.addProperty("has-bank-pin", new Boolean(player.getBankPinAttributes().hasBankPin()));
			object.addProperty("last-pin-attempt", new Long(player.getBankPinAttributes().getLastAttempt()));
			object.addProperty("invalid-pin-attempts", new Integer(player.getBankPinAttributes().getInvalidAttempts()));
			object.add("bank-pin", builder.toJsonTree(player.getBankPinAttributes().getBankPin()));
			object.add("appearance", builder.toJsonTree(player.getAppearance().getLook()));
			object.add("agility-obj", builder.toJsonTree(player.getCrossedObstacles()));
			object.add("skills", builder.toJsonTree(player.getSkillManager().getSkills()));
			object.add("inventory", builder.toJsonTree(player.getInventory().getItems()));
			object.add("equipment", builder.toJsonTree(player.getEquipment().getItems()));
			object.add("preset-equipment", builder.toJsonTree(player.getPreSetEquipment().getItems()));
			object.add("offences", builder.toJsonTree(player.getOffences()));
			object.add("bank-0", builder.toJsonTree(player.getBank(0).getValidItems()));
			object.add("bank-1", builder.toJsonTree(player.getBank(1).getValidItems()));
			object.add("bank-2", builder.toJsonTree(player.getBank(2).getValidItems()));
			object.add("bank-3", builder.toJsonTree(player.getBank(3).getValidItems()));
			object.add("bank-4", builder.toJsonTree(player.getBank(4).getValidItems()));
			object.add("bank-5", builder.toJsonTree(player.getBank(5).getValidItems()));
			object.add("bank-6", builder.toJsonTree(player.getBank(6).getValidItems()));
			object.add("bank-7", builder.toJsonTree(player.getBank(7).getValidItems()));
			object.add("bank-8", builder.toJsonTree(player.getBank(8).getValidItems()));

			object.add("ge-slots", builder.toJsonTree(player.getGrandExchangeSlots()));

			/** STORE SUMMON **/
			if (player.getSummoning().getBeastOfBurden() != null) {
				object.add("store", builder.toJsonTree(player.getSummoning().getBeastOfBurden().getValidItems()));
			}
			object.add("charm-imp", builder.toJsonTree(player.getSummoning().getCharmImpConfigs()));

			object.add("friends", builder.toJsonTree(player.getRelations().getFriendList().toArray()));
			object.add("ignores", builder.toJsonTree(player.getRelations().getIgnoreList().toArray()));
			object.add("loyalty-titles", builder.toJsonTree(player.getUnlockedLoyaltyTitles()));
			object.add("kills", builder.toJsonTree(player.getKillsTracker().toArray()));
			object.add("drops", builder.toJsonTree(player.getDropLog().toArray()));
			object.addProperty("fri13may16", new Boolean(player.didFriday13May2016())); // player.didfri13may16
			object.addProperty("spiritdebug", new Boolean(player.isSpiritDebug()));
			object.addProperty("reffered", new Boolean(player.gotReffered()));
			object.addProperty("indung", new Boolean(player.isInDung()));
			object.addProperty("toggledglobalmessages", new Boolean(player.toggledGlobalMessages()));
			object.addProperty("flying", new Boolean(player.isFlying()));
			object.addProperty("canfly", new Boolean(player.canFly()));
			object.addProperty("ghostwalking", new Boolean(player.isGhostWalking()));
			object.addProperty("canghostwalk", new Boolean(player.canGhostWalk()));
			object.addProperty("barrowschests", new Integer(player.getPointsHandler().getBarrowsChests()));
			object.addProperty("cluesteps", new Integer(player.getPointsHandler().getClueSteps()));
			object.addProperty("difficulty", player.getDifficulty().name());
			object.add("hween2016", builder.toJsonTree(player.getHween2016All()));
			object.addProperty("donehween2016", new Boolean(player.doneHween2016()));
			object.addProperty("christmas2016", new Integer(player.getChristmas2016()));
			object.addProperty("newYear2017", new Integer(player.getNewYear2017()));
			object.addProperty("easter2017", new Integer(player.getEaster2017()));
			object.add("hcimdunginventory", builder.toJsonTree(player.getDungeoneeringIronInventory().getItems()));
			object.add("hcimdungequipment", builder.toJsonTree(player.getDungeoneeringIronEquipment().getItems()));
			object.addProperty("bonecrusheffect", new Boolean(player.getBonecrushEffect()));
			object.add("p-tps", builder.toJsonTree(player.getPreviousTeleports()));
			object.addProperty("yell-tit", player.getYellTitle() == null ? "null" : player.getYellTitle());
			// doneHween2016
			// object.add("uimDungItems",
			// builder.toJsonTre1e(player.getBank(0).getValidItems()));


			object.addProperty("3x3", player.get3x3());
			object.addProperty("4x4", player.get4x4());
			object.addProperty("afk-tree", player.getAfkTree());
			object.addProperty("afk-sapphire", player.getAfkSapphire());
			object.addProperty("afk-emerald", player.getAfkEmerald());
			object.addProperty("afk-ruby", player.getAfkbRuby());
			object.addProperty("afk-diamond", player.getAfkDiamond());
			object.addProperty("afk-onyx", player.getAfkOnyx());
			object.addProperty("afk-zenyte", player.getAfkZenyte());

			object.add("starter-task-amount", builder.toJsonTree(player.getStarterTasks().getAmountRemaining()));
			object.add("starter-task-completed", builder.toJsonTree(player.getStarterTasks().getCompleted()));
			object.add("progression-zones", builder.toJsonTree(player.getProgressionZones()));
			object.add("zones-complete", builder.toJsonTree(player.getZonesComplete()));

			object.addProperty("gamble-banned", player.isGambleBanned());
			object.addProperty("chest-looted", player.isChestLooted());
			object.addProperty("fish-collected", player.isFishCollected());
			object.addProperty("reward-collected", player.isRewardCollected());
			object.addProperty("treasure-map-1-collected", player.isTreasureMap1Collected());
			object.addProperty("treasure-map-2-collected", player.isTreasureMap2Collected());
			object.addProperty("treasure-map-3-collected", player.isTreasureMap3Collected());
			object.addProperty("lucifers-unlocked", player.isUnlockedLucifers());
			object.addProperty("quest-one-started", player.getQuestOneStarted());
			object.addProperty("quest-one-step-one", player.getQuestOneStep1());
			object.addProperty("quest-one-step-two", player.getQuestOneStep2());
			object.addProperty("quest-one-step-three", player.getQuestOneStep3());
			object.addProperty("quest-one-step-four", player.getQuestOneStep4());
			object.addProperty("quest-one-step-five", player.getQuestOneStep5());
			object.addProperty("quest-one-step-six", player.getQuestOneStep6());
			object.addProperty("quest-one-step-seven", player.getQuestOneStep7());

			object.addProperty("quest-two-started", player.getQuestTwoStarted());
			object.addProperty("quest-two-step-one", player.getQuestTwoStep1());
			object.addProperty("quest-two-step-two", player.getQuestTwoStep2());
			object.addProperty("quest-two-step-three", player.getQuestTwoStep3());
			object.addProperty("quest-two-step-four", player.getQuestTwoStep4());
			object.addProperty("quest-two-step-five", player.getQuestTwoStep5());
			object.addProperty("quest-two-step-six", player.getQuestTwoStep6());
			object.addProperty("quest-two-step-seven", player.getQuestTwoStep7());


			object.addProperty("quest-three-started", player.getQuestThreeStarted());
			object.addProperty("quest-three-step-one", player.getQuestThreeStep1());
			object.addProperty("quest-three-step-two", player.getQuestThreeStep2());
			object.addProperty("quest-three-step-three", player.getQuestThreeStep3());
			object.addProperty("quest-three-step-four", player.getQuestThreeStep4());
			object.addProperty("quest-three-step-five", player.getQuestThreeStep5());
			object.addProperty("quest-three-step-six", player.getQuestThreeStep6());
			object.addProperty("quest-three-step-seven", player.getQuestThreeStep7());

			object.addProperty("talked-to-ghost", player.getTalkedToGhost());
			object.addProperty("magic1-unlocked", player.getMagicGuildTier1());
			object.addProperty("magic2-unlocked", player.getMagicGuildTier2());
			object.addProperty("magic3-unlocked", player.getMagicGuildTier3());
			object.addProperty("magic-master", player.getMagicianMaster());
			object.addProperty("warrior1-unlocked", player.getWarriorGuildTier1());
			object.addProperty("warrior2-unlocked", player.getWarriorGuildTier2());
			object.addProperty("warrior3-unlocked", player.getWarriorGuildTier3());
			object.addProperty("warrior-master", player.getWarriorMaster());
			object.addProperty("archer1-unlocked", player.getArcherGuildTier1());
			object.addProperty("archer2-unlocked", player.getArcherGuildTier2());
			object.addProperty("archer3-unlocked", player.getArcherGuildTier3());
			object.addProperty("archer-master", player.getArcherMaster());
			object.addProperty("dark-supremes-unlocked", player.isUnlockedDarkSupreme());
			object.add("currency-pouch", builder.toJsonTree(player.getCurrencyPouch()));
			object.addProperty("lastTGloveIndex", player.lastTGloveIndex);
			if (player.getIronmanGroup() != null)
				object.addProperty("group-ironman-id", player.getIronmanGroup().getUniqueId());
			object.addProperty("group-ironman-locked", player.isGroupIronmanLocked());
			object.addProperty("lastInstanceNpc", player.lastInstanceNpc);
			object.add("daily-task", builder.toJsonTree(player.dailies));
			object.addProperty("daily-skips", player.dailySkips);
			object.addProperty("dailies-done", player.dailiesCompleted);
			object.addProperty("daily-task-info", player.taskInfo);
			object.addProperty("level-notifications", player.levelNotifications);
			object.add("dailies-received-times", builder.toJsonTree(player.getTaskReceivedTimes()));


			object.add("favorite-teleports", builder.toJsonTree(player.getFavoriteTeleports()));

			object.add("obtained-pets", builder.toJsonTree(player.getObtainedPets()));

			writer.write(builder.toJson(object));
			writer.close();

			/*
			 * Housing
			 */
			/*
			 * FileOutputStream fileOut = new FileOutputStream("./data/saves/housing/rooms/"
			 * + player.getUsername() + ".ser"); ObjectOutputStream out = new
			 * ObjectOutputStream(fileOut); out.writeObject(player.getHouseRooms());
			 * out.close(); fileOut.close();
			 * 
			 * fileOut = new FileOutputStream("./data/saves/housing/furniture/" +
			 * player.getUsername() + ".ser"); out = new ObjectOutputStream(fileOut);
			 * out.writeObject(player.getHouseFurniture()); out.close(); fileOut.close();
			 * 
			 * fileOut = new FileOutputStream("./data/saves/housing/portals/" +
			 * player.getUsername() + ".ser"); out = new ObjectOutputStream(fileOut);
			 * out.writeObject(player.getHousePortals()); out.close(); fileOut.close();
			 */
		} catch (Exception e) {
			// An error happened while saving.
			GameServer.getLogger().log(Level.WARNING, "An error has occured while saving a character file!", e);
		}
	}

	public static boolean playerExists(String p) {
		p = Misc.formatPlayerName(p.toLowerCase());
		p = WordUtils.capitalizeFully(p);
		p.replaceAll(" ", "\\ ");
		// // System.out.println("./data/saves/characters/"+p+".json ....... "+ new
		// File("./data/saves/characters/"+p+".json").exists());
		return new File("./data/saves/characters/" + p + ".json").exists();
	}
}
