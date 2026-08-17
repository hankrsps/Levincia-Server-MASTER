package com.ruse.world.content.combat.strategy.impl;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.*;
import com.ruse.util.Misc;
import com.ruse.world.content.combat.CombatContainer;
import com.ruse.world.content.combat.CombatType;
import com.ruse.world.content.combat.strategy.CombatStrategy;
import com.ruse.world.entity.impl.Character;
import com.ruse.world.entity.impl.npc.NPC;

public class DragonKing implements CombatStrategy {

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
		NPC dragonKing = (NPC) entity;
		if (dragonKing.isChargingAttack() || victim.getConstitution() <= 0) {
			return true;
		}

		if (Locations.goodDistance(dragonKing.getPosition().copy(), victim.getPosition().copy(), 3)
				&& Misc.getRandom(5) <= 3) {
			dragonKing.performAnimation(new Animation(dragonKing.getDefinition().getAttackAnimation()));

			dragonKing.performAnimation(new Animation(5026));
			dragonKing.getCombatBuilder().setContainer(new CombatContainer(dragonKing, victim, 1, 1, CombatType.MELEE, true));
			if (Misc.getRandom(10) <= 2) {
				if (victim.isPlayer()) {
					int moveX = victim.getPosition().getX() - dragonKing.getPosition().getX();
					int moveY = victim.getPosition().getY() - dragonKing.getPosition().getY();

					if (moveX > 0)
						moveX = 3;
					else if (moveX < 0)
						moveX = -3;
					if (moveY > 0)
						moveY = 3;
					else if (moveY < 0)
						moveY = -3;
					if (victim.getMovementQueue().canWalk(moveX, moveY)) {
						victim.setEntityInteraction(dragonKing);
						victim.getMovementQueue().reset();
						victim.performGraphic(new Graphic(1393, GraphicHeight.HIGH));
						TaskManager.submit(new Task(1, false) {
							@Override
							public void execute() {
								stop();
							}
						});
					}
				}

			}
		} else {
			dragonKing.setChargingAttack(true);
			dragonKing.performAnimation(new Animation(5026));
			dragonKing.getCombatBuilder().setContainer(new CombatContainer(dragonKing, victim, 1, 3, CombatType.MAGIC, true));
			TaskManager.submit(new Task(1, dragonKing, false) {
				int tick = 0;

				@Override
				public void execute() {
					if (tick == 0) {
						new Projectile(dragonKing, victim, 346, 44, 3, 41, 31, 0).sendProjectile();
					} else if (tick == 1) {
						dragonKing.setChargingAttack(false);
						stop();
					}
					tick++;
				}
			});
		}
		return true;
	}

	@Override
	public int attackDelay(Character entity) {
		return entity.getAttackSpeed();
	}

	@Override
	public int attackDistance(Character entity) {
		return 3;
	}

	@Override
	public CombatType getCombatType() {
		return CombatType.MIXED;
	}
}
