package com.ecriture.kam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Flux {

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
}
