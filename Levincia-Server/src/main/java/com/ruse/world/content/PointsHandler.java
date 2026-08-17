package com.ruse.world.content;

import com.ruse.world.entity.impl.player.Player;

public class PointsHandler {

	private Player p;

	public PointsHandler(Player p) {
		this.p = p;
	}

	public void reset() {
		dungTokens = commendations = (int) (loyaltyPoints = votingPoints = slayerPoints = pkPoints = 0);
		p.getPlayerKillingAttributes().setPlayerKillStreak(0);
		p.getPlayerKillingAttributes().setPlayerKills(0);
		p.getPlayerKillingAttributes().setPlayerDeaths(0);
		p.getDueling().arenaStats[0] = p.getDueling().arenaStats[1] = 0;
	}

	/*
	 * public PointsHandler refreshPanel() { p.getPacketSender().sendString(39170,
	 * "@or2@Prestige Points: @yel@"+prestigePoints);
	 * p.getPacketSender().sendString(39171,
	 * "@or2@Commendations: @yel@ "+commendations);
	 * p.getPacketSender().sendString(39172,
	 * "@or2@Loyalty Points: @yel@"+(int)loyaltyPoints);
	 * p.getPacketSender().sendString(39173,
	 * "@or2@Dung. Tokens: @yel@ "+dungTokens);
	 * p.getPacketSender().sendString(39174,
	 * "@or2@Voting Points: @yel@ "+votingPoints);
	 * p.getPacketSender().sendString(39175,
	 * "@or2@Slayer Points: @yel@"+slayerPoints);
	 * p.getPacketSender().sendString(39176,
	 * "@or2@Barrows Points: @yel@"+barrowsPoints);
	 * p.getPacketSender().sendString(39177,
	 * "@or2@Member Points: @yel@"+memberPoints);
	 * p.getPacketSender().sendString(39178, "@or2@Pk Points: @yel@"+pkPoints);
	 * p.getPacketSender().sendString(39179,
	 * "@or2@Wilderness Killstreak: @yel@"+p.getPlayerKillingAttributes().
	 * getPlayerKillStreak()); p.getPacketSender().sendString(39180,
	 * "@or2@Wilderness Kills: @yel@"+p.getPlayerKillingAttributes().getPlayerKills(
	 * )); p.getPacketSender().sendString(39181,
	 * "@or2@Wilderness Deaths: @yel@"+p.getPlayerKillingAttributes().
	 * getPlayerDeaths()); p.getPacketSender().sendString(39182,
	 * "@or2@Arena Victories: @yel@"+p.getDueling().arenaStats[0]);
	 * p.getPacketSender().sendString(39183,
	 * "@or2@Arena Points: @yel@"+p.getDueling().arenaStats[1]);
	 * //p.getPacketSender().sendString(30184,
	 * "@or2@Skilling points: @yel@"+skillingPoints);
	 * //p.getPacketSender().sendString(30185,
	 * "@or2@Barrows chests opened: @yel@"+barrowsChests); return this; }
	 */

	private int barrowsPoints;
	private int prestigePoints;
	private int slayerPoints;
	private int questPoints;
	private int commendations;
	private int dungTokens;
	private int pkPoints;
	private double loyaltyPoints;
	private int votingPoints;
	private int eventpoints;
	private int bosspoints;
	private int spawnkillcount;
	private int lordkillcount;
	private int demonkillcount;
	private int dragonkillcount;
	private int beastkillcount;
	private int kingkillcount;
	private int avatarkillcount;
	private int angelkillcount;
	private int lucienkillcount;
	private int herculeskillcount;
	private int satankillcount;
	private int zeuskillcount;
	private int groudonkillcount;
	private int fenrirkillcount;
	private int avalonBeastKC;

	private int borkKC;
	private int forestArcherKC;
	private int chaoticArcherKC;
	private int streamCount;
	private int divineArcherKC;
	private int facelessMagicianKC;
	private int lotusMagicianKC;
	private int shadowMagicianKC;
	private int vampireWarriorKC;
	private int lesarkusWarriorKC;
	private int ancientWarriorKC;
	private int miniLuciferkillcount;
	private int luciferkillcount;
	private int midnightgoblinkillcount;
	private int shillingrate;
	private int npckillcount;
	private int questOneDreamKC;
	private int islesKC;
	private int treasureHunter;
	private int suffering;
	private int necromancer;
	private int telos;
	private int zombieRaidKC;
	private int unknownCompleted;
	private int totalprestiges;
	private int totalsprees;
	private int achievementPoints;
	private int donatorPoints;
	private int skillingPoints;
	private int barrowsChests;
	private int minigame1count;
	private int minigame2count;
	private int minigame3count;
	private int clueSteps;

