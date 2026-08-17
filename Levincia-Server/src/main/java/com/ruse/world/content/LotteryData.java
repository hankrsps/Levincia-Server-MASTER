package com.ruse.world.content;

import com.ruse.util.Misc;
import com.ruse.world.World;

import java.io.Serializable;
import java.util.*;



public class LotteryData implements Serializable {

    private static final long serialVersionUID = -3335621107999346653L;

    /**
     * Compares the value of an entry
     */
    private static final Comparator<Map.Entry<String, Integer>> HIGHEST_VALUE = Map.Entry.comparingByValue();

    /**
     * Contains all of the entries for the week
     */
    private Map<String, Integer> entries = new HashMap<>();

    private int totalpot;

    /**
     * Winners of the previous week
     */
    private Map<String, Integer> winners;

    /**
     * The date the week is over. The initial date is set.
     */
    private Date date = Misc.getFutureDate(2022, Calendar.AUGUST, 29, 20, 0, 0);

    private Date date20minsbefore = Misc.getFutureDate(2022, Calendar.AUGUST, 29, 19, 40, 0);

    /**
     * Requests that an update be made on the entries variable.
     *
     * @param player the key being updated
     * @param amount the amount being added - ADDED IMPORTANT
     */
    public void update(String player, Integer amount) {
        if (!entries.containsKey(player)) {
            entries.put(player, amount);
        } else {
            int oldValue = entries.get(player);
            entries.replace(player, oldValue, oldValue + amount);
        }
        totalpot+=amount;
        World.getServerData().setTopLottery(World.getServerData().getTopLottery());
        World.getServerData().processQueue();
    }

    /**
     * Clears all entries in the map
     */
    public void clear() {
        entries.clear();
        totalpot = 0;
    }

    /**
     * Determines the weekly winner based on their contributions
     *
     * @return the winner
     */
    public ArrayList<Map.Entry<String, Integer>> getSortedResults() {//the total number to list
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entries.entrySet());

        list.sort(HIGHEST_VALUE);
        Collections.reverse(list);
        return new ArrayList<>(list.subList(0, list.size()));
    }

    public ArrayList<Map.Entry<String, Integer>> getSortedResultsForWinners() {//the actual number of winners (1)
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entries.entrySet());

        //    list.sort(HIGHEST_VALUE);
        Collections.shuffle(list);

        return new ArrayList<>(list.subList(0, 1));
    }


    /**
     * The map containing all of the entries for the week
     *
     * @return the entries
     */
    public Map<String, Integer> getEntries() {
        return entries;
    }
    public Integer getTotalPot() {
        return totalpot;
    }

    /**
     * The winner of the previous week
     *
     * @return the winner
     */
    public Map<String, Integer> getWinners() {
        return winners;
    }

    /**
     * Sets the new winner of the week
     *
     * @param winner the winner
     */
    public void setWinners(Map<String, Integer> winners) {
        this.winners = winners;
    }

    /**
     * The date the week started
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }
    public Date get20minutedate() {
        return date20minsbefore;
    }

    /**
     * Sets the date of the week the event starts on
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate20minsbefore(Date date) {
        this.date20minsbefore = date;
    }
}



