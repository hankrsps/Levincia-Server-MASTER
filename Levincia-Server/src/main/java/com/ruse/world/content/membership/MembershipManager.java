package com.ruse.world.content.membership;


import com.ruse.world.World;
import com.ruse.world.entity.impl.player.Player;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MembershipManager {
	/**
	 *  change this every month
	 */
	public static Calendar endDate = new GregorianCalendar(World.getCalendar().getInstance().get(Calendar.YEAR), Calendar.NOVEMBER, 30, 23, 30);
	public static Calendar startDate = new GregorianCalendar(World.getCalendar().getInstance().get(Calendar.YEAR), Calendar.OCTOBER, 31, 0, 30);

	public static String theEndDate() {
		Calendar start = Calendar.getInstance();
		Calendar end = endDate;
		Date startDate = start.getTime();
		Date endDate = end.getTime();
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		long diffTime = endTime - startTime;
		long diffDays = diffTime / (1000 * 60 * 60 * 24);
		DateFormat dateFormat = DateFormat.getDateInstance();
		return dateFormat.format(endDate);
	}

	public static boolean didMonthEnd() {
		Calendar calendar = World.getCalendar().getInstance();

		return calendar.after(startDate)  && calendar.before(endDate);
	}
	private Player player;
	public MembershipManager(Player player) {
		this.player = player;
	}

	public void reset() {
		if (player.isMembershipUnlocked() == true) {
			player.setUnlockedMembership(false);
		}
		if (player.isCosmeticUnlocked() == true) {
			player.setUnlockedCosmetic(false);
		}
	}
}
