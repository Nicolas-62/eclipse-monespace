
public class Tableau3 {

	public static void main(String[] args) {
		String tab[][] = { { "toto", "titi", "tutu", "tete", "tata" }, { "1", "2", "3", "4" } };
		int i = 0, j = 0;

		for (String sousTab[] : tab) {
			i = 0;
			for (String str : sousTab) {
				System.out.println("La valeur de la nouvelle boucle est  : " + str);
				System.out.println("La valeur du tableau à l'indice [" + j + "][" + i + "] est : " + tab[j][i]);
				i++;
			}
			j++;
		}

		for (int k = 0; k < tab.length; k++) {
			for (int l = 0; l < tab[k].length; l++) {
				System.out.println("La valeur de la nouvelle boucle est  : " + tab[k][l]);
				System.out.println("La valeur du tableau à " + "l'indice [" + k + "][" + l + "] est : " + tab[k][l]);

			}
		}

	}

}
