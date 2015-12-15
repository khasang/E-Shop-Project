package com.eshop.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateDataTable {
	private JdbcTemplate jdbcTemplate;
	private String result;

	public CreateDataTable(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void createDataTable(String tableName) {
		try {
			jdbcTemplate.execute("CREATE TABLE " + tableName
					+ "(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name varchar(255),amount INT)");
			result = "Table " + tableName + " created sucesfull!";
		} catch (Exception e) {
			result = "Error on create " + tableName;
			System.err.print(e);
		}
	}

	public String getResult() {
		return result;
	}
}