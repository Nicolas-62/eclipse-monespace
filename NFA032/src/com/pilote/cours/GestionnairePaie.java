package com.pilote.cours;
public class GestionnairePaie {
	public void editerAttestationSalaire(Collaborateur collab) {
		long salaire = collab.calculerSalaire();
		String texte = "Montant du salaire : "+salaire;
		System.out.println(texte);
	}
}
