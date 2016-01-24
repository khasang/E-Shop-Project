package com.eshop.dao;

import java.util.List;

import com.eshop.model.Product;

public interface ProductDAO {
	public void addProduct(Product product);

	public void addProductInOrder(Product product, Long orderID);

	public List<Product> getAllProducts();

	public void removeProduct(Long id);

	public List<Product> getAllProductsInOrder(Long orderId);
}
