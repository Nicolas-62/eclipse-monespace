import java.util.InputMismatchException;
import java.util.Scanner;

public class Brut_net {

	public static void main(String[] args) {
		double salaireNet=0, salaireBrut=0;
		double taux=0.3;
		Scanner sc = new Scanner(System.in);
		while(salaireBrut!=-1) {
			// Saisie :
			System.out.println("Veuillez saisir le salaire Brut, tapez -1 pour arrêter : ");
			try {
				salaireBrut = sc.nextDouble();
				// Traitement :
				if(salaireBrut>0) {
					salaireNet = salaireBrut-salaireBrut*taux;		
					// Resultat :
					System.out.println("Le salaire Net est : "+salaireNet);
				}else if (salaireBrut==-1){
					System.out.println("Au revoir !");	
				}else {
					System.out.println("Veuillez entrer un nombre positif !");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Veuillez saisir un nombre !");
			}
			finally {
			    sc.nextLine();				
			}
		}
	}
}
