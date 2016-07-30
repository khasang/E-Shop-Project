package com.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.entity.Product;
import com.eshop.jsonview.Views;
import com.eshop.model.cart.Cart;
import com.eshop.model.cart.ResponseCartBody;
import com.eshop.model.cart.Item;
import com.eshop.model.cart.RequestUpdatedItem;
import com.eshop.repository.ProductRepository;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class AjaxController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private Cart cart;

	@JsonView(Views.Public.class)
	@RequestMapping(value = "/cart/api/getUpdatedCart")
	public ResponseCartBody getUpdatedCart(@RequestBody RequestUpdatedItem updatedItem) {
		int productId = updatedItem.getProductId();
		Product product = productRepository.findOne(productId);
		Item item = cart.updateItem(product, updatedItem.getNewQuantity());
		ResponseCartBody result = new ResponseCartBody();
		result.setProductId(productId);
		result.setAmount(item.getAmount());
		result.setAmountTotal(cart.getAmountTotal());
		result.setQuantityTotal(cart.getQuantityTotal());
		return result;
	}
}