	public int getClueSteps() {
		return clueSteps;
	}

	public void setClueSteps(int points, boolean add) {
		if (add) {
			this.clueSteps += points;
		} else {
			this.clueSteps = points;
		}
	}

	public int getBarrowsChests() {
		return barrowsChests;
	}

	public void setBarrowsChests(int points, boolean add) {
		if (add)
			this.barrowsChests += points;
		else
			this.barrowsChests = points;
	}

	public int getDonatorPoints() {
		return donatorPoints;
	}

	public void setDonatorPoints(int points, boolean add) {
		if (add)
			this.donatorPoints += points;
		else
			this.donatorPoints = points;
	}

	public int getBarrowsPoints() {
		return this.barrowsPoints;
	}

	public void setBarrowsPoints(int points, boolean add) {
		if (add)
			this.barrowsPoints += points;
		else
			this.barrowsPoints = points;
	}

	public int getPrestigePoints() {
		return prestigePoints;
	}

	public void setPrestigePoints(int points, boolean add) {
		if (add)
			this.prestigePoints += points;
		else
			this.prestigePoints = points;
	}

	public int getSlayerPoints() {
		return slayerPoints;
	}

	public void setSlayerPoints(int slayerPoints, boolean add) {
		if (add)
			this.slayerPoints += slayerPoints;
		else
			this.slayerPoints = slayerPoints;
	}

	public int getQuestPoints() {
		return questPoints;
	}

	public void setQuestPoints(int questPoints, boolean add) {
		if (add)
			this.questPoints += questPoints;
		else
			this.questPoints = questPoints;
	}

	public int getCommendations() {
		return this.commendations;
	}

	public void setCommendations(int commendations, boolean add) {
		if (add)
			this.commendations += commendations;
		else
			this.commendations = commendations;
	}

	public int getLoyaltyPoints() {
		return (int) this.loyaltyPoints;
	}

	public void setLoyaltyPoints(int points, boolean add) {
		if (add)
			this.loyaltyPoints += points;
		else
			this.loyaltyPoints = points;
	}

	public void incrementLoyaltyPoints(double amount) {
		this.loyaltyPoints += amount;
	}

	public int getPkPoints() {
		return this.pkPoints;
	}

	public void setPkPoints(int points, boolean add) {
		if (add)
			this.pkPoints += points;
		else
			this.pkPoints = points;
	}

	public int getDungeoneeringTokens() {
		return dungTokens;
	}

	public void setDungeoneeringTokens(int dungTokens, boolean add) {
		if (add)
			this.dungTokens += dungTokens;
		else
			this.dungTokens = dungTokens;
	}

	public int getEventPoints() {
		return eventpoints;
	}

	public void setEventPoints(int eventpoints) {
		this.eventpoints = eventpoints;
	}

	public void incrementEventPoints() {
		this.eventpoints++;
	}

	public void incrementEventPoints(int amt) {
		this.eventpoints += amt;
	}

	public void setEventPoints(int points, boolean add) {
		if (add)
			this.eventpoints += points;
		else
			this.eventpoints = points;
	}

	public int getVotingPoints() {
		return votingPoints;
	}

	public void setVotingPoints(int votingPoints) {
		this.votingPoints = votingPoints;
	}

	public void incrementVotingPoints() {
		this.votingPoints++;
	}

	public void incrementVotingPoints(int amt) {
		this.votingPoints += amt;
	}

	public void setVotingPoints(int points, boolean add) {
		if (add)
			this.votingPoints += points;
		else
			this.votingPoints = points;
	}

	public int getBossPoints() {
		return bosspoints;
	}

	public void setBossPoints(int bosspoints) {
		this.bosspoints = bosspoints;
	}

	public void incrementBossPoints() {
		this.bosspoints++;
	}

