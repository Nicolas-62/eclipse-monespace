package com.bdd.cnam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.entite.cnam.Utilisateur;

public class CnamDb {
	public static void insererUtilisateur(Connection conn, Utilisateur unUtilisateur) {
		PreparedStatement prep = null;
		String requete = "insert into Utilisateur(nom, prenom, email, sexe) values(?,?,?,?)";
		try {
			prep = conn.prepareStatement(requete);
			prep.setString(1, unUtilisateur.getNom());
			prep.setString(2, unUtilisateur.getPrenom());
			prep.setString(3, unUtilisateur.getEmail());
			prep.setString(4, unUtilisateur.getSexe());
			prep.executeUpdate();
			prep.close();

		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
	}

	public static void afficherUtilisateurs(Connection conn) {
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("select id, email, nom, prenom, sexe from Utilisateur");
			afficherDonnees(resultSet);
			stmt.close();


		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
	}
	public static Set<String> recupererMailUtilisateurs(Connection conn){
		Statement stmt = null;
		ResultSet resultSet = null;
		Set<String> setMail = new HashSet<String>();
		try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("select Email from Utilisateur");
			while (resultSet.next()) {
				setMail.add(resultSet.getString(1));
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		return setMail;		
	}
	public static void afficherDonnees(ResultSet resultSet) {
		try {
			ResultSetMetaData resultMeta = resultSet.getMetaData();
			// On affiche le nom des colonnes
			for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
				System.out.format("%30s", resultMeta.getColumnName(i).toUpperCase());

			}
			System.out.println();
			// on affiches les données
			while (resultSet.next()) {// return false when there is no more row ! first at -1
				for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
					if (resultSet.getObject(i) != null) {
						System.out.format("%30s", resultSet.getObject(i).toString());
					} else {
						System.out.format("%30s", "NULL");
					}
				}
				System.out.println();
			}
			resultSet.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}	
}
