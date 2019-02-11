package com.tuto.ville;
import fr.perso.mesclasses.Out;
public class NbHabitantException extends Exception {
		public NbHabitantException(int NbHab) {
			Out.p("Vous essayez de créer un ville avec un nombre d'habitants négatif !");
			Out.p("Vous avez rentré : "+NbHab);
		}
}
