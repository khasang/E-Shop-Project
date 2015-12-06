package com.eshop.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class DeleteDataTable {
	private static DeleteDataTable instance;
	SimpleDriverDataSource dataSource;
	JdbcTemplate jdbcTemplate;
	String resultMessage;
	

	private DeleteDataTable() {
		dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost/eshop");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}	

	public static DeleteDataTable getInstance() {
		if (instance == null) {
			instance = new DeleteDataTable();
		}
		return instance;
	}
	
	public void deleteTable(String tableName){
		try{
		jdbcTemplate.execute("DROP TABLE "+ tableName);
		resultMessage = "Table " + tableName + " deleted successfully";
		}catch(Exception e){
			resultMessage = "Error ocurred: " + e;
			e.printStackTrace();
		}
	}
	
	public String getResultMessage(){
		return resultMessage;
	}
}
