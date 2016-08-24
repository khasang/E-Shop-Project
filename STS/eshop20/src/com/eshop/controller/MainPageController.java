package com.eshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eshop.entity.Product;
import com.eshop.entity.User;
import com.eshop.model.cart.Cart;
import com.eshop.repository.CategoryRepository;
import com.eshop.repository.ProductRepository;
import com.eshop.repository.UserRepository;
import com.eshop.service.PasswordValidator;

@Controller
public class MainPageController {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
    @Autowired
	private Cart cart;
	@Autowired
	private PasswordValidator passwordValidator;
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value={"main","register","loginpage"})
	public ModelAndView displayMainPage(HttpServletRequest request) {	
		ModelAndView modelandview = new ModelAndView("main");
		modelandview.addObject("listCategories", categoryRepository.findAllByOrderByName());
		int totalItemsInCart = cart.getQuantityTotal();
		modelandview.addObject("totalItemsInCart",totalItemsInCart);
		modelandview.addObject("User", new User());
		return modelandview;
	}
	
	@RequestMapping(value = "/cart/add/{productId}")
	public String addToCart(@PathVariable("productId") int productId) {
		Product product = productRepository.findOne(productId);
		cart.addtem(product);
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/cart/delete/{productId}")
	public String deletefromCart(@PathVariable("productId") int productId){
		Product product = productRepository.findOne(productId);
		cart.deleteItem(product);
		return "redirect:/cart";
		
	}

	@RequestMapping("cart")
	public ModelAndView viewCart() {
		ModelAndView modelandview = new ModelAndView("ñart");
		modelandview.addObject("listCart", cart.getItems());
		modelandview.addObject("totalItemsInCart",cart.getQuantityTotal());
		modelandview.addObject("totalAmountInCart", cart.getAmountTotal());
		return modelandview;
	}
	
	@RequestMapping("adduser")
	public ModelAndView registerUser(@ModelAttribute("User") @Valid User newUser, BindingResult result) {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		passwordValidator.validate(newUser, result);
		if (!result.hasErrors()) {
			try {
				userRepository.save(newUser);
				modelandview.addObject("result", "User " + newUser.getLogin() + " successfully added");
			} catch (DataIntegrityViolationException e) {
				result.reject("user.exists", "User already exists");
			}
			modelandview.setViewName("registration");	
		}		
		return modelandview;
	}
}
