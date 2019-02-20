package exo.SocieteAssurance.cours;

public class ContAssMoto extends Contrat{
	private int tarifBase = 30;
	private double tarif;
	private int cylindre;
	private double bonus;
	private int anneeAssure;
	/* bareme des majorations du tarif : bareme[][1]
	 * en fonction de la cylindrée maximale : bareme[][0]
	 */
	private double[][] bareme = {{200,1},{400,1.1},{600,1.2},{800,1.3},{1000,1.4},{1200,1.5},{19000,1.6}};
	
	public ContAssMoto(String nom, String prenom,String dateNais, boolean marie, int nbEnfant) {
		super(nom, prenom, dateNais, marie, nbEnfant);
		this.setTypeContrat("assurance moto");	
	}	
	public double calculerTarif() {
		tarif = tarifBase;
		for(int i=0; i<bareme.length; i++) {
			if(cylindre<=bareme[i][0]) {
				tarif = tarif*bareme[i][1];
				break;
			}
		}
		if(anneeAssure<=6) {
			tarif = tarif-anneeAssure;
		}else {
			tarif = tarif-6;
		}
		tarif = tarif*bonus;
		return tarif;		
	};
	public void imprimerResultatDevis() {
		String str;
		str ="DEVIS ASSURANCE MOTO \n\n";		
		str+= "Nom : "+this.getNom()+"\n";
		str+= "Prenom : "+this.getPrenom()+"\n";
		str+= "Le tarif à payer pour votre"+this.getTypeContrat()+" est de : "+this.calculerTarif()+"\n";
		str+= "Veuillez joindre : \n";
		str+="Copie carte grise moto \n";
		str+="Copie de permis moto \n";
		str+="RIB \n";
		str+="Carte d'identié assureur";
		System.out.print(str);
	}
	public int getCylindre() {
		return cylindre;
	}
	public void setCylindre(int cylindre) {
		this.cylindre = cylindre;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public int getAnneeAssure() {
		return anneeAssure;
	}
	public void setAnneeAssure(int anneeAssure) {
		this.anneeAssure = anneeAssure;
	};
}
