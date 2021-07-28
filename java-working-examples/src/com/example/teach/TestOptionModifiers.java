package com.example.teach;

public class TestOptionModifiers {

	private static String[] names = new String[] { "RAJ", "AKSHAY" };

	public static void main(String[] args) {

		System.out.println(names[0] + "  " + names[1]);

		TestOptionModifiers test = new TestOptionModifiers();
		System.out.println(test.sum(1, 2));

	}

	public long sum(int num1, int num2) {

		int multiPlyResultNum2 = num2 * 2;

		return (long) num1 + multiPlyResultNum2;
	}

}
