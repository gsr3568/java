package com.test.sql;

import java.util.List;

import com.test.dao.DataException;
import com.test.dao.PersonDAO;
import com.test.dao.PersonDTO;

public class DAOApp {

	public static void main(String[] args) throws DataException {
		PersonDAO dao =  new PersonDAO();
		PersonDTO personDTO = dao.getPersonByID(999);
		System.out.println(personDTO);
		
		System.out.println("================");
		List<PersonDTO> personList = dao.getAllPerson();
		System.out.println(" Size " + personList.size());

	}

}
