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
import com.ruse.world.entity.impl.player.Player;

public class NephilimBoss implements CombatStrategy {

	private static final Animation anim1 = new Animation(711);
	private static final Animation anim2 = new Animation(452);
	private static final Graphic gfx1 = new Graphic(1352);
	private static final Graphic gfx2 = new Graphic(1358);
	private static final Graphic gfx3 = new Graphic(1390);
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
		NPC nephilim = (NPC) entity;
		if (nephilim.isChargingAttack() || victim.getConstitution() <= 0) {
			return true;
		}

		if (Locations.goodDistance(nephilim.getPosition().copy(), victim.getPosition().copy(), 1)
				&& Misc.getRandom(5) <= 3) {
			nephilim.performAnimation(anim1);
			victim.performGraphic(gfx3);
			nephilim.getCombatBuilder().setContainer(new CombatContainer(nephilim, victim, 1, 1, CombatType.MAGIC, true));

			nephilim.getCombatBuilder().setContainer(new CombatContainer(nephilim, victim, 1, 1, CombatType.MAGIC, true));

			nephilim.getCombatBuilder().setContainer(new CombatContainer(nephilim, victim, 1, 1, CombatType.MAGIC, true));

		} else if (!Locations.goodDistance(nephilim.getPosition().copy(), victim.getPosition().copy(), 3)
				&& Misc.getRandom(5) == 1) {
			nephilim.setChargingAttack(true);
			final Position pos = new Position(victim.getPosition().getX() - 2 + Misc.getRandom(4),
					victim.getPosition().getY() - 2 + Misc.getRandom(4));

			((Player) victim).getPacketSender().sendGlobalGraphic(new Graphic(1549), pos);
			nephilim.performAnimation(anim1);

			nephilim.forceChat("You shall perish!");
			TaskManager.submit(new Task(2) {
				@Override
				protected void execute() {
					nephilim.moveTo(pos);
					nephilim.performGraphic(gfx2);
					nephilim.performAnimation(anim2);
					nephilim.getCombatBuilder()
							.setContainer(new CombatContainer(nephilim, victim, 1, 1, CombatType.MELEE, false));

					victim.performGraphic(gfx3);
					nephilim.setChargingAttack(false);
					nephilim.getCombatBuilder().setAttackTimer(0);
					stop();
				}
			});
		} else {
			nephilim.setChargingAttack(true);
			nephilim.performAnimation(anim1);
			nephilim.getCombatBuilder()
					.setContainer(new CombatContainer(nephilim, victim, 1, 3, CombatType.MAGIC, true));
			TaskManager.submit(new Task(1, nephilim, false) {
				int tick = 0;

				@Override
				public void execute() {
					if (tick == 0) {
						new Projectile(nephilim, victim, 1352, 44, 3, 43, 43, 0).sendProjectile();
					} else if (tick == 1) {
						nephilim.setChargingAttack(false).getCombatBuilder()
								.setAttackTimer(attackDelay(nephilim) - 2);
						stop();
					}
					tick++;
				}
			});
		}
		return true;
	}

	public static int getAnimation(int npc) {
		int anim = 12259;
		if (npc == 50)
			anim = 81;
		else if (npc == 5362 || npc == 5363)
			anim = 14246;
		else if (npc == 51)
			anim = 13152;
		return anim;
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
