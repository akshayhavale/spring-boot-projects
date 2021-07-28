package com.example.multithreading.concepts;

import java.util.Random;

public class MyThread implements Runnable {

	@Override
	public void run() {
		synchronized (this) {
			long startTime1 = System.currentTimeMillis();

			System.out.println("Thread Name = " + Thread.currentThread().getName());
			Algorithms algorithms = new Algorithms();
			int number = Math.abs(new Random().nextInt());
			System.out.println("Number is = " + number + " from Thread = " + Thread.currentThread().getName());
			boolean flag = algorithms.isPrimeNumber(number);
			System.out.println("Result = " + flag + " from Thread = " + Thread.currentThread().getName());

			long endTime1 = System.currentTimeMillis();
			System.out.println(
					"Time taken = " + (endTime1 - startTime1) + " from Thread = " + Thread.currentThread().getName());
		}

	}

}
