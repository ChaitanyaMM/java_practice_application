package com.practice.java8.functionalInterfaces;

import java.util.function.BiPredicate;

public class BiPredicateExample {

//	@FunctionalInterface
//	public interface BiPredicate<T, U> {
//	    boolean test(T t, U u);
//	}

	public static void main(String[] args) {

		BiPredicate<String, Integer> filter = (x, y) -> {
			return x.length() == y;
		};

		boolean result = filter.test("chy", 3);
		System.out.println(result); // true

		boolean result2 = filter.test("java", 10);
		System.out.println(result2); // false

	}

}
