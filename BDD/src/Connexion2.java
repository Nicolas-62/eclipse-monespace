import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion2 {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		String url = "jdbc:mysql://localhost/BdMicro" +
		"?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
//		"?useUnicode=true"+
//		"&useJDBCCompliantTimezoneShift=true"+
//		"&useLegacyDatetimeCode=false"+
//		"&serverTimezone=UTC";
		String user = "root";
		String password = "Alligator487";
		try {
			conn = DriverManager.getConnection(url, user, password);
			// System.out.println("connexion reussie !");
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("select * from Produit");
			while (resultSet.next()) {// return false when there is no more row

				String designation = resultSet.getString("Designation");
				String marque = resultSet.getString("Marque");
				float prixUnit = resultSet.getFloat("PrixUnit");
				int qtStock = resultSet.getInt("QtStock");
				System.out.println("designation : " + designation + " marque : " + marque + " prix unitaire : "
						+ prixUnit + " quntite stock : " + qtStock);
				System.out.println();
			}

			resultSet.close();
			stmt.close();
			ajouterClient(conn);
			
			// System.out.println("selection reussie !");

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
	}
	public static void afficherTable(Connection conn) {
		
	}
	public static void ajouterClient(Connection conn) {
		Statement stmt = null;
		String nom = "jounwaz";
		String ville = "lille";
		String tel =  "0320334455";
		try {
			String sqlAjouter = "insert into Client(NumCli,Nom,Ville,Telephone) values('"+88+"','"+nom+"','"+ville+"','"+tel+"');";
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlAjouter);
			stmt.close();
			
		}catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
	}

}
