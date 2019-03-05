package interfacage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MainInterface {
	public static void main(String[] args) {
		
	    //Interface Pilotable
	    Pilotable engin = new SimulateurVol();
	    engin.inclinerVolets(15);
	    
	    Pilotable enginV2 = new Avion();
	    enginV2.inclinerVolets(15);
	    Pilote unPilote = new Pilote("max", "odin");
	    unPilote.faireDecoller(engin);

	    List<Pilote> listPilote = new ArrayList<Pilote>();
	    List<Object> listPilote2 = new ArrayList<Object>();

	    listPilote.add(new Pilote("seb", "lourdel"));
	    listPilote.add(unPilote);
	    
	    listPilote.remove(0);
	    System.out.println(listPilote.get(0).nom);
	    System.out.println();
	    listPilote2.add(unPilote);
	    listPilote2.add("dédé");
	   
	}


}
