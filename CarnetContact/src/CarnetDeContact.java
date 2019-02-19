import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;

import fr.perso.mesclasses.Clavier;

public class CarnetDeContact {
	/*
	 * Fonction qui lit/créer le fichier qui contient le carnet de contact
	 * 
	 * @param String[][] tabContact : un tableau vide qui va contenir les contacts
	 * @return String[][] tabContact : le tableau qui contient les contacts
	 */
	public static String[][] lireCarnet(String[][] tabContact) {

		ObjectInputStream ois;
		File source = new File("carnet.txt");
		if (source.length() != 0) {
			try {
				ois = new ObjectInputStream(new FileInputStream(source));
				tabContact = (String[][]) ois.readObject();
				ois.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return tabContact;
	}

	/*
	 * Fonction qui enregistre le carnet de contact dans un fichier
	 * 
	 * @param String[][] tabContact : tableau qui contient les contacts
	 */
	public static void ecrireCarnet(String[][] tabContact) {

		ObjectOutputStream oos;
		File source = new File("carnet.txt");
		try {
			oos = new ObjectOutputStream(new FileOutputStream(source));
			oos.writeObject(tabContact);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Fonction qui enregistre le choix de l'utilisateur
	 * @return int choix : l'indice du choix de l'utilisateur
	 */
	public static int saisieChoixMenu() {

		boolean saisieChoixValide = false;
		int choix = 0;
		while (!saisieChoixValide) {
			try {
				System.out.print(" Votre choix : ");
				choix = Clavier.readInt();
				if (choix >= -1 && choix <= 5 && choix != 0) {
					saisieChoixValide = true;
				} else {
					System.out.println("Veuillez saisir un chiffre compris dans la liste : ");
				}
			} catch (InputMismatchException i) {
				System.out.println("Erreur de saisie, veuillez saisir un nombre.");
			}
		}
		return choix;
	}
	/*
	 * Fonction qui enregistre un contact dans le carnet
	 * @param String[][] tabContact : carnet
	 * @param int indice : indice du carnet où est enregistré le contact
	 */
	public static void saisieContact(String[][] tabContact, int indice) {
		String groupe = "";
		String nom = "";
		String prenom = "";
		String numTel = "";
		String email = "";
		String contient = "aàäbecdeèéfghijklmnopqrstuvwxyz";
		groupe = saisieGroupe();
		nom = saisieString(nom, "Nom", 2, 25, contient);
		prenom = saisieString(prenom, "prenom", 2, 25, contient);
		numTel = saisieNumero(numTel);
		email = saisieMail(email);
		// enregistrement du contact dans le carnet à la place libre trouvée
		tabContact[indice][0] = groupe;
		tabContact[indice][1] = nom;
		tabContact[indice][2] = prenom;
		tabContact[indice][3] = numTel;
		tabContact[indice][4] = email;
	}
	/*
	 * Fonction qui demande la saisie d'un groupe du carnet
	 * @return String choixGroupe : le nom du groupe saisi par l'utilisateur
	 */
	public static String saisieGroupe() {
		String[] tabGroupes = { "amis", "famille", "collegues", "clients" };
		boolean saisieValide;
		String choixGroupe = "";
		int groupe = 0;
		do {
			System.out.println("Sasie du groupe : ");
			for (int i = 0; i < tabGroupes.length; i++) {
				System.out.println(" " + i + ". " + tabGroupes[i]);
			}
			System.out.println("Veuillez saisir le n° du groupe dans le carnet de contact :");
			groupe = Clavier.readInt();
			saisieValide = true;
			while (groupe < 0 || groupe > 3) {
				System.out.println("Veuillez saisir un numéro valide");
				groupe = Clavier.readInt();
			}
		} while (!saisieValide);
		switch (groupe) {
		case 0:
			choixGroupe = tabGroupes[0];
			break;
		case 1:
			choixGroupe = tabGroupes[1];
			break;
		case 2:
			choixGroupe = tabGroupes[2];
			break;
		case 3:
			choixGroupe = tabGroupes[3];
			break;
		}
		return choixGroupe;
	}
	/*
	 * Fonction qui demande et contrôle la saisie d'une chaîne de caractère
	 * 
	 * @param String chaine : chaîne qui va contenir la saisie de l'utilisateur
	 * @param String type : type de variable attendu (nom, prenom, mail..)
	 * @param int minLength : taille minimale que doit faire la chaîne
	 * @param int maxLength : taille maximale que doit faire la chaîne
	 * @param String contient : caractères autorisés dans la saisie
	 * @return String chaine : chaîne saisie par l'utilisateur
	 */
	public static String saisieString(String chaine, String type, int minLength, int maxLength, String contient) {
		boolean saisieValide;
		do {
			saisieValide = true;
			System.out.println(type + " ?");
			chaine = Clavier.readString();
			chaine = chaine.trim().toLowerCase();
			if (chaine.length() < minLength) {
				System.out.println("Vous devez saisir au moins " + minLength + " caractères");
				saisieValide = false;
				continue;
			}
			if (chaine.length() > maxLength) {
				System.out.println("Votre saisie doit contenir au max " + maxLength + " caractères.");
				saisieValide = false;
				continue;
			}
			/*
			 * La string ne doit pas comporter les caractères présents dans la variable
			 * "contient" on vérifie que chaque caractère de celle ci est bien présent dans
			 * "contient"
			 */
			char[] chaineTabChar = chaine.toCharArray();
			for (int i = 0; i < chaineTabChar.length; i++) {
				/*
				 * la methode contains s'applique sur un objet de type string, on lui envoie la
				 * représentation en string de notre caractère à analyser.
				 */
				if (!contient.contains(String.valueOf(chaineTabChar[i]))) {
					System.out.println("Votre " + type + " contient des caractères non valides");
					saisieValide = false;
					break;
				}
			}
		} while (!saisieValide);
		return chaine;
	}
	/*
	 * Fonction qui contrôle la saisie du numéro de téléphone
	 * @param String chaine : chaîne qui va contenir la saisie de l'utilisateur
	 * @return String chaine : chaine saisie par l'utilisateur
	 */
	public static String saisieNumero(String chaine) {

		boolean saisieValide;
		do {
			System.out.println("Numéro  de téléphone ?");
			chaine = Clavier.readString();
			saisieValide = true;
			if (chaine.charAt(0) != '0') {
				System.out.println("Votre numéro doit commencer par zéro.");
				saisieValide = false;
			}
			if (chaine.length() != 10) {
				System.out.println("Votre numéro doit comporter 10 chiffres.");
				saisieValide = false;
			}
			try {
				Integer.parseInt(chaine);
			} catch (NumberFormatException e) {
				System.out.println("Veuillez ne saisir que des chiffres.");
				saisieValide = false;
			}
		} while (!saisieValide);
		return chaine;
	}
	/*
	 * Fonction qui contrôle la saisie de l'adresse mail
	 * @param String chaine : chaîne qui va contenir la saisie de l'utilisateur
	 * @return String mail : chaine saisie par l'utilisateur
	 */
	public static String saisieMail(String chaine) {
		boolean saisieValide;
		String saisie1 = "", saisie2 = "", saisie3 = "", email = "";
		String contient = "abecdefghijklmnopqrstuvwxyz.-_123456789";
		System.out.println("Format de l'adresse : \"saisie1\"@\"saisie2.\"saisie3\"");
		do {
			saisieValide = true;
			email += saisieString(saisie1, "Saisie1", 1, 30, contient);
			email += "@";
			email += saisieString(saisie2, "Saisie2", 2, 30, contient);
			email += ".";
			contient = "abecdefghijklmnopqrstuvwxyz";
			email += saisieString(saisie3, "Saisie3", 2, 4, contient);
		} while (!saisieValide);
		return email;

	}
	/*
	 * Fonction qui ajoute un contact dans le carnet à une ligne vide
	 * @param String[][] tabContact : le carnet
	 * 
	 */
	public static void ajouterContact(String[][] tabContact) {

		boolean contact = false;
		int indice = 0;
		// Recherche d'un place libre dans le carnet de contact
		for (int i = 0; i < tabContact.length; i++) {
			if (tabContact[i][0] == null) {
				contact = true;
				indice = i;
				break;
			}
		}
		if (!contact) {
			System.out.println("Le carnet de contact est plein !!");
			// Saisie des infos du contact
		} else {
			saisieContact(tabContact, indice);
			System.out.println("Contact ajouté !");
		}
	}
	/*
	 * Fonction qui modifie un contact
	 * @param String[][] tabContact : le carnets
	 */
	public static void modifierContact(String[][] tabContact) {

		if (isCarnetVide(tabContact)) {
			System.out.println("Aucun contact dans le carnet");
		} else {
			afficherCarnetContacts(tabContact);
			int index = 0;
			System.out.println("Veuillez saisir l'index du contact à modifier : ");
			index = Clavier.readInt();

			while (tabContact[index][0] == null) {
				System.out.println("index invalide, veuillez saisir l'index du contact à modifier : ");
				index = Clavier.readInt();
			}
			saisieContact(tabContact, index);
			System.out.println("Contact modifié !");
		}
	}
	/*
	 * Fonction qui supprime su contact
	 * @param String[][] tabContact : le carnet
	 * 
	 */
	public static void supprimerContact(String[][] tabContact) {

		if (isCarnetVide(tabContact)) {
			System.out.println("Aucun contact dans le carnet");
		} else {
			int index = 0;
			afficherCarnetContacts(tabContact);
			System.out.println("Veuillez saisir l'index du contact à supprimer : ");
			index = Clavier.readInt();
			while (tabContact[index][0] == null) {
				System.out.println("index invalide, veuillez saisir l'index du contact à modifier : ");
				index = Clavier.readInt();
			}
			for (int i = 0; i < tabContact[index].length; i++) {
				tabContact[index][i] = null;
			}
			System.out.println("Contact supprimé !");
		}
	}
	/*
	 * Fonction qui verifie si le carnet est vide
	 * @return boolean contact : variable qui vaut true si le carnet est vide
	 */
	public static boolean isCarnetVide(String[][] tabContact) {

		boolean contact = true;
		for (int i = 0; i < tabContact.length; i++) {
			if (tabContact[i][0] != null) {
				contact = false;
				break;
			}
		}
		return contact;
	}
	/*
	 * Fonction qui affiche un contact
	 * @param String[][] tabContact : carnet de contact
	 */
	public static void afficherUnContact(String[] tabContact) {
		System.out.format("Groupe : %-12s", tabContact[0]);
		System.out.format("Nom : %-20s", tabContact[1]);
		System.out.format("Prenom : %-15s", tabContact[2]);
		System.out.format("NumTel : %-12s", tabContact[3]);
		System.out.format("Email : %-25s", tabContact[4]);

	}
	/*
	 * Fonction qui affiche tout ou partie du carnet de contact suivant les choiux de l'utilisateur
	 * @param String[][] tabContact : carnet de contact
	 */
	public static void afficherCarnetContacts(String[][] tabContact) {

		if (isCarnetVide(tabContact)) {
			System.out.println("Aucun contact dans le carnet");
		} else {
			System.out.println("Afficher tout le carnet ? \"o\" pour oui, \"n\" pour non");
			char choix = Clavier.readChar();
			choix = Character.toLowerCase(choix);
			while (choix != 'o' && choix != 'n') {
				System.out.println("veuillez rentrer une valeur valide :");
				choix = Clavier.readChar();
				choix = Character.toLowerCase(choix);
			}
			if (choix == 'n') {
				String choixGroupe = saisieGroupe();
				afficherContactsMatch(tabContact, choixGroupe);
			} else {
				for (int i = 0; i < tabContact.length; i++) {
					if (tabContact[i][0] != null) {
						System.out.print(i + " ");
						afficherUnContact(tabContact[i]);
						System.out.println();
					}
				}
			}
		}
	}
	/*
	 * Fonction qui affiche les contacts qui possèdent dans leurs coordonnées 
	 * la chaine de caractères passée en paramètre.
	 * 
	 * @param String[][] tabContact : le carnet de contacts
	 * @param String match : la chaîne à tester
	 */
	public static void afficherContactsMatch(String[][] tabContact, String match) {
		boolean contact = false;
		// Recherche de cette chaine dans les infos des contacts
		System.out.println("Contacts trouvés : ");
		for (int i = 0; i < tabContact.length; i++) {
			for (int j = 0; j < tabContact[i].length; j++) {
				if (tabContact[i][j] != null && tabContact[i][j].contains(match)) {
					// affichage des contacts qui possèdent cette chaine dans leurs infos
					afficherUnContact(tabContact[i]);
					contact = true;
				}
			}
		}
		if (!contact) {
			System.out.println("Aucun");
		}
	}
	/*
	 * Fonction recherche les contacts en fonction de la chaine de caractère
	 * saisie par l'utilisateur.
	 * @param String[][] tabContact : le carnet de contact
	 */
	public static void chercherContact(String[][] tabContact) {

		if (isCarnetVide(tabContact)) {
			System.out.println("Aucun contact dans le carnet");
		} else {
			String match = "";

			// Saisie de la chaîne de caractère à chercher dans les infos des contacts
			System.out.println("Veuillez saisir une valeur : ");
			match = Clavier.readString();
			match = match.trim().toLowerCase();
			// afficher les contacts qui matchent avec cette chaîne
			afficherContactsMatch(tabContact, match);
		}
	}
}
