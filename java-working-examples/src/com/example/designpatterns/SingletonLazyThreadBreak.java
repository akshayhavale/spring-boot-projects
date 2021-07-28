package com.example.designpatterns;

public class SingletonLazyThreadBreak {

	private static SingletonLazyThreadBreak INSTANCE = null;

	private SingletonLazyThreadBreak() {

	}

	public static SingletonLazyThreadBreak getInstance() throws InterruptedException {
		if (INSTANCE == null) {
			//Some code is there so it we make thread to sleep
			Thread.sleep(2000);
			INSTANCE = new SingletonLazyThreadBreak();
		}
		return INSTANCE;
	}

}
