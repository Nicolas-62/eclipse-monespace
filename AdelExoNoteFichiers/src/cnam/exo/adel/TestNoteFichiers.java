package cnam.exo.adel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

public class TestNoteFichiers {

	public static void main(String[] args) throws IOException {

		File monDossier = new File("mesFichiers/");
		String[] fichiers = {"totalDesNotes.txt", "totalDesNotesBuffered.txt"};
		File fichierEntree = new File(monDossier, "notes.txt");
		File fichierSortie1 = new File(monDossier, fichiers[0]);
		File fichierSortie2 = new File(monDossier, fichiers[1]);

		BufferedReader entree = null;;
		PrintWriter sortie1 = null;
		BufferedWriter sortie2 = null;
		String chaine = null;
		
		try {
			entree = new BufferedReader(
						new InputStreamReader(
							new FileInputStream(fichierEntree), "Cp1252"));
			// !! PrintWriter without automatic flushing
			// Printwriter ne jette pas d'exception c'est pourri
			sortie1 = new PrintWriter(
						new OutputStreamWriter(
							new FileOutputStream(fichierSortie1), "UTF-8"));
			
			sortie2 = new BufferedWriter(
						new OutputStreamWriter(
							new FileOutputStream(fichierSortie2), "UTF-8"));

			// si spécification encodage pas nécessaire : 
//			BufferedWriter br = new BufferedWriter(
//									new FileWriter(fichierSortie));
			

			entree.mark(10000);
/**************** sortie1 ***********************************************************/	
			Long time = System.currentTimeMillis();
			//lecture première ligne
			chaine = entree.readLine();
			// lecture éléments de la ligne
			while (chaine != null) {
				StringTokenizer st = new StringTokenizer(chaine, ";");

				String name = st.nextToken();
				int totalNote = 0;
				int somme = 0;
				while (st.hasMoreTokens()) {
					somme += Integer.parseInt(st.nextToken());
					totalNote++;
				}
				sortie1.println("Le total des " + totalNote + " notes de " + name + " est de : " + somme);
				sortie1.flush();
				// lecture ligne suivante
				chaine = entree.readLine();
			}
			System.out.println("tps lecture 1 : " + (System.currentTimeMillis() - time));
			entree.reset();
/**************** sortie2 ***********************************************************/
			time = System.currentTimeMillis();
			//lecture première ligne
			chaine = entree.readLine();
			while (chaine != null) {
				StringTokenizer st = new StringTokenizer(chaine, ";");

				String name = st.nextToken();
				int totalNote = 0;
				int somme = 0;
				while (st.hasMoreTokens()) {
					somme += Integer.parseInt(st.nextToken());
					totalNote++;
				}				
				sortie2.write("Le total des " + totalNote + " notes de " + name + " est de : " + somme);
				sortie2.newLine();
				// lecture ligne suivante
				chaine = entree.readLine();
			}
			System.out.println("tps lecture 2 : " + (System.currentTimeMillis() - time));
			
			System.out.println("compression des fichiers...");
			TestNoteFichierZip.testZip(fichiers);
			System.out.println("compression réussi !");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("erreur création fichier : "+e.getMessage());
			e.printStackTrace();

		} catch(IOException e) {
			System.out.println("erreur : "+e.getMessage());
			e.printStackTrace();				
		}finally {
			try {
				if(entree != null) {
					entree.close();
				}
			}catch(IOException e) {
				e.getMessage();
				e.printStackTrace();
			}
			try {
				if(sortie2 != null) {
					sortie2.close();
				}
			}catch(IOException e) {
				e.getMessage();
				e.printStackTrace();
			}
		}

	}

}
