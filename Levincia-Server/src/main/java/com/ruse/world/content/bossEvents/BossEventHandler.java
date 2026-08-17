package com.ruse.world.content.bossEvents;

import com.ruse.model.Item;
import com.ruse.model.Position;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.transportation.TeleportHandler;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Levincia#9598 (AlwaysDreaming.AI@gmail.com)
 * Offering Development services with tutorials pm me
 *
 */

public class BossEventHandler {
	public static ArrayList<String> array = new ArrayList<String>();
	// Flag to indicate whether an event is currently running
	static boolean isEventRunning = false;

	// List of players who have completed the current boss task
	private static List<Player> completedPlayers = new ArrayList<> ();



	/**
	 * Assigns a boss task to all online players.
	 *
	 * @param taskNumber the number of the task to assign
	 */
	public static void assignTasks(int taskNumber) {
		if (isEventRunning) {
			return;
		}

		// Clear the list of completed players
		completedPlayers.clear ();

		BossEventData data = BossEventData.byId.get (taskNumber);
		for (Player player : World.getPlayers ()) {
			if (player != null) {
				if (taskNumber == data.getTaskNumber ()) {
					player.setBossevent (data);
					player.setCurrentBossTask (data.getNpcid ());
					player.setCurrentBossTaskAmount (data.getEndamount ());
					player.sendMessage ("@blu@<img=832>[Boss Event] You have been assigned to kill: @red@" + player.getBossevent ().getName ()
							+ " Amount: " + player.getBossevent ().getEndamount ());
					player.setHasPlayerCompletedBossTask (false);
					isEventRunning = true;
				}
			}
		}

		World.sendMessage ("@red@Do ::bossevent to teleport to the task!");
	}

	/**
	 * Executes the boss event by assigning a random task to all online players.
	 */
	public void execute() {
		assignTasks (Misc.exclusiveRandom (0, 9));
	}

	/**
	 * Forces a reset of the boss event, clearing the list of completed players and setting the
	 * event running flag to false.
	 */
	public static void forceReset() {
		for (Player player : World.getPlayers ()) {
			if (player != null) {
				resetTasks (player);
			}
		}

		World.sendMessage ("<img=13><col=0000ff>The Boss Event has finished!");
		completedPlayers.clear ();
		isEventRunning = false;
	}


	public static void resetTasks(Player player) {
		if (player.bossevent instanceof BossEventData && player.currentBossTask != -1 && player.currentBossTaskAmount != -1) {
			player.setCurrentBossTask(-1);
			player.setCurrentBossTaskAmount(-1);
			player.setBossevent(null);
			player.setHasPlayerCompletedBossTask(false);
			isEventRunning = false;
		}
	}
	/**
	 * Teleports the specified player to their assigned boss task.
	 *
	 * @param player the player to teleport
	 */
	public static void teleport(Player player) {
		if (player.getBossevent () != null) {
			TeleportHandler.teleportPlayer (
					player, new Position (player.getBossevent ().getPosition ().getX (),
							player.getBossevent ().getPosition ().getY (), player.getBossevent ().getPosition ().getZ ()),
					player.getSpellbook ().getTeleportType ());
		} else {
			player.getPacketSender ().sendMessage ("You do not have a task currently!");
		}
	}

	public void death(Player player, NPC npc, String NpcName) {
		if (!isEventRunning) {
			return;
		}

		if (player.bossevent == null || player.currentBossTask == -1 || player.currentBossTaskAmount == -1) {
			return;
		}

		if (player.isHasPlayerCompletedBossTask()) {
			return;
		}

		if (npc.getId() != player.getCurrentBossTask()) {
			return;
		}

		player.setCurrentBossTaskAmount(player.getCurrentBossTaskAmount() - 1);
		player.getPA().sendMessage("You currently need to kill " + player.getCurrentBossTaskAmount() + " " + NpcName);

		if (player.getCurrentBossTaskAmount() <= 0 && array.size() <= 3 && !player.isHasPlayerCompletedBossTask()) {
			player.setHasPlayerCompletedBossTask(true);
			player.getPA().sendMessage("You have completed the boss task, check your inventory or bank or the floor for your reward.");
			array.add(player.getUsername());
			finish(player);
		}
	}

	public static void finish(Player player) {
		switch (array.size()) {
			case 1:
				World.sendMessage("<img=13><col=0000ff> " + player.getUsername()
						+ " Has just been awarded 1st place for completing the Daily Boss Event Task");
				break;
			case 2:
				World.sendMessage("<img=13><col=0000ff> " + player.getUsername()
						+ " Has just been awarded 2nd place for completing the Daily Boss Event Task");
				break;
			case 3:
				World.sendMessage("<img=13><col=0000ff> " + player.getUsername()
						+ " Has just been awarded 3rd place for completing the Daily Boss Event Task");
				break;
		}
		player.getInventory().add(new Item (player.getBossevent().getRewards(), 1));
		player.getPA().sendMessage("You have Received a reward for completing the daily tasks!");
		if (array.size() == 3) {
			array.add(player.getUsername());
			for (Player players : World.getPlayers()) {
				if (players != null) {
					players.setCurrentBossTask(-1);
					players.setCurrentBossTaskAmount(-1);
					players.setBossevent(null);
					players.setHasPlayerCompletedBossTask(false);
				}
			}
			World.sendMessage(
					"<img=13><col=0000ff> " + " The Boss Event has just ended, congrats to the first three winners!!");
			array.removeAll(array);
			isEventRunning = false;
		}
	}

}
