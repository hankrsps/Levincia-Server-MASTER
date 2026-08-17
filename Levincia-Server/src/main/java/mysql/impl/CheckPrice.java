package mysql.impl; // dont fo


import com.ruse.world.entity.impl.player.Player;

import java.sql.*;


public class CheckPrice implements Runnable{

    private static int voteCount = 0;

    public static final String HOST = "184.105.7.128";
    public static final String USER = "levisnsm_root";
    public static final String PASS = "ilysm123!@#";
    public static final String DATABASE = "levisnsm_store";

    private Player player;

    private int itemid;
    private int amount;
    private int cashamount;

    private Connection conn;
    private Statement stmt;

    public CheckPrice(Player player, int itemId, int amount, int cashamount) {
        this.player = player;
        this.itemid = itemId;
        this.amount = amount;
        this.cashamount = cashamount;
    }

    @Override
    public void run() {
        try {

            if (!connect(HOST, DATABASE, USER, PASS)) {

                return;
            }

            ResultSet rs = executeQuery("SELECT * FROM averageprice WHERE itemId='" + itemid + "'");

            if(rs.next()) {


                int previousamount =   rs.getInt("amountsold");
                int previouscashamount =   rs.getInt("avgprice");
                player.sendMessage(previousamount+" "+ previouscashamount);

                int newamount = previousamount + amount;
                int newcashamount = (previouscashamount + cashamount ) / newamount;

                rs.updateInt("amountsold", newamount);
                rs.updateInt("avgprice", newcashamount);

                rs.updateRow();
            } else {

                String insertStatement
                        = "INSERT INTO averageprice VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(insertStatement);

                ps.setInt(1, itemid);
                ps.setInt(2, amount);
                ps.setInt(3, cashamount);
                ps.execute();
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
            System.out.println("Failing connecting to database!");
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
