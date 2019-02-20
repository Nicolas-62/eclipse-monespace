package exo.SocieteAssurance.cours;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Simulateur {
	public static void main(String[] args) {
		// Variables ;
		String nom, prenom, dateNais, typeContrat;
		boolean statutMarital;
		int nbEnfant;
		System.out.println("------------------------------------------------");
		System.out.println("   Contrat d'assurance : Simulateur de devis    ");
		System.out.println("------------------------------------------------");
		// Q1 : Saisie du nom	
		nom = saisieString("nom");
		// Q2 : Saisie du prenom	
		prenom = saisieString("prenom");
		// Q3 Saisie de la date de naissance
		dateNais = saisieString("date de naissance (format JJ/MM/AAAA");
		// Q4 Saisie du statut marital		
		System.out.println("Etes vous marié ? oui/non");
		statutMarital = saisieBoolean();
		// Q5 saisie du nombre d'enfants
		System.out.print("Entrez le nombre d'enfants à votre charge : ");
		nbEnfant = (int)saisieNombre(0,10);
		// Q6 saisie du type de contrat
		typeContrat = saisieString("contrat (voiture, moto, habitation)");

		if(typeContrat == "voiture") {
			ContAssVoit contratVoit = new ContAssVoit(nom, prenom, dateNais, statutMarital, nbEnfant);
			// QV1 saisie du nombre de chevaux fiscaux
			System.out.println("saisie du nombre de chevaux fiscaux ? oui/non");
			boolean saisieChevaux = saisieBoolean();
			if(saisieChevaux) {
				System.out.print("Entrez le nombre de chevaux fiscaux de votre voiture (entre 4 et 10) : ");			
				contratVoit.setSaisieChevaux(true);
				contratVoit.setNbChevaux((int)saisieNombre(4,10));
			}
			// QV2 saisie du bonus malus
			System.out.println("saisie de votre bonus/malus ? oui/non");
			boolean saisieBonus = saisieBoolean();
			if(saisieBonus) {
				System.out.print("Entrez le montant de votre bonus (entre 0.5 et 1.5) : ");			
				contratVoit.setSaisieBonus(true);
				contratVoit.setBonus(saisieNombre(0.5,1.5));
			}	
			// QV3 saisie nb années assurance
			System.out.print("Combien d'années cumulez vous d'assurance auto ? : ");			
			contratVoit.setAnneeAssure((int)saisieNombre(0,60));	
			// QV4 saisie statut conjoint assuré
			if(statutMarital) {
				System.out.println("Votre conjoint sera-t-il assuré ?");
				contratVoit.setConjointAssure(saisieBoolean());
			}
			// QV5 saisie statut enfant assuré
			if(nbEnfant >0) {
				System.out.println("Votre enfant sera-t-il assuré ?");
				contratVoit.setEnfantAssure(saisieBoolean());
			}		
		}else if(typeContrat == "moto") {
			ContAssMoto contratMoto = new ContAssMoto(nom, prenom, dateNais, statutMarital, nbEnfant);
			// QM1 saisie de la cylindrée
			System.out.print("Saisissez la cylindrée de votre moto (entre 50 et 1900) : ");			
			contratMoto.setCylindre((int)saisieNombre(50,1900));
			// QM2 saisie du bonus malus
			System.out.print("Entrez le montant de votre bonus (entre 0.5 et 1.5) : ");			
			contratMoto.setBonus(saisieNombre(0.5,1.5));
			// QM3 saisie nb années assurance
			System.out.print("Combien d'années cumulez vous d'assurance moto ? : ");			
			contratMoto.setAnneeAssure((int)saisieNombre(0,60));
			
		}else if(typeContrat == "habitation") {
			ContAssMaison contratMaison = new ContAssMaison(nom, prenom, dateNais, statutMarital, nbEnfant);
			// QH1 saisie du type d'habitation
			contratMaison.setTypeHabitat(saisieString("type d'habitation (appartement ou maison)"));			
			// QH2 garage ?
			System.out.println("Avez vous un garage  ?");
			contratMaison.setGarage(saisieBoolean());
			// QV3 saisie surface de l'habitation
			System.out.print("Quelle est la surface de votre habitation ? : ");			
			contratMaison.setSurface(saisieNombre(10,9999));		
		}			
	}// Fin du simulateur
	
	
	
	/*
	 * fonction qui retourne une donnée saisie par l'utilisateur
	 * @param objet : type de donnée attendu
	 * @return saisieString : chaine saisie par l'utilisateur
	 */
	public static String saisieString(String objet) {
		// Instantiation objet pour saisies clavier
		Scanner sc = new Scanner(System.in);
		// variables :
		boolean saisieValide; 
		String saisieString;
		// saisie :
		System.out.println("Votre "+objet+" ?");	
		saisieValide = false; 
		saisieString="";
		while(!saisieValide){
			try {
				saisieString = sc.nextLine();			
				saisieString = saisieString.trim().toLowerCase();
				if(saisieString.equals("")) {
					System.out.println("Erreur, veuillez renseigner votre "+objet);									
				}else {
					saisieValide = true;	
				}
			}catch(NoSuchElementException i) {
				System.out.println("Aucune saisies");
			}
		}
		// Fin des saisies, destruction de l'objet permettant les saisies
		sc.close();	
		return saisieString;
	}
	/*
	 * fonction qui retourne le statut marital saisi par l'utilisateur
	 * @return statut : vaut true si utilisateur marié
	 */
	public static boolean saisieBoolean() {
		Scanner sc = new Scanner(System.in);
		boolean saisieValide = false; 
		String saisieString="";	
		boolean statut = false;
		while(!saisieValide){
			try {
				saisieString = sc.nextLine();			
				saisieString = saisieString.trim().toLowerCase();
				if(saisieString.equals("oui")) {
					statut = true;
					saisieValide = true;					
				}else if(saisieString.equals("non")) {
					statut = false;
					saisieValide = true;
				}else {
					System.out.println("Erreur, veuillez répondre par oui ou non : ");
				}
			}catch(NoSuchElementException i) {
				System.out.println("Erreur de saisie, veuillez saisir oui ou non.");
			}
		}	
		sc.close();
		return statut;
	}
	/*
	 * fonction qui retourne le nombre d'enfants saisis par l'utilisateur
	 * @param min : valeur minimal exclue
	 * @param max : valeur maximale eclue
	 * @return saisieDouble : le nombre d'enfants de l'utilisateur
	 */
	public static double saisieNombre(double min, double max) {
		Scanner sc = new Scanner(System.in);
		boolean saisieValide = false;
		double saisieDouble = 0;
		while(!saisieValide){
			try {
				System.out.println("veuillez saisir un nombre entre "+min+" et "+max);
				saisieDouble = sc.nextInt();
				if(saisieDouble>=min && saisieDouble<=max)
					saisieValide = true;
			}catch(InputMismatchException i) {
				System.out.println("Erreur de saisie, veuillez saisir un nombre.");
			}finally {
				sc.nextLine();
			}
		}
		// Fin des saisies, destruction de l'objet permettant les saisies
		sc.close();	
		return saisieDouble;
	}	
}
