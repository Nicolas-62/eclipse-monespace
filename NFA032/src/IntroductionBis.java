import java.util.InputMismatchException;
import java.util.Scanner;

public class IntroductionBis {

	public static void main(String[] args) {
		// Déclaration variables
		String valeur;
		int nombreEntier;
		boolean capteur=true;
		Scanner sc = new Scanner(System.in);		
		
		while(capteur) {
			System.out.print("Veuillez entrer un nombre :");
			try {
				valeur=sc.nextLine();
				nombreEntier= Integer.parseInt(valeur);
				if(nombreEntier%2==0) {
					System.out.println(" => La valeur du nombre est pair");
				}
				else {
					System.out.println(" => La valeur du nombre est impair");
				}
			}
			catch(NumberFormatException e){
				System.out.println("La valeur saisie n'est pas un nombre.");
			}
			finally {
				//...
			}
		}
		sc.close();
	}
}
