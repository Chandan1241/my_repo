package com.boot.swagger.to;

import java.io.Serializable;

public class Education implements Serializable {

	private static final long serialVersionUID = 3L;
	private String major;
	private String course;
	private String university;
	private Address universityAddress;

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public Address getUniversityAddress() {
		return universityAddress;
	}

	public void setUniversityAddress(Address universityAddress) {
		this.universityAddress = universityAddress;
	}

}
