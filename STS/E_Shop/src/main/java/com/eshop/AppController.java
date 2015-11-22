package com.eshop;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
	@RequestMapping(value = "/trafficlight", method = RequestMethod.GET)
	public String greetingForm(TrafficLight trafficLight, Model model) {
		model.addAttribute("message", new Text());
		return "trafficlight";
	}

	@RequestMapping(value = "/trafficlight", method = RequestMethod.POST)
	public String greetingSubmit(@Valid @ModelAttribute TrafficLight trafficLight, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "trafficlight";
		}
		return "result";
	}
}
