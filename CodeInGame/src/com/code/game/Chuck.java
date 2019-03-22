package com.code.game;



public class Chuck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String MESSAGE = "C";
		char[] tabChar = MESSAGE.toCharArray();
		char[] tabBin=null;
		MESSAGE = "";
		String lettre = "";
		boolean flag=true;
		for(int i=0; i<tabChar.length; i++) {
			lettre = Integer.toBinaryString(tabChar[i]);
			tabBin = lettre.toCharArray();
			for(int j=0; j<tabBin.length; j++) {
				if((int)tabBin[j]==0) {
					
				}
			}
		}
		System.out.println(MESSAGE);
		
	}

}
