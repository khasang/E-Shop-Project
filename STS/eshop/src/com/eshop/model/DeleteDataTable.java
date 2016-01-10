package com.eshop.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class DeleteDataTable {
	private JdbcTemplate jdbcTemplate;
	private String result;

	public DeleteDataTable(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void dropDataTable(String tableName) {
		try {
			jdbcTemplate.execute("DROP TABLE `eshop`.`" + tableName.toLowerCase() + "` ");
			result = "Purchase " + tableName + " deleted";
		} catch (Exception e) {
			result = "Error on delete purchase " + tableName;
		}
	}

	public void deleteDataFromTable(String selectedOrderId) {
		try {
			int id = Integer.parseInt(selectedOrderId);
			jdbcTemplate.execute("DELETE FROM product WHERE id=" + id + ";");
		} catch (Exception e) {
			result = "Error on delete product  id" + selectedOrderId;
		}
	}

	public String getResult() {
		return result;
	}
}