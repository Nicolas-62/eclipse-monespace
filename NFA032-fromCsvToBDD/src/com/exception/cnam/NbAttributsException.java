package com.exception.cnam;

public class NbAttributsException extends UtilisateurException{
	public NbAttributsException() {
		super("format incorrect : manque un élément dans la ligne");
	}

}
