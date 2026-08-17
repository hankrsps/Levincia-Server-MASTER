package com.ruse.world.content.combat.strategy.impl;

import java.util.Random;
import com.ruse.model.Animation;
import com.ruse.model.Graphic;
import com.ruse.model.Locations;
import com.ruse.model.Position;
import com.ruse.model.Projectile;
import com.ruse.util.Misc;
import com.ruse.util.RandomUtility;
import com.ruse.world.World;
import com.ruse.world.content.combat.CombatContainer;
import com.ruse.world.content.combat.CombatType;
import com.ruse.world.content.combat.strategy.CombatStrategy;
import com.ruse.world.entity.impl.Character;
import com.ruse.world.entity.impl.npc.NPC;

public class Veigar implements CombatStrategy {

	public static final int NPC = 585;
	private static int[] MinionId = { 125,688,3712 };
	private final int[] MAGICANIMS = { 410};
	private final int[] GFX = { 999,1000,1002,2589,2001};

	private int getRandomAnimationMagic() {
		return MAGICANIMS[RandomUtility.exclusiveRandom(0, MAGICANIMS.length)];
	}

	private int getRandomGfx() {
		return GFX[RandomUtility.exclusiveRandom(0, GFX.length)];
	}
	public static void spawnMinion(Character victim) {

		Random random = new Random();

		boolean success = random.nextInt(100) <= 37 ? true : false;
		if (success) {

			for (int i = 0; i < MinionId.length; i++) {
				Position MinionSpawn = new Position(victim.getPosition().getX(), victim.getPosition().getY());
				NPC monster = new NPC(MinionId[i], MinionSpawn);
				World.register(monster);
				monster.getCombatBuilder().attack(victim);
			}
		}

	}

	private Animation animationsmagic = new Animation(getRandomAnimationMagic());
	private Graphic graphics = new Graphic(getRandomGfx());


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
		NPC Boss = (NPC) entity;
		animationsmagic = new Animation(getRandomAnimationMagic());

		graphics = new Graphic(getRandomGfx());
		if (Locations.goodDistance(Boss.getPosition().copy(), victim.getPosition().copy(), 1)
				&& Misc.getRandom(5) <= 3) {
			Boss.performAnimation(animationsmagic);
			new Projectile(entity, victim, graphics.getId(), 44, 3, 43, 31, 0).sendProjectile();

			Boss.getCombatBuilder().setContainer(new CombatContainer(Boss, victim, 3, 1, CombatType.MAGIC, true));

		} else {
			Boss.performAnimation(animationsmagic);
			new Projectile(entity, victim, graphics.getId(), 44, 3, 43, 31, 0).sendProjectile();
			Boss.getCombatBuilder().setContainer(new CombatContainer(Boss, victim, 3, 1, CombatType.MAGIC, true));

		}
		return true;
	}

	@Override
	public int attackDelay(Character entity) {
		return entity.getAttackSpeed();
	}

	@Override
	public int attackDistance(Character entity) {
		return 15;
	}

	@Override
	public CombatType getCombatType() {
		return CombatType.MAGIC;
	}
}