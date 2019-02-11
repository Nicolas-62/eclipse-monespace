package com.tp.option;

import java.io.Serializable;

public class VitreElectrique implements Option, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4024779432620677701L;
	protected Double prix = 212.35;
	
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix=prix;
	}
	public String toString() {
		String str;
		str="Vitre electrique ("+this.prix+" €)";
		return str;
	}
}
