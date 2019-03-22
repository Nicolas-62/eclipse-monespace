package com.code.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Mime {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ligne = "gggf.ptjbf-aaa.png-f";
		Scanner sc = new Scanner(ligne);
		Pattern pat = Pattern.compile("(.*)\\.(\\w{1,10})$");
		while(sc.hasNextLine()) {
			if(sc.findInLine(pat)==null) {
				System.out.println("unknown");
			}else {
				MatchResult match = sc.match();
				String ext = match.group(2).toLowerCase();
				System.out.println(ext);
			}
			sc.nextLine();
		}
	}
	  public static void maSoluce(String args[]) {
	        Scanner in = new Scanner(System.in);
	        int N = in.nextInt(); // Number of elements which make up the association table.
	        int Q = in.nextInt(); // Number Q of file names to be analyzed.
	        
	        // stockage Map<extention, type MIME>
	        Map<String, String> mime = new HashMap<String, String>();
	        for (int i = 0; i < N; i++) {
	            String EXT = in.next(); // file extension
	            String MT = in.next(); // MIME type.
	            mime.put(EXT.toLowerCase(),MT);
	        }
	        
	        in.nextLine();
	        Scanner lecteur = null;
	        String extention="";
	        // définition de la regex ((groupe 1  : tt type de cacarctères x fois) . (groupe 2: 1 à 10 lettres))
	        Pattern pat = Pattern.compile("(.*)\\.(\\w{1,10})$");
	        for (int i = 0; i < Q; i++) {
	            String FNAME = in.nextLine(); // One file name per line.
	            lecteur = new Scanner(FNAME);
	            if(lecteur.findInLine(pat) != null){
	                MatchResult match = lecteur.match();
	                extention = match.group(2).toLowerCase();
	                if(mime.containsKey(extention)){
	                    System.out.println(mime.get(extention));
	                }else{
	                  System.out.println("UNKNOWN");  
	                }
	            }else{
	                System.out.println("UNKNOWN");
	            }
	        }
	        lecteur.close();
	    }
    public static void Superflight(String args[]) {
        Scanner in = new Scanner(System.in);
        int types_n = in.nextInt();
        int files_n = in.nextInt();
        
        Map<String, String> map = new HashMap<String, String>();
        
        for (int i = 0; i < types_n; i++) { 
        	map.put(in.next().toLowerCase(), in.next()); 
        	in.nextLine(); 
        }
        
        for (int i = 0; i < files_n; i++) 
        {
            String FNAME = in.nextLine().toLowerCase(); // One file name per line.
            int dotI = FNAME.lastIndexOf(".");
            String ext = dotI == -1 ? "" : FNAME.substring(dotI+1);
            System.out.println(map.containsKey(ext) ?  map.get(ext) : "UNKNOWN");
        }
    }
}
