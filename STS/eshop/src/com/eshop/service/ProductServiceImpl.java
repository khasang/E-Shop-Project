package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.ProductDAO;
import com.eshop.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO productDAO;

	@Override
	@Transactional
	public void addProduct(Product product) {
		productDAO.addProduct(product);
	}

	@Override
	@Transactional
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}

	@Override
	@Transactional
	public void removeProduct(Long id) {
		productDAO.removeProduct(id);
	}

	@Override
	@Transactional
	public List<Product> getAllProductsInOrder(Long orderId) {
		return productDAO.getAllProductsInOrder(orderId);
	}

	@Override
	public void addProductInOrder(Product product, Long orderID) {
		productDAO.addProductInOrder(product, orderID);
	}

}
