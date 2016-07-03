package com.eshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.eshop.entity.Product;
import com.eshop.model.cart.Cart;

@Controller
@SessionAttributes("cart")
public class CartController {
	
  @RequestMapping(value="addToCart/{productId}")
  public void addToCart(@PathVariable("productId") int productId, @ModelAttribute("cart") Cart cart){
	  Product product = new Product();	  
	  product.setId(productId);
	  cart.addtem(product);	  
  }
  
  @RequestMapping("/viewCart")
  public ModelAndView viewCart(HttpSession session){
    ModelAndView modelandview = new ModelAndView("viewCart");
    Cart cart = (Cart)session.getAttribute("cart");
    modelandview.addObject("listCart", cart.getItems());
    return modelandview;
  }      
}
