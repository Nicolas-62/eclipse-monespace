package hello.models;

public class Personne {
	private Integer id;
	private String nom;
	private int age;
	
	public Personne() {
		super();
	}
	public Personne(String nom, int age) {
		super();
		this.nom = nom;
		this.age = age;
	}
	public Personne(Integer id, String nom, int age) {
		super();
		this.id = id;
		this.nom = nom;
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	@Override
	public String toString() {
		return String.format("Personne [id=%s, nom=%s, age=%s]", id, nom, age);
	}
}
