package exo.SocieteAssurance.cours;

public class ContAssMaison extends Contrat{
	private static int tarifBase = 15;
	private double tarif;
	private double surface;
	private boolean garage;
	private int nbPersFoyer;
	private String typeHabitat;
	/* tableau des baremes bareme[][0] = surface maximale de la maison
	   bareme[][1] = majoration liée à la surface de la maison
	   bareme[][2] = majoration si la maison possède un garage
	  */
	private double[][] bareme = {{50,1,0},{60,1.1,1},{70,1.2,2},{80,1.3,3},{90,1.4,4},{100,1.5,5},{999999,1.6,6}};
	/* tableau des baremes bareme[][0] = nombre maximal de personnes dans le foyer
	   bareme[][1] = majoration applicable
	  */	
	private int[][] baremeFoyer = {{1,0},{2,2},{3,3},{4,4},{5,5},{6,6},{7,7},{99,7}};
	
	public ContAssMaison(String nom, String prenom,String dateNais, boolean marie, int nbEnfant) {
		super(nom, prenom, dateNais, marie, nbEnfant);
		this.setNbPersFoyer(marie, nbEnfant);
		this.setTypeContrat("assurance habitation");	
	}
	public double calculerTarif() {
		// variable qui contient la position de la ligne du tableau où se trouve la bareme applicable
		int indiceTableau=0;
		tarif = tarifBase;	
		for(int i=0; i<bareme.length; i++) {
			if(surface<=bareme[i][0]) {
				tarif = tarif*bareme[i][1];
				indiceTableau = i;
				break;
			}
		}
		if(garage) {
			tarif = tarif+bareme[indiceTableau][2];
		}
		for(int i=0; i<baremeFoyer.length; i++) {
			if(nbPersFoyer<=baremeFoyer[i][0]) {
				tarif = tarif+baremeFoyer[i][1];
				break;
			}
		}
		return tarif;		
	};
	public void imprimerResultatDevis() {
		String str;
		str ="DEVIS ASSURANCE HABITATION \n\n";
		str+= "Nom : "+this.getNom()+"\n";
		str+= "Prenom : "+this.getPrenom()+"\n";
		str+= "Le tarif à payer pour votre"+this.getTypeContrat()+" est de : "+this.calculerTarif()+"\n";
		str+= "Veuillez joindre : \n";
		str+="Contrat de location \n";
		str+="RIB \n";
		str+="Carte d'identié assureur";
		System.out.print(str);
	}
	public int getNbPersFoyer() {
		return nbPersFoyer;
	}
	public void setNbPersFoyer(boolean marie, int nbEnfant) {		
		int nbPers=1;
		if(marie) {
			nbPers +=1;
		}
		nbPers += nbEnfant;
		this.nbPersFoyer = nbPers;
	}
	public String getTypeHabitat() {
		return typeHabitat;
	}
	public void setTypeHabitat(String typeHabitat) {
		this.typeHabitat = typeHabitat;
	}
	/**
	 * @return the surface
	 */
	public double getSurface() {
		return surface;
	}
	/**
	 * @param surface the surface to set
	 */
	public void setSurface(double surface) {
		this.surface = surface;
	}
	/**
	 * @return the garage
	 */
	public boolean isGarage() {
		return garage;
	}
	/**
	 * @param garage the garage to set
	 */
	public void setGarage(boolean garage) {
		this.garage = garage;
	};
}
