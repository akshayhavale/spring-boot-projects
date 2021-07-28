package com.example.designpatterns.builder;

public class TestBuilderPattern {
	
	public static void main(String[] args) {
		
		//mandatory feilds only by creating laptops
		Laptop laptopWithMandatory = new Laptop.LaptopBuilder("8GB","512GB").build();
		System.out.println(laptopWithMandatory);
		Laptop withAllFields = new Laptop.LaptopBuilder("4Gb", "256GB").isHasInbuiltOs(true).build();
		System.out.println(withAllFields);
	}

}
