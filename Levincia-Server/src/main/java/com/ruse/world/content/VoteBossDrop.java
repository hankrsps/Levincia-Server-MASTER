package com.ruse.world.content;

import com.ruse.GameSettings;
import com.ruse.model.definitions.NPCDrops;
import com.ruse.webhooks.discord.DiscordMessager;
import com.ruse.world.World;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.content.combat.CombatBuilder.CombatDamageCache;
import com.ruse.world.content.combat.CombatFactory;
import com.ruse.world.content.startertasks.StarterTasks;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import java.util.*;
import java.util.Map.Entry;

public class VoteBossDrop {

	public static NPC currentSpawn;
public static int spawned = 0;

	public static void handleSpawn() {
		if (spawned < 1) {
			for (Player players : World.getPlayers()) {
				if (players == null) {
					continue;
				}
				players.getPacketSender().sendBroadCastMessage("Vote boss has spawned at ::Vboss", 100);
			}
			World.sendBroadcastMessage("Vote boss has spawned at ::Vboss");
			World.sendMessage(
					"<img=28><shad=f9f6f6>Vote boss has spawned at ::Vboss <shad=-1>");
			if (GameSettings.LOCALHOST == false)
				DiscordMessager.sendVoteBossLog("");
			spawned++;
		}
	}
	
	public static void handleDrop(NPC npc) {
		if (npc.getCombatBuilder().getDamageMap().size() == 0) {
			return;
		}
		Map<Player, Integer> killers = new HashMap<>();



		for (Entry<Player, CombatDamageCache> entry : npc.getCombatBuilder().getDamageMap().entrySet()) {
			if (entry == null) {
				continue;
			}

			long timeout = entry.getValue().getStopwatch().elapsed();
			if (timeout > CombatFactory.DAMAGE_CACHE_TIMEOUT) {
				continue;
			}

			Player player = entry.getKey();
			if (player.getConstitution() <= 0 || !player.isRegistered()) {
				continue;
			}

			killers.put(player, entry.getValue().getDamage());
		}

		npc.getCombatBuilder().getDamageMap().clear();

		List<Entry<Player, Integer>> result = sortEntries(killers);
		for (Iterator<Entry<Player, Integer>> iterator = result.iterator(); iterator.hasNext(); ) {

			Entry<Player, Integer> entry = iterator.next();
			Player killer = entry.getKey();
			KillsTracker.submitById(killer, npc.getId(), true, npc.getDefinition().boss);
			KillsTracker.submitById(killer, npc.getId(), false, npc.getDefinition().boss);
			StarterTasks.doProgress(killer, StarterTasks.StarterTask.KILL_GLOBALS);
			killer.getAchievementTracker().progress(AchievementData.KILL_5K_GLOBALS, 1);
			NPCDrops.handleDrops(killer, npc);
			iterator.remove();
		}

		currentSpawn = null;
		spawned = 0;
	}


	/**
	 * 
	 * @param map
	 * @return
	 */
	static <K, V extends Comparable<? super V>> List<Entry<K, V>> sortEntries(Map<K, V> map) {

		List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K, V>>(map.entrySet());

		Collections.sort(sortedEntries, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

		return sortedEntries;

	}
}
