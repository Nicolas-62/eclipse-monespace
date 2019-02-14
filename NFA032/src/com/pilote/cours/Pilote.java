package com.pilote.cours;

public class Pilote extends Collaborateur{
	
	private int nbHVol;
	private int txHoraire;
	
	public Pilote(String nom, String prenom) {
		super(nom, prenom);
	}
	@Override // methode redéfinie, sa signature est la même
	/* Méta-donnée précisant au compilateur que la déclaration d’une méthode
	* redéfinie une méthode de sa super classe.
	* Erreur générée par le compilateur java lorsqu’un
	*/
	public long calculerSalaire() {
		long salaire = nbHVol*txHoraire;
		return salaire;
	}
	public void gererAccident() {
		System.out.println("J'enclenche le siège éjectable");
	}
	public void faireDecoller(Pilotable objetVolant) {
		System.out.println("on décolle !!");
	}
	public void faireAtterir() {
		System.out.println("on atterri");
	}
	public int getNbHVol() {
		return nbHVol;
	}
	public void setNbHVol(int nbHVol) {
		this.nbHVol = nbHVol;
	}
	public int getTxHoraire() {
		return txHoraire;
	}
	public void setTxHoraire(int txHoraire) {
		this.txHoraire = txHoraire;
	}
}
