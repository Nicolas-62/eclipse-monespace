package com.tuto.genericite;

public class Solo {
	
	private Object valeur;
	
	Solo(){
		
	}
	Solo(Object val){
		setValeur(val);
	}

	protected void setValeur(Object val) {
		this.valeur = val;
	}
	protected Object getValeur() {
		return this.valeur;
	}
	
}
