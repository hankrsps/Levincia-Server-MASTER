package com.ruse.world.content.teleport;

import com.ruse.model.Item;
import com.ruse.model.PlayerRights;
import com.ruse.model.Position;
import com.ruse.model.definitions.ItemDefinition;
import com.ruse.model.definitions.NpcDefinition;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.seasonpass.SeasonPass;
import com.ruse.world.content.transportation.TeleportHandler;
import com.ruse.world.content.transportation.TeleportType;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;

import static com.ruse.world.content.progressionzone.ProgressionZone.getCurrentZone;

/**
 * @author Snz
 * @date 2020
 */
public class TeleportInterfaceHandler {

	/**
	 * idk why the fuck that was protected lmfao
	 **/
	private Player player;

	public TeleportInterfaceHandler(Player player) {
		this.player = player;
	}

	/* This cache's enum values to prevent it from constantly using arraysOnCopy */
	public final TeleportData data[] = TeleportData.values();

	public void open() {
		player.getPacketSender().resetItemsOnInterface(28229 + 20, 20);
		switchTab(28215);
		player.getPA().sendInterface(28200);
		if (player.getTeleportData() == null) {
			player.setTeleportType(TeleportCategory.MONSTERS);
			player.getPA().sendString(28205, "Monsters");
			sendItemsOnInterface(TeleportData.MINOTAUR);
			player.setCurrentTeleport(TeleportData.MINOTAUR);
			switchData();
			player.getPacketSender().sendString(60000 + 50, "Tier: 1");
			player.getPacketSender().sendString(64112, "Health: @whi@" + "2,500");
			player.getPacketSender().sendString(60000 + 54, "Max hit: @whi@"+ "10");
		}
	}

	public void quickOpenZones() {
		player.getPacketSender().resetItemsOnInterface(28229 + 20, 20);
		switchTab(28215);
		player.getPA().sendInterface(28200);
		if (player.getTeleportData() == null) {
			player.setTeleportType(TeleportCategory.ZONES);
			player.getPA().sendString(28205, "Zones");
			sendItemsOnInterface(TeleportData.DUST_CLAW);
			player.setCurrentTeleport(TeleportData.DUST_CLAW);
			switchData();
			player.getPacketSender().sendString(60000 + 50, "Tier: 1");
			player.getPacketSender().sendString(64112, "Health: @whi@" + "4,000");
			player.getPacketSender().sendString(60000 + 54, "Max hit: @whi@"+ "10");
		}
	}

	public void open(TeleportCategory type) {
		player.setTeleportType(type);
		switchTab(28215);
		player.getPA().sendInterface(28200);
	}

	public void switchTab(int buttonid) {
		switch (buttonid) {
			case 28215:
				player.setTeleportType(TeleportCategory.MONSTERS);
				switchData();
				player.getPA().sendString(28205, "Monsters");
				break;
			case 28216:
				player.setTeleportType(TeleportCategory.BOSSES);
				switchData();
				player.getPA().sendString(28205, "Bosses");
				break;
			case 28217:
				player.setTeleportType(TeleportCategory.MINIGAMES);
				switchData();
				player.getPA().sendString(28205, "Minigames");
				break;
			case 28218:
				player.setTeleportType(TeleportCategory.DUNGEONS);
				switchData();
				player.getPA().sendString(28205, "Dungeons");
				break;
			case 28219:
				player.setTeleportType(TeleportCategory.ZONES);
				switchData();
				player.getPA().sendString(28205, "Zones");
				break;
			case 28220:
				player.setTeleportType(TeleportCategory.GLOBALS);
				switchData();
				player.getPA().sendString(28205, "Globals");
				break;
			default:
				break;
		}
	}

	public void switchData() {
		int count = 28307;
		for (int i = 28307; i < 28382; i++) {
			player.getPA().sendString(i, "");
		}
		for (TeleportData data : data) {
			if (data.getType() == player.getTeleportType()) {
				player.getPA().sendString(count++, data.getName());
			}
		}
	}


	public void sendItemsOnInterface(TeleportData data1) {
		player.getPA().sendScrollableItemsOnInterface(28229, data1.getItems());
	}

