package com.eshop.model;

import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;

public class ShrinkDataDB {
	private String shrinkRes;
	private JdbcTemplate jdbcTemplate;

	public String shrinkDataDB() throws SQLException {
		try {
			jdbcTemplate.execute("OPTIMIZE TABLE trafficlight");
			shrinkRes = "The table was optimizing successfully!";
			return shrinkRes;
		} catch (Exception e) {
			return "Error " + e;
		}
	}
}