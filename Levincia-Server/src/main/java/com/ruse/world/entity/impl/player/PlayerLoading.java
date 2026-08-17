package com.ruse.world.entity.impl.player;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.ruse.engine.task.impl.FamiliarSpawnTask;
import com.ruse.model.*;
import com.ruse.model.PlayerRelations.PrivateChatStatus;
import com.ruse.model.container.impl.Bank;
import com.ruse.net.login.LoginResponses;
import com.ruse.world.content.CurrencyPouch;
import com.ruse.world.content.DropLog;
import com.ruse.world.content.DropLog.DropLogEntry;
import com.ruse.world.content.KillsTracker;
import com.ruse.world.content.KillsTracker.KillsEntry;
import com.ruse.world.content.LoyaltyProgramme.LoyaltyTitles;
import com.ruse.world.content.collectionlog.CollectionEntry;
import com.ruse.world.content.combat.magic.CombatSpells;
import com.ruse.world.content.combat.weapon.FightType;
import com.ruse.world.content.dailyTasksNew.DailyTaskSlot;
import com.ruse.world.content.dailytasks_new.DailyTask;
import com.ruse.world.content.dailytasks_new.TaskChallenge;
import com.ruse.world.content.grandexchange.GrandExchangeSlot;
import com.ruse.world.content.groupironman.GroupManager;
import com.ruse.world.content.groupironman.IronmanGroup;
import com.ruse.world.content.osrscollectionlog.Collection;
import com.ruse.world.content.skill.SkillManager.Skills;
import com.ruse.world.content.skill.impl.slayer.SlayerTasks;
import com.ruse.world.content.skill.impl.slayer.TaskType;
import com.ruse.world.content.skill.impl.summoning.BossPets;
import org.mindrot.jbcrypt.BCrypt;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerLoading {

    private final static Path SAVE_DIR = Paths.get("./data/saves/characters/");

    public static boolean accountExists(String name) {
        return SAVE_DIR.resolve(name + ".json").toFile().exists();
    }

    public static int getResult(Player player) {
    	return getResult(player, false);
    }

    public static int getResult(Player player, boolean force) {

        // Create the path and file objects.
        Path path = Paths.get("./data/saves/characters/", player.getUsername() + ".json");
        File file = path.toFile();

        // If the file doesn't exist, we're logging in for the first
        // time and can skip all of this.
        if (!file.exists()) {
            System.out.println("diesn't exist");
            return LoginResponses.NEW_ACCOUNT;
        }

        // Now read the properties from the json parser.
        try (FileReader fileReader = new FileReader(file)) {
            JsonParser fileParser = new JsonParser();
            Gson builder = new GsonBuilder().create();
            JsonObject reader = (JsonObject) fileParser.parse(fileReader);

            if (reader.has("total-play-time-ms")) {
                player.setTotalPlayTime(reader.get("total-play-time-ms").getAsLong());
            }

            if (reader.has("username")) {
                player.setUsername(reader.get("username").getAsString());
            }

            if (reader.has("uim-bank")) {
                Map<Integer, Integer> items = builder.fromJson(reader.get("uim-bank"),
                        new TypeToken<Map<Integer, Integer>>() {
                        }.getType());
                player.setUimBankItems(items);
            }

            if(reader.has("dg-floor")) {
                player.setDungeoneeringFloor(reader.get("dg-floor").getAsInt());
            }

            if(reader.has("dg-prestige")) {
                player.setDungeoneeringPrestige(reader.get("dg-prestige").getAsInt());
            }
            if (reader.has("has-pin2")) {
                player.setHasPin(reader.get("has-pin2").getAsBoolean());
            }
            if (reader.has("saved-pin2")) {
                player.setSavedPin(reader.get("saved-pin2").getAsString());
            }

            if (reader.has("money-pouch")) {
                player.setMoneyInPouch(reader.get("money-pouch").getAsLong());
            }
            if (reader.has("saved-ip")) {
                player.setSavedIp(reader.get("saved-ip").getAsString());
            }

            if (reader.has("password")) {
				String password = reader.get("password").getAsString();
				if (!password.equalsIgnoreCase("")) {
					if (!force) {
						if (!player.getPassword().equals(password)) {
							return LoginResponses.LOGIN_INVALID_CREDENTIALS;
						}
					}
					player.setPassword(password);
				}
			} else if (reader.has("hash")) {
                String hash = reader.get("hash").getAsString();
                player.setSalt(hash.substring(0, 29));
                if (BCrypt.checkpw(player.getPassword(), hash)) {
                    // System.out.println("Successfully authenticated hashed pw.");
                } else {
                    // System.out.println("Failed hashed pw authentication.");
                    return LoginResponses.LOGIN_INVALID_CREDENTIALS;
                }
            }

            if (reader.has("amount-donated-today")) {
                player.setAmountDonatedToday(reader.get("amount-donated-today").getAsInt());
            }

            if (reader.has("global-rate")) {
                player.getPointsHandler().setGlobalRate(reader.get("global-rate").getAsInt());
            }
            if (reader.has("peng-rate")) {
                player.getPointsHandler().setPengRate(reader.get("peng-rate").getAsInt());
            }

            if (reader.has("godmodetime")) {
                player.setGodModeTimer(reader.get("godmodetime").getAsInt());
            }
            if (reader.has("mini-lucifer")) {
                player.setMiniLucifer(reader.get("mini-lucifer").getAsBoolean());
            }
            if (reader.has("3x3")) {
                player.set3x3(reader.get("3x3").getAsBoolean());
            }
            if (reader.has("4x4")) {
                player.set4x4(reader.get("3x3").getAsBoolean());
            }
            if (reader.has("quest-one-started")) {
                player.setQuestOneStarted(reader.get("quest-one-started").getAsBoolean());
            }
            if (reader.has("quest-one-step-one")) {
                player.setQuestOneStep1(reader.get("quest-one-step-one").getAsBoolean());
            }
            if (reader.has("quest-one-step-two")) {
                player.setQuestOneStep2(reader.get("quest-one-step-two").getAsBoolean());
            }
            if (reader.has("quest-one-step-three")) {
                player.setQuestOneStep3(reader.get("quest-one-step-three").getAsBoolean());
            }
            if (reader.has("quest-one-step-four")) {
                player.setQuestOneStep4(reader.get("quest-one-step-four").getAsBoolean());
            }
            if (reader.has("quest-one-step-five")) {
                player.setQuestOneStep5(reader.get("quest-one-step-five").getAsBoolean());
            }
            if (reader.has("quest-one-step-six")) {
                player.setQuestOneStep6(reader.get("quest-one-step-six").getAsBoolean());
            }
            if (reader.has("quest-one-step-seven")) {
                player.setQuestOneStep7(reader.get("quest-one-step-seven").getAsBoolean());
            }
            if (reader.has("quest-two-started")) {
                player.setQuestTwoStarted(reader.get("quest-two-started").getAsBoolean());
            }
            if (reader.has("quest-two-step-one")) {
                player.setQuestTwoStep1(reader.get("quest-two-step-one").getAsBoolean());
            }
            if (reader.has("quest-two-step-two")) {
                player.setQuestTwoStep2(reader.get("quest-two-step-two").getAsBoolean());
            }
            if (reader.has("quest-two-step-three")) {
                player.setQuestTwoStep3(reader.get("quest-two-step-three").getAsBoolean());
            }
            if (reader.has("quest-two-step-four")) {
                player.setQuestTwoStep4(reader.get("quest-two-step-four").getAsBoolean());
            }
            if (reader.has("quest-two-step-five")) {
                player.setQuestTwoStep5(reader.get("quest-two-step-five").getAsBoolean());
            }
            if (reader.has("quest-two-step-six")) {
                player.setQuestTwoStep6(reader.get("quest-two-step-six").getAsBoolean());
            }
            if (reader.has("quest-two-step-seven")) {
                player.setQuestTwoStep7(reader.get("quest-two-step-seven").getAsBoolean());
            }
            if (reader.has("quest-three-step-one")) {
                player.setQuestThreeStep1(reader.get("quest-three-step-one").getAsBoolean());
            }
            if (reader.has("quest-three-step-two")) {
                player.setQuestThreeStep2(reader.get("quest-three-step-two").getAsBoolean());
            }
            if (reader.has("quest-three-step-three")) {
                player.setQuestThreeStep3(reader.get("quest-three-step-three").getAsBoolean());
            }
            if (reader.has("quest-three-step-four")) {
                player.setQuestThreeStep4(reader.get("quest-three-step-four").getAsBoolean());
            }
            if (reader.has("quest-three-step-five")) {
                player.setQuestThreeStep5(reader.get("quest-three-step-five").getAsBoolean());
            }
            if (reader.has("quest-three-step-six")) {
                player.setQuestThreeStep6(reader.get("quest-three-step-six").getAsBoolean());
            }
            if (reader.has("quest-three-step-seven")) {
                player.setQuestThreeStep7(reader.get("quest-three-step-seven").getAsBoolean());
            }
            if (reader.has("talked-to-ghost")) {
                player.setTalkedToGhost(reader.get("talked-to-ghost").getAsBoolean());
            }
            if (reader.has("archer1-unlocked")) {
                player.setArcherGuildTier1(reader.get("archer1-unlocked").getAsBoolean());
            }
            if (reader.has("archer2-unlocked")) {
                player.setArcherGuildTier2(reader.get("archer2-unlocked").getAsBoolean());
            }
            if (reader.has("archer3-unlocked")) {
                player.setArcherGuildTier3(reader.get("archer3-unlocked").getAsBoolean());
            }
            if (reader.has("archer-master")) {
                player.setArcherMaster(reader.get("archer-master").getAsBoolean());
            }
            if (reader.has("warrior1-unlocked")) {
                player.setWarriorGuildTier1(reader.get("warrior1-unlocked").getAsBoolean());
            }
            if (reader.has("warrior2-unlocked")) {
                player.setWarriorGuildTier2(reader.get("warrior2-unlocked").getAsBoolean());
            }
            if (reader.has("warrior3-unlocked")) {
                player.setWarriorGuildTier3(reader.get("warrior3-unlocked").getAsBoolean());
            }
            if (reader.has("warrior-master")) {
                player.setWarriorMaster(reader.get("warrior-master").getAsBoolean());
            }
            if (reader.has("magic1-unlocked")) {
                player.setMagicGuildTier1(reader.get("magic1-unlocked").getAsBoolean());
            }
            if (reader.has("magic2-unlocked")) {
                player.setMagicGuildTier2(reader.get("magic2-unlocked").getAsBoolean());
            }
            if (reader.has("magic3-unlocked")) {
                player.setMagicGuildTier3(reader.get("magic3-unlocked").getAsBoolean());
            }
            if (reader.has("magic-master")) {
                player.setMagicianMaster(reader.get("magic-master").getAsBoolean());
            }
            if (reader.has("celestial-member")) {
                player.setCelestial(reader.get("celestial-member").getAsBoolean());
            }
            if (reader.has("supreme-member")) {
                player.setSupreme(reader.get("supreme-member").getAsBoolean());
            }
            if (reader.has("supreme-charges")) {
                player.setSupremeCharges(reader.get("supreme-charges").getAsInt());
            }
            if (reader.has("fallen-warrior-unlocked")) {
                player.setFallenWarrior(reader.get("fallen-warrior-unlocked").getAsBoolean());
            }
            if (reader.has("dark-supreme")) {
                player.setDarkSupreme(reader.get("dark-supreme").getAsBoolean());
            }


            if (reader.has("claimed-first")) {
                player.claimedFirst = reader.get("claimed-first").getAsBoolean();
            }

            if (reader.has("claimed-second")) {
                player.claimedSecond = reader.get("claimed-second").getAsBoolean();
            }

            if (reader.has("claimed-third")) {
                player.claimedThird = reader.get("claimed-third").getAsBoolean();
            }

            if (reader.has("last-donation")) {
                player.lastDonation = reader.get("last-donation").getAsLong();
            }

            if (reader.has("last-time-reset")) {
                player.lastDonation = reader.get("last-time-reset").getAsLong();
            }

            if (reader.has("unlocked-rammernaut")) {
                player.setUnlockedRammernaut(reader.get("unlocked-rammernaut").getAsBoolean());
            }
            if (reader.has("travelling-day")) {
                player.setTravelingMerchantDay(reader.get("travelling-day").getAsInt());
            }

            if (reader.has("travelling-merchant")) {
                player.setMerchantItems(builder.fromJson(reader.get("travelling-merchant").getAsJsonArray(), Item[].class));
            }


            if (reader.has("days-voted")) {
                boolean[] completed = builder.fromJson(reader.get("days-voted").getAsJsonArray(),
                        boolean[].class);
                player.getVotingStreak().setDaysVoted(completed);
            }
            if (reader.has("daily-reward-day")) {
                player.getVotingStreak().setCurrentDay(reader.get("daily-reward-day").getAsInt());
            }
            if (reader.has("last-voted")) {
                player.setLastVotedDay(reader.get("last-voted").getAsInt());
            }
            if (reader.has("current-voting-streak")) {
                player.setCurrentVotingStreak(reader.get("current-voting-streak").getAsInt());
            }
            if (reader.has("daily-reward-epoch")) {
                player.getVotingStreak().setEpochDay(reader.get("daily-reward-epoch").getAsLong());
            }
            if (reader.has("email")) {
                player.setEmailAddress(reader.get("email").getAsString());
            }
            if (reader.has("lastTGloveIndex")) {
                player.lastTGloveIndex = reader.get("lastTGloveIndex").getAsInt();
            }
            if (reader.has("starter-task-amount")) {
                int[] amountRemaining = builder.fromJson(reader.get("starter-task-amount").getAsJsonArray(),
                        int[].class);
                player.getStarterTasks().setAmountRemaining(amountRemaining);
            }
            if (reader.has("starter-task-completed")) {
                boolean[] completed = builder.fromJson(reader.get("starter-task-completed").getAsJsonArray(),
                        boolean[].class);
                player.getStarterTasks().setCompleted(completed);
            }

            if (reader.has("staff-rights")) {
                String rights = reader.get("staff-rights").getAsString();

                /** retard keen using shit ranks **/

                /*
                 * if(rights.equals("DONATOR")) { rights = "BRONZE_MEMBER"; } else
                 * if(rights.equals("SUPER_DONATOR")) { rights = "SILVER_MEMBER"; } else
                 * if(rights.equals("EXTREME_DONATOR")) { rights = "GOLD_MEMBER"; } else
                 * if(rights.equals("DIAMOND_DONATOR")) { rights = "PLATINUM_MEMBER"; } else
                 * if(rights.equals("ONYX_DONATOR")) { rights = "DIAMOND_MEMBER"; }
                 */

                player.setRights(PlayerRights.valueOf(rights));
            }

            if (reader.has("game-mode")) {
                if (reader.get("game-mode").getAsString().equalsIgnoreCase("HARDCORE_IRONMAN")) {
                    player.setGameMode(GameMode.ULTIMATE_IRONMAN);
                } else {
                    player.setGameMode(GameMode.valueOf(reader.get("game-mode").getAsString()));
                }
            }

            if (reader.has("collection-data")) {
                Type collectionLogType = new TypeToken<List<CollectionEntry>>() {
                }.getType();
                player.setCollectionLogData(new Gson().fromJson(reader.get("collection-data"), collectionLogType));
            }
            if (reader.has("collectionlog-data")) {
                HashMap<Collection, ArrayList<Item>>collectionlog = builder.fromJson(reader.get("collectionlog-data"),

                        new TypeToken<HashMap<Collection, ArrayList<Item>>>() {
                        }.getType());
                player.getCollectionLog2().collectionLog = collectionlog;

            }
            if (reader.has("collectionlog-data2")) {
                HashMap<Collection, Integer>collectionlog2 = builder.fromJson(reader.get("collectionlog-data2"),

                        new TypeToken<HashMap<Collection, Integer>>() {
                        }.getType());
                player.getCollectionLog2().collectionLogofkills= collectionlog2;

            }
            if (reader.has("collectionlog-data3")) {
                HashMap<Collection, Boolean>collectionlog3 = builder.fromJson(reader.get("collectionlog-data3"),

                        new TypeToken<HashMap<Collection, Boolean>>() {
                        }.getType());
                player.getCollectionLog2().collectionLogofrewards= collectionlog3;

            }
            if (reader.has("holy-prayers-unlocked")) {
                player.setUnlockedHolyPrayers(
                        builder.fromJson(reader.get("holy-prayers-unlocked").getAsJsonArray(), boolean[].class));
            }

            if (reader.has("current-boss-task")) {
                player.setCurrentBossTask(reader.get("current-boss-task").getAsInt());
            }

            if (reader.has("current-boss-amount")) {
                player.setCurrentBossTaskAmount(reader.get("current-boss-amount").getAsInt());
            }
            if (reader.has("unlocked-set1")) {
                player.setUnlockedSet1 (reader.get("unlocked-set1").getAsBoolean());
            }
            if (reader.has("unlocked-set2")) {
                player.setUnlockedSet2 (reader.get("unlocked-set2").getAsBoolean());
            }
            if (reader.has("unlocked-set3")) {
                player.setUnlockedSet3 (reader.get("unlocked-set3").getAsBoolean());
            }
            if (reader.has("unlocked-set4")) {
                player.setUnlockedSet4 (reader.get("unlocked-set4").getAsBoolean());
            }
            if (reader.has("unlocked-set5")) {
                player.setUnlockedSet5 (reader.get("unlocked-set5").getAsBoolean());
            }
            if (reader.has("unlocked-set6")) {
                player.setUnlockedSet6 (reader.get("unlocked-set6").getAsBoolean());
            }
            if (reader.has("unlocked-set7")) {
                player.setUnlockedSet7 (reader.get("unlocked-set7").getAsBoolean());
            }
            if (reader.has("unlocked-set8")) {
                player.setUnlockedSet8 (reader.get("unlocked-set8").getAsBoolean());
            }
            if (reader.has("unlocked-set9")) {
                player.setUnlockedSet8 (reader.get("unlocked-set9").getAsBoolean());
            }
            if (reader.has("unlocked-set10")) {
                player.setUnlockedSet8 (reader.get("unlocked-set10").getAsBoolean());
            }
            if (reader.has("unlocked-set11")) {
                player.setUnlockedSet8 (reader.get("unlocked-set11").getAsBoolean());
            }
            if (reader.has("unlocked-set12")) {
                player.setUnlockedSet8 (reader.get("unlocked-set12").getAsBoolean());
            }
            if (reader.has("unlocked-set13")) {
                player.setUnlockedSet8 (reader.get("unlocked-set13").getAsBoolean());
            }
            if (reader.has("unlocked-set14")) {
                player.setUnlockedSet8 (reader.get("unlocked-set14").getAsBoolean());
            }
            if (reader.has("unlocked-set15")) {
                player.setUnlockedSet8 (reader.get("unlocked-set15").getAsBoolean());
            }
            if (reader.has("unlocked-set16")) {
                player.setUnlockedSet8 (reader.get("unlocked-set16").getAsBoolean());
            }
            if (reader.has("unlocked-set17")) {
                player.setUnlockedSet8 (reader.get("unlocked-set17").getAsBoolean());
            }
            if (reader.has("unlocked-set18")) {
                player.setUnlockedSet8 (reader.get("unlocked-set18").getAsBoolean());
            }
            if (reader.has("unlocked-set19")) {
                player.setUnlockedSet8 (reader.get("unlocked-set19").getAsBoolean());
            }
            if (reader.has("unlocked-set20")) {
                player.setUnlockedSet8 (reader.get("unlocked-set20").getAsBoolean());
            }
            if (reader.has("has-completed-boss-task")) {
                player.setHasPlayerCompletedBossTask(reader.get("has-completed-boss-task").getAsBoolean());
            }

            if (reader.has("current-daily-task-id")) {
                player.setCurrentDailyTask(reader.get("current-daily-task-id").getAsString());
            }

            if (reader.has("current-daily-task-amount")) {
                player.setCurrentDailyTaskAmount(reader.get("current-daily-task-amount").getAsInt());
            }

            if (reader.has("current-daily-task-x-pos")) {
                player.setxPosDailyTask(reader.get("current-daily-task-x-pos").getAsInt());
            }

            if (reader.has("current-daily-task-y-pos")) {
                player.setyPostDailyTask(reader.get("current-daily-task-y-pos").getAsInt());
            }

            if (reader.has("current-daily-task-z-pos")) {
                player.setzPosDailyTask(reader.get("current-daily-task-z-pos").getAsInt());
            }
            if (reader.has("current-daily-task-reward")) {
                player.setRewardDailyTask(reader.get("current-daily-task-reward").getAsInt());
            }
            if (reader.has("discord-user")) {
                player.setDiscordUser(reader.get("discord-user").getAsLong());
            }
            if (reader.has("discord-tag")) {
                player.setDiscordTag(reader.get("discord-tag").getAsString());
            }
            if (reader.has("discord-points")) {
                player.setDiscordPoints(reader.get("discord-points").getAsInt());
            }

            if (reader.has("daysVoted")) {
                player.setDaysVoted(reader.get("daysVoted").getAsInt());
            }

            if (reader.has("totalTimesClaimed")) {
                player.setTotalTimesClaimed(reader.get("totalTimesClaimed").getAsInt());
            }

            if (reader.has("longestDaysVoted")) {
                player.setLongestDaysVoted(reader.get("longestDaysVoted").getAsInt());
            }

            if (reader.has("timeUntilNextReward")) {
                player.setTimeUntilNextReward(reader.get("timeUntilNextReward").getAsInt());
            }

            if (reader.has("lastVoted")) {
                player.setLastVoted(reader.get("lastVoted").getAsString());
            }

            if (reader.has("current-voting-streak")) {
                player.setCurrentVotingStreak(reader.get("current-voting-streak").getAsInt());
            }

            if (reader.has("entriesCurrency")) {
                player.setEntriesCurrency(reader.get("entriesCurrency").getAsDouble());
            }

            if (reader.has("loyalty-title")) {
                player.setLoyaltyTitle(LoyaltyTitles.valueOf(reader.get("loyalty-title").getAsString()));
            }

            if (reader.has("position")) {
                player.getPosition().setAs(builder.fromJson(reader.get("position"), Position.class));
            }

            if (reader.has("online-status")) {
                player.getRelations().setStatus(PrivateChatStatus.valueOf(reader.get("online-status").getAsString()),
                        false);
            }

            if (reader.has("given-starter")) {
                player.setReceivedStarter(reader.get("given-starter").getAsBoolean());
            }

            if (reader.has("donated")) {
                player.incrementAmountDonated(reader.get("donated").getAsInt());
            }

            if (reader.has("minutes-bonus-exp")) {
                player.setMinutesBonusExp(reader.get("minutes-bonus-exp").getAsInt(), false);
            }
            if (reader.has("minutes-voting-dr")) {
                player.setMinutesVotingDR(reader.get("minutes-voting-dr").getAsInt(), false);
            }
            if (reader.has("minutes-voting-dmg")) {
                player.setMinutesVotingDMG(reader.get("minutes-voting-dmg").getAsInt(), false);
            }

            if (reader.has("total-gained-exp")) {
                player.getSkillManager().setTotalGainedExp(reader.get("total-gained-exp").getAsInt());
            }

            if (reader.has("dung-tokens")) {
                player.getPointsHandler().setDungeoneeringTokens(reader.get("dung-tokens").getAsInt(), false);
            }

            if (reader.has("barrows-points")) {
                player.getPointsHandler().setBarrowsPoints(reader.get("barrows-points").getAsInt(), false);
            }

            if (reader.has("donator-points")) {
                player.getPointsHandler().setDonatorPoints(reader.get("donator-points").getAsInt(), false);
            }

            if (reader.has("prestige-points")) {
                player.getPointsHandler().setPrestigePoints(reader.get("prestige-points").getAsInt(), false);
            }
            if (reader.has("Skilling-points")) {
                player.getPointsHandler().setSkillingPoints(reader.get("Skilling-points").getAsInt(), false);
            }

            if (reader.has("achievement-points")) {
                player.getPointsHandler().setAchievementPoints(reader.get("achievement-points").getAsInt(), false);
            }

            if (reader.has("commendations")) {
                player.getPointsHandler().setCommendations(reader.get("commendations").getAsInt(), false);
            }

            if (reader.has("loyalty-points")) {
                player.getPointsHandler().setLoyaltyPoints(reader.get("loyalty-points").getAsInt(), false);
            }


            if (reader.has("voting-points")) {
                player.getPointsHandler().setVotingPoints(reader.get("voting-points").getAsInt(), false);
            }
            if (reader.has("spawn-killcount")) {
                player.getPointsHandler().setSPAWNKILLCount(reader.get("spawn-killcount").getAsInt(), false);
            }
            if (reader.has("lord-killcount")) {
                player.getPointsHandler().setLORDKILLCount(reader.get("lord-killcount").getAsInt(), false);
            }
            if (reader.has("demon-killcount")) {
                player.getPointsHandler().setDEMONKILLCount(reader.get("demon-killcount").getAsInt(), false);
            }
            if (reader.has("dragon-killcount")) {
                player.getPointsHandler().setDRAGONKILLCount(reader.get("dragon-killcount").getAsInt(), false);
            }
            if (reader.has("beast-killcount")) {
                player.getPointsHandler().setBEASTKILLCount(reader.get("beast-killcount").getAsInt(), false);
            }
            if (reader.has("king-killcount")) {
                player.getPointsHandler().setKINGKILLCount(reader.get("king-killcount").getAsInt(), false);
            }
            if (reader.has("avatar-killcount")) {
                player.getPointsHandler().setAVATARKILLCount(reader.get("avatar-killcount").getAsInt(), false);
            }
            if (reader.has("angel-killcount")) {
                player.getPointsHandler().setANGELKILLCount(reader.get("angel-killcount").getAsInt(), false);
            }
            if (reader.has("lucien-killcount")) {
                player.getPointsHandler().setLUCIENKILLCount(reader.get("lucien-killcount").getAsInt(), false);
            }
            if (reader.has("hercules-killcount")) {
                player.getPointsHandler().setHERCULESKILLCount(reader.get("hercules-killcount").getAsInt(), false);
            }
            if (reader.has("satan-killcount")) {
                player.getPointsHandler().setSATANKILLCount(reader.get("satan-killcount").getAsInt(), false);
            }
            if (reader.has("zeus-killcount")) {
                player.getPointsHandler().setZEUSKILLCount(reader.get("zeus-killcount").getAsInt(), false);
            }
            if (reader.has("groudon-killcount")) {
                player.getPointsHandler().setGROUDONKILLCount(reader.get("groudon-killcount").getAsInt(), false);
            }
            if (reader.has("vindicta-killcount")) {
                player.getPointsHandler().setFENRIRKILLCount(reader.get("vindicta-killcount").getAsInt(), false);
            }
            if (reader.has("midnight-killcount")) {
                player.getPointsHandler().setMIDNIGHTKILLCount(reader.get("midnight-killcount").getAsInt(), false);
            }
            if (reader.has("ab-killcount")) {
                player.getPointsHandler().setBorkKC(reader.get("ab-killcount").getAsInt(), false);
            }
            if (reader.has("quest-one-dream-kc")) {
                player.getPointsHandler().setQuestOneDreamKC(reader.get("quest-one-dream-kc").getAsInt(), false);
            }

            if (reader.has("zombie-raid-kc")) {
                player.getPointsHandler().setZombieRaidsKC(reader.get("zombie-raid-kc").getAsInt(), false);
            }
            if (reader.has("isles-kc")) {
                player.getPointsHandler().setIslesKC(reader.get("isles-kc").getAsInt(), false);
            }
            if (reader.has("lastInstanceNpc")) {
                player.lastInstanceNpc = reader.get("lastInstanceNpc").getAsInt();
            }
            if (reader.has("cosmetic-override")) {
                player.setCosmeticOveride(reader.get("cosmetic-override").getAsBoolean());
            }
            if (reader.has("treasure-hunter-kc")) {
                player.getPointsHandler().setTreasureHunterKC(reader.get("treasure-hunter-kc").getAsInt(), false);
            }
            if (reader.has("suffering-kc")) {
                player.getPointsHandler().setSufferingKC(reader.get("suffering-kc").getAsInt(), false);
            }
            if (reader.has("isle-easy-timer")) {
                player.setIsleEasyTimer(reader.get("isle-easy-timer").getAsLong());
            }
            if (reader.has("isle-med-timer")) {
                player.setIsleMedTimer(reader.get("isle-med-timer").getAsLong());
            }
            if (reader.has("isle-hard-timer")) {
                player.setIsleHardTimer(reader.get("isle-hard-timer").getAsLong());
            }

            if (reader.has("elder-easy-timer")) {
                player.setElderEasyTimer(reader.get("elder-easy-timer").getAsLong());
            }
            if (reader.has("elder-med-timer")) {
                player.setElderMedTimer(reader.get("elder-med-timer").getAsLong());
            }
            if (reader.has("elder-hard-timer")) {
                player.setElderHardTimer(reader.get("elder-hard-timer").getAsLong());
            }
            if (reader.has("isle-dr")) {
                player.setIsleDropRate(reader.get("isle-dr").getAsDouble());
            }

            if (reader.has("elder-dr")) {
                player.setElderDropRate(reader.get("elder-dr").getAsDouble());
            }
            if (reader.has("starter-task-amount")) {
                int[] amountRemaining = builder.fromJson(reader.get("starter-task-amount").getAsJsonArray(),
                        int[].class);
                player.getStarterTasks().setAmountRemaining(amountRemaining);
            }
            if (reader.has("starter-task-completed")) {
                boolean[] completed = builder.fromJson(reader.get("starter-task-completed").getAsJsonArray(),
                        boolean[].class);
                player.getStarterTasks().setCompleted(completed);
            }
            if (reader.has("sacrificed-owner")) {
                player.setSacrificedFantasyItem(reader.get("sacrificed-owner").getAsBoolean());
            }
            if (reader.has("fantasy")) {
                player.setFantasy(reader.get("fantasy").getAsBoolean());
            }
            if (reader.has("diminisher")) {
                player.setDiminisher(reader.get("diminisher").getAsBoolean());
            }
            if (reader.has("upg-dr")) {
                player.setScrollBonus(reader.get("upg-dr").getAsDouble());
            }
            if (reader.has("turkeys-mutated")) {
                player.setTurkeysMutated(builder.fromJson(reader.get("turkeys-mutated"), boolean[].class));
            }
            if (reader.has("gods-coffer")) {
                player.getGodsCoffer().clear();
                for (Item item : builder.fromJson(reader.get("gods-coffer").getAsJsonArray(), Item[].class)) {
                    player.getGodsCoffer().add(item);
                }
            }
            if (reader.has("telos-coffer")) {
                player.getTelosCoffer().clear();
                for (Item item : builder.fromJson(reader.get("telos-coffer").getAsJsonArray(), Item[].class)) {
                    player.getTelosCoffer().add(item);
                }
            }
            if (reader.has("easy-isle-god-kc")) {
                player.setEasyIsleGodKC(reader.get("easy-isle-god-kc").getAsInt());
            }
            if (reader.has("med-isle-god-kc")) {
                player.setMedIsleGodKC(reader.get("med-isle-god-kc").getAsInt());
            }
            if (reader.has("hard-isle-god-kc")) {
                player.setHardIsleGodKC(reader.get("hard-isle-god-kc").getAsInt());
            }
            if (reader.has("easy-elder-god-kc")) {
                player.setEasyElderGodKC(reader.get("easy-elder-god-kc").getAsInt());
            }
            if (reader.has("med-elder-god-kc")) {
                player.setMedElderGodKC(reader.get("med-elder-god-kc").getAsInt());
            }
            if (reader.has("hard-elder-god-kc")) {
                player.setHardElderGodKC(reader.get("hard-elder-god-kc").getAsInt());
            }
            if (reader.has("necromancer-kc")) {
                player.getPointsHandler().setNecromancerKC(reader.get("necromancer-kc").getAsInt(), false);
            }
            if (reader.has("shadow-drop-rate")) {
                player.setShadowRareDropBoost(reader.get("shadow-drop-rate").getAsInt());
            }
            if (reader.has("shadow-key-opened")) {
                player.setShadowKeysOpened(reader.get("shadow-key-opened").getAsInt());
            }
            if (reader.has("seasonpass-xp")) {
                player.getSeasonPass().setXp(reader.get("seasonpass-xp").getAsInt());
            }
            if (reader.has("seasonpass-tier")) {
                player.getSeasonPass().setTier(reader.get("seasonpass-tier").getAsInt());
            }

            if (reader.has("seasonpass-season")) {
                player.getSeasonPass().setCurrentSeason(reader.get("seasonpass-season").getAsInt());
            }

            if (reader.has("stream-count")) {
                player.getPointsHandler().setStreamCount(reader.get("stream-count").getAsInt(), false);
            }
            if (reader.has("seasonpass-kc")) {
                player.set500kcforseasonpass(reader.get("seasonpass-kc").getAsInt());

            }
            if (reader.has("monthly-vote-count")) {
                player.setMonthlyVoteCount (reader.get("monthly-vote-count").getAsInt());

            }
            if (reader.has("monthly-donator-count")) {
                player.setMonthlyDonationCount(reader.get("monthly-donator-count").getAsInt());

            }
            if (reader.has("pumpkins-collected")) {
                player.setSoulInPouch(reader.get("pumpkins-collected").getAsInt());

            }
            if (reader.has("unlockedseasonpass")) {
                player.setunlockedseasonpass(reader.get("unlockedseasonpass").getAsBoolean());
            }
            if (reader.has("unlockedMembership")) {
                player.setUnlockedMembership(reader.get("unlockedMembership").getAsBoolean());
            }
            if (reader.has("unlockedCosmetic")) {
                player.setUnlockedCosmetic(reader.get("unlockedCosmetic").getAsBoolean());
            }
            if (reader.has("faceless-magician-killcount")) {
                player.getPointsHandler().setFacelessMagicianKC(reader.get("faceless-magician-killcount").getAsInt(), false);
            }
            if (reader.has("lotus-magician-killcount")) {
                player.getPointsHandler().setLotusMagicianKC(reader.get("lotus-magician-killcount").getAsInt(), false);
            }
            if (reader.has("shadow-magician-killcount")) {
                player.getPointsHandler().setShadowMagicianKC(reader.get("shadow-magician-killcount").getAsInt(), false);
            }
            if (reader.has("forest-archer-killcount")) {
                player.getPointsHandler().setForestArcherKC(reader.get("forest-archer-killcount").getAsInt(), false);
            }
            if (reader.has("chaotic-archer-killcount")) {
                player.getPointsHandler().setChaoticArcherKC(reader.get("chaotic-archer-killcount").getAsInt(), false);
            }
            if (reader.has("divine-archer-killcount")) {
                player.getPointsHandler().setDivineArcherKC(reader.get("divine-archer-killcount").getAsInt(), false);
            }
            if (reader.has("lesarkus-warrior-killcount")) {
                player.getPointsHandler().setLesarkusWarriorKC(reader.get("lesarkus-warrior-killcount").getAsInt(), false);
            }
            if (reader.has("vampire-warrior-killcount")) {
                player.getPointsHandler().setVampireWarriorKC(reader.get("vampire-warrior-killcount").getAsInt(), false);
            }
            if (reader.has("ancient-warrior-killcount")) {
                player.getPointsHandler().setAncientWarriorKC(reader.get("ancient-warrior-killcount").getAsInt(), false);
            }
            if (reader.has("mini-lucifer-killcount")) {
                player.getPointsHandler().setMiniLuciferkillcount(reader.get("mini-lucifer-killcount").getAsInt());
            }
            if (reader.has("lucifer-killcount")) {
                player.getPointsHandler().setLuciferkillcount(reader.get("lucifer-killcount").getAsInt());
            }
            if (reader.has("npc-killcount")) {
                player.getPointsHandler().setNPCKILLCount(reader.get("npc-killcount").getAsInt(), false);
            }
            if (reader.has("unknown-completed")) {
                player.getPointsHandler().setUnknownCompleted(reader.get("unknown-completed").getAsInt(), false);
            }
            if (reader.has("total-prestiges")) {
                player.getPointsHandler().setTotalPrestiges(reader.get("total-prestiges").getAsInt(), false);
            }
            if (reader.has("minigame1-killcount")) {
                player.getPointsHandler().setMG1Count(reader.get("minigame1-killcount").getAsInt(), false);
            }
            if (reader.has("minigame2-killcount")) {
                player.getPointsHandler().setMG2Count(reader.get("minigame2-killcount").getAsInt(), false);
            }
            if (reader.has("minigame3-killcount")) {
                player.getPointsHandler().setMG3Count(reader.get("minigame3-killcount").getAsInt(), false);
            }
            if (reader.has("event-points")) {
                player.getPointsHandler().setEventPoints(reader.get("event-points").getAsInt(), false);
            }
            if (reader.has("boss-points")) {
                player.getPointsHandler().setBossPoints(reader.get("boss-points").getAsInt(), false);
            }
            if (reader.has("shilling-rate")) {
                player.getPointsHandler().setSHILLINGRate(reader.get("shilling-rate").getAsInt(), false);
            }

            if (reader.has("slayer-rate")) {
                player.getPointsHandler().setSlayerRate(reader.get("slayer-rate").getAsInt());
            }

            if (reader.has("slayer-spree")) {
                player.getPointsHandler().setSlayerSpree(reader.get("slayer-spree").getAsInt(), false);
            }

            if (reader.has("slayer-points")) {
                player.getPointsHandler().setSlayerPoints(reader.get("slayer-points").getAsInt(), false);
            }

            if (reader.has("slayer-master1")) {
                player.getSlayer().setTaskType(TaskType.valueOf(reader.get("slayer-master1").getAsString()));
            }

            if (reader.has("slayer-task1")) {
                player.getSlayer().setSlayerTask(SlayerTasks.valueOf(reader.get("slayer-task1").getAsString()));
            }


            if (reader.has("easy-task-kc")) {
                player.getSlayer().setEasyTaskKC(reader.get("easy-task-kc").getAsInt());
            }
            if (reader.has("med-task-kc")) {
                player.getSlayer().setMedTaskKC(reader.get("med-task-kc").getAsInt());
            }
            if (reader.has("hard-task-kc")) {
                player.getSlayer().setHardTaskKC(reader.get("hard-task-kc").getAsInt());
            }
            if (reader.has("boss-task-kc")) {
                player.getSlayer().setBossTaskKC(reader.get("boss-task-kc").getAsInt());
            }

            if (reader.has("prev-slayer-task1")) {
                player.getSlayer().setLastTask(SlayerTasks.valueOf(reader.get("prev-slayer-task1").getAsString()));
            }

            if (reader.has("task-amount1")) {
                player.getSlayer().setAmountToSlay(reader.get("task-amount1").getAsInt());
            }

            if (reader.has("task-streak")) {
                player.getSlayer().setTaskStreak(reader.get("task-streak").getAsInt());
            }

            if (reader.has("duo-partner")) {
                String partner = reader.get("duo-partner").getAsString();
                player.getSlayer().setDuoPartner(partner.equals("null") ? null : partner);
            }

            if (reader.has("double-slay-xp")) {
                player.getSlayer().doubleSlayerXP = reader.get("double-slay-xp").getAsBoolean();
            }

            if (reader.has("slayer-fav")) {
                player.getSlayerFavourites().setFavouriteNpcIds(builder.fromJson(reader.get("slayer-fav").getAsJsonArray(), int[].class));
            }
            if (reader.has("slayer-blocked")) {
                player.getSlayerFavourites().setBlockedNpcIds(builder.fromJson(reader.get("slayer-blocked").getAsJsonArray(), int[].class));
            }

            if (reader.has("quest-points")) {
                player.getPointsHandler().setQuestPoints(reader.get("quest-points").getAsInt(), false);
            }
            if (reader.has("pk-points")) {
                player.getPointsHandler().setPkPoints(reader.get("pk-points").getAsInt(), false);
            }

            if (reader.has("player-kills")) {
                player.getPlayerKillingAttributes().setPlayerKills(reader.get("player-kills").getAsInt());
            }

            if (reader.has("player-killstreak")) {
                player.getPlayerKillingAttributes().setPlayerKillStreak(reader.get("player-killstreak").getAsInt());
            }

            if (reader.has("player-deaths")) {
                player.getPlayerKillingAttributes().setPlayerDeaths(reader.get("player-deaths").getAsInt());
            }

            if (reader.has("target-percentage")) {
                player.getPlayerKillingAttributes().setTargetPercentage(reader.get("target-percentage").getAsInt());
            }

            if (reader.has("bh-rank")) {
                player.getAppearance().setBountyHunterSkull(reader.get("bh-rank").getAsInt());
            }
            if (reader.has("prestigeicon")) {
                player.getAppearance().setprestigeIcon(reader.get("prestigeicon").getAsInt());
            }
            if (reader.has("gender")) {
                player.getAppearance().setGender(Gender.valueOf(reader.get("gender").getAsString()));
            }

            if (reader.has("spell-book")) {
                player.setSpellbook(MagicSpellbook.valueOf(reader.get("spell-book").getAsString()));
            }

            if (reader.has("prayer-book")) {
                player.setPrayerbook(Prayerbook.valueOf(reader.get("prayer-book").getAsString()));
            }
            if (reader.has("running")) {
                player.setRunning(reader.get("running").getAsBoolean());
            }
            if (reader.has("run-energy")) {
                player.setRunEnergy(reader.get("run-energy").getAsInt());
            }
            if (reader.has("music")) {
                player.setMusicActive(reader.get("music").getAsBoolean());
            }
            if (reader.has("sounds")) {
                player.setSoundsActive(reader.get("sounds").getAsBoolean());
            }
            if (reader.has("auto-retaliate")) {
                player.setAutoRetaliate(reader.get("auto-retaliate").getAsBoolean());
            }
            if (reader.has("xp-locked")) {
                player.setExperienceLocked(reader.get("xp-locked").getAsBoolean());
            }
            if (reader.has("veng-cast")) {
                player.setHasVengeance(reader.get("veng-cast").getAsBoolean());
            }
            if (reader.has("last-veng")) {
                player.getLastVengeance().reset(reader.get("last-veng").getAsLong());
            }
            if (reader.has("fight-type")) {
                player.setFightType(FightType.valueOf(reader.get("fight-type").getAsString()));
            }
            if (reader.has("sol-effect")) {
                player.setStaffOfLightEffect(Integer.valueOf(reader.get("sol-effect").getAsInt()));
            }
            if (reader.has("skull-timer")) {
                player.setSkullTimer(reader.get("skull-timer").getAsInt());
            }
            if (reader.has("accept-aid")) {
                player.setAcceptAid(reader.get("accept-aid").getAsBoolean());
            }
            if (reader.has("poison-damage")) {
                player.setPoisonDamage(reader.get("poison-damage").getAsInt());
            }
            if (reader.has("poison-immunity")) {
                player.setPoisonImmunity(reader.get("poison-immunity").getAsInt());
            }
            if (reader.has("double-dr-timer")) {
                player.setDoubleDRTimer(reader.get("double-dr-timer").getAsInt());
            }
            if (reader.has("double-ddr-timer")) {
                player.setDoubleDDRTimer(reader.get("double-ddr-timer").getAsInt());
            }
            if (reader.has("double-dmg-timer")) {
                player.setDoubleDMGTimer(reader.get("double-dmg-timer").getAsInt());
            }
            if (reader.has("fire-immunity")) {
                player.setFireImmunity(reader.get("fire-immunity").getAsInt());
            }
            if (reader.has("fire-damage-mod")) {
                player.setFireDamageModifier(reader.get("fire-damage-mod").getAsInt());
            }
            if (reader.has("prayer-renewal-timer")) {
                player.setPrayerRenewalPotionTimer(reader.get("prayer-renewal-timer").getAsInt());
            }
            if (reader.has("teleblock-timer")) {
                player.setTeleblockTimer(reader.get("teleblock-timer").getAsInt());
            }
            if (reader.has("special-amount")) {
                player.setSpecialPercentage(reader.get("special-amount").getAsInt());
            }

            if (reader.has("entered-gwd-room")) {
                player.getMinigameAttributes().getGodwarsDungeonAttributes()
                        .setHasEnteredRoom(reader.get("entered-gwd-room").getAsBoolean());
            }

            if (reader.has("gwd-altar-delay")) {
                player.getMinigameAttributes().getGodwarsDungeonAttributes()
                        .setAltarDelay(reader.get("gwd-altar-delay").getAsLong());
            }

            if (reader.has("gwd-killcount")) {
                player.getMinigameAttributes().getGodwarsDungeonAttributes()
                        .setKillcount(builder.fromJson(reader.get("gwd-killcount"), int[].class));
            }

            if (reader.has("effigy")) {
                player.setEffigy(reader.get("effigy").getAsInt());
            }

            if (reader.has("summon-npc")) {
                int npc = reader.get("summon-npc").getAsInt();
                if (npc > 0)
                    player.getSummoning().setFamiliarSpawnTask(new FamiliarSpawnTask(player)).setFamiliarId(npc);
            }
            if (reader.has("summon-death")) {
                int death = reader.get("summon-death").getAsInt();
                if (death > 0 && player.getSummoning().getSpawnTask() != null)
                    player.getSummoning().getSpawnTask().setDeathTimer(death);
            }
            if (reader.has("process-farming")) {
                player.setProcessFarming(reader.get("process-farming").getAsBoolean());
            }

            if (reader.has("clanchat")) {
                String clan = reader.get("clanchat").getAsString();
                if (!clan.equals("null"))
                    player.setClanChatName(clan);
            }
            if (reader.has("autocast")) {
                player.setAutocast(reader.get("autocast").getAsBoolean());
            }
            if (reader.has("autocast-spell")) {
                int spell = reader.get("autocast-spell").getAsInt();
                if (spell != -1)
                    player.setAutocastSpell(CombatSpells.getSpell(spell));
            }

            if (reader.has("dfs-charges")) {
                player.incrementDfsCharges(reader.get("dfs-charges").getAsInt());
            }
            if (reader.has("kills")) {
                KillsTracker.submit(player, builder.fromJson(reader.get("kills").getAsJsonArray(), KillsEntry[].class));
            }

            if (reader.has("drops")) {
                DropLog.submit(player, builder.fromJson(reader.get("drops").getAsJsonArray(), DropLogEntry[].class));
            }

            if (reader.has("lastlogin"))
                player.lastLogin = (reader.get("lastlogin").getAsLong());
            if (reader.has("lastdailyclaim"))
                player.lastDailyClaim = (reader.get("lastdailyclaim").getAsLong());

            if (reader.has("day1claimed"))
                player.day1Claimed = (reader.get("day1claimed").getAsBoolean());

            if (reader.has("day2claimed"))
                player.day2Claimed = (reader.get("day2claimed").getAsBoolean());

            if (reader.has("day3claimed"))
                player.day3Claimed = (reader.get("day3claimed").getAsBoolean());

            if (reader.has("day4claimed"))
                player.day4Claimed = (reader.get("day4claimed").getAsBoolean());

            if (reader.has("day5claimed"))
                player.day5Claimed = (reader.get("day5claimed").getAsBoolean());

            if (reader.has("day6claimed"))
                player.day6Claimed = (reader.get("day6claimed").getAsBoolean());

            if (reader.has("day7claimed"))
                player.day7Claimed = (reader.get("day7claimed").getAsBoolean());

            if (reader.has("lastvotetime"))
                player.lastVoteTime = (reader.get("lastvotetime").getAsLong());

            if (reader.has("hasvotedtoday"))
                player.hasVotedToday = (reader.get("hasvotedtoday").getAsBoolean());

            if (reader.has("recoil-deg")) {
                player.setRecoilCharges(reader.get("recoil-deg").getAsInt());
            }

            if (reader.has("starter-deg")) {
                player.setStarterCharges(reader.get("starter-deg").getAsInt());
            }
            if (reader.has("brawlers-deg")) {
                player.setBrawlerCharges(builder.fromJson(reader.get("brawlers-deg").getAsJsonArray(), int[].class));
            }

            if (reader.has("ancient-deg")) {
                player.setAncientArmourCharges(
                        builder.fromJson(reader.get("ancient-deg").getAsJsonArray(), int[].class));
            }

            if (reader.has("blowpipe-deg")) {
                player.setBlowpipeCharges(reader.get("blowpipe-deg").getAsInt());
            }

            if (reader.has("killed-players")) {
                List<String> list = new ArrayList<String>();
                String[] killed_players = builder.fromJson(reader.get("killed-players").getAsJsonArray(),
                        String[].class);
                for (String s : killed_players)
                    list.add(s);
                player.getPlayerKillingAttributes().setKilledPlayers(list);
            }

            if (reader.has("vod-brother")) {
                player.getMinigameAttributes().getVoidOfDarknessAttributes().setBarrowsData(
                        builder.fromJson(reader.get("vod-brother").getAsJsonArray(), int[][].class));
            }

            if (reader.has("vod-killcount")) {
                player.getMinigameAttributes().getVoidOfDarknessAttributes()
                        .setKillcount((reader.get("vod-killcount").getAsInt()));
            }
            if (reader.has("hov-killcount")) {
                player.getMinigameAttributes().getHallsOfValorAttributes()
                        .setKillcount((reader.get("hov-killcount").getAsInt()));
            }
            if (reader.has("barrows-brother")) {
                player.getMinigameAttributes().getBarrowsMinigameAttributes().setBarrowsData(
                        builder.fromJson(reader.get("barrows-brother").getAsJsonArray(), int[][].class));
            }

            if (reader.has("random-coffin")) {
                player.getMinigameAttributes().getBarrowsMinigameAttributes()
                        .setRandomCoffin((reader.get("random-coffin").getAsInt()));
            }

            if (reader.has("barrows-killcount")) {
                player.getMinigameAttributes().getBarrowsMinigameAttributes()
                        .setKillcount((reader.get("barrows-killcount").getAsInt()));
            }

            if (reader.has("nomad")) {
                player.getMinigameAttributes().getNomadAttributes()
                        .setQuestParts(builder.fromJson(reader.get("nomad").getAsJsonArray(), boolean[].class));
            }

            if (reader.has("recipe-for-disaster")) {
                player.getMinigameAttributes().getRecipeForDisasterAttributes().setQuestParts(
                        builder.fromJson(reader.get("recipe-for-disaster").getAsJsonArray(), boolean[].class));
            }

            if (reader.has("recipe-for-disaster-wave")) {
                player.getMinigameAttributes().getRecipeForDisasterAttributes()
                        .setWavesCompleted((reader.get("recipe-for-disaster-wave").getAsInt()));
            }

            if (reader.has("clue-progress")) {
                player.setClueProgress((reader.get("clue-progress").getAsInt()));
            }

            if (reader.has("dung-items-bound")) {
                player.getMinigameAttributes().getDungeoneeringAttributes()
                        .setBoundItems(builder.fromJson(reader.get("dung-items-bound").getAsJsonArray(), int[].class));
            }


            if (reader.has("hween-trick")) {
                player.getHweenEvent().setTrick(reader.get("hween-trick").getAsInt());
            }
            if (reader.has("hween-treat")) {
                player.getHweenEvent().setTreat(reader.get("hween-treat").getAsInt());
            }
            if (reader.has("unlocked-trick")) {
                player.getHweenEvent().setUnlockedTrick(builder.fromJson(reader.get("unlocked-trick"), boolean[].class));
            }
            if (reader.has("unlocked-treat")) {
                player.getHweenEvent().setUnlockedTreat(builder.fromJson(reader.get("unlocked-treat"), boolean[].class));
            }
            if (reader.has("unlocked-crown")) {
                player.getHweenEvent().setUnlockedCrown(reader.get("unlocked-crown").getAsBoolean());
            }


            if (reader.has("rune-ess")) {
                player.setStoredRuneEssence((reader.get("rune-ess").getAsInt()));
            }

            if (reader.has("pure-ess")) {
                player.setStoredPureEssence((reader.get("pure-ess").getAsInt()));
            }

            if (reader.has("bank-pin")) {
                player.getBankPinAttributes()
                        .setBankPin(builder.fromJson(reader.get("bank-pin").getAsJsonArray(), int[].class));
            }

            if (reader.has("has-bank-pin")) {
                player.getBankPinAttributes().setHasBankPin(reader.get("has-bank-pin").getAsBoolean());
            }
            if (reader.has("last-pin-attempt")) {
                player.getBankPinAttributes().setLastAttempt(reader.get("last-pin-attempt").getAsLong());
            }
            if (reader.has("invalid-pin-attempts")) {
                player.getBankPinAttributes().setInvalidAttempts(reader.get("invalid-pin-attempts").getAsInt());
            }

            if (reader.has("bank-pin")) {
                player.getBankPinAttributes()
                        .setBankPin(builder.fromJson(reader.get("bank-pin").getAsJsonArray(), int[].class));
            }

            if (reader.has("appearance")) {
                player.getAppearance().set(builder.fromJson(reader.get("appearance").getAsJsonArray(), int[].class));
            }

            if (reader.has("agility-obj")) {
                player.setCrossedObstacles(
                        builder.fromJson(reader.get("agility-obj").getAsJsonArray(), boolean[].class));
            }

            if (reader.has("skills")) {
                player.getSkillManager().setSkills(builder.fromJson(reader.get("skills"), Skills.class));
            }
            if (reader.has("inventory")) {
                player.getInventory()
                        .setItems(builder.fromJson(reader.get("inventory").getAsJsonArray(), Item[].class));
            }
            if (reader.has("equipment")) {
                player.getEquipment()
                        .setItems(builder.fromJson(reader.get("equipment").getAsJsonArray(), Item[].class));
            }
            if (reader.has("preset-equipment")) {
                player.getPreSetEquipment()
                        .setItems(builder.fromJson(reader.get("preset-equipment").getAsJsonArray(), Item[].class));
            }

            if (reader.has("offences")) {
                ArrayList<String> list = new ArrayList<String>();
                String[] killed_players = builder.fromJson(reader.get("offences").getAsJsonArray(), String[].class);
                for (String s : killed_players)
                    list.add(s);
                player.setOffences(list);
            }

            /** BANK **/
            for (int i = 0; i < 9; i++) {
                if (reader.has("bank-" + i + ""))
                    player.setBank(i, new Bank(player)).getBank(i).addItems(
                            builder.fromJson(reader.get("bank-" + i + "").getAsJsonArray(), Item[].class), false);
            }

            if (reader.has("bank-0")) {
                player.setBank(0, new Bank(player)).getBank(0)
                        .addItems(builder.fromJson(reader.get("bank-0").getAsJsonArray(), Item[].class), false);
            }

            if (reader.has("bank-1")) {
                player.setBank(1, new Bank(player)).getBank(1)
                        .addItems(builder.fromJson(reader.get("bank-1").getAsJsonArray(), Item[].class), false);
            }

            if (reader.has("bank-2")) {
                player.setBank(2, new Bank(player)).getBank(2)
                        .addItems(builder.fromJson(reader.get("bank-2").getAsJsonArray(), Item[].class), false);
            }

            if (reader.has("bank-3")) {
                player.setBank(3, new Bank(player)).getBank(3)
                        .addItems(builder.fromJson(reader.get("bank-3").getAsJsonArray(), Item[].class), false);
            }

            if (reader.has("bank-4")) {
                player.setBank(4, new Bank(player)).getBank(4)
                        .addItems(builder.fromJson(reader.get("bank-4").getAsJsonArray(), Item[].class), false);
            }

            if (reader.has("bank-5")) {
                player.setBank(5, new Bank(player)).getBank(5)
                        .addItems(builder.fromJson(reader.get("bank-5").getAsJsonArray(), Item[].class), false);
            }

            if (reader.has("bank-6")) {
                player.setBank(6, new Bank(player)).getBank(6)
                        .addItems(builder.fromJson(reader.get("bank-6").getAsJsonArray(), Item[].class), false);
            }

            if (reader.has("bank-7")) {
                player.setBank(7, new Bank(player)).getBank(7)
                        .addItems(builder.fromJson(reader.get("bank-7").getAsJsonArray(), Item[].class), false);
            }

            if (reader.has("bank-8")) {
                player.setBank(8, new Bank(player)).getBank(8)
                        .addItems(builder.fromJson(reader.get("bank-8").getAsJsonArray(), Item[].class), false);
            }

            if (reader.has("ge-slots")) {
                GrandExchangeSlot[] slots = builder.fromJson(reader.get("ge-slots").getAsJsonArray(),
                        GrandExchangeSlot[].class);
                player.setGrandExchangeSlots(slots);
            }

            if (reader.has("store")) {
                Item[] validStoredItems = builder.fromJson(reader.get("store").getAsJsonArray(), Item[].class);
                if (player.getSummoning().getSpawnTask() != null) {
                    player.getSummoning().getSpawnTask().setValidItems(validStoredItems);
                }
            }

            if (reader.has("charm-imp")) {
                int[] charmImpConfig = builder.fromJson(reader.get("charm-imp").getAsJsonArray(), int[].class);
                player.getSummoning().setCharmimpConfig(charmImpConfig);
            }

            if (reader.has("friends")) {
                long[] friends = builder.fromJson(reader.get("friends").getAsJsonArray(), long[].class);

                for (long l : friends) {
                    player.getRelations().getFriendList().add(l);
                }
            }
            if (reader.has("ignores")) {
                long[] ignores = builder.fromJson(reader.get("ignores").getAsJsonArray(), long[].class);

                for (long l : ignores) {
                    player.getRelations().getIgnoreList().add(l);
                }
            }

            if (reader.has("loyalty-titles")) {
                player.setUnlockedLoyaltyTitles(
                        builder.fromJson(reader.get("loyalty-titles").getAsJsonArray(), boolean[].class));
            }

            if (reader.has("daily-tasks-completed")) {
                player.setDailyTasksCompleted(reader.get("daily-tasks-completed").getAsInt());
            }

            if (reader.has("daily-task-slots")) {
                player.getDailyTaskManager().setTaskSlots(builder.fromJson(reader.get("daily-task-slots").getAsJsonArray(), DailyTaskSlot[][].class));
            }

            if (reader.has("achievements-points")) {
                int points = reader.get("achievements-points").getAsInt();
                player.getAchievements().setPoints(points);
            }
            if (reader.has("achievements-amount")) {
                int[][] amountRemaining = builder.fromJson(reader.get("achievements-amount").getAsJsonArray(),
                        int[][].class);
                player.getAchievements().setAmountRemaining(amountRemaining);
            }
            if (reader.has("achievements-completed")) {
                boolean[][] completed = builder.fromJson(reader.get("achievements-completed").getAsJsonArray(),
                        boolean[][].class);
                player.getAchievements().setCompleted(completed);
            }
            if (reader.has("achievements-daily")) {
                player.getAchievements().setDailyTaskDate(reader.get("achievements-daily").getAsLong());
            }
            if (reader.has("yellhexcolor")) {
                player.setYellHex(reader.get("yellhexcolor").getAsString());
            }

            if (reader.has("yell-tit")) {
                player.setYellTitle(reader.get("yell-tit").getAsString());
            }

            if (reader.has("fri13may16")) {
                player.setFriday13May2016(reader.get("fri13may16").getAsBoolean());
            }

            if (reader.has("spiritdebug")) {
                player.setSpiritDebug(reader.get("spiritdebug").getAsBoolean());
            }

            if (reader.has("reffered")) {
                player.setReffered(reader.get("reffered").getAsBoolean());
            }

            if (reader.has("indung")) {
                player.setInDung(reader.get("indung").getAsBoolean());
            }

            if (reader.has("toggledglobalmessages")) {
                player.setToggledGlobalMessages(reader.get("toggledglobalmessages").getAsBoolean());
            }

            if (reader.has("flying")) {
                player.setFlying(reader.get("flying").getAsBoolean());
            }

            if (reader.has("canfly")) {
                player.setCanFly(reader.get("canfly").getAsBoolean());
            }

            if (reader.has("canghostwalk")) {
                player.setCanGhostWalk(reader.get("canghostwalk").getAsBoolean());
            }

            if (reader.has("ghostwalking")) {
                player.setGhostWalking(reader.get("ghostwalking").getAsBoolean());
            }

            if (reader.has("barrowschests")) {
                player.getPointsHandler().setBarrowsChests(reader.get("barrowschests").getAsInt(), false);
            }

            if (reader.has("cluesteps")) {
                player.getPointsHandler().setClueSteps(reader.get("cluesteps").getAsInt(), false);
            }

            if (reader.has("currency-pouch")) {
                player.setCurrencyPouch(builder.fromJson(reader.get("currency-pouch"), CurrencyPouch.class));
            }

            /*
             * RIP difficulty loading. We'll still keep original values though, because fuck
             * it. if (reader.has("difficulty")) { Difficulty.set(player,
             * Difficulty.valueOf(reader.get("difficulty").getAsString()), true);
             * //player.setGameMode(GameMode.valueOf(reader.get("game-mode").getAsString()))
             * ; }
             */

            if (reader.has("hween2016")) {
                player.setHween2016All(builder.fromJson(reader.get("hween2016").getAsJsonArray(), boolean[].class));
            }

            if (reader.has("bosspets")) {
                player.setBossPetsAll(builder.fromJson(reader.get("bosspets").getAsJsonArray(), boolean[].class));
            }
            if (reader.has("donehween2016")) {
                player.setDoneHween2016(reader.get("donehween2016").getAsBoolean());
            }

            if (reader.has("christmas2016")) {
                player.setchristmas2016(reader.get("christmas2016").getAsInt());
            }

            if (reader.has("newYear2017")) {
                player.setNewYear2017(reader.get("newYear2017").getAsInt());
            }

            if (reader.has("easter2017")) {
                player.setEaster2017(reader.get("easter2017").getAsInt());
            }

            if (reader.has("hcimdunginventory")) {
                player.getDungeoneeringIronInventory()
                        .setItems(builder.fromJson(reader.get("hcimdunginventory").getAsJsonArray(), Item[].class));
            }

            if (reader.has("hcimdungequipment")) {
                player.getDungeoneeringIronEquipment()
                        .setItems(builder.fromJson(reader.get("hcimdungequipment").getAsJsonArray(), Item[].class));
            }

            if (reader.has("bonecrusheffect")) {
                player.setBonecrushEffect(reader.get("bonecrusheffect").getAsBoolean());
            }

            if (reader.has("p-tps")) {
                player.setPreviousTeleports(builder.fromJson(reader.get("p-tps").getAsJsonArray(), int[].class));
            }

            if (reader.has("afk-tree"))
                player.setAfkTree(reader.get("afk-tree").getAsInt());
            if (reader.has("afk-sapphire"))
                player.setAfkSapphire(reader.get("afk-sapphire").getAsInt());
            if (reader.has("afk-emerald"))
                player.setAfkEmerald(reader.get("afk-emerald").getAsInt());
            if (reader.has("afk-ruby"))
                player.setAfkbRuby(reader.get("afk-ruby").getAsInt());
            if (reader.has("afk-diamond"))
                player.setAfkDiamond(reader.get("afk-diamond").getAsInt());
            if (reader.has("afk-onyx"))
                player.setAfkOnyx(reader.get("afk-onyx").getAsInt());
            if (reader.has("afk-zenyte"))
                player.setAfkZenyte(reader.get("afk-zenyte").getAsInt());

            if (reader.has("gwd-killcount")) {
                player.getMinigameAttributes().getGodwarsDungeonAttributes()
                        .setKillcount(builder.fromJson(reader.get("gwd-killcount"), int[].class));
            }

            if (reader.has("progression-zones")) {
                player.setProgressionZones(builder.fromJson(reader.get("progression-zones"), int[].class));
            }
            if (reader.has("zones-complete")) {
                player.setZonesComplete(builder.fromJson(reader.get("zones-complete"), boolean[].class));
            }

            if (reader.has("gamble-banned")) {
                player.setGambleBanned(reader.get("gamble-banned").getAsBoolean());
            }

            if (reader.has("lucifers-unlocked")) {
                player.setUnlockedLucifers(reader.get("lucifers-unlocked").getAsBoolean());
            }
            if (reader.has("dark-supremes-unlocked")) {
                player.setUnlockedDarkSupreme(reader.get("dark-supremes-unlocked").getAsBoolean());
            }

            if (reader.has("chest-looted")) {
                player.setChestLooted(reader.get("chest-looted").getAsBoolean());
            }
            if (reader.has("fish-collected")) {
                player.setFishCollected(reader.get("fish-collected").getAsBoolean());
            }
            if (reader.has("treasure-map-1-collected")) {
                player.setTreasureMap1Collected(reader.get("treasure-map-1-collected").getAsBoolean());
            }

            if (reader.has("treasure-map-2-collected")) {
                player.setTreasureMap2Collected(reader.get("treasure-map-2-collected").getAsBoolean());
            }

            if (reader.has("treasure-map-3-collected")) {
                player.setTreasureMap3Collected(reader.get("treasure-map-3-collected").getAsBoolean());
            }
            if (reader.has("reward-collected")) {
                player.setRewardCollected(reader.get("reward-collected").getAsBoolean());
            }
            if (reader.has("group-ironman-id")) {
                IronmanGroup group = GroupManager.getGroup((reader.get("group-ironman-id").getAsInt()));
                System.out.println("ID : " + reader.get("group-ironman-id").getAsInt());
                if (group != null) {
                    System.out.println("ID1 : " + reader.get("group-ironman-id").getAsInt());
                    System.out.println("GROUP: " + group);
                    System.out.println("GROUP name: " + group.getName());
                    System.out.println("agroup.getMembers(): " +group.getMembers().size());
                    System.out.println("player.getUsername(): " +player.getUsername());
                    if (group.getMembers().contains(player.getUsername())) {
                        System.out.println("add name: " + player.getUsername());
                        player.setIronmanGroup(group);
                    }
                }
            }

            if (reader.has("group-ironman-locked")) {
                player.setGroupIronmanLocked((reader.get("group-ironman-locked").getAsBoolean()));
            }

            if (reader.has("lastInstanceNpc")) {
                player.lastInstanceNpc = reader.get("lastInstanceNpc").getAsInt();
            }

            if (reader.has("daily-task")) {
                HashMap<DailyTask, TaskChallenge> dailyTasks = builder.fromJson(reader.get("daily-task"),
                        new TypeToken<HashMap<DailyTask, TaskChallenge>>() {
                        }.getType());
                player.setDailies(dailyTasks);
            }

            if (reader.has("daily-skips")) {
                player.dailySkips = reader.get("daily-skips").getAsInt();
            }

            if (reader.has("dailies-done")) {
                player.dailiesCompleted = reader.get("dailies-done").getAsInt();
            }

            if (reader.has("daily-task-info")) {
                player.taskInfo = reader.get("daily-task-info").getAsString();
            }

            if (reader.has("level-notifications")) {
                player.levelNotifications = reader.get("level-notifications").getAsBoolean();
            }

            if (reader.has("dailies-received-times")) {
                player.setTaskReceivedTimes(builder.fromJson(reader.get("dailies-received-times").getAsJsonArray(), long[].class));
            }
            /*if (reader.has("favorite-teleports")) {
                TeleportInterface.Teleport[] data = builder.fromJson(reader.get("favorite-teleports").getAsJsonArray(), TeleportInterface.Teleport[].class);
                for (TeleportInterface.Teleport l : data) {
                    player.getFavoriteTeleports().add(l);
                }
            }*/

            if (reader.has("obtained-pets")) {
                BossPets.BossPet[] data = builder.fromJson(reader.get("obtained-pets").getAsJsonArray(), BossPets.BossPet[].class);
                for (BossPets.BossPet l : data) {
                    player.getObtainedPets().add(l);
                }
            }

            if (reader.has("achievements")) {
                player.getAchievementTracker().load(reader.get("achievements"));
            }



            /*
             * File rooms = new File("./data/saves/housing/rooms/" + player.getUsername() +
             * ".ser"); if (rooms.exists()) { FileInputStream fileIn = new
             * FileInputStream(rooms); ObjectInputStream in = new ObjectInputStream(fileIn);
             * player.setHouseRooms((Room[][][]) in.readObject()); in.close();
             * fileIn.close(); }
             *
             * File portals = new File("./data/saves/housing/portals/" +
             * player.getUsername() + ".ser"); if (portals.exists()) { FileInputStream
             * fileIn = new FileInputStream(portals); ObjectInputStream in = new
             * ObjectInputStream(fileIn); player.setHousePortals((ArrayList<Portal>)
             * in.readObject()); in.close(); fileIn.close(); }
             *
             * File furniture = new File("./data/saves/housing/furniture/" +
             * player.getUsername() + ".ser"); if (furniture.exists()) { FileInputStream
             * fileIn = new FileInputStream(furniture); ObjectInputStream in = new
             * ObjectInputStream(fileIn);
             * player.setHouseFurniture((ArrayList<HouseFurniture>) in.readObject());
             * in.close(); fileIn.close(); }
             */
        } catch (Exception e) {
            e.printStackTrace();
            return LoginResponses.LOGIN_SUCCESSFUL;
        }
        return LoginResponses.LOGIN_SUCCESSFUL;
    }
}