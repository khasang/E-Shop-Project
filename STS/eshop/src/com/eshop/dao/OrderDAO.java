package com.eshop.dao;

import java.util.List;

import com.eshop.model.Order;

public interface OrderDAO {
	public void addOrder(Order order);

	public List<Order> getAllOrders();

	public void removeOrder(Long id);

	public List<Order> getAllUserOrders(Long userId);
}
