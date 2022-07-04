package com.practice.java8.generics;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface OnlineAccount {
	int basePrice = 120;
	int regularMoviePrice = 45;
	int exclusiveMoviePrice = 80;
}

class Account implements OnlineAccount, Comparable<Account> {

    int noOfRegularMovies, noOfExclusiveMovies;
    String ownerName;

    // 1) Add a parameterized constructor that initializes the attributes noOfRegularMovies and noOfExclusiveMovies.


    public Account(String ownerName, int noOfRegularMovies, int noOfExclusiveMovies) {
    	this.ownerName=ownerName;
    	this.noOfRegularMovies = noOfRegularMovies;
    	this.noOfExclusiveMovies = noOfExclusiveMovies;
	}

	// 2. This method returns the monthly cost for the account.
    public int monthlyCost() {
    	
    	int  mc = basePrice + (noOfRegularMovies * regularMoviePrice)+  (noOfExclusiveMovies* exclusiveMoviePrice);
        return mc;
    }

    // 3. Override the compareTo method of the Comparable interface such that two accounts can be compared based on their monthly cost.
    
    // 4. Returns "Owner is [ownerName] and monthly cost is [monthlyCost] USD."
    public String toString() {
		return "Owner is " + ownerName + " monthly cost is " + monthlyCost() + " USD.";

    }


	@Override
	public int compareTo(Account acc) {
		return this.monthlyCost() -acc.monthlyCost();
	}
}

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
    	Account acc1 = new Account ("Frank",12,6);
    	Account acc2 = new Account ("David",7,19);
    	Account acc3 = new Account ("Karen",14,4);
    	
    	
    	
    	
    	
//        Scanner sc = new Scanner(System.in);
//        String sub = sc.nextLine();
//
//        int t = Integer.parseInt(sub);

        ArrayList<Account> list = new ArrayList<Account>();
        list.add(acc1);list.add(acc2);list.add(acc3);

//        for(int i=0; i<t; i++) {
//        	String[] input = sc.nextLine().split(" ");
//        	list.add(new Account(input[0],
//        						Integer.parseInt(input[1]),
//        						Integer.parseInt(input[2])));
//        }
      	
        Collections.sort(list);

        System.out.println("Most valuable account details:");
        System.out.println(list.get(list.size() - 1));
    }
}
