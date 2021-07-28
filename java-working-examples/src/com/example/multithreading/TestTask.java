package com.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestTask {

	public static void main(String[] args) {

		NormalTask normalTask = new NormalTask();

		long normalTaskStartTime = System.currentTimeMillis();
		System.out.println(normalTask.checkIsPrimeNumber(82589933));
		System.out.println(normalTask.checkIsPrimeNumber(82589933));
		System.out.println(normalTask.checkIsPrimeNumber(82589933));
		System.out.println(normalTask.checkIsPrimeNumber(82589933));
		System.out.println(normalTask.checkIsPrimeNumber(82589933));
		System.out.println(normalTask.checkIsPrimeNumber(82589933));
		System.out.println(normalTask.checkIsPrimeNumber(82589933));
		System.out.println(normalTask.checkIsPrimeNumber(82589933));
		System.out.println(normalTask.checkIsPrimeNumber(82589933));
		System.out.println(normalTask.checkIsPrimeNumber(82589933));
		long normalTaskEndTime = System.currentTimeMillis();

		System.out
				.println("Time taken by normal task = " + (normalTaskEndTime - normalTaskStartTime) + " milliseconds");

		System.out.println(
				"=======================================================xxxx========================================================");

		/*
		 * 
		 * Now we going to make Multithreading by using
		 * 
		 * 1) Thread class 2) Runnable Interface 3) Executor service
		 * 
		 */

		MyThread myThread1 = new MyThread();
		MyThread myThread2 = new MyThread();
		MyThread myThread3 = new MyThread();
		MyThread myThread4 = new MyThread();
		MyThread myThread5 = new MyThread();

//		Thread t1 = new Thread(myThread);
//		Thread t2 = new Thread(myThread);
//		Thread t3 = new Thread(myThread);
//		Thread t4 = new Thread(myThread);

//		myThread1.start();
//		myThread2.start();
//		myThread3.start();
//		myThread4.start();
//		myThread5.start();
//		
//
		MyThread1 myRunnableThread1 = new MyThread1();
//
//		Thread t1 = new Thread(myRunnableThread1);
//		t1.start();
		
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		executorService.execute(myRunnableThread1);
		
	}

}
