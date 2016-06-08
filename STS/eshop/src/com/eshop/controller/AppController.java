package com.eshop.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eshop.entity.Basket;
import com.eshop.entity.LogOrders;
import com.eshop.entity.Status;
import com.eshop.entity.User;
import com.eshop.model.BackupDB;
import com.eshop.model.OrderStatus;
import com.eshop.model.Orders;
import com.eshop.model.ShowTableDB;
import com.eshop.model.ShrinkDataDB;
import com.eshop.repository.BasketRepository;
import com.eshop.repository.CategoryRepository;
import com.eshop.repository.LogOrdersRepository;
import com.eshop.repository.ProductRepository;
import com.eshop.repository.UserRepository;
import com.eshop.service.PasswordValidator;

@Controller
public class AppController {
	@Autowired
	ShrinkDataDB shrinkDataDB;
	@Autowired
	ShowTableDB show;
	@Autowired
	BackupDB backup;
	@Autowired
	PasswordValidator passwordValidator;
	@Autowired
	UserRepository userRepository;
	@Autowired
	BasketRepository basketRepository;
	@Autowired
	LogOrdersRepository logOrdersRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@RequestMapping("login")
	public String login() {
		return "login";
	}

	@RequestMapping("registration")
	public ModelAndView registration() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.addObject("User", new User());
		modelandview.setViewName("registration");
		return modelandview;
	}

	@RequestMapping("/")
	public ModelAndView inputForm() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.addObject("result", "Welcome to our Eshop project!");
		return modelandview;
	}
	
	@RequestMapping("main")
	public ModelAndView displayMainPage(){
		ModelAndView modelandview = new ModelAndView("main");
		modelandview.addObject("listCategories",categoryRepository.findAllByOrderByName());
		return modelandview;
	}

	@RequestMapping("basket")
	public ModelAndView viewBasket(Principal principal) {
		ModelAndView modelandview = new ModelAndView("basket");
		String login = principal.getName();
		User user = userRepository.findByLogin(login);
		modelandview.addObject("listBasket", basketRepository.findByUser(user));
        modelandview.addObject("listOrders", new Orders());	    
        modelandview.addObject("orderSum",basketRepository.getOrderSum(user));
		return modelandview;
	}
	
	@RequestMapping(value="deleteorder/{orderId}")
	public String deleteOrder(@PathVariable("orderId") int orderId){
	    Basket basket = new Basket();
	    basket.setId(orderId);
	    basketRepository.delete(basket);
        return "redirect:/basket";
	}
	
	@RequestMapping("adduser")
	public ModelAndView registerUser(@ModelAttribute("User") User newUser, BindingResult result) {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		passwordValidator.validate(newUser, result);
		if (!result.hasErrors()) {
			try {
				userRepository.save(newUser);
				modelandview.addObject("result", "User " + newUser.getLogin() + " successfully added");
			} catch (DataIntegrityViolationException e) {
				result.reject("user.exists", "User already exists");
			}
		}
		modelandview.setViewName("registration");
		return modelandview;
	}

	@RequestMapping("addOrderInLog")
	public ModelAndView addOrderInLog(@ModelAttribute("Basket") Basket basket, BindingResult result) {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		LogOrders logOrders = new LogOrders();
		Status status = new Status();
		status.setStatusCode(OrderStatus.PAID);		
		logOrders.setStatus(status);
		logOrders.setBasket(basket);
	    logOrdersRepository.save(logOrders);
		modelandview.addObject("result", "The order has been paid");
		return modelandview;
	}

	@RequestMapping("/admin/manageusers")
	public ModelAndView manageusers() {
		ModelAndView modelandview = new ModelAndView("manageusers");
		User user = new User();
		modelandview.addObject("User", user);
		modelandview.addObject("listUserRoles", user.getRolesValues());
		modelandview.addObject("listUsers", userRepository.findAll());
		return modelandview;
	}

	@RequestMapping("/admin/updateRole")
	public String updaterole(@ModelAttribute("User") User user) {
		userRepository.setRole(user.getLogin(), user.getRole());
		return "redirect:/admin/manageusers";
	}

	@RequestMapping("/admin/backup")
	public ModelAndView backupDBView() {
		ModelAndView modelandview = new ModelAndView("backup");
		return modelandview;
	}

	@RequestMapping("/admin/BackupDB")
	public ModelAndView backupDB(@RequestParam(value = "path") String path) {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		backup.setPath(path);
		modelandview.addObject("result", backup.backupResultOutput());
		return modelandview;
	}

	@RequestMapping("/admin/showtables")
	public ModelAndView show() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.setViewName("/showtables");
		List<String> listTables = show.listTables();
		modelandview.addObject("listTables", listTables);
		modelandview.addObject("OptimizedTables", new ShowTableDB());
		return modelandview;
	}

	@RequestMapping("/admin/ShrinkDataDB")
	public ModelAndView shrinkDataDB(@ModelAttribute("OptimizedTables") ShowTableDB optimizedTables) {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		shrinkDataDB.setTablesToOptimize(optimizedTables.getTablesList());
		modelandview.addObject("listTables", shrinkDataDB.optimizeTables());
		modelandview.setViewName("shrink");
		return modelandview;
	}
}
