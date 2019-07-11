package com.evaljava.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class TestTransfer {

	public static void main(String[] args) {
        try (Reader lecture = new FileReader("Entree.txt")){
            
            try(Writer ecriture = new FileWriter("nouveau.txt")){
                lecture.transferTo(ecriture);
            }catch(Exception e) {
                
            }
    
        }catch(Exception e ) {
            
        }

	}

}
