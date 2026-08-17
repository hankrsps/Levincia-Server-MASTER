package com.ruse.world.content.combat.strategy.impl;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Animation;
import com.ruse.model.Graphic;
import com.ruse.model.Locations;
import com.ruse.model.Position;
import com.ruse.model.projectile.Projectile;
import com.ruse.util.Misc;
import com.ruse.world.content.combat.CombatContainer;
import com.ruse.world.content.combat.CombatType;
import com.ruse.world.content.combat.strategy.CombatStrategy;
import com.ruse.world.entity.impl.Character;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

public class NightmareBoss implements CombatStrategy {

	/**
	 * Attacking melee anims
	 */
	private static final Animation anim = new Animation(407);
	private static final Animation anim1 = new Animation(406);
	/**
	 * Attacking melee gfx
	 */
	private static final Graphic gfx = new Graphic(147);
	private static final Graphic gfx1 = new Graphic(147);

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
			new Projectile(earthquake, victim, 1165, 44, 3, 43, 43, 0).sendProjectile();
			TaskManager.submit(new Task(4, earthquake, false) {

				@Override
				public void execute() {
					if (victim.getPosition().sameAs(pos)) {
						earthquake.getCombatBuilder()
						.setContainer(new CombatContainer(earthquake, victim, 1, 1, CombatType.MAGIC, true));
					}
					earthquake.setChargingAttack(false);
					stop();
					earthquake.performAnimation(anim1);
					earthquake.performGraphic(gfx);
				}
			});

			if (Locations.goodDistance(earthquake.getPosition().copy(), victim.getPosition().copy(), 1)
					&& Misc.getRandom(5) <= 3) {
				earthquake.getCombatBuilder().setContainer(new CombatContainer(earthquake, victim, 1, 1, CombatType.MELEE, true));

				earthquake.getCombatBuilder().setContainer(new CombatContainer(earthquake, victim, 1, 1, CombatType.MELEE, true));

				earthquake.getCombatBuilder().setContainer(new CombatContainer(earthquake, victim, 1, 1, CombatType.MELEE, true));

				earthquake.performGraphic(gfx1);
				earthquake.performAnimation(anim);
				earthquake.performGraphic(gfx);
			}
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
		return CombatType.MELEE;
	}

}
