package com.practice.java8.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReduceArray {

	public static Integer minimumAdjustmentCost(List<Integer> list) {
		return list.stream().collect(Collectors.summingInt(Integer::intValue));

	}

	public static void main(String[] args) {

		List<Integer> aa = new ArrayList<>();

		aa.add(1);
		aa.add(2);
		aa.add(3);

		List<Integer> result = new ArrayList<>();

		int count = aa.size();

		while (count > 1) {

			for (int i = 0; i < count - 1; i++) {

				int one = aa.get(i);
				System.out.println("one " + one);

				int two = aa.get(i + 1);
				System.out.println("two " + two);

				int sum = one + two;
				System.out.println("sum " + sum);

				aa.add(sum);
				Collections.sort(aa);

				aa.remove(aa.get(i + 1));
				aa.remove(aa.get(i));

				result.add(sum);

				System.out.println(aa);

				count = aa.size();
				i--;

			}

		}

		Integer minCostofArray = minimumAdjustmentCost(result);
		System.out.println("minCostofArray  " + minCostofArray);

	}

}
