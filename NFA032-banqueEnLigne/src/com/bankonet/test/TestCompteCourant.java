package com.bankonet.test;
import com.bankonet.CompteCourant;

public class TestCompteCourant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompteCourant unCompte1 = new CompteCourant("217600", "PEL", 1235.7,500);
		CompteCourant unCompte2 = new CompteCourant("395600", "LivretA", 8000, 1500);
		CompteCourant unCompte3 = new CompteCourant("475882", "CompteCourant", 4987.3,2000);
		
		CompteCourant[] compteCourantTab = new CompteCourant[3];
		compteCourantTab[0]=unCompte1;
		compteCourantTab[1]=unCompte2;
		compteCourantTab[2]=unCompte3;
		
		for(int i=0; i<compteCourantTab.length; i++) {
			System.out.println(compteCourantTab[i]);
		}
		
		for(CompteCourant compte : compteCourantTab) {
			System.out.println(compte);
		}
	}

}
