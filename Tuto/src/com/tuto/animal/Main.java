package com.tuto.animal;

import fr.perso.mesclasses.Out;

public class Main {

	public static void main(String[] args) {
//		Chat guizmo = new Chat("roux", 5);
//		System.out.println(guizmo);
//		guizmo.crier();
//		guizmo.deplacement();
//		guizmo.manger();
//		Animal.parler();
		int i=20, j=0;
		try {
			Out.p(i/j);
		}catch (ArithmeticException e) {
			Out.p("Division par 0 !"+e.getMessage());
		}
		Out.p("salut "+i);
		
		Chien c = new Chien();
		c.faireLeBeau();
		Out.p();
		Rintintin r = new Chien();
		r.faireLeBeau();
	}

}
