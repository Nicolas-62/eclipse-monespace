package exoContacts;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class TestContact {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Contact> listeContacts = new ArrayList<Contact>();
		String ligne;
		try {
			BufferedReader fichierContacts = new BufferedReader (new InputStreamReader( new FileInputStream("C:\\Users\\adelk\\eclipse-workspace\\DevInfo\\src\\exoContacts\\contacts.txt")));
			
			ligne = fichierContacts.readLine();
			
			PrintWriter contactsTriees = new PrintWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\adelk\\eclipse-workspace\\DevInfo\\src\\exoContacts\\contactsTries.txt")));
			
			while(ligne != null) {
				StringTokenizer st = new StringTokenizer(ligne,";");
				
				Contact contact = new Contact();
				contact.setNumero(Integer.parseInt(st.nextToken()));
				contact.setNom(st.nextToken());
				contact.setAdresse(st.nextToken());
				contact.setCodePostal(st.nextToken());
				contact.setVille(st.nextToken());
				contact.setCodeSecteur(Integer.parseInt(st.nextToken())); 
				
				listeContacts.add(contact);
				ligne = fichierContacts.readLine();
				
			}
			
			Collections.sort(listeContacts);
			
			
			for(Contact c : listeContacts) {
				System.out.println(c);
				contactsTriees.println(c.toString());
			}
			
			fichierContacts.close();
			contactsTriees.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
