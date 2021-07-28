package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) {
		System.out.println("Hello ");
		
		
		int[] arr = {7,1,7, 4, 4};
		
		//7, 5
		
		int sum = 0;
		
		for(int i : arr) {
			sum = sum + i;
		}
		
		double avg = sum/7;
		
		long val = Math.round(avg);
		
		int result = (int) ++val;
		
		System.out.println(result);
		
		List<String>  list = Arrays.asList("account-details-1","account-details-2");
		ConcurrentMap<Object, Object> map = list.stream().collect(Collectors.toConcurrentMap(value ->"123", value->value));
		map.get("123");
		
	}

}
