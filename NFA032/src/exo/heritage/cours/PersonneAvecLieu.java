package exo.heritage.cours;

public class PersonneAvecLieu extends LaPersonne{
	String LieuDeNaissance;
	
	public PersonneAvecLieu(String name, LaDate naiss, String lieu){
		super(name, naiss);	
		this.LieuDeNaissance = lieu;
	}
	public void ecrire() {
		super.ecrire();
		System.out.println(" Lieu de naissance : "+LieuDeNaissance);
	}
}
