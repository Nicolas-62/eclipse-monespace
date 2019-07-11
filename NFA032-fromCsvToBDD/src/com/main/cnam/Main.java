package com.main.cnam;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import com.bdd.cnam.CnamDb;
import com.bdd.cnam.MaConnexion;
import com.entite.cnam.Utilisateur;
import com.exception.cnam.NbAttributsException;
import com.exception.cnam.UtilisateurException;
import com.exception.cnam.sameMailException;
import com.fichier.cnam.Flux;
import com.traitement.cnam.Traitement;

public class Main {

	public static void main(String[] args) {
		// lecture du fichier récupération de chaque ligne du fichier
		String source = "Utilisateurs.csv";
		List<String> listLignes = Flux.lireFichierUtilisateurs(source);
		// déclaration de variables
		List<String> listLog = new ArrayList<String>();
		Set<String> setMail = new HashSet<String>();
		int nbLignesInsere = 0;
		int nbLignesrejete = 0;
		String mail = "";
		
		// début édition des lignes à insérer dans le rapport de log
		listLog.add("Rapport de log : \n");
		listLog.add("\n");
		listLog.add("Traitement insertion utilisateur \n");
		listLog.add("source : " + source + "\n");
		// récupération de la date courante au format : AAAA mm jj hh:mm:ss
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss");
		String textDate = date.format(formatter);
		listLog.add("Debut du traitement : " + textDate + "\n");
		listLog.add("Ligne 1 ignorée \n");
		
		// ouverture d'une connexion à la bdd
		Connection conn = MaConnexion.getConnection();
		
		// pour chaque ligne du fichier on essai de créer un utilisateur
		for (int i = 1; i < listLignes.size(); i++) {
			// on récupère les 4 attributs séparés par des ";" dans chaque ligne
			StringTokenizer st = new StringTokenizer(listLignes.get(i), ";");
			try {
				if (st.countTokens() != 4) {
					
					throw new UtilisateurException("manque un élément dans la ligne");
				}
				mail = st.nextToken();
				// on vérifie que le mail est unique et n'est pas en  bdd
				setMail = CnamDb.recupererMailUtilisateurs(conn);
				if(setMail.contains(mail)) {
					throw new sameMailException("cause :l'email " + mail + " existe déjà");
				}
				
				// on tente de créer un utilisateur et de renseigner ses attributs
				Utilisateur unUtilisateur = new Utilisateur();
				unUtilisateur.setEmail(mail);
				unUtilisateur.setNom(st.nextToken());
				unUtilisateur.setPrenom(st.nextToken());
				unUtilisateur.setSexe(st.nextToken());
				// si les attributs de l'utilisateur sont bien rensignés on l'insère en bdd
				CnamDb.insererUtilisateur(conn, unUtilisateur);
				listLog.add("Ligne " + (i + 1) + " insérée \n");
				nbLignesInsere++;

			} catch (UtilisateurException e) {
				listLog.add("ligne " + (i + 1) + " : rejetée : " + e.getMessage() + "\n");
				nbLignesrejete++;
			}
		}					
		// fin édition des lignes à insérer dans le rapport de log
		listLog.add("\n");
		listLog.add("Nombre de lignes insérées : " + nbLignesInsere + "\n");
		listLog.add("Nmbre de lignes rejetées : " + nbLignesrejete + "\n");
		listLog.add("total lignes traitées : " + (nbLignesInsere + nbLignesrejete) + "\n\n");
		listLog.add("\n");		
		date = LocalDateTime.now();
		textDate = date.format(formatter);
		listLog.add("Fin traitment " + textDate);
		
		// génération du fichier rapport de log
		Flux.ecrireLog(listLog);
		//affichage des utilisateurs entrés en bdd
		CnamDb.afficherUtilisateurs(conn);
		// fermeture de la connexion à la bdd
		MaConnexion.stop();	

	}

}
