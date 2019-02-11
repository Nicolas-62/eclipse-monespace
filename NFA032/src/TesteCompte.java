
public class TesteCompte {
	public static void main(String[] args) {
		// création d'un tableau de 10 comptes
		Compte monCompte = new Compte("nico");
		monCompte.afficher();
		Compte tonCompte = new Compte();
		tonCompte.setNom("kamel");
		tonCompte.afficher();
		
	}	
}
