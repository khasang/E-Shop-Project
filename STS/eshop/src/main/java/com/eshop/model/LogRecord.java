package com.eshop.model;

public class LogRecord {
	private String tableName, operation, result;

	public LogRecord(String tableName, String operation, String result) {
		this.tableName = tableName;
		this.operation = operation;
		this.result = result;
	}

	public String getTableName() {
		return tableName;
	}

	public String getOperation() {
		return operation;
	}

	public String getResult() {
		return result;
	}

	@Override
	public String toString() {
		return String.format("<tr><td>%s</td><td>%s</td><td>%s</td></tr>", tableName, operation, result);
	}
}