package com.oops.examples;

public class ArrayInJava {
	static final String LS = System.lineSeparator();

	public static void main(String[] args) {
		int a[] = new int[2];
		System.out.println(a.getClass());

		int arr[][] = { { 1, 2, 3 }, { 2, 4, 5 }, { 4, 4, 5 } };
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.print(LS);
		}
	}

}
