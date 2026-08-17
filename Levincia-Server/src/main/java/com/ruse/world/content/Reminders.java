package com.ruse.world.content;

import com.ruse.util.Misc;
import com.ruse.util.Stopwatch;
import com.ruse.world.World;

/*
 * @author Milo
 * 
 */

public class Reminders {
	
	
    private static final int TIME = 900000; //10 minutes
	private static Stopwatch timer = new Stopwatch().reset();
	public static String currentMessage;
	
	/*
	 * Random Message Data
	 */
	private static final String[][] MESSAGE_DATA = { 
			{"<img=832>Join 'Support' CC For Help/Tips!"},
			{"<img=832>Never use the same password on different servers"},
			{"<img=832>Do ::guides To Check out some in depth server guides"},
			{"<img=832>Remember to ::vote for the server every 12 hours to support Levincia!"},
			{"<img=832>Type ::commands to see a list of helpful commands"},
			{"<img=832>Use the ::help command to ask staff for help"},
			{"<img=832>Dont forget to set a bank pin"},
			{"<img=832>Don't forget to claim your rewards from completing achievements!"},
	         
	
	
	
	};

	/*
	 * Sequence called in world.java
	 * Handles the main method
	 * Grabs random message and announces it
	 */
	public static void sequence() {
		if(timer.elapsed(TIME)) {
			timer.reset();
			{
				
			currentMessage = MESSAGE_DATA[Misc.getRandom(MESSAGE_DATA.length - 1)][0];
			World.sendMessage(currentMessage);
			World.savePlayers();
					
				}
				
			World.savePlayers();
			}
		

          }

}