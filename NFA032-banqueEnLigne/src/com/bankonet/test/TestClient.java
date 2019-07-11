package com.bankonet.test;

import com.bankonet.*;

public class TestClient {

	public static void main(String[] args) {
		// Création des clients
		Client unClient1 = new Client("244", "lourdel", "nicolas");
		unClient1.setCompteCourant(new CompteCourant("217600", "PEL", 1235.7, 500));
		unClient1.setCompteEpargne(new CompteEpargne("234888", "maison", 33900, 0.05));
		Client unClient2 = new Client("245", "dupont", "roger");
		unClient2.setCompteCourant(new CompteCourant("334567", "PP", 3459, 500));
		unClient2.setCompteEpargne(new CompteEpargne("457266", "appart", 330, 0.05));
		Client unClient3 = new Client("244", "dujardin", "celine");
		unClient3.setCompteCourant(new CompteCourant("447832", "PEL", 3000.7, 500));
		// Ajout des clients dans un tableau
		Client[] clientTab = new Client[3];
		clientTab[0] = unClient1;
		clientTab[1] = unClient2;
		clientTab[2] = unClient3;
		// Affichage des clients
		for (int i = 0; i < clientTab.length; i++) {
			System.out.println(clientTab[i]);
			System.out.println("............................");
		}
		System.out.println("###################################");
		// Tests mouvements de fonds sur client1
		try {
			unClient1.getCompteEpargne().debiter(200000);
		} catch (DebitException e) {
			System.out.println("debit compte epargne impossible");
		}
		try {
			unClient1.getCompteCourant().debiter(2000);
		} catch (DebitException e) {
			System.out.println("debit compte courant impossible");
		}
		System.out.println("###################################");
		System.out.println("Affichage du compte du client1");
		System.out.println(unClient1.getCompteCourant());
		// downcasting
		Compte unCompte = unClient1.getCompteCourant();
		System.out.println("Affichage après downcasting..");
		// utilise méthode de compte courant, montant découvert affiché qd même.
		System.out.println(unCompte);
		System.out.println("______________________________");
		try {
			unClient1.getCompteCourant().effectuerVirement(unClient1.getCompteEpargne(), 2000);
		} catch (CompteException e) {
			System.out.println("Virement impossible");
		}
	}

}
