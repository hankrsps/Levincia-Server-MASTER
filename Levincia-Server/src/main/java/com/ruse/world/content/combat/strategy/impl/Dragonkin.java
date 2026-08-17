package com.ruse.world.content.combat.strategy.impl;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.*;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.combat.CombatContainer;
import com.ruse.world.content.combat.CombatType;
import com.ruse.world.content.combat.strategy.CombatStrategy;
import com.ruse.world.entity.impl.Character;
import com.ruse.world.entity.impl.npc.NPC;

public class Dragonkin implements CombatStrategy {

	public static boolean minions_spawned = false;
	public static boolean minions_dead = false;
	public static final int MINION_NPCID = 9897;

	@Override
	public boolean canAttack(Character entity, Character victim) {
		return true;
	}

	@Override
	public CombatContainer attack(Character entity, Character victim) {
		return null;
	}


	@Override
	public boolean customContainerAttack(Character attacker, Character target) {
		NPC npc = (NPC) attacker;

		if (target.getConstitution() <= 0) {
			npc.forceChat("This is not the end, adventurer!");
			return true;
		}
		if (npc.isChargingAttack())
			return true;

			boolean meleeDistance = Locations.goodDistance(npc.getPosition(), target.getPosition(), 2);
			if (meleeDistance) {
				npc.setHealed(true);
				npc.performGraphic(gfx2);
				npc.performAnimation(anim3);
				npc.getMovementQueue().setLockMovement(true);
				npc.forceChat("Gods.. Aid me..");
				npc.setChargingAttack(true);
			}
				npc.setChargingAttack(true);
				npc.getMovementQueue().setLockMovement(true);

				npc.setChargingAttack(true);
				npc.getMovementQueue().reset().setLockMovement(true);
				TaskManager.submit(new Task(1, npc, false) {
					int ticks = 0;

					@Override
					public void execute() {

						if (ticks == 0) {
							target.getMovementQueue().freeze(5);
							target.performGraphic(gfx3);
							npc.forceChat("Freeze!");
							npc.performAnimation(new Animation(711));
							npc.getCombatBuilder()
									.setContainer(new CombatContainer(npc, target, 1, CombatType.MAGIC, true));
						} else if (ticks == 1 || ticks == 4 || ticks == 5) {
							npc.performGraphic(gfx2);
							npc.performAnimation(anim3);
						}
						if (ticks == 5)
							npc.forceChat ("The Elder Gods will not be defeated");
						if (ticks == 18 && minions_dead == false && minions_spawned == false){
							npc.forceChat("I call upon you, minions!");
								NPC[] babies = new NPC[] { new NPC(MINION_NPCID, new Position (2922 + Misc.getRandom (5),2927+ Misc.getRandom (5), target.getPosition ().getZ())) };
							NPC[] babies1 = new NPC[] { new NPC(MINION_NPCID, new Position (2922 - Misc.getRandom (5),2927+ Misc.getRandom (5), target.getPosition ().getZ())) };
							NPC[] babies2 = new NPC[] { new NPC(MINION_NPCID, new Position (2922+ Misc.getRandom (5),2927 - Misc.getRandom (5), target.getPosition ().getZ())) };
								minions_spawned = true;
								for (NPC n : babies) {
									World.register(n);
									n.getCombatBuilder().attack(target);
									if (n.getConstitution() <= 0) {
										World.deregister(n);
									}
								}
							for (NPC n : babies1) {
								World.register(n);
								n.getCombatBuilder().attack(target);
								if (n.getConstitution() <= 0) {
									World.deregister(n);
								}
							}
							for (NPC n : babies2) {
								World.register(n);
								n.getCombatBuilder().attack(target);
								if (n.getConstitution() <= 0) {
									World.deregister(n);
								}
							}
							}
						if (ticks == 20)
							npc.performAnimation(new Animation(451));
						if (ticks == 23)
							new Projectile(npc, target, 2001, 44, 3, 43, 31, 0).sendProjectile();
						if (ticks == 24) {
							target.performGraphic (new Graphic (2004));
							npc.setChargingAttack (false);
							stop ();
						}
						ticks++;
					}
				});
		return true;
	}

	private static int count = 0;
	public static void handleDeath() {
		count++;
		if (count == 3) {
			minions_dead = true;
			minions_spawned = true;
		}
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




	private static final Animation anim3 = new Animation(451);
	private static final Graphic gfx2 = new Graphic(2281, GraphicHeight.LOW);
	private static final Graphic gfx3 = new Graphic(369, GraphicHeight.LOW);
}
