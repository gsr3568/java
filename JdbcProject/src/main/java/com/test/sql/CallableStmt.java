package com.test.sql;

import java.sql.CallableStatement;
import java.sql.Connection;

public class CallableStmt {

	public static void main(String[] args) throws Exception{
		//Get the Connection
		Connection connection =  DBUtil.getDBConnection();
		connection.setAutoCommit(false);
		
		CallableStatement cstmt =  connection.prepareCall("{call insertStudent}");
		cstmt.executeUpdate();
		connection.commit();
	}

}
