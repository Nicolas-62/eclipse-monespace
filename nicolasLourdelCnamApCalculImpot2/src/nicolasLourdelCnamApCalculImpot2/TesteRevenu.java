package nicolasLourdelCnamApCalculImpot2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TesteRevenu {

	public static void main(String[] args) {
		// Instantiation objet pour saisies clavier
		Scanner sc = new Scanner(System.in);	
		// Variables ; saisie du revenu
		int revenu = 0;
		boolean saisieRevenuValide = false; 
		// Variables ; saisie du statut
		String saisieStatut;
		int statut = 0;
		boolean saisieStatutValide = false;
		// Variables ; saisie du nb d'enfants à charge
		int nbEnfants = 0;
		boolean saisieNbEnfantsValide = false;		

		// Debut
		/**************************** Saisies ************************************************/
		// Saisie du revenu
		while(!saisieRevenuValide){
			try {
				System.out.print("Revenu net imposable foyer : ");
				revenu = sc.nextInt();
				saisieRevenuValide = true;
			}catch(InputMismatchException i) {
				System.out.println("Erreur de saisie, veuillez saisir un nombre.");
			}finally {
				sc.nextLine();
			}
		}
		// Saisie du statut marital		
		System.out.println("Etes vous marié ou pacsé ? oui/non");		
		while(!saisieStatutValide){
			try {
				saisieStatut = sc.nextLine();			
				saisieStatut = saisieStatut.trim().toLowerCase();
				if(saisieStatut.equals("oui")) {
					statut = 1;
					saisieStatutValide = true;					
				}else if(saisieStatut.equals("non")) {
					statut = 0;
					saisieStatutValide = true;
				}else {
					System.out.println("Erreur, veuillez répondre par oui ou non : ");
				}
			}catch(InputMismatchException i) {
				System.out.println("Erreur de saisie, veuillez saisir un nombre.");
			}
		}		
		// Saisie du nombre d'enfants
		while(!saisieNbEnfantsValide){
			try {
				System.out.print("Entrez le nombre d'enfants à votre charge : ");
				nbEnfants = sc.nextInt();
				saisieNbEnfantsValide = true;
			}catch(InputMismatchException i) {
				System.out.println("Erreur de saisie, veuillez saisir un nombre.");
			}finally {
				sc.nextLine();
			}
		}
		// Fin des saisies, destruction de l'objet permettant les saisies
		sc.close();
		// Création  et affichage d'un foyer fiscal
		FoyerFiscal nico = new FoyerFiscal(revenu, statut, nbEnfants);
		System.out.println(nico);

	}

}
