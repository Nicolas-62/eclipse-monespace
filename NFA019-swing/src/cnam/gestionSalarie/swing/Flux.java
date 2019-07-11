package cnam.gestionSalarie.swing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;

public class Flux {

	public static void enregistrer(JList<Object> list) {
		try {
			File f = new File("salarie.txt");
			FileWriter fw = new FileWriter(f, false);
			BufferedWriter buffer = new BufferedWriter(fw);
			for (int i = 0; i < list.getModel().getSize(); i++) {
				buffer.write(list.getModel().getElementAt(i).toString());
				buffer.newLine();
				buffer.flush();
			}
			buffer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public static void charger(JList<Object> jlist, List<Salarie> listSalarie) {
		try {
            File fichier = new File ("salarie.txt");
            FileReader fr = new FileReader(fichier);
            BufferedReader br = new BufferedReader(fr);

            String line;
            listSalarie.clear();
            while ((line=br.readLine())!=null) {
            	System.out.println(line);
                String [] splitArray = null;
                splitArray = line.split(";");
                Salarie s = new Salarie();
                s.setMatricule(splitArray[0]);
                s.setNom(splitArray[1]);
                s.setPrenom(splitArray[2]);
                s.setFonction(splitArray[3]);
                s.setTel(splitArray[4]);
                s.setDateNais(splitArray[5]);
                s.setDateEmb(splitArray[6]);
                s.setSalaire(splitArray[7]);
                listSalarie.add(s);
            }
            jlist.removeAll();
            jlist.setListData(listSalarie.toArray());
        }catch (Exception excep) {
            excep.printStackTrace();
        }
	}
}
