package com.eshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eshop.entity.Basket;
import com.eshop.entity.User;

public interface BasketRepository extends CrudRepository<Basket, Integer> {
	List<Basket>findByUser(User user);	
	
	@Query("select SUM(priceTotal) from Basket where user = :user")
	int getOrderSum(@Param("user") User user);
}
