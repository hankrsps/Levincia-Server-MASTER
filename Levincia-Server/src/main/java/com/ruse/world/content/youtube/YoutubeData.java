package com.ruse.world.content.youtube;

/**
 * @author Levincia
 * Contact email: AlwaysDreaming.ai@gmail.com
 * Date coded 9/14/2022
 */


import com.ruse.world.entity.impl.player.Player;
import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ruse.world.content.PlayerLogs.getTime;
public enum YoutubeData {

    WRECKEDYOU(82461, 82461, 82461, 82361,"WreckedYou","https://www.youtube.com/c/wr3ckedyou",YoutubeCategory.MAIN,
            new int[][] {{12855, 50000}, {5022, 25000}, {19886,1 }, {23370, 2}, {20489, 1}, {19114, 3}, {7956, 25}, {15003, 1}, {6769, 1}, {10946, 1}, {11137, 15}, {20549, 1}, {23257, 5}, {4446, 1}, {15358, 1}, {15359, 1}, {4278, 10}, {23174, 3}, {20173, 1}, {8809, 1}},false,23414 ),
    INHERITED(82462, 82462, 82462, 82362,"InheritedRS","https://www.youtube.com/channel/UCtyzcyz9HFsafoE7PwVdSfA",YoutubeCategory.MAIN,
            new int[][] {{23215, 10}, {15289, 1}, {22214,10 }, {6199, 50}, {7956, 25}, {10946, 3}, {23047, 1}, {8812, 1}, {23020, 2}, {23264, 3}, {9084, 1}, {21218, 5}, {10947, 1}, {15003, 1}, {6769, 1}, {989, 10}, {19116, 10}, {19115, 7}, {19114, 5}, {22080, 1}},false,23415 ),
    WALKCHAOS(82463, 82463, 82463, 82363,"Walkchaos","https://www.youtube.com/c/Walkchaos",YoutubeCategory.MAIN,
                    new int[][] {{23370, 2}, {15003, 1}, {15289,1 }, {8812, 1}, {6833, 2}, {6199, 50}, {19114, 3}, {20549,1}, {10946, 1}, {10947, 1}, {15288, 1}, {15358, 1}, {15359, 1}, {6769, 1}, {23174, 5}, {19116, 10}, {5022, 25000}, {8860, 1}, {8861, 1}, {8862, 1}},false,23417 ),
    CELESTIAL(82464, 82464, 82464, 82364,"Celestial","https://www.youtube.com/channel/UCLXEHqVf9UzmbhHfk7X2ngA",YoutubeCategory.MAIN,
            new int[][] {{3907, 5}, {4152, 10}, {11236,10 }, {15487, 10}, {10946, 5}, {15288, 1}, {6833, 2}, {22123, 5}, {7120, 10}, {21220, 10}, {21219, 5}, {11137, 15}, {6769, 1}, {15003, 1}, {18404, 1}, {23257, 5}, {23174, 5}, {18768, 1}, {8834, 1}, {8835, 1}},false,23416 ),
    LANO(82465, 82465, 82465, 82365,"Lano","https://www.youtube.com/c/LanoRS",YoutubeCategory.MAIN,
            new int[][] {{5022, 25000}, {19001, 1}, {15288,1 }, {7956, 25}, {6199, 50}, {15003, 1}, {10946, 1}, {19886, 1}, {21218, 5}, {989, 10}, {19115, 5}, {19114, 3}, {20549, 1}, {23370, 2}, {3907, 10}, {4152, 10}, {11236, 10}, {20173, 1}, {23174, 5}, {23257, 5}},false,23416 ),

    ;

    /** The main type of the youtuber. */
    private final YoutubeCategory type;

    /** The name of the youtuber. */
    private final String name;
    public String getName() {
        return name;
    }

    /** The channel of the youtuber. */
    private final String channelLink;
    public String getChannel() {
        return channelLink;
    }

    /** The status of the youtuber. */
    public boolean live;
    public boolean getLive() {
        return live;
    }
    public void setLive(boolean live) {
        this.live = live;
    }

    /** buttonId content */
    public final int buttonId;
    private int clickingid, textButtonId, backgroundButtonId;
    public int getTextButtonId() {
        return textButtonId;
    }
    public int getBackgroundButtonId() {
        return backgroundButtonId;
    }
    public int getClickingId() {
        return clickingid;
    }
    public int getButtonId() {
        return buttonId;
    }

