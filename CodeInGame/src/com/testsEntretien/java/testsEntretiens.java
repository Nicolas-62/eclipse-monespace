package com.testsEntretien.java;

public class testsEntretiens {

	public static int fibo(int n) {
		if (n == 1)
			return 1;
		else if (n == 0)
			return 0;
		else
			return fibo(n - 1) + fibo(n - 2);
	}

	public static void fizzBuzz() {
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				if (i % 5 == 0) {
					System.out.println("Fizz Buzz");
				} else {
					System.out.println("Fizz");
				}
			} else {
				if (i % 5 == 0) {
					System.out.println("Buzz");
				} else {
					System.out.println(i);
				}
			}
		}
	}

	public static void caracteres(String chaineA, String chaineB) {
		char[] tabA = chaineA.trim().toLowerCase().toCharArray();
		char[] tabB = chaineB.trim().toLowerCase().toCharArray();
		boolean flag = false;
		for (char charA : tabA) {
			flag = false;
			for (int i=0; i<tabB.length; i++ ) {
				if (tabB[i] == charA) {
					tabB[i]='\0';
					flag = true;
					break;
				}
			}
			if(flag==false) {
				break;
			}
		}
		
		System.out.println(flag);
	}
	enum Planet{
		D,F,G
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		fizzBuzz();
		System.out.println(fibo(10));
//		String a = "hello ";
//		String b = "hollE";
//		caracteres(a, b);
//		fizzBuzz();
	}

}
