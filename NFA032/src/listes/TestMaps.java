package listes;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestMaps {
	/*
	 * Gestion des doublons. Les maps acceptent les doublons. Un élément peut être
	 * présent plusieurs fois s'il est référencé par des clés différentes. Rajout
	 * d'un élément avec une clé déjà existante possible. La valeur précédente est
	 * écrasée.
	 */
	public static void main(String[] args) {
		Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
		ht.put(1, "printemps");
		ht.put(10, "été");
		ht.put(12, "automne");
		ht.put(45, "hiver");

		Enumeration e = ht.elements();
		/*
		 * On parcourt cet objet grâce aux clés qu'il contient en recourant à la classe
		 * Enumeration. L'objet Enumeration contient notre Hashtable et permet de le
		 * parcourir très simplement.
		 */
		while (e.hasMoreElements())
			System.out.println(e.nextElement());
		System.out.println("----------------------------------");
		/*
		 * a la difference de HashTable, HashMap accepte la valeur null il n'est pas
		 * Thread Safe.
		 */
		// Map : pas de doublons (clé, valeur)
		Map<String, String> map = new HashMap<String, String>();
		map.put("dupont", "nico");
		map.put("dupont", "roger");
		map.put("Dupont", "fabrice");

		System.out.println(map.get("dupont"));
		System.out.println(map.get("nico"));
		System.out.println("é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~");
		// parcour d'une map :
		Map<String, User> map2 = new HashMap<String, User>();
		User user1 = new User("lourdel", "nicolas", 23);
		User user2 = new User("lourdel", "aurélia", 34);
		User user3 = new User("dupont", "Jean", 22);
		map2.put(user1.getNom(), user1);
		map2.put(user2.getNom(), user2);
		map2.put(user3.getNom(), user3);
		// avec les iterators :
		Iterator<String> keys = map2.keySet().iterator();
		Iterator<User> values = map2.values().iterator();
		for (Iterator<String> key = keys; keys.hasNext();) {
			System.out.println(key.next() + " : " + values.next());
		}
		System.out.println("------------------------------------");
		// avec la methode entry
		for (Map.Entry<String, User> entry : map2.entrySet()) {
			String key = entry.getKey();
			// getValue() appel de la methode toString de l'objet (qui affiche le prenom
			// ici)
			User value = entry.getValue();
			System.out.println(key + " = " + value);
		}
	}

}
