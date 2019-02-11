package com.tuto.genericite;

import java.util.ArrayList;
import java.util.List;

import fr.perso.mesclasses.Out;

public class Test {

	public static void main(String[] args) {
		Solo obj = new Solo(12);
		Out.p(obj.getValeur());
//		int nbre = obj.getValeur(); // impossible il faut caster l'objet pour avoir un nombre en retour
		int nbre = (Integer)obj.getValeur();
		Solo2<Integer>obj2 = new Solo2<Integer>(12);
		int nbre2 = obj2.getValeur();

		  System.out.println("Liste de String");
		  System.out.println("------------------------------");
		  List<String> listeString= new ArrayList<String>();
		  listeString.add("Une chaîne");
		  listeString.add("Une autre");
		  listeString.add("Encore une autre");
		  listeString.add("Allez, une dernière");

		  for(String str : listeString)
		    System.out.println(str);

		  System.out.println("\nListe de float");
		  System.out.println("------------------------------");
		                
		  List<Float> listeFloat = new ArrayList<Float>();
		  listeFloat.add(12.25f);
		  listeFloat.add(15.25f);
		  listeFloat.add(2.25f);
		  listeFloat.add(128764.25f);
		                
		  for(float f : listeFloat)
		    System.out.println(f);
		  // Créer une liste qui accepte n'importe quel type :
		  ArrayList<?> list;
		  //List n'acceptant que des instances de Voiture ou de ses sous-classes
		  List<? extends Voiture> listVoitureSP = new ArrayList<VoitureSansPermis>();
	}

}
