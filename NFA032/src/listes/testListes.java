package listes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import fr.perso.mesclasses.Out;

public class testListes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// creer une nouvelle liste et ajouter trois users :
		// utilisation de l'interface List, la classe ArrayList implémente l'interface List
	    // ArrayList : tout type d'objet, doublons possibles
	    List<String> listNoms = new ArrayList<String>();
	    listNoms.add("nico");
	    listNoms.add("roger");
	    listNoms.add("jeff");
	    listNoms.add("massi");
	    listNoms.add("elvis");
	    listNoms.add("adel");
	    
	    System.out.println(listNoms.get(0));
	    System.out.println(listNoms.get(1));
	    System.out.println("-------------------------------");
	    /* Iterator
	     * •Permet de parcourir une collection en récupérant les éléments successivement
	     * •Méthode de parcours homogène pour tous les types de collections
	     * •Garantit la cohérence de la collection parcourue
	     * •Permet de retirer d’une collection un élément pointer par l’itérateur
	     * •Pas de modifications externes autorisées pendant le parcours
	     */
	    for(Iterator<String> it = listNoms.iterator(); it.hasNext();) {
	    	String nomAfficher = it.next();
	    	System.out.println(nomAfficher);
	    }
	    System.out.println("-------------------------------");
	    for(String nom : listNoms) {
	    	System.out.println(nom);
	    }
	    System.out.println("-------------------------------");

		List<User> userList = new ArrayList<User>();
		User user1 = new User("lourdel","nicolas", 23);
		User user2 = new User("lourdel","aurélia", 34);
		User user3 = new User("dupont", "Jean", 22);
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		afficherUser(userList);
		// avec une boucle traditionnelle :
		for(int i=0; i<userList.size(); i++) {
			System.out.print(userList.get(i).getPrenom()+" "+userList.get(i).getNom());
			System.out.println();
		}
		System.out.println("---------------------------------");
		
		System.out.println("taille de la liste : "+userList.size());
		System.out.println();
		// test ajout, suppression
		/*Gestion des doublons
		 * •Les listes acceptent les doublons
		 * •Ils sont positionnés à un index différent
		 * •La liste stocke plusieurs références vers le même objet
		 */
		afficherUser(userList);
		System.out.println("ajout doublon :");
		userList.add(user1);
		System.out.println("---------------------------------");
		afficherUser(userList);
		System.out.println("---------------------------------");
		System.out.println("modif objet");
		userList.get(0).setNom("Dugenou");
		// userList.get(0) et .get(3) pointent sur le même objet à l'affichage ces deux index auront changé
		afficherUser(userList);
		System.out.println("---------------------------------");
		System.out.println("suppression doublon : ");
		userList.remove(user1);
		afficherUser(userList);
		// Création d'un objet Linkedlist qui contient une liste d'objets.
		List l = new LinkedList();
		l.add("toto");
		l.add("titi");
		l.add(12);
		l.add(12.04);
		l.add("C");
		// le type déclaré LinkedList possède d'autres méthodes...
		LinkedList ll = new LinkedList();
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
	public static void afficherUser(List<User> userList) {
		for(User user : userList) {
			System.out.print(user.getNom());
			System.out.print(" "+user.getPrenom());
			System.out.println(" "+user.getIdentifiant());
		}
		System.out.println();
	}
}
