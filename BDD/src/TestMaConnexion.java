import java.sql.*;

public class TestMaConnexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = MaConnexion.getConnection();
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
			while (resultSet.next()) {// return false when there is no more row
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

}
