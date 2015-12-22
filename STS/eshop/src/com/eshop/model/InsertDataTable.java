package com.eshop.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class InsertDataTable {
	private JdbcTemplate jdbcTemplate;
	private String insertResult;

	public InsertDataTable(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insertDataInTable(String tableName, String name, String amount) {
		try {
			if (name.length() == 0)
				throw new NullPointerException();
			Integer amountInt = Integer.parseInt(amount);
			jdbcTemplate.update("INSERT INTO " + tableName.toLowerCase() + "(name,amount) values(?,?)", name,
					amountInt);
			insertResult = "Insert done!";
		} catch (NumberFormatException e) {
			insertResult = "Insert failure. Amount must be a number and not null";
			System.err.print(e);
		} catch (Exception e) {
			insertResult = "Insert failure";
			System.err.print(e);
		}
	}

	public void insertDataInTable(String name) {
		try {
			if (name.length() == 0)
				throw new NullPointerException();
			jdbcTemplate.update("INSERT INTO product(name) values(?)", name);
			insertResult = "Insert done!";
		} catch (NumberFormatException e) {
			insertResult = "Insert failure. Amount must be a number and not null";
			System.err.print(e);
		} catch (Exception e) {
			insertResult = "Insert failure";
			System.err.print(e);
		}
	}

	public void createDataTable() {
		try {
			jdbcTemplate.execute("DROP TABLE IF EXISTS `eshop`.`product` ");
			jdbcTemplate.execute(
					"CREATE TABLE product(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name varchar(255),amount INT)");
		} catch (Exception e) {
			System.err.print(e);
		}
	}

	public String getResult() {
		return insertResult;
	}
}
