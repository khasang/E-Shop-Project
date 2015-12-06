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

	public SelectDataTable() {
	}

	private Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // it's need for work
													// connection
			connection = (Connection) DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public List<DataTable> viewTable() {
		List<DataTable> list = new ArrayList<>();
		Statement statement = null;
		Connection connection = getConnection();
		String query = "select ID, minute, color " + "from " + TABLE_NAME;
		try {
			statement = (Statement) connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				DataTable dataTable = new DataTable();
				dataTable.setID(resultSet.getInt("ID"));
				dataTable.setMinute(resultSet.getInt("minute"));
				dataTable.setColor(resultSet.getString("color"));
				list.add(dataTable);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
