package com.practice.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StremsOperations {

	private static boolean isPrime(int x) {
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				System.out.println("Not primeNumber)");
				return false;

			} else {
				System.out.println("primeNumber");
			}

		}
		return true;

	}

	public static boolean isPrime2(int number) {

		if (number <= 1)
			return false; // 1 is not prime and also not composite

		return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
	}

	public static void main(String[] args) {

		String[] names = { "Java", "Node", "JavaScript", "Rust", "Go" };

		List<String> values = IntStream.range(0, names.length).mapToObj(index -> index + ":" + names[index])
				.collect(Collectors.toList());
		values.stream().forEach(System.out::println);

		// febinocci

		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(10).map(t -> t[0])
				.forEach(x -> System.out.println(x));

		System.out.println();

		Stream.iterate(new int[] { 0, 1 }, x -> new int[] { x[1], x[0] + x[1] }).limit(12).map(x -> x[0])
				.forEach(System.out::println);

		// primeNUmber
		int x = 6;
		List<Integer> collect = new ArrayList<>();

		for (int i = 0; i < x; i++) {
			if (isPrime(i)) {
				collect.add(i);
			}
		}

		// primeNumberStream
		long count = Stream.iterate(0, n -> n + 1).limit(1000).filter(StremsOperations::isPrime2)
				.peek(a -> System.out.format("%s\t", a)).count();

		System.out.println("\nTotal: " + count);

	}

}
