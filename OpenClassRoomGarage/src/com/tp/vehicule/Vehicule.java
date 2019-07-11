package com.tp.vehicule;
import com.tp.option.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tp.moteur.*;

public abstract class Vehicule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2423073485096138799L;
	protected Marque nomMarque;
	protected String nom;
	protected Moteur moteur;
	protected List<Option> options;
	// prix moteur + prix options
	protected Double prix = 0.0;
	
	Vehicule(){}
	
	public String toString() {
		String str = "Voiture "+this.nomMarque+" : "+this.nom+
					this.moteur.toString()+this.getOptions()+
					" d'une valeur totale de : "+this.getPrix()+" €";
		return str;
	}
	public Marque getMarque() {
		return this.nomMarque;
	}
	public void setMoteur(Moteur moteur) {
		// quand on ajoute le moteur au véhicule cette action réinitialise
		// le prix du véhicule et les options
		this.moteur = moteur;
		this.options = new ArrayList<Option>();
		this.prix = moteur.getPrix();		
	}
	public void addOption(Option opt) {
		this.options.add(opt);
		// a chaque fois qu'on ajoute une option on modifie le prix de la voiture
		this.prix += opt.getPrix();
	}
	public List<Option> getOptions(){
		return this.options;
	}
	public Double getPrix() {
		return this.prix;
	}

}
