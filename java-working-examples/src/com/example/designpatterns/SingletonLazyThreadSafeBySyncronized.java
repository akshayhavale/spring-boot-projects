package com.example.designpatterns;

public class SingletonLazyThreadSafeBySyncronized {
	private static SingletonLazyThreadSafeBySyncronized INSTANCE = null;

	private SingletonLazyThreadSafeBySyncronized() {

	}

	public static synchronized SingletonLazyThreadSafeBySyncronized getInstanceWithoutDoubleCheck()
			throws InterruptedException {
		if (INSTANCE == null) {
			// Some code is there so it we make thread to sleep
			Thread.sleep(2000);
			INSTANCE = new SingletonLazyThreadSafeBySyncronized();
		}
		return INSTANCE;
	}

	public static SingletonLazyThreadSafeBySyncronized getInstanceWithDoubleCheck() throws InterruptedException {
		if (INSTANCE == null) {
			synchronized (SingletonLazyThreadBreak.class) {
				if (INSTANCE == null) {
					// Some code is there so it we make thread to sleep
					Thread.sleep(2000);
					INSTANCE = new SingletonLazyThreadSafeBySyncronized();
				}
			}
		}
		return INSTANCE;
	}
}
