package com.ruse.motivote3;

import com.ruse.world.entity.impl.player.Player;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Local voting-service placeholder.
 *
 * The original source required libs/mvgate3.jar, but that JAR is not included.
 * This preserves the API used by the rest of the server so local development,
 * combat, progression, and login testing can work without the external provider.
 *
 * Replace this implementation when a new vote provider is configured.
 */
public class doMotivote implements Runnable {

    private static int voteCount = 0;
    private static final ExecutorService SERVICE = Executors.newCachedThreadPool();

    public static void main(Player player, String auth) {
        SERVICE.execute(() -> {
            if (player != null) {
                player.getPacketSender().sendMessage(
                        "Voting is temporarily unavailable while the vote service is being configured."
                );
                player.getLastVoteClaim().reset();
            }
        });
    }

    @Override
    public void run() {
        // No background voting task is required for local development.
    }

    public static int getVoteCount() {
        return voteCount;
    }

    public static void setVoteCount(int voteCount) {
        doMotivote.voteCount = voteCount;
    }

    public void terminate() {
        // Kept for compatibility with older call sites.
    }

    public void start() {
        // Kept for compatibility with older call sites.
    }
}
