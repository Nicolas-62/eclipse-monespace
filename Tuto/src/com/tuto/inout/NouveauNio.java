package com.tuto.inout;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NouveauNio {

	public static void Main(String[] args) throws IOException {
		Path source = Paths.get("test.txt");
		Path cible = Paths.get("test2.txt");
		try {
		  Files.copy(source, cible, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) { e.printStackTrace();	}
		
		
		
		Path source1 = Paths.get("test3.txt");
		//Ouverture en lecture :
		try ( InputStream input = Files.newInputStream(source1) ) {}
		//Ouverture en écriture :
		try ( OutputStream output = Files.newOutputStream(source1) )  {}

		//Ouverture d'un Reader en lecture :
		try ( BufferedReader reader = Files.newBufferedReader(source1, StandardCharsets.UTF_8) )  {}

		//Ouverture d'un Writer en écriture :
		try ( BufferedWriter writer = Files.newBufferedWriter(source1, StandardCharsets.UTF_8) )  {}
	}
}
