package com.eshop.model;

import java.util.ArrayList;
import java.util.List;
import com.eshop.entity.Basket;

public class Orders {	
	private List<Basket> ordersList = new ArrayList<Basket>();
	
	public Orders() {

	}
	
	public List<Basket> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Basket> ordersList) {
		this.ordersList = ordersList;
	}
}
