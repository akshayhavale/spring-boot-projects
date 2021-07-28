package com.example.collections.map;

import java.util.Map;

public class MapTask1 implements Runnable {

	private Map<String, Integer> map;

	public MapTask1(Map<String, Integer> map) {
		this.map = map;
		new Thread(this, "MapTask1").start();
	}

	public void run() {
		map.put("1", 1);

		try {
			System.out.println("MyTask1 is Sleeping");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
