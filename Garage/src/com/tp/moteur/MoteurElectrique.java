package com.tp.moteur;

public class MoteurElectrique extends Moteur{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2379743635106079422L;

	public MoteurElectrique(String cylindre, Double prix){
		super(cylindre, prix);
		this.type = TypeMoteur.ELECTRIQUE;		
	}
}
