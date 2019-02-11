import java.util.Scanner;

public class JourSuivant {

	public static void main(String[] args) {
		// Variables
		int jour, mois, annee, nb_jours_mois;
		Scanner sc = new Scanner(System.in);

		// Debut saisie des données :
		System.out.println("Veuillez saisir le jour");
		jour = sc.nextInt();
		System.out.println("Veuillez saisir le mois");
		mois = sc.nextInt();
		System.out.println("Veuillez saisir l'année");
		annee = sc.nextInt();

		// Traitement : calcul du nombre de jours dans le mois saisi.
		if (mois == 1 || mois == 3 || mois == 5 || mois == 7 || mois == 8 || mois == 10 || mois == 12) {
			nb_jours_mois = 31;
		} else if (mois == 2) {
			if ((annee % 4 == 0 && annee % 100 != 0) || annee % 400 == 0) {
				nb_jours_mois = 29;
			} else {
				nb_jours_mois = 28;
			}
		} else {
			nb_jours_mois = 30;
		}
		// Traitement des changements de mois et d'année :
		// On est à la fin du mois :
		if (jour == nb_jours_mois) {
			// On est à la fin du mois et de l'année.
			if (mois == 12) {
				annee = annee + 1;
				mois = 1;
			} else {
				mois = mois + 1;
			}
			jour = 1;
		} else {
			jour = jour + 1;
		}
		// Fin, affichage du résultat
		System.out.println("La nouvelle date est : " + jour + "/" + mois + "/" + annee + "");
	}

}
