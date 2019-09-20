package cnam.exo.adel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TestNoteFichierZip {
	// fonction qui zippe des fichier dans un fichier "monFichier.zip" comprenant
	// pour chaque fichier un répertoire du même nom avec ce fichier dedans
	public static void testZip(String[] fichiers) {
		File fichierZip = new File("fichierZip.zip");
		FileInputStream in = null;
		ZipOutputStream sortie =null;
		try {
			sortie = new ZipOutputStream(new FileOutputStream(fichierZip));
			// création d'un répertoire
			ZipEntry entry = new ZipEntry("vide/");
			sortie.putNextEntry(entry);
			
			 // création d'un autre répertoire 
			entry =  new ZipEntry("notes/") ;
			sortie.putNextEntry(entry) ;
			// création d'un repertoire pour chaque fichier
			for(int i=0; i<fichiers.length; i++) {
				// ouverture d'un flux de lecture sur le fichier
				in = new FileInputStream("mesFichiers/"+fichiers[i]);
				entry = new ZipEntry("notes/"+fichiers[i]);
				sortie.putNextEntry(entry);
				byte[] buffer = new byte[1024];
				int len;
				
				while ((len = in.read(buffer)) > 0) {
					sortie.write(buffer, 0, len);
				}		
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("erreur : "+e.getMessage());
			e.printStackTrace();				
		}finally {
			try {
				if(in != null) {
					in.close();
				}
			}catch(IOException e) {
				e.getMessage();
				e.printStackTrace();
			}
			try {
				if(sortie != null) {
					sortie.close();
				}
			}catch(IOException e) {
				e.getMessage();
				e.printStackTrace();
			}
		}
		
	}

}
