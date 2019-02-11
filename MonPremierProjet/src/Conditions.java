import java.util.Scanner;

public class Conditions {

	public static void main(String[] args) {

		System.out.println("Veuillez saisir un mot : ");
		Scanner sc = new Scanner(System.in);
		String mot = sc.nextLine();
		System.out.println("Vous avez saisi le mot : " + mot);
		char lettre = mot.charAt(0);
		System.out.println("La première lettre de ce mot est : " + lettre);

		switch (mot) {
		case "nico":
			System.out.println("Bienvenue " + mot);
			break;
		case "dede":
			System.out.println("Au revoir " + mot);
			break;
		default:
			System.out.println("Gros nul !!");
		}
	}

}
