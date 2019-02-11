import java.util.InputMismatchException;
import java.util.Scanner;

public class Introduction {

	public static void main(String[] args) {
		// Déclaration variables
		int nombre=0;
		boolean capteur=true;
		Scanner sc = new Scanner(System.in);
		
		// Saisie de la valeur
		while(capteur) {
			System.out.print("Veuillez entrer un nombre :");
			try {
				nombre=sc.nextInt();
				
				if(nombre%2==0) {
					System.out.println(" => La valeur du nombre est pair");
				}
				else {
					System.out.println(" => La valeur du nombre est impair");
				}
			}
			catch(InputMismatchException e){
				System.out.println("La valeur saisie n'est pas un nombre.");
			}
			finally {
				sc.nextLine();
			}
		}	
	}
}
