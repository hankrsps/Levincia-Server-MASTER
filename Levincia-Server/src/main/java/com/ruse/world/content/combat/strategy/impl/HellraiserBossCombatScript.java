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

public class HellraiserBossCombatScript implements CombatStrategy {
	public static final int EARTHQUAKE = 187;
	public static Position foodloc = new Position(2864, 2864, 0);
	private int attack;
	/**
	 * Attacking melee
	 */
	private static final Animation MELEE = new Animation(407);
	private static final Animation MELEE1 = new Animation(406);
	@Override
	public boolean canAttack(Character entity, Character victim) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public CombatContainer attack(Character entity, Character victim) {
		// TODO Auto-generated method stub
		return null;
	}

	int[] foodIds = new int[] { 15272, 17817,391 };


	//Player player = (Player) victim;
	//spawnFood(player);
	//NPC npc = (NPC) entity;
	//npc.forceChat("IM not dead yet!");
	@Override
	public boolean customContainerAttack(Character entity, Character victim) {
		NPC earthquake = (NPC) entity;
		Player player = (Player) victim;
			Position pos = victim.getPosition().copy();
			earthquake.setChargingAttack(true).getCombatBuilder().setAttackTimer(6);
			new Projectile(earthquake, victim, 1741, 44, 3, 43, 43, 0).sendProjectile();
			TaskManager.submit(new Task(4, earthquake, false) {

				@Override
				public void execute() {
					if (victim.getPosition().sameAs(pos)) {
						earthquake.getCombatBuilder()
						.setContainer(new CombatContainer(earthquake, victim, 1, 1, CombatType.MAGIC, true));
					}
					earthquake.setChargingAttack(false);
					stop();
					earthquake.performAnimation(MELEE1);
					earthquake.performGraphic(new Graphic(1176));
				}
			});

			if (Locations.goodDistance(earthquake.getPosition().copy(), victim.getPosition().copy(), 1)
					&& Misc.getRandom(5) <= 3) {
				earthquake.getCombatBuilder().setContainer(new CombatContainer(earthquake, victim, 1, 1, CombatType.MELEE, true));

				earthquake.getCombatBuilder().setContainer(new CombatContainer(earthquake, victim, 1, 1, CombatType.MELEE, true));

				earthquake.getCombatBuilder().setContainer(new CombatContainer(earthquake, victim, 1, 1, CombatType.MELEE, true));

				earthquake.performGraphic(new Graphic(1201));
				earthquake.performAnimation(MELEE);
				earthquake.performGraphic(new Graphic(1176));
			}
		return true;
	}

	@Override
	public int attackDelay(Character entity) {
		// TODO Auto-generated method stub
		return entity.getAttackSpeed();
	}

	@Override
	public int attackDistance(Character entity) {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public CombatType getCombatType() {
		// TODO Auto-generated method stub
		return CombatType.MELEE;
	}

}
