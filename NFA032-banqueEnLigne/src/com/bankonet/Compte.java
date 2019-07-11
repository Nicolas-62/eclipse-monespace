package com.bankonet;

public abstract class Compte {
	private String numero;
	private String intitule;
	private double solde;
	
	public Compte(String unNumero, String unIntitule, double unSolde) {
		this.numero=unNumero;
		this.intitule=unIntitule;
		if(unSolde<0) {
			System.out.println("Impossible de créer un compte avec un solde négatif.");
			this.solde=0;
		}else {
			this.solde=unSolde;
		}	
	}
	protected abstract boolean debitAutorise(double montant);
	
	public void debiter(double montant) throws DebitException{
		if(!debitAutorise(montant)) {
//			System.out.println("débit impossible, saisissez un montant moins important !");
			throw new DebitException();
		}else {
			this.solde-=montant;
		}
	}	
	public void effectuerVirement(Compte compte, double montant) throws CompteException {
		// throws DebitException imposé pour appel de la methode débiter, ici on propage l'exception
		debiter(montant);
		compte.crediter(montant);
	}
	public String toString() {
		String str ="Compte \n"+ 
					"numero compte : "+this.numero+"\n"+
					"intitule : "+this.intitule+"\n"+
					"solde : "+this.solde+"\n";
		return str;						
	}	
	public void crediter(double montant) throws CreditException{
		this.solde+=montant;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	
}
