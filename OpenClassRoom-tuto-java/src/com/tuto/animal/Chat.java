package com.tuto.animal;

public class Chat extends Felin{
	public Chat() {
	}
	public Chat(String couleur, int poids) {
		this.couleur = couleur;
		this.poids = poids;
		System.out.println(this.toString());
	}
	void crier() {
		System.out.println("je miaule");
	}
}
