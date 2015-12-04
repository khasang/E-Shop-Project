package com.eshop.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sql {
	public static String sqlCheck;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/e-shop";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";
	static String supplierName;

	private void selectData() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
			// Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql = "SELECT id, name FROM customers";
			ResultSet rs = stmt.executeQuery(sql);
			// Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				supplierName = rs.getString("name");
				// Display values
				System.out.print("ID: " + id);
				System.out.println(", supplier name: " + supplierName);
			}
			rs.close();
		} catch (SQLException e) {
			// Handle errors for JDBC
			e.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException e) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}

	public String selectSupplierName() {
		Sql sql = new Sql();
		sql.selectData();
		return supplierName;
	}

	public void sqlInsert() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
			// Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql = "INSERT INTO `e-shop`.`customers` (`id`, `name`) VALUES ('2', 'RedBull');";
			//ResultSet rs = stmt.executeQuery(sql);
			stmt.executeUpdate(sql);
			System.out.println("Table Updated");
			sqlCheck = "Table Updated";
		} catch (SQLException e) {
			// Handle errors for JDBC
			sqlCheck = "Exception + " + e;
			e.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			sqlCheck = "Exception + " + e;
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException e) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}

	public String sqlInsertCheck() {
		Sql sql = new Sql();
		sql.sqlInsert();
		return sqlCheck;
	}
}