package com.pilote.cours;

public class Avion implements Pilotable{
	
	private Moteur moteur;
	private CapteurAltitude capteurAltitude;

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
}
