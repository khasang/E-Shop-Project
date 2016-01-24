package com.eshop.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eshop.dao.ProductDAO;
import com.eshop.model.Order;
import com.eshop.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Override
	public void removeProduct(Long id) {
		Product product = (Product) sessionFactory.getCurrentSession().load(Product.class, id);
		if (product != null) {
			sessionFactory.getCurrentSession().delete(product);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProductsInOrder(Long orderId) {
		return sessionFactory.getCurrentSession().createQuery("from Product where inOrder_id = :order_id")
				.setParameter("order_id", orderId).list();
	}

	@Override
	public void addProductInOrder(Product product, Long orderID) {
		Order order = (Order) sessionFactory.getCurrentSession().load(Order.class, orderID);
		if (order != null) {
			product.setInOrder(order);
		}
	}
}
