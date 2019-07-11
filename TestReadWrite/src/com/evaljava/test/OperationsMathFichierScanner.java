package com.evaljava.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class EvaluationScanner {
	public static void main(String[] args) {
		List<String> lignes = new ArrayList<>();
		List<Double> resultats = new ArrayList<>();
		List<String> lignesLues = new ArrayList<>();
		double resultat = 0;
		Scanner lecteur = null;
		double nb1 = 0, nb2 = 0;
		String ope = "";
		Pattern pattern = Pattern.compile("(\\d+(\\.\\d+)?)\\s?(\\S)\\s?(\\d+(\\.\\d+)?)\\s?");
		int ligne=0;
		try {
			ligne++;
			lecteur = new Scanner(new File("Entree.txt"));
			System.out.println("lecteur : "+lecteur.next());
			System.exit(1);
			while (lecteur.findInLine(pattern) != null) {
				MatchResult match = lecteur.match();
				nb1 = Double.parseDouble(match.group(1));
				ope = match.group(3);
				nb2 = Double.parseDouble(match.group(4));

				switch (ope) {
				case "+": resultat = nb1 + nb2;break;
				case "-": resultat = nb1 - nb2;break;
				case "x": resultat = nb1 * nb2;break;
				case "/": resultat = nb1 / nb2;break;
				default : System.out.println("Erreur à la ligne : "+ligne);
				}
				lignes.add(+ nb1 + " " + ope + " " + nb2 + " = " + resultat);
				resultats.add(resultat);
				if (lecteur.hasNextLine())
					lecteur.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (lecteur != null)
				lecteur.close();
		}
//		System.exit(1);
		// Ecriture
		// Création du répertoire si il n'existe pas
		try {
			Path monRepertoire = Paths.get("sorties");
			Files.createDirectory(monRepertoire);
		} catch (FileAlreadyExistsException e) {
			System.out.println("Le dossier existe déjà");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPathException e) {
			e.printStackTrace();
		}
		/*
		 * On crée un fichier avec l'opération présente dans la liste et on regroupe
		 * dans le même fichier les opérations ayant le même résultat
		 */
		
		for (int k = 0; k < resultats.size(); k++) {
			Path fichier = Paths.get("sorties/resultats(" + resultats.get(k) + ").txt");
			if (Files.exists(fichier)) {
				try {
					lignesLues = Files.readAllLines(fichier, StandardCharsets.UTF_8);
				} catch (IOException e) {
					e.printStackTrace();
				}
				try (BufferedWriter writer = Files.newBufferedWriter(fichier, StandardCharsets.UTF_8)) {
					lignesLues.add(lignes.get(k));
					for(int j=0; j<lignesLues.size(); j++) {
						writer.write(lignesLues.get(j));
						writer.newLine();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					// Création du fichier
					Path newFichier = Paths.get("sorties/resultats(" + resultats.get(k) + ").txt");
					Files.createFile(newFichier);
					// Ecriture dans le fichier
					try (BufferedWriter writer = Files.newBufferedWriter(newFichier, StandardCharsets.UTF_8)) {
						String ligneAecrire = lignes.get(k);
						writer.write(ligneAecrire, 0, ligneAecrire.length());
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InvalidPathException e) {
					e.printStackTrace();
				}
			}
		} // endfor ecriture
		System.out.println("fini !");
	}

}
