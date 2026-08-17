package com.ruse.world.content.skill.impl.woodcutting;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Animation;
import com.ruse.model.GameObject;
import com.ruse.model.Skill;
import com.ruse.model.container.impl.Equipment;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.CustomObjects;
import com.ruse.world.content.Sounds;
import com.ruse.world.content.Sounds.Sound;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.content.afk.AfkSystem;
import com.ruse.world.content.casketopening.Box;
import com.ruse.world.content.casketopening.CasketOpening;
import com.ruse.world.content.skill.impl.firemaking.Logdata;
import com.ruse.world.content.skill.impl.firemaking.Logdata.logData;
import com.ruse.world.content.skill.impl.woodcutting.WoodcuttingData.Hatchet;
import com.ruse.world.content.skill.impl.woodcutting.WoodcuttingData.Trees;
import com.ruse.world.entity.impl.player.Player;

public class Woodcutting {
	public static Box[] afktree = new Box[]{
			new Box(5022, 1, 2, 100),  //Pvm tickets
			new Box(5022, 3, 4, 75),  //Pvm tickets
			new Box(5020, 1, 2, 100),  //Afk tickets
			new Box(5020, 3, 4, 70),  //Afk tickets
			new Box(ItemDefinition.UPGRADE_TOKEN_ID, 2, 4, 100),  //Orbs
			new Box(ItemDefinition.UPGRADE_TOKEN_ID, 4, 6, 60),  //Orbs
			new Box(6199, 1, 0.4D),  //mystery box
			new Box(7956, 1, 0.3D),  //PvM Box
			new Box(19116, 0.05D), //Super mbox
			new Box(15003, 0.001D), //Azure casket
	};
	public static void chopAFKtree(Player player, int objectId, int tier) {
		player.getSkillManager().stopSkilling();
		player.getPacketSender().sendInterfaceRemoval();
		if (!player.getClickDelay().elapsed(2000))
			return;
		if (player.getInventory().getFreeSlots() <= 0) {
			player.getPacketSender().sendMessage("You need some more inventory space to do this.");
			return;
		}
		if (player.busy() || player.getCombatBuilder().isBeingAttacked() || player.getCombatBuilder().isAttacking()) {
			player.getPacketSender().sendMessage("You cannot do that right now.");
			return;
		}


		int accounts = 1;
		for (Player p : World.getPlayers()) {
			if (p == null)
				continue;
			if (!player.equals(p) && player.getHostAddress().equals(p.getHostAddress())) {
				if (p.getInteractingObject() != null && (p.getInteractingObject().getId() == 52601
						|| p.getInteractingObject().getId() == 53654 || p.getInteractingObject().getId() == 30035)) {
					accounts++;
					continue;
				}
			}
		}
		if (accounts > 2){
			player.getPacketSender().sendMessage("You already have two accounts afk.");
			return;
		}

		player.setCurrentTask(new Task(4, player, true) {

			@Override
			public void execute() {
				if (player.getInventory().getFreeSlots() <= 0) {
					player.getPacketSender().sendMessage("You do not have any free inventory space left.");
					this.stop();
					return;
				}

				final Hatchet axe = Hatchet.forId(WoodcuttingData.getHatchet(player));
				if (axe != null) {
					player.performAnimation(new Animation(axe.getAnim()));
					Box[] loot = afktree;
					if (tier == 1) {
						player.setAfkTree(player.getAfkTree() + 1);
					}
					Box reward = CasketOpening.getLoot(loot);
					player.getInventory().add(reward.getId(), reward.getMin() + Misc.getRandom(reward.getMax() - reward.getMin()));
					AfkSystem.burnedSouls++;
					player.getInventory().refreshItems();
					player.getClickDelay().reset();
					return;
				} else
					this.stop();
				player.getPacketSender().sendMessage("You don't have a hatchet to chop this tree with.");
			}

			@Override
			public void stop() {
				setEventRunning(false);
				player.performAnimation(new Animation(65535));
			}
		});
		TaskManager.submit(player.getCurrentTask());
	}
	public static void cutWood(final Player player, final GameObject object, boolean restarting) {
		if (!restarting)
			player.getSkillManager().stopSkilling();
		if (player.getInventory().getFreeSlots() == 0) {
			player.getPacketSender().sendMessage("You don't have enough free inventory space.");
			return;
		}
		player.setPositionToFace(object.getPosition());
		final int objId = object.getId();
		final Hatchet h = Hatchet.forId(WoodcuttingData.getHatchet(player));
		if (h != null) {
			if (player.getSkillManager().getCurrentLevel(Skill.WOODCUTTING) >= h.getRequiredLevel()) {
				final Trees t = Trees.forId(objId);
				if (t != null) {
					player.setEntityInteraction(object);
					if (player.getSkillManager().getCurrentLevel(
							Skill.WOODCUTTING) >= (t.getReq())) {
						player.performAnimation(new Animation(h.getAnim()));
						int delay = Misc.getRandom(t.getTicks() - WoodcuttingData.getChopTimer(player, h)) + 1;
						player.setCurrentTask(new Task(1, player, false) {
							int cycle = 0, reqCycle = delay >= 2 ? delay : Misc.getRandom(1) + 1;

							@Override
							public void execute() {
								if (player.getInventory().getFreeSlots() == 0) {
									player.performAnimation(new Animation(65535));
									player.getPacketSender().sendMessage("You don't have enough free inventory space.");
									this.stop();
									return;
								}
								if (cycle != reqCycle) {
									cycle++;
									player.performAnimation(new Animation(h.getAnim()));
								} else if (cycle >= reqCycle) {
									int xp =  t.getXp();
									if (lumberJack(player))
										xp *= 1.5;
									player.getSkillManager().addExperience(Skill.WOODCUTTING, (int) (xp));
									cycle = 0;
									//BirdNests.dropNest(player); //Disabled bird nests
									this.stop();
									int cutDownRandom = Misc.getRandom(100);
									// player.getPacketSender().sendMessage("Random: " + cutDownRandom);
									if (!t.isMulti()
											|| (player.getSkillManager().skillCape(Skill.WOODCUTTING)
											&& cutDownRandom >= 88)
											|| (!player.getSkillManager().skillCape(Skill.WOODCUTTING)
											&& cutDownRandom >= 82)) {// 82
										// player.getPacketSender().sendMessage("You rolled a: "+cutDownRandom);
										player.getInventory().add(t.getReward(), 1);
										treeRespawn(player, object);
										player.getPacketSender().sendMessage("You've chopped the tree down.");
										player.getAchievementTracker().progress(AchievementData.WOODCUTTING, 1);
										player.getAchievementTracker().progress(AchievementData.WOODCUT_ALOT, 1);
										player.performAnimation(new Animation(65535));
									} else { // if they didn't cut down the tree
										cutWood(player, object, true);
										if (player.getSkillManager().skillCape(Skill.WOODCUTTING) && cutDownRandom >= 82
												&& cutDownRandom < 87) {
											player.getPacketSender().sendMessage(
													"Your cape helps keep the tree alive a little longer.");
										}
										if (infernoAdze(player)) { // if they do not have an adze equipped
											if (Misc.getRandom(10) <= 6) {
												logData fmLog = Logdata.getLogData(player, t.getReward());
												if (fmLog != null) { // if their their logdata is not null...
													player.getSkillManager().addExperience(Skill.FIREMAKING,
															fmLog.getXp());
													player.getPacketSender().sendMessage(
															"You chop a log, and your Inferno Adze burns it into ash.");
												} else { // if the fmLog data is null
													player.getPacketSender().sendMessage(
															"<col=b40404>The game thinks you have an adze, but are burning nothing.")
															.sendMessage(
																	"<col=b40404>Please contact Crimson and report this bug.");
												}
											} else {

												player.getInventory().add(t.getReward(), 1);
												player.getPacketSender().sendMessage("You get some logs...");

											}
										} else { // if they player doesn't have an adze, do this.
											player.getInventory().add(t.getReward(), 1);
											player.getPacketSender().sendMessage("You get some logs...");
										}
									}
									Sounds.sendSound(player, Sound.WOODCUT);

								}
							}
						});
						TaskManager.submit(player.getCurrentTask());
					} else {
						player.getPacketSender().sendMessage(
								"You need a Woodcutting level of at least " + t.getReq() + " to cut this tree.");
					}
				}
			} else {
				player.getPacketSender()
						.sendMessage("You do not have a hatchet which you have the required Woodcutting level to use.");
			}
		} else {
			player.getPacketSender().sendMessage("You do not have a hatchet that you can use.");
		}
	}

