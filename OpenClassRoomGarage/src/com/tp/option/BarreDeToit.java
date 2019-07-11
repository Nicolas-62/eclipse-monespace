package com.tp.option;

import java.io.Serializable;

public class BarreDeToit implements Option, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7911864335994289599L;
	protected Double prix = 29.9;
	
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix=prix;
	}
	public String toString() {
		String str;
		str="Barre de toit ("+this.prix+" €)";
		return str;
	}
}
