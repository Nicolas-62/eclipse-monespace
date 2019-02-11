import java.util.Scanner;

public class Essai {

	public static void main(String[] args) {

		// Conversion de type ou cast
		int a = 3, b = 2;
		double resultat;
		resultat = a / b;
		// Ici affiche 1, il faut caster en double a et b séparemment pour avoir 1.5
		System.out.println(resultat);

		// Saisie clavier
		Scanner sc = new Scanner(System.in);

		System.out.println("Veuillez saisir un mot");
		String mot = sc.nextLine();

		System.out.println("Vous avez saisi : " + mot);
		char lettre = mot.charAt(0);

		System.out.println("La premiere lettre du mot est : " + lettre);

		// retour à la ligne, attention !

		System.out.println("Veuillez saisir un chiffre :");
		int chiffre = sc.nextInt();
		System.out.println("Veuillez saisir un mot : ");
		sc.nextLine();
		String chaine = sc.nextLine();

		System.out.println("La valeur de la chaîne est : " + chaine);

	}

}
