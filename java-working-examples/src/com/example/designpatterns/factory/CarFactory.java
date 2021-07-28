package com.example.designpatterns.factory;

public class CarFactory {

	private CarFactory() {

	}

	public static Car getCar(CarType carType) {
		switch (carType) {
		case FERARRI:

			return new Ferarri();

		case NANO:

			return new Nano();

		default:
			return null;
		}
	}

}
