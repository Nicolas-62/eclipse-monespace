import java.util.Scanner;

public class Degre {

	public static double arrondi(double A, int B) {
		return (double) ((int) (A * Math.pow(10, B) + .5)) / Math.pow(10, B);
	}

	public static void main(String[] args) {
		int choixMode = 0;
		char reset = 'O';
		double resultat, temp;
		Scanner sc = new Scanner(System.in);

		System.out.println("Convertisseur de degrés, Celsius/Farenheit");
		System.out.println("==========================================");

		while (reset == 'O') {
			while (choixMode != 1 && choixMode != 2) {
				System.out.println("Choisissez le mode de conversion : ");
				System.out.println("1 - Celsius->Farenheit");
				System.out.println("2 - Farenheit/Celsius");
				choixMode = sc.nextInt();
				sc.nextLine();
			}
			System.out.println("Entrez la température : ");
			temp = sc.nextDouble();
			sc.nextLine();

			switch (choixMode) {
			case 1:
				resultat = (temp - 32) * 5 / 9;
				resultat = arrondi(resultat, 3);
				System.out.println(temp + "°C correspond à " + resultat + "°F");
				break;
			case 2:
				resultat = (9 * temp / 5) + 32;
				resultat = arrondi(resultat, 3);
				System.out.println(temp + "°F correspond à " + resultat + "°C");
				break;
			}
			choixMode = 0;
			do {
				System.out.println("Souhaitez vous convertir une autre température ? O/N");
				reset = sc.nextLine().charAt(0);
			} while (reset != 'O' && reset != 'N');
		}
		System.out.println("Au revoir !");

	}

}
