package com.practice.java8.functionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodRefereanceExample {

	public static void main(String[] args) {

		// anonymous class
		List<String> list = Arrays.asList("node", "java", "python", "ruby");
		list.forEach(new Consumer<String>() {

			@Override
			public void accept(String s) {
				System.out.println(s);
			}

		});
		
		//lambda
		 
		list.stream().forEach(a->System.out.print(a +" "));
		
		//method reference
		list.stream().forEach(System.out::println );
		

	}

}
