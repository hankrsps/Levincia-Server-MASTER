package com.ruse.world.content.serverperks;

import ca.momoperes.canarywebhooks.DiscordMessage;
import ca.momoperes.canarywebhooks.WebhookClient;
import ca.momoperes.canarywebhooks.WebhookClientBuilder;
import ca.momoperes.canarywebhooks.embed.DiscordEmbed;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ruse.GameSettings;
import com.ruse.util.Misc;
import com.ruse.util.Stopwatch;
import com.ruse.world.World;
import com.ruse.world.content.startertasks.StarterTasks;
import com.ruse.world.entity.impl.player.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.ruse.util.StringUtils.usToSpace;

public class ServerPerks {

    @Getter
    @AllArgsConstructor
    public enum Perk {
        DR("x1.5 DR boost", "x1.5 DR", 1524, 30_000_000),// DONE
        XP("x2 EXP Boost", "x2 EXP", 529, 15_000_000),// DONE
        DOUBLE_DROPS("Double Drops", "x2 Drops", 1525, 45_000_000),// DONE
        PEST_CONTROL("x2 PC Points", "x2 PC", 1521, 25_000_000),// DONE
        SLAYER_POINTS("x1.5 Slayer Points", "x1.5 Slay", 1522, 30_000_000),// DONE
        RAIDS_LOOT("x2 Raids Loot", "x2 Raids", 1521, 45_000_000),// DONE
        ;

        private final String name;
        private final String smallName;
        private final int spriteId;
        private final int cost;
    }

    private final int TIME = 6000; // 1 hour
    private final int INTERFACE_ID = 42050;
    private final int OVERLAY_ID = 42400;
    public Perk CURRENT_PERK = Perk.values()[0];
    private Perk activePerk;
    private int currentTime = 0;
    private boolean active = false;
    public int COST = 100_000_000;
    private final Stopwatch stopwatch = new Stopwatch();
    public int contributed = 0;

    private long COOL_DOWN = 60 * 60 * 1000;

    public Perk getActivePerk() {
        return activePerk;
    }

    public void open(Player player) {
        player.getPacketSender().sendInterface(INTERFACE_ID);
        updateInterface(player);
    }

    public void contribute(Player player, int amount) {
        if (active) {
            player.sendMessage("@red@A perk is already active");
            return;
        }

        if (!player.getInventory().contains(12855, amount)) {
            amount = player.getInventory().getAmount(12855);
        }

        if (amount <= 0) {
            player.sendMessage("@red@You do not have any tokens to contribute!");
            return;
        }

        amount = Math.min(amount, COST - contributed);


        long cooldown = stopwatch.elapsed();
        if (cooldown != 0) {
            if (cooldown < COOL_DOWN) {
                player.sendMessage("You cannot contribute to the server perks while there is a cool down.");
                return;
            }
        }

        StarterTasks.doProgress(player, StarterTasks.StarterTask.CONTRIBUTE_PERKS, amount);
        player.getInventory().delete(12855, amount);
        contributed += amount;
        updateInterface(player);


        player.getDailyTaskManager().submitProgressToIdentifier(25, amount);
        player.setServerPerksContributions(player.getServerPerksContributions() + amount);


        if (amount >= 1000000) {
            World.sendMessage("<img=16><shad=1>@or2@[" + player.getUsername() + "] @yel@has just donated @gre@" + Misc.insertCommasToNumber(amount)
                    + " @yel@Levincia tokens to the Server Perks!");
        }
        if (contributed >= COST) {
            start(CURRENT_PERK);
        }
        save();
    }


    public void contribute(int amount) {
        if (active) {
            return;
        }

        amount = Math.min(amount, COST - contributed);


        contributed += amount;

        if (contributed >= COST) {
            start(CURRENT_PERK);
        }
        save();
    }


    public void setPerk(Perk perk) {
       CURRENT_PERK = perk;
       COST  = perk.getCost();
    }


    public void setPerk(Player player, int index) {
        if (active) {
            player.sendMessage("@red@A perk is already active");
            return;
        }
        int amount = COST - contributed;
        contributed += COST - contributed;

        World.sendMessage("<img=16><shad=1>@or2@[" + player.getUsername() + "] @yel@has just donated @gre@" + amount + " @yel@Levincia tokens to the Server-Wide Perks!");
        if (contributed >= COST) {
            start(Perk.values()[index]);
        }
        save();
    }

    public void tick() {
        if (!active) {
            return;
        }

        currentTime--;

        if (currentTime == 0) {
            end();
        }

        if (currentTime % 100 == 0) {
            updateOverlay();
        }
    }

    private void start(Perk perk) {
        currentTime = TIME;
        active = true;

        activePerk = perk;
        updateOverlay();

        World.sendBroadcastMessage("[Perk] " + perk.getName() + " has been activated for 1 hour!", 500);

        if (!GameSettings.LOCALHOST)
            discordBroadcast("");
    }

    public void end() {
        active = false;
        contributed = 0;
        stopwatch.reset();
        discordBroadcastEnd("");
        activePerk = null;
        resetInterface();

        if (CURRENT_PERK.ordinal() >= Perk.values().length - 1){
            setPerk(Perk.values()[0]);
        }else
            setPerk(Perk.values()[CURRENT_PERK.ordinal() + 1]);

    }

