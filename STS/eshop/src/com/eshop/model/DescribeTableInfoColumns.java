package com.eshop.model;

import java.sql.*;
import java.util.*;

public class DescribeTableInfoColumns {
	private ArrayList<String> tableColumnNames;

	private void getTableColumnsNames() throws SQLException {
		String tableName = "eshop";
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		try {
			con = DriverManager.getConnection("mysql://localhost/e-shop");
			DatabaseMetaData meta = con.getMetaData();
			res = meta.getColumns(null, null, tableName, null);
			tableColumnNames = new ArrayList<String>();
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
	}

	public void showTableColumnNames() throws SQLException {
		getTableColumnsNames();
		for (String s : tableColumnNames) {
			System.out.println(s);
		}
	}
}