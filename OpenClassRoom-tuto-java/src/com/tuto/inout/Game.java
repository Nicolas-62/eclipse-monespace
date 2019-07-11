package com.tuto.inout;

import java.io.Serializable;

public class Game implements Serializable{

		private String nom;
		private String type;
		private double prix;
		  //Maintenant, cette variable ne sera pas sérialisée
		  //Elle sera tout bonnement ignorée !
		  private transient Notice notice;
		
		public Game(String nom, String type, double prix) {
			this.nom = nom;
			this.type = type;
			this.prix = prix;
			this.notice = new Notice();
		}
		public String toString() {
			return "Nom du jeu : " +this.nom+ "\n"
					+"Type de jeu : "+this.type+"\n"
					+"Prix du jeu : "+this.prix;
		}
}
