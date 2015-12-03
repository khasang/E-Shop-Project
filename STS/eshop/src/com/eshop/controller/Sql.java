package com.eshop.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class Sql {
	public static String sqlCheck;

	public void sqlInsert() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUsername("root");
		dataSource.setUrl("jdbc:mysql://localhost/e-shop");
		dataSource.setPassword("1111");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("try to update db...");
		try {
			//System.out.println("Creating tables");
			//jdbcTemplate.execute("DROP TABLE IF EXISTS trafficlight");
			//jdbcTemplate.execute("create table trafficlight(ID INT NOT NULL,"
			//+ " minute INT NOT NULL, color MEDIUMTEXT NOT NULL)");
			jdbcTemplate.update("INSERT INTO trafficlight(ID, minute, color) VALUES(1, 1, 'red')");
			jdbcTemplate.update("INSERT INTO trafficlight(ID, minute, color) VALUES(2, 3, 'yellow')");
			jdbcTemplate.update("INSERT INTO trafficlight(ID, minute, color) VALUES(3, 5, 'green')");
			sqlCheck = "db updated";
		} catch (Exception e) {
			sqlCheck = "Have error: " + e;
			System.err.println(sqlCheck);
		}
	}

	public String sqlInsertCheck() {
		Sql sql = new Sql();
		sql.sqlInsert();
		return sqlCheck;
	}
}