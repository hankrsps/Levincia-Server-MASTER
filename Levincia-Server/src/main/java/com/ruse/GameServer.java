package com.ruse;

import com.ruse.util.ShutdownHook;

import java.io.File;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

//import com.ruse.tools.discord.Discord;

/**
 * The starting point of Levincia.
 *
 * @author Gabriel
 * @author Samy
 */
public class GameServer {

    static {
        normalizeWorkingDirectory();
    }

    private static final GameLoader loader = new GameLoader(GameSettings.GAME_PORT);
    private static final Logger logger = Logger.getLogger("Levincia");
    private static boolean updating;

    private static void normalizeWorkingDirectory() {
        File cwd = new File(System.getProperty("user.dir"));
        if (new File(cwd, "data").isDirectory()) {
            return;
        }

        File nestedServer = new File(cwd, "Levincia-Server");
        if (new File(nestedServer, "data").isDirectory()) {
            System.setProperty("user.dir", nestedServer.getAbsolutePath());
            return;
        }

        try {
            File classes = new File(GameServer.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            File target = classes.getParentFile();
            File serverRoot = target != null ? target.getParentFile() : null;
            if (serverRoot != null && new File(serverRoot, "data").isDirectory()) {
                System.setProperty("user.dir", serverRoot.getAbsolutePath());
            }
        } catch (URISyntaxException | SecurityException ignored) {
            // If auto-detection fails, startup will report the original missing-data error.
        }
    }

    public static void main(String[] params) {
        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
        try {
            logger.info("Working directory: " + System.getProperty("user.dir"));
            logger.info("Initializing the loader...");
            loader.init();
            loader.finish();
            logger.info(GameSettings.RSPS_NAME + " is now online on port " + GameSettings.GAME_PORT + "!");
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Could not start " + GameSettings.RSPS_NAME + "! Program terminated.", ex);
            System.exit(1);
        }

        // PkingBots.init();
    }

    public static GameLoader getLoader() {
        return loader;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setUpdating(boolean updating) {
        GameServer.updating = updating;
    }

    public static boolean isUpdating() {
        return GameServer.updating;
    }
}
