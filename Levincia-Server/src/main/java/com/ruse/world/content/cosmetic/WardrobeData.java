package com.ruse.world.content.cosmetic;


/**
 * The wardrobes data.
 * @author Levincia
 */

public enum WardrobeData {
    /*
     * Wardrobe items
     */

    COSTUME_1(133071, "Season 1 Outfit", "2,000 Gems", 2000, WardrobeCategory.FAVORITES,
            new int[] {23396, 1}, //helmet
            new int[] {-1, 1}, //amulet
            new int[] {23397, 1}, //body
            new int[] {23398, 1}, //legs
            new int[] {23399, 1}, //boots
            new int[] {-1, 1}, //cape
            new int[] {-1, 1}, //weapon
            new int[] {-1, 1}, //aura
            new int[] {23400, 1}, //gloves
            new int[] {-1, 1}, //shield
            new int[] {-1, 1}, //ring
            9244, //npcid
            390,
            true),//zoom

    COSTUME_2(133072, "Rogue Bandit", "500 Gems", 500, WardrobeCategory.FAVORITES,
            new int[] {10612, 1}, //helmet
            new int[] {19335, 1}, //amulet
            new int[] {5553, 1}, //body
            new int[] {5555, 1}, //legs
            new int[] {5557, 1}, //boots
            new int[] {-1, 1}, //cape
            new int[] {-1, 1}, //weapon
            new int[] {-1, 1}, //aura
            new int[] {5556, 1}, //gloves
            new int[] {-1, 1}, //shield
            new int[] {-1, 1}, //ring
            2270, //npcid
            320,
            true),//zoom

    COSTUME_3(133073, "Shadow Outfit", "1,000 Gems", 1000, WardrobeCategory.FAVORITES,
            new int[] {17614, 1}, //helmet
            new int[] {11195, 1}, //amulet
            new int[] {17616, 1}, //body
            new int[] {17618, 1}, //legs
            new int[] {17622, 1}, //boots
            new int[] {17606, 1}, //cape
            new int[] {17624, 1}, //weapon
            new int[] {-1, 1}, //aura
            new int[] {-1, 1}, //gloves
            new int[] {17620, 1}, //shield
            new int[] {-1, 1}, //ring
            607, //npcid
            320,
            true),//zoom

    COSTUME_4(133074, "Sephiroth Outfit", "1,000 Gems", 1000, WardrobeCategory.FAVORITES,
            new int[] {13328, 1}, //helmet
            new int[] {-1, 1}, //amulet
            new int[] {13329, 1}, //body
            new int[] {13330, 1}, //legs
            new int[] {13332, 1}, //boots
            new int[] {-1, 1}, //cape
            new int[] {13333, 1}, //weapon
            new int[] {-1, 1}, //aura
            new int[] {-1, 1}, //gloves
            new int[] {-1, 1}, //shield
            new int[] {-1, 1}, //ring
            903, //npcid
            320,
            true),//zoom

    COSTUME_5(133075, "Devil Outfit", "2,500 Gems", 2500, WardrobeCategory.FAVORITES,
            new int[] {3067, 1}, //helmet
            new int[] {-1, 1}, //amulet
            new int[] {3068, 1}, //body
            new int[] {3069, 1}, //legs
            new int[] {3070, 1}, //boots
            new int[] {3073, 1}, //cape
            new int[] {3072, 1}, //weapon
            new int[] {-1, 1}, //aura
            new int[] {3071, 1}, //gloves
            new int[] {-1, 1}, //shield
            new int[] {-1, 1}, //ring
            904, //npcid
            320,
            true),//zoom

    COSTUME_6(133076, "Samurai Outfit", "750 Gems", 750, WardrobeCategory.FAVORITES,
            new int[] {3074, 1}, //helmet
            new int[] {-1, 1}, //amulet
            new int[] {3075, 1}, //body
            new int[] {3076, 1}, //legs
            new int[] {-1, 1}, //boots
            new int[] {-1, 1}, //cape
            new int[] {-1, 1}, //weapon
            new int[] {-1, 1}, //aura
            new int[] {-1, 1}, //gloves
            new int[] {-1, 1}, //shield
            new int[] {-1, 1}, //ring
            905, //npcid
            320,
            true),//zoom


