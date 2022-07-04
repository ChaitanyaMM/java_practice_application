package com.practice.java8.functionalInterfaces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionExample {

//	@FunctionalInterface
//	public interface Function<T, R> {
//	      R apply(T t);
//	}

	public static <T, R> Map<T, R> convertListToMap(List<T> list, Function<T, R> func) {

		Map<T, R> result = new HashMap<>();
		for (T t : list) {
			result.put(t, func.apply(t));
		}
		return result;

	}

	public static Integer getLength(String str) {
		return str.length();
	}

	public static void main(String[] args) {

		//// 1
		Function<String, Integer> functin = x -> x.length();
		Integer result = functin.apply("chy");
		System.out.println(result);

		//// 2

		List<String> list = Arrays.asList("node", "c++", "java", "javascript");

		// lambda
		Map<String, Integer> map = convertListToMap(list, x -> x.length());

		System.out.println(map); // {node=4, c++=3, java=4, javascript=10}

		// method reference
		Map<String, Integer> map2 = convertListToMap(list, FunctionExample::getLength);

		System.out.println(map2);
	}

}
