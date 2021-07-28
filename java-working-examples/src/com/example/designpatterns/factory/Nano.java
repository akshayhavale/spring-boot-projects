package com.example.designpatterns.factory;

public class Nano implements Car {

	@Override
	public String start() {
		return "Nano is starting";
	}

	@Override
	public String run() {
		return "Nano is running";
	}

	@Override
	public String stop() {
		return "Nano is stoping";
	}

}
