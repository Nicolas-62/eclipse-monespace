import java.util.Scanner;

public class Boucles {

	// Sous-programmes, fonctions et boucles :
	public static void ssPrenom() {
		Scanner sc = new Scanner(System.in);
		char reponse = 'O';

		while (reponse == 'O') {

			System.out.println("Veuillez saisir votre prénom : ");
			String prenom = sc.nextLine();
			System.out.println("Bonjour " + prenom);

			reponse = ' ';
			System.out.println("Voulez vous recommencez ? (O/N)");
			reponse = sc.nextLine().charAt(0);
			while (reponse != 'O' && reponse != 'N') {
				System.out.println("Mauvaise reponse, voulez vous recommencez ? (O/N)");
				reponse = sc.nextLine().charAt(0);
			}
		}
		System.out.println("Au revoir !");
	}

	public static void ssBoucle(int p1, int p2) {

		for (int i = 0, j = 2; (i < p1 && j < p2); i++, j += 2) {
			System.out.println("i = " + i + ", j = " + j);
		}
	}

	public static double fcValeurAbsolue(double x) {
		double abs;
		if (x < 0) {
			abs = -x;
		} else {
			abs = x;
		}
		return abs;
	}

	public static void main(String[] args) {
		ssBoucle(10, 20);
		System.out.println(fcValeurAbsolue(20));

	}
}
