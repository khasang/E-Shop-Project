package com.eshop.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderList {
	private JdbcTemplate jdbcTemplate;
	private String result;

	public OrderList(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void createOrderTable() {
		try {
			jdbcTemplate.execute(
					"CREATE TABLE IF NOT EXIST orders (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, order_number INT,order_date DATE NOT NULL)");
		} catch (Exception e) {
			System.err.print(e);
		}
	}
}
