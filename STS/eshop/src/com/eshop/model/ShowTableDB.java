package com.eshop.model;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ShowTableDB {
	private JdbcTemplate jdbcTemplate;
	private DatabaseMetaData dbmd = null;
	private ResultSet resultSet = null;
	private List<String> tablesList = new ArrayList<String>();

	public void setTablesList(List<String> tablesList) {
		this.tablesList = tablesList;
	}

	public List<String> getTablesList() {
		return tablesList;
	}

	public ShowTableDB(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public ShowTableDB() {

	}

	public List<String> listTables() {
		dbmd = null;
		resultSet = null;
		tablesList.clear();
		try {
			dbmd = jdbcTemplate.getDataSource().getConnection().getMetaData();
			String[] types = { "TABLE" };
			resultSet = dbmd.getTables(null, null, "%", types);
			while (resultSet.next()) {
				String tableName = resultSet.getString(3);
				tablesList.add(tableName);
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
		return tablesList;
	}
}