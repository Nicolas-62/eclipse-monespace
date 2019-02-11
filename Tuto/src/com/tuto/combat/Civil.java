package com.tuto.combat;

import fr.perso.mesclasses.Out;

public class Civil extends Personnage{
	public void seDeplacer() {
		Out.p("Je me deplace à pied.");
	}
	public void combattre() {
		Out.p("Je ne conbat pas !");
	}
}
