package com.tuto.javautil;
// Classe utilisée dans TestFunction
public class Personne {
	
	private String nom;
	private int age;	
	public Personne() {};
	public Personne(int age, String nom) {
		this.setAge(age);
		this.setNom(nom);
	}	
	protected void setNom(String nom) {
		this.nom = nom;
	}
	protected void setAge(int age) {
		this.age = age;
	}
	protected String getNom() {
		return this.nom;
	}
	protected int getAge() {
		return this.age;
	}
}
