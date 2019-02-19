package exo.heritage.cours;

public class Employe {
	
	private String nom;
	private int matricule;
	private static double indiceSalarial = 1.2;
	private double salaire;
	
	Employe(){};
	
	Employe(String nom, int matricule){
		this.nom=nom;
		this.matricule=matricule;
	}
	public void calculerSalaire(double txHoraire) {
		this.setSalaire(txHoraire*indiceSalarial);
	}
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
	 * @return the matricule
	 */
	public double getMatricule() {
		return matricule;
	}
	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	/**
	 * @return the indiceSalarial
	 */
	public double getIndiceSalarial() {
		return indiceSalarial;
	}
	public double getSalaire() {
		return salaire;
	}	
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}	
}
