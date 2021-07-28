package com.example.multithreading.concepts;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();

		MyThread myThread = new MyThread();
		
		
//		for (int i = 0; i < 2; i++) {
//			
//			Thread thread = new Thread(myThread, "TaskThread"+i);
//
//			thread.start();
//		}
		
		executorService.execute(myThread);
		executorService.execute(myThread);
		

		
		

	}
}