    private void updateOverlay() {
        World.getPlayers().forEach(player -> {
            updateOverlay(player);
        });
    }

    public void updateOverlay(Player player) {
        if (activePerk == null) {
            player.getPacketSender().sendWalkableInterface(OVERLAY_ID, false);
            return;
        }
        int minutes = (int) QuickUtils.tickToMin(currentTime);
        player.getPacketSender().sendSpriteChange(OVERLAY_ID + 1, activePerk.getSpriteId());
        player.getPacketSender().sendWalkableInterface(OVERLAY_ID, true);
        player.getPacketSender()
                .sendString(OVERLAY_ID + 3, usToSpace(activePerk.getSmallName()));
        player.getPacketSender().sendString(OVERLAY_ID + 2, minutes + " min");
    }

    private void resetInterface() {
        World.getPlayers().forEach(player -> {
            player.getPacketSender().sendWalkableInterface(OVERLAY_ID, false);
            player.getPacketSender().updateProgressBar(INTERFACE_ID + 10, 0);
        });
    }

    public void updateInterface(Player player) {
        loadList(player);
        int percentage = getPercentage(contributed, COST);
        player.getPacketSender().updateProgressBar(INTERFACE_ID + 7, percentage);
        player.getPacketSender().sendString(INTERFACE_ID + 8, Misc.insertCommasToNumber(contributed) + "/" + Misc.insertCommasToNumber(COST) + "");

        long cooldown = stopwatch.elapsed();

        if ((COOL_DOWN) - cooldown <= 0) {
            cooldown = 0;
        }

        if (cooldown == 0)
            player.getPacketSender().sendString(INTERFACE_ID + 11, "No Cooldown");
        else
            player.getPacketSender().sendString(INTERFACE_ID + 11, Misc.getHoursLeft((COOL_DOWN) - cooldown) + " Cooldown");
    }

    private void loadList(Player player) {
        player.getPacketSender().sendString(42062, active ? "Current Perk" : "Next Perk");

        int interID = 42102;
        player.getPacketSender().sendString(interID++, CURRENT_PERK.getName());
        player.getPacketSender().sendSpriteChange(interID++, CURRENT_PERK.getSpriteId());
        player.getPacketSender().sendSpriteChange(interID++, CURRENT_PERK.getSpriteId());
    }

    private int getPercentage(int n, int total) {
        float proportion = ((float) n) / ((float) total);
        return (int) (proportion * 100f);
    }

    public boolean handleButton(Player player, int id) {
        if (id >= -23435 && id <= -23405) {
            updateInterface(player);
            return true;
        }

        return false;
    }

    public void reset() {
        contributed = 0;
        World.getPlayers().forEach(this::updateInterface);
    }

    private static ServerPerks instance = null;

    public static ServerPerks getInstance() {
        if (instance == null) {
            instance = new ServerPerks();
        }
        return instance;
    }

    private ServerPerks() {

    }


    public void save() {
        Path path = Paths.get("./data/saves/saved-info.json");
        File file = path.toFile();
        file.getParentFile().setWritable(true);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileWriter writer = new FileWriter(file)) {
            Gson builder = new GsonBuilder().setPrettyPrinting().create();
            JsonObject object = new JsonObject();

            object.addProperty("contributed", contributed);
            object.addProperty("current-perk", CURRENT_PERK.ordinal());

            writer.write(builder.toJson(object));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void discordBroadcast(String msg) {
        try {
            String webhook = "https://discord.com/api/webhooks/983470634304675850/v1rdbrXWCpule0_2fKc1AvGt0V3W-VNCBM5aKuk5kOLTkufAtWLKxu4mIxss9Kk-wIZp";
            WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
            DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("").withColor(Color.orange).withDescription(
                    "***[Perk] "+ ServerPerks.getInstance().CURRENT_PERK.getName() + " has been activated for 1 hour!***").build();
            DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)).withEmbed(embed).withUsername("Broadcast").build();
            client.sendPayload(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void discordBroadcastEnd(String msg) {
        try {
            String webhook = "https://discord.com/api/webhooks/983470634304675850/v1rdbrXWCpule0_2fKc1AvGt0V3W-VNCBM5aKuk5kOLTkufAtWLKxu4mIxss9Kk-wIZp";
            WebhookClient client = new WebhookClientBuilder().withURI(new URI(webhook)).build(); // Create the webhook
            DiscordEmbed embed = new DiscordEmbed.Builder().withTitle("").withColor(Color.orange).withDescription(
                    "***[Perk] "+ ServerPerks.getInstance().CURRENT_PERK.getName() + " has been deactivated***").build();
            DiscordMessage message = new DiscordMessage.Builder(Misc.stripIngameFormat(msg)).withEmbed(embed).withUsername("Broadcast").build();
            client.sendPayload(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void load() {
        try (FileReader fileReader = new FileReader("./data/saves/saved-info.json")) {
            JsonParser fileParser = new JsonParser();
            JsonObject reader = (JsonObject) fileParser.parse(fileReader);

            if (reader.has("contributed"))
                contributed = reader.get("contributed").getAsInt();
            if (reader.has("current-perk"))
                setPerk(Perk.values()[reader.get("current-perk").getAsInt()]);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}