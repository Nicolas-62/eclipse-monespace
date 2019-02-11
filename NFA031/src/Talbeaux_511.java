import fr.perso.mesclasses.*;

public class Talbeaux_511 {
	
	// Question 5
	public static void echangerIndice(int i1, int i2, int[] tab) {
		for(int i=0; i<tab.length; i++) {
			System.out.print(i+" : "+tab[i]+"  ");
		}
		Out.p();
		int[] tabnew = new int[tab.length];
		tabnew[i1]=tab[i2];
		tabnew[i2]=tab[i1];
		for(int i=0; i<tabnew.length; i++) {
			if(i!=i1 && i!= i2) {
				tabnew[i] = tab[i];
			}
			System.out.print(i+" : "+tabnew[i]+"  ");
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tab = {12,15,13,10,8,9,13,14};	
		
		Out.p("Ex3 veuillez saisir un nombre : ");
		double nombreEssai = Clavier.readDouble();
		boolean flag=false;
		for(int i=0; i<tab.length; i++) {
			if(tab[i]==nombreEssai) {
				flag=true;
			}
		}
		if(flag) {
			Out.p("oui");
		}else {
			Out.p("non");
		}
		System.exit(1);
		
		
		//Question 5 :
		Out.p("Veuillez saisir deux indices :");
		Out.p("Premier indice :");
		int indiceTab1 = Clavier.readInt();
		Out.p("deuxième indice :");
		int indiceTab2 = Clavier.readInt();
		echangerIndice(indiceTab1, indiceTab2, tab);
		System.exit(1);
		
		//Question 1, 2 : 
		Out.p("veuillez saisir un nombre : ");
		double nb = Clavier.readDouble();
		int i=0;
		int indice= -1;
		while(i<tab.length) {			
			if(tab[i]==nb)
				indice = i;				
			i++;
		}
		
		if(indice>=0)
			Out.p("Ce nombre appartient au tableau on le trouve en dernier à l'indice : "+indice);
		else {
			Out.p("Ce nombre n'appartient pas au tableau");
		}
		//Question 3 : 
		Out.p("Ex3 veuillez saisir un nombre : ");
		double nb3 = Clavier.readDouble();
		int i3=0;
		int indice3= -1;
		while(i3<tab.length && indice3==-1) {			
			if(tab[i3]==nb3)
				indice3 = i3;		
			i3++;
		}
		if(indice3>=0)
			Out.p("Ce nombre appartient au tableau on le trouve à l'indice : "+indice3);
		else {
			Out.p("Ce nombre n'appartient pas au tableau");
		}
	}
}
