package com.tp.garage;

import com.tp.vehicule.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Garage implements Serializable{
	
	private static final long serialVersionUID = 6278661694887344369L;
	public static int nbInstances;
	public List<Vehicule> voitures = new ArrayList<Vehicule>();
	// récupération des voitures enregistrées à chaque instanciation.
	Garage(){
		nbInstances++;
		// On verifie que le fichier n'est pas vide
		File file = new File("garage.txt");
		//Si il n'est pas vide c'est qu'il y  a un objet garage avec des voitures
		if(file.length() != 0) {
			ObjectInputStream ois = null;	
			try {
			  FileInputStream fichier = new FileInputStream("garage.txt");
			  ois = new ObjectInputStream(fichier);
			  Garage garage = (Garage)ois.readObject();
			  // On ajoute les voitures du garage sauvegardé au garage instancié
			  this.voitures = garage.voitures;
			} catch (IOException e) {
			  e.printStackTrace();
			} catch (ClassNotFoundException e) {
			  e.printStackTrace();
			} finally {
			  try {
			    if (ois != null) {
			      ois.close();
			    }
			  } catch (IOException ex) {
			    ex.printStackTrace();
			  }
			}	
		}
	}	
	// Affichage des voitures du garage si il en possède
	public String toString() {
		String str = "";
		if(voitures.isEmpty())
			str = "Garage vide !";
		else {
    		str +="*************************\n";
    		str +="*     Garage de Nico    *\n";
    		str +="*************************\n";			
			int i = 1;
			for(Vehicule v : voitures) {
				str += i+" "+v.toString()+"\n";
				i++;
			}
		}
		return str;
	}
	// ajout d'une voiture à la liste des voitures du garage et sauvegarde du garage
	public void add(Vehicule v) {
		this.voitures.add(v);
		// on sauvegarde le garage à chaque ajout de voiture
		this.saveGarage();
		
	}
	//Sauvegarde du garage instancié dans le fichier "garage.txt"
	public void saveGarage() {
	    ObjectOutputStream oos = null;
	    try {
	      final FileOutputStream fichier = new FileOutputStream("garage.txt");
	      oos = new ObjectOutputStream(fichier);
	      oos.writeObject(this);
	      oos.flush();
	    } catch (final IOException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        if (oos != null) {
	          oos.flush();
	          oos.close();
	        }
	      } catch (final IOException ex) {
	        ex.printStackTrace();
	      }
	    }		
	}
}
