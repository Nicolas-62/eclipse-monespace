package com.fichier.cnam;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Flux {
	// fonction qui récupère et renvoie toute les lignes du fichier dans une liste
	public static List<String> lireFichierUtilisateurs(String chemin){	
		List<String> listUtilisateurs = new ArrayList<String>();
		Path source = Paths.get(chemin);
		try {
			listUtilisateurs = Files.readAllLines(source, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUtilisateurs;
	}
	// fontion qui génère un fichier de rapport de log et y écrit la liste de lignes à écrire passée en paramètre
	public static void ecrireLog(List<String> listLog) {
	    // la définition du writer doit se faire ici
	    // pour des raisons de visibilité
		BufferedWriter writer = null;
		// récupération de la date actuelle
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_kk_mm_ss");
		String textDate = date.format(formatter);	
		// ecriture du fichier
		try {
			// ouverture du flux de sortie
			/* Notons que pour l'écriture dans des fichiers, la classe PrintWriter 
			 * expose également un constructeur qui prend une instance de File. 
			 * En l'utilisant on n'a donc pas besoin de construire soi-même l'instance de Writer.
			 */
			writer = new BufferedWriter(new FileWriter("traitement-"+textDate+".log"));
			for(String ligne : listLog) {
				writer.write(ligne);
				writer.newLine();
				// permet de vider le buffer
				// ici nécessaire !!
				// pas nécessaire si pas de buffer, la méthode close de FileWriter appelle elle-même flush()
				writer.flush();
			}			
		}catch(IOException e) {
			// affichage du message d'erreur et de la pile d'appel
			System.out.println("erreur d'ecriture : "+e.getMessage());
			e.printStackTrace();
		}finally {
			// il faut fermer le flux quoi qu'il arrive (erreur ou pas)
			if(writer != null) {
				try{
					writer.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
}
