package com.tuto.inout;

import java.io.File;

import fr.perso.mesclasses.Out;

public class Main {
	
	public static void fileInfo() {
		// Utilisation de la classe File, petit tour de ces methodes.
		File f = new File("tuto.txt");
		Out.p("Chemin absolu du fichier : "+ f.getAbsolutePath());
		Out.p("Nom du fichier : "+ f.getName());
		Out.p("Est-ce qu'il existe ? "+f.exists());
		Out.p("Est-ce un répertoire ?"+f.isDirectory());
		Out.p("Est-ce un fichier ?"+ f.isFile());

		Out.p("Affichage des lecteurs à la racine du PC : ");
		for(File file : f.listRoots())
		{
			Out.p(file.getAbsolutePath());
			try {
				int i =1;
				// Parcours de la liste des fichiers et répertoires
				for(File nom : file.listFiles()) 
				{
					// S'il s'agit d'un dossier on ajoute "/"
					Out.p("\t\t"+ ((nom.isDirectory()) ? nom.getName()+"/" : nom.getName()));
					
					if((i%4) == 0) 
					{
						Out.p("\n");
					}
					i++;
				}
				Out.p("\n");
			} 
			catch (NullPointerException e) {}
	        //L'instruction peut générer une NullPointerException
	        //s'il n'y a pas de sous-fichier !
		}
	}
	public static void main(String[] args) {
//		fileInfo();
//		Copie.copie();
//		TempsCopie.tempsCopie();
//		Ecriture.ecriture();
		SauvegardeClasse.save();
	}
}
