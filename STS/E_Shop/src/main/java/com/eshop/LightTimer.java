package com.eshop;

public class LightTimer {
	public String checkCurrentColorByMinute(int minute) {
		return (minute < 2) ? Messages.RED : (minute > 2 && minute < 3) ? Messages.YELLOW : Messages.GREEN;
	}
}
