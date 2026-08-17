package com.ruse.world.content.leaderboards;

import lombok.Getter;

import java.util.ArrayList;

import static com.ruse.world.content.leaderboards.LeaderboardData.LeaderboardType.MAIN;
import static com.ruse.world.content.leaderboards.LeaderboardData.LeaderboardType.MONSTER;

@Getter
public enum LeaderboardData {

    NPC_KILLCOUNT(MAIN,  "NPC Killcount"),
    TIME_PLAYED(MAIN, "Time Played"),
    DONATED(MAIN, "Donator Rank"),
    VOTES(MAIN, "Top Monthly Voters"),
    DONATIONS(MAIN, "Top Monthly Contributors"),
    COLLECTION_LOGS_COMPLETED(MAIN, "Collection Logs Completed"),
    DAILY_TASKS_COMPLETED(MAIN, "Daily Tasks Completed"),
   // TITLES_UNLOCKED(MAIN, "Titles Unlocked"),
    EASY_SLAYER_TASKS(MAIN, "Easy Slayer Tasks"),
    MED_SLAYER_TASKS(MAIN, "Medium Slayer Tasks"),
    HARD_SLAYER_TASKS(MAIN, "Hard Slayer Tasks"),
    BOSS_SLAYER_TASKS(MAIN, "Boss Slayer Tasks"),
    SANCTUM_OF_DEATH(MAIN, "Souls of Suffering Runs"),
    //TREASURE_HUNTER(MAIN, "Elder Gods Runs"),


    CAVE_DRONE(MONSTER, 6799, "Cave Drone"),
    CAVE_MUTANT(MONSTER, 6798, "Cave Mutant"),
    CAVE_SNAIL(MONSTER, 6792, "Cave Snail"),
    HANTO(MONSTER, 250, "Hanto Warrior"),
    RADITZ(MONSTER, 449, "Raditz"),
    GOKU(MONSTER, 452, "Goku"),
    BOTANIC(MONSTER, 2342, "Botanic Guardian"),
    ELEMENTAL(MONSTER, 505, "Elemental Guardian"),
    ENRAGED(MONSTER, 2949, "Enraged Guardian"),
    INUYASHA(MONSTER, 185, "Inuyasha"),
    TOLROKOTH(MONSTER, 6430, "Tolrokoth"),
    DEITY(MONSTER, 440, "Demons of Deity"),
    MUTATED(MONSTER, 9839, "Mutated Hound"),
    ELITE(MONSTER, 205, "Elite Valdis"),
    MEGA(MONSTER, 4540, "Colossal Avatar"),
    INERNAL(MONSTER, 12810, "Plutonic Demon"),
    RAMMERNAUT(MONSTER, 9767, "Crimson"),
    LUCIFER(MONSTER, 9012, "Fallen Angel"),
    MIDNIGHT_GOBLIN(MONSTER, 9837, "Midnight goblin"),
    BLOOD_DEMON(MONSTER, 9813, "Blood Demon"),
    NECROMANCER(MONSTER, 9894, "Necromancer"),

    ;

    private LeaderboardType type;
    private String name;
    private int npcId;

    LeaderboardData(LeaderboardType type, String name) {
        this.type = type;
        this.name = name;
        this.npcId = -1;
    }

    LeaderboardData(LeaderboardType type, int npcId, String name) {
        this.type = type;
        this.name = name;
        this.npcId = npcId;
    }



    public static ArrayList<LeaderboardData> getItems(LeaderboardType type) {
        ArrayList<LeaderboardData> items = new ArrayList<>();
        for (LeaderboardData s : LeaderboardData.values()) {
            if (s.type == type) {
                items.add(s);
            }
        }
        return items;
    }
    public static LeaderboardData forNpcId(int npcId) {
        for (LeaderboardData s : LeaderboardData.values()) {
            if (s.npcId == npcId) {
               return s;
            }
        }
        return null;
    }

    public enum LeaderboardType{
        MAIN, MONSTER;
    }



}
