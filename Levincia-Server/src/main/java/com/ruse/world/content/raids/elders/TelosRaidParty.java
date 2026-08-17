package com.ruse.world.content.raids.elders;

import com.ruse.model.Locations;
import com.ruse.model.PlayerRights;
import com.ruse.model.Position;
import com.ruse.util.Stopwatch;
import com.ruse.world.content.dialogue.DialogueManager;
import com.ruse.world.content.raids.system.RaidDifficulty;
import com.ruse.world.entity.impl.npc.NPC;
import com.ruse.world.entity.impl.player.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CopyOnWriteArrayList;


public class TelosRaidParty {

    private Player owner;
    private CopyOnWriteArrayList<Player> player_members;
    private CopyOnWriteArrayList<NPC> npc_members = new CopyOnWriteArrayList<NPC>();
    private boolean hasEnteredDungeon;
    private int entered;
    private int kills;
    private int height;
    private int currentPhase;
    private int phaseAmount;
    private int deathCount;

    public TelosRaidParty(Player owner) {
        this.owner = owner;
        timer = new Stopwatch();
        player_members = new CopyOnWriteArrayList<Player>();
        player_members.add(owner);
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(int currentPhase) {
        this.currentPhase = currentPhase;
    }

    public int getPhaseAmount() {
        return phaseAmount;
    }

    public void setPhaseAmount(int phaseAmount) {
        this.phaseAmount = phaseAmount;
    }

    public void invite(Player p) {
        if (getOwner() == null || p == getOwner())
            return;
        if (hasEnteredDungeon) {
            getOwner().getPacketSender().sendMessage("You cannot invite anyone right now.");
            return;
        }
        if (player_members.size() >= 12) {
            getOwner().getPacketSender().sendMessage("Your party is full.");
            return;
        }

        if (player_members.contains(p)) {
            getOwner().getPacketSender().sendMessage("That player is already in your party.");
            return;
        }
        if (p.getTelosRaidsParty() != null) {
            getOwner().getPacketSender().sendMessage("That player is currently in another party.");
            return;
        }
        if (p.getRights() != PlayerRights.OWNER && System.currentTimeMillis()
                - getOwner().getMinigameAttributes().getTelosAttributes().getLastInvitation() < 2000 ||  System.currentTimeMillis()
                - getOwner().getMinigameAttributes().getSODAttributes().getLastInvitation() < 2000 ) {
            getOwner().getPacketSender().sendMessage("You must wait 2 seconds between each party invitation.");
            return;
        }
        if (p.busy()) {
            getOwner().getPacketSender().sendMessage("That player is currently busy.");
            return;
        }

        getOwner().getMinigameAttributes().getTelosAttributes ().setLastInvitation(System.currentTimeMillis());
        DialogueManager.start(p, new TelosRaidsPartyInvitation (getOwner(), p));
        getOwner().getPacketSender().sendMessage("An invitation has been sent to " + p.getUsername() + ".");
    }

    public void add(Player p) {
        if (player_members.size() >= 12) {
            p.getPacketSender().sendMessage("That party is already full.");
            return;
        }
        if (hasEnteredDungeon) {
            p.getPacketSender().sendMessage("This party has already entered a dungeon.");
            return;
        }

        sendMessage(p.getUsername() + " has joined the party.");
        p.getPacketSender().sendMessage("You've joined " + getOwner().getUsername() + "'s party.");
        player_members.add(p);
        p.setTelosRaidParty(this);
        owner.setTelosRaidParty(this);

    }

    public void remove(Player p, boolean fromParty) {
        if (fromParty) {
            player_members.remove(p);
        }
        p.getPacketSender().sendCameraNeutrality();
        p.getPacketSender().sendInterfaceRemoval();
        p.getPacketSender().sendString(111709, "Create");
        int id = 111716;
        for (int i = 111716; i < 111737; i++) {
            p.getPacketSender().sendString(id++, "---");
            p.getPacketSender().sendString(id++, "--");
            p.getPacketSender().sendString(id++, "-");
        }
        p.getPacketSender().sendString(111702, "Elder Gods Party: @whi@0");

        if (p.getPosition().getY() >= 5709) {
            if (fromParty) {
                // System.out.println("move: ");
            }
        }

        if (p == owner) {
            if (fromParty) {
                if (getPlayers().size() >= 1) {
                    Player newOwner = getPlayers().get(0);
                    sendMessage(p.getUsername() + " has left the party.");
                    sendMessage("The party owner has been transfered to: " + newOwner.getUsername());
                    setOwner(newOwner);
                } else {
                    sendMessage("The raids party has been destroyed.");
                }
            }

        } else {
            // System.out.println("else: ");
            if (fromParty) {
                sendMessage(p.getUsername() + " has left the party.");
            }
        }
        if (fromParty) {
            p.setTelosRaidParty (null);
        }
        p.getPacketSender().sendInterfaceRemoval();

        boolean destruct = true;
        if (hasEnteredRaids()) {
            for (Player player : getPlayers()) {
                if (player.getLocation() == Locations.Location.TELOS)
                    destruct = false;
            }

        } else {
            destruct = false;
        }
        if (getPlayers().size() <= 0 || destruct) {
            TelosRaid.destroyInstance(this);
        }
    }
    /**
     * Difficulty of the raid.
     */
    @Getter
    @Setter
    private RaidDifficulty difficulty;


    @Getter
    @Setter
    private NPC telos;


    @Getter
    @Setter
    private boolean telosAttacking;

    @Getter
    @Setter
    private int telosHP;

    /**
     * Checks to see if players have trade open
     * @return
     */
    public boolean hasTradeOpen() {
        for(Player playerInParty : getPlayers()) {//Check for smuggling owner items into raid
            if(playerInParty.getTrading().inTrade()) {
                sendMessage(("Can't start the raid while " + playerInParty.getUsername().toLowerCase() + " is in a trade"));
                return true;
            }
        }
        return false;
    }

    public void sendMessage(String message) {
        for (Player member : getPlayers()) {
            if (member != null) {
                member.getPacketSender().sendMessage(message);
            }
        }
    }

    public void moveTo(Position position) {
        for (Player member : getPlayers()) {
            if (member != null) {
                member.moveTo(position);
            }
        }
    }
    /**
     * Stopwatch that can be used to time completion of a wave or raid.
     */
    @Getter
    @Setter
    private Stopwatch timer;
    public void create() {

        if (owner.getTelosRaidsParty() != null) {
            owner.getPacketSender().sendMessage("You are already in a Raids party.");
            return;
        }

        if (owner.getTelosRaidsParty() == null)
            owner.setTelosRaidParty(new TelosRaidParty (owner));

        owner.getPacketSender().sendMessage("<col=660000>You've created a Elder Gods party.");

        owner.setTelosRaidParty(this);

    }

    public void refreshInterface() {
        for (Player member : getPlayers()) {
            if (member != null) {
                member.getPacketSender().sendString(111709, "Invite");

                int start = 111716;
                for (int i = 0; i < getPlayers().size(); i++) {
                    member.getPacketSender().sendString(start++, "" + getPlayers().get(i).getUsername());
                    member.getPacketSender().sendString(start++,
                            "" + getPlayers().get(i).getSkillManager().getTotalLevel());
                    member.getPacketSender().sendString(start++,
                            "" + getPlayers().get(i).getSkillManager().getCombatLevel());
                }

                for (int i = start; i < 111737; i++) {
                    member.getPacketSender().sendString(start++, "---");
                    member.getPacketSender().sendString(start++, "--");
                    member.getPacketSender().sendString(start++, "-");
                }

                member.getPacketSender().sendString(111702, "Elder Gods Party: @whi@" + getPlayers().size());
            }
        }
    }


    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public CopyOnWriteArrayList<Player> getPlayers() {
        return player_members;
    }

    public boolean hasEnteredRaids() {
        return hasEnteredDungeon;
    }

    public void enteredDungeon(boolean hasEnteredDungeon) {
        this.hasEnteredDungeon = hasEnteredDungeon;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public CopyOnWriteArrayList<NPC> getNpcs() {
        return npc_members;
    }

    public static boolean isAllowedSoulsplit(Player player) {
        if (player.getTelosRaidsParty () != null) {
            return true;
        }
        return true;
    }

    public void startElderGods() {
        TelosRaid.firstWave(this);
    }
    public void endTelosRaid() {
        TelosRaid.finishRaid(this);
    }
}
