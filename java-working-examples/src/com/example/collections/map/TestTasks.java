package com.example.collections.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestTasks {
	/*
	 * 
	 * 
	 * 
	 * The main difference between SyncronizedMap and ConcurrentHashMap is
	 * the lock is on Map in SyncronizedMap 
	 * but for concurrentHashMap the lock is on part of segment of Map
	 * 
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {

		Map<String, Integer> hashMap = new HashMap<>();

		Map<String, Integer> syncronizedMap = Collections.synchronizedMap(hashMap);
		Map<String, Integer> conMap = new ConcurrentHashMap<>();
		MapTask1 task1 = new MapTask1(syncronizedMap);
		MapTask2 task2 = new MapTask2(syncronizedMap);
		MapTask3 task3 = new MapTask3(syncronizedMap);
		MapTask4 task4 = new MapTask4(syncronizedMap);

		for (Map.Entry<String, Integer> entry : syncronizedMap.entrySet()) {
			System.out.println("Key = " + entry.getKey() + "   " + "Value = " + entry.getValue());
		}

	}

}
