package com.practice.java8.streams;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SortMap {

	private static Map<String, Integer> sortValues(Map<String, Integer> map) {

		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

		 //1
//		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//
//			@Override
//			public int compare(Entry<String, Integer> v1, Entry<String, Integer> v2) {
//				return v1.getValue().compareTo(v2.getValue());
//			}
//
//		});
		
		//2
	 list.sort((Entry<String, Integer> v1 ,Entry<String, Integer> v2) ->  v1.getValue()-v2.getValue());

		Map<String, Integer> temp = new LinkedHashMap<String, Integer>();

		for (Map.Entry<String, Integer> dd : list) {
			temp.put(dd.getKey(), dd.getValue());

		}

		return temp;

	}

	public static void main(String[] argv) {

		Map<String, Integer> unsortMap = new HashMap<>();
		unsortMap.put("z", 10);
		unsortMap.put("b", 5);
		unsortMap.put("a", 6);
		unsortMap.put("c", 20);
		unsortMap.put("d", 1);
		unsortMap.put("e", 7);
		unsortMap.put("y", 8);
		unsortMap.put("n", 99);
		unsortMap.put("g", 50);
		unsortMap.put("m", 2);
		unsortMap.put("f", 9);

		System.out.println("Original...");
		System.out.println(unsortMap);

		TreeMap<String, Integer> tm = new TreeMap<String, Integer>(unsortMap);
		System.out.println("sorted...");
		System.out.println(tm);
		
		Map<String,Integer> sortByValues =sortValues(unsortMap);
		System.out.println(sortByValues);
		
		
//		unsortMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//		                             .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldV,newV)-> oldV,LinkedHashMap::new));
		
		
		
		
		
		
		Map<String, Integer> sorted =unsortMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect
		(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldV,newV)-> oldV,LinkedHashMap:: new));
		
		
		
		
		
		


	}

}
