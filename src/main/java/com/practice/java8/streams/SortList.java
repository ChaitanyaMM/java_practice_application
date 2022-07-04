package com.practice.java8.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortList {

	static class User {
		private int id;
		private String name;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		User(int id, String name) {
			this.id = id;
			this.name = name;

		}

	}

	public static void main(String[] args) {

		// normal List defaul sorting

		List<Integer> list = Arrays.asList(22, 1, 3, 12, 16, 7);

		Collections.sort(list);

		System.out.println(list + "");

		// userList
		
		//pick which ever is the case

		User user1 = new User(23, "B");
		User user2 = new User(22, "A");
		User user3 = new User(1, "c");

		List<User> userList = Arrays.asList(user1, user2, user3);

		// way :1
		userList.sort(new Comparator<User>() {

			@Override
			public int compare(User a, User b) {
				return a.getId() - b.getId();
			}

		});

		// way2
		userList.sort(Comparator.comparingInt(User::getId).reversed()); // descending
		
		// way3
		userList.sort(Comparator.comparingInt(User::getId)); // asc
		
		//way4
		
		userList.sort(Comparator.comparing(User::getName));
		

		userList.forEach(x -> System.out.println(x.getId() + ": " + x.getName()));

	}

}
