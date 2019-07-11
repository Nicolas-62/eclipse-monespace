package cnam.gestionSalarie.swing;
public class Salarie {
	
	private String matricule;
	private String nom;
	private String prenom;
	private String fonction;
	private String tel;
	private String dateNais;
	private String dateEmb;
	private String salaire;
	
	public Salarie() {}
	
	public Salarie(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Salarie(String matricule, String nom, String prenom, String fonction, String tel, String dateNais,
			String dateEmb, String salaire) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.tel = tel;
		this.dateNais = dateNais;
		this.dateEmb = dateEmb;
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return String.format(
				"%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s".replaceAll("\t", ";"),
				matricule, nom, prenom, fonction, tel, dateNais, dateEmb, salaire);
	}

	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
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
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDateNais() {
		return dateNais;
	}
	public void setDateNais(String dateNais) {
		this.dateNais = dateNais;
	}
	public String getDateEmb() {
		return dateEmb;
	}
	public void setDateEmb(String dateEmb) {
		this.dateEmb = dateEmb;
	}
	public String getSalaire() {
		return salaire;
	}
	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}
	
}
