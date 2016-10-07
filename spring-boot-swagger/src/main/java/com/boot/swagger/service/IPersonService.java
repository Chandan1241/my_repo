package com.boot.swagger.service;

import com.boot.swagger.to.Person;

public interface IPersonService {
	public Person getPersonDetailsBySSN(String ssn);
}
