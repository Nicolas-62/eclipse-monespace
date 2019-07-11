package com.tp.moteur;

public class MoteurDiesel extends Moteur{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -147370151043025683L;

	public MoteurDiesel(String cylindre, Double prix){
		super(cylindre, prix);
		this.type = TypeMoteur.DIESEL;		
	}
}
