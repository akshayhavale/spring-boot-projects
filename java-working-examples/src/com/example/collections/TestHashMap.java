package com.example.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class TestHashMap {

	private static final Logger LOGGER = Logger.getAnonymousLogger();

	private static Map<String, String> map = new HashMap<>();

	public static void main(String args[]) {

		map.put("Akshay", "1");
		map.put("Vinod", "2");

		map.entrySet().stream().forEach(mapper -> LOGGER.info(mapper.getKey() + " " + mapper.getValue()));
		
		
	}

}
