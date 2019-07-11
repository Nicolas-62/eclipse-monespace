package com.tuto.animal;

abstract class Animal {
	
	protected int poids;
	protected String couleur;
	
	
	protected void manger() {
		System.out.println("Je mange de la viande");
	}
	protected void boire() {
		System.out.println("Je bois de l'eau");
	}
	abstract void deplacement();
	
	abstract void crier();
	
	public String toString() {
		String str = "Je suis un "+this.getClass().getName()+
					 "\n Je suis de couleur "+this.couleur+
					 "\n Je pèse "+this.poids+" kilos";
		return str;
	}
	public static void parler() {
		System.out.println("Je suis une classe");
	}

}
