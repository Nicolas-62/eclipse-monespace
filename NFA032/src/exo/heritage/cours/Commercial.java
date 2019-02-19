package exo.heritage.cours;

public class Commercial extends Employe{

	private double interessement;
	
	public void calculerSalaire(double salaire, double interessement) {
		this.setSalaire(salaire+interessement);
	}
}
