package com.practice.java8.functionalInterfaces;

import java.util.function.BiConsumer;

public class BiConsumerExample {

//	@FunctionalInterface
//	public interface BiConsumer<T, U> {
//	  void accept(T t, U u);
//	}

	static <T> void addTwo(T a1, T a2, BiConsumer<T, T> predicate) {
		predicate.accept(a1, a2);
	}

	public static void main(String[] args) {

		BiConsumer<Integer, Integer> addTwo = (x, y) -> System.out.println(x + y);
		addTwo.accept(1, 2);

		// 2
		addTwo(1, 2, (x, y) -> System.out.println(x + y)); // 3
		addTwo("abc", "efg", (x, y) -> System.out.println(x + y)); // abcefg

	}

}
