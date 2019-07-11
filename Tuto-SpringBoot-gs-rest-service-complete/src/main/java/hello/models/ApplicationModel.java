package hello.models;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

/* cette annotation signifie que la classe sera géré par Spring 
 * la nature par defaut des composants Spring est de type singleton :
 * le composant est créé en un unique exemplaire lorsque le conteneur Spring est
 * instancié cad au démarrage de l'application.
 * Nous pouvons utiliser ce cycle de vie pour stocker dans le singleton des informations
 * de configuration qui seront accessibles à tous les utlisateurs
 */
@Component
public class ApplicationModel {
	
	private AtomicLong compteur = new AtomicLong(0);

	/* AtomicLong :
	 * Ce type a une méthode [incrementAndGet] dite atomique. Cela signifie
qu'un thread qui exécute cette méthode est assuré qu'un autre thread ne lira pas la valeur du compteur (Get) entre sa
lecture (Get) et son incrément (increment) par le 1er thread, ce qui provoquerait des erreurs puisque deux threads liraient
la même valeur du compteur, et celui-ci au lieu d'être incrémenté de deux le serait de un ;
	 */
	public AtomicLong getCompteur() {
		return compteur;
	}

	public void setCompteur(AtomicLong compteur) {
		this.compteur = compteur;
	}
}
