/**
 * 
 */
package interfacage;

/**
 * @author dell
 * description d'un avion
 */
public class Avion implements Pilotable , IGestionnaireRadio{

	private long matricule;
	
	

	private Moteur moteur;


	public long getMatricule() {
		return matricule;
	}

	public void setMatricule(long paramMatricule) {
		matricule = paramMatricule;
	}
	
	public Moteur getMoteur() {
		return moteur;
	}

	public void setMoteur(Moteur unMoteur) {
		this.moteur = unMoteur;
	}

	@Override
	public long getPuissance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPuissance(long puissanceCible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long getAltitude() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void rentrerTrainAtterrissage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortirTrainAtterrissage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPositionManche(long position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void virer(long angle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void emettreSignalRadio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rentrerTrainAtterissage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortirTrainAtterissage() {
		// TODO Auto-generated method stub
		
	}
	
//	public void inclinerVolets(long angle) {
//    	Pilotable.super.inclinerVolets(angle);	
//	}

	@Override
	public void alert() {
		// TODO Auto-generated method stub
		//System.out.println("inclinerVolets class avion");	
		//IGestionnaireRadio.super.alert();
		Pilotable.super.alert();
	}

	

}