	public void incrementBossPoints(int amt) {
		this.bosspoints += amt;
	}

	public void setBossPoints(int points, boolean add) {
		if (add)
			this.bosspoints += points;
		else
			this.bosspoints = points;
	}

	public int getSPAWNKILLCount() {
		return spawnkillcount;
	}

	public void setSPAWNKILLCount(int spawnkillcount) {
		this.spawnkillcount = spawnkillcount;
	}

	public void incrementSPAWNKILLCount() {
		this.spawnkillcount++;
	}

	public void incrementSPAWNKILLCount(int amt) {
		this.spawnkillcount += amt;
	}

	public void setSPAWNKILLCount(int points, boolean add) {
		if (add)
			this.spawnkillcount += points;
		else
			this.spawnkillcount = points;
	}

	public int getLORDKILLCount() {
		return lordkillcount;
	}

	public void setLORDKILLCount(int lordkillcount) {
		this.lordkillcount = lordkillcount;
	}

	public void incrementLORDKILLCount() {
		this.lordkillcount++;
	}

	public void incrementLORDKILLCount(int amt) {
		this.lordkillcount += amt;
	}

	public void setLORDKILLCount(int points, boolean add) {
		if (add)
			this.lordkillcount += points;
		else
			this.lordkillcount = points;
	}

	public int getDEMONKILLCount() {
		return demonkillcount;
	}

	public void setDEMONKILLCount(int demonkillcount) {
		this.demonkillcount = demonkillcount;
	}

	public void incrementDEMONKILLCount() {
		this.demonkillcount++;
	}

	public void incrementDEMONKILLCount(int amt) {
		this.demonkillcount += amt;
	}

	public void setDEMONKILLCount(int points, boolean add) {
		if (add)
			this.demonkillcount += points;
		else
			this.demonkillcount = points;
	}

	public int getDRAGONKILLCount() {
		return dragonkillcount;
	}

	public void setDRAGONKILLCount(int dragonkillcount) {
		this.dragonkillcount = dragonkillcount;
	}

	public void incrementDRAGONKILLCount() {
		this.dragonkillcount++;
	}

	public void incrementDRAGONKILLCount(int amt) {
		this.dragonkillcount += amt;
	}

	public void setDRAGONKILLCount(int points, boolean add) {
		if (add)
			this.dragonkillcount += points;
		else
			this.dragonkillcount = points;
	}

	public int getSHILLINGRate() {
		return shillingrate;
	}
	
	private int globalRate;
	
	public int getGlobalRate() {
		return globalRate;
	}
	
	public void setGlobalRate(int rate) {
		this.globalRate = rate > 100 ? 100 : rate;
	}
	
	public void incrementGlobalRate(int rate) {
		this.globalRate += (this.globalRate + rate) > 100 ? 0 : rate;
	}
	
	public void decrementGlobalRate(int rate) {
		this.globalRate -= rate;
	}
private int slayerRate;
	
	public int getSlayerRate() {
		return slayerRate;
	}
	
	public void setSlayerRate(int rate) {
		this.slayerRate = rate > 100 ? 100 : rate;
	}
	
	public void incrementSlayerRate(int rate) {
		this.slayerRate += (this.slayerRate + rate) > 100 ? 0 : rate;
	}
	
	public void decrementSlayerRate(int rate) {
		this.slayerRate -= rate;
	}
private int pengRate;
	
	public int getPengRate() {
		return pengRate;
	}
	
	public void setPengRate(int rate) {
		this.pengRate = rate > 500000 ? 500000 : rate;
	}
	
	public void incrementPengRate(int rate) {
		this.pengRate += (this.pengRate + rate) > 500000 ? 0 : rate;
	}
	
	public void decrementPengRate(int rate) {
		this.pengRate -= rate;
	}
	public void setSHILLINGRate(int shillingrate) {
		this.shillingrate = shillingrate;
	}

	public void incrementSHILLINGRate() {
		this.shillingrate++;
	}

	public void incrementSHILLINGRate(int amt) {
		this.shillingrate += amt;
	}

	public void setSHILLINGRate(int points, boolean add) {
		if (add)
			this.shillingrate += points;
		else
			this.shillingrate = points;
	}

