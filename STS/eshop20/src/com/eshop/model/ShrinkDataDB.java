package com.eshop.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ShrinkDataDB {
	private JdbcTemplate jdbcTemplate;
	private List<String> tablesToOptimize;

	public List<String> getTablesToOptimize() {
		return tablesToOptimize;
	}

	public void setTablesToOptimize(List<String> tablesToOptimize) {
		this.tablesToOptimize = tablesToOptimize;
	}

	public ShrinkDataDB() {
	}

	public ShrinkDataDB(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<LogRecord> optimizeTables() {
		LogRecord optimizeResult;
		List<LogRecord> resultList = new ArrayList<LogRecord>();
		for (String tableName : tablesToOptimize) {
			optimizeResult = shrinkDataDB(tableName);
			resultList.add(optimizeResult);
			saveToLog(optimizeResult);
		}
		return resultList;
	}

	public void saveToLog(LogRecord record) {
		try {
			jdbcTemplate.update("INSERT INTO eshop.log(dt,table_name,operation,result) " + "VALUES(sysdate(), ?, ?, ?)",
					record.getTableName(), record.getOperation(), record.getResult());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	public LogRecord shrinkDataDB(String tableName) {
		String operationResult;
		try {
			jdbcTemplate.execute("OPTIMIZE TABLE " + tableName);
			operationResult = "success";
		} catch (DataAccessException e) {
			operationResult = "error: " + e;
			e.printStackTrace();
		}
		return new LogRecord(tableName, "optimize", operationResult);
	}
}