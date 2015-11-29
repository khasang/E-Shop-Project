package com.eshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
	private String color;
	private LightTimer lightTimer;
	private TimeReader timeReader;

	@RequestMapping("/result")
	public @ResponseBody String colorOfLight() {
		color = lightTimer.checkCurrentColorByMinute(timeReader.getMinute());
		if (!color.equals(null)) {
			return color;
		} else {
			return Strings.colorWarning;
		}
	}

	public void init(LightTimer lightTimer, TimeReader timeReader) {
		this.lightTimer = lightTimer;
		this.timeReader = timeReader;
	}
}
