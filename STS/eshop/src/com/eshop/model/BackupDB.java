package com.eshop.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class BackupDB {
	public void sqlInsert() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUsername("root");
		dataSource.setUrl("jdbc:mysql://localhost/e-shop");
		dataSource.setPassword("root");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("try to update db...");
		// System.out.println("Creating tables");
		// jdbcTemplate.execute("DROP TABLE IF EXISTS trafficlight");
		// jdbcTemplate.execute("create table trafficlight(ID INT NOT NULL,"
		// + " minute INT NOT NULL, color MEDIUMTEXT NOT NULL)");
		jdbcTemplate.update("INSERT INTO trafficlight(ID, minute, color) VALUES(1, 1, 'red')");
		jdbcTemplate.update("INSERT INTO trafficlight(ID, minute, color) VALUES(2, 3, 'yellow')");
		jdbcTemplate.update("INSERT INTO trafficlight(ID, minute, color) VALUES(3, 5, 'green')");
	}
}
