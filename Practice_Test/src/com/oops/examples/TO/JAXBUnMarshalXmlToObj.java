package com.oops.examples.TO;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class JAXBUnMarshalXmlToObj {
	
	public static void main(String[] args) throws Exception {
		
		JAXBContext context =  JAXBContext.newInstance(Person.class);
		File file = new File("E:/person.xml");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Person person = (Person) unmarshaller.unmarshal(file);
		System.out.println("Data : " +person.getPersonId());
		
	}

}
