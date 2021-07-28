package com.example.designpatterns;

public class TestDesignPatterns {

	public static void main(String args[]) {

		User akshay = new User("Akshay", "Havale");
		System.out.println(akshay);
		System.out.println(akshay.hashCode());
		akshay = new User("Akshay", "Havale");
		System.out.println(akshay);
		System.out.println(akshay.hashCode());
	}

}
