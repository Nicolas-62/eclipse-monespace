package com.code.game;

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

}
