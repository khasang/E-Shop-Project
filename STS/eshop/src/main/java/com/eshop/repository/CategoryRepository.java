package com.eshop.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.eshop.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
	List<Category>findAllByOrderByName();
}
