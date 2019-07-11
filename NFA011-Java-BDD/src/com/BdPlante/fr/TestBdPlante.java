package com.BdPlante.fr;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TestBdPlante {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = MaConnexionBdPlante.getConnection();
//		afficherProduits(conn);
		afficherProduitsPrix(conn);
//		ajouterClient(conn, "dupont", "nicolas", "8 rue de luxembourg", 62000, "Arras", "dupont@gmail.com", "azer",
//				"0321556677");
//		afficherClients(conn);
		ajouterProduitPrix(conn, "Petunia", "Petunia petunia", "C:\\\\MesImages\\petunia.jpg", 10, 5.90);
		ajouterProduitPrix(conn, "Iris", "Iristus", "C:\\\\MesImages\\iris.jpg", 9, 8.90);
		afficherProduitsPrix(conn);
		creerCommande(conn);

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

	public static void afficherProduits(Connection conn) {
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("select * from Produits");
			afficherDonnees(resultSet);
			stmt.close();

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public static void afficherProduitsPrix(Connection conn) {
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("select * from Produits, Prix where(Produits.id_prod=Prix.id_produit_prix)");
			afficherDonnees(resultSet);
			stmt.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public static void afficherClients(Connection conn) {
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("select * from Clients");

			ResultSetMetaData resultMeta = resultSet.getMetaData();
			// On affiche le nom des colonnes
			for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
				System.out.format("%20s", resultMeta.getColumnName(i).toUpperCase());
			}
			System.out.println();
			// on affiches les données
			while (resultSet.next()) {// return false when there is no more row ! first at -1
				if (resultSet.getObject(8).toString().equals("1")) {
					continue;
				}
				for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
					if (resultSet.getObject(i) != null) {
						System.out.format("%20s", resultSet.getObject(i).toString());
					} else {
						System.out.format("%20s", "null");
					}
				}
				System.out.println();
			}
			resultSet.close();
			stmt.close();

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {

		}
	}

	public static void ajouterClient(Connection conn, String unNom, String unPrenom, String uneAdr, int unCp,
			String uneVille, String unMail, String unMdp, String unTel) {
		PreparedStatement prep = null;
		try {
			String sqlAjouterClient = "insert into Clients(nom_cli, prenom_cli, adr_cli, cp_cli, ville_cli, date_crea_cli, email_cli, mpasse_cli, tel_cli) "
					+ "values(?,?,?,?,?,?,?,?,?)";
			prep = conn.prepareStatement(sqlAjouterClient);
			prep.setString(1, unNom);
			prep.setString(2, unPrenom);
			prep.setString(3, uneAdr);
			prep.setInt(4, unCp);
			prep.setString(5, uneVille);
//			prep.setDate(6, Date.valueOf("2019-03-07"));
			prep.setDate(6, Date.valueOf(java.time.LocalDate.now()));
			prep.setString(7, unMail);
			prep.setString(8, unMdp);
			prep.setString(9, unTel);
			prep.executeUpdate();
			prep.close();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

	public static void ajouterProduitPrix(Connection conn, String nomCourt, String nomLong, String cheminPhoto, int qte,
			double prix) {

		PreparedStatement prep = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			String sqlAjouterProduit = "insert into Produits(libelle_court_prod, libelle_long_prod, chemin_photo_prod, date_creat_prod, quantite_prod)"
					+ "values(?,?,?,?,?)";
			prep = conn.prepareStatement(sqlAjouterProduit);
			prep.setString(1, nomCourt);
			prep.setString(2, nomLong);
			prep.setString(3, cheminPhoto);
			prep.setDate(4, Date.valueOf(java.time.LocalDate.now()));
			prep.setInt(5, qte);
			prep.executeUpdate();

			String sqlgetIdProduit = "select id_prod from Produits where libelle_court_prod = '" + nomCourt + "'";
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(sqlgetIdProduit);
			resultSet.next();
			int idProduit = resultSet.getInt(1);
			stmt.close();
			String sqlAjouterPrix = "insert into Prix(date_debutVal_prix, date_finVal_prix, isdeleted, id_produit_prix, prix_prix)"
					+ "values(?,?,?,?,?)";

			prep = conn.prepareStatement(sqlAjouterPrix);
			prep.setDate(1, Date.valueOf(java.time.LocalDate.now()));
			prep.setDate(2, Date.valueOf("2019-12-01"));
			prep.setInt(3, 0);
			prep.setInt(4, idProduit);
			prep.setDouble(5, prix);
			prep.executeUpdate();
			prep.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

	public static void modifierClient(Connection conn, String unNom, String uneVille, String unTel) {

	}

	public static void creerCommande(Connection conn) {
		Statement stmt = null;

		PreparedStatement prep = null;
		try {
			stmt = conn.createStatement();
			String req = "insert into Commande(date_comm) values(?)";
			prep = conn.prepareStatement(req);
			prep.setDate(1, Date.valueOf(java.time.LocalDate.now()));
			prep.executeUpdate();
			prep.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public static void ajouterProduitLastCommande(Connection conn, int idProduit, int QteProduit) {
		Statement stmt = null;
		ResultSet resultSet = null;
		PreparedStatement prep = null;
		try {
			String sqlIdCommande = "select max(id_comm) from Commande";
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(sqlIdCommande);
			resultSet.next();
			int idCommande = resultSet.getInt(1);
			String req = "insert into Detail_commande(id_comm_DC, id_produit_DC, Qte_DC, date_crea_DC, is_deleted_DC) "
					+ "values(?,?,?,?,?)";
			prep = conn.prepareStatement(req);
			prep.setInt(1, idCommande);
			prep.setInt(2, idProduit);
			prep.setInt(3, QteProduit);
			prep.setDate(4, Date.valueOf(java.time.LocalDate.now()));
			prep.setInt(5, 0);
			prep.executeUpdate();				
			prep.close();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	public static void afficherCommande(Connection conn) {
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			String sqlCommande = "select date_comm";
			conn.createStatement();
			
			
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
}
