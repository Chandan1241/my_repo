package com.oops.examples.TO;

public class User implements Cloneable {

	private Integer id;
	private String name;
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//this is a Object class method not Cloneable interface
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