	public void button(int buttonId) {
		for (TeleportData data : data) {
			if (data.getType() == player.getTeleportType()) {
				if (buttonId == data.getTextButtonId() || buttonId == data.getBackgroundButtonId()) {
					player.setCurrentTeleport(data);
					sendItemsOnInterface(data);
					if (!data.getName().isEmpty()) {
						player.getPA().sendString(28209, data.getName());
					} else {
						player.getPA().sendString(28209, data.getName());
					}
					//player.getPA().sendString(64112, data.getDescription());
					player.getPA().sendString(64113, data.getReq1());
					player.getPA().sendString(64114, data.getReq2());
					player.getPacketSender().sendString(64112, "Health: @whi@"+
							Misc.insertCommasToNumber(NpcDefinition.forId(data.getNpcId()).getHitpoints()));
					player.getPacketSender().sendString(60000 + 50, "Tier: " + data.getTier());
					player.getPacketSender().sendString(60000 + 54, "Max hit: @whi@"+
							Misc.insertCommasToNumber(NpcDefinition.forId(data.getNpcId()).getMaxHit()));

					player.getPA().sendNpcOnInterface(28214, data.getNpcId(), data.getAdjustedZoom());
					System.err.println("" + data.getNpcId());
				}
			}
		}
	}

	public void teleport() {
		if (player.getCurrentTeleport() == null) {
			player.getPA().sendMessage("Please select a teleport destination first!");
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == 9001) {
			TeleportHandler.teleportPlayer(player, getCurrentZone(player).getCoords(), TeleportType.NORMAL);
			player.sendMessage("You have been teleported to the " + getCurrentZone(player).getName() + " Zone.");
			player.sendMessage("@blu@Once you completed the zone, you will be teleported to the next phase!");
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == 9024) {
			player.hov.initArea();
			player.hov.start();
			player.getPacketSender().sendInterfaceRemoval();
			return;
		}
		if (player.getCurrentTeleport().getNpcId() == 9813) {
			if (player.getRights() == PlayerRights.OWNER)
				player.sendMessage("Being an Owner nullifies the teleport requirements.");
			if (player.getPointsHandler().getMIDNIGHTKILLCount() >= 10_000 || player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			}
			else
				player.sendMessage("@red@You need 10k Midnight Goblin kills to go here!");
			return;
		}
		if (player.getCurrentTeleport().getNpcId() == 587) {
			if (player.getRights() == PlayerRights.OWNER)
				player.sendMessage("Being an Owner nullifies the teleport requirements.");
			if (player.getGameMode().isIronman() || player.getRights() == PlayerRights.OWNER|| player.getRights() == PlayerRights.YOUTUBER) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			}
			else
				player.sendMessage("@red@This boss is Ironman only!");
			return;
		}
		if (player.getCurrentTeleport().getNpcId() == 9318) {
			if (player.getRights() == PlayerRights.OWNER)
				player.sendMessage("Being an Owner nullifies the teleport requirements.");
			if (player.getRights() == PlayerRights.OWNER || player.getAmountDonated() >= 1000|| player.getRights() == PlayerRights.YOUTUBER) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			}
			else
				player.sendMessage("You need to be an Onyx donator to go here.");
			return;
		}
		if (player.getCurrentTeleport().getNpcId() == 9319) {
			if (player.getRights() == PlayerRights.OWNER)
				player.sendMessage("Being an Owner nullifies the teleport requirements.");
			if (player.getRights() == PlayerRights.OWNER || player.getAmountDonated() >= 5000|| player.getRights() == PlayerRights.YOUTUBER) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			}
			else
				player.sendMessage("You need to be an Zenyte Donator to go here.");
			return;
		}
		if (player.getCurrentTeleport().getNpcId() == 10034) {
			if (player.getRights() == PlayerRights.OWNER)
				player.sendMessage("Being an Owner nullifies the teleport requirements.");
			if (player.getRights() == PlayerRights.OWNER || player.getAmountDonated() >= 20000|| player.getRights() == PlayerRights.YOUTUBER) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			}
			else
				player.sendMessage("You need to be an Platinum Donator to go here.");
			return;
		}
		if (player.getCurrentTeleport().getNpcId() == 9116) {

			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Being an Owner nullifies the teleport requirements.");
				player.setMagicGuildTier1(true);
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
				}
				if (!player.getMagicGuildTier1()) {
					player.magicGuildUnlock.openMain();
					return;
				} else if (player.getMagicGuildTier1()) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
				player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return; }
		}
		if (player.getCurrentTeleport().getNpcId() == 277) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.setWarriorGuildTier1(true);
				player.sendMessage("Being an Owner nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			}
			if (!player.getWarriorGuildTier1()) {
				player.warriorGuildUnlock.openMain();
				return;
			} else if (player.getWarriorGuildTier1()) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return; }
		}
		if (player.getCurrentTeleport().getNpcId() == 1458) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.setArcherGuildTier1(true);
				player.sendMessage("Being an Owner nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			}
			if (!player.getArcherGuildTier1()) {
				player.archerGuildUnlock.openMain();
				return;
			} else if (player.getArcherGuildTier1()) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return; }
		}


		if (player.getCurrentTeleport().getNpcId() == TeleportData.DUST_CLAW.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.getPointsHandler().getNPCKILLCount() <= 49){
				player.getPacketSender().sendMessage("You need 50 npc kill Count. You currently have @red@"
						+ player.getPointsHandler().getNPCKILLCount() + "@bla@ kills.");
				player.getPacketSender().sendMessage("@blu@To get Fast NPC KILLS go to ::Starter");
				return;
			}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == TeleportData.ICE_NIHIL.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.getPointsHandler().getBorkKC() <= 74999){
				player.getPacketSender().sendMessage("You need 75,000 Bork kill Count. You currently have @red@"
						+ player.getPointsHandler().getBorkKC() + "@bla@ kills.");
				return;
			}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == TeleportData.LORD_TELEPORT.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else  if (player.getPointsHandler().getSPAWNKILLCount() <= 99) {
				player.getPacketSender().sendMessage("You need 100 Dustclaw kills. You currently have @red@"
						+ player.getPointsHandler().getSPAWNKILLCount() + "@bla@ kills.");
				return;
			}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == TeleportData.SHADOW_HUNTER.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else  if (player.getPointsHandler().getLORDKILLCount() <= 199) {
				player.getPacketSender().sendMessage("You need 200 Lord kills. You currently have @red@"
						+ player.getPointsHandler().getLORDKILLCount() + "@bla@ kills.");
				return;
			}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
		}


		if (player.getCurrentTeleport().getNpcId() == TeleportData.JOYX_GOLEM.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
			player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.getPointsHandler().getDEMONKILLCount() <= 299) {
				player.getPacketSender().sendMessage("You need 300 Shadow kills. You currently have @red@"
						+ player.getPointsHandler().getDEMONKILLCount() + "@bla@ kills.");
				return;
			}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == TeleportData.SHETANI.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.getPointsHandler().getDRAGONKILLCount() <= 399) {
				player.getPacketSender().sendMessage("You need 400 Golem kills. You currently have @red@"
						+ player.getPointsHandler().getDRAGONKILLCount() + "@bla@ kills.");
				return;
			}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == TeleportData.RIPPER.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.getPointsHandler().getBEASTKILLCount() <= 499) {
				player.getPacketSender().sendMessage("You need 500 Shetani kills. You currently have @red@"
						+ player.getPointsHandler().getBEASTKILLCount() + "@bla@ kills.");
				return;
			}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == TeleportData.AVATAR_TITAN.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.getPointsHandler().getKINGKILLCount() <= 999) {
				player.getPacketSender().sendMessage("You need 1,000 Ripper kills. You currently have @red@"
						+ player.getPointsHandler().getKINGKILLCount() + "@bla@ kills.");
				return;
			}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == TeleportData.WYVERNS.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.getPointsHandler().getAVATARKILLCount() <= 1199) {
				player.getPacketSender().sendMessage("You need 1,200 Avatar kills. You currently have @red@"
						+ player.getPointsHandler().getAVATARKILLCount() + "@bla@ kills.");
				return;
			}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == TeleportData.ONI.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.getPointsHandler().getANGELKILLCount() <= 1499) {
				player.getPacketSender().sendMessage("You need 1,500 Wyvern kills. You currently have @red@"
						+ player.getPointsHandler().getANGELKILLCount() + "@bla@ kills.");
				return;
			}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == TeleportData.SHENRON.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.getPointsHandler().getLUCIENKILLCount() <= 2499) {
				player.getPacketSender().sendMessage("You need 2,500 Oni kills. You currently have @red@"
						+ player.getPointsHandler().getLUCIENKILLCount() + "@bla@ kills.");
				return;
			}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == TeleportData.SUBZERO.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.getPointsHandler().getHERCULESKILLCount() <= 3499) {
				player.getPacketSender().sendMessage("You need 3,500 Shenron kills. You currently have @red@"
						+ player.getPointsHandler().getHERCULESKILLCount() + "@bla@ kills.");
				return;
			}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == TeleportData.ZEUS.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.getPointsHandler().getSATANKILLCount() <= 4999) {
				player.getPacketSender().sendMessage("You need 5,000 Subzero kills. You currently have @red@"
						+ player.getPointsHandler().getSATANKILLCount() + "@bla@ kills.");
				return;
			}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
		}


		if (player.getCurrentTeleport().getNpcId() == TeleportData.DIMINISHER.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.isDiminisher ()) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (!player.isDiminisher () && !player.getInventory ().contains (23759, 1000) && !player.getInventory().contains (12855, 25000000)
					&& !player.getInventory().contains (16465, 500)) {
				player.getPacketSender().sendMessage("@red@You need to sacrifice x1,000 Crimson flakes, x500 Diminished shards, and 25M Levincia tokens.");
				return;
			}
			else if (!player.isDiminisher () && player.getInventory ().contains (23759, 1000) && player.getInventory().contains (12855, 25000000)
					&& player.getInventory().contains (16465, 500)) {
				player.getInventory().delete (23759, 1000);
				player.getInventory().delete (12855, 25000000);
				player.getInventory().delete (16465, 500);
				player.setDiminisher(true);
			}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == TeleportData.IPOTANE.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.getPointsHandler().getZEUSKILLCount() <= 14999) {
				player.getPacketSender().sendMessage("You need 15,000 Zeus kills. You currently have @red@"
						+ player.getPointsHandler().getZEUSKILLCount() + "@bla@ kills.");
				return;
			}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == TeleportData.VINDICTA.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.getPointsHandler().getGROUDONKILLCount() <= 24999) {
				player.getPacketSender().sendMessage("You need 25,000 Ipotane kills. You currently have @red@"
						+ player.getPointsHandler().getGROUDONKILLCount() + "@bla@ kills.");
				return;
			}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == TeleportData.BORK.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.getPointsHandler().getFENRIRKILLCount() <= 49999) {
				player.getPacketSender().sendMessage("You need 50,000 Vindicta kills. You currently have @red@"
						+ player.getPointsHandler().getFENRIRKILLCount() + "@bla@ kills.");
				return;
			}
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			return;
		}

		if (player.getCurrentTeleport().getNpcId() == TeleportData.SEASON_PASS.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.getSeasonPass().getTier() == 50 && player.isunlockedseasonpass()) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.getSeasonPass().getTier() < 50) {
					player.sendMessage("You need to have completed the season " + SeasonPass.SEASON + " gold pass to do this.");
					return;
				}
		}
		if (player.getCurrentTeleport().getNpcId() == TeleportData.FALLEN_WARRIOR.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.getFallenWarrior() == true) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
					return;
				} else if (player.getFallenWarrior() == false) {
				Item[] requirements = new Item[]{new Item(ItemDefinition.UPGRADE_TOKEN_ID, 25_000_000), new Item(20400, 1),
						new Item(18823, 3), new Item(19888, 3)};
				if (player.getInventory().containsAll(requirements)) {
					player.getInventory().deleteItemSet(requirements);
					player.setFallenWarrior(true);
					player.sendMessage("@red@Congratulations, you have unlocked Fallen Warrior's zone!");
				} else {
					player.sendMessage("You do not have the requirements to unlock Fallen Warriors!");
					player.sendMessage("You need 25m tokens, an enraged cape + 3 coll rings II, 3 colls necks II to sacrifice!!");
					player.sendMessage("@red@Try again with these items in your inventory!");
					return;
				}
			}
		}

		if (player.getCurrentTeleport().getNpcId() == TeleportData.MIDNIGHT_GOBLIN.getNpcId()) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				player.sendMessage("Your rank nullifies the teleport requirements.");
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.isUnlockedDarkSupreme() == true) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				return;
			} else if (player.isUnlockedDarkSupreme() == false) {
				Item[] requirements = new Item[]{ new Item(5011, 1), new Item(12537, 1), new Item(17013, 1)};
				if (player.getInventory().containsAll(requirements)) {
					player.getInventory().deleteItemSet(requirements);
					player.setUnlockedDarkSupreme(true);
					player.sendMessage("@red@Congratulations, you have unlocked Midnight Goblin's zone!");
				} else {
					player.sendMessage(""); player.sendMessage("You do not have the requirements to unlock Midnight Goblins!");
					player.sendMessage("You need to sacrifice a Legends Light bow, scythe, and staff!");
					player.sendMessage("@red@Try again with these items in your inventory!");
					return;
				}
			}
		}

		if (player.getCurrentTeleport().getNpcId() == TeleportData.DONATION_BOSS.getNpcId()) {
			int roll = Misc.getRandom(3);
			if (roll == 0) {
				Position position = new Position(2656, 3812, 0);
				TeleportHandler.teleportPlayer(player, position, TeleportType.NORMAL);
				System.out.println("Rolled : 0");
			}
			else if (roll == 1) {
				Position position = new Position(2656, 3794, 0);
				TeleportHandler.teleportPlayer(player, position, TeleportType.NORMAL);
				System.out.println("Rolled : 1");
			}
			else if (roll == 2) {
				Position position = new Position(2667, 3805, 0);
				TeleportHandler.teleportPlayer(player, position, TeleportType.NORMAL);
				System.out.println("Rolled : 2");
			}
			else {
				Position position = new Position(2645, 3805, 0);
				TeleportHandler.teleportPlayer(player, position, TeleportType.NORMAL);
				System.out.println("Rolled : 3");
			}
		}
