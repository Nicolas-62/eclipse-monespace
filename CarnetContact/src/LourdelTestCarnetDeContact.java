
public class LourdelTestCarnetDeContact {

	public static void main(String[] args) {
		
		//j'ajoute du texte pour tester git...
		int choix = 0;
		String[][] tabContact = new String[30][5];
//		System.out.println(tabContact[0][0]);
//		System.exit(1);
		tabContact = LourdelCarnetDeContact.lireCarnet(tabContact);
		
		while(true) {
			System.out.println("-------------------------------------------");
			System.out.println("          Menu Carnet de contact :         ");
			System.out.println("-------------------------------------------");
			System.out.println(" ( 1 ) . Ajouter un contact");
			System.out.println(" ( 2 ) . Chercher et afficher un contact");
			System.out.println(" ( 3 ) . Modifier un contact");
			System.out.println(" ( 4 ) . Supprimer un contact");
			System.out.println(" ( 5 ) . Afficher le contenu du carnet");
			
			System.out.println(" (-1 ) . Quitter");
			System.out.println("-------------------------------------------");			
			choix = LourdelCarnetDeContact.saisieChoixMenu();
			
			switch(choix)
			{
			case 1 : LourdelCarnetDeContact.ajouterContact(tabContact); break;
			case 2 : LourdelCarnetDeContact.chercherContact(tabContact); break;
			case 3 : LourdelCarnetDeContact.modifierContact(tabContact); break;
			case 4 : LourdelCarnetDeContact.supprimerContact(tabContact); break;
			case 5 : LourdelCarnetDeContact.afficherCarnetContacts(tabContact); break;
			case -1 : LourdelCarnetDeContact.ecrireCarnet(tabContact); System.exit(1);
			default : LourdelCarnetDeContact.ecrireCarnet(tabContact); System.exit(1);
			}
		}
	}

}
