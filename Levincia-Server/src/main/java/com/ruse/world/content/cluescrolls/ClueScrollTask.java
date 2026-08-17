package com.ruse.world.content.cluescrolls;

import com.ruse.world.content.skill.impl.slayer.SlayerTasks;
import com.ruse.world.entity.impl.player.Player;

public class ClueScrollTask {

    public ClueScrollTask(Player p) {
        this.player = p;
    }

    public SlayerTasks getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(SlayerTasks currentTask) {
        this.currentTask = currentTask;
    }

    public int getAmountToSlay() {
        return amountToSlay;
    }

    public void setAmountToSlay(int amountToSlay) {
        this.amountToSlay = amountToSlay;
    }

    SlayerTasks currentTask = SlayerTasks.NO_TASK;

    public SlayerTasks getLastTask() {
        return lastTask;
    }

    public void setLastTask(SlayerTasks lastTask) {
        this.lastTask = lastTask;
    }

    SlayerTasks lastTask = SlayerTasks.NO_TASK;
    Player player;
    int amountToSlay = 0;

}
