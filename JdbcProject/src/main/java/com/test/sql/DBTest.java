package com.test.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args)throws Exception {
		
		//Load Driver Class NAme
		//Class.forName("com.mysql.jdbc.Driver");
		
		//Get the Connection
		Connection connection =  DBUtil.getDBConnection();//DriverManager.getConnection("jdbc:mysql://localhost:3306/decdb", "root", "root");
		
		Connection connection1 =  DBUtil.getDBConnection();
		
		//Peforming DB
		Statement stmt = connection.createStatement();
		
		/*stmt.execute("CREATE TABLE Persons"
				+ "(PersonID int,LastName varchar(255),"
				+ "FirstName varchar(255),Address varchar(255),"
				+ "City varchar(255)); ");
		
		System.out.println("Table created Successfully");*/
		/*//Insert
		int result = stmt.executeUpdate("INSERT INTO persons VALUES (9876,'Tim','W','Chandler','AZ')");
		System.out.println(" Inserted " + result + "Records SuccessFully in DB");*/
		
		//Update
	/*	int result = stmt.executeUpdate("Update persons Set City='AZ' where PersonID = 1000");
		System.out.println(" Updated " + result + " Records SuccessFully in DB");*/
		
		//Delete
		
		int result = stmt.executeUpdate("DELETE from  persons where PersonID = 9999");
		System.out.println(" Deleted " + result + " Records SuccessFully in DB");
		
		connection.close();
	}

}
