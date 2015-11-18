package com.eshop;

import java.util.ArrayList;
import java.util.List;

public class LightTimer {
	private final int MINUTES = 60;
	private List<Integer> redMinutesTimer = new ArrayList<Integer>();
	private List<Integer> yellowMinutesTimer = new ArrayList<Integer>();

	public void initLightTimer() {
		for (int i = 0; i < MINUTES; i += 6) {
			redMinutesTimer.add(i);
			redMinutesTimer.add(i + 1);
			yellowMinutesTimer.add(i + 2);
		}
	}

	public String checkCurrentColorByMinute(int currentMinute) {
		initLightTimer();
		if (redMinutesTimer.contains(currentMinute)) {
			return "Red";
		} else if (yellowMinutesTimer.contains(currentMinute)) {
			return "Yellow";
		} else
			return "Green";
	}
}
