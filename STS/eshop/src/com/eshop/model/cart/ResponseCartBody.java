package com.eshop.model.cart;

import com.eshop.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class ResponseCartBody {
	
	@JsonView(Views.Public.class)
	int productId;
	
	@JsonView(Views.Public.class)
	int amount;
	
	@JsonView(Views.Public.class)
	int quantityTotal;
	
	@JsonView(Views.Public.class)
	int amountTotal;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getQuantityTotal() {
		return quantityTotal;
	}

	public void setQuantityTotal(int quantityTotal) {
		this.quantityTotal = quantityTotal;
	}

	public int getAmountTotal() {
		return amountTotal;
	}

	public void setAmountTotal(int amountTotal) {
		this.amountTotal = amountTotal;
	}		
}
