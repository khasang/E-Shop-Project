package com.eshop;

public class LightTimer {
	private final int TIME_GREEN = 3;
	private final int TIME_YELLOW = 1;
	private final int TIME_RED = 2;

	public String checkCurrentColorByMinute(int currentMinute) {
		int timeLost = currentMinute % (TIME_GREEN + TIME_RED + TIME_YELLOW);
		if (timeLost > TIME_GREEN + TIME_YELLOW) {
			return Text.RED;
		} else if (timeLost > TIME_GREEN) {
			return Text.YELLOW;
		} else {
			return Text.GREEN;
		}
	}
}
