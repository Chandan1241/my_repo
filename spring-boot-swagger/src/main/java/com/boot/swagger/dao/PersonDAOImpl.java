package com.boot.swagger.dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.boot.swagger.to.Address;
import com.boot.swagger.to.Education;
import com.boot.swagger.to.Person;

@Repository
public class PersonDAOImpl implements IPersonDAO {

	private Map<String, Person> data = new HashMap<String, Person>();

	@PostConstruct
	public void setUp() {

		Person p = new Person();
		p.setFirstName("Chandan");
		p.setMiddleName("Singh");
		p.setLastName("India");
		p.setPersonId(100L);
		p.setSsn("123-456-789");

		Address addr = new Address();
		addr.setStreet1("12345 SOME ADDRESS");
		addr.setStreet2("Apt #200");
		addr.setCity("San Jose");
		addr.setCountry("USA");
		addr.setPhoneNumber(7894561230L);
		addr.setState("CA");
		addr.setZipCode(94538L);

		p.setAddress(addr);

		Education educ = new Education();
		educ.setCourse("Computer Science");
		educ.setMajor("Masters");
		educ.setUniversity("SJSU");
		educ.setUniversityAddress(addr);

		p.setEducation(educ);

		data.put("123456789", p);
		data.put("100400700", p);
	}

	public Map<String, Person> getData() {
		return data;
	}

	public void setData(Map<String, Person> data) {
		this.data = data;
	}

	/**
	 * Constant Data as we don't have any DATABSE Here
	 */
	@Override
	public Map<String, Person> getAllPersonDetails() {
		return getData();
	}

}
