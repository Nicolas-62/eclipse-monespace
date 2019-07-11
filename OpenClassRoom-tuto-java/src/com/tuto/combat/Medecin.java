package com.tuto.combat;

import fr.perso.mesclasses.Out;

public class Medecin extends Personnage {
	public void seDeplacer() {
		Out.p("Je me deplace à pied.");
	}
	public void combattre() {
		Out.p("Je combat avec une serpe");
	}
	public void soigner() {
		Out.p("Je soigne les blessures");
	}
}
