package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.OrderDAO;
import com.eshop.model.Order;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDAO orderDAO;

	@Override
	@Transactional
	public void addOrder(Order order) {
		orderDAO.addOrder(order);
	}

	@Override
	@Transactional
	public List<Order> getAllOrders() {
		return orderDAO.getAllOrders();
	}

	@Override
	@Transactional
	public void removeOrder(Long id) {
		orderDAO.removeOrder(id);
	}

	@Override
	@Transactional
	public List<Order> getAllUserOrders(Long userId) {
		return orderDAO.getAllUserOrders(userId);
	}
}
