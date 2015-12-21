package com.eshop.model;

import java.sql.*;
import java.util.*;

import org.springframework.jdbc.core.JdbcTemplate;

public class DescribeTableInfoColumns {
	private JdbcTemplate jdbcTemplate;
	
	public DescribeTableInfoColumns(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<String> getTableNames1(){
		List<String> tableNames = new ArrayList<String>();
		try {
			DatabaseMetaData meta = jdbcTemplate.getDataSource().getConnection().getMetaData();
			String[] type = {"TABLE"};
			ResultSet res = meta.getTables(null, null, "%", type);
			while (res.next()) {
				tableNames.add(res.getString(3));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tableNames;
	}
	
	@SuppressWarnings("unused")
	private List<String> getTableNames() throws SQLException {
		List<String> tablesNames = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		try {
			con = DriverManager.getConnection("mysql://localhost/e-shop");
			DatabaseMetaData meta = con.getMetaData();
			res = meta.getTables(null, null, null, null);
			// tablesNames = new ArrayList <String>();
			while (res.next()) {
				tablesNames.add(res.getString("COLUMN_NAME"));
			}
			String[] columnNames = new String[tablesNames.size()];
			tablesNames.toArray(columnNames);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (res != null)
					res.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return tablesNames;
	}

	@SuppressWarnings("unused")
	private List<String> getTableColumnsNames() throws SQLException {
		List<String> tableColumnNames = new ArrayList<String>();
		;
		String tableName = "eshop";
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		try {
			con = DriverManager.getConnection("mysql:// localhost/e-shop");
			DatabaseMetaData meta = con.getMetaData();
			res = meta.getColumns(null, null, tableName, null);
			while (res.next()) {
				tableColumnNames.add(res.getString("COLUMN_NAME"));
			}
			String[] columnNames = new String[tableColumnNames.size()];
			tableColumnNames.toArray(columnNames);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (res != null)
					res.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return tableColumnNames;
	}
}