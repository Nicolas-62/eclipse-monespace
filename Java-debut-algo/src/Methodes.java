
public class Methodes {

	public static void main(String[] args) {
		String[] tab = { "toto", "titi", "tata", "tete" };
		int[] tabInt = { 1, 2, 3, 4, 5 };
		parcourirTableau(tab);
		System.out.println(crossTab(tab));
		parcourirTableau(toString(tabInt));

	}

	static void parcourirTableau(String[] tab) {
		System.out.println("Methode qui parcour un tableau de string \n------------------");
		for (String str : tab)
			System.out.println(str);
	}

	static String crossTab(String[] tab) {
		System.out.println("Methode qui retourne le contenu du tableau sous forme de chaine ! \n---------------");
		String retour = "";

		for (String str : tab)
			retour += str + "\n";

		return retour;
	}

	// Methode qui créé un tableau de string à partir d'un tableau de nombre.
	static String[] toString(int[] tab) {
		String retour = new String();
		String[] tabString = new String[tab.length];

		int i = 0;
		for (int str : tab) {
			retour = retour.valueOf(str);
			tabString[i] = retour;
			i++;
		}
		return tabString;
	}
}
