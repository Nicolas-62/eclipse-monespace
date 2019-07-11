package com.tp.option;

import java.io.Serializable;

public class GPS implements Option, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3568152266494676334L;
	protected Double prix = 113.5;
	
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix=prix;
	}
	public String toString() {
		String str;
		str="GPS ("+this.prix+" €)";
		return str;
	}
}
