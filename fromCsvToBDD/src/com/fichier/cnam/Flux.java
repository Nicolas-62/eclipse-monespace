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
		BufferedWriter writer = null;
		// récupération de la date actuelle
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_kk_mm_ss");
		String textDate = date.format(formatter);	
		// ecriture du fichier
		try {
			writer = new BufferedWriter(new FileWriter("traitement-"+textDate+".log"));
			for(String ligne : listLog) {
				writer.write(ligne);
				writer.newLine();
			}			
		}catch(IOException e) {
			System.out.println("erreur d'ecriture : "+e.getMessage());
		}finally {
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
