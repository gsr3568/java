package com.test.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBRead {

	public static void main(String[] args) throws Exception {
		
		//printStudentDetails("99999");
		//printStudentDetails1("MS");
		System.out.println("==================");
	
		//printStudentDetails1("MBBS OR 1=1"); //SQL Injection
		insertDBRecord();
	}
	
	public static void printStudentDetails(String sno) throws Exception{
		Connection connection = DBUtil.getDBConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from Student where sno = " + sno);
		while(rs.next()){
			System.out.println("Sno  " + rs.getInt("Sno"));
			System.out.println("Sname  " + rs.getString("Sname"));
			System.out.println("Course  " + rs.getString("Course"));
			System.out.println("Fee  " + rs.getInt("Fee"));
		}
		
	}
	
	public static void printStudentDetails1(String course) throws Exception{
		Connection connection = DBUtil.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("Select Course, Fee from Student where course =  ?");
		pstmt.setString(1, course);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			//System.out.println("Sno  " + rs.getInt("Sno"));
			//System.out.println("Sname  " + rs.getString("Sname"));
			System.out.println("Course  " + rs.getString("Course"));
			System.out.println("Fee  " + rs.getInt("Fee"));
		}
		
	}
	
	public static void insertDBRecord() throws Exception{
		Connection connection = DBUtil.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("INSERT INTO persons VALUES (?,?,?,?,?)");
		for(int i=9000;i<10000;i++){
			pstmt.setInt(1, i);
			pstmt.setString(2, "Fname"+i);
			pstmt.setString(3, "lname"+i);
			pstmt.setString(4, "City"+i);
			pstmt.setString(5, "State"+i);
			pstmt.executeUpdate();
		}
	}
	
	public static void insertDBRecordStmt() throws Exception{
		Connection connection = DBUtil.getDBConnection();
		Statement stmt = connection.createStatement();
		//PreparedStatement pstmt = connection.prepareStatement("INSERT INTO persons VALUES (?,?,?,?,?)");
		for(int i=11000;i<12000;i++){
			stmt.executeUpdate(" INSERT INTO persons VALUES(" +  i + ", '" +"Fname"+i+"',"
					+", '" +"Lname"+i+"',"
					+", '" +"City"+i+"',"
					+", '" +"Address"+i+"')");
		}
	}

}
