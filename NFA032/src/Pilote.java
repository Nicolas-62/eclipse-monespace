
public class Pilote {
	
	private long matricule;
	private String nom;
	private String prenom;
	
	public Pilote() {}
	
	public Pilote(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public void faireDecoller() {
		System.out.println("on décolle !!");
	}
	public void faireAtterir() {}
	
	
	public long getMatricule() {
		return matricule;
	}
	public void setMatricule(long matricule) {
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
	};
}
