package com.tp.moteur;

public class MoteurEssence extends Moteur{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4955522149992414002L;

	public MoteurEssence(String cylindre, Double prix){
		super(cylindre, prix);
		this.type = TypeMoteur.ESSENCE;		
	}
}
