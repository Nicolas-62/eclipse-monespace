package com.tuto.interfaces;

public class InterfaceTuto {
	
	public interface Reproduction {

		public static void description() {
			System.out.println("Méthode statique dans une interface");
		}
		
	}
	
	public interface Mitose extends Reproduction {
		public static void description() {
			Reproduction.description();
			System.out.println("Redéfinie dans Mitose.java");
		}
		
		default void reproduire() {
			System.out.println("Je me divise !");
		}
	}

	public interface Pondre extends Reproduction {

		public static void description() {
			Reproduction.description();
			System.out.println("Redéfinie dans Pondre.java");
		}

		
		default void reproduire() {
			System.out.println("Je ponds des oeufs !");
		}
		
	}



	static class Alien implements Pondre, Mitose {

		public void reproduire() {
			
			System.out.println("Je suis un alien et :");
			Pondre.super.reproduire();
			Mitose.super.reproduire();

		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alien unAlien = new Alien();
		unAlien.reproduire();
		

	}

}
