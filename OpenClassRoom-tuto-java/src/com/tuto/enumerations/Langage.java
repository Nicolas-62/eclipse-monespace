package com.tuto.enumerations;

import fr.perso.mesclasses.Out;

public enum Langage {
	JAVA("Langage JAVA", "Eclispe"),
	PHP("Langage PHP", "PHPStorm"),
	C("Langage C", "CodeBlocks");
	
	private String name = "";
	private String editor = "";
	
	//Construteur
	Langage(String name, String editor){
		this.name = name;
		this.editor = editor;
	}
	public void getEditor() {
		Out.p("Editeur : " + editor);
	}
	public String toString() {
		return name;
	}
	
	public static void main(String[] args) {
		
		Langage L1 = Langage.JAVA;
		Langage L2 = Langage.PHP;
		L1.getEditor();
		Out.p(L2.toString());
		
	    for(Langage lang : Langage.values()){
	        if(Langage.JAVA.equals(lang))
	          System.out.println("J'aime le : " + lang.editor);
	        else
	          System.out.println(lang);
	    }
	}
	
}
