package com.oops.examples;

public class StackOverFlowExceptionEx {
	public static void main(String[] args) {
		recursion();
	}

	public static void recursion() {
		System.out.println("keep on calling same method");
		recursion();
	}

}
