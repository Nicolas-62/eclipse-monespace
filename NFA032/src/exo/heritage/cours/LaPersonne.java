package exo.heritage.cours;

public class LaPersonne {

	LaDate naissance;
	String nom;
	/* il faut réécrir le constructeur par défaut sinon dans les classes fille il faudra
	 * obligatoirement rappeler celui avec les paramètres
	 */
	public LaPersonne() {};
	public LaPersonne(String name, LaDate naiss) {
		this.nom = name;
		this.naissance = naiss;
	}

	public void ecrire() {
		System.out.print(nom + "(");
		naissance.ecrire();
		System.out.print(")");
	}
}
