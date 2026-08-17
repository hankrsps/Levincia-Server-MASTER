package com.ruse.world.content;

import com.ruse.model.definitions.NPCDrops;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.content.combat.CombatBuilder;
import com.ruse.world.content.combat.CombatFactory;
import com.ruse.world.content.dailytasks_new.DailyTask;
import com.ruse.world.content.startertasks.StarterTasks;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import java.util.*;
import java.util.Map.Entry;

public class GuardianBossDrop {

	public static void handleDropReward(NPC npc) {
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
		for (Iterator<Map.Entry<Player, Integer>> iterator = result.iterator(); iterator.hasNext(); ) {
			Map.Entry<Player, Integer> entry = iterator.next();
			Player killer = entry.getKey();

			DailyTask.GLOBAL_BOSSES.tryProgress(killer);
			KillsTracker.submitById(killer, npc.getId(), true, npc.getDefinition().boss);
			KillsTracker.submitById(killer, npc.getId(), false, npc.getDefinition().boss);
			StarterTasks.doProgress(killer, StarterTasks.StarterTask.KILL_GLOBALS);
			killer.getAchievementTracker().progress(AchievementData.KILL_5K_GLOBALS, 1);
			killer.setGuardianBonus(0);
			NPCDrops.handleDrops(killer, npc);
			iterator.remove();
		}
	}

	/**
	 * 
	 * @param npc
	 * @param player
	 * @param damage
	 */

	/**
	 * 
	 * @param map
	 * @return
	 */
	static <K, V extends Comparable<? super V>> List<Entry<K, V>> sortEntries(Map<K, V> map) {

		List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K, V>>(map.entrySet());

		Collections.sort(sortedEntries, new Comparator<Entry<K, V>>() {

			@Override
			public int compare(Entry<K, V> e1, Entry<K, V> e2) {
				return e2.getValue().compareTo(e1.getValue());
			}

		});

		return sortedEntries;

	}

	
}
