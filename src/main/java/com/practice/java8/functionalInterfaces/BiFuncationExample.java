package com.practice.java8.functionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFuncationExample {

	// @FunctionalInterface
	// public interface BiFunction<T, U, R> {
	// R apply(T t, U u);
	// }

	public static <A1, A2, R1, R2> R2 convert(A1 a1, A2 a2, BiFunction<A1, A2, R1> func, Function<R1, R2> func2) {

		return func.andThen(func2).apply(a1, a2);

	}

	static class GPS {

		String Latitude;
		String Longitude;

		public GPS(String latitude, String longitude) {
			Latitude = latitude;
			Longitude = longitude;
		}

		public String getLatitude() {
			return Latitude;
		}

		public void setLatitude(String latitude) {
			Latitude = latitude;
		}

		public String getLongitude() {
			return Longitude;
		}

		public void setLongitude(String longitude) {
			Longitude = longitude;
		}

		@Override
		public String toString() {
			return "GPS{" + "Latitude='" + Latitude + '\'' + ", Longitude='" + Longitude + '\'' + '}';
		}

		public static <R extends GPS> R factory(String Latitude, String Longitude, BiFunction<String, String, R> func) {
			return func.apply(Latitude, Longitude);
		}

		public static void main(String[] args) {

			// 1
			BiFunction<Integer, Integer, Integer> func = (x1, x2) -> x1 + x2;
			Integer result = func.apply(2, 3);
			System.out.println(result);

			// 2
			BiFunction<Integer, Integer, List<Integer>> func3 = (x1, x2) -> Arrays.asList(x1 + x2);
			List<Integer> result3 = func3.apply(2, 3);
			System.out.println(result3);

			// 3
			BiFunction<Integer, Integer, Double> func1 = (a1, a2) -> Math.pow(a1, a2);
			Function<Double, String> func2 = (input) -> "Result : " + String.valueOf(input);
			String result4 = func1.andThen(func2).apply(2, 4);
			System.out.println(result4);

			// generic for above
			String result5 = convert(2, 4, (a1, a2) -> Math.pow(a1, a2), (r) -> "Pow : " + String.valueOf(r));
			System.out.println(result5);

			/// 4
	        GPS obj = factory("40.741895", "-73.989308", GPS::new);
			System.out.println(obj);


		}

	}
}
