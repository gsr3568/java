package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.sql.DBUtil;

public class PersonDAO {
	
	
	public  void insert(int pID,String fname,String lName,
			String city,String state) throws Exception{
		Connection connection = DBUtil.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("INSERT INTO persons VALUES (?,?,?,?,?)");
			pstmt.setInt(1, pID);
			pstmt.setString(2, fname);
			pstmt.setString(3, lName);
			pstmt.setString(4, city);
			pstmt.setString(5, state);
			pstmt.executeUpdate();
		connection.close();
	}
	
	public  void insert(PersonDTO person) throws Exception{
		Connection connection = DBUtil.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("INSERT INTO persons VALUES (?,?,?,?,?)");
			pstmt.setInt(1, person.getPid());
			pstmt.setString(2, person.getFname());
			pstmt.setString(3, person.getLname());
			pstmt.setString(4, person.getAddress());
			pstmt.setString(5, person.getCity());
			pstmt.executeUpdate();
		connection.close();
	}
	
	public  PersonDTO getPersonByID(int personID) throws DataException{
		Connection connection = DBUtil.getDBConnection();
		try{
			PersonDTO dto = new PersonDTO();
			PreparedStatement pstmt = connection.prepareStatement("Select * from Persons where PersonID=?");
			pstmt.setInt(1, personID);
			ResultSet rs =  pstmt.executeQuery();
			if(rs.next()){
				dto.setPid(rs.getInt("PersonID"));
				dto.setCity(rs.getString("City"));
				dto.setFname(rs.getString("Firstname"));
				dto.setLname(rs.getString("Lastname"));
				dto.setAddress(rs.getString("Address"));
				return dto;
			}else{
				DataException dataException = new DataException("1002", "Person Record Not Found " + personID);
				throw dataException;
			}
		}catch(SQLException ex){
			DataException dataException = new DataException("1000", ex.getMessage());
			ex.printStackTrace();
			throw dataException;
		}finally{
			try{
				connection.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		}
	}
	
	public  List<PersonDTO> getAllPerson() throws DataException{
		Connection connection = DBUtil.getDBConnection();
		List<PersonDTO> personList = new ArrayList<PersonDTO>();
		try{
			PreparedStatement pstmt = connection.prepareStatement("Select * from Persons");
			ResultSet rs =  pstmt.executeQuery();
			while(rs.next()){
				PersonDTO dto = new PersonDTO();
				dto.setPid(rs.getInt("PersonID"));
				dto.setCity(rs.getString("City"));
				dto.setFname(rs.getString("Firstname"));
				dto.setLname(rs.getString("Lastname"));
				dto.setAddress(rs.getString("Address"));
				personList.add(dto);
			}
		}catch(SQLException ex){
			DataException dataException = new DataException("1000", ex.getMessage());
			ex.printStackTrace();
			throw dataException;
		}finally{
			try{
				connection.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		}
		return personList;
	}
	

}
