package com.eshop.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class InsertDataTable {
	private static InsertDataTable instance;
	private final String USER_NAME = "root", USER_PASSWORD = "root", URL = "jdbc:mysql://localhost:3306/eshop";
	private JdbcTemplate jdbcTemplate;
	private SimpleDriverDataSource dataSource;
	private String insertResult;

	private InsertDataTable() {
		dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUsername(USER_NAME);
		dataSource.setPassword(USER_PASSWORD);
		dataSource.setUrl(URL);
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public static InsertDataTable getInstance() {
		return instance == null ? new InsertDataTable() : instance;
	}

	public void insertDataInTable(String name, String amount) {
		try {
			if (name.length() == 0)
				throw new NullPointerException();
			Integer amountInt = Integer.parseInt(amount);
			jdbcTemplate.update("INSERT INTO product(name,amount) values(?,?)", name, amountInt);
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

	public String getInsertResult() {
		return insertResult;
	}
}
