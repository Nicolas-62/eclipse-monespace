package exo.SocieteAssurance.cours;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Simulateur {
	public static void main(String[] args) {
		// Instantiation objet pour saisies clavier
		Scanner sc = new Scanner(System.in);
		// Variables de saisie;
		String nom, prenom, dateNais;
		int typeContrat, nbEnfant;
		boolean statutMarital;
		
		System.out.println("------------------------------------------------");
		System.out.println("   Contrat d'assurance : Simulateur de devis    ");
		System.out.println("------------------------------------------------");
		// Q1 : Saisie du nom	
		nom = saisieString("nom",sc);
		// Q2 : Saisie du prenom	
		prenom = saisieString("prenom",sc);
		// Q3 Saisie de la date de naissance
		dateNais = saisieString("date de naissance",sc);
		// Q4 Saisie du statut marital		
		System.out.println("Etes vous marié ? oui/non");
		statutMarital = saisieBoolean(sc);
		// Q5 saisie du nombre d'enfants
		System.out.print("Entrez le nombre d'enfants à votre charge : ");
		nbEnfant = (int)saisieNombre(0,10,sc);
		System.out.println("nbEnfant : "+nbEnfant);
		// Q6 saisie du type de contrat
		System.out.println("Choisissez le n° du type de contrat que vous voulez simuler");
		System.out.println("n°1 - voiture");
		System.out.println("n°2 - moto");
		System.out.println("n°3 - habitation");
		typeContrat = (int)saisieNombre(1,3,sc);

		if(typeContrat==1) {
			ContAssVoit contratVoit = new ContAssVoit(nom, prenom, dateNais, statutMarital, nbEnfant);
			// QV1 saisie du nombre de chevaux fiscaux
			System.out.println("saisie du nombre de chevaux fiscaux ? oui/non");
			boolean saisieChevaux = saisieBoolean(sc);
			if(saisieChevaux) {
				System.out.print("Entrez le nombre de chevaux fiscaux de votre voiture (entre 4 et 10) : ");			
				contratVoit.setSaisieChevaux(true);
				try {
					contratVoit.setNbChevaux((int)saisieNombre(0,10,sc));
				}catch(NbChevauxException e){
					System.out.println(e.getMessage());
				}
			}
			// QV2 saisie du bonus malus
			System.out.println("saisie de votre bonus/malus ? oui/non");
			boolean saisieBonus = saisieBoolean(sc);
			if(saisieBonus) {
				System.out.print("Entrez le montant de votre bonus (entre 0.5 et 1.5) : ");			
				contratVoit.setSaisieBonus(true);
				contratVoit.setBonus(saisieNombre(0.5,1.5,sc));
			}	
			// QV3 saisie nb années assurance
			System.out.print("Combien d'années cumulez vous d'assurance auto ? : ");			
			contratVoit.setAnneeAssure((int)saisieNombre(0,60,sc));	
			// QV4 saisie statut conjoint assuré
			if(statutMarital) {
				System.out.println("Votre conjoint sera-t-il assuré ?");
				contratVoit.setConjointAssure(saisieBoolean(sc));
			}
			// QV5 saisie statut enfant assuré
			if(nbEnfant >0) {
				System.out.println("Votre enfant sera-t-il assuré ?");
				contratVoit.setEnfantAssure(saisieBoolean(sc));
				contratVoit.imprimerResultatDevis();
			}		
		}else if(typeContrat==2) {
			ContAssMoto contratMoto = new ContAssMoto(nom, prenom, dateNais, statutMarital, nbEnfant);
			// QM1 saisie de la cylindrée
			System.out.print("Saisissez la cylindrée de votre moto (entre 50 et 1900) : ");			
			contratMoto.setCylindre((int)saisieNombre(50,1900,sc));
			// QM2 saisie du bonus malus
			System.out.print("Entrez le montant de votre bonus (entre 0.5 et 1.5) : ");			
			contratMoto.setBonus(saisieNombre(0.5,1.5,sc));
			// QM3 saisie nb années assurance
			System.out.print("Combien d'années cumulez vous d'assurance moto ? : ");			
			contratMoto.setAnneeAssure((int)saisieNombre(0,60,sc));
			contratMoto.imprimerResultatDevis();
			
		}else if(typeContrat==3) {
			ContAssMaison contratMaison = new ContAssMaison(nom, prenom, dateNais, statutMarital, nbEnfant);
			// QH1 saisie du type d'habitation
			contratMaison.setTypeHabitat(saisieString("type d'habitation (appartement ou maison)",sc));			
			// QH2 garage ?
			System.out.println("Avez vous un garage  ?");
			contratMaison.setGarage(saisieBoolean(sc));
			// QV3 saisie surface de l'habitation
			System.out.print("Quelle est la surface de votre habitation ? : ");			
			contratMaison.setSurface(saisieNombre(10,9999,sc));	
			contratMaison.imprimerResultatDevis();
		}else {
			System.out.println("type contrat : "+typeContrat);
		}
	// Fin des saisies, destruction de l'objet permettant les saisies
	sc.close();	
	}// Fin du simulateur
	
	
	
	/*
	 * fonction qui retourne une donnée saisie par l'utilisateur
	 * @param objet : type de donnée attendu
	 * @return saisieString : chaine saisie par l'utilisateur
	 */
	public static String saisieString(String objet, Scanner sc) {
		// variables :
		boolean saisieValide; 
		String saisieString;
		// saisie :
		System.out.println("Votre "+objet+" ?");	
		saisieValide = false; 
		saisieString="";
		while(!saisieValide){
			saisieString = sc.nextLine();			
			saisieString = saisieString.trim().toLowerCase();
			if(saisieString.equals("")) {
				System.out.println("Erreur, veuillez renseigner votre "+objet);									
			}else {
				saisieValide = true;	
			}
		}
		return saisieString;
	}
	/*
	 * fonction retourne un booleen en fonction de la saisie qu'elle demande à l'utilisateur (oui/non)
	 * @return statut : booleen
	 */
	public static boolean saisieBoolean(Scanner sc) {
		boolean saisieValide = false; 
		String saisieString="";	
		boolean statut = false;
		while(!saisieValide){
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
		}	
		return statut;
	}
	/*
	 * fonction qui retourne un nombre saisi par l'utilisateur
	 * @param min : valeur minimal
	 * @param max : valeur maximale 
	 * @return saisieDouble : le nombre attendu
	 */
	public static double saisieNombre(double min, double max, Scanner sc) {
		boolean saisieValide = false;
		double saisieDouble = 0;
		while(!saisieValide){
			try {
				String saisie = sc.nextLine();
				saisieDouble = Double.parseDouble(saisie);
				if(saisieDouble>=min && saisieDouble<=max) {
					saisieValide = true;
				}else {
					System.out.println("veuillez saisir un nombre compris dans l'intervalle :");
				}
			}catch(NumberFormatException i) {
				System.out.println("Erreur de saisie, veuillez saisir un nombre :");
			}finally {
				//...
			}
		}
		return saisieDouble;
	}	
}
