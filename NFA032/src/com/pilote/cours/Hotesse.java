package com.pilote.cours;

public class Hotesse extends Collaborateur{
	private long salaire;

	public Hotesse(String nom, String prenom) {
		super(nom, prenom);
		this.setNom(nom);
	}

	@Override
	public void gererAccident() {
		System.out.println("Je prends un parachute et je saute");
	}
	@Override
	public long calculerSalaire() {
		return 20000;
	}
	public void servirBoissons() {
		System.out.println("Je sers les boissons");
	}
	public long getSalaire() {
		return salaire;
	}

	public void setSalaire(long salaire) {
		this.salaire = salaire;
	}

}
