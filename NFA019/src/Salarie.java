import java.util.Date;

public class Salarie {
	
	private String matricule;
	private String nom;
	private String prenom;
	private String fonction;
	private String tel;
	private String email;
	private String dateNais;
	private String dateEmb;
	private Double salaire;
	
	public Salarie() {}
	
	public Salarie(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return String.format(
				"Salarie [matricule=%s, nom=%s, prenom=%s, fonction=%s, tel=%s, email=%s, dateNais=%s, dateEmb=%s, salaire=%s]",
				matricule, nom, prenom, fonction, tel, email, dateNais, dateEmb, salaire);
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Double getSalaire() {
		return salaire;
	}
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
	
}
