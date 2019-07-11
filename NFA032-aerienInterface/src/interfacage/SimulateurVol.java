package interfacage;

public class SimulateurVol implements Pilotable {
	
	private boolean trainAtterissageSorti;
	private long angleVolet;
	private long puissance;
	private long altitude;
	

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
	public void virer(long angle) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the trainAtterissageSorti
	 */
	public boolean isTrainAtterissageSorti() {
		return trainAtterissageSorti;
	}

	/**
	 * @param trainAtterissageSorti the trainAtterissageSorti to set
	 */
	public void setTrainAtterissageSorti(boolean trainAtterissageSorti) {
		this.trainAtterissageSorti = trainAtterissageSorti;
	}

	/**
	 * @return the angleVolet
	 */
	public long getAngleVolet() {
		return angleVolet;
	}

	/**
	 * @param angleVolet the angleVolet to set
	 */
	public void setAngleVolet(long angleVolet) {
		this.angleVolet = angleVolet;
	}

	/**
	 * @param altitude the altitude to set
	 */
	public void setAltitude(long altitude) {
		this.altitude = altitude;
	}

	@Override
	public void rentrerTrainAtterissage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortirTrainAtterissage() {
		// TODO Auto-generated method stub
		
	}
	
	public void inclinerVolets(long angle) {
    	Pilotable.super.inclinerVolets(angle);	
    }

	@Override
	public void setPositionManche(long position) {
		// TODO Auto-generated method stub
		
	};

}
