package com.eshop.service;

import java.util.List;

import com.eshop.model.Product;

public interface ProductService {
	public void addProduct(Product product);

	public void addProductInOrder(Product product, Long orderID);

	public List<Product> getAllProducts();

	public void removeProduct(Long id);

	public List<Product> getAllProductsInOrder(Long orderId);
}
