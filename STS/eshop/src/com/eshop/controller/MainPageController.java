package com.eshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eshop.entity.Product;
import com.eshop.model.cart.Cart;
import com.eshop.repository.CategoryRepository;
import com.eshop.repository.ProductRepository;

@Controller
public class MainPageController {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
    @Autowired
	private Cart cart;

	@RequestMapping("main")
	public ModelAndView displayMainPage(HttpSession session) {
		ModelAndView modelandview = new ModelAndView("main");
		modelandview.addObject("listCategories", categoryRepository.findAllByOrderByName());
		int totalItemsInCart = cart.getQuantityTotal();
		modelandview.addObject("totalItemsInCart",totalItemsInCart);
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
}
