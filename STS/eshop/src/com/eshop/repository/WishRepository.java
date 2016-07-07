package com.eshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eshop.entity.User;
import com.eshop.entity.Wish;

public interface WishRepository  extends CrudRepository<Wish, Integer> {
	List<Wish>findПожалуйстаByUser(User user);
}
