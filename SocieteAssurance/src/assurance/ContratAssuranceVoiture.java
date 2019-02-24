package assurance;

/**
 * 
 * @author ica
 * Description : Classe concr�te de l'assurance voiture qui h�rite de la classe abstraite ContratVehicule.
 */

public class ContratAssuranceVoiture extends ContratVehicule {
	
	private int nombreChevaux;
	private boolean conjointAssure = false;
	private boolean enfantAssure = false;
		
	/*
	 * Getters et Setters des attributs.
	 */
	
	public int getNombreChevaux() {
		return nombreChevaux;
	}
	public void setNombreChevaux(int nombreChevaux) {
		this.nombreChevaux = nombreChevaux;
	}

	public boolean isConjointAssure() {
		return conjointAssure;
	}
	
	public void setConjointAssure(boolean conjointAssure) {
		this.conjointAssure = conjointAssure;			

	}
	public boolean isEnfantAssure() {
		return enfantAssure;
	}
	
	public void setEnfantAssure(boolean enfantAssure) {
		this.enfantAssure = enfantAssure;
		
	}
	
	/**
	 * (REDEFINITION METHODE ABSTRAITE calculerMajoration() de classe abstract ContratVehicule)
	 * 
	 * M�thode servant � calculer la majoration selon le nombre de chevaux fiscaux.
	 * @return un r�el representant la majoration en fonction du nombre de chevaux fiscaux.
	 */
	public double calculerMajoration() {
		double majChevauxFiscaux = 1;
		switch(this.nombreChevaux) {
		case 4 :
			majChevauxFiscaux = 1;
			break;
		case 5 :
			majChevauxFiscaux = 1.1;
			break;
		case 6 :
			majChevauxFiscaux = 1.2;
			break;
		case 7 :
			majChevauxFiscaux = 1.3;
			break;
		case 8 :
			majChevauxFiscaux = 1.4;
			break;
		case 9 :
			majChevauxFiscaux = 1.5;
			break;
		case 10 :
			majChevauxFiscaux = 1.6;
			break;
		}
		return majChevauxFiscaux;
	}
	
	// redefinition des m�thodes abstraites 
	
	/**
	 * (REDEFINITION DE LA METHODE ABSTRAITE calculerTarif() de la classe abstract CONTRAT)
	 * 
	 * M�thode qui calcul le tarif du contrat d'assurance voiture.
	 * 		Il fait appel � la m�thode "calculerMajoration".
	 * 		V�rifie s'il y a moins de 6 ann�es d'assurance. (soustrait en fct de cette info)
	 * 		V�rifie si l'enfant et le conjoint (s'il y'a) sont assur�s. (soustrait en fct)
	 * 		Multiplie par le malus/bonus.
	 * 
	 * 	@return Un double representant le tarif de l'assurance voiture. (de l'objet instanci�)
	 */
	@Override
	public double calculerTarif() {
		double tarif;
		
		double majChevauxFisc = calculerMajoration();
		
		tarif = 20*majChevauxFisc;
		if(this.getAnneeAssurance()>= 6) {
			tarif -= 6;
		}
		else {
			tarif -= getAnneeAssurance();
		}
		if(this.isEnfantAssure()) {
			tarif += (this.nombreChevaux)-3;
		}
		if(this.isConjointAssure()) {
			tarif += (this.nombreChevaux)-3;
		}
		tarif *= this.getBonusOuMalus();
		
		return tarif;
		
	}
	
	/**
	 * (REDEFINITION DE LA METHODE ABSTRAITE imprimerResultatDevis() de la classe CONTRAT)
	 * 
	 * Objectif : affiche le resultat du devis d'assurance voiture.
	 * Il fait appel � la m�thode CalculerTarif pour l'afficher.
	 */
	
	@Override
	public void imprimerResultatDevis() {

		System.out.println("DEVIS ASSURANCE VOITURE");
		System.out.println("Nom : "+this.getNom());
		System.out.println("Prenom : "+this.getPrenom());
		System.out.println("\nLe tarif � payer pour l'assurance voiture est de "+this.calculerTarif()+" �");
		System.out.println("\nVeuillez joindre : ");
		System.out.println("Copie de carte grise");
		System.out.println("Copie de permis");
		if(this.isConjointAssure()) {
			System.out.println("Copie permis conjoint");
		}
		if(this.isEnfantAssure()) {
			System.out.println("Copie permis enfant");
		}
		System.out.println("RIB");
		System.out.println("Carte d'identit� assureur");
	}
	
	
	

}
