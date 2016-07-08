package com.eshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.eshop.entity.Product;
import com.eshop.model.cart.Cart;
import com.eshop.repository.CategoryRepository;
import com.eshop.repository.ProductRepository;

@Controller
@SessionAttributes("cart")
public class MainPageController {
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;

	@RequestMapping("main")
	public ModelAndView displayMainPage(HttpSession session) {
		ModelAndView modelandview = new ModelAndView("main");
		modelandview.addObject("listCategories", categoryRepository.findAllByOrderByName());
		if (session.getAttribute("cart") == null) {
			modelandview.addObject("cart", new Cart());
		}
		return modelandview;
	}

	@RequestMapping(value = "addtocart/{productId}")
	public String addToCart(@PathVariable("productId") int productId, @ModelAttribute("cart") Cart cart) {
		Product product = productRepository.findOne(productId);
		cart.addtem(product);
		return "redirect:/main";
	}

	@RequestMapping("viewcart")
	public ModelAndView viewCart(@ModelAttribute("cart") Cart cart) {
		ModelAndView modelandview = new ModelAndView("viewñart");
		modelandview.addObject("listCart", cart.getItems());
		return modelandview;
	}
}
