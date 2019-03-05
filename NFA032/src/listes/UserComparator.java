package listes;

import java.util.Comparator;

public class UserComparator implements Comparator<User>{

	public int compare(User u1, User u2) {
		int resultat= u1.getNom().compareTo(u2.getNom());
		if(resultat== 0) {
			resultat= u1.getPrenom().compareTo(u2.getPrenom());
		}
		return resultat;		
	}
}
