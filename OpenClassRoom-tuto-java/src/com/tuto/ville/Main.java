package com.tuto.ville;

import fr.perso.mesclasses.Out;

public class Main {

	public static void polymorphisme() {
		try {
			Ville[] tabVilles = new Ville[6];
			
			String[] nomVilles = {"Achicourt", "Beaurain", "Bapeaume", "Paris", "Londres", "New-york"};
			int[] nbHabitants = {1000, 500, 3000, 10_000_000, 5_000_000, 15_000_000};
			String[] monuments = {"La Concorde", "Big Ben", "La statue de la liberté"};
			
			for(int i=0; i<nomVilles.length; i++) {			
				if(i<3) {			
					tabVilles[i] = new Ville(nomVilles[i], "France", nbHabitants[i]);
				}else {
					tabVilles[i] = new Capitale(nomVilles[i], "Inconnu", nbHabitants[i], monuments[i-3]);
				}
			}
			// Covariance V représente des Villes et des Capitales (qui sont des villes)
			for(Object obj : tabVilles) {
	//			System.out.println(obj.toString());		
			}
			for(Ville v : tabVilles) {
	//			System.out.println(v.decrisToi());
				// ici on fait appel implicitement à la methode toString();
				System.out.println(v);
				System.out.println(v.hashCode());
			}
		}catch (NomVilleException | NbHabitantException a) {
			Out.p(a.getMessage());
		}
	}
	public static void main(String[] args) {
//		System.out.println("Nb instances : "+Ville.NbInstances);
//		Ville arras = new Ville("Arras", "France", 1000);
//		System.out.println("Nb instances : "+Ville.NbInstances);
//		Ville feuchy = new Ville("Feuchy", "France", 10000);
//		System.out.println("Nb instances : "+Ville.NbInstances);
//		System.out.println("Ville : " + feuchy.getNomVille());
//		System.out.println("Nombre d'habitants : " + feuchy.getNbHabitants());
//		feuchy.setNbHabitants(10);
//		System.out.println("Ville : " + feuchy.getNomVille());
//		System.out.println("Nombre d'habitants : " + feuchy.getNbHabitants());
//		System.out.println(feuchy.decrisToi());
//		System.out.println(feuchy.comparer(arras));
//		System.out.println("Nb instances : "+Ville.NbInstances);
//		System.out.println("Nb instancesBis : "+Ville.getNbInstancesBis());
//		Capitale paris = new Capitale();
//		System.out.println(paris.decrisToi());
		polymorphisme();
		// Exceptions : 
		// On créer l'objet ville avant sinon il n'existera que dans le bloc try
//		Ville v = new Ville();
//		try {
//			v = new Ville("Acc", "France", -12000);
//		}catch (NomVilleException | NbHabitantException a) {
////			Out.p(a.getMessage());
//		}
//		finally{
//			if(v == null) {
//				v = new Ville();
//			}
//		}
//		
//		Out.p(v.toString());
	}

}
