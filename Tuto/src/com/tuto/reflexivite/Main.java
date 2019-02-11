package com.tuto.reflexivite;


import java.lang.reflect.Method;

import fr.perso.mesclasses.Out;

public class Main {

	public static void main(String[] args) {
		Class str = new String().getClass();
//		Out.p(str.class.getClass());
		Out.p(str.getName());
		System.out.println("La superclasse de la classe " + 
		str.getName() + " est : " + 
		str.getSuperclass());
		
		Class[] c = str.getInterfaces();
		Out.p(c.length+" interfaces implémentées :");
		for(int i=0; i<c.length; i++) {
			Out.p(c[i]);
		}
		
		Method[] m = str.getMethods();
		Out.p(m.length+" methodes :");
		for(int i=0; i<m.length; i++) {
			Out.p(m[i]);
		}		
		
	}

}
