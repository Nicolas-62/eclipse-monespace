package com.evaljava.test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Evaluation {

	public static void main(String[] args) {
		List<String>lignes = new ArrayList<>();
		List<Double>resultats = new ArrayList<>();
		// Lecture
		try {
			// Ouverture du fichier, création d'une liste de string avec le contenu de chaque ligne.
			Path source1 = Paths.get("/home/lourdel/eclipse-workspace/Entree.txt");
			lignes = Files.readAllLines(source1, StandardCharsets.UTF_8);	
			// Pour chaque chaine de la liste (qui représente une ligne donc une opération mathématique) :
			for(int h=0; h< lignes.size(); h++) {
				// Variables
				// Transformation de la chaîne en tableau de caractères
				char[] tabChar = lignes.get(h).trim().toCharArray();
				// chaines représentant les nombres trouvés dans chaque ligne
				String strNombre1="", strNombre2="";
				// Nombres trouvés convertis en double
				double nombre1=0, nombre2=0;
				// Capteur lancement lecture nombre2
				boolean saveNb2 = false;
				// Operateur arithmétique trouvé sur la ligne
				char operateur=' ';
				double resultat=0;
				// Identification des nombres et de l'operateur arithmétique présent sur la ligne
				for(int i=0; i < tabChar.length; i++) {
					if(operateur !=' ') {
						saveNb2 = true;
					}
					if(tabChar[i]=='+' || tabChar[i]=='-' || tabChar[i]=='/' || tabChar[i]=='x') {
						nombre1 = Double.parseDouble(strNombre1.trim());
						operateur = tabChar[i];
					}
					if(saveNb2) {
						strNombre2 = strNombre2+tabChar[i];
					}else if (operateur == ' '){
						strNombre1 = strNombre1+tabChar[i];
					}
					if(i == tabChar.length-1) {
						nombre2 = Double.parseDouble(strNombre2.trim());
					}					
				}
				// Calcul de l'operation methematique
				switch (operateur) {
					case'+' : resultat = nombre1+nombre2; break;
					case'-' : resultat = nombre1-nombre2; break;
					case'x' : resultat = nombre1*nombre2; break;
					case'/' : resultat = nombre1/nombre2; break;								
				}
				System.out.println("operation : "+lignes.get(h)+" = "+resultat);
				resultats.add(resultat);
			}
			for(int j=0; j<resultats.size(); j++) {
				System.out.println("tab["+j+"] = "+resultats.get(j));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(InvalidPathException e) {
			e.printStackTrace();
		}
		//Ecriture
		// Création du répertoire si il n'existe pas
		try {
			Path monRepertoire = Paths.get("/home/lourdel/eclipse-workspace/sorties");
			Files.createDirectory(monRepertoire);
		} catch(FileAlreadyExistsException e) {
			System.out.print("Le dossier existe déjà");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(InvalidPathException e) {
			e.printStackTrace();
		}
		/* On crée un fichier avec l'opération présente dans la liste et on regroupe dans le même fichier
		 * les opérations ayant le même résultat 
		 */ 
		for (int k=0; k<resultats.size(); k++) {
			Path fichier = Paths.get("/home/lourdel/eclipse-workspace/sorties/resultats("+resultats.get(k)+").txt");
			if(Files.exists(fichier)) {	
				List<String>lignesLues = new ArrayList<>();
				try {
					lignesLues = Files.readAllLines(fichier, StandardCharsets.UTF_8);
				} catch (IOException e) {
					e.printStackTrace();
				}
				try(BufferedWriter writer = Files.newBufferedWriter(fichier, StandardCharsets.UTF_8)){				
					lignesLues.add("\n"+lignes.get(k)+" = "+resultats.get(k));
					String lignesAecrire = lignesLues.toString().replaceAll("\\[|\\]|," , "");
					writer.write(lignesAecrire, 0, lignesAecrire.length());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				try {
					// Création du fichier
					Path newFichier = Paths.get("/home/lourdel/eclipse-workspace/sorties/resultats("+resultats.get(k)+").txt");
					Set<PosixFilePermission> perms=PosixFilePermissions.fromString("rw-rw-rw-");
					FileAttribute<Set<PosixFilePermission>>attr=PosixFilePermissions.asFileAttribute(perms);
					Files.createFile(newFichier,attr);
					// Ecriture dans le fichier
					try (BufferedWriter writer = Files.newBufferedWriter(newFichier, StandardCharsets.UTF_8)) {
						String ligneAecrire = lignes.get(k)+" = "+resultats.get(k);				
						writer.write(ligneAecrire, 0, ligneAecrire.length());
					} catch (IOException e) {
						e.printStackTrace();
					}			
				} catch (IOException e) {
					e.printStackTrace();
				} catch(InvalidPathException e) {
					e.printStackTrace();
				}					
			}
		}//endfor ecriture
		System.out.println("fini !");
		
	}
}
