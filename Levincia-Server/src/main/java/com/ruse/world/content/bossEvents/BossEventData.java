package com.ruse.world.content.bossEvents;

import com.ruse.model.Position;
import com.ruse.util.Misc;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Levincia#9598 (AlwaysDreaming.AI@gmail.com)
 * Offering Development services with tutorials pm me
 *
 */

public enum BossEventData {

	HANTO(0, 250, "Hanto Warriors", 40, 19624, 40, "Hanto Warriors", 699, 20000, "All", 35,
			new Position(2849, 4576, 0)),

	RADITZ(1, 449, "Raditz", 35, 19624, 35, "Raditz", 699, 20000, "All", 35,
			new Position(2911, 3991, 0)),

	GOKU(2, 452, "Goku", 35, 19624, 35, "Goku", 126, 12000, "All", 26, new Position(3358, 9307, 0)),

	BOTANIC(3, 2342, "Botanic Guardian", 35, 19624, 35, "Botanic Guardian", 126, 12000, "All", 26,
			new Position(2586, 9449, 0)),

	ENRAGED_GUARDIAN(4, 2949, "Enraged Guardian", 30, 19624, 30, "Enraged Guardian", 126, 12000, "All", 26,
			new Position(3039, 3995,0)),

	ELEMENTAL_GUARDIAN(5, 505, "Elemental Guardian", 30, 19624, 30, "Elemental Guardian", 126, 12000, "All", 26,
			new Position(2781, 4576, 0)),

	INYUASHA(6, 185, "Inuyasha", 30, 19624, 30, "Inuyasha", 126, 12000, "All", 26,
			new Position(2328, 5409, 0)),

	TOLROKOTH(7, 6430, "Tolrokoth", 25, 19624, 25, "Tolrokoth", 126, 12000, "All", 26, new Position(1887, 5468, 0)),

	DEITY_DEMON(8, 440, "Demons of Deity", 20, 19624, 20, "Demons of Deity", 699, 20000, "All", 35, new Position(2842, 9387, 0)),

	MUTATED_HOUND(9, 9839, "Mutated Hound", 20, 19624, 20, "Mutated Hound", 126, 12000, "All", 26,
			new Position(3421, 4777, 0)),
	;

	BossEventData(int taskNumber, int npcid, String text, int endamount, int rewards, int amount, String name,
			int combatLevel, int health, String weakness, int maxhit, Position position) {
		this.taskNumber = taskNumber;
		this.npcid = npcid;
		this.text = text;
		this.endamount = endamount;
		this.rewards = rewards;
		this.amount = amount;
		this.name = name;
		this.combatLevel = combatLevel;
		this.health = health;
		this.weakness = weakness;
		this.maxhit = maxhit;
		this.position = position;
	}

	private Position position;

	public Position getPosition() {
		return position;
	}

	private int npcid, endamount, taskNumber, combatLevel, health, maxhit, x, y, z;
	private int rewards, amount;

	private String text, name, weakness;

	public int getMaxhit() {
		return maxhit;
	}

	public int getAmount() {
		return amount;
	}

	public int getCombatLevel() {
		return combatLevel;
	}

	public void setCombatLevel(int combatLevel) {
		this.combatLevel = combatLevel;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getWeakness() {
		return weakness;
	}

	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}

	public int getTaskNumber() {
		return taskNumber;
	}

	public int getEndamount() {
		return randomAmount;
	}

	public void setEndamount(int endamount) {
		this.endamount = endamount;
	}

	public String getName() {
		return name;
	}

	public int randomAmount = 25 + Misc.getRandom (40);

	public int getNpcid() {
		return npcid;
	}

	public String getText() {
		return text;
	}

	public int getRewards() {
		return rewards;
	}

	static final Map<Integer, BossEventData> byId = new HashMap<Integer, BossEventData>();

	private final static BossEventData data[] = BossEventData.values();

	static {
		for (BossEventData e : data) {
			if (byId.put(e.getTaskNumber(), e) != null) {
				throw new IllegalArgumentException("duplicate id: " + e.getTaskNumber());
			}
		}
	}

	public static BossEventData getById(int id) {
		if (byId.get(id) == null) {
			return byId.get(0);
		}
		return byId.get(id);
	}
}
