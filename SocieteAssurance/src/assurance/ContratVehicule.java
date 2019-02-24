package assurance;

/**
 * 
 * @author ica
 * description : Classe abstraite "ContratVehicule" qui hérite de la classe abstraite "Contrat".
 */

public abstract class ContratVehicule extends Contrat {
	
	
	private double bonusOuMalus;
	
	public double getBonusOuMalus() {
		return bonusOuMalus;
	}


	public void setBonusOuMalus(double bonusMalus) {
		this.bonusOuMalus = bonusMalus;
	}


	@Override
	public abstract double calculerTarif();
	
	@Override
	public abstract void imprimerResultatDevis();
	
	public abstract double calculerMajoration();
}
