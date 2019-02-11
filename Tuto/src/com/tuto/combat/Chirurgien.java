package com.tuto.combat;

import com.tuto.comportement.*;


public class Chirurgien extends Personnage{
	public Chirurgien() {
		this.soin = new Operation();
	}
	public Chirurgien(EspritCombatif combat, Deplacement dep, Soin soin) {
		this.deplacement = dep;
		this.espritCombatif = combat;
		this.soin = soin;
	}
}
