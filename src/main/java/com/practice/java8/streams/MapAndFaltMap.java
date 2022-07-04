package com.practice.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapAndFaltMap {
	public static void main(String[] args) {

		
		
		//1
		List<String> numbers = Arrays.asList("1", "2", "A", "B", "C1D2E3");

		List<List<String>> listOflist = numbers.stream()
				.map(x -> new Scanner(x).findAll("\\D+").map(m -> m.group()).collect(Collectors.toList()))
				.collect(Collectors.toList());

		System.out.println(listOflist);

		List<String> collect = numbers.stream()
				.map(x -> new Scanner(x).findAll("\\D+").map(m -> m.group()).collect(Collectors.toList()))
				.flatMap(List::stream).collect(Collectors.toList());

		System.out.println(collect);
		
		
		//2

		String lines = "I Love Java 8 Stream!";

		String[] aa = Arrays.stream(lines.split("\\s+")).map(String::toUpperCase).toArray(String[]::new);

		for (String s : aa) {
			System.out.println(s + "");
		}
		
		//3
		
		
		  List<String> items =
	                Arrays.asList("apple", "apple", "banana",
	                        "apple", "orange", "banana", "papaya");
		  
		  
		Map<String, Long> map = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(map + "");
 
        Map<String, Long>  finalMap =map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect
		(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldV,newV)-> oldV,LinkedHashMap:: new));
        
		System.out.println(finalMap + "");


		
		
		

	}

}
