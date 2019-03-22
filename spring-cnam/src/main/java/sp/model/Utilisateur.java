package sp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@NotNull
	@Size(min=2, max=30, message="Taille minimum de {min} et {max} au maximum.")
	private String nom;
	@NotNull
	@Size(min=2, max=30, message="Taille minimum de {min} et {max} au maximum.")
	private String prenom;
	@Email
	@Column(unique=true)
	private String email;
	@NotNull
	@Past
	@DateTimeFormat (pattern="YYYY-MM-dd")
	private Date dateNaissance;
	private boolean cgu;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public boolean isCgu() {
		return cgu;
	}
	public void setCgu(boolean cgu) {
		this.cgu = cgu;
	}
}
