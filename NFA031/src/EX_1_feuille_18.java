import fr.perso.mesclasses.Out;

public class EX_1_feuille_18 {

	public static void afficherHeure(int min) {
		int heures = min/60;
		int minutes = min%60;
		Out.p("Il est "+heures+"h"+minutes+"min");
	}
	public static void afficherDate(int min) {
		int jours = min/(24*60);
		min = min-(jours*24*60);
		int heures = min/60;
		int minutes = min%60;
		Out.p("Ca fait "+jours+"j"+heures+"h"+minutes+"min");
	}
	public static void main(String[] args) {
		afficherHeure(48);
		afficherDate(48);
	}

}
