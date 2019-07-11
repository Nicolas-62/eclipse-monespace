import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TestBdMicro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = MaConnexion.getConnection();
		afficherProduits(conn);
//		ajouterClient(conn, "lourdel", "arras","0321446677");
//		ajouterClient(conn, "jounwaz", "lille", "0988776677");
		afficherClients(conn);
		ajouterClientBis(conn,"dujardin","celine","067879998");
		afficherClients(conn);
		

	}
	public static void afficherProduits(Connection conn) {
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("select * from Produit");

			ResultSetMetaData resultMeta = resultSet.getMetaData();
			// On affiche le nom des colonnes
			for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
				System.out.format("%20s", resultMeta.getColumnName(i).toUpperCase());

			}
			System.out.println();
			// on affiches les données
			while (resultSet.next()) {// return false when there is no more row ! first at -1
				for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
					System.out.format("%20s", resultSet.getObject(i).toString());
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
		}		
	}
	public static void afficherClients(Connection conn) {
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("select * from Client");

			ResultSetMetaData resultMeta = resultSet.getMetaData();
			// On affiche le nom des colonnes
			for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
				System.out.format("%20s", resultMeta.getColumnName(i).toUpperCase());
			}
			System.out.println();
			// on affiches les données
			while (resultSet.next()) {// return false when there is no more row ! first at -1
				for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
					if(resultSet.getObject(i)!=null) {
						System.out.format("%20s", resultSet.getObject(i).toString());
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
		}	finally {
			
		}
	}	
	public static void ajouterClient(Connection conn, String unNom, String uneVille, String unTel) {
		Statement stmt = null;
		String nom = unNom;
		String ville = uneVille;
		String tel =  unTel;
		try {
			String sqlAjouter = "insert into Client(Nom,Ville,Telephone) values('"+nom+"','"+ville+"','"+tel+"');";
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlAjouter);
			stmt.close();
			
		}catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
	}
	public static void ajouterClientBis(Connection conn, String unNom, String uneVille, String unTel) {
		PreparedStatement prep = null;
		String nom = unNom;
		String ville = uneVille;
		String tel =  unTel;
		try {
			String sqlAjouter = "insert into Client(Nom,Ville,Telephone) values(?,?,?)";
			prep = conn.prepareStatement(sqlAjouter);
			prep.setString(1, nom);
			prep.setString(2, ville);
			prep.setString(3, tel);
			prep.executeUpdate();
			prep.close();
		}catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
	}	
	public static void modifierClient(Connection conn, String unNom, String uneVille, String unTel) {
		
	}
}
