package com.tuto.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.perso.mesclasses.Out;

public class TestStream {
	public static void main(String[] args) {
		// utilisation de la classe ArrayList qui implémente l'interface List
		List<Personne> listP = new ArrayList<Personne>();
		// convertion d'un tableau en ArrayList grâce à la methode asList de la classe Arrays
		listP = Arrays.asList(
				new Personne(1.80, 70, "A", "Nicolas", Couleur.BLEU),
				new Personne(1.56, 50, "B", "Nicole", Couleur.VERRON),
				new Personne(1.75, 65, "C", "Germain", Couleur.VERT)
		);	
		// impossible d'ajouter un élément à la liste car elle est liée au tableau
		// !!! listP.add( new Personne(1.11, 45, "A", "gege", Couleur.BLEU));
		// essai pour ajout d'une personne à la liste
		List<Personne> listP2 = new ArrayList<Personne>();
		Personne[] tabP = {
				new Personne(1.68, 50, "D", "Michel", Couleur.ROUGE),
				new Personne(1.96, 65, "E", "Cyrille", Couleur.BLEU),
				new Personne(2.10, 120, "F", "Denis", Couleur.ROUGE),
				new Personne(1.90, 90, "G", "Olivier", Couleur.VERRON)		
		};

		Collections.addAll(listP2, tabP);
		listP2.add(new Personne(1.75, 65, "C", "Germain", Couleur.VERT));
		Out.p("liste P2 : ");
		for(Personne p : listP2)
			System.out.println(p);		
		Out.etoiles();
		System.out.println("tableau tabP :");
		for(Personne p : tabP) {
			System.out.println(p);
		}
		Out.etoiles();
		for(Personne p : listP)
			System.out.println(p);
		Out.etoiles();
		// utilisation des streams
		// parcours..
		// La methode forEach est une méthode terminale elle consomme le stream on ne peut plus 
		// invoquer de
		// méthode après celle ci.
		Stream<Personne> sp = listP.stream();
		sp.forEach(System.out::println);
		// Utilisation de la methode iterate, methode statique de l'interface Stream
		// 1d est le point de départ et la lambda correspond à l'opération faite sur le premier élément
		Stream.iterate(1d, (x) -> x + 1).limit(5).forEach(System.out::println);
		
		// Filtrage
		sp = listP.stream();
		sp.filter(x -> x.getPoids() > 50).forEach(System.out::println);
		
		// opération map
		sp = listP.stream();
		sp.filter(x -> x.getPoids() > 50).map(x -> x.getPoids()).forEach(System.out::println);
		
		//operation reduce
		sp = listP.stream();
		Double sum = sp.filter(x -> x.getPoids() > 50)
						.map(x -> x.getPoids())
						.reduce(0.0d, (x,y) -> x+y);
		System.out.println("resultat addition : "+sum);
		// gesttion des erreurs
		sp = listP.stream();
		// utilisation de l'objet Optional ; conteneur pour une valeur pouvant être nulle
		Optional<Double> sum2 = sp	.filter(x -> x.getPoids() > 250)
									.map(x -> x.getPoids())
									.reduce((x,y) -> x+y);
		if(sum2.isPresent())
			System.out.println(sum2.get());
		else
			System.out.println("Aucun aggrégat de poids...");
		//Permet de gérer le cas d'erreur en renvoyant 0.0 si isPresent() == false
		System.out.println(sum2.orElse(0.0));
		// count
		sp = listP.stream();

		long count = sp	.filter(x -> x.getPoids() > 50)
						.map(x -> x.getPoids())
						.count();

		System.out.println("Nombre d'éléments : " + count);
		// collect
		//Permet de récupérer le résultat des opérations successives sous une certaines forme. 
		// Cette forme est définie par un objet  Collectors  (implémentant l'interface  Collector  ). 
		//C'est avec cet objet que nous pourrons dire que nous souhaitons avoir notre résultat sous forme 
		// de  Set  , de  Map  , de  List  et plus encore.
		sp = listP.stream();

		List<Double> ld = sp.filter(x -> x.getPoids() > 50)
							.map(x -> x.getPoids())
							.collect(Collectors.toList());
		System.out.println(ld);
		// dans un fichier..
//		String fileName = "D://Documents/IPTABLES.sh";
//		try(Stream<String> sf = Files.lines(Paths.get(fileName))){
//			sf.forEach(System.out::println);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
	}
}
