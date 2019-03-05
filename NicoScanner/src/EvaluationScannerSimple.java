

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class EvaluationScannerSimple {
	public static void main(String[] args) {

		Scanner lecteur = null;
		double nb1 = 0, nb2 = 0;
		String ope = "";
		Pattern pattern = Pattern.compile("(\\d+(\\.\\d+)?)\\s?(\\S)\\s?(\\d+(\\.\\d+)?)\\s?");
		double resultat=0;
		try {
			lecteur = new Scanner(new File("Entree.txt"));
			while(lecteur.findInLine(pattern) != null) {
				MatchResult match = lecteur.match();
				nb1 = Double.parseDouble(match.group(1));
				ope = match.group(3);
				nb2 = Double.parseDouble(match.group(4));
				switch (ope) {
				case "+": resultat = nb1 + nb2;break;
				case "-": resultat = nb1 - nb2;break;
				case "x": resultat = nb1 * nb2;break;
				case "/": resultat = nb1 / nb2;break;
				default : System.out.println("Erreur");
				}
				System.out.println(nb1 + " " + ope + " " + nb2 + " = " + resultat);
				if (lecteur.hasNextLine()) lecteur.nextLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (lecteur!=null) lecteur.close();
		}
		System.exit(1);
	}
}
