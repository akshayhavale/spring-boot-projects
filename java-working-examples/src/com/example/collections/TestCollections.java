package com.example.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class TestCollections {
	/*
	 * 
	 * List -> 1)ArrayList 2) LinkedList 3) Vector
	 * 
	 * Map -> 1) HashMap 2) LinkedHashMap 3) SortedMap 4) TreeMap
	 * 
	 * Set -> 1) HashSet 2) TreeSet 3) LinkedHashSet
	 * 
	 * HashTable
	 * 
	 * Queue ->
	 * 
	 */

	public static void main(String[] args) {

		List linkedList = new LinkedList();

		List list = Collections.synchronizedList(new ArrayList());

		Map map = new ConcurrentHashMap<>();

		
		Deque deque = new ArrayDeque<>();
//		deque.
		
		Stack stack = new Stack<>();
		
		
		List vector = new Vector<>();
	}

}
