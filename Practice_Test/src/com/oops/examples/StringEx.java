package com.oops.examples;

public class StringEx {

	public static void main(String[] args) {

		String a = "chandan";
		String b = "chandan";
		if (a.hashCode() == b.hashCode()) {
			System.out.println(true);
		}

		String n1 = new String("singh");
		String n2 = new String("singh");
		if (n1.hashCode() == n2.hashCode())
			System.out.println(true);
		
		StringBuffer sb = new StringBuffer();
		sb.append("chandan");
		
		StringBuffer sb1 = new StringBuffer();
		sb1.append("chandan");
		
		if (sb.hashCode() == sb1.hashCode()) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
		
		StringBuilder sb2 = new StringBuilder();
		sb2.append("chandan");
		
		StringBuilder sb3 = new StringBuilder();
		sb3.append("chandan");
		
		if (sb2.hashCode() == sb3.hashCode()) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
		
		

	}

}
