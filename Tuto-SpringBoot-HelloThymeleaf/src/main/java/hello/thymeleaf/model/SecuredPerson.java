package hello.thymeleaf.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class SecuredPerson {

	@Range(min = 1)
	private int id;

	@Length(min = 4, max = 10)
	private String nom;

	@Range(min = 8, max = 14)
	private int age;

	// constructeurs
	public SecuredPerson() {

	}

	public SecuredPerson(int id, String nom, int age) {
	this.id=id;
	this.nom = nom;
	this.age = age;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("SecuredPerson [id=%s, nom=%s, age=%s]", id, nom, age);
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	}