package assurance;

/**
 * 
 * @author ica
 * Description : Classe Abstraite Contrat 
 */
public abstract class Contrat {

	private String nom;
	private String prenom;
	private String dateDeNaissance;
	private boolean estMarie;
	private boolean avoirEnfant;
	private int anneeAssurance;
	
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
	public String getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public boolean isEstMarie() {
		return estMarie;
	}
	
	public void setEstMarie(boolean marie) {
		this.estMarie = marie;
	}
	public boolean isAvoirEnfant() {
		return avoirEnfant;
	}
	
	public void setAvoirEnfant(boolean enfant) {
		this.avoirEnfant = enfant;
	}
	public int getAnneeAssurance() {
		return anneeAssurance;
	}
	public void setAnneeAssurance(int anneeAssurance) {
		this.anneeAssurance = anneeAssurance;
	}

	
	// méthodes abstraites 
	
	public abstract double calculerTarif();
	public abstract void imprimerResultatDevis();
		
	
	
}
