package com.tuto.decorator;

public class CoucheBiscuit extends Couche {
	public CoucheBiscuit(Patisserie pat) {
		super(pat);
		this.nom = "\n Une couche de biscuit \n";
	}
}
