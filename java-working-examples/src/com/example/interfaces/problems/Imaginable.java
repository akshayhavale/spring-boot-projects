package com.example.interfaces.problems;

/**
 * 
 * @author akshayhavale
 * 
 *         Simple i created 2 abstract methods to check the interface working
 *         when 2 interfaces with same abstract method it has
 * 
 */
public interface Imaginable {

	/**
	 * 
	 * Same --- 1) returnType 2) Input 3
	 */
	public String m1();

	/**
	 * 
	 * 1) Different returnType 2) same Input
	 */
	public Integer m2(int marks);

	/**
	 * 
	 * Both different
	 */
	public Double m3(Double d);

	/**
	 * 
	 * 1) Same returnType 2) different Input
	 */
	public String m4(Long value);

}
