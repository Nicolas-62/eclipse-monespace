package com.tuto.divers;

public class TryCatch {

	public static void main(String[] args){
		
		  int j = 20, i = 0;
		  try {
		    System.out.println(j/i);
		  } catch (ArithmeticException e) {
		    System.out.println("Division par zéro !"+ e.getMessage());
		  }
		  System.out.println("coucou toi !"); 
		  
		  
		  try {
		    System.out.println(" =>" + (1/0));
		  } catch (ClassCastException e) {
		    e.printStackTrace();
		  }
		  finally{
		    System.out.println("action faite systématiquement");
		  }
		}


}