	public int getBEASTKILLCount() {
		return beastkillcount;
	}

	public void setBEASTKILLCount(int beastkillcount) {
		this.beastkillcount = beastkillcount;
	}

	public void incrementBEASTKILLCount() {
		this.beastkillcount++;
	}

	public void incrementBEASTKILLCount(int amt) {
		this.beastkillcount += amt;
	}

	public void setBEASTKILLCount(int points, boolean add) {
		if (add)
			this.beastkillcount += points;
		else
			this.beastkillcount = points;
	}

//
	public int getKINGKILLCount() {
		return kingkillcount;
	}

	public void setKINGKILLCount(int kingkillcount) {
		this.kingkillcount = kingkillcount;
	}

	public void incrementKINGKILLCount() {
		this.kingkillcount++;
	}

	public void incrementKINGKILLCount(int amt) {
		this.kingkillcount += amt;
	}

	public void setKINGKILLCount(int points, boolean add) {
		if (add)
			this.kingkillcount += points;
		else
			this.kingkillcount = points;
	}

	//
	public int getAVATARKILLCount() {
		return avatarkillcount;
	}

	public void setAVATARKILLCount(int avatarkillcount) {
		this.avatarkillcount = avatarkillcount;
	}

	public void incrementAVATARKILLCount() {
		this.avatarkillcount++;
	}

	public void incrementAVATARKILLCount(int amt) {
		this.avatarkillcount += amt;
	}

	public void setAVATARKILLCount(int points, boolean add) {
		if (add)
			this.avatarkillcount += points;
		else
			this.avatarkillcount = points;
	}

	//
	public int getANGELKILLCount() {
		return angelkillcount;
	}

	public void setANGELKILLCount(int angelkillcount) {
		this.angelkillcount = angelkillcount;
	}

	public void incrementANGELKILLCount() {
		this.angelkillcount++;
	}

	public void incrementANGELKILLCount(int amt) {
		this.angelkillcount += amt;
	}

	public void setANGELKILLCount(int points, boolean add) {
		if (add)
			this.angelkillcount += points;
		else
			this.angelkillcount = points;
	}

	//
	public int getLUCIENKILLCount() {
		return lucienkillcount;
	}

	public void setLUCIENKILLCount(int lucienkillcount) {
		this.lucienkillcount = lucienkillcount;
	}

	public void incrementLUCIENKILLCount() {
		this.lucienkillcount++;
	}

	public void incrementLUCIENKILLCount(int amt) {
		this.lucienkillcount += amt;
	}

	public void setLUCIENKILLCount(int points, boolean add) {
		if (add)
			this.lucienkillcount += points;
		else
			this.lucienkillcount = points;
	}

	//
	public int getHERCULESKILLCount() {
		return herculeskillcount;
	}

	public void setHERCULESKILLCount(int herculeskillcount) {
		this.herculeskillcount = herculeskillcount;
	}

	public void incrementHERCULESKILLCount() {
		this.herculeskillcount++;
	}

	public void incrementHERCULESKILLCount(int amt) {
		this.herculeskillcount += amt;
	}

	public void setHERCULESKILLCount(int points, boolean add) {
		if (add)
			this.herculeskillcount += points;
		else
			this.herculeskillcount = points;
	}

	//
	public int getSATANKILLCount() {
		return satankillcount;
	}

	public void setSATANKILLCount(int satankillcount) {
		this.satankillcount = satankillcount;
	}

	public void incrementSATANKILLCount() {
		this.satankillcount++;
	}

	public void incrementSATANKILLCount(int amt) {
		this.satankillcount += amt;
	}

	public void setSATANKILLCount(int points, boolean add) {
		if (add)
			this.satankillcount += points;
		else
			this.satankillcount = points;
	}

	//
	public int getZEUSKILLCount() {
		return zeuskillcount;
	}

	public void setZEUSKILLCount(int zeuskillcount) {
		this.zeuskillcount = zeuskillcount;
	}

	public void incrementZEUSKILLCount() {
		this.zeuskillcount++;
	}

	public void incrementZEUSKILLCount(int amt) {
		this.zeuskillcount += amt;
	}

	public void incrementMiniLuciferKillCount(int amt) {
		this.miniLuciferkillcount += amt;
	}

