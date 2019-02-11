
public class PiloteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
		PiloteInstructeur nico = new PiloteInstructeur();
		/* PiloteInstructeur est une classe fille de Pilote
		 * elle hérite de tous les attributs et methodes de sa classe mère : Pilote
		 * L'attribut Nom et ses get/setters associés se trouvent dans la classe mère,
		 * comme PiloteInstructeur hérite de Pilote il possède cet attribut également.
		 */
		nico.setNom("nico");
		System.out.println(nico.getNom());
		nico.enseignerDecollage();
		/* faireDecoller() appartient à Pilote, PiloteInstructeur hérite également de cette méthode. 
		 */
		nico.faireDecoller();
		
		Pilote sona = new Pilote();
		sona.setNom("sona");
		System.out.println(sona.getNom());
		// on ne peut pas appeler une methode de la classe fille : 
//		sona.enseignerDecollage();	-> erreur
		
		PiloteInstructeur seb = new PiloteInstructeur("Sebastien", "lourdel");
		System.out.println(seb.getNom());
		System.out.println(seb.getPrenom());
		Pilote unPilote = seb;
		int i = 1;
		String k = String.valueOf(i);
		System.out.println(k+"fin");
		
	}

}
