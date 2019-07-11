package com.bankonet;

public final class CompteCourant extends Compte{

		private double montantDecouvertAutorise;
//		public static int nbComptesCourants=0;
		
		public CompteCourant(String unNumero, String unIntitule, double unSolde, double unMontantDecouvertAutorise) {
			super(unNumero, unIntitule, unSolde);
			this.montantDecouvertAutorise=unMontantDecouvertAutorise;
//			nbComptesCourants++;
		}
		public boolean debitAutorise(double montant) {
			if(this.getSolde()-montant<this.montantDecouvertAutorise) {
				return false;
			}else {
				return true;
			}
		}
		public String toString() {
			String str =super.toString();
			str+="montant decouvert autorisé : "+this.montantDecouvertAutorise+"\n";
			return str;						
		}
		public double getMontantDecouvertAutorise() {
			return montantDecouvertAutorise;
		}
		public void setMontantDecouvertAutorise(double montantDecouvertAutorise) {
			this.montantDecouvertAutorise = montantDecouvertAutorise;
		}		
		
}
