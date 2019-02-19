package com.exceptions.cours;

public class ExceptionTest {
	
	double diviser(int a, int b) throws Exception{
		if(b==0) {
			throw new Exception("Division par zero");
		}
		return a / b;
	}
	double appelerDiviser(int a, int b) throws Exception{
		try {
			return diviser(a,b);
		}catch(Exception e) {
			return 0;
		}
	}

	public static void main(String[] args) {
		int a=4;
		int b=0;
		ExceptionTest exp = new ExceptionTest();
		try {
			System.out.println(exp.appelerDiviser(a,b));
		}catch(Exception e) {
			e.getMessage();
		}
	}
}

