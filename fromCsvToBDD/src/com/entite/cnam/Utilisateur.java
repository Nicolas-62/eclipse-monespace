package com.entite.cnam;

import com.exception.cnam.SexeException;
import com.exception.cnam.StringSizeException;

public class Utilisateur {
	private String nom;
	private String prenom;
	private String email;
	private String sexe;

	public Utilisateur() {}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String unNom) throws StringSizeException{
		if(unNom.length() > 255) {
			throw new StringSizeException();
		}else {
			this.nom = unNom;
		}
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String unPrenom) throws StringSizeException{
		if(unPrenom.length() > 255) {
			throw new StringSizeException();
		}else {		
			this.prenom = unPrenom;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String unEmail) throws StringSizeException{
		if(unEmail.length() > 255) {
			throw new StringSizeException();
		}else {			
			this.email = unEmail;
		}
	}

	public String getSexe() {
		return sexe;
	}
	
	public void setSexe(String unSexe) throws SexeException {
		if("M".equals(unSexe) || "F".equals(unSexe)) {
			this.sexe = unSexe;
		}else {
			throw new SexeException();			
		}
	}

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", sexe=" + sexe + "]";
	}
}
