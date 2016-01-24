package com.eshop.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eshop.model.Order;
import com.eshop.model.User;
import com.eshop.service.AccountService;
import com.eshop.service.OrderService;
import com.eshop.service.ProductService;

@Controller
public class AppController {
	@Autowired
	AccountService accountService;
	@Autowired
	OrderService orderService;
	@Autowired
	ProductService productService;

	@RequestMapping("/vieworder")
	public String viewOrder() {
		return "vieworder";
	}

	@RequestMapping("/createorder")
	public String createOrder() {
		return "createorder";
	}

	@RequestMapping("/")
	public ModelAndView indexPage(@ModelAttribute(value = "username") String username) {
		ModelAndView model = new ModelAndView("index");
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addObject("result", "Welcome to EShop " + user.getUsername() + "!");
		return model;
	}

	@RequestMapping(value = "/newpurchase")
	public String newPurchase() {
		return "addpurchase";
	}

	@RequestMapping(value = "/addpurchase")
	public ModelAndView addNewPurchase(@RequestParam(value = "purchasename") String name) {
		ModelAndView model = new ModelAndView("addpurchase");
		String result;
		if (name == null || name.equals("")) {
			result = "Enter purchase name";
		} else {
			try {
				User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				Order order = new Order(name, user);
				user.getUserOrderList().add(order);
				orderService.addOrder(order);
				result = "Purchase:" + name + " was added.";
			} catch (DataIntegrityViolationException e) {
				result = "Purchase with " + name + " already exist.";
			} catch (Exception e) {
				result = "Error adding purchase.";
			}
		}
		model.addObject("result", result);
		return model;
	}

	@RequestMapping("/cancelpurchase")
	public String cancelPurchase(Map<String, Object> map) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		map.put("purchaseList", orderService.getAllUserOrders(user.getId()));
		return "cancelpurchase";
	}

	@RequestMapping("/cancelpurchase/{purchaseId}")
	public String deleteUser(@PathVariable("purchaseId") Long purchaseId) {
		orderService.removeOrder(purchaseId);
		return "redirect:/cancelpurchase";
	}

	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/reg")
	public String regPage() {
		return "registration";
	}

	@RequestMapping("/reguser")
	public String regUser(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		try {
			if (username != null & !username.equals("") & password != null & !password.equals("")) {
				User user = new User(username, password);
				accountService.addUser(user);
			}
		} catch (DataIntegrityViolationException e) {
			return "redirect:/reg";
		}
		return "login";
	}
}