/*
		if (player.getCurrentTeleport().getNpcId() == 9106) {
			if (player.getRights() == PlayerRights.OWNER)
				player.sendMessage("Being an Owner nullifies the teleport requirements.");
			if ((player.getPointsHandler().getZombieRaidKC() >= 100 || player.getRights() == PlayerRights.OWNER)) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
			} else {
				player.sendMessage("You need to have completed x 100 Legend raids to teleport here!");
			}
			return;
		}*/

		if (player.getCurrentTeleport().getNpcId() == 9012) {
			if (player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER)
				player.sendMessage("Your rank nullifies the teleport requirements.");
			if (player.getPointsHandler().getMiniLuciferkillcount() >= 10_000 || player.getRights() == PlayerRights.OWNER || player.getRights() == PlayerRights.YOUTUBER) {
				TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
						player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
				boolean contains = false;
				for (NPC others : World.getNpcs()) {
					if (others == null) {
						continue;
					}

					if (others.getId() == 9012 && others.getPosition().getRegionId() == 7760 &&
							others.getPosition().getZ() == (player.getIndex() * 4)) {
						contains = true;
					}
				}
				if (!contains) {
					NPC npc_ = new NPC(9012, new Position(1952, 5146, player.getIndex() * 4));
					npc_.setSpawnedFor(player);
					World.register(npc_);
				}
			} else {
				player.sendMessage("You need to have killed 10k Fallen Warriors to go here.");
			}
			return;
		}

		if (player.getCurrentTeleport() != null) {
			TeleportHandler.teleportPlayer(player, new Position(player.getCurrentTeleport().getPosition().getX(),
					player.getCurrentTeleport().getPosition().getY(), player.getCurrentTeleport().getPosition().getZ()), TeleportType.NORMAL);
		} else {
			if (player.getCurrentTeleport() == null)
			player.getPA().sendMessage("Please select a teleport destination first!");
		}
	}
}