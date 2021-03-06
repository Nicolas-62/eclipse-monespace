package com.evaljava.test;


public class TrieTableaux {
	/*
	 * Fonction qui copie dans un autre tableau
	 * les entiers positifs d'un tableau dans l'ordre croissant
	 * @Param tab : tableau d'entiers positifs
	 * @Param tabTri : tableau vide de taille égale à tab
	 */
	public static void tri(int[] tab, int[] tabTri) {
		int valMax=0;
		int indice=0;
		for(int j=tabTri.length-1; j>=0;  j--) {
			valMax=0;
			for(int k=0; k<tab.length; k++) {
				if(tab[k]>valMax) {
					valMax=tab[k];
					indice=k;
				}
			}
			tab[indice]=0;
			tabTri[j]=valMax;		
		}		
	}
	/*
	 * Fonction qui copie dans un autre tableau
	 * les decimaux positifs d'un tableau dans l'ordre croissant
	 * @Param tab : tableau de decimaux positifs
	 * @Param tabTri : tableau vide de taille égale à tab
	 */
	public static void tri(double[] tab, double[] tabTri) {
		double valMax=0;
		int indice=0;
		for(int j=tabTri.length-1; j>=0;  j--) {
			valMax=0;
			for(int k=0; k<tab.length; k++) {
				if(tab[k]>valMax) {
					valMax=tab[k];
					indice=k;
				}
			}
			tab[indice]=0;
			tabTri[j]=valMax;		
		}		
	}	
	
	public static void main(String[] args) {
		int[] tabInt = new int[10];
		int[] tabTriInt = new int[10];
		double[] tabDouble = {101.1, 1.4, 9, 12, 0.2};
		double[] tabTriDouble= new double[5];
		// remplissage tableau avec valeurs entre 1 et 100
		for(int i=0; i<tabInt.length; i++) {
			double val = Math.random()*100;
			tabInt[i] = (int)val;
		}	
		System.out.println("classement des entiers dans un nouveau tableau");
		tri(tabInt, tabTriInt);		
		for(int n=0; n<tabTriInt.length; n++) {
			System.out.println("tabTriInt["+n+"] : "+tabTriInt[n]);
		}	
		System.out.println("##################################");
		System.out.println("classement des décimaux dans un nouveau tableau");
		tri(tabDouble, tabTriDouble);
		for(int n=0; n<tabTriDouble.length; n++) {
			System.out.println("tabTriDouble["+n+"] : "+tabTriDouble[n]);
		}
		System.out.println("##################################");
		// associer 2 tableaux précedent dans un nouveau tableau
		double[] resultat = new double[tabTriInt.length+tabTriDouble.length];
		double[] resultatTrie = new double[tabTriInt.length+tabTriDouble.length];
		for(int n=0; n<resultat.length; n++) {
			if(n<tabTriInt.length) {
				resultat[n]=tabTriInt[n];				
			}else {
				resultat[n]=tabTriDouble[n-tabTriInt.length];
			}		
			System.out.println("resultat["+n+"] : "+resultat[n]);
		}
		tri(resultat, resultatTrie);
		for(int i=0; i<resultatTrie.length; i++) {
			System.out.println(resultatTrie[i]);
		}
		

	}

}
