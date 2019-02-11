
class Compte {
	
	int solde = 0;
	private String nom;
	
	public Compte(String nom){
		this.setNom(nom);
	}
	
	public Compte() {
		// TODO Auto-generated constructor stub
	}

	void setNom(String nom) {
		this.nom = nom;
	}
	String getNom() {
		return this.nom;
	}
	
	void deposer(int montant) {
		solde = solde + montant;
	}
	
	void retirer(int montant) {
		solde = solde - montant;
	}
	
	void virerVers(int montant, Compte destination) {
		this.retirer(montant);
		destination.deposer(montant);
	}
	
	void afficher() {
		System.out.println("solde: " + this.solde + "\n");
		System.out.println("nom : " + this.getNom());
	}

}