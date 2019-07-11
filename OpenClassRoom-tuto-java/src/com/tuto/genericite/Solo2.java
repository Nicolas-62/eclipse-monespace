package com.tuto.genericite;

public class Solo2<T> {
	 
	  //Variable d'instance
	  private T valeur;
	        
	  //Constructeur par défaut
	  public Solo2(){
	    this.valeur = null;
	  }

	  //Constructeur avec paramètre inconnu pour l'instant
	  public Solo2(T val){
	    this.valeur = val;
	  }
	        
	  //Définit la valeur avec le paramètre
	  public void setValeur(T val){
	    this.valeur = val;
	  }
	        
	  //Retourne la valeur déjà « castée » par la signature de la méthode !
	  public T getValeur(){
	    return this.valeur;
	  }       
	}