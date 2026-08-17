package com.ruse.world.content.afk;

import com.ruse.model.definitions.NPCDrops;
import com.ruse.world.content.KillsTracker;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.content.combat.CombatBuilder.CombatDamageCache;
import com.ruse.world.content.combat.CombatFactory;
import com.ruse.world.content.dailytasks_new.DailyTask;
import com.ruse.world.content.startertasks.StarterTasks;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import java.util.*;
import java.util.Map.Entry;

public class AFKBossDrops {

	public static void handleDrop(NPC npc) {
		Map<Player, CombatDamageCache> damageMap = npc.getCombatBuilder().getDamageMap();
		if (damageMap.isEmpty()) {
			return;
		}

		// Get the players who dealt damage to the NPC, and the amount of damage they dealt
		Map<Player, Integer> killers = new HashMap<>();
		for (Entry<Player, CombatDamageCache> entry : damageMap.entrySet()) {
			Player player = entry.getKey();
			CombatDamageCache cache = entry.getValue();
			if (player == null || cache == null || player.getConstitution() <= 0 || !player.isRegistered() || cache.getStopwatch().elapsed() > CombatFactory.DAMAGE_CACHE_TIMEOUT) {
				continue;
			}
			killers.put(player, cache.getDamage());
		}

		// Clear the damage map
		damageMap.clear();

		// Sort the players by the amount of damage they dealt
		List<Entry<Player, Integer>> result = sortEntries(killers);

		// Handle the drops for each player
		for (Iterator<Entry<Player, Integer>> iterator = result.iterator(); iterator.hasNext(); ) {
			Entry<Player, Integer> entry = iterator.next();
			Player killer = entry.getKey();

			// Try to progress the daily task for killing global bosses
			DailyTask.GLOBAL_BOSSES.tryProgress(killer);

			// Submit the kill to the player's kill tracker
			KillsTracker.submitById(killer, npc.getId(), true, npc.getDefinition().boss);
			KillsTracker.submitById(killer, npc.getId(), false, npc.getDefinition().boss);

			// Update the player's starter tasks
			StarterTasks.doProgress(killer, StarterTasks.StarterTask.KILL_GLOBALS);

			// Update the player's achievements
			killer.getAchievementTracker().progress(AchievementData.KILL_5K_GLOBALS, 1);

			// Handle the drops for the player
			NPCDrops.handleDrops(killer, npc);
			iterator.remove();
		}
	}

	static <K, V extends Comparable<? super V>> List<Entry<K, V>> sortEntries(Map<K, V> map) {
		List<Entry<K, V>> sortedEntries = new ArrayList<>(map.entrySet());

		// Sort the entries in descending order by the value
		sortedEntries.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));

		return sortedEntries;
	}
}
