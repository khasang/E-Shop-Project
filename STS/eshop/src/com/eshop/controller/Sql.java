package com.eshop.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class Sql {
	public static String sqlCheck;

	public void sqlInsert() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUsername("root");
		dataSource.setUrl("jdbc:mysql://localhost/e-shop");
		dataSource.setPassword("root");
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
	
	String sqlSelect() throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUsername("root");
		dataSource.setUrl("jdbc:mysql://localhost/e-shop");
		dataSource.setPassword("root");
		try{
		conn =  DriverManager.getConnection("jdbc:mysql://localhost/e-shop?" +
			                                   "user=root&password=root");
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT name FROM `e-shop`.customers where id = '1'");
		    String foundType = rs.getString("name");
		    return foundType;
		}
		catch(Exception e){
			System.err.println("Error" + e);
			return "Error" + e;
		}
		finally{
			if (stmt != null) { stmt.close(); }
		}
	}

	public String sqlInsertCheck() {
		Sql sql = new Sql();
		sql.sqlInsert();
		return sqlCheck;
	}
}