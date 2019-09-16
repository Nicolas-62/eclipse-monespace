package com.testsEntretien.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class testsCopyLists {
	public static class Flower {
		Integer petals;
		Flower(int petals){
			this.petals=petals;
		}
		Integer getPetals(){
			return this.petals;
			
		}
		public String toString(){
			return "je suis une fleur et j'ai "+this.petals+" pétales";
		}
		
	}

	public static void main(String[] args) {
		// Differentes façons de copier une liste
		List<String> list = new ArrayList<String>();
		list.add("Nicolas");
		list.add("Lourdel");
		
		List<Integer> source = Arrays.asList(1,2,3);
		List<Integer> dest = Arrays.asList(4,5,6);
		Collections.copy(dest, source);
		System.out.println("copy 1 : "+dest);
		// copy 1 : [1, 2, 3]
		
		List<Integer> source2 = Arrays.asList(1, 2, 3);
		List<Integer> dest2 = Arrays.asList(5, 6, 7, 8, 9, 10);
		Collections.copy(dest2, source2);
		System.out.println("copy 2 : "+dest2);
		// copy 2 : [1, 2, 3, 8, 9, 10]
		
		List<String> copy = list.stream()
				  .skip(1)
				  .collect(Collectors.toList());
		System.out.println("copy stream, skip"+copy);
		// copy stream, skip[Lourdel]
		
		List<String> copy2 = list.stream()
				  .filter(s -> s.length() > 10)
				  .collect(Collectors.toList());
		System.out.println("copy2 stream, skip"+copy2);
		// copy2 stream, skip[]
		
		Flower flo = new Flower(10);
		List<Flower> listFlowers = new ArrayList<Flower>();
		listFlowers.add(new Flower(4));
		listFlowers.add(flo);
		
		List<Flower> flowers = listFlowers.stream()
				  .filter(f -> f.getPetals() > 3)
				  .collect(Collectors.toList());
		System.out.println("flowers : "+flowers);
		// flowers : [je suis une fleur et j'ai 4 pétales, je suis une fleur et j'ai 10 pétales]
	}

}
