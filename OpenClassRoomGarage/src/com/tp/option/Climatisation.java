package com.tp.option;

import java.io.Serializable;

public class Climatisation implements Option, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -719947273182529177L;
	protected Double prix = 347.3;
	
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix=prix;
	}
	public String toString() {
		String str;
		str="Climatisation ("+this.prix+" €)";
		return str;
	}
}