	public static boolean lumberJack(Player player) {
		return player.getEquipment().get(Equipment.HEAD_SLOT).getId() == 10941
				&& player.getEquipment().get(Equipment.BODY_SLOT).getId() == 10939
				&& player.getEquipment().get(Equipment.LEG_SLOT).getId() == 10940
				&& player.getEquipment().get(Equipment.FEET_SLOT).getId() == 10933;
	}

	public static boolean infernoAdze(Player player) {
		return player.getEquipment().get(Equipment.WEAPON_SLOT).getId() == 13661;
	}

	public static void treeRespawn(final Player player, final GameObject oldTree) {
		if (oldTree == null || oldTree.getPickAmount() >= 10)
			return;
		oldTree.setPickAmount(10);
		for (Player players : player.getLocalPlayers()) {
			if (players == null)
				continue;
			if (players.getInteractingObject() != null && players.getInteractingObject().getPosition()
					.equals(player.getInteractingObject().getPosition().copy())) {
				players.getSkillManager().stopSkilling();
				players.getPacketSender().sendClientRightClickRemoval();
			}
		}
		player.getPacketSender().sendClientRightClickRemoval();
		player.getSkillManager().stopSkilling();
		CustomObjects.globalObjectRespawnTask(new GameObject(1343, oldTree.getPosition().copy(), 10, 0), oldTree,
				20 + Misc.getRandom(10));
	}

}
