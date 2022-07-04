package com.practice.java8.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsTester {

	static class A {

	}

	static class B extends A {

	}

	static class C extends B {

	}

	static class Test<T> {
		T ob;
		
		Test(){
			
		}

		Test(T ob) {
			this.ob = ob;
		}

		public T getOb() {
			return ob;
		}

	}
	public static void display(Test<? super B> obj) {
		System.out.println("worked");
	}
	
	
//	? super B --> lower bound allows superType & B
//	? extends B --> upper bound allows subType & B		
	
	public static void main(String[] args) { 
		
		Test<B> b = new Test<>();
		Test<A> a = new Test<>();
		Test<C> c = new Test<>();

		
		display(b);  
		 display(a);
		// display(c);zl
		
		
		
		
	}

}
