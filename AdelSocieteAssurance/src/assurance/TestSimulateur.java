package assurance;

/**
 * 
 * @author ica
 * Description : Simulateur de devis pour contrats d’assurance
 *  (assurance Voiture, assurance Moto, assurance Maison)
 */

public class TestSimulateur {

	public static void main(String[] args) {


		String nom, prenom, date;
		int choixContrat, saisieEntier;
		double saisieDouble;
		boolean isMarie, isEnfant, saisieBool;
		
		System.out.println("***SIMULATEUR DEVIS DE CONTRAT ASSURANCE***\n\n");
		
		System.out.println("Quel est votre nom : ");
		nom = Saisie.texte();
		System.out.println("Quel est votre Prénom : ");
		prenom = Saisie.texte();
		System.out.println("Quelle est votre date de naissance (sous la forme \"jj/mm/aa\" ou \"jj/mm/aaaa\" ou \"jjmmaaaa\" ) : ");
		date = Saisie.date();
		System.out.println("Etes-vous marié(e) ou pas (oui ou non) ");
		isMarie = Saisie.ouiNon();
		
		System.out.println("Avez-vous des enfants ? (oui ou non) : ");
		isEnfant = Saisie.ouiNon();
		do {
			System.out.println("Quel contrat souhaitez-vous (1 : voiture : 2 : moto : 3 : habitat)");
			choixContrat = Saisie.entierPositif();
		} while(choixContrat < 1 || choixContrat > 3);
		
	
		switch(choixContrat){
		case 1 :  // devis Voiture 
			ContratAssuranceVoiture contratVoiture = new ContratAssuranceVoiture();
			contratVoiture.setNom(nom);
			contratVoiture.setPrenom(prenom);
			contratVoiture.setDateDeNaissance(date);
			contratVoiture.setEstMarie(isMarie);
			contratVoiture.setAvoirEnfant(isEnfant);
			
			System.out.println("Vous avez choisi l'assurance Voiture.");
			
			System.out.println("\nSaisir les informations suivantes : ");
			System.out.println("\nnombre de chevaux fiscaux de la voiture (entre 4 et 10) : ");
			saisieEntier = Saisie.chevauxFisc();
			contratVoiture.setNombreChevaux(saisieEntier);
			
			System.out.println("Votre bonus/malus (compris entre 0,5 et 1,5) ");
			saisieDouble = Saisie.bonusMalus();
			contratVoiture.setBonusOuMalus(saisieDouble);
			System.out.println("Nombre d'années d'assurance : ");
			saisieEntier = Saisie.entierPositif();
			contratVoiture.setAnneeAssurance(saisieEntier);
			if(contratVoiture.isEstMarie()) {
				System.out.println("Votre conjoint sera assuré (oui ou non)  ?");
				saisieBool = Saisie.ouiNon();
				contratVoiture.setConjointAssure(saisieBool);
			}
			if(contratVoiture.isAvoirEnfant()) {
				System.out.println("Votre enfant sera assuré (oui ou non) ?");
				saisieBool = Saisie.ouiNon();
				contratVoiture.setEnfantAssure(saisieBool);
			}
			
			contratVoiture.imprimerResultatDevis();
			
			
			break;
		case 2 : // devis Moto
			ContratAssuranceMoto contratMoto = new ContratAssuranceMoto();
			contratMoto.setNom(nom);
			contratMoto.setPrenom(prenom);
			contratMoto.setDateDeNaissance(date);
			contratMoto.setEstMarie(isMarie);
			contratMoto.setAvoirEnfant(isEnfant);
			System.out.println("Vous avez choisi l'assurance Moto.");
			
			System.out.println("\nSaisir les informations suivantes : ");
			
			System.out.println("\nVotre bonus/malus (compris entre 0,5 et 1,5) ");
			saisieDouble = Saisie.bonusMalus();
			contratMoto.setBonusOuMalus(saisieDouble);
			System.out.println("Nombre d'années d'assurance : ");
			saisieEntier = Saisie.entierPositif();
			contratMoto.setAnneeAssurance(saisieEntier);
			System.out.println("Nombre de cylindrée [compris entre 50 et 1900 cm3] ");
			saisieEntier = Saisie.cylindree();
			contratMoto.setCylindree(saisieEntier);
			
			contratMoto.imprimerResultatDevis();
			
			break;
		case 3 :  // devis Maison
			ContratAssuranceMaison contratMaison = new ContratAssuranceMaison();
			
			contratMaison.setNom(nom);
			contratMaison.setPrenom(prenom);
			contratMaison.setDateDeNaissance(date);
			contratMaison.setEstMarie(isMarie);
			contratMaison.setAvoirEnfant(isEnfant);
			
			System.out.println("Vous avez choisi l'assurance Maison.");
			
			System.out.println("\nSaisir les informations suivantes : ");

			System.out.println("\nEst ce un appartement ? (saisir : 'non' si maison) : ");
			saisieBool = Saisie.ouiNon();
			contratMaison.setAppartement(saisieBool);
			System.out.println("Avec garage ou non ? ('oui' ou 'non') ");
			saisieBool = Saisie.ouiNon();
			contratMaison.setAvecGarage(saisieBool);
			System.out.println("Saisir la surface de la maison : ");
			saisieEntier = Saisie.surface();
			contratMaison.setSurface(saisieEntier);
			System.out.println("Nombre de personne au foyer : ");
			saisieEntier = Saisie.entierPositif();
			contratMaison.setNbPersFoyer(saisieEntier);
			
			contratMaison.imprimerResultatDevis();
			break;
		}	
	}

}
