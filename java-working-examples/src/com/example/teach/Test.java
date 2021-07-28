package com.example.teach;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Appartment appartment = new Appartment();
		Scanner scanner = new Scanner(System.in);

		System.out.println("PLESE GIVE ME YOUR APPARTMENT NAME");
		String myHomeName = scanner.next();
		appartment.setName(myHomeName);
		System.out.println("YOUR APPARTMENT NAME YOU SPECIFIED AS  = " + appartment.getName());

		Conncret conncret = new Conncret();
		System.out.println("PLEASE GIVE ME CONCRET TO BUILD YOUR APPARTMENT");
		String myHomeConcret = scanner.next();
		conncret.setConcretName(myHomeConcret);
		appartment.setConcret(conncret);
		System.out.println("YOUR APPARTMENT CONCRET YOU USED IS = " + appartment.getConcret());

		System.out.println("IS YOUR APPARTMENT HAS PARKING FACILITY :Y/N");
		String parkingFacility = scanner.next();

		if (parkingFacility.equalsIgnoreCase("Y")) {
			appartment.setParkingArea(true);
		} else {
			appartment.setParkingArea(false);
		}
		System.out.println("YOUR APPARTMENT HAS PARKING FACILITY AS = " + appartment.isParkingArea());

		System.out.println(appartment.toString());

	}

}
