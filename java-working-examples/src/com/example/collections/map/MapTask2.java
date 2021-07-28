package com.example.collections.map;

import java.util.Map;

public class MapTask2 implements Runnable {

	private Map<String, Integer> map;

	public MapTask2(Map<String, Integer> map) {
		this.map = map;
		new Thread(this, "MapTask2").start();
	}

	public void run() {
		map.put("2", 2);
		try {
			Thread.sleep(100);
			System.out.println("MyTask2 is Sleeping");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
