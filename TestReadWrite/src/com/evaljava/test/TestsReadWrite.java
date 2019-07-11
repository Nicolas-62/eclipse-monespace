package com.evaljava.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestsReadWrite {

	public static void lireFichier(String source) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(source));
			String ligne = null;
			while ((ligne = reader.readLine()) != null) {
				System.out.println(ligne);
			}
		} catch (IOException e) {
			System.err.println("erreur de lecture: " + e.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	public static List<String> lireFichierBis(String chemin){	
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
	public static void ecrireFichier() {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("fichier.txt"));
			writer.write("Nous sommes le "+ new Date());
			writer.newLine();
			writer.write("Bonjour tout le monde !!");
			
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
	public static void ecrireLog(List<String> listLog) {
		BufferedWriter writer = null;
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_kk_mm_ss");
		String textDate = date.format(formatter);		
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
