package com.cg.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.bank.exception.BankException;



public class ConnectionFactory {
	
	private static ConnectionFactory sigtonObj;

	public static ConnectionFactory getSigtonObj() {

		if (sigtonObj == null)
			sigtonObj = new ConnectionFactory();

		return sigtonObj;

	}

	public Connection getConnection() throws BankException{
		Connection con = null;
		
			//FileInputStream fis = new FileInputStream("resource/oracledb.properties");
			//Properties prop = new Properties();
			//prop.load(fis);
			// String driver=prop.getProperty("db.driver");
		
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:XE"; // prop.getProperty("db.url");
			String user = "system"; // prop.getProperty("db.user");
			String pwd = "Capgemini123"; // prop.getProperty("db.pass");
			//Class.forName(driver).newInstance();
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				throw new BankException("driver problem!!!!!!!!!!!!!!");
			}
			try {
				con = DriverManager.getConnection(url, user, pwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new BankException("connection problem!!!!!!!!!!!!!!");
			}
			
			if(con == null)
				System.out.println("con is null....");
		
		return con;
	}

}



