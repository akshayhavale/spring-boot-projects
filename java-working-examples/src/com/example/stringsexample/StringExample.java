package com.example.stringsexample;

public class StringExample {

	public static void main(String[] args) {

		String str1 = "Akshay";

		String str2 = "Akshay";

		String str3 = new String("Akshay");
		String str4 = new String("Akshay");

		String str5 = str4;

		String str6 = str2;
		System.out.println(str1.hashCode() + "   " + str1);
		System.out.println(str2.hashCode() + "   " + str2);
		System.out.println(str3.hashCode() + "   " + str3);
		System.out.println(str4.hashCode() + "   " + str4);

		System.out.println("=========================================");

		// check str1 == str2 this compares the reference are same

		System.out.println("str1 == str2 Is  " + str1 == str2);

		System.out.println("str2==str3 Is  " + str2 == str3);

		System.out.println("str3==str4 Is  " + str3 == str4);

		System.out.println("str4==str5 Is  " + str4 == str5);

		System.out.println("str6==str2 Is  " + str6 == str2);

		System.out.println("=========================================");

		// check str1.equals(str2) this compares the object location

		System.out.println("str1.equals(str2) Is  " + str1.equals(str2));

		System.out.println("str2.equals(str3) Is  " + str2.equals(str3));

		System.out.println("str3.equals(str4) Is " + str3.equals(str4));

		System.out.println("str4.equals(str5) Is  " + str4.equals(str5));

	}

}
