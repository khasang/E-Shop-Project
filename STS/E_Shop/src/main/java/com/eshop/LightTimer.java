package com.eshop;

import java.util.ArrayList;
import java.util.List;

public class LightTimer {
	private MinuteReader minuteReader = new MinuteReader();
	private final int MINUTES_IN_HOUR = 60;
	private List<Integer> redMinutesTimer = new ArrayList<Integer>();
	private List<Integer> yellowMinutesTimer = new ArrayList<Integer>();
	
	public LightTimer(){
		initLightTimer();
	}
	
	public void initLightTimer() {
		for (int i = 0; i < MINUTES_IN_HOUR; i += 6) {
			redMinutesTimer.add(i);
			redMinutesTimer.add(i + 1);
			yellowMinutesTimer.add(i + 2);
		}
	}

	public String resultColorOut() {
		if (redMinutesTimer.contains(minuteReader.getUserInputNumber())) {
			return "Red";
		} else if (yellowMinutesTimer.contains(minuteReader.getUserInputNumber())) {
			return "Yellow";
		} else
			return "Green";
	}
}
