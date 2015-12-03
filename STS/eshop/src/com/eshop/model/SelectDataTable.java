package com.eshop.model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SelectDataTable {
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "1111";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/e-shop";
	private static final String TABLE_NAME = "trafficlight";
	public List<DataTable> list = new ArrayList<>();

	public SelectDataTable() {
		try {
			viewTable(getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // it's need for work
													// connection
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Connected to database");
		return (Connection) DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
	}

	private void viewTable(Connection con) {
		Statement stmt = null;
		DataTable dt = new DataTable();
		String query = "select ID, minute, color " + "from " + TABLE_NAME;
		try {
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("ID");
				int minute = rs.getInt("minute");
				String color = rs.getString("color");
				System.out.println("ID = " + id + " minute = " + minute + " color = " + color);
				dt.setID(id);
				dt.setMinute(minute);
				dt.setColor(color);
				list.add(dt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
