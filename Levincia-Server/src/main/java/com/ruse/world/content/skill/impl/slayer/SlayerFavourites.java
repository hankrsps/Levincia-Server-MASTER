package com.ruse.world.content.skill.impl.slayer;

import com.ruse.model.definitions.NpcDefinition;
import com.ruse.world.entity.impl.player.Player;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class SlayerFavourites {

    private final Player p;

    @Getter
    @Setter
    private int[] favouriteNpcIds = new int[4];

    @Getter
    @Setter
    private int[] blockedNpcIds = new int[4];

    private TaskType selectedType = TaskType.EASY;
    private List<SlayerTasks> tasksForCurrentType = new ArrayList<>();

    public void open() {
        selectCategory(0);
        displayFavourites();
        displayBlocked();
        p.getPA().sendInterface(142500);
    }

    private void selectCategory(int index) {
        selectedType = TaskType.values()[index];
        tasksForCurrentType = SlayerTasks.tasksForType(selectedType);
        displayTaskList();
    }


    private void displayTaskList() {
        int index = 0;
        while (index < 20) {
            String text = index >= tasksForCurrentType.size() ? "" : NpcDefinition.forId(tasksForCurrentType.get(index).getNpcId()).getName();
            p.getPA().sendString(142555+(index*3), text);
            index++;
        }
    }

    private void displayFavourites() {
        for (int i = 0; i < 4; i++)
            p.getPA().sendString(142515+(i*2), (favouriteNpcIds[i] > 0 ? NpcDefinition.forId(favouriteNpcIds[i]).getName() : "---"));
    }

    private void displayBlocked() {
        for (int i = 0; i < 4; i++)
            p.getPA().sendString(142523+(i*2), (blockedNpcIds[i] > 0 ? NpcDefinition.forId(blockedNpcIds[i]).getName() : "---"));
    }

    private void addFavourite(int npcId) {
        if (isFavourite(npcId)) {
            p.sendMessage("You have already added this task to your favourites!");
            return;
        }
        if (isBlocked(npcId)) {
            p.sendMessage("You can not favourite a task that is in your blocked list!");
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (favouriteNpcIds[i] <= 0) {
                favouriteNpcIds[i] = npcId;
                p.sendMessage("You successfully add this task to your favourites");
                return;
            }
        }
        p.sendMessage("You can only have 4 favourites at one time!");
    }

    private void addBlocked(int npcId) {
        if (isBlocked(npcId)) {
            p.sendMessage("You have already added this task to your blocked list!");
            return;
        }
        if (isFavourite(npcId)) {
            p.sendMessage("You can not block a task that is in your favourites list!");
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (blockedNpcIds[i] <= 0) {
                blockedNpcIds[i] = npcId;
                p.sendMessage("You successfully block this task.");
                return;
            }
        }
        p.sendMessage("You can only have 4 blocked tasks at one time!");
    }

    public boolean isFavourite(int npcId) {
        for (int i : favouriteNpcIds)
            if (i == npcId)
                return true;
        return false;
    }

    public boolean isBlocked(int npcId) {
        for (int i : blockedNpcIds)
            if (i == npcId)
                return true;
        return false;
    }

    public boolean handleButton(int id) {

        if (id >=142556 && id <= 142606) {
            boolean favourite = (id - 142556) % 3 == 0;
            int index;
            if (favourite) {
                index = (id-142556)/3;
            } else {
                index = (id-142557)/3;
            }
            if (index >= tasksForCurrentType.size()) {
                p.sendMessage("Invalid selection!");
                return true;
            }
            if (favourite) {
                addFavourite(tasksForCurrentType.get(index).getNpcId());
                displayFavourites();
            } else {
                addBlocked(tasksForCurrentType.get(index).getNpcId());
                displayBlocked();
            }
        }

        switch (id) {
            case 142506:
                selectCategory(0);
                 return true;
            case 142507:
                selectCategory(1);
                 return true;
            case 142508:
                selectCategory(2);
                 return true;
            case 142509:
                selectCategory(3);
                 return true;

            case 142516:
                favouriteNpcIds[0] = -1;
                displayFavourites();
                 return true;
            case 142518:
                favouriteNpcIds[1] = -1;
                displayFavourites();
                 return true;
            case 142520:
                favouriteNpcIds[2] = -1;
                displayFavourites();
                 return true;
            case 142522:
                favouriteNpcIds[3] = -1;
                displayFavourites();
                 return true;

            case 142524:
                blockedNpcIds[0] = -1;
                displayBlocked();
                 return true;
            case 142526:
                blockedNpcIds[1] = -1;
                displayBlocked();
                 return true;
            case 142528:
                blockedNpcIds[2] = -1;
                displayBlocked();
                 return true;
            case 142530:
                blockedNpcIds[3] = -1;
                displayBlocked();
                 return true;
        }

        return false;
    }
}
