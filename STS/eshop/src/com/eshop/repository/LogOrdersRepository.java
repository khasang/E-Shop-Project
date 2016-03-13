package com.eshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.eshop.entity.LogOrders;

public interface LogOrdersRepository extends CrudRepository<LogOrders, Integer> {
}
