package org.necrotic;

public class Configuration {


	public static boolean localHost = true;
	public static int clientversion = 30;//change this to match the one in LoginDecoder
	public final static String SERVER_HOST() {
		return localHost ? "127.0.0.1" : "51.81.49.184";
	}

	public final static int SERVER_PORT = 43594;

	public final static int CLIENT_VERSION = 3;

	public final static String CLIENT_NAME = "Levincia";
	public final static String CACHE_DIRECTORY_NAME = "." + CLIENT_NAME;
	public static final String SETTINGS_DIRECTORY_NAME = "." + Configuration.CLIENT_NAME + "_data";
	public static final boolean FORCE_CACHE_UPDATE = true;

	public static final boolean IS_RUNNING_WINDOWS = true;
	public static final boolean STOP_CACHE_UPDATES = false;
	public static final boolean DROPBOX_MODE = false;
	public final static boolean JAGCACHED_ENABLED = false;
	public final static String JAGCACHED_HOST = "";
	public static boolean DISPLAY_PRESTIGES = false;
	public final static int NPC_BITS = 18;
	public static final boolean SEND_HASH = true;
	public static final boolean USING_INTELLIJ = true;
	public static boolean SAVE_ACCOUNTS = true;
	public static boolean DISPLAY_HP_ABOVE_HEAD = false;
	public static boolean DISPLAY_USERNAMES_ABOVE_HEAD = false;
	public static boolean TWEENING_ENABLED = true;
	public static boolean NEW_HITMARKS = true;
	public static boolean CONSTITUTION_ENABLED = false;
	public static boolean NEW_HEALTH_BARS = true;
	public static boolean MONEY_POUCH_ENABLED = false;
	public static boolean SMILIES_ENABLED = false;
	public static boolean NOTIFICATIONS_ENABLED = false;
	public static boolean HIGHLIGHT_USERNAME = true;
	public static boolean NEW_CURSORS = false;
	public static boolean NEW_FUNCTION_KEYS = true;
	public static boolean PARTICLES_ENABLED = true;
	public static boolean FOG_ENABLED = false;
	public static boolean GROUND_TEXT = true;
	public static boolean HIGH_DETAIL = true;
	public static boolean hdMinimap = true;
	public static boolean hdShading = true;
	public static boolean TOGGLE_ROOF_OFF = true;
	public static boolean TOGGLE_FOV = true;
	public static boolean DEPTH_BUFFER = true;

	public static final int[] REPACK_INDICIES = {
			4
	};

	public static int 
		clientSize = 0,
		clientWidth = 765,
		clientHeight = 503;
	
	public static int getClientWidth() {
		return clientWidth;
	}
	public static int getClientHeight() {
		return clientHeight;
	}
	

}