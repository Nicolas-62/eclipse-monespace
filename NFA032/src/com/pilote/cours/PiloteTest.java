package com.pilote.cours;

public class PiloteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*	
		• Définitions
		• Type réel d'un objet : classe dont le constructeur est appelé pour créer
		l'objet = PiloteInstructeur
		• Type déclaré : classe utilisée pour manipuler l'objet = Pilote
		• Upcasting : type déclaré = superclasse du type réel
		• Utilisation d’une variable du type de la super-classe à la place d’une variable
		du type réel de l'objet
		*/
		
		/* POYLMORPHISME : un objet peut être vu sous plusieurs formes
		*  et plusieurs objets peuvent être vus sous une même forme
		*/
		/* upcasting : un objets->plusieurs formes.
		 * 
		 */
		PiloteInstructeur unPiloteInstructeur = new PiloteInstructeur("lourdel","nicolas");
		Pilote unPilote = unPiloteInstructeur;
		// unPilote.enseignerDecollage(); impossible
		unPilote.getNom();
		/*
		 * Plusieurs objets peuvent être vus sous une même forme
		 */
		GestionnairePaie paie = new GestionnairePaie();
		Hotesse uneHotesse = new Hotesse("flavien", "berger");
		// rappel signature : editerAttestationSalaire(Collaborateur collab)
		paie.editerAttestationSalaire(unPilote);
		paie.editerAttestationSalaire(uneHotesse);
		/*
		 * downcasting
		 */
		Collaborateur unCollabo = new Hotesse("dédé", "champagne");
		unCollabo.prendreConge();//methode finale
		//unCollabo.servirBoissons(); // impossible
		Hotesse uneHotesse2 = (Hotesse) unCollabo;
		uneHotesse2.servirBoissons();
		System.out.println("fin");
		/*
		 * Interfaces ici interface Pilotable() implémentée par Avion
		 * Utilisation de l'interface comme un type
		 * Permet d'appliquer des methodes sans connaître la nature réelle de l'objet
		 */
		Pilotable pilotable = new Avion();		
		unPilote.faireDecoller(pilotable);
		
	}

}
