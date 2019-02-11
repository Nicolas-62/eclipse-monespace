package com.tuto.combat;
import com.tuto.comportement.*;

public abstract class Personnage {
	
	protected String armes="", chaussure="", sacDeSoin="";
	
	protected EspritCombatif espritCombatif = new Pacifiste();
	protected Deplacement deplacement = new Marcher();
	protected Soin soin = new AucunSoin();
	protected Dialoguer dialoguer;
	// Constructeur par defaut
	public Personnage() {};
	// Constructeur avec paramètres
	public Personnage(EspritCombatif espritCombatif, Deplacement deplacement, Soin soin) {
		this.espritCombatif = espritCombatif;
		this.deplacement = deplacement;
		this.soin = soin;
		
	}	
	public void seDeplacer() {
		deplacement.deplacer();
	}
	public void combattre() {
		espritCombatif.combat();
	}
	public void soigner() {
		soin.soigner();
	}
	public void parler(String question) {
		dialoguer.parler(question);
	}
	protected void setDialoguer(Dialoguer dialoguer) {
		this.dialoguer = dialoguer;
	}
	// redéfinit le comportement de déplacement
	protected void setDeplacement(Deplacement deplacement) {
		this.deplacement = deplacement;
	}
	protected void setCombat(EspritCombatif espritCombatif) {
		this.espritCombatif = espritCombatif;
	}
	protected void setSoin(Soin soin) {
		this.soin = soin;
	}
	protected void setArme(String armes) {
		this.armes = armes;
	}
	protected void setChaussure(String chaussure) {
		this.chaussure = chaussure;
	}
	protected void setSacDeSoin(String sacDeSoin) {
		this.sacDeSoin = sacDeSoin;
	}
}
