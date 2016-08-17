package com.eshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.eshop.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
  List<Product> findByCategoryId(int categotyId);
}
