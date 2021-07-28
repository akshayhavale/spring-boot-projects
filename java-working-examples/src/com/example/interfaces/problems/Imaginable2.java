package com.example.interfaces.problems;

public interface Imaginable2 {

	/**
	 * 
	 * Same --- 1) returnType 2) Input 3			--> Hurrey This is passed which implemented this method
	 */
	public String m1();

	/**
	 * 
	 * 1) Different returnType 2) same Input
	 */
	public Double m2(int marks);			

	/**
	 * 
	 * Both different
	 */
	public String m3(String d);

	/**
	 * 
	 * 1) Same returnType 2) different Input
	 */
	public String m4(String value);

}
