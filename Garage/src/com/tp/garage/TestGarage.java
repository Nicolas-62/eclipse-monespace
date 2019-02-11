package com.tp.garage;
import com.tp.moteur.*;
import com.tp.option.*;
import com.tp.vehicule.*;
import fr.perso.mesclasses.*;
public class TestGarage {

	public static void main(String[] args) {
		/* Creation du garage. 
		 * Lors de la création, récuperation des voitures du garage enregistré
		 * dans le fichier si il existe.
		 */
		Garage garage = new Garage();
		// Premier lancement du garage, affichage du garage
		Out.p(garage);
		// création voiture
		Clio c = new Clio();
		c.setMoteur(new MoteurEssence("160ch", 15200d));
		c.addOption(new BarreDeToit());
		c.addOption(new GPS());
		// création voiture
		Celerio cel = new Celerio();
		cel.setMoteur(new MoteurHybride("68ch", 7300d));
		cel.addOption(new VitreElectrique());
		cel.addOption(new BarreDeToit());
		cel.addOption(new GPS());
		/* Ajout des voitures au garage, enregistrement du garage dans le fichier
		 * "garage.txt" à chaque ajout de voiture.
		 */
		garage.add(c);
		garage.add(cel);
		/* Nouvelle instance donc récupération des voitures du garage enregistré
		 * dans "garage.txt"
		 */
		Garage garage2 = new Garage();
		// Affichage du garage
		Out.p(garage2); 		
		// création voiture
		Baleno b = new Baleno();
		b.setMoteur(new MoteurDiesel("100ch", 13400d));
		c.addOption(new GPS());
		c.addOption(new SiegeChauffant());
		c.addOption(new VitreElectrique());
		// ajout voitures au garage
		garage2.add(b);
		/* Nouvelle instance donc récupération des voitures du garage enregistré.
		 */		
		Garage garage3 = new Garage();
		// affichage du garage
		Out.p(garage3); 
	}
}
