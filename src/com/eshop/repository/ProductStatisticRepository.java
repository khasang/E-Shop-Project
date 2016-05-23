package com.eshop.repository;

import org.springframework.data.repository.CrudRepository;
import com.eshop.entity.ProductStatistic;

public interface ProductStatisticRepository extends CrudRepository<ProductStatistic, Integer> {
	
}