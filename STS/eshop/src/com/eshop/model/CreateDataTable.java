package com.eshop.model;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class CreateDataTable {
	private static final String DB_URL = "mysql://localhost/e-shop";
	private static final String USER = "root";
	private static final String PASS = "root";
	public static String sqlCheck;

	public void sqlTableCreate() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// Open a connection
			System.out.println("Connecting to a selected database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
			// Execute a query
			System.out.println("Creating statement...");
			stmt = (Statement) conn.createStatement();
			// String sql = "INSERT INTO `e-shop`.`customers` (`id`, `name`)
			// VALUES ('2', 'RedBull');";
			String sql = "CREATE TABLE trafficlight (" + "id INT NOT NULL AUTO_INCREMENT," + "minute INT NOT NULL,"
					+ "color VARCHAR(6) NOT NULL," + "PRIMARY KEY (id));";
			// ResultSet rs = stmt.executeQuery(sql);
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
}
