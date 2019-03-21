package com.exception.cnam;

public class sameMailException extends UtilisateurException{
	public sameMailException() {
		super("cet email existe déjà");
	}
	public sameMailException(String msg) {
		super(msg);
	}
}
