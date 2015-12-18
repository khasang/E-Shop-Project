package com.eshop.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class ShrinkDataDB {
	private JdbcTemplate jdbcTemplate;
	public ShrinkDataDB(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<LogRecord> optimizeAllTables(){
		LogRecord optimizeResult;
		List<LogRecord> resultList = new ArrayList<LogRecord>();
	  	List<String> tableList = jdbcTemplate.queryForList("SHOW TABLES FROM ESHOP",String.class);
	  for(String tableName:tableList){  
		  optimizeResult = shrinkDataDB(tableName);
		  resultList.add(optimizeResult);
	      saveToLog(optimizeResult);	    
	  }      
	  	return resultList;
	}
	
   public void saveToLog(LogRecord record){
		 jdbcTemplate.update("INSERT INTO eshop.log(dt,table_name,operation,result) "
		 		+ "VALUES(sysdate(), ?, ?, ?)", 
				record.getTableName(),
				record.getOperation(),
				record.getResult());
   }
	
	public LogRecord shrinkDataDB(String tableName) {
		String operationResult;
		try {		
			 jdbcTemplate.execute("OPTIMIZE TABLE " + tableName);			 
			 operationResult = "success";			 
		} catch (DataAccessException e) {
			operationResult = "error: " + e;
		 }		
		return new LogRecord(tableName,"optimize",operationResult);
	}
	
	
}