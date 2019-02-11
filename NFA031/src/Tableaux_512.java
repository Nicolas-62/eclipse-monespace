import fr.perso.mesclasses.*;

public class Tableaux_512 {
	
	//Saisie tableau de char et calcul plus grand tableau
	public static void question3() {
		char[] tab = new char[6];
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','z'};
		int indiceAlphabet=-1;
		int indiceAscii=0;
		int indiceTab=0;
		char lettre, lettrePlusGrande=' ';
		// Remplissage du tableau de caractères par l'utilisateur :
		Out.p("saisissez les 6 caractères qui vont remplir le tableau");		
		for(int k=0; k<tab.length; k++) {
			Out.p("Veuillez saisir le caractère "+k+" : ");
			lettre=Clavier.readChar();
			tab[k]=lettre;
			//comparaison du code ascii de la nouvelle lettre tapée avec la précedente :
			if(k>0) {
				if((int)tab[indiceAscii]<(int)tab[k]) {					
					indiceAscii=k;
				}
			}			
			// Variante : a chaque saisie de lettre on recherche la lettre dans l'alphabet
			for(int i=0; i<alphabet.length; i++) {
				//si la lettre est la plus grande on l'enregistre ainsi que l'indice auquel on l'a trouvé dans l'alphabet
				if(alphabet[i]==lettre && indiceAlphabet<i) {
					indiceAlphabet=i;
					lettrePlusGrande=lettre;
				}
			}		
		}
		//recherche indice du tableau saisie qui contient la lettre la plus grande :
		int g=0;
		while(g<tab.length) {
			if(tab[g]==lettrePlusGrande) {
				indiceTab=g;
			}
			g++;
		}
		//afficher tableau  et indice
		for(int j=0; j<tab.length; j++) {
			System.out.print("indice : "+j+" : "+tab[j]+"  ");
		}
		Out.p();
		Out.p("la plus grande lettre est à l'indice : "+indiceAscii);
	}
	public static void main(String args[]) {
		question3();
	}
}
