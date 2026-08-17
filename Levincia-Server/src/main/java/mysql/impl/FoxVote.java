package mysql.impl; // dont forget to change packaging ^-^

import com.ruse.GameSettings;
import com.ruse.motivote3.doMotivote;
import com.ruse.util.Misc;
import com.ruse.world.World;
import com.ruse.world.content.Cases;
import com.ruse.world.content.PlayerLogs;
import com.ruse.world.content.VoteBossDrop;
import com.ruse.world.content.achievements.AchievementData;
import com.ruse.world.entity.impl.player.Player;

import java.sql.*;
import java.util.Calendar;

public class FoxVote implements Runnable {

	private static int voteCount = 0;
    public static final String HOST = "184.105.7.128";
    public static final String USER = "levisnsm_root";
    public static final String PASS = "ilysm123!@#";
    public static final String DATABASE = "levisnsm_store";

	private Player player;
	private Connection conn;
	private Statement stmt;

	public FoxVote(Player player) {
		this.player = player;
	}

	@Override
	public void run() {
		try {
			if (!connect(HOST, DATABASE, USER, PASS)) {
				System.out.println("The connection to the voting database has failed!");
				return;
			}

			String name = player.getUsername();
			ResultSet rs = executeQuery("SELECT * FROM fx_votes WHERE username='"+name+
					"' AND claimed=0 AND callback_date IS NOT NULL");
			int amount = 0;

			while (rs.next()) {
				String ipAddress = rs.getString("ip_address");
				int siteId = rs.getInt("site_id");
				amount+= 2;

				rs.updateInt("claimed", 1); // do not delete otherwise they can reclaim!
				rs.updateRow();
			}

			name = player.getUsername().replace(" ", "_");
			rs = executeQuery("SELECT * FROM fx_votes WHERE username='" + name + "' AND claimed=0");

			while (rs.next()) {
				String ipAddress = rs.getString("ip_address");
				int siteId = rs.getInt("site_id");
				amount+= 2;


				rs.updateInt("claimed", 1); // do not delete otherwise they can reclaim!
				rs.updateRow();
			}


			name = player.getUsername().replace(" ", "+");
			rs = executeQuery("SELECT * FROM fx_votes WHERE username='" + name + "' AND claimed=0");

			while (rs.next()) {
				String ipAddress = rs.getString("ip_address");
				int siteId = rs.getInt("site_id");
				amount+= 2;


				rs.updateInt("claimed", 1); // do not delete otherwise they can reclaim!
				rs.updateRow();
			}

			if (amount > 0) {
				if (amount >= 100){
					World.sendStaffMessage("<col=FF0066><img=2> [VOTE ABUSE]<col=6600FF> " + player.getUsername()
							+ " tried to claim @red@" + amount + " votes <col=6600FF>- Message Levincia on Discord");
				}else {
					for (int i = 0; i < amount / 2; i++) {
						Cases.grantCasket(player, 2);
					}

					if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null
							&& player.getSummoning().getFamiliar().getSummonNpc() != null
							&& player.getSummoning().getFamiliar().getSummonNpc().getId() == 8802) {
						player.getInventory().add(23020, amount);
						player.getPacketSender()
								.sendMessage("<shad=1>@yel@You get an extra vote scroll because of your pet!");
					}
					if (GameSettings.DOUBLE_VOTE) {
						player.getInventory().add(23020, amount);
						player.getPacketSender()
								.sendMessage("<shad=1>@yel@You get an extra vote scroll because of the current event!");
					}

					PlayerLogs.logPlayerVotes(player.getUsername(), "Player claimed votes: " + amount + ", IP: " + player.getHostAddress());

					player.getInventory().add(23020, amount);

					player.getPacketSender().sendMessage("Thank you for voting!");
					int rollAccuracy = Misc.getRandom (100);
					if (rollAccuracy <= 50) {
						player.getInventory ().add (10792, 1);
						player.getPacketSender().sendMessage("You were rewarded a Celebration box for voting!");
					}
					player.lastVoteTime = System.currentTimeMillis();
					player.getAchievementTracker().progress(AchievementData.SUPPORT_AVALON, 1);
					player.getAchievementTracker().progress(AchievementData.SUPPORTER, 1);
					player.getAchievementTracker().progress(AchievementData.MEGA_SUPPORTER, 1);
					player.getAchievementTracker().progress(AchievementData.VETERAN_VOTER, 1);

					player.setVoteCount(doMotivote.getVoteCount() + amount);

					if (doMotivote.getVoteCount() >= 40) {
						VoteBossDrop.handleSpawn();
					}
					Calendar cal = Calendar.getInstance();
					int day = cal.get(Calendar.DAY_OF_YEAR);

					player.setLastVotedDay(day);

					player.setMonthlyVoteCount(player.getMonthlyVoteCount () + 1);
					World.sendMessage("<img=11>" + player.getUsername() + " has voted for " + amount
							+ " points. ::vote now to support the server.");
					player.getVotingStreak().vote();
				}
			}


			destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean connect(String host, String database, String user, String pass) {
		try {
			this.conn = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, user, pass);
			return true;
		} catch (SQLException e) {
			// System.out.println("Failing connecting to database!");
			return false;
		}
	}

	public void destroy() {
		try {
			conn.close();
			conn = null;
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int executeUpdate(String query) {
		try {
			this.stmt = this.conn.createStatement(1005, 1008);
			int results = stmt.executeUpdate(query);
			return results;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	public ResultSet executeQuery(String query) {
		try {
			this.stmt = this.conn.createStatement(1005, 1008);
			ResultSet results = stmt.executeQuery(query);
			return results;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
