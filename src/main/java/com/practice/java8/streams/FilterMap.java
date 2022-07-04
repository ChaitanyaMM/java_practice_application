package com.practice.java8.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class FilterMap {

	private static <T, U, R> R operations(T t1, U t2, BiFunction<T, U, R> biFunction) {
		return biFunction.apply(t1, t2);

	}
	
	private static <T> String add(T a, T b) {
		String aa = String.valueOf(Integer.valueOf((String) a)+Integer.valueOf((String) b));

		return aa;
	}

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "aws");
		map.put(2, "heroku");

		String result = "";

		for (Map.Entry<Integer, String> map1 : map.entrySet()) {

			if ("aws".equalsIgnoreCase(map1.getValue())) {
				result = map1.getValue() + " and key is  " + map1.getKey();

			}

		}
		System.out.println(result);

		// streams
		String resultStream = map.entrySet().stream().filter(f -> "aws".equals(f.getValue()))
				.map(x -> x.getValue() + "key is : " + x.getKey()).collect(Collectors.joining());

		System.out.println(resultStream);

		BiFunction<Integer, Integer, Integer> additon = (x1, x2) -> x1 + x2;
		BiFunction<Integer, Integer, Integer> sub = (x1, x2) -> x1 - x2;
		BiFunction<Integer, Integer, Integer> mult = (x1, x2) -> x1 * x2;

		Integer r = operations(2, 3, additon);
		Integer r1 = operations(2, 3, sub);
		Integer r2 = operations(2, 3, mult);

		System.out.println(r + "");
		System.out.println(r1 + "");

		System.out.println(r2 + "");
		
	 


	}

}
