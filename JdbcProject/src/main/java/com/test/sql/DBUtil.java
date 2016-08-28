package com.test.sql;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
	
	private static Properties dbProperties = new Properties();
	
	static{
		try{
//			FileInputStream fileInStream = new FileInputStream("C:\\Dec2015\\JdbcProject\\src\\main\\java\\database.properties");
			dbProperties.load(DBUtil.class.getResourceAsStream("database.properties"));
			System.out.println("DB PRoperties : " + dbProperties);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static Connection getDBConnection(){
		//Load Configurations
		try{
			
			//FileInputStream fileInStream = new FileInputStream("C:\\Dec2015\\JdbcProject\\src\\main\\java\\database.properties");
			//dbProperties.load(fileInStream);
			
			//Load Driver Class NAme
			Class.forName(dbProperties.getProperty("dbClassName"));
			
			//Get the Connection
			Connection connection =  DriverManager.getConnection(dbProperties.getProperty("url"),
					dbProperties.getProperty("username"), dbProperties.getProperty("password"));
			
			return connection;
			
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Failed to Create DB Connection");
		}
		
		return null;
	}

}
