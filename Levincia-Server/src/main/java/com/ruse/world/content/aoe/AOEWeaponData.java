package com.ruse.world.content.aoe;

import com.ruse.model.CombatIcon;

public class AOEWeaponData {

	private final int id;
	private final int minDamage;
	private final int maxDamage;
	private final int radius;
	private final CombatIcon icon;

	public AOEWeaponData(int id, int minDamage, int maxDamage, int radius, CombatIcon icon) {
		this.id = id;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.radius = radius;
		this.icon = icon;
	}

	public int getId() {
		return id;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public int getRadius() {
		return radius;
	}

	public CombatIcon getIcon() {
		return icon;
	}
}
