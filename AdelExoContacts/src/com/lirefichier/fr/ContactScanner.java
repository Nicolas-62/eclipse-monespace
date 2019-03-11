package com.lirefichier.fr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=null;
		ArrayList<Contact> listeContacts = new ArrayList<Contact>();
		try {
			sc = new Scanner(new File("contactsNew.txt"));
			sc.useDelimiter(";|\n");
			while(sc.hasNextLine()) {
				Contact contact = new Contact();
				contact.setNumero(Integer.parseInt(sc.next()));
				contact.setNom(sc.next());
				contact.setAdresse(sc.next());
				contact.setCodePostal(sc.next());
				contact.setVille(sc.next());
				contact.setCodeSecteur(Integer.parseInt(sc.next().trim())); 
				if (sc.hasNextLine()) sc.nextLine();				
				
				listeContacts.add(contact);
			}
			for(Contact c : listeContacts) {
				System.out.println(c.toString());
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (sc!=null) sc.close();
		}
	}

}
