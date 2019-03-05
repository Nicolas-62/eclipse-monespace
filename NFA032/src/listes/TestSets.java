package listes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSets {
	/* Les Set sont particulièrement adaptés pour manipuler une grande quantité de données. 
	 * Cependant, les performances de ceux-ci peuvent être amoindries en insertion. 
	 * Généralement, on opte pour un HashSet, car il est plus performant en temps d'accès, 
	 * mais si vous avez besoin que votre collection soit constamment triée, optez pour un TreeSet.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user1 = new User("lourdel", "nicolas", 23);
		User user2 = new User("lourdel", "aurélia", 34);
		User user3 = new User("dupont", "Jean", 22);
		// manipulation de set :
		Set<User> userSet = new HashSet<User>();
		userSet.add(user1);
		userSet.add(user2);
		userSet.add(user3);

		System.out.println("affichage du set : ");
		for (User user : userSet) {
			System.out.print(user.getNom());
			System.out.print(" " + user.getPrenom());
			System.out.println(" " + user.getIdentifiant());
		}
		System.out.println("--------------------------------");
		for(Iterator<User> it = userSet.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
		System.out.println("--------------------------------");
		// set : pas de doublons (objet)
		Set<String> set = new HashSet<String>();
		set.add("le");
		set.add("petit");
		set.add("chat");
		set.add("chat");

		for (String chaine : set) {
			System.out.println(chaine);
		}
	}

}
