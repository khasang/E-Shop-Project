package com.eshop.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
public class ShrinkDataDB {
	public static String sqlCheck;

	Connection getConnection(){
		
		return null;
	}
	
	void getDataSource(){
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(DBRegistrationData.DRIVER);
		dataSource.setUsername(DBRegistrationData.USERNAME);
		dataSource.setUrl(DBRegistrationData.URL);
		dataSource.setPassword(DBRegistrationData.PASSWORD);
	}
	
	public String shrinkDataDB() throws SQLException {
		Statement stmt = null;
		Connection conn = null;
		getDataSource();
		try{
		conn =  DriverManager.getConnection(DBRegistrationData.URL + "?"
												+ "user=" + DBRegistrationData.USERNAME
												+ "&password=" + DBRegistrationData.PASSWORD);
		    stmt = conn.createStatement();
		    stmt.executeQuery("OPTIMIZE TABLE trafficlight");
		   }
		catch(Exception e){
			System.err.println("Error" + e);
			return "Error" + e;
		}
		finally{
			if (stmt != null) { stmt.close(); }
		}
		return "The table was optimizing successfully!";
	}
	
}
