package com.practice.java8.streams;

import java.util.HashMap;
import java.util.Map;

public class MapCount {

	public static Integer createDefault(String key, Integer value) {
		if (value == null) {
			return 1;
		}
		return value + 1;
	}

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();

		// 1
		for (int i = 0; i < 10; i++) {
			if (map.containsKey("count")) {
				map.put("count", map.get("count") + 1);
			} else {
				map.put("count", 1);
			}
		}

		// 2
		map.put("count", map.containsKey("count") ? map.get("count") + 1 : 1);

		System.out.println(map.get("count"));

		// 3
		Map<String, Integer> map2 = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			// if key "count" doesn't exist, default to 0
			map2.put("count", map2.getOrDefault("count", 0) + 1);
		}
		System.out.println(map2.get("count"));

		// 4
		Map<String, Integer> map3 = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			// if key doesn't exist, default to 1
			// lambda2)
			map3.merge("count", 1, (v1, v2) -> v1 + v2);
		}
		System.out.println(map3.get("count"));

		// 5
		Map<String, Integer> map4 = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			// if key doesn't exist, default to 1
			// lambda2)
			map4.merge("count", 1, Integer::sum);
		}
		System.out.println(map3.get("count"));

		// 6
		Map<String, Integer> map5 = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map5.compute("count", (k, v) -> (v == null) ? 1 : v + 1);
		}
		System.out.println(map5.get("count"));

		// 7
		Map<String, Integer> map6 = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			// lambda
			// map.compute("count", (k, v) -> createDefault(k, v));

			// method reference
			map6.compute("count", MapCount::createDefault);
		}
		System.out.println(map6.get("count"));
		
		//8
		  Map<String, Integer> map7 = new HashMap<>();
		  for (int i = 0; i < 10; i++) {
		      // key count not exists, skip x 10
			  map7.computeIfPresent("count", (k,v) -> v + 1);
		  }
		  System.out.println(map7.get("count"));
		  
		//9
		  Map<String, Integer> map8 = new HashMap<>();
		  map8.put("count", 1);
		  for (int i = 0; i < 10; i++) {
		      // key count not exists, skip x 10
			  map8.computeIfPresent("count", (k,v) -> v + 1);
		  }
		  System.out.println(map8.get("count"));
		

	}

}
