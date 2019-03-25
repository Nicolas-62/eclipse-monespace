package com.code.game;



public class Chuck {

	public static void main(String[] args) {
		soluceNico();
	}
	
	public static void soluceNico() {
		// TODO Auto-generated method stub
		String MESSAGE = "Chuck Norris' keyboard has 2 keys: 0 and white space.";
		char[] tabChar = MESSAGE.toCharArray();

		MESSAGE = "";
		String lettre = "";
		boolean zero=false;
		boolean one=false;
		int indice=0;
		char lettreChar=' ';
		for(int i=0; i<tabChar.length; i++) {
			lettreChar = tabChar[i];
			System.out.print(lettreChar);
			lettre = Integer.toBinaryString(tabChar[i]);
//			System.out.print(lettre);

			indice=0;
			char[] tabBin= {'0','0','0','0','0','0','0'};
			for(int k=7-lettre.length(); k<7; k++) {
				tabBin[k] = lettre.charAt(indice);
				indice++;
			}			
			for(int j=0; j<tabBin.length; j++) {
				System.out.print(tabBin[j]);
				if(tabBin[j]=='0') {
					if(!zero){
						MESSAGE+=" 00 "+"0";
						zero=true;
						one=false;
					}else {
						MESSAGE+="0";
					}
				}else {
					if(!one) {
						MESSAGE+=" 0 "+"0";
						one=true;
						zero=false;
					}else {
						MESSAGE+="0";
					}
				}
			}
			System.out.println();
		}
		System.out.println(MESSAGE.trim());
		System.out.println("0 0 00 0000 0 0000 00 0 0 0 00 000 0 000 00 0 0 0 00 0 0 000 00 000 0 0000 00 0 0 0 00 0 0 00 00 0 0 0 00 00000 0 0 00 00 0 000 00 0 0 00 00 0 0 0000000 00 00 0 0 00 0 0 000 00 00 0 0 00 0 0 00 00 0 0 0 00 00 0 0000 00 00 0 00 00 0 0 0 00 00 0 000 00 0 0 0 00 00000 0 00 00 0 0 0 00 0 0 0000 00 00 0 0 00 0 0 00000 00 00 0 000 00 000 0 0 00 0 0 00 00 0 0 000000 00 0000 0 0000 00 00 0 0 00 0 0 00 00 00 0 0 00 000 0 0 00 00000 0 00 00 0 0 0 00 000 0 00 00 0000 0 0000 00 00 0 00 00 0 0 0 00 000000 0 00 00 00 0 0 00 00 0 0 00 00000 0 00 00 0 0 0 00 0 0 0000 00 00 0 0 00 0 0 00000 00 00 0 0000 00 00 0 00 00 0 0 000 00 0 0 0 00 00 0 0 00 000000 0 00 00 00000 0 0 00 00000 0 00 00 0000 0 000 00 0 0 000 00 0 0 00 00 00 0 0 00 000 0 0 00 00000 0 000 00 0 0 00000 00 0 0 0 00 000 0 00 00 0 0 0 00 00 0 0000 00 0 0 0 00 00 0 00 00 00 0 0 00 0 0 0 00 0 0 0 00 00000 0 000 00 00 0 00000 00 0000 0 00 00 0000 0 000 00 000 0 0000 00 00 0 0 00 0 0 0 00 0 0 0 00 0 0 000 00 0");
		
	}
	public static void soluceNicoBis() {
		// TODO Auto-generated method stub
		String MESSAGE = "Chuck Norris' keyboard has 2 keys: 0 and white space.";
		char[] tabChar = MESSAGE.toCharArray();
		
		float nb;

		MESSAGE = "";
		String lettre = "";
		boolean zero=false;
		boolean one=false;
		int indice=0;
		char lettreChar=' ';
		for(int i=0; i<tabChar.length; i++) {
			lettreChar = tabChar[i];
			System.out.print(lettreChar);
			lettre = Integer.toBinaryString(tabChar[i]);
//			System.out.print(lettre);

			indice=0;
			char[] tabBin= {'0','0','0','0','0','0','0'};
			for(int k=7-lettre.length(); k<7; k++) {
				tabBin[k] = lettre.charAt(indice);
				indice++;
			}			
			for(int j=0; j<tabBin.length; j++) {
				System.out.print(tabBin[j]);
				if(tabBin[j]=='0') {
					if(!zero){
						MESSAGE+=" 00 "+"0";
						zero=true;
						one=false;
					}else {
						MESSAGE+="0";
					}
				}else {
					if(!one) {
						MESSAGE+=" 0 "+"0";
						one=true;
						zero=false;
					}else {
						MESSAGE+="0";
					}
				}
			}
			System.out.println();
		}
		System.out.println(MESSAGE.trim());
		System.out.println("0 0 00 0000 0 0000 00 0 0 0 00 000 0 000 00 0 0 0 00 0 0 000 00 000 0 0000 00 0 0 0 00 0 0 00 00 0 0 0 00 00000 0 0 00 00 0 000 00 0 0 00 00 0 0 0000000 00 00 0 0 00 0 0 000 00 00 0 0 00 0 0 00 00 0 0 0 00 00 0 0000 00 00 0 00 00 0 0 0 00 00 0 000 00 0 0 0 00 00000 0 00 00 0 0 0 00 0 0 0000 00 00 0 0 00 0 0 00000 00 00 0 000 00 000 0 0 00 0 0 00 00 0 0 000000 00 0000 0 0000 00 00 0 0 00 0 0 00 00 00 0 0 00 000 0 0 00 00000 0 00 00 0 0 0 00 000 0 00 00 0000 0 0000 00 00 0 00 00 0 0 0 00 000000 0 00 00 00 0 0 00 00 0 0 00 00000 0 00 00 0 0 0 00 0 0 0000 00 00 0 0 00 0 0 00000 00 00 0 0000 00 00 0 00 00 0 0 000 00 0 0 0 00 00 0 0 00 000000 0 00 00 00000 0 0 00 00000 0 00 00 0000 0 000 00 0 0 000 00 0 0 00 00 00 0 0 00 000 0 0 00 00000 0 000 00 0 0 00000 00 0 0 0 00 000 0 00 00 0 0 0 00 00 0 0000 00 0 0 0 00 00 0 00 00 00 0 0 00 0 0 0 00 0 0 0 00 00000 0 000 00 00 0 00000 00 0000 0 00 00 0000 0 000 00 000 0 0000 00 00 0 0 00 0 0 0 00 0 0 0 00 0 0 000 00 0");
		
	}

}
