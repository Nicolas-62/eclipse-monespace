package com.traitement.cnam;

import java.util.Iterator;
import java.util.List;

import com.entite.cnam.Utilisateur;
import com.exception.cnam.sameMailException;

public class Traitement {
	public static void verifMailUnique(List<Utilisateur> listUtilisateurs, String mail) throws sameMailException {
		for (Iterator<Utilisateur> it = listUtilisateurs.iterator(); it.hasNext();) {
			if (it.next().getEmail().equals(mail)) {
				throw new sameMailException("cause :l'email " + mail + " existe déjà");
			}
		}
	}
}