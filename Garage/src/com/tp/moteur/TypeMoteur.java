package com.tp.moteur;

public enum TypeMoteur {
	
	ESSENCE("ESSENCE"),
	DIESEL("DIESEL"),
	HYBRIDE("HYBRIDE"),
	ELECTRIQUE("ELECTRIQUE");
	
	public String name ="";
	
	TypeMoteur(String name){
		this.name = name;
	}
	public String toString() {
		return name;
	}
	
}
