package com.eshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
	@RequestMapping("/result")
	public @ResponseBody String colorOfLight() {
		return new LightTimer().resultColorOut();
	}
}
