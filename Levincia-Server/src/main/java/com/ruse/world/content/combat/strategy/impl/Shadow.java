package com.ruse.world.content.combat.strategy.impl;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Graphic;
import com.ruse.model.Locations;
import com.ruse.model.Position;
import com.ruse.util.Misc;
import com.ruse.world.content.combat.CombatContainer;
import com.ruse.world.content.combat.CombatType;
import com.ruse.world.content.combat.strategy.CombatStrategy;
import com.ruse.world.entity.impl.Character;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

public class Shadow implements CombatStrategy {

	@Override
	public boolean canAttack(Character entity, Character victim) {
		return true;
	}

	@Override
	public CombatContainer attack(Character entity, Character victim) {
		return null;
	}

	@Override
	public boolean customContainerAttack(Character entity, Character victim) {

		NPC earthquake = (NPC) entity;
		Player player = (Player) victim;
		Position pos = victim.getPosition().copy();
		earthquake.setChargingAttack(true).getCombatBuilder().setAttackTimer(6);
		earthquake.setAggressive(true);
		TaskManager.submit(new Task(1, earthquake, true) {
			@Override
			public void execute() {
				if (victim.getPosition().sameAs(pos)) {
					if (((Player) victim).getInventory().contains(17801)) {
						player.getInventory().delete(17801, 1);
						player.getInventory().add(2959, 1);
						victim.performGraphic(new Graphic(536, 0));
						earthquake.setChargingAttack(false);
						stop();
					} else if (Locations.goodDistance(earthquake.getPosition().copy(), victim.getPosition().copy(), 1)
							&& Misc.getRandom(5) <= 3) {
						earthquake.getCombatBuilder().setContainer(new CombatContainer(earthquake, victim, 1, 0, CombatType.MELEE, true));

						earthquake.getCombatBuilder().setContainer(new CombatContainer(earthquake, victim, 1, 0, CombatType.MELEE, true));

						earthquake.getCombatBuilder().setContainer(new CombatContainer(earthquake, victim, 1, 0, CombatType.MELEE, true));

					}
				}
				earthquake.setAggressive(true);
				earthquake.setChargingAttack(false);
				stop();
			}
		});
		return true;
	}


	@Override
	public int attackDelay(Character entity) {
		return entity.getAttackSpeed();
	}

	@Override
	public int attackDistance(Character entity) {
		return 4;
	}

	@Override
	public CombatType getCombatType() {
		return CombatType.MIXED;
	}
}
