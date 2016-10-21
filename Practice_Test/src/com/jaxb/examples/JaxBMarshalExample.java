package com.jaxb.examples;

import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.oops.examples.TO.Address;
import com.oops.examples.TO.Person;

public class JaxBMarshalExample {

	public static void main(String[] args) {
		
		Person p = new Person();
		p.setPersonId(100L);
		p.setFirstName("Chandan");
		p.setMiddleName("Singh");
		p.setLastName("Singh");
		p.setPhoneName("123-456-7890");
		p.setEmailId("abc@gmail.com");
		Address add = new Address();
		add.setPersonId(100L);
		add.setStreet("12345 Street State");
		add.setCity("San Jose");
		add.setCountry("USA");
		add.setZipcode("94531");
		p.setAddress(add);

		try {
			JAXBContext context = JAXBContext.newInstance(Person.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(p, new FileOutputStream("E:/person.xml"));
			System.out.println("Successfully generated....");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