    /** The rewards */
    private final int[][] items;
    public int[][] getItems() {
        return items;
    }
    private int reward;
    public int getReward() {
        return reward;
    }

    /** Create the Enum */
    YoutubeData(int buttonId, int clickingid, int textButtonId, int backgroundButtonId, String name,String channelLink,YoutubeCategory type, int[][] items, boolean live,int reward) {
        //npcid is 3rd to last parameter
        //this.index = (index);
        this.buttonId = buttonId;
        this.clickingid = clickingid;
        this.textButtonId = textButtonId;
        this.backgroundButtonId = backgroundButtonId;
        this.name = name;
        this.channelLink = channelLink;
        this.type = type;
        this.items = items;
        this.live = live;
        this.reward = reward;
    }

    public static List<String> addValue(List<String> lines, String username) {
        List<String> newLines = new ArrayList<String>();
        for (String line : lines) {
            if (line.contains(username)) {
                String[] vals = line.split(" : ");
                newLines.add(vals[0] + " : " + (Integer.parseInt(vals[1]) + 1));
            } else {
                newLines.add(line);
            }

        }
        return newLines;
    }



    @SneakyThrows
    public static void clear() throws IOException {
        try{
            FileWriter fw = new FileWriter("data/youtube/youtube_data.txt", false);
            PrintWriter pw = new PrintWriter(fw,false);
            pw.flush();
            pw.close();
            fw.close();
        } catch (Exception exception){
            System.out.println("Exception has been caught");
        }
    }

    @SneakyThrows
    public static void handleSyntax(Player player, String syntax) {

        if (!player.getCurrentData().getLive()) {
            player.getPA().sendMessage("This youtuber is not currently live!");
            return;
        }

        if (checkIp(player.getHostAddress())) {
            player.getPacketSender().sendMessage("You have already received a livestream reward!");
            return;
        }
        if (player.getMac() != null && checkMac(player.getMac())) {
            player.getPacketSender().sendMessage("You have already received a livestream reward!");
            return;
        }
        if (player.getCurrentData().getLive()) {
            try {
                BufferedWriter w = new BufferedWriter(new FileWriter("data/youtube/youtube_data.txt", true));
                w.write(player.getHostAddress() + " : " + player.getMac() + " : " + player.getUsername() + " : " + getTime() + ": " + syntax);
                w.newLine();
                w.flush();
                w.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                List<String> lines;
                boolean contains = false;
                File f = new File("./data/youtube/total.txt");
                if (!f.exists())
                    f.createNewFile();
                player.getInventory().add(player.getCurrentData().getReward(),1);
                player.getPA().sendMessage("You Claim " + player.getCurrentData().getName() +"'s Goodiebag, Subscribe for future videos!");
                lines = Files.readAllLines(f.toPath(), Charset.defaultCharset());

                for (String line : lines) {
                    if (line.split(" : ")[0].equalsIgnoreCase(syntax)) {
                        contains = true;
                    }
                }

                if (contains) {
                    addValue(lines, syntax);
                    Files.write(f.toPath(), addValue(lines, syntax), Charset.defaultCharset());
                } else {
                    FileWriter total = new FileWriter("./data/youtube/total.txt", true);
                    if (total != null) {
                        total.write(syntax + " : 1");
                        total.write(System.lineSeparator());
                        total.close();
                    }
                }
            } catch (Exception e) {
                // log.error("Error while writing promo code data", e);
            }

        }
    }

    @SneakyThrows
    public static boolean checkIp(String ip) {
        File file = new File("data/youtube/youtube_data.txt");
        if (!file.exists())
            file.createNewFile();
        Scanner scanner = new Scanner(file);
        String content;
        int count = 0;
        while (scanner.hasNext()) {
            content = scanner.nextLine();
            String[] split = content.split(" : ");
            if (ip.equalsIgnoreCase(split[0])) {
                count++;
            }
            if (count >= 1) {
                return true;
            }
        }
        return false;
    }

    @SneakyThrows
    public static boolean checkMac(String mac) {
        File file = new File("data/youtube/youtube_data.txt");
        if (!file.exists())
            file.createNewFile();

        Scanner scanner = new Scanner(file);
        String content;
        int count = 0;
        while (scanner.hasNext()) {
            content = scanner.nextLine();
            String[] split = content.split(" : ");
            if (mac.equalsIgnoreCase(split[1])) {
                count++;
            }
            if (count >= 1) {
                return true;
            }
        }
        return false;
    }
    public YoutubeCategory getType() {
        return type;
    }
}