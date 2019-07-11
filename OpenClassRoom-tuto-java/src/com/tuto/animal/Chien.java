package com.tuto.animal;

public class Chien extends Canin implements Rintintin{
	
	public Chien() {		
	}
	public Chien(String couleur, int poids) {
		this.couleur = couleur;
		this.poids = poids;
		System.out.println(this.toString());
	}
	void crier() {
		System.out.println("Je jappe, j'aboie");
	}
	public void faireCalin() {
		System.out.println("Je fais un gros CALIN !");
	}
	public void faireLeBeau() {
		System.out.println("Je fais le beau");
	}
	public void faireLechouille() {
		System.out.println("Je fais une léchouille !");
	}
}
