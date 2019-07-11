package com.tuto.test;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		System.out.println(a.b.str);
		
		// essais avec des tableaux transformés en liste
		String tab[] = {"abc", "klm", "xyz", "pqr"};
		Integer tab2[] = {1, 2, 3, 4};
		Integer i = 0;
		for( Integer z : tab2) {
			System.out.print(" tab2["+i+"] : "+z*2);
			i++;
		}		
		List<String> list1 = Arrays.asList(tab);
		List<Integer> list2 = Arrays.asList(tab2);
		System.out.println("The list is : "+list1);
		System.out.println("The list2 is : "+list2);
		
	}
}
