package com.bankonet;

public class Client {
	private String identifiant;
	private String nom;
	private String prenom;
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;
	
	public Client() {}
	
	public Client(String unIdentifiant, String unNom, String unPrenom) {
		this.setIdentifiant(unIdentifiant);
		this.nom = unNom;
		this.prenom= unPrenom;
	}
	
	public double calculerAvoirGlobal() {
		double montant=0;
		if(this.compteCourant != null) {
			montant += this.compteCourant.getSolde();
		}
		if(this.compteEpargne != null) {
			montant+=this.compteEpargne.getSolde();
		}
		return montant;
	}
	public String toString() {
		String str;
		str="CLient, nom : "+this.nom+" prenom : "+this.prenom+"\n";
		if(this.compteCourant != null) {
			str += this.compteCourant.toString();
		}
		if(this.compteEpargne != null) {
			str+=this.compteEpargne.toString();
		}
		str+="Avoir global : "+this.calculerAvoirGlobal();
		return str;
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
	}

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
}
