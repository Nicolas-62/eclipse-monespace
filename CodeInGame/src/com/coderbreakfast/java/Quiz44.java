package com.coderbreakfast.java;

import java.util.Random;

public class Quiz44 {

	private static final int NB_VALUES = 10_000_000;
	private static final int MAX_VALUE = 1000;
	private static final int NB_RUNS = 10;

	public static void main(String[] args) {

		// tableau d'Integer
		Integer[] boxedValues = new Integer[NB_VALUES];
		// tableau d'int
		int[] values = initValues();

		System.out.println("Benchmarking...");
		for (int run = 1; run <= NB_RUNS; run++) {
			long t1 = System.currentTimeMillis();
			for (int i = 0; i < NB_VALUES; i++) {

				/*
				 * Transfert de tableau d'int vers tableau d'Integer Depuis Java 5, il n'est
				 * plus nécessaire d'effectuer la transformation de type manuellement, grâce à
				 * une fonctionnalité appelée "autoboxing" : en coulisse, le compilateur insère
				 * à notre place les instructions nécessaires (ici, un Integer.valueOf())
				 */
				boxedValues[i] = Integer.valueOf(values[i]);
				/*Comme ces opérations de boxing / unboxing sont fréquentes et qu'il serait coûteux de 
				 * construire un nouveau wrapper Integer à chaque fois, la classe Integer gère un cache 
				 * qui couvre la plage de valeurs la plus utilisée (par défaut, -128 à +127). 
				 * Ce cache est utilisé par la méthode Integer.valueOf() insérée par le compilateur :*/
				/*Comme le quiz utilise des entiers de 0 à 1000, le cache n'est que peu efficace.
				 *  Selon une mesure, plus de 16 millions de wrappers sont créés et occupent 
				 *  plus de 260Mo sur les 330Mo alloués !
				 */
				/*Pour réduire la consommation mémoire et la charge du Garbage Collector, il serait intéressant d'augmenter la plage d'action du cache, en fixant sa borne supérieure à 1000. 
				 * L'examen du code de la classe Integer fournit la solution (classe Integer, lignes 557+ sur le JDK 6.0.24) :
				 */
				/*Lançons donc le Quiz 44 avec cette option :
					java -XX:AutoBoxCacheMax=1000 Quiz44
					*/
				/*Les performances sont améliorées d'un ordre de grandeur (plus de 30X sur ma machine),
				 *  et la consommation mémoire en chute libre : 
				 *  plus que 1200 Integers présents en mémoire, pour à peine 20Mo.
				 */
			}
			long t2 = System.currentTimeMillis();
			System.out.printf("Run %2d : %4dms%n", run, t2 - t1);
		}
	}

	/** Nothing important here, just values init. */
	private static int[] initValues() {
		System.out.println("Generating values...");
		int[] values = new int[NB_VALUES];
		Random random = new Random();
		for (int i = 0; i < values.length; i++) {
			values[i] = random.nextInt(MAX_VALUE);
		}

		return values;
	}
/*
 * Comme ces opérations de boxing / unboxing sont fréquentes et qu'il serait coûteux de construire un nouveau 
 * wrapper Integer à chaque fois, la classe Integer gère un cache qui couvre la plage de 
 * valeurs la plus utilisée (par défaut, -128 à +127). 
 * Ce cache est utilisé par la méthode Integer.valueOf() insérée par le compilateur :
	
	public static Integer valueOf(int i) {
        if(i >= -128 && i <= IntegerCache.high)
            return IntegerCache.cache[i + 128];
        else
            return new Integer(i);
    }
 * 
 */
}