	public void incrementLuciferKillCount(int amt) {
		this.luciferkillcount += amt;
	}

	public void setZEUSKILLCount(int points, boolean add) {
		if (add)
			this.zeuskillcount += points;
		else
			this.zeuskillcount = points;
	}
	public int getMIDNIGHTKILLCount() {
		return midnightgoblinkillcount;
	}
	public void setMIDNIGHTKILLCount(int points, boolean add) {		if (add)
		this.midnightgoblinkillcount += points;
	else
		this.midnightgoblinkillcount = points;
	}
	public void incrementMIDNIGHTKILLCount() {
		this.midnightgoblinkillcount++;
	}

	public void incrementMIDNIGHTKILLCount(int amt) {
		this.midnightgoblinkillcount += amt;
	}

	//
	public int getBorkKC() {
		return borkKC;
	}

	public void addBorkKC(int amt) {
		this.borkKC += amt;
	}

	public void setBorkKC(int points, boolean add) {
		if (add)
			this.borkKC += points;
		else
			this.borkKC = points;
	}
	//
	public int getAvalonBeastBKC() {
		return avalonBeastKC;
	}

	public void addAvalonBeastKC(int amt) {
		this.avalonBeastKC += amt;
	}

	public void setAvalonBeastKC(int points, boolean add) {
		if (add)
			this.avalonBeastKC += points;
		else
			this.avalonBeastKC = points;
	}
	/*
	Archer Guild
	 */
	public int getForestArcherKC() {
		return forestArcherKC;
	}
	public void addForestArcherKC(int amt) {this.forestArcherKC += amt;}
	public void setForestArcherKC(int points, boolean add) {
		if (add)
			this.forestArcherKC += points;
		else
			this.forestArcherKC = points;
	}
	public int getChaoticArcherKC() {
		return chaoticArcherKC;
	}
	public void addChaoticArcherKC(int amt) {this.chaoticArcherKC += amt;}
	public void setChaoticArcherKC(int points, boolean add) {
		if (add)
			this.chaoticArcherKC += points;
		else
			this.chaoticArcherKC = points;
	}
	public int getStreamCount() {
		return streamCount;
	}
	public void addStreamCount(int amt) {this.streamCount += amt;}
	public void setStreamCount(int points, boolean add) {
		if (add)
			this.streamCount += points;
		else
			this.streamCount = points;
	}
	public int getDivineArcherKC() {
		return divineArcherKC;
	}
	public void addDivineArcherKC(int amt) {this.divineArcherKC += amt;}
	public void setDivineArcherKC(int points, boolean add) {
		if (add)
			this.divineArcherKC += points;
		else
			this.divineArcherKC = points;
	}
	/*
	End Archer Guild
	 */

	/*
	Start Warrior Guild
	 */
	public int getLesarkusWarriorKC() {
		return lesarkusWarriorKC;
	}
	public void addLesarkusWarriorKC(int amt) {this.lesarkusWarriorKC += amt;}
	public void setLesarkusWarriorKC(int points, boolean add) {
		if (add)
			this.lesarkusWarriorKC += points;
		else
			this.lesarkusWarriorKC = points;
	}
	public int getVampireWarriorKC() {
		return vampireWarriorKC;
	}
	public void addVampireWarriorKC(int amt) {this.vampireWarriorKC += amt;}
	public void setVampireWarriorKC(int points, boolean add) {
		if (add)
			this.vampireWarriorKC += points;
		else
			this.vampireWarriorKC = points;
	}
	public int getAncientWarriorKC() {
		return ancientWarriorKC;
	}
	public void addAncientWarriorKC(int amt) {this.ancientWarriorKC += amt;}
	public void setAncientWarriorKC(int points, boolean add) {
		if (add)
			this.ancientWarriorKC += points;
		else
			this.ancientWarriorKC = points;
	}
	/*
	End Warrior Guild
	 */


