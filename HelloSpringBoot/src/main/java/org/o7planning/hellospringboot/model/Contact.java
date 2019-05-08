package org.o7planning.hellospringboot.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Contact {
	
	@NotNull
	@Pattern(regexp="(M\\.)?(Mme)?",
	message="format invalide")	
	private String civiliteContact;
	@NotNull
	@Size(min=2, max=30, message="Taille minimum de {min} et {max} au maximum.")
	@Pattern(regexp="^[a-zA-Zàâéèëêïîôùüçœ\\'’ -]{2,25}$",
	message="format du nom invalide")
	private String nomContact;
	@NotNull
	@Size(min=2, max=30, message="Taille minimum de {min} et {max} au maximum.")
	@Pattern(regexp="^[a-zA-Zàâéèëêïîôùüçœ\\'’ -]{2,25}$",
	message="format du nom invalide")
	private String prenomContact;
	@Email
	@Pattern(regexp = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$", 
	message="Format de mail invalide")
	private String emailContact;
	@NotNull
	@Size(min=100, max=2000, message="Taille minimum de {min} et {max} au maximum.")
	private String messageContact;
	public String getCiviliteContact() {
		return civiliteContact;
	}
	public void setCiviliteContact(String civiliteContact) {
		this.civiliteContact = civiliteContact;
	}
	public String getNomContact() {
		return nomContact;
	}
	public void setNomContact(String nomContact) {
		this.nomContact = nomContact;
	}
	public String getPrenomContact() {
		return prenomContact;
	}
	public void setPrenomContact(String prenomContact) {
		this.prenomContact = prenomContact;
	}
	public String getEmailContact() {
		return emailContact;
	}
	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}
	public String getMessageContact() {
		return messageContact;
	}
	public void setMessageContact(String messageContact) {
		this.messageContact = messageContact;
	}


}
