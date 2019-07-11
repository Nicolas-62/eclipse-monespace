package com.tuto.decorator;

import fr.perso.mesclasses.Out;

public class Main {

	public static void main(String[] args) {
		Patisserie mongateau = new CoucheChocolat(
									new CoucheCaramel(
										new CoucheBiscuit(
												new CoucheChocolat(
														new Gateau()))));	
		Out.p(mongateau.preparer());
	}

}
