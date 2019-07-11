package com.tuto.collections;

import java.util.List;

import java.util.ListIterator;

import fr.perso.mesclasses.Out;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashSet;

public class ListObjets {

	public static void main(String[] args) {		
//		objetLinkedList();
//		objetArrayList();
//		objetHashTableMap();
		// Un Set est une collection qui n'accepte pas les doublons.
		objetSet();
		
	}
	public static void objetLinkedList() {
		// Création d'un objet Linkedlist qui contient une liste d'objets.
		List l = new LinkedList();
		l.add("toto");
		l.add("titi");
		l.add(12);
		l.add(12.04);
		l.add("C");
		// Parcour de la liste
		for(int i=0; i<l.size(); i++) {
			Out.p("Objet de l'index "+i+" = "+l.get(i));			
		}
		Out.p();
		Out.p("Parcours de la liste avec un itérateur");
		Out.etoiles();
		Out.p();
		ListIterator li = l.listIterator();
		
		while(li.hasNext())
			Out.p(li.next());
	}
	
	public static void objetArrayList() {
		ArrayList al = new ArrayList();
		al.add("Une arraylist !!!");
		al.add(false);
		al.add(12);
		al.add(12/3);
		al.add('C');
		al.add("FIN !");
		
		for(int i =0; i < al.size(); i++) {
			Out.p("Objet d'indice "+i+" : "+al.get(i));
		}
		Out.p(al.contains('C'));
		al.remove(4);
		for(int i =0; i < al.size(); i++) {
			Out.p("Objet d'indice "+i+" : "+al.get(i));
		}
		Out.p(al.isEmpty());
		Out.p(al.contains('C'));
	}
	
	public static void objetHashTableMap() {
		
		Hashtable ht = new Hashtable();
		ht.put(45, "Patrick");
		ht.put(50, "Lisa");
		ht.put(72, "Bob");
		ht.put("douze", "Nico");
		ht.put(0, "Albert");
		
		// On parcours cet objet grâce aux clés qu'il contient 
		// en recourant à la classe Enumeration
		Enumeration e = ht.elements();		
		while(e.hasMoreElements())
			Out.p(e.nextElement());

		Enumeration e2 = ht.keys();
		while(e2.hasMoreElements())
			Out.p(e2.nextElement());
	}
	
	public static void objetSet() {
		HashSet hs = new HashSet();
		hs.add("toto");
		hs.add("titi");
		hs.add(12);
		hs.add("bob");
		hs.add("Nico");
		
		Out.p("Parcours avec un iterateur");
		Out.etoiles();
		Iterator it = hs.iterator();
		while(it.hasNext())
			Out.p(it.next());
		Out.p();
		Out.p("Parcours avec un tableau d'objet");
		Out.etoiles();
		
		Object[] obj = hs.toArray();
		
		for(Object o : obj)
			Out.p(o);
	}
}
