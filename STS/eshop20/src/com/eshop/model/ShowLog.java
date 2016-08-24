/*package com.eshop.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.jdbc.core.JdbcTemplate;

public class ShowLog {
	private JdbcTemplate jdbcTemplate;

	public ShowLog(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public ArrayList<LogRecord> getLog(String tableName) throws SQLException {
		String query = "SELECT * FROM " + tableName;
		ArrayList<LogRecord> list = new ArrayList<>();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = jdbcTemplate.getDataSource().getConnection().createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				list.add(new LogRecord(resultSet.getString("id"), resultSet.getString("dt"),
						resultSet.getString("table_name"), resultSet.getString("operation"),
						resultSet.getString("result")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}*/