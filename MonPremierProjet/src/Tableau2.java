import java.util.Scanner;

public class Tableau2 {

	public static void main(String[] args) {
		char tab[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
		char lettre, reponse = '0';
		int i = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Recherche caractère dans tableau");

		while (reponse == '0') {

			System.out.println("Entrez un caractère : ");
			lettre = sc.nextLine().charAt(0);

			while (tab[i] != lettre) {
				i++;
			}

		}

	}

}
