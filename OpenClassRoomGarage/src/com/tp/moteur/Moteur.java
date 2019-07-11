package com.tp.moteur;

import java.io.Serializable;

public abstract class Moteur implements Serializable{
	
	private static final long serialVersionUID = 3996967533549385542L;
	protected TypeMoteur type;
	private String cylindre;
	private Double prix;
	
	Moteur(String cylindre, Double prix){
		this.cylindre = cylindre;
		this.prix = prix;
	}
	public String toString() {
		String str = " Moteur "+this.type.name+" "+this.cylindre+" ("+this.getPrix()+" €) ";
		return str;
	}
	public Double getPrix() {return this.prix;}
	
}
