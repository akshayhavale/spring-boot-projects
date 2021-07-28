package com.example.javamemorymodel;

public class TestJMM {

	private int count = 1;

	public static void main(String[] args) {
		TestJMM jmm = new TestJMM();

		jmm.setCount(3);

		System.out.println(jmm.getCount());

	}

	public void setCount(int number) {
		count = count + number;
	}

	public int getCount() {
		return count;
	}

}
