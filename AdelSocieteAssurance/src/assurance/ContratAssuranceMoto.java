package assurance;

/**
 * 
 * @author ica
 * Description : Classe concrète de l'assurance Moto qui étends la classe Abstraite ContratVehicule.
 */

public class ContratAssuranceMoto extends ContratVehicule {

	private int cylindree;
	
	/*
	 * Getter et Setter de Cylindre.
	 */
	public int getCylindree() {
		return cylindree;
	}

	public void setCylindree(int cylindree) {
		this.cylindree = cylindree;
	}

	
	// redefinition des méthodes abstraites
	
	/**
	 * (REDEFINITION METHODE ABSTRAITE calculerMajoration() de classe abstract ContratVehicule)
	 * 
	 * Méthode servant à calculer la majoration selon le nombre de cylindrée.
	 * @return un réel representant la majoration en fonction du nombre de cylindrée.
	 */
	
	@Override
	public double calculerMajoration() {
		
		double majoration;

		if(this.cylindree <= 200) {
			majoration = 1;
		}
		else if(this.cylindree <= 400) {
			majoration = 1.1;
		}
		else if(this.cylindree <= 600) {
			majoration = 1.2;
		}
		else if(this.cylindree <= 800) {
			majoration = 1.3;
		}
		else if(this.cylindree <= 1000) {
			majoration = 1.4;
		}
		else if(this.cylindree <= 1200) {
			majoration = 1.5;
		}
		else {
			majoration = 1.6;
		}
		return majoration;
	}
	
	/**
	 * (REDEFINITION DE LA METHODE ABSTRAITE calculerTarif() de la classe abstract CONTRAT)
	 * 
	 * Méthode qui calcul le tarif du contrat d'assurance Moto.
	 * 		Il fait appel à la méthode "calculerMajoration".
	 * 		Vérifie s'il y a moins de 6 années d'assurance. (soustrait en fct de cette info)
	 * 		Multiplie par le malus/bonus.
	 * 
	 * 	@return Un double representant le tarif de l'assurance moto. (de l'objet instancié)
	 */
	@Override
	public double calculerTarif() {
		double tarif;
		tarif = 30 * calculerMajoration();
		if(this.getAnneeAssurance()>= 6) {
			tarif -= 6;
		}
		else {
			tarif -= getAnneeAssurance();
		}
		tarif *= this.getBonusOuMalus();
		return tarif;
		
	}
	
	/**
	 * (REDEFINITION DE LA METHODE ABSTRAITE imprimerResultatDevis() de la classe CONTRAT)
	 * 
	 * Objectif : affiche le resultat du devis d'assurance Moto.
	 * Il fait appel à la méthode CalculerTarif pour l'afficher.
	 */
	
	@Override
	public void imprimerResultatDevis() {
		System.out.println("DEVIS ASSURANCE MOTO");
		System.out.println("Nom : "+this.getNom());
		System.out.println("Prenom : "+this.getPrenom());
		System.out.println("\nLe tarif à payer pour l'assurance moto est de "+ this.calculerTarif()+" €");
		System.out.println("\nVeuillez joindre : ");
		System.out.println("Copie de carte grise moto");
		System.out.println("Copie de permis moto");
		System.out.println("RIB");
		System.out.println("Carte d'identité assureur");	
	}
}
