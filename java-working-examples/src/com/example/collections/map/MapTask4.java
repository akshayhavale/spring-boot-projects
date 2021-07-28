package com.example.collections.map;

import java.util.Map;

public class MapTask4 implements Runnable {

	private Map<String, Integer> map;

	public MapTask4(Map<String, Integer> map) {
		this.map = map;
		new Thread(this, "MapTask4").start();
	}

	public void run() {
		map.put("4", 4);
		try {
			Thread.sleep(100);
			System.out.println("MyTask4 is Sleeping");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
