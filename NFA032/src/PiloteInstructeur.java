public class PiloteInstructeur extends Pilote{
	
	private String dateLicenceInstructeur;
	
	public PiloteInstructeur() {}
	
	public PiloteInstructeur(String nom, String prenom) {
		super(nom, prenom);
		this.dateLicenceInstructeur = "18/02/2008";
	}
	
	public void enseignerDecollage() {}
	public void enseignerAtterrissage() {}
	/**
	 * @return the dateLicenceInstructeur
	 */
	public String getDateLicenceInstructeur() {
		return dateLicenceInstructeur;
	}
	/**
	 * @param dateLicenceInstructeur the dateLicenceInstructeur to set
	 */
	public void setDateLicenceInstructeur(String dateLicenceInstructeur) {
		this.dateLicenceInstructeur = dateLicenceInstructeur;
	}


}
