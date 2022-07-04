package com.practice.java8.functionalInterfaces;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class BinaryOperatorExample {
	
//	@FunctionalInterface
//	public interface BinaryOperator<T> extends BiFunction<T,T,T> {
//	}

	static int math(int[] list, int init, IntBinaryOperator accumulator) {
		int result = init;
		for (int t : list) {
			result = accumulator.applyAsInt(result, t);
		}
		return result;
	}

	static class Developer {

		String name;
		BigDecimal salary;

		public Developer(String name, BigDecimal salary) {
			this.name = name;
			this.salary = salary;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public BigDecimal getSalary() {
			return salary;
		}

		public void setSalary(BigDecimal salary) {
			this.salary = salary;
		}

	}
	
	public static Developer find(List<Developer> list, BinaryOperator<Developer> accumulator) {
        Developer result = null;
        for (Developer t : list) {
            if (result == null) {
                result = t;
            } else {
                result = accumulator.apply(result, t);
            }
        }
        return result;
    }

	public static void main(String[] args) {

		// BiFunction
		BiFunction<Integer, Integer, Integer> func = (x1, x2) -> x1 + x2;

		Integer result = func.apply(2, 3);

		System.out.println(result); // 5

		// BinaryOperator
		BinaryOperator<Integer> func2 = (x1, x2) -> x1 + x2;

		Integer result2 = func2.apply(2, 3);

		System.out.println(result2); // 5

		// 2
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int result1_1 = math((numbers), 0, (a, b) -> a + b);

		System.out.println(result1_1); // 55

		int result1_2 = math((numbers), 0, Integer::sum);

		System.out.println(result1_2); // 55
		
		
		
		
		
		//3
        Developer dev1 = new Developer("jordan", BigDecimal.valueOf(9999));
        Developer dev2 = new Developer("jack", BigDecimal.valueOf(8888));
        Developer dev3 = new Developer("jaden", BigDecimal.valueOf(10000));
        Developer dev4 = new Developer("ali", BigDecimal.valueOf(2000));
        Developer dev5 = new Developer("mkyong", BigDecimal.valueOf(1));

        List<Developer> list = Arrays.asList(dev1, dev2, dev3, dev4, dev5);

        // 1. Create a Comparator
        Comparator<Developer> comparing = Comparator.comparing(Developer::getSalary);

        // 2. BinaryOperator with a custom Comparator
        BinaryOperator<Developer> bo = BinaryOperator.maxBy(comparing);

        Developer result3_1 = find(list, bo);

        System.out.println(result3_1.getName() + result3_1.getSalary());     // Developer{name='jaden', salary=10000}

        // one line

        // find developer with highest pay
        Developer developer = find(list, BinaryOperator.maxBy(Comparator.comparing(Developer::getSalary)));
        System.out.println(developer.getName() + developer.getSalary());  // Developer{name='jaden', salary=10000}

        // find developer with lowest pay
        Developer developer2 = find(list, BinaryOperator.minBy(Comparator.comparing(Developer::getSalary)));
        System.out.println(developer2.getName() + developer2.getSalary());

	}

}
