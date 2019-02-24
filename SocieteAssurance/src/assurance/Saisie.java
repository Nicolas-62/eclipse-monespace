package assurance;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 
 * @author ica
 * Objectif : Classe Saisie qui contient des m�thodes statiques de saisie
 * qui g�re les exceptions. 
 */
public class Saisie {

	public static Scanner sc = new Scanner(System.in);
	
	// �criture de la date sous la forme : "jj/mm/aa" ou "jj/mm/aaaa"
	// il peut y avoir trois s�parateur : "/" ou "." ou "-" ou aucun s�parateur.
	public static Pattern patternDate = Pattern.compile("^(0[1-9]|1[0-9]|2[0-9]|3[01])[/.-]?(0[1-9]|1[012])[/.-]?(19|20)?[0-9]{2}$");

	
	/**
	 * Utilisation de l'expression r�guli�re nomm�e patternDate
	 * @param date (une chaine de caract�re representant la saisie de la date)
	 * @return un booleen v�rifiant si la saisie est conforme � l'expression r�guli�re patternDate.
	 */
	public static boolean isDateValide(String date) {
		return patternDate.matcher(date).matches();
	}
	
	
	/**
	 * M�thode servant � la saisie de la date.
	 * @return la chaine r�presentant la date (si conforme � notre expression reguli�re (regex)).
	 */
	public static String date() {
		boolean erreur;
		String saisie="";
		do {
			erreur = false;
			saisie = sc.nextLine();
			if(! isDateValide(saisie)) {
				erreur = true;
				System.out.println("La date n'est pas conforme, veuillez resaisir une date sous la forme (sous la forme \"jj/mm/aa\" ou \"jj/mm/aaaa\" ou \"jjmmaaaa\" )  : ");
			}	
		}while(erreur);
		return saisie;		
	}
	
	/**
	 * M�thode servant � la saisie du texte (nom, pr�nom, date)
	 * V�rifie si la chaine est vide.
	 */
	public static String texte() {
		boolean erreur;
		String saisie = "";
		do {
			erreur = false;
			saisie = sc.nextLine();
			if(saisie.trim().length() < 1 ) {
				erreur = true;
				System.out.println("La chaine saisie est vide, veuillez saisir : ");
			}	
		}while(erreur);
		return saisie;
	}
	
	/**
	 * M�thode servant � la saisie des questions attendant une r�ponse booleenne.
	 * Verifie si la chaine de caract�re correspond bien � "oui" ou "non". (ignore la casse).
	 */
	public static Boolean ouiNon() {
		boolean erreur, ouiNon = true;
		String reponse="";
		do {
			erreur = false;
			reponse = sc.nextLine();
			if( reponse.equalsIgnoreCase("oui")) {
				ouiNon = true;
			}
			else if(reponse.equalsIgnoreCase("non")) {
				ouiNon = false;
			}
			else {
				erreur = true;
				System.out.println("Veuillez saisir 'oui' ou 'non' ");
			}
		} while(erreur);
		
		return ouiNon;
	}
	
	/**
	 * M�thode servant � la saisie du nombre de chevaux fiscaux.
	 * Verifie si bonne saisie. (entier compris entre 4 et 10)
	 */
	public static int chevauxFisc() {
		int nombre = 0;
		String saisie = "";
		boolean erreur;
		do {
			erreur = false;
			try {
				saisie = sc.nextLine();
				nombre = Integer.parseInt(saisie);
				if(nombre < 4 || nombre > 10) {
					erreur = true;
					System.out.println("Saisir un nombre entre 4 et 10");
				}
			} catch(NumberFormatException e) {
				erreur = true;
				System.out.println("Mauvaise saisie de valeur, veuillez saisir un entier  : ");
			}
		}while(erreur);
		
		return nombre;
	}
	
	/**
	 * Methode servant � la saisie du bonusMalus.
	 * V�rifie si la valeur est bien comprise entre 0,5 et 1,5 et qu'il n'y a pas d'erreur
	 * de saisie. (ex : 1,3 au lieu de 1.3).
	 */
	public static double bonusMalus() {
		double valeur = 0;
		String saisie = "";
		boolean erreur;
		do {
			erreur = false;
			try {
				saisie = sc.nextLine();
				valeur = Double.parseDouble(saisie);
				if(valeur < 0.5 || valeur > 1.5) {
					erreur = true;
					System.out.println("Saisir malus compris entre 0.5 et 1.5");
				}
			} catch(NumberFormatException e) {
				erreur = true;
				System.out.println("Mauvaise saisie de valeur, veuillez saisir un r�el  : ");
			}
		}
		while(erreur);
		return valeur;
	}
	
	/**
	 * M�thode servant � la saisie du nombre de cylindree
	 * V�rifie si le nombre est compris entre 50 et 1900 cm3 et qu'il s'agit bien d'un entier.
	 */
	public static int cylindree() {
		int valeur=0;
		String saisie = "";
		boolean erreur;
		do {
			erreur = false;
			try {
				saisie = sc.nextLine();
				valeur = Integer.parseInt(saisie);
				if(valeur < 50 || valeur > 1900) {
					erreur = true;
					System.out.println("Saisir un nombre de cylindre compris entre 50 et 1900");					
				}
			} catch(NumberFormatException e) {
				erreur = true;
				System.out.println("Mauvaise saisie de valeur, veuillez saisir un entier  : ");
			}
		}while(erreur);
		
		return valeur;
	}
	
	/**
	 * M�thode servant � la saisie de la surface.
	 * V�rifie si la surface est bien comprise entre 10 et 100 et qu'il s'agit bien d'un entier.
	 */
	public static int surface() {
		int valeur=0;
		String saisie = "";
		boolean erreur;
		do {
			erreur = false;
			try {
				saisie = sc.nextLine();
				valeur = Integer.parseInt(saisie);
				if(valeur < 10 || valeur > 100) {
					erreur = true;
					System.out.println("Saisir une surface comprise entre 10 et 100");					
				}
			} catch(NumberFormatException e) {
				erreur = true;
				System.out.println("Mauvaise saisie de valeur, veuillez saisir un entier  : ");
			}
		}while(erreur);
		
		return valeur;
	}	
	
	/**
	 * M�thode servant � la saisie d'un entier positif ou nul.
	 */
	public static int entierPositif() {
		int valeur=0;
		String saisie = "";
		boolean erreur;
		do {
			erreur = false;
			try {
				saisie = sc.nextLine();
				valeur = Integer.parseInt(saisie);
				if(valeur < 0) {
					erreur = true;
					System.out.println("Saisir un entier positif ou nul");					
				}
			} catch(NumberFormatException e) {
				erreur = true;
				System.out.println("Mauvaise saisie de valeur, veuillez saisir un entier  : ");
			}
		}while(erreur);
		
		return valeur;
	}
}
