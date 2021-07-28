package com.example.random.lenghty.strings;

import java.util.Random;
import java.util.UUID;

public class Generator {

	public static void main(String[] args) {

		System.out.println(getSaltString());
		
		

	}

	private static String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 100) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			System.out.println(index);
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	private static String concatUUIDToLenthyString(String lengthyString) {
		UUID uuid = UUID.randomUUID();
		String uuidString = uuid.toString();
		System.out.println(uuidString);
		return lengthyString.concat(uuidString);
	}
}
