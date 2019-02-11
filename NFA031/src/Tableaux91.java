import fr.perso.mesclasses.*;

public class Tableaux91 {
	
	public static int[][] saisieTableauVentes(String[] vendeurs, String[] modeles) {
		System.out.println("\n Saisie des Ventes : \n");
		// tableau de n lignes de vendeurs et n colonnes de modèles
		int[][] tab = new int[vendeurs.length][modeles.length];
		for(int i=0; i<vendeurs.length; i++) {
			Out.p("Veuillez saisir les ventes de "+vendeurs[i]+" : ");
			for(int j=0; j<modeles.length; j++) {
				System.out.print(modeles[j]+" : ");
				tab[i][j] = Clavier.readInt();
			}
		}
		return tab;
	}
	public static void affichageVentes(String[] vendeurs, String[] modeles, int[][] ventes) {
		System.out.println("\n Affichage Ventes : \n");
		// Affichage du nom des modèles
		System.out.print("\t\t");
		for(String m : modeles)
			System.out.print(m+"\t");
		Out.p();
		// Affichage du nom des vendeurs
		for(int i=0; i<ventes.length; i++) {
			System.out.print(vendeurs[i]+"\t:\t");
			//Affichage des ventes de chaque vendeur
			for(int j=0; j<ventes[i].length; j++) {
				System.out.print(ventes[i][j]+"\t");			
			}
			Out.p();
		}			
	}
	public static void affichageVentesParModeles(String[] modeles, int[][] ventes, int nbVendeurs) {
		System.out.println("\n Affichage Ventes par modèles : \n");
		int totalVentesModele;
		for(int i=0; i<modeles.length; i++) {
			totalVentesModele = 0;
			System.out.print("Ventes de "+modeles[i]+":\t");
			for(int k=0; k<nbVendeurs; k++) {
				totalVentesModele += ventes[k][i];
			}
			System.out.println(totalVentesModele);
		}
	}
	public static void afficheCAVendeur(String[] vendeurs, int[][] ventes, int[] prixModele, int nbModeles) {
		System.out.println("\n Affichage chiffre d'affaire par vendeur : \n");
		int chiffreAffaire;
		for(int i=0; i<vendeurs.length; i++) {
			chiffreAffaire = 0;
			System.out.print("CA "+vendeurs[i]+" : \t");
			for(int j=0; j<nbModeles; j++) {
				chiffreAffaire += ventes[i][j]*prixModele[j];
			}
			System.out.println(chiffreAffaire);
		}
	}
	
	public static void main(String[] args) {
		
		String[] vendeurs = {"andre","ingemar","cindy","joey"};
//		String[] vendeurs = {"andre"};
		String[] modeles = {"twingo","clio  ","megane","vel_satis"};
		int ventes[][] = {{1,2,1,4},{2,2,2,2},{1,1,1,1},{3,3,2,1}};
//		int ventes[][] = {{1,5,3,2}};

//		int[][] ventes = saisieTableauVentes(vendeurs, modeles);
		affichageVentes(vendeurs, modeles, ventes);	
		affichageVentesParModeles(modeles, ventes, vendeurs.length);
		int[] prixModele = {10_000,12_000,15_000,30_000};
		afficheCAVendeur(vendeurs, ventes, prixModele, modeles.length);
		
	}
}
