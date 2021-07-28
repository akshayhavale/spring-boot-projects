package com.example.designpatterns.factory;

public class TestFactoryDesignPattern {

	public static void main(String[] args) {

		Car ferarri = CarFactory.getCar(CarType.FERARRI);
		System.out.println(ferarri.start());
		System.out.println(ferarri.run());
		System.out.println(ferarri.stop());
	}

}
