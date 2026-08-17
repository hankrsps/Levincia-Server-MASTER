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

public class Terrorstep implements CombatStrategy {

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
		NPC bandosAvatar = (NPC) entity;
		if (bandosAvatar.isChargingAttack() || victim.getConstitution() <= 0) {
			return true;
		}

		if (Locations.goodDistance(bandosAvatar.getPosition().copy(), victim.getPosition().copy(), 1)
				&& Misc.getRandom(5) <= 3) {
			bandosAvatar.performAnimation(new Animation(10265 ));
			victim.performGraphic(new Graphic(405));
			bandosAvatar.getCombatBuilder().setContainer(new CombatContainer(bandosAvatar, victim, 1, 1, CombatType.MELEE, true));

			bandosAvatar.getCombatBuilder().setContainer(new CombatContainer(bandosAvatar, victim, 1, 1, CombatType.MELEE, true));

			bandosAvatar.getCombatBuilder().setContainer(new CombatContainer(bandosAvatar, victim, 1, 1, CombatType.MELEE, true));

		} else if (!Locations.goodDistance(bandosAvatar.getPosition().copy(), victim.getPosition().copy(), 3)
				&& Misc.getRandom(5) == 1) {
			bandosAvatar.setChargingAttack(true);
			final Position pos = new Position(victim.getPosition().getX() - 2 + Misc.getRandom(4),
					victim.getPosition().getY() - 2 + Misc.getRandom(4));

			((Player) victim).getPacketSender().sendGlobalGraphic(new Graphic(1549), pos);
			bandosAvatar.performAnimation(new Animation(10265 ));

			bandosAvatar.forceChat("You shall perish!");
			TaskManager.submit(new Task(2) {
				@Override
				protected void execute() {
					bandosAvatar.moveTo(pos);
					bandosAvatar.performAnimation(new Animation(10265 ));
					bandosAvatar.getCombatBuilder()
							.setContainer(new CombatContainer(bandosAvatar, victim, 1, 1, CombatType.MELEE, false));
					bandosAvatar.setChargingAttack(false);
					bandosAvatar.getCombatBuilder().setAttackTimer(0);
					stop();
				}
			});
		} else {
			bandosAvatar.setChargingAttack(true);
			bandosAvatar.performAnimation(new Animation(10265 ));
			bandosAvatar.getCombatBuilder()
					.setContainer(new CombatContainer(bandosAvatar, victim, 1, 3, CombatType.MAGIC, true));
			TaskManager.submit(new Task(1, bandosAvatar, false) {
				int tick = 0;

				@Override
				public void execute() {
					if (tick == 0) {
						new Projectile(bandosAvatar, victim, 422, 44, 3, 43, 43, 0).sendProjectile();
					} else if (tick == 1) {
						bandosAvatar.setChargingAttack(false).getCombatBuilder()
								.setAttackTimer(attackDelay(bandosAvatar) - 2);
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
