package com.boot.swagger.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.swagger.dao.IPersonDAO;
import com.boot.swagger.to.Person;

@Service
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private IPersonDAO personDAO;

	@Override
	public Person getPersonDetailsBySSN(String ssn) {
		if (null == ssn || ssn.isEmpty()) {
			throw new IllegalArgumentException("SSN must not be NULL");
		}

		Map<String, Person> personsData = personDAO.getAllPersonDetails();

		Person finalResp = personsData.get(ssn);
		if (null == finalResp) {
			throw new IllegalStateException("SSN is invalid");
		}
		return finalResp;
	}

}
