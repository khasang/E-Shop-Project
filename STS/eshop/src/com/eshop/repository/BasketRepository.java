package com.eshop.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.eshop.entity.Basket;
import com.eshop.entity.User;

public interface BasketRepository extends CrudRepository<Basket, Integer> {
	List<Basket>findByUser(User user);
}
