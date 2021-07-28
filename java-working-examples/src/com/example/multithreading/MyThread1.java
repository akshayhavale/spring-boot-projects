package com.example.multithreading;

public class MyThread1 implements Runnable {

	@Override
	public void run() {
		long threadTaskStartTime = System.currentTimeMillis();
		System.out.println(checkIsPrimeNumber(82589933));
		System.out.println(checkIsPrimeNumber(82589933));
		System.out.println(checkIsPrimeNumber(82589933));
		System.out.println(checkIsPrimeNumber(82589933));
		System.out.println(checkIsPrimeNumber(82589933));
		System.out.println(checkIsPrimeNumber(82589933));
		System.out.println(checkIsPrimeNumber(82589933));
		System.out.println(checkIsPrimeNumber(82589933));
		System.out.println(checkIsPrimeNumber(82589933));
		System.out.println(checkIsPrimeNumber(82589933));

		long threadTaskEndTime = System.currentTimeMillis();

		System.out
				.println("Time taken by thread task = " + (threadTaskEndTime - threadTaskStartTime) + " milliseconds");

	}

	public boolean checkIsPrimeNumber(int number) {

		boolean flag = false;

		/*
		 * 
		 * Conditions to verify is boolean
		 * 
		 * 1) It should be greater than zero
		 * 
		 * 2) It should be only divide by itself and not by any other number except 1
		 * 
		 * Logic
		 * 
		 * 1) check number is greater than 1
		 * 
		 * 2) if number = 1 and 2 return its prime number
		 * 
		 * 3) More than 2 value of number then iterate from reverse side decreasing
		 * count of that number and check is divisible by using number%value==0
		 * 
		 * 4) If all conditions satisfy then return the result in boolean
		 * 
		 * 
		 */

		if (number <= 0) {
			return false;
		}

		if (number == 1 && number == 2) {
			return true;
		}

		for (int i = number - 1; i > 1; i--) {

			if (number % i == 0) {
				return false;
			}

		}

		return true;

	}

}
