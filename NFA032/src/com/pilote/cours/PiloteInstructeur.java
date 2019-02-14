package com.pilote.cours;
public class PiloteInstructeur extends Pilote{
	
	private String dateLicenceInstructeur;
	
	
	public PiloteInstructeur(String nom, String prenom) {
		super(nom, prenom);
		this.dateLicenceInstructeur = "18/02/2008";
	}
	
	public void enseignerDecollage() {
		System.out.println("J'enseigne le décollage");
	}
	public void enseignerAtterrissage() {
		System.out.println("J'enseigne l'atterrissage");
	}
	/**
	 * @return the dateLicenceInstructeur
	 */
	public String getDateLicenceInstructeur() {
		return dateLicenceInstructeur;
	}
	/**
	 * @param dateLicenceInstructeur the dateLicenceInstructeur to set
	 */
	public void setDateLicenceInstructeur(String dateLicenceInstructeur) {
		this.dateLicenceInstructeur = dateLicenceInstructeur;
	}


}
