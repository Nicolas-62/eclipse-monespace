import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		String url = "jdbc:mysql://localhost/BdMicro";
		String user = "lourdel";
		String password = "Alligator487";
		try {
			conn = DriverManager.getConnection(url, user, password);
			// System.out.println("connexion reussie !");
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("select * from Produit");

			ResultSetMetaData resultMeta = resultSet.getMetaData();

			// On affiche le nom des colonnes
			for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
				System.out.format("%20s",resultMeta.getColumnName(i).toUpperCase());
			}
			System.out.println();
			while (resultSet.next()) {// return false when there is no more row
				for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
					System.out.format("%20s", resultSet.getObject(i).toString());
				}
				System.out.println();

			}

			resultSet.close();
			stmt.close();
			// System.out.println("selection reussie !");

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

}
