package com.eshop.model;

public class BackupDB {
	static String backupResult;
	
    public String backupResultOutput(){
      backupDatabase();
      return backupResult;
    }
	
	public void backupDatabase() {
		Process backupProcess = null;
		try {
			Runtime runtime = Runtime.getRuntime();
			backupProcess = runtime.exec(
					"mysqldump eshop -u root -proot -r \"C:\\ProgramData\\MySQL\\MySQL Server 5.7\\Uploads\\backup.sql\"");
			int processComplete = backupProcess.waitFor();
			if (processComplete == 0) {
				backupResult = "Backup created successfully!";
			} else {
				backupResult = "Could not create the backup";
			}
		} catch (Exception e) {
			backupResult = "Error: " + e;
			e.printStackTrace();
		}
	}
}
