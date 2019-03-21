package com.exception.cnam;

public class SexeException extends UtilisateurException{
	public SexeException() {
		super("la valeur de sexe est incorrecte => valeur autorisée (M ou F)");
	}
	
}
