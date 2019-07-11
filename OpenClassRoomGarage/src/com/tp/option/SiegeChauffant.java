package com.tp.option;

import java.io.Serializable;

public class SiegeChauffant implements Option, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1481972558802427800L;
	protected Double prix = 562.9;
	
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix=prix;
	}
	public String toString() {
		String str;
		str="Siège chauffant ("+this.prix+" €)";
		return str;
	}
}
