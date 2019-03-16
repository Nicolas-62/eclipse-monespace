package com.bdd.cnam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BdJava {
	public static void recupererMembres(Connection conn) {
		Statement stmt = null;
		ResultSet resultSet = null;
		List<String> list = new ArrayList<String>();
		String header="";
		try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("select nom, prenom, sexe, mail from Membres");
			ResultSetMetaData resultMeta = resultSet.getMetaData();

			// On affiche le nom des colonnes
			for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
				header+=resultMeta.getColumnName(i).toUpperCase();
				if(i<resultMeta.getColumnCount()-1) {
					header+=';';
				}
			}			
			while(resultSet.next()) {
				for(int i=0; i<resultMeta.getColumnCount(); i++) {
				list.add(resultSet.getObject(i).toString());
				
				}
			}			
			
		}catch(SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
	}
}
