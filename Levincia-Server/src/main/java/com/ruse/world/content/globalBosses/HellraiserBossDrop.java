package com.ruse.world.content.globalBosses;

import com.ruse.model.definitions.NPCDrops;
import com.ruse.world.content.KillsTracker;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.content.combat.CombatBuilder;
import com.ruse.world.content.combat.CombatFactory;
import com.ruse.world.content.dailytasks_new.DailyTask;
import com.ruse.world.content.startertasks.StarterTasks;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import java.util.*;
import java.util.Map.Entry;

public class HellraiserBossDrop {

	public static void handleDrop(NPC npc) {
		if (npc.getCombatBuilder().getDamageMap().size() == 0) {
			return;
		}
		Map<Player, Integer> killers = new HashMap<>();

		for (Map.Entry<Player, CombatBuilder.CombatDamageCache> entry : npc.getCombatBuilder().getDamageMap().entrySet()) {
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

		List<Map.Entry<Player, Integer>> result = sortEntries(killers);
		for (Iterator<Entry<Player, Integer>> iterator = result.iterator(); iterator.hasNext(); ) {
			Map.Entry<Player, Integer> entry = iterator.next();
			Player killer = entry.getKey();

			DailyTask.GLOBAL_BOSSES.tryProgress(killer);
			StarterTasks.doProgress(killer, StarterTasks.StarterTask.KILL_GLOBALS);
			KillsTracker.submitById(killer, npc.getId(), true, npc.getDefinition().boss);
			KillsTracker.submitById(killer, npc.getId(), false, npc.getDefinition().boss);
			killer.getAchievementTracker().progress(AchievementData.KILL_5K_GLOBALS, 1);
			NPCDrops.handleDrops(killer, npc);
			iterator.remove();
		}
	}
	static <K, V extends Comparable<? super V>> List<Map.Entry<K, V>> sortEntries(Map<K, V> map) {

		List<Map.Entry<K, V>> sortedEntries = new ArrayList<Map.Entry<K, V>>(map.entrySet());

		Collections.sort(sortedEntries, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

		return sortedEntries;

	}

	
}
