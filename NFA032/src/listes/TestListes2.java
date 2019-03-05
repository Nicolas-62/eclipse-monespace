package listes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestListes2 {

	public static void afficherCollection(Collection<User> col) {
		for(Iterator<User> it= col.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
	public static void main(String[] args) {
		User u1 = new User("dupont","jean", 12);
		User u2 = new User("durant","Jean", 12);
		User u3 = new User("lourdel","nicolas", 23);
		User u4 = new User("alemant","aurélia", 34);
		User u5 = new User("bretiau", "fabrice", 22);
		User u6 = new User("lourdel","zoe", 23);
		User u7 = new User("lourdel","sebastien", 23);
		
		Set<User>set= new HashSet<User>();
		set.add(u1);
		set.add(u1);
		afficherCollection(set);
		System.out.println("after remove u1 :");
		set.remove(u1);
		afficherCollection(set);
		System.out.println("--------------------------------");
		
		List<User>list= new ArrayList<User>();
		list.add(u1);
		list.add(u1);
		System.out.println("liste : ");
		afficherCollection(list);
		System.out.println("--------------------------------");
		
		Map<String, User>map=new HashMap<String, User>();
		System.out.println("Map : ");
		map.put("dupont",u1);
		map.put("durand",u2);
		//  même clé, ecrase la première entrée :
		map.put("dupont",u1);
		for(Map.Entry<String, User> entry : map.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		System.out.println("--------------------------------");
		System.out.println("tableau :");
		User[] array = {u1,u2,u3,u4,u5,u6,u7};
		for(User user : array) {
			System.out.println(user.getNom()+" = "+user.getPrenom());
		}
		/* Tri des éléments : 
		 * pour trier des objets en fonction de leurs attributs
		 * ceux ci doivent implémenter l'interface Comparable
		 * sinon une CLassCastException est levée
		 */
//		Arrays.sort(array);
		System.out.println("after sort : ");
		for(User user : array) {
			System.out.println(user.getNom()+" = "+user.getPrenom());
		}
		/*
		 * On peut egalement créer un Comparator, l'avantage est qu'on peut 
		 * en créer plusieurs selon les besoins 
		 */
		List<User> uneListe = new ArrayList<User>();
		System.out.println("Liste : ");
		Collections.addAll(uneListe, array);
		afficherCollection(uneListe);
		Collections.sort(uneListe);
		System.out.println("--------------------------------");
		System.out.println("après tri : ");
		afficherCollection(uneListe);
		
		List<User> uneListe2 = new ArrayList<User>();
		System.out.println("Liste2 : ");
		Collections.addAll(uneListe2, array);
		afficherCollection(uneListe2);
		Collections.sort(uneListe2, new UserComparator());
		System.out.println("--------------------------------");
		System.out.println("après tri : ");
		afficherCollection(uneListe2);	
		
		// renvoie une collection non modifiable
		List L1 = Collections.unmodifiableList(uneListe);
		
		// liste synchronysée pour gérer les accès concurrents
		List L2 = Collections.synchronizedList(uneListe);
		
	}

}
