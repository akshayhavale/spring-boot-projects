package com.example.designpatterns;

public class StaticSingletonClass {

	private static StaticSingletonClass INSTANCE = null;

	static {
		INSTANCE = new StaticSingletonClass();
	}

	private StaticSingletonClass() {

	}

	public StaticSingletonClass getInstance() {
		return INSTANCE;
	}

}
