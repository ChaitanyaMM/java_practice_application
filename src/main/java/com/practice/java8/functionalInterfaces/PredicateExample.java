package com.practice.java8.functionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

	//	@FunctionalInterface
	//	public interface Predicate<T> {
	//	  boolean test(T t);
	//	}

	static class StringProcessor {
		static List<String> filter(List<String> list, Predicate<String> predicate) {
			return list.stream().filter(predicate::test).collect(Collectors.toList());
		}

		static class Hosting {

			private int Id;
			private String name;
			private String url;

			public Hosting(int id, String name, String url) {
				Id = id;
				this.name = name;
				this.url = url;
			}

			public int getId() {
				return Id;
			}

			public void setId(int id) {
				Id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getUrl() {
				return url;
			}

			public void setUrl(String url) {
				this.url = url;
			}

		}

		static class HostingRespository {

			public static List<Hosting> filterHosting(List<Hosting> hosting, Predicate<Hosting> predicate) {
				return hosting.stream().filter(predicate).collect(Collectors.toList());
			}
		}

		public static Predicate<Hosting> isDeveloperFriendly() {
			return n -> n.getName().equals("linode");
		}

		public static void main(String[] args) {

			// 1
			List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

			List<Integer> collect = list.stream().filter(x -> x > 5).collect(Collectors.toList());

			System.out.println(collect);

			// 2
			Predicate<Integer> predicate = x -> x < 5;
			List<Integer> collectPredicate = list.stream().filter(predicate).collect(Collectors.toList());
			System.out.println(collectPredicate);

			// 3
			Predicate<Integer> noGreaterThan5 = x -> x > 5;
			Predicate<Integer> noLessThan8 = x -> x < 8;

			List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

			List<Integer> collect3 = list3.stream().filter(noGreaterThan5.and(noLessThan8))
					.collect(Collectors.toList());

			System.out.println(collect3);

			// 4

			Predicate<String> startWithA = x -> x.startsWith("A");

			List<String> list4 = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");

			List<String> collect4 = list4.stream().filter(startWithA.negate()).collect(Collectors.toList());

			System.out.println(collect4);

			// 5

			List<String> list5 = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");

			System.out.println(StringProcessor.filter(list5, x -> x.startsWith("A"))); // [A, AA, AAA]

			System.out.println(StringProcessor.filter(list5, x -> x.startsWith("A") && x.length() == 3)); // [AAA]

			// 6

			Hosting h1 = new Hosting(1, "amazon", "aws.amazon.com");
			Hosting h2 = new Hosting(2, "linode", "linode.com");
			Hosting h3 = new Hosting(3, "liquidweb", "liquidweb.com");
			Hosting h4 = new Hosting(4, "google", "google.com");

			List<Hosting> list6 = Arrays.asList(new Hosting[] { h1, h2, h3, h4 });

			List<Hosting> result = HostingRespository.filterHosting(list6, x -> x.getName().startsWith("g"));
			System.out.println("result : " + result); // google

			List<Hosting> result2 = HostingRespository.filterHosting(list6, isDeveloperFriendly());
			System.out.println("result2 : " + result2); // linode

		}

	}
}
