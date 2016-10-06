package com.oops.examples;

import com.oops.examples.TO.User;

public class CloneExample {
	public static void main(String[] args) throws Exception {
		User us = new User();
		us.setId(123);
		us.setName("ABC");
		us.setEmail("abc@d.com");
		
		
		User us1 = (User) us.clone();
		
		System.out.println(us1.getEmail());
		System.out.println(us.getEmail());
		
		
	}

}
