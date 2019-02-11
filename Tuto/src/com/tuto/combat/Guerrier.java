package com.tuto.combat;
import fr.perso.mesclasses.Out;
import com.tuto.comportement.*;

public class Guerrier extends Personnage{

	public Guerrier() {
		this.espritCombatif = new CombatCouteau();
	}
	public Guerrier(EspritCombatif combat, Deplacement dep, Soin soin) {
		this.deplacement = dep;
		this.espritCombatif = combat;
		this.soin = soin;
	}
	

}
