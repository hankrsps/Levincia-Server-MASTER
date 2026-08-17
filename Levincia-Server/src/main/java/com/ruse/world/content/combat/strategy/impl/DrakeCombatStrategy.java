package com.ruse.world.content.combat.strategy.impl;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Animation;
import com.ruse.model.Locations;
import com.ruse.model.Position;
import com.ruse.model.Projectile;
import com.ruse.util.Misc;
import com.ruse.world.content.combat.CombatContainer;
import com.ruse.world.content.combat.CombatType;
import com.ruse.world.content.combat.strategy.CombatStrategy;
import com.ruse.world.entity.impl.Character;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

/**
 * Handles Drake Combat strategy
 * 
 * @author 2012 <https://www.rune-server.ee/members/dexter+morgan/>
 *
 */
public class DrakeCombatStrategy implements CombatStrategy {

	/**
	 * Attacking melee
	 */
	private static final Animation MELEE = new Animation(10265);
	/**
	 * Attacking melee
	 */
	private static final Animation RANGE = new Animation(4230);

	/**
	 * The drake npc id
	 */
	public static final int DRAKE = 9884;

	/**
	 * The attack number
	 */
	private int attack;


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
		NPC npc = (NPC) entity;
		Player player = (Player) victim;
		if (npc.isChargingAttack() || npc.getConstitution() <= 0) {
			npc.getCombatBuilder().setAttackTimer(4);
			return true;
		}
		attack = 0;
		if (attack == 7) {
			Position pos = victim.getPosition().copy();
			npc.setChargingAttack(true).getCombatBuilder().setAttackTimer(6);
			new Projectile (npc, victim, 1229, 44, 3, 43, 43, 0).sendProjectile();
			TaskManager.submit(new Task (4, npc, false) {

				@Override
				public void execute() {
					if (victim.getPosition().sameAs(pos)) {
						npc.getCombatBuilder()
						.setContainer(new CombatContainer(npc, victim, 1, 1, CombatType.DRAGON_FIRE, true));
					}
					npc.setChargingAttack(false);
					stop();
				}
			});
			attack = 0;
		} else {
			if (Locations.goodDistance(npc.getPosition().copy(), victim.getPosition().copy(), 1)
					&& Misc.getRandom(5) <= 3) {
				npc.getCombatBuilder().setContainer(new CombatContainer(npc, victim, 1, 1, CombatType.MELEE, true));
				npc.performAnimation(MELEE);
			} else {
				new Projectile(npc, victim, 610, 44, 3, 43, 43, 0).sendProjectile();
				npc.getCombatBuilder()
						.setContainer(new CombatContainer(npc, victim, 1, 1, CombatType.RANGED, true));
				npc.performAnimation(RANGE);
			}
		}
		attack++;
		return true;
	}

	@Override
	public int attackDelay(Character entity) {
		return entity.getAttackSpeed();
	}

	@Override
	public int attackDistance(Character entity) {
		return 5;
	}

	@Override
	public CombatType getCombatType() {
		return CombatType.MIXED;
	}
}