	/*
	Start Magic Guild
	 */
	public int getFacelessMagicianKC() {
		return facelessMagicianKC;
	}
	public void addFacelessMagicianKC(int amt) {this.facelessMagicianKC += amt;}
	public void setFacelessMagicianKC(int points, boolean add) {
		if (add)
			this.facelessMagicianKC += points;
		else
			this.facelessMagicianKC = points;
	}
	public int getLotusMagicianKC() {
		return lotusMagicianKC;
	}
	public void addLotusMagicianKC(int amt) {this.lotusMagicianKC += amt;}
	public void setLotusMagicianKC(int points, boolean add) {
		if (add)
			this.lotusMagicianKC += points;
		else
			this.lotusMagicianKC = points;
	}
	public int getShadowMagicianKC() {
		return shadowMagicianKC;
	}
	public void addShadowMagicianKC(int amt) {this.shadowMagicianKC += amt;}
	public void setShadowMagicianKC(int points, boolean add) {
		if (add)
			this.shadowMagicianKC += points;
		else
			this.shadowMagicianKC = points;
	}
	/*
	End Magic Guild
	 */
	//
	public int getGROUDONKILLCount() {
		return groudonkillcount;
	}

	public void setGROUDONKILLCount(int groudonkillcount) {
		this.groudonkillcount = groudonkillcount;
	}
	public void incrementGROUDONKILLCount() {
		this.groudonkillcount++;
	}

	public void incrementGROUDONKILLCount(int amt) {
		this.groudonkillcount += amt;
	}

	public void setGROUDONKILLCount(int points, boolean add) {
		if (add)
			this.groudonkillcount += points;
		else
			this.groudonkillcount = points;
	}
	//
	public int getFENRIRKILLCount() {
		return fenrirkillcount;
	}

	public void setFENRIRKILLCount(int fenrirkillcount) {
		this.fenrirkillcount = fenrirkillcount;
	}
	public void incrementFENRIRKILLCount() {
		this.fenrirkillcount++;
	}

	public void incrementFENRIRKILLCount(int amt) {
		this.fenrirkillcount += amt;
	}

	public void setFENRIRKILLCount(int points, boolean add) {
		if (add)
			this.fenrirkillcount += points;
		else
			this.fenrirkillcount = points;
	}

	public int getSlayerSpree() {
		return totalsprees;
	}

	public void setSlayerSpree(int totalsprees) {
		this.totalsprees = totalsprees;
	}

	public void incrementSlayerspree() {
		this.totalsprees++;
	}

	public void incrementSlayerSpree(int amt) {
		this.totalsprees += amt;
	}

	public void setSlayerSpree(int points, boolean add) {
		if (add)
			this.totalsprees += points;
		else
			this.totalsprees = points;
	}
	//
	public int getNPCKILLCount() {
		return npckillcount;
	}

	public void setNPCKILLCount(int npckillcount) {
		this.npckillcount = npckillcount;
	}

	public void incrementNPCKILLCount() {
		this.npckillcount++;
	}

	public void incrementNPCKILLCount(int amt) {
		this.npckillcount += amt;
	}
	public void incrementZombieRaidKC(int amt) {
		this.zombieRaidKC += amt;
	}
	public void incrementIslesKC(int amt) {
		this.islesKC += amt;
	}
	public void incrementTreasureHunterKC(int amt) {
		this.treasureHunter += amt;
	}
	public void incrementSufferingKC(int amt) {
		this.suffering += amt;
	}
	public void incrementNecromancerKC(int amt) {
		this.necromancer += amt;
	}

	public void incrementTelosKC(int amt) {
		this.telos += amt;
	}
	public int getZombieRaidKC() {
		return zombieRaidKC;
	}
	public int getIslesKC() {
		return islesKC;
	}
	public int getTreasureHunterKC() {
		return treasureHunter;
	}
	public int getSufferingKC() {
		return suffering;
	}
	public int getNecromancerKC() {
		return necromancer;
	}

	public int getTelosKC() {
		return telos;
	}
	public int getQuestOneDreamKC() {
		return questOneDreamKC;
	}

	public void incrementQuestOneDreamKC(int amt) {
		this.questOneDreamKC += amt;
	}

