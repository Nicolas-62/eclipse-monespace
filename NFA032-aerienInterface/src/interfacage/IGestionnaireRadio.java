package interfacage;

public interface IGestionnaireRadio {
	
	public void emettreSignalRadio();
	public default void alert() {
    	System.out.println("alert");	
	}

}
