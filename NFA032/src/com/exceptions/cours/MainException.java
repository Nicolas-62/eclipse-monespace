package com.exceptions.cours;

public class MainException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=4;
		int b=0;
		ExceptionTest exp = new ExceptionTest();
		try {
		System.out.println(exp.diviser(a,b));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
