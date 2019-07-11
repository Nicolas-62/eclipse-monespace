package com.tp.moteur;

public class MoteurHybride extends Moteur{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5381501986091264252L;

	public MoteurHybride(String cylindre, Double prix){
		super(cylindre, prix);
		this.type = TypeMoteur.HYBRIDE;
		
	}
}
