package com.code.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ascii {

	public static void main(String args[]) {
		
	    // essais : 
		String ligne="---debut..fin---##-#---##";
		System.out.println(ligne.substring(3,13));
		System.exit(1);
		
		// code de bob :
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        in.nextLine();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine();
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            for( int j = 0; j < T.length(); j++ ) {
                int c = T.toLowerCase().charAt( j );
                int index = c - 'a';
                System.err.println( index );
                System.err.println( index * L );
                if( index < 0 || index > 25 ) {
                    index = 26; // ?
                }
                System.out.print( ROW.substring( index * L, index * L + L ) );
            }
            System.out.println("");
        }
    }


    public static void soluce1(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String message = in.nextLine();
        // ligne de l'alphabet en asciiArt
        String ROW="";
        // lettre recupérée en asciiARt
        String lettre="";
        /* liste des lettres en hashtag
         * clé : int : code décimal de la lettre en majuscule
         * valeur : string : lettre en asciiArt
         */
        Map<Integer, String> map = new HashMap<Integer, String>();
        // indice de chaque hastag dans chaque ligne représentant l'alphabet en asciiArt
        int indice=0;
        // message à afficher
        String[] affichage = new String[H];
        for(int u=0; u<H; u++){
            affichage[u]="";
        }
        
        boolean premierPassage=false;
        // récupération de l'alphabet en asciiArt
        for (int i = 0; i < H; i++) {
            ROW = in.nextLine();
            indice=0;
            for(int j = 65; j<92; j++){
                lettre="";
                if(premierPassage){
                    lettre=map.get(j);
                }
                for(int n =0; n<L; n++){
                    lettre+=ROW.charAt(indice);
                    indice++;
                }
                lettre+="\n";
                //System.out.println(j+" "+lettre);
                map.put(j, lettre);
            }
            premierPassage=true;
        }
        
        Scanner sc = null;
        // recuperation des lettres du message
        for(int k=0; k< message.length(); k++){
            //recup de la lettre, si c'est un caractère spécial on met un ? :
            if(((int)message.toUpperCase().charAt(k))<65 || ((int)message.toUpperCase().charAt(k))>90 ){
                lettre=map.get(91);
            }else{
                lettre = map.get((int) message.toUpperCase().charAt(k));
            }
            // correspondance de chaque ligne de la lettre avec chaque ligne du tableau d'affichage
            sc = new Scanner(lettre);
            sc.useDelimiter("\n");
            indice=0;
            while(sc.hasNext()){
                affichage[indice]+=sc.next();
                indice++;
            }
        }
        // affichage du message
        for(int h=0; h<affichage.length; h++){
            System.out.println(affichage[h]);
        }
        //System.out.println((int)'@');
        
    }
    
    public static void soluce2(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String T = in.nextLine();
        T = T.toUpperCase();
        String[] result = new String[H];
        // pour chaque ligne de caractère acsii
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            // pour une ligne donnée :
            // pour chaque caractère du message on récupère sa suite de # correspondant
            for(int j =0; j < T.length(); j++){
                // on crée la String
                if(j==0){
                    result[i] = new String();
                }
                // indice de la lettre dans la chaine de caractère ascii
                // ex : A est la première lettre indice = 0;
                int indice = T.codePointAt(j) - 65;
                // si c'est un caractère spécial on prend le point d'interrogation en bout de chaine ascii
                if(indice < 0 || indice > 25){
                    indice=26;
                }
                result[i] += ROW.substring(indice*L, indice*L+L);
            }
            
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        // affichage du message
        for(int h=0; h<result.length; h++){
            System.out.println(result[h]);
        }
    }    

}
