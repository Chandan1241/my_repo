package com.mail.TO;

import java.util.List;

public class ResponseObject {
	private List<String> possiblePhoneNumbers;
	private int status;
	private String message;
	private int totalNoofCombinations;

	public int getTotalNoofCombinations() {
		return totalNoofCombinations;
	}

	public void setTotalNoofCombinations(int totalNoofCombinations) {
		this.totalNoofCombinations = totalNoofCombinations;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getPossiblePhoneNumbers() {
		return possiblePhoneNumbers;
	}

	public void setPossiblePhoneNumbers(List<String> possiblePhoneNumbers) {
		this.possiblePhoneNumbers = possiblePhoneNumbers;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
