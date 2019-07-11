package com.evaljava.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LectureMembresScanner {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("membres.txt"));
			sc.useDelimiter(";");	
//			System.out.println("lecteur : "+sc.nextLine());
//			System.exit(1);	
			do{
				System.out.println("nom : " + sc.next() + " prenom : " + sc.next() + " age : " + sc.next()
						+ " adresse : " + sc.next());
			}while (sc.hasNextLine());
		} catch (FileNotFoundException e) {
			System.out.println("fichier introuvble");
		} finally {
			sc.close();
		}
	}
}