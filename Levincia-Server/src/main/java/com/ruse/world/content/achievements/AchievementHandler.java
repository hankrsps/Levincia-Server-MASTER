package com.ruse.world.content.achievements;

import com.ruse.world.entity.impl.player.Player;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class AchievementHandler {
    private static final int MAXIMUM_TIER_ACHIEVEMENTS = 100;
    private static final int MAXIMUM_TIERS = 4;
    private final Player player;
    /**
     * WARNING: ADD TO THE END OF THE LIST.
     */
    private final int[][] boughtItems = {{7409, -1}, {13659, -1}, {20120, -1}, {88, -1}, {13281, -1}, {2379, -1}, {20235, -1}, {13845, -1}, {13846, -1}, {13847, -1},
            {13848, -1}, {13849, -1}, {13850, -1}, {13851, -1}, {13852, -1}, {13853, -1}, {13854, -1}, {13855, -1}, {13856, -1}, {13857, -1}, {20220, -1},
            {20221, -1}, {20222, -1},};
    public int currentInterface = 0;
    public boolean clickedAchievement = false;
    private int toView;
    private int[][] amountRemaining = new int[MAXIMUM_TIERS][MAXIMUM_TIER_ACHIEVEMENTS];
    private boolean[][] completed = new boolean[MAXIMUM_TIERS][MAXIMUM_TIER_ACHIEVEMENTS];
    private int points;
//	private static final long numDaily = Achievement.ACHIEVEMENTS.stream().filter(n -> n.getDifficulty().ordinal() == 3).count();
    private long dailyAchievementsDate;
    private int previousAchievementIndex = 0;
    private int selectedAchievementIndex = 0;


    public AchievementHandler(Player player) {
        this.player = player;
    }

    /**
     * Gets tomorrow's date
     */
    public static String getTimeLeft() {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("EST"));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DATE, 1);

        final long millis = cal.getTimeInMillis() - System.currentTimeMillis();

        return String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis)
                        - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis)
                        - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
    }

    public void refreshInterface(int tier) {
        String tab = "";
        switch (tier) {
            case 0://Easy
                tab = "Easy";
                selectedAchievementIndex = 0;
                break;
        }
        previousAchievementIndex = selectedAchievementIndex;

        //Send the name of the tab
        player.getPA().sendFrame126(tab, 36026);

        //Display the time in the proper tab
        if (tab.equalsIgnoreCase("Daily")) {
            player.getPA().sendString(36503, "Time Left: " + getTimeLeft());
        } else {
            player.getPA().sendString(36503, "");
        }

        //Counter, to allow us to sift through all achievements and properly send their frame
        int count = 36037;

        //Views the first achievement of that tier
        viewAchievement(0, tier);
        //Clearing the left over achievement interface slots
        for (int i = count; i < 36137; i++) {
            player.getPacketSender().sendString(count, "");
            count++;
        }
    }

    /**
     * Responsive clicking for viewing an achievement
     *
     * @param achievement
     */
    private void viewAchievement(int achievement, int tier) {
        int toView;

        if (achievement < 0) {
            toView = 36037 + (achievement + 29499);
        } else {
            toView = 36037;
        }

        previousAchievementIndex = selectedAchievementIndex;

        this.toView = toView;
        //Counter, to allow us to sift through all achievements and properly send their frame
        int count = 36037;

    }



    public boolean isComplete(int tier, int index) {
        return completed[tier][index];
    }

    public void setComplete(int tier, int index, boolean state) {
        this.completed[tier][index] = state;
    }

    public boolean[][] getCompleted() {
        return completed;
    }

    public void setCompleted(boolean[][] completed) {
        this.completed = completed;
    }

    public int getAmountRemaining(int tier, int index) {
        return amountRemaining[tier][index];
    }

    public int[][] getAmountRemaining() {
        return amountRemaining;
    }

    public void setAmountRemaining(int[][] amountRemaining) {
        this.amountRemaining = amountRemaining;
    }

    public void setAmountRemaining(int tier, int index, int amountRemaining) {
        this.amountRemaining[tier][index] = amountRemaining;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isAchievementItem(int itemId) {
        for (int[] boughtItem : boughtItems)
            if (boughtItem[0] == itemId)
                return true;
        return false;
    }

    public boolean hasBoughtItem(int itemId) {
        for (int[] boughtItem : boughtItems)
            if (boughtItem[0] == itemId)
                if (boughtItem[1] != -1)
                    return true;
        return false;
    }

    public void setBoughtItem(int itemId) {
        for (int i = 0; i < boughtItems.length; i++)
            if (boughtItems[i][0] == itemId)
                boughtItems[i][1] = 1;
    }

    public int[][] getBoughtItems() {
        return this.boughtItems;
    }

    public void setBoughtItem(int index, int value) {
        if (index > this.boughtItems.length - 1)
            return;
        this.boughtItems[index][1] = value;
    }

    /**
     * Gets today's date
     *
     * @return
     */
    public int getTodayDate() {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_YEAR);
        return day;
    }

    public long getDailyAchievementsDate() {
        return dailyAchievementsDate;
    }

    public void setDailyTaskDate(long dailyTaskDate) {
        this.dailyAchievementsDate = dailyTaskDate;
    }

    public boolean handleButtonClick(int buttonId) {
        /**Achievement Buttons**/
        if (buttonId >= -29499 && buttonId <= -29400) {
            return true;
        }

        switch (buttonId) {
            case -29032:
                complete(buttonId);
                return true;
            case -26282:
            case -19530:
                return true;
            case -19529:
                return true;
            case -19528:
                return true;
            case -19527:
                player.getDailyTaskManager().open();
                return true;
        }
        return false;
    }

    private void complete(int achievement) {
        //Counter, to allow us to sift through all achievements and properly send their frame
        int count = 36037;
        //Looping through all achievements of the tier currently being viewed

    }

}
