import java.util.Scanner;

public class TestStringMethodes {

	public static void main(String[] args) {
		
		String operation ="2211";
		int nombre1 = 11;
		int nombre2 = 22;
		char operateur = '+';
		int resultat = nombre1+operateur+nombre2;
		System.out.println("resultat : "+(int)operateur);
		double k = Double.valueOf(operation).doubleValue();
		System.out.println("k : "+k);
		String phrase = "Salut gros naze";
		System.out.println(phrase);
		System.out.println(phrase.substring(1, 3));
		String prefix = "Sa";
		System.out.println(phrase.startsWith(prefix));
		int a=5;
		String s = a+"";
		System.out.println(s);
		System.out.println(String.valueOf(s));
		System.out.println("saisie oui : ");
		Scanner sc = new Scanner(System.in);
		String oui = sc.nextLine();
		String valeur = String.valueOf(oui.trim().toLowerCase());
//		String valeur="oui";
		if(valeur == "oui") {
			System.out.println("good");
		}else {
			System.out.println("valeur : "+valeur);
		}

	}

}
