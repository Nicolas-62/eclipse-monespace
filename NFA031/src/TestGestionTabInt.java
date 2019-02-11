import fr.perso.mesclasses.Out;

public class TestGestionTabInt {

	public static void main(String[] args) {
		int[] tab = {14,-3,-5,12,-6,-15};		
		Out.p(GestionTabInt.somme(tab));
		int index = GestionTabInt.indexMax(tab);
		if(tab.length == 0) {
			Out.p("Le tableau est vide");
		}
		else {
			Out.p("La valeur la plus grande du tableau se trouve "
					+ "à l'index : "+index+
					" et vaut : "+tab[index]);
		}
		GestionTabInt.ecrire(tab);
		int[] tab2 = GestionTabInt.ajoute(tab, 20);
		GestionTabInt.ecrire(tab2);
	}
}
