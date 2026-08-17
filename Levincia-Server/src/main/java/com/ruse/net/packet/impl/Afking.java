package com.ruse.net.packet.impl;


import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.*;
import com.ruse.model.definitions.WeaponAnimations;
import com.ruse.world.content.CustomObjects;
import com.ruse.world.entity.impl.player.Player;

public class Afking {
    static int chairanimation = 11671;

    public static void afk(final Player player)
    {

        if (!player.idleEventUsed && !player.getCombatBuilder().isBeingAttacked())
        {
            player.idleEventUsed = true;

            player.setPositionToFace(new Position(player.getPosition().getX(), player.getPosition().getY() - 1));

            player.getCharacterAnimations().setStandingAnimation(chairanimation);

            if (player.getRights() == PlayerRights.OWNER) {
                player.throneId = 13671;
            }
            if (player.getUsername().equalsIgnoreCase("avalon")) {
                player.throneId = 1105;
            }

            if (player.getRights() == PlayerRights.SUPPORT || player.getRights() == PlayerRights.MODERATOR || player.getRights() == PlayerRights.ADMINISTRATOR) {
                player.throneId = 1098;
            }
            final GameObject object3 = new GameObject(player.throneId, new Position(player.getPosition().getX(),player.getPosition().getZ() == 1 ? player.getPosition().getY()-1 :
                    player.getPosition().getZ() == 2 ? player.getPosition().getY()-2:
                    player.getPosition().getZ() == 3 ? player.getPosition().getY()-3:
                    player.getPosition().getZ() == 4 ? player.getPosition().getY()-4:
                    player.getPosition().getZ() == 5 ? player.getPosition().getY()-5:
                    player.getPosition().getZ() == 6 ? player.getPosition().getY()-6:
                    player.getPosition().getZ() == 7 ? player.getPosition().getY()-7:
                    player.getPosition().getZ() == 8 ? player.getPosition().getY()-8:
                    player.getPosition().getZ() == 9 ? player.getPosition().getY()-9:
                    player.getPosition().getZ() == 10 ? player.getPosition().getY()-10:
                    player.getPosition().getZ() == 11 ? player.getPosition().getY()-11:
                    player.getPosition().getZ() == 12 ? player.getPosition().getY()-12:
                    player.getPosition().getY(), player.getPosition().getZ()),10,2);

            player.toRemove.add(object3);


            CustomObjects.spawnGlobalObject(object3);


            TaskManager.submit(new Task(2, player, true) {
                @Override
                protected void execute() {
                    if (player.idleEventUsed) {

                        player.performGraphic(new Graphic(277));

                        player.updateAppearance();

                    } else {
                        stop();
                    }
                }
                @Override
                public void stop() {
                    resetAfk(player,false);


                }
            });


        }
    }

    public static void resetAfk(Player player, boolean ignore)
    {
        if (player.idleEventUsed)
        {
            if (!ignore)
            {
                player.performAnimation(new Animation(65535));

                WeaponAnimations.update(player);
            }

            player.updateAppearance();
            player.idleEventUsed = false;

            for (int index = 0; index < player.toRemove.size(); index++)
            {

                if (player.toRemove.get(index).getId() == player.throneId)
                {

                    CustomObjects.deleteGlobalObject(player.toRemove.get(index));

                    break;
                }
            }
            player.toRemove.clear();
        }

    }


}
