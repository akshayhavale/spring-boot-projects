package com.example.multithreading.concepts;

import java.util.Random;

public class MainThreadApp {

	public static void main(String[] args) {
		System.out.println("Main Thread = " + Thread.currentThread().getName());

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 2; i++) {

			System.out.println("Thread Name = " + Thread.currentThread().getName());
			Algorithms algorithms = new Algorithms();
			int number = Math.abs(new Random().nextInt());
			System.out.println("Number is = " + number + " From Main Thread");
			boolean flag = algorithms.isPrimeNumber(number);
			System.out.println("Result = " + flag + " from Main thread");

		}
		long endTime = System.currentTimeMillis();

		System.out.println("TIme main thread taken = " + (endTime - startTime));
	}
}
