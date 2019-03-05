package listes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class testListes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// creer une nouvelle liste et ajouter trois users :
		// utilisation de l'interface List, la classe ArrayList implémente l'interface List
		List<User> userList = new ArrayList<User>();
		User user1 = new User("lourdel","nicolas", 23);
		User user2 = new User("lourdel","aurélia", 34);
		User user3 = new User("dupont", "Jean", 22);
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		afficherUser(userList);

		for(int i=0; i<userList.size(); i++) {
			System.out.print(userList.get(i).getPrenom()+" "+userList.get(i).getNom());
			System.out.println();
		}

		
		System.out.println("taille de la liste : "+userList.size());
		System.out.println();
		// test ajout, suppression
		System.out.println("ajout doublon :");
		userList.add(user3);
		afficherUser(userList);
		
		System.out.println("suppression doublon : ");
		userList.remove(user3);
		afficherUser(userList);
		System.out.println("---------------------------------");
		System.out.println("LES SETS : ");
		// manipulation de set :
		Set<User> userSet = new HashSet<User>();
		userSet.add(user1);
		userSet.add(user2);
		userSet.add(user3);
		
		System.out.println("affichage du set : ");
		for(User user : userSet) {
			System.out.print(user.getNom());
			System.out.print(" "+user.getPrenom());
			System.out.println(" "+user.getIdentifiant());		
		}
		

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
