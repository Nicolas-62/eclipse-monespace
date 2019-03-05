package exoContacts;

public class Contact implements Comparable<Contact> {

	private Integer numero;
	private String nom;
	private String adresse;
	private String codePostal;
	private String ville;
	private Integer codeSecteur;
	
	public Contact() {
		
	}
	
	public Contact(Integer numero, String nom) {
		this.numero = numero;
		this.nom = nom;
	}
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Integer getCodeSecteur() {
		return codeSecteur;
	}
	public void setCodeSecteur(Integer codeSecteur) {
		this.codeSecteur = codeSecteur;
	}

	@Override
	public int compareTo(Contact autreContact) {
		return this.getNumero().compareTo(autreContact.getNumero());
	}
	
	
	@Override
	public String toString() {
		return numero+";"+nom + ";"+adresse +";"+codePostal+";"+ville+";"+codeSecteur;
	}
	
	
	
}
