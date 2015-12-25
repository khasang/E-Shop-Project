package com.eshop.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BackupDB {

	public BackupDB() {
	}

	static String backupResult;
	private String path;

	public BackupDB(String path) {
		this.path = path;
	}

	public String backupResultOutput() {
		backupDatabase();
		return backupResult;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path + "\\backup.sql";
	}

	public void backupDatabase() {
		Process backupProcess = null;
		try {
			Runtime runtime = Runtime.getRuntime();
			String command = "mysqldump eshop -u root -proot -r \"" + path + "\"";
			backupProcess = runtime.exec(command);
			int processComplete = backupProcess.waitFor();
			if (processComplete == 0) {
				backupResult = "Backup created successfully!<br>Path: " + path;
			} else {
				try(BufferedReader stdInput = new BufferedReader(
						new InputStreamReader(backupProcess.getErrorStream()))){
				String comandOutput = null;
				StringBuilder result = new StringBuilder();				
				while ((comandOutput = stdInput.readLine()) != null) {
				    result.append(comandOutput);
				}				
				backupResult = "Could not create the backup " + command  +"<br>" + result.toString();
				}
			}						
		} catch (Exception e) {
			backupResult = "Error: " + e;
			e.printStackTrace();		
		}
	}
}
