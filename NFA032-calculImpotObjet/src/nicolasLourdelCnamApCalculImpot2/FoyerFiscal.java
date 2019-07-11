package nicolasLourdelCnamApCalculImpot2;

import java.text.DecimalFormat;
/**
 * Classe FoyerFiscal
 * @author lourdel
 *
 */
public class FoyerFiscal {
		/**
		 * attributs
		 */
		private double revenuNetImposable;
		private int  statut;
		private int nbEnfant;
		private double quotientFamilial;
		private double impot;
		private static double[][] tabQuotientFam = {	{1, 2}, {1.5, 2.5}, {2, 3}, {3, 4}, {4, 5}	};
		private static double[] plafond = {9_807, 	27_086, 	72_617, 	153_783};
		private static double[] taux =	  {0,		0.14,		0.30 ,		0.41 ,	0.45};	
		/**
		 * Constructeur par défaut
		 */
		public FoyerFiscal() {
		}
		/**
		 * Constructeur surchargé
		 * @param revenu : revenu net imposable
		 * @param statut : situation maritale
		 * @param nbEnfant : nombre d'enfants à charge
		 */
		public FoyerFiscal(int revenu, int statut, int nbEnfant) throws RevenuException{
			if(revenu ==0) {
				throw new RevenuException();
			}else {
				this.setRevenu(revenu);
			}
			this.setStatut(statut);
			this.setNbEnfant(nbEnfant);
			this.setQuotientFamilial(this.getNbEnfant(), this.getStatut());
			this.setImpot(this.getRevenu(), this.getQuotientFamilial(), plafond, taux);
		}
		// getters
		public double getRevenu() { return this.revenuNetImposable;}
		public int getStatut() {return this.statut;}
		public int getNbEnfant() {return this.nbEnfant;}
		public double getQuotientFamilial() {return this.quotientFamilial;}
		public double getImpot() {return this.impot;}
		public static double[][] getTabQuotientFam(){return tabQuotientFam;}
		public static double[] getPlafond(){return plafond;}
		public static double[] getTaux(){return taux;}
		// setters
		public void setRevenu(double revenu) {this.revenuNetImposable = revenu;}
		public void setStatut(int statut) {this.statut = statut;}
		public void setNbEnfant(int nbEnfant) {this.nbEnfant = nbEnfant;}
		/**
		 * Fonction qui déduit le quotient familial.
		 * @param nbEnfant : nombre d'enfants à charge
		 * @param statut : statut marital
		 */
		public void setQuotientFamilial(int nbEnfant, int statut ) {
			if(nbEnfant<tabQuotientFam.length) {
				this.quotientFamilial = tabQuotientFam[nbEnfant][statut];
			}else {
				this.quotientFamilial = tabQuotientFam[tabQuotientFam.length-1][statut] + (nbEnfant-(tabQuotientFam.length-1));
			}	
		}
		/**
		 * Fonction qui calcul le montant de l'impôt.
		 * @param revenu : revenu net imposable
		 * @param quotientFam : quotient familial
		 * @param plafond : plafonds de revenu
		 * @param taux : taux appliqués à chaque plafond
		 */
		public void setImpot(double revenu, double quotientFam, double[] plafond, double[] taux) {
			// Il faut dabord diviser le revenu net imposable par le nombre de parts du quotient familial			
			revenu = revenu / quotientFam;
			/* Il faut ensuite calculer le montant de l'impot pour chaque tranche inférieur au revenu 
			/* puis celle dans laquelle se trouve le revenu			 
			 */
			double impot =0;
			if(revenu<plafond[0]) {
				impot = revenu*taux[0];
			}else {
				// Calcul première tranche
				impot = plafond[0]*taux[0];
				// Calcul tranches suivantes
				for(int i=1; i<plafond.length; i++) {
					if(revenu<plafond[i]) {
						// Calcul dernière tranche (celle dans laquelle est le revenu)
						impot += (revenu-plafond[i-1])*taux[i];
						break;
					}else {
						// Calcul tranches précedentes du revenu
						impot += (plafond[i]-plafond[i-1])*taux[i];
						// Calcul revenu supérieur à la dernière tranche
						if(i == plafond.length-1) {
							impot += (revenu-plafond[i])*taux[i+1];
						}
					}
				}
			}
			// Enfin multiplier le résultat par le nombre de parts du quotient familial
			impot = impot*quotientFamilial;	
	        // Mise à jour de l'attribut impot :
	        this.impot = impot;
		}	
		/**
		 * fonction qui décrit l'objet et donne les valeurs de ses attributs
		 */
		public String toString() {
			// Formatage de l'impôt pour affichage
			DecimalFormat df = new DecimalFormat("0.00");
	        String impot = df.format(this.getImpot());
	        // affichage des attributs de l'objet
			String str = "Ce foyer fiscal a le statut : ";
			str += (statut == 0) ? "Célibataire, divorcé ou veuf." : "marié ou pacsé."; 
			str += "\n";
			str += "Il possède "+this.getNbEnfant()+" enfants.";
			str += "\n";
			str += "Son quotient familial vaut : "+this.getQuotientFamilial();
			str += "\n";
			str += "Son revenu net imposable vaut : "+this.getRevenu()+" €";
			str += "\n";
			str += "Le montant de son impôt est de : "+impot+" €";
			return str;
		}
}
