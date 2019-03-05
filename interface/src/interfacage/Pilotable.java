package interfacage;

public interface Pilotable extends IGestionnaireMoteur,
IGestionnaireTrainAtterrissage {
    static final int ALTITUDE_SECURITE = 100; 
   
    
    public default void alert() {
    	System.out.println("alert");	
	}
    

    long getPuissance(); 
    void setPuissance(long puissanceCible);
    long getAltitude();
    void rentrerTrainAtterrissage();
    void sortirTrainAtterrissage();
    public default void inclinerVolets(long angle) {
    	System.out.println("inclinerVolets class Pilotable");	
    };
    void setPositionManche(long position);
    void virer(long angle);
}

