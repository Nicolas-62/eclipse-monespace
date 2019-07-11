package exo.SocieteAssurance.cours;

public abstract class Contrat {
	
	private String nom;
	private String prenom;
	private String dateNais;
	private boolean statutMarital;
	private int nbEnfant;
	private String typeContrat;

	public Contrat() {}
	public Contrat(String nom, String prenom,String dateNais, boolean statutMarital, int nbEnfant) {
		this.nom=nom;
		this.prenom=prenom;
		this.dateNais=dateNais;
		this.statutMarital=statutMarital;
		this.statutMarital=statutMarital;
		this.nbEnfant=nbEnfant;
	}

	public abstract double calculerTarif();
	public abstract void imprimerResultatDevis();
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the dateNais
	 */
	public String getDateNais() {
		return dateNais;
	}
	/**
	 * @param dateNais the dateNais to set
	 */
	public void setDateNais(String dateNais) {
		this.dateNais = dateNais;
	}
	/**
	 * @return the statutMarital
	 */
	public boolean isStatutMarital() {
		return statutMarital;
	}
	/**
	 * @param statutMarital the statutMarital to set
	 */
	public void setStatutMarital(boolean statutMarital) {
		this.statutMarital = statutMarital;
	}
	public String getTypeContrat() {
		return typeContrat;
	}
	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}
	/**
	 * @return the nbEnfant
	 */
	public int getNbEnfant() {
		return nbEnfant;
	}
	/**
	 * @param nbEnfant the nbEnfant to set
	 */
	public void setNbEnfant(int nbEnfant) {
		this.nbEnfant = nbEnfant;
	}	
}
