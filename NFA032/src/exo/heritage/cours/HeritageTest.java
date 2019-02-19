package exo.heritage.cours;

public class HeritageTest {

	public static void main(String[] args) {
		
		PersonneAvecLieu unePersonne = new PersonneAvecLieu("Lourdel", new LaDate(16,1,1986), "Lille");
		unePersonne.ecrire();
		SuperieurHierarchique unSup = new SuperieurHierarchique();
		Employe[] tabEmployes = {new Employe("nico", 1), new Employe("seb", 2)};
		unSup.setEmployes(tabEmployes);
		System.out.println(tabEmployes[0].getNom());
		unSup.getEmployes();

	}

}
