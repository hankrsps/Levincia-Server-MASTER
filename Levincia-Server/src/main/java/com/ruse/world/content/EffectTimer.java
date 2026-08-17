package com.ruse.world.content;

public enum EffectTimer {

	X2_DR_1HR(15355),
	X2_DMG_15MIN(14084),
	X2_DDR_15MIN(4564),
	X2_DR_15MIN(1973),
	X2_DR_4HR(4277),
	X2_DMG_4HR(15675),
	X2_DDR_1HR(15356),
	X2_DMG_1HR(15357),
	X2_DR_30MIN(15358),
	X2_DMG_30MIN(15359),
	INFINITE_SUPER_OVERLOAD(15330),
	INFINITE_RAGE_POTION(23225),
	INFINITE_OWNER_POTION(23242),
	T1_INF_OVERLOAD(23124),
	T2_INF_OVERLOAD(23125),
	T3_INF_OVERLOAD(23126),
	FANTASY_ZONE(23273);
	;
	
	EffectTimer(int clientSprite) {
		this.clientSprite = clientSprite;
	}
	
	private int clientSprite;
	
	public int getClientSprite() {
		return clientSprite;
	}
	
	public void setClientSprite(int sprite) {
		this.clientSprite = sprite;
	}
}
