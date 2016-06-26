package com.eshop.model.cart;

import com.eshop.entity.Product;

public class Item {
	private Product product;
	private int quantity;

	public Item(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getPrice(){
		return product.getPrice();
	}
	
	public int getAmount(){
		return product.getPrice()*quantity;
	}

}
