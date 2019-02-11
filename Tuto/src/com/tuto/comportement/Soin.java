package com.tuto.comportement;
@FunctionalInterface

public interface Soin {
	public void soigner();
	// Une interface fonctionnelle n'a qu'une seule methode abstraite
//	public String operer(int i) {
//		return "Tout est OK !";
//	}
// Elle peut par contre contenir d'autres methodes si elles sont par defaut
	public default String operer(int i) {
		return "Tout est OK !";
	}	
}
