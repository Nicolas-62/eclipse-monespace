package listes;

public class User {
	private String nom;
	private String prenom;
	private int identifiant;
	
	public User(String unNom, String unPrenom, int unIdentifiant) {
		this.nom = unNom;
		this.prenom = unPrenom;
		this.identifiant = unIdentifiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	
}
