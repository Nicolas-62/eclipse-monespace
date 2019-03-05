package assurance;

/**
 * 
 * @author ica
 * Description : Classe concrète AssuranceMaison héritant de la classe abstraite Contrat.
 */

public class ContratAssuranceMaison extends Contrat {

	private boolean isAppartement;
	private boolean avecGarage;
	private int surface;
	private int nbPersFoyer;
	
	/*
	 * Getters et Setters des attributs
	 */
	public boolean isAppartement() {
		return isAppartement;
	}
	
	public void setAppartement(boolean isAppartement) {
		this.isAppartement = isAppartement;

	}

	public boolean isAvecGarage() {
		return avecGarage;
	}

	public void setAvecGarage(boolean avecGarage) {
		this.avecGarage = avecGarage;
	}

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public int getNbPersFoyer() {
		return nbPersFoyer;
	}

	public void setNbPersFoyer(int nbPersFoyer) {
		this.nbPersFoyer = nbPersFoyer;
	}

	/**
	 * Objectif : calcul la majoration en fonction de la surface.
	 * @return un réel representant la majoration surface.
	 */
	public double calculerMajorationSurface() {
		double majSurface;
		
		if(this.getSurface() <= 50) {
			majSurface = 1;
		}
		else if(this.getSurface() <= 60) {
			majSurface = 1.1;
		}
		else if(this.getSurface() <= 70) {
			majSurface = 1.2;
		}
		else if(this.getSurface() <= 80) {
			majSurface = 1.3;
		}
		else if(this.getSurface() <= 90) {
			majSurface = 1.4;
		}
		else if(this.getSurface() <= 100) {
			majSurface = 1.5;
		}
		else {
			majSurface = 1.6;
		}
		
		return majSurface;
	}
	
	/**
	 * Objectif : calcul la majoration Garage en fonction de la surface
	 * @return un réel representant la majoration Garage.
	 */
	public int calculerMajorationGarage() {
		int majGarage;
		if(this.getSurface() <= 50) {
			majGarage = 0;
		}
		else if(this.getSurface() <= 60) {
			majGarage = 1;
		}
		else if(this.getSurface() <= 70) {
			majGarage = 2;
		}
		else if(this.getSurface() <= 80) {
			majGarage = 3;
		}
		else if(this.getSurface() <= 90) {
			majGarage = 4;
		}
		else if(this.getSurface() <= 100) {
			majGarage = 5;
		}
		else {
			majGarage = 6;
		}	
		return majGarage;
		
	}
	
	/**
	 * (REDEFINITION DE LA METHODE ABSTRAITE calculerTarif() de la classe abstract CONTRAT)
	 * 
	 * Méthode qui calcul le tarif du contrat d'assurance Maison.
	 * 		Il fait appel à la méthode "calculerMajorationSurface" et "calculerMajorationGarage".
	 * 		SI majoration garage > 0 : additionne le tarif en fonction de la majoration+1.
	 * 		Vérifie s'il y a moins de 7 personnes au foyer ou plus. (additionne selon la condition)
	 * 
	 * 	@return Un double representant le tarif de l'assurance moto. (de l'objet instancié)
	 */	
	@Override
	public double calculerTarif() {
		double tarif;
		tarif = 15 * calculerMajorationSurface();
		if(this.avecGarage) {
			tarif += calculerMajorationGarage()+1;
		}
		if(this.getNbPersFoyer() >= 7) {
			tarif += 7;
		}
		else {
			tarif += this.getNbPersFoyer();
		}
		return tarif;
	}

	/**
	 * (REDEFINITION DE LA METHODE ABSTRAITE imprimerResultatDevis() de la classe CONTRAT)
	 * 
	 * Objectif : affiche le resultat du devis d'assurance Maison.
	 * Il fait appel à la méthode CalculerTarif pour l'afficher.
	 */
	
	@Override
	public void imprimerResultatDevis() {
		System.out.println("DEVIS ASSURANCE HABITATION");
		System.out.println("Nom : "+this.getNom());
		System.out.println("Prenom : "+this.getPrenom());
		System.out.println("\nLe tarif à payer pour l'assurance habitation est de "+this.calculerTarif()+" €");
		System.out.println("\nVeuillez joindre : ");
		System.out.println("Contrat de location");
		System.out.println("RIB");
		System.out.println("Carte d'identité assureur");

	}

}
