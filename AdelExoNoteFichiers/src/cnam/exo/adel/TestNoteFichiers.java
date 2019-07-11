package cnam.exo.adel;

import java.io.BufferedReader;
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

		File fichierEntree = new File(monDossier, "notes.txt");
		File fichierSortie = new File(monDossier, "totalDesNotes.txt");

		BufferedReader entree;
		PrintWriter sortie;

		String chaine;
		
		try {
			entree = new BufferedReader(
						new InputStreamReader(
							new FileInputStream(fichierEntree), "Cp1252"));
			//lecture première ligne
			chaine = entree.readLine();
			try {
				sortie = new PrintWriter(
							new OutputStreamWriter(
								new FileOutputStream(fichierSortie), "UTF-8"));
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
					sortie.println("Le total des " + totalNote + " notes de " + name + " est de : " + somme);
					// lecture ligne suivante
					chaine = entree.readLine();
				}
				entree.close();
				sortie.close();

			} catch (FileNotFoundException e) {

			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
