package com.tuto.ville;

/**
 * @author lourdel
 *
 */
public class Capitale extends Ville{
	
	private String monument;

	public Capitale() {
		// Appelle le constructeur par défault de la classe mère;
		super();
		monument = "Ma bite";
	}
	/**
	 * Constructeur d'initialisation de Capitale
	 * @param nom
	 * @param pays
	 * @param hab
	 * @param monument
	 * @throws NbHabitantException 
	 * @throws NomVilleException 
	 */
	public Capitale(String nom, String pays, int hab, String monument) 
		throws NomVilleException, NbHabitantException { 
		
			super(nom, pays, hab);
			this.monument = monument;
		}
	
	
	/* (non-Javadoc)
	 * @see Ville#decrisToi()
	 * @return String retourne la description de l'objet Capitale
	 */
	public String decrisToi() {
		String str = super.decrisToi() + "\n" + this.monument +" en est un monument.";
		return str;
	}
	/* (non-Javadoc)
	 * @see Ville#toString()
	 */
	public String toString() {
		String str = super.toString() + "\n" + this.monument +" en est un monument.";
		return str;		
	}
	
	/**
	 * @return String retourne le monument de la Capitale 
	 */
	public String getMonument() {
		return monument;
	}
	/**
	 * Mutateurs
	 * @param monument
	 */
	public void setMonument(String monument) {
		this.monument = monument;
	}
}
