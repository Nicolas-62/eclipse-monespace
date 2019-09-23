package com.code.game;

import java.util.Arrays;
import java.util.Random;

public class EcartType {
	
	private static final int NB_VALUES = 10_000;
	private static final int MAX_VALUE = 1_000_000_000;
	private static final int NB_RUNS = 10;	
	
	public static void main(String[] args) {
		int[] values = initValues();
		for(int run=1; run<=NB_RUNS; run++) {
			long t1 = System.currentTimeMillis();
			soluce1(values);
			long t2 = System.currentTimeMillis();
			
			System.out.printf("Run %2d : %4dms%n", run, t2 - t1);
		}
		System.out.println("**************************************************");
		for(int run=1; run<=NB_RUNS; run++) {
			long t1 = System.currentTimeMillis();
			soluce2(values);
			long t2 = System.currentTimeMillis();
			
			System.out.printf("Run %2d : %4dms%n", run, t2 - t1);
		}		
	}
	private static int[] initValues() {
		System.out.println("Generating values...");
		int[] values = new int[NB_VALUES];
		Random random = new Random();
		for (int i = 0; i < values.length; i++) {
			values[i] = random.nextInt(MAX_VALUE);
		}
		return values;
	}	
	public static void soluce1(int[] values) {
        
        int pi1=values[0];
        int pi2=values[1];
        int ecart = Math.abs(pi2-pi1);
        int[] liste = new int[NB_VALUES];

        liste[0] = pi1;
        liste[1] = pi2;
        
        
        
        for (int i = 2; i < NB_VALUES; i++) {
            liste[i]= values[i];
            
            for(int j = i-1; j>=0; j--){
                ecart = find(liste[i], liste[j], ecart);
            }
        }
        System.out.println("soluce 1 : "+ ecart);
		
	}
    public static int find(int val2, int val1, int ecart){
        if(Math.abs(val2-val1)<ecart){
            ecart = Math.abs(val2-val1);
        }
        return ecart;
    }
    public static void soluce2(int[] values) {

        int[] liste = new int[NB_VALUES];     
        for (int i = 0; i < NB_VALUES; i++) {
            liste[i]= values[i];
        }
        Arrays.sort(liste);  
        int p1 = liste[0];
        int p2 = liste[1];
        int ecart = p2-p1;
        for(int j=2; j<liste.length; j++){
            if(liste[j]-liste[j-1]<ecart){
                ecart = liste[j]-liste[j-1];
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println("soluce 2 : "+ ecart);
    }
}