package com.example.collections.map;

import java.util.EnumMap;
import java.util.Map;

public class TestMaps {
	
	public static void main(String[] args) {
		
		
		ProductTypes value = ProductTypes.getValue("sneakers");
		System.out.println(value.getText());
		
		Map<ProductTypes, String> map = new EnumMap<>(ProductTypes.class);
		map.get("sneakers");
	}

}
