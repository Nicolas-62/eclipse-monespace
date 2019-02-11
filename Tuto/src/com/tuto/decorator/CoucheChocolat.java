package com.tuto.decorator;

public class CoucheChocolat extends Couche {

	public CoucheChocolat(Patisserie pat) {
		super(pat);
		this.nom = "\n Une couche de chocolat \n";
	}
}
