
public class TestCarnetDeContact {

	public static void main(String[] args) {
		
		//j'ajoute du texte pour tester git...
		int choix = 0;
		String[][] tabContact = new String[30][5];
//		System.out.println(tabContact[0][0]);
//		System.exit(1);
		tabContact = CarnetDeContact.lireCarnet(tabContact);
		
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
			choix = CarnetDeContact.saisieChoixMenu();
			
			switch(choix)
			{
			case 1 : CarnetDeContact.ajouterContact(tabContact); break;
			case 2 : CarnetDeContact.chercherContact(tabContact); break;
			case 3 : CarnetDeContact.modifierContact(tabContact); break;
			case 4 : CarnetDeContact.supprimerContact(tabContact); break;
			case 5 : CarnetDeContact.afficherCarnetContacts(tabContact); break;
			case -1 : CarnetDeContact.ecrireCarnet(tabContact); System.exit(1);
			default : CarnetDeContact.ecrireCarnet(tabContact); System.exit(1);
			}
		}
	}

}
