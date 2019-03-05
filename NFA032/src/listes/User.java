package listes;

public class User implements Comparable<User>{
	private String nom;
	private String prenom;
	private int identifiant;
	
	public User(String unNom, String unPrenom, int unIdentifiant) {
		this.nom = unNom;
		this.prenom = unPrenom;
		this.identifiant = unIdentifiant;
	}
	public int compareTo(User otherUser) {
		// renvoie un nombre négatif si l'objet en cours a un nom
		// situé avant le nom de l'objet passé en paramètre (ordre alphabétique)
		// renvoie un nombre positif si l'objet en cours a un nom
		// situé après le nom de l'objet passé en paramètre
		int resultat= nom.compareTo(otherUser.nom);
		if(resultat== 0) {
			resultat= prenom.compareTo(otherUser.prenom);
		}
		return resultat;
	}
	public String toString() {
		String str;
		str=this.nom+"/"+this.prenom;
		return str;
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
