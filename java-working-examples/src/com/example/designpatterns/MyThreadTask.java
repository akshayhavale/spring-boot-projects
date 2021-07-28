package com.example.designpatterns;

public class MyThreadTask implements Runnable {

	@Override
	public void run() {

		try {
			SingletonLazyThreadBreak singletonLazyThreadBreak = SingletonLazyThreadBreak.getInstance();
			System.out.println(Thread.currentThread().getName() + "  " + singletonLazyThreadBreak.hashCode());

			System.out.println("============================without doublecheck=============just syncronized");

			SingletonLazyThreadSafeBySyncronized singletonLazyThreadSafeBySyncronized = SingletonLazyThreadSafeBySyncronized
					.getInstanceWithoutDoubleCheck();
			System.out
					.println(Thread.currentThread().getName() + "  " + singletonLazyThreadSafeBySyncronized.hashCode());

			System.out.println("============================with doublecheck=============syncronized");

			SingletonLazyThreadSafeBySyncronized singletonLazyThreadSafeBySyncronized1 = SingletonLazyThreadSafeBySyncronized
					.getInstanceWithDoubleCheck();
			System.out.println(
					Thread.currentThread().getName() + "  " + singletonLazyThreadSafeBySyncronized1.hashCode());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
