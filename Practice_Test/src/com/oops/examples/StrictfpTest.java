package com.oops.examples;

public  class StrictfpTest {
	public strictfp double getValue() {
		return 12.2500D;
	}
	
	public static void main(String[] args) {
		StrictfpTest obj = new StrictfpTest();
		System.out.println(obj.getValue());
	}
}
