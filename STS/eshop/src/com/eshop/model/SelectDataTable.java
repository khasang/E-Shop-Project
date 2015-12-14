package com.eshop.model;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class SelectDataTable {
	private JdbcTemplate jdbcTemplate;
	private DatabaseMetaData dbmd = null;
	private ResultSet resultSet = null;

	public SelectDataTable(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<String> viewTable(String tableName) {
		String query = "SELECT id, name, amount FROM " + tableName;
		ArrayList<String> list = new ArrayList<String>();
		Statement pStatment = null;
		ResultSet resultSet = null;
		try {
			pStatment = jdbcTemplate.getDataSource().getConnection().createStatement();
			resultSet = pStatment.executeQuery(query);
			while (resultSet.next()) {
				list.add(resultSet.getString("id"));
				list.add(resultSet.getString("name"));
				list.add(resultSet.getString("amount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatment != null) {
					pStatment.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<String> dataBaseAllTableName() {
		dbmd = null;
		resultSet = null;
		List<String> list = new ArrayList<String>();
		try {
			dbmd = jdbcTemplate.getDataSource().getConnection().getMetaData();
			String[] types = { "TABLE" };
			resultSet = dbmd.getTables(null, null, "%", types);
			while (resultSet.next()) {
				String tableName = resultSet.getString(3);
				list.add(tableName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return list;
	}

	public List<String> getTableColumnName(String tableName) {
		dbmd = null;
		resultSet = null;
		List<String> list = new ArrayList<String>();
		try {
			dbmd = jdbcTemplate.getDataSource().getConnection().getMetaData();
			resultSet = dbmd.getColumns(null, null, tableName, null);
			while (resultSet.next()) {
				String tableColumnName = resultSet.getString("COLUMN_NAME");
				list.add(tableColumnName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return list;
	}
}
