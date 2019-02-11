

import java.util.Random;
import java.util.Scanner;

public class PierreFeuille {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nb;
		Random nbRand = new Random();
		
		String saisie;
		String[] tabValeur = {"feuille", "ciseau", "pierre"};
		int indice=0;
		
		System.out.println("***** Jeu Pierre Feuille Ciseau ***** \n");
		
		while(true) {
			boolean indiceTrouve= false;
			// Saisie utilisateur
			while(!indiceTrouve) {
				System.out.println("Veuillez saisir une valeur (Pierre, feuille ou ciseau) : ");
				saisie = sc.nextLine();
				saisie = saisie.toLowerCase();
				indiceTrouve = false;
				for(int i=0; i<tabValeur.length; i++) {
					if(saisie.equals(tabValeur[i])) {
						indice = i;
						indiceTrouve= true;
					}
				}
			}
			// choix d'un nombre entre 0 et 2
			nb = nbRand.nextInt(2);
			
			// comparaison des valeurs;
			if(indice == nb+1 || nb == indice+2) {			
				System.out.println("Vous avez gagné !!!");			
			}else if(indice == nb) {			
				System.out.println("Egalité...");		
			}else {
				System.out.println("Vous avez perdu");
			}
			// affichage valeur choisie par l'ordinateur
			System.out.println("valeur choisie par l'ordinateur : "+tabValeur[nb]);
		}
	}

}
