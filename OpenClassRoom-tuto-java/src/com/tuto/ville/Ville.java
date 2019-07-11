package com.tuto.ville;
import java.util.Objects;

/**
 * @author lourdel
 *
 */
public class Ville  {
	/**
	 * Variables de classe donc statiques, utilisées que dans le contexte de cette classe.
	 * Les methodes qui les utilisent sont donc elles aussi statiques.
	 */
	public static int NbInstances;
	protected static int NbInstancesBis;
	/**
	 * Variables d'instance
	 */
	protected String nomVille;
	protected String nomPays;
	protected int nbHabitants;
	protected char categorie;

	/**
	 * Constructeur par défaut
	 */
	public Ville() {
//		System.out.println("Création d'une ville !");
		nomVille = "inconnu";
		nomPays = "inconnu";
		nbHabitants = 0;
		NbInstances++;
		NbInstancesBis++;
		this.setCategorie(nbHabitants);

	}
	/**
	 * Constructeur surchargé
	 * @param pnomVille
	 * @param pnomPays
	 * @param pnbHabitants
	 */
	public Ville(String pnomVille, String pnomPays, int pnbHabitants) 
		throws NomVilleException, NbHabitantException
		{
			if(pnomVille.length() < 3)
				throw new NomVilleException("Nom de ville trop petit !");
			if(pnbHabitants < 0)
				throw new NbHabitantException(pnbHabitants);
			else {
	//				System.out.println("Création d'une ville avec paramètres !");
				nomVille = pnomVille;
				nomPays = pnomPays;
				nbHabitants = pnbHabitants;
				this.setCategorie(nbHabitants);
	//				System.out.println(this.decrisToi());
				NbInstances++;
				NbInstancesBis++;				
			}
		}

	// Accesseurs :
	public static int getNbInstancesBis() {
		return NbInstancesBis;
	}

	public String getNomVille() {
		return nomVille;
	}

	public String getNomPays() {
		return nomPays;
	}

	public int getNbHabitants() {
		return nbHabitants;
	}

	public char getCategorie() {
		return categorie;
	}

	// Mutateurs
	public void setNomVille(String nom) {
		nomVille = nom;
	}

	public void setNomPays(String nom) {
		nomPays = nom;
	}

	public void setNbHabitants(int nb) {
		nbHabitants = nb;
		this.setCategorie(nbHabitants);
	}
	/**
	 * Methode d'instance, appelée par le constructeur et par setNbHabitants.
	 * @param nbHabitants
	 */
	protected void setCategorie(int nbHabitants) {
		int[] tabNbHabitants = { 0, 100, 1000, 10_000, 100_000, 1_000_000 };
		char[] tabCategories = { 'F', 'E', 'D', 'C', 'B', 'A' };

		categorie = '?';
		int i = 0;
		while (i < tabNbHabitants.length && nbHabitants > tabNbHabitants[i]) {
			categorie = tabCategories[i];
			i++;
		}
	}
	/**
	 * Description d'une Ville
	 * @return String retourne la description de l'objet Ville
	 */
	public String decrisToi() {
		return "\t" + this.getNomVille() + " est une ville de " + this.getNbHabitants()
				+ " habitants elle est donc de catégorie " + this.getCategorie();
	}	
	/**
	 * Compare le nb d'habitants avec ceux d'une autre ville
	 * @param v2
	 * @return String Donne la ville la plus peuplée
	 */
	public String comparer(Ville v2) {
		if (this.nbHabitants > v2.getNbHabitants()) {
			return this.nomVille + " est plus grand que " + v2.getNomVille();
		} else {
			return v2.getNomVille() + " est plus grand que " + this.nomVille;
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "\t" + this.getNomVille() + " est une ville de " + this.getNbHabitants()
		+ " habitants elle est donc de catégorie " + this.getCategorie();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		  return Objects.hash(categorie, nbHabitants, nomPays, nomVille);
		}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		  //On vérifie si les références d'objets sont identiques
		  if (this == obj)
		    return true;

		  //On s'assure que les objets sont du même type, ici de type Ville
		  if (getClass() != obj.getClass())
		    return false;
			
		  //Maintenant, on compare les attributs de nos objets
		  Ville other = (Ville) obj;

		  return Objects.equals(other.getCategorie(), this.getCategorie()) &&
			 Objects.equals(other.getNomVille(), this.getNomVille()) &&
			 Objects.equals(other.getNbHabitants(), this.getNbHabitants()) &&
			 Objects.equals(other.getNomPays(), this.getNomPays());
		}

}