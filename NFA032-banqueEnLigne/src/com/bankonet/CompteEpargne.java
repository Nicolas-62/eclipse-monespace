package com.bankonet;

public class CompteEpargne extends Compte{
	private double tauxInteret;
	private double plafond;
	
	public CompteEpargne(String unNumero, String unIntitule, double unSolde, double unTauxInteret) {
		super(unNumero, unIntitule, unSolde);
		this.tauxInteret=unTauxInteret;
	}
	public boolean debitAutorise(double montant) {
		if(this.getSolde()-montant<0) {
			return false;
		}else {
			return true;
		}
	}
	public void crediter(double montant) throws CreditException{
		if(this.getSolde()+montant>this.plafond) {
			throw new CreditException();
		}else {
			super.crediter(montant);
		}
	}
	public String toString() {
		String str =super.toString();
		str+="taux d'interêt : "+this.tauxInteret+"\n";
		return str;						
	}
	public double calculerInterets() {
		double interets=0;
		interets=this.getSolde()*this.getTauxInteret();
		return interets;
	}	
	public double getTauxInteret() {
		return tauxInteret;
	}
	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}
	public double getPlafond() {
		return plafond;
	}
	public void setPlafond(double plafond) {
		this.plafond = plafond;
	}
}
