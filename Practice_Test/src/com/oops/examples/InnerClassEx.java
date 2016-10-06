package com.oops.examples;

class Test {

	static class Student {
		public void display() {
			System.out.println("Inner class method");
		}
	}

	class Student2 {
		public void display() {
			System.out.println("Inner class method");
		}
	}

	void display() {
		System.out.println("Outer class method");
	}

}

public class InnerClassEx {
	public static void main(String[] args) {
		Test ex = new Test();
		ex.display();

		Test.Student st = new Test.Student();
		st.display();

		Test.Student2 st2 = new Test().new Student2();
		st2.display();

	}
}
