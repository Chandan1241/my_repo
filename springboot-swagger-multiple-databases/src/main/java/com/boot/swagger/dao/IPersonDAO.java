package com.boot.swagger.dao;

import java.util.Map;

import com.boot.swagger.to.Person;

public interface IPersonDAO {
	Map<String, Person> getAllPersonDetails();

}
