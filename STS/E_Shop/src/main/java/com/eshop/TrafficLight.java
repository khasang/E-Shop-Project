package com.eshop;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TrafficLight {
	Text text = new Text();
	@NotNull
	@Max(59)
	@Min(0)
	private int userInputMinute;

	public int getUserInputMinute() {
		return userInputMinute;
	}

	public void setUserInputMinute(int userInputMinute) {
		this.userInputMinute = userInputMinute;
	}

	public String checkCurrentColorByMinute() {
		int timeLost = userInputMinute % (3 + 2 + 1);
		if (timeLost > 3 + 1) {
			return text.RED;
		} else if (timeLost > 3) {
			return text.YELLOW;
		} else {
			return text.GREEN;
		}
	}
}
