package com.test.sql;

import com.test.dao.PersonDTO;
import com.test.dao.PersonDAO;

public class DBApp {

	public static void main(String[] args)  throws Exception{
		//Read person Input
		PersonDAO dao = new PersonDAO();
		dao.insert(new PersonDTO(100, "Rama", "Krishna", "Chanlder", "AZ"));

	}

}
