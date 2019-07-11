/**
 * 
 */
package interfacage;



/**
 * @author dell
 * Cette decrit les caractréstiques d'un pilote d'avion
 *
 */
public class Pilote {
	 public long matricule;
	 public String nom;
	 public String prenom;
	 int niveau;
	
	/** définition d'un constructeur 
	 * @param pilotable **/
	public Pilote() {};
	public Pilote(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	

	
	public void faireDecoller(Pilotable pilotable){
		System.out.println(" L'avion décolle class Pilote");
		pilotable.inclinerVolets(10);
	
	}
	
	
	private void chaufferMoteur(){
		System.out.println(this.getClass() + " Chauffer le moteur");
	}
	
	private void checkAvion(){
		System.out.println(this.getClass() + " checkAvion avion");
	}
	public final void faireAtterir(){
		System.out.println(this.getClass() + " L'avion atterrit");
	}

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

	public long getMatricule() {
		return matricule;
	}

	public void setMatricule(long paramMatricule) {
		this.matricule = paramMatricule;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
	public String toString() {
		return prenom + " " + nom;
		
	}

	public String toString(String chaine) {
		// TODO Auto-generated method stub
		return "objet pilote";
	}


	public long calculerSalaire() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	
	
	
	

}
