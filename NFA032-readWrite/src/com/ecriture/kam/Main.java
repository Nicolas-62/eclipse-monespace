package com.ecriture.kam;

import java.io.Console;

public class Main {

	public static void main(String[] args) {
//		Flux.ecrireFichier();
//		Flux.lireFichier("fichier.txt");
		Console console = System.console();
		if (console != null) {
			console.printf("Veuillez entrer votre nom: ");
			String name = console.readLine();
			console.printf("Veuillez entrer votre mot de passe: ");
			char[] passwordChars = console.readPassword();
			String password = new String(passwordChars);
			console.printf("%s vous êtes connecté" + " avec le mot de passe %s", name, password);
		} else {
			System.err.println("Pas de console disponible");
		}
		/*nom prenom sexe email, inserer, recuperer de la bdd, email unique, mettre quelque
		 *valeurs nulles
		 */
	}

}
