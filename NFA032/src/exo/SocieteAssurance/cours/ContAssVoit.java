package exo.SocieteAssurance.cours;

public class ContAssVoit extends Contrat{	
	private int tarifBase = 20;
	private boolean saisieChevaux=false;
	private int nbChevaux;
	private boolean saisieBonus=false;
	private double bonus;
	private int anneeAssure;
	private boolean conjointAssure=false;
	private boolean enfantAssure=false;
	/* tableau des baremes bareme[][0] = nombre de chevaux fiscaux
						   bareme[][1] = majoration liée au nombre de chevaux fiscaux
						   bareme[][2] = majoration si conjoint assuré
						   bareme[][3] = majoration si enfant assuré
 						  */
	private double[][] bareme = {{4,1,1,1},{5,1.1,2,2},{6,1.2,3,3},{7,1.3,4,4},{8,1.4,5,5},{9,1.5,6,6},{10,1.6,7,7}};

	public ContAssVoit() {}
	public ContAssVoit(String nom, String prenom,String dateNais, boolean marie, int nbEnfant) {

			super(nom, prenom, dateNais, marie, nbEnfant);

		this.setTypeContrat("assurance voiture");	
	}
	public double calculerTarif() {
		// variable qui contient la position de la ligne du tableau où se trouve la bareme applicable
		int indiceTableau=0;
		double tarif = tarifBase;
		if(saisieChevaux) {		
			for(int i=0; i<bareme.length; i++) {
				if(nbChevaux == bareme[i][0]) {
					tarif = tarif*bareme[i][1];
					indiceTableau = i;
					break;
				}
			}
		}
		if(anneeAssure<=6) {
			tarif = tarif-anneeAssure;
		}else {
			tarif = tarif-6;
		}
		if(conjointAssure) {
			tarif = tarif+bareme[indiceTableau][2];
		}
		if(enfantAssure) {
			tarif = tarif+bareme[indiceTableau][3];
		}
		if(saisieBonus) {
			tarif = tarif*bonus;
		}
		return tarif;
	}
	public void imprimerResultatDevis() {
		String str;
		str ="DEVIS ASSURANCE VOITURE \n\n";		
		str+= "Nom : "+this.getNom()+"\n";
		str+= "Prenom : "+this.getPrenom()+"\n";
		str+= "Le tarif à payer pour votre "+this.getTypeContrat()+" est de : "+this.calculerTarif()+" €\n";
		str+= "Veuillez joindre : \n";
		str+="Copie carte grise \n";
		str+="Copie de permis \n";
		str+="Si mariée :  \n";
		str+="\t Copie permis conjoint \n";
		str+="Si enfant conduit : \n";
		str+="\t Copie permis enfant \n";
		str+="RIB \n";
		str+="Carte d'identié assureur";
		System.out.print(str);
	}
	
	/**
	 * @return the nbChevaux
	 */
	public int getNbChevaux() {
		return nbChevaux;
	}
	/**
	 * @param nbChevaux the nbChevaux to set
	 */
	public void setNbChevaux(int nbChevaux) throws NbChevauxException{
		if(nbChevaux ==0)
			throw new NbChevauxException("Nombre de chevaux nul impossible");
		else {
			this.nbChevaux = nbChevaux;
		}
	}
	/**
	 * @return the bonus
	 */
	public double getBonus() {
		return bonus;
	}
	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	/**
	 * @return the anneeAssure
	 */
	public int getAnneeAssure() {
		return anneeAssure;
	}
	/**
	 * @param anneeAssure the anneeAssure to set
	 */
	public void setAnneeAssure(int anneeAssure) {
		this.anneeAssure = anneeAssure;
	}
	/**
	 * @return the conjointAssure
	 */
	public boolean isConjointAssure() {
		return conjointAssure;
	}
	/**
	 * @param conjointAssure the conjointAssure to set
	 */
	public void setConjointAssure(boolean conjointAssure) {
		this.conjointAssure = conjointAssure;
	}
	/**
	 * @return the enfantAssure
	 */
	public boolean isEnfantAssure() {
		return enfantAssure;
	}
	/**
	 * @param enfantAssure the enfantAssure to set
	 */
	public void setEnfantAssure(boolean enfantAssure) {
		this.enfantAssure = enfantAssure;
	}
	/**
	 * @return the saisieChevaux
	 */
	public boolean isSaisieChevaux() {
		return saisieChevaux;
	}
	/**
	 * @param saisieChevaux the saisieChevaux to set
	 */
	public void setSaisieChevaux(boolean saisieChevaux) {
		this.saisieChevaux = saisieChevaux;
	}
	/**
	 * @return the saisieBonus
	 */
	public boolean isSaisieBonus() {
		return saisieBonus;
	}
	/**
	 * @param saisieBonus the saisieBonus to set
	 */
	public void setSaisieBonus(boolean saisieBonus) {
		this.saisieBonus = saisieBonus;
	}
	public double getTarifBase() {
		return tarifBase;
	}

}
