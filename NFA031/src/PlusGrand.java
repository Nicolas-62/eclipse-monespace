import java.util.Scanner;

import fr.perso.mesclasses.Clavier;
import fr.perso.mesclasses.Out;

public class PlusGrand {

	public static void main(String[] args) {
		char sup, moy,min;
		Scanner sc = new Scanner(System.in);
		Out.p("Entrez 3 valeurs distinctes : ");
		Out.p("a");
		char a =Clavier.readChar();
		Out.p("b");
		char b =Clavier.readChar();
		Out.p("c");
		char c =Clavier.readChar();
		
		if(a>b) {
			if(b>c) {
				sup=a;moy=b;min=c;
			}
			else {
				if (c>a) {
					sup=c;moy=a;min=b;
				}
				else {
					sup=a;moy=c;min=b;
				}
			}
		}else {
			if(b<c) {
				sup=c;moy=b;min=a;
			}
			else{
				if (a>c) {
					sup=b;moy=a;min=c;
				}
				else {
					sup=b;moy=c;min=a;
				}
			}
		}
		Out.p(sup+" > "+moy+" > "+min);
		

	}

}
