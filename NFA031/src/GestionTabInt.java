

public class GestionTabInt {
	// Fonction qui affiche un tableau
	public static void ecrire(int tab[]) {
		for(int i=0; i<tab.length; i++) {
			System.out.print(tab[i]+"  ");
		}
		System.out.println();
	}
	// fonction qui fait la somme des entiers du tableau
	public static int somme(int[] tab) {
		int somme =0;
		for(int i=0; i<tab.length; i++) {
			somme +=tab[i];
		}
		return somme;
	}
	// fonction qui donne l'index de l'entier le plus grand du tableau.
	public static int indexMax(int[] tab) {	
		// La fonction retourne -1 si le tableau est vide;
		int indice =-1;
		if(tab.length != 0) {
			// On compare la valeur de la première clé à celle de la clé suivante
			int max = tab[0];
			int i = 1;
			indice = 0;
			do {				
				if(max < tab[i]) {
					max = tab[i];
					indice = i;
				}
			i++;
			}while(i<tab.length);
		}
		return indice;		
	}
	// fonction qui ajoute un entier au tableau
	public static int[] ajoute(int[] tab, int nb) {
		int[] tabNew = new int[tab.length+1];
		for(int i=0; i<tab.length; i++) {
			tabNew[i] = tab[i];
		}
		tabNew[tab.length] = nb;
		return tabNew;
	}
}
