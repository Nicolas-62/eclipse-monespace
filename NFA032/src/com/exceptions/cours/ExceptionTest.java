package com.exceptions.cours;

public class ExceptionTest {
	
	double diviser(int a, int b) throws Exception{
		if(b==0) {
			throw new Exception("Division par zero");
		}
		return a / b;
	}
	double appelerDiviser(int a, int b) {
		try {
			return diviser(a,b);
		}catch(Exception e) {
			return 0;
		}
	}
}

