package cnam.projet.mondeEco.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Inscription {
	@NotNull
	@Pattern(regexp = "(M\\.)?(Mme)?", message = "format invalide")
	private String civiliteInscription;
	@NotNull
	@Size(min = 2, max = 30, message = "Taille minimum de {min} et {max} au maximum.")
	@Pattern(regexp = "^[a-zA-Zàâéèëêïîôùüçœ'’ -]{2,25}$", message = "format saisie invalide")
	private String nomInscription;
	@NotNull
	@Size(min = 2, max = 30, message = "Taille minimum de {min} et {max} au maximum.")
	@Pattern(regexp = "^[a-zA-Zàâéèëêïîôùüçœ'’ -]{2,25}$", message = "format saisie invalide")
	private String prenomInscription;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9àâéèëêïîôùüçœ\\'’ \\._ ,]{5,60}$", message = "Format saisie invalide")
	private String adresseInscription;
	@NotNull
	@Pattern(regexp = "^[a-zA-Zàâéèëêïîôùüçœ\\'’ -]{2,25}$", message = "Format saisie invalide")
	private String villeInscription;
	@NotNull
	@Pattern(regexp = "^([0-9]{5})$", message = "Format saisie invalide")
	private String CpInscription;
	@Email
//	@Pattern(regexp = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$", message = "Format de mail invalide")
	private String emailInscription;
	@Pattern(regexp = "^0[1-9]([-\\. ]?[0-9]{2}){4}$", message = "Format saisie invalide")
	private String telInscription;
	@Pattern(regexp = "(.*){3,60}")
	private String diplomeObtenuInscription;
	@NotNull
	private String formationSouhaiteInscription;// checkbox

	public String getCiviliteInscription() {
		return civiliteInscription;
	}

	public void setCiviliteInscription(String civiliteInscription) {
		this.civiliteInscription = civiliteInscription;
	}

	public String getNomInscription() {
		return nomInscription;
	}

	public void setNomInscription(String nomInscription) {
		this.nomInscription = nomInscription;
	}

	public String getPrenomInscription() {
		return prenomInscription;
	}

	public void setPrenomInscription(String prenomInscription) {
		this.prenomInscription = prenomInscription;
	}

	public String getEmailInscription() {
		return emailInscription;
	}

	public void setEmailInscription(String emailInscription) {
		this.emailInscription = emailInscription;
	}

	public String getAdresseInscription() {
		return adresseInscription;
	}

	public void setAdresseInscription(String adresseInscription) {
		this.adresseInscription = adresseInscription;
	}

	public String getVilleInscription() {
		return villeInscription;
	}

	public void setVilleInscription(String villeInscription) {
		this.villeInscription = villeInscription;
	}

	public String getCpInscription() {
		return CpInscription;
	}

	public void setCpInscription(String cpInscription) {
		CpInscription = cpInscription;
	}

	public String getTelInscription() {
		return telInscription;
	}

	public void setTelInscription(String telInscription) {
		this.telInscription = telInscription;
	}

	public String getDiplomeObtenuInscription() {
		return diplomeObtenuInscription;
	}

	public void setDiplomeObtenuInscription(String diplomeObtenuInscription) {
		this.diplomeObtenuInscription = diplomeObtenuInscription;
	}

	public String getFormationSouhaiteInscription() {
		return formationSouhaiteInscription;
	}

	public void setFormationSouhaiteInscription(String formationSouhaiteInscription) {
		this.formationSouhaiteInscription = formationSouhaiteInscription;
	}

	public String getFinancemementFormation() {
		return financemementFormation;
	}

	public void setFinancemementFormation(String financemementFormation) {
		this.financemementFormation = financemementFormation;
	}

	private String financemementFormation;// checkbox

}
