
public class Tableau1 {

	/*
	 * A la difference des types primitifs qui sont passés par valeur (copie) les
	 * types objets sont passés par référence (=> modification de l'objet).
	 */
	public static void afficherTableau(int tab[]) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i] + " ; ");
		}
		System.out.println();
	}

	public static void initialiserTableau(int tab[]) {
		for (int i = 0; i < tab.length; i++) {
			tab[i] = 0;
		}
	}

	public static void fois2(int x) {
		System.out.println("x = " + x * 2);
	}

	public static void main(String args[]) {
		int x = 1;
		int tab[] = { 5, 4, 3, 2, 1 };
		afficherTableau(tab);
		initialiserTableau(tab);
		afficherTableau(tab);
		System.out.println("x = " + x);
		fois2(x);
		System.out.println("x = " + x);
	}
}
