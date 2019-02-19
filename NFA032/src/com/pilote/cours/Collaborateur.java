package com.pilote.cours;
// la classe abstraite Collaborateur est une interface pour ses sous classe
// elle fournit une interface commune
public abstract class Collaborateur {

	protected long matricule;
	private String nom;
	protected String prenom;
	
	public Collaborateur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		
	}
	// Interdit de redéfinir la méthode finale dans une sous-classe
	public final void prendreConge() {
		System.out.println("Je prends des congés");
	}
	public abstract void gererAccident();
	public abstract long calculerSalaire();
	public String toString() {
		return nom+" "+prenom;
	}
	
	public long getMatricule() {
		return matricule;
	}
	public void setMatricule(long matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	};	
}
