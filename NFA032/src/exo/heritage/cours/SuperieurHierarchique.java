package exo.heritage.cours;

public class SuperieurHierarchique extends Employe{
	
	
	private Employe[] employes;
	SuperieurHierarchique(){};
	public void setEmployes(Employe[] tabEmployes) {
		this.employes = tabEmployes;
	}
	public void getEmployes() {
			System.out.println("Inferieurs directs : ");
		for(int i=0; i<this.employes.length; i++) {
			System.out.println("inférieur n°"+i+" : "+this.employes[i].getNom());
		}
	}
	
}
