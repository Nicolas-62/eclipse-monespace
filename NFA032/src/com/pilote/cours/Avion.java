package com.pilote.cours;

public class Avion implements Pilotable, GestionnaireRadio{
	
	private Moteur moteur;
	private CapteurAltitude capteurAltitude;
	
	Avion(){
		this.moteur = new Moteur();
		this.capteurAltitude = new CapteurAltitude();
	}

	public void emettreSignalradio() {
		System.out.println("Signal radio...");
	}
	public long getPuissance() { 
		return moteur.getPuissance(); 
	}
	public void setPuissance(long puissance) {
		moteur.setPuissance(puissance); 
	}
	public long getAltitude() { 
		return capteurAltitude.getAltitude();
	}
	public void sortirTrainAtterrissage() { /* code */ }
	public void rentrerTrainAtterrissage() { /* code */ }
	public void inclinerVolets(long angle) { /* code */ }
	public void setPositionManche(long position) { /* code */ }
	public void virer(long angle) { /* code */ }
	public void alert() {
	}
}
