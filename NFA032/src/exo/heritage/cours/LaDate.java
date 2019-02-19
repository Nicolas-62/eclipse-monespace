package exo.heritage.cours;

public class LaDate {
	int jour;
	int mois;
	int annee;
	public LaDate(int j, int m, int a) {
		this.jour = j;
		this.mois = m;
		this.annee = a;
	}
	public void ecrire() {
		System.out.print(jour + "/" + mois + "/" +annee);
	}
}