    COSTUME_7(133077, "Black Knight", "1,500 Gems", 1500, WardrobeCategory.FAVORITES,
            new int[] {10612, 1}, //helmet
            new int[] {19335, 1}, //amulet
            new int[] {5553, 1}, //body
            new int[] {5555, 1}, //legs
            new int[] {5557, 1}, //boots
            new int[] {-1, 1}, //cape
            new int[] {-1, 1}, //weapon
            new int[] {-1, 1}, //aura
            new int[] {5556, 1}, //gloves
            new int[] {-1, 1}, //shield
            new int[] {-1, 1}, //ring
            906, //npcid
            320,
            true),//zoom
/*
    COSTUME_8(133078, "Shit eater", "5000 Gems", 5000, WardrobeCategory.FAVORITES,
            new int[] {10612, 1}, //helmet
            new int[] {19335, 1}, //amulet
            new int[] {5553, 1}, //body
            new int[] {5555, 1}, //legs
            new int[] {5557, 1}, //boots
            new int[] {-1, 1}, //cape
            new int[] {-1, 1}, //weapon
            new int[] {-1, 1}, //aura
            new int[] {5556, 1}, //gloves
            new int[] {-1, 1}, //shield
            new int[] {-1, 1}, //ring
            904, //npcid
            320,
            false),//zoom
*/
    ;


    private int clickingid, textButtonId, backgroundButtonId;

    /** The name of the teleport. */
    private final int[] helmet;
    public int[] getHelmet() {
        return helmet;
    }
    private final int[] amulet;
    public int[] getAmulet() {
        return amulet;
    }
    private final int[] body;
    public int[] getBody() {
        return body;
    }
    private final int[] legs;
    public int[] getLegs() {
        return legs;
    }
    private final int[] boots;
    public int[] getBoots() {
        return boots;
    }
    private final int[] cape;
    public int[] getCape() {
        return cape;
    }
    private final int[] weapon;
    public int[] getWeapon() {
        return weapon;
    }
    private final int[] aura;
    public int[] getAura() {
        return aura;
    }
    private final int[] gloves;
    public int[] getGloves() {
        return gloves;
    }
    private final int[] shield;
    public int[] getShield() {
        return shield;
    }
    private final int[] ring;
    public int[] getRing() {
        return ring;
    }

    public final int npcId;
    public int getNpcId() {
        return npcId;
    }
    public boolean unlocked;

    public boolean getOutfitUnlocked() {
        return unlocked;
    }
    public void setOutfitUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    private final String name;

    private final String description;

    private final int cost;
    public int getCost() {
        return cost;
    }
    /** The type of the teleport. */
    private final WardrobeCategory type;

    public final int buttonId;

    private int spriteId;

    private final int adjustedZoom;
    /** Creates a new <code>Teleport<code>. */ //might have to make it multidimensioanl
    //the format of the enumid
    WardrobeData(int buttonId, String name,
                 String description, int cost, WardrobeCategory type, int[] helmet,int[] amulet,int[] body,int[] legs,int[] boots,int[] cape,int[]
                         weapon,int[] aura,int[] gloves,int[] shield,int[] ring,int npcId, int adjustedZoom,boolean unlocked) {
        //npcid is 3rd to last parameter
        //this.index = (index);
        this.buttonId = buttonId;
        this.clickingid = clickingid;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.type = type;
        this.helmet = helmet;
        this.amulet = amulet;
        this.body = body;
        this.legs = legs;
        this.boots = boots;
        this.cape = cape;
        this.weapon = weapon;
        this.aura = aura;
        this.gloves = gloves;
        this.shield = shield;
        this.ring = ring;
        this.npcId = npcId;
        this.adjustedZoom = adjustedZoom;
        this.unlocked = unlocked;
    }

    public String getName() {
        return name;
    }
    public int getAdjustedZoom() {
        return adjustedZoom;
    }
    public String getDescription() {
        return description;
    }

    public WardrobeCategory getType() {
        return type;
    }

    public int getButtonId() {
        return buttonId;
    }


}
