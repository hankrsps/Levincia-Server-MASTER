package com.ruse.world.content.combat.strategy;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.*;
import com.ruse.util.Misc;
import com.ruse.world.clip.region.RegionClipping;
import com.ruse.world.content.combat.CombatContainer;
import com.ruse.world.content.combat.CombatType;
import com.ruse.world.content.combat.strategy.impl.BaseAttacks;
import com.ruse.world.content.raids.shadows.NecromancerRaidParty;
import com.ruse.world.entity.impl.Character;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class TelosCombatStrategy implements CombatStrategy {


	// Add a position instance variable to represent Telos' position
	private Position telosPosition;

	// Add a new instance variable to keep track of the last task
	private Task lastTask;

	// Add a constructor that initializes the telosPosition variable
	public TelosCombatStrategy() {
		telosPosition = new Position(2942, 2968);
		lastTask = null;
	}


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
        /*
        if (player.getShadowRaidsParty() == null)
            return false;
*/

		int random = Misc.random(5);
		if (random == 1) {
			randomFire(npc, player);
		} else if (random == 2) {
			dripPlayer(npc, player);
		} else if (random == 3) {
			randomFire2(npc, player);
		/*} else if (random == 4 && npc.getConstitution () < npc.getDefaultConstitution () / 2) {
			healArea(npc, player);*/
		} else {
			BaseAttacks.magicAttack(npc, player);
		}
		return true;
	}

	@Override
	public int attackDelay(Character entity) {
		return 2;
	}

	@Override
	public int attackDistance(Character entity) {
		return 20;
	}

	@Override
	public CombatType getCombatType() {
		return CombatType.MAGIC;
	}

	public NecromancerRaidParty getParty() {
		return getParty();
	}

	public static Position getRandom() {
		// Use a ThreadLocal Random instance instead of creating a new one every time
		Random random = ThreadLocalRandom.current();
		int x = 2925 + random.nextInt(37);
		int y = 2957 + random.nextInt(23);

		// Use a do-while loop instead of a recursive call
		do {
			x = 2925 + random.nextInt(37);
			y = 2957 + random.nextInt(23);
		} while (RegionClipping.getClipping(x, y, 0) != 0);

		return new Position(x, y);
	}
	/*
	private void healArea(NPC npc, Player player) {
		// If the last task is not null, stop it
		if (lastTask != null) {
			lastTask.stop();
		}

		// Choose a random position within 20 tiles of Telos
		Position randomPosition = new Position(telosPosition.getX() + ThreadLocalRandom.current().nextInt(-10, 10), telosPosition.getY() + ThreadLocalRandom.current().nextInt(-10, 10));

		// Send a graphic to the player to indicate the 4x4 area around the random position
		player.getPacketSender().sendGlobalGraphic(new Graphic(626), randomPosition);

		// Create a task that will run every 2 seconds and will heal Telos if the player is not standing
		// in the 4x4 area around the random position
		Task task = new Task(1, npc, false) {
			@Override
			public void execute() {
				// Check if the player is not standing in the 4x4 area around the random position
				if (!(player.getPosition().getX() >= randomPosition.getX() - 2 && player.getPosition().getX() <= randomPosition.getX() + 2 && player.getPosition().getY() >= randomPosition.getY() - 2 && player.getPosition().getY() <= randomPosition.getY() + 2)) {
					player.sendMessage ("Telos is healing because you are not standing in the portal!");
					player.dealDamage (new Hit (1, Hitmask.DARK_PURPLE, CombatIcon.BLOCK));
					// Heal Telos by 1% of its maximum health
					npc.heal(npc.getDefaultConstitution () / 100);
					// Send a graphic to the player to indicate the 4x4 area
				}
			}

			@Override
			public void stop() {
				setEventRunning(false);
			}
		};

		// Submit the task and store it in the lastTask variable
		TaskManager.submit(task);
		lastTask = task;
	}
*/
	   private void dripPlayer(NPC npc, Player player) {
		// Choose a random message for Telos to say
		String[] messages = {
				"You are not ready for this!",
				"I will burn you to ashes!",
				"You should have stayed away!",
				"You will regret facing me!",
				"I am the master of this realm!",
				"You dare challenge me?!",
				"My power is unmatched!",
				"I will crush you with my might!",
				"You are no match for me!",
				"I will destroy you!",
				"You will suffer for your insolence!",
				"You will pay for your defiance!",
				"I will rain down fire upon you!",
				"You will regret crossing me!",
				"I am the ultimate predator!",
				"Your death is at hand!",
				"I will feast on your soul!",
				"You are nothing but a mere insect to me!",
				"I will tear you apart with my bare hands!",
				"You will cower before my greatness!",
				"I am the embodiment of death and destruction!",
				"Your fate is sealed!",
				"You will beg for mercy before I am done with you!",
				"I am the supreme ruler of this land!",
				"You will tremble at the sound of my name!",
				"I will crush your spirit and leave you broken!",
				"Your death will be swift and merciless!",
				"I am the terror that lurks in the darkness!",
				"Your demise is inevitable!"
		};
		int randomIndex = new Random().nextInt(messages.length);
		String message = messages[randomIndex];
		npc.forceChat(message);

					// Create a task that will run every 2 seconds and will inflict damage to the player
					// and heal Telos when the player is within range
					TaskManager.submit(new Task(1, npc, false) {
					int tick = 0;

			@Override
			public void execute() {
				if (npc == null || npc.isDying() || npc.getConstitution() <= 0) {
					stop();
					return;
				}

				if (tick >= 3 && tick % 2 == 1) {
					if (player == null || player.isTeleporting() || player.getPosition().distance(npc.getPosition()) > 5) {
						return;
					}

					// Calculate the distance between the player and Telos
					int distance = player.getPosition().distance(npc.getPosition());
					if (distance > 5) {
						return;
					}

					int playerX = player.getPosition().getX();
					int playerY = player.getPosition().getY();
					int npcX = npc.getPosition().getX();
					int npcY = npc.getPosition().getY();

					for (int i = 1; i < distance; i++) {
						int x = playerX + (npcX - playerX) * i / distance;
						int y = playerY + (npcY - playerY) * i / distance;
						Position tilePos = new Position (x, y);

						// Send the global graphic to the tile at the current position
						player.getPacketSender().sendGlobalGraphic(new Graphic(184), tilePos);
					}

					int damage = 30 + new Random ().nextInt(30);
					int healAmount = damage * 10;
					player.dealDamage(new Hit(damage));
					npc.heal(healAmount);
				}
				tick++;
			}
		});
	}


	public static void randomFire2(NPC npc, Player player) {
		// Choose a random message for Telos to say
		String[] messages = {
				"You are not ready for this!",
				"I will burn you to ashes!",
				"You should have stayed away!",
				"You will regret facing me!",
				"I am the master of this realm!",
				"You dare challenge me?!",
				"My power is unmatched!",
				"I will crush you with my might!",
				"You are no match for me!",
				"I will destroy you!",
				"You will suffer for your insolence!",
				"You will pay for your defiance!",
				"I will rain down fire upon you!",
				"You will regret crossing me!",
				"I am the ultimate predator!",
				"Your death is at hand!",
				"I will feast on your soul!",
				"You are nothing but a mere insect to me!",
				"I will tear you apart with my bare hands!",
				"You will cower before my greatness!",
				"I am the embodiment of death and destruction!",
				"Your fate is sealed!",
				"You will beg for mercy before I am done with you!",
				"I am the supreme ruler of this land!",
				"You will tremble at the sound of my name!",
				"I will crush your spirit and leave you broken!",
				"Your death will be swift and merciless!",
				"I am the terror that lurks in the darkness!",
				"Your demise is inevitable!"
		};
		int randomIndex = new Random().nextInt(messages.length);
		String message = messages[randomIndex];
		npc.forceChat(message);

		//npc.performAnimation(new Animation(13159));
		npc.getCombatBuilder().setContainer(new CombatContainer(npc, player, 1, 3, CombatType.MAGIC, true));
		player.sendMessage("Telos is channeling a powerful spell, get ready to move!");

		TaskManager.submit(new Task(3, npc, false) {
			@Override
			public void execute() {
				// Use a ThreadLocal Random instance instead of creating a new one every time
				Random random = ThreadLocalRandom.current ();

				// Choose a random direction for Telos to cast the spell
				int direction = random.nextInt (8);

				// Calculate the position of the spell based on Telos' position and the chosen direction
				int x = npc.getPosition ().getX ();
				int y = npc.getPosition ().getY ();

				// Keep track of the spell's current position
				Position currentPosition = new Position (x, y);

				// Loop until the spell reaches the end of its range
				while (currentPosition.distance (npc.getPosition ()) <= 7) {
					// Move the spell in the chosen direction
					if (direction == 0) {
						x--;
						y--;
					} else if (direction == 1) {
						y--;
					} else if (direction == 2) {
						x++;
						y--;
					} else if (direction == 3) {
						x--;
					} else if (direction == 4) {
						x++;
					} else if (direction == 5) {
						x--;
						y++;
					} else if (direction == 6) {
						y++;
					} else if (direction == 7) {
						x++;
						y++;
					}

					// Update the current position of the spell
					currentPosition.setX (x);
					currentPosition.setY (y);

					// Send a graphic at the position of the spell to indicate it to the players
					player.getPacketSender ().sendGlobalGraphic (new Graphic (1677), currentPosition);

					// Check if the player is standing at the position of the spell
					if (player.getPosition ().equals (currentPosition)) {
						// Inflict damage to the player
						player.dealDamage (new Hit (Misc.random (250, 600), Hitmask.DARK_PURPLE, CombatIcon.NONE));
						stop ();
						return;
					}
				}

				stop ();
			}

			@Override
			public void stop() {
				setEventRunning (false);
			}
		});
	}

	public static void randomFire(NPC npc, Player player) {
		String[] messages = {
				"You are not ready for this!",
				"I will burn you to ashes!",
				"You should have stayed away!",
				"You will regret facing me!",
				"I am the master of this realm!",
				"You dare challenge me?!",
				"My power is unmatched!",
				"I will crush you with my might!",
				"You are no match for me!",
				"I will destroy you!",
				"You will suffer for your insolence!",
				"You will pay for your defiance!",
				"I will rain down fire upon you!",
				"You will regret crossing me!",
				"I am the ultimate predator!",
				"Your death is at hand!",
				"I will feast on your soul!",
				"You are nothing but a mere insect to me!",
				"I will tear you apart with my bare hands!",
				"You will cower before my greatness!",
				"I am the embodiment of death and destruction!",
				"Your fate is sealed!",
				"You will beg for mercy before I am done with you!",
				"I am the supreme ruler of this land!",
				"You will tremble at the sound of my name!",
				"I will crush your spirit and leave you broken!",
				"Your death will be swift and merciless!",
				"I am the terror that lurks in the darkness!",
				"Your demise is inevitable!"
		};

		// Use a ThreadLocal Random instance instead of creating a new one every time
		Random random = ThreadLocalRandom.current();
		int randomIndex = random.nextInt(messages.length);
		String message = messages[randomIndex];
		npc.forceChat(message);

		npc.setChargingAttack(true);
		npc.performAnimation(new Animation(npc.getDefinition().getAttackAnimation()));
		ArrayList<Position> positionList = new ArrayList<>();

		// Pre-allocate the list to the desired size to avoid resizing
		positionList.ensureCapacity(20);

		for (int i = 0 ; i < 20; i ++){
			positionList.add(getRandom().setZ(npc.getPosition().getZ()));
		}

		TaskManager.submit(new Task(1, true) {
			int tick = 0;

			@Override
			protected void execute() {
				if (tick == 0) {
					positionList.forEach(position -> player.getPacketSender()
							.sendGraphic(new Graphic(1678), position));
				}
				if (tick == 1) {
					// Use a for-each loop to avoid creating an unnecessary iterator
					for (Player partyMember : player.getTelosRaidsParty().getPlayers()) {
						if (positionList.contains(partyMember.getPosition())) {
							partyMember.dealDamage(new Hit(Misc.random(250, 600), Hitmask.DARK_PURPLE, CombatIcon.NONE));
						}
					}
					npc.setChargingAttack(false);
					stop();
				}
				tick++;
			}
		});
	}
};
