package com.example.collections.map;

import java.util.Map;

public class MapTask3 implements Runnable {

	private Map<String, Integer> map;

	public MapTask3(Map<String, Integer> map) {
		this.map = map;
		new Thread(this, "MapTask3").start();
	}

	public void run() {
		map.put("3", 3);
		try {
			Thread.sleep(100);
			System.out.println("MyTask3 is Sleeping");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
