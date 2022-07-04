package com.practice.java8.functionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
	
		//@FunctionalInterface
		//public interface Consumer<T> {
		//  void accept(T t);
		//}
	
	public static void main(String[] args) {
		
		Consumer<String>  cc = x -> System.out.println(x);
		cc.accept("chy");
		
		
		Consumer<List<Integer>> values = list->{
			
			for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
		};
		
		 List<Integer> list = new ArrayList<Integer>();
	        list.add(2);
	        list.add(1);
	        list.add(3);
	        
		values.accept(list);
		
		//lambda
		Consumer<List<Integer>> modifedList = list2->list2.stream().forEach(a->System.out.println(a));
		
		//methodReference
		Consumer<List<Integer>> modifedList2 = list2->list2.stream().forEach(System.out::println);

		modifedList.accept(list);
		
	}

}
