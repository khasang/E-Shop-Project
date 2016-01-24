package com.eshop.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eshop.dao.OrderDAO;
import com.eshop.model.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addOrder(Order order) {
		sessionFactory.getCurrentSession().save(order);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrders() {
		return sessionFactory.getCurrentSession().createQuery("from Order").list();
	}

	@Override
	public void removeOrder(Long id) {
		Order order = sessionFactory.getCurrentSession().get(Order.class, id);
		if (order != null) {
			sessionFactory.getCurrentSession().delete(order);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllUserOrders(Long userId) {
		return sessionFactory.getCurrentSession().createQuery("from Order where user_id = :user_id")
				.setParameter("user_id", userId).list();
	}
}
