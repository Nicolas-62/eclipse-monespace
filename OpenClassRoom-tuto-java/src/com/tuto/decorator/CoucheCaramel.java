package com.tuto.decorator;

public class CoucheCaramel extends Couche{
	public CoucheCaramel(Patisserie pat) {
		super(pat);
		this.nom = "\n Une couche de caramel \n";
	}

}
