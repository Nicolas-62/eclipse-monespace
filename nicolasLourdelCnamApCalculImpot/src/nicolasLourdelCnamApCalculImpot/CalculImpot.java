package nicolasLourdelCnamApCalculImpot;
/* Calcul de l'impot sur le revenu
 * demande à l'utilisateur de saisir son revenu, statut marital et nombre d'enfants à charge
 * et lui calcul et affiche le montant de son impot sur le revenu
 */
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculImpot {

	public static void main(String[] args) {
		// Instantiation objet pour saisies clavier
		Scanner sc = new Scanner(System.in);	
		// Variables ; saisie du revenu
		double revenu = 0;
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
				revenu = sc.nextDouble();
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
				System.out.println("Erreur de saisie, veuillez saisir oui ou non.");
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
		
		/**************************** Calculs ************************************************/
		
		/* 1. Calcul du quotient familial en fonction du staut marital et du nombre d'enfants à charge		
		 * Variables :
		 * Tableau des quotients familiaux : tabQuotientFam[nbEnfants][statut]
		 * nbEnfants : nombre d'enfants à charges 
		 * statut = 0 : célib, divorcé, veuf
		 * statut = 1 : marié ou pacsé
		 */
		double[][] tabQuotientFam = {	{1, 2}, {1.5, 2.5}, {2, 3}, {3, 4}, {4, 5}	};		
		// Quotient +1 pour chaque enfant supplémentaire si nbEnfants > 4
		double quotientFamilial; 		
		if(nbEnfants<=4) {
			quotientFamilial = tabQuotientFam[nbEnfants][statut];
		}else {
			quotientFamilial = tabQuotientFam[4][statut] + (nbEnfants-4);
		}
		System.out.println("quot : "+quotientFamilial);
		// 2. Diviser le revenu net imposable par le nombre de parts du quotient familial
		revenu = revenu / quotientFamilial;
		
		/* 3. Appliquer le barème progressif de l’impôt au résultat obtenu
		 * 
		 * Tableau des plafonds et taux d'imposition :
		 */
		double[] plafond = {9_807, 	27_086, 	72_617, 	153_783};
		double[] taux =	   {0,		0.14,		0.30 ,		0.41 ,	0.45};
		double impot = 0;

		if(revenu<plafond[0]) {
			impot = revenu*taux[0];
		}else {
			// Calcul première tranche
			impot = plafond[0]*taux[0];
			// Calcul tranches suivantes
			for(int i=1; i<plafond.length; i++) {
				if(revenu<plafond[i]) {
					// Calcul dernière tranche (celle dans laquelle est le revenu)
					impot += (revenu-plafond[i-1])*taux[i];
					break;
				}else {
					// Calcul tranches précedentes du revenu
					impot += (plafond[i]-plafond[i-1])*taux[i];
					// Calcul revenu supérieur à la dernière tranche
					if(i == plafond.length-1) {
						impot += (revenu-plafond[i])*taux[i+1];
					}
				}
			}
		}
		// 4. Multiplier le résultat par le nombre de parts du quotient familial
		impot = impot*quotientFamilial;
		
		/**************************** Resultat ************************************************/
		
        // Mise en forme du resultat à deux chiffres après la virgule
		DecimalFormat df = new DecimalFormat("0.00");
        String resultat = df.format(impot);
        
		System.out.print("\nL'impôt à payer est de : "+resultat);
	}
}
