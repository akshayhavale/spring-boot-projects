package com.example.designpatterns.factory;

public class Ferarri implements Car {

	@Override
	public String start() {
		return "Ferarri is starting";
	}

	@Override
	public String run() {
		return "Ferarri is running";
	}

	@Override
	public String stop() {
		return "Ferarri is stopping";
	}

}