	public void setQuestOneDreamKC(int points, boolean add) {
		if (add)
			this.questOneDreamKC += points;
		else
			this.questOneDreamKC = points;
	}
	public void setZombieRaidsKC(int points, boolean add) {
		if (add)
			this.zombieRaidKC += points;
		else
			this.zombieRaidKC = points;
	}
	public void setSufferingKC(int points, boolean add) {
		if (add)
			this.suffering += points;
		else
			this.suffering = points;
	}
	public void setNecromancerKC(int points, boolean add) {
		if (add)
			this.necromancer += points;
		else
			this.necromancer = points;
	}
	public void setTelosKC(int points, boolean add) {
		if (add)
			this.telos += points;
		else
			this.telos = points;
	}
	public void setIslesKC(int points, boolean add) {
		if (add)
			this.islesKC += points;
		else
			this.islesKC = points;
	}
	public void setTreasureHunterKC(int points, boolean add) {
		if (add)
			this.treasureHunter += points;
		else
			this.treasureHunter = points;
	}
	public void setNPCKILLCount(int points, boolean add) {
		if (add)
			this.npckillcount += points;
		else
			this.npckillcount = points;
	}

	public int getUnknownCompleted() {
		return unknownCompleted;
	}

	public void setUnknownCompleted(int unknownCompleted) {
		this.unknownCompleted = unknownCompleted;
	}

	public void incrementUnknownCompleted() {
		this.unknownCompleted++;
	}

	public void incrementUnknownCompleted(int amt) {
		this.unknownCompleted += amt;
	}

	public void setUnknownCompleted(int points, boolean add) {
		if (add)
			this.unknownCompleted += points;
		else
			this.unknownCompleted = points;
	}
	public void setTotalPrestiges(int totalprestiges) {
		this.totalprestiges = totalprestiges;
	}

	public void incrementTotalprestiges() {
		this.totalprestiges++;
	}


	public int getTotalPrestiges() {
		return totalprestiges;
	}

	public void incrementTotalPrestiges(int amt) {
		this.totalprestiges += amt;
	}

	public void setTotalPrestiges(int points, boolean add) {
		if (add)
			this.totalprestiges += points;
		else
			this.totalprestiges = points;
	}
	
	

	public int getAchievementPoints() {
		return achievementPoints;
	}

	public void setAchievementPoints(int points, boolean add) {
		if (add)
			this.achievementPoints += points;
		else
			this.achievementPoints = points;
	}

	public void incrementAchievementPoints(double amount) {
		this.achievementPoints += amount;
	}

	public int getSkillingPoints() {
		return skillingPoints;
	}

	public void setSkillingPoints(int points, boolean add) {
		if (add)
			this.skillingPoints += points;
		else
			this.skillingPoints = points;
	}

	public int getMiniLuciferkillcount() {
		return miniLuciferkillcount;
	}

	public void setMiniLuciferkillcount(int miniLuciferkillcount) {
		this.miniLuciferkillcount = miniLuciferkillcount;
	}

	public void incrementMiniLuciferkillcount() {
		this.miniLuciferkillcount++;
	}

	public int getLuciferkillcount() {
		return luciferkillcount;
	}
	public void setLuciferkillcount(int luciferkillcount) {
		this.luciferkillcount = luciferkillcount;
	}

	public int getMG1Count() {
		return minigame1count;
	}

	public void setMG1Count(int minigame1count) {
		this.minigame1count = minigame1count;
	}

	public void incrementMG1Count() {
		this.minigame1count++;
	}

	public void incrementMG1Count(int amt) {
		this.minigame1count += amt;
	}

	public void setMG1Count(int points, boolean add) {
		if (add)
			this.minigame1count += points;
		else
			this.minigame1count = points;
	}


	public int getMG2Count() {
		return minigame2count;
	}

	public void setMG2Count(int minigame2count) {
		this.minigame2count = minigame2count;
	}

	public void incrementMG2Count() {
		this.minigame2count++;
	}

	public void incrementMG2Count(int amt) {
		this.minigame2count += amt;
	}

	public void setMG2Count(int points, boolean add) {
		if (add)
			this.minigame2count += points;
		else
			this.minigame2count = points;
	}


	public int getMG3Count() {
		return minigame3count;
	}

	public void setMG3Count(int minigame3count) {
		this.minigame3count = minigame3count;
	}

	public void incrementMG3Count() {
		this.minigame3count++;
	}

	public void incrementMG3Count(int amt) {
		this.minigame3count += amt;
	}

	public void setMG3Count(int points, boolean add) {
		if (add)
			this.minigame3count += points;
		else
			this.minigame3count = points;
	}

}
