package com.tuto.combat;
import com.tuto.comportement.*;

import fr.perso.mesclasses.Out;

public class Main {

	public static void main(String[] args) {
		// Covariance une variable objet peut contenir d'un objet qui hérite de sa classe
		Personnage[] pers = {new Chirurgien(),new Guerrier()};
		for(Personnage p : pers) {
			Out.p(p.toString());
			Out.p("\n Instance de "+p.getClass().getName());
			p.seDeplacer();
			p.combattre();
			Out.p("*************** \n");
		}
		Guerrier conan = new Guerrier(new CombatPistolet(), new Courir(), new AucunSoin());
		Out.p("\n Instance de "+conan.getClass().getName());
		conan.combattre();
		conan.seDeplacer();
		conan.soigner();
		conan.setArme("Pistolet");	
		conan.setSoin(new Operation());
		conan.soigner();
		// utilisation d'une classe anonyme pour redéfinir le comportement
		conan.setSoin(new Soin() {
			public void soigner() {
				Out.p("Je soigne avec une classe anonyme !");
			}
		});
		conan.soigner();
		// utilisation d'une classe anonyme pour redéfinir le comportement
		conan.setDialoguer(new Dialoguer() {
			public void parler(String question) {
				Out.p("Tu as dit : "+question);
			}
		});
		conan.parler("Bonjour à tous !");
		// redéfinition du comportement mais avec une lambda
		conan.setDialoguer((s)-> Out.p("Nous avons dit : "+ s));
		conan.parler("Bonjour à tous !");

	}

}
