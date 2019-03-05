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
	    // ArrayList : tout type d'objet, doublons possibles
	    List<String> listNoms = new ArrayList<String>();
	    listNoms.add("nico");
	    listNoms.add("roger");
	    listNoms.add("jeff");
	    listNoms.add("massi");
	    listNoms.add("elvis");
	    listNoms.add("adel");
	    
	    System.out.println(listNoms.get(0));
	    System.out.println(listNoms.get(1));
	    System.out.println();
	    List<Pilote> listPilote = new ArrayList<Pilote>();
	    List<Object> listPilote2 = new ArrayList<Object>();

	    listPilote.add(new Pilote("seb", "lourdel"));
	    listPilote.add(unPilote);
	    
	    listPilote.remove(0);
	    System.out.println(listPilote.get(0).nom);
	    System.out.println();
	    listPilote2.add(unPilote);
	    listPilote2.add("dédé");
	    
	    for(Iterator<String> it = listNoms.iterator(); it.hasNext();) {
	    	String nomAfficher = it.next();
	    	System.out.println(nomAfficher);
	    }
	    System.out.println();
	    for(String nom : listNoms) {
	    	System.out.println(nom);
	    }
	    System.out.println();
	    
	  // set : pas de doublons (objet)
	   Set<String> set = new HashSet<String>();
	   set.add("le");
	   set.add("petit");
	   set.add("chat");
	   set.add("chat");
	   
	   for(String chaine : set) {
		   System.out.println(chaine);
	   }
	   // Map : pas de doublons (clé, valeur)
	   Map<String,String> map = new HashMap<String,String>();
	   map.put("dupont","nico");
	   map.put("dupont", "roger");
	   
	   System.out.println(map.get("dupont"));
	   
	   
	}


}
