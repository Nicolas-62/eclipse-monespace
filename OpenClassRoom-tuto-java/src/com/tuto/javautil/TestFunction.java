package com.tuto.javautil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
// Test des interfaces fonctionnelles de Java 8
// presentation de quelques interfaces et code source ici :
// https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java/5012411-classes-anonymes-interfaces-fonctionnelles-lambdas-et-references-de-methode#/id/r-5013039
public class TestFunction {
	public static void main(String[] args) {
		
		List<Personne> lPersonne = Arrays.asList(
				new Personne(10, "toto"),
				new Personne(20, "titi"),
				new Personne(30, "tata"),
				new Personne(40, "tutu")
		);
		//java.util.function.Function<T,R>  : sa méthode fonctionnelle a la signature R  apply(T t)  . 
		//Cette interface permet donc de traiter un paramètre T et de renvoyer un type R.	
		// réecriture de la methode de l'interface avec une lambda
		Function<Personne, String> f1 = (Personne p) -> p.getNom();
		Function<Personne, Integer> f2 = (Personne p) -> p.getAge();
		Function<Integer, Integer> f3 = (a) -> a *2;
		
		System.out.println(transformToListString(lPersonne, f1));
		System.out.println(transformToListInt(lPersonne, f2.andThen(f3)));
		//***************************************************************************
		for(Personne p : lPersonne)
			System.out.println("Nom : "+p.getNom()+"\t Age : "+p.getAge());
		
		// Interface qui se contente de consommer un objet, d'y appliquer un traitement.
		Consumer<Personne> c = (Personne p) -> p.setAge(p.getAge() + 20);
		
		for(Personne p : lPersonne) {
			c.accept(p);
			System.out.println("Nom : "+p.getNom()+"\t Age : "+p.getAge());				
		}
		//***************************************************************************
		Predicate<Personne> predicate = (Personne p) -> p.getAge() > 40;
		for(Personne p : lPersonne) {
			if(predicate.test(p))
				System.out.println(p.getNom()+" a l'âge requis !");
		}
		//***************************************************************************
		Supplier<String> s1 = () -> new String("Salut !");
		System.out.println(s1.get());
	}
	
	
	public static List<String> transformToListString(List<Personne> list, Function<Personne, String> func){
		List<String> ls = new ArrayList<>();
		for (Personne p : list) {
			ls.add(func.apply(p));
			//func.apply(p) retournera ici le nom de l'objet Personne
		}
		return ls;		
	}
	public static List<Integer> transformToListInt(List<Personne> list, Function<Personne, Integer> func){
		List<Integer> ls = new ArrayList<>();
		for (Personne p : list) {
			ls.add(func.apply(p));
			//func.apply(p) retournera ici l'âge multiplié par 2 de l'objet Personne
		}
		return ls;		
	}
}
