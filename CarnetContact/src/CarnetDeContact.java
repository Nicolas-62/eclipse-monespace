import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;

import fr.perso.mesclasses.Clavier;

public class CarnetDeContact {
	
	public static String[][] lireTableau(String[][] tabContact) {
		
		ObjectInputStream ois;
		File source = new File("carnet.txt");
		if(source.length() !=0) {
			try {
				ois = new ObjectInputStream(new FileInputStream(source));
				tabContact = (String[][]) ois.readObject();
				ois.close();				
			}
			catch(IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}	
		return tabContact;
	}
	public static void ecrireTableau(String[][] tableau) {
		
		ObjectOutputStream oos;
		File source = new File("carnet.txt");
		try {
			oos = new ObjectOutputStream(new FileOutputStream(source));
			oos.writeObject(tableau);
			oos.close();				
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static int saisieChoix() {
		
		boolean saisieChoixValide = false;
		int choix=0;
		while(!saisieChoixValide){
			try {
				System.out.print(" Votre choix : ");
				choix = Clavier.readInt();
				if(choix>=-1 && choix<=5 && choix !=0) {
					saisieChoixValide = true;
				}else {
					System.out.println("Veuillez saisir un chiffre compris dans la liste : ");
				}
			}catch(InputMismatchException i) {
				System.out.println("Erreur de saisie, veuillez saisir un nombre.");
			}
		}
		return choix;
	}
	public static void saisieContact(String[][] tabContact, int indice) {
		String groupe = "";
		String nom="";
		String prenom = "";
		String numTel = "";
		String email = "";
		String contient="aàäbecdeèéfghijklmnopqrstuvwxyz";
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
	public static String saisieGroupe() {
		String[] tabGroupes = {"amis", "famille", "collègues", "clients"};
		boolean saisieValide;
		String choixGroupe = "";
		int groupe=0;
		do {
			System.out.println("Sasie du groupe : ");
			for(int i=0; i<tabGroupes.length; i++) {
				System.out.println(" "+i+". "+tabGroupes[i]);
			}
			System.out.println("Veuillez saisir le n° du groupe dans le carnet de contact :");
			groupe = Clavier.readInt();
			saisieValide=true;
			while(groupe<0 || groupe>3) {
				System.out.println("Veuillez saisir un numéro valide");
				groupe = Clavier.readInt();
			}
		}while(!saisieValide);
		switch(groupe) {
			case 0 : choixGroupe = "amis";break;
			case 1 : choixGroupe = "famille";break;
			case 2 : choixGroupe = "collègues";break;
			case 3 : choixGroupe = "clients";break;
		}	
		return choixGroupe;		
	}
	public static String saisieString(String chaine, String type, int minLength, int maxLength, String contient) {
		boolean saisieValide;
		do{
			saisieValide = true; 
			System.out.println(type+" ?");
			chaine = Clavier.readString();
			chaine = chaine.trim().toLowerCase();
			if(chaine.length()<minLength) {
				System.out.println("Vous devez saisir au moins "+minLength+" caractères");
				saisieValide=false;
				continue;
			}
			if(chaine.length()>maxLength) {
				System.out.println("Votre saisie doit contenir au max "+maxLength+" caractères.");
				saisieValide=false;
				continue;
			}			
			/* La string ne doit pas comporter les caractères présents dans la variable "contient"
			 * on vérifie que chaque caractère de celle ci est bien présent dans "contient"
			 */
			char[] chaineTabChar = chaine.toCharArray();
			for(int i=0; i< chaineTabChar.length; i++) {
				/* la methode contains s'applique sur un objet de type string, 
				 * on lui envoie la représentation en string de notre caractère à analyser.
				 */
				if(!contient.contains(String.valueOf(chaineTabChar[i]))) {
					System.out.println("Votre "+type+" contient des caractères non valides");
					saisieValide=false;
					break;
				}
			}
		}while(!saisieValide);
		return chaine;
	}

	public static String saisieNumero(String chaine) {
		
		boolean saisieValide;
		do {
			System.out.println("Numéro  de téléphone ?");
			chaine = Clavier.readString();
			saisieValide=true;
			if(chaine.charAt(0)!='0') {
				System.out.println("Votre numéro doit commencer par zéro.");
				saisieValide=false;
			}
			if(chaine.length()!=10) {
				System.out.println("Votre numéro doit comporter 10 chiffres.");
				saisieValide=false;
			}
			try {
				Integer.parseInt(chaine);
			}
			catch(NumberFormatException e) {
				System.out.println("Veuillez ne saisir que des chiffres.");
				saisieValide=false;
			}
		}while(!saisieValide);
		return chaine;
	}
	public static String saisieMail(String chaine) {
		boolean saisieValide;
		String saisie1="", saisie2="", saisie3="", email="";
		String contient = "abecdefghijklmnopqrstuvwxyz.-_123456789";
		System.out.println("Format de l'adresse : \"saisie1\"@\"saisie2.\"saisie3\"");
		do {
			saisieValide=true;
			email+=saisieString(saisie1,"Saisie1", 1, 30, contient);
			email+="@";
			email+=saisieString(saisie2,"Saisie2", 2, 30, contient);
			email+=".";
			contient = "abecdefghijklmnopqrstuvwxyz";
			email+=saisieString(saisie3,"Saisie3", 2, 4, contient);			
		}while(!saisieValide);
		return email;
		
	}
	public static void ajouterContact(String[][] tabContact) {
		
		boolean contact=false;
		int indice = 0;
		// Recherche d'un place libre dans le carnet de contact
		for(int i=0; i<tabContact.length; i++) {
			if(tabContact[i][0]==null) {
				contact=true;
				indice = i;
				break;
			}
		}
		if(!contact) {
			System.out.println("Le carnet de contact est plein !!");
		// Saisie des infos du contact
		}else {
			saisieContact(tabContact, indice);
			System.out.println("Contact ajouté !");
		}			
	}
	public static void chercherContact(String[][] tabContact) {	
		
		if(isCarnetVide(tabContact)) {
			System.out.println("Aucun contact dans le carnet");
		}else {	
			String valeur = "";
			boolean contact = false;
			// Saisie de la chaîne de caractère à chercher dans les infos des contacts
			System.out.println("Veuillez saisir une valeur : ");
			valeur = Clavier.readString();
			valeur = valeur.trim().toLowerCase();
			// Recherche de cette chaine dans les infos des contacts
			System.out.println("Contacts trouvés : ");
			for(int i=0; i<tabContact.length; i++) {
				for(int j=0; j<tabContact[i].length; j++) {
					if(tabContact[i][j] != null && tabContact[i][j].contains(valeur)) {
						// affichage des contacts qui possèdent cette chaine dans leurs infos
						afficherContact(tabContact[i]);
						contact = true;
					}
				}
			}
			if(!contact) {
				System.out.println("Aucun");
			}
		}
	}
	public static void afficherContact(String[] tabContact) {
		
		System.out.print("Nom : "+tabContact[0]);
		System.out.print("\tPrenom : "+tabContact[1]);
		System.out.print("\tNumTel : "+tabContact[2]);
		System.out.print("\tEmail : "+tabContact[3]);
		
	}
	public static void modifierContact(String[][] tabContact) {
		
		if(isCarnetVide(tabContact)) {
			System.out.println("Aucun contact dans le carnet");
		}else {		
			afficherCarnet(tabContact);
			int index=0;
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
	public static void supprimerContact(String[][] tabContact) {
		
		if(isCarnetVide(tabContact)) {
			System.out.println("Aucun contact dans le carnet");
		}else {
			int index=0;
			afficherCarnet(tabContact);
			System.out.println("Veuillez saisir l'index du contact à supprimer : ");
			index = Clavier.readInt();
			while (tabContact[index][0] == null) {
				System.out.println("index invalide, veuillez saisir l'index du contact à modifier : ");
				index = Clavier.readInt();
			}
			for(int i=0; i<tabContact[index].length; i++) {
				tabContact[index][i] = null;
			}
			System.out.println("Contact supprimé !");
		}
	}
	public static boolean isCarnetVide(String[][] tabContact) {
		
		boolean contact = true;		
		for(int i=0; i<tabContact.length; i++) {
			if(tabContact[i][0] != null) {
				contact = false;
				break;
			}
		}	
		return contact;
	}
	public static void afficherCarnet(String[][] tabContact) {	
		
		System.out.println("Carnet de contact : ");
		for(int i=0; i<tabContact.length; i++) {
			if(tabContact[i][0]!=null) {
				System.out.print(" "+i+"\t");
				afficherContact(tabContact[i]);
				System.out.println();
			}
		}
	}
	public static void afficherCarnetContacts(String[][] tabContact) {
		
		if(isCarnetVide(tabContact)) {
			System.out.println("Aucun contact dans le carnet");
		}else {
			afficherCarnet(tabContact);
		}
	}
